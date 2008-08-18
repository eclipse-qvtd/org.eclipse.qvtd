/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTcTextConfiguration.java,v 1.3 2008/08/18 07:57:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.qvt.declarative.editor.ui.text.TextColorManager;
import org.eclipse.qvt.declarative.editor.ui.text.TextDoubleClickStrategy;
import org.eclipse.qvt.declarative.editor.ui.text.TextPartitionScanner;
import org.eclipse.qvt.declarative.editor.ui.text.QVTTextSourceViewerConfiguration;
import org.eclipse.ui.editors.text.EditorsUI;

@Deprecated // Use UniversalTextEditor
public class QVTcTextConfiguration extends QVTTextSourceViewerConfiguration {
	private TextDoubleClickStrategy doubleClickStrategy;
	private QVTcTextDefaultContentScanner scanner = null;
	private TextColorManager colorManager;

	public QVTcTextConfiguration(TextColorManager colorManager) {
		super(EditorsUI.getPreferenceStore());
		this.colorManager = colorManager;
	}
	
	@Override public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return TextPartitionScanner.getConfiguredContentTypes();
	}

	@Override public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new TextDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected QVTcTextDefaultContentScanner getDefaultContentTypeScanner() {
		if (scanner == null) {
			scanner = new QVTcTextDefaultContentScanner(colorManager);
			scanner.setDefaultReturnToken(
				colorManager.getDefaultContextToken());
		}
		return scanner;
	}

	@Override public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        DefaultDamagerRepairer dr = null;
     	PresentationReconciler reconciler = new PresentationReconciler();

        dr = new DefaultDamagerRepairer(getDefaultContentTypeScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        return reconciler;
	}
}