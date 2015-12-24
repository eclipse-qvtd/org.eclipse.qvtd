/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getEvaluationElement()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationElement extends EObject {
	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor);
} // EvaluationElement
