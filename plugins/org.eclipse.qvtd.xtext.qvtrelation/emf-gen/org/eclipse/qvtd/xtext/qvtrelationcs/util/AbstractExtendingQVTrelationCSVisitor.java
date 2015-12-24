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
	protected AbstractExtendingQVTrelationCSVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAbstractDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull AbstractDomainCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitCollectionTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull CollectionTemplateCS object) {
		return visitTemplateCS(object);
	}

	@Override
	public R visitDefaultValueCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DefaultValueCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainCS object) {
		return visitAbstractDomainCS(object);
	}

	@Override
	public R visitDomainPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainPatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitElementTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ElementTemplateCS object) {
		return visitTemplateVariableCS(object);
	}

	@Override
	public R visitKeyDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull KeyDeclCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitModelDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ModelDeclCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitObjectTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ObjectTemplateCS object) {
		return visitTemplateCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PredicateCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitPrimitiveTypeDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PrimitiveTypeDomainCS object) {
		return visitTemplateVariableCS(object);
	}

	@Override
	public R visitPropertyTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PropertyTemplateCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull QueryCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitRelationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull RelationCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitTemplateVariableCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateVariableCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TransformationCS object) {
		return visitClassCS(object);
	}

	@Override
	public R visitUnitCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull UnitCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitVarDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitVarDeclarationIdCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationIdCS object) {
		return visitNamedElementCS(object);
	}
}
