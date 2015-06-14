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
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
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
		EvaluationLogger logger = context.getLogger();
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
			logger.append("=> ");
			logger.append(NameUtil.qualifiedNameFor(visit));
			logger.append("\n");
			return visit;
		}
		catch (RuntimeException e) {
			if (indentableLogger != null) {
				indentableLogger.popIndentation();
			}
			logger.append(" !! ");
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

	@Override
	public @NonNull Evaluator getEvaluator() {
		return context.getEvaluator();
	}

	@SuppressWarnings("deprecation")
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

	@Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
		context.add(referredVariable, value);
	}

	@Override
	public void dispose() {
		context.dispose();
	}

	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return context.getCompleteEnvironment();
	}

	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
		return context.getDiagnosticSeverity(severityPreference, resultValue);
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return context.getIdResolver();
	}

	@Override
	public @Nullable EvaluationLogger getLogger() {
		return context.getLogger();
	}

	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return context.getRegexPattern(regex);
	}

	@Override
	public int getSeverity(@Nullable Object validationKey) {
		return context.getSeverity(validationKey);
	}

	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value) {
		return context.getStaticTypeOf(value);
	}

	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return context.getStaticTypeOf(value, values);
	}

	@Override
	public @NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return context.getStaticTypeOf(value, values);
	}

	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
		return context.getValueOf(referredVariable);
	}

	@Override
	public @NonNull EvaluationEnvironment getRootEvaluationEnvironment() {
		return context.getRootEvaluationEnvironment();
	}

	@Override
	public void popEvaluationEnvironment() {
		context.popEvaluationEnvironment();
	}

	@Override
	public @NonNull EvaluationEnvironment pushEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return context.pushEvaluationEnvironment(executableObject);
	}

	@Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
		context.replace(referredVariable, value);
	}

	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		context.setLogger(logger);
	}
}
