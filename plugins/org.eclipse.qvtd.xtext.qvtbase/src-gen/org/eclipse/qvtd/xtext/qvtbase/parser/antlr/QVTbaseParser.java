/*******************************************************************************
 * Copyright (c) 2011, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.qvtd.xtext.qvtbase.parser.antlr.internal.InternalQVTbaseParser;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class QVTbaseParser extends AbstractAntlrParser {

	@Inject
	private QVTbaseGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}


	@Override
	protected InternalQVTbaseParser createParser(XtextTokenStream stream) {
		return new InternalQVTbaseParser(stream, getGrammarAccess());
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
