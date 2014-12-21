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
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
	public QVTimperativeCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}	

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
		ExpCS csTarget = csElement.getTarget();
		EObject eContainer = csElement.eContainer();
		if ((csElement.getInitialiser() == null) || (eContainer instanceof GuardPatternCS)) {
			if (csTarget instanceof NameExpCS) {
				context.refreshModelElement(VariablePredicate.class, QVTimperativePackage.Literals.VARIABLE_PREDICATE, csElement);
			}
			else {
				context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csElement);
			}
		}
		else if (csTarget instanceof NameExpCS) {
			context.refreshModelElement(VariableAssignment.class, QVTcoreBasePackage.Literals.VARIABLE_ASSIGNMENT, csElement);
		}
		else {
			EObject eContainerContainer = eContainer != null ? eContainer.eContainer() : null;
			if ((eContainerContainer instanceof DomainCS) && (((DomainCS)eContainerContainer).getName() == null)) {
				context.refreshModelElement(PropertyAssignment.class, QVTimperativePackage.Literals.MIDDLE_PROPERTY_ASSIGNMENT, csElement);
			}
			else {
				context.refreshModelElement(PropertyAssignment.class, QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csElement);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTimperativePackage.Literals.MAPPING, csElement);
		DomainCS csMiddle = csElement.getMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getGuardPattern()));
		}
		else {
			BottomPattern bottomPattern = pivotElement.getBottomPattern();
			if (bottomPattern == null) {
				bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
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
		context.refreshPivotList(CoreDomain.class, pivotElement.getDomain(), csElement.getDomains());
		pivotElement.setMappingStatement(PivotUtil.getPivot(MappingStatement.class, csElement.getMappingSequence()));
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		@NonNull MappingCall pivotElement = context.refreshModelElement(MappingCall.class, QVTimperativePackage.Literals.MAPPING_CALL, csElement);
		context.refreshPivotList(MappingCallBinding.class, pivotElement.getBinding(), csElement.getBindings());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		@NonNull MappingCallBinding pivotElement = context.refreshModelElement(MappingCallBinding.class, QVTimperativePackage.Literals.MAPPING_CALL_BINDING, csElement);
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csMappingLoop) {
		@NonNull MappingLoop pivotElement = context.refreshModelElement(MappingLoop.class, QVTimperativePackage.Literals.MAPPING_LOOP, csMappingLoop);
		@NonNull Variable iterator = refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, ClassUtil.nonNullState(csMappingLoop.getOwnedIterator()));
		pivotElement.getOwnedIterators().clear();
		pivotElement.getOwnedIterators().add(iterator);
		pivotElement.setOwnedBody(PivotUtil.getPivot(MappingStatement.class, csMappingLoop.getMappingSequence()));
//		CollectionType collectionType = metaModelManager.getCollectionType();
//		DomainOperation forAllIteration = ClassUtil.getNamedElement(collectionType.getLocalOperations(), "forAll");
//		pivotElement.setReferredIteration((Iteration) forAllIteration);
		context.refreshComments(pivotElement, csMappingLoop);
		return null;
	}

	@Override
	public Continuation<?> visitMappingSequenceCS(@NonNull MappingSequenceCS csMappingSequence) {
		@NonNull MappingSequence pivotElement = context.refreshModelElement(MappingSequence.class, QVTimperativePackage.Literals.MAPPING_SEQUENCE, csMappingSequence);
		context.refreshPivotList(MappingStatement.class, pivotElement.getMappingStatements(), csMappingSequence.getMappingStatements());
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull ImperativeModel asModel = refreshRoot(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, csElement);
		context.refreshPivotList(Unit.class, asModel.getUnit(), csElement.getOwnedImports());
		List<TransformationCS> csTransformations = csElement.getTransformations();
//		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
//			txList.add(pTransformation);
		}
//		ImperativeModel asModel = PivotUtil.getPivot(ImperativeModel.class, csElement);
//		if (asModel != null) {
//			PivotUtil.refreshList(asModel.getOwnedTransformations(), txList);
//		}
//		List<TransformationCS> csTransformations = csElement.getTransformations();
		List<org.eclipse.ocl.pivot.Package> asPackages = resolveTransformations(csTransformations, asModel);
		PivotUtil.refreshList(asModel.getOwnedPackages(), asPackages);
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asModel);		// Ensure containment viable for imported library type references
//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		//
		for (MappingCS csMapping : csElement.getMappings()) {
			Transformation inTransformation = csMapping.getIn();
			List<Mapping> mappings = tx2mappings.get(inTransformation);
			if (mappings != null) {
				Mapping pMapping = PivotUtil.getPivot(Mapping.class, csMapping);
				if (pMapping != null) {
					mappings.add(pMapping);
				}
			}
		}
		Map<Transformation, List<Function>> tx2qMap = new HashMap<Transformation, List<Function>>();
		for (QueryCS csQuery : csElement.getQueries()) {
			Transformation transformation = csQuery.getTransformation();
			Function query = PivotUtil.getPivot(Function.class,  csQuery);
			List<Function> queries = tx2qMap.get(transformation);
			if (queries == null) {
				queries = new ArrayList<Function>();
				tx2qMap.put(transformation, queries);
			}
			queries.add(query);
		}
		for (Transformation pTransformation : tx2mappings.keySet()) {
			PivotUtil.refreshList(pTransformation.getRule(), tx2mappings.get(pTransformation));
			List<Function> newElements = tx2qMap.get(pTransformation);
			if (newElements != null) {
				PivotUtil.refreshList(pTransformation.getOwnedOperations(), newElements);
			}
			else {
				pTransformation.getOwnedOperations().clear();
			}
		}
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS( @NonNull TransformationCS csElement) {
		// TODO Auto-generated method stub
		return super.visitTransformationCS(csElement);
	}
}
