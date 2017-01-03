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
package org.eclipse.qvtd.xtext.qvtcore.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecs.util.AbstractQVTcoreCSContainmentVisitor;

import com.google.common.collect.Iterables;

public class QVTcoreCSContainmentVisitor extends AbstractQVTcoreCSContainmentVisitor
{
	protected static class IsAssignmentPredicate implements com.google.common.base.Predicate<PredicateOrAssignmentCS>
	{
		public final static @NonNull IsAssignmentPredicate INSTANCE = new IsAssignmentPredicate();

		@Override
		public boolean apply(PredicateOrAssignmentCS csAssignment) {
			return csAssignment.getOwnedInitExpression() != null;
		}
	}

	protected static class IsPredicatePredicate implements com.google.common.base.Predicate<PredicateOrAssignmentCS>
	{
		public final static @NonNull IsPredicatePredicate INSTANCE = new IsPredicatePredicate();

		@Override
		public boolean apply(PredicateOrAssignmentCS csAssignment) {
			return csAssignment.getOwnedInitExpression() == null;
		}
	}

	protected static class DirectionContentContinuation extends SingleContinuation<DirectionCS>
	{
		private DirectionContentContinuation(@NonNull CS2ASConversion context, @NonNull DirectionCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			if (pTypedModel != null) {
				PivotUtilInternal.refreshList(pTypedModel.getUsedPackage(), csElement.getImports());
			}
			return null;
		}
	}

	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(@NonNull CS2ASConversion context, @NonNull DomainCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			CoreDomain pDomain = PivotUtil.getPivot(CoreDomain.class, csElement);
			if (pDomain != null) {
				TypedModel direction = csElement.getDirection();
				if (direction == null) {
					Transformation transformation = QVTbaseUtil.getContainingTransformation(pDomain);
					if (transformation != null) {
						direction = transformation.getModelParameter(null);
					}
				}
				pDomain.setTypedModel(direction);
			}
			return null;
		}
	}

	public QVTcoreCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected void resolveTransformationMappings(@NonNull Iterable<? extends @NonNull MappingCS> csMappings) {
		Map<@NonNull Transformation, List<@NonNull Mapping>> tx2mappings = new HashMap<@NonNull Transformation, List<@NonNull Mapping>>();
		for (@NonNull MappingCS csMapping : csMappings) {
			PathNameCS csInPathName = csMapping.getOwnedInPathName();
			if (csInPathName != null) {
				Transformation asTransformation = lookupTransformation(csMapping, csInPathName, null);
				if (asTransformation != null) {
					Mapping asMapping = PivotUtil.getPivot(Mapping.class, csMapping);
					if (asMapping != null) {
						List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
						if (asMappings == null) {
							asMappings = new ArrayList<@NonNull Mapping>();
							tx2mappings.put(asTransformation, asMappings);
						}
						asMappings.add(asMapping);
					}
				}
			}
		}
		for (@NonNull Transformation asTransformation : tx2mappings.keySet()) {
			List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
			List<Rule> asRules = asTransformation.getRule();
			if (asMappings != null) {
				PivotUtilInternal.refreshList(asRules, asMappings);
			}
			else {
				asRules.clear();
			}
		}
	}

	protected void resolveTransformationQueries(@NonNull Iterable<@NonNull QueryCS> csQueries) {
		Map<@NonNull Transformation, List<@NonNull Function>> tx2qMap = new HashMap<@NonNull Transformation, List<@NonNull Function>>();
		for (@NonNull QueryCS csQuery : csQueries) {
			Transformation asTransformation = csQuery.getTransformation();
			if (asTransformation != null) {
				Function asQuery = PivotUtil.getPivot(Function.class,  csQuery);
				if (asQuery != null) {
					List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
					if (asQueries == null) {
						asQueries = new ArrayList<@NonNull Function>();
						tx2qMap.put(asTransformation, asQueries);
					}
					asQueries.add(asQuery);
				}
			}
		}
		for (Transformation asTransformation : tx2qMap.keySet()) {
			List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
			List<Operation> asOperations = asTransformation.getOwnedOperations();
			if (asQueries != null) {
				PivotUtilInternal.refreshList(asOperations, asQueries);
			}
			else {
				asOperations.clear();
			}
		}
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		BottomPattern pBottomPattern = context.refreshModelElement(BottomPattern.class, QVTcorePackage.Literals.BOTTOM_PATTERN, csElement);
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getOwnedRealizedVariables());
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getOwnedUnrealizedVariables());
		context.refreshPivotList(EnforcementOperation.class, pBottomPattern.getEnforcementOperation(), csElement.getOwnedEnforcementOperations());
		context.refreshPivotList(Assignment.class, pBottomPattern.getAssignment(), Iterables.filter(csElement.getOwnedConstraints(), IsAssignmentPredicate.INSTANCE));
		context.refreshPivotList(Predicate.class, pBottomPattern.getPredicate(), Iterables.filter(csElement.getOwnedConstraints(), IsPredicatePredicate.INSTANCE));
		context.refreshComments(pBottomPattern, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return new DirectionContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		EObject eContainer = csElement.eContainer();
		if ((eContainer instanceof MappingCS) && (((MappingCS)eContainer).getOwnedMiddle() == csElement)) {
			return null;
		}
		CoreDomain pivotElement = context.refreshModelElement(CoreDomain.class, QVTcorePackage.Literals.CORE_DOMAIN, csElement);
		pivotElement.setIsCheckable(csElement.isIsCheck());
		pivotElement.setIsEnforceable(csElement.isIsEnforce());
		pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csElement.getOwnedBottomPattern()));
		pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csElement.getOwnedGuardPattern()));
		context.refreshComments(pivotElement, csElement);
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(@NonNull EnforcementOperationCS csElement) {
		context.refreshModelElement(EnforcementOperation.class, QVTcorePackage.Literals.ENFORCEMENT_OPERATION, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		@NonNull GuardPattern pGuardPattern = context.refreshModelElement(GuardPattern.class, QVTcorePackage.Literals.GUARD_PATTERN, csElement);
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getOwnedUnrealizedVariables());
		context.refreshPivotList(Predicate.class, pGuardPattern.getPredicate(), csElement.getOwnedPredicates());
		context.refreshComments(pGuardPattern, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		if (csElement.eContainer() instanceof TopLevelCS) {
			if (csElement.getName() == null) {
				context.addDiagnostic(csElement, "top level mapping must be named");
			}
		}
		else {
			if (csElement.getName() != null) {
				context.addDiagnostic(csElement, "composed mapping must be unnamed");
			}
		}
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTcorePackage.Literals.MAPPING, csElement);
		DomainCS csMiddle = csElement.getOwnedMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getOwnedBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getOwnedGuardPattern()));
		}
		else {
			BottomPattern bottomPattern = pivotElement.getBottomPattern();
			if (bottomPattern == null) {
				bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
				bottomPattern.getAssignment().clear();
				bottomPattern.getBindsTo().clear();
				bottomPattern.getEnforcementOperation().clear();
				bottomPattern.getPredicate().clear();
				bottomPattern.getRealizedVariable().clear();
				bottomPattern.getVariable().clear();
				pivotElement.setBottomPattern(bottomPattern);
			}
			GuardPattern guardPattern = pivotElement.getGuardPattern();
			if (guardPattern == null) {
				guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
				guardPattern.getBindsTo().clear();
				guardPattern.getPredicate().clear();
				guardPattern.getVariable().clear();
				pivotElement.setGuardPattern(guardPattern);
			}
		}
		context.refreshPivotList(CoreDomain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		context.refreshPivotList(Mapping.class, pivotElement.getLocal(), csElement.getOwnedComposedMappings());
		pivotElement.setIsDefault(csElement.isIsDefault());
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPredicateOrAssignmentCS(@NonNull PredicateOrAssignmentCS csElement) {
		ExpCS csTarget = csElement.getOwnedTarget();
		if (csElement.getOwnedInitExpression() == null) {
			context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		}
		else if (csTarget instanceof NameExpCS) {
			VariableAssignment asAssignment = context.refreshModelElement(VariableAssignment.class, QVTcorePackage.Literals.VARIABLE_ASSIGNMENT, csElement);
			asAssignment.setIsPartial(csElement.isIsPartial());
		}
		else {
			PropertyAssignment asAssignment = context.refreshModelElement(PropertyAssignment.class, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT, csElement);
			asAssignment.setIsDefault(csElement.isIsDefault());
			asAssignment.setIsPartial(csElement.isIsPartial());
		}
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, QVTbasePackage.Literals.TRANSFORMATION, csElement, null);
		}
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		//		pivotElement.setIsStatic(true);
		pivotElement.setIsTransient(csElement.isIsTransient());
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(@NonNull RealizedVariableCS csElement) {
		refreshNamedElement(RealizedVariable.class, QVTcorePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull CoreModel asModel = refreshRoot(CoreModel.class, QVTcorePackage.Literals.CORE_MODEL, csElement);
		installPackageStructure(asModel, ClassUtil.nullFree(csElement.getOwnedPackages()), ClassUtil.nullFree(csElement.getOwnedTransformations()));
		context.refreshPivotList(Import.class, asModel.getOwnedImports(), csElement.getOwnedImports());
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asModel);		// Ensure containment viable for imported library type references
			//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		resolveTransformationMappings(ClassUtil.nullFree(csElement.getOwnedMappings()));
		resolveTransformationQueries(ClassUtil.nullFree(csElement.getOwnedQueries()));
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@SuppressWarnings("null") @NonNull EClass eClass = QVTbasePackage.Literals.TRANSFORMATION;
		Transformation asTransformation = refreshNamedElement(Transformation.class, eClass, csElement);
		refreshClassifier(asTransformation, csElement);
		context.refreshPivotList(TypedModel.class, asTransformation.getModelParameter(), csElement.getOwnedDirections());
		QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		if (csElement.eContainer() instanceof GuardPatternCS) {
			refreshNamedElement(GuardVariable.class, QVTcorePackage.Literals.GUARD_VARIABLE, csElement);
		}
		else {
			refreshNamedElement(BottomVariable.class, QVTcorePackage.Literals.BOTTOM_VARIABLE, csElement);
		}
		return null;
	}
}
