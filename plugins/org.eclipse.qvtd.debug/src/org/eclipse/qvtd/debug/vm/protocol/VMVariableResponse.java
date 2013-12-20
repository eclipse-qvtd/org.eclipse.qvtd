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

import org.eclipse.qvtd.debug.vm.VMVariable;


public class VMVariableResponse extends VMResponse {
	
	private static final long serialVersionUID = 4349537265414257787L;

	public final VMVariable variable;
	public final VMVariable[] childVariables;
	
	public VMVariableResponse(VMVariable variable, VMVariable[] childVariables) {
		this.variable = variable;
		this.childVariables = childVariables;
	}
	
	public VMVariableResponse(VMVariable variable) {
		this(variable, null);
	}
}