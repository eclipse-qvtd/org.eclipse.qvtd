/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseHelper;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;

/**
 * QVTimperativeHelper provides helper routines to assist creation of QVTimperative model elements.
 */
public class QVTimperativeHelper extends QVTcoreBaseHelper
{
	public QVTimperativeHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull ConnectionAssignment createConnectionAssignment(@NonNull ConnectionVariable connectionVariable, @NonNull OCLExpression childrenExpression) {
		ConnectionAssignment connectionAssignment = QVTimperativeFactory.eINSTANCE.createConnectionAssignment();
		connectionAssignment.setTargetVariable(connectionVariable);
		connectionAssignment.setValue(childrenExpression);
		return connectionAssignment;
	}

	public @NonNull ConnectionVariable createConnectionVariable(@NonNull String name, @NonNull Type asType, @Nullable OCLExpression initExpression) {
		ConnectionVariable asVariable = QVTimperativeFactory.eINSTANCE.createConnectionVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(true);
		asVariable.setOwnedInit(initExpression);
		return asVariable;
	}
}