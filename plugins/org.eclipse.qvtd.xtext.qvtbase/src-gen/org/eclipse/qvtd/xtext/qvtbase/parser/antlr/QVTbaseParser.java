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
package org.eclipse.qvtd.xtext.qvtbase.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;

public class QVTbaseParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private QVTbaseGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}

	@Override
	protected org.eclipse.qvtd.xtext.qvtbase.parser.antlr.internal.InternalQVTbaseParser createParser(XtextTokenStream stream) {
		return new org.eclipse.qvtd.xtext.qvtbase.parser.antlr.internal.InternalQVTbaseParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "AttributeCS";
	}

	public QVTbaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(QVTbaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
