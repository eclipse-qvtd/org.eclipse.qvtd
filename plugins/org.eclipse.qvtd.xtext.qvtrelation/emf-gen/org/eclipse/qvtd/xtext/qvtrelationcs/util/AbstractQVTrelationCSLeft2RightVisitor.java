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
	public @Nullable Element visitAbstractDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull AbstractDomainCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitCollectionTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull CollectionTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Element visitDefaultValueCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DefaultValueCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainCS csElement) {
		return visitAbstractDomainCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull DomainPatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitElementTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ElementTemplateCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitKeyDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull KeyDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitModelDeclCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ModelDeclCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitObjectTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ObjectTemplateCS csElement) {
		return visitTemplateCS(csElement);
	}

	@Override
	public @Nullable Element visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PredicateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPrimitiveTypeDomainCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PrimitiveTypeDomainCS csElement) {
		return visitTemplateVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitPropertyTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull PropertyTemplateCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitQueryCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRelationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull RelationCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTemplateCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitTemplateVariableCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TemplateVariableCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTopLevelCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitTransformationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull TransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Element visitUnitCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull UnitCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVarDeclarationCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitVarDeclarationIdCS(org.eclipse.qvtd.xtext.qvtrelationcs.@NonNull VarDeclarationIdCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
