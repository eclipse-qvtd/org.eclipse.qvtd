/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsKindOfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
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
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.analysis.QVTimperativeDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
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

		public void addRealizedVariable(@NonNull NewStatement asNewStatement) {
			List<@NonNull CGValuedElement> cgRealizedVariables = ClassUtil.nullFree(cgMappingExp.getRealizedVariables());
			CGRealizedVariable cgVariable = getRealizedVariable(asNewStatement);
			cgRealizedVariables.add(cgVariable);
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
			if (cgMapping.getBody() == null) {
				cgMapping.setBody(cgElementRoot);
			}
			if (cgLeafExp instanceof CGLetExp) {
				((CGLetExp)cgLeafExp).setIn(cgElementRoot);
			}
			else if (cgLeafExp instanceof CGIfExp) {
				((CGIfExp)cgLeafExp).setThenExpression(cgElementRoot);
			}
			else {
				assert cgLeafExp == null;
			}
			cgLeafExp = cgElement;
		}

		public void doBottoms() {
			List<@NonNull CGGuardVariable> cgFreeVariables = new ArrayList<>();
			for (@NonNull MappingParameter pMappingParameter : ClassUtil.nullFree(asMapping.getOwnedParameters())) {
				cgFreeVariables.add(getGuardVariable(pMappingParameter));
			}
			Collections.sort(cgFreeVariables, NameUtil.NAMEABLE_COMPARATOR);
			cgMapping.getFreeVariables().addAll(cgFreeVariables);
			CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
			List<CGValuedElement> cgMappingStatements = cgSequence.getStatements();
			for (@NonNull Statement asStatement : ClassUtil.nullFree(asMapping.getOwnedStatements())) {
				CGNamedElement cgElement = asStatement.accept(QVTiAS2CGVisitor.this);
				if (cgElement != null) {	// FIXME some statements do a more complex appendSubTree
					cgMappingStatements.add((CGValuedElement) cgElement);
				}
			}
			appendSubTree(cgMappingExp);
			cgMappingExp.setBody(cgSequence);
		}

		@Override
		public String toString() {
			return String.valueOf(cgMapping.getBody());
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

	@Override
	protected <T extends EObject> @NonNull T createCopy(@NonNull T aPrototype) {
		Copier copier = new EcoreUtil.Copier();
		EObject aCopy = copier.copy(aPrototype);
		assert aCopy != null;
		copier.copyReferences();
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(aPrototype);
		if (asTransformation != null) {
			//			System.out.println("Copying " + aPrototype);
			QVTiCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			QVTiTransformationAnalysis transformationAnalysis = codeGenerator.getTransformationAnalysis(asTransformation);
			QVTimperativeDomainUsageAnalysis domainUsageAnalysis = transformationAnalysis.getDomainUsageAnalysis();
			for (EObject prototypeEObject : copier.keySet()) {
				EObject clonedEObject = copier.get(prototypeEObject);
				assert clonedEObject != null;
				DomainUsage usage = domainUsageAnalysis.basicGetUsage((Element)prototypeEObject);
				//				System.out.println("    " + prototypeEObject.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(prototypeEObject)) + " => " + usage + " : " + prototypeEObject);
				if (usage != null) {
					//					System.out.println("    " + clonedEObject.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(clonedEObject)) + " <= " + usage + " : " + clonedEObject);
					domainUsageAnalysis.setUsage((Element) clonedEObject, usage);
				}
			}
		}
		@SuppressWarnings("unchecked") T castCopy = (T) aCopy;
		return castCopy;
	}

	/*	protected @NonNull CGValuedElement generateMiddlePropertyCallExp(@NonNull CGValuedElement cgSource, @NonNull MiddlePropertyCallExp asMiddlePropertyCallExp) {
		Property asOppositeProperty = ClassUtil.nonNullModel(asMiddlePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		globalContext.addToMiddleProperty(asOppositeProperty);
//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
		CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();
//		CGExecutorProperty cgExecutorProperty = analyzer.getExecutorProperty(asProperty);
//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
//		cgPropertyCallExp = cgExecutorPropertyCallExp;
//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(asOppositeProperty);
		setAst(cgPropertyCallExp, asMiddlePropertyCallExp);
		cgPropertyCallExp.setRequired(asProperty.isIsRequired());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	} */

	@Override
	protected @NonNull CGValuedElement generateOperationCallExp(@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		Operation pOperation = asOperationCallExp.getReferredOperation();
		if (pOperation instanceof Function) {
			if (cgSource == null) {			// FIXME workaround for BUG 481664
				Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asOperationCallExp);
				if (asTransformation != null) {
					VariableDeclaration asThis = QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
					VariableExp asThisExp = PivotUtil.createVariableExp(asThis);
					cgSource = doVisit(CGValuedElement.class, asThisExp);
				}
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
		boolean isPrimitiveVariable = QVTimperativeUtil.isPrimitiveVariable(asVariable);
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
		Domain pDomain = QVTimperativeUtil.getContainingDomain(pVariable);
		TypedModel asTypedModel = null;
		if (pDomain != null) {
			asTypedModel = ClassUtil.nonNullState(pDomain.getTypedModel());
		}
		else {
			Transformation pTransformation = QVTimperativeUtil.getContainingTransformation(pVariable);
			assert pTransformation != null;
			asTypedModel = ClassUtil.nonNullState(pTransformation.getModelParameter(null));
		}
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

	@Override
	public @Nullable CGNamedElement visitAddStatement(@NonNull AddStatement asAddStatement) {
		ConnectionVariable asVariable = asAddStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getVariable(asVariable);
		OCLExpression asInitValue = asAddStatement.getOwnedExpression();
		assert (cgVariable instanceof CGConnectionVariable) || (cgVariable instanceof CGAccumulator);
		CGValuedElement initValue = doVisit(CGValuedElement.class, asInitValue);
		CGConnectionAssignment cgConnectionAssignment = QVTiCGModelFactory.eINSTANCE.createCGConnectionAssignment();
		cgConnectionAssignment.setConnectionVariable(cgVariable);
		cgConnectionAssignment.setInitValue(initValue);
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
		cgMappingCallBinding.setValue(cgVariableExp);
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
		CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();
		cgAccumulator.setAst(asVariable);
		cgAccumulator.setName(asVariable.getName());
		if (asInit != null) {
			CGValuedElement cgInit = doVisit(CGValuedElement.class, asInit);
			cgAccumulator.setTypeId(cgInit.getTypeId());
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
	public @Nullable CGNamedElement visitFunction(@NonNull Function asFunction) {
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		setAst(cgFunction, asFunction);
		cgFunction.setRequired(asFunction.isIsRequired());
		for (Parameter pParameter : asFunction.getOwnedParameters()) {
			cgFunction.getParameters().add(doVisit(CGParameter.class, pParameter));
		}
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
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
		}
		analyzer.addFunction(asFunction, cgFunction);
		return cgFunction;
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
		cgMappingCallBinding.setValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeTypedModel(@NonNull ImperativeTypedModel asTypedModel) {
		CGTypedModel cgTypedModel = QVTiCGModelFactory.eINSTANCE.createCGTypedModel();
		setAst(cgTypedModel, asTypedModel);
		analyzer.addTypedModel(asTypedModel, cgTypedModel);
		return cgTypedModel;
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
		cgMappingCallBinding.setValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitLoopVariable(@NonNull LoopVariable asVariable) {
		return visiting(asVariable);
	}

	@Override
	public @Nullable CGNamedElement visitMapping(@NonNull Mapping pMapping) {
		@SuppressWarnings("unused")String name = pMapping.getName();
		CGMapping cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
		setAst(cgMapping, pMapping);
		analyzer.addMapping(pMapping, cgMapping);
		PredicateTreeBuilder bodyBuilder2 = bodyBuilder = new PredicateTreeBuilder(pMapping, cgMapping);
		bodyBuilder2.doBottoms();

		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getFreeVariables());
		List<@NonNull CGGuardVariable> sortedVariables = new ArrayList<>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		bodyBuilder = null;
		return cgMapping;
	}

	@Override
	public CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		setAst(cgMappingCall, asMappingCall);
		List<@NonNull CGMappingCallBinding> cgMappingCallBindings = new ArrayList<>();
		for (MappingParameterBinding asMappingCallBinding : asMappingCall.getBinding()) {
			CGMappingCallBinding cgMappingCallBinding = doVisit(CGMappingCallBinding.class, asMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, CGMappingCallBindingComparator.INSTANCE);
		cgMappingCall.getMappingCallBindings().addAll(cgMappingCallBindings);
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
		List<CGValuedElement> cgMappingStatements = cgSequence.getStatements();
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
			getBodyBuilder().addRealizedVariable(asNewStatement);
		}
		else {
			getBodyBuilder().appendCheckedLetVariable(asNewStatement, asInit);
		}
		return null;
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
		Transformation asTransformation = ClassUtil.nonNullModel(QVTbaseUtil.getContainingTransformation(asSetStatement));
		QVTiTransformationAnalysis transformationAnalysis = analyzer.getCodeGenerator().getTransformationAnalysis(asTransformation);
		Integer cacheIndex = transformationAnalysis.getCacheIndex(asSetStatement);
		if (cacheIndex != null) {
			//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
			setAst(cgPropertyAssignment, asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = getVariable(asVariable);
			cgPropertyAssignment.setSlotValue(analyzer.createCGVariableExp(cgVariable));
			Property asProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			cgPropertyAssignment.setReferredProperty(asProperty);
			//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
			//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
				} catch (GenModelException e) {
					System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
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
						System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
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
							System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
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
			cgPropertyAssignment.setSlotValue(analyzer.createCGVariableExp(cgVariable));
			cgPropertyAssignment.setReferredProperty(asTargetProperty);
			//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getTypeId(TypeId.OCL_VOID));
			//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));

			CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asTargetProperty);
			cgPropertyAssignment.setExecutorProperty(cgExecutorProperty);
			return cgPropertyAssignment;
		}
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
		cgMappingCallBinding.setValue(doVisit(CGValuedElement.class, asSimpleParameterBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public CGNamedElement visitStatement(@NonNull Statement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitTransformation(@NonNull Transformation asTransformation) {
		/*QVTiTransformationAnalysis transformationAnalysis =*/ analyzer.getCodeGenerator().getTransformationAnalysis(asTransformation);
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		setAst(cgTransformation, asTransformation);
		pushCurrentClass(cgTransformation);
		List<CGTypedModel> cgTypedModels = cgTransformation.getTypedModels();
		for (TypedModel asTypedModel : asTransformation.getModelParameter()) {
			CGTypedModel cgTypedModel = doVisit(CGTypedModel.class, asTypedModel);
			cgTypedModel.setModelIndex(cgTypedModels.size());
			cgTypedModels.add(cgTypedModel);
		}
		for (Rule asRule : asTransformation.getRule()) {
			CGMapping cgMapping = doVisit(CGMapping.class, asRule);
			cgTransformation.getMappings().add(cgMapping);
		}
		for (Operation asOperation : asTransformation.getOwnedOperations()) {
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		popCurrentClass(cgTransformation);
		return cgTransformation;
	}

	@Override
	public CGNamedElement visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);		// Should be ImperativeTypedModel
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
