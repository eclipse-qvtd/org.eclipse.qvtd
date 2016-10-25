/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;

public interface QVTiExecutor extends ExecutorInternal
{
	@Nullable Resource createModel(@NonNull String outName, @NonNull URI outURI, @Nullable String contentType);
	Boolean execute();
	@Override
	@NonNull QVTiEvaluationEnvironment getEvaluationEnvironment();
	@NonNull InvocationConstructor getInvocationConstructor(@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor);
	@NonNull InvocationManager getInvocationManager();
	@Nullable Resource getModel(@NonNull String name);
	@Override
	@NonNull QVTiModelManager getModelManager();
	@Nullable Object internalExecuteMapping(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Object @NonNull [] boundValues, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteNewStatement(@NonNull NewStatement newStatement, @NonNull EvaluationVisitor undecoratedVisitor);
	void internalExecuteSetStatement(@NonNull SetStatement setStatement, @NonNull Object slotObject, @Nullable Object ecoreValue, @Nullable Object childKey);
	@Nullable Object internalExecuteTransformation(@NonNull ImperativeTransformation transformation, @NonNull EvaluationVisitor undecoratedVisitor);
	void loadModel(@NonNull String inName, @NonNull URI inURI, @Nullable String contentType);
	void replace(@NonNull TypedElement referredVariable, @Nullable Object value, boolean checkType);
	void saveModels();
}
