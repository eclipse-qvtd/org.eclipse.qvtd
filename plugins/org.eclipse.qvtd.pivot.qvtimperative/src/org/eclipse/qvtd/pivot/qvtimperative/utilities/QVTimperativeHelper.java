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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;

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
		addStatement.setOwnedExpression(childrenExpression);
		return addStatement;
	}

	public @NonNull AppendParameter createAppendParameter(@NonNull String name, @NonNull Type asType, boolean isRequired) {
		AppendParameter asVariable = QVTimperativeFactory.eINSTANCE.createAppendParameter();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		return asVariable;
	}

	public @NonNull CheckStatement createCheckStatement(@NonNull OCLExpression asConditionExpression) {
		CheckStatement asPredicate = QVTimperativeFactory.eINSTANCE.createCheckStatement();
		asPredicate.setOwnedExpression(asConditionExpression);
		return asPredicate;
	}

	public @NonNull DeclareStatement createDeclareStatement(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression initExpression) {
		DeclareStatement asVariableStatement = QVTimperativeFactory.eINSTANCE.createDeclareStatement();
		asVariableStatement.setIsChecked(!initExpression.getType().conformsTo(standardLibrary, asType));
		asVariableStatement.setOwnedExpression(initExpression);
		asVariableStatement.setName(name);
		asVariableStatement.setType(asType);
		asVariableStatement.setIsRequired(isRequired);
		return asVariableStatement;
	}

	public @NonNull GuardParameter createGuardParameter(@NonNull String name, @NonNull ImperativeTypedModel typedModel, @NonNull Type type, boolean isRequired) {
		GuardParameter asVariable = QVTimperativeFactory.eINSTANCE.createGuardParameter();
		asVariable.setName(name);
		asVariable.setReferredTypedModel(typedModel);
		asVariable.setType(type);
		asVariable.setIsRequired(isRequired);
		return asVariable;
	}

	public @NonNull LoopVariable createLoopVariable(@NonNull String name, @NonNull Type type) {
		LoopVariable asVariable = QVTimperativeFactory.eINSTANCE.createLoopVariable();
		asVariable.setName(name);
		asVariable.setType(type);
		asVariable.setIsRequired(true);
		return asVariable;
	}

	public @NonNull OutConnectionVariable createOutConnectionVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression initExpression) {
		OutConnectionVariable asVariable = QVTimperativeFactory.eINSTANCE.createOutConnectionVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedExpression(initExpression);
		return asVariable;
	}
}