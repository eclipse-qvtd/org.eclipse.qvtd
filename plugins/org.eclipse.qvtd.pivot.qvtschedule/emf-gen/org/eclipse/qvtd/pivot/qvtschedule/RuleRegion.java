/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.qvtd.pivot.qvtbase.Rule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule <em>Referred Rule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRuleRegion()
 * @model
 * @generated
 */
public interface RuleRegion extends MappingRegion {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRuleRegion_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RuleRegion!name'"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Returns the value of the '<em><b>Referred Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property to navigate from source to target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Rule</em>' reference.
	 * @see #setReferredRule(Rule)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRuleRegion_ReferredRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RuleRegion!referredRule'"
	 * @generated
	 */
	Rule getReferredRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule <em>Referred Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Rule</em>' reference.
	 * @see #getReferredRule()
	 * @generated
	 */
	void setReferredRule(Rule value);

	@Nullable Node getNode(@NonNull TypedElement typedElement);
} // BasicMappingRegion
