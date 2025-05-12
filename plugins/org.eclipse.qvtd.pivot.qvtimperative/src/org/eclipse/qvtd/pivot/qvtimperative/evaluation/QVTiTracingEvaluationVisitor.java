/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractMergedQVTimperativeVisitor;

public class QVTiTracingEvaluationVisitor extends AbstractMergedQVTimperativeVisitor<Object, IQVTiEvaluationVisitor> implements IQVTiEvaluationVisitor
{
	private boolean showOCL = true;

	public QVTiTracingEvaluationVisitor(@NonNull IQVTiEvaluationVisitor decorated) {
		super(decorated);
		decorated.setUndecoratedVisitor(this);
	}

	@SuppressWarnings("null")
	@Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
		EvaluationLogger logger = context.getExecutor().getLogger();
		if ((logger == null) || (!showOCL && (visitable.eClass().getEPackage() == PivotPackage.eINSTANCE))) {
			return visitable.accept(context);
		}
		if (visitable instanceof EObject) {
			logger.append(String.valueOf(((EObject)visitable).eClass().getName()));
		}
		else {
			logger.append(String.valueOf(visitable.getClass().getSimpleName()));
		}
		logger.append(": ");
		logger.append(String.valueOf(visitable));
		logger.append("\n");
		EvaluationLogger.Indentable indentableLogger = null;
		if (logger instanceof EvaluationLogger.Indentable) {
			indentableLogger = (EvaluationLogger.Indentable)logger;
		}
		try {
			if (indentableLogger != null) {
				indentableLogger.pushIndentation();
			}
			Object visit = visitable.accept(context);
			if (indentableLogger != null) {
				indentableLogger.popIndentation();
			}
			logger.append("=> ");
			logger.append(NameUtil.qualifiedNameFor(visit));
			logger.append("\n");
			return visit;
		}
		catch (Throwable e) {
			if (indentableLogger != null) {
				indentableLogger.popIndentation();
			}
			logger.append("!! ");
			logger.append(String.valueOf(e.getClass().getSimpleName()));
			logger.append(": ");
			logger.append(String.valueOf(e.getMessage()));
			logger.append("\n");
			throw e;
		}
	}

	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return context.evaluate(body);
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return context.getEnvironmentFactory();
	}

	@Override
	public @NonNull Executor getExecutor() {
		return context.getExecutor();
	}

	@Override
	public @Nullable Monitor getMonitor() {
		return context.getMonitor();
	}

	@Override
	public boolean isCanceled() {
		return context.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		context.setCanceled(isCanceled);
	}

	@Override
	public void setMonitor(@Nullable Monitor monitor) {
		context.setMonitor(monitor);
	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		context.setUndecoratedVisitor(evaluationVisitor);
	}
}
