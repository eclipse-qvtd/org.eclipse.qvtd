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
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;

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
		asFunction.setType(returnType);
		asFunction.setIsRequired(returnIsRequired);
		if (asParameters != null) {
			asFunction.getOwnedParameters().addAll(asParameters);
		}
		return asFunction;
	}

	public @NonNull FunctionParameter createFunctionParameter(@NonNull TypedElement typedElement) {
		String name = ClassUtil.nonNullState(typedElement.getName());
		Type type = ClassUtil.nonNullState(typedElement.getType());
		FunctionParameter asParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
		asParameter.setName(name);
		asParameter.setType(type);
		asParameter.setIsRequired(typedElement.isIsRequired());
		return asParameter;
	}

	public @NonNull Predicate createPredicate(@NonNull OCLExpression asConditionExpression) {
		Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
		asPredicate.setConditionExpression(asConditionExpression);
		return asPredicate;
	}
}