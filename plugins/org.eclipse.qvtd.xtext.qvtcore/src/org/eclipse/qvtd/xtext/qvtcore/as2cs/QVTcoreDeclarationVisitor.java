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
package org.eclipse.qvtd.xtext.qvtcore.as2cs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS;
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

public class QVTcoreDeclarationVisitor extends QVTcoreBaseDeclarationVisitor implements QVTcoreVisitor<ElementCS>
{
	public QVTcoreDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

	public ElementCS visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		BottomPatternCS csBottomPattern = context.refreshElement(BottomPatternCS.class, QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS, asBottomPattern);
		csBottomPattern.setPivot(asBottomPattern);
		List<Element> asConstraints = new ArrayList<Element>(asBottomPattern.getAssignment());
		asConstraints.addAll(asBottomPattern.getPredicate());
		context.refreshList(csBottomPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asConstraints, null));
		context.refreshList(csBottomPattern.getRealizedVariables(), context.visitDeclarations(RealizedVariableCS.class, asBottomPattern.getRealizedVariable(), null));
		context.refreshList(csBottomPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asBottomPattern.getVariable(), null));
		return csBottomPattern;
	}

	public ElementCS visitCoreModel(@NonNull CoreModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTcoreCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImport(), context.visitDeclarations(ImportCS.class, asModel.getUnit(), null));
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

	public ElementCS visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		GuardPatternCS csGuardPattern = context.refreshElement(GuardPatternCS.class, QVTcoreBaseCSPackage.Literals.GUARD_PATTERN_CS, asGuardPattern);
		csGuardPattern.setPivot(asGuardPattern);
		context.refreshList(csGuardPattern.getConstraints(), context.visitDeclarations(AssignmentCS.class, asGuardPattern.getPredicate(), null));
		context.refreshList(csGuardPattern.getUnrealizedVariables(), context.visitDeclarations(UnrealizedVariableCS.class, asGuardPattern.getVariable(), null));
		return csGuardPattern;
	}

	public ElementCS visitMapping(@NonNull Mapping asMapping) {
		MappingCS csMapping = context.refreshNamedElement(MappingCS.class, QVTcoreCSPackage.Literals.MAPPING_CS, asMapping);
		csMapping.setPivot(asMapping);
		csMapping.setIn(asMapping.getTransformation());
		context.refreshList(csMapping.getDomains(), context.visitDeclarations(DomainCS.class, asMapping.getDomain(), null));
		DomainCS csDomain = context.refreshElement(DomainCS.class, QVTcoreBaseCSPackage.Literals.DOMAIN_CS, asMapping);
		csDomain.setPivot(null);		// stop comment duplication
		csDomain.setBottomPattern(context.visitDeclaration(BottomPatternCS.class, asMapping.getBottomPattern()));
		csDomain.setGuardPattern(context.visitDeclaration(GuardPatternCS.class, asMapping.getGuardPattern()));
		csMapping.setMiddle(csDomain);
		context.refreshList(csMapping.getComposedMappings(), context.visitDeclarations(MappingCS.class, asMapping.getLocal(), null));
		PivotUtil.refreshList(csMapping.getRefines(), asMapping.getRefinement());
		return csMapping;
	}
}
