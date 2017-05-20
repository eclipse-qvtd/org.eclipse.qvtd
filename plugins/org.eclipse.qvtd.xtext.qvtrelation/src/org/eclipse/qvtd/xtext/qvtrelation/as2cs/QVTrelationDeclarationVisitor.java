/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.as2cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.as2cs.BaseReferenceVisitor;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSFactory;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtbase.as2cs.QVTbaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
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
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;

public class QVTrelationDeclarationVisitor extends QVTbaseDeclarationVisitor implements QVTrelationVisitor<ElementCS>
{
	private static final Logger logger = Logger.getLogger(QVTrelationDeclarationVisitor.class);

	public static @Nullable PathNameCS createPathNameCS(@Nullable List<? extends @NonNull NamedElement> csPath) {
		PathNameCS csPathName = null;
		if (csPath != null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			List<@NonNull PathElementCS> csPathElements = ClassUtil.nullFree(csPathName.getOwnedPathElements());
			for (@NonNull NamedElement csElement : csPath) {
				PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
				csPathElement.setReferredElement(csElement);
				csPathElements.add(csPathElement);
			}
		}
		return csPathName;
	}

	/**
	 * QVTrelationAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTrelationAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTrelationAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTrelationAliasAnalysis) {
					QVTrelationAliasAnalysis aliasAnalysis = (QVTrelationAliasAnalysis)adapter;
					if (aliasAnalysis.environmentFactory == environmentFactory) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTrelationAliasAnalysis(resource, environmentFactory);
		}

		public QVTrelationAliasAnalysis(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(resource, environmentFactory);
		}
	}

	public QVTrelationDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	protected void addClass(@NonNull PackageOwnerCS csParentPackage, @NonNull ClassCS csClass) {
		/*if (csParentPackage instanceof AbstractTopLevelCS) {
			((AbstractTopLevelCS)csParentPackage).getOwnedClasses().add(csClass);
		}
		else*/ if (csParentPackage instanceof PackageCS) {
			((PackageCS)csParentPackage).getOwnedClasses().add(csClass);
		}
		else {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " addClass for a " + csClass.eClass().getName());
		}
	}

	protected void addPackage(@NonNull PackageOwnerCS csParentPackage, @NonNull QualifiedPackageCS csPackage) {
		csParentPackage.getOwnedPackages().add(csPackage);
	}

	protected void addTransformation(@NonNull PackageOwnerCS csParentPackage, @NonNull TransformationCS csTransformation) {
		if (csParentPackage instanceof TopLevelCS) {
			((TopLevelCS)csParentPackage).getOwnedTransformations().add(csTransformation);
		}
		else if (csParentPackage instanceof PackageCS) {
			((PackageCS)csParentPackage).getOwnedClasses().add(csTransformation);
		}
		else {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " addClass for a " + csTransformation.eClass().getName());
		}
	}

	public void buildModel(@NonNull RootPackageCS csRootPackage, @NonNull Model asModel) {
		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asModel.getOwnedPackages())) {
			if (!Orphanage.isTypeOrphanage(asPackage)) {
				buildPackage(csRootPackage, null, asPackage);
			}
		}
	}

	private void buildPackage(@NonNull PackageOwnerCS csParentPackage, @Nullable List<@NonNull NamedElement> csParentPath, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (needsQualifiedPackageCS(asPackage)) {
			QualifiedPackageCS csPackage = context.visitDeclaration(QualifiedPackageCS.class, asPackage);
			if (csPackage != null) {
				csPackage.setOwnedPathName(createPathNameCS(csParentPath));
				addPackage(csParentPackage, csPackage);
				csParentPackage = csPackage;
			}
			csParentPath = null;
		}
		else {
			List<@NonNull NamedElement> csPath = new ArrayList<>();
			if (csParentPath != null) {
				csPath.addAll(csParentPath);
			}
			csPath.add(asPackage);
			csParentPath = csPath;
		}
		for (org.eclipse.ocl.pivot.@NonNull Package asChildPackage : ClassUtil.nullFree(asPackage.getOwnedPackages())) {
			buildPackage(csParentPackage, csParentPath, asChildPackage);
		}
		for (org.eclipse.ocl.pivot.@NonNull Class asChildClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
			buildClass(csParentPackage, csParentPath, asChildClass);
		}
	}

	private void buildClass(@NonNull PackageOwnerCS csParentPackage, @Nullable List<@NonNull NamedElement> csPath, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		ClassCS csClass = context.visitDeclaration(ClassCS.class, asClass);
		if (csClass instanceof TransformationCS) {
			TransformationCS csTransformation = (TransformationCS)csClass;
			if ((csPath != null) && ((csParentPackage instanceof QualifiedPackageCS) || (csPath.size() != 1) || !"".equals(csPath.get(0).getName()))) {
				csTransformation.setOwnedPathName(createPathNameCS(csPath));
			}
			addTransformation(csParentPackage, csTransformation);
		}
		else if (csClass != null) {
			addClass(csParentPackage, csClass);
		}
	}

	protected void gatherTransformations(@NonNull List<Transformation> asTransformations, @NonNull List<Package> ownedPackages) {
		for (org.eclipse.ocl.pivot.Package asPackage : ownedPackages) {
			for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
				if (asClass instanceof Transformation) {
					asTransformations.add((Transformation) asClass);
				}
			}
			gatherTransformations(asTransformations, asPackage.getOwnedPackages());
		}
	}

	/*	protected @Nullable Package getScope(@NonNull Variable asVariable) {
		TypedModel typedModel = QVTrelationUtil.basicGetTypedModel(QVTrelationUtil.getContainingArea(asVariable));
		if (typedModel == null) {
			return null;
		}
		List<Package> usedPackages = typedModel.getUsedPackage();
		if (usedPackages.isEmpty()) {
			return null;
		}
		return usedPackages.get(0);
	} */

	/**
	 * Return true if a QualifiedPackageCS is needed to avoid information loss when serializing asPackage.
	 */
	protected boolean needsQualifiedPackageCS(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (asPackage.getNsPrefix() != null) {
			return true;
		}
		if (asPackage.getURI() != null) {
			return true;
		}
		if (asPackage.getOwnedPackages().size() > 1) {
			return true;
		}
		//		if (asPackage.getOwnedComments().size() > 1) {
		//			return true;
		//		}
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
			if (!(asClass instanceof Transformation)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Post-processing sets up the AliasAdapter with the names from the Unit declarations
	 */
	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {
		AliasAnalysis.dispose(csResource);
		QVTrelationAliasAnalysis aliasAdapter = QVTrelationAliasAnalysis.getAdapter(csResource, context.getEnvironmentFactory());
		List<EObject> contents = csResource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof RootPackageCS) {
				for (ImportCS csImport : ((RootPackageCS)root).getOwnedImports()) {
					Element pivot = csImport.getPivot();
					if (pivot instanceof Import) {
						Import asImport = (Import)pivot;
						String alias = asImport.getName();
						Namespace asNamespace = asImport.getImportedNamespace();
						if ((asNamespace != null) && (alias != null)) {
							aliasAdapter.getAlias(asNamespace, alias);
						}
					}
				}
			}
		}
	}

	@Override
	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitCollectionTemplateExp(@NonNull CollectionTemplateExp asCollectionTemplateExp) {
		Variable bindsTo = asCollectionTemplateExp.getBindsTo();
		CollectionTemplateCS csCollectionTemplate = context.refreshNamedElement(CollectionTemplateCS.class, QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS, asCollectionTemplateExp, bindsTo.isIsImplicit() ? null : bindsTo.getName());
		csCollectionTemplate.setOwnedType(createTypeRefCS(asCollectionTemplateExp.getType()));
		//
		List<TemplateVariableCS> csTemplateVariables = new ArrayList<>();
		for (OCLExpression asMember : asCollectionTemplateExp.getMember()) {
			if (asMember instanceof VariableExp) {
				VariableDeclaration asVariable = PivotUtil.getReferredVariable((VariableExp)asMember);
				ElementTemplateCS csElementTemplate = context.refreshElement(ElementTemplateCS.class, QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS, asVariable);
				csElementTemplate.setPivot(asMember);
				csElementTemplate.setIdentifier((SharedVariable) asVariable);
				csTemplateVariables.add(csElementTemplate);
			}
			//			else if ((asMember instanceof SharedVariable) && ((SharedVariable)asMember).isIsImplicit()){
			//				return visiting(asCollectionTemplateExp);
			//			}
			else {
				TemplateVariableCS csTemplateVariable = context.visitDeclaration(TemplateVariableCS.class, asMember);
				csTemplateVariables.add(csTemplateVariable);
			}
		}
		context.refreshList(csCollectionTemplate.getOwnedMemberIdentifiers(), csTemplateVariables);
		//
		Variable asRest = asCollectionTemplateExp.getRest();
		if (asRest instanceof SharedVariable) {
			ElementTemplateCS csElementTemplate = context.refreshElement(ElementTemplateCS.class, QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS, asRest);
			csElementTemplate.setPivot(asRest);
			csElementTemplate.setIdentifier((SharedVariable)asRest);
			csCollectionTemplate.setOwnedRestIdentifier(csElementTemplate);
		}
		csCollectionTemplate.setOwnedGuardExpression(context.visitDeclaration(ExpCS.class, asCollectionTemplateExp.getWhere()));
		return csCollectionTemplate;
	}

	@Override
	public ElementCS visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitDomainPattern(@NonNull DomainPattern asDomainPattern) {
		DomainPatternCS csDomainPattern = context.refreshElement(DomainPatternCS.class, QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS, asDomainPattern);
		csDomainPattern.setPivot(asDomainPattern);
		csDomainPattern.setOwnedTemplate(context.visitDeclaration(TemplateCS.class, asDomainPattern.getTemplateExpression()));
		return csDomainPattern;
	}

	@Override
	public ElementCS visitFunction(@NonNull Function asFunction) {
		QueryCS csQuery = refreshTypedElement(QueryCS.class, QVTrelationCSPackage.Literals.QUERY_CS, asFunction);
		context.refreshList(csQuery.getOwnedParameters(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameters(), null));
		csQuery.setOwnedExpression(createExpCS(asFunction.getQueryExpression()));
		csQuery.setIsTransient(asFunction.isIsTransient());
		return csQuery;
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = refreshTypedElement(ParamDeclarationCS.class, QVTrelationCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		return csParamDeclaration;
	}

	@Override
	public @Nullable ElementCS visitImport(@NonNull Import asUnit) {
		BaseCSResource csResource = context.getCSResource();
		Namespace asNamespace = asUnit.getImportedNamespace();
		EObject eObject = asNamespace.getESObject();
		String importURI = null;
		if (eObject instanceof EPackage) {
			EPackage ePackage = (EPackage)eObject;
			Resource resource = ePackage.eResource();
			if (ClassUtil.isRegistered(resource)) {
				importURI = ePackage.getNsURI();
			}
		}
		if ((importURI == null) && (csResource != null)) {
			URI fullURI = EcoreUtil.getURI(eObject != null ? eObject : asNamespace);
			URI csURI = csResource.getURI();
			URI deresolvedURI = fullURI.deresolve(csURI, true, true, false);
			importURI = deresolvedURI.toString();
		}
		ImportCS csImport = context.refreshElement(ImportCS.class, BaseCSPackage.Literals.IMPORT_CS, asUnit);
		csImport.setPivot(asUnit);
		csImport.setName(asUnit.getName());
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		List<PathElementCS> csPath = csPathName.getOwnedPathElements();
		PathElementWithURICS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementWithURICS();
		csSimpleRef.setReferredElement(asNamespace);
		csSimpleRef.setUri(importURI);
		csPath.add(csSimpleRef);
		csImport.setOwnedPathName(csPathName);
		return csImport;
	}

	@Override
	public ElementCS visitKey(@NonNull Key asKey) {
		KeyDeclCS csKey = context.refreshElement(KeyDeclCS.class, QVTrelationCSPackage.Literals.KEY_DECL_CS, asKey);
		csKey.setPivot(asKey);
		NamedElement asNamedElement = QVTrelationUtil.getIdentifies(asKey);
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		csKey.setOwnedPathName(csPathName);
		context.refreshPathName(csPathName, asNamedElement, null);
		context.refreshList(csKey.getPropertyIds(), asKey.getPart());
		return csKey;
	}

	@Override
	public ElementCS visitObjectTemplateExp(@NonNull ObjectTemplateExp asObjectTemplateExp) {
		Variable bindsTo = asObjectTemplateExp.getBindsTo();
		ObjectTemplateCS csObjectTemplate = context.refreshNamedElement(ObjectTemplateCS.class, QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS, asObjectTemplateExp, bindsTo.isIsImplicit() ? null : bindsTo.getName());
		Type asType = PivotUtil.getType(asObjectTemplateExp);
		TypedRefCS csTypeRef = null;
		@SuppressWarnings("null") @NonNull EClass eClass = asType.eClass();
		BaseReferenceVisitor expressionVisitor = context.getExpressionVisitor(eClass, null);
		if (expressionVisitor == null) {
			logger.warn("Unsupported reference " + asType.eClass().getName());
		}
		else if (asType.eIsProxy()) {
			logger.warn("Unresolved reference " + ((BasicEObjectImpl)asType).eProxyURI());
		}
		else {
			ElementCS csElement = asType.accept(expressionVisitor);
			if (csElement != null) {
				csTypeRef = (TypedRefCS) csElement;
				if (!(asType instanceof CollectionType)) {
					if (asObjectTemplateExp.isIsRequired()) {
						MultiplicityBoundsCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityBoundsCS();
						csMultiplicity.setLowerBound(1);
						csTypeRef.setOwnedMultiplicity(csMultiplicity);
					}
					//			else {
					//				MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
					//				csMultiplicity.setStringBounds("1");
					//				csTypeRef.setOwnedMultiplicity(csMultiplicity);
					//			}
				}
			}
		}
		csObjectTemplate.setOwnedType(csTypeRef);
		context.refreshList(csObjectTemplate.getOwnedPropertyTemplates(), context.visitDeclarations(PropertyTemplateCS.class, asObjectTemplateExp.getPart(), null));
		csObjectTemplate.setOwnedGuardExpression(context.visitDeclaration(ExpCS.class, asObjectTemplateExp.getWhere()));
		return csObjectTemplate;
	}

	@Override
	public ElementCS visitPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		//		List<org.eclipse.ocl.pivot.@NonNull Class> asClasses = ClassUtil.nullFree(asPackage.getOwnedClasses());
		//		List<org.eclipse.ocl.pivot.@NonNull Package> asPackages = ClassUtil.nullFree(asPackage.getOwnedPackages());
		//		if (needsQualifiedPackageCS(asPackage)) {
		//			assert needsQualifiedPackageCS(asPackage);
		QualifiedPackageCS csPackage = context.refreshNamedElement(QualifiedPackageCS.class, QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS, asPackage);
		//			context.refreshList(csPackage.getOwnedClasses(), context.visitDeclarations(ClassCS.class, asClasses, null));
		csPackage.setNsPrefix(asPackage.getNsPrefix());
		csPackage.setNsURI(asPackage.getURI());
		//			context.refreshList(csPackage.getOwnedPackages(), context.visitDeclarations(QualifiedPackageCS.class, asPackages, null));
		return csPackage;
		//		}
		//		else {
		//			PackageCS csPackage = context.refreshNamedElement(PackageCS.class, BaseCSPackage.Literals.PACKAGE_CS, asPackage);
		//			context.refreshList(csPackage.getOwnedClasses(), context.visitDeclarations(ClassCS.class, asClasses, null));
		//			csPackage.setNsPrefix(asPackage.getNsPrefix());
		//			csPackage.setNsURI(asPackage.getURI());
		//			context.refreshList(csPackage.getOwnedPackages(), context.visitDeclarations(PackageCS.class, asPackages, null));
		//			return csPackage;
		//		}
	}

	@Override
	public ElementCS visitPattern(@NonNull Pattern asPattern) {
		PatternCS csPattern = context.refreshElement(PatternCS.class, QVTrelationCSPackage.Literals.PATTERN_CS, asPattern);
		csPattern.setPivot(asPattern);
		context.refreshList(csPattern.getOwnedPredicates(), context.visitDeclarations(PredicateCS.class, asPattern.getPredicate(), null));
		return csPattern;
	}

	@Override
	public ElementCS visitPredicate(@NonNull Predicate asPredicate) {
		PredicateCS csPredicate = context.refreshElement(PredicateCS.class, QVTrelationCSPackage.Literals.PREDICATE_CS, asPredicate);
		csPredicate.setPivot(asPredicate);
		csPredicate.setOwnedCondition(context.visitDeclaration(ExpCS.class, asPredicate.getConditionExpression()));
		return csPredicate;
	}

	@Override
	public ElementCS visitPropertyTemplateItem(@NonNull PropertyTemplateItem asPropertyTemplateItem) {
		PropertyTemplateCS csPropertyTemplate = context.refreshElement(PropertyTemplateCS.class, QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS, asPropertyTemplateItem);
		csPropertyTemplate.setPivot(asPropertyTemplateItem);
		csPropertyTemplate.setPropertyId(asPropertyTemplateItem.getReferredProperty());
		csPropertyTemplate.setOwnedExpression(context.visitDeclaration(ExpCS.class, asPropertyTemplateItem.getValue()));
		return csPropertyTemplate;
	}

	@Override
	public ElementCS visitRelation(@NonNull Relation asRelation) {
		RelationCS csRelation = context.refreshNamedElement(RelationCS.class, QVTrelationCSPackage.Literals.RELATION_CS, asRelation, "«null»");
		csRelation.setPivot(asRelation);
		csRelation.setIsAbstract(asRelation.isIsAbstract());
		csRelation.setIsTop(asRelation.isIsTopLevel());
		csRelation.setOverridden(QVTrelationUtil.basicGetOverridden(asRelation));
		context.refreshList(csRelation.getOwnedDomains(), context.visitDeclarations(DomainCS.class, asRelation.getDomain(), null));
		List<@NonNull Variable> asSharedVariables = new ArrayList<>();
		for (Variable asVariable : asRelation.getVariable()) {
			if ((asVariable instanceof SharedVariable) && !asVariable.isIsImplicit()) {
				asSharedVariables.add(asVariable);
			}
		}
		context.refreshList(csRelation.getOwnedVarDeclarations(), context.visitDeclarations(VarDeclarationCS.class, asSharedVariables, null));
		Pattern asWhere = asRelation.getWhere();
		if (asWhere != null) {
			csRelation.setOwnedWhere(context.visitDeclaration(PatternCS.class, asWhere));
		}
		Pattern asWhen = asRelation.getWhen();
		if (asWhen != null) {
			csRelation.setOwnedWhen(context.visitDeclaration(PatternCS.class, asWhen));
		}
		return csRelation;
	}

	@Override
	public ElementCS visitRelationCallExp(@NonNull RelationCallExp asRelationCallExp) {
		NameExpCS csNameExp = createNameExpCS(asRelationCallExp.getReferredRelation());
		csNameExp.setPivot(asRelationCallExp);
		RoundBracketedClauseCS csRoundBracketedClause = EssentialOCLCSFactory.eINSTANCE.createRoundBracketedClauseCS();
		csNameExp.setOwnedRoundBracketedClause(csRoundBracketedClause);
		String prefix = null;
		for (OCLExpression asArgument : QVTrelationUtil.getOwnedArguments(asRelationCallExp)) {
			csRoundBracketedClause.getOwnedArguments().add(createNavigatingArgCS(prefix, asArgument));
			prefix = ",";
		}
		return csNameExp;
	}

	@Override
	public ElementCS visitRelationDomain(@NonNull RelationDomain asRelationDomain) {
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTrelationCSPackage.Literals.DOMAIN_CS, asRelationDomain);
		csDomain.setPivot(asRelationDomain);
		csDomain.setModelId(asRelationDomain.getTypedModel());
		//		boolean isCheckable = asRelationDomain.isIsCheckable();
		boolean isEnforceable = asRelationDomain.isIsEnforceable();
		csDomain.setIsCheckonly(false); //isCheckable && !isEnforceable);
		csDomain.setIsEnforce(isEnforceable);// && !isCheckable);
		context.refreshList(csDomain.getOwnedPatterns(), context.visitDeclarations(DomainPatternCS.class, asRelationDomain.getPattern(), null));
		context.refreshList(csDomain.getOwnedDefaultValues(), context.visitDeclarations(DefaultValueCS.class, asRelationDomain.getDefaultAssignment(), null));
		//		context.refreshList(csDomain.getOwnedImplementedBy(), context.visitDeclarations(ExpCS.class, asRelationDomain.getImplementedBy(), null));
		return csDomain;
	}

	@Override
	public ElementCS visitRelationDomainAssignment(@NonNull RelationDomainAssignment asRelationDomainAssignment) {
		DefaultValueCS csDefaultValue= context.refreshElement(DefaultValueCS.class, QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS, asRelationDomainAssignment);
		csDefaultValue.setPivot(asRelationDomainAssignment);
		csDefaultValue.setPropertyId((SharedVariable) asRelationDomainAssignment.getVariable());
		csDefaultValue.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asRelationDomainAssignment.getValueExp()));
		return csDefaultValue;
	}

	@Override
	public ElementCS visitRelationImplementation(@NonNull RelationImplementation object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitRelationModel(@NonNull RelationModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTrelationCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getOwnedImports(), null));

		buildModel(csDocument, asModel);

		List<Transformation> asTransformations = new ArrayList<>();
		gatherTransformations(asTransformations, asModel.getOwnedPackages());
		context.refreshList(csDocument.getOwnedTransformations(), context.visitDeclarations(TransformationCS.class, asTransformations, null));
		return csDocument;
	}

	@Override
	public ElementCS visitRelationalTransformation(@NonNull RelationalTransformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTrelationCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		csTransformation.setPivot(asTransformation);
		org.eclipse.ocl.pivot.Package owningPackage = asTransformation.getOwningPackage();
		if ((owningPackage == null) || "".equals(owningPackage.getName()) || (owningPackage.getName() == null)) {
			csTransformation.setOwnedPathName(null);
		}
		else {
			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csTransformation.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, owningPackage, null);
		}
		context.refreshList(csTransformation.getOwnedModelDecls(), context.visitDeclarations(ModelDeclCS.class, asTransformation.getModelParameter(), null));
		context.refreshList(csTransformation.getOwnedKeyDecls(), context.visitDeclarations(KeyDeclCS.class, asTransformation.getOwnedKey(), null));
		context.refreshList(csTransformation.getOwnedQueries(), context.visitDeclarations(QueryCS.class, asTransformation.getOwnedOperations(), null));
		context.refreshList(csTransformation.getOwnedRelations(), context.visitDeclarations(RelationCS.class, asTransformation.getRule(), null));
		return csTransformation;
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitSharedVariable(@NonNull SharedVariable asSharedVariable) {
		VarDeclarationIdCS csVarDeclarationId = context.refreshNamedElement(VarDeclarationIdCS.class, QVTrelationCSPackage.Literals.VAR_DECLARATION_ID_CS, asSharedVariable);
		csVarDeclarationId.setPivot(asSharedVariable);
		VarDeclarationCS csVarDeclaration = context.refreshElement(VarDeclarationCS.class, QVTrelationCSPackage.Literals.VAR_DECLARATION_CS, asSharedVariable);
		csVarDeclaration.getOwnedVarDeclarationIds().add(csVarDeclarationId);
		csVarDeclaration.setOwnedType(createTypeRefCS(asSharedVariable));
		csVarDeclaration.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asSharedVariable.getOwnedInit()));
		return csVarDeclaration;
	}

	@Override
	public ElementCS visitTemplateExp(@NonNull TemplateExp object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitTemplateVariable(@NonNull TemplateVariable object) {
		return visitVariable(object);
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitTypedModel(@NonNull TypedModel asTypedModel) {
		ModelDeclCS csDirection = context.refreshNamedElement(ModelDeclCS.class, QVTrelationCSPackage.Literals.MODEL_DECL_CS, asTypedModel, null);
		if ("".equals(asTypedModel.getName())) {
			csDirection.setName(null);
		}
		PivotUtilInternal.refreshList(csDirection.getMetamodelIds(), asTypedModel.getUsedPackage());
		PivotUtilInternal.refreshList(csDirection.getDependsOn(), asTypedModel.getDependsOn());
		return csDirection;
	}
}
