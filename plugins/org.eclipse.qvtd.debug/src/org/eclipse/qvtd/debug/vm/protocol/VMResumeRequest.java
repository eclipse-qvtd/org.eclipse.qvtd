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


public class VMResumeRequest extends VMRequest {
	
	private static final long serialVersionUID = 7434621076114466548L;
	
	public final int detail;
	
	public VMResumeRequest(int detail) {
		super();
		this.detail = detail;
	}
}