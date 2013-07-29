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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;


/**
 * The Class QVTiTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public class QVTiTracingEvaluationVisitorMR extends QVTiAbstractTracingEvaluationVisitor
{
	/** The indent level. */
	private int indentLevel = 0;	

	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 */
	public QVTiTracingEvaluationVisitorMR(@NonNull QVTiEvaluationVisitor decorated) {
		
		this(decorated, 0);
	}
	
	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 * @param indentLevel the indent level
	 */
	protected QVTiTracingEvaluationVisitorMR(@NonNull QVTiEvaluationVisitor decorated, int indentLevel) {
		
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#createNestedEvaluator()
	 */
	@Override
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		
		return new QVTiTracingEvaluationVisitorMR(super.createNestedEvaluator(), indentLevel);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern)
	 */
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
		if (bottomPattern.getArea() instanceof Mapping) {
			// Print the domain realized variables to see their attributes
			for(Domain d : ((Mapping)bottomPattern.getArea()).getDomain()) {
				System.out.println(getIndent() + "RealizedVariables for CoreDomain " + d.getName());
				indentLevel++;
				for (Variable v : ((Area)d).getBottomPattern().getRealizedVariable()) {
					System.out.println(getIndent() + "RealizedVariable " + v.getName() + ": " + prettyPrint((EObject) delegate.getEvaluationEnvironment().getValueOf(v)));
				}
				indentLevel--;
			}
		}
		indentLevel--;
		return result;
	}
}
