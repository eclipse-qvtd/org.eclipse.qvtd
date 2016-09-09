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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;

/**
 * QVTimperativeHelper provides helper routines to assist creation of QVTimperative model elements.
 */
public class QVTimperativeHelper extends QVTbaseHelper
{
	public QVTimperativeHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull AddStatement createAddStatement(@NonNull ConnectionVariable connectionVariable, @NonNull OCLExpression childrenExpression) {
		AddStatement addStatement = QVTimperativeFactory.eINSTANCE.createAddStatement();
		addStatement.setTargetVariable(connectionVariable);
		addStatement.setValue(childrenExpression);
		return addStatement;
	}

	public @NonNull ConnectionVariable createConnectionVariable(@NonNull String name, @NonNull Type asType, @Nullable OCLExpression initExpression) {
		ConnectionVariable asVariable = QVTimperativeFactory.eINSTANCE.createConnectionVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(true);
		asVariable.setOwnedInit(initExpression);
		return asVariable;
	}

	public @NonNull NewStatement createNewStatement(@NonNull String name, @NonNull TypedModel typedModel, @NonNull Type type) {
		return QVTimperativeUtil.createNewStatement(name, typedModel, type);
	}

	public @NonNull SetStatement createSetStatement(@NonNull Variable asVariable, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression) {
		return QVTimperativeUtil.createSetStatement(asVariable, asProperty, asValueExpression);
	}

	public @NonNull VariableAssignment createVariableAssignment(@NonNull Variable asVariable, @NonNull OCLExpression asValueExpression) {
		VariableAssignment asVariableAssignment = QVTimperativeFactory.eINSTANCE.createVariableAssignment();
		asVariableAssignment.setTargetVariable(asVariable);
		asVariableAssignment.setValue(asValueExpression);
		return asVariableAssignment;
	}
}