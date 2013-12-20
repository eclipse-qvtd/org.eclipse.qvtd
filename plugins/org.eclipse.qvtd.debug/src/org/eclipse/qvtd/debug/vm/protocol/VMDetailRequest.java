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

import org.eclipse.emf.common.util.URI;

public class VMDetailRequest extends VMRequest {

	private static final long serialVersionUID = -5178607839378495025L;

	private final String fVariableURI;
	
	public VMDetailRequest(URI variableURI) {
		if(variableURI == null) {
			throw new IllegalArgumentException();
		}
		
		fVariableURI = variableURI.toString();
	}

	public URI getVariableURI() {
		return URI.createURI(fVariableURI);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + fVariableURI + ")"; //$NON-NLS-1$
	}
}
