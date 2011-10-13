/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.pivot.Namespace;

import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.PackageRefCS#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.PackageRefCS#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getPackageRefCS()
 * @model
 * @generated
 */
public interface PackageRefCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getPackageRefCS_Namespace()
	 * @model
	 * @generated
	 */
	EList<Namespace> getNamespace();

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getPackageRefCS_Element()
	 * @model
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.PackageRefCS#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(org.eclipse.ocl.examples.pivot.Package value);

} // PackageRefCS
