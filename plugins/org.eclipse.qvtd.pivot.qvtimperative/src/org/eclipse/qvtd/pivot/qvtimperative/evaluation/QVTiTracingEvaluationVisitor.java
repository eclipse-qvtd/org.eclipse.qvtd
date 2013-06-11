/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;

public class QVTiTracingEvaluationVisitor extends QVTiEvaluationVisitorDecorator
{
	protected static final String DEFAULT_INDENT = "  ";
	
	private int indentLevel = 0;

	public QVTiTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated) {
		this(decorated, 0);
	}
	
	protected QVTiTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated, int indentLevel) {
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
	@Override
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		return new QVTiTracingEvaluationVisitor(super.createNestedEvaluator(), indentLevel);
	}

	@Override
	public @NonNull QVTiEvaluationVisitor createNestedLMVisitor() {
		System.out.println("(Creating nested LM Visitor)");
		QVTiTracingEvaluationVisitor decorator = new QVTiTracingEvaluationVisitor(
				delegate.createNestedLMVisitor());
		return decorator;
	}

	@Override
	public @NonNull QVTiEvaluationVisitor createNestedMMVisitor() {
		System.out.println("(Creating nested MM Visitor)");
		QVTiTracingEvaluationVisitor decorator = new QVTiTracingEvaluationVisitor(
				delegate.createNestedMMVisitor());
		return decorator;
	}

	@Override
	public @NonNull QVTiEvaluationVisitor createNestedMRVisitor() {
		System.out.println("(Creating nested MR Visitor)");
		QVTiTracingEvaluationVisitor decorator = new QVTiTracingEvaluationVisitor(
				delegate.createNestedMRVisitor());
		return decorator;
	}
	
	protected @NonNull String getIndent() {
		StringBuilder outputBuffer = new StringBuilder(indentLevel);
		for (int i = 0; i < indentLevel; i++){
		   outputBuffer.append(DEFAULT_INDENT);
		}
		@SuppressWarnings("null")@NonNull String string = outputBuffer.toString();
		return string;
	}

	protected @NonNull String safePrint(@Nullable Element element) {
		return element != null ? PrettyPrinter.print(element) : "null";
	}
	
	@Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
		if (bottomPattern.getArea() instanceof CoreDomain) {
			System.out.println(getIndent() + "Visiting CoreDomain BottomPattern");
		}
		if (bottomPattern.getArea() instanceof Mapping) {
			System.out.println(getIndent() + "Visiting Mapping BottomPattern");
		}
		indentLevel++;
		Object result = delegate.visitBottomPattern(bottomPattern);
		for (Variable v : bottomPattern.getVariable()) {
			System.out.println(getIndent() + "Variable " + v.getName() + ": " + delegate.getEvaluationEnvironment().getValueOf(v));
		}
		if (bottomPattern.getPredicate().size() == 0) {
			System.out.println(getIndent() + "BottomPattern has no predicates.");
		} else {
			System.out.println(getIndent() + "BottomPattern result: " + result);
		}
		// TODO Print the created (realized) variables
		indentLevel--;
		return result;
	}
	
	@Override
    public @Nullable Object visitCoreDomain(@NonNull CoreDomain coreDomain) {
		System.out.println(getIndent() + "CoreDomain " + coreDomain.getName());
		indentLevel++;
		Object result = delegate.visitCoreDomain(coreDomain);
		indentLevel--;
    	return result;
    }
	
	@Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern guardPattern) {
		if (guardPattern.getArea() instanceof CoreDomain) {
			System.out.println(getIndent() + "Visiting CoreDomain GuardPattern");
		}
		if (guardPattern.getArea() instanceof Mapping) {
			System.out.println(getIndent() + "Visiting Mapping GuardPattern");
		}
		indentLevel++;
		Object result = delegate.visitGuardPattern(guardPattern);
		// Variables are assigned after visit
		for (Variable v : guardPattern.getVariable()) {
			System.out.println(getIndent() + "Variable " + v.getName() + ": " + delegate.getEvaluationEnvironment().getValueOf(v));
		}
		if (guardPattern.getPredicate().size() == 0) {
			System.out.println(getIndent() + "GuardPattern has no predicates.");
		} else {
			System.out.println(getIndent() + "GuardPattern result: " + result);
		}
		indentLevel--;
    	return result;
	}
	
	@Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
		return delegate.visitImperativeModel(imperativeModel);
	}
	
	@Override
	public @Nullable Object visitIteratorExp(@NonNull org.eclipse.ocl.examples.pivot.IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}
	
	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
		System.out.println(getIndent() + "Mapping " + mapping.getName());
		indentLevel++;
		Object result = delegate.visitMapping(mapping);
		indentLevel--;
		return result;
	}
	
	@Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
		System.out.println(getIndent() + "Visiting MappingCall, calling: " + mappingCall.getReferredMapping().getName());
		indentLevel++;
		System.out.println(getIndent() + "Bindings");
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = binding.getBoundVariable();
			System.out.println(getIndent() + boundVariable.getName() + ": " +  safePrint(binding.getValue()));
    	}
		Object result = delegate.visitMappingCall(mappingCall);
		indentLevel--;
		return result;
	}


	public Object visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment propertyAssignment) {
		System.out.println(getIndent() + "visitMiddlePropertyAssignment " + propertyAssignment.getSlotExpression()
			+ ": " + propertyAssignment.getTargetProperty().getName());
	indentLevel++;
	Object result = delegate.visitPropertyAssignment(propertyAssignment);
	indentLevel--;
	return result;
	}

	public Object visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp callExp) {
        return delegate.visitMiddlePropertyCallExp(callExp);
	}
	
	@Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		System.out.println(getIndent() + "visitAssignment " + propertyAssignment.getSlotExpression()
				+ ": " + propertyAssignment.getTargetProperty().getName());
		indentLevel++;
		Object result = delegate.visitPropertyAssignment(propertyAssignment);
		indentLevel--;
		return result;
    }
	
	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		System.out.println("\n");
		System.out.println("---- Transformation " + transformation.getName() + " ----");
		indentLevel++;
		Object result = delegate.visitTransformation(transformation);
		indentLevel--;
		System.out.println("---- Transformation End ----");
		return result;
	}
	
	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {		
		OCLExpression exp = predicate.getConditionExpression();
		System.out.println(getIndent() + "Predicate " + safePrint(exp));
		return delegate.visitPredicate(predicate);
		
	}
	
	@Override
	public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		Variable v = variableAssignment.getTargetVariable();
		System.out.println(getIndent() + "visitVariableAssignment " + v
				+ ": " + ((EvaluationVisitorImpl)delegate).safeVisit(variableAssignment.getValue()));
		indentLevel++;
		Object result = delegate.visitVariableAssignment(variableAssignment);
		indentLevel--;
		return result;
	}
}
