/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
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
		catch (RuntimeException e) {
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

	@SuppressWarnings("deprecation")
	@Override
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return context.createNestedEvaluator();
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
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return context.getEvaluationEnvironment();
	}

	/** @deprected moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull EvaluationVisitor getEvaluator() {
		return context.getEvaluator();
	}

	@Override
	public @NonNull Executor getExecutor() {
		return context.getExecutor();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull MetamodelManager getMetamodelManager() {
        return context.getMetamodelManager();
    }

	@SuppressWarnings("deprecation")
	@Override
	public @NonNull ModelManager getModelManager() {
		return context.getModelManager();
	}

	@Override
	public @Nullable Monitor getMonitor() {
		return context.getMonitor();
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return context.getStandardLibrary();
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

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public void dispose() {
		context.dispose();
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return context.getCompleteEnvironment();
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
		return context.getDiagnosticSeverity(severityPreference, resultValue);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull IdResolver getIdResolver() {
		return context.getIdResolver();
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @Nullable EvaluationLogger getLogger() {
		return context.getLogger();
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return context.getRegexPattern(regex);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public int getSeverity(@Nullable Object validationKey) {
		return context.getSeverity(validationKey);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value) {
		return context.getStaticTypeOf(value);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return context.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return context.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Executor. */
	@Deprecated
	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		context.setLogger(logger);
	}
}
