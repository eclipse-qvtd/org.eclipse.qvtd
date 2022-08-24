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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation()
 * @model
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
	 * @see #setIsTopLevel(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_IsTopLevel()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsTopLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #isIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Operational Impl</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Impl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Impl</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_OperationalImpl()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation
	 * @model opposite="relation" containment="true" ordered="false"
	 * @generated
	 */
	EList<RelationImplementation> getOperationalImpl();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariable();

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
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_When()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whenOwner'"
	 * @generated
	 */
	Pattern getWhen();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}' containment reference.
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
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelation_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='whereOwner'"
	 * @generated
	 */
	Pattern getWhere();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}' containment reference.
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
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DomainsAreRelationDomains'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tdomain-&gt;forAll(oclIsKindOf(RelationDomain))\n'"
	 * @generated
	 */
	boolean validateDomainsAreRelationDomains(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TopRelationOverriddenByTopRelation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\toverridden &lt;&gt; null and not overridden.oclAsType(Relation).isTopLevel implies not isTopLevel\n\n'"
	 * @generated
	 */
	boolean validateTopRelationOverriddenByTopRelation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TransformationIsRelationalTransformation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttransformation.oclIsKindOf(RelationalTransformation)\n\n'"
	 * @generated
	 */
	boolean validateTransformationIsRelationalTransformation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='VariablesAreUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = let namesBag = variable-&gt;collect(name) in\n\tlet namesSet= namesBag-&gt;asSet() in\n\tlet multiNames = namesSet-&gt;select(n | namesBag-&gt;count(n) &gt; 1)-&gt;sortedBy(n | n) in\n\t\'Relation::VariablesAreUnique: Multiple definitions of \' + multiNames-&gt;iterate(b ; acc = \'\' |\n\t\tlet s = if b &lt;&gt; null then \'\"\' + b + \'\"\' else \'null\' endif in\n\t\tif acc &lt;&gt; \'\' then acc + \',\' + s else s endif) + \' in \"\' + transformation.name + \'::\' + name + \'\"\',\n\tstatus : Boolean = \n\tvariable-&gt;isUnique(name)\n\n\n}.status'"
	 * @generated
	 */
	boolean validateVariablesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Relation
