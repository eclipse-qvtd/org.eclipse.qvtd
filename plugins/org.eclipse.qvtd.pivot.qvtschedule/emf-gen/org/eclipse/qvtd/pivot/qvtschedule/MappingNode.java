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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingNode may contribute to a MappingRegion in a QBTs graph.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingNode()
 * @model abstract="true"
 * @generated
 */
public interface MappingNode extends Node {
	void setOriginatingElement(@NonNull Element originatingElement);

} // MappingNode
