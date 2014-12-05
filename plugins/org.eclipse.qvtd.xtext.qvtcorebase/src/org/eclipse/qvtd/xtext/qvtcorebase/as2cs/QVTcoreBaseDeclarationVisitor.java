/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
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
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;

public abstract class QVTcoreBaseDeclarationVisitor extends EssentialOCLDeclarationVisitor implements QVTcoreBaseVisitor<ElementCS>
{
	/**
	 * QVTcoreBaseAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTcoreBaseAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTcoreBaseAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTcoreBaseAliasAnalysis) {
					QVTcoreBaseAliasAnalysis aliasAnalysis = (QVTcoreBaseAliasAnalysis)adapter;
					if (aliasAnalysis.metaModelManager == metaModelManager) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTcoreBaseAliasAnalysis(resource, metaModelManager);
		}

		public QVTcoreBaseAliasAnalysis(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
			super(resource, metaModelManager);
 		}
	}

	public QVTcoreBaseDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
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
		QVTcoreBaseAliasAnalysis aliasAdapter = QVTcoreBaseAliasAnalysis.getAdapter(csResource, context.getMetaModelManager());
		List<EObject> contents = csResource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof RootPackageCS) {
				for (ImportCS csImport : ((RootPackageCS)root).getOwnedImports()) {
					Element pivot = csImport.getPivot();
					if (pivot instanceof Unit) {
						Unit asUnit = (Unit)pivot;
						String alias = asUnit.getName();
						Namespace asNamespace = asUnit.getUsedPackage();
						if ((asNamespace != null) && (alias != null)) {
							aliasAdapter.getAlias(asNamespace, alias);
						}
					}
				}
			}
		}
	}

	public ElementCS visitAssignment(@NonNull Assignment object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitCoreDomain(@NonNull CoreDomain asCoreDomain) {
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asCoreDomain);
		csDomain.setPivot(asCoreDomain);
		csDomain.setBottomPattern(context.visitDeclaration(BottomPatternCS.class, asCoreDomain.getBottomPattern()));
		csDomain.setGuardPattern(context.visitDeclaration(GuardPatternCS.class, asCoreDomain.getGuardPattern()));
		csDomain.setCheck(asCoreDomain.isIsCheckable());
		csDomain.setDirection(asCoreDomain.getTypedModel());
		csDomain.setEnforce(asCoreDomain.isIsEnforceable());
		return csDomain;
	}

	public ElementCS visitCorePattern(@NonNull CorePattern object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitDomain(@NonNull Domain object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitEnforcementOperation(@NonNull EnforcementOperation object) {
		throw new UnsupportedOperationException();			// FIXME
	}

	public ElementCS visitFunction(@NonNull Function asFunction) {
		QueryCS csQuery = context.refreshNamedElement(QueryCS.class, QVTcoreBaseCSPackage.Literals.QUERY_CS, asFunction);
		csQuery.setPivot(asFunction);
		csQuery.setPathName(createPathNameCS(asFunction.getOwningClass()));
		csQuery.setOwnedType(createTypeRefCS(asFunction.getType()));
		context.refreshList(csQuery.getInputParamDeclaration(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameter(), null));
		csQuery.setExpression(createExpCS(asFunction.getQueryExpression()));
		return csQuery;
	}

	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = context.refreshNamedElement(ParamDeclarationCS.class, QVTcoreBaseCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		csParamDeclaration.setPivot(asFunctionParameter);
		csParamDeclaration.setOwnedType(createTypeRefCS(asFunctionParameter.getType()));
		return csParamDeclaration;
	}

	public ElementCS visitPattern(@NonNull Pattern object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitPredicate(@NonNull Predicate asPredicate) {
		AssignmentCS csPredicate = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asPredicate);
		csPredicate.setPivot(asPredicate);
		csPredicate.setTarget(createExpCS(asPredicate.getConditionExpression()));
		return csPredicate;
	}

	@Nullable
	public ElementCS visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		AssignmentCS csAssignment = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asPropertyAssignment);
		csAssignment.setPivot(asPropertyAssignment);
		InfixExpCS csTargetExp = context.refreshElement(InfixExpCS.class, EssentialOCLCSPackage.Literals.INFIX_EXP_CS, asPropertyAssignment);
		NamedElement asSlotExpression = asPropertyAssignment.getSlotExpression();
		if (asSlotExpression instanceof VariableExp) {
			asSlotExpression = ((VariableExp)asSlotExpression).getReferredVariable();
		}
		csTargetExp.setOwnedLeft(createNameExpCS(asSlotExpression));
		csTargetExp.setOwnedRight(createNameExpCS(asPropertyAssignment.getTargetProperty()));
//		NavigationOperatorCS csOperator = context.refreshElement(NavigationOperatorCS.class, EssentialOCLCSPackage.Literals.NAVIGATION_OPERATOR_CS, asPropertyAssignment);
		csTargetExp.setName(".");
//		csTargetExp.getOwnedOperator().add(csOperator);
		csAssignment.setTarget(csTargetExp);
		csAssignment.setInitialiser(createExpCS(asPropertyAssignment.getValue()));
		csAssignment.setDefault(asPropertyAssignment.isIsDefault());
		return csAssignment;
	}

	public ElementCS visitRealizedVariable(@NonNull RealizedVariable asRealizedVariable) {
		RealizedVariableCS csRealizedVariable = context.refreshNamedElement(RealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.REALIZED_VARIABLE_CS, asRealizedVariable);
		csRealizedVariable.setPivot(asRealizedVariable);
		csRealizedVariable.setOwnedType(createTypeRefCS(asRealizedVariable.getType(), getScope(asRealizedVariable)));
		return csRealizedVariable;
	}

	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitTransformation(@NonNull Transformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTcoreBaseCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		csTransformation.setPivot(asTransformation);
		context.refreshList(csTransformation.getDirections(), context.visitDeclarations(DirectionCS.class, asTransformation.getModelParameter(), null));
		return csTransformation;
	}

	public ElementCS visitTypedModel(@NonNull TypedModel asTypedModel) {
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTcoreBaseCSPackage.Literals.DIRECTION_CS, asTypedModel);
		csDirection.setPivot(asTypedModel);
		PivotUtil.refreshList(csDirection.getImports(), asTypedModel.getUsedPackage());
//		PivotUtil.refreshList(csDirection.getUses(), asTypedModel.getDependsOn());
		return csDirection;
	}

	public @Nullable ElementCS visitUnit(@NonNull Unit asUnit) {
		BaseCSResource csResource = context.getCSResource();
		Namespace asNamespace = asUnit.getUsedPackage();
		EObject eObject = asNamespace.getETarget();
		String importURI = null;
		if (eObject instanceof EPackage) {
			EPackage ePackage = (EPackage)eObject;
			Resource resource = ePackage.eResource();
			if (DomainUtil.isRegistered(resource)) {
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
			return csUnrealizedVariable;
		}
		else {
			return super.visitVariable(asVariable);
		}
	}

	@Nullable
	public ElementCS visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		AssignmentCS csAssignment = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asVariableAssignment);
		csAssignment.setPivot(asVariableAssignment);
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable != null) {
			csAssignment.setTarget(createNameExpCS(asVariable));
		}
		csAssignment.setInitialiser(context.visitDeclaration(ExpCS.class, asVariableAssignment.getValue()));
		csAssignment.setDefault(asVariableAssignment.isIsDefault());
		return csAssignment;
	}
}
