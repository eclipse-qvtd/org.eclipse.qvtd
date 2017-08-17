/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.as2cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.xtext.qvtbase.as2cs.QVTbaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS;

public class QVTcoreDeclarationVisitor extends QVTbaseDeclarationVisitor implements QVTcoreVisitor<ElementCS>
{
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
	 * QVTcoreAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTcoreAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTcoreAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTcoreAliasAnalysis) {
					QVTcoreAliasAnalysis aliasAnalysis = (QVTcoreAliasAnalysis)adapter;
					if (aliasAnalysis.environmentFactory == environmentFactory) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTcoreAliasAnalysis(resource, environmentFactory);
		}

		public QVTcoreAliasAnalysis(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(resource, environmentFactory);
		}
	}

	public QVTcoreDeclarationVisitor(@NonNull AS2CSConversion context) {
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

	protected void addTransformation(@NonNull PackageOwnerCS csParentPackage, @NonNull AbstractTransformationCS csTransformation) {
		if (csParentPackage instanceof TopLevelCS) {
			((TopLevelCS)csParentPackage).getOwnedTransformations().add((TransformationCS)csTransformation);
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
		if (csClass instanceof AbstractTransformationCS) {
			AbstractTransformationCS csTransformation = (AbstractTransformationCS)csClass;
			if ((csPath != null) && ((csParentPackage instanceof QualifiedPackageCS) || (csPath.size() != 1) || !"".equals(csPath.get(0).getName()))) {
				csTransformation.setOwnedPathName(createPathNameCS(csPath));
			}
			addTransformation(csParentPackage, csTransformation);
		}
		else if (csClass != null) {
			addClass(csParentPackage, csClass);
		}
	}

	protected @NonNull DomainCS createCoreDomain(@NonNull CoreDomain asCoreDomain) {
		return context.refreshElement(DomainCS.class, QVTcoreCSPackage.Literals.DOMAIN_CS, asCoreDomain);
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

	protected @Nullable Package getScope(@NonNull Variable asVariable) {
		TypedModel typedModel = QVTcoreUtil.basicGetTypedModel(QVTcoreUtil.getContainingArea(asVariable));
		if (typedModel == null) {
			return null;
		}
		List<Package> usedPackages = typedModel.getUsedPackage();
		if (usedPackages.isEmpty()) {
			return null;
		}
		return usedPackages.get(0);
	}

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
		QVTcoreAliasAnalysis aliasAdapter = QVTcoreAliasAnalysis.getAdapter(csResource, context.getEnvironmentFactory());
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

	protected void refreshOwnedInTransformation(@NonNull MappingCS csMapping, @NonNull Mapping asMapping) {
		Transformation asTransformation = asMapping.getTransformation();
		if (asTransformation != null) {
			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMapping.setOwnedInPathName(csPathName);
			org.eclipse.ocl.pivot.Package asPackage = asTransformation.getOwningPackage();
			String asPackageName = asPackage != null ? asPackage.getName() : null;
			if ((asPackageName == null) || "".equals(asPackageName)) {
				PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
				csPathName.getOwnedPathElements().add(csPathElement);
				csPathElement.setReferredElement(asTransformation);
			}
			else {
				context.refreshPathName(csPathName, asTransformation, null);
			}
		}
		else {
			csMapping.setOwnedInPathName(null);
		}
	}

	@Override
	public ElementCS visitAssignment(@NonNull Assignment object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		List<Element> asConstraints = new ArrayList<>(asBottomPattern.getAssignment());
		asConstraints.addAll(asBottomPattern.getPredicate());
		context.refreshList(csBottomPattern.getOwnedConstraints(), context.visitDeclarations(PredicateOrAssignmentCS.class, asConstraints, null));
		context.refreshList(csBottomPattern.getOwnedRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
		context.refreshList(csBottomPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		return csBottomPattern;
	}

	@Override
	public ElementCS visitBottomVariable(@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public ElementCS visitCoreDomain(@NonNull CoreDomain asCoreDomain) {
		DomainCS csDomain = createCoreDomain(asCoreDomain);
		csDomain.setPivot(asCoreDomain);
		csDomain.setOwnedBottomPattern(context.visitDeclaration(BottomPatternCS.class, asCoreDomain.getBottomPattern()));
		csDomain.setOwnedGuardPattern(context.visitDeclaration(GuardPatternCS.class, asCoreDomain.getGuardPattern()));
		csDomain.setIsCheck(asCoreDomain.isIsCheckable());
		csDomain.setDirection(asCoreDomain.getTypedModel());
		csDomain.setIsEnforce(asCoreDomain.isIsEnforceable());
		return csDomain;
	}

	@Override
	public ElementCS visitCoreModel(@NonNull CoreModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTcoreCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getOwnedImports(), null));

		buildModel(csDocument, asModel);

		List<Mapping> asMappings = null;
		List<Function> asQueries = null;
		List<Transformation> asTransformations = new ArrayList<>();
		gatherTransformations(asTransformations, asModel.getOwnedPackages());
		for (Transformation asTransformation : asTransformations) {
			for (Rule asRule : asTransformation.getRule()) {
				if (asRule instanceof Mapping) {
					if (asMappings == null) {
						asMappings = new ArrayList<>();
					}
					asMappings.add((Mapping) asRule);
				}
			}
			for (Operation asOperation : asTransformation.getOwnedOperations()) {
				if (asOperation instanceof Function) {
					if (asQueries == null) {
						asQueries = new ArrayList<>();
					}
					asQueries.add((Function) asOperation);
				}
			}
		}
		//		context.refreshList(csDocument.getOwnedTransformations(), context.visitDeclarations(TransformationCS.class, asTransformations, null));
		if (asMappings != null) {
			context.refreshList(csDocument.getOwnedMappings(), context.visitDeclarations(MappingCS.class, asMappings, null));
		}
		else {
			csDocument.getOwnedMappings().clear();
		}
		if (asQueries != null) {
			context.refreshList(csDocument.getOwnedQueries(), context.visitDeclarations(QueryCS.class, asQueries, null));
		}
		else {
			csDocument.getOwnedQueries().clear();
		}
		return csDocument;
	}

	@Override
	public ElementCS visitCorePattern(@NonNull CorePattern object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitDomain(@NonNull Domain object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitEnforcementOperation(@NonNull EnforcementOperation object) {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public ElementCS visitFunction(@NonNull Function asFunction) {
		QueryCS csQuery = refreshTypedElement(QueryCS.class, QVTcoreCSPackage.Literals.QUERY_CS, asFunction);
		csQuery.setOwnedPathName(createPathNameCS(asFunction.getOwningClass()));
		context.refreshList(csQuery.getOwnedParameters(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameters(), null));
		csQuery.setOwnedExpression(createExpCS(asFunction.getQueryExpression()));
		csQuery.setIsTransient(asFunction.isIsTransient());
		return csQuery;
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = refreshTypedElement(ParamDeclarationCS.class, QVTcoreCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		return csParamDeclaration;
	}

	@Override
	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		csGuardPattern.setPivot(asGuardPattern);
		context.refreshList(csGuardPattern.getOwnedPredicates(), context.visitDeclarations(PredicateCS.class, asGuardPattern.getPredicate(), null));
		context.refreshList(csGuardPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		return csGuardPattern;
	}

	@Override
	public ElementCS visitGuardVariable(@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public ElementCS visitMapping(@NonNull Mapping asMapping) {
		String defaultName = asMapping.getContext() != null ? null : "«null»";
		MappingCS csMapping = context.refreshNamedElement(MappingCS.class, QVTcoreCSPackage.Literals.MAPPING_CS, asMapping, defaultName);
		csMapping.setPivot(asMapping);
		csMapping.setIsAbstract(asMapping.isIsAbstract());
		refreshOwnedInTransformation(csMapping, asMapping);
		context.refreshList(csMapping.getOwnedDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreCSPackage.Literals.DOMAIN_CS, asMapping);
		csDomain.setPivot(null);		// stop comment duplication
		csDomain.setOwnedBottomPattern(context.visitDeclaration(BottomPatternCS.class, asMapping.getBottomPattern()));
		csDomain.setOwnedGuardPattern(context.visitDeclaration(GuardPatternCS.class, asMapping.getGuardPattern()));
		csMapping.setOwnedMiddle(csDomain);
		context.refreshList(csMapping.getOwnedComposedMappings(), context.visitDeclarations(MappingCS.class, asMapping.getLocal(), null));
		PivotUtilInternal.refreshList(csMapping.getRefines(), asMapping.getSpecification());
		return csMapping;
	}

	@Override
	public ElementCS visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asNavigationAssignment);
		ExpCS csSlotExp = createExpCS(asNavigationAssignment.getSlotExpression());
		NameExpCS csPropName = createNameExpCS(QVTcoreUtil.getTargetProperty(asNavigationAssignment));
		csAssignment.setOwnedTarget(createInfixExpCS(csSlotExp, ".", csPropName));
		csAssignment.setOwnedInitExpression(createExpCS(asNavigationAssignment.getValue()));
		csAssignment.setIsDefault(asNavigationAssignment.isIsDefault());
		csAssignment.setIsPartial(asNavigationAssignment.isIsPartial());
		return csAssignment;
	}

	@Override
	public ElementCS visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
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
	public ElementCS visitPattern(@NonNull Pattern object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitPredicate(@NonNull Predicate asPredicate) {
		if (asPredicate.eContainer() instanceof GuardPattern) {
			PredicateCS csPredicate = context.refreshElement(PredicateCS.class, QVTcoreCSPackage.Literals.PREDICATE_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedCondition(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
		else {
			PredicateOrAssignmentCS csPredicate = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedTarget(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
	}

	@Override
	public ElementCS visitPropertyAssignment(@NonNull PropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public ElementCS visitRealizedVariable(@NonNull RealizedVariable asRealizedVariable) {
		RealizedVariableCS csRealizedVariable = refreshTypedElement(RealizedVariableCS.class, QVTcoreCSPackage.Literals.REALIZED_VARIABLE_CS, asRealizedVariable);
		return csRealizedVariable;
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTcoreCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		//		csTransformation.setPivot(asTransformation);
		//		org.eclipse.ocl.pivot.Package owningPackage = asTransformation.getOwningPackage();
		//		if ((owningPackage == null) || "".equals(owningPackage.getName()) || (owningPackage.getName() == null)) {
		//			csTransformation.setOwnedPathName(null);
		//		}
		//		else {
		//			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		//			csTransformation.setOwnedPathName(csPathName);
		//			context.refreshPathName(csPathName, owningPackage, null);
		//		}
		context.refreshList(csTransformation.getOwnedDirections(), context.visitDeclarations(DirectionCS.class, asTransformation.getModelParameter(), null));

		return csTransformation;
	}

	@Override
	public ElementCS visitTypedModel(@NonNull TypedModel asTypedModel) {
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTcoreCSPackage.Literals.DIRECTION_CS, asTypedModel, null);
		if ("".equals(asTypedModel.getName())) {
			csDirection.setName(null);
		}
		PivotUtilInternal.refreshList(csDirection.getImports(), asTypedModel.getUsedPackage());
		PivotUtilInternal.refreshList(csDirection.getUses(), asTypedModel.getDependsOn());
		return csDirection;
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
	public ElementCS visitVariable(@NonNull Variable asVariable) {
		if (asVariable.eContainer() instanceof CorePattern) {
			UnrealizedVariableCS csUnrealizedVariable = refreshTypedElement(UnrealizedVariableCS.class, QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
			csUnrealizedVariable.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariable.getOwnedInit()));
			return csUnrealizedVariable;
		}
		else {
			return super.visitVariable(asVariable);
		}
	}

	@Override
	public ElementCS visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asVariableAssignment);
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable != null) {
			csAssignment.setOwnedTarget(createNameExpCS(asVariable));
		}
		csAssignment.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariableAssignment.getValue()));
		csAssignment.setIsDefault(asVariableAssignment.isIsDefault());
		csAssignment.setIsPartial(asVariableAssignment.isIsPartial());
		return csAssignment;
	}

}
