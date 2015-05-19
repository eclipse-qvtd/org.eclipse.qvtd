/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.schedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Derivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getPrimaryParameter <em>Primary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getSecondaryParameter <em>Secondary Parameter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getParameterDerivation()
 * @model
 * @generated
 */
public interface ParameterDerivation extends ScheduleElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractAction#getParameterDerivations <em>Parameter Derivations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(AbstractAction)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getParameterDerivation_Target()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractAction#getParameterDerivations
	 * @model opposite="parameterDerivations" transient="false"
	 * @generated
	 */
	AbstractAction getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Primary Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Parameter</em>' reference.
	 * @see #setPrimaryParameter(DataParameter)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getParameterDerivation_PrimaryParameter()
	 * @model
	 * @generated
	 */
	DataParameter getPrimaryParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getPrimaryParameter <em>Primary Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Parameter</em>' reference.
	 * @see #getPrimaryParameter()
	 * @generated
	 */
	void setPrimaryParameter(DataParameter value);

	/**
	 * Returns the value of the '<em><b>Secondary Parameter</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivation <em>Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Parameter</em>' containment reference.
	 * @see #setSecondaryParameter(SecondaryParameter)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getParameterDerivation_SecondaryParameter()
	 * @see org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivation
	 * @model opposite="derivation" containment="true"
	 * @generated
	 */
	SecondaryParameter getSecondaryParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getSecondaryParameter <em>Secondary Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Parameter</em>' containment reference.
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	void setSecondaryParameter(SecondaryParameter value);

} // ParameterDerivation
