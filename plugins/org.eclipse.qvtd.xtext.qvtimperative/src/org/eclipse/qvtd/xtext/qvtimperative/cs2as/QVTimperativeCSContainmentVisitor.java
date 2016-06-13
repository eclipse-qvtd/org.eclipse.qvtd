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
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ConnectionStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeRealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.impl.ImperativeDomainCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
	public QVTimperativeCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}	

	@Override
	protected @NonNull ImperativeBottomPattern createBottomPattern(@NonNull BottomPatternCS csElement) {
		return context.refreshModelElement(ImperativeBottomPattern.class, QVTimperativePackage.Literals.IMPERATIVE_BOTTOM_PATTERN, csElement);
	}

	@Override
	protected @NonNull ImperativeDomain createDomain(@NonNull DomainCS csElement) {
		return context.refreshModelElement(ImperativeDomain.class, QVTimperativePackage.Literals.IMPERATIVE_DOMAIN, csElement);
	}

	@Override
	public @Nullable Continuation<?> visitConnectionStatementCS(@NonNull ConnectionStatementCS csElement) {
		context.refreshModelElement(ConnectionStatement.class, QVTimperativePackage.Literals.CONNECTION_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		Continuation<?> continuation = super.visitDirectionCS(csElement);
		TypedModel asTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
		if (asTypedModel != null) {
			QVTbaseUtil.getContextVariable(standardLibrary, asTypedModel);
		}
		return continuation;
	}

	@Override
	public @Nullable Continuation<?> visitImperativePredicateOrAssignmentCS(@NonNull ImperativePredicateOrAssignmentCS csElement) {
		ExpCS csTarget = csElement.getOwnedTarget();
		EObject eContainer = csElement.eContainer();
		if ((csElement.getOwnedInitExpression() == null) || (eContainer instanceof GuardPatternCS)) {
			context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		}
		else if (csTarget instanceof NameExpCS) {
			if (csElement.isIsAccumulate()) {
				context.refreshModelElement(ConnectionAssignment.class, QVTimperativePackage.Literals.CONNECTION_ASSIGNMENT, csElement);
			}
			else {
				context.refreshModelElement(VariableAssignment.class, QVTcoreBasePackage.Literals.VARIABLE_ASSIGNMENT, csElement);
			}
		}
		else {
			context.refreshModelElement(PropertyAssignment.class, QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitImperativeRealizedVariableCS(@NonNull ImperativeRealizedVariableCS csElement) {
		refreshNamedElement(RealizedVariable.class, QVTcoreBasePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTimperativePackage.Literals.MAPPING, csElement);
		DomainCS csMiddle = csElement.getOwnedMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getOwnedBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getOwnedGuardPattern()));
		}
		else {
			BottomPattern bottomPattern = pivotElement.getBottomPattern();
			if (bottomPattern == null) {
				bottomPattern = QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern();
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
				guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
				guardPattern.getBindsTo().clear();
				guardPattern.getPredicate().clear();
				guardPattern.getVariable().clear();
				pivotElement.setGuardPattern(guardPattern);
			}
		}
		context.refreshPivotList(CoreDomain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		pivotElement.setMappingStatement(PivotUtil.getPivot(MappingStatement.class, csElement.getOwnedMappingSequence()));
		pivotElement.setIsDefault(csElement.isIsDefault());
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		@NonNull MappingCall pivotElement = context.refreshModelElement(MappingCall.class, QVTimperativePackage.Literals.MAPPING_CALL, csElement);
		context.refreshPivotList(MappingCallBinding.class, pivotElement.getBinding(), csElement.getOwnedBindings());
		pivotElement.setIsInfinite(csElement.isIsInfinite());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		@NonNull MappingCallBinding pivotElement = context.refreshModelElement(MappingCallBinding.class, QVTimperativePackage.Literals.MAPPING_CALL_BINDING, csElement);
		pivotElement.setIsPolled(csElement.isIsPolled());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csMappingLoop) {
		@NonNull MappingLoop pivotElement = context.refreshModelElement(MappingLoop.class, QVTimperativePackage.Literals.MAPPING_LOOP, csMappingLoop);
		@NonNull Variable iterator = refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, ClassUtil.nonNullState(csMappingLoop.getOwnedIterator()));
		pivotElement.getOwnedIterators().clear();
		pivotElement.getOwnedIterators().add(iterator);
		pivotElement.setOwnedBody(PivotUtil.getPivot(MappingStatement.class, csMappingLoop.getOwnedMappingSequence()));
//		CollectionType collectionType = metamodelManager.getCollectionType();
//		DomainOperation forAllIteration = ClassUtil.getNamedElement(collectionType.getLocalOperations(), "forAll");
//		pivotElement.setReferredIteration((Iteration) forAllIteration);
		context.refreshComments(pivotElement, csMappingLoop);
		return null;
	}

	@Override
	public Continuation<?> visitMappingSequenceCS(@NonNull MappingSequenceCS csMappingSequence) {
		@NonNull MappingSequence pivotElement = context.refreshModelElement(MappingSequence.class, QVTimperativePackage.Literals.MAPPING_SEQUENCE, csMappingSequence);
		context.refreshPivotList(MappingStatement.class, pivotElement.getMappingStatements(), csMappingSequence.getOwnedMappingStatements());
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
		EObject eContainer = csElement.eContainer();
		if ((csElement.getOwnedInitExpression() == null) || (eContainer instanceof GuardPatternCS)) {
			context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
		}
		else if (csTarget instanceof NameExpCS) {
			context.refreshModelElement(VariableAssignment.class, QVTcoreBasePackage.Literals.VARIABLE_ASSIGNMENT, csElement);
		}
		else {
			context.refreshModelElement(PropertyAssignment.class, QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull ImperativeModel asModel = refreshRoot(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, csElement);
		installPackageStructure(asModel, ClassUtil.nullFree(csElement.getOwnedPackages()), ClassUtil.nullFree(csElement.getOwnedTransformations()));
		context.refreshPivotList(Import.class, asModel.getOwnedImports(), csElement.getOwnedImports());
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asModel);		// Ensure containment viable for imported library type references
//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		//
		resolveTransformationMappings(ClassUtil.nullFree(csElement.getOwnedMappings()));
		resolveTransformationQueries(ClassUtil.nullFree(csElement.getOwnedQueries()));
//		context.addMappings(ClassUtil.nullFree(csElement.getOwnedMappings()));
//		context.addQueries(ClassUtil.nullFree(csElement.getOwnedQueries()));
//		context.installTransformationStructure();
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		EObject eContainer = csElement.eContainer();
		if ((eContainer instanceof PatternCS) && !(csElement.getOwnedType() instanceof PrimitiveTypeRefCS)) {		// FIXME need clearer syntax
			EObject eContainerContainer = eContainer.eContainer();
			if (eContainerContainer instanceof ImperativeDomainCSImpl) {
				TypedModel typedModel = ((ImperativeDomainCSImpl)eContainerContainer).basicGetDirection();
				if (typedModel == null) {
					refreshNamedElement(ConnectionVariable.class, QVTimperativePackage.Literals.CONNECTION_VARIABLE, csElement);
					return null;
				}
			}
		}
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}
