/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtrelationcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTrelationCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTrelationCSVisitor<R, C, D extends QVTrelationCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTrelationCSVisitor<R>
{
	protected AbstractDelegatingQVTrelationCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS object) {
		return delegate.visitAbstractDomainCS(object);
	}

	@Override
	public @Nullable R visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS object) {
		return delegate.visitCollectionTemplateCS(object);
	}

	@Override
	public @Nullable R visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS object) {
		return delegate.visitDefaultValueCS(object);
	}

	@Override
	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public @Nullable R visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS object) {
		return delegate.visitDomainPatternCS(object);
	}

	@Override
	public @Nullable R visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS object) {
		return delegate.visitElementTemplateCS(object);
	}

	@Override
	public @Nullable R visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS object) {
		return delegate.visitKeyDeclCS(object);
	}

	@Override
	public @Nullable R visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS object) {
		return delegate.visitModelDeclCS(object);
	}

	@Override
	public @Nullable R visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS object) {
		return delegate.visitObjectTemplateCS(object);
	}

	@Override
	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public @Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS object) {
		return delegate.visitPrimitiveTypeDomainCS(object);
	}

	@Override
	public @Nullable R visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS object) {
		return delegate.visitPropertyTemplateCS(object);
	}

	@Override
	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public @Nullable R visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS object) {
		return delegate.visitRelationCS(object);
	}

	@Override
	public @Nullable R visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS object) {
		return delegate.visitTemplateCS(object);
	}

	@Override
	public @Nullable R visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS object) {
		return delegate.visitTemplateVariableCS(object);
	}

	@Override
	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	@Override
	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS object) {
		return delegate.visitUnitCS(object);
	}

	@Override
	public @Nullable R visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS object) {
		return delegate.visitVarDeclarationCS(object);
	}

	@Override
	public @Nullable R visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS object) {
		return delegate.visitVarDeclarationIdCS(object);
	}
}
