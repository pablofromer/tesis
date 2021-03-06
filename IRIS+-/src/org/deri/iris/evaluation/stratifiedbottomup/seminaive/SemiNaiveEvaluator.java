/*
 * Integrated Rule Inference System (IRIS):
 * An extensible rule inference system for datalog with extensions.
 *
 * Copyright (C) 2008 Semantic Technology Institute (STI) Innsbruck,
 * University of Innsbruck, Technikerstrasse 21a, 6020 Innsbruck, Austria.
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
package org.deri.iris.evaluation.stratifiedbottomup.seminaive;

import java.util.List;

import org.deri.iris.Configuration;
import org.deri.iris.EvaluationException;
import org.deri.iris.api.basics.IPredicate;
import org.deri.iris.api.basics.ITuple;
import org.deri.iris.evaluation.stratifiedbottomup.IRuleEvaluator;
import org.deri.iris.facts.Facts;
import org.deri.iris.facts.IFacts;
import org.deri.iris.rules.compiler.ICompiledRule;
import org.deri.iris.storage.IRelation;

/**
 * Semi-naive evaluation. see Ullman, Vol. 1
 */
public class SemiNaiveEvaluator implements IRuleEvaluator {
  @Override
  public void evaluateRules(final List<ICompiledRule> rules, final IFacts facts, final Configuration configuration)
      throws EvaluationException {
    IFacts deltas = new Facts(configuration.relationFactory);

    // One pass with simple evaluation to generate deltas
    // For each rule in the collection (stratum)
    for (final ICompiledRule rule : rules) {
      final IRelation delta = rule.evaluate();

      if ((delta != null) && (delta.size() > 0)) {
        final IPredicate predicate = rule.headPredicate();
        deltas.get(predicate).addAll(delta);
      }
    }

    // Update the facts
    addAll(facts, deltas);

    // Now do iterative evaluation (semi-naive)
    boolean newTuples;

	
    int i = 0;
    for (;;) {
    	
      newTuples = false;

      final IFacts previousDeltas = deltas;

      deltas = new Facts(configuration.relationFactory);

      for (final ICompiledRule rule : rules) {
        final IPredicate predicate = rule.headPredicate();

        IRelation delta = rule.evaluateIteratively(previousDeltas);

        // Remove already known tuples
        if ((delta != null) && (delta.size() > 0)) {
          final IRelation programFacts = facts.get(predicate);
          delta = removeDeducedTuples(predicate, delta, programFacts, configuration);
        }

        if ((delta != null) && (delta.size() > 0)) {
          newTuples = true;
          deltas.get(predicate).addAll(delta);
        }
      }

      i++;
      if (!newTuples || i == 10) {
        break;
      }

      // Iterate new tuples in dP[i] and add to program
      addAll(facts, deltas);
    }
  }

  /**
   * Add all the tuples from each of the deltas to the target facts.
   * 
   * @param target
   *          The facts to be added to.
   * @param deltas
   *          The facts to be added.
   */
  private static void addAll(final IFacts target, final IFacts deltas) {
    for (final IPredicate predicate : deltas.getPredicates()) {
      target.get(predicate).addAll(deltas.get(predicate));
    }
  }

  /**
   * Helper to remove tuples from a delta that are already known or computed.
   * 
   * @param predicate
   *          The predicate identifying the relation.
   * @param delta
   *          The deltas produced by the last round of evaluation.
   * @param programFacts
   *          The already known or computed facts.
   * @return
   */
  private static IRelation removeDeducedTuples(final IPredicate predicate, final IRelation delta,
      final IRelation programFacts, final Configuration configuration) {
    // If there is nothing to take away from, or just nothing to
    // take-away...
    if ((delta.size() == 0) || (programFacts.size() == 0))
      return delta;

    final IRelation result = configuration.relationFactory.createRelation();

    for (int t = 0; t < delta.size(); ++t) {
      final ITuple tuple = delta.get(t);
      if (!programFacts.contains(tuple)) {
        result.add(tuple);
      }
    }

    return result;
  }

  @Override
  public void evaluateRules(final List<ICompiledRule> compiledRules, final IFacts facts, final int maxQueryLength,
      final Configuration configuration) {
    // ignore the query bound.
    evaluateRules(compiledRules, facts, configuration);

  }
}
