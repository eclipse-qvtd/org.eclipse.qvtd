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

import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Secondary Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#isIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDataParameter <em>Data Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivationProperty <em>Derivation Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSecondaryParameter()
 * @model
 * @generated
 */
public interface SecondaryParameter extends ScheduleElement {
	/**
	 * Returns the value of the '<em><b>Is Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Loop</em>' attribute.
	 * @see #setIsLoop(boolean)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSecondaryParameter_IsLoop()
	 * @model
	 * @generated
	 */
	boolean isIsLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#isIsLoop <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Loop</em>' attribute.
	 * @see #isIsLoop()
	 * @generated
	 */
	void setIsLoop(boolean value);

	/**
	 * Returns the value of the '<em><b>Data Parameter</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getSecondaryParameter <em>Secondary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Parameter</em>' reference.
	 * @see #setDataParameter(DataParameter)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSecondaryParameter_DataParameter()
	 * @see org.eclipse.qvtd.pivot.schedule.DataParameter#getSecondaryParameter
	 * @model opposite="secondaryParameter" required="true"
	 * @generated
	 */
	DataParameter getDataParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDataParameter <em>Data Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Parameter</em>' reference.
	 * @see #getDataParameter()
	 * @generated
	 */
	void setDataParameter(DataParameter value);

	/**
	 * Returns the value of the '<em><b>Derivation Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivation Property</em>' reference.
	 * @see #setDerivationProperty(Property)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSecondaryParameter_DerivationProperty()
	 * @model
	 * @generated
	 */
	Property getDerivationProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivationProperty <em>Derivation Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivation Property</em>' reference.
	 * @see #getDerivationProperty()
	 * @generated
	 */
	void setDerivationProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Derivation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getSecondaryParameter <em>Secondary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivation</em>' container reference.
	 * @see #setDerivation(ParameterDerivation)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSecondaryParameter_Derivation()
	 * @see org.eclipse.qvtd.pivot.schedule.ParameterDerivation#getSecondaryParameter
	 * @model opposite="secondaryParameter" transient="false"
	 * @generated
	 */
	ParameterDerivation getDerivation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDerivation <em>Derivation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivation</em>' container reference.
	 * @see #getDerivation()
	 * @generated
	 */
	void setDerivation(ParameterDerivation value);

} // SecondaryParameter
