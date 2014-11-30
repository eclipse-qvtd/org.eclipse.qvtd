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
package org.eclipse.qvtd.xtext.qvtimperative.as2cs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.xtext.qvtcorebase.as2cs.QVTcoreBaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
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
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;

public class QVTimperativeDeclarationVisitor extends QVTcoreBaseDeclarationVisitor implements QVTimperativeVisitor<ElementCS>
{
	public QVTimperativeDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		Area asArea = asBottomPattern.getArea();
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		if (asArea instanceof Mapping) {
			List<Element> asConstraints = new ArrayList<Element>(asBottomPattern.getAssignment());
			asConstraints.addAll(asBottomPattern.getPredicate());
			context.refreshList(csBottomPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asConstraints, null));
		}
		else {
			context.refreshList(csBottomPattern.getRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
			context.refreshList(csBottomPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		}
		return csBottomPattern;
	}

	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		Area asArea = asGuardPattern.getArea();
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreBaseCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		csGuardPattern.setPivot(asGuardPattern);
		if (asArea instanceof Mapping) {
			context.refreshList(csGuardPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asGuardPattern.getPredicate(), null));
		}
		else {
			context.refreshList(csGuardPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		}
		return csGuardPattern;
	}

	public ElementCS visitImperativeModel(@NonNull ImperativeModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTimperativeCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getUnit(), null));
		List<Mapping> asMappings = null;
		List<Function> asQueries = null;
		List<Transformation> asTransformations = null;
		for (org.eclipse.ocl.examples.pivot.Package asPackage : asModel.getOwnedPackages()) {
			if ("".equals(asPackage.getName())) {
				for (org.eclipse.ocl.examples.pivot.Class asClass : asPackage.getOwnedClasses()) {
					if (asClass instanceof Transformation) {
						if (asTransformations == null) {
							asTransformations = new ArrayList<Transformation>();
						}
						Transformation asTransformation = (Transformation) asClass;
						asTransformations.add(asTransformation);
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
				}
			}
			// else other packages, orphanage
		}
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
		csMapping.setPivot(asMapping);
		csMapping.setIn(asMapping.getTransformation());
		context.refreshList(csMapping.getDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asMapping);
		csDomain.setPivot(null);		// stop comment duplication
		csDomain.setBottomPattern(context.visitDeclaration(BottomPatternCS.class, asMapping.getBottomPattern()));
		csDomain.setGuardPattern(context.visitDeclaration(GuardPatternCS.class, asMapping.getGuardPattern()));
		csMapping.setMiddle(csDomain);
		csMapping.setMappingSequence(context.visitDeclaration(MappingSequenceCS.class, asMapping.getMappingStatements()));
		return csMapping;
	}

	public ElementCS visitMappingCall(@NonNull MappingCall asMappingCall) {
		MappingCallCS csMappingCall = context.refreshElement(MappingCallCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_CS, asMappingCall);
		csMappingCall.setPivot(asMappingCall);
		context.refreshList(csMappingCall.getBindings(), context.visitDeclarations(MappingCallBindingCS.class, asMappingCall.getBinding(), null));
		csMappingCall.setReferredMapping(asMappingCall.getReferredMapping());
		return csMappingCall;
	}

	public ElementCS visitMappingCallBinding(@NonNull MappingCallBinding asMappingCallBinding) {
		MappingCallBindingCS csMappingCallBinding = context.refreshElement(MappingCallBindingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_BINDING_CS, asMappingCallBinding);
		csMappingCallBinding.setPivot(asMappingCallBinding);
		csMappingCallBinding.setReferredVariable(asMappingCallBinding.getBoundVariable());
		csMappingCallBinding.setValue(createExpCS(asMappingCallBinding.getValue()));
		return csMappingCallBinding;
	}

	public ElementCS visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		MappingLoopCS csMappingLoop = context.refreshElement(MappingLoopCS.class, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS, asMappingLoop);
		csMappingLoop.setPivot(asMappingLoop);
		csMappingLoop.setOwnedIterator(context.visitDeclaration(VariableCS.class, asMappingLoop.getIterator().get(0)));
		csMappingLoop.setInExpression(createExpCS(asMappingLoop.getSource()));
		csMappingLoop.setMappingSequence(context.visitDeclaration(MappingSequenceCS.class, asMappingLoop.getBody()));
		return csMappingLoop;
	}

	public ElementCS visitMappingSequence(@NonNull MappingSequence pMappingSequence) {
		MappingSequenceCS csMappingSequence = context.refreshElement(MappingSequenceCS.class, QVTimperativeCSPackage.Literals.MAPPING_SEQUENCE_CS, pMappingSequence);
		context.refreshList(csMappingSequence.getMappingStatements(), context.visitDeclarations(MappingStatementCS.class, pMappingSequence.getMappingStatements(), null));
		return csMappingSequence;
	}

	public ElementCS visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	public ElementCS visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment asMiddlePropertyAssignment) {
		return visitPropertyAssignment(asMiddlePropertyAssignment);
	}

	public ElementCS visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp asMiddlePropertyCallExp) {
		return visitOppositePropertyCallExp(asMiddlePropertyCallExp);
	}

	@Override
	public ElementCS visitVariable(@NonNull Variable asVariable) {
		if (asVariable.eContainer() instanceof MappingLoop) {
			VariableCS csVariable = context.refreshNamedElement(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, asVariable);
			Type type = asVariable.getType();
			if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != context.getMetaModelManager().getStandardLibrary().getCollectionType())) {
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

	public ElementCS visitVariablePredicate(@NonNull VariablePredicate asVariablePredicate) {
		AssignmentCS csPredicate = context.refreshElement(AssignmentCS.class, QVTcoreBaseCSPackage.Literals.ASSIGNMENT_CS, asVariablePredicate);
		csPredicate.setPivot(asVariablePredicate);
		csPredicate.setTarget(createNameExpCS(asVariablePredicate.getTargetVariable()));
		csPredicate.setInitialiser(createExpCS(asVariablePredicate.getConditionExpression()));
		return csPredicate;
	}
}
