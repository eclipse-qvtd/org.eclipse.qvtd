package org.eclipse.qvtd.debug.utils;
/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/


public class QVTODebugOptions {

	private QVTODebugOptions() {
		super();
	}

	public static final String DEBUG = QVTODebugCore.PLUGIN_ID + "/debug"; //$NON-NLS-1$

	/**
	 * Trace QVTO debug target
	 */
	public static final String TARGET = "target"; //$NON-NLS-1$

	/**
	 * Trace QVTO virtual machine
	 */
	public static final String VM = "vm"; //$NON-NLS-1$

	/**
	 * Trace QVTO debug evaluator
	 */
	public static final String EVALUATOR = "evaluator"; //$NON-NLS-1$

	public static final String EXCEPTIONS_CATCHING = DEBUG
			+ "/exceptions/catching"; //$NON-NLS-1$
	public static final String EXCEPTIONS_THROWING = DEBUG
			+ "/exceptions/throwing"; //$NON-NLS-1$

	public static final String METHODS_ENTERING = DEBUG + "/methods/entering"; //$NON-NLS-1$
	public static final String METHODS_EXITING = DEBUG + "/methods/exiting"; //$NON-NLS-1$
}
