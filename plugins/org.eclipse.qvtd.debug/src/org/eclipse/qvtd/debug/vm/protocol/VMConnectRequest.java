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



public class VMConnectRequest extends VMRequest {
	
	private static final long serialVersionUID = -1112681920766060737L;

	
	public VMConnectRequest() {
		super();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName(); 
	}
}
