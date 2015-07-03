/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.AbstractQVTrelationCSContainmentVisitor;

public class QVTrelationCSContainmentVisitor extends AbstractQVTrelationCSContainmentVisitor
{
	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(@NonNull CS2ASConversion context, @NonNull DomainCS csElement) {
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
		private KeyDeclContentContinuation(@NonNull CS2ASConversion context, @NonNull KeyDeclCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Key pKey = PivotUtil.getPivot(Key.class, csElement);
			if (pKey != null) {
				pKey.setIdentifies(csElement.getClassId());
				PivotUtilInternal.refreshList(pKey.getPart(), csElement.getPropertyIds());
				List<Property> oppositePart = new ArrayList<Property>();
				for (PathNameCS oppositePropertyId : csElement.getOwnedOppositePropertyIds()) {
					Element element = oppositePropertyId.getReferredElement();
					if (element instanceof Property) {
						oppositePart.add((Property) element);
					}
				}
				PivotUtilInternal.refreshList(pKey.getOppositePart(), oppositePart);
			}
			return null;
		}
	}

	protected static class ModelDeclContentContinuation extends SingleContinuation<ModelDeclCS>
	{
		private ModelDeclContentContinuation(@NonNull CS2ASConversion context, @NonNull ModelDeclCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			if (pTypedModel != null) {
				List<org.eclipse.ocl.pivot.Package> newUsedPackage = new ArrayList<org.eclipse.ocl.pivot.Package>();
				for (Namespace metamodelId : csElement.getMetamodelIds()) {
					if (metamodelId instanceof Model) {
						newUsedPackage.addAll(((Model)metamodelId).getOwnedPackages());
					}
					else if (metamodelId instanceof org.eclipse.ocl.pivot.Package) {
						newUsedPackage.add((org.eclipse.ocl.pivot.Package)metamodelId);
					}
				}
				PivotUtilInternal.refreshList(pTypedModel.getUsedPackage(), newUsedPackage);
			}
			return null;
		}
	}

	public QVTrelationCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	private void addVariable(@NonNull List<Variable> pivotVariables, @Nullable Variable variable) {
		if (variable != null) {
			if (variable.getName() == null) {
				variable.setName(QVTrelationUtil.DUMMY_VARIABLE_NAME + pivotVariables.size());
			}
			pivotVariables.add(variable);
		}
	}

	private void gatherVariables(@NonNull List<Variable> pivotVariables, @NonNull TemplateExp templateExp) {
		Variable variable = templateExp.getBindsTo();
		addVariable(pivotVariables, variable);
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
				if (member instanceof TemplateExp) {
					gatherVariables(pivotVariables, (TemplateExp)member);
				}
				else if (member instanceof VariableExp) {
					Variable variableDeclaration = (Variable) ((VariableExp)member).getReferredVariable();
					addVariable(pivotVariables, variableDeclaration);
				}
			}
			Variable rest = collectionTemplateExp.getRest();
			addVariable(pivotVariables, rest);
		}
	}

	protected @NonNull List<org.eclipse.ocl.pivot.Package> resolveTransformations(@NonNull List<TransformationCS> csTransformations, @NonNull BaseModel asCoreModel) {
		List<org.eclipse.ocl.pivot.Package> asPackages = new ArrayList<org.eclipse.ocl.pivot.Package>();
		Map<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Package>> package2ownedPackages = new HashMap<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Package>>();
		Map<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Class>> package2ownedClasses = new HashMap<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Class>>();
		for (TransformationCS csTransformation : csTransformations) {
			org.eclipse.ocl.pivot.Package asParent = null;
			Transformation asTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			asParent = NameUtil.getNameable(asCoreModel.getOwnedPackages(), "");
			if (asParent == null) {
				asParent = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, null);
				asParent.setName("");
			}
			asPackages.add(asParent);
			List<org.eclipse.ocl.pivot.Class> asNewTransformations = package2ownedClasses.get(asParent);
			if (asNewTransformations == null) {
				asNewTransformations = new ArrayList<org.eclipse.ocl.pivot.Class>();
				package2ownedClasses.put(asParent, asNewTransformations);
			}
			asNewTransformations.add(asTransformation);
		}
		for (org.eclipse.ocl.pivot.Package asPackage : package2ownedPackages.keySet()) {
			PivotUtilInternal.refreshList(asPackage.getOwnedPackages(), package2ownedPackages.get(asPackage));
		}
		for (org.eclipse.ocl.pivot.Package asPackage : package2ownedClasses.keySet()) {
			PivotUtilInternal.refreshList(asPackage.getOwnedClasses(), package2ownedClasses.get(asPackage));
		}
		return asPackages;
	}

	@Override
	public Continuation<?> visitAbstractDomainCS(@NonNull AbstractDomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		@NonNull CollectionTemplateExp pivotElement = context.refreshModelElement(CollectionTemplateExp.class, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, csElement);
		Variable variable = pivotElement.getBindsTo();
		if (variable == null) {
			variable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
			pivotElement.setBindsTo(variable);
		}
		context.refreshName(variable, csElement.getName());
		context.refreshPivotList(OCLExpression.class, pivotElement.getMember(), csElement.getOwnedMemberIdentifiers());
		pivotElement.setRest(PivotUtil.getPivot(Variable.class, csElement.getOwnedRestIdentifier()));
		return null;
	}

	@Override
	public Continuation<?> visitDefaultValueCS(@NonNull DefaultValueCS csElement) {
		context.refreshModelElement(RelationDomainAssignment.class, QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		@NonNull RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		List<DomainPattern> asPatterns = pivotElement.getPattern();
		context.refreshPivotList(DomainPattern.class, asPatterns, csElement.getOwnedPattern());
		context.refreshPivotList(RelationDomainAssignment.class, pivotElement.getDefaultAssignment(), csElement.getOwnedDefaultValues());
		if (asPatterns.size() > 0) {
			List<Variable> rootVariables = new ArrayList<Variable>();
			for (DomainPattern rootPattern : asPatterns) {
				if (rootPattern != null) {
					TemplateExp rootTemplate = rootPattern.getTemplateExpression();
					if (rootTemplate != null) {
						rootVariables.add(rootTemplate.getBindsTo());
					}
				}
			}
			PivotUtilInternal.refreshList(pivotElement.getRootVariable(), rootVariables);
			for (DomainPattern asPattern : asPatterns) {
				List<Variable> pivotVariables = new ArrayList<Variable>();
				if (asPattern != null) {
					TemplateExp templateExpression = asPattern.getTemplateExpression();
					if (templateExpression != null) {
						gatherVariables(pivotVariables, templateExpression);
					}
					PivotUtilInternal.refreshList(asPattern.getBindsTo(), pivotVariables);
				}
//				else {
//					pivotVariables.addAll(pivotElement.getRootVariable());
//				}
			}
		}
		else {
			pivotElement.getRootVariable().clear();
		}
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitDomainPatternCS(@NonNull DomainPatternCS csElement) {
		@NonNull DomainPattern pivotElement = context.refreshModelElement(DomainPattern.class, QVTrelationPackage.Literals.DOMAIN_PATTERN, csElement);
		pivotElement.setTemplateExpression(PivotUtil.getPivot(TemplateExp.class, csElement.getOwnedTemplate()));
		return null;
	}

	@Override
	public Continuation<?> visitElementTemplateCS(@NonNull ElementTemplateCS csElement) {
		if (csElement.eContainingFeature() == QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER) {
			@NonNull Variable asVariable = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
			context.refreshName(asVariable, csElement.getName());
			return null;
		}
		else {
			@NonNull VariableExp asVariableExp = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csElement);
			context.refreshName(asVariableExp, csElement.getName());
			VariableDeclaration asVariable = asVariableExp.getReferredVariable();
			if (asVariable == null) {
				asVariable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
				asVariableExp.setReferredVariable(asVariable);
			}
			context.refreshName(asVariable, csElement.getName());
			return null;
		}
	}

	@Override
	public Continuation<?> visitKeyDeclCS(@NonNull KeyDeclCS csElement) {
		PathNameCS csPathName = ClassUtil.nonNullState(csElement.getOwnedPathName());
		CS2AS.setElementType(csPathName, PivotPackage.Literals.CLASS, csElement, null);
		for (PathNameCS csOppositePropertyId : csElement.getOwnedOppositePropertyIds()) {
			if (csOppositePropertyId != null) {
				CS2AS.setElementType(csOppositePropertyId, PivotPackage.Literals.PROPERTY, csElement, null);
			}
		}
		@SuppressWarnings("unused")
		Key pivotElement = context.refreshModelElement(Key.class, QVTrelationPackage.Literals.KEY, csElement);
		return new KeyDeclContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitModelDeclCS(@NonNull ModelDeclCS csElement) {
		@SuppressWarnings("unused")
		TypedModel pivotElement = refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return new ModelDeclContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitObjectTemplateCS(@NonNull ObjectTemplateCS csElement) {
		@NonNull ObjectTemplateExp pivotElement = context.refreshModelElement(ObjectTemplateExp.class, QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP, csElement);
		Variable variable = pivotElement.getBindsTo();
		if (variable == null) {
			variable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
			pivotElement.setBindsTo(variable);
		}
		context.refreshName(variable, csElement.getName());
		context.refreshPivotList(PropertyTemplateItem.class, pivotElement.getPart(), csElement.getOwnedPropertyTemplates());
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
		@NonNull Pattern pivotElement = context.refreshModelElement(Pattern.class, QVTbasePackage.Literals.PATTERN, csElement);
		context.refreshPivotList(Predicate.class, pivotElement.getPredicate(), csElement.getOwnedPredicates());
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
		@NonNull RelationDomain pivotElement = context.refreshModelElement(RelationDomain.class, QVTrelationPackage.Literals.RELATION_DOMAIN, csElement);
		@NonNull DomainPattern asPattern = context.refreshModelElement(DomainPattern.class, QVTrelationPackage.Literals.DOMAIN_PATTERN, null);
		List<DomainPattern> asPatterns = new ArrayList<DomainPattern>();
		asPatterns.add(asPattern);
		PivotUtilInternal.refreshList(pivotElement.getPattern(), asPatterns);
		@NonNull TemplateExp template = context.refreshModelElement(TemplateExp.class, QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP, null);
		asPattern.setTemplateExpression(template);
		@NonNull Variable rootVariable = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, null);
		context.refreshName(rootVariable, csElement.getName());
		template.setBindsTo(rootVariable);
		List<Variable> rootVariables = new ArrayList<Variable>();
		rootVariables.add(rootVariable);
		PivotUtilInternal.refreshList(pivotElement.getRootVariable(), rootVariables);
		List<Variable> pivotVariables = new ArrayList<Variable>();
		pivotVariables.add(rootVariable);
		PivotUtilInternal.refreshList(asPattern.getBindsTo(), pivotVariables);
		return null;
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(@NonNull PropertyTemplateCS csElement) {
		PathNameCS csOppositePropertyId = csElement.getOwnedOppositePropertyId();
		if (csOppositePropertyId != null) {
			CS2AS.setElementType(csOppositePropertyId, PivotPackage.Literals.PROPERTY, csElement, null);
		}
		@NonNull PropertyTemplateItem pivotElement = context.refreshModelElement(PropertyTemplateItem.class, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM, csElement);
		ExpCS csExp = csElement.getOwnedExpression();
		if (csExp instanceof TemplateCS) {
			pivotElement.setValue(PivotUtil.getPivot(TemplateExp.class, csExp));
		}
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public Continuation<?> visitRelationCS(@NonNull RelationCS csElement) {
		@NonNull Relation pivotElement = refreshNamedElement(Relation.class, QVTrelationPackage.Literals.RELATION, csElement);
		context.refreshPivotList(Domain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		boolean explicitCheckonly = false;
		boolean explicitEnforce = false;
		for (AbstractDomainCS abstractDomainCS : csElement.getOwnedDomains()) {
			if (abstractDomainCS instanceof DomainCS) {
				DomainCS domainCS = (DomainCS) abstractDomainCS;
				if (domainCS.isIsCheckonly())
					explicitCheckonly = true;
				if (domainCS.isIsEnforce())
					explicitEnforce = true;
			}
		}
		for (AbstractDomainCS abstractDomainCS : csElement.getOwnedDomains()) {
			Domain domain = PivotUtil.getPivot(Domain.class, abstractDomainCS);
			if (domain != null) {
				boolean isCheckable = true;
				boolean isEnforceable = true;
				if (abstractDomainCS instanceof DomainCS) {
					DomainCS domainCS = (DomainCS) abstractDomainCS;
					isCheckable = !explicitCheckonly || domainCS.isIsCheckonly();
					isEnforceable = !explicitEnforce || domainCS.isIsEnforce();
				}
				domain.setIsCheckable(isCheckable);
				domain.setIsEnforceable(isEnforceable);
			}
		}
		List<Variable> pivotVariables = new ArrayList<Variable>();
		for (VarDeclarationCS csVarDeclarations : csElement.getOwnedVarDeclarations()) {
			for (VarDeclarationIdCS csVarDeclarationId : csVarDeclarations.getOwnedVarDeclarationIds()) {
				pivotVariables.add(PivotUtil.getPivot(Variable.class, csVarDeclarationId));
			}
		}
		for (Domain domain : pivotElement.getDomain()) {
			RelationDomain relationDomain = (RelationDomain)domain;
			for (DomainPattern pattern : relationDomain.getPattern()) {
				if (pattern != null) {
					pivotVariables.addAll(pattern.getBindsTo());
				}
			}
		}
		PivotUtilInternal.refreshList(pivotElement.getVariable(), pivotVariables);
		pivotElement.setWhen(PivotUtil.getPivot(Pattern.class, csElement.getOwnedWhen()));
		pivotElement.setWhere(PivotUtil.getPivot(Pattern.class, csElement.getOwnedWhere()));
		pivotElement.setIsTopLevel(csElement.isIsTop());
		pivotElement.setIsDefault(csElement.isIsDefault());
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
		RelationModel asModel = refreshRoot(RelationModel.class, QVTrelationPackage.Literals.RELATION_MODEL, csElement);
		List<TransformationCS> csTransformations = csElement.getOwnedTransformations();
		List<org.eclipse.ocl.pivot.Package> asPackages = resolveTransformations(csTransformations, asModel);
		PivotUtilInternal.refreshList(asModel.getOwnedPackages(), asPackages);
//		context.refreshPivotList(Transformation.class, pivotElement.getOwnedTransformations(), csElement.getTransformations());
		context.refreshPivotList(Import.class, asModel.getOwnedImports(), csElement.getOwnedImports());
/*		List<TransformationCS> csTransformations = csElement.getTransformation();
		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
			txList.add(pTransformation);
		}
		org.eclipse.ocl.pivot.Package pPackage = PivotUtil.getPivot(org.eclipse.ocl.pivot.Package.class, csElement);
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
//		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage()); */
		Resource asResource = asModel.eResource();
		if (asResource == null) {
			Resource csResource = csElement.eResource();
			if (csResource instanceof BaseCSResource) {
				context.installRootElement((BaseCSResource)csResource, asModel);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION;
		RelationalTransformation pivotElement = refreshNamedElement(RelationalTransformation.class, eClass, csElement);
		refreshClassifier(pivotElement, csElement);
		context.refreshPivotList(Key.class, pivotElement.getOwnedKey(), csElement.getOwnedKeyDecls());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getOwnedModelDecls());
		context.refreshPivotList(Relation.class, pivotElement.getRule(), csElement.getOwnedRelations());
		context.refreshPivotList(Operation.class, pivotElement.getOwnedOperations(), csElement.getOwnedQueries());
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
