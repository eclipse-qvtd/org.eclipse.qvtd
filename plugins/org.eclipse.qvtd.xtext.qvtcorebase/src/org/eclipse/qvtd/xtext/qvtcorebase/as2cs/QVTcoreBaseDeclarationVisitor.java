/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 456371
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.as2cs;

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
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLDeclarationVisitor;
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
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;

public abstract class QVTcoreBaseDeclarationVisitor extends EssentialOCLDeclarationVisitor implements QVTcoreBaseVisitor<ElementCS>
{
	/**
	 * QVTcoreBaseAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTcoreBaseAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTcoreBaseAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTcoreBaseAliasAnalysis) {
					QVTcoreBaseAliasAnalysis aliasAnalysis = (QVTcoreBaseAliasAnalysis)adapter;
					if (aliasAnalysis.environmentFactory == environmentFactory) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTcoreBaseAliasAnalysis(resource, environmentFactory);
		}

		public QVTcoreBaseAliasAnalysis(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(resource, environmentFactory);
 		}
	}

	public QVTcoreBaseDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	protected @NonNull DomainCS createCoreDomain(@NonNull CoreDomain asCoreDomain) {
		return context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asCoreDomain);
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
		TypedModel typedModel = QVTcoreBaseUtil.getTypedModel(QVTcoreBaseUtil.getContainingArea(asVariable));
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
	 * Post-processing sets up the AliasAdapter with the names from the Unit declarations
	 */
	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<Namespace, List<String>> importedNamespaces) {
		AliasAnalysis.dispose(csResource);
		QVTcoreBaseAliasAnalysis aliasAdapter = QVTcoreBaseAliasAnalysis.getAdapter(csResource, context.getEnvironmentFactory());
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

	protected void refreshOwnedInTransformation(@NonNull AbstractMappingCS csMapping, @NonNull AbstractMapping asMapping) {
		Transformation asTransformation = asMapping.getTransformation();
		if (asTransformation != null) {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMapping.setOwnedInPathName(csPathName);
			org.eclipse.ocl.pivot.Package asPackage = asTransformation.getOwningPackage();
			String asPackageName = asPackage != null ? asPackage.getName() : null;
			if ((asPackageName == null) || "".equals(asPackageName)) {
				@SuppressWarnings("null") @NonNull PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
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
		QueryCS csQuery = context.refreshNamedElement(QueryCS.class, QVTcoreBaseCSPackage.Literals.QUERY_CS, asFunction);
		csQuery.setPivot(asFunction);
		csQuery.setOwnedPathName(createPathNameCS(asFunction.getOwningClass()));
		csQuery.setOwnedType(createTypeRefCS(asFunction.getType()));
		context.refreshList(csQuery.getOwnedParameters(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameters(), null));
		csQuery.setOwnedExpression(createExpCS(asFunction.getQueryExpression()));
		return csQuery;
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = context.refreshNamedElement(ParamDeclarationCS.class, QVTcoreBaseCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		csParamDeclaration.setPivot(asFunctionParameter);
		csParamDeclaration.setOwnedType(createTypeRefCS(asFunctionParameter.getType()));
		return csParamDeclaration;
	}

	@Override
	public ElementCS visitPattern(@NonNull Pattern object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitPredicate(@NonNull Predicate asPredicate) {
		if (asPredicate.eContainer() instanceof GuardPattern) {
			PredicateCS csPredicate = context.refreshElement(PredicateCS.class, QVTcoreBaseCSPackage.Literals.PREDICATE_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedCondition(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
		else {
			PredicateOrAssignmentCS csPredicate = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreBaseCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asPredicate);
			csPredicate.setPivot(asPredicate);
			csPredicate.setOwnedTarget(createExpCS(asPredicate.getConditionExpression()));
			return csPredicate;
		}
	}

	@Override
	public ElementCS visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreBaseCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asPropertyAssignment);
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
		RealizedVariableCS csRealizedVariable = context.refreshNamedElement(RealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.REALIZED_VARIABLE_CS, asRealizedVariable);
		csRealizedVariable.setPivot(asRealizedVariable);
		csRealizedVariable.setOwnedType(createTypeRefCS(asRealizedVariable.getType(), getScope(asRealizedVariable)));
		return csRealizedVariable;
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTcoreBaseCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		csTransformation.setPivot(asTransformation);
		org.eclipse.ocl.pivot.Package owningPackage = asTransformation.getOwningPackage();
		if ((owningPackage == null) || "".equals(owningPackage.getName()) || (owningPackage.getName() == null)) {
			csTransformation.setOwnedPathName(null);
		}
		else {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csTransformation.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, owningPackage, null);
		}
		context.refreshList(csTransformation.getOwnedDirections(), context.visitDeclarations(DirectionCS.class, asTransformation.getModelParameter(), null));
		return csTransformation;
	}

	@Override
	public ElementCS visitTypedModel(@NonNull TypedModel asTypedModel) {
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTcoreBaseCSPackage.Literals.DIRECTION_CS, asTypedModel, null);
		csDirection.setPivot(asTypedModel);
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
		@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
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
			UnrealizedVariableCS csUnrealizedVariable = context.refreshNamedElement(UnrealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
			csUnrealizedVariable.setPivot(asVariable);
			csUnrealizedVariable.setOwnedType(createTypeRefCS(asVariable.getType(), getScope(asVariable)));
			csUnrealizedVariable.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariable.getOwnedInit()));
			return csUnrealizedVariable;
		}
		else {
			return super.visitVariable(asVariable);
		}
	}

	@Override
	public ElementCS visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		PredicateOrAssignmentCS csAssignment = context.refreshElement(PredicateOrAssignmentCS.class, QVTcoreBaseCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS, asVariableAssignment);
		csAssignment.setPivot(asVariableAssignment);
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable != null) {
			csAssignment.setOwnedTarget(createNameExpCS(asVariable));
		}
		csAssignment.setOwnedInitExpression(context.visitDeclaration(ExpCS.class, asVariableAssignment.getValue()));
		csAssignment.setIsDefault(asVariableAssignment.isIsDefault());
		return csAssignment;
	}
}
