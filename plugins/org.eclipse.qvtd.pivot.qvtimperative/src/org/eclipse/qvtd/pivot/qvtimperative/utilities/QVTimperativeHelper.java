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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
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
		setType(asVariable, asType, isRequired);
		return asVariable;
	}

	public @NonNull AppendParameterBinding createAppendParameterBinding(@NonNull AppendParameter variable, @NonNull ConnectionVariable value) {
		AppendParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createAppendParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		return mappingParameterBinding;
	}

	public @NonNull BufferStatement createBufferStatement(@NonNull String name, boolean isStrict, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression initExpression) {
		BufferStatement asVariable = QVTimperativeFactory.eINSTANCE.createBufferStatement();
		asVariable.setName(name);
		setType(asVariable, asType, isRequired);
		asVariable.setIsStrict(isStrict);
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
		setType(asVariableStatement, asType, isRequired);
		return asVariableStatement;
	}

	public @NonNull GuardParameter createGuardParameter(@NonNull String name, @NonNull ImperativeTypedModel typedModel, @NonNull Type type, boolean isRequired) {
		GuardParameter asVariable = QVTimperativeFactory.eINSTANCE.createGuardParameter();
		asVariable.setName(name);
		asVariable.setReferredTypedModel(typedModel);
		setType(asVariable, type, isRequired);
		return asVariable;
	}

	public @NonNull GuardParameterBinding createGuardParameterBinding(@NonNull GuardParameter variable, @NonNull ConnectionVariable value) {
		GuardParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createGuardParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		Type elementType = value.getType();
		Type guardType = ClassUtil.nonNullState(variable.getType());
		mappingParameterBinding.setIsCheck(!elementType.conformsTo(standardLibrary, guardType));
		return mappingParameterBinding;
	}

	public @NonNull LoopVariable createLoopVariable(@NonNull String name, @NonNull Type type) {
		LoopVariable asVariable = QVTimperativeFactory.eINSTANCE.createLoopVariable();
		asVariable.setName(name);
		setType(asVariable, type, true);
		return asVariable;
	}

	public @NonNull LoopParameterBinding createLoopParameterBinding(@NonNull GuardParameter variable, @NonNull LoopVariable value) {
		LoopParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createLoopParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		mappingParameterBinding.setIsCheck(!value.getType().conformsTo(standardLibrary, ClassUtil.nonNullState(variable.getType())));
		return mappingParameterBinding;
	}

	public @NonNull Mapping createMapping(@NonNull String name) {
		Mapping mapping = QVTimperativeFactory.eINSTANCE.createMapping();
		mapping.setName(name);
		return mapping;
	}

	public @NonNull MappingCall createMappingCall(@NonNull Mapping mapping, @NonNull List<@NonNull MappingParameterBinding> mappingParameterBindings) {
		MappingCall mappingCall = QVTimperativeFactory.eINSTANCE.createMappingCall();
		mappingCall.setReferredMapping(mapping);
		mappingCall.getOwnedMappingParameterBindings().addAll(mappingParameterBindings);
		return mappingCall;
	}

	public @NonNull MappingLoop createMappingLoop(@NonNull OCLExpression source, @NonNull LoopVariable iterator, @NonNull MappingStatement mappingStatement) {
		assert iterator.eContainer() == null;
		MappingLoop ml = QVTimperativeFactory.eINSTANCE.createMappingLoop();
		ml.setOwnedExpression(source);
		ml.getOwnedIterators().add(iterator);
		ml.getOwnedMappingStatements().add(mappingStatement);
		return ml;
	}

	public @NonNull NewStatement createNewStatement(@NonNull String name, @NonNull ImperativeTypedModel typedModel, @NonNull Type type) {
		NewStatement newStatement = QVTimperativeFactory.eINSTANCE.createNewStatement();
		newStatement.setName(name);
		newStatement.setReferredTypedModel(typedModel);
		newStatement.setType(type);
		newStatement.setIsRequired(true);
		return newStatement;
	}

	public @NonNull SetStatement createSetStatement(@NonNull VariableDeclaration asVariable, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression, boolean isPartial, boolean isNotify) {
		SetStatement asSetAssignment = QVTimperativeFactory.eINSTANCE.createSetStatement();
		if (asProperty.isIsImplicit()) {
			asSetAssignment.setTargetProperty(asProperty.getOpposite());
			asSetAssignment.setIsOpposite(true);
		}
		else {
			asSetAssignment.setTargetProperty(asProperty);
			asSetAssignment.setIsOpposite(false);
		}
		asSetAssignment.setTargetVariable(asVariable);
		asSetAssignment.setOwnedExpression(asValueExpression);
		asSetAssignment.setIsPartial(isPartial);
		asSetAssignment.setIsNotify(isNotify);
		assert isPartial == ((asSetAssignment.getTargetProperty().getType() instanceof CollectionType) && !(asValueExpression.getType() instanceof CollectionType));	// FIXME inadequate for nested types but good for initial debugging
		return asSetAssignment;
	}

	public @NonNull SimpleParameterBinding createSimpleParameterBinding(@NonNull SimpleParameter variable, @NonNull OCLExpression value) {
		SimpleParameterBinding mappingParameterBinding = QVTimperativeFactory.eINSTANCE.createSimpleParameterBinding();
		mappingParameterBinding.setBoundVariable(variable);
		mappingParameterBinding.setValue(value);
		mappingParameterBinding.setIsCheck(!value.getType().conformsTo(standardLibrary, ClassUtil.nonNullState(variable.getType())));
		return mappingParameterBinding;
	}

	public @NonNull ImperativeTransformation createTransformation(@NonNull String name) {
		ImperativeTransformation transformation = QVTimperativeFactory.eINSTANCE.createImperativeTransformation();
		transformation.setName(name);
		return transformation;
	}

	public  @NonNull ImperativeTypedModel createTypedModel(@NonNull String name) {
		ImperativeTypedModel typedModel = QVTimperativeFactory.eINSTANCE.createImperativeTypedModel();
		typedModel.setName(name);
		return typedModel;
	}
}