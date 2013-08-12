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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;


/**
 * The Class QVTiTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public class QVTiLMTracingEvaluationVisitor extends QVTiAbstractTracingEvaluationVisitor
{
	
	/** The Constant DEFAULT_INDENT. */
	protected static final String DEFAULT_INDENT = "  ";
	
	static int VERBOSE_LEVEL_LOW = 0;
	static int VERBOSE_LEVEL_MED = 1;
	static int VERBOSE_LEVEL_HIGH = 2;
	
	
	/** The indent level. */
	private int indentLevel = 0;
	

	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 */
	public QVTiLMTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated) {
		
		this(decorated, 0);
	}
	
	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 * @param indentLevel the indent level
	 */
	protected QVTiLMTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated, int indentLevel) {
		
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#createNestedEvaluator()
	 */
	@Override
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		
		return new QVTiLMTracingEvaluationVisitor(super.createNestedEvaluator(), indentLevel);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern)
	 */
	@Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
		
		if (bottomPattern.getArea() instanceof CoreDomain) {
			logger.info(getIndent() + "Visiting CoreDomain BottomPattern");
		}
		if (bottomPattern.getArea() instanceof Mapping) {
			logger.info(getIndent() + "Visiting Mapping BottomPattern");
		}
		indentLevel++;
		Object result = delegate.visitBottomPattern(bottomPattern);
		for (Variable v : bottomPattern.getRealizedVariable()) {
			logger.info(getIndent() + "RealizedVariable " + v.getName() + ": " + prettyPrint((EObject) delegate.getEvaluationEnvironment().getValueOf(v)));
		}
		indentLevel--;
		if (bottomPattern.getArea() instanceof Mapping) {
			// After visiting the mapping bottom pattern, the middle model must have changed.
			if(verboseLevel == VERBOSE_LEVEL_HIGH) {
				// Print the middle model after each mapping
				logger.info("==============================");
				logger.info("Middle Model");
				for (EObject eo : ((QVTiModelManager)delegate.getModelManager()).getMiddleModelElements()) {
					logger.info(prettyPrintUnident(eo));
				}
				logger.info("==============================");
			}
		}
		return result;
	}
}
