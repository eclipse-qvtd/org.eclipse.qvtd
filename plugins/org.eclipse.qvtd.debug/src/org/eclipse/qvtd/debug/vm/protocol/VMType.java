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

import org.eclipse.jdt.annotation.NonNull;

public class VMType implements Serializable
{		
	private static final long serialVersionUID = -966391641921455730L;
	
	public static final int DATATYPE = 0;
	public static final int EOBJECT = 1;		
	public static final int COLLECTION = 2;
	public static final int RESOURCE = 3;

	public static @NonNull String toTypeString(int status) {
		switch (status) {
		case DATATYPE: return "DATATYPE";
		case EOBJECT: return "EOBJECT";
		case COLLECTION: return "COLLECTION";
		case RESOURCE: return "RESOURCE";
		}
		return "???";
	}
	
	public final String declaringType;
	public final String actualType;
	public final int kind;
	
	public VMType(int kind, String actualType, String declaringType) {
		this.kind = kind;
		this.declaringType = declaringType;
		this.actualType = actualType;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toTypeString(kind) + ", " + declaringType + ", " + actualType + ")";
	}	
}