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

/**
 * An AbstractDelegatingQVTcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreCSVisitor<R, C, D extends QVTcoreCSVisitor<R, C>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreCSVisitor<R, C>
{
    protected AbstractDelegatingQVTcoreCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return delegate.visitAreaCS(object);
	}

	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return delegate.visitBottomPatternCS(object);
	}

	public R visitConstraintCS(org.eclipse.qvtd.xtext.qvtcorecst.ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	public R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return delegate.visitEnforcementOperationCS(object);
	}

	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return delegate.visitGuardPatternCS(object);
	}

	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return delegate.visitRealizeableVariableCS(object);
	}

	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return delegate.visitRealizedVariableCS(object);
	}

	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return delegate.visitUnrealizedVariableCS(object);
	}
}
