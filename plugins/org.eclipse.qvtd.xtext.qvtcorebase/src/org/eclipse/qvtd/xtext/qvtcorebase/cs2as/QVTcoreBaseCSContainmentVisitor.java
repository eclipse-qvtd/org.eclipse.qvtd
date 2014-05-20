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
 */
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.SingleContinuation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.AbstractQVTcoreBaseCSContainmentVisitor;

public class QVTcoreBaseCSContainmentVisitor extends AbstractQVTcoreBaseCSContainmentVisitor
{
	protected static class DirectionContentContinuation extends SingleContinuation<DirectionCS>
	{
		private DirectionContentContinuation(@NonNull CS2PivotConversion context, @NonNull DirectionCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			if (pTypedModel != null) {
				PivotUtil.refreshList(pTypedModel.getUsedPackage(), csElement.getImports());
			}
			return null;
		}
	}

	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(@NonNull CS2PivotConversion context, @NonNull DomainCS csElement) {
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

	public QVTcoreBaseCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		@NonNull BottomPattern pBottomPattern = context.refreshModelElement(BottomPattern.class, QVTcoreBasePackage.Literals.BOTTOM_PATTERN, csElement);
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getRealizedVariables());
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(EnforcementOperation.class, pBottomPattern.getEnforcementOperation(), csElement.getEnforcementOperations());
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
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		pivotElement.setIsStatic(true);
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameter(), csElement.getInputParamDeclaration());
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
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		Transformation pivotElement = refreshPackage(Transformation.class, QVTbasePackage.Literals.TRANSFORMATION, csElement);
//		context.refreshPivotList(Mapping.class, pivotElement.getRule(), csElement.getMapping());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getDirections());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}