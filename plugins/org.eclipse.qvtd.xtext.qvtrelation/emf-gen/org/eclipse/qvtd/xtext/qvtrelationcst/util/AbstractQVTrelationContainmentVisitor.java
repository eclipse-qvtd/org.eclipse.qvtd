/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * from: org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCST.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtrelationcst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLContainmentVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractQVTrelationContainmentVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationContainmentVisitor
	extends EssentialOCLContainmentVisitor
	implements QVTrelationCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	public @Nullable Continuation<?> visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS csElement) {
		return visitAbstractDomainCS(csElement);
	}

	public @Nullable Continuation<?> visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	public @Nullable Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
