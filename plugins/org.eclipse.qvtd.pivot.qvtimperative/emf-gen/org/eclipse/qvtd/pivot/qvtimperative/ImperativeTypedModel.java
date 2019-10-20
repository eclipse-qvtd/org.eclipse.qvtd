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
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ImperativeTypedModel defines an input,middle or output modek for the transformation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsOutput <em>Is Output</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#getAllUsedPackages <em>All Used Packages</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel()
 * @generated
 */
public interface ImperativeTypedModel extends TypedModel {
	/**
	 * Returns the value of the '<em><b>Is Input</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True for an input model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Input</em>' attribute.
	 * @see #setIsInput(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel_IsInput()
	 * @generated
	 */
	boolean isIsInput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsInput <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Input</em>' attribute.
	 * @see #isIsInput()
	 * @generated
	 */
	void setIsInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Output</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True for an output model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Output</em>' attribute.
	 * @see #setIsOutput(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel_IsOutput()
	 * @generated
	 */
	boolean isIsOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsOutput <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Output</em>' attribute.
	 * @see #isIsOutput()
	 * @generated
	 */
	void setIsOutput(boolean value);

	/**
	 * Returns the value of the '<em><b>All Used Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Used Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Used Packages</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel_AllUsedPackages()
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Package> getAllUsedPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNotBothInputAndOutput(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ImperativeTypedModel
