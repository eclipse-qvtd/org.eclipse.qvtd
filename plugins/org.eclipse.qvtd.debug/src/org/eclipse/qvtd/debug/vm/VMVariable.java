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

import org.eclipse.jdt.annotation.NonNull;

public class VMVariable implements Serializable {
	
	private static final long serialVersionUID = -7174716073141901340L;
	
	public static final int LOCAL = 0;
	public static final int ATTRIBUTE = 1;
	public static final int REFERENCE = 2;
	public static final int PREDEFINED_VAR = 3;
	public static final int MODEL_PARAMETER = 4;
	public static final int INTERM_PROPERTY = 5;
	public static final int COLLECTION_ELEMENT = 6;

	public static @NonNull String toKindString(int kind) {
		switch (kind) {
		case LOCAL: return "LOCAL";
		case ATTRIBUTE: return "ATTRIBUTE";
		case REFERENCE: return "REFERENCE";
		case PREDEFINED_VAR: return "PREDEFINED_VAR";
		case MODEL_PARAMETER: return "MODEL_PARAMETER";
		case INTERM_PROPERTY: return "INTERM_PROPERTY";
		case COLLECTION_ELEMENT: return "COLLECTION_ELEMENT";
		}
		return "???";
	}
	
	public String name;
	public String variableURI;
	public Value value;
	public Object valueObject;
	public Value.Type type;
	public int kind;
	
	public VMVariable() {
		super();
	}
	
	public boolean isRootVariable() {
		return variableURI == null;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(").append(toKindString(kind));
		s.append(",").append(variableURI);
		s.append(",").append(name);
		s.append(":").append(type);
		s.append("=").append(valueObject);
		s.append(")");
		return s.toString();
	}
}