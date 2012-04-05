/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.qvt.declarative.parser.ui.QVTUIPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class QVTTopLevelPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{
	public QVTTopLevelPreferencePage() {
		super(GRID);
		setPreferenceStore(QVTUIPlugin.getDefault().getPreferenceStore());
		setDescription("QVT tool Behaviour ");
	}
	
	@Override public void createFieldEditors() {
		addField(new RadioGroupFieldEditor(QVTPreferenceConstants.P_QVT_REPRESENTATION,
			"Generated model representation",
			1,
			new String[][] {
				{ "EMOF ('strictly' OMG compliant)", "emof" },
				{ "Ecore (more efficient)", "ecore" }
		}, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {}	
}