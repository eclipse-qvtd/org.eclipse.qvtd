/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedVarDeclarations <em>Owned Var Declarations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhen <em>Owned When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhere <em>Owned Where</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS()
 * @model
 * @generated
 */
public interface RelationCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_IsAbstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Top</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top</em>' attribute.
	 * @see #setIsTop(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_IsTop()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsTop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsTop <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top</em>' attribute.
	 * @see #isIsTop()
	 * @generated
	 */
	void setIsTop(boolean value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' reference.
	 * @see #setOverridden(Relation)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_Overridden()
	 * @model
	 * @generated
	 */
	Relation getOverridden();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOverridden <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' reference.
	 * @see #getOverridden()
	 * @generated
	 */
	void setOverridden(Relation value);

	/**
	 * Returns the value of the '<em><b>Owned Var Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Var Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Var Declarations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_OwnedVarDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VarDeclarationCS> getOwnedVarDeclarations();

	/**
	 * Returns the value of the '<em><b>Owned Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Domains</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_OwnedDomains()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractDomainCS> getOwnedDomains();

	/**
	 * Returns the value of the '<em><b>Owned When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned When</em>' containment reference.
	 * @see #setOwnedWhen(PatternCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_OwnedWhen()
	 * @model containment="true"
	 * @generated
	 */
	PatternCS getOwnedWhen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhen <em>Owned When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned When</em>' containment reference.
	 * @see #getOwnedWhen()
	 * @generated
	 */
	void setOwnedWhen(PatternCS value);

	/**
	 * Returns the value of the '<em><b>Owned Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Where</em>' containment reference.
	 * @see #setOwnedWhere(PatternCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getRelationCS_OwnedWhere()
	 * @model containment="true"
	 * @generated
	 */
	PatternCS getOwnedWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhere <em>Owned Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Where</em>' containment reference.
	 * @see #getOwnedWhere()
	 * @generated
	 */
	void setOwnedWhere(PatternCS value);

} // RelationCS
