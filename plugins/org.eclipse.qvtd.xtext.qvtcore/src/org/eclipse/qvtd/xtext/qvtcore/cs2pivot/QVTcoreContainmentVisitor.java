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

import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS;

public class QVTcoreContainmentVisitor extends AbstractQVTcoreContainmentVisitor
{
	protected static class DirectionContentContinuation extends SingleContinuation<DirectionCS>
	{
		private DirectionContentContinuation(CS2PivotConversion context, DirectionCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
			PivotUtil.refreshList(pTypedModel.getUsedPackage(), csElement.getImports());
			return null;
		}
	}

	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(CS2PivotConversion context, DomainCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			CoreDomain pDomain = PivotUtil.getPivot(CoreDomain.class, csElement);
			pDomain.setTypedModel(csElement.getDirection());
			return null;
		}
	}

	public QVTcoreContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}	

	@Override
	public Continuation<?> visitAssignmentCS(AssignmentCS csElement) {
		return null;
	}

	public Continuation<?> visitBottomPatternCS(BottomPatternCS csElement) {
		context.refreshModelElement(BottomPattern.class, QVTcorePackage.Literals.BOTTOM_PATTERN, csElement);
		return null;
	}

	public Continuation<?> visitDirectionCS(DirectionCS csElement) {
		refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return new DirectionContentContinuation(context, csElement);
	}

	public Continuation<?> visitDomainCS(DomainCS csElement) {
		CoreDomain pivotElement = context.refreshModelElement(CoreDomain.class, QVTcorePackage.Literals.CORE_DOMAIN, csElement);
		pivotElement.setIsCheckable(csElement.isCheck());
		pivotElement.setIsEnforceable(csElement.isEnforce());
		pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csElement.getBottomPattern()));
		pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csElement.getGuardPattern()));
		return new DomainContentContinuation(context, csElement);
	}

	public Continuation<?> visitEnforcementOperationCS(EnforcementOperationCS csElement) {
		context.refreshModelElement(EnforcementOperation.class, QVTcorePackage.Literals.ENFORCEMENT_OPERATION, csElement);
		return null;
	}

	public Continuation<?> visitGuardPatternCS(GuardPatternCS csElement) {
		context.refreshModelElement(GuardPattern.class, QVTcorePackage.Literals.GUARD_PATTERN, csElement);
		return null;
	}

	public Continuation<?> visitMappingCS(MappingCS csElement) {
		Mapping pivotElement = refreshNamedElement(Mapping.class, QVTcorePackage.Literals.MAPPING, csElement);
		DomainCS csMiddle = csElement.getMiddle();
		if (csMiddle != null) {
			pivotElement.setBottomPattern(PivotUtil.getPivot(BottomPattern.class, csMiddle.getBottomPattern()));
			pivotElement.setGuardPattern(PivotUtil.getPivot(GuardPattern.class, csMiddle.getGuardPattern()));
		}
		else {
			pivotElement.setBottomPattern(null);
			pivotElement.setGuardPattern(null);
		}
		context.refreshPivotList(CoreDomain.class, pivotElement.getDomain(), csElement.getDomains());
		context.refreshPivotList(Mapping.class, pivotElement.getLocal(), csElement.getComposedMappings());
		return null;
	}

	public Continuation<?> visitParamDeclarationCS(ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	public Continuation<?> visitQueryCS(QueryCS csElement) {
		Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameter(), csElement.getInputParamDeclaration());
		return null;
	}

	public Continuation<?> visitRealizedVariableCS(RealizedVariableCS csElement) {
		refreshNamedElement(RealizedVariable.class, QVTcorePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	public Continuation<?> visitTopLevelCS(TopLevelCS csElement) {
		importPackages(csElement);
		refreshRoot(CoreModel.class, QVTcorePackage.Literals.CORE_MODEL, csElement);
		List<TransformationCS> csTransformations = csElement.getTransformations();
		List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
		Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
		for (TransformationCS csTransformation : csTransformations) {
			Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
			tx2mappings.put(pTransformation, new ArrayList<Mapping>());
			txList.add(pTransformation);
		}
		CoreModel pPackage = PivotUtil.getPivot(CoreModel.class, csElement);
		PivotUtil.refreshList(pPackage.getNestedPackage(), txList);
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
		for (Transformation pTransformation : tx2mappings.keySet()) {
			PivotUtil.refreshList(pTransformation.getRule(), tx2mappings.get(pTransformation));
		}
//		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	public Continuation<?> visitTransformationCS(TransformationCS csElement) {
		Transformation pivotElement = refreshPackage(Transformation.class, QVTbasePackage.Literals.TRANSFORMATION, csElement);
//		context.refreshPivotList(Mapping.class, pivotElement.getRule(), csElement.getMapping());
		context.refreshPivotList(TypedModel.class, pivotElement.getModelParameter(), csElement.getDirections());
//		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return null;
	}

	public Continuation<?> visitUnrealizedVariableCS(UnrealizedVariableCS csElement) {
		refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}