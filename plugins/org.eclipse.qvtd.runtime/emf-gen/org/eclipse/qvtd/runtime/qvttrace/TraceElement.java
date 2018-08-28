/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.runtime.qvttrace;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.runtime.qvttrace.util.QVTtraceVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Element</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * @extends org.eclipse.qvtd.runtime.qvttrace.util.TraceVisitable
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceElement()
 * @model abstract="true"
 * @generated
 */
public interface TraceElement extends EObject, org.eclipse.ocl.pivot.utilities.Nameable, org.eclipse.qvtd.runtime.qvttrace.util.TraceVisitable {

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	@Override
	public <R> R accept(@NonNull QVTtraceVisitor<R> visitor);

} // TraceElement
