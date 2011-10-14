/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: QVTCoreMessages.java,v 1.1 2008/12/31 17:41:34 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.operations;

import org.eclipse.osgi.util.NLS;

public class QVTCoreMessages extends NLS
{
	public static String _UI_BottomPattern_RealizedVariableNameIsNotUnique;
	public static String _UI_CorePattern_VariableNameIsNotUnique;
	public static String _UI_PropertyAssignment_PropertyTypeIsNotConsistent;
	public static String _UI_VariableAssignment_VariableTypeIsNotInconsistent;

	static {
		NLS.initializeMessages(QVTCoreMessages.class.getName(), QVTCoreMessages.class);
	}
}