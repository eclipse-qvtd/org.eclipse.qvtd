/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getVariable extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getVariable INSTANCE = new Helper4getVariable();

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object selfValue, @Nullable Object sourceValue) {
		VariableDeclaration atlVariable = (VariableDeclaration)sourceValue;
		assert atlVariable != null;
		String varName = atlVariable.getVarName();
		if ("self".equals(varName)) {
			for (EObject eObject = atlVariable.getVariableExp().get(0); eObject instanceof OclFeatureDefinition; eObject = eObject.eContainer()) {

			}

		}
		/*		StandardLibrary standardLibrary = executor.getStandardLibrary();
		if (atlType instanceof BooleanType) {
			return standardLibrary.getBooleanType();
		}
		else if (atlType instanceof IntegerType) {
			return standardLibrary.getIntegerType();
		}
		else if (atlType instanceof RealType) {
			return standardLibrary.getRealType();
		}
		else if (atlType instanceof StringType) {
			return standardLibrary.getStringType();
		}
		else if (atlType instanceof OclModelElement) {
			OclModelElement oclModelElement = (OclModelElement)atlType;
			OclModel metamodel = oclModelElement.getModel();
			//			OclModel metamodel = model.getMetamodel();
			Module atlModule = (Module) EcoreUtil.getRootContainer(oclModelElement);
			assert atlModule != null;
			String packageName = metamodel.getName();
			assert packageName != null;
			String className = oclModelElement.getName();
			assert className != null;
			org.eclipse.ocl.pivot.Class asClass = HelperUtils.getClass(executor, atlModule, packageName, className);
			if (asClass != null) {
				return asClass;
			}
			return standardLibrary.getOclInvalidType();
		}
		else {
			return standardLibrary.getOclInvalidType();
		} */
		return null;
	}
}
