/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.analysis;

import java.util.*;
import org.deri.iris.parser.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    public void caseADirectiveExpr(ADirectiveExpr node)
    {
        defaultCase(node);
    }

    public void caseARuleExpr(ARuleExpr node)
    {
        defaultCase(node);
    }

    public void caseAFactExpr(AFactExpr node)
    {
        defaultCase(node);
    }

    public void caseAQueryExpr(AQueryExpr node)
    {
        defaultCase(node);
    }

    public void caseADirective(ADirective node)
    {
        defaultCase(node);
    }

    public void caseARule(ARule node)
    {
        defaultCase(node);
    }

    public void caseAFact(AFact node)
    {
        defaultCase(node);
    }

    public void caseAQuery(AQuery node)
    {
        defaultCase(node);
    }

    public void caseALitlist(ALitlist node)
    {
        defaultCase(node);
    }

    public void caseAAndLitlist(AAndLitlist node)
    {
        defaultCase(node);
    }

    public void caseACommaLitlist(ACommaLitlist node)
    {
        defaultCase(node);
    }

    public void caseANegatedLiteral(ANegatedLiteral node)
    {
        defaultCase(node);
    }

    public void caseALiteral(ALiteral node)
    {
        defaultCase(node);
    }

    public void caseABuiltinLiteral(ABuiltinLiteral node)
    {
        defaultCase(node);
    }

    public void caseANegatedbuiltinLiteral(ANegatedbuiltinLiteral node)
    {
        defaultCase(node);
    }

    public void caseAPredicate(APredicate node)
    {
        defaultCase(node);
    }

    public void caseADirname(ADirname node)
    {
        defaultCase(node);
    }

    public void caseAParamlist(AParamlist node)
    {
        defaultCase(node);
    }

    public void caseATermTermlist(ATermTermlist node)
    {
        defaultCase(node);
    }

    public void caseATermlist(ATermlist node)
    {
        defaultCase(node);
    }

    public void caseAIntlist(AIntlist node)
    {
        defaultCase(node);
    }

    public void caseAIntIntlist(AIntIntlist node)
    {
        defaultCase(node);
    }

    public void caseAFunctionTerm(AFunctionTerm node)
    {
        defaultCase(node);
    }

    public void caseAVarTerm(AVarTerm node)
    {
        defaultCase(node);
    }

    public void caseAIntegerTerm(AIntegerTerm node)
    {
        defaultCase(node);
    }

    public void caseAIntegerlTerm(AIntegerlTerm node)
    {
        defaultCase(node);
    }

    public void caseAStringTerm(AStringTerm node)
    {
        defaultCase(node);
    }

    public void caseAStringlTerm(AStringlTerm node)
    {
        defaultCase(node);
    }

    public void caseADecimalTerm(ADecimalTerm node)
    {
        defaultCase(node);
    }

    public void caseADecimallTerm(ADecimallTerm node)
    {
        defaultCase(node);
    }

    public void caseASqnameTerm(ASqnameTerm node)
    {
        defaultCase(node);
    }

    public void caseASqnamelTerm(ASqnamelTerm node)
    {
        defaultCase(node);
    }

    public void caseAIriTerm(AIriTerm node)
    {
        defaultCase(node);
    }

    public void caseAIrilTerm(AIrilTerm node)
    {
        defaultCase(node);
    }

    public void caseABooleanTerm(ABooleanTerm node)
    {
        defaultCase(node);
    }

    public void caseADoubleTerm(ADoubleTerm node)
    {
        defaultCase(node);
    }

    public void caseAFloatTerm(AFloatTerm node)
    {
        defaultCase(node);
    }

    public void caseADateTerm(ADateTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetzTerm(ADatetzTerm node)
    {
        defaultCase(node);
    }

    public void caseATimeisTerm(ATimeisTerm node)
    {
        defaultCase(node);
    }

    public void caseATimeistzTerm(ATimeistzTerm node)
    {
        defaultCase(node);
    }

    public void caseATimefsTerm(ATimefsTerm node)
    {
        defaultCase(node);
    }

    public void caseATimefstzTerm(ATimefstzTerm node)
    {
        defaultCase(node);
    }

    public void caseATimemsTerm(ATimemsTerm node)
    {
        defaultCase(node);
    }

    public void caseATimemstzTerm(ATimemstzTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimeisTerm(ADatetimeisTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimeistzTerm(ADatetimeistzTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimefsTerm(ADatetimefsTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimefstzTerm(ADatetimefstzTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimemsTerm(ADatetimemsTerm node)
    {
        defaultCase(node);
    }

    public void caseADatetimemstzTerm(ADatetimemstzTerm node)
    {
        defaultCase(node);
    }

    public void caseADurationisTerm(ADurationisTerm node)
    {
        defaultCase(node);
    }

    public void caseADurationfsTerm(ADurationfsTerm node)
    {
        defaultCase(node);
    }

    public void caseADurationmsTerm(ADurationmsTerm node)
    {
        defaultCase(node);
    }

    public void caseAGdayTerm(AGdayTerm node)
    {
        defaultCase(node);
    }

    public void caseAGmonthTerm(AGmonthTerm node)
    {
        defaultCase(node);
    }

    public void caseAGyearTerm(AGyearTerm node)
    {
        defaultCase(node);
    }

    public void caseAGyearmonthTerm(AGyearmonthTerm node)
    {
        defaultCase(node);
    }

    public void caseAGmonthdayTerm(AGmonthdayTerm node)
    {
        defaultCase(node);
    }

    public void caseABase64binaryTerm(ABase64binaryTerm node)
    {
        defaultCase(node);
    }

    public void caseAHexbinaryTerm(AHexbinaryTerm node)
    {
        defaultCase(node);
    }

    public void caseABinaryBuiltin(ABinaryBuiltin node)
    {
        defaultCase(node);
    }

    public void caseAEqualsBuiltin(AEqualsBuiltin node)
    {
        defaultCase(node);
    }

    public void caseATernaryBuiltin(ATernaryBuiltin node)
    {
        defaultCase(node);
    }

    public void caseTTBlank(TTBlank node)
    {
        defaultCase(node);
    }

    public void caseTTDash(TTDash node)
    {
        defaultCase(node);
    }

    public void caseTTComment(TTComment node)
    {
        defaultCase(node);
    }

    public void caseTTDot(TTDot node)
    {
        defaultCase(node);
    }

    public void caseTTImpliedby(TTImpliedby node)
    {
        defaultCase(node);
    }

    public void caseTTAnd(TTAnd node)
    {
        defaultCase(node);
    }

    public void caseTTNot(TTNot node)
    {
        defaultCase(node);
    }

    public void caseTTComma(TTComma node)
    {
        defaultCase(node);
    }

    public void caseTTLpar(TTLpar node)
    {
        defaultCase(node);
    }

    public void caseTTRpar(TTRpar node)
    {
        defaultCase(node);
    }

    public void caseTTUnders(TTUnders node)
    {
        defaultCase(node);
    }

    public void caseTTVariable(TTVariable node)
    {
        defaultCase(node);
    }

    public void caseTTQuery(TTQuery node)
    {
        defaultCase(node);
    }

    public void caseTTId(TTId node)
    {
        defaultCase(node);
    }

    public void caseTTBinOp(TTBinOp node)
    {
        defaultCase(node);
    }

    public void caseTTTerOp(TTTerOp node)
    {
        defaultCase(node);
    }

    public void caseTTEq(TTEq node)
    {
        defaultCase(node);
    }

    public void caseTTInt(TTInt node)
    {
        defaultCase(node);
    }

    public void caseTTPosint(TTPosint node)
    {
        defaultCase(node);
    }

    public void caseTTDec(TTDec node)
    {
        defaultCase(node);
    }

    public void caseTTStr(TTStr node)
    {
        defaultCase(node);
    }

    public void caseTTSq(TTSq node)
    {
        defaultCase(node);
    }

    public void caseTTPreInteger(TTPreInteger node)
    {
        defaultCase(node);
    }

    public void caseTTPreString(TTPreString node)
    {
        defaultCase(node);
    }

    public void caseTTPreDecimal(TTPreDecimal node)
    {
        defaultCase(node);
    }

    public void caseTTPreDouble(TTPreDouble node)
    {
        defaultCase(node);
    }

    public void caseTTPreFloat(TTPreFloat node)
    {
        defaultCase(node);
    }

    public void caseTTPreBase64(TTPreBase64 node)
    {
        defaultCase(node);
    }

    public void caseTTPreBoolean(TTPreBoolean node)
    {
        defaultCase(node);
    }

    public void caseTTPreDate(TTPreDate node)
    {
        defaultCase(node);
    }

    public void caseTTPreDatetime(TTPreDatetime node)
    {
        defaultCase(node);
    }

    public void caseTTPreDuration(TTPreDuration node)
    {
        defaultCase(node);
    }

    public void caseTTPreGday(TTPreGday node)
    {
        defaultCase(node);
    }

    public void caseTTPreGmonthday(TTPreGmonthday node)
    {
        defaultCase(node);
    }

    public void caseTTPreGmonth(TTPreGmonth node)
    {
        defaultCase(node);
    }

    public void caseTTPreGyearmonth(TTPreGyearmonth node)
    {
        defaultCase(node);
    }

    public void caseTTPreGyear(TTPreGyear node)
    {
        defaultCase(node);
    }

    public void caseTTPreHex(TTPreHex node)
    {
        defaultCase(node);
    }

    public void caseTTPreIri(TTPreIri node)
    {
        defaultCase(node);
    }

    public void caseTTPreSqname(TTPreSqname node)
    {
        defaultCase(node);
    }

    public void caseTTPreTime(TTPreTime node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
