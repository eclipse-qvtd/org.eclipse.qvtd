/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtbase.ide.contentassist.antlr;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.util.PolymorphicDispatcher;

public class PartialQVTbaseContentAssistParser extends QVTbaseParser {

	private AbstractRule rule;

	@Override
	public void initializeFor(AbstractRule rule) {
		this.rule = rule;
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		if (rule == null || rule.eIsProxy())
			return Collections.emptyList();
		String methodName = "entryRule" + rule.getName();
		PolymorphicDispatcher<Collection<FollowElement>> dispatcher =
			new PolymorphicDispatcher<Collection<FollowElement>>(methodName, 0, 0, Collections.singletonList(parser));
		dispatcher.invoke();
		return parser.getFollowElements();
	}

}
