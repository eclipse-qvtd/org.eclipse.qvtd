/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebasecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS#getUnrealizedVariables <em>Unrealized Variables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getPatternCS()
 * @model abstract="true"
 * @generated
 */
public interface PatternCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unrealized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unrealized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getPatternCS_UnrealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnrealizedVariableCS> getUnrealizedVariables();

} // PatternCS
