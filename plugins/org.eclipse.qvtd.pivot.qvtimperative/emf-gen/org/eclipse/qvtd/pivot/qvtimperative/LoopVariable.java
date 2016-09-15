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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop <em>Owning Mapping Loop</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getLoopVariable()
 * @generated
 */
public interface LoopVariable extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Owning Mapping Loop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Mapping Loop</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Mapping Loop</em>' container reference.
	 * @see #setOwningMappingLoop(MappingLoop)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getLoopVariable_OwningMappingLoop()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators
	 * @generated
	 */
	MappingLoop getOwningMappingLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop <em>Owning Mapping Loop</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping Loop</em>' container reference.
	 * @see #getOwningMappingLoop()
	 * @generated
	 */
	void setOwningMappingLoop(MappingLoop value);

} // LoopVariable
