/*******************************************************************************
 * Copyright (c) 2011, 2024 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtrelation.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.qvtd.xtext.qvtrelation.parser.antlr.internal.InternalQVTrelationParser;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class QVTrelationParser extends AbstractAntlrParser {

	@Inject
	private QVTrelationGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}


	@Override
	protected InternalQVTrelationParser createParser(XtextTokenStream stream) {
		return new InternalQVTrelationParser(stream, getGrammarAccess());
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
