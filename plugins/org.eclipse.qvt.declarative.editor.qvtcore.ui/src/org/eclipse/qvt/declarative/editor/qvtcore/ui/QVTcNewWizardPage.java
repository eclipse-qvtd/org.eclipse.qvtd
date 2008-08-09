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
 * $Id: QVTcNewWizardPage.java,v 1.2 2008/08/09 17:56:12 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.qvt.declarative.editor.ui.wizards.PagedNewWizardPage;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (qvtc).
 */
public class QVTcNewWizardPage extends PagedNewWizardPage
{
	public QVTcNewWizardPage(ISelection selection) {
		super(selection);
	}

	@Override protected String getFileExtension() {
		return QVTPreferences.getCoreTextExtension();
	}

	@Override protected String[] getFileExtensions() {
		return QVTPreferences.getCoreTextExtensions();
	}
}