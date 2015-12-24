/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationVisitor;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractMergedQVTimperativeVisitor;

public class QVTiVMEvaluationVisitor extends AbstractMergedQVTimperativeVisitor<Object, IQVTiEvaluationVisitor> implements IQVTiEvaluationVisitor, VMEvaluationVisitor
{
	protected final @NonNull VMEvaluationStepper vmEvaluationStepper;

	public QVTiVMEvaluationVisitor(@NonNull VMEvaluationStepper vmEvaluationStepper, @NonNull IQVTiEvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor);
		this.vmEvaluationStepper = vmEvaluationStepper;
		context.setUndecoratedVisitor(this);
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return context.createNestedEvaluator();
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public void dispose() {
		context.dispose();
	}

	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return context.evaluate(body);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return context.getCompleteEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
        return context.getDiagnosticSeverity(severityPreference, resultValue);
	}

	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) context.getEnvironmentFactory();
	}

	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return context.getEvaluationEnvironment();
	}

	/** @deprecated Use this or getExecutor() */
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
	public @NonNull IdResolver getIdResolver() {
		return context.getIdResolver();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @Nullable EvaluationLogger getLogger() {
		return context.getLogger();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull MetamodelManager getMetamodelManager() {
        return context.getMetamodelManager();
    }

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull ModelManager getModelManager() {
        return context.getModelManager();
    }

	public @Nullable Monitor getMonitor() {
		return context.getMonitor();
	}

	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
        return context.getRegexPattern(regex);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getSeverity(@Nullable Object validationKey) {
        return context.getSeverity(validationKey);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return context.getStandardLibrary();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value) {	
		return context.getStaticTypeOf(value);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return context.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value,	@NonNull Iterable<?> values) {
		return context.getStaticTypeOf(value, values);
	}

	public @NonNull VMEvaluationEnvironment getVMEvaluationEnvironment() {
		return (VMEvaluationEnvironment) context.getEvaluationEnvironment();
	}

	public @NonNull VMEvaluationStepper getVMEvaluationStepper() {
		return vmEvaluationStepper;
	}

	@Override
	public boolean isCanceled() {
		return context.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		context.setCanceled(isCanceled);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		context.setLogger(logger);
	}

	public void setMonitor(@Nullable Monitor monitor) {
		context.setMonitor(monitor);
	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		context.setUndecoratedVisitor(evaluationVisitor);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();// + "(" + getDepth() + ")";
	}

	@Override
	public Object visitVariable(@NonNull Variable vd) {
		Object result = super.visitVariable(vd);
		Type declaredType = vd.getType();
//		String name = vd.getName();
		EvaluationEnvironment env = getEvaluationEnvironment();
		env.replace(vd, declaredType);
//		env.replace(name, env.getValueOf(name), declaredType);

		return result;
	}

	@Override
	public @Nullable Object visiting(@NonNull Visitable object) {
		return vmEvaluationStepper.visiting((Element)object);
	}
}
