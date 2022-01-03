/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp()
 * @model
 * @generated
 */
public interface RelationCallExp extends OCLExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp_Argument()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='relationCallExp'"
	 * @generated
	 */
	EList<OCLExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Referred Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Relation</em>' reference.
	 * @see #setReferredRelation(Relation)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationCallExp_ReferredRelation()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='relationCallExp'"
	 * @generated
	 */
	Relation getReferredRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Relation</em>' reference.
	 * @see #getReferredRelation()
	 * @generated
	 */
	void setReferredRelation(Relation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MatchingArgumentCount'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tself.argument-&gt;size() = self.referredRelation.domain.oclAsType(RelationDomain).rootVariable-&gt;size()\n'"
	 * @generated
	 */
	boolean validateMatchingArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='WhereInvocationIsANonTopRelation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tlet pattern : qvtbase::Pattern = self-&gt;asOrderedSet()-&gt;closure(e : ocl::OclElement | e.oclContainer())-&gt;selectByKind(qvtbase::Pattern)-&gt;first() in\n    let relation : Relation = pattern-&gt;asOrderedSet()-&gt;closure(e : ocl::OclElement | e.oclContainer())-&gt;selectByKind(Relation)-&gt;first() in\n\trelation._where = pattern implies not referredRelation.isTopLevel\n'"
	 * @generated
	 */
	boolean validateWhereInvocationIsANonTopRelation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataTypeInvocationIsANonTopRelation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tself.argument-&gt;exists(type.oclIsKindOf(pivot::DataType) and not type.oclIsKindOf(pivot::CollectionType))\n\timplies not referredRelation.isTopLevel\n\n'"
	 * @generated
	 */
	boolean validateDataTypeInvocationIsANonTopRelation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationCallExp
