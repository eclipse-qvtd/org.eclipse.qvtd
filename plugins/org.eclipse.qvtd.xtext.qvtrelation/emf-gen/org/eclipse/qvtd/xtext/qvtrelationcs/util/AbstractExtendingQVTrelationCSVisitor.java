/*******************************************************************************
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
 * from: org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtrelationcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTrelationCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTrelationCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
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

	@Override
	public @Nullable R visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS object) {
		return visitTemplateCS(object);
	}

	@Override
	public @Nullable R visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS object) {
		return visitAbstractDomainCS(object);
	}

	@Override
	public @Nullable R visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS object) {
		return visitTemplateVariableCS(object);
	}

	@Override
	public @Nullable R visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS object) {
		return visitTemplateCS(object);
	}

	@Override
	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS object) {
		return visitTemplateVariableCS(object);
	}

	@Override
	public @Nullable R visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	@Override
	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS object) {
		return visitClassCS(object);
	}

	@Override
	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS object) {
		return visitNamedElementCS(object);
	}
}
