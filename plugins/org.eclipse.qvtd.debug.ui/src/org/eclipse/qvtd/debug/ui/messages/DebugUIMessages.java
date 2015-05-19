/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.messages;

import org.eclipse.osgi.util.NLS;

public class DebugUIMessages
{
	static {
		NLS.initializeMessages(DebugUIMessages.class.getName(), DebugUIMessages.class);
	}

	public static String QVTiMainTab_mustRunAsQVTApp;

	public static String ModifiedSourceFileHandler_HotReplaceNotSupported;

	public static String ModifiedSourceFileHandler_ModifiedDebuggedSource;
}
