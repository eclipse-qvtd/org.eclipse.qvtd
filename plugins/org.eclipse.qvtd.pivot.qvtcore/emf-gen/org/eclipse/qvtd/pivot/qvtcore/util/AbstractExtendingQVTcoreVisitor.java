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
 * from: /org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcore.util;

/**
 * An AbstractExtendingQVTcoreVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractExtendingQVTbaseVisitor<R, C>
	implements QVTcoreVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTcoreVisitor(C context) {
	    super(context);
	}	

	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.Assignment object) {
		return visitElement(object);
	}

	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.BottomPattern object) {
		return visitCorePattern(object);
	}

	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.CoreDomain object) {
		return visitDomain(object);
	}

	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return visitModel(object);
	}

	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.CorePattern object) {
		return visitPattern(object);
	}

	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object) {
		return visitElement(object);
	}

	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.GuardPattern object) {
		return visitCorePattern(object);
	}

	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return visitRule(object);
	}

	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object) {
		return visitAssignment(object);
	}

	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object) {
		return visitVariable(object);
	}

	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object) {
		return visitAssignment(object);
	}
}
