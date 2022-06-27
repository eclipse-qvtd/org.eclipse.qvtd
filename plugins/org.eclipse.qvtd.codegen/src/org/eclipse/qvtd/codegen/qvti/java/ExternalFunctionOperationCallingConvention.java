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
package org.eclipse.qvtd.codegen.qvti.java;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NestedNameManager;
import org.eclipse.ocl.examples.codegen.calling.LibraryOperationCallingConvention;
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
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 *  ExternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by a Java class.
 */
public class ExternalFunctionOperationCallingConvention extends FunctionOperationCallingConvention
{
	public static final @NonNull ExternalFunctionOperationCallingConvention INSTANCE = new ExternalFunctionOperationCallingConvention();

	@Override
	public void createCGBody(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOuterOperation) {
		CGFunction cgOuterFunction = (CGFunction)cgOuterOperation;
		Function asOuterFunction = QVTiCGUtil.getAST(cgOuterFunction);
		String implementationClass = asOuterFunction.getImplementationClass();
		assert implementationClass != null;
		assert asOuterFunction.getQueryExpression() == null;
		//	LibraryOperation libraryOperation = loadImplementation(as2cgVisitor, implementationClass);
		//	LibraryOperation libraryOperation2 = (LibraryOperation)asFunction.getImplementation();
		LibraryOperation libraryOperation = (LibraryOperation) as2cgVisitor.getMetamodelManager().getImplementation(asOuterFunction);
		Transformation asTransformation = QVTbaseUtil.getContainingTransformation(asOuterFunction);
		VariableDeclaration asThis = QVTbaseUtil.getContextVariable(as2cgVisitor.getEnvironmentFactory().getStandardLibrary(), asTransformation);
		//	VariableExp zzasThisExp = PivotUtil.createVariableExp(asThis);
		//	CGValuedElement cgSource = as2cgVisitor.doVisit(CGValuedElement.class, asThisExp);

		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();



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

		CGOperation cgInnerOperation = createCGInnerOperation(as2cgVisitor, libraryOperation, asOuterFunction);

		CGLibraryOperationCallExp cgOperationCallExp = createCGInnerOperationCallExp(as2cgVisitor, cgInnerOperation, libraryOperation, asOuterFunction);//, cgFunction, asFunction)

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
		/*	CGPropertyCallExp cgPropertyCallExp = analyzer.createCGNativePropertyCallExp(instanceField, NativePropertyCallingConvention.INSTANCE);
		CGOperationCallExp cgFunctionCallExp = analyzer.createCGNativeOperationCallExp(evaluateMethod, NativeOperationCallingConvention.INSTANCE);

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


		CGOperationCallExp cgFunctionCallExp = analyzer.createCGNativeOperationCallExp(evaluateMethod, SupportOperationCallingConvention.INSTANCE);
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
		//	CGCallExp cgFunctionCallExp = LibraryOperationCallingConvention.INSTANCE.createCGOperationCallExp(this, cgFunction, libraryOperation, cgSource, asOperationCallExp);
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

	private @NonNull CGOperation createCGInnerOperation(@NonNull AS2CGVisitor as2cgVisitor, LibraryOperation libraryOperation, @NonNull Operation asOuterOperation) {
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		Method jMethod = libraryOperation.getEvaluateMethod(asOuterOperation);
		CGLibraryOperation cgInnerOperation = CGModelFactory.eINSTANCE.createCGLibraryOperation();
		//	analyzer.installOperation(asOperation, cgOperation, this);
		assert cgInnerOperation.getAst() == null;
		assert cgInnerOperation.getCallingConvention() == null;
		//		System.out.println("installOperation " + callingConvention.getClass().getSimpleName() + " " + NameUtil.debugSimpleName(cgOperation) + " " + NameUtil.debugSimpleName(asOperation) + " : " + asOperation);
		cgInnerOperation.setAst(asOuterOperation);		// no inner available
		cgInnerOperation.setTypeId(analyzer.getCGTypeId(asOuterOperation.getTypeId()));
		cgInnerOperation.setRequired(asOuterOperation.isIsRequired());
		cgInnerOperation.setCallingConvention(LibraryOperationCallingConvention.INSTANCE);
		NestedNameManager nameManager = as2cgVisitor.pushNestedNameManager(cgInnerOperation);
		//		analyzer.addCGOperation(cgOperation);
		//	createCGParameters(as2cgVisitor, gOperation, null;
		ExpressionInOCL expressionInOCL	= null;
		//	Operation asOperation = CGUtil.getAST(cgOperation);
		//	NestedNameManager nameManager = as2cgVisitor.getNameManager();
		List<CGParameter> cgParameters = cgInnerOperation.getParameters();
		//	LibraryOperation libraryOperation = (LibraryOperation)as2cgVisitor.getMetamodelManager().getImplementation(asOperation);
		//	Method jMethod = libraryOperation.getEvaluateMethod(asOperation);
		cgInnerOperation.setRequired(as2cgVisitor.getCodeGenerator().getIsNonNull(jMethod) == Boolean.TRUE);
		//	List<@NonNull Parameter> asParameters = PivotUtil.getOwnedParameters(asOuterOperation);
		//	int i = asOuterOperation.isIsStatic() ? 0 : -1;
		//	if (Modifier.isStatic(jMethod.getModifiers())) {
		//		cgParameters.add(nameManager.getThisParameter());
		//	}
		cgParameters.add(nameManager.getExecutorParameter());
		cgParameters.add(nameManager.getTypeIdParameter());
		for (Parameter asParameter : PivotUtil.getOwnedParameters(asOuterOperation)) {
			CGParameter cgParameter = nameManager.getParameter(asParameter, (String)null);
			cgParameters.add(cgParameter);
		}
		//	assert i == asParameters.size();
		as2cgVisitor.popNestedNameManager();
		return cgInnerOperation;
	}

	private @NonNull CGLibraryOperationCallExp createCGInnerOperationCallExp(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOuterOperation, @NonNull LibraryOperation libraryOperation, @NonNull Operation asOuterOperation) {
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
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

		NestedNameManager nameManager = as2cgVisitor.getNameManager();
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgOuterOperation);
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		int i = 0;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			if (i == 0) {
				CGVariable executorVariable = nameManager.getExecutorVariable();
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
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() != null;

		//	CGClass cgClass = analyzer.createNestedCGClass(asOperation, "FTOR" + asOperation.getName());

		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		initOperation(analyzer, cgFunction, asOperation);
		analyzer.addCGOperation(cgFunction);
		return cgFunction;
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(as2cgVisitor, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		assert cgSource != null;
		cgFunctionCallExp.getArguments().add(cgSource);
		initCallArguments(as2cgVisitor, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @Nullable ExpressionInOCL bodyExpression) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		boolean useClassToCreateObject = codeGenerator.getShadowExp(asFunction) != null;
		List<CGParameter> cgParameters = cgFunction.getParameters();
		assert !useClassToCreateObject;
		cgParameters.add(qvtias2cgVisitor.getNameManager().getThisTransformerParameter());
		for (Parameter asParameter : asFunction.getOwnedParameters()) {
			CGParameter cgParameter = as2cgVisitor.doVisit(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	/*	private @NonNull TypeExp createTypeExp(@NonNull EnvironmentFactory environmentFactory,  @NonNull Type type) {
		TypeExp asTypeExp = PivotFactory.eINSTANCE.createTypeExp();
		asTypeExp.setIsRequired(true);
		asTypeExp.setReferredType(type);
		asTypeExp.setName(type.getName());
		//	asTypeExp.setType(type instanceof TemplateParameter ? metamodelManager.getOclType("TemplateParameter") : standardLibrary.getClassType());
		EClass eClass = type.eClass();
		assert eClass != null;
		asTypeExp.setType(environmentFactory.getIdResolver().getType(eClass));
		asTypeExp.setTypeValue(type);
		return asTypeExp;
	} */

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		// TODO Auto-generated method stub
		return super.generateJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		return super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperation);
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
