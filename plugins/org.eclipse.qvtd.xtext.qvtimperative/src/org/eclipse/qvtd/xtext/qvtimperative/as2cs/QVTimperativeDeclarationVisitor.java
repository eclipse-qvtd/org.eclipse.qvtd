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
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.as2cs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
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
import org.eclipse.qvtd.xtext.qvtcorebase.as2cs.QVTcoreBaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;

public class QVTimperativeDeclarationVisitor extends QVTcoreBaseDeclarationVisitor implements QVTimperativeVisitor<ElementCS>
{
	public QVTimperativeDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	@Override
	protected @NonNull ImperativeDomainCS createCoreDomain(@NonNull CoreDomain asCoreDomain) {
		return context.refreshElement(ImperativeDomainCS.class, QVTimperativeCSPackage.Literals.IMPERATIVE_DOMAIN_CS, asCoreDomain);
	}

	protected void refreshReferredMapping(@NonNull MappingCallCS csMappingCall, @NonNull MappingCall asMappingCall) {
		Mapping asMapping = asMappingCall.getReferredMapping();
		if (asMapping != null) {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMappingCall.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, asMapping, QVTbaseUtil.getContainingTransformation(asMappingCall));
		}
		else {
			csMappingCall.setOwnedPathName(null);
		}
	}

	protected void refreshUsedProperties(@NonNull Transformation asTransformation, /*@NonNull*/ List<PathNameCS> csPathNames, /*@NonNull*/ List<Property> asProperties) {
		List<PathNameCS> pathNames = new ArrayList<PathNameCS>();
		for (@SuppressWarnings("null") @NonNull Property asProperty : asProperties) {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			pathNames.add(csPathName);
			context.refreshPathName(csPathName, asProperty, asTransformation);
		}
		context.refreshList(csPathNames, pathNames);
	}

	protected void refreshUsedTypes(@NonNull MappingCS csMapping, @NonNull Mapping asMapping) {
		List<PathNameCS> csPathNames = new ArrayList<PathNameCS>();
		for (@SuppressWarnings("null") org.eclipse.ocl.pivot.@NonNull Class asClass : asMapping.getPolledClasses()) {
			@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csPathNames.add(csPathName);
			Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asMapping);
			context.refreshPathName(csPathName, asClass, asTransformation);
		}
		context.refreshList(csMapping.getOwnedUsesPathNames(), csPathNames);
	}

	@Override
	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		Area asArea = asBottomPattern.getArea();
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		if (asArea instanceof Mapping) {
			List<Element> asConstraints = new ArrayList<Element>(asBottomPattern.getAssignment());
			asConstraints.addAll(asBottomPattern.getPredicate());
			context.refreshList(csBottomPattern.getOwnedConstraints(), context.visitDeclarations(ImperativePredicateOrAssignmentCS.class, asConstraints, null));
			context.refreshList(csBottomPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		else {
			context.refreshList(csBottomPattern.getOwnedRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
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
	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		Area asArea = asGuardPattern.getArea();
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreBaseCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
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
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), asImperativeDomain.getCheckedProperties());
		refreshUsedProperties(asTransformation, csDomain.getEnforcedProperties(), asImperativeDomain.getEnforcedProperties());
		return csDomain;
	}

	@Override
	public ElementCS visitImperativeModel(@NonNull ImperativeModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTimperativeCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getOwnedImports(), null));
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
		context.refreshList(csDocument.getOwnedTransformations(), context.visitDeclarations(TransformationCS.class, asTransformations, null));
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
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), asMapping.getCheckedProperties());
		refreshUsedProperties(asTransformation, csDomain.getCheckedProperties(), asMapping.getCheckedProperties());
		csMapping.setOwnedMiddle(csDomain);
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
			UnrealizedVariableCS csUnrealizedVariable = context.refreshNamedElement(UnrealizedVariableCS.class, QVTcoreBaseCSPackage.Literals.UNREALIZED_VARIABLE_CS, asVariable);
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
			return super.visitVariable(asVariable);
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
