/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Obeo - New File Wizard
 *******************************************************************************/
package org.eclipse.qvtd.umlx.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class UMLXUIMessages
{
	static {
		NLS.initializeMessages(UMLXUIMessages.class.getName(), UMLXUIMessages.class);
	}

	public static String SaveUMLX_ShellTitle;
	public static String SaveUMLX_Title;
	public static String SaveUMLX_Description;
	public static String SaveError_Title;
}
