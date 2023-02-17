/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreContainerAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSequence;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.CompositionProperty;
import org.eclipse.ocl.pivot.internal.library.ExplicitNavigationProperty;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor.CGVariableComparator;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor.InlinedBodyAdapter;
import org.eclipse.qvtd.codegen.qvti.calling.RuleCacheClassCallingConvention;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Lists;

public class QVTiAnalyzer extends CodeGenAnalyzer
{
	/**
	 * CreationCache describes the AS class and instance that cache distinct creations of a trace class.
	 *
	 * ?? is it actually necessary to distingusish different typed models ??
	 */
	public static class CreationCache extends AbstractCache
	{
		private @NonNull TypedModel asTypedModel;
		private @NonNull CGExecutorType cgExecutorType;
		private @NonNull List<@NonNull NewStatementPart> sortedASParts;
		private @NonNull List<@NonNull Property> asProperties;

		protected CreationCache(@NonNull TypedModel asTypedModel, @NonNull CGExecutorType cgExecutorType, @NonNull Iterable<@NonNull NewStatementPart> asParts, @NonNull Property asCacheInstance, org.eclipse.ocl.pivot.@NonNull Class asEntryClass) {
			super(asCacheInstance, asEntryClass);
			this.asTypedModel = asTypedModel;
			this.cgExecutorType = cgExecutorType;
			List<@NonNull NewStatementPart> sortedASParts = Lists.newArrayList(asParts);
			Collections.sort(sortedASParts, NameUtil.NAMEABLE_COMPARATOR);
			this.sortedASParts = sortedASParts;
			List<@NonNull Property> asProperties = new ArrayList<>();
			for (NewStatementPart asPart : sortedASParts) {
				asProperties.add(QVTimperativeUtil.getReferredProperty(asPart));
			}
			this.asProperties = asProperties;
		}

		public @NonNull CGExecutorType getExecutorType() {
			return cgExecutorType;
		}

		public @NonNull List<@NonNull Property> getProperties() {
			return asProperties;
		}

		public @NonNull List<@NonNull NewStatementPart> getSortedASParts() {
			return sortedASParts;
		}

		public @NonNull TypedModel getTypedModel() {
			return asTypedModel;
		}
	}

	/**
	 * A CachedInstance identifies the characteristics of a shared mapping invocation.
	 *
	public class CachedInstanceData
	{
		private org.eclipse.ocl.pivot.@NonNull Class asClass;
		private @NonNull CGTypedModel cgTypedModel;
		//	private @NonNull CGExecutorType cgExecutorType;
		//	private @NonNull List<@NonNull CGProperty> cgProperties;
		private int modelIndex;

		//	protected CachedInstance(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull CGExecutorType cgExecutorType,
		//			@NonNull List<@NonNull CGProperty> cgProperties, int modelIndex) {
		//		this.asClass = asClass;
		//		this.cgExecutorType = cgExecutorType;
		//		this.cgProperties = cgProperties;
		//	}

		public CachedInstanceData(@NonNull TypedModel asTypedModel, org.eclipse.ocl.pivot.@NonNull Class asClass) {
			this.asTypedModel = asTypedModel;
			this.asClass = asClass;
			this.cgTypedModel = getCGTypedModel(asTypedModel);
			this.modelIndex = cgTypedModel.getModelIndex();
		}

		public void check(@NonNull List<@NonNull CGProperty> cgProperties, int modelIndex) {
			// TODO Auto-generated method stub
			//		List<@NonNull CGExecutorProperty> oldProperties = cachedInstances.put(cgType, cgProperties);
			//		if (oldProperties != null) {
			//			assert oldProperties.equals(cgProperties);
			//		}

		}
	} */

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

		public PredicateTreeBuilder(@NonNull CGMapping cgMapping) {
			this.cgMapping = cgMapping;
			this.asMapping = QVTiCGUtil.getAST(cgMapping);
			this.cgMappingExp = QVTiCGModelFactory.eINSTANCE.createCGMappingExp();
			cgMappingExp.setAst(asMapping);
			TypeId pivotTypeId = TypeId.BOOLEAN; //pMapping.getTypeId();
			cgMappingExp.setTypeId(getCGTypeId(pivotTypeId));
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
		public void appendCheckedLetVariable(@NonNull VariableDeclaration asVariable, @NonNull OCLExpression asInit) {
			Type sourceType = ClassUtil.nonNullState(asInit.getType());
			Type targetType = ClassUtil.nonNullState(asVariable.getType());
			boolean needsNullTest = !asInit.isIsRequired() && asVariable.isIsRequired();
			boolean needsTypeCheck = !sourceType.conformsTo(standardLibrary, targetType);
			//
			CGValuedElement cgInit = createCGElement(CGValuedElement.class, asInit);

			if (needsTypeCheck || needsNullTest) {
				CGTypeId cgTypeId = getCGTypeId(asInit.getTypeId());
				CGFinalVariable cgRawVariable = createCGFinalVariable(null, cgTypeId, asInit.isIsRequired());
				cgRawVariable.setAst(asInit);
				cgRawVariable.setInit(cgInit);
				//
				CGLetExp cgRawLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
				cgRawLetExp.setAst(asInit);
				cgRawLetExp.setTypeId(cgTypeId);
				cgRawLetExp.setInit(cgRawVariable);
				//				cgRawLetExp.setIn(cgIn);
				cgRawLetExp.setTypeId(getCGTypeId(TypeId.BOOLEAN));
				//
				appendSubTree(cgRawLetExp);
				//
				if (needsNullTest) {
					appendNonNullPredicate(cgRawVariable);
				}
				if (needsTypeCheck) {
					ExecutableNameManager executableNameManager = useExecutableNameManager(asVariable);
					CGExecutorType cgType = executableNameManager.getCGExecutorType(targetType);
					appendIsKindOfPredicate(cgRawVariable, cgType);
					CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
					cgCastExp.setSource(createCGVariableExp(cgRawVariable));
					cgCastExp.setExecutorType(cgType);
					cgCastExp.setTypeId(getCGTypeId(asVariable.getTypeId()));
					cgInit = cgCastExp;
				}
				else {
					cgInit = createCGVariableExp(cgRawVariable);
				}
			}
			CGFinalVariable cgVariable = useExecutableNameManager(asVariable).createCGVariable(asVariable);
			cgVariable.setInit(cgInit);
			CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			initAst(cgLetExp, asVariable, true);
			cgLetExp.setInit(cgVariable);
			cgLetExp.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			appendSubTree(cgLetExp);
		}

		/**
		 * Add an expression sub-tree that ensures that cgVariable conforms to cgExecutorType.
		 */
		private void appendIsKindOfPredicate(@NonNull CGFinalVariable cgVariable, @NonNull CGExecutorType cgExecutorType) {
			@NonNull CGIsKindOfExp cgCondition = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
			cgCondition.setSource(createCGVariableExp(cgVariable));
			cgCondition.setExecutorType(cgExecutorType);
			//			setAst(cgCondition, asVariable);
			cgCondition.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			//			cgCondition.setInvalidating(false);
			//			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asVariable);
			cgIfExp.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			//			cgIfExp.setName(cgVariable.getName());
			cgIfExp.setCondition(cgCondition);
			//			cgIfExp.setThenExpression(cgUnsafeExp);
			cgIfExp.setElseExpression(createCGConstantExp(getCGBoolean(false)));
			//
			appendSubTree(cgIfExp);
		}

		/**
		 * Add an expression sub-tree that ensures that cgVariable is non-null.
		 */
		private void appendNonNullPredicate(@NonNull CGFinalVariable cgVariable) {
			CGIsEqualExp cgCondition = CGModelFactory.eINSTANCE.createCGIsEqualExp();
			cgCondition.setNotEquals(true);
			cgCondition.setSource(createCGVariableExp(cgVariable));
			cgCondition.setArgument(createCGConstantExp(getCGNull()));
			//			setAst(cgCondition, asExpression);
			cgCondition.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asExpression);
			cgIfExp.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			cgIfExp.setCondition(cgCondition);
			cgIfExp.setElseExpression(createCGConstantExp(getCGBoolean(false)));
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
		public void appendSubTree(@NonNull CGValuedElement cgElement) {
			CGValuedElement cgElementRoot = cgElement;
			while (cgElementRoot.eContainer() != null) {
				cgElementRoot = (CGValuedElement) cgElementRoot.eContainer();
			}
			if (cgMapping.getOwnedBody() == null) {
				cgMapping.setOwnedBody(cgElementRoot);
			}
			if (cgLeafExp instanceof CGLetExp) {
				CGLetExp cgLetExp = (CGLetExp)cgLeafExp;
				cgLetExp.setIn(cgElementRoot);
				cgLetExp.setRequired(cgElementRoot.isRequired());
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
			CGSequence cgSequence = CGModelFactory.eINSTANCE.createCGSequence();
			List<CGValuedElement> cgMappingStatements = cgSequence.getOwnedStatements();
			for (@NonNull Statement asStatement : ClassUtil.nullFree(asMapping.getOwnedStatements())) {
				CGNamedElement cgElement = createCGStatement(CGNamedElement.class, asStatement);
				if (cgElement != null) {	// FIXME some statements do a more complex appendSubTree
					cgMappingStatements.add((CGValuedElement) cgElement);
				}
			}
			appendSubTree(cgMappingExp);
			cgMappingExp.setOwnedBody(cgSequence);
			cgMappingExp.setRequired(true);
		}

		@Override
		public String toString() {
			return String.valueOf(cgMapping.getOwnedBody());
		}
	}

	/**
	 * Mapping from each AS Function to its corresponding CGFunction.
	 */
	//	private final @NonNull Map<@NonNull Function, @NonNull CGFunction> asFunction2cgFunctions = new HashMap<>();

	/**
	 * Mapping from each AS Mapping to its corresponding CGMapping.
	 */
	//	private final @NonNull Map<@NonNull Mapping, @NonNull CGMapping> asMapping2cgMapping = new HashMap<>();

	/**
	 * Mapping from each AS MappingLoop to its corresponding CGMappingLoop.
	 */
	//	private final @NonNull Map<@NonNull MappingLoop, @NonNull CGMappingLoop> asMappingLoop2cgMappingLoop = new HashMap<>();

	/**
	 * Mapping from each AS TypedModel to its corresponding CGTypedModel.
	 */
	//	private final @NonNull Map<@NonNull TypedModel, @NonNull CGTypedModel> asTypedModel2cgTypedModel = new HashMap<>();
	private final @Nullable TypeId originalThisTypeId;
	private final @NonNull TypeId runtimeThisTypeId;

	private @Nullable PredicateTreeBuilder bodyBuilder;
	//	private @NonNull Map<@NonNull Operation, org.eclipse.ocl.pivot.@NonNull Property> asOperation2asConstructorClass = new HashMap<>();

	/**
	 * The Trace instance class for each Trace meta class.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull CreationCache>> asTypedModel2asClass2creationCache = new HashMap<>();

	public QVTiAnalyzer(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		ImperativeTransformation iTransformation = codeGenerator.getContextClass();
		Type contextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
		if (contextClass != iTransformation) {
			originalThisTypeId = iTransformation.getTypeId();
			runtimeThisTypeId = contextClass.getTypeId();
		}
		else {
			originalThisTypeId = null;
			runtimeThisTypeId = iTransformation.getTypeId();
		}
	}

	//	public void addCGFunction(@NonNull CGFunction cgFunction) {
	//		asFunction2cgFunctions.put(QVTiCGUtil.getAST(cgFunction), cgFunction);
	//	}

	public void addCGMapping(@NonNull CGMapping cgMapping) {
		asElement2cgElement.put(QVTiCGUtil.getAST(cgMapping), cgMapping);
	}

	//	@Override
	//	public void addCGOperation(@NonNull CGOperation cgOperation) {
	//		super.addCGOperation(cgOperation);
	//		if (cgOperation instanceof CGFunction) {
	//			addCGFunction((CGFunction)cgOperation);
	//		}
	//	}

	public void addCGTypedModel(@NonNull CGTypedModel cgTypedModel) {
		CGNamedElement old = asElement2cgElement.put(QVTiCGUtil.getAST(cgTypedModel), cgTypedModel);
		assert old == null;
	}

	public @NonNull CreationCache addCacheInstance(@NonNull NewStatement asNewStatement, @NonNull Property asCacheInstance, org.eclipse.ocl.pivot.@NonNull Class asEntryClass) {
		CGRealizedVariable cgRealizedVariable = getCGRealizedVariable(asNewStatement);
		CGExecutorType cgExecutorType = QVTiCGUtil.getExecutorType(cgRealizedVariable);
		Iterable<@NonNull NewStatementPart> asParts = QVTimperativeUtil.getOwnedParts(asNewStatement);
		TypedModel asTypedModel = QVTimperativeUtil.getReferredTypedModel(asNewStatement);
		CreationCache creationCache = new CreationCache(asTypedModel, cgExecutorType, asParts, asCacheInstance, (org.eclipse.ocl.pivot.Class)asNewStatement.getType());
		addCacheInstanceInternal(creationCache);
		return creationCache;
	}

	public @Nullable CGMapping basicGetCGMapping(@NonNull Mapping asMapping) {
		return (CGMapping)asElement2cgElement.get(asMapping);
	}

	public @Nullable CGTypedModel basicGetCGTypedModel(@NonNull TypedModel asTypedModel) {
		return (CGTypedModel)asElement2cgElement.get(asTypedModel);
	}

	@Override
	protected void checkNameManager(@NonNull CGNamedElement cgElement, @NonNull NamedElement asElement) {
		if (cgElement instanceof CGMappingExp) {		// FIXME CGMappingExp has same AST as ancestral CGMapping
			//	assert cgElement.getAst() == asElement;
			//	CGMapping cgMapping = (CGMapping)cgElement.eContainer();
			//	assert cgMapping.getAst() == asElement;
			//	checkNameManager(cgMapping, asElement);
		}
		else if ((cgElement instanceof CGVariableExp) && (cgElement.eContainer() instanceof CGMappingCallBinding)) {
			// The referred variable is in the target domain and CGVariableExp cannot be folded since it might need an unbox wrapper.
		}
		else if (cgElement instanceof CGPropertyAssignment) {
			// The referred property is in the class not operation.
		}
		else {
			super.checkNameManager(cgElement, asElement);
		}
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

	public @Nullable <T extends CGElement> T createCGStatement(@NonNull Class<T> requiredClass, @Nullable Statement asElement) {
		if (asElement == null) {
			throw new NullPointerException("null source for mapping to " + requiredClass.getName());
		}
		CGNamedElement cgElement = asElement.accept(as2cgVisitor);
		//	if (cgElement == null) {
		//		throw new NullPointerException("null result of mapping to " + requiredClass.getName());
		//	}
		if (cgElement != null) {
			Class<? extends CGNamedElement> actualClass = cgElement.getClass();
			if (!requiredClass.isAssignableFrom(actualClass)) {
				throw new ClassCastException("cannot cast " + actualClass.getName() + " result of mapping to " + requiredClass.getName());
			}
			@SuppressWarnings("unchecked") T cgElement2 = (T) cgElement;
			return cgElement2;
		}
		return null;
	}

	@Override
	public @NonNull CGClass generateClass(@Nullable CGClass cgClass, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		if (!(asClass instanceof ImperativeTransformation)) {
			return super.generateClass(cgClass, asClass);
		}
		if (cgClass == null) {
			cgClass = basicGetCGClass(asClass);
			if (cgClass == null) {
				cgClass = generateClassDeclaration(asClass, null);
			}
		}
		//	getClassNameManager(cgClass, asClass);			// Nominally redundant here but needed downstream
		ImperativeTransformation asTransformation = (ImperativeTransformation)asClass;
		CGTransformation cgTransformation = (CGTransformation)cgClass;
		super.generateClass(cgTransformation, asTransformation);
		//	globalNameManager.declareGlobalName(cgTransformation, PivotUtil.getName(asTransformation));
		//	setCGRootClass(cgTransformation);			// set TransformationCallingConvention	// XXX cgRootClass
		List<CGTypedModel> cgTypedModels = cgTransformation.getOwnedTypedModels();
		for (@NonNull TypedModel asTypedModel : QVTimperativeUtil.getModelParameters(asTransformation)) {
			CGTypedModel cgTypedModel = createCGElement(CGTypedModel.class, asTypedModel);
			cgTypedModel.setModelIndex(cgTypedModels.size());
			cgTypedModels.add(cgTypedModel);
		}
		Set<@NonNull Mapping> useClasses = computeUseClasses(asTransformation);
		for (@NonNull Mapping asMapping : QVTimperativeUtil.getOwnedMappings(asTransformation)) {
			CGMapping cgMapping = createCGElement(CGMapping.class, asMapping);
			cgTransformation.getOwnedMappings().add(cgMapping);
			if (useClasses.contains(asMapping)) {
				cgMapping.setUseClass(true);
			}
		}
		//	for (Operation asOperation : asTransformation.getOwnedOperations()) {			// Why omit properties / nested classes ?
		//		CGOperation cgOperation = createCGElement(CGOperation.class, asOperation);
		//		cgTransformation.getOperations().add(cgOperation);
		//	}
		return cgTransformation;
	}

	//	@Override
	//	public @NonNull CGClass generateClassDeclaration(org.eclipse.ocl.pivot.@NonNull Class asClass, @Nullable ClassCallingConvention callingConvention) {
	// TODO Auto-generated method stub
	//		return super.generateClassDeclaration(asClass, callingConvention);
	//	}

	public @NonNull CGMapping generateMapping(@NonNull Mapping asMapping) {
		CGMapping cgMapping = generateMappingDeclaration(asMapping);
		QVTiExecutableNameManager mappingNameManager = getMappingNameManager(cgMapping, asMapping);
		//
		//	Allocate Transformation and TypedModel context variables now to allow lazy assertion to be stronger.
		//
		Transformation asTransformation = QVTbaseUtil.getOwningTransformation(asMapping);
		VariableDeclaration asContextVariable = QVTbaseUtil.getOwnedContext(asTransformation);
		/*CGVariable cgThisVariable =*/ mappingNameManager.lazyGetCGVariable(asContextVariable);			// 'contained' by QVTiExecutableNameManager
		for (@NonNull TypedModel asTypedModel : QVTimperativeUtil.getModelParameters(asTransformation)) {
			if (!asTypedModel.isIsPrimitive() && !asTypedModel.isIsThis()) {
				VariableDeclaration asContextVariable2 = asTypedModel.getOwnedContext();
				if (asContextVariable2 != null) {
					CGVariable cgTypedModelVariable = mappingNameManager.lazyGetCGVariable(asContextVariable2);	// 'contained' by QVTiExecutableNameManager
					CGTypedModel cgTypedModel = getCGTypedModel(asTypedModel);
					globalNameManager.getNameResolution(cgTypedModel).addCGElement(cgTypedModelVariable);
				}
			}
		}
		PredicateTreeBuilder bodyBuilder2 = bodyBuilder = new PredicateTreeBuilder(cgMapping);
		bodyBuilder2.doBottoms();
		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
		List<@NonNull CGGuardVariable> sortedVariables = new ArrayList<>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		bodyBuilder = null;
		return cgMapping;
	}

	public @NonNull CGMapping generateMappingDeclaration(@NonNull Mapping asMapping) {
		@SuppressWarnings("unused")String name = asMapping.getName();
		CGMapping cgMapping = basicGetCGMapping(asMapping);
		if (cgMapping == null) {
			cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
			cgMapping.setAst(asMapping);
			addCGMapping(cgMapping);
		}
		return cgMapping;
	}

	public @NonNull CGMappingLoop generateMappingLoop(@NonNull MappingLoop asMappingLoop) {
		ExecutableNameManager parentNameManager = useExecutableNameManager((NamedElement)asMappingLoop.eContainer());
		OCLExpression asSource = asMappingLoop.getOwnedExpression();
		CGValuedElement cgSource = createCGElement(CGValuedElement.class, asSource);
		globalNameManager.addSelfNameManager(cgSource, parentNameManager);										// Source always evaluated in parent context
		CGMappingLoop cgMappingLoop = QVTiCGModelFactory.eINSTANCE.createCGMappingLoop();
		cgMappingLoop.setAst(asMappingLoop);
		asElement2cgElement.put(asMappingLoop, cgMappingLoop);
		getMappingLoopNameManager(cgMappingLoop, asMappingLoop);		// eager to allow useXXX downstream
		cgMappingLoop.setSource(cgSource);
		List<LoopVariable> asIterators = asMappingLoop.getOwnedIterators();
		if (asIterators.size() > 0) {
			LoopVariable asIterator = asIterators.get(0);
			if (asIterator != null) {
				CGIterator cgIterator = useExecutableNameManager(asIterator).lazyGetIterator(asIterator);
				cgIterator.setTypeId(getCGTypeId(asIterator.getTypeId()));		// XXX why repeat ???
				cgIterator.setRequired(asIterator.isIsRequired());
				if (asIterator.isIsRequired()) {
					cgIterator.setRequired(true);
				}
				cgMappingLoop.getIterators().add(cgIterator);
			}
		}
		//		cgIterator.setNonInvalid();
		//		cgIterator.setRequired(true);
		CollectionType collectionType = getStandardLibrary().getCollectionType();
		Iteration forAllIteration = (Iteration)NameUtil.getNameable(collectionType.getOwnedOperations(), "forAll");
		assert forAllIteration != null;
		cgMappingLoop.setReferredIteration(generateIterationDeclaration(/*asSource.getType(),*/ forAllIteration));
		CGSequence cgSequence = CGModelFactory.eINSTANCE.createCGSequence();
		List<CGValuedElement> cgMappingStatements = cgSequence.getOwnedStatements();
		for (MappingStatement asMappingStatement : asMappingLoop.getOwnedMappingStatements()) {
			CGValuedElement cgMappingStatement = createCGElement(CGValuedElement.class, asMappingStatement);
			cgMappingStatements.add(cgMappingStatement);
		}
		cgMappingLoop.setBody(cgSequence);
		return cgMappingLoop;
	}

	@Override
	public @NonNull CGValuedElement generatePropertyCallExp(@Nullable CGValuedElement cgSource, @NonNull PropertyCallExp element) {
		Property asProperty = ClassUtil.nonNullModel(element.getReferredProperty());
		boolean isRequired = asProperty.isIsRequired();
		org.eclipse.ocl.pivot.Class asSourceClass = asProperty.getOwningClass();
		boolean isThis = false;
		if (asSourceClass instanceof ImperativeTransformation) {	// XXX ??? obsolete wrt TransformationPropertyCallingConvention
			ImperativeTransformation iTransformation = (ImperativeTransformation)asSourceClass;
			org.eclipse.ocl.pivot.Class runtimeContextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
			Property iProperty = NameUtil.getNameable(runtimeContextClass.getOwnedProperties(), asProperty.getName());
			assert iProperty != null;
			asProperty = iProperty;
			isThis = true;
			//	}
		}
		if (isThis) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
			if (eStructuralFeature != null) {
				CGPropertyCallExp cgPropertyCallExp = null;
				try {
					getGenModelHelper().getGetAccessor(eStructuralFeature);
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
					//	CGExecutorProperty cgExecutorProperty = analyzer.createExecutorProperty(asProperty);
					CGProperty cgExecutorProperty = generatePropertyDeclaration(asProperty, null);
					cgExecutorPropertyCallExp.setReferredProperty(cgExecutorProperty);
					//					cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
					cgPropertyCallExp = cgExecutorPropertyCallExp;
				}
				CGProperty cgProperty = generatePropertyDeclaration(asProperty, null);
				cgPropertyCallExp.setReferredProperty(cgProperty);
				cgPropertyCallExp.setAst(element);
				cgPropertyCallExp.setTypeId(getCGTypeId(element.getTypeId()));
				cgPropertyCallExp.setRequired(isRequired || codeGenerator.isPrimitive(cgPropertyCallExp));
				cgPropertyCallExp.setSource(cgSource);
				return cgPropertyCallExp;
			}
		}
		assert (cgSource == null) == asProperty.isIsStatic();
		return super.generatePropertyCallExp(cgSource, element);
	}

	public CGNamedElement generateSetStatement(SetStatement asSetStatement) {
		ImperativeTransformation asTransformation = QVTimperativeUtil.getContainingTransformation(asSetStatement);
		EntryPointsAnalysis entryPointsAnalysis = getCodeGenerator().getEntryPointsAnalysis(asTransformation);
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(asSetStatement);
		if (cacheIndex != null) {
			//			Property asProperty = ClassUtil.nonNullModel(asPropertyAssignment.getTargetProperty());
			CGMiddlePropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyAssignment();
			cgPropertyAssignment.setAst(asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = useExecutableNameManager(asVariable).getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(createCGVariableExp(cgVariable));
			Property asProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			CGProperty cgProperty = generatePropertyDeclaration(asProperty, null);
			cgPropertyAssignment.setReferredProperty(cgProperty);
			//			cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(getCGTypeId(TypeId.OCL_VOID));
			//			cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(createCGElement(CGValuedElement.class, asSetStatement.getOwnedExpression()));
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
						CGEcorePropertyAssignment cgEcorePropertyAssignment = CGModelFactory.eINSTANCE.createCGEcorePropertyAssignment();
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
							CGEcoreContainerAssignment cgEcoreContainerAssignment = CGModelFactory.eINSTANCE.createCGEcoreContainerAssignment();
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
				cgPropertyAssignment = CGModelFactory.eINSTANCE.createCGPropertyAssignment();
			}
			cgPropertyAssignment.setAst(asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = useExecutableNameManager(asVariable).getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(createCGVariableExp(cgVariable));
			CGProperty cgTargetProperty = generatePropertyDeclaration(asTargetProperty, null);
			cgPropertyAssignment.setReferredProperty(cgTargetProperty);
			//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(getCGTypeId(TypeId.OCL_VOID));
			//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(createCGElement(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			//	CGExecutorProperty cgExecutorProperty = qvtiAnalyzer.createExecutorProperty(asTargetProperty);
			return cgPropertyAssignment;
		}
	}

	public @NonNull PredicateTreeBuilder getBodyBuilder() {
		assert bodyBuilder != null;
		return bodyBuilder;
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator) super.getCodeGenerator();
	}

	public @Nullable CGFunction getCGFunction(@NonNull Function asFunction) {
		//	return asFunction2cgFunctions.get(asFunction);
		return (CGFunction)getCGOperation(asFunction);
	}

	//	public @NonNull CGMapping getCGMapping(@NonNull Mapping asMapping) {
	//		return ClassUtil.nonNullState(asMapping2cgMapping.get(asMapping));
	//	}

	//	public @NonNull CGMappingLoop getCGMappingLoop(@NonNull MappingLoop asMappingLoop) {
	//		return ClassUtil.nonNullState(asMappingLoop2cgMappingLoop.get(asMappingLoop));
	//	}

	@Override
	public @NonNull CGTypeId getCGTypeId(@NonNull TypeId typeId) {
		//	if (typeId == originalThisTypeId) {		// XXX
		//		return super.getCGTypeId(runtimeThisTypeId);
		//	}
		//	else {
		return super.getCGTypeId(typeId);
		//	}
	}

	public @NonNull CGTypedModel getCGTypedModel(@NonNull TypedModel asTypedModel) {
		return ClassUtil.nonNullState(basicGetCGTypedModel(asTypedModel));
	}

	public @NonNull CGRealizedVariable getCGRealizedVariable(@NonNull NewStatement asNewStatement) {
		return (CGRealizedVariable)ClassUtil.nonNullState(asElement2cgElement.get(asNewStatement));
	}

	public @NonNull CGRealizedVariablePart getCGRealizedVariablePart(@NonNull NewStatementPart asNewStatementPart) {
		return (CGRealizedVariablePart)ClassUtil.nonNullState(asElement2cgElement.get(asNewStatementPart));
	}

	/**
	 * Create or use the ClassNameManager for asClass exploiting an optionally already known cgClass.
	 *
	@Override			// XXX Avoiding bad inherited assert
	public @NonNull ClassNameManager getClassNameManager(@Nullable CGClass cgClass, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		if (!(cgClass instanceof CGTransformation)) {
			return super.getClassNameManager(cgClass, asClass);
		}
		//	if (cgClass == null) {
		//		cgClass = (CGClass)asElement2cgElement.get(asClass);
		//		if (cgClass == null) {
		//			cgClass = generateClassDeclaration(asClass, null);
		//		}
		//	}
		//	assert environmentFactory.getCompleteModel().getCompleteClass(asClass).getPrimaryClass() == cgClass.getAst();
		ClassNameManager classNameManager = (ClassNameManager)globalNameManager.basicGetChildNameManager(cgClass);
		if (classNameManager == null) {
			EObject eContainer = asClass.eContainer();
			ClassableNameManager classableNameManager = null;
			if (eContainer instanceof org.eclipse.ocl.pivot.Package) {
				classableNameManager = getPackageNameManager(null, (org.eclipse.ocl.pivot.Package)eContainer);
			}
			else if (eContainer instanceof org.eclipse.ocl.pivot.Package) {
				classableNameManager = getClassNameManager(null, (org.eclipse.ocl.pivot.Class)eContainer);
			}
			assert classableNameManager != null;
			classNameManager = globalNameManager.createClassNameManager(classableNameManager, cgClass);
		}
		return classNameManager;
	} */

	public @NonNull CreationCache getCreationCache(org.eclipse.ocl.pivot.Class asCacheClass) {
		CreationCache creationCache = (CreationCache)asCacheClass2abstractCache.get(asCacheClass);
		assert creationCache != null;
		return creationCache;
	}

	public @NonNull CreationCache getCreationCache(@NonNull NewStatement asNewStatement) {
		TypedModel asTypedModel = QVTimperativeUtil.getReferredTypedModel(asNewStatement);
		org.eclipse.ocl.pivot.Class asClass = (org.eclipse.ocl.pivot.Class)QVTimperativeUtil.getType(asNewStatement);
		Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull CreationCache> asClass2creationCache = asTypedModel2asClass2creationCache.get(asTypedModel);
		if (asClass2creationCache == null) {
			asClass2creationCache = new HashMap<>();
			asTypedModel2asClass2creationCache.put(asTypedModel, asClass2creationCache);
		}
		CreationCache creationCache = asClass2creationCache.get(asClass);
		if (creationCache == null) {
			ClassNameManager classNameManager = getClassNameManager(null, asClass);
			creationCache = RuleCacheClassCallingConvention.getInstance(asClass).createCreationCache(classNameManager, asNewStatement);
			asClass2creationCache.put(asClass, creationCache);
		}
		return creationCache;
	}

	public @Nullable EClassifier getEClassifier(@Nullable Type type) {
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

	//	public @NonNull QVTiExecutableNameManager getFunctionNameManager(@NonNull CGFunction cgFunction, @NonNull Function asFunction) {
	//		return (QVTiExecutableNameManager)super.zzgetOperationNameManager(cgFunction, asFunction);
	//	}

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		Function asFunction = QVTiCGUtil.getOwningFunction(asFunctionParameter);
		ExecutableNameManager operationNameManager = getOperationNameManager(null, asFunction, null);
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)operationNameManager.basicGetCGParameter(asFunctionParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			initAst(cgFunctionParameter, asFunctionParameter, true);
			//	cgFunctionParameter.setTypeId(getCGTypeId(asFunctionParameter.getTypeId()));
			//	nameManager.declarePreferredName(cgFunctionParameter);
			//	cgFunctionParameter.setTypeId(getCGTypeId(asFunctionParameter.getTypeId()));
			//	if (asFunctionParameter.isIsRequired()) {
			//		cgFunctionParameter.setRequired(true);
			//	}
			operationNameManager.addVariable(asFunctionParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	@Override
	public @NonNull QVTiGlobalNameManager getGlobalNameManager() {
		return (QVTiGlobalNameManager)super.getGlobalNameManager();
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull VariableDeclaration asVariable) {
		ExecutableNameManager nameManager = useExecutableNameManager(asVariable);
		CGGuardVariable cgGuardVariable = (CGGuardVariable)nameManager.basicGetCGParameter(asVariable);
		assert cgGuardVariable == null;
		boolean isConnectionVariable = asVariable instanceof ConnectionVariable;
		boolean isPrimitiveVariable = QVTimperativeUtil.isPrimitiveVariable(asVariable);	// FIXME obsolete ??
		if (isConnectionVariable) {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGConnectionVariable();
		}
		else {
			cgGuardVariable = QVTiCGModelFactory.eINSTANCE.createCGGuardVariable();
		}
		initAst(cgGuardVariable, asVariable, true);
		//	cgGuardVariable.setAst(asVariable);
		//	cgGuardVariable.setTypeId(getCGTypeId(asVariable.getTypeId()));
		//	nameManager.declarePreferredName(cgGuardVariable);
		if (!isConnectionVariable && !isPrimitiveVariable) {
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
		}
		nameManager.addVariable(asVariable, cgGuardVariable);
		return cgGuardVariable;
	}

	/**
	 * Create or use the MappingLoopNameManager for asMappingLoop exploiting an optionally already known cgMapping.
	 */
	public @NonNull ExecutableNameManager getMappingLoopNameManager(@NonNull CGMappingLoop cgMappingLoop, @NonNull MappingLoop asMappingLoop) {
		//	if (cgMappingLoop == null) {
		//		cgMappingLoop = asMappingLoop2cgMappingLoop.get(asMappingLoop);
		//		if (cgMappingLoop == null) {
		//			cgMappingLoop = generateMappingLoopDeclaration(asMappingLoop);
		//		}
		//	}
		assert cgMappingLoop.getAst() == asMappingLoop;
		ExecutableNameManager mappingLoopNameManager = (ExecutableNameManager) globalNameManager.basicGetChildNameManager(cgMappingLoop);
		if (mappingLoopNameManager == null) {			//
			ExecutableNameManager parentNameManager = useExecutableNameManager((NamedElement)asMappingLoop.eContainer());
			ClassNameManager traansformationNameManager = parentNameManager.getClassNameManager();
			mappingLoopNameManager = getGlobalNameManager().createExecutableNameManager(traansformationNameManager, parentNameManager, cgMappingLoop);
		}
		return mappingLoopNameManager;
	}

	/**
	 * Create or use the MappingNameManager for asMapping exploiting an optionally already known cgMapping.
	 */
	public @NonNull QVTiExecutableNameManager getMappingNameManager(@Nullable CGMapping cgMapping, @NonNull Mapping asMapping) {
		if (cgMapping == null) {
			cgMapping = (CGMapping)asElement2cgElement.get(asMapping);
			if (cgMapping == null) {
				cgMapping = generateMappingDeclaration(asMapping);
			}
		}
		assert cgMapping.getAst() == asMapping;
		QVTiExecutableNameManager mappingNameManager = (QVTiExecutableNameManager)globalNameManager.basicGetChildNameManager(cgMapping);
		if (mappingNameManager == null) {			//
			Transformation asTransformation = QVTbaseUtil.getOwningTransformation(asMapping);
			ClassNameManager transformationNameManager = getClassNameManager(null, asTransformation);
			mappingNameManager = getGlobalNameManager().createMappingNameManager(transformationNameManager, cgMapping);
		}
		return mappingNameManager;
	}

	@Override
	public @NonNull QVTiExecutableNameManager getOperationNameManager(@Nullable CGOperation cgOperation, @NonNull Operation asOperation, @Nullable TypedElement asOrigin) {
		return (QVTiExecutableNameManager)super.getOperationNameManager(cgOperation, asOperation, asOrigin);
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull NewStatement asNewStatement) {
		ExecutableNameManager nameManager = useExecutableNameManager(asNewStatement);
		CGVariable cgVariable2 = nameManager.basicGetCGVariable(asNewStatement);
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
			initAst(cgVariable, asNewStatement, true);
			TypedModel asTypedModel = ClassUtil.nonNullState(asNewStatement.getReferredTypedModel());
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(getTypedModel(asTypedModel));
			cgVariable.setTypedModel(cgTypedModel);
			nameManager.addVariable(asNewStatement, cgVariable);
		}
		return cgVariable;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getRuleCacheClass(@NonNull TypedModel asTypedModel, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull CreationCache> asClass2creationCache = asTypedModel2asClass2creationCache.get(asTypedModel);
		assert asClass2creationCache != null;
		CreationCache creationCache = asClass2creationCache.get(asClass);
		assert creationCache != null;
		org.eclipse.ocl.pivot.Class asCacheClass = creationCache.getASCacheClass();
		return asCacheClass;
	}

	public @NonNull TypedModel getTypedModel(org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		CreationCache creationCache = (CreationCache)asCacheClass2abstractCache.get(asCacheClass);		// XXX basicGet ??
		assert creationCache != null;
		return creationCache.getTypedModel();
	}

	public @NonNull CGTypedModel getTypedModel(@NonNull TypedModel asTypedModel) {
		return (CGTypedModel)ClassUtil.nonNullState(asElement2cgElement.get(asTypedModel));
	}

	public @NonNull CGTypedModel getTypedModel(@NonNull VariableDeclaration pVariable) {
		if (pVariable instanceof GuardParameter) {
			TypedModel referredTypedModel = ClassUtil.nonNullState(((GuardParameter)pVariable).getReferredTypedModel());
			return ClassUtil.nonNullState(getTypedModel(referredTypedModel));
		}
		Transformation pTransformation = QVTimperativeUtil.getContainingTransformation(pVariable);
		TypedModel asTypedModel = ClassUtil.nonNullState(pTransformation.getModelParameter(null));
		return ClassUtil.nonNullState(getTypedModel(asTypedModel));
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
	protected @Nullable ExecutableNameManager useExecutableNameManagerInternal(@NonNull EObject eObject) {
		ExecutableNameManager executableNameManager = super.useExecutableNameManagerInternal(eObject);
		if (executableNameManager == null) {
			if (eObject instanceof Mapping) {
				//	CGMapping cgMapping = getCGMapping((Mapping)eObject);
				//	return useMappingNameManager(cgMapping);
				CGMapping cgMapping = ClassUtil.nonNullState(asMapping2cgMapping.get(eObject));
				return (ExecutableNameManager)ClassUtil.nonNullState(globalNameManager.basicGetNestedNameManager(cgMapping));
			}
			if (eObject instanceof MappingLoop) {
				//	CGMappingLoop cgMappingLoop = getCGMappingLoop((MappingLoop)eObject);
				//	return useMappingLoopNameManager(cgMappingLoop);
				CGMappingLoop cgMappingLoop = ClassUtil.nonNullState(asMappingLoop2cgMappingLoop.get(eObject));
				return (ExecutableNameManager)ClassUtil.nonNullState(globalNameManager.basicGetNestedNameManager(cgMappingLoop));
			}
		}
		return executableNameManager;
	} */

	//	public @NonNull ExecutableNameManager useMappingNameManager(@NonNull CGMapping cgMapping) {
	//		ExecutableNameManager executableNameManager = (ExecutableNameManager)globalNameManager.basicGetChildNameManager(cgMapping);
	//		return ClassUtil.nonNullState(executableNameManager);
	//	}
}
