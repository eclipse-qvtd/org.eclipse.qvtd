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


public class VMConnectResponse extends VMResponse
{
	private static final long serialVersionUID = -5645434708867846363L;

	private final int fEventPort;
	
	public VMConnectResponse(int eventPort) {
		fEventPort = eventPort;
	}
	
	public int getEventPort() {
		return fEventPort;
	}
	

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toStatusString(status) + ", " + fEventPort + ")";  //$NON-NLS-1$
	}
}