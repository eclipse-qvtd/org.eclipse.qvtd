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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS;
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
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl;

public class QVTrelationContainmentVisitor extends AbstractQVTrelationContainmentVisitor
{
	private static final class OperationOrRuleFilter implements ScopeFilter
	{
		public static OperationOrRuleFilter INSTANCE = new OperationOrRuleFilter();
		
		public int compareMatches(@NonNull DomainElement match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1,
				@NonNull DomainElement match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
			return 0;
		}

		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject) {
			return (eObject instanceof Operation) || (eObject instanceof Rule);
		}
	}

	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(@NonNull CS2PivotConversion context, @NonNull DomainCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			RelationDomain pDomain = PivotUtil.getPivot(RelationDomain.class, csElement);
			if (pDomain != null) {
				pDomain.setTypedModel(csElement.getModelId());
			}
			return null;
		}
	}

	protected static class KeyDeclContentContinuation extends SingleContinuation<KeyDeclCS>
	{
		private KeyDeclContentContinuation(@NonNull CS2PivotConversion context, @NonNull KeyDeclCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Key pKey = PivotUtil.getPivot(Key.class, csElement);
			if (pKey != null) {
				pKey.setIdentifies(csElement.getClassId());
				PivotUtil.refreshList(pKey.getPart(), csElement.getPropertyIds());
//				PivotUtil.refreshList(pKey.getOppositePart(), csElement.getPropertyId());
			}
			return null;
		}
	}

	protected static class ModelDeclContentContinuation extends SingleContinuation<ModelDeclCS>
	{
		private ModelDeclContentContinuation(@NonNull CS2PivotConversion context, @NonNull ModelDeclCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			if (pTypedModel != null) {
				List<org.eclipse.ocl.examples.pivot.Package> newUsedPackage = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
				for (Namespace metaModelId : csElement.getMetaModelIds()) {
					if (metaModelId instanceof Root) {
						newUsedPackage.addAll(((Root)metaModelId).getNestedPackage());
					}
					else if (metaModelId instanceof org.eclipse.ocl.examples.pivot.Package) {
						newUsedPackage.add((org.eclipse.ocl.examples.pivot.Package)metaModelId);
					}
				}
				PivotUtil.refreshList(pTypedModel.getUsedPackage(), newUsedPackage);
			}
			return null;
		}
	}

	protected static class RelationDomainAssignmentContentContinuation extends SingleContinuation<DefaultValueCS>
	{
		private RelationDomainAssignmentContentContinuation(@NonNull CS2PivotConversion context, @NonNull DefaultValueCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			RelationDomainAssignment pDomain = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
			if (pDomain != null) {
				pDomain.setVariable(csElement.getPropertyId());
			}
			return null;
		}
	}

	public QVTrelationContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	private void gatherVariables(List<Variable> pivotVariables, TemplateExp templateExp) {
		Variable variable = templateExp.getBindsTo();
		if (variable != null) {
			pivotVariables.add(variable);
		}
		if (templateExp instanceof ObjectTemplateExp) {
			for (PropertyTemplateItem part : ((ObjectTemplateExp)templateExp).getPart()) {
				OCLExpression value = part.getValue();
				if (value instanceof TemplateExp) {
					gatherVariables(pivotVariables, (TemplateExp)value);
				}
			}
		}
		else if (templateExp instanceof CollectionTemplateExp) {
			CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)templateExp;
			for (OCLExpression member : collectionTemplateExp.getMember()) {
//				OCLExpression value = part.getValue();
				if (member instanceof TemplateExp) {
					gatherVariables(pivotVariables, (TemplateExp)member);
				}
				else if (member instanceof VariableExp) {
					Variable variableDeclaration = (Variable) ((VariableExp)member).getReferredVariable();
					if (variableDeclaration != null) {
						pivotVariables.add(variableDeclaration);
					}
				}
			}
			Variable rest = collectionTemplateExp.getRest();
			if ((rest != null)  && rest.isImplicit()) {
				pivotVariables.add(rest);
			}
		}
	}

	@Override
	public Continuation<?> visitAbstractDomainCS(@NonNull AbstractDomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		CollectionTemplateExp pivotElement = context.refreshModelElement(CollectionTemplateExp.class, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, csElement);
		if (pivotElement != null) {
			Variable variable = pivotElement.getBindsTo();
			if (variable == null) {
				variable = DomainUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
				pivotElement.setBindsTo(variable);
			}
			context.refreshName(variable, DomainUtil.nonNullState(csElement.getName()));
			if (((CollectionTemplateCSImpl)csElement).basicGetRestIdentifier() == null) {
				variable = pivotElement.getRest();
				if (variable == null) {
					variable = PivotFactory.eINSTANCE.createVariable();
					pivotElement.setRest(variable);
				}
				variable.setImplicit(true);
			}
//			variable = pivotElement.getRest();
//			if (variable == null) {
//				variable = PivotFactory.eINSTANCE.createVariable();
//				pivotElement.setRest(variable);
//			}
//			context.refreshName(variable, csElement.getRestIdentifier());
			context.refreshPivotList(OCLExpression.class, pivotElement.getMember(), csElement.getMemberIdentifiers());
		}
		return null;
	}

	@Override
	public Continuation<?> visitDefaultValueCS(@NonNull DefaultValueCS csElement) {
		@SuppressWarnings("unused")
		RelationDomainAssignment pivotElement = context.refreshModelElement(RelationDomainAssignment.class, QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT, csElement);
		return new RelationDomainAssignmentContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		if (pivotElement != null) {
			pivotElement.setPattern(PivotUtil.getPivot(DomainPattern.class, csElement.getPattern()));
			context.refreshPivotList(RelationDomainAssignment.class, pivotElement.getDefaultAssignment(), csElement.getDefaultValues());
		}
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitDomainPatternCS(@NonNull DomainPatternCS csElement) {
		DomainPattern pivotElement = context.refreshModelElement(DomainPattern.class, QVTrelationPackage.Literals.DOMAIN_PATTERN, csElement);
		if (pivotElement != null) {
			pivotElement.setTemplateExpression(PivotUtil.getPivot(TemplateExp.class, csElement.getTemplate()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitElementTemplateCS(@NonNull ElementTemplateCS csElement) {
		VariableExp pivotElement = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csElement);
		if (pivotElement != null) {
			VariableDeclaration variable = pivotElement.getReferredVariable();
			if (variable == null) {
				variable = DomainUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
				pivotElement.setReferredVariable(variable);
			}
			context.refreshName(variable, DomainUtil.nonNullState(csElement.getName()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS csElement) {
		PathNameCS csPathName = DomainUtil.nonNullState(csElement.getPathName());
		CS2Pivot.setElementType(csPathName, PivotPackage.Literals.PACKAGE, csElement, null);
		super.visitImportCS(csElement);
		Unit pivotElement = refreshNamedElement(Unit.class, QVTbasePackage.Literals.UNIT, csElement);
		if (pivotElement != null) {
			Namespace namespace = csElement.getNamespace();
			pivotElement.setUsedPackage(namespace);
		}
		return null;
	}

	@Override
	public Continuation<?> visitInvocationExpCS(@NonNull InvocationExpCS csElement) {
		PathNameCS csPathName = DomainUtil.nonNullState(csElement.getPathName());
		CS2Pivot.setElementType(csPathName, PivotPackage.Literals.NAMED_ELEMENT, csElement, OperationOrRuleFilter.INSTANCE);
		return null;
	}

	@Override
	public Continuation<?> visitKeyDeclCS(@NonNull KeyDeclCS csElement) {
		PathNameCS csPathName = DomainUtil.nonNullState(csElement.getPathName());
		CS2Pivot.setElementType(csPathName, PivotPackage.Literals.CLASS, csElement, null);
		@SuppressWarnings("unused")
		Key pivotElement = context.refreshModelElement(Key.class, QVTrelationPackage.Literals.KEY, csElement);
		return new KeyDeclContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitLibraryCS(@NonNull LibraryCS csElement) {
		csElement.getPackage();					// Resolve the proxy to perform the import.
		return null;
	}

	@Override
	public Continuation<?> visitModelDeclCS(@NonNull ModelDeclCS csElement) {
		@SuppressWarnings("unused")
		TypedModel pivotElement = refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return new ModelDeclContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		ObjectTemplateExp pivotElement = context.refreshModelElement(ObjectTemplateExp.class, QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP, csElement);
		if (pivotElement != null) {
			Variable variable = pivotElement.getBindsTo();
			if (variable == null) {
				variable = DomainUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
				pivotElement.setBindsTo(variable);
			}
			context.refreshName(variable, DomainUtil.nonNullState(csElement.getName()));
			context.refreshPivotList(PropertyTemplateItem.class, pivotElement.getPart(), csElement.getPropertyTemplates());
		}
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		@SuppressWarnings("unused")
		Parameter pivotElement = refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPatternCS(@NonNull PatternCS csElement) {
		Pattern pivotElement = context.refreshModelElement(Pattern.class, QVTbasePackage.Literals.PATTERN, csElement);
		if (pivotElement != null) {
			context.refreshPivotList(Predicate.class, pivotElement.getPredicate(), csElement.getPredicates());
		}
		return null;
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		@SuppressWarnings("unused")
		Predicate pivotElement = context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeDomainCS(@NonNull PrimitiveTypeDomainCS csElement) {
		@SuppressWarnings("unused")
		RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(@NonNull PropertyTemplateCS csElement) {
		PropertyTemplateItem pivotElement = context.refreshModelElement(PropertyTemplateItem.class, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM, csElement);
		if (pivotElement != null) {
			ExpCS csExp = csElement.getExpression();
			if (csExp instanceof TemplateCS) {
				pivotElement.setValue(PivotUtil.getPivot(TemplateExp.class, csExp));
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		if (pivotElement != null) {
			context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getInputParamDeclarations());
		}
		return null;
	}

	@Override
	public Continuation<?> visitRelationCS(@NonNull RelationCS csElement) {
		Relation pivotElement = refreshNamedElement(Relation.class, QVTrelationPackage.Literals.RELATION, csElement);
		if (pivotElement != null) {
			context.refreshPivotList(Domain.class, pivotElement.getDomain(), csElement.getDomains());
			List<Variable> pivotVariables = new ArrayList<Variable>();
			for (VarDeclarationCS csVarDeclarations : csElement.getVarDeclarations()) {
				for (VarDeclarationIdCS csVarDeclarationId : csVarDeclarations.getVarDeclarationIds()) {
					pivotVariables.add(PivotUtil.getPivot(Variable.class, csVarDeclarationId));
				}
			}
			for (Domain domain : pivotElement.getDomain()) {
				DomainPattern pattern = ((RelationDomain)domain).getPattern();
				if (pattern != null) {
					TemplateExp templateExpression = pattern.getTemplateExpression();
					if (templateExpression != null) {
						gatherVariables(pivotVariables, templateExpression);
					}
				}
			}
			PivotUtil.refreshList(pivotElement.getVariable(), pivotVariables);
			pivotElement.setWhen(PivotUtil.getPivot(Pattern.class, csElement.getWhen()));
			pivotElement.setWhere(PivotUtil.getPivot(Pattern.class, csElement.getWhere()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitTemplateCS(@NonNull TemplateCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateVariableCS(@NonNull TemplateVariableCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
//		importPackages(csElement);
		RelationModel pivotElement = refreshRoot(RelationModel.class, QVTrelationPackage.Literals.RELATION_MODEL, csElement);
		context.refreshPivotList(Transformation.class, pivotElement.getNestedPackage(), csElement.getTransformations());
		context.refreshPivotList(Unit.class, pivotElement.getUnit(), csElement.getOwnedImport());
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

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		RelationalTransformation pivotElement = refreshPackage(RelationalTransformation.class, QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION, csElement);
		context.refreshPivotList(Key.class, pivotElement.getOwnedKey(), csElement.getKeyDecls());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getModelDecls());
		context.refreshPivotList(Relation.class, pivotElement.getRule(), csElement.getRelation());
		context.refreshPivotList(Operation.class, pivotElement.getOwnedOperation(), csElement.getQueries());
		return null;
	}

	@Override
	public Continuation<?> visitUnitCS(@NonNull UnitCS csElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Continuation<?> visitVarDeclarationCS(@NonNull VarDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitVarDeclarationIdCS(@NonNull VarDeclarationIdCS csElement) {
		@SuppressWarnings("unused")
		Variable pivotElement = refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}