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
 * A ModelNameAccesor defines a key to access model registry entries by an informal
 * model name.
 */
public class ModelNameAccessor implements Accessor
{
	public static final String KIND = "Model Name";

	private final String name;
	
	public ModelNameAccessor() {
		this.name = "<prototype>";
	}
	
	public ModelNameAccessor(String name) {
		this.name = name;
	}

	@Override public boolean equals(Object object) {
		if (!(object instanceof ModelNameAccessor))
			return false;
		return name.equals(((ModelNameAccessor)object).getName());
	}

	public String getKind() { return KIND; }
	public String getName() { return name; }

	public ModelNameAccessor newInstance(String name) throws Exception {
		return new ModelNameAccessor(name);
	}
	
	@Override public String toString() { return name; }
}
