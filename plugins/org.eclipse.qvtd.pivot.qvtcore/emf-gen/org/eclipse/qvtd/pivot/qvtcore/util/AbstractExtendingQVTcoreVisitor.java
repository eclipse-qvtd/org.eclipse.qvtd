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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTcoreVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractExtendingQVTbaseVisitor<R, C>
	implements QVTcoreVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTcoreVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.Assignment object) {
		return visitElement(object);
	}

	public @Nullable R visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.BottomPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable R visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreDomain object) {
		return visitDomain(object);
	}

	public @Nullable R visitCoreModel(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return visitBaseModel(object);
	}

	public @Nullable R visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.CorePattern object) {
		return visitPattern(object);
	}

	public @Nullable R visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object) {
		return visitElement(object);
	}

	public @Nullable R visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.GuardPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return visitRule(object);
	}

	public @Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtcore.MappingCall object) {
		return visitOCLExpression(object);
	}

	public @Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding object) {
		return visitTypedElement(object);
	}

	public @Nullable R visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object) {
		return visitAssignment(object);
	}

	public @Nullable R visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object) {
		return visitVariable(object);
	}

	public @Nullable R visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object) {
		return visitAssignment(object);
	}
}
