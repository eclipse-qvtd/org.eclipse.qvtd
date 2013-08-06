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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;


/**
 * The Class QVTiTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public class QVTiMRTracingEvaluationVisitor extends QVTiAbstractTracingEvaluationVisitor
{
	
	/** The indent level. */
	private int indentLevel = 0;	

	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 */
	public QVTiMRTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated) {
		
		this(decorated, 0);
	}
	
	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 * @param indentLevel the indent level
	 */
	protected QVTiMRTracingEvaluationVisitor(@NonNull QVTiEvaluationVisitor decorated, int indentLevel) {
		
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#createNestedEvaluator()
	 */
	@Override
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		
		return new QVTiMRTracingEvaluationVisitor(super.createNestedEvaluator(), indentLevel);
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
		if (bottomPattern.getArea() instanceof Mapping) {
			// Print the domain realized variables to see their attributes
			for(Domain d : ((Mapping)bottomPattern.getArea()).getDomain()) {
				logger.info(getIndent() + "RealizedVariables for CoreDomain " + d.getName());
				indentLevel++;
				for (Variable v : ((Area)d).getBottomPattern().getRealizedVariable()) {
					logger.info(getIndent() + "RealizedVariable " + v.getName() + ": " + prettyPrint((EObject) delegate.getEvaluationEnvironment().getValueOf(v)));
				}
				indentLevel--;
			}
		}
		indentLevel--;
		if (bottomPattern.getArea() instanceof Mapping) {
			// After visiting the mapping bottom pattern, the middle model must have changed.
			if(verboseLevel == VERBOSE_LEVEL_HIGH) {
				// Print the output model after each mapping
				logger.info("==============================");
				logger.info("Output Model");
				TypedModel tm = ((Mapping)bottomPattern.getArea()).getDomain().get(0).getTypedModel();
				for (EObject eo : ((QVTiModelManager)delegate.getModelManager()).getTypeModelEObjectList(tm)) {
					logger.info(prettyPrintUnident(eo));
				}
				logger.info("==============================");
			}
		}
		return result;
	}
}
