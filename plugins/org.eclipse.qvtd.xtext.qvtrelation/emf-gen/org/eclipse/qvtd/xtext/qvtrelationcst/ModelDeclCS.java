/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS#getMetaModelIds <em>Meta Model Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getModelDeclCS()
 * @model
 * @generated
 */
public interface ModelDeclCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Meta Model Ids</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Ids</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Ids</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getModelDeclCS_MetaModelIds()
	 * @model
	 * @generated
	 */
	EList<Namespace> getMetaModelIds();

} // ModelDeclCS
