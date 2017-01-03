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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BufferStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.LoopParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSContainmentVisitor;

public class QVTimperativeCSContainmentVisitor extends AbstractQVTimperativeCSContainmentVisitor
{
	protected static class DirectionContentContinuation extends SingleContinuation<DirectionCS>
	{
		private DirectionContentContinuation(@NonNull CS2ASConversion context, @NonNull DirectionCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			ImperativeTypedModel pTypedModel = PivotUtil.getPivot(ImperativeTypedModel.class, csElement);
			if (pTypedModel != null) {
				PivotUtilInternal.refreshList(pTypedModel.getUsedPackage(), csElement.getImports());
			}
			return null;
		}
	}

	public static class GuardParameterCompletion extends SingleContinuation<@NonNull GuardParameterCS>
	{
		public GuardParameterCompletion(@NonNull CS2ASConversion context, @NonNull GuardParameterCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			GuardParameter pivotElement = PivotUtil.getPivot(GuardParameter.class, csElement);
			if (pivotElement != null) {
				pivotElement.setReferredTypedModel(csElement.getReferredTypedModel());
			}
			return null;
		}
	}

	public static class NewStatementCompletion extends SingleContinuation<@NonNull NewStatementCS>
	{
		public NewStatementCompletion(@NonNull CS2ASConversion context, @NonNull NewStatementCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			NewStatement pivotElement = PivotUtil.getPivot(NewStatement.class, csElement);
			if (pivotElement != null) {
				pivotElement.setReferredTypedModel(csElement.getReferredTypedModel());
			}
			return null;
		}
	}

	public static class SimpleParameterCompletion extends SingleContinuation<@NonNull SimpleParameterCS>
	{
		public SimpleParameterCompletion(@NonNull CS2ASConversion context, @NonNull SimpleParameterCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			SimpleParameter pivotElement = PivotUtil.getPivot(SimpleParameter.class, csElement);
			if (pivotElement != null) {
				pivotElement.setReferredTypedModel(csElement.getReferredTypedModel());
			}
			return null;
		}
	}

	public QVTimperativeCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected void resolveTransformationMappings(@NonNull Iterable<? extends @NonNull MappingCS> csMappings) {
		Map<@NonNull Transformation, List<@NonNull Mapping>> tx2mappings = new HashMap<@NonNull Transformation, List<@NonNull Mapping>>();
		for (@NonNull MappingCS csMapping : csMappings) {
			PathNameCS csInPathName = csMapping.getOwnedInPathName();
			if (csInPathName != null) {
				Transformation asTransformation = lookupTransformation(csMapping, csInPathName, null);
				if (asTransformation != null) {
					Mapping asMapping = PivotUtil.getPivot(Mapping.class, csMapping);
					if (asMapping != null) {
						List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
						if (asMappings == null) {
							asMappings = new ArrayList<@NonNull Mapping>();
							tx2mappings.put(asTransformation, asMappings);
						}
						asMappings.add(asMapping);
					}
				}
			}
		}
		for (@NonNull Transformation asTransformation : tx2mappings.keySet()) {
			List<@NonNull Mapping> asMappings = tx2mappings.get(asTransformation);
			List<Rule> asRules = asTransformation.getRule();
			if (asMappings != null) {
				PivotUtilInternal.refreshList(asRules, asMappings);
			}
			else {
				asRules.clear();
			}
		}
	}

	protected void resolveTransformationQueries(@NonNull Iterable<@NonNull QueryCS> csQueries) {
		Map<@NonNull Transformation, List<@NonNull Function>> tx2qMap = new HashMap<@NonNull Transformation, List<@NonNull Function>>();
		for (@NonNull QueryCS csQuery : csQueries) {
			Transformation asTransformation = csQuery.getTransformation();
			if (asTransformation != null) {
				Function asQuery = PivotUtil.getPivot(Function.class,  csQuery);
				if (asQuery != null) {
					List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
					if (asQueries == null) {
						asQueries = new ArrayList<@NonNull Function>();
						tx2qMap.put(asTransformation, asQueries);
					}
					asQueries.add(asQuery);
				}
			}
		}
		for (Transformation asTransformation : tx2qMap.keySet()) {
			List<@NonNull Function> asQueries = tx2qMap.get(asTransformation);
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
	public @Nullable Continuation<?> visitAddStatementCS(@NonNull AddStatementCS csElement) {
		context.refreshModelElement(AddStatement.class, QVTimperativePackage.Literals.ADD_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitAppendParameterBindingCS(@NonNull AppendParameterBindingCS csElement) {
		@NonNull AppendParameterBinding pivotElement = context.refreshModelElement(AppendParameterBinding.class, QVTimperativePackage.Literals.APPEND_PARAMETER_BINDING, csElement);
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitAppendParameterCS(@NonNull AppendParameterCS csElement) {
		refreshNamedElement(AppendParameter.class, QVTimperativePackage.Literals.APPEND_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitBufferStatementCS(@NonNull BufferStatementCS csElement) {
		BufferStatement pivotElement = refreshNamedElement(BufferStatement.class, QVTimperativePackage.Literals.BUFFER_STATEMENT, csElement);
		pivotElement.setIsStrict(csElement.isIsStrict());
		return null;
	}

	@Override
	public Continuation<?> visitCheckStatementCS(@NonNull CheckStatementCS csElement) {
		context.refreshModelElement(CheckStatement.class, QVTimperativePackage.Literals.CHECK_STATEMENT, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDeclareStatementCS(@NonNull DeclareStatementCS csElement) {
		DeclareStatement asElement = refreshNamedElement(DeclareStatement.class, QVTimperativePackage.Literals.DECLARE_STATEMENT, csElement);
		asElement.setIsCheck(csElement.isIsCheck());
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		ImperativeTypedModel asTypedModel = refreshNamedElement(ImperativeTypedModel.class, QVTimperativePackage.Literals.IMPERATIVE_TYPED_MODEL, csElement);
		Continuation<?> continuation = new DirectionContentContinuation(context, csElement);
		asTypedModel.setIsChecked(csElement.isIsChecked());
		asTypedModel.setIsEnforced(csElement.isIsEnforced());
		QVTbaseUtil.getContextVariable(standardLibrary, asTypedModel);
		return continuation;
	}

	@Override
	public Continuation<?> visitGuardParameterBindingCS(@NonNull GuardParameterBindingCS csElement) {
		@NonNull GuardParameterBinding pivotElement = context.refreshModelElement(GuardParameterBinding.class, QVTimperativePackage.Literals.GUARD_PARAMETER_BINDING, csElement);
		pivotElement.setIsCheck(csElement.isIsCheck());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitGuardParameterCS(@NonNull GuardParameterCS csElement) {
		refreshNamedElement(GuardParameter.class, QVTimperativePackage.Literals.GUARD_PARAMETER, csElement);
		return new GuardParameterCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitLoopParameterBindingCS(@NonNull LoopParameterBindingCS csElement) {
		@NonNull LoopParameterBinding pivotElement = context.refreshModelElement(LoopParameterBinding.class, QVTimperativePackage.Literals.LOOP_PARAMETER_BINDING, csElement);
		pivotElement.setIsCheck(csElement.isIsCheck());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		Mapping pivotElement = refreshNamedElement(Mapping.class, QVTimperativePackage.Literals.MAPPING, csElement);
		context.refreshPivotList(MappingParameter.class, pivotElement.getOwnedMappingParameters(), csElement.getOwnedParameters());
		context.refreshPivotList(Statement.class, pivotElement.getOwnedStatements(), csElement.getOwnedStatements());
		pivotElement.setIsStrict(csElement.isIsStrict());
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		@NonNull MappingCall pivotElement = context.refreshModelElement(MappingCall.class, QVTimperativePackage.Literals.MAPPING_CALL, csElement);
		context.refreshPivotList(MappingParameterBinding.class, pivotElement.getOwnedMappingParameterBindings(), csElement.getOwnedBindings());
		pivotElement.setIsInstall(csElement.isIsInstall());
		pivotElement.setIsInvoke(csElement.isIsInvoke());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csMappingLoop) {
		@NonNull MappingLoop pivotElement = context.refreshModelElement(MappingLoop.class, QVTimperativePackage.Literals.MAPPING_LOOP, csMappingLoop);
		@NonNull LoopVariable iterator = refreshNamedElement(LoopVariable.class, QVTimperativePackage.Literals.LOOP_VARIABLE, ClassUtil.nonNullState(csMappingLoop.getOwnedIterator()));
		pivotElement.getOwnedIterators().clear();
		pivotElement.getOwnedIterators().add(iterator);
		context.refreshPivotList(MappingStatement.class, pivotElement.getOwnedMappingStatements(), csMappingLoop.getOwnedMappingStatements());
		context.refreshComments(pivotElement, csMappingLoop);
		return null;
	}

	@Override
	public Continuation<?> visitNewStatementCS(@NonNull NewStatementCS csElement) {
		NewStatement asNewStatement = refreshNamedElement(NewStatement.class, QVTimperativePackage.Literals.NEW_STATEMENT, csElement);
		asNewStatement.setIsContained(csElement.isIsContained());
		return new NewStatementCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, QVTbasePackage.Literals.TRANSFORMATION, csElement, null);
		}
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		//		pivotElement.setIsStatic(true);
		pivotElement.setIsTransient(csElement.isIsTransient());
		context.refreshPivotList(FunctionParameter.class, pivotElement.getOwnedParameters(), csElement.getOwnedParameters());
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitSetStatementCS(@NonNull SetStatementCS csSetStatement) {
		SetStatement asSetStatement = context.refreshModelElement(SetStatement.class, QVTimperativePackage.Literals.SET_STATEMENT, csSetStatement);
		asSetStatement.setIsNotify(csSetStatement.isIsNotify());
		asSetStatement.setIsPartial(csSetStatement.isIsPartial());
		return null;
	}

	@Override
	public Continuation<?> visitSimpleParameterBindingCS(@NonNull SimpleParameterBindingCS csElement) {
		@NonNull SimpleParameterBinding pivotElement = context.refreshModelElement(SimpleParameterBinding.class, QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING, csElement);
		pivotElement.setIsCheck(csElement.isIsCheck());
		context.refreshComments(pivotElement, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitSimpleParameterCS(@NonNull SimpleParameterCS csElement) {
		refreshNamedElement(SimpleParameter.class, QVTimperativePackage.Literals.SIMPLE_PARAMETER, csElement);
		return new SimpleParameterCompletion(context, csElement);
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
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		PathNameCS pathName = csElement.getOwnedPathName();
		if (pathName != null) {
			CS2AS.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
		}
		@SuppressWarnings("null") @NonNull EClass eClass = QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION;
		ImperativeTransformation asTransformation = refreshNamedElement(ImperativeTransformation.class, eClass, csElement);
		refreshClassifier(asTransformation, csElement);
		context.refreshPivotList(ImperativeTypedModel.class, asTransformation.getModelParameter(), csElement.getOwnedDirections());
		QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csElement) {
		refreshNamedElement(LoopVariable.class, QVTimperativePackage.Literals.LOOP_VARIABLE, csElement);
		return null;
	}
}
