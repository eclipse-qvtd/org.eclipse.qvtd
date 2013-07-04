/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS;

public class QVTcoreContainmentVisitor extends AbstractQVTcoreContainmentVisitor
{
	public QVTcoreContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
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
		Mapping pivotElement = refreshNamedElement(Mapping.class, QVTcorePackage.Literals.MAPPING, csElement);
		if (pivotElement != null) {
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
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		importPackages(csElement);
		CoreModel pivotElement = refreshRoot(CoreModel.class, QVTcorePackage.Literals.CORE_MODEL, csElement);
		List<TransformationCS> csTransformations = csElement.getTransformations();
		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
			txList.add(pTransformation);
		}
		CoreModel pPackage = PivotUtil.getPivot(CoreModel.class, csElement);
		if (pPackage != null) {
			PivotUtil.refreshList(pPackage.getNestedPackage(), txList);
		}
		//
		Resource eResource = csElement.eResource();
		if ((eResource != null) && (pivotElement != null)) {
			context.installRootElement(eResource, pivotElement);		// Ensure containment viable for imported library type references
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
}