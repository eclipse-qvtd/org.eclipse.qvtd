/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

public interface QVTiExecutor extends ExecutorInternal
{
	@Override
	@NonNull QVTiEvaluationEnvironment getEvaluationEnvironment();
	@Override
	@NonNull QVTiModelManager getModelManager();
	@Nullable Object internalExecuteMapping(@NonNull Mapping mapping, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull Map<Variable, Object> variable2value, @NonNull EvaluationVisitor undecoratedVisitor);
	void internalExecutePropertyAssignment(@NonNull PropertyAssignment propertyAssignment, @NonNull Object slotObject, @Nullable Object ecoreValue);
	@Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor);
	@Nullable Object internalExecuteTransformation(@NonNull Transformation transformation, @NonNull EvaluationVisitor undecoratedVisitor);
}
