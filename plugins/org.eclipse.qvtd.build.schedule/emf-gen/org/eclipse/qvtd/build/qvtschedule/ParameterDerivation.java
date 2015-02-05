/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getPrimaryParameter <em>Primary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getSecondaryParameters <em>Secondary Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getParameterDerivation()
 * @model
 * @generated
 */
public interface ParameterDerivation extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameterDerivations <em>Parameter Derivations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(AbstractAction)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getParameterDerivation_Target()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameterDerivations
	 * @model opposite="parameterDerivations" transient="false"
	 * @generated
	 */
	AbstractAction getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Primary Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Parameter</em>' containment reference.
	 * @see #setPrimaryParameter(DataParameter)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getParameterDerivation_PrimaryParameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataParameter getPrimaryParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getPrimaryParameter <em>Primary Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Parameter</em>' containment reference.
	 * @see #getPrimaryParameter()
	 * @generated
	 */
	void setPrimaryParameter(DataParameter value);

	/**
	 * Returns the value of the '<em><b>Secondary Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivation <em>Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Parameters</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getParameterDerivation_SecondaryParameters()
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivation
	 * @model opposite="derivation" containment="true"
	 * @generated
	 */
	EList<SecondaryParameter> getSecondaryParameters();

} // ParameterDerivation
