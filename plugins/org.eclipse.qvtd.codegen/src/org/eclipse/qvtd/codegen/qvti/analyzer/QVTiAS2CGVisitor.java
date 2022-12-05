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
import java.util.List;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsKindOfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer.PredicateTreeBuilder;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
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

	protected final @NonNull QVTiAnalyzer qvtiAnalyzer;

	public QVTiAS2CGVisitor(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
		this.qvtiAnalyzer = analyzer;
	}

	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator)codeGenerator;
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

	//	@Override
	//	public @NonNull QVTiLocalContext getLocalContext() {
	//		return (QVTiLocalContext)super.getLocalContext();
	//	}

	//	@Override
	//	public @NonNull QVTiNestedNameManager getNameManager() {
	//		return (QVTiNestedNameManager)super.getNameManager();
	//	}

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
		CGVariable cgVariable = qvtiAnalyzer.useExecutableNameManager(asVariable).getCGVariable(asVariable);
		OCLExpression asInitValue = asAddStatement.getOwnedExpression();
		assert cgVariable instanceof CGConnectionVariable;
		CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInitValue);
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
		ConnectionVariable asVariable = QVTimperativeUtil.getValue(asAppendParameterBinding);
		CGVariable cgVariable = qvtiAnalyzer.useExecutableNameManager(asVariable).getCGVariable(asVariable);
		CGVariableExp cgVariableExp = qvtiAnalyzer.createCGVariableExp(cgVariable);
		qvtiAnalyzer.initAst(cgVariableExp, asAppendParameterBinding, asVariable, true);
		//
		VariableDeclaration asBoundVariable = QVTimperativeUtil.getBoundVariable(asAppendParameterBinding);
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		qvtiAnalyzer.initAst(cgMappingCallBinding, asAppendParameterBinding, asBoundVariable, false);
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitBufferStatement(@NonNull BufferStatement asVariable) {
		ExecutableNameManager nameManager = qvtiAnalyzer.useExecutableNameManager(asVariable);
		OCLExpression asInit = asVariable.getOwnedExpression();
		CGAccumulator cgAccumulator = CGModelFactory.eINSTANCE.createCGAccumulator();		// ?? FIXME Use ConnectionVariable
		cgAccumulator.setAst(asVariable);
		//	nameManager.declarePreferredName(cgAccumulator);
		//	cgAccumulator.setName(asVariable.getName());
		if (asInit != null) {
			CGValuedElement cgInit = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInit);
			TypeId typeId = asInit.getTypeId();
			if (typeId instanceof CollectionTypeId) {
				typeId = ((CollectionTypeId)typeId).getElementTypeId();
			}
			cgAccumulator.setTypeId(qvtiAnalyzer.getCGTypeId(typeId));
			cgAccumulator.setInit(cgInit);
			//							cgAccumulator.setRequired(true);
		}
		else {
			cgAccumulator.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
		}
		cgAccumulator.setNonNull();
		cgAccumulator.setNonInvalid();
		qvtiAnalyzer.getBodyBuilder().addAccumulator(cgAccumulator);
		nameManager.addVariable(asVariable, cgAccumulator);
		return null;
	}

	@Override
	public @Nullable CGNamedElement visitCheckStatement(@NonNull CheckStatement asPredicate) {
		CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
		cgPredicate.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
		cgPredicate.setRequired(true);
		OCLExpression asConditionExpression = asPredicate.getOwnedExpression();
		assert asConditionExpression != null;
		cgPredicate.setCondition(qvtiAnalyzer.createCGElement(CGValuedElement.class, asConditionExpression));
		CGConstantExp cgElse = qvtiAnalyzer.createCGConstantExp(asConditionExpression, qvtiAnalyzer.getCGBoolean(false));
		cgElse.setAst(asConditionExpression);
		cgElse.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
		cgElse.setRequired(true);
		cgPredicate.setElseExpression(cgElse);
		qvtiAnalyzer.getBodyBuilder().appendSubTree(cgPredicate);
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
		CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInitValue);
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
			CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asVariable.getOwnedExpression());
			cgVariable.setInit(initValue);
			cgVariable.setTypeId(initValue.getTypeId());
			cgVariable.setRequired(initValue.isRequired());
			return cgVariable; */
			qvtiAnalyzer.getBodyBuilder().appendCheckedLetVariable(asVariable, asInit);
		}
		else {
			CGValuedElement cgExpression = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInit);
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
			cgOuterLetExp.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
			cgOuterLetExp.setInit(cgUncastVariable);
			cgOuterLetExp.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
			cgOuterLetExp.setRequired(true);
			//
			CGIfExp cgPredicate = CGModelFactory.eINSTANCE.createCGIfExp();
			cgPredicate.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
			cgPredicate.setRequired(true);
			CGConstantExp cgElse = qvtiAnalyzer.createCGConstantExp(asInit, qvtiAnalyzer.getCGBoolean(false));
			cgElse.setAst(asVariable);
			cgElse.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
			cgElse.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
			cgElse.setRequired(true);
			cgPredicate.setElseExpression(cgElse);
			CGIsKindOfExp cgIsKindOfExp = CGModelFactory.eINSTANCE.createCGIsKindOfExp();
			cgIsKindOfExp.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
			cgIsKindOfExp.setRequired(true);
			CGVariableExp cgUncastVariableExp1 = CGModelFactory.eINSTANCE.createCGVariableExp();
			cgUncastVariableExp1.setAst(asVariable);
			cgUncastVariableExp1.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
			cgUncastVariableExp1.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp1.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp1.setRequired(cgUncastVariable.isRequired());
			cgIsKindOfExp.setSource(cgUncastVariableExp1);

			ExecutableNameManager executableNameManager = qvtiAnalyzer.useExecutableNameManager(asVariable);
			CGExecutorType cgExecutorType = executableNameManager.getCGExecutorType(PivotUtil.getType(asVariable));
			cgIsKindOfExp.setExecutorType(cgExecutorType);
			cgPredicate.setCondition(cgIsKindOfExp);
			cgOuterLetExp.setIn(cgPredicate);

			CGVariableExp cgUncastVariableExp2 = CGModelFactory.eINSTANCE.createCGVariableExp();
			cgUncastVariableExp2.setAst(asVariable);
			cgUncastVariableExp2.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
			cgUncastVariableExp2.setReferredVariable(cgUncastVariable);
			cgUncastVariableExp2.setTypeId(cgUncastVariable.getTypeId());
			cgUncastVariableExp2.setRequired(cgUncastVariable.isRequired());
			CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
			cgCastExp.setSource(cgUncastVariableExp2);
			cgCastExp.setExecutorType(cgExecutorType);
			TypeId asTypeId = cgExecutorType.getASTypeId();
			assert asTypeId != null;
			cgCastExp.setTypeId(qvtiAnalyzer.getCGTypeId(asTypeId));

			CGFinalVariable cgCastVariable = qvtiAnalyzer.useExecutableNameManager(asVariable).createCGVariable(asVariable);
			cgCastVariable.setInit(cgCastExp);

			CGLetExp cgCastLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
			cgCastLetExp.setAst(asVariable);
			cgCastLetExp.setTypeId(qvtiAnalyzer.getCGTypeId(asVariable.getTypeId()));
			cgCastLetExp.setInit(cgCastVariable);
			cgCastLetExp.setTypeId(qvtiAnalyzer.getCGTypeId(TypeId.BOOLEAN));
			cgCastLetExp.setRequired(true);

			cgPredicate.setThenExpression(cgCastLetExp);
			qvtiAnalyzer.getBodyBuilder().appendSubTree(cgCastLetExp);
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
		CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInitValue);
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
	public @Nullable CGNamedElement visitEntryPoint(@NonNull EntryPoint asEntryPoint) {
		return qvtiAnalyzer.generateMapping(asEntryPoint);
	}

	@Override
	public @Nullable CGNamedElement visitFunction(@NonNull Function asFunction) {
		return super.visitOperation(asFunction);
		/*	CGFunction cgFunction = (CGFunction)qvtiAnalyzer.generateOperationDeclaration(asFunction, null, true);
		AbstractOperationCallingConvention callingConvention = (AbstractOperationCallingConvention)cgFunction.getCallingConvention();
		callingConvention.createCGBody(qvtiAnalyzer, cgFunction);
		//	cgFunction.setRequired(asFunction.isIsRequired());
		/ *		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
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
			//	cgFunction.setBody(qvtiAnalyzer.createCGElement(CGValuedElement.class, query)); //.getOwnedBody()));
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
			CGValuedElement cgSource = qvtiAnalyzer.createCGElement(CGValuedElement.class, asThisExp);




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
				//	CGValuedElement cgArgument = qvtiAnalyzer.createCGElement(CGValuedElement.class, asParameterExp);
				//	CGFunctionCallExp.getArguments().add(cgArgument);
			}
			//	CGCallExp cgFunctionCallExp = LibraryOperationCallingConvention.INSTANCE.createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
			CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)callingConvention.createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
			//	cgLibraryOperationCallExp.setAst(asOperationCallExp);
			//	cgLibraryOperationCallExp.setTypeId(qvtiAnalyzer.getCGTypeId(asOperationCallExp.getTypeId()));
			//	for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
			//		VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			//		asOperationCallExp.getOwnedArguments().add(asParameterExp);
			//		CGValuedElement cgArgument = qvtiAnalyzer.createCGElement(CGValuedElement.class, asParameterExp);
			//		CGFunctionCallExp.getArguments().add(cgArgument);
			//	}
			//	for (@NonNull OCLExpression pArgument : ClassUtil.nullFree(element.getOwnedArguments())) {
			//		CGValuedElement cgArgument = qvtiAnalyzer.createCGElement(CGValuedElement.class, pArgument);
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
			//	TypeDescriptor functionTypeDescriptor = qvtiAnalyzer.getTypeDescriptor(cgFunction).getEcoreDescriptor(qvtiAnalyzer, null);
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
		//	qvtiAnalyzer.addFunction(asFunction, cgFunction); */
		//	return cgFunction;
	}

	@Override
	public @Nullable CGNamedElement visitFunctionBody(@NonNull FunctionBody object) {
		return super.visitExpressionInOCL(object);
	}

	@Override
	public @Nullable CGNamedElement visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		return qvtiAnalyzer.getFunctionParameter(asFunctionParameter);
	}

	@Override
	public @Nullable CGNamedElement visitGuardParameter(@NonNull GuardParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitGuardParameterBinding(@NonNull GuardParameterBinding asGuardParameterBinding) {
		ConnectionVariable asVariable = QVTimperativeUtil.getValue(asGuardParameterBinding);
		CGVariable cgVariable = qvtiAnalyzer.useExecutableNameManager(asVariable).getCGVariable(asVariable);
		CGVariableExp cgVariableExp = qvtiAnalyzer.createCGVariableExp(cgVariable);
		qvtiAnalyzer.initAst(cgVariableExp, asGuardParameterBinding, asVariable, true);
		//
		VariableDeclaration asBoundVariable = QVTimperativeUtil.getBoundVariable(asGuardParameterBinding);
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		qvtiAnalyzer.initAst(cgMappingCallBinding, asGuardParameterBinding, asBoundVariable, false);
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitImperativeTransformation(@NonNull ImperativeTransformation asTransformation) {
		return visitClass(asTransformation);
	}

	@Override
	public @Nullable CGNamedElement visitLoopParameterBinding(@NonNull LoopParameterBinding asLoopParameterBinding) {
		LoopVariable asVariable = QVTimperativeUtil.getValue(asLoopParameterBinding);
		CGVariable cgVariable = qvtiAnalyzer.useExecutableNameManager(asVariable).getCGVariable(asVariable);
		CGVariableExp cgVariableExp = qvtiAnalyzer.createCGVariableExp(cgVariable);
		qvtiAnalyzer.initAst(cgVariableExp, asLoopParameterBinding, asVariable, true);
		//
		VariableDeclaration asBoundVariable = QVTimperativeUtil.getBoundVariable(asLoopParameterBinding);
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		cgMappingCallBinding.setOwnedValue(cgVariableExp);
		qvtiAnalyzer.initAst(cgMappingCallBinding, asLoopParameterBinding, asBoundVariable, false);
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitLoopVariable(@NonNull LoopVariable asVariable) {
		return visiting(asVariable);
	}

	@Override
	public @Nullable CGNamedElement visitMapping(@NonNull Mapping asMapping) {
		return qvtiAnalyzer.generateMapping(asMapping);
	}

	@Override
	public CGNamedElement visitMappingCall(@NonNull MappingCall asMappingCall) {
		CGMappingCall cgMappingCall = QVTiCGModelFactory.eINSTANCE.createCGMappingCall();
		cgMappingCall.setAst(asMappingCall);
		Mapping asMapping = QVTimperativeUtil.getReferredMapping(asMappingCall);
		CGMapping cgMapping = qvtiAnalyzer.generateMappingDeclaration(asMapping);
		cgMappingCall.setReferredMapping(cgMapping);
		List<@NonNull CGMappingCallBinding> cgMappingCallBindings = new ArrayList<>();
		for (@NonNull MappingParameterBinding asMappingCallBinding : QVTimperativeUtil.getOwnedMappingParameterBindings(asMappingCall)) {
			CGMappingCallBinding cgMappingCallBinding = qvtiAnalyzer.createCGElement(CGMappingCallBinding.class, asMappingCallBinding);
			cgMappingCallBindings.add(cgMappingCallBinding);
		}
		Collections.sort(cgMappingCallBindings, CGMappingCallBindingComparator.INSTANCE);
		cgMappingCall.getOwnedMappingCallBindings().addAll(cgMappingCallBindings);
		return cgMappingCall;
	}

	@Override
	public CGNamedElement visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		return qvtiAnalyzer.generateMappingLoop(asMappingLoop);
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
		PredicateTreeBuilder bodyBuilder = qvtiAnalyzer.getBodyBuilder();
		OCLExpression asInit = asNewStatement.getOwnedExpression();
		if (asInit == null) {
			CGRealizedVariable cgRealizedVariable = bodyBuilder.addRealizedVariable(asNewStatement);
			ExecutableNameManager executableNameManager = qvtiAnalyzer.useExecutableNameManager(asNewStatement);
			Type asType = PivotUtil.getType(asNewStatement);
			CGExecutorType cgExecutorType = executableNameManager.getCGExecutorType(asType);
			cgRealizedVariable.setExecutorType(cgExecutorType);
			cgExecutorType.setTypeId(qvtiAnalyzer.getCGTypeId(asNewStatement.getTypeId()));			// FIXME promote
			List<@NonNull NewStatementPart> asParts = new ArrayList<>(ClassUtil.nullFree(asNewStatement.getOwnedParts()));
			Collections.sort(asParts, NameUtil.NAMEABLE_COMPARATOR);
			List<@NonNull CGRealizedVariablePart> cgParts = ClassUtil.nullFree(cgRealizedVariable.getOwnedParts());		// Ensure deterministic CGShadowPart order
			for (@NonNull NewStatementPart asPart : asParts) {
				cgParts.add(qvtiAnalyzer.createCGElement(CGRealizedVariablePart.class, asPart));
			}
			if (asParts.size() > 0) {
				org.eclipse.ocl.pivot.@NonNull Class asClass = (org.eclipse.ocl.pivot.Class)CGUtil.getAST(cgExecutorType);
				assert asClass == asType;
				//	ClassNameManager classNameManager = qvtiAnalyzer.getClassNameManager(null, asClass);
				qvtiAnalyzer.getRuleCacheClass(asNewStatement, QVTimperativeUtil.getReferredTypedModel(asNewStatement), asClass);
			}
		}
		else {
			bodyBuilder.appendCheckedLetVariable(asNewStatement, asInit);
		}
		return null;
	}

	@Override
	public @Nullable CGNamedElement visitNewStatementPart(@NonNull NewStatementPart element) {
		CGRealizedVariablePart cgRealizedVariablePart = QVTiCGModelFactory.eINSTANCE.createCGRealizedVariablePart();
		cgRealizedVariablePart.setAst(element);
		cgRealizedVariablePart.setInit(qvtiAnalyzer.createCGElement(CGValuedElement.class, element.getOwnedExpression()));
		Property asProperty = element.getReferredProperty();
		if (asProperty != null) {
			//	CGExecutorProperty cgExecutorProperty = qvtiAnalyzer.createExecutorProperty(asProperty);
			CGProperty cgExecutorProperty = qvtiAnalyzer.generatePropertyDeclaration(asProperty, null);
			//	getNameManager().declareStandardName(cgExecutorProperty);
			cgRealizedVariablePart.setReferredProperty(cgExecutorProperty);
			cgExecutorProperty.setTypeId(qvtiAnalyzer.getCGTypeId(asProperty.getTypeId()));			// FIXME promote
			qvtiAnalyzer.addExternalFeature(asProperty);
		}
		return cgRealizedVariablePart;
	}

	@Override
	public CGNamedElement visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable CGNamedElement visitParameter(@NonNull Parameter object) {
		return visiting(object);		// ParameterVariable rather than Parameter shuld used
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
		return qvtiAnalyzer.generateSetStatement(asSetStatement);
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
		OCLExpression asExpression = QVTimperativeUtil.getValue(asSimpleParameterBinding);
		CGValuedElement cgElement = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpression);
		qvtiAnalyzer.initAst(cgElement, asSimpleParameterBinding.getValue(), asExpression, false);
		//
		VariableDeclaration asBoundVariable = QVTimperativeUtil.getBoundVariable(asSimpleParameterBinding);
		CGMappingCallBinding cgMappingCallBinding = QVTiCGModelFactory.eINSTANCE.createCGMappingCallBinding();
		cgMappingCallBinding.setOwnedValue(cgElement);
		qvtiAnalyzer.initAst(cgMappingCallBinding, asSimpleParameterBinding, asBoundVariable, true);
		return cgMappingCallBinding;
	}

	@Override
	public @Nullable CGNamedElement visitSpeculateStatement(@NonNull SpeculateStatement asSpeculateStatement) {
		CGSpeculateExp cgSpeculateExp = QVTiCGModelFactory.eINSTANCE.createCGSpeculateExp();
		cgSpeculateExp.setAst(asSpeculateStatement);
		for (@NonNull OCLExpression asExpression : ClassUtil.nullFree(asSpeculateStatement.getOwnedExpressions())) {
			CGEcorePropertyCallExp cgArgument = qvtiAnalyzer.createCGElement(CGEcorePropertyCallExp.class, asExpression);
			CGSpeculatePart cgSpeculatePart = QVTiCGModelFactory.eINSTANCE.createCGSpeculatePart();
			CGValuedElement cgSource = cgArgument.getSource();
			PivotUtilInternal.resetContainer(cgSource);
			cgSpeculatePart.setObjectExp(cgSource);
			cgSpeculatePart.setEStructuralFeature(cgArgument.getEStructuralFeature());
			cgSpeculateExp.getParts().add(cgSpeculatePart);
		}
		qvtiAnalyzer.getBodyBuilder().appendSubTree(cgSpeculateExp);
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
		CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asInitValue);
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
		// The name of a CGTypedModel is not used. Run-time models are kept in an array whose index is discovered by
		// search within a private namespace wrt the AS TypedModel name.
		// XXX globalNameManager.declareEagerName(cgTypedModel, "TM_" + asTypedModel.getName());		// Lazy and use regular hint
		qvtiAnalyzer.addCGTypedModel(cgTypedModel);
		return cgTypedModel;
	}

	@Override
	public @Nullable CGNamedElement visitVariable(@NonNull Variable object) {
		return visiting(object);		// Really should not be happening
		/*		CGVariable cgVariable = getVariable(asVariable);
		CGValuedElement initValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asVariable.getOwnedExpression());
		cgVariable.setInit(initValue);
		cgVariable.setTypeId(initValue.getTypeId());
		cgVariable.setRequired(initValue.isRequired());
		return cgVariable; */
	}

	@Override
	public @Nullable CGNamedElement visitVariableDeclaration(@NonNull VariableDeclaration object) {
		return visiting(object);		// Really should not be happening
	}

	@Override
	public @Nullable CGNamedElement visitVariableStatement(@NonNull VariableStatement object) {
		return visiting(object);
	}
}
