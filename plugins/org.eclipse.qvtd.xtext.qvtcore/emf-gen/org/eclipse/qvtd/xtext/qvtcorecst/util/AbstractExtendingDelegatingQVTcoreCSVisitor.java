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

import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTcoreCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTcoreCSVisitor<R, C, D extends EssentialOCLCSVisitor<R, C>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreCSVisitor<R, C>
{
    protected AbstractExtendingDelegatingQVTcoreCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public R visitConstraintCS(org.eclipse.qvtd.xtext.qvtcorecst.ConstraintCS object) {
		return delegate.visitExpCS(object);
	}

	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return delegate.visitPackageCS(object);
	}

	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
