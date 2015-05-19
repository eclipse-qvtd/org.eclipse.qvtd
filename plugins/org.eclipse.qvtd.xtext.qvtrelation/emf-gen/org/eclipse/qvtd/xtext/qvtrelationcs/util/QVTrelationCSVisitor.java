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
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTrelationCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS object);
	@Nullable R visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS object);
	@Nullable R visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS object);
	@Nullable R visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS object);
	@Nullable R visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS object);
	@Nullable R visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS object);
	@Nullable R visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS object);
	@Nullable R visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS object);
	@Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS object);
	@Nullable R visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS object);
	@Nullable R visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS object);
	@Nullable R visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS object);
	@Nullable R visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS object);
	@Nullable R visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS object);
	@Nullable R visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS object);
	@Nullable R visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS object);
	@Nullable R visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS object);
}
