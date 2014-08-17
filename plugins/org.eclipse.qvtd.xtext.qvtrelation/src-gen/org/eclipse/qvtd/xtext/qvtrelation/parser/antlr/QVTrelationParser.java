/*
* generated by Xtext
*/
package org.eclipse.qvtd.xtext.qvtrelation.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;

public class QVTrelationParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private QVTrelationGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.qvtd.xtext.qvtrelation.parser.antlr.internal.InternalQVTrelationParser createParser(XtextTokenStream stream) {
		return new org.eclipse.qvtd.xtext.qvtrelation.parser.antlr.internal.InternalQVTrelationParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "TopLevelCS";
	}
	
	public QVTrelationGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(QVTrelationGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
