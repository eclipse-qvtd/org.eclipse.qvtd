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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
	public QVTimperativeCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
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
		context.refreshPivotList(MappingCall.class, pivotElement.getMappingCall(), csElement.getMappingCalls());
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
		pivotElement.setIsLoop(csElement.isIsLoop());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull ImperativeModel pivotElement = refreshRoot(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, csElement);
		List<TransformationCS> csTransformations = csElement.getTransformations();
		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
			txList.add(pTransformation);
		}
		ImperativeModel pPackage = PivotUtil.getPivot(ImperativeModel.class, csElement);
		if (pPackage != null) {
			PivotUtil.refreshList(pPackage.getNestedPackage(), txList);
		}
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, pivotElement);		// Ensure containment viable for imported library type references
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
				PivotUtil.refreshList(pTransformation.getOwnedOperation(), newElements);
			}
			else {
				pTransformation.getOwnedOperation().clear();
			}
		}
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS( @NonNull TransformationCS csElement) {
		// TODO Auto-generated method stub
		return super.visitTransformationCS(csElement);
	}
}