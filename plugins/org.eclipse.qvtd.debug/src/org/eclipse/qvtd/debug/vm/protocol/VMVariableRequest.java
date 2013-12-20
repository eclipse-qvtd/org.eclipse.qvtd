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

import java.io.Serializable;


public class VMVariableRequest extends VMRequest implements Serializable {

	private static final long serialVersionUID = -5791928039344216899L;

	public final String variableURI;
	public final long frameID;
	public final boolean includeChildVars;
	
	public VMVariableRequest(long frameID, String variableURI, boolean includeChildVars) {
		this.frameID = frameID;
		this.variableURI = variableURI;
		this.includeChildVars = includeChildVars;
	}
	
	public VMVariableRequest(long frameID, String variableURI) {
		this(frameID, variableURI, false);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + frameID + "," + variableURI + ", " + includeChildVars + ")";
	}
}
