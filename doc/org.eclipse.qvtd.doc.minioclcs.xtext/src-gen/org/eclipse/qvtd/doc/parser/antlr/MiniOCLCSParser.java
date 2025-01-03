/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/*
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.qvtd.doc.parser.antlr.internal.InternalMiniOCLCSParser;
import org.eclipse.qvtd.doc.services.MiniOCLCSGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class MiniOCLCSParser extends AbstractAntlrParser {

	@Inject
	private MiniOCLCSGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMiniOCLCSParser createParser(XtextTokenStream stream) {
		return new InternalMiniOCLCSParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "RootCS";
	}

	public MiniOCLCSGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MiniOCLCSGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
