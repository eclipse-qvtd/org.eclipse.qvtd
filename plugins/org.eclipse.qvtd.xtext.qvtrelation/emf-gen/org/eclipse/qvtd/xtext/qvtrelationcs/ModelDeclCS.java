/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getMetamodelIds <em>Metamodel Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getIterates <em>Iterates</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getModelDeclCS()
 * @model
 * @generated
 */
public interface ModelDeclCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Metamodel Ids</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Ids</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Ids</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getModelDeclCS_MetamodelIds()
	 * @model
	 * @generated
	 */
	EList<Namespace> getMetamodelIds();

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getModelDeclCS_DependsOn()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getDependsOn();

	/**
	 * Returns the value of the '<em><b>Iterates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterates</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getModelDeclCS_Iterates()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getIterates();

} // ModelDeclCS
