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
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * The <b>Resource </b> associated with the package.
 * @see org.eclipse.qvtd.umlx.resource.UMLXResourceFactoryImpl
 */
public class UMLXResourceImpl extends XMIResourceImpl
{
	/**
	 * Creates an instance of the resource.
	 *
	 * @param uri the URI of the new resource.
	 */
	public UMLXResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLSave createXMLSave() {
		return new UMLXSaveImpl(new XMIHelperImpl(this));
	}
}
