/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS#getModelDecls <em>Model Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS#getKeyDecls <em>Key Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends ClassCS {
	/**
	 * Returns the value of the '<em><b>Model Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ModelDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Decls</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS_ModelDecls()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelDeclCS> getModelDecls();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Transformation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS_Extends()
	 * @model
	 * @generated
	 */
	EList<Transformation> getExtends();

	/**
	 * Returns the value of the '<em><b>Key Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.KeyDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Decls</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS_KeyDecls()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyDeclCS> getKeyDecls();

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getQueries();

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.RelationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTransformationCS_Relation()
	 * @model containment="true"
	 * @generated
	 */
	EList<RelationCS> getRelation();

} // TransformationCS
