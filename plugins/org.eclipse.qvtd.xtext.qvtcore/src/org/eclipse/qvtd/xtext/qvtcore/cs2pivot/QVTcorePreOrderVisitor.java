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
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ConstraintCS;
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
import org.eclipse.qvtd.xtext.qvtcorecst.util.AbstractExtendingDelegatingQVTcoreCSVisitor;

public class QVTcorePreOrderVisitor
	extends AbstractExtendingDelegatingQVTcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{	
	protected static class DomainContentContinuation extends SingleContinuation<DomainCS>
	{
		private DomainContentContinuation(CS2PivotConversion context, DomainCS csElement) {
			super(context, null, null, csElement);
			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			CoreDomain pDomain = PivotUtil.getPivot(CoreDomain.class, csElement);
			BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement.getBottomPattern());
			GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement.getGuardPattern());
			pDomain.setBottomPattern(pBottomPattern);
			pDomain.setGuardPattern(pGuardPattern);
			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

	protected static class MappingContentContinuation extends SingleContinuation<MappingCS>
	{
		private MappingContentContinuation(CS2PivotConversion context, MappingCS csElement) {
			super(context, null, null, csElement);
			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Mapping pMapping = PivotUtil.getPivot(Mapping.class, csElement);
			DomainCS csMiddle = csElement.getMiddle();
			if (csMiddle != null) {
				BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csMiddle.getBottomPattern());
				GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csMiddle.getGuardPattern());
				pMapping.setBottomPattern(pBottomPattern);
				pMapping.setGuardPattern(pGuardPattern);
			}
			else {
				pMapping.setBottomPattern(null);
				pMapping.setGuardPattern(null);
			}
			context.refreshPivotList(CoreDomain.class, pMapping.getDomain(), csElement.getDomains());
			context.refreshPivotList(Mapping.class, pMapping.getLocal(), csElement.getComposedMappings());
			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

	protected static class TopLevelContentContinuation extends SingleContinuation<TopLevelCS>
	{
		private TopLevelContentContinuation(CS2PivotConversion context, TopLevelCS csElement) {
			super(context, null, null, csElement);
			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			List<TransformationCS> csTransformations = csElement.getTransformations();
			List<Transformation> txList = new ArrayList<Transformation>(csTransformations.size());
			Map<Transformation, List<Mapping>> tx2mappings = new HashMap<Transformation, List<Mapping>>();
			for (TransformationCS csTransformation : csTransformations) {
				Transformation pTransformation = PivotUtil.getPivot(Transformation.class, csTransformation);
				tx2mappings.put(pTransformation, new ArrayList<Mapping>());
				txList.add(pTransformation);
			}
			org.eclipse.ocl.examples.pivot.Package pPackage = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csElement);
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
//			context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//			context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

	protected static class TransformationContentContinuation extends SingleContinuation<TransformationCS>
	{
		private TransformationContentContinuation(CS2PivotConversion context, TransformationCS csElement) {
			super(context, null, null, csElement);
			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Transformation pivotElement = PivotUtil.getPivot(Transformation.class, csElement);
//			context.refreshPivotList(Mapping.class, pivotElement.getRule(), csElement.getMapping());
//			context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
//			context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

	protected final MetaModelManager metaModelManager;

	public QVTcorePreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
		metaModelManager = context.getMetaModelManager();
	}

	@Override
	public Continuation<?> visitBottomPatternCS(BottomPatternCS csElement) {
		BottomPattern pivotElement = context.refreshModelElement(BottomPattern.class,
				QVTcorePackage.Literals.BOTTOM_PATTERN, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(ConstraintCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(DirectionCS csElement) {
		TypedModel pivotElement = context.refreshNamedElement(TypedModel.class,
				QVTbasePackage.Literals.TYPED_MODEL, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(DomainCS csElement) {
		CoreDomain pCoreDomain = context.refreshNamedElement(CoreDomain.class,
				QVTcorePackage.Literals.CORE_DOMAIN, csElement);
		pCoreDomain.setIsCheckable(csElement.isCheck());
		pCoreDomain.setIsEnforceable(csElement.isEnforce());
		return new DomainContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(EnforcementOperationCS csElement) {
		EnforcementOperation pivotElement = context.refreshModelElement(EnforcementOperation.class,
				QVTcorePackage.Literals.ENFORCEMENT_OPERATION, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(GuardPatternCS csElement) {
		GuardPattern pivotElement = context.refreshModelElement(GuardPattern.class,
				QVTcorePackage.Literals.GUARD_PATTERN, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(MappingCS csElement) {
		Mapping pMapping = context.refreshNamedElement(Mapping.class,
				QVTcorePackage.Literals.MAPPING, csElement);
		return new MappingContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(ParamDeclarationCS csElement) {
		FunctionParameter pivotElement = context.refreshNamedElement(FunctionParameter.class,
				QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(QueryCS csElement) {
		Function pivotElement = context.refreshNamedElement(Function.class,
				QVTbasePackage.Literals.FUNCTION, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(RealizedVariableCS csElement) {
		RealizedVariable pivotElement = context.refreshNamedElement(RealizedVariable.class,
				QVTcorePackage.Literals.REALIZED_VARIABLE, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(TopLevelCS csElement) {
		for (LibraryCS csLibrary : csElement.getOwnedLibrary()) {
			csLibrary.getPackage();						// Resolve the proxy to perform the import.
		}
		for (ImportCS csImport : csElement.getOwnedImport()) {
			csImport.getNamespace();					// Resolve the proxy to perform the import.
		}
		org.eclipse.ocl.examples.pivot.Package pivotElement = context.refreshPackage(org.eclipse.ocl.examples.pivot.Package.class,
				PivotPackage.Literals.PACKAGE, csElement);
			String newNsPrefix = csElement.getNsPrefix();
			String oldNsPrefix = pivotElement.getNsPrefix();
			if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
				pivotElement.setNsPrefix(newNsPrefix);
			}
			String newNsURI = csElement.getNsURI();
			String oldNsURI = pivotElement.getNsURI();
			if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
				pivotElement.setNsURI(newNsURI);
			}
		return new TopLevelContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitTransformationCS(TransformationCS csElement) {
		Transformation pivotElement = context.refreshNamedElement(Transformation.class,
				QVTbasePackage.Literals.TRANSFORMATION, csElement);
		String newNsPrefix = csElement.getNsPrefix();
		String oldNsPrefix = pivotElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			pivotElement.setNsPrefix(newNsPrefix);
		}
		String newNsURI = csElement.getNsURI();
		String oldNsURI = pivotElement.getNsURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotElement.setNsURI(newNsURI);
		}
		return new TransformationContentContinuation(context, csElement);
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(UnrealizedVariableCS csElement) {
		Variable pivotElement = context.refreshNamedElement(Variable.class,
				PivotPackage.Literals.VARIABLE, csElement);
		return null;
	}
}