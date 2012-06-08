/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcore.ui;

import java.util.List;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;

import com.google.common.collect.Multimap;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTcoreUiModule extends org.eclipse.qvtd.xtext.qvtcore.ui.AbstractQVTcoreUiModule {
	public QVTcoreUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public static class Bug382088Workaround extends ParserBasedContentAssistContextFactory.StatefulFactory
	{
		private int depth = 0;

		@Override
		protected void computeFollowElements(ParserBasedContentAssistContextFactory.FollowElementCalculator calculator,
				FollowElement element, Multimap<Integer, List<AbstractElement>> visited) {
			try {
				if (++depth < 10) {
					super.computeFollowElements(calculator, element, visited);
				}
			} finally {
				depth--;
			}
		}		
	}
	
	public Class<? extends ParserBasedContentAssistContextFactory.StatefulFactory> bindStatefulFactory() {
		return Bug382088Workaround.class;		// BUG 382088
	}
}
