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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;

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

	public @NonNull AppendParameterBinding createAppendParameterBinding(@NonNull AppendParameter variable, @NonNull ConnectionVariable value) {
		AppendParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createAppendParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		return mappingParameterBinding;
	}

	public @NonNull BufferStatement createBufferStatement(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression initExpression) {
		BufferStatement asVariable = QVTimperativeFactory.eINSTANCE.createBufferStatement();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedExpression(initExpression);
		return asVariable;
	}

	public @NonNull CheckStatement createCheckStatement(@NonNull OCLExpression asConditionExpression) {
		CheckStatement asPredicate = QVTimperativeFactory.eINSTANCE.createCheckStatement();
		asPredicate.setOwnedExpression(asConditionExpression);
		return asPredicate;
	}

	public @NonNull DeclareStatement createDeclareStatement(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression initExpression) {
		DeclareStatement asVariableStatement = QVTimperativeFactory.eINSTANCE.createDeclareStatement();
		asVariableStatement.setIsCheck(!initExpression.getType().conformsTo(standardLibrary, asType));
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

	public @NonNull GuardParameterBinding createGuardParameterBinding(@NonNull GuardParameter variable, @NonNull ConnectionVariable value) {
		GuardParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createGuardParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		CollectionType collectionType = (CollectionType) value.getType();
		Type elementType = collectionType.getElementType();
		Type guardType = ClassUtil.nonNullState(variable.getType());
		mappingParameterBinding.setIsCheck(!elementType.conformsTo(standardLibrary, guardType));
		return mappingParameterBinding;
	}

	public @NonNull LoopVariable createLoopVariable(@NonNull String name, @NonNull Type type) {
		LoopVariable asVariable = QVTimperativeFactory.eINSTANCE.createLoopVariable();
		asVariable.setName(name);
		asVariable.setType(type);
		asVariable.setIsRequired(true);
		return asVariable;
	}

	public @NonNull LoopParameterBinding createLoopParameterBinding(@NonNull GuardParameter variable, @NonNull LoopVariable value) {
		LoopParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createLoopParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		mappingParameterBinding.setIsCheck(!value.getType().conformsTo(standardLibrary, ClassUtil.nonNullState(variable.getType())));
		return mappingParameterBinding;
	}

	public @NonNull SimpleParameterBinding createSimpleParameterBinding(@NonNull SimpleParameter variable, @NonNull OCLExpression value) {
		SimpleParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createSimpleParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		mappingParameterBinding.setIsCheck(!value.getType().conformsTo(standardLibrary, ClassUtil.nonNullState(variable.getType())));
		return mappingParameterBinding;
	}
}