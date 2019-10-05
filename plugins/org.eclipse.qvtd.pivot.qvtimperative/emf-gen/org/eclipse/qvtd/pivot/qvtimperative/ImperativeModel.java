/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameAdapter;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Model of an Imperative QVT transformation.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeModel()
 * @generated
 */
public interface ImperativeModel extends BaseModel {

	@NonNull SymbolNameAdapter getSymbolNameAdapter();						// FIXME promote to Model/ModelImpl
	@NonNull String reserveSymbolName(@NonNull SymbolNameBuilder s, @NonNull Object object);
} // ImperativeModel
