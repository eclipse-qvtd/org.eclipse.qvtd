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
package org.eclipse.qvtd.debug.vm.protocol;

public class VMTerminateEvent extends VMEvent {

	private static final long serialVersionUID = 8606236775842913079L;

	private int fExitCode;
	

	public VMTerminateEvent(int exitCode) {
		fExitCode = exitCode;
	}
	
	public int getExitCode() {
		return fExitCode;
	}

}