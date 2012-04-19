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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.AnyElementCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.WhenCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.WhereCS;

public class QVTrelationContainmentVisitor extends AbstractQVTrelationContainmentVisitor
{
	public QVTrelationContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}

	public Continuation<?> visitAbstractDomainCS(AbstractDomainCS csElement) {
		return null;
	}

	public Continuation<?> visitAnyElementCS(AnyElementCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Continuation<?> visitCollectionTemplateCS(CollectionTemplateCS csElement) {
		CollectionTemplateExp pivotElement = context.refreshModelElement(CollectionTemplateExp.class, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, csElement);
		return null;
	}

	public Continuation<?> visitDefaultValueCS(DefaultValueCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Continuation<?> visitDomainCS(DomainCS csElement) {
		RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		pivotElement.setPattern(PivotUtil.getPivot(DomainPattern.class, csElement.getTemplate()));
		return null;
	}

	@Override
	public Continuation<?> visitImportCS(ImportCS csElement) {
		csElement.getNamespace();					// Resolve the proxy to perform the import.
		return null;
	}

	public Continuation<?> visitKeyDeclCS(KeyDeclCS csElement) {
		Key pivotElement = context.refreshModelElement(Key.class, QVTrelationPackage.Literals.KEY, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitLibraryCS(LibraryCS csElement) {
		csElement.getPackage();					// Resolve the proxy to perform the import.
		return null;
	}

	public Continuation<?> visitModelDeclCS(ModelDeclCS csElement) {
		TypedModel pivotElement = refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return null;
	}

	public Continuation<?> visitObjectTemplateCS(ObjectTemplateCS csElement) {
		ObjectTemplateExp pivotElement = context.refreshModelElement(ObjectTemplateExp.class, QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP, csElement);
		return null;
	}

	public Continuation<?> visitParamDeclarationCS(ParamDeclarationCS csElement) {
		Parameter pivotElement = refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csElement);
		return null;
	}

	public Continuation<?> visitPrimitiveTypeDomainCS(PrimitiveTypeDomainCS csElement) {
		RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		return null;
	}

	public Continuation<?> visitPropertyTemplateCS(PropertyTemplateCS csElement) {
		PropertyTemplateItem pivotElement = context.refreshModelElement(PropertyTemplateItem.class, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM, csElement);
		return null;
	}

	public Continuation<?> visitQueryCS(QueryCS csElement) {
		Function pivotElement = context.refreshModelElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getInputParamDeclaration());
		return null;
	}

	public Continuation<?> visitRelationCS(RelationCS csElement) {
		Relation pivotElement = refreshNamedElement(Relation.class, QVTrelationPackage.Literals.RELATION, csElement);
		context.refreshPivotList(Domain.class, pivotElement.getDomain(), csElement.getDomain());
		pivotElement.setWhen(PivotUtil.getPivot(DomainPattern.class, csElement.getWhen()));
		pivotElement.setWhere(PivotUtil.getPivot(DomainPattern.class, csElement.getWhere()));
		return null;
	}

	public Continuation<?> visitTemplateCS(TemplateCS csElement) {
		return null;
	}

	public Continuation<?> visitTemplateVariableCS(TemplateVariableCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Continuation<?> visitTopLevelCS(TopLevelCS csElement) {
//		importPackages(csElement);
		RelationModel pivotElement = refreshPackage(RelationModel.class, QVTrelationPackage.Literals.RELATION_MODEL, csElement);
		context.refreshPivotList(Transformation.class, pivotElement.getNestedPackage(), csElement.getTransformation());
/*		List<TransformationCS> csTransformations = csElement.getTransformation();
		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
			txList.add(pTransformation);
		}
		org.eclipse.ocl.examples.pivot.Package pPackage = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csElement);
		PivotUtil.refreshList(pPackage.getNestedPackage(), txList);
		//
		for (MappingCS csMapping : csElement.getMappings()) {
			Transformation inTransformation = csMapping.getIn();
			List<Mapping> mappings = tx2mappings.get(inTransformation);
			if (mappings != null) {
				Mapping pMapping = PivotUtil.getPivot(Mapping.class, csMapping);
				if (pMapping != null) {
					mappings.add(pMapping);
				}
			}
		}
		for (Transformation pTransformation : tx2mappings.keySet()) {
			PivotUtil.refreshList(pTransformation.getRule(), tx2mappings.get(pTransformation));
		}
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage()); */
		return null;
	}

	public Continuation<?> visitTransformationCS(TransformationCS csElement) {
		RelationalTransformation pivotElement = refreshPackage(RelationalTransformation.class, QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION, csElement);
		context.refreshPivotList(Key.class, pivotElement.getOwnedKey(), csElement.getKeyDecl());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getModelDecl());
		context.refreshPivotList(Relation.class, pivotElement.getRule(), csElement.getRelation());
		return null;
	}

	public Continuation<?> visitUnitCS(UnitCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Continuation<?> visitVarDeclarationCS(VarDeclarationCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	public Continuation<?> visitWhenCS(WhenCS csElement) {
		DomainPattern pivotElement = context.refreshModelElement(DomainPattern.class, QVTrelationPackage.Literals.DOMAIN_PATTERN, csElement);
		return null;
	}

	public Continuation<?> visitWhereCS(WhereCS csElement) {
		DomainPattern pivotElement = context.refreshModelElement(DomainPattern.class, QVTrelationPackage.Literals.DOMAIN_PATTERN, csElement);
		return null;
	}	
}