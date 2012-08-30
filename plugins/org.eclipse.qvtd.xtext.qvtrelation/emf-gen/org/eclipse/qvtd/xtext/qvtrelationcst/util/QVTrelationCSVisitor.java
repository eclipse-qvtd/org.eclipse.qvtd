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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTrelationCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAbstractDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS object);
	@Nullable R visitCollectionTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS object);
	@Nullable R visitDefaultValueCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS object);
	@Nullable R visitDomainPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS object);
	@Nullable R visitElementTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS object);
	@Nullable R visitKeyDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS object);
	@Nullable R visitModelDeclCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS object);
	@Nullable R visitObjectTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS object);
	@Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS object);
	@Nullable R visitPrimitiveTypeDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS object);
	@Nullable R visitPropertyTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS object);
	@Nullable R visitRelationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS object);
	@Nullable R visitTemplateCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS object);
	@Nullable R visitTemplateVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS object);
	@Nullable R visitUnitCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS object);
	@Nullable R visitVarDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS object);
	@Nullable R visitVarDeclarationIdCS(@NonNull org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS object);
}
