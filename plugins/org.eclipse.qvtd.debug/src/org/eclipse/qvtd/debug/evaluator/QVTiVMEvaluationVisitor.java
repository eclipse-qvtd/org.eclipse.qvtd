/*******************************************************************************
 * Copyright (c) 2009,2012 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.debug.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.stubs.OperationCallResult;
import org.eclipse.ocl.examples.debug.stubs.VMInterruptedExecutionException;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainLogger;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractWrappingQVTimperativeVisitor;

public abstract class QVTiVMEvaluationVisitor extends AbstractWrappingQVTimperativeVisitor<Object, Object, QVTiEvaluationVisitor, Object> implements QVTiEvaluationVisitor
{
	public static final @NonNull TracingOption LOCATION = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "location");
	public static final @NonNull TracingOption PRE_VISIT = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "pre-visit");
	public static final @NonNull TracingOption POST_VISIT = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "post-visit");
	public static final @NonNull TracingOption VISITOR_STACK = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "visitorStack");
	public static final @NonNull TracingOption VM_EVENT = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "vmEvent");
	public static final @NonNull TracingOption VM_REQUEST = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "vmRequest");
	public static final @NonNull TracingOption VM_RESPONSE = new TracingOption(QVTiDebugPlugin.PLUGIN_ID, "vmResponse");
	
	static {
//		LOCATION.setState(true);
//		PRE_VISIT.setState(true);
//		POST_VISIT.setState(true);
//		VISITOR_STACK.setState(true);
//		VM_EVENT.setState(true);
//		VM_REQUEST.setState(true);
//		VM_RESPONSE.setState(true);
	}
	
	protected QVTiVMEvaluationVisitor(@NonNull QVTiEvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor, new Object());
		delegate.setUndecoratedVisitor(this);
	}

	public abstract int getDepth();

	public @NonNull QVTiEnvironment getEnvironment() {
		return (QVTiEnvironment) delegate.getEnvironment();
	}

	public @NonNull IQVTiVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IQVTiVMEvaluationEnvironment) delegate.getEvaluationEnvironment();
	}

	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}
	
//	@Override
//	protected void poppedStack() {
//		popLocation();
//	}
		
//	@Override
//	protected void pushedStack(IDebugEvaluationEnvironment env) {
//		Element currentIP = env.getCurrentIP();

//		UnitLocation startLocation = newLocalLocation(env, currentIP, ASTBindingHelper.getStartPosition(currentIP)); 
//				getEndPosition(currentIP) - getStartPosition(currentIP));

//		pushLocation(startLocation);
//	}


//	@Override
//	protected void addToEnv(String varName, Object value, EClassifier declaredType) {
//		getEvaluationEnvironment().add(varName, value, declaredType);
//	}

//	@Override
//	protected void replaceInEnv(String varName, Object value, EClassifier declaredType) {
//		getEvaluationEnvironment().replace(varName, value, declaredType);
//	}

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

	@Override
	protected @Nullable Object badVisit(@NonNull Visitable visitable, @Nullable Object preState, @NonNull Throwable e) throws RuntimeException {
		Element element = (Element)visitable;
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		Object result = badVisit(evalEnv, element, preState, e);
		if (POST_VISIT.isActive()) {
			POST_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
		return result;
	}

	protected abstract @Nullable Object badVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, Object preState, @NonNull Throwable e);

	protected void superProcessDeferredTasks() {
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		evalEnv.processDeferredTasks();
	}

	@Override
	protected Object postVisit(@NonNull Visitable visitable, @Nullable Object preState, @Nullable Object result) {
		Element element = (Element)visitable;
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		postVisit(evalEnv, element, preState);
		if (POST_VISIT.isActive()) {
			POST_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString() + " => " + result);
		}
		return result;
	}

	protected abstract void postVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, Object preState);

	@Override
	protected Object preVisit(@NonNull Visitable visitable) {
		Element element = (Element)visitable;
		if (PRE_VISIT.isActive()) {
			PRE_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
		setCurrentEnvInstructionPointer(element);
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		return preVisit(evalEnv, element);
	}

	protected abstract Object preVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element);

	public void throwQVTException(VMInterruptedExecutionException qvtInterruptedExecutionException) {
		// TODO Auto-generated method stub
		
	}

	public OperationCallResult runMainEntry(Transformation transformation, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}
	   
    protected Element setCurrentEnvInstructionPointer(Element element) {
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
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
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		return delegate.createNestedEvaluator();
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainExpression body) {
		return delegate.evaluate(body);
	}

	@Override
	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		return delegate.evaluate(expressionInOCL);
	}

	public @NonNull QVTiEvaluationVisitorImpl getClonedEvaluator() {
		IQVTiVMEvaluationEnvironment oldEvaluationEnvironment = getEvaluationEnvironment();
		IQVTiEvaluationEnvironment clonedEvaluationEnvironment = oldEvaluationEnvironment.createClonedEvaluationEnvironment();
		return new QVTiEvaluationVisitorImpl(getEnvironment(), clonedEvaluationEnvironment);
	}

	public static IVMEvaluationEnvironment<?> cloneEvaluationEnv(IVMEvaluationEnvironment<?> evaluationEnvironment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NonNull EvaluationVisitor getEvaluator() {
		return delegate.getEvaluator();
	}

	@Override
	public @NonNull DomainModelManager getModelManager() {
		return delegate.getModelManager();
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return delegate.getMetaModelManager();
	}

	@Override
	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		delegate.setUndecoratedVisitor(evaluationVisitor);
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	@Override
	public @Nullable DomainLogger getLogger() {
		return delegate.getLogger();
	}

	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return delegate.getRegexPattern(regex);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		return delegate.getStaticTypeOf(value);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	@Override
	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	@Override
	public void setLogger(@Nullable DomainLogger logger) {
		delegate.setLogger(logger);
	}

	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}

	public abstract @NonNull QVTiRootVMEvaluationVisitor getRootEvaluationVisitor();

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
