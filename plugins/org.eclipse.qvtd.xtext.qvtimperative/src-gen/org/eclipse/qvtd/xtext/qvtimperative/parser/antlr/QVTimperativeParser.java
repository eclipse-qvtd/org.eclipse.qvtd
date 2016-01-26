/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;

public class QVTimperativeParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private QVTimperativeGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.qvtd.xtext.qvtimperative.parser.antlr.internal.InternalQVTimperativeParser createParser(XtextTokenStream stream) {
		return new org.eclipse.qvtd.xtext.qvtimperative.parser.antlr.internal.InternalQVTimperativeParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "TopLevelCS";
	}
	
	public QVTimperativeGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(QVTimperativeGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
