/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.as2cs;

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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
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
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.as2cs.QVTbaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ConnectionStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeRealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.UnrealizedVariableCS;

public class QVTimperativeDeclarationVisitor extends QVTbaseDeclarationVisitor implements QVTimperativeVisitor<ElementCS>
{
	/**
	 * QVTimperativeAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTimperativeAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTimperativeAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTimperativeAliasAnalysis) {
					QVTimperativeAliasAnalysis aliasAnalysis = (QVTimperativeAliasAnalysis)adapter;
					if (aliasAnalysis.environmentFactory == environmentFactory) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTimperativeAliasAnalysis(resource, environmentFactory);
		}

		public QVTimperativeAliasAnalysis(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(resource, environmentFactory);
		}
	}

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

	public QVTimperativeDeclarationVisitor(@NonNull AS2CSConversion context) {
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

	protected @NonNull ImperativeDomainCS createCoreDomain(@NonNull CoreDomain asCoreDomain) {
		return context.refreshElement(ImperativeDomainCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_DOMAIN_CS, asCoreDomain);
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
		TypedModel typedModel = QVTimperativeUtil.getTypedModel(QVTimperativeUtil.getContainingArea(asVariable));
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
		QVTimperativeAliasAnalysis aliasAdapter = QVTimperativeAliasAnalysis.getAdapter(csResource, context.getEnvironmentFactory());
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

	protected void refreshOwnedInTransformation(@NonNull MappingCS csMapping, @NonNull AbstractMapping asMapping) {
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

	protected void refreshReferredMapping(@NonNull MappingCallCS csMappingCall, @NonNull MappingCall asMappingCall) {
		Mapping asMapping = asMappingCall.getReferredMapping();
		if (asMapping != null) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMappingCall.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, asMapping, QVTbaseUtil.getContainingTransformation(asMappingCall));
		}
		else {
			csMappingCall.setOwnedPathName(null);
		}
	}

	protected void refreshUsedProperties(@NonNull Transformation asTransformation, /*@NonNull*/ List<PathNameCS> csPathNames, /*@NonNull*/ List<@NonNull Property> asProperties) {
		List<PathNameCS> pathNames = new ArrayList<PathNameCS>();
		for (@NonNull Property asProperty : asProperties) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			pathNames.add(csPathName);
			context.refreshPathName(csPathName, asProperty, asTransformation);
		}
		context.refreshList(csPathNames, pathNames);
	}

	protected void refreshUsedTypes(@NonNull MappingCS csMapping, @NonNull Mapping asMapping) {
		List<PathNameCS> csPathNames = new ArrayList<PathNameCS>();
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asMapping.getPolledClasses())) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathNames.add(csPathName);
			Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asMapping);
			context.refreshPathName(csPathName, asClass, asTransformation);
		}
		context.refreshList(csMapping.getOwnedUsesPathNames(), csPathNames);
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
		Area asArea = asBottomPattern.getArea();
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTimperativeCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		if (asArea instanceof Mapping) {
			List<Element> asConstraints = new ArrayList<Element>(asBottomPattern.getAssignment());
			asConstraints.addAll(asBottomPattern.getPredicate());
			context.refreshList(csBottomPattern.getOwnedConstraints(), context.visitDeclarations(ImperativePredicateOrAssignmentCS.class, asConstraints, null));
			context.refreshList(csBottomPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		else {
			context.refreshList(csBottomPattern.getOwnedRealizedVariables(), context.visitDeclarations(ImperativeRealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
			context.refreshList(csBottomPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		return csBottomPattern;
	}

	@Override
	public ElementCS visitConnectionAssignment(@NonNull ConnectionAssignment asConnectionAssignment) {
		ImperativePredicateOrAssignmentCS csAssignment = context.refreshElement(ImperativePredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS, asConnectionAssignment);
		csAssignment.setPivot(asConnectionAssignment);
		Variable asVariable = asConnectionAssignment.getTargetVariable();
		if (asVariable != null) {
			assert asVariable.eContainer().eContainer() instanceof Mapping;
			csAssignment.setOwnedTarget(createNameExpCS(asVariable));
			csAssignment.setIsAccumulate(true);
		}
		csAssignment.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asConnectionAssignment.getValue()));
		assert !asConnectionAssignment.isIsDefault();
		return csAssignment;
	}

	@Override
	public ElementCS visitConnectionStatement(@NonNull ConnectionStatement asConnectionStatement) {
		ConnectionStatementCS csStatement = context.refreshElement(ConnectionStatementCS.class, QVTimperativeCSPackage.Literals.CONNECTION_STATEMENT_CS, asConnectionStatement);
		csStatement.setPivot(asConnectionStatement);
		Variable asVariable = asConnectionStatement.getTargetVariable();
		if (asVariable != null) {
			assert asVariable.eContainer().eContainer() instanceof Mapping;
			csStatement.setTargetVariable(asVariable);
		}
		csStatement.setOwnedExpression(context.visitDeclaration(ExpCS.class, asConnectionStatement.getValue()));
		return csStatement;
	}

	@Override
	public ElementCS visitConnectionVariable(@NonNull ConnectionVariable object) {
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
		QueryCS csQuery = refreshTypedElement(QueryCS.class, QVTimperativeCSPackage.Literals.QUERY_CS, asFunction);
		csQuery.setOwnedPathName(createPathNameCS(asFunction.getOwningClass()));
		context.refreshList(csQuery.getOwnedParameters(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameters(), null));
		csQuery.setOwnedExpression(createExpCS(asFunction.getQueryExpression()));
		csQuery.setIsTransient(asFunction.isIsTransient());
		return csQuery;
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = refreshTypedElement(ParamDeclarationCS.class, QVTimperativeCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		return csParamDeclaration;
	}

	@Override
	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		Area asArea = asGuardPattern.getArea();
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTimperativeCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		csGuardPattern.setPivot(asGuardPattern);
		if (asArea instanceof Mapping) {
			context.refreshList(csGuardPattern.getOwnedPredicates(), context.visitDeclarations(PredicateCS.class, asGuardPattern.getPredicate(), null));
			context.refreshList(csGuardPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		}
		else {
			context.refreshList(csGuardPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		}
		return csGuardPattern;
	}

	@Override
	public ElementCS visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public ElementCS visitImperativeDomain(@NonNull ImperativeDomain asImperativeDomain) {
		ImperativeDomainCS csDomain = (ImperativeDomainCS) visitCoreDomain(asImperativeDomain);
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asImperativeDomain);
		assert asTransformation != null;
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), ClassUtil.nullFree(asImperativeDomain.getCheckedProperties()));
		refreshUsedProperties(asTransformation, csDomain.getEnforcedProperties(), ClassUtil.nullFree(asImperativeDomain.getEnforcedProperties()));
		return csDomain;
	}

	@Override
	public ElementCS visitImperativeModel(@NonNull ImperativeModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTimperativeCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getOwnedImports(), null));

		buildModel(csDocument, asModel);

		List<Mapping> asMappings = null;
		List<Function> asQueries = null;
		List<Transformation> asTransformations = new ArrayList<Transformation>();
		gatherTransformations(asTransformations, asModel.getOwnedPackages());
		for (Transformation asTransformation : asTransformations) {
			for (Rule asRule : asTransformation.getRule()) {
				if (asRule instanceof Mapping) {
					if (asMappings == null) {
						asMappings = new ArrayList<Mapping>();
					}
					asMappings.add((Mapping) asRule);
				}
			}
			for (Operation asOperation : asTransformation.getOwnedOperations()) {
				if (asOperation instanceof Function) {
					if (asQueries == null) {
						asQueries = new ArrayList<Function>();
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
	public ElementCS visitMapping(@NonNull Mapping asMapping) {
		MappingCS csMapping = context.refreshNamedElement(MappingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CS, asMapping);
		csMapping.setPivot(asMapping);
		csMapping.setIsDefault(asMapping.isIsDefault());
		refreshOwnedInTransformation(csMapping, asMapping);
		refreshUsedTypes(csMapping, asMapping);
		context.refreshList(csMapping.getOwnedDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		ImperativeDomainCS csDomain = context.refreshElement(ImperativeDomainCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_DOMAIN_CS, asMapping);
		csDomain.setPivot(null);		// stop comment duplication
		csDomain.setOwnedBottomPattern(context.visitDeclaration(BottomPatternCS.class, asMapping.getBottomPattern()));
		csDomain.setOwnedGuardPattern(context.visitDeclaration(GuardPatternCS.class, asMapping.getGuardPattern()));
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asMapping);
		assert asTransformation != null;
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), ClassUtil.nullFree(asMapping.getCheckedProperties()));
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), ClassUtil.nullFree(asMapping.getCheckedProperties()));
		csMapping.setOwnedMiddle(csDomain);
		csMapping.setOwnedKeyExpression(createExpCS(asMapping.getOwnedKeyExpression()));
		MappingStatementCS csMappingStatement = context.visitDeclaration(MappingStatementCS.class, asMapping.getMappingStatement());
		MappingSequenceCS csMappingSequence;
		if (csMappingStatement instanceof MappingSequenceCS) {
			csMappingSequence = (MappingSequenceCS) csMappingStatement;
		}
		else if (csMappingStatement != null) {
			csMappingSequence = csMapping.getOwnedMappingSequence();
			if (csMappingSequence == null) {
				csMappingSequence = QVTimperativeCSFactory.eINSTANCE.createMappingSequenceCS();
			}
			else {
				csMappingSequence.getOwnedMappingStatements().clear();
			}
			csMappingSequence.getOwnedMappingStatements().add(csMappingStatement);
		}
		else {
			csMappingSequence = null;
		}
		csMapping.setOwnedMappingSequence(csMappingSequence);
		return csMapping;
	}

	@Override
	public ElementCS visitMappingCall(@NonNull MappingCall asMappingCall) {
		MappingCallCS csMappingCall = context.refreshElement(MappingCallCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_CS, asMappingCall);
		csMappingCall.setPivot(asMappingCall);
		context.refreshList(csMappingCall.getOwnedBindings(), context.visitDeclarations(MappingCallBindingCS.class, asMappingCall.getBinding(), null));
		csMappingCall.setIsInfinite(asMappingCall.isIsInfinite());
		refreshReferredMapping(csMappingCall, asMappingCall);
		return csMappingCall;
	}

	@Override
	public ElementCS visitMappingCallBinding(@NonNull MappingCallBinding asMappingCallBinding) {
		MappingCallBindingCS csMappingCallBinding = context.refreshElement(MappingCallBindingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_BINDING_CS, asMappingCallBinding);
		csMappingCallBinding.setPivot(asMappingCallBinding);
		csMappingCallBinding.setIsPolled(asMappingCallBinding.isIsPolled());
		csMappingCallBinding.setReferredVariable(asMappingCallBinding.getBoundVariable());
		csMappingCallBinding.setOwnedValue(createExpCS(asMappingCallBinding.getValue()));
		return csMappingCallBinding;
	}

	@Override
	public ElementCS visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		MappingLoopCS csMappingLoop = context.refreshElement(MappingLoopCS.class, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS, asMappingLoop);
		csMappingLoop.setPivot(asMappingLoop);
		csMappingLoop.setOwnedIterator(context.visitDeclaration(VariableCS.class, asMappingLoop.getOwnedIterators().get(0)));
		csMappingLoop.setOwnedInExpression(createExpCS(asMappingLoop.getOwnedSource()));
		MappingStatementCS csMappingStatement = context.visitDeclaration(MappingStatementCS.class, asMappingLoop.getOwnedBody());
		MappingSequenceCS csMappingSequence;
		if (csMappingStatement instanceof MappingSequenceCS) {
			csMappingSequence = (MappingSequenceCS) csMappingStatement;
		}
		else if (csMappingStatement != null) {
			csMappingSequence = csMappingLoop.getOwnedMappingSequence();
			if (csMappingSequence == null) {
				csMappingSequence = QVTimperativeCSFactory.eINSTANCE.createMappingSequenceCS();
			}
			else {
				csMappingSequence.getOwnedMappingStatements().clear();
			}
			csMappingSequence.getOwnedMappingStatements().add(csMappingStatement);
		}
		else {
			csMappingSequence = null;
		}
		csMappingLoop.setOwnedMappingSequence(csMappingSequence);
		return csMappingLoop;
	}

	@Override
	public ElementCS visitMappingSequence(@NonNull MappingSequence asMappingSequence) {
		List<MappingStatement> asMappingStatements = asMappingSequence.getMappingStatements();
		if (asMappingStatements.size() <= 0) {
			return null;
		}
		MappingSequenceCS csMappingSequence = context.refreshElement(MappingSequenceCS.class, QVTimperativeCSPackage.Literals.MAPPING_SEQUENCE_CS, asMappingSequence);
		context.refreshList(csMappingSequence.getOwnedMappingStatements(), context.visitDeclarations(MappingStatementCS.class, asMappingStatements, null));
		return csMappingSequence;
	}

	@Override
	public ElementCS visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(PredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asNavigationAssignment);
		ExpCS csSlotExp = createExpCS(asNavigationAssignment.getSlotExpression());
		NameExpCS csPropName = createNameExpCS(QVTimperativeUtil.getTargetProperty(asNavigationAssignment));
		csAssignment.setOwnedTarget(createInfixExpCS(csSlotExp, ".", csPropName));
		csAssignment.setOwnedInitExpression(createExpCS(asNavigationAssignment.getValue()));
		csAssignment.setIsDefault(asNavigationAssignment.isIsDefault());
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
		EObject eContainer = asPredicate.eContainer();
		if (eContainer instanceof BottomPattern) {
			Area area = ((BottomPattern)eContainer).getArea();
			if (area instanceof Mapping) {
				ImperativePredicateOrAssignmentCS csPredicate = context.refreshElement(ImperativePredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS, asPredicate);
				csPredicate.setPivot(asPredicate);
				csPredicate.setOwnedTarget(createExpCS(asPredicate.getConditionExpression()));
				return csPredicate;
			}
		}
		if (asPredicate.eContainer() instanceof GuardPattern) {
			PredicateCS csPredicate = context.refreshElement(PredicateCS.class, QVTimperativeCSPackage.Literals.PREDICATE_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedCondition(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
		else {
			PredicateOrAssignmentCS csPredicate = context.refreshElement(PredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedTarget(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
	}

	@Override
	public ElementCS visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(ImperativePredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS, asPropertyAssignment);
		csAssignment.setPivot(asPropertyAssignment);
		ExpCS csSlotExp = createExpCS(asPropertyAssignment.getSlotExpression());
		NameExpCS csPropName = createNameExpCS(asPropertyAssignment.getTargetProperty());
		csAssignment.setOwnedTarget(createInfixExpCS(csSlotExp, ".", csPropName));
		csAssignment.setOwnedInitExpression(createExpCS(asPropertyAssignment.getValue()));
		csAssignment.setIsDefault(asPropertyAssignment.isIsDefault());
		return csAssignment;
	}

	@Override
	public ElementCS visitRealizedVariable(@NonNull RealizedVariable asRealizedVariable) {
		ImperativeRealizedVariableCS csRealizedVariable = context.refreshNamedElement(ImperativeRealizedVariableCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_REALIZED_VARIABLE_CS, asRealizedVariable);
		csRealizedVariable.setPivot(asRealizedVariable);
		csRealizedVariable.setOwnedType(createTypeRefCS(asRealizedVariable.getType(), getScope(asRealizedVariable)));
		csRealizedVariable.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asRealizedVariable.getOwnedInit()));
		return csRealizedVariable;
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTimperativeCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
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
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTimperativeCSPackage.Literals.DIRECTION_CS, asTypedModel, null);
		if ("".equals(asTypedModel.getName())) {
			csDirection.setName(null);
		}
		PivotUtilInternal.refreshList(csDirection.getImports(), asTypedModel.getUsedPackage());
		//		PivotUtil.refreshList(csDirection.getUses(), asTypedModel.getDependsOn());
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
		if (asVariable.eContainer() instanceof MappingLoop) {
			VariableCS csVariable = context.refreshNamedElement(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, asVariable);
			Type type = asVariable.getType();
			if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != context.getMetamodelManager().getStandardLibrary().getCollectionType())) {
				PivotUtil.debugWellContainedness(type);
				type = ((CollectionType)type).getElementType();
			}
			else if (type instanceof VoidType) {
				type = null;
			}
			if (type != null) {
				PivotUtil.debugWellContainedness(type);
				TypedRefCS typeRef = context.visitReference(TypedRefCS.class, type, null);
				csVariable.setOwnedType(typeRef);
			}
			else {
				csVariable.setOwnedType(null);
			}
			//		refreshList(csElement.getOwnedConstraint(), visitDeclarations(ConstraintCS.class, object.getOwnedRule(), null));
			return csVariable;
		}
		else if (asVariable.eContainer() instanceof GuardPattern){
			Mapping containingMapping = QVTimperativeUtil.getContainingMapping(asVariable);
			assert containingMapping != null;
			UnrealizedVariableCS csUnrealizedVariable = context.refreshNamedElement(UnrealizedVariableCS.class, QVTimperativeCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
			csUnrealizedVariable.setPivot(asVariable);
			csUnrealizedVariable.setOwnedType(createTypeRefCS(asVariable.getType(), getScope(asVariable)));
			OCLExpression ownedInit = null;
			for (Predicate asPredicate : containingMapping.getGuardPattern().getPredicate()) {
				if (asPredicate instanceof VariablePredicate) {
					VariablePredicate asVariablePredicate = (VariablePredicate)asPredicate;
					if (asVariablePredicate.getTargetVariable() == asVariable) {
						ownedInit = asVariablePredicate.getConditionExpression();
						break;
					}
				}
			}
			csUnrealizedVariable.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, ownedInit));
			return csUnrealizedVariable;
		}
		else {
			if (asVariable.eContainer() instanceof CorePattern) {
				UnrealizedVariableCS csUnrealizedVariable = refreshTypedElement(UnrealizedVariableCS.class, QVTimperativeCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
				csUnrealizedVariable.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariable.getOwnedInit()));
				return csUnrealizedVariable;
			}
			else {
				return super.visitVariable(asVariable);
			}
		}
	}

	@Override
	public ElementCS visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		ImperativePredicateOrAssignmentCS csAssignment = context.refreshElement(ImperativePredicateOrAssignmentCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS, asVariableAssignment);
		csAssignment.setPivot(asVariableAssignment);
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable != null) {
			assert (asVariable.eContainer() instanceof BottomPattern) || !(asVariable.eContainer().eContainer() instanceof Mapping);
			csAssignment.setOwnedTarget(createNameExpCS(asVariable));
		}
		csAssignment.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariableAssignment.getValue()));
		csAssignment.setIsDefault(asVariableAssignment.isIsDefault());
		return csAssignment;
	}

	@Override
	public ElementCS visitVariablePredicate(@NonNull VariablePredicate asVariablePredicate) {
		return null;
	}
}
