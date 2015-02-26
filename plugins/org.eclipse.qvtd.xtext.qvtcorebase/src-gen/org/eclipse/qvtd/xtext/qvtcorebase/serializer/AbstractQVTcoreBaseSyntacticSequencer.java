/*
 * generated by Xtext
 */
package org.eclipse.qvtd.xtext.qvtcorebase.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractQVTcoreBaseSyntacticSequencer extends AbstractSyntacticSequencer {

	protected QVTcoreBaseGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BottomPatternCS_VerticalLineKeyword_0_3_0_q;
	protected AbstractElementAlias match_GuardPatternCS_VerticalLineKeyword_0_3_0_q;
	protected AbstractElementAlias match_GuardPatternCS___LeftParenthesisKeyword_0_1_VerticalLineKeyword_0_3_0_q_RightParenthesisKeyword_0_4___or_____LeftParenthesisKeyword_1_1_RightParenthesisKeyword_1_3___or___LeftParenthesisKeyword_2_1_RightParenthesisKeyword_2_3____;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (QVTcoreBaseGrammarAccess) access;
		match_BottomPatternCS_VerticalLineKeyword_0_3_0_q = new TokenAlias(false, true, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3_0());
		match_GuardPatternCS_VerticalLineKeyword_0_3_0_q = new TokenAlias(false, true, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3_0());
		match_GuardPatternCS___LeftParenthesisKeyword_0_1_VerticalLineKeyword_0_3_0_q_RightParenthesisKeyword_0_4___or_____LeftParenthesisKeyword_1_1_RightParenthesisKeyword_1_3___or___LeftParenthesisKeyword_2_1_RightParenthesisKeyword_2_3____ = new AlternativeAlias(false, false, new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_2_3()))), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_1()), new TokenAlias(false, true, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3_0()), new TokenAlias(false, false, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_4())));
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_BottomPatternCS_VerticalLineKeyword_0_3_0_q.equals(syntax))
				emit_BottomPatternCS_VerticalLineKeyword_0_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GuardPatternCS_VerticalLineKeyword_0_3_0_q.equals(syntax))
				emit_GuardPatternCS_VerticalLineKeyword_0_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GuardPatternCS___LeftParenthesisKeyword_0_1_VerticalLineKeyword_0_3_0_q_RightParenthesisKeyword_0_4___or_____LeftParenthesisKeyword_1_1_RightParenthesisKeyword_1_3___or___LeftParenthesisKeyword_2_1_RightParenthesisKeyword_2_3____.equals(syntax))
				emit_GuardPatternCS___LeftParenthesisKeyword_0_1_VerticalLineKeyword_0_3_0_q_RightParenthesisKeyword_0_4___or_____LeftParenthesisKeyword_1_1_RightParenthesisKeyword_1_3___or___LeftParenthesisKeyword_2_1_RightParenthesisKeyword_2_3____(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '|'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedRealizedVariables+=RealizedVariableCS (ambiguity) '}' (rule end)
	 *     ownedUnrealizedVariables+=UnrealizedVariableCS (ambiguity) '}' (rule end)
	 */
	protected void emit_BottomPatternCS_VerticalLineKeyword_0_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '|'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedUnrealizedVariables+=GuardVariableCS (ambiguity) ')' (rule end)
	 */
	protected void emit_GuardPatternCS_VerticalLineKeyword_0_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' '|'? ')') | (('(' ')') | ('(' ')'))
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_GuardPatternCS___LeftParenthesisKeyword_0_1_VerticalLineKeyword_0_3_0_q_RightParenthesisKeyword_0_4___or_____LeftParenthesisKeyword_1_1_RightParenthesisKeyword_1_3___or___LeftParenthesisKeyword_2_1_RightParenthesisKeyword_2_3____(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
