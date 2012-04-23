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
 * from: /org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtrelationcst.util;

import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTrelationCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTrelationCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTrelationCSVisitor<R>
{
    protected AbstractExtendingDelegatingQVTrelationCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAbstractDomainCS(org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitAnyElementCS(org.eclipse.qvtd.xtext.qvtrelationcst.AnyElementCS object) {
		return delegate.visitExpCS(object);
	}

	public R visitCollectionTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS object) {
		return visitTemplateCS(object);
	}

	public R visitDefaultValueCS(org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS object) {
		return visitAbstractDomainCS(object);
	}

	public R visitDomainPatternCS(org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitKeyDeclCS(org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitModelDeclCS(org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitObjectTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS object) {
		return visitTemplateCS(object);
	}

	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitPrimitiveTypeDomainCS(org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS object) {
		return visitTemplateVariableCS(object);
	}

	public R visitPropertyTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitRelationCS(org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS object) {
		return visitTemplateVariableCS(object);
	}

	public R visitTemplateVariableCS(org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS object) {
		return delegate.visitPackageCS(object);
	}

	public R visitUnitCS(org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitVarDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitVarDeclarationIdCS(org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS object) {
		return delegate.visitNamedElementCS(object);
	}
}
