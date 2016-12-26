/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.cs2as.compiler.tests.models.companies.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.qvtd.cs2as.compiler.tests.models.companies.parser.antlr.internal.InternalCompaniesParser;
import org.eclipse.qvtd.cs2as.compiler.tests.models.companies.services.CompaniesGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class CompaniesParser extends AbstractAntlrParser {

	@Inject
	private CompaniesGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	

	@Override
	protected InternalCompaniesParser createParser(XtextTokenStream stream) {
		return new InternalCompaniesParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "company";
	}

	public CompaniesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CompaniesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
