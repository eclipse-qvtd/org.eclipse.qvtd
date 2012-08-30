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
 * from: /org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtcorecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTcoreCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTcoreCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreCSVisitor<R>
{
    protected AbstractExtendingDelegatingQVTcoreCSVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public @Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public @Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public @Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
