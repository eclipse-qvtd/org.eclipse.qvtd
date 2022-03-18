/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsKindOfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.library.CompositionProperty;
import org.eclipse.ocl.pivot.internal.library.ExplicitNavigationProperty;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.java.QVTiGlobalContext;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
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
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiAS2CGVisitor extends AS2CGVisitor implements QVTimperativeVisitor<@Nullable CGNamedElement>
{
	public static class CGMappingCallBindingComparator implements Comparator<@NonNull CGMappingCallBinding>
	{
		public static final @NonNull CGMappingCallBindingComparator INSTANCE = new CGMappingCallBindingComparator();

		@Override
		public int compare(@NonNull CGMappingCallBinding o1, @NonNull CGMappingCallBinding o2) {
			MappingParameterBinding b1 = (MappingParameterBinding) o1.getAst();
			MappingParameterBinding b2 = (MappingParameterBinding) o2.getAst();
			VariableDeclaration v1 = b1 != null ? b1.getBoundVariable() : null;
			VariableDeclaration v2 = b2 != null ? b2.getBoundVariable() : null;
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}

	public static class CGVariableComparator implements Comparator<@NonNull CGVariable>
	{
		public static final @NonNull CGVariableComparator INSTANCE = new CGVariableComparator();

		@Override
		public int compare(@NonNull CGVariable o1, @NonNull CGVariable o2) {
			VariableDeclaration v1 = (VariableDeclaration) o1.getAst();
			VariableDeclaration v2 = (VariableDeclaration) o2.getAst();
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}

	public static class InlinedBodyAdapter extends AdapterImpl
	{
		protected final @NonNull OperationCallExp operationCallExp;

		public InlinedBodyAdapter(@NonNull OperationCallExp operationCallExp) {
			this.operationCallExp = operationCallExp;
		}

		public @NonNull OperationCallExp getOperationCallExp() {
			return operationCallExp;
		}
	}

	/**
	 * PredicateTreeBuilder supports building a CGMapping.body as a nest of if/let expressions top-down,
	 * continually appending to the 'leaf' which is the then-expression of an if, or the in-expression of a let.
	 */
	protected class PredicateTreeBuilder
	{
		protected final @NonNull Mapping asMapping;
		protected final @NonNull CGMapping cgMapping;
		protected final @NonNull CGMappingExp cgMappingExp;
		private @Nullable CGValuedElement cgLeafExp = null;

		public PredicateTreeBuilder(@NonNull Mapping asMapping, @NonNull CGMapping cgMapping) {
			this.asMapping = asMapping;
			this.cgMapping = cgMapping;
			this.cgMappingExp = QVTiCGModelFactory.eINSTANCE.createCGMappingExp();
			setAst(cgMappingExp, asMapping);
			TypeId pivotTypeId = TypeId.BOOLEAN; //pMapping.getTypeId();
			cgMappingExp.setTypeId(analyzer.getTypeId(pivotTypeId));
		}

		public void addAccumulator(@NonNull CGAccumulator cgAccumulator) {
			cgMappingExp.getOwnedAccumulators().add(cgAccumulator);
		}

		public @NonNull CGRealizedVariable addRealizedVariable(@NonNull NewStatement asNewStatement) {
			List<@NonNull CGRealizedVariable> cgRealizedVariables = ClassUtil.nullFree(cgMapping.getOwnedRealizedVariables());
			CGRealizedVariable cgVariable = getRealizedVariable(asNewStatement);
			cgRealizedVariables.add(cgVariable);
			return cgVariable;
		}

		/**
		 * Add a let expression sub-tree that exposes asVariable after initialization with asInit, as the 'leaf' of an existing expression sub-tree at cgLeafExp.
		 * If cgLeafExp is null then cgMapping.getBody() is the existing 'leaf'. Returns cgElement as the new 'leaf'.
		 * If asInit may be null but asVariable may not, a null value predicate as appended to enforce the non-nullness.
		 * If asInit.getType() does not conform to asVariable.getType() a ttype conformace predicate is appended to enforce type compatibility.
		 *
		 * This method supports building a nest of if/let expressions top-down, continually appending to the 'leaf' which is
		 * the then-expression of an if, or the in-expression of a let.
		 */
		private void appendCheckedLetVariable(@NonNull VariableDeclaration asVariable, @NonNull OCLExpression asInit) {
			Type sourceType = ClassUtil.nonNullState(asInit.getType());
			Type targetType = ClassUtil.nonNullState(asVariable.getType());
			boolean needsNullTest = !asInit.isIsRequired() && asVariable.isIsRequired();
			boolean needsTypeCheck = !sourceType.conformsTo(standardLibrary, targetType);
			//
			CGValuedElement cgInit = doVisit(CGValuedElement.class, asInit);

			if (needsTypeCheck || needsNullTest) {
				CGFinalVariable cgRawVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
				setAst(cgRawVariable, asInit);
				cgRawVariable.setInit(cgInit);
				cgRawVariable.setName("raw_" + asVariable.getName());
				//
				CGLetExp cgRawLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
				setAst(cgRawLetExp, asInit);
				cgRawLetExp.setInit(cgRawVariable);
				//				cgRawLetExp.setIn(cgIn);
				cgRawLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
				//
				appendSubTree(cgRawLetExp);
				//
				if (needsNullTest) {
					appendNonNullPredicate(cgRawVariable);
				}
				if (needsTypeCheck) {
					CGExecutorType cgType = analyzer.createExecutorType(targetType);
					appendIsKindOfPredicate(cgRawVariable, cgType);
					CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
					cgCastExp.setSource(analyzer.createCGVariableExp(cgRawVariable));
					cgCastExp.setExecutorType(cgType);
					cgCastExp.setTypeId(codeGenerator.getAnalyzer().getTypeId(asVariable.getTypeId()));
					cgInit = cgCastExp;
				}
				else {
					cgInit = analyzer.createCGVariableExp(cgRawVariable);
				}
			}
			CGFinalVariable cgVariable = (CGFinalVariable) createCGVariable(asVariable);		// FIXME Lose cast
			cgVariable.setInit(cgInit);
			CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			setAst(cgLetExp, asVariable);
			cgLetExp.setInit(cgVariable);
			cgLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			appendSubTree(cgLetExp);
		}

		/**
		 * Add an expression sub-tree that ensures that cgVariable conforms to cgExecutorType.
		 */
		private void appendIsKindOfPredicate(@NonNull CGFinalVariable cgVariable, @NonNull CGExecutorType cgExecutorType) {
			@NonNull CGIsKindOfExp cgCondition = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
			cgCondition.setSource(analyzer.createCGVariableExp(cgVariable));
			cgCondition.setExecutorType(cgExecutorType);
			//			setAst(cgCondition, asVariable);
			cgCondition.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			//			cgCondition.setInvalidating(false);
			//			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asVariable);
			cgIfExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			//			cgIfExp.setName(cgVariable.getName());
			cgIfExp.setCondition(cgCondition);
			//			cgIfExp.setThenExpression(cgUnsafeExp);
			cgIfExp.setElseExpression(analyzer.createCGConstantExp(analyzer.getBoolean(false)));
			//
			appendSubTree(cgIfExp);
		}

		/**
		 * Add an expression sub-tree that ensures that cgVariable is non-null.
		 */
		private void appendNonNullPredicate(@NonNull CGFinalVariable cgVariable) {
			CGIsEqualExp cgCondition = CGModelFactory.eINSTANCE.createCGIsEqualExp();
			cgCondition.setNotEquals(true);
			cgCondition.setSource(analyzer.createCGVariableExp(cgVariable));
			cgCondition.setArgument(analyzer.createCGConstantExp(analyzer.getNull()));
			//			setAst(cgCondition, asExpression);
			cgCondition.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgCondition.setInvalidating(false);
			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asExpression);
			cgIfExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgIfExp.setName(cgVariable.getName());
			cgIfExp.setCondition(cgCondition);
			cgIfExp.setElseExpression(analyzer.createCGConstantExp(analyzer.getBoolean(false)));
			//
			appendSubTree(cgIfExp);
		}

		/**
		 * Add the expression sub-tree whose 'leaf' is at cgElement, as the 'leaf' of an existing expression sub-tree at cgLeafExp.
		 * If cgLeafExp is null then cgMapping.getBody() is the existing 'leaf'. Returns cgElement as the new 'leaf'.
		 *
		 * This method supports building a nest of if/let expressions top-down, continually appending to the 'leaf' which is
		 * the then-expression of an if, or the in-expression of a let.
		 */
		private void appendSubTree(@NonNull CGValuedElement cgElement) {
			CGValuedElement cgElementRoot = cgElement;
			while (cgElementRoot.eContainer() != null) {
				cgElementRoot = (CGValuedElement) cgElementRoot.eContainer();
			}
			if (cgMapping.getOwnedBody() == null) {
				cgMapping.setOwnedBody(cgElementRoot);
			}
			if (cgLeafExp instanceof CGLetExp) {
				((CGLetExp)cgLeafExp).setIn(cgElementRoot);
			}
			else if (cgLeafExp instanceof CGIfExp) {
				((CGIfExp)cgLeafExp).setThenExpression(cgElementRoot);
			}
			else if (cgLeafExp instanceof CGSpeculateExp) {
				((CGSpeculateExp)cgLeafExp).setSpeculated(cgElementRoot);
			}
			else {
				assert cgLeafExp == null;
			}
			cgLeafExp = cgElement;
		}

		public void doBottoms() {
			List<@NonNull CGGuardVariable> cgFreeVariables = new ArrayList<>();
			for (@NonNull MappingParameter pMappingParameter : QVTimperativeUtil.getOwnedMappingParameters(asMapping)) {
				cgFreeVariables.add(getGuardVariable(pMappingParameter));
			}
			Collections.sort(cgFreeVariables, NameUtil.NAMEABLE_COMPARATOR);
			cgMapping.getOwnedGuardVariables().addAll(cgFreeVariables);
			CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
			List<CGValuedElement> cgMappingStatements = cgSequence.getOwnedStatements();
			for (@NonNull Statement asStatement : ClassUtil.nullFree(asMapping.getOwnedStatements())) {
				CGNamedElement cgElement = asStatement.accept(QVTiAS2CGVisitor.this);
				if (cgElement != null) {	// FIXME some statements do a more complex appendSubTree
					cgMappingStatements.add((CGValuedElement) cgElement);
				}
			}
			appendSubTree(cgMappingExp);
			cgMappingExp.setOwnedBody(cgSequence);
		}

		@Override
		public String toString() {
			return String.valueOf(cgMapping.getOwnedBody());
		}
	}

	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private @Nullable PredicateTreeBuilder bodyBuilder;

	public QVTiAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext) {
		super(analyzer);
		this.analyzer = analyzer;
		this.globalContext = globalContext;
		this.standardLibrary = environmentFactory.getStandardLibrary();
	}

	private @NonNull Set<@NonNull Mapping> computeUseClasses(@NonNull ImperativeTransformation iTransformation) {
		Iterable<@NonNull Mapping> iMappings = QVTimperativeUtil.getOwnedMappings(iTransformation);
		Set<@NonNull Mapping> useClassMappings = new HashSet<>();
		for (@NonNull Mapping iMapping : iMappings) {
			if (iMapping.isIsStrict()) {
				useClassMappings.add(iMapping);
			}
			else if (QVTimperativeUtil.isObserver(iMapping)) {	// ?? redundant
				useClassMappings.add(iMapping);
			}
			for (@NonNull Statement iStatement : QVTimperativeUtil.getOwnedStatements(iMapping)) {
				if (iStatement instanceof SpeculateStatement) {
					useClassMappings.add(iMapping);
				}
			}
		}
		if (useClassMappings.size() > 0) {
			for (@NonNull EntryPoint iEntryPoint : QVTimperativeUtil.computeEntryPoints(iTransformation)) {
				useClassMappings.add(iEntryPoint);
			}
		}
		return useClassMappings;
	}

	@Override
	protected <T extends EObject> @NonNull T createCopy(@NonNull T aPrototype) {
		Copier copier = new EcoreUtil.Copier();
		EObject aCopy = copier.copy(aPrototype);
		assert aCopy != null;
		copier.copyReferences();
		@SuppressWarnings("unchecked") T castCopy = (T) aCopy;
		return castCopy;
	}

	@Override
	protected @NonNull CGValuedElement generateOperationCallExp(@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		Operation pOperation = asOperationCallExp.getReferredOperation();
		if (pOperation instanceof Function) {
			if (cgSource == null) {			// FIXME workaround for BUG 481664
				Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asOperationCallExp);
				VariableDeclaration asThis = QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
				VariableExp asThisExp = PivotUtil.createVariableExp(asThis);
				cgSource = doVisit(CGValuedElement.class, asThisExp);
			}
			CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
			cgFunctionCallExp.setReferredOperation(pOperation);
			setAst(cgFunctionCallExp, asOperationCallExp);
			cgFunctionCallExp.setRequired(pOperation.isIsRequired());
			cgFunctionCallExp.setSource(cgSource);
			for (OCLExpression pArgument : asOperationCallExp.getOwnedArguments()) {
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
				cgFunctionCallExp.getArguments().add(cgArgument);
			}
			//			cgOperationCallExp.setOperation(getOperation(asOperationCallExp.getReferredOperation()));
			return cgFunctionCallExp;
		}
		else {
			return super.generateOperationCallExp(cgSource, asOperationCallExp);
		}
	}

	@Override
	protected @NonNull CGValuedElement generateOppositePropertyCallExp(@NonNull CGValuedElement cgSource, @NonNull OppositePropertyCallExp asOppositePropertyCallExp) {
		Property asOppositeProperty = ClassUtil.nonNullModel(asOppositePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		if (asOppositeProperty.isIsComposite()) {
			return super.generateOppositePropertyCallExp(cgSource, asOppositePropertyCallExp);
		}
		else {
			globalContext.addOppositeProperty(asOppositeProperty);
			//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
			CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();
			cgPropertyCallExp.setAst(asOppositePropertyCallExp);
			//		CGExecutorProperty cgExecutorProperty = analyzer.getExecutorProperty(asProperty);
			//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
			//		cgPropertyCallExp = cgExecutorPropertyCallExp;
			//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
			cgPropertyCallExp.setReferredProperty(asProperty);
			setAst(cgPropertyCallExp, asOppositePropertyCallExp);
			cgPropertyCallExp.setRequired(asProperty.isIsRequired());
			cgPropertyCallExp.setSource(cgSource);
			return cgPropertyCallExp;
		}
	}

	@Override
	protected @NonNull CGValuedElement generatePropertyCallExp(@Nullable CGValuedElement cgSource, @NonNull PropertyCallExp element) {
		Property asProperty = ClassUtil.nonNullModel(element.getReferredProperty());
		boolean isRequired = asProperty.isIsRequired();
		org.eclipse.ocl.pivot.Class asSourceClass = asProperty.getOwningClass();
		boolean isThis = false;
		if (asSourceClass instanceof Transformation) {
			ImperativeTransformation iTransformation = getAnalyzer().getCodeGenerator().getTransformation();
			org.eclipse.ocl.pivot.Class compileTimeContextClass = QVTimperativeUtil.getCompileTimeContextClass(iTransformation);
			if (iTransformation != compileTimeContextClass) {
				org.eclipse.ocl.pivot.Class runtimeContextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
				if (runtimeContextClass != compileTimeContextClass) {
					Property iProperty = NameUtil.getNameable(runtimeContextClass.getOwnedProperties(), asProperty.getName());
					assert iProperty != null;
					asProperty = iProperty;
					isThis = true;
				}
			}
		}
		if (isThis) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				CGPropertyCallExp cgPropertyCallExp = null;
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					CGEcorePropertyCallExp cgEcorePropertyCallExp = CGModelFactory.eINSTANCE.createCGEcorePropertyCallExp();
					cgEcorePropertyCallExp.setEStructuralFeature(eStructuralFeature);
					//					Boolean ecoreIsRequired = codeGenerator.isNonNull(asProperty);
					//					if (ecoreIsRequired != null) {
					//						isRequired = ecoreIsRequired;
					//					}
					isRequired = asProperty.isIsRequired();
					cgPropertyCallExp = cgEcorePropertyCallExp;
				} catch (GenModelException e) {
					codeGenerator.addProblem(e);		// FIXME drop through to better default
				}
				if (cgPropertyCallExp == null) {
					CGExecutorPropertyCallExp cgExecutorPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorPropertyCallExp();
					CGExecutorProperty cgExecutorProperty = context.createExecutorProperty(asProperty);
					cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
					cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
					cgPropertyCallExp = cgExecutorPropertyCallExp;
				}
				cgPropertyCallExp.setReferredProperty(asProperty);
				setAst(cgPropertyCallExp, element);
				cgPropertyCallExp.setRequired(isRequired || codeGenerator.isPrimitive(cgPropertyCallExp));
				cgPropertyCallExp.setSource(cgSource);
				return cgPropertyCallExp;
			}
		}
		assert cgSource != null;
		return super.generatePropertyCallExp(cgSource, element);
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer) context;
	}

	private @NonNull PredicateTreeBuilder getBodyBuilder() {
		assert bodyBuilder != null;
		return bodyBuilder;
	}

	protected @Nullable EClassifier getEClassifier(@Nullable Type type) {
		if (type == null) {
			return null;
		}
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(type);
		for (Type partialClass : completeClass.getPartialClasses()) {
			EObject esObject = partialClass.getESObject();
			if (esObject instanceof EClassifier) {
				return (EClassifier) esObject;
			}
		}
		return null;
	}

	protected @NonNull String getFunctionInstanceName(@NonNull CGFunction cgFunction) {
		//	JavaLocalContext<@NonNull ?> functionContext = ClassUtil.nonNullState(globalContext.getLocalContext(cgFunction));
		NameResolution instanceName = globalContext.getInstanceNameResolution();
		CGValuedElement instanceKey = cgFunction.getBody();
		if (instanceKey == null) {
			/*instanceKey =*/ QVTiCGUtil.getAST(cgFunction).getImplementationClass();
			//	nameManager.queueValueName(instanceKey, instanceName);
		}
		else {
			//	nameManager.declareStandardName(instanceKey, instanceName)
			instanceName.addSecondaryElement(instanceKey);
		}
		return instanceName.getResolvedName();
	}

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)getVariablesStack().getParameter(asFunctionParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			analyzer.setNames(cgFunctionParameter, asFunctionParameter);
			setAst(cgFunctionParameter, asFunctionParameter);
			cgFunctionParameter.setTypeId(analyzer.getTypeId(asFunctionParameter.getTypeId()));
			if (asFunctionParameter.isIsRequired()) {
				cgFunctionParameter.setNonNull();
			}
			addParameter(asFunctionParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull VariableDeclaration asVariable) {
		CGGuardVariable cgGuardVariable = (CGGuardVariable) getVariablesStack().getParameter(asVariable);
		assert cgGuardVariable == null;
		boolean isConnectionVariable = asVariable instanceof ConnectionVariable;
		boolean isPrimitiveVariable = QVTimperativeUtil.isPrimitiveVariable(asVariable);	// FIXME obsolete ??
		if (isConnectionVariable) {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGConnectionVariable();
		}
		else {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
		}
		analyzer.setNames(cgGuardVariable, asVariable);
		setAst(cgGuardVariable, asVariable);
		cgGuardVariable.setTypeId(analyzer.getTypeId(asVariable.getTypeId()));
		if (!isConnectionVariable && !isPrimitiveVariable) {
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
		}
		addParameter(asVariable, cgGuardVariable);
		return cgGuardVariable;
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull NewStatement pNewStatement) {
		Variables variablesStack = getVariablesStack();
		CGVariable cgVariable2 = variablesStack.getVariable(pNewStatement);
		CGRealizedVariable cgVariable = (CGRealizedVariable) cgVariable2;
		if (cgVariable == null) {
			EClassifier eClassifier = getEClassifier(pNewStatement.getType());
			if (eClassifier != null) {
				CGEcoreRealizedVariable cgEcoreRealizedVariable = QVTiCGModelFactory.eINSTANCE.createCGEcoreRealizedVariable();
				cgEcoreRealizedVariable.setEClassifier(eClassifier);
				cgVariable = cgEcoreRealizedVariable;
			}
			if (cgVariable == null) {
				cgVariable = QVTiCGModelFactory.eINSTANCE.createCGRealizedVariable();
			}
			setAst(cgVariable, pNewStatement);
			TypedModel asTypedModel = ClassUtil.nonNullState(pNewStatement.getReferredTypedModel());
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
			cgVariable.setTypedModel(cgTypedModel);
			variablesStack.putVariable(pNewStatement, cgVariable);
		}
		return cgVariable;
	}

	protected @NonNull CGTypedModel getTypedModel(@NonNull VariableDeclaration pVariable) {
		if (pVariable instanceof GuardParameter) {
			TypedModel referredTypedModel = ClassUtil.nonNullState(((GuardParameter)pVariable).getReferredTypedModel());
			return ClassUtil.nonNullState(analyzer.getTypedModel(referredTypedModel));
		}
		Transformation pTransformation = QVTimperativeUtil.getContainingTransformation(pVariable);
		TypedModel asTypedModel = ClassUtil.nonNullState(pTransformation.getModelParameter(null));
		return ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
	}

	@Override
	protected @Nullable CGValuedElement inlineOperationCall(@NonNull OperationCallExp callExp, @NonNull LanguageExpression specification) {
		CGValuedElement cgInlineOperationCall = super.inlineOperationCall(callExp, specification);
		if (cgInlineOperationCall != null) {
			//
			//	We need to follow the path from an inlined property call to thge outer statement to mark the
			//	outer statement as observing the property. The OCL CG leaves the inline code as orphans, so
			//	add an adapter to workaround the broken containment path.
			//
			Element asInlineOperationCall = cgInlineOperationCall.getAst();
			asInlineOperationCall.eAdapters().add(new InlinedBodyAdapter(callExp));
		}
		return cgInlineOperationCall;
	}

	//	@Override
	@Deprecated
	protected boolean isEcoreProperty(@NonNull LibraryProperty libraryProperty) {
		return (libraryProperty instanceof ExplicitNavigationProperty)
				|| (libraryProperty instanceof CompositionProperty)
				|| (libraryProperty instanceof ImplicitNonCompositionProperty);		// FIXME surely this isn't Ecore
		//		|| (libraryProperty instanceof StaticProperty)
		//		|| (libraryProperty instanceof StereotypeProperty)
		//		|| (libraryProperty instanceof ConstrainedProperty);
	}

	@Override
	protected boolean isQualifiedThis(@NonNull VariableExp asVariableExp, @NonNull Parameter asParameter) {
		assert asParameter == PivotUtil.getReferredVariable(asVariableExp);
		assert isThis(asParameter);
		Type currentType = PivotUtil.getContainingType(asVariableExp);
		Mapping currentMapping = QVTimperativeUtil.basicGetContainingMapping(asVariableExp);
		Operation currentOperation = QVTimperativeUtil.basicGetContainingOperation(asVariableExp);
		Type referencedType = PivotUtil.getContainingType(asParameter);  // FIXME Mappings
		return (currentType != referencedType) || (currentMapping != null) || (currentOperation != null);
	}

	/**
	 * Return true if asParameter is a 'this' parameter.
	 */
	@Override
	protected boolean isThis(@NonNull Parameter asParameter) {
		EStructuralFeature eContainingFeature = asParameter.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			return true;
		}
		return super.isThis(asParameter);
	}

	@Override
	public @Nullable CGNamedElement visitAddStatement(@NonNull AddStatement asAddStatement) {
		ConnectionVariable asVariable = asAddStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asAddStatement.getOwnedExpression();
		assert cgVariable instanceof CGConnectionVariable;
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		CGConnectionAssignment cgConnectionAssignment = QVTiCGModelFactory.eINSTANCE.createCGConnectionAssignment();
		cgConnectionAssignment.setConnectionVariable(cgVariable);
		cgConnectionAssignment.setOwnedInitValue(initValue);
		cgConnectionAssignment.setTypeId(initValue.getTypeId());
		cgConnectionAssignment.setRequired(initValue.isRequired());
		return cgConnectionAssignment;
	}

	@Override
	public @Nullable CGNamedElement visitAppendParameter(@NonNull AppendParameter object) {
		return visiting(object);		// Really should not be happening.
		/*		CGVariable cgVariable = getVariable(asConnectionVariable);
		return cgVariable; */
	}

	@Override
	public @Nullable CGNamedElement visitAppendParameterBinding(@NonNull AppendParameterBinding asAppendParameterBinding) {
		VariableDeclaration asBoundVariable = asAppendParameterBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		//		setPivot(cgMappingCallBinding, asAppendParameterBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asAppendParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		ConnectionVariable asVariable = asAppendParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgVariableExp, ClassUtil.nonNullModel(asVariable));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitBufferStatement(@NonNull BufferStatement asVariable) {
		/*		CGVariable cgVariable = getVariable(asConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asConnectionVariable.getOwnedExpression());
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; */
		OCLExpression asInit = asVariable.getOwnedExpression();
		CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();		// ?? FIXME Use ConnectionVariable
		cgAccumulator.setAst(asVariable);
		cgAccumulator.setName(asVariable.getName());
		if (asInit != null) {
			CGValuedElement cgInit = doVisit(CGValuedElement.class, asInit);
			TypeId typeId = asInit.getTypeId();
			if (typeId instanceof CollectionTypeId) {
				typeId = ((CollectionTypeId)typeId).getElementTypeId();
			}
			cgAccumulator.setTypeId(analyzer.getTypeId(typeId));
			cgAccumulator.setInit(cgInit);
			//							cgAccumulator.setRequired(true);
		}
		else {
			cgAccumulator.setTypeId(analyzer.getTypeId(asVariable.getTypeId()));
		}
		cgAccumulator.setNonNull();
		getBodyBuilder().addAccumulator(cgAccumulator);
		getVariablesStack().putVariable(asVariable, cgAccumulator);
		return null;
	}

	@Override
	public @Nullable CGNamedElement visitCheckStatement(@NonNull CheckStatement asPredicate) {
		CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
		cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgPredicate.setRequired(true);
		OCLExpression asConditionExpression = asPredicate.getOwnedExpression();
		assert asConditionExpression != null;
		cgPredicate.setCondition(doVisit(CGValuedElement.class, asConditionExpression));
		CGConstantExp cgElse = analyzer.createCGConstantExp(asConditionExpression, analyzer.getBoolean(false));
		setAst(cgElse, asConditionExpression);
		cgElse.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
		cgElse.setRequired(true);
		cgPredicate.setElseExpression(cgElse);
		getBodyBuilder().appendSubTree(cgPredicate);
		return null;
	}

	/*	@Override
	public @Nullable CGNamedElement visitCheckVariableStatement(@NonNull CheckVariableStatement asCheckVariableStatement) {
		/*		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asCheckVariableStatement.getOwnedExpression();
		assert !(cgVariable instanceof CGConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; * /
		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		OCLExpression asInit = asCheckVariableStatement.getOwnedExpression();
		assert (asVariable != null) && (asInit != null);
		getBodyBuilder().appendCheckedLetVariable(asVariable, asInit);
		return null;
	} */

	@Override
	public @Nullable CGNamedElement visitCompoundTargetElement(@NonNull CompoundTargetElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visiting(object);
	}

	@Override
	public CGNamedElement visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		OCLExpression asInit = asVariable.getOwnedExpression();
		assert asInit != null;
		if (!asVariable.isIsCheck()) {
			/*		CGVariable cgVariable = getVariable(asVariable);
			CGValuedElement initValue = doVisit(CGValuedElement.class, asVariable.getOwnedExpression());
			cgVariable.setInit(initValue);
			cgVariable.setTypeId(initValue.getTypeId());
			cgVariable.setRequired(initValue.isRequired());
			return cgVariable; */
			getBodyBuilder().appendCheckedLetVariable(asVariable, asInit);
		}
		else {
			CGValuedElement cgExpression = doVisit(CGValuedElement.class, asInit);
			cgExpression.setName("temp1_" + asVariable.getName());
			//
			CGFinalVariable cgUncastVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			cgUncastVariable.setName("temp2_" + asVariable.getName());
			cgUncastVariable.setInit(cgExpression);
			cgUncastVariable.setTypeId(cgExpression.getTypeId());
			cgUncastVariable.setRequired(cgExpression.isRequired());
			//
			CGLetExp cgOuterLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			setAst(cgOuterLetExp, asVariable);
			cgOuterLetExp.setInit(cgUncastVariable);
			cgOuterLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgOuterLetExp.setRequired(true);
			//
			CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
			cgPredicate.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgPredicate.setRequired(true);
			CGConstantExp cgElse = analyzer.createCGConstantExp(asInit, analyzer.getBoolean(false));
			setAst(cgElse, asVariable);
			cgElse.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgElse.setRequired(true);
			cgPredicate.setElseExpression(cgElse);
			CGIsKindOfExp cgIsKindOfExp = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
			cgIsKindOfExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgIsKindOfExp.setRequired(true);
			CGVariableExp cgUncastVariableExp1 = CGModelFactory.eINSTANCE.createCGVariableExp();
			setAst(cgUncastVariableExp1, asVariable);
			cgUncastVariableExp1.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp1.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp1.setRequired(cgUncastVariable.isRequired());
			cgIsKindOfExp.setSource(cgUncastVariableExp1);

			CGExecutorType cgExecutorType = analyzer.createExecutorType(ClassUtil.nonNullState(asVariable.getType()));
			cgIsKindOfExp.setExecutorType(cgExecutorType);
			cgPredicate.setCondition(cgIsKindOfExp);
			cgOuterLetExp.setIn(cgPredicate);

			CGVariableExp cgUncastVariableExp2 = CGModelFactory.eINSTANCE.createCGVariableExp();
			setAst(cgUncastVariableExp2, asVariable);
			cgUncastVariableExp2.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp2.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp2.setRequired(cgUncastVariable.isRequired());
			CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
			cgCastExp.setSource(cgUncastVariableExp2);
			cgCastExp.setExecutorType(cgExecutorType);
			TypeId asTypeId = cgExecutorType.getASTypeId();
			assert asTypeId != null;
			cgCastExp.setTypeId(analyzer.getTypeId(asTypeId));

			CGFinalVariable cgCastVariable = (CGFinalVariable) createCGVariable(asVariable);		// FIXME Lose cast
			cgCastVariable.setInit(cgCastExp);

			CGLetExp cgCastLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			setAst(cgCastLetExp, asVariable);
			cgCastLetExp.setInit(cgCastVariable);
			cgCastLetExp.setTypeId(analyzer.getTypeId(TypeId.BOOLEAN));
			cgCastLetExp.setRequired(true);

			cgPredicate.setThenExpression(cgCastLetExp);
			getBodyBuilder().appendSubTree(cgCastLetExp);
		}
		return null;
	}

	/*	@Override
	public @Nullable CGNamedElement visitCheckVariableStatement(@NonNull CheckVariableStatement asCheckVariableStatement) {
		/*		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asCheckVariableStatement.getOwnedExpression();
		assert !(cgVariable instanceof CGConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; * /
		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		OCLExpression asInit = asCheckVariableStatement.getOwnedExpression();
		assert (asVariable != null) && (asInit != null);
		getBodyBuilder().appendCheckedLetVariable(asVariable, asInit);
		return null;
	} */

	@Override
	public @Nullable CGNamedElement visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitEntryPoint(@NonNull EntryPoint pEntryPoint) {
		return visitMapping(pEntryPoint);
	}

	@Override
	public @Nullable CGNamedElement visitFunction(@NonNull Function asFunction) {
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		pushLocalContext(cgFunction, asFunction);
		cgFunction.setRequired(asFunction.isIsRequired());
		for (Parameter pParameter : asFunction.getOwnedParameters()) {
			cgFunction.getParameters().add(doVisit(CGParameter.class, pParameter));
		}
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		String implementationClass = asFunction.getImplementationClass();
		if (query != null) {
			//			try {
			//				ExpressionInOCL query = metamodelManager.parseSpecification(specification);
			//				Variable contextVariable = query.getOwnedContext();
			//				if (contextVariable != null) {
			//					getParameter(contextVariable);
			//				}
			//				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : query.getOwnedParameters()) {
			//					getParameter(parameterVariable);
			//				}
			cgFunction.setBody(doVisit(CGValuedElement.class, query)); //.getOwnedBody()));
			//			} catch (ParserException e) {
			// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
		} else if (implementationClass != null) {
			ClassNotFoundException cnfe = null;
			Class<?> functionClass = null;
			for (@NonNull ClassLoader classLoader : metamodelManager.getImplementationManager().getClassLoaders()) {
				try {
					functionClass = classLoader.loadClass(implementationClass);
					cnfe = null;
					break;
				} catch (ClassNotFoundException e) {
					if (cnfe == null) {
						cnfe = e;
					}
				}
			}
			if (cnfe != null) {
				throw new IllegalStateException("Load class failure for " + implementationClass + " in QVTiAS2CGVisitor.visitFunction()", cnfe);
			}
			assert functionClass != null;
			//			ClassLoader classLoader = asFunction.getClass().getClassLoader();
			Object implementationInstance;
			try {
				Field implementationField = functionClass.getField("INSTANCE");
				implementationInstance = implementationField.get(null);
			}
			catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
			Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asFunction);
			VariableDeclaration asThis = QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
			VariableExp asThisExp = PivotUtil.createVariableExp(asThis);
			CGValuedElement cgSource = doVisit(CGValuedElement.class, asThisExp);
			CGLibraryOperationCallExp cgLibraryOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
			cgLibraryOperationCallExp.setSource(cgSource);
			//	cgLibraryOperationCallExp.setTypeId(value);
			//	cgLibraryOperationCallExp.setThisIsSelf(true);
			OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
			asOperationCallExp.setReferredOperation(asFunction);
			asOperationCallExp.setOwnedSource(asThisExp);
			asOperationCallExp.setName(asFunction.getName());
			asOperationCallExp.setType(asFunction.getType());
			setAst(cgLibraryOperationCallExp, asOperationCallExp);
			for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
				VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
				asOperationCallExp.getOwnedArguments().add(asParameterExp);
				CGValuedElement cgArgument = doVisit(CGValuedElement.class, asParameterExp);
				cgLibraryOperationCallExp.getArguments().add(cgArgument);
			}
			//	for (@NonNull OCLExpression pArgument : ClassUtil.nullFree(element.getOwnedArguments())) {
			//		CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
			//		cgNativeOperationCallExp.getArguments().add(cgArgument);
			//	}
			cgLibraryOperationCallExp.setReferredOperation(asFunction);
			cgLibraryOperationCallExp.setLibraryOperation((LibraryOperation)implementationInstance);
			cgFunction.setBody(cgLibraryOperationCallExp); //.getOwnedBody()));
			String instanceName = getFunctionInstanceName(cgFunction);
			cgLibraryOperationCallExp.setName(instanceName);
			//				final CGTypeId resultType = cgFunction.getTypeId();
			//	Function asFunction = QVTiCGUtil.getAST(cgFunction);
			//	TypeDescriptor functionTypeDescriptor = context.getTypeDescriptor(cgFunction).getEcoreDescriptor(context, null);
			//	js.append("/* " + localContext.getIdResolverVariable(cgFunction) + "*/");

			//	functionTypeDescriptor.appendBox(js, localContext, cgFunction, cgFunction);
			/*	js.appendClassReference(null, ValueUtil.class);
					js.append(".createSetValue(");
					js.appendValueName(resultType);
					js.append(", "); * /
					js.append(asFunction.getImplementationClass());
					js.append(".INSTANCE.evaluate(");
					js.append(JavaConstants.EXECUTOR_NAME);
					js.append(", ");
					js.appendValueName(resultType);
					for (@NonNull CGParameter cgParameter : QVTiCGUtil.getParameters(cgFunction)) {
						js.append(", ");
						js.appendValueName(cgParameter);
					}
					//	js.append(")");
					js.append(");\n");
					js.appendThis(functionName);
					js.append("." + instanceName + " = ");
					js.appendValueName(cgFunction);
					js.append(";\n");
			 */
			//	}

		}
		analyzer.addFunction(asFunction, cgFunction);
		popLocalContext(cgFunction);
		return cgFunction;
	}

	@Override
	public @Nullable CGNamedElement visitFunctionBody(@NonNull FunctionBody object) {
		return super.visitExpressionInOCL(object);
	}

	@Override
	public @Nullable CGNamedElement visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		return getFunctionParameter(asFunctionParameter);
	}

	@Override
	public @Nullable CGNamedElement visitGuardParameter(@NonNull GuardParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitGuardParameterBinding(@NonNull GuardParameterBinding asGuardParameterBinding) {
		VariableDeclaration asBoundVariable = asGuardParameterBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asGuardParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		ConnectionVariable asVariable = asGuardParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgVariableExp, ClassUtil.nonNullModel(asVariable));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeTransformation(@NonNull ImperativeTransformation asTransformation) {
		/*QVTiTransformationAnalysis entryPointsAnalysis =*/ analyzer.getCodeGenerator().getEntryPointsAnalysis(asTransformation);
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		pushLocalContext(cgTransformation, asTransformation);
		List<CGTypedModel> cgTypedModels = cgTransformation.getOwnedTypedModels();
		for (@NonNull TypedModel asTypedModel : QVTimperativeUtil.getModelParameters(asTransformation)) {
			CGTypedModel cgTypedModel = doVisit(CGTypedModel.class, asTypedModel);
			cgTypedModel.setModelIndex(cgTypedModels.size());
			cgTypedModels.add(cgTypedModel);
		}
		Set<@NonNull Mapping> useClasses = computeUseClasses(asTransformation);
		for (@NonNull Mapping asMapping : QVTimperativeUtil.getOwnedMappings(asTransformation)) {
			CGMapping cgMapping = doVisit(CGMapping.class, asMapping);
			cgTransformation.getOwnedMappings().add(cgMapping);
			if (useClasses.contains(asMapping)) {
				cgMapping.setUseClass(true);
			}
		}
		for (Operation asOperation : asTransformation.getOwnedOperations()) {
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		popLocalContext(cgTransformation);
		return cgTransformation;
	}

	@Override
	public @Nullable CGNamedElement visitLoopParameterBinding(@NonNull LoopParameterBinding asLoopParameterBinding) {
		VariableDeclaration asBoundVariable = asLoopParameterBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asLoopParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		LoopVariable asVariable = asLoopParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		setAst(cgVariableExp, ClassUtil.nonNullModel(asVariable));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitLoopVariable(@NonNull LoopVariable asVariable) {
		return visiting(asVariable);
	}

	@Override
	public @Nullable CGNamedElement visitMapping(@NonNull Mapping asMapping) {
		@SuppressWarnings("unused")String name = asMapping.getName();
		CGMapping cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
		pushLocalContext(cgMapping, asMapping);
		analyzer.addMapping(asMapping, cgMapping);
		PredicateTreeBuilder bodyBuilder2 = bodyBuilder = new PredicateTreeBuilder(asMapping, cgMapping);
		bodyBuilder2.doBottoms();

		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
		List<@NonNull CGGuardVariable> sortedVariables = new ArrayList<>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		bodyBuilder = null;
		popLocalContext(cgMapping);
		return cgMapping;
	}

	@Override
	public CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		setAst(cgMappingCall, asMappingCall);
		List<@NonNull CGMappingCallBinding> cgMappingCallBindings = new ArrayList<>();
		for (@NonNull MappingParameterBinding asMappingCallBinding : QVTimperativeUtil.getOwnedMappingParameterBindings(asMappingCall)) {
			CGMappingCallBinding cgMappingCallBinding = doVisit(CGMappingCallBinding.class, asMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, CGMappingCallBindingComparator.INSTANCE);
		cgMappingCall.getOwnedMappingCallBindings().addAll(cgMappingCallBindings);
		return cgMappingCall;
	}

	@Override
	public CGNamedElement visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		CGMappingLoop cgMappingLoop = QVTiCGModelFactory.eINSTANCE.createCGMappingLoop();
		List<LoopVariable> asIterators = asMappingLoop.getOwnedIterators();
		if (asIterators.size() > 0) {
			LoopVariable asIterator = asIterators.get(0);
			if (asIterator != null) {
				CGIterator cgIterator = getIterator(asIterator);
				cgIterator.setTypeId(analyzer.getTypeId(asIterator.getTypeId()));
				cgIterator.setRequired(asIterator.isIsRequired());
				if (asIterator.isIsRequired()) {
					cgIterator.setNonNull();
				}
				cgMappingLoop.getIterators().add(cgIterator);
			}
		}
		cgMappingLoop.setSource(doVisit(CGValuedElement.class, asMappingLoop.getOwnedExpression()));
		//		cgIterator.setNonInvalid();
		//		cgIterator.setNonNull();
		cgMappingLoop.setAst(asMappingLoop);
		CollectionType collectionType = standardLibrary.getCollectionType();
		Operation forAllIteration = NameUtil.getNameable(collectionType.getOwnedOperations(), "forAll");
		cgMappingLoop.setReferredIteration((Iteration) forAllIteration);
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<CGValuedElement> cgMappingStatements = cgSequence.getOwnedStatements();
		for (MappingStatement asMappingStatement : asMappingLoop.getOwnedMappingStatements()) {
			CGValuedElement cgMappingStatement = doVisit(CGValuedElement.class, asMappingStatement);
			cgMappingStatements.add(cgMappingStatement);
		}
		cgMappingLoop.setBody(cgSequence);
		return cgMappingLoop;
	}

	@Override
	public CGNamedElement visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);
	}

	@Override
	public CGNamedElement visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitNewStatement(@NonNull NewStatement asNewStatement) {
		OCLExpression asInit = asNewStatement.getOwnedExpression();
		if (asInit == null) {
			CGRealizedVariable CGRealizedVariable = getBodyBuilder().addRealizedVariable(asNewStatement);
			CGExecutorType cgExecutorType = context.createExecutorType(ClassUtil.nonNullState(asNewStatement.getType()));
			getNameManager().declareStandardName(cgExecutorType);
			CGRealizedVariable.setExecutorType(cgExecutorType);
			cgExecutorType.setTypeId(codeGenerator.getAnalyzer().getTypeId(asNewStatement.getTypeId()));			// FIXME promote
			List<@NonNull NewStatementPart> asParts = new ArrayList<>(ClassUtil.nullFree(asNewStatement.getOwnedParts()));
			Collections.sort(asParts, NameUtil.NAMEABLE_COMPARATOR);
			List<@NonNull CGRealizedVariablePart> cgParts = ClassUtil.nullFree(CGRealizedVariable.getOwnedParts());		// Ensure deterministic CGShadowPart order
			for (@NonNull NewStatementPart asPart : asParts) {
				cgParts.add(doVisit(CGRealizedVariablePart.class, asPart));
			}
		}
		else {
			getBodyBuilder().appendCheckedLetVariable(asNewStatement, asInit);
		}
		return null;
	}

	@Override
	public @Nullable CGNamedElement visitNewStatementPart(@NonNull NewStatementPart element) {
		CGRealizedVariablePart cgRealizedVariablePart = QVTiCGModelFactory.eINSTANCE.createCGRealizedVariablePart();
		setAst(cgRealizedVariablePart, element);
		cgRealizedVariablePart.setInit(doVisit(CGValuedElement.class, element.getOwnedExpression()));
		Property asProperty = element.getReferredProperty();
		if (asProperty != null) {
			CGExecutorProperty cgExecutorProperty = context.createExecutorProperty(asProperty);
			getNameManager().declareStandardName(cgExecutorProperty);
			cgRealizedVariablePart.setExecutorProperty(cgExecutorProperty);
			cgExecutorProperty.setTypeId(codeGenerator.getAnalyzer().getTypeId(asProperty.getTypeId()));			// FIXME promote
		}
		return cgRealizedVariablePart;
	}

	@Override
	public CGNamedElement visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitPredicate(@NonNull Predicate object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitSetStatement(@NonNull SetStatement asSetStatement) {
		ImperativeTransformation asTransformation = QVTimperativeUtil.getContainingTransformation(asSetStatement);
		EntryPointsAnalysis entryPointsAnalysis = analyzer.getCodeGenerator().getEntryPointsAnalysis(asTransformation);
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(asSetStatement);
		if (cacheIndex != null) {
			//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
			setAst(cgPropertyAssignment, asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = getVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgVariable));
			Property asProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			cgPropertyAssignment.setReferredProperty(asProperty);
			//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
			//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
				} catch (GenModelException e) {
					codeGenerator.addProblem(e);
					//					System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
				}
			}
			return cgPropertyAssignment;
		}
		else {
			Property asTargetProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			LibraryProperty libraryProperty = metamodelManager.getImplementation(asSetStatement, null, asTargetProperty);
			CGPropertyAssignment cgPropertyAssignment = null;
			if (isEcoreProperty(libraryProperty)) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature) asTargetProperty.getESObject();
				if (eStructuralFeature != null) {
					try {
						genModelHelper.getGetAccessor(eStructuralFeature);
						CGEcorePropertyAssignment cgEcorePropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGEcorePropertyAssignment();
						cgEcorePropertyAssignment.setEStructuralFeature(eStructuralFeature);
						cgPropertyAssignment = cgEcorePropertyAssignment;
					} catch (GenModelException e) {
						codeGenerator.addProblem(e);
						//						System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
					}
				}
				else {
					Property asOppositeProperty = asTargetProperty.getOpposite();
					eStructuralFeature = (EStructuralFeature) (asOppositeProperty != null ? asOppositeProperty.getESObject() : null);
					if (eStructuralFeature != null) {
						assert ((EReference)eStructuralFeature).isContainment();
						try {
							genModelHelper.getGetAccessor(eStructuralFeature);
							CGEcoreContainerAssignment cgEcoreContainerAssignment = QVTiCGModelFactory.eINSTANCE.createCGEcoreContainerAssignment();
							cgEcoreContainerAssignment.setEStructuralFeature(eStructuralFeature);
							cgPropertyAssignment = cgEcoreContainerAssignment;
						} catch (GenModelException e) {
							codeGenerator.addProblem(e);
							//							System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
						}
					}
				}
			}
			if (cgPropertyAssignment == null) {
				cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			}
			setAst(cgPropertyAssignment, asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = getVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgVariable));
			cgPropertyAssignment.setReferredProperty(asTargetProperty);
			//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
			//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));

			CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asTargetProperty);
			cgPropertyAssignment.setExecutorProperty(cgExecutorProperty);
			return cgPropertyAssignment;
		}
	}

	@Override
	public @Nullable CGNamedElement visitSimpleTargetElement(@NonNull SimpleTargetElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitSimpleParameter(@NonNull SimpleParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitSimpleParameterBinding(@NonNull SimpleParameterBinding asSimpleParameterBinding) {
		VariableDeclaration asBoundVariable = asSimpleParameterBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asSimpleParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		cgMappingCallBinding.setOwnedValue(doVisit(CGValuedElement.class, asSimpleParameterBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitSpeculateStatement(@NonNull SpeculateStatement asSpeculateStatement) {
		CGSpeculateExp cgSpeculateExp = QVTiCGModelFactory.eINSTANCE.createCGSpeculateExp();
		setAst(cgSpeculateExp, asSpeculateStatement);
		for (@NonNull OCLExpression asExpression : ClassUtil.nullFree(asSpeculateStatement.getOwnedExpressions())) {
			CGEcorePropertyCallExp cgArgument = doVisit(CGEcorePropertyCallExp.class, asExpression);
			CGSpeculatePart cgSpeculatePart = QVTiCGModelFactory.eINSTANCE.createCGSpeculatePart();
			cgSpeculatePart.setObjectExp(cgArgument.getSource());
			cgSpeculatePart.setEStructuralFeature(cgArgument.getEStructuralFeature());
			cgSpeculateExp.getParts().add(cgSpeculatePart);
		}
		getBodyBuilder().appendSubTree(cgSpeculateExp);
		return null;
	}

	@Override
	public CGNamedElement visitStatement(@NonNull Statement object) {
		return visiting(object);
	}

	/*	@Override
	public @Nullable CGNamedElement visitCheckVariableStatement(@NonNull CheckVariableStatement asCheckVariableStatement) {
		/*		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asCheckVariableStatement.getOwnedExpression();
		assert !(cgVariable instanceof CGConnectionVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; * /
		VariableDeclaration asVariable = asCheckVariableStatement.getTargetVariable();
		OCLExpression asInit = asCheckVariableStatement.getOwnedExpression();
		assert (asVariable != null) && (asInit != null);
		getBodyBuilder().appendCheckedLetVariable(asVariable, asInit);
		return null;
	} */

	@Override
	public @Nullable CGNamedElement visitTarget(@NonNull Target object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitTargetElement(@NonNull TargetElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitTransformation(@NonNull Transformation object) {
		return visiting(object);		// Should be ImperativeTransformation
	}

	@Override
	public @Nullable CGNamedElement visitTypedModel(@NonNull TypedModel asTypedModel) {
		CGTypedModel cgTypedModel = QVTiCGModelFactory.eINSTANCE.createCGTypedModel();
		setAst(cgTypedModel, asTypedModel);
		analyzer.addTypedModel(asTypedModel, cgTypedModel);
		return cgTypedModel;
	}

	@Override
	public @Nullable CGNamedElement visitVariable(@NonNull Variable object) {
		return visiting(object);		// Really should not be happening.
		/*		CGVariable cgVariable = getVariable(asVariable);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asVariable.getOwnedExpression());
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; */
	}

	@Override
	public @Nullable CGNamedElement visitVariableDeclaration(@NonNull VariableDeclaration object) {
		return visiting(object);		// Really should not be happening.
	}

	@Override
	public @Nullable CGNamedElement visitVariableStatement(@NonNull VariableStatement object) {
		return visiting(object);
	}
}
