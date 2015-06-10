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
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEValuationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.VMInterruptedExecutionException;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractWrappingQVTimperativeVisitor;

public abstract class AbstractQVTiVMEvaluationVisitor extends AbstractWrappingQVTimperativeVisitor<Object, Object, IQVTiEvaluationVisitor, Element> implements IQVTiEvaluationVisitor, VMEValuationVisitor
{
	protected AbstractQVTiVMEvaluationVisitor(@NonNull IQVTiEvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor, new Object());
		delegate.setUndecoratedVisitor(this);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
		delegate.add(referredVariable, value);
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return delegate.createNestedEvaluator();
	}
	
	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override	
	public void dispose() {
		delegate.dispose();
	}

	public abstract int getDepth();

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return delegate.getCompleteEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
        return delegate.getDiagnosticSeverity(severityPreference, resultValue);
	}

	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) delegate.getEnvironmentFactory();
	}

	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return delegate.getEvaluationEnvironment();
	}

	@Override
	public @NonNull Evaluator getEvaluator() {
		return delegate.getEvaluator();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @Nullable EvaluationLogger getLogger() {
		return delegate.getLogger();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull MetamodelManager getMetamodelManager() {
		return delegate.getMetamodelManager();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull ModelManager getModelManager() {
        return delegate.getModelManager();
    }

	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
        return delegate.getRegexPattern(regex);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
    @Override
	public @NonNull EvaluationEnvironment getRootEvaluationEnvironment() {
	       return delegate.getRootEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getSeverity(@Nullable Object validationKey) {
        return delegate.getSeverity(validationKey);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
		return delegate.getValueOf(referredVariable);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void popEvaluationEnvironment() {
		delegate.popEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull EvaluationEnvironment pushEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return delegate.pushEvaluationEnvironment(executableObject);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
		delegate.replace(referredVariable, value);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {	
		return delegate.getStaticTypeOf(value);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value,	@NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	public @NonNull VMEvaluationEnvironment getVMEvaluationEnvironment() {
		return (VMEvaluationEnvironment) delegate.getEvaluationEnvironment();
	}

//	@Override
	protected void processDeferredTasks() {
//		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
//		Transformation transformation = evalEnv.getTransformation();
//		UnitLocation startLocation = newLocalLocation(evalEnv, transformation, ASTBindingHelper.getEndPosition(transformation));//, 0);
//		try {
//			pushLocation(startLocation);

//			superProcessDeferredTasks();
//		} finally {
//			popLocation();
//		}
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		delegate.setLogger(logger);
	}

	@Override
	protected @Nullable Object badVisit(@NonNull Visitable visitable, @Nullable Element preState, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof VMInterruptedExecutionException) {
			throw (VMInterruptedExecutionException)e;
		}
		Element element = (Element)visitable;
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
		Object result = badVisit(evalEnv, element, preState, e);		// FIXME bad code exception here is confusing to user
		if (VMVirtualMachine.POST_VISIT.isActive()) {
			VMVirtualMachine.POST_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
		return result;
	}

	protected abstract @Nullable Object badVisit(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element, Object preState, @NonNull Throwable e);

	protected void superProcessDeferredTasks() {
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
		evalEnv.processDeferredTasks();
	}

	@Override
	protected Object postVisit(@NonNull Visitable visitable, @Nullable Element prologue, @Nullable Object result) {
		Element element = (Element)visitable;
		if (VMVirtualMachine.POST_VISIT.isActive()) {
			VMVirtualMachine.POST_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString() + " => " + result);
		}
//		setCurrentEnvInstructionPointer(parentElement);
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
		postVisit(evalEnv, element, result);
		return result;
	}

	protected abstract void postVisit(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element, @Nullable Object result);

	@Override
	protected @Nullable Element preVisit(@NonNull Visitable visitable) {
		Element element = (Element)visitable;
		if (VMVirtualMachine.PRE_VISIT.isActive()) {
			VMVirtualMachine.PRE_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
//		Element previousIP = setCurrentEnvInstructionPointer(null/*element*/);
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
		Element previousIP = evalEnv.getCurrentIP();
		preVisit(evalEnv, element);
		return previousIP;
	}

	protected abstract Object preVisit(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element);

//	public void throwQVTException(VMInterruptedExecutionException qvtInterruptedExecutionException) {
		// TODO Auto-generated method stub
		
//	}
	
	/** @deprecated no lon ger used */
	@Deprecated
    protected Element setCurrentEnvInstructionPointer(Element element) {
		VMEvaluationEnvironment evalEnv = getVMEvaluationEnvironment();
    	if (element != null) {
    		return evalEnv.setCurrentIP(element);
    	}
    	else {
    		return evalEnv.getCurrentIP();
    	}
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
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return delegate.evaluate(body);
	}

	public static VMEvaluationEnvironment cloneEvaluationEnv(VMEvaluationEnvironment evaluationEnvironment) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public @NonNull EvaluationVisitor getEvaluator() {
//		return delegate.getEvaluator();
//	}

//	@Override
//	public @NonNull ModelManager getModelManager() {
//		return delegate.getModelManager();
//	}

//	@Override
//	public @NonNull MetamodelManager getMetamodelManager() {
//		return delegate.getMetamodelManager();
//	}

//	@Override
//	public @NonNull StandardLibrary getStandardLibrary() {
//		return delegate.getStandardLibrary();
//	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		delegate.setUndecoratedVisitor(evaluationVisitor);
	}

//	@Override
//	public @NonNull IdResolver getIdResolver() {
//		return delegate.getIdResolver();
//	}

//	@Override
//	public @Nullable EvaluationLogger getLogger() {
//		return delegate.getLogger();
//	}

	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

//	@Override
//	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
//		return delegate.getRegexPattern(regex);
//	}

	public abstract @NonNull QVTiVMEvaluationVisitor getRootEvaluationVisitor();

//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value) {
//		return delegate.getStaticTypeOf(value);
//	}

//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
//		return delegate.getStaticTypeOf(value, values);
//	}

//	@Override
//	public @NonNull org.eclipse.ocl.pivot.Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
//		return delegate.getStaticTypeOf(value, values);
//	}

	@Override
	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

//	@Override
//	public void setLogger(@Nullable EvaluationLogger logger) {
//		delegate.setLogger(logger);
//	}

	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}

//	@Override
//	public @Nullable Object visitTransformation(@NonNull Transformation object) {
//	    try {
//	    	pushedStack(getEvaluationEnvironment());
//			return super.visitTransformation(object);
//	    }
//	    finally {
//	    	poppedStack();
//	    }
//	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + getDepth() + ")";
	}
}
