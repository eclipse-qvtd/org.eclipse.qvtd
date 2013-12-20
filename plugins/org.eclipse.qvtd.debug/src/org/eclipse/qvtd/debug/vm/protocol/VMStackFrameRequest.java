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


public class VMStackFrameRequest extends VMRequest implements Serializable {

	private static final long serialVersionUID = -870457096053189047L;
	
	public final long frameID;
	
	public final String variableURI;
	
	public VMStackFrameRequest(long frameID) {
		this(frameID, null);
	}
	
	public VMStackFrameRequest(long frameID, String variableURI) {
		this.frameID = frameID;
		this.variableURI = variableURI;
	}
	
	public boolean rootVariablesRequest() {
		return variableURI == null;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "(" + frameID + ", " + variableURI + ")";
	}
}
