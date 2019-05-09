import * as tgdModule from "../src/parser/tgdBuilder";
import * as predicateModule from "../src/parser/predicateBuilder";
import * as parameterModule from "../src/parser/parameterBuilder";
import * as queryModule from "../src/parser/queryBuilder";

var chai = require('chai');


var assert = chai.assert;

describe('#applicabilityTests()', function() {

    it('atom should count correct appearances of variable', function() {
        var atom = predicateModule.builder.build("p('a', ?x, ?y, ?x)");
        var variableX = parameterModule.builder.build('?x');
        var variableY = parameterModule.builder.build('?y');
        var variableZ = parameterModule.builder.build('?z');
        assert.equal(atom.countFor(variableX), 2);
        assert.equal(atom.countFor(variableY), 1);
        assert.equal(atom.countFor(variableZ), 0);
    })

    it('should query respond variable is shared if one atom has that variabele more than once', function() {
        var query = queryModule.builder.build("?- p('a', ?x, ?x, ?y)");
        var variableX = parameterModule.builder.build('?x');
        var variableY = parameterModule.builder.build('?y');
        assert.equal(query.isSharedVariable(variableX), true);
        assert.equal(query.isSharedVariable(variableY), false);
    })

    it('should query respond variable is shared if two atoms have the same variabele in the same query', function() {
        var query = queryModule.builder.build("?- p('a', ?x), r(?x, ?y)");
        var variableX = parameterModule.builder.build('?x');
        var variableY = parameterModule.builder.build('?y');
        assert.equal(query.isSharedVariable(variableX), true);
        assert.equal(query.isSharedVariable(variableY), false);
    })

    it('should query respond is not shared for constants', function() {
        var query = queryModule.builder.build("?- p('a', 'a'), r('a', ?y)");
        var constant = parameterModule.builder.build("'a'");
        assert.equal(query.isSharedVariable(constant), false);
    })

    it('tgd should rename its variables correctly', function() {
        var atom1 = predicateModule.builder.build("? p(?x, ?y)");
        var atom2 = predicateModule.builder.build("? p(?x, ?z)");
        var tgd = tgdModule.builder.build("q(?x, ?y) :- r('a', ?x, ?w)");
        var atoms = [atom1, atom2];
        assert.equal(tgd.head.predicate.renameVariablesAndNulls(atoms).toString(), tgdModule.builder.build("q(?_renamed_x, ?_renamed_y) :- r('a', ?_renamed_x, ?w)").head.predicate.toString());
        //entender porque esto no funciona//tgdModule.builder.build("q(?_renamed_x, ?_renamed_y) :- r('a', ?_renamed_x, ?w)")
        //SIN EMBARGO ESTO ESTA BIEN: tgd.head.predicate.renameVariablesAndNulls(atoms).toString() "q(?_renamed_x, ?_renamed_y)"
    })


})