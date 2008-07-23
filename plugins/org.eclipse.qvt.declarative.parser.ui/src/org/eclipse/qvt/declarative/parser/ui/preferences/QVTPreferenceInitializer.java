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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.qvt.declarative.parser.ui.QVTUIPlugin;

/**
 * Class used to initialize default preference values.
 */
public class QVTPreferenceInitializer extends AbstractPreferenceInitializer
{
	@Override public void initializeDefaultPreferences() {
		IPreferenceStore store = QVTUIPlugin.getDefault().getPreferenceStore();

		store.setDefault(QVTPreferenceConstants.P_QVT_REPRESENTATION, "ecore");
		
		store.setDefault(QVTPreferenceConstants.P_TEXT_EXTENSIONS.CORE, "qvtc");
		store.setDefault(QVTPreferenceConstants.P_EMOF_EXTENSIONS.CORE, "qvtcore");	
		store.setDefault(QVTPreferenceConstants.P_ECORE_EXTENSIONS.CORE, "eqvtcore");	
		store.setDefault(QVTPreferenceConstants.P_TEXT_EXTENSIONS.KM3, "km3");
		store.setDefault(QVTPreferenceConstants.P_EMOF_EXTENSIONS.KM3, "emof");	
		store.setDefault(QVTPreferenceConstants.P_ECORE_EXTENSIONS.KM3, "ecore");	
		store.setDefault(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OCL, "ocl");
		store.setDefault(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OCL, "oclemof");	
		store.setDefault(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OCL, "oclecore");	
		store.setDefault(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OPERATIONAL, "qvto");
		store.setDefault(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OPERATIONAL, "qvtoperational");	
		store.setDefault(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OPERATIONAL, "eqvtoperational");	
		store.setDefault(QVTPreferenceConstants.P_TEXT_EXTENSIONS.RELATION, "qvtr,qvt");
		store.setDefault(QVTPreferenceConstants.P_EMOF_EXTENSIONS.RELATION, "qvtrelation");
		store.setDefault(QVTPreferenceConstants.P_ECORE_EXTENSIONS.RELATION, "eqvtrelation");
	}	
}
