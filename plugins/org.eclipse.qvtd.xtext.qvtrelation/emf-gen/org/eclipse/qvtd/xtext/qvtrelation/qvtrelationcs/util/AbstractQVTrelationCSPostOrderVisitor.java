/*******************************************************************************
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
 * from: org.eclipse.qvtd.xtext.qvtrelation/model/QVTrelationCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

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
	protected AbstractQVTrelationCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.AbstractDomainCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.CollectionTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	public @Nullable Continuation<?> visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DefaultValueCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainCS csElement) {
		return visitAbstractDomainCS(csElement);
	}

	public @Nullable Continuation<?> visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainPatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ElementTemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.KeyDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ModelDeclCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ObjectTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	public @Nullable Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PredicateCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PrimitiveTypeDomainCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PropertyTemplateCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.RelationCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TemplateVariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.UnitCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationIdCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
