/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtbase.util;

/**
 * An AbstractExtendingQVTbaseVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTbaseVisitor<R, C>
	extends org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor<R, C>
	implements QVTbaseVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTbaseVisitor(C context) {
	    super(context);
	}	

	public R visitDomain(org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return visitElement(object);
	}

	public R visitFunction(org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return visitOperation(object);
	}

	public R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return visitParameter(object);
	}

	public R visitPattern(org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return visitElement(object);
	}

	public R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return visitElement(object);
	}

	public R visitRule(org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return visitNamedElement(object);
	}

	public R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return visitClass(object);
	}

	public R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return visitNamedElement(object);
	}
}
