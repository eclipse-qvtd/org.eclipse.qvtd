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

// TODO Implement all this!!
/**
 * The Class QVTiTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public class QVTiTracingEvaluationVisitorMM extends QVTiAbstractTracingEvaluationVisitor
{
	
	/** The indent level. */
	private int indentLevel = 0;	

	public QVTiTracingEvaluationVisitorMM(QVTiEvaluationVisitor decorated) {
		super(decorated);
		// TODO Auto-generated constructor stub
	}

	
	
}
