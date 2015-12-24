/*******************************************************************************
 * Copyright (c) 2012, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationVisitorDecorator;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;

/**
 * QVTcoreEvaluationVisitorImpl is the class for ...
 */
public abstract class QVTiEvaluationVisitorDecorator extends AbstractEvaluationVisitorDecorator<IQVTiEvaluationVisitor>
        implements IQVTiEvaluationVisitor {
	
	
	public QVTiEvaluationVisitorDecorator(@NonNull IQVTiEvaluationVisitor decorated) {
		super(decorated);
	}
	
	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return delegate.evaluate(body);
	}

	/**
     * Delegates to my decorated visitor.
     */
//	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
//		return delegate.evaluate(expressionInOCL);
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @NonNull CompleteEnvironment getCompleteEnvironment() {
//		return delegate.getCompleteEnvironment();
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @NonNull EvaluationVisitor getEvaluator() {
//		return delegate.getEvaluator();
//	}
	
//	@Override
//	public @NonNull EvaluationVisitor getEvaluator() {
//		return delegate.getEvaluator();
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @NonNull IdResolver getIdResolver() {
//		return delegate.getIdResolver();
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @Nullable EvaluationLogger getLogger() {
//		return delegate.getLogger();
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @NonNull MetamodelManager getMetamodelManager() {
//		return delegate.getMetamodelManager();
//	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public @NonNull StandardLibrary getStandardLibrary() {
//		return delegate.getStandardLibrary();
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value) {	
//		return delegate.getStaticTypeOf(value);
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value,
//			@NonNull Object... values) {
//		return delegate.getStaticTypeOf(value, values);
//	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value,
//			@NonNull Iterable<?> values) {
//		return delegate.getStaticTypeOf(value, values);
//	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	/**
     * Delegates to my decorated visitor.
     */
//	@Override
//	public void setLogger(@Nullable EvaluationLogger logger) {
//		delegate.setLogger(logger);
//	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}
	
	@Override
	public Object safeVisit(@Nullable Visitable v) {
		if (v == null) {
			throw new InvalidValueException("null expression");
		}
		try {
			Object result = v.accept(delegate);
			assert ValueUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			return result;
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		}
	}
	
	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitAssignment(@NonNull Assignment assignment) {
		return delegate.visitAssignment(assignment);
    }
	
    /**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitBaseModel(@NonNull BaseModel baseModel) {
		return delegate.visitBaseModel(baseModel);
	}
	
	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
    	return delegate.visitBottomPattern(bottomPattern);
    }
    
    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitCoreDomain(@NonNull CoreDomain coreDomain) {
    	return delegate.visitCoreDomain(coreDomain);
    }

    /**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitDomain(@NonNull Domain domain) {
		return delegate.visitDomain(domain);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitCorePattern(@NonNull CorePattern corePattern) {
    	return delegate.visitCorePattern(corePattern);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitEnforcementOperation(@NonNull EnforcementOperation enforcementOperation) {
    	return delegate.visitEnforcementOperation(enforcementOperation);
    }

    /**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitFunction(@NonNull Function function) {
		return delegate.visitFunction(function);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitFunctionParameter(@NonNull FunctionParameter functionParameter) {
		return delegate.visitFunctionParameter(functionParameter);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern guardPattern) {
    	return delegate.visitGuardPattern(guardPattern);
    }
    
    /**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitPattern(@NonNull Pattern pattern) {
		return delegate.visitPattern(pattern);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {
		return delegate.visitPredicate(predicate);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
    	return delegate.visitPropertyAssignment(propertyAssignment);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable realizedVariable) {
    	return delegate.visitRealizedVariable(realizedVariable);
    }

    /**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitRule(@NonNull Rule rule) {
		return delegate.visitRule(rule);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		return delegate.visitTransformation(transformation);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitTypedModel(@NonNull TypedModel typedModel) {
		return delegate.visitTypedModel(typedModel);
	}

	/**
     * Delegates to my decorated visitor.
     */
	@Override
	public @Nullable Object visitImport(@NonNull Import _import) {
		return delegate.visitImport(_import);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
    	return delegate.visitVariableAssignment(variableAssignment);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
    	return delegate.visitImperativeModel(imperativeModel);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
    	return delegate.visitMapping(mapping);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
    	return delegate.visitMappingCall(mappingCall);
	}

	/**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visitMappingCallBinding(@NonNull MappingCallBinding mappingCallBinding) {
    	return delegate.visitMappingCallBinding(mappingCallBinding);
	}

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
    	return delegate.visiting(visitable);
	}
}
