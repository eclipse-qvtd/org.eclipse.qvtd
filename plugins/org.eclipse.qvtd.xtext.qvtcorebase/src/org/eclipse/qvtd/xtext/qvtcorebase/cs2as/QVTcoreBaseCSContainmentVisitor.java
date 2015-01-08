/*******************************************************************************
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.AbstractQVTcoreBaseCSContainmentVisitor;

import com.google.common.collect.Iterables;

public class QVTcoreBaseCSContainmentVisitor extends AbstractQVTcoreBaseCSContainmentVisitor
{
	protected static class IsAssignmentPredicate implements com.google.common.base.Predicate<AssignmentCS>
	{
		public final static @NonNull IsAssignmentPredicate INSTANCE = new IsAssignmentPredicate();
		
		@Override
		public boolean apply(AssignmentCS csAssignment) {
			return csAssignment.getInitialiser() != null;
		}
	}

	protected static class IsPredicatePredicate implements com.google.common.base.Predicate<AssignmentCS>
	{
		public final static @NonNull IsPredicatePredicate INSTANCE = new IsPredicatePredicate();
		
		@Override
		public boolean apply(AssignmentCS csAssignment) {
			return csAssignment.getInitialiser() == null;
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

	public QVTcoreBaseCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}	

	protected @NonNull List<org.eclipse.ocl.pivot.Package> resolveTransformations(@NonNull List<TransformationCS> csTransformations, @NonNull BaseModel asCoreModel) {
		List<org.eclipse.ocl.pivot.Package> asPackages = new ArrayList<org.eclipse.ocl.pivot.Package>();
		Map<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Package>> package2ownedPackages = new HashMap<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Package>>();
		Map<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Class>> package2ownedClasses = new HashMap<org.eclipse.ocl.pivot.Package, List<org.eclipse.ocl.pivot.Class>>();
		for (TransformationCS csTransformation : csTransformations) {
			org.eclipse.ocl.pivot.Package asParent = null;
			Transformation asTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			PathNameCS pathName = csTransformation.getPathName();
			List<PathElementCS> ownedPathElements = pathName != null ? pathName.getOwnedPathElements() : null;
			if ((ownedPathElements == null) || ownedPathElements.isEmpty()) {
				asParent = NameUtil.getNameable(asCoreModel.getOwnedPackages(), "");
				if (asParent == null) {
					asParent = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, null);
					asParent.setName("");
				}
				asPackages.add(asParent);
			}
			else {
				for (PathElementCS pathElement : ownedPathElements) {
					String name = pathElement.toString();
					List<org.eclipse.ocl.pivot.Package> asOldPackages;
					List<org.eclipse.ocl.pivot.Package> asNewPackages;
					if (asParent == null) {
						asOldPackages = asCoreModel.getOwnedPackages();
						asNewPackages = asPackages;
					}
					else {
						asOldPackages = asParent.getOwnedPackages();
						asNewPackages = package2ownedPackages.get(asParent);
						if (asNewPackages == null) {
							asNewPackages = new ArrayList<org.eclipse.ocl.pivot.Package>();
							package2ownedPackages.put(asParent, asNewPackages);
						}
					}
					org.eclipse.ocl.pivot.Package asPackage = NameUtil.getNameable(asOldPackages, name);
					if (asPackage == null) {
						asPackage = context.refreshModelElement(org.eclipse.ocl.pivot.Package.class, PivotPackage.Literals.PACKAGE, null);
						asPackage.setName(name);
					}
					asNewPackages.add(asPackage);
					asParent = asPackage;
				}
			}
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
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		@NonNull BottomPattern pBottomPattern = context.refreshModelElement(BottomPattern.class, QVTcoreBasePackage.Literals.BOTTOM_PATTERN, csElement);
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getRealizedVariables());
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(EnforcementOperation.class, pBottomPattern.getEnforcementOperation(), csElement.getEnforcementOperations());
		context.refreshPivotList(Assignment.class, pBottomPattern.getAssignment(), Iterables.filter(csElement.getConstraints(), IsAssignmentPredicate.INSTANCE));
		context.refreshPivotList(Predicate.class, pBottomPattern.getPredicate(), Iterables.filter(csElement.getConstraints(), IsPredicatePredicate.INSTANCE));
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
		if ((eContainer instanceof AbstractMappingCS) && (((AbstractMappingCS)eContainer).getMiddle() == csElement)) {
			return null;
		}
		@NonNull CoreDomain pivotElement = context.refreshModelElement(CoreDomain.class, QVTcoreBasePackage.Literals.CORE_DOMAIN, csElement);
		pivotElement.setIsCheckable(csElement.isCheck());
		pivotElement.setIsEnforceable(csElement.isEnforce());
		pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csElement.getBottomPattern()));
		pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csElement.getGuardPattern()));
		context.refreshComments(pivotElement, csElement);
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(@NonNull EnforcementOperationCS csElement) {
		context.refreshModelElement(EnforcementOperation.class, QVTcoreBasePackage.Literals.ENFORCEMENT_OPERATION, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		@NonNull GuardPattern pGuardPattern = context.refreshModelElement(GuardPattern.class, QVTcoreBasePackage.Literals.GUARD_PATTERN, csElement);
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(Predicate.class, pGuardPattern.getPredicate(), csElement.getConstraints());
		context.refreshComments(pGuardPattern, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		pivotElement.setIsStatic(true);
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameters(), csElement.getInputParamDeclaration());
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(@NonNull RealizedVariableCS csElement) {
		refreshNamedElement(RealizedVariable.class, QVTcoreBasePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@SuppressWarnings("null") @NonNull EClass eClass = QVTbasePackage.Literals.TRANSFORMATION;
		Transformation pivotElement = refreshNamedElement(Transformation.class, eClass, csElement);
		refreshClassifier(pivotElement, csElement);
//		Transformation pivotElement = refreshPackage(Transformation.class, QVTbasePackage.Literals.TRANSFORMATION, csElement);
//		context.refreshPivotList(Mapping.class, pivotElement.getRule(), csElement.getMapping());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getDirections());
//		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}
