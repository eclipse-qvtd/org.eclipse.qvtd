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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCachedOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsKindOfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.naming.FeatureNameManager;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
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
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiFeatureNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiAnalyzer extends CodeGenAnalyzer
{
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
				CGFinalVariable cgRawVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
				cgRawVariable.setAst(asInit);
				cgRawVariable.setTypeId(getCGTypeId(asInit.getTypeId()));
				cgRawVariable.setInit(cgInit);
				//	cgRawVariable.setName("raw_" + asVariable.getName());
				//	getNameManager().declareLazyName(cgRawVariable);
				//
				CGLetExp cgRawLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
				cgRawLetExp.setAst(asInit);
				cgRawLetExp.setTypeId(getCGTypeId(asInit.getTypeId()));
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
					FeatureNameManager featureNameManager = useFeatureNameManager(asVariable);
					CGExecutorType cgType = featureNameManager.getCGExecutorType(targetType);
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
			CGFinalVariable cgVariable = useFeatureNameManager(asVariable).createCGVariable(asVariable);
			cgVariable.setInit(cgInit);
			CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgLetExp.setAst(asVariable);
			cgLetExp.setTypeId(getCGTypeId(asVariable.getTypeId()));
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
			cgCondition.setInvalidating(false);
			cgCondition.setValidating(true);
			//
			CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
			//			setAst(cgIfExp, asExpression);
			cgIfExp.setTypeId(getCGTypeId(TypeId.BOOLEAN));
			//	cgIfExp.setName(cgVariable.getName());
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
				CGNamedElement cgElement = createCGElement(CGNamedElement.class, asStatement);
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

	private final @NonNull Map<@NonNull Function, @NonNull CGFunction> asFunction2cgFunctions = new HashMap<>();
	private final @NonNull Map<@NonNull Mapping, @NonNull CGMapping> asMapping2cgMapping = new HashMap<>();
	private final @NonNull Map<@NonNull TypedModel, @NonNull CGTypedModel> asTypedModel2cgTypedModel = new HashMap<>();
	private final @Nullable TypeId originalThisTypeId;
	private final @NonNull TypeId runtimeThisTypeId;

	private @Nullable PredicateTreeBuilder bodyBuilder;

	public QVTiAnalyzer(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		ImperativeTransformation iTransformation = codeGenerator.getTransformation();
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

	public void addCGFunction(@NonNull CGFunction cgFunction) {
		asFunction2cgFunctions.put(QVTiCGUtil.getAST(cgFunction), cgFunction);
	}

	public void addCGMapping(@NonNull CGMapping cgMapping) {
		asMapping2cgMapping.put(QVTiCGUtil.getAST(cgMapping), cgMapping);
	}

	@Override
	public void addCGOperation(@NonNull CGOperation cgOperation) {
		super.addCGOperation(cgOperation);
		if (cgOperation instanceof CGFunction) {
			addCGFunction((CGFunction)cgOperation);
		}
	}

	public void addCGTypedModel(@NonNull CGTypedModel cgTypedModel) {
		asTypedModel2cgTypedModel.put(QVTiCGUtil.getAST(cgTypedModel), cgTypedModel);
	}

	@Override
	public void addVirtualCGOperation(@NonNull Operation asOperation, @NonNull CGCachedOperation cgOperation) {
		super.addVirtualCGOperation(asOperation, cgOperation);
		// XXX virtual functions
	}

	public @Nullable CGFunction basicGetCGFunction(@NonNull Function asFunction) {
		return asFunction2cgFunctions.get(asFunction);
	}

	public @Nullable CGMapping basicGetCGMapping(@NonNull Mapping asMapping) {
		return asMapping2cgMapping.get(asMapping);
	}

	public void generateMappingBody(@NonNull CGMapping cgMapping) {
		PredicateTreeBuilder bodyBuilder2 = bodyBuilder = new PredicateTreeBuilder(cgMapping);
		bodyBuilder2.doBottoms();
		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
		List<@NonNull CGGuardVariable> sortedVariables = new ArrayList<>(cgFreeVariables);
		Collections.sort(sortedVariables, CGVariableComparator.INSTANCE);
		cgFreeVariables.clear();
		cgFreeVariables.addAll(sortedVariables);
		bodyBuilder = null;
	}

	public @NonNull CGMapping generateMappingDeclaration(@NonNull Mapping asMapping) {
		@SuppressWarnings("unused")String name = asMapping.getName();
		CGMapping cgMapping = basicGetCGMapping(asMapping);
		if (cgMapping == null) {
			cgMapping = QVTiCGModelFactory.eINSTANCE.createCGMapping();
			cgMapping.setAst(asMapping);
			globalNameManager.declareGlobalName(cgMapping, asMapping.getName());		// XXX lazy
			addCGMapping(cgMapping);
		}
		return cgMapping;
	}

	/*	@Override
	public @NonNull CGOperation generateOperationDeclaration(@NonNull Operation asOperation, @Nullable OperationCallingConvention callingConvention, boolean requireFinal) {
		if (!requireFinal && (asOperation instanceof Function)) {			// XXX ??? eliminate override
			Function asFunction = (Function)asOperation;
			CGFunction cgFunction = basicGetCGFunction(asFunction);
			if (cgFunction == null) {
				FunctionOperationCallingConvention callingConvention = (FunctionOperationCallingConvention)codeGenerator.getCallingConvention(asFunction, true);
				//	CGClass cgClass = generateClassDeclaration(PivotUtil.getOwningClass(asOperation), callingConvention.getClassCallingConvention());
				cgFunction = (CGFunction)callingConvention.createCGOperation(this, asFunction);
				assert cgFunction.getAst() != null;
				assert cgFunction.getCallingConvention() == callingConvention;
				callingConvention.createCGParameters(this, cgFunction, (ExpressionInOCL)asFunction.getBodyExpression());
				addCGFunction(cgFunction);
			}
			return cgFunction;
		}
		return super.generateOperationDeclaration(asOperation, callingConvention, requireFinal);
	} */

	@Override
	public @NonNull CGValuedElement generatePropertyCallExp(@Nullable CGValuedElement cgSource, @NonNull PropertyCallExp element) {
		Property asProperty = ClassUtil.nonNullModel(element.getReferredProperty());
		boolean isRequired = asProperty.isIsRequired();
		org.eclipse.ocl.pivot.Class asSourceClass = asProperty.getOwningClass();
		boolean isThis = false;
		if (asSourceClass instanceof ImperativeTransformation) {
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
					cgExecutorPropertyCallExp.getOwns().add(cgExecutorProperty);
					cgPropertyCallExp = cgExecutorPropertyCallExp;
				}
				CGProperty cgProperty = generatePropertyDeclaration(asProperty, null);
				cgPropertyCallExp.setAsProperty(asProperty);
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
			CGVariable cgVariable = useFeatureNameManager(asVariable).getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(createCGVariableExp(cgVariable));
			Property asProperty = QVTimperativeUtil.getTargetProperty(asSetStatement);
			cgPropertyAssignment.setAsProperty(asProperty);
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
			cgPropertyAssignment.setAst(asSetStatement);
			VariableDeclaration asVariable = asSetStatement.getTargetVariable();
			assert asVariable != null;
			CGVariable cgVariable = useFeatureNameManager(asVariable).getCGVariable(asVariable);
			cgPropertyAssignment.setOwnedSlotValue(createCGVariableExp(cgVariable));
			cgPropertyAssignment.setAsProperty(asTargetProperty);
			//		cgPredicate.setName(asPredicate.getName());
			cgPropertyAssignment.setTypeId(getCGTypeId(TypeId.OCL_VOID));
			//		cgMappingCallBinding.setValueName(localnameasMappingCallBinding.getBoundVariable().getName());
			cgPropertyAssignment.setOwnedInitValue(createCGElement(CGValuedElement.class, asSetStatement.getOwnedExpression()));
			//	CGExecutorProperty cgExecutorProperty = qvtiAnalyzer.createExecutorProperty(asTargetProperty);
			CGProperty cgTargetProperty = generatePropertyDeclaration(asTargetProperty, null);
			cgPropertyAssignment.setReferredProperty(cgTargetProperty);
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
		return asFunction2cgFunctions.get(asFunction);
	}

	@Override
	public @NonNull CGTypeId getCGTypeId(@NonNull TypeId typeId) {
		if (typeId == originalThisTypeId) {
			return super.getCGTypeId(runtimeThisTypeId);
		}
		else {
			return super.getCGTypeId(typeId);
		}
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

	public @NonNull CGFunctionParameter getFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		Function asFunction = QVTiCGUtil.getOwningFunction(asFunctionParameter);
		FeatureNameManager operationNameManager = getOperationNameManager(null, asFunction);
		CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)operationNameManager.basicGetParameter(asFunctionParameter);
		if (cgFunctionParameter == null) {
			cgFunctionParameter = QVTiCGModelFactory.eINSTANCE.createCGFunctionParameter();
			cgFunctionParameter.setAst(asFunctionParameter);
			//	cgFunctionParameter.setTypeId(getCGTypeId(asFunctionParameter.getTypeId()));
			//	nameManager.declarePreferredName(cgFunctionParameter);
			cgFunctionParameter.setTypeId(getCGTypeId(asFunctionParameter.getTypeId()));
			if (asFunctionParameter.isIsRequired()) {
				cgFunctionParameter.setNonNull();
			}
			operationNameManager.addVariable(asFunctionParameter, cgFunctionParameter);
		}
		return cgFunctionParameter;
	}

	public @NonNull CGGuardVariable getGuardVariable(@NonNull VariableDeclaration asVariable) {
		FeatureNameManager nameManager = useFeatureNameManager(asVariable);
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
		cgGuardVariable.setTypeId(getCGTypeId(asVariable.getTypeId()));
		//	nameManager.declarePreferredName(cgGuardVariable);
		if (!isConnectionVariable && !isPrimitiveVariable) {
			cgGuardVariable.setTypedModel(getTypedModel(asVariable));
		}
		nameManager.addVariable(asVariable, cgGuardVariable);
		return cgGuardVariable;
	}

	@Override
	public @NonNull QVTiFeatureNameManager getOperationNameManager(@Nullable CGOperation cgOperation, @NonNull Operation asOperation) {
		return (QVTiFeatureNameManager)super.getOperationNameManager(cgOperation, asOperation);
	}

	public @NonNull CGRealizedVariable getRealizedVariable(@NonNull NewStatement asNewStatement) {
		FeatureNameManager nameManager = useFeatureNameManager(asNewStatement);
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
			cgVariable.setTypeId(getCGTypeId(asNewStatement.getTypeId()));
			//	nameManager.declarePreferredName(cgVariable);
			TypedModel asTypedModel = ClassUtil.nonNullState(asNewStatement.getReferredTypedModel());
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(getTypedModel(asTypedModel));
			cgVariable.setTypedModel(cgTypedModel);
			nameManager.addVariable(asNewStatement, cgVariable);
		}
		return cgVariable;
	}

	public @Nullable CGTypedModel getTypedModel(@NonNull TypedModel asTypedModel) {
		return asTypedModel2cgTypedModel.get(asTypedModel);
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
}
