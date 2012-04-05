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
import org.eclipse.qvt.declarative.parser.ui.QVTUIPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class QVTExtensionsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{
	public QVTExtensionsPreferencePage() {
		super(GRID);
		setPreferenceStore(QVTUIPlugin.getDefault().getPreferenceStore());
		setDescription("Configure the extensions used by QVT tools.\n\n"
				+ "The first extension is used for tool outputs.\n"
				+ "All extensions are used for tool inputs.\n\n"
				+ "Multiple extensions should be separated by commas.\n"
				);
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override public void createFieldEditors() {
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_TEXT_EXTENSIONS.KM3, "KM3 Text:", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_EMOF_EXTENSIONS.KM3, "KM3 XML (EMOF):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_ECORE_EXTENSIONS.KM3, "KM3 XML (Ecore):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OCL, "OCL Text:", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OCL, "OCL XML (EMOF):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OCL, "OCL XML (Ecore):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_TEXT_EXTENSIONS.CORE, "QVTcore Text:", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_EMOF_EXTENSIONS.CORE, "QVTcore XML (EMOF):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_ECORE_EXTENSIONS.CORE, "QVTcore XML (Ecore):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OPERATIONAL, "QVToperational Text:", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OPERATIONAL, "QVToperational XML (EMOF):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OPERATIONAL, "QVToperational XML (Ecore):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_TEXT_EXTENSIONS.RELATION, "QVTrelation Text:", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_EMOF_EXTENSIONS.RELATION, "QVTrelation XML (EMOF):", getFieldEditorParent()));
		addField(new ExtensionsStringFieldEditor(QVTPreferenceConstants.P_ECORE_EXTENSIONS.RELATION, "QVTrelation XML (Ecore):", getFieldEditorParent()));
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}