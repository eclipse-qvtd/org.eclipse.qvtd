/**
 * <copyright>
 * </copyright>
 *
 * $Id: TTransformationToPackage.java,v 1.1 2009/02/24 17:31:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTransformation To Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getRt <em>Rt</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getP <em>P</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTTransformationToPackage()
 * @model
 * @generated
 */
public interface TTransformationToPackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Rt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rt</em>' reference.
	 * @see #setRt(RelationalTransformation)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTTransformationToPackage_Rt()
	 * @model
	 * @generated
	 */
	RelationalTransformation getRt();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getRt <em>Rt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rt</em>' reference.
	 * @see #getRt()
	 * @generated
	 */
	void setRt(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>P</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>P</em>' reference.
	 * @see #setP(EPackage)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTTransformationToPackage_P()
	 * @model
	 * @generated
	 */
	EPackage getP();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getP <em>P</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>P</em>' reference.
	 * @see #getP()
	 * @generated
	 */
	void setP(EPackage value);

} // TTransformationToPackage
