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

/**
 * An AbstractDelegatingQVTrelationCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTrelationCSVisitor<R, C, D extends QVTrelationCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTrelationCSVisitor<R>
{
	protected AbstractDelegatingQVTrelationCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull AbstractDomainCS object) {
		return delegate.visitAbstractDomainCS(object);
	}

	@Override
	public R visitCollectionTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull CollectionTemplateCS object) {
		return delegate.visitCollectionTemplateCS(object);
	}

	@Override
	public R visitDefaultValueCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DefaultValueCS object) {
		return delegate.visitDefaultValueCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public R visitDomainPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainPatternCS object) {
		return delegate.visitDomainPatternCS(object);
	}

	@Override
	public R visitElementTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ElementTemplateCS object) {
		return delegate.visitElementTemplateCS(object);
	}

	@Override
	public R visitKeyDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull KeyDeclCS object) {
		return delegate.visitKeyDeclCS(object);
	}

	@Override
	public R visitModelDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ModelDeclCS object) {
		return delegate.visitModelDeclCS(object);
	}

	@Override
	public R visitObjectTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ObjectTemplateCS object) {
		return delegate.visitObjectTemplateCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public R visitPrimitiveTypeDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PrimitiveTypeDomainCS object) {
		return delegate.visitPrimitiveTypeDomainCS(object);
	}

	@Override
	public R visitPropertyTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PropertyTemplateCS object) {
		return delegate.visitPropertyTemplateCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public R visitRelationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull RelationCS object) {
		return delegate.visitRelationCS(object);
	}

	@Override
	public R visitTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateCS object) {
		return delegate.visitTemplateCS(object);
	}

	@Override
	public R visitTemplateVariableCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateVariableCS object) {
		return delegate.visitTemplateVariableCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public R visitUnitCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull UnitCS object) {
		return delegate.visitUnitCS(object);
	}

	@Override
	public R visitVarDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationCS object) {
		return delegate.visitVarDeclarationCS(object);
	}

	@Override
	public R visitVarDeclarationIdCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationIdCS object) {
		return delegate.visitVarDeclarationIdCS(object);
	}
}
