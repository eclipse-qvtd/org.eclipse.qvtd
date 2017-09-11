/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import com.google.common.collect.Iterables;

/**
 * QVTbaseHelper provides helper routines to assist creation of QVTbase model elements.
 */
public class QVTbaseHelper extends PivotHelper
{
	public QVTbaseHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull Function createFunction(@NonNull String name, @NonNull Type returnType, boolean returnIsRequired, @Nullable List<@NonNull FunctionParameter> asParameters) {
		Function asFunction = QVTbaseFactory.eINSTANCE.createFunction();
		asFunction.setName(name);
		setType(asFunction, returnType, returnIsRequired);
		if (asParameters != null) {
			asFunction.getOwnedParameters().addAll(asParameters);
		}
		return asFunction;
	}

	public @NonNull FunctionParameter createFunctionParameter(@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class asClass, boolean isRequired) {
		FunctionParameter asParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
		asParameter.setName(name);
		setType(asParameter, asClass, isRequired);
		return asParameter;
	}

	public @NonNull FunctionParameter createFunctionParameter(@NonNull TypedElement typedElement) {
		String name = ClassUtil.nonNullState(typedElement.getName());
		Type type = ClassUtil.nonNullState(typedElement.getType());
		FunctionParameter asParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
		asParameter.setName(name);
		setType(asParameter, type, typedElement.isIsRequired());
		return asParameter;
	}

	public @NonNull IteratorExp createIteratorExp(@NonNull OCLExpression asSourceExpression, @NonNull String opName, @NonNull List<@NonNull ? extends Variable> asIterators, @NonNull OCLExpression asBody) {
		Type asType = ClassUtil.nonNullState(asSourceExpression.getType());
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(asType);
		int iteratorsCount = asIterators.size();
		int bestMatches = -1;
		Iteration bestIteration = null;
		for (@NonNull Operation asOperation : completeClass.getOperations(FeatureFilter.SELECT_NON_STATIC, opName)) {
			if (asOperation instanceof Iteration) {
				Iteration asIteration = (Iteration) asOperation;
				List<@NonNull Parameter> asParameters = ClassUtil.nullFree(asIteration.getOwnedIterators());
				if (asParameters.size() == iteratorsCount) {
					int exactMatches = 0;
					boolean gotOne = true;
					for (int i = 0; i < iteratorsCount; i++) {
						Type asParameterType = ClassUtil.nonNullState(asParameters.get(i).getType());
						if (asParameterType instanceof SelfType) {
							Type asArgumentType = asIterators.get(i).getType();
							if (asArgumentType.conformsTo(standardLibrary, asType) && asType.conformsTo(standardLibrary, asArgumentType)) {
								exactMatches++;
							}
						}
						else {
							Type asArgumentType = asIterators.get(i).getType();
							if (!asArgumentType.conformsTo(standardLibrary, asParameterType)) {
								gotOne = false;
								break;
							}
							if (asParameterType.conformsTo(standardLibrary, asArgumentType)) {
								exactMatches++;
							}
						}
					}
					if (gotOne) {
						if (exactMatches > bestMatches) {
							bestMatches = exactMatches;
							bestIteration = asIteration;
						}
						else if (exactMatches > bestMatches) {
							bestIteration = null;
						}
					}
				}
			}
		}
		if (bestMatches < 0) {
			throw new IllegalStateException("No match found for " + opName);
		}
		if (bestIteration == null) {
			throw new IllegalStateException("Ambiguous match found for " + opName);
		}
		return createIteratorExp(asSourceExpression, bestIteration, asIterators, asBody);
	}

	public @NonNull Pattern createPattern() {
		Pattern asPattern = QVTbaseFactory.eINSTANCE.createPattern();
		return asPattern;
	}

	public @NonNull Predicate createPredicate(@NonNull OCLExpression asConditionExpression) {
		Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
		asPredicate.setConditionExpression(asConditionExpression);
		return asPredicate;
	}

	public @NonNull Transformation createTransformation(@NonNull String name) {
		Transformation transformation = QVTbaseFactory.eINSTANCE.createTransformation();
		transformation.setName(name);
		return transformation;
	}

	public @NonNull TypedModel createTypedModel(@NonNull String name, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> usedPackages) {
		TypedModel asTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
		asTypedModel.setName(name);
		Iterables.addAll(QVTbaseUtil.Internal.getUsedPackagesList(asTypedModel), usedPackages);
		return asTypedModel;
	}

	public @NonNull CompleteClass getCompleteClass(@NonNull Type type) {
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(type);
		return completeClass;
	}
}