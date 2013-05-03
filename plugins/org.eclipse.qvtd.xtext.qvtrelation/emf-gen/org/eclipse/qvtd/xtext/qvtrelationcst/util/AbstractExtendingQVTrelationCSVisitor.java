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
 * from: model/QVTrelationCST.genmodel
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTrelationCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTrelationCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements QVTrelationCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTrelationCSVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS object) {
		return visitTemplateCS(object);
	}

	public @Nullable R visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS object) {
		return visitAbstractDomainCS(object);
	}

	public @Nullable R visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS object) {
		return visitTemplateVariableCS(object);
	}

	public @Nullable R visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS object) {
		return visitTemplateCS(object);
	}

	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS object) {
		return visitTemplateVariableCS(object);
	}

	public @Nullable R visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS object) {
		return visitTemplateVariableCS(object);
	}

	public @Nullable R visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS object) {
		return visitNamedElementCS(object);
	}
}
