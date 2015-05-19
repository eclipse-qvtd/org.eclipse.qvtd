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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractQVTrelationCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements QVTrelationCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Element visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS csElement) {
		return visitAbstractDomainCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Element visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Element visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
