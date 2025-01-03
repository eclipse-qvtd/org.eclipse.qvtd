/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;

public interface QVTiExecutor extends ExecutorInternal
{
	void checkModels() throws CoreException;
	Boolean execute();
	@Override
	@NonNull QVTiEvaluationEnvironment getEvaluationEnvironment();
	@NonNull Interval getInterval(@NonNull Mapping asMapping);
	@NonNull InvocationConstructor getInvocationConstructor(@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor);
	@NonNull InvocationManager getInvocationManager();
	@Nullable Resource getModel(@NonNull String name);
	@NonNull QVTiModelsManager getModelsManager();
	@Nullable Object internalExecuteFunctionCallExp(@NonNull OperationCallExp operationCallExp,
			@NonNull Function asFunction, @Nullable Object @NonNull [] boxedSourceAndArgumentValues);
	@Nullable Object internalExecuteMapping(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteNewStatement(@NonNull NewStatement newStatement, @NonNull EvaluationVisitor undecoratedVisitor);
	void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object slotObject, @Nullable Object ecoreValue);
	@Nullable Boolean internalExecuteSpeculateStatement(@NonNull SpeculateStatement speculateStatement);
	@Nullable Object internalExecuteTransformation(@NonNull ImperativeTransformation transformation, @NonNull EvaluationVisitor undecoratedVisitor);
	boolean replace(@NonNull VariableDeclaration referredVariable, @Nullable Object value, boolean checkType);
	void saveModels(@Nullable Map<?, ?> savingOptions) throws IOException;
	void saveOutput(@NonNull String outName, @NonNull URI outURI);
}
