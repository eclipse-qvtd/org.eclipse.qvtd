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
package org.eclipse.qvtd.xtext.qvtcore.cs2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.util.AbstractQVTcoreCSContainmentVisitor;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;

public class QVTcoreCSContainmentVisitor extends AbstractQVTcoreCSContainmentVisitor
{
	public QVTcoreCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	protected void resolveTransformationMappings(@NonNull TopLevelCS csTopLevel) {
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (MappingCS csMapping : csTopLevel.getMappings()) {
			Transformation asTransformation = csMapping.getIn();
			if (asTransformation != null) {
				Mapping asMapping = PivotUtil.getPivot(Mapping.class, csMapping);
				if (asMapping != null) {
					List<Mapping> asMappings = tx2mappings.get(asTransformation);
					if (asMappings == null) {
						asMappings = new ArrayList<Mapping>();
						tx2mappings.put(asTransformation, asMappings);
					}
					asMappings.add(asMapping);
				}
			}
		}
		for (Transformation asTransformation : tx2mappings.keySet()) {
			List<Mapping> asMappings = tx2mappings.get(asTransformation);
			List<Rule> asRules = asTransformation.getRule();
			if (asMappings != null) {
				PivotUtil.refreshList(asRules, asMappings);
			}
			else {
				asRules.clear();
			}
		}
	}

	protected void resolveTransformationQueries(@NonNull TopLevelCS csTopLevel) {
		Map<Transformation, List<Function>> tx2qMap = new HashMap<Transformation, List<Function>>();
		for (QueryCS csQuery : csTopLevel.getQueries()) {
			Transformation asTransformation = csQuery.getTransformation();
			if (asTransformation != null) {
				Function asQuery = PivotUtil.getPivot(Function.class,  csQuery);
				if (asQuery != null) {
					List<Function> asQueries = tx2qMap.get(asTransformation);
					if (asQueries == null) {
						asQueries = new ArrayList<Function>();
						tx2qMap.put(asTransformation, asQueries);
					}
					asQueries.add(asQuery);
				}
			}
		}
		for (Transformation asTransformation : tx2qMap.keySet()) {
			List<Function> asQueries = tx2qMap.get(asTransformation);
			List<Operation> asOperations = asTransformation.getOwnedOperation();
			if (asQueries != null) {
				PivotUtil.refreshList(asOperations, asQueries);
			}
			else {
				asOperations.clear();
			}
		}
	}

	protected @NonNull List<Transformation> resolveTransformations(@NonNull TopLevelCS csTopLevel) {
		List<TransformationCS> csTransformations = csTopLevel.getTransformations();
		List<Transformation> asTransformations = new ArrayList<Transformation>(csTransformations.size());
		for (TransformationCS csTransformation : csTransformations) {
			Transformation asTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			asTransformations.add(asTransformation);
		}
		return asTransformations;
	}

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
		ExpCS csTarget = csElement.getTarget();
		if ((csElement.getInitialiser() == null) || (csElement.eContainer() instanceof GuardPatternCS)) {
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
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		if (csElement.eContainer() instanceof TopLevelCS) {
			if (csElement.getName() == null) {
				context.addDiagnostic(csElement, "top level mapping must be named");
			}			
		}
		else {
			if (csElement.getName() != null) {
				context.addDiagnostic(csElement, "composed mapping must be unnamed");
			}			
		}
		@NonNull Mapping pivotElement = refreshNamedElement(Mapping.class, QVTcorePackage.Literals.MAPPING, csElement);
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
		context.refreshPivotList(Mapping.class, pivotElement.getLocal(), csElement.getComposedMappings());
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		@NonNull CoreModel asCoreModel = refreshRoot(CoreModel.class, QVTcorePackage.Literals.CORE_MODEL, csElement);
		context.refreshPivotList(Unit.class, asCoreModel.getUnit(), csElement.getOwnedImport());
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asCoreModel);		// Ensure containment viable for imported library type references
//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		List<Transformation> asTransformations = resolveTransformations(csElement);
		PivotUtil.refreshList(asCoreModel.getNestedPackage(), asTransformations);
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		resolveTransformationMappings(csElement);
		resolveTransformationQueries(csElement);
		return null;
	}
}
