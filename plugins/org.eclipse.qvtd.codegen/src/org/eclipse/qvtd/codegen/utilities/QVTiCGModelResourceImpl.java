/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiCG2StringVisitor;

/**
 * The <b>Resource </b> associated with the package.
 */
public class QVTiCGModelResourceImpl extends XMIResourceImpl
{
	/**
	 * Creates an instance of the resource.
	 */
	public QVTiCGModelResourceImpl(URI uri) {
		super(uri);
		eAdapters().add(QVTiCG2StringVisitor.FACTORY);
	}
} //CGModelResourceImpl
