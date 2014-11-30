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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;
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
	public QVTcoreBaseDeclarationVisitor(@NonNull Pivot2CSConversion context) {
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

	protected void importPackage(@NonNull org.eclipse.ocl.examples.pivot.Package aPackage) {
		context.importNamespace(aPackage, null);
		org.eclipse.ocl.examples.pivot.Package nestingPackage = null;
		while ((nestingPackage = aPackage.getNestingPackage()) != null) {
			aPackage = nestingPackage;
			context.importNamespace(aPackage, null);
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
		csQuery.setPathName(createPathNameCS(asFunction.getOwningType()));
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
		csTargetExp.getOwnedExpression().add(createNameExpCS(asSlotExpression));
		csTargetExp.getOwnedExpression().add(createNameExpCS(asPropertyAssignment.getTargetProperty()));
		NavigationOperatorCS csOperator = context.refreshElement(NavigationOperatorCS.class, EssentialOCLCSPackage.Literals.NAVIGATION_OPERATOR_CS, asPropertyAssignment);
		csOperator.setName(".");
		csTargetExp.getOwnedOperator().add(csOperator);
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

	public ElementCS visitUnit(@NonNull Unit object) {
		throw new UnsupportedOperationException();
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
