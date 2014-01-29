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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
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
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.stubs.OperationCallResult;
import org.eclipse.qvtd.debug.stubs.QvtInterruptedExecutionException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractWrappingQVTimperativeVisitor;

public abstract class DebugQVTiEvaluationVisitor extends AbstractWrappingQVTimperativeVisitor<Object, Object, QVTiEvaluationVisitor, Object> implements QVTiEvaluationVisitor
{
	public static final @NonNull TracingOption LOCATION = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "location");
	public static final @NonNull TracingOption PRE_VISIT = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "pre-visit");
	public static final @NonNull TracingOption POST_VISIT = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "post-visit");
	public static final @NonNull TracingOption VISITOR_STACK = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "visitorStack");
	public static final @NonNull TracingOption VM_EVENT = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "vmEvent");
	public static final @NonNull TracingOption VM_REQUEST = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "vmRequest");
	public static final @NonNull TracingOption VM_RESPONSE = new TracingOption(QVTdDebugPlugin.PLUGIN_ID, "vmResponse");
	
	static {
//		LOCATION.setState(true);
//		PRE_VISIT.setState(true);
//		POST_VISIT.setState(true);
//		VISITOR_STACK.setState(true);
//		VM_EVENT.setState(true);
//		VM_REQUEST.setState(true);
//		VM_RESPONSE.setState(true);
	}
	
	protected DebugQVTiEvaluationVisitor(@NonNull QVTiEvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor, new Object());
		delegate.setUndecoratedVisitor(this);
	}

/*	public QvtOperationalEvaluationVisitor createDebugInterceptor() {
		return new DebugInterceptor(this);
	} */
	
/*	@Override
	protected QvtOperationalEvaluationVisitorImpl createNestedEvaluationVisitor(
			QvtOperationalEvaluationVisitorImpl parent,
			QvtOperationalEvaluationEnv nestedEvalEnv) {
		return new QVTODebugEvaluator(parent, nestedEvalEnv);
	} */

//	public abstract @Nullable UnitLocation getCurrentLocation();

	public abstract int getDepth();

	public @NonNull QVTiEnvironment getEnvironment() {
		return (QVTiEnvironment) delegate.getEnvironment();
	}

	public @NonNull IDebugEvaluationEnvironment getEvaluationEnvironment() {
		return (IDebugEvaluationEnvironment) delegate.getEvaluationEnvironment();
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

	protected void superProcessDeferredTasks() {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		evalEnv.processDeferredTasks();
	}

/*	@Override
	public void notifyAfterDeferredAssign(AssignExp asssignExp,
			Object assignLeftValue) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();

		UnitLocation startLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition(), getNodeLength(asssignExp));
		setCurrentLocation(asssignExp, startLocation, false);

		processDebugRequest(startLocation);

		UnitLocation endLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition() + getNodeLength(asssignExp) - 1,
				1);
		setCurrentLocation(asssignExp, endLocation, true);
	} */

/*	public Object navigateProperty(EStructuralFeature property, Object target) {
		OCLExpression<EClassifier> body = getPropertyBody(property);
		if (body != null) {
			return super.navigate(property, body, target);
		}
		return getEvaluationEnvironment().navigateProperty(property, null, target);
	} */

	@Override
	protected Object postVisit(@NonNull Visitable visitable, @Nullable Object preState, @Nullable Object result) {
		Element element = (Element)visitable;
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		postVisit(evalEnv, element, preState);
		if (POST_VISIT.isActive()) {
			POST_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
		return result;
	}

	protected abstract void postVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element, Object preState);

	@Override
	protected Object preVisit(@NonNull Visitable visitable) {
		Element element = (Element)visitable;
		if (PRE_VISIT.isActive()) {
			PRE_VISIT.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString());
		}
		setCurrentEnvInstructionPointer(element);
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		return preVisit(evalEnv, element);
	}

	protected abstract Object preVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element);

//	private void pushLocation(UnitLocation location) {
//		fLocationStack.add(0, location);
//	}

//	private UnitLocation popLocation() {
//		UnitLocation removed = fLocationStack.remove(0);
//		return removed;
//	}
	
//	@Override
//	protected InternalEvaluator createInterruptibleVisitor() {
//		return (DebugInterceptor)createDebugInterceptor();
//	}
	
/*	private final class DebugInterceptor extends QvtGenericEvaluationVisitor implements InternalEvaluator {
		
		public ModuleInstance callTransformationImplicitConstructor(OperationalTransformation transformation, List<ModelInstance> args) {
			return QVTODebugEvaluator.this.callTransformationImplicitConstructor(transformation, args);
		}
		
		public OperationCallResult runMainEntry(OperationalTransformation transformation, List<Object> args) {
			return QVTODebugEvaluator.this.runMainEntry(transformation, args);
		}

		public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
			fCurrentLocation = newLocalLocation(getOperationalEvaluationEnv(), transformation, transformation
					.getStartPosition(), getNodeLength(transformation));
			
			return QVTODebugEvaluator.this.execute(transformation);
		}

		private DebugInterceptor(QvtOperationalEvaluationVisitor qvtExtVisitor) {
			super(qvtExtVisitor);
		}

		public DebugInterceptor(QVTODebugEvaluator qvtoDebugEvaluator) {
			// TODO Auto-generated constructor stub
		}

		public void setOperationalEvaluationEnv(
				QvtOperationalEvaluationEnv evalEnv) {
			QVTODebugEvaluator.this.setOperationalEvaluationEnv(evalEnv);
		}

		public QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
			return QVTODebugEvaluator.this.getOperationalEvaluationEnv();
		}

		public IContext getContext() {
			return QVTODebugEvaluator.this.getContext();
		}

		@Override
		protected Object genericPreVisitAST(ASTNode visited) {
			if (getContext().getMonitor() != null && getContext().getMonitor().isCanceled()) {    				
				throwQVTException(new QvtInterruptedExecutionException());    				
			}
			return preElementVisit(visited);
		}

		@Override
		protected Object genericPostVisitAST(ASTNode element,
				Object preVisitState, Object result) {
			return postElementVisit(element, preVisitState, result);
		}
	} */

	public void throwQVTException(QvtInterruptedExecutionException qvtInterruptedExecutionException) {
		// TODO Auto-generated method stub
		
	}

	public OperationCallResult runMainEntry(Transformation transformation, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}
	   
    protected Element setCurrentEnvInstructionPointer(Element element) {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
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
	@Nullable
	public DomainLogger getLogger() {
		return delegate.getLogger();
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

	public abstract @NonNull DebugRootQVTiEvaluationVisitor getRootEvaluationVisitor();

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
