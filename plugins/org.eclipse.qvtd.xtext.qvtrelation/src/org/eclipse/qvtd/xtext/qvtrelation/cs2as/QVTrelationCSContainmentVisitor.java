/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
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
import java.util.List;

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
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
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
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
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
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
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

	/**
	 * Return the name referenced by an element template, null for a dummy variable.
	 */
	protected static @Nullable String getElementTemplateName(@NonNull ElementTemplateCS csElementTemplate) {
		String name = ElementUtil.getText(csElementTemplate);
		if (QVTrelationUtil.DUMMY_VARIABLE_NAME.equals(name)) {
			return null;
		}
		else {
			return name;
		}
	}

	public QVTrelationCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	/**
	 * Traverse the templateExp hierarchy assigning all bound variables (TemplateExp::bindsTo and non-implicit CollectionTempateExp::rest)
	 * to voundVariables.
	 *
	private void gatherBoundVariables(@NonNull List<@NonNull Variable> boundVariables, @NonNull TemplateExp templateExp) {
		Variable variable = templateExp.getBindsTo();
		if (variable != null) {
			boundVariables.add(variable);
		}
		if (templateExp instanceof ObjectTemplateExp) {
			for (PropertyTemplateItem part : ((ObjectTemplateExp)templateExp).getPart()) {
				OCLExpression value = part.getValue();
				if (value instanceof TemplateExp) {
					gatherBoundVariables(boundVariables, (TemplateExp)value);
				}
			}
		}
		else if (templateExp instanceof CollectionTemplateExp) {
			CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)templateExp;
			for (OCLExpression member : collectionTemplateExp.getMember()) {
				if (member instanceof TemplateExp) {
					gatherBoundVariables(boundVariables, (TemplateExp)member);
				}
			}
			Variable restVariable = collectionTemplateExp.getRest();
			if ((restVariable != null) && !restVariable.isIsImplicit()) {
				boundVariables.add(restVariable);
			}
		}
	} */

	/**
	 * Traverse the templateExp hierarchy assigning all special variables (_) to specialVariables allocating a distinctive name to each.
	 * Append special member variables to relationVariables as well.
	 */
	private void processSpecialVariables(@NonNull List<@NonNull Variable> relationVariables, @NonNull List<@NonNull Variable> boundVariables, @NonNull List<@NonNull Variable> specialVariables, @NonNull TemplateCS csTemplate) {
		TemplateExp asTemplateExp = PivotUtil.getPivot(TemplateExp.class, csTemplate);
		assert asTemplateExp != null;
		Variable asBoundVariable = asTemplateExp.getBindsTo();
		assert asBoundVariable != null;
		relationVariables.add(asBoundVariable);
		boundVariables.add(asBoundVariable);
		if (csTemplate instanceof ObjectTemplateCS) {
			for (PropertyTemplateCS csPart : ((ObjectTemplateCS)csTemplate).getOwnedPropertyTemplates()) {
				ExpCS csExp = csPart.getOwnedExpression();
				if (csExp instanceof TemplateCS) {
					processSpecialVariables(relationVariables, boundVariables, specialVariables, (TemplateCS)csExp);
				}
			}
		}
		else if (csTemplate instanceof CollectionTemplateCS) {
			CollectionTemplateCS csCollectionTemplate = (CollectionTemplateCS)csTemplate;
			CollectionTemplateExp asCollectionTemplateExp = (CollectionTemplateExp)asTemplateExp;
			assert asCollectionTemplateExp != null;
			List<TemplateVariableCS> csMemberIdentifiers = csCollectionTemplate.getOwnedMemberIdentifiers();
			for (TemplateVariableCS csMember : csMemberIdentifiers) {
				if (csMember instanceof TemplateCS) {
					processSpecialVariables(relationVariables, boundVariables, specialVariables, (TemplateCS)csMember);
				}
				else if (csMember instanceof ElementTemplateCS) {
					String name = getElementTemplateName((ElementTemplateCS) csMember);
					VariableExp asVariableExp = context.refreshModelElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csMember);
					if (name == null) {
						Variable asMemberVariable = PivotFactory.eINSTANCE.createVariable();
						asMemberVariable.setName(QVTrelationUtil.DUMMY_VARIABLE_NAME + specialVariables.size());
						asMemberVariable.setIsImplicit(true);
						specialVariables.add(asMemberVariable);
						relationVariables.add(asMemberVariable);
						asVariableExp.setReferredVariable(asMemberVariable);
					}
					else {
						Variable asVariable = NameUtil.getNameable(relationVariables, name);
						asVariableExp.setReferredVariable(asVariable);
					}
				}
			}
			context.refreshPivotList(OCLExpression.class, asCollectionTemplateExp.getMember(), csMemberIdentifiers);
			//
			ElementTemplateCS csRestTemplate = csCollectionTemplate.getOwnedRestIdentifier();
			Variable asRestVariable = null;
			if (csRestTemplate != null) {
				String name = getElementTemplateName(csRestTemplate);
				if (name != null) {
					asRestVariable = NameUtil.getNameable(relationVariables, name);
					if (asRestVariable != null) {
						csRestTemplate.setPivot(asRestVariable);
					}
				}
				else {
					asRestVariable = context.refreshModelElement(Variable.class, PivotPackage.Literals.VARIABLE, csRestTemplate);
					asRestVariable.setIsImplicit(true);
					asRestVariable.setTypeValue(null);
					asRestVariable.setIsRequired(true);
					asRestVariable.setName(QVTrelationUtil.DUMMY_VARIABLE_NAME + specialVariables.size());
					specialVariables.add(asRestVariable);
					relationVariables.add(asRestVariable);
					csRestTemplate.setPivot(asRestVariable);
				}
			}
			asCollectionTemplateExp.setRest(asRestVariable);
		}
	}

	protected void resolveTemplateVariable(@NonNull TemplateCS csElement, @NonNull TemplateExp pivotElement) {
		Variable variable = pivotElement.getBindsTo();
		if (variable == null) {
			variable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
			pivotElement.setBindsTo(variable);
		}
		context.refreshName(variable, csElement.getName());
	}

	@Override
	public Continuation<?> visitAbstractDomainCS(@NonNull AbstractDomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCollectionTemplateCS(@NonNull CollectionTemplateCS csElement) {
		@NonNull CollectionTemplateExp pivotElement = context.refreshModelElement(CollectionTemplateExp.class, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, csElement);
		resolveTemplateVariable(csElement, pivotElement);
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
			for (DomainPattern asPattern : asPatterns) {
				if (asPattern != null) {
					//					List<@NonNull Variable> boundVariables = new ArrayList<@NonNull Variable>();
					TemplateExp asTemplate = asPattern.getTemplateExpression();
					if (asTemplate != null) {
						rootVariables.add(asTemplate.getBindsTo());
						//						gatherBoundVariables(boundVariables, asTemplate);
					}
					//					PivotUtilInternal.refreshList(asPattern.getBindsTo(), boundVariables);
				}
			}
			PivotUtilInternal.refreshList(pivotElement.getRootVariable(), rootVariables);
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
		return null;
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
		resolveTemplateVariable(csElement, pivotElement);
		context.refreshPivotList(PropertyTemplateItem.class, pivotElement.getPart(), csElement.getOwnedPropertyTemplates());
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		@SuppressWarnings("unused")
		FunctionParameter pivotElement = refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
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
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		pivotElement.setIsTransient(csElement.isIsTransient());
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
		for (@NonNull AbstractDomainCS abstractDomainCS : ClassUtil.nullFree(csElement.getOwnedDomains())) {
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
		List<@NonNull Variable> relationVariables = new ArrayList<@NonNull Variable>();
		//
		//	Gather explicit local variables.
		//
		for (VarDeclarationCS csVarDeclarations : csElement.getOwnedVarDeclarations()) {
			for (VarDeclarationIdCS csVarDeclarationId : csVarDeclarations.getOwnedVarDeclarationIds()) {
				Variable asVariable = PivotUtil.getPivot(Variable.class, csVarDeclarationId);
				if (asVariable != null) {
					relationVariables.add(asVariable);
				}
			}
		}
		//
		//	Accumulate variables bound at template variables.
		//
		//		for (@NonNull Domain domain : ClassUtil.nullFree(pivotElement.getDomain())) {
		//			RelationDomain relationDomain = (RelationDomain)domain;
		//			for (@NonNull DomainPattern pattern : ClassUtil.nullFree(relationDomain.getPattern())) {
		//				relationVariables.addAll(ClassUtil.nullFree(pattern.getBindsTo()));
		//			}
		//		}
		//
		//	Resolve the special variables.
		//
		List<@NonNull Variable> specialVariables = new ArrayList<@NonNull Variable>();
		for (@NonNull AbstractDomainCS csAbstractDomain : ClassUtil.nullFree(csElement.getOwnedDomains())) {
			if (csAbstractDomain instanceof DomainCS) {
				for (@NonNull DomainPatternCS csDomainPatternCS : ClassUtil.nullFree(((DomainCS)csAbstractDomain).getOwnedPattern())) {
					DomainPattern asPattern = PivotUtil.getPivot(DomainPattern.class, csDomainPatternCS);
					List<@NonNull Variable> boundVariables = new ArrayList<@NonNull Variable>();
					TemplateCS csTemplate = csDomainPatternCS.getOwnedTemplate();
					if (csTemplate != null) {
						processSpecialVariables(relationVariables, boundVariables, specialVariables, csTemplate);
					}
					if (asPattern != null) {
						PivotUtilInternal.refreshList(asPattern.getBindsTo(), boundVariables);
					}
				}
			}
			else {		// PrimitiveDomainCS
				RelationDomain asDomain = PivotUtil.getPivot(RelationDomain.class, csAbstractDomain);
				if (asDomain != null) {
					for (@NonNull DomainPattern pattern : ClassUtil.nullFree(asDomain.getPattern())) {
						relationVariables.addAll(ClassUtil.nullFree(pattern.getBindsTo()));
					}
				}
			}
		}
		PivotUtilInternal.refreshList(pivotElement.getVariable(), relationVariables);
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
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		RelationModel asModel = refreshRoot(RelationModel.class, QVTrelationPackage.Literals.RELATION_MODEL, csElement);
		installPackageStructure(asModel, ClassUtil.nullFree(csElement.getOwnedPackages()), ClassUtil.nullFree(csElement.getOwnedTransformations()));
		context.refreshPivotList(Import.class, asModel.getOwnedImports(), csElement.getOwnedImports());
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
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@SuppressWarnings("null") @NonNull EClass eClass = QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION;
		RelationalTransformation asTransformation = refreshNamedElement(RelationalTransformation.class, eClass, csElement);
		refreshClassifier(asTransformation, csElement);
		context.refreshPivotList(Key.class, asTransformation.getOwnedKey(), csElement.getOwnedKeyDecls());
		context.refreshPivotList(TypedModel.class, asTransformation.getModelParameter(), csElement.getOwnedModelDecls());
		context.refreshPivotList(Relation.class, asTransformation.getRule(), csElement.getOwnedRelations());
		context.refreshPivotList(Operation.class, asTransformation.getOwnedOperations(), csElement.getOwnedQueries());
		QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
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
