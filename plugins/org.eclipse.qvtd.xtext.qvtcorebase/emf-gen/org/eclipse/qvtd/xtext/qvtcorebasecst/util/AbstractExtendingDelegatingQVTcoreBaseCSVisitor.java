/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/QVTcoreBaseCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtcorebasecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTcoreBaseCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTcoreBaseCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreBaseCSVisitor<R>
{
	protected AbstractExtendingDelegatingQVTcoreBaseCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public @Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public @Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
