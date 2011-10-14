/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Relation.java,v 1.4 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AtLeastTwoDomains\r\nDomainTypedModelsMatchModelParameters\r\nEveryDomainIsARelationDomain\r\nNonTopLevelIsNotInvokedWarning\r\nRelationImplsAreUniqueWarning\r\nVariablesAreUnique\r\nWhenTypesAreDeclaredByRelation\r\nWhenVariablesAreDefinedByRelation\r\nWhereTypesAreDeclaredByRelation\r\nWhereVariablesAreDefinedByRelation\r\n'"
 * @generated
 */
public interface Relation extends Rule {

	/**
	 * Returns the value of the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top Level</em>' attribute.
	 * @see #isSetIsTopLevel()
	 * @see #unsetIsTopLevel()
	 * @see #setIsTopLevel(boolean)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation_IsTopLevel()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsTopLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #isSetIsTopLevel()
	 * @see #unsetIsTopLevel()
	 * @see #isIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsTopLevel()
	 * @see #isIsTopLevel()
	 * @see #setIsTopLevel(boolean)
	 * @generated
	 */
	void unsetIsTopLevel();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Top Level</em>' attribute is set.
	 * @see #unsetIsTopLevel()
	 * @see #isIsTopLevel()
	 * @see #setIsTopLevel(boolean)
	 * @generated
	 */
	boolean isSetIsTopLevel();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * Returns the value of the '<em><b>Operational Impl</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Impl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Impl</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation_OperationalImpl()
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation#getRelation
	 * @model opposite="relation" containment="true" ordered="false"
	 * @generated
	 */
	EList<RelationImplementation> getOperationalImpl();

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(Pattern)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation_When()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whenOwner'"
	 * @generated
	 */
	Pattern getWhen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Pattern value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(Pattern)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelation_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whereOwner'"
	 * @generated
	 */
	Pattern getWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Relation#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(Pattern value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	RelationalTransformation getRelationalTransformation();

} // Relation
