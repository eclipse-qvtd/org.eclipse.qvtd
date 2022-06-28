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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.analyzer.NestedNameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.library.CompositionProperty;
import org.eclipse.ocl.pivot.internal.library.ExplicitNavigationProperty;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.java.FunctionOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiNestedNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
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
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
			cgMappingExp.setAst(asMapping);
			TypeId pivotTypeId = TypeId.BOOLEAN; //pMapping.getTypeId();
			cgMappingExp.setTypeId(analyzer.getCGTypeId(pivotTypeId));
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
				cgRawVariable.setAst(asInit);
				cgRawVariable.setTypeId(analyzer.getCGTypeId(asInit.getTypeId()));
				cgRawVariable.setInit(cgInit);
				//	cgRawVariable.setName("raw_" + asVariable.getName());
				//	getNameManager().declareLazyName(cgRawVariable);
				//
				CGLetExp cgRawLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
				cgRawLetExp.setAst(asInit);
				cgRawLetExp.setTypeId(analyzer.getCGTypeId(asInit.getTypeId()));
				cgRawLetExp.setInit(cgRawVariable);
				//				cgRawLetExp.setIn(cgIn);
				cgRawLetExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
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
					cgCastExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
					cgInit = cgCastExp;
				}
				else {
					cgInit = analyzer.createCGVariableExp(cgRawVariable);
				}
			}
			CGFinalVariable cgVariable = getNameManager().createCGVariable(asVariable);
			cgVariable.setInit(cgInit);
			CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgLetExp.setAst(asVariable);
			cgLetExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgLetExp.setInit(cgVariable);
			cgLetExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
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
			cgCondition.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			//			cgCondition.setInvalidating(false);
			//			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asVariable);
			cgIfExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			//			cgIfExp.setName(cgVariable.getName());
			cgIfExp.setCondition(cgCondition);
			//			cgIfExp.setThenExpression(cgUnsafeExp);
			cgIfExp.setElseExpression(analyzer.createCGConstantExp(analyzer.getCGBoolean(false)));
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
			cgCondition.setArgument(analyzer.createCGConstantExp(analyzer.getCGNull()));
			//			setAst(cgCondition, asExpression);
			cgCondition.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			cgCondition.setInvalidating(false);
			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asExpression);
			cgIfExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			//	cgIfExp.setName(cgVariable.getName());
			cgIfExp.setCondition(cgCondition);
			cgIfExp.setElseExpression(analyzer.createCGConstantExp(analyzer.getCGBoolean(false)));
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

	//	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private @Nullable PredicateTreeBuilder bodyBuilder;

	public QVTiAS2CGVisitor(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		//		this.analyzer = codeGenerator.getAnalyzer();
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

	/*	protected <T extends EObject> @NonNull T createCopy(@NonNull T aPrototype) {
		Copier copier = new EcoreUtil.Copier();
		EObject aCopy = copier.copy(aPrototype);
		assert aCopy != null;
		copier.copyReferences();
		@SuppressWarnings("unchecked") T castCopy = (T) aCopy;
		return castCopy;
	} */

	protected @NonNull CGMapping generateMappingDeclaration(@NonNull Mapping asMapping) {
		@SuppressWarnings("unused")String name = asMapping.getName();
		QVTiAnalyzer analyzer = getAnalyzer();
		CGMapping cgMapping = analyzer.basicGetCGMapping(asMapping);
		if (cgMapping == null) {
			cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
			cgMapping.setAst(asMapping);
			globalNameManager.declareGlobalName(cgMapping, asMapping.getName());
			analyzer.addCGMapping(cgMapping);
		}
		return cgMapping;
	}

	@Override
	public @NonNull CGOperation generateOperationDeclaration(@NonNull Operation asOperation, boolean requireFinal) {
		if (!requireFinal && (asOperation instanceof Function)) {			// XXX ??? eliminate override
			Function asFunction = (Function)asOperation;
			QVTiAnalyzer analyzer = getAnalyzer();
			CGFunction cgFunction = analyzer.basicGetCGFunction(asFunction);
			if (cgFunction == null) {
				FunctionOperationCallingConvention callingConvention = (FunctionOperationCallingConvention)context.getCallingConvention(asFunction, true);
				CGClass cgClass = generateClassDeclaration(PivotUtil.getOwningClass(asOperation), callingConvention.getClassCallingConvention());
				pushClassNameManager(cgClass);
				cgFunction = callingConvention.createCGOperation(this, asFunction);
				assert cgFunction.getAst() != null;
				assert cgFunction.getCallingConvention() == callingConvention;
				pushNestedNameManager(cgFunction);
				callingConvention.createCGParameters(this, cgFunction, (ExpressionInOCL)asFunction.getBodyExpression());
				analyzer.addCGFunction(cgFunction);
				popNestedNameManager();
				popClassNameManager();
			}
			return cgFunction;
		}
		return super.generateOperationDeclaration(asOperation, requireFinal);
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
					//					Boolean ecoreIsRequired = context.isNonNull(asProperty);
					//					if (ecoreIsRequired != null) {
					//						isRequired = ecoreIsRequired;
					//					}
					isRequired = asProperty.isIsRequired();
					cgPropertyCallExp = cgEcorePropertyCallExp;
				} catch (GenModelException e) {
					context.addProblem(e);		// FIXME drop through to better default
				}
				if (cgPropertyCallExp == null) {
					CGExecutorPropertyCallExp cgExecutorPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorPropertyCallExp();
					//	CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asProperty);
					CGProperty cgExecutorProperty = generatePropertyDeclaration(asProperty, null);
					cgExecutorPropertyCallExp.setReferredProperty(cgExecutorProperty);
					cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
					cgPropertyCallExp = cgExecutorPropertyCallExp;
				}
				CGProperty cgProperty = generatePropertyDeclaration(asProperty, null);
				cgPropertyCallExp.setAsProperty(asProperty);
				cgPropertyCallExp.setReferredProperty(cgProperty);
				cgPropertyCallExp.setAst(element);
				cgPropertyCallExp.setTypeId(analyzer.getCGTypeId(element.getTypeId()));
				cgPropertyCallExp.setRequired(isRequired || context.isPrimitive(cgPropertyCallExp));
				cgPropertyCallExp.setSource(cgSource);
				return cgPropertyCallExp;
			}
		}
		assert (cgSource == null) == asProperty.isIsStatic();
		return super.generatePropertyCallExp(cgSource, element);
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer)analyzer;
	}

	private @NonNull PredicateTreeBuilder getBodyBuilder() {
		assert bodyBuilder != null;
		return bodyBuilder;
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator)context;
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
		NameResolution instanceName = globalNameManager.getInstanceNameResolution();
		CGValuedElement instanceKey = cgFunction.getBody();
		if (instanceKey == null) {
			/*instanceKey =*/ QVTiCGUtil.getAST(cgFunction).getImplementationClass();
			//	nameManager.queueValueName(instanceKey, instanceName);
		}
		else {
			//	nameManager.declareStandardName(instanceKey, instanceName)
			instanceName.addCGElement(instanceKey);
		}
		return instanceName.getResolvedName();
	}

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		NestedNameManager nameManager = getNameManager();
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)nameManager.basicGetParameter(asFunctionParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			cgFunctionParameter.setAst(asFunctionParameter);
			//	cgFunctionParameter.setTypeId(analyzer.getCGTypeId(asFunctionParameter.getTypeId()));
			//	nameManager.declarePreferredName(cgFunctionParameter);
			cgFunctionParameter.setTypeId(analyzer.getCGTypeId(asFunctionParameter.getTypeId()));
			if (asFunctionParameter.isIsRequired()) {
				cgFunctionParameter.setNonNull();
			}
			nameManager.addVariable(asFunctionParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull VariableDeclaration asVariable) {
		NestedNameManager nameManager = getNameManager();
		CGGuardVariable cgGuardVariable = (CGGuardVariable)nameManager.basicGetParameter(asVariable);
		assert cgGuardVariable == null;
		boolean isConnectionVariable = asVariable instanceof ConnectionVariable;
		boolean isPrimitiveVariable = QVTimperativeUtil.isPrimitiveVariable(asVariable);	// FIXME obsolete ??
		if (isConnectionVariable) {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGConnectionVariable();
		}
		else {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
		}
		cgGuardVariable.setAst(asVariable);
		cgGuardVariable.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
		//	nameManager.declarePreferredName(cgGuardVariable);
		if (!isConnectionVariable && !isPrimitiveVariable) {
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
		}
		nameManager.addVariable(asVariable, cgGuardVariable);
		return cgGuardVariable;
	}

	//	@Override
	//	public @NonNull QVTiLocalContext getLocalContext() {
	//		return (QVTiLocalContext)super.getLocalContext();
	//	}

	@Override
	public @NonNull QVTiNestedNameManager getNameManager() {
		return (QVTiNestedNameManager)super.getNameManager();
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull NewStatement asNewStatement) {
		QVTiAnalyzer analyzer = getAnalyzer();
		NestedNameManager nameManager = getNameManager();
		CGVariable cgVariable2 = nameManager.basicGetVariable(asNewStatement);
		CGRealizedVariable cgVariable = (CGRealizedVariable) cgVariable2;
		if (cgVariable == null) {
			EClassifier eClassifier = getEClassifier(asNewStatement.getType());
			if (eClassifier != null) {
				CGEcoreRealizedVariable cgEcoreRealizedVariable = QVTiCGModelFactory.eINSTANCE.createCGEcoreRealizedVariable();
				cgEcoreRealizedVariable.setEClassifier(eClassifier);
				cgVariable = cgEcoreRealizedVariable;
			}
			if (cgVariable == null) {
				cgVariable = QVTiCGModelFactory.eINSTANCE.createCGRealizedVariable();
			}
			cgVariable.setAst(asNewStatement);
			cgVariable.setTypeId(analyzer.getCGTypeId(asNewStatement.getTypeId()));
			//	nameManager.declarePreferredName(cgVariable);
			TypedModel asTypedModel = ClassUtil.nonNullState(asNewStatement.getReferredTypedModel());
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
			cgVariable.setTypedModel(cgTypedModel);
			nameManager.addVariable(asNewStatement, cgVariable);
		}
		return cgVariable;
	}

	protected @NonNull CGTypedModel getTypedModel(@NonNull VariableDeclaration pVariable) {
		QVTiAnalyzer analyzer = getAnalyzer();
		if (pVariable instanceof GuardParameter) {
			TypedModel referredTypedModel = ClassUtil.nonNullState(((GuardParameter)pVariable).getReferredTypedModel());
			return ClassUtil.nonNullState(analyzer.getTypedModel(referredTypedModel));
		}
		Transformation pTransformation = QVTimperativeUtil.getContainingTransformation(pVariable);
		TypedModel asTypedModel = ClassUtil.nonNullState(pTransformation.getModelParameter(null));
		return ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
	}

	@Override
	public @Nullable CGValuedElement inlineOperationCall(@NonNull OperationCallExp callExp, @NonNull LanguageExpression specification) {
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

	/*	@Override
	protected boolean isQualifiedThis(@NonNull VariableExp asVariableExp, @NonNull Parameter asParameter) {
		assert asParameter == PivotUtil.getReferredVariable(asVariableExp);
		assert isThis(asParameter);
		Type currentType = PivotUtil.getContainingType(asVariableExp);
		Mapping currentMapping = QVTimperativeUtil.basicGetContainingMapping(asVariableExp);
		Operation currentOperation = QVTimperativeUtil.basicGetContainingOperation(asVariableExp);
		Type referencedType = PivotUtil.getContainingType(asParameter);  // FIXME Mappings
		return (currentType != referencedType) || (currentMapping != null) || (currentOperation != null);
	} */

	/**
	 * Return true if asParameter is a 'this' parameter.
	 *
	@Override
	protected boolean isThis(@NonNull Parameter asParameter) {
		EStructuralFeature eContainingFeature = asParameter.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			return true;
		}
		return super.isThis(asParameter);
	} */

	@Override
	public @Nullable CGNamedElement visitAddStatement(@NonNull AddStatement asAddStatement) {
		ConnectionVariable asVariable = asAddStatement.getTargetVariable();
		if (asVariable == null) {
			return null;
		}
		CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
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
		//	cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asAppendParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		ConnectionVariable asVariable = asAppendParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		cgVariableExp.setAst(asVariable);
		cgVariableExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getCGTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitBufferStatement(@NonNull BufferStatement asVariable) {
		NestedNameManager nameManager = getNameManager();
		OCLExpression asInit = asVariable.getOwnedExpression();
		CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();		// ?? FIXME Use ConnectionVariable
		cgAccumulator.setAst(asVariable);
		//	nameManager.declarePreferredName(cgAccumulator);
		//	cgAccumulator.setName(asVariable.getName());
		if (asInit != null) {
			CGValuedElement cgInit = doVisit(CGValuedElement.class, asInit);
			TypeId typeId = asInit.getTypeId();
			if (typeId instanceof CollectionTypeId) {
				typeId = ((CollectionTypeId)typeId).getElementTypeId();
			}
			cgAccumulator.setTypeId(analyzer.getCGTypeId(typeId));
			cgAccumulator.setInit(cgInit);
			//							cgAccumulator.setRequired(true);
		}
		else {
			cgAccumulator.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
		}
		cgAccumulator.setNonNull();
		cgAccumulator.setNonInvalid();
		getBodyBuilder().addAccumulator(cgAccumulator);
		nameManager.addVariable(asVariable, cgAccumulator);
		return null;
	}

	@Override
	public @Nullable CGNamedElement visitCheckStatement(@NonNull CheckStatement asPredicate) {
		CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
		cgPredicate.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
		cgPredicate.setRequired(true);
		OCLExpression asConditionExpression = asPredicate.getOwnedExpression();
		assert asConditionExpression != null;
		cgPredicate.setCondition(doVisit(CGValuedElement.class, asConditionExpression));
		CGConstantExp cgElse = analyzer.createCGConstantExp(asConditionExpression, analyzer.getCGBoolean(false));
		cgElse.setAst(asConditionExpression);
		cgElse.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
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
			//	cgExpression.setName("temp1_" + asVariable.getName());
			//
			CGFinalVariable cgUncastVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			//	cgUncastVariable.setName("temp2_" + asVariable.getName());
			cgUncastVariable.setInit(cgExpression);
			cgUncastVariable.setTypeId(cgExpression.getTypeId());
			cgUncastVariable.setRequired(cgExpression.isRequired());
			//	getNameManager().declareLazyName(cgUncastVariable);
			//
			CGLetExp cgOuterLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgOuterLetExp.setAst(asVariable);
			cgOuterLetExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgOuterLetExp.setInit(cgUncastVariable);
			cgOuterLetExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			cgOuterLetExp.setRequired(true);
			//
			CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
			cgPredicate.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			cgPredicate.setRequired(true);
			CGConstantExp cgElse = analyzer.createCGConstantExp(asInit, analyzer.getCGBoolean(false));
			cgElse.setAst(asVariable);
			cgElse.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgElse.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			cgElse.setRequired(true);
			cgPredicate.setElseExpression(cgElse);
			CGIsKindOfExp cgIsKindOfExp = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
			cgIsKindOfExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
			cgIsKindOfExp.setRequired(true);
			CGVariableExp cgUncastVariableExp1 = CGModelFactory.eINSTANCE.createCGVariableExp();
			cgUncastVariableExp1.setAst(asVariable);
			cgUncastVariableExp1.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgUncastVariableExp1.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp1.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp1.setRequired(cgUncastVariable.isRequired());
			cgIsKindOfExp.setSource(cgUncastVariableExp1);

			CGExecutorType cgExecutorType = analyzer.createExecutorType(ClassUtil.nonNullState(asVariable.getType()));
			cgIsKindOfExp.setExecutorType(cgExecutorType);
			cgPredicate.setCondition(cgIsKindOfExp);
			cgOuterLetExp.setIn(cgPredicate);

			CGVariableExp cgUncastVariableExp2 = CGModelFactory.eINSTANCE.createCGVariableExp();
			cgUncastVariableExp2.setAst(asVariable);
			cgUncastVariableExp2.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgUncastVariableExp2.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp2.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp2.setRequired(cgUncastVariable.isRequired());
			CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
			cgCastExp.setSource(cgUncastVariableExp2);
			cgCastExp.setExecutorType(cgExecutorType);
			TypeId asTypeId = cgExecutorType.getASTypeId();
			assert asTypeId != null;
			cgCastExp.setTypeId(analyzer.getCGTypeId(asTypeId));

			CGFinalVariable cgCastVariable = getNameManager().createCGVariable(asVariable);
			cgCastVariable.setInit(cgCastExp);

			CGLetExp cgCastLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgCastLetExp.setAst(asVariable);
			cgCastLetExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
			cgCastLetExp.setInit(cgCastVariable);
			cgCastLetExp.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
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
		CGFunction cgFunction = (CGFunction)generateOperationDeclaration(asFunction, true);
		FunctionOperationCallingConvention callingConvention = (FunctionOperationCallingConvention)cgFunction.getCallingConvention();
		pushNestedNameManager(cgFunction);
		callingConvention.createCGBody(this, cgFunction);
		//	cgFunction.setRequired(asFunction.isIsRequired());
		/*		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		//	callingConvention.createCGParameters(this, cgFunction, null);
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
			//	cgFunction.setBody(doVisit(CGValuedElement.class, query)); //.getOwnedBody()));
			callingConvention.createCGBody(this, cgFunction);
			//			} catch (ParserException e) {
			// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
		}
		else if (implementationClass != null) {
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
			LibraryOperation libraryOperation;
			try {
				Field implementationField = functionClass.getField("INSTANCE");
				libraryOperation = (LibraryOperation)implementationField.get(null);
				assert libraryOperation != null;
			}
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
			Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asFunction);
			VariableDeclaration asThis = QVTbaseUtil.getContextVariable(standardLibrary, asTransformation);
			VariableExp asThisExp = PivotUtil.createVariableExp(asThis);
			CGValuedElement cgSource = doVisit(CGValuedElement.class, asThisExp);




			//	CGLibraryOperationCallExp cgLibraryOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
			//	cgLibraryOperationCallExp.getArguments().add(cgSource);
			//	cgLibraryOperationCallExp.setTypeId(value);
			//	cgLibraryOperationCallExp.setThisIsSelf(true);
			OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
			asOperationCallExp.setReferredOperation(asFunction);
			asOperationCallExp.setOwnedSource(asThisExp);
			asOperationCallExp.setName(asFunction.getName());
			asOperationCallExp.setType(asFunction.getType());
			for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
				VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
				asOperationCallExp.getOwnedArguments().add(asParameterExp);
				//	CGValuedElement cgArgument = doVisit(CGValuedElement.class, asParameterExp);
				//	CGFunctionCallExp.getArguments().add(cgArgument);
			}
			//	CGCallExp cgFunctionCallExp = LibraryOperationCallingConvention.INSTANCE.createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
			CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)callingConvention.createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
			//	cgLibraryOperationCallExp.setAst(asOperationCallExp);
			//	cgLibraryOperationCallExp.setTypeId(analyzer.getCGTypeId(asOperationCallExp.getTypeId()));
			//	for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
			//		VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			//		asOperationCallExp.getOwnedArguments().add(asParameterExp);
			//		CGValuedElement cgArgument = doVisit(CGValuedElement.class, asParameterExp);
			//		CGFunctionCallExp.getArguments().add(cgArgument);
			//	}
			//	for (@NonNull OCLExpression pArgument : ClassUtil.nullFree(element.getOwnedArguments())) {
			//		CGValuedElement cgArgument = doVisit(CGValuedElement.class, pArgument);
			//		cgNativeOperationCallExp.getArguments().add(cgArgument);
			//	}
			//	CGFunctionCallExp.setLibraryOperation(libraryOperation);
			//	cgFunctionCallExp.setReferredOperation(cgFunction);
			cgFunction.setBody(cgFunctionCallExp); //.getOwnedBody()));				// XXX is this line used (by testQVTrCompiler_ATL2QVTr_CG) - it seems like an infinite recursion
			//	callingConvention.createCGBody(this, cgFunction, query);
			//	String instanceName = getFunctionInstanceName(cgFunction);				// XXX redundant ??
			//	cgFunctionCallExp.setName(instanceName);								// XXX redundant ??
			//				final CGTypeId resultType = cgFunction.getTypeId();
			//	Function asFunction = QVTiCGUtil.getAST(cgFunction);
			//	TypeDescriptor functionTypeDescriptor = analyzer.getTypeDescriptor(cgFunction).getEcoreDescriptor(analyzer, null);
			//	js.append("/ * " + localContext.getIdResolverVariable(cgFunction) + "* /");

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
		 * /
			//	}

		}
		//	analyzer.addFunction(asFunction, cgFunction); */
		popNestedNameManager();
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
		//	cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asGuardParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		ConnectionVariable asVariable = asGuardParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		cgVariableExp.setAst(asVariable);
		cgVariableExp.setTypeId(analyzer.getCGTypeId(asVariable.getTypeId()));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getCGTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeTransformation(@NonNull ImperativeTransformation asTransformation) {
		QVTiAnalyzer analyzer = getAnalyzer();
		/*QVTiTransformationAnalysis entryPointsAnalysis =*/ analyzer.getCodeGenerator().getEntryPointsAnalysis(asTransformation);
		CGTransformation cgTransformation = QVTiCGModelFactory.eINSTANCE.createCGTransformation();
		cgTransformation.setAst(asTransformation);
		globalNameManager.declareGlobalName(cgTransformation, asTransformation.getName());
		analyzer.setCGRootClass(cgTransformation);			// set TransformationCallingConvention
		pushClassNameManager(cgTransformation);
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
		for (Operation asOperation : asTransformation.getOwnedOperations()) {			// Why omit properties / nested classes ?
			CGOperation cgOperation = doVisit(CGOperation.class, asOperation);
			cgTransformation.getOperations().add(cgOperation);
		}
		popClassNameManager();
		return cgTransformation;
	}

	@Override
	public @Nullable CGNamedElement visitLoopParameterBinding(@NonNull LoopParameterBinding asLoopParameterBinding) {
		VariableDeclaration asBoundVariable = asLoopParameterBinding.getBoundVariable();
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		//		setPivot(cgMappingCallBinding, asMappingCallBinding);
		//	cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asLoopParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		LoopVariable asVariable = asLoopParameterBinding.getValue();
		assert asVariable != null;
		CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		cgVariableExp.setAst(ClassUtil.nonNullModel(asVariable));
		cgVariableExp.setReferredVariable(cgVariable);
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		cgMappingCallBinding.setTypeId(analyzer.getCGTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitLoopVariable(@NonNull LoopVariable asVariable) {
		return visiting(asVariable);
	}

	@Override
	public @Nullable CGNamedElement visitMapping(@NonNull Mapping asMapping) {
		CGMapping cgMapping = generateMappingDeclaration(asMapping);
		pushNestedNameManager(cgMapping);
		PredicateTreeBuilder bodyBuilder2 = bodyBuilder = new PredicateTreeBuilder(asMapping, cgMapping);
		bodyBuilder2.doBottoms();
		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
		List<@NonNull CGGuardVariable> sortedVariables = new ArrayList<>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		bodyBuilder = null;
		popNestedNameManager();
		return cgMapping;
	}

	@Override
	public CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		cgMappingCall.setAst(asMappingCall);
		Mapping asMapping = QVTimperativeUtil.getReferredMapping(asMappingCall);
		CGMapping cgMapping = generateMappingDeclaration(asMapping);
		cgMappingCall.setReferredMapping(cgMapping);
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
		cgMappingLoop.setAst(asMappingLoop);
		OCLExpression asSource = asMappingLoop.getOwnedExpression();
		cgMappingLoop.setSource(doVisit(CGValuedElement.class, asSource));
		NestedNameManager nameManager = pushNestedNameManager(cgMappingLoop);
		List<LoopVariable> asIterators = asMappingLoop.getOwnedIterators();
		if (asIterators.size() > 0) {
			LoopVariable asIterator = asIterators.get(0);
			if (asIterator != null) {
				CGIterator cgIterator = nameManager.getIterator(asIterator);
				cgIterator.setTypeId(analyzer.getCGTypeId(asIterator.getTypeId()));		// XXX why repeat ???
				cgIterator.setRequired(asIterator.isIsRequired());
				if (asIterator.isIsRequired()) {
					cgIterator.setNonNull();
				}
				cgMappingLoop.getIterators().add(cgIterator);
			}
		}
		//		cgIterator.setNonInvalid();
		//		cgIterator.setNonNull();
		CollectionType collectionType = standardLibrary.getCollectionType();
		Iteration forAllIteration = (Iteration)NameUtil.getNameable(collectionType.getOwnedOperations(), "forAll");
		assert forAllIteration != null;
		cgMappingLoop.setAsIteration(forAllIteration);
		cgMappingLoop.setReferredIteration(generateIterationDeclaration(asSource.getType(), forAllIteration));
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<CGValuedElement> cgMappingStatements = cgSequence.getOwnedStatements();
		for (MappingStatement asMappingStatement : asMappingLoop.getOwnedMappingStatements()) {
			CGValuedElement cgMappingStatement = doVisit(CGValuedElement.class, asMappingStatement);
			cgMappingStatements.add(cgMappingStatement);
		}
		cgMappingLoop.setBody(cgSequence);
		popNestedNameManager();
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
			CGExecutorType cgExecutorType = analyzer.createExecutorType(ClassUtil.nonNullState(asNewStatement.getType()));
			//	getNameManager().declareStandardName(cgExecutorType);
			CGRealizedVariable.setExecutorType(cgExecutorType);
			cgExecutorType.setTypeId(analyzer.getCGTypeId(asNewStatement.getTypeId()));			// FIXME promote
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
		cgRealizedVariablePart.setAst(element);
		cgRealizedVariablePart.setInit(doVisit(CGValuedElement.class, element.getOwnedExpression()));
		Property asProperty = element.getReferredProperty();
		if (asProperty != null) {
			//	CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asProperty);
			CGProperty cgExecutorProperty = generatePropertyDeclaration(asProperty, null);
			//	getNameManager().declareStandardName(cgExecutorProperty);
			cgRealizedVariablePart.setReferredProperty(cgExecutorProperty);
			cgExecutorProperty.setTypeId(analyzer.getCGTypeId(asProperty.getTypeId()));			// FIXME promote
			analyzer.addExternalFeature(asProperty);
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
		QVTiAnalyzer analyzer = getAnalyzer();
		ImperativeTransformation asTransformation = QVTimperativeUtil.getContainingTransformation(asSetStatement);
		EntryPointsAnalysis entryPointsAnalysis = analyzer.getCodeGenerator().getEntryPointsAnalysis(asTransformation);
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(asSetStatement);
		if (cacheIndex != null) {
			//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
			cgPropertyAssignment.setAst(asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgVariable));
			Property asProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			cgPropertyAssignment.setAsProperty(asProperty);
			//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getCGTypeId(TypeId.OCL_VOID));
			//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				try {
					genModelHelper.getGetAccessor(eStructuralFeature);
					cgPropertyAssignment.setEStructuralFeature(eStructuralFeature);
				} catch (GenModelException e) {
					context.addProblem(e);
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
						context.addProblem(e);
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
							context.addProblem(e);
							//							System.out.println("Missing getAccessor for " + eStructuralFeature + "ignored : " + e.getMessage());
						}
					}
				}
			}
			if (cgPropertyAssignment == null) {
				cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			}
			cgPropertyAssignment.setAst(asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = getNameManager().getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgVariable));
			cgPropertyAssignment.setAsProperty(asTargetProperty);
			//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(analyzer.getCGTypeId(TypeId.OCL_VOID));
			//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(doVisit(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			//	CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asTargetProperty);
			CGProperty cgTargetProperty = generatePropertyDeclaration(asTargetProperty, null);
			cgPropertyAssignment.setReferredProperty(cgTargetProperty);
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
		//	cgMappingCallBinding.setName(asBoundVariable.getName());
		cgMappingCallBinding.setAst(asSimpleParameterBinding);
		cgMappingCallBinding.setRequired(asBoundVariable.isIsRequired());
		cgMappingCallBinding.setOwnedValue(doVisit(CGValuedElement.class, asSimpleParameterBinding.getValue()));
		cgMappingCallBinding.setTypeId(analyzer.getCGTypeId(asBoundVariable.getTypeId()));
		//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitSpeculateStatement(@NonNull SpeculateStatement asSpeculateStatement) {
		CGSpeculateExp cgSpeculateExp = QVTiCGModelFactory.eINSTANCE.createCGSpeculateExp();
		cgSpeculateExp.setAst(asSpeculateStatement);
		for (@NonNull OCLExpression asExpression : ClassUtil.nullFree(asSpeculateStatement.getOwnedExpressions())) {
			CGEcorePropertyCallExp cgArgument = doVisit(CGEcorePropertyCallExp.class, asExpression);
			CGSpeculatePart cgSpeculatePart = QVTiCGModelFactory.eINSTANCE.createCGSpeculatePart();
			CGValuedElement cgSource = cgArgument.getSource();
			PivotUtilInternal.resetContainer(cgSource);
			cgSpeculatePart.setObjectExp(cgSource);
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
		cgTypedModel.setAst(asTypedModel);
		globalNameManager.declareGlobalName(cgTypedModel, asTypedModel.getName());
		getAnalyzer().addCGTypedModel(cgTypedModel);
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
