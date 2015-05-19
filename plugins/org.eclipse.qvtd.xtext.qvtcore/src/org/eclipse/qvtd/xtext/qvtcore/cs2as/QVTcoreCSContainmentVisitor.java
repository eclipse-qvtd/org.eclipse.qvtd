/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
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
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecs.util.AbstractQVTcoreCSContainmentVisitor;

public class QVTcoreCSContainmentVisitor extends AbstractQVTcoreCSContainmentVisitor
{
	public QVTcoreCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}	

	protected void resolveTransformationMappings(@NonNull TopLevelCS csTopLevel) {
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (MappingCS csMapping : csTopLevel.getOwnedMappings()) {
			PathNameCS csInPathName = csMapping.getOwnedInPathName();
			if (csInPathName != null) {
				Transformation asTransformation = lookupTransformation(csMapping, csInPathName, null);
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
		}
		for (Transformation asTransformation : tx2mappings.keySet()) {
			List<Mapping> asMappings = tx2mappings.get(asTransformation);
			List<Rule> asRules = asTransformation.getRule();
			if (asMappings != null) {
				PivotUtilInternal.refreshList(asRules, asMappings);
			}
			else {
				asRules.clear();
			}
		}
	}

	protected void resolveTransformationQueries(@NonNull TopLevelCS csTopLevel) {
		Map<Transformation, List<Function>> tx2qMap = new HashMap<Transformation, List<Function>>();
		for (QueryCS csQuery : csTopLevel.getOwnedQueries()) {
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
			List<Operation> asOperations = asTransformation.getOwnedOperations();
			if (asQueries != null) {
				PivotUtilInternal.refreshList(asOperations, asQueries);
			}
			else {
				asOperations.clear();
			}
		}
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
		DomainCS csMiddle = csElement.getOwnedMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getOwnedBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getOwnedGuardPattern()));
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
		context.refreshPivotList(CoreDomain.class, pivotElement.getDomain(), csElement.getOwnedDomains());
		context.refreshPivotList(Mapping.class, pivotElement.getLocal(), csElement.getOwnedComposedMappings());
		pivotElement.setIsDefault(csElement.isIsDefault());
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
		if (csElement.getOwnedInitExpression() == null) {
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
		@NonNull CoreModel asCoreModel = refreshRoot(CoreModel.class, QVTcorePackage.Literals.CORE_MODEL, csElement);
		context.refreshPivotList(Import.class, asCoreModel.getOwnedImports(), csElement.getOwnedImports());
		//
		Resource eResource = csElement.eResource();
		if (eResource instanceof BaseCSResource) {
			context.installRootElement((BaseCSResource)eResource, asCoreModel);		// Ensure containment viable for imported library type references
//			importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
		}
		List<TransformationCS> csTransformations = csElement.getOwnedTransformations();
		List<org.eclipse.ocl.pivot.Package> asPackages = resolveTransformations(csTransformations, asCoreModel);
		PivotUtilInternal.refreshList(asCoreModel.getOwnedPackages(), asPackages);
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		resolveTransformationMappings(csElement);
		resolveTransformationQueries(csElement);
		return null;
	}
}
