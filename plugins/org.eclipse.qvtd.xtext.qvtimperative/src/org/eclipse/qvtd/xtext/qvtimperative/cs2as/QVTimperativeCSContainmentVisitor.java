/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
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
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BufferStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.EntryPointCS;
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
import org.eclipse.qvtd.xtext.qvtimperativecs.SpeculateStatementCS;
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
			TypedModel pTypedModel = PivotUtil.getPivot(TypedModel.class, csElement);
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
		pivotElement.setFirstPass(csElement.getFirstPass());
		pivotElement.setIsStrict(csElement.isIsStrict());
		pivotElement.setLastPass(csElement.getLastPass());
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
		TypedModel asTypedModel = refreshNamedElement(TypedModel.class, QVTbasePackage.Literals.TYPED_MODEL, csElement);
		Continuation<?> continuation = new DirectionContentContinuation(context, csElement);
		QVTbaseUtil.getContextParameter(standardLibrary, asTypedModel);
		return continuation;
	}

	@Override
	public Continuation<?> visitEntryPointCS(@NonNull EntryPointCS csElement) {
		EntryPoint pivotElement = refreshNamedElement(EntryPoint.class, QVTimperativePackage.Literals.ENTRY_POINT, csElement);
		context.refreshPivotList(MappingParameter.class, pivotElement.getOwnedMappingParameters(), csElement.getOwnedParameters());
		context.refreshPivotList(Statement.class, pivotElement.getOwnedStatements(), csElement.getOwnedStatements());
		pivotElement.setFirstPass(0);
		pivotElement.setIsStrict(csElement.isIsStrict());
		pivotElement.setLastPass(0);
		pivotElement.setTargetName(csElement.getTargetName());
		return null;
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
		pivotElement.setFirstPass(csElement.getFirstPass());
		pivotElement.setIsStrict(csElement.isIsStrict());
		pivotElement.setLastPass(csElement.getLastPass());
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
		List<ShadowPartCS> csParts = null;
		TypedRefCS csType = csElement.getOwnedType();
		if (csType instanceof TypeNameExpCS) {
			CurlyBracketedClauseCS csCurlyBracketedClause = ((TypeNameExpCS)csType).getOwnedCurlyBracketedClause();
			if (csCurlyBracketedClause != null) {
				csParts = csCurlyBracketedClause.getOwnedParts();
			}
		}
		if (csParts != null) {
			context.refreshPivotList(NewStatementPart.class, asNewStatement.getOwnedParts(), csParts);
		}
		else {
			asNewStatement.getOwnedParts().clear();
		}
		return new NewStatementCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		refreshNamedElement(FunctionParameter.class, QVTbasePackage.Literals.FUNCTION_PARAMETER, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		@NonNull Function pivotElement = refreshNamedElement(Function.class, QVTbasePackage.Literals.FUNCTION, csElement);
		//		pivotElement.setIsStatic(true);
		pivotElement.setIsTransient(csElement.isIsTransient());
		JavaClassCS csJavaClass = csElement.getImplementation();
		pivotElement.setImplementationClass(csJavaClass != null ? csJavaClass.getName() : null);
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
	public Continuation<?> visitShadowPartCS(@NonNull ShadowPartCS csElement) {
		if (QVTimperativeCS2AS.isNewStatementPartCS(csElement)) {
			context.refreshModelElement(NewStatementPart.class, QVTimperativePackage.Literals.NEW_STATEMENT_PART, csElement);
			return null;
		}
		return super.visitShadowPartCS(csElement);
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
	public Continuation<?> visitSpeculateStatementCS(@NonNull SpeculateStatementCS csElement) {
		context.refreshModelElement(SpeculateStatement.class, QVTimperativePackage.Literals.SPECULATE_STATEMENT, csElement);
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
		context.refreshPivotList(TypedModel.class, asTransformation.getModelParameter(), csElement.getOwnedDirections());
		QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
		context.refreshPivotList(Mapping.class, asTransformation.getRule(), csElement.getOwnedMappings());
		context.refreshPivotList(Operation.class, asTransformation.getOwnedOperations(), csElement.getOwnedQueries());
		context.refreshPivotList(Property.class, asTransformation.getOwnedProperties(), csElement.getOwnedProperties());
		return null;
	}

	@Override
	public Continuation<?> visitVariableCS(@NonNull VariableCS csElement) {
		EReference eContainmentFeature = csElement.eContainmentFeature();
		if (eContainmentFeature == EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR) {
			//			refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csElement);
			return super.visitVariableCS(csElement);
		}
		else {
			refreshNamedElement(LoopVariable.class, QVTimperativePackage.Literals.LOOP_VARIABLE, csElement);
			return null;
		}
	}
}
