/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtbase/model/QVTbaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtbasecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTbaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTbaseCSVisitor<R, C, @NonNull D extends QVTbaseCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTbaseCSVisitor<R>
{
	protected AbstractDelegatingQVTbaseCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractTransformationCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull AbstractTransformationCS object) {
		return delegate.visitAbstractTransformationCS(object);
	}

	@Override
	public R visitCompoundTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull CompoundTargetElementCS object) {
		return delegate.visitCompoundTargetElementCS(object);
	}

	@Override
	public R visitJavaClassCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull JavaClassCS object) {
		return delegate.visitJavaClassCS(object);
	}

	@Override
	public R visitJavaImplementationCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull JavaImplementationCS object) {
		return delegate.visitJavaImplementationCS(object);
	}

	@Override
	public R visitQualifiedPackageCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull QualifiedPackageCS object) {
		return delegate.visitQualifiedPackageCS(object);
	}

	@Override
	public R visitSimpleTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull SimpleTargetElementCS object) {
		return delegate.visitSimpleTargetElementCS(object);
	}

	@Override
	public R visitTargetCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull TargetCS object) {
		return delegate.visitTargetCS(object);
	}

	@Override
	public R visitTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull TargetElementCS object) {
		return delegate.visitTargetElementCS(object);
	}
}
