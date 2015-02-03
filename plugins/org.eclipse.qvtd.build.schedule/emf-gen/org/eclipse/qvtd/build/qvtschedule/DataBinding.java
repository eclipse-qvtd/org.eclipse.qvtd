/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataBinding#getSourceExp <em>Source Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataBinding#getTargetDataParameter <em>Target Data Parameter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataBinding()
 * @model
 * @generated
 */
public interface DataBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Exp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Exp</em>' reference.
	 * @see #setSourceExp(OCLExpression)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataBinding_SourceExp()
	 * @model
	 * @generated
	 */
	OCLExpression getSourceExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataBinding#getSourceExp <em>Source Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Exp</em>' reference.
	 * @see #getSourceExp()
	 * @generated
	 */
	void setSourceExp(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Target Data Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Data Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Data Parameter</em>' reference.
	 * @see #setTargetDataParameter(DataParameter)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataBinding_TargetDataParameter()
	 * @model
	 * @generated
	 */
	DataParameter getTargetDataParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataBinding#getTargetDataParameter <em>Target Data Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Data Parameter</em>' reference.
	 * @see #getTargetDataParameter()
	 * @generated
	 */
	void setTargetDataParameter(DataParameter value);

} // DataBinding
