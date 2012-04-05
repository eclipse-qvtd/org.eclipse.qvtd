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

/**
 * Constant definitions for plug-in preferences
 */
public class QVTPreferenceConstants
{
	public static final String P_QVT_REPRESENTATION = "qvtRepresentation";
	
	public static class QVTPreferenceConstantDomain
	{
		public final String CORE;
		public final String KM3;
		public final String OCL;
		public final String OPERATIONAL;
		public final String RELATION;
		
		public QVTPreferenceConstantDomain(String core, String km3, String ocl, String operational, String relation) {
			this.CORE = core;
			this.KM3 = km3;
			this.OCL = ocl;
			this.OPERATIONAL = operational;
			this.RELATION = relation;
		}
	}

	public static final QVTPreferenceConstantDomain P_TEXT_EXTENSIONS = new QVTPreferenceConstantDomain("textQVTcoreExtension", "textKM3Extension", "textOCLExtension", "textQVToperationalExtension", "textQVTrelationExtension");
	public static final QVTPreferenceConstantDomain P_ECORE_EXTENSIONS = new QVTPreferenceConstantDomain("ecoreQVTcoreExtension", "ecoreKM3Extension", "ecoreOCLExtension", "ecoreQVToperationalExtension", "ecoreQVTrelationExtension");
	public static final QVTPreferenceConstantDomain P_EMOF_EXTENSIONS = new QVTPreferenceConstantDomain("emofQVTcoreExtension", "emofKM3Extension", "emofOCLExtension", "emofQVToperationalExtension", "emofQVTrelationExtension");
}
