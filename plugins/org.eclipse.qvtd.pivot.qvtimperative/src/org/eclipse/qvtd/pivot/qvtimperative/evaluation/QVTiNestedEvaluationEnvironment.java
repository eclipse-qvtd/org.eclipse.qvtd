/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsageAnalysis;

public class QVTiNestedEvaluationEnvironment extends BasicEvaluationEnvironment implements QVTiEvaluationEnvironment
{
	protected final @NonNull QVTiRootEvaluationEnvironment rootEvaluationEnvironment;
	private @Nullable DomainUsageAnalysis usageAnalysis;
	
	public QVTiNestedEvaluationEnvironment(@NonNull QVTiEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable OCLExpression callingObject) {
		super(evaluationEnvironment, executableObject, callingObject);
		rootEvaluationEnvironment = evaluationEnvironment.getRootEvaluationEnvironment();
	}

	@Override
	public @NonNull QVTiExecutor getExecutor() {
		return (QVTiExecutor) super.getExecutor();
	}

	@Override
	public @NonNull QVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		EvaluationEnvironment parent = getParent();
		assert parent != null;
		return (QVTiEvaluationEnvironment)parent;
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return rootEvaluationEnvironment;
	}

	@Override
	public @NonNull Transformation getTransformation() {
		return rootEvaluationEnvironment.getTransformation();
	}

	@Override
	public @Nullable DomainUsage getUsageFor(@NonNull Element element) {
		DomainUsage domainUsage = null;
		DomainUsageAnalysis usageAnalysis2 = usageAnalysis;
		if (usageAnalysis2 == null) {
			if (callingObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)callingObject;
				Operation referredOperation = operationCallExp.getReferredOperation();
				if (referredOperation != null) {
					usageAnalysis = usageAnalysis2 = getExecutor().getModelManager().getTransformationAnalysis().getDomainUsageAnalysis().getAnalysis(referredOperation);
					// FIXME Surely we need to 'specialize' for the actual usage of callingObject
				}
			}
		}
		if (usageAnalysis2 != null) {
			domainUsage = usageAnalysis2.getUsage(element);
		}
		if (domainUsage != null) {
			return domainUsage;
		}
		else {
			return getParentEvaluationEnvironment().getUsageFor(element);
		}
	}
}
