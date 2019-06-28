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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getOppositePart <em>Opposite Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getKey()
 * @model
 * @generated
 */
public interface Key extends Element {
	/**
	 * Returns the value of the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifies</em>' reference.
	 * @see #setIdentifies(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getKey_Identifies()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='key'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getIdentifies();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifies</em>' reference.
	 * @see #getIdentifies()
	 * @generated
	 */
	void setIdentifies(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getKey_Part()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='key'"
	 * @generated
	 */
	EList<Property> getPart();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(RelationalTransformation)
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getKey_Transformation()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey
	 * @model opposite="ownedKey"
	 * @generated
	 */
	RelationalTransformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(RelationalTransformation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='IdentifiesIsNotAbstract'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\t\t\t-- see Bugzilla 512532 discussion\n\tnot identifies.isAbstract\n\n'"
	 * @generated
	 */
	boolean validateIdentifiesIsNotAbstract(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='IdentifiesIsAUsedPackageClass'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttransformation&lt;&gt; null implies transformation.modelParameter.usedPackage-&gt;includes(identifies.owningPackage)\n\n'"
	 * @generated
	 */
	boolean validateIdentifiesIsAUsedPackageClass(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NoSuperKeys'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\t\t\t-- see Bugzilla 512532 discussion\n\ttransformation &lt;&gt; null implies \n\tlet superClasses = identifies.superClasses-&gt;closure(superClasses) in\n\tlet otherKeys = transformation?.ownedKey?-&gt;excluding(self) in\n\totherKeys.identifies-&gt;excludesAll(superClasses)\n\n'"
	 * @generated
	 */
	boolean validateNoSuperKeys(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='IdentifiesIsUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\ttransformation &lt;&gt; null implies \n\tlet otherKeys = transformation?.ownedKey?-&gt;excluding(self) in\n\totherKeys.identifies-&gt;excludes(identifies)\n\n'"
	 * @generated
	 */
	boolean validateIdentifiesIsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OppositePartsHaveOpposites'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\toppositePart-&gt;forAll(opposite &lt;&gt; null)\n\n'"
	 * @generated
	 */
	boolean validateOppositePartsHaveOpposites(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OppositePartsAreOppositeParts'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\toppositePart-&gt;forAll(self.identifies.conformsTo(type))\n\n'"
	 * @generated
	 */
	boolean validateOppositePartsAreOppositeParts(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='PartsAreParts'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tpart-&gt;forAll(self.identifies.conformsTo(owningClass))\n\n'"
	 * @generated
	 */
	boolean validatePartsAreParts(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='PartsAreUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tpart-&gt;excludesAll(oppositePart.opposite)\n\n'"
	 * @generated
	 */
	boolean validatePartsAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Opposite Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Part</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getKey_OppositePart()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='oppKey'"
	 * @generated
	 */
	EList<Property> getOppositePart();

} // Key
