/**
 * <copyright>
 * </copyright>
 *
 * $Id: TestDomain.java,v 1.1 2008/12/31 18:11:05 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestDomain()
 * @model
 * @generated
 */
public interface TestDomain extends Domain {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestDomain_Contents()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<EObject> getContents();

} // TestDomain
