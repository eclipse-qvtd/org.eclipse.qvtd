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

public class VMValue implements Serializable
{
	private static final long serialVersionUID = 875965513717520820L;

	public static final int PRIMITIVE = 0;		
	public static final int OBJECT_REF = 1;
	public static final int COLLECTION_REF = 2;
	public static final int INVALID = 3;
	public static final int RESOURCE = 4;

	public static @NonNull String toValueString(int status) {
		switch (status) {
		case PRIMITIVE: return "PRIMITIVE";
		case OBJECT_REF: return "OBJECT_REF";
		case COLLECTION_REF: return "COLLECTION_REF";
		case INVALID: return "INVALID";
		case RESOURCE: return "RESOURCE";
		}
		return "???";
	}
	
	public final int kind;
	public final Object value;
	public final boolean hasVariables;
	
	public VMValue(int kind, String value) {
		this(kind, value, false);
	}
	
	public VMValue(int kind, String value, boolean hasVariables) {
		this.kind = kind;
		this.value = value;
		this.hasVariables = hasVariables;
	}

	public static VMValue invalid() {
		return new VMValue(INVALID, "OclInvalid"); //$NON-NLS-1$
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toValueString(kind) + ", " + value + ")";
	}	
}