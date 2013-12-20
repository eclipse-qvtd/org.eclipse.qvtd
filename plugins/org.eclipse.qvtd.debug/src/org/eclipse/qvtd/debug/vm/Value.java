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
package org.eclipse.qvtd.debug.vm;

import java.io.Serializable;

public class Value implements Serializable {
	
	public static class Type implements Serializable {		
		private static final long serialVersionUID = 7495906714815485400L;		
	
		public static final int DATATYPE = 0;
		public static final int EOBJECT = 1;		
		public static final int COLLECTION = 2;
		
		public final String declaringType;
		public final String actualType;
		public final int kind;
		
		public Type(int kind, String actualType, String declaringType) {
			this.kind = kind;
			this.declaringType = declaringType;
			this.actualType = actualType;
		}		
	}

	private static final long serialVersionUID = 6197087566347216082L;
	
	public static final int PRIMITIVE = 0;		
	public static final int OBJECT_REF = 1;
	public static final int COLLECTION_REF = 2;
	public static final int INVALID = 3;
	
	public final int kind;
	public final Object value;
	public final boolean hasVariables;
	
	public Value(int kind, String value) {
		this(kind, value, false);
	}
	
	public Value(int kind, String value, boolean hasVariables) {
		this.kind = kind;
		this.value = value;
		this.hasVariables = hasVariables;
	}

	public static Value invalid() {
		return new Value(INVALID, "OclInvalid"); //$NON-NLS-1$
	}
}