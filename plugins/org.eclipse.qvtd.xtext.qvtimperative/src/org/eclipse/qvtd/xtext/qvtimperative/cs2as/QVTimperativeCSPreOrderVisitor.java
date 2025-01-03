/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.PivotDependency;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
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
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSPreOrderVisitor;

public class QVTimperativeCSPreOrderVisitor extends AbstractQVTimperativeCSPreOrderVisitor
{
	public static class AppendParameterCompletion extends SingleContinuation<@NonNull AppendParameterCS>
	{
		public AppendParameterCompletion(@NonNull CS2ASConversion context, @NonNull AppendParameterCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			AppendParameter pivotElement = PivotUtil.getPivot(AppendParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class BufferStatementCompletion extends SingleContinuation<@NonNull BufferStatementCS>
	{
		public BufferStatementCompletion(@NonNull CS2ASConversion context, @NonNull BufferStatementCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			BufferStatement pivotElement = PivotUtil.getPivot(BufferStatement.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class DeclareStatementCompletion extends SingleContinuation<@NonNull DeclareStatementCS>
	{
		public DeclareStatementCompletion(@NonNull CS2ASConversion context, @NonNull DeclareStatementCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			DeclareStatement pivotElement = PivotUtil.getPivot(DeclareStatement.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class GuardParameterCompletion extends SingleContinuation<@NonNull GuardParameterCS>
	{
		public GuardParameterCompletion(@NonNull CS2ASConversion context, @NonNull GuardParameterCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			GuardParameter pivotElement = PivotUtil.getPivot(GuardParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class MappingLoopIteratorCompletion extends SingleContinuation<@NonNull MappingLoopCS>
	{
		protected static @NonNull PivotDependency @NonNull [] computeDependencies(@NonNull MappingLoopCS csElement) {
			VariableCS csIterator = csElement.getOwnedIterator();
			if (csIterator != null) {
				TypedRefCS ownedType = csIterator.getOwnedType();
				if (ownedType != null) {
					return new @NonNull PivotDependency[]{new PivotDependency(ownedType)};
				}
			}
			return new PivotDependency[0];
		}

		public MappingLoopIteratorCompletion(@NonNull CS2ASConversion context, @NonNull MappingLoopCS csElement) {
			super(context, null, null, csElement, computeDependencies(csElement));
		}

		@Override
		public BasicContinuation<?> execute() {
			MappingLoop pivotElement = PivotUtil.getPivot(MappingLoop.class, csElement);
			if (pivotElement != null) {
				LoopVariable iterator = pivotElement.getOwnedIterators().get(0);
				if (iterator != null) {
					VariableCS csIterator = csElement.getOwnedIterator();
					if (csIterator != null) {
						Type type = PivotUtil.getPivot(Type.class, csIterator.getOwnedType());
						iterator.setType(type);
					}
				}
			}
			return null;
		}
	}

	public static class NewStatementCompletion extends SingleContinuation<@NonNull NewStatementCS>
	{
		public NewStatementCompletion(@NonNull CS2ASConversion context, @NonNull NewStatementCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}


		@Override
		public BasicContinuation<?> execute() {
			NewStatement pivotElement = PivotUtil.getPivot(NewStatement.class, csElement);
			if (pivotElement != null) {
				TypedRefCS csType = csElement.getOwnedType();
				if (csType instanceof TypeNameExpCS) {
					Type asType = ((TypeNameExpCS)csType).getElement();
					Boolean isRequired = context.getConverter().isRequired(csType);
					context.getHelper().setType(pivotElement, asType, isRequired == Boolean.TRUE);
				}
			}
			return null;
		}
	}

	protected static class NewStatementTypeNameExpContinuation extends SingleContinuation<TypeNameExpCS>
	{
		protected final @NonNull NewStatementCS csNewStatement;

		public NewStatementTypeNameExpContinuation(@NonNull CS2ASConversion context, @NonNull TypeNameExpCS csElement, @NonNull NewStatementCS csNewStatement) {
			super(context, null, null, csElement, context.getOperatorsHavePrecedenceInterDependency(), new PivotDependency(csNewStatement));
			this.csNewStatement = csNewStatement;
			assert csElement.getOwnedCurlyBracketedClause() != null;
		}

		@Override
		public BasicContinuation<?> execute() {
			NewStatement pivotElement = PivotUtil.getPivot(NewStatement.class, csNewStatement);
			if (pivotElement != null) {
				context.installPivotUsage(csElement, pivotElement);
			}
			return null;
		}
	}

	public static class ParamDeclarationCompletion extends SingleContinuation<@NonNull ParamDeclarationCS>
	{
		public ParamDeclarationCompletion(@NonNull CS2ASConversion context, @NonNull ParamDeclarationCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			FunctionParameter pivotElement = PivotUtil.getPivot(FunctionParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class QueryCompletion extends SingleContinuation<QueryCS>
	{
		public QueryCompletion(@NonNull CS2ASConversion context, @NonNull QueryCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class SimpleParameterCompletion extends SingleContinuation<@NonNull SimpleParameterCS>
	{
		public SimpleParameterCompletion(@NonNull CS2ASConversion context, @NonNull SimpleParameterCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			SimpleParameter pivotElement = PivotUtil.getPivot(SimpleParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class TransformationCompletion extends SingleContinuation<@NonNull TransformationCS>
	{
		public TransformationCompletion(@NonNull CS2ASConversion context, @NonNull TransformationCS csElement) {
			super(context, null, null, csElement, createDependencies(csElement.getOwnedContextType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			ImperativeTransformation pivotElement = PivotUtil.getPivot(ImperativeTransformation.class, csElement);
			if (pivotElement != null) {
				TypedRefCS csContextType = csElement.getOwnedContextType();
				if (csContextType != null) {
					org.eclipse.ocl.pivot.Class pivotType = PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, csContextType);
					pivotElement.setContextType(pivotType);
				}
			}
			return null;
		}
	}

	public QVTimperativeCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected org.eclipse.ocl.pivot.@Nullable Class lookupClass(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, PivotPackage.Literals.CLASS, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof org.eclipse.ocl.pivot.Class) {
			return (org.eclipse.ocl.pivot.Class) namedElement;
		}
		else {
			return null;
		}
	}

	protected @Nullable Mapping lookupMapping(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, QVTimperativePackage.Literals.MAPPING, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof Mapping) {
			return (Mapping) namedElement;
		}
		else {
			return null;
		}
	}



	protected @Nullable Property lookupProperty(@NonNull ElementCS csElement, @NonNull PathNameCS csPathName, @Nullable ScopeFilter scopeFilter) {
		CS2AS.setElementType(csPathName, PivotPackage.Literals.PROPERTY, csElement, scopeFilter);
		Element namedElement = csPathName.getReferredElement();
		if (namedElement instanceof Property) {
			return (Property) namedElement;
		}
		else {
			return null;
		}
	}

	private void refreshObservedProperties(@NonNull PivotableElementCS csElement, /*@NonNull*/ List<PathNameCS> csProperties) {
		ObservableStatement asElement = PivotUtil.getPivot(ObservableStatement.class, csElement);
		assert asElement != null;
		List<Property> properties = new ArrayList<Property>();
		for (PathNameCS csPathName : csProperties) {
			if (csPathName != null) {
				Property asProperty = lookupProperty(csElement, csPathName, null);
				if (asProperty != null) {
					properties.add(asProperty);
				}
			}
		}
		helper.refreshList(asElement.getObservedProperties(), properties);
	}

	@Override
	public Continuation<?> visitAddStatementCS(@NonNull AddStatementCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitAppendParameterCS(@NonNull AppendParameterCS csElement) {
		return new AppendParameterCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitAppendParameterBindingCS(@NonNull AppendParameterBindingCS csElement) {
		AppendParameterBinding pivotElement = PivotUtil.getPivot(AppendParameterBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
			pivotElement.setValue(csElement.getValue());
		}
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitBufferStatementCS(@NonNull BufferStatementCS csElement) {
		return new BufferStatementCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitCheckStatementCS(@NonNull CheckStatementCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitDeclareStatementCS(@NonNull DeclareStatementCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return new DeclareStatementCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitGuardParameterCS(@NonNull GuardParameterCS csElement) {
		return new GuardParameterCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitGuardParameterBindingCS(@NonNull GuardParameterBindingCS csElement) {
		GuardParameterBinding pivotElement = PivotUtil.getPivot(GuardParameterBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
			pivotElement.setValue(csElement.getValue());
		}
		return null;
	}

	@Override
	public Continuation<?> visitLoopParameterBindingCS(@NonNull LoopParameterBindingCS csElement) {
		LoopParameterBinding pivotElement = PivotUtil.getPivot(LoopParameterBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
			pivotElement.setValue(csElement.getValue());
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csMapping) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallCS(@NonNull MappingCallCS csElement) {
		MappingCall pivotElement = PivotUtil.getPivot(MappingCall.class, csElement);
		if (pivotElement != null) {
			PathNameCS csPathName = csElement.getOwnedPathName();
			if (csPathName != null) {
				Mapping asMapping = lookupMapping(csElement, csPathName, null);
				pivotElement.setReferredMapping(asMapping);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return new MappingLoopIteratorCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitNewStatementCS(@NonNull NewStatementCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return new NewStatementCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		return new ParamDeclarationCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		return new QueryCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitSetStatementCS(@NonNull SetStatementCS csElement) {
		refreshObservedProperties(csElement, csElement.getObservedProperties());
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitSimpleParameterCS(@NonNull SimpleParameterCS csElement) {
		return new SimpleParameterCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitSimpleParameterBindingCS(@NonNull SimpleParameterBindingCS csElement) {
		SimpleParameterBinding pivotElement = PivotUtil.getPivot(SimpleParameterBinding.class, csElement);
		if (pivotElement != null) {
			pivotElement.setBoundVariable(csElement.getReferredVariable());
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		Transformation pivotElement = PivotUtil.getPivot(Transformation.class, csElement);
		if (pivotElement != null) {
			List<org.eclipse.ocl.pivot.Class> superClasses = pivotElement.getSuperClasses();
			//			helper.refreshList(Type.class, superClasses, csElement.getOwnedSuperType());
			if (superClasses.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = context.getMetamodelManager().getStandardLibrary().getOclElementType();
				pivotElement.getSuperClasses().add(oclElementType);
			}
		}
		return new TransformationCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS csTypeNameExp) {
		EObject eContainer = csTypeNameExp.eContainer();
		// Perhaps there should be a distinct CS class for this variant
		if ((eContainer instanceof NewStatementCS) && (csTypeNameExp.getOwnedCurlyBracketedClause() != null)) {
			return new NewStatementTypeNameExpContinuation(context, csTypeNameExp, (NewStatementCS)eContainer);
		}
		return super.visitTypeNameExpCS(csTypeNameExp);
	}
}