/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.modelregistry.model;

/**
 * An UnregisteredAccessor defines a key to access model registry entries by an 
 * unregistered accessor kind.
 */
public class UnregisteredAccessor implements Accessor
{
	private final String kind;
	private final String name;
	
	public UnregisteredAccessor(String kind, String name) {
		this.kind = kind;
		this.name = name;
	}

	public String getKind() { return kind; }
	public String getName() { return name; }
	
	@Override public String toString() { return name; }

	public Accessor newInstance(String name) throws Exception {
		throw new UnsupportedOperationException(getClass().getName() + ".newInstance");
	}
}
