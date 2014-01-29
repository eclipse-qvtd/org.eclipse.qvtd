/**
 * <copyright>
 *
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 176110, 191689 
 *   Zeligsoft - Bug 253512
 *   Borland - Bug 242880
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */

package org.eclipse.qvtd.debug.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class QVTdDebugMessages
{
	static {
		NLS.initializeMessages(QVTdDebugMessages.class.getName(), QVTdDebugMessages.class);
	}
	
	public static String MiscUtil_ErrorMessage;
	public static String ShallowProcess_InvalidState;
	public static String ShallowProcess_Label;
}
