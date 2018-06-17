/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Obeo - New File Wizard
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class QVTdBaseUIMessages
{
	static {
		NLS.initializeMessages(QVTdBaseUIMessages.class.getName(), QVTdBaseUIMessages.class);
	}

	public static String QVTdNatureAddingEditorCallback_MessageDialog_Message;
	public static String QVTdNatureAddingEditorCallback_MessageDialog_Title;
}
