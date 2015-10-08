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
import org.eclipse.ocl.pivot.Operation;
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
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
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

	@Override
	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		Area asArea = asBottomPattern.getArea();
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		if (asArea instanceof Mapping) {
			List<Element> asConstraints = new ArrayList<Element>(asBottomPattern.getAssignment());
			asConstraints.addAll(asBottomPattern.getPredicate());
			context.refreshList(csBottomPattern.getOwnedConstraints(), context.visitDeclarations(PredicateOrAssignmentCS.class, asConstraints, null));
			context.refreshList(csBottomPattern.getOwnedUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		else {
			context.refreshList(csBottomPattern.getOwnedRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
		}
		return csBottomPattern;
	}

	@Override
	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		Area asArea = asGuardPattern.getArea();
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreBaseCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		csGuardPattern.setPivot(asGuardPattern);
		if (asArea instanceof Mapping) {
			context.refreshList(csGuardPattern.getOwnedPredicates(), context.visitDeclarations(PredicateCS.class, asGuardPattern.getPredicate(), null));
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
		context.refreshList(csMapping.getOwnedDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asMapping);
		csDomain.setPivot(null);		// stop comment duplication
		csDomain.setOwnedBottomPattern(context.visitDeclaration(BottomPatternCS.class, asMapping.getBottomPattern()));
		csDomain.setOwnedGuardPattern(context.visitDeclaration(GuardPatternCS.class, asMapping.getGuardPattern()));
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
		else {
			return super.visitVariable(asVariable);
		}
	}

	@Override
	public ElementCS visitVariablePredicate(@NonNull VariablePredicate asVariablePredicate) {
		PredicateCS csPredicate = context.refreshElement(PredicateCS.class, QVTcoreBaseCSPackage.Literals.PREDICATE_CS, asVariablePredicate);
		csPredicate.setPivot(asVariablePredicate);
		NameExpCS csVariableExp = createNameExpCS(asVariablePredicate.getTargetVariable());
		ExpCS csValueExp = createExpCS(asVariablePredicate.getConditionExpression());
		InfixExpCS csConditionExp = createInfixExpCS(csVariableExp, "=", csValueExp);
		csPredicate.setOwnedCondition(csConditionExp);
		return csPredicate;
	}
}
