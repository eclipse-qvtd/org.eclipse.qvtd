/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DispatchRegion provides a graphical representation of an executable mapping that dispatches a hierrachy of QVTr Relations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion <em>Referred Rule Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDispatchRegion()
 * @model
 * @generated
 */
public interface DispatchRegion extends RuleRegion {
	/**
	 * Returns the value of the '<em><b>Referred Rule Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Rule represented by this RuleRegion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Rule Region</em>' reference.
	 * @see #setReferredRuleRegion(RuleRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getDispatchRegion_ReferredRuleRegion()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!DispatchRegion!referredRuleRegion'"
	 * @generated
	 */
	RuleRegion getReferredRuleRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion <em>Referred Rule Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Rule Region</em>' reference.
	 * @see #getReferredRuleRegion()
	 * @generated
	 */
	void setReferredRuleRegion(RuleRegion value);

} // DispatchRegion
