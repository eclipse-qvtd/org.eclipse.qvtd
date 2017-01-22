/**
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.resource;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * The <b>Resource Factory</b> associated with the package.
 * @see org.eclipse.qvtd.umlx.utilities.UMLXResourceImpl
 */
public class UMLXResourceFactoryImpl extends ResourceFactoryImpl
{
	/**
	 * Creates an instance of the resource factory.
	 */
	public UMLXResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new UMLXResourceImpl(uri);
		return result;
	}
}
