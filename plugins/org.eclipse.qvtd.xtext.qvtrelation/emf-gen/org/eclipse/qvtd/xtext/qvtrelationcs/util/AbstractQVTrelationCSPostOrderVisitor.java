/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtrelationcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;

/**
 * An AbstractQVTrelationCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationCSPostOrderVisitor
	extends EssentialOCLCSPostOrderVisitor
	implements QVTrelationCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS csElement) {
		return visitAbstractDomainCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
