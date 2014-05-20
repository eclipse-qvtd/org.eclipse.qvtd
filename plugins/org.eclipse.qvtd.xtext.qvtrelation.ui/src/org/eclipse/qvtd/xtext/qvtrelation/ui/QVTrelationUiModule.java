/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.ui;

import java.util.List;

import org.eclipse.qvtd.xtext.qvtrelation.ui.internal.QVTrelationActivator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;

import com.google.common.collect.Multimap;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTrelationUiModule extends org.eclipse.qvtd.xtext.qvtrelation.ui.AbstractQVTrelationUiModule
{
	public static final String EDITOR_ID = QVTrelationActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTRELATION_QVTRELATION;

	public QVTrelationUiModule(AbstractUIPlugin plugin) {
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
