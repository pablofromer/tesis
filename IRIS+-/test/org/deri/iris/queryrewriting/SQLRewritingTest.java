/*
 * Integrated Rule Inference System (IRIS):
 * An extensible rule inference system for datalog with extensions.
 * 
 * Copyright (C) 2009 ICT Institute - Dipartimento di Elettronica e Informazione (DEI), 
 * Politecnico di Milano, Via Ponzio 34/5, 20133 Milan, Italy.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.deri.iris.queryrewriting;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.deri.iris.ConfigurationException;
import org.deri.iris.EvaluationException;
import org.deri.iris.Expressivity;
import org.deri.iris.ReportingUtils;
import org.deri.iris.api.basics.ILiteral;
import org.deri.iris.api.basics.IPosition;
import org.deri.iris.api.basics.IPredicate;
import org.deri.iris.api.basics.IQuery;
import org.deri.iris.api.basics.IRule;
import org.deri.iris.api.queryrewriting.IQueryRewriter;
import org.deri.iris.basics.BasicFactory;
import org.deri.iris.compiler.Parser;
import org.deri.iris.queryrewriting.caching.CacheManager;
import org.deri.iris.queryrewriting.configuration.DecompositionStrategy;
import org.deri.iris.queryrewriting.configuration.NCCheck;
import org.deri.iris.queryrewriting.configuration.RewritingLanguage;
import org.deri.iris.queryrewriting.configuration.SubCheckStrategy;
import org.deri.iris.storage.IRelation;
import org.deri.iris.storage.StorageManager;

import au.com.bytecode.opencsv.CSVWriter;

import com.google.common.collect.Sets;

/**
 * @author Giorgio Orsi <orsi@elet.polimi.it> - Politecnico di Milano
 */
public class SQLRewritingTest extends TestCase {

  private final Logger LOGGER = Logger.getLogger(SQLRewritingTest.class);

  private final String _DEFAULT_OUTPUT_PATH = "/examples/rewriting_test/output/";
  private final String _DEFAULT_SUMMARY_DIR = "summary";
  private final String _DEFAULT_INPUT_PATH = "/examples/rewriting_test/input/";
  private final File _WORKING_DIR = FileUtils.getFile(System.getProperty("user.dir"));
  private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'-'HH:mm:ss");

  static {
    // Load the logging configuration
    PropertyConfigurator.configure("config/logging.properties");
  }

  public static Test suite() {
    return new TestSuite(SQLRewritingTest.class, SQLRewritingTest.class.getSimpleName());
  }

  public void testSQLRewriting() throws Exception {

    // Configuration.
    final DecompositionStrategy decomposition = DecompositionStrategy.DECOMPOSE;
    final RewritingLanguage rewLang = RewritingLanguage.UCQ;
    final SubCheckStrategy subchkStrategy = SubCheckStrategy.INTRADEC;
    final NCCheck ncCheckStrategy = NCCheck.NONE;

    LOGGER.info("Decomposition: " + decomposition.name());
    LOGGER.info("Rewriting Language: " + rewLang.name());
    LOGGER.info("Subsumption Check Strategy: " + subchkStrategy.name());
    LOGGER.info("Negative Constraints Check Strategy " + ncCheckStrategy.name());

    // Read the test-cases file

    final File testSuiteFile = FileUtils.getFile(_WORKING_DIR, FilenameUtils.separatorsToSystem(_DEFAULT_INPUT_PATH),
        "test-cases.txt");

    final List<String> tests = IOUtils.readLines(new FileReader(testSuiteFile));

    final String creationDate = dateFormat.format(new Date());

    // Summary reporting
    final String summaryPrefix = StringUtils.join(creationDate, "-", decomposition.name(), "-", rewLang.name(), "-",
        subchkStrategy.name(), "-", ncCheckStrategy.name());

    final File sizeSummaryFile = FileUtils.getFile(_WORKING_DIR,
        FilenameUtils.separatorsToSystem(_DEFAULT_OUTPUT_PATH), FilenameUtils.separatorsToSystem(_DEFAULT_SUMMARY_DIR),
        StringUtils.join(summaryPrefix, "-", "size-summary.csv"));
    final CSVWriter sizeSummaryWriter = new CSVWriter(new FileWriter(sizeSummaryFile), ',');

    final File timeSummaryFile = FileUtils.getFile(_WORKING_DIR,
        FilenameUtils.separatorsToSystem(_DEFAULT_OUTPUT_PATH), FilenameUtils.separatorsToSystem(_DEFAULT_SUMMARY_DIR),
        StringUtils.join(summaryPrefix, "-", "time-summary.csv"));
    final CSVWriter timeSummaryWriter = new CSVWriter(new FileWriter(timeSummaryFile), ',');

    final File cacheSummaryFile = FileUtils.getFile(_WORKING_DIR,
        FilenameUtils.separatorsToSystem(_DEFAULT_OUTPUT_PATH), FilenameUtils.separatorsToSystem(_DEFAULT_SUMMARY_DIR),
        StringUtils.join(summaryPrefix, "-", "cache-summary.csv"));
    final CSVWriter cacheSummaryWriter = new CSVWriter(new FileWriter(cacheSummaryFile), ',');

    final File memorySummaryFile = FileUtils.getFile(_WORKING_DIR,
        FilenameUtils.separatorsToSystem(_DEFAULT_OUTPUT_PATH), FilenameUtils.separatorsToSystem(_DEFAULT_SUMMARY_DIR),
        StringUtils.join(summaryPrefix, "-", "memory-summary.csv"));
    final CSVWriter memorySummaryWriter = new CSVWriter(new FileWriter(memorySummaryFile), ',');

    sizeSummaryWriter.writeNext(ReportingUtils.getSummaryRewritingSizeReportHeader());
    timeSummaryWriter.writeNext(ReportingUtils.getSummaryRewritingTimeReportHeader());
    cacheSummaryWriter.writeNext(ReportingUtils.getSummaryCachingReportHeader());
    memorySummaryWriter.writeNext(ReportingUtils.getSummaryMemoryReportHeader());

    // Compute the rewriting for each test ontology.
    for (final String testName : tests) {

      // Read the next test case on the list
      final File testFile = FileUtils.getFile(_WORKING_DIR, FilenameUtils.separatorsToSystem(_DEFAULT_INPUT_PATH),
          testName + ".dtg");

      // Create the Directory where to store the test results
      final File outTestDir = FileUtils.getFile(_WORKING_DIR, FilenameUtils.separatorsToSystem(_DEFAULT_OUTPUT_PATH),
          testName);
      if (!outTestDir.exists()) {
        if (outTestDir.mkdir()) {
          LOGGER.info("Created output directory: " + testName);
        } else {
          LOGGER.fatal("Error creating output directory");
        }
      }

      LOGGER.info("Processing file: " + testName);

      // Read the content of the current program
      final FileReader fr = new FileReader(testFile);
      final StringBuilder sb = new StringBuilder();
      int ch = -1;
      while ((ch = fr.read()) >= 0) {
        sb.append((char) ch);
      }
      final String program = sb.toString();
      fr.close();

      // Parse the program
      final Parser parser = new Parser();
      parser.parse(program);

      // Get the rules
      final List<IRule> rules = parser.getRules();

      // Get the queries
      final List<IQuery> queryHeads = parser.getQueries();

      // Get the TGDs from the set of rules
      final List<IRule> tgds = RewritingUtils.getTGDs(rules, queryHeads);

      // Convert the query bodies in rules
      final List<IRule> bodies = new LinkedList<IRule>(rules);
      bodies.removeAll(tgds);

      final List<IRule> queries = RewritingUtils.getQueries(bodies, queryHeads);

      // Get the configuration
      final Map<IPredicate, IRelation> conf = parser.getDirectives();
      if (conf.containsKey(BasicFactory.getInstance().createPredicate("DBConnection", 8))) {
        StorageManager.getInstance();
        StorageManager.configure(conf);
      } else {
        LOGGER.error("Missing DB connection parameters.");
        throw new ConfigurationException("Missing DB connection parameters.");

      }

      // Get the SBox rules from the set of rules
      final List<IRule> sbox = RewritingUtils.getSBoxRules(rules, queryHeads);

      // get the constraints from the set of rules
      final Set<IRule> constraints = RewritingUtils.getConstraints(rules, queryHeads);

      final Set<Expressivity> exprs = RewritingUtils.getExpressivity(tgds);
      LOGGER.info("Expressivity: " + exprs.toString());

      if (!exprs.contains(Expressivity.LINEAR) && !exprs.contains(Expressivity.STICKY))
        throw new EvaluationException("Only Linear and Sticky TGDs are supported for rewriting.");

      // compute the dependency graph

      LOGGER.debug("Computing position dependencies.");
      // long depGraphMem = MonitoringUtils.getHeapUsage();

      Map<Pair<IPosition, IPosition>, Set<Pair<List<IPosition>, List<IRule>>>> deps = DepGraphUtils
          .computePropagationGraph(tgds);

      // Setup caching
      CacheManager.setupCaching();

      // if linear TGDs, compute the atom coverage graph.
      LOGGER.debug("Computing atom coverage graph.");
      if (exprs.contains(Expressivity.LINEAR)) {
        deps = DepGraphUtils.computeCoverGraph(deps);
      }

      // rewriting constraints
      final ParallelRewriter cnsRewriter = new ParallelRewriter(DecompositionStrategy.MONOLITIC, RewritingLanguage.UCQ,
          SubCheckStrategy.NONE, NCCheck.NONE);
      final Set<IRule> rewrittenConstraints = Sets.newHashSet();
      if (!ncCheckStrategy.equals(NCCheck.NONE)) {
        for (final IRule c : constraints) {
          rewrittenConstraints.addAll(cnsRewriter.getRewriting(c, tgds, new HashSet<IRule>(), deps, exprs));
        }
      }
      LOGGER.debug("Finished rewriting constraints.");

      // dump the rewritten constraints:
      File outFile = FileUtils.getFile(outTestDir, testName.concat("_cns.dtg"));
      final FileWriter cnsFW = new FileWriter(outFile);
      IOUtils.writeLines(rewrittenConstraints, IOUtils.LINE_SEPARATOR, cnsFW);
      cnsFW.close();

      // Compute the Rewriting
      final ParallelRewriter rewriter = new ParallelRewriter(decomposition, rewLang, subchkStrategy, ncCheckStrategy);
      for (final IRule q : queries) {

        // Setup caching
        CacheManager.setupCaching();

        final String queryPredicate = q.getHead().iterator().next().getAtom().getPredicate().getPredicateSymbol();

        LOGGER.info("Processing query: ".concat(q.toString()));
        final Set<IRule> rewriting = rewriter.getRewriting(q, tgds, rewrittenConstraints, deps, exprs);

        // Create a file to store the rewriting results.

        outFile = FileUtils.getFile(outTestDir, queryPredicate.concat("_rew.dtg"));
        final FileWriter rewFW = new FileWriter(outFile);

        rewFW.write("/// Query: " + q + "///\n");
        rewFW.write("/// Ontology: " + testName + "///");
        rewFW.write("/// Created on: " + creationDate + " ///\n");
        rewFW.write("/// Rules in the program: " + rules.size() + " ///\n");
        rewFW.write("/// TGDs in the program: " + tgds.size() + " ///\n");
        rewFW.write("/// Constraints in the program: " + constraints.size() + " ///\n");
        rewFW.write("/// Theory expressivity: " + exprs.toString() + " ///\n");
        rewFW.write("/// Decomposition: " + decomposition.name() + " ///\n");
        rewFW.write("/// Subsumption Check Strategy: " + subchkStrategy.name() + " ///\n");
        rewFW.write("/// Negative Constraints Check Strategy: " + ncCheckStrategy.name() + " ///\n");
        rewFW.write(IOUtils.LINE_SEPARATOR);

        LOGGER.info("Writing the output at: " + outFile.getAbsolutePath());

        rewFW.write(IOUtils.LINE_SEPARATOR);
        rewFW.write(IOUtils.LINE_SEPARATOR);

        rewFW.write("/// Rewritten Program ///\n");
        final Set<ILiteral> newHeads = new HashSet<ILiteral>();
        for (final IRule qr : rewriting) {
          newHeads.add(qr.getHead().iterator().next());
          rewFW.write(qr + "\n");
        }
        rewFW.write("\n");
        for (final ILiteral h : newHeads) {
          rewFW.write("?- " + h + ".\n");
        }
        rewFW.write("\n");
        rewFW.flush();
        rewFW.close();

        if (sbox.size() > 0) {

          // Produce the rewriting according to the Storage Box
          final IQueryRewriter ndmRewriter = new NDMRewriter(sbox);
          // final Set<ILiteral> newHeads = new HashSet<ILiteral>();
          final Set<IRule> sboxRew = new LinkedHashSet<IRule>();
          for (final IRule r : rewriting) {
            // Create a file to store the rewriting results as Datalog Rules
            LOGGER.debug("-- Processing rewriting: " + r);
            sboxRew.addAll(ndmRewriter.getRewriting(r));
          }

          // dump the rewritten sbox rewriting:
          final File sboxFile = FileUtils.getFile(outTestDir, queryPredicate.concat("_sbox_rew.dtg"));
          final FileWriter sboxFW = new FileWriter(sboxFile);
          IOUtils.writeLines(sboxRew, IOUtils.LINE_SEPARATOR, sboxFW);
          sboxFW.close();

          // Produce a SQL rewriting
          final SQLRewriter sqlRewriter = new SQLRewriter();
          final String sqlRew = sqlRewriter.getUCQSQLRewriting(sboxRew);
          final File sqlFile = FileUtils.getFile(outTestDir, queryPredicate.concat("_rew.sql"));
          final FileWriter sqlFW = new FileWriter(sqlFile);
          IOUtils.write(sqlRew, sqlFW);
          sqlFW.close();

          // Execute the SQL rewriting
          LOGGER.info("Executing SQL Rewriting: " + IOUtils.LINE_SEPARATOR + sqlRew);

          long duration = System.nanoTime();
          final IRelation result = StorageManager.executeQuery(sqlRew);
          duration = (System.nanoTime() - duration) / 1000000;
          LOGGER.info(result.size() + " tuples in " + duration + " [ms]\n");
          LOGGER.info(IOUtils.LINE_SEPARATOR + result.toString());
        }
      }
    }
    sizeSummaryWriter.close();
    timeSummaryWriter.close();
    cacheSummaryWriter.close();
    memorySummaryWriter.close();

  }
}
