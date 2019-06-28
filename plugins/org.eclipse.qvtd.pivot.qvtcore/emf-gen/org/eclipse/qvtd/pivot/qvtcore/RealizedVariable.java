/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Realized Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getRealizedVariable()
 * @model
 * @generated
 */
public interface RealizedVariable extends Variable {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NonDataTypeForType'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='not type.oclIsKindOf(ocl::DataType)\n\n'"
	 * @generated
	 */
	boolean validateNonDataTypeForType(DiagnosticChain diagnostics, Map<Object, Object> context);
} // RealizedVariable
