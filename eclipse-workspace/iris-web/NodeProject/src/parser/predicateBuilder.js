import * as parameterModule  from "./parameterBuilder";
import * as regExModule from "./regExService";


function _builder(tgdText) {

	return {
		build: function (predicateText) {
			var parameters = regExModule.service.arrayOfMatches(regExModule.service.variableOrConstantRegEx, predicateText);
			var parametersAsObjets = [];
			var type;
			for (var i = 0; i < parameters.length; i++) {
				parametersAsObjets.push(parameterModule.builder.build(parameters[i]));
			};

			var hasVariable = function (v) {
				return parametersAsObjets.some(p => p.name == v)
			};

			return {
				name: predicateText.split("(")[0].trim(),
				parameters: parametersAsObjets,
				hasVariable: hasVariable,
				allVariables: parametersAsObjets.filter(p => p.type == 'variable').map(p => p.name),
				hasAllVariables: function (variables) {
					return variables.every(v => hasVariable(v));
				},
				toString: function () {
					return [this.name, "(", this.parameters.map(p => p.toString()).join(", "), ")"].join("");
				}
			}
		}
	}
}

export const builder = _builder();