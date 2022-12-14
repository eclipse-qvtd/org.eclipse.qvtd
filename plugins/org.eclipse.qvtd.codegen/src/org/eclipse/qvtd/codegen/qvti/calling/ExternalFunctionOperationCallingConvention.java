/*******************************************************************************
 * Copyright (c) 2022 Willink Transformation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.calling;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.LibraryOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCachedOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 *  ExternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by a Java class.
 */
public class ExternalFunctionOperationCallingConvention extends AbstractCachedOperationCallingConvention
{
	private static final @NonNull ExternalFunctionOperationCallingConvention INSTANCE = new ExternalFunctionOperationCallingConvention();

	public static @NonNull ExternalFunctionOperationCallingConvention getInstance(@NonNull Operation asOperation, boolean maybeVirtual) {
		INSTANCE.logInstance(asOperation, maybeVirtual);
		return INSTANCE;
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOuterOperation) {
		CGFunction cgOuterFunction = (CGFunction)cgOuterOperation;
		Function asOuterFunction = QVTiCGUtil.getAST(cgOuterFunction);
		String implementationClass = asOuterFunction.getImplementationClass();
		assert implementationClass != null;
		assert asOuterFunction.getQueryExpression() == null;
		//	LibraryOperation libraryOperation = loadImplementation(as2cgVisitor, implementationClass);
		//	LibraryOperation libraryOperation2 = (LibraryOperation)asFunction.getImplementation();
		PivotMetamodelManager metamodelManager = analyzer.getMetamodelManager();
		LibraryOperation libraryOperation = (LibraryOperation) metamodelManager.getImplementation(asOuterFunction);
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asOuterFunction);
		VariableDeclaration asThis = QVTbaseUtil.getContextVariable(asTransformation);
		//	VariableExp zzasThisExp = PivotUtil.createVariableExp(asThis);
		//	CGValuedElement cgSource = as2cgVisitor.doVisit(CGValuedElement.class, asThisExp);

		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;



		//	CGLibraryOperationCallExp cgLibraryOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		//	cgLibraryOperationCallExp.getArguments().add(cgSource);
		//	cgLibraryOperationCallExp.setTypeId(value);
		//	cgLibraryOperationCallExp.setThisIsSelf(true);

		/*	Field instanceField;
		try {
			instanceField = libraryOperation.getClass().getField("INSTANCE");
			assert instanceField != null;
		} catch (SecurityException | NoSuchFieldException e) {
			throw new RuntimeException(e);
		} */


		/*		Operation asOperation = ClassUtil.nonNullState(asOperationCallExp.getReferredOperation());
	//	System.out.println("createCGOperationCallExp: to " + asOperation);
		assert (cgSource == null) == asOperation.isIsStatic();
		CGLibraryOperationCallExp cgOperationCallExp = createCGMethodOperationCallExp(as2cgVisitor, libraryOperation, cgSource, asOperationCallExp);
		boolean isRequired = cgOperation.isRequired();
		init(as2cgVisitor, cgOperationCallExp, asOperationCallExp, cgOperation, isRequired); */



		//	Method jMethod = libraryOperation.getEvaluateMethod(asOuterFunction);

		//	Property asProperty = analyzer.getNativeProperty(instanceField);
		//	Operation asOperation = analyzer.getNativeOperation(jMethod);

		//	PivotHelper helper = new PivotHelper(as2cgVisitor.getEnvironmentFactory());

		CGOperation cgInnerOperation = createCGInnerOperation(qvtiAnalyzer, libraryOperation, asOuterFunction);

		CGLibraryOperationCallExp cgOperationCallExp = createCGInnerOperationCallExp(qvtiAnalyzer, cgInnerOperation, libraryOperation, asOuterFunction);//, cgFunction, asFunction)

		//	innerCallingConvention.createCGOperationCallExp(as2cgVisitor, cgFunction, libraryOperation, null, null);
		//	CGLibraryOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		//	cgOperationCallExp.setLibraryOperation(libraryOperation);
		//	boolean isRequired = true;		// XXX
		//	initCallExp2(as2cgVisitor, cgOperationCallExp, cgInnerOperation, isRequired);

		/*	List<@NonNull CGParameter> cgParameters = QVTiCGUtil.getParametersList(cgFunction);
		//	int cgParametersSize = cgParameters.size();
		//	assert asArgumentSize == asFunction.getOwnedParameters().size();

		CGValuedElement cgSource = null;

		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		Class<?>[] jParameterTypes = jMethod.getParameterTypes();
		int syntheticArgumentSize = jParameterTypes.length - cgParameters.size();
		for (int i = 0; i < syntheticArgumentSize; i++) {
			Class<?> jParameterType = jParameterTypes[i];
			if (jParameterType == Executor.class) {
				CGVariable executorVariable = as2cgVisitor.getNameManager().getExecutorVariable();
				cgArguments.add(analyzer.createCGVariableExp(executorVariable));
			}
			else if (jParameterType == TypeId.class) {
				addTypeIdArgument(as2cgVisitor, cgOperationCallExp, asFunction/*CallExp* /.getTypeId());
			}
			else if (jParameterType == Object.class) {
				if (cgSource != null) {
					cgArguments.add(cgSource);
				}
				break;
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		for (@NonNull CGParameter cgParameter : cgParameters) {
			cgArguments.add(analyzer.createCGVariableExp(cgParameter));
		} */

		cgOuterFunction.setBody(cgOperationCallExp);






		/*	PropertyCallExp asPropertyCallExp = helper.createPropertyCallExp(null, asProperty);
		List<@NonNull OCLExpression> asArguments = new ArrayList<>();
		CGVariable cgExecutorVariable = as2cgVisitor.getNameManager().getExecutorVariable();
		VariableDeclaration asExecutorVariable = CGUtil.getAST(cgExecutorVariable);
		asArguments.add(PivotUtil.createVariableExp(asExecutorVariable));		// XXX executor
		asArguments.add(createTypeExp(as2cgVisitor.getEnvironmentFactory(), asExecutorVariable.getType()));		// XXX typeId
		asArguments.add(PivotUtil.createVariableExp(asThis));
		for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
			VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			asArguments.add(asParameterExp);
		}
		OperationCallExp asOperationCallExp = helper.createOperationCallExp(asPropertyCallExp, asOperation, asArguments);

		//	CGValuedElement cgBody = (CGValuedElement)as2cgVisitor.visit(asOperationCallExp);
		CGValuedElement cgBody = as2cgVisitor.doVisit(CGValuedElement.class, asOperationCallExp);

		cgFunction.setBody(cgBody);
		//.getOwnedBody()));				// XXX is this line used (by testQVTrCompiler_ATL2QVTr_CG) - it seems like an infinite recursion
		 */
		/*	CGPropertyCallExp cgPropertyCallExp = analyzer.createCGNativePropertyCallExp(instanceField, NativePropertyCallingConvention.getInstance());
		CGOperationCallExp cgFunctionCallExp = analyzer.createCGNativeOperationCallExp(evaluateMethod, NativeOperationCallingConvention.getInstance());

		OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asOperationCallExp.setReferredOperation(asFunction);

		CGOperation cgUnderlyingOperation = as2cgVisitor.generateOperationDeclaration(null, asFunction, true);
		OperationCallingConvention underlyingCallingConvention = cgUnderlyingOperation.getCallingConvention();
		OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asOperationCallExp.setReferredOperation(asFunction);
		for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
			VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			asOperationCallExp.getOwnedArguments().add(asParameterExp);
			//	CGValuedElement cgArgument = doVisit(CGValuedElement.class, asParameterExp);
			//	CGFunctionCallExp.getArguments().add(cgArgument);
		}

		CGOperationCallExp cgFunctionCallExp = (CGOperationCallExp)underlyingCallingConvention.createCGOperationCallExp(as2cgVisitor, cgUnderlyingOperation, libraryOperation, cgSource, asOperationCallExp);


		CGOperationCallExp cgFunctionCallExp = analyzer.createCGNativeOperationCallExp(evaluateMethod, SupportOperationCallingConvention.getInstance());
		cgFunctionCallExp.setTypeId(cgUnderlyingOperation.getTypeId());
		cgFunctionCallExp.getArguments().add(cgSource);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			//	asOperationCallExp.getOwnedArguments().add(asParameterExp);
			CGValuedElement cgArgument = as2cgVisitor.doVisit(CGValuedElement.class, asParameterExp);
			cgFunctionCallExp.getArguments().add(cgArgument);
		}

		//	OperationCallExp asOperationCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		//	asOperationCallExp.setReferredOperation(asFunction);
		/*	asOperationCallExp.setOwnedSource(asThisExp);
		asOperationCallExp.setName(asFunction.getName());
		asOperationCallExp.setType(asFunction.getType());
		for (@NonNull Parameter asParameter : ClassUtil.nullFree(asFunction.getOwnedParameters())) {
			VariableExp asParameterExp = PivotUtil.createVariableExp(asParameter);
			asOperationCallExp.getOwnedArguments().add(asParameterExp);
			//	CGValuedElement cgArgument = doVisit(CGValuedElement.class, asParameterExp);
			//	CGFunctionCallExp.getArguments().add(cgArgument);
		}
		//	CGCallExp cgFunctionCallExp = LibraryOperationCallingConvention.getInstance().createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
		CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)createCGOperationCallExp(as2cgVisitor, cgFunction, libraryOperation, cgSource, asOperationCallExp);
		 */		//	cgLibraryOperationCallExp.setAst(asOperationCallExp);
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
		//		cgFunction.setBody(cgFunctionCallExp); //.getOwnedBody()));				// XXX is this line used (by testQVTrCompiler_ATL2QVTr_CG) - it seems like an infinite recursion
		//	callingConvention.createCGBody(this, cgFunction, query);
		//	String instanceName = getFunctionInstanceName(cgFunction);				// XXX redundant ??
		//	cgFunctionCallExp.setName(instanceName);								// XXX redundant ??
		//				final CGTypeId resultType = cgFunction.getTypeId();
		//	Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	TypeDescriptor functionTypeDescriptor = analyzer.getTypeDescriptor(cgFunction).getEcoreDescriptor(analyzer, null);
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
		//	analyzer.addFunction(asFunction, cgFunction); */
	}

	private @NonNull CGOperation createCGInnerOperation(@NonNull CodeGenAnalyzer analyzer, LibraryOperation libraryOperation, @NonNull Operation asOuterOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		Method jMethod = libraryOperation.getEvaluateMethod(asOuterOperation);
		CGLibraryOperation cgInnerOperation = CGModelFactory.eINSTANCE.createCGLibraryOperation();
		//	analyzer.installOperation(asOperation, cgOperation, this);
		assert cgInnerOperation.getAst() == null;
		assert cgInnerOperation.getCallingConvention() == null;
		//		System.out.println("installOperation " + callingConvention.getClass().getSimpleName() + " " + NameUtil.debugSimpleName(cgOperation) + " " + NameUtil.debugSimpleName(asOperation) + " : " + asOperation);
		cgInnerOperation.setAst(asOuterOperation);		// no inner available
		cgInnerOperation.setTypeId(analyzer.getCGTypeId(asOuterOperation.getTypeId()));
		cgInnerOperation.setRequired(asOuterOperation.isIsRequired());
		cgInnerOperation.setCallingConvention(LibraryOperationCallingConvention.getInstance(asOuterOperation, false));
		ExecutableNameManager nameManager = qvtiAnalyzer.getOperationNameManager(cgInnerOperation, asOuterOperation);
		//		analyzer.addCGOperation(cgOperation);
		//	createCGParameters(as2cgVisitor, gOperation, null;
		ExpressionInOCL expressionInOCL	= null;
		//	Operation asOperation = CGUtil.getAST(cgOperation);
		//	NestedNameManager nameManager = as2cgVisitor.getNameManager();
		List<CGParameter> cgParameters = cgInnerOperation.getParameters();
		//	LibraryOperation libraryOperation = (LibraryOperation)as2cgVisitor.getMetamodelManager().getImplementation(asOperation);
		//	Method jMethod = libraryOperation.getEvaluateMethod(asOperation);
		cgInnerOperation.setRequired(qvtiAnalyzer.getCodeGenerator().getIsNonNull(jMethod) == Boolean.TRUE);
		//	List<@NonNull Parameter> asParameters = PivotUtil.getOwnedParameters(asOuterOperation);
		//	int i = asOuterOperation.isIsStatic() ? 0 : -1;
		//	if (Modifier.isStatic(jMethod.getModifiers())) {
		//		cgParameters.add(nameManager.getThisParameter());
		//	}
		cgParameters.add(nameManager.getExecutorParameter());
		cgParameters.add(nameManager.getTypeIdParameter());
		for (Parameter asParameter : PivotUtil.getOwnedParameters(asOuterOperation)) {
			CGParameter cgParameter = nameManager.getCGParameter(asParameter, (String)null);
			cgParameters.add(cgParameter);
		}
		//	assert i == asParameters.size();
		return cgInnerOperation;
	}

	private @NonNull CGLibraryOperationCallExp createCGInnerOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOuterOperation, @NonNull LibraryOperation libraryOperation, @NonNull Operation asOuterOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		//	Operation asOperation = ClassUtil.nonNullState(asOperationCallExp.getReferredOperation());
		//	System.out.println("createCGOperationCallExp: to " + asOperation);
		//	assert (cgSource == null) == asOperation.isIsStatic();
		//	CGValuedElement cgSource = null;
		boolean isRequired = cgOuterOperation.isRequired();
		//	Method jMethod = libraryOperation.getEvaluateMethod(asOuterOperation);
		//	assert (cgSource == null) == Modifier.isStatic(jMethod.getModifiers());
		CGLibraryOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		cgOperationCallExp.setLibraryOperation(libraryOperation);
		cgOperationCallExp.setTypeId(cgOuterOperation.getTypeId());
		cgOperationCallExp.setReferredOperation(cgOuterOperation);
		//	cgOperationCallExp.setInvalidating(asOperation.isIsInvalidating());
		//	cgOperationCallExp.setValidating(asOperation.isIsValidating());
		cgOperationCallExp.setRequired(isRequired);

		QVTiExecutableNameManager nameManager = qvtiAnalyzer.getOperationNameManager(cgOuterOperation, asOuterOperation);
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgOuterOperation);
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		int i = 0;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			if (i == 0) {
				CGVariable executorVariable = analyzer.getExecutorVariable(nameManager);
				cgArguments.add(analyzer.createCGVariableExp(executorVariable));
			}
			else if (i == 1) {
				cgArguments.add(analyzer.createCGConstantExp(CGUtil.getTypeId(cgOuterOperation)));
			}
			else {
				cgArguments.add(analyzer.createCGVariableExp(cgParameter));
			}
			i++;
		}
		return cgOperationCallExp;
	}

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() != null;
		CGCachedOperation cgOperation = CGModelFactory.eINSTANCE.createCGCachedOperation();
		analyzer.initAst(cgOperation, asOperation, true);
		CGClass cgRootClass = analyzer.getCGRootClass(asOperation);
		cgRootClass.getOperations().add(cgOperation);
		createCachingClassesAndInstance(analyzer, cgOperation);
		return cgOperation;
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		assert QVTimperativeUtil.basicGetShadowExp(asOperation) == null;
		CGOperationCallExp cgOperationCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(qvtiAnalyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		assert cgSource != null;
		cgOperationCallExp.getArguments().add(cgSource);
		initCallArguments(qvtiAnalyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		CodeGenAnalyzer qvtiAnalyzer = operationNameManager.getAnalyzer();
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		Operation asOperation = CGUtil.getAST(cgOperation);
		boolean useClassToCreateObject = PivotUtil.basicGetShadowExp(asOperation) != null;
		List<CGParameter> cgParameters = cgOperation.getParameters();
		assert !useClassToCreateObject;
		cgParameters.add(operationNameManager.getContextObjectParameter());
		for (Parameter asParameter : asOperation.getOwnedParameters()) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		return generateDeprecatedJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperationCallExp cgOperationCallExp) {
		if (cgOperationCallExp.eContainer() != cgOperationCallExp.getReferredOperation()) {
			super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperationCallExp);
		}
		else {
			// the inner call does not need boxing or guarding
		}
	}
}
