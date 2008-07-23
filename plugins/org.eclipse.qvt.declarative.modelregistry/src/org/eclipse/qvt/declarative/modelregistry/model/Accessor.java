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
 * An Accessor defines a key by which models can be accessed in the model registry.
 * The derived class defines the key type or kind and should return a distinctive
 * value as getKind(). The key value should be returned via getName().
 */
public interface Accessor
{
	/**
	 * Return the name by which this kind of accessor is known.  
	 * @return the human friendly accessor class name
	 */
	public String getKind();

	/**
	 * Return the name that is accessed.  
	 * @return the accessed name
	 */
	public String getName();

	/**
	 * Create a new accessor of this kind for a name  
	 * @return the accessor for name
	 * @throws Exception 
	 */
	public Accessor newInstance(String name) throws Exception;
}
