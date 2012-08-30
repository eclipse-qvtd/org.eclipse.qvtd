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
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getModelDecls <em>Model Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getKeyDecls <em>Key Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends PackageCS {
	/**
	 * Returns the value of the '<em><b>Model Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Decls</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS_ModelDecls()
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
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS_Extends()
	 * @model
	 * @generated
	 */
	EList<Transformation> getExtends();

	/**
	 * Returns the value of the '<em><b>Key Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Decls</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS_KeyDecls()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyDeclCS> getKeyDecls();

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getQueries();

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getTransformationCS_Relation()
	 * @model containment="true"
	 * @generated
	 */
	EList<RelationCS> getRelation();

} // TransformationCS
