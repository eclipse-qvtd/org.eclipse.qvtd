/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS;
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
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;

public class QVTimperativeDeclarationVisitor extends EssentialOCLDeclarationVisitor implements QVTimperativeVisitor<ElementCS>
{
	public QVTimperativeDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

/*	protected void gatherPackages(@NonNull List<org.eclipse.ocl.examples.pivot.Package> allPackages, @NonNull List<org.eclipse.ocl.examples.pivot.Package> nestedPackages) {
		allPackages.addAll(nestedPackages);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : nestedPackages) {
			List<org.eclipse.ocl.examples.pivot.Package> nestedNestedPackages = nestedPackage.getNestedPackage();
			assert nestedNestedPackages != null;
			gatherPackages(allPackages, nestedNestedPackages);
		}
	} */

	protected void importPackage(@NonNull org.eclipse.ocl.examples.pivot.Package aPackage) {
		context.importNamespace(aPackage, null);
		org.eclipse.ocl.examples.pivot.Package nestingPackage = null;
		while ((nestingPackage = aPackage.getNestingPackage()) != null) {
			aPackage = nestingPackage;
			context.importNamespace(aPackage, null);
		}
	}

	protected void refreshArea(@NonNull Area asCoreDomain, @NonNull DomainCS csDomain) {
		csDomain.setBottomPattern(context.visitDeclaration(BottomPatternCS.class, asCoreDomain.getBottomPattern()));
		csDomain.setGuardPattern(context.visitDeclaration(GuardPatternCS.class, asCoreDomain.getGuardPattern()));
	}

	protected void refreshPathNamedElement(@NonNull PathNameDeclCS csDecl, @NonNull NamedElement namedElement, Namespace scope) {
		PathNameCS csPathName = csDecl.getPathName();
		if (csPathName == null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csDecl.setPathName(csPathName);
		}
		context.refreshPathName(csPathName, namedElement, scope);
	}

	public ElementCS visitAssignment(@NonNull Assignment object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		Area asArea = asBottomPattern.getArea();
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		if (asArea instanceof Mapping) {
			context.refreshList(csBottomPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asBottomPattern.getAssignment(), null));
		}
		else {
			context.refreshList(csBottomPattern.getRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
			context.refreshList(csBottomPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		return csBottomPattern;
	}

	public ElementCS visitCoreDomain(@NonNull CoreDomain asCoreDomain) {
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asCoreDomain);
		refreshArea(asCoreDomain, csDomain);
		if (asCoreDomain.isIsCheckable()) {
			csDomain.setCheck(true);
		}
		csDomain.setDirection(asCoreDomain.getTypedModel());
		if (asCoreDomain.isIsEnforceable()) {
			csDomain.setEnforce(true);
		}
		return csDomain;
	}

	public ElementCS visitCorePattern(@NonNull CorePattern object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitDomain(@NonNull Domain object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitFunction(@NonNull Function asFunction) {
		QueryCS csQuery = context.refreshNamedElement(QueryCS.class, QVTcoreBaseCSPackage.Literals.QUERY_CS, asFunction);
		return csQuery;
	}

	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		Area asArea = asGuardPattern.getArea();
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreBaseCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		if (asArea instanceof Mapping) {
//			context.refreshList(csGuardPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asGuardPattern.getPredicate(), null));
		}
		else {
			context.refreshList(csGuardPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		}
		return csGuardPattern;
	}

	public ElementCS visitImperativeModel(@NonNull ImperativeModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTimperativeCSPackage.Literals.TOP_LEVEL_CS, asModel);
		List<Mapping> asMappings = null;
		List<Function> asQueries = null;
		List<Transformation> asTransformations = null;
		for (org.eclipse.ocl.examples.pivot.Package asPackage : asModel.getNestedPackage()) {
			if (asPackage instanceof Transformation) {
				if (asTransformations == null) {
					asTransformations = new ArrayList<Transformation>();
				}
				Transformation asTransformation = (Transformation) asPackage;
				asTransformations.add(asTransformation);
				for (Rule asRule : asTransformation.getRule()) {
					if (asRule instanceof Mapping) {
						if (asMappings == null) {
							asMappings = new ArrayList<Mapping>();
						}
						asMappings.add((Mapping) asRule);
					}
				}
				for (Operation asOperation : asTransformation.getOwnedOperation()) {
					if (asOperation instanceof Function) {
						if (asQueries == null) {
							asQueries = new ArrayList<Function>();
						}
						asQueries.add((Function) asOperation);
					}
				}
			}
			// else other packages, orphanage
		}
		List<Package> nestedPackages = asModel.getNestedPackage();
		assert nestedPackages != null;
//		gatherPackages(allPackages, nestedPackages); 
//		context.refreshList(csDocument.getQueries(), context.visitDeclarations(QueryCS.class, allPackages, null));
		if (asTransformations != null) {
			context.refreshList(csDocument.getTransformations(), context.visitDeclarations(TransformationCS.class, asTransformations, null));
		}
		else {
			csDocument.getTransformations().clear();
		}
		if (asMappings != null) {
			context.refreshList(csDocument.getMappings(), context.visitDeclarations(MappingCS.class, asMappings, null));
		}
		else {
			csDocument.getMappings().clear();
		}
		if (asQueries != null) {
			context.refreshList(csDocument.getQueries(), context.visitDeclarations(QueryCS.class, asQueries, null));
		}
		else {
			csDocument.getQueries().clear();
		}
		return csDocument;
	}

	public ElementCS visitMapping(@NonNull Mapping asMapping) {
		MappingCS csMapping = context.refreshNamedElement(MappingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CS, asMapping);
		csMapping.setIn(asMapping.getTransformation());
		context.refreshList(csMapping.getDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		context.refreshList(csMapping.getMappingCalls(), context.visitDeclarations(MappingCallCS.class, asMapping.getMappingCall(), null));
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asMapping);
		refreshArea(asMapping, csDomain);
		csMapping.setMiddle(csDomain);
		return csMapping;
	}

	public ElementCS visitMappingCall(@NonNull MappingCall asMappingCall) {
		MappingCallCS csMappingCall = context.refreshElement(MappingCallCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_CS, asMappingCall);
		context.refreshList(csMappingCall.getBindings(), context.visitDeclarations(MappingCallBindingCS.class, asMappingCall.getBinding(), null));
		csMappingCall.setReferredMapping(asMappingCall.getReferredMapping());
		return csMappingCall;
	}

	public ElementCS visitMappingCallBinding(@NonNull MappingCallBinding asMappingCallBinding) {
		MappingCallBindingCS csMappingCallBinding = context.refreshElement(MappingCallBindingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_BINDING_CS, asMappingCallBinding);
		csMappingCallBinding.setIsLoop(asMappingCallBinding.isIsLoop());
		csMappingCallBinding.setReferredVariable(asMappingCallBinding.getBoundVariable());
		csMappingCallBinding.setValue(createExpCS(asMappingCallBinding.getValue()));
		return csMappingCallBinding;
	}

	public ElementCS visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment asMiddlePropertyAssignment) {
		return visitPropertyAssignment(asMiddlePropertyAssignment);
	}

	public ElementCS visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp asMiddlePropertyCallExp) {
		return visitOppositePropertyCallExp(asMiddlePropertyCallExp);
	}

	public ElementCS visitPattern(@NonNull Pattern object) {
		throw new UnsupportedOperationException();
	}

	@Nullable
	public ElementCS visitPropertyAssignment(@NonNull PropertyAssignment asPropertyAssignment) {
		AssignmentCS csAssignment = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asPropertyAssignment);
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
		return csAssignment;
	}

	public ElementCS visitRealizedVariable(@NonNull RealizedVariable asRealizedVariable) {
		RealizedVariableCS csRealizedVariable = context.refreshNamedElement(RealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.REALIZED_VARIABLE_CS, asRealizedVariable);
		csRealizedVariable.setOwnedType(createTypeRefCS(asRealizedVariable.getType()));
		return csRealizedVariable;
	}

	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	public ElementCS visitTransformation(@NonNull Transformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTcoreBaseCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		context.refreshList(csTransformation.getDirections(), context.visitDeclarations(DirectionCS.class, asTransformation.getModelParameter(), null));
		return csTransformation;
	}

	public ElementCS visitTypedModel(@NonNull TypedModel asTypedModel) {
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTcoreBaseCSPackage.Literals.DIRECTION_CS, asTypedModel);
		PivotUtil.refreshList(csDirection.getImports(), asTypedModel.getUsedPackage());
//		PivotUtil.refreshList(csDirection.getUses(), asTypedModel.getDependsOn());
		return csDirection;
	}

	@Override
	public ElementCS visitVariable(@NonNull Variable asVariable) {
		if (asVariable.eContainer() instanceof CorePattern) {
			UnrealizedVariableCS csUnrealizedVariable = context.refreshNamedElement(UnrealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
			csUnrealizedVariable.setOwnedType(createTypeRefCS(asVariable.getType()));
			return csUnrealizedVariable;
		}
		else {
			return super.visitVariable(asVariable);
		}
	}

	@Nullable
	public ElementCS visitVariableAssignment(@NonNull VariableAssignment asVariableAssignment) {
		AssignmentCS csAssignment = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asVariableAssignment);
		Variable asVariable = asVariableAssignment.getTargetVariable();
		if (asVariable != null) {
			csAssignment.setTarget(createNameExpCS(asVariable));
		}
		csAssignment.setInitialiser(context.visitDeclaration(ExpCS.class, asVariableAssignment.getValue()));
		return csAssignment;
	}

	public ElementCS visitEnforcementOperation(@NonNull EnforcementOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElementCS visitFunctionParameter(@NonNull FunctionParameter object) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElementCS visitPredicate(@NonNull Predicate object) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElementCS visitUnit(@NonNull Unit object) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElementCS visitVariablePredicate(@NonNull VariablePredicate object) {
		// TODO Auto-generated method stub
		return null;
	}

}
