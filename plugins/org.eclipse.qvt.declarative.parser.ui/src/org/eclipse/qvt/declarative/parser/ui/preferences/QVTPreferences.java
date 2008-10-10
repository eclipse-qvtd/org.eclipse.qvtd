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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.qvt.declarative.parser.ui.QVTUIPlugin;

/**
 * Class used to access preference values.
 */
public class QVTPreferences
{
	private static String representation = null;
	private static boolean generateEMOF = false;
	private static String[] coreEMOFExtensions = null;
	private static String[] coreEcoreExtensions = null;
	private static String[] coreTextExtensions = null;
	private static String[] km3EMOFExtensions = null;
	private static String[] km3EcoreExtensions = null;
	private static String[] km3TextExtensions = null;
	private static String[] oclEMOFExtensions = null;
	private static String[] oclEcoreExtensions = null;
	private static String[] oclTextExtensions = null;
	private static String[] operationalEMOFExtensions = null;
	private static String[] operationalEcoreExtensions = null;
	private static String[] operationalTextExtensions = null;
	private static String[] relationEMOFExtensions = null;
	private static String[] relationEcoreExtensions = null;
	private static String[] relationTextExtensions = null;
	
	
	public static void clean() {
		representation = null;
		coreEMOFExtensions = null;		
		coreEcoreExtensions = null;		
		coreTextExtensions = null;		
		km3EMOFExtensions = null;		
		km3EcoreExtensions = null;		
		km3TextExtensions = null;		
		oclEMOFExtensions = null;		
		oclEcoreExtensions = null;		
		oclTextExtensions = null;		
		operationalEMOFExtensions = null;		
		operationalEcoreExtensions = null;		
		operationalTextExtensions = null;		
		relationEMOFExtensions = null;		
		relationEcoreExtensions = null;		
		relationTextExtensions = null;		
	}
	
	public static boolean generateEMOF() {
		if (representation == null) {
			getRepresentation();
			generateEMOF = "emof".equals(representation);
		}
		return generateEMOF;
	}
	
	public static String getExtension(String[] preferences) {
		if ((preferences == null) || (preferences.length < 1))
			return null;
		return preferences[0];
	}
	
	public static String[] getExtensions(String preferenceName) {
		IPreferenceStore store = getPreferenceStore();
		if (store == null)
			return null;
		String preference = store.getString(preferenceName);
		if (preference == null)
			return null;
		return preference.split(",");
	}
	
	public static String[] getCoreEMOFExtensions() {
		if (coreEMOFExtensions == null)
			coreEMOFExtensions = getExtensions(QVTPreferenceConstants.P_EMOF_EXTENSIONS.CORE);
		if (coreEMOFExtensions == null)
			coreEMOFExtensions = new String[] { "qvtcore" };
		return coreEMOFExtensions;
	}
	
	public static String[] getCoreEcoreExtensions() {
		if (coreEcoreExtensions == null)
			coreEcoreExtensions = getExtensions(QVTPreferenceConstants.P_ECORE_EXTENSIONS.CORE);
		if (coreEcoreExtensions == null)
			coreEcoreExtensions = new String[] { "eqvtcore" };
		return coreEcoreExtensions;
	}
	
	public static String getCoreTextExtension() {
		return getExtension(getCoreTextExtensions());
	}
	
	public static String[] getCoreTextExtensions() {
		if (coreTextExtensions == null)
			coreTextExtensions = getExtensions(QVTPreferenceConstants.P_TEXT_EXTENSIONS.CORE);
		if (coreTextExtensions == null)
			coreTextExtensions = new String[] { "qvtc" };
		return coreTextExtensions;
	}
	
//	public static String getCoreXMLExtension() {
//		return getExtension(getCoreXMLExtensions());
//	}
	
//	public static String[] getCoreXMLExtensions() {
//		if (coreXMLExtensions == null)
//			coreXMLExtensions = getExtensions(getXMLExtensionPreferenceNames().CORE);
//		return coreXMLExtensions;
//	}
	
	public static String getKM3EMOFExtension() {
		return getExtension(getKM3EMOFExtensions());
	}
	
	public static String[] getKM3EMOFExtensions() {
		if (km3EMOFExtensions == null)
			km3EMOFExtensions = getExtensions(QVTPreferenceConstants.P_EMOF_EXTENSIONS.KM3);
		if (km3EMOFExtensions == null)
			km3EMOFExtensions = new String[] { "emof" };
		return km3EMOFExtensions;
	}
	
	public static String getKM3EcoreExtension() {
		return getExtension(getKM3EcoreExtensions());
	}
	
	public static String[] getKM3EcoreExtensions() {
		if (km3EcoreExtensions == null)
			km3EcoreExtensions = getExtensions(QVTPreferenceConstants.P_ECORE_EXTENSIONS.KM3);
		if (km3EcoreExtensions == null)
			km3EcoreExtensions = new String[] { "ecore" };
		return km3EcoreExtensions;
	}

	public static String getKM3TextExtension() {
		return getExtension(getKM3TextExtensions());
	}
	
	public static String[] getKM3TextExtensions() {
		if (km3TextExtensions == null)
			km3TextExtensions = getExtensions(QVTPreferenceConstants.P_TEXT_EXTENSIONS.KM3);
		if (km3TextExtensions == null)
			km3TextExtensions = new String[] { "km3" };
		return km3TextExtensions;
	}
	
	public static String getOCLEMOFExtension() {
		return getExtension(getOCLEMOFExtensions());
	}
	
	public static String[] getOCLEMOFExtensions() {
		if (oclEMOFExtensions == null)
			oclEMOFExtensions = getExtensions(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OCL);
		if (oclEMOFExtensions == null)
			oclEMOFExtensions = new String[] { "emofocl" };
		return oclEMOFExtensions;
	}
	
	public static String getOCLEcoreExtension() {
		return getExtension(getOCLEcoreExtensions());
	}
	
	public static String[] getOCLEcoreExtensions() {
		if (oclEcoreExtensions == null)
			oclEcoreExtensions = getExtensions(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OCL);
		if (oclEcoreExtensions == null)
			oclEcoreExtensions = new String[] { "ecoreocl" };
		return oclEcoreExtensions;
	}

	public static String getOCLTextExtension() {
		return getExtension(getOCLTextExtensions());
	}
	
	public static String[] getOCLTextExtensions() {
		if (oclTextExtensions == null)
			oclTextExtensions = getExtensions(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OCL);
		if (oclTextExtensions == null)
			oclTextExtensions = new String[] { "ocl" };
		return oclTextExtensions;
	}
	
	public static String getOperationalEMOFExtension() {
		return getExtension(getOperationalEMOFExtensions());
	}
	
	public static String[] getOperationalEMOFExtensions() {
		if (operationalEMOFExtensions == null)
			operationalEMOFExtensions = getExtensions(QVTPreferenceConstants.P_EMOF_EXTENSIONS.OPERATIONAL);
		if (operationalEMOFExtensions == null)
			operationalEMOFExtensions = new String[] { "qvtoperational" };
		return operationalEMOFExtensions;
	}
	
	public static String getOperationalEcoreExtension() {
		return getExtension(getOperationalEcoreExtensions());
	}
	
	public static String[] getOperationalEcoreExtensions() {
		if (operationalEcoreExtensions == null)
			operationalEcoreExtensions = getExtensions(QVTPreferenceConstants.P_ECORE_EXTENSIONS.OPERATIONAL);
		if (operationalEcoreExtensions == null)
			operationalEcoreExtensions = new String[] { "eqvtoperational" };
		return operationalEcoreExtensions;
	}

	public static String getOperationalTextExtension() {
		return getExtension(getOperationalTextExtensions());
	}
	
	public static String[] getOperationalTextExtensions() {
		if (operationalTextExtensions == null)
			operationalTextExtensions = getExtensions(QVTPreferenceConstants.P_TEXT_EXTENSIONS.OPERATIONAL);
		if (operationalTextExtensions == null)
			operationalTextExtensions = new String[] { "qvto" };
		return operationalTextExtensions;
	}

	public static IPreferenceStore getPreferenceStore() {
		QVTUIPlugin plugin = QVTUIPlugin.getDefault();
		if (plugin == null)
			return null;
		return plugin.getPreferenceStore();
	}
	
	public static String getRelationEMOFExtension() {
		return getExtension(getRelationEMOFExtensions());
	}
	
	public static String[] getRelationEMOFExtensions() {
		if (relationEMOFExtensions == null)
			relationEMOFExtensions = getExtensions(QVTPreferenceConstants.P_EMOF_EXTENSIONS.RELATION);
		if (relationEMOFExtensions == null)
			relationEMOFExtensions = new String[] { "qvtrelation" };
		return relationEMOFExtensions;
	}
	
	public static String getRelationEcoreExtension() {
		return getExtension(getRelationEcoreExtensions());
	}
	
	public static String[] getRelationEcoreExtensions() {
		if (relationEcoreExtensions == null)
			relationEcoreExtensions = getExtensions(QVTPreferenceConstants.P_ECORE_EXTENSIONS.RELATION);
		if (relationEcoreExtensions == null)
			relationEcoreExtensions = new String[] { "eqvtrelation" };
		return relationEcoreExtensions;
	}
	
	public static String getRelationTextExtension() {
		return getExtension(getRelationTextExtensions());
	}
	
	public static String[] getRelationTextExtensions() {
		if (relationTextExtensions == null)
			relationTextExtensions = getExtensions(QVTPreferenceConstants.P_TEXT_EXTENSIONS.RELATION);
		if (relationTextExtensions == null)
			relationTextExtensions = new String[] { "qvtr" };
		return relationTextExtensions;
	}
	
	public static String getRepresentation() {
		if (representation == null) {
			IPreferenceStore store = getPreferenceStore();
			if (store == null)
				return null;
			representation = store.getString(QVTPreferenceConstants.P_QVT_REPRESENTATION);
		}
		return representation;
	}

	public static boolean hasExtension(String fileExtension, String[] extensions) {
		if (fileExtension == null)
			return false;
		if (extensions == null)
			return false;
		for (String extension : extensions)
			if (fileExtension.compareToIgnoreCase(extension) == 0)
				return true;
		return false;
	}

	public static boolean hasCoreTextExtension(String fileExtension) {
		return hasExtension(fileExtension, getCoreTextExtensions());
	}

	public static boolean hasKM3TextExtension(String fileExtension) {
		return hasExtension(fileExtension, getKM3TextExtensions());
	}

	public static boolean hasOCLTextExtension(String fileExtension) {
		return hasExtension(fileExtension, getOCLTextExtensions());
	}

	public static boolean hasOperationalTextExtension(String fileExtension) {
		return hasExtension(fileExtension, getOperationalTextExtensions());
	}

	public static boolean hasRelationTextExtension(String fileExtension) {
		return hasExtension(fileExtension, getRelationTextExtensions());
	}
}
