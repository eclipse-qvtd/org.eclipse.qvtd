/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaDependencyVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.types.TypeDescriptor;
import org.eclipse.ocl.examples.domain.evaluation.AbstractTransformation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

/**
 * A CG2JavaClassVisitor supports generation of an OCL expression as the LibraryOperation INSTANCE of a Java Class.
 */
public class QVTiCG2JavaVisitor extends CG2JavaVisitor implements QVTiCGModelVisitor<Object>
{
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull Transformation transformation;
	protected final @NonNull CGPackage cgPackage;
	protected final @NonNull CGTransformation cgTransformation;
	
	public QVTiCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator,
			@NonNull Transformation transformation, String packageName, String className) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.transformation = transformation;
		this.cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		QVTiPivot2CGVisitor pivot2CGVisitor = new QVTiPivot2CGVisitor(analyzer, getGlobalContext());
		this.cgTransformation = (CGTransformation) DomainUtil.nonNullState(transformation.accept(pivot2CGVisitor));
		cgPackage.getClasses().add(cgTransformation);
		Resource resource = new XMIResourceImpl(URI.createURI("cg.xmi"));
		resource.getContents().add(cgPackage);
		analyzer.analyze(cgPackage);
	}

	protected void appendModelIndex(@Nullable CGTypedModel cgTypedModel) {
		if (cgTypedModel == null) {
			js.append("-1/*null*/");
		}
		else {
			js.append(cgTypedModel.getModelIndex() + "/*" + cgTypedModel.getName() + "*/");
		}
	}

	protected void doAddRealization(@NonNull CGRealizedVariable cgRealizedVariable) {
		RealizedVariable pRealizedVariable = (RealizedVariable)cgRealizedVariable.getPivot();
		Area pArea = QVTcoreBaseUtil.getContainingArea(pRealizedVariable);
		if (pArea != null) {
			BottomPattern pBottomPattern = pArea.getBottomPattern();
			if (pBottomPattern != null) {
				for (Assignment pAssignment : pBottomPattern.getAssignment()) {
					if (pAssignment instanceof PropertyAssignment) {
						Property pProperty = ((PropertyAssignment)pAssignment).getTargetProperty();
						if (pProperty != null) {
							Property pOppositeProperty = pProperty.getOpposite();
							if ((pOppositeProperty != null) && pOppositeProperty.isComposite()) {
// FIXME must check for null asssignment and correct target								return;
							}
						}
					}
				}
			}
		}
		CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
		//
		js.append("modelObjects[");
		appendModelIndex(cgTypedModel);
		js.append("].add(");
		js.appendValueName(cgRealizedVariable);
		js.append(");\n");
	}

	protected void doConstructor(@NonNull CGTransformation cgTransformation) {
		String evaluatorName = ((QVTiGlobalContext)globalContext).getEvaluatorParameter().getName();
		String className = cgTransformation.getName();
		//
		js.append("public " + className + "(final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(DomainEvaluator.class);
		js.append(" " + evaluatorName + ") {\n");
		js.pushIndentation(null);		
		js.append("super(" + evaluatorName + ", new String[] {");
		boolean isFirst = true;
		for (CGTypedModel cgTypedModel : cgTransformation.getTypedModels()) {
			if (!isFirst) {
				js.append(", ");
			}
			String name = cgTypedModel.getName();
			js.appendString(name != null ? name : "");
			isFirst = false;
		}
		js.append("});\n");
		js.popIndentation();		
		js.append("}\n");
	}

	protected void doGlobals(@NonNull CGTransformation cgTransformation) {
		DependencyVisitor dependencyVisitor = context.createDependencyVisitor();
		dependencyVisitor.visitAll(globalContext.getGlobals());
		dependencyVisitor.visitAll(cgTransformation.getOperations());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		generateGlobals(sortedDependencies);
	}
    
/*    public boolean run() {
        for (EObject eObject : getObjectsByType(0, HSVTreePackage.Literals.HSV_NODE)) {
        	HSV2MiddleRoot((HSVNode) eObject);
        }
        return true;
    } */

	@SuppressWarnings("null")
	protected void doRun(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = cgTransformation.getMappings().get(0);
		List<CGGuardVariable> cgGuardVariables = cgRootMapping.getGuardVariables();
		NameManager nameManager = globalContext.getNameManager();
		Map<CGParameter, String> listNames = new HashMap<CGParameter, String>();
		for (CGGuardVariable cgGuardVariable : cgGuardVariables) {
			String nameHint = "LIST_" + cgGuardVariable.getValueName();
			String listName = nameManager.getGlobalSymbolName(null, nameHint);
			listNames.put(cgGuardVariable, listName);
		}
		//
		js.append("public boolean run() {\n");
		js.pushIndentation(null);
		for (@NonNull CGGuardVariable cgGuardVariable : cgGuardVariables) {
			TypeDescriptor typeDescriptor = context.getJavaTypeDescriptor(cgGuardVariable);
			EClassifier eClassifier = DomainUtil.nonNullState(typeDescriptor.getEClassifier());
			String qualifiedPackageInterfaceName = genModelHelper.getQualifiedPackageInterfaceName(eClassifier.getEPackage());
			String classifierLiteralName = genModelHelper.getLiteralName(eClassifier);
			js.appendClassReference(List.class, typeDescriptor);
			js.append(" ");
			js.append(listNames.get(cgGuardVariable));
			js.append(" = getObjectsByType(");
			js.appendClassReference(typeDescriptor);
			js.append(".class, ");
			appendModelIndex(cgGuardVariable.getTypedModel());
			js.append(", ");
			js.appendClassReference(qualifiedPackageInterfaceName);
			js.append(".Literals." + classifierLiteralName);
			js.append(");\n");
		}
		for (CGGuardVariable cgGuardVariable : cgGuardVariables) {
			js.append("for (");
			js.appendClassReference(cgGuardVariable);
			js.append(" ");
			js.appendValueName(cgGuardVariable);
			js.append(" : ");
			js.append(listNames.get(cgGuardVariable));
			js.append(") {\n");
			js.pushIndentation(null);
		}
		js.append(cgRootMapping.getName());
		js.append("(");
		boolean isFirst = true;
		for (CGGuardVariable cgGuardVariable : cgGuardVariables) {
			if (!isFirst) {
				js.append(", ");
			}
			js.appendValueName(cgGuardVariable);
			isFirst = false;
		}
		js.append(");\n");
		for (@SuppressWarnings("unused") CGGuardVariable cgGuardVariable : cgGuardVariables) {
			js.popIndentation();
			js.append("}\n");
		}
		js.append("return true;\n");
		js.popIndentation();		
		js.append("}\n");
	}

	protected CGPackage generate() {
		CG2JavaPreVisitor cg2PreVisitor = context.createCG2JavaPreVisitor();
		cgPackage.accept(cg2PreVisitor);
		safeVisit(cgPackage);
		return cgPackage;
	}

	protected @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	protected @NonNull QVTiLocalContext getLocalContext() {
		return (QVTiLocalContext) localContext;
	}

	@Override
	@Nullable
	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
//		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
//		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
//		JavaTypeDescriptor requiredTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, false);
		EStructuralFeature eStructuralFeature = cgPropertyAssignment.getEStructuralFeature();
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getSlotValue());
		String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getInitValue());
//		Class<?> requiredJavaClass = requiredTypeDescriptor.getJavaClass();
//		Method leastDerivedMethod = requiredJavaClass != null ? getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
//		Class<?> unboxedSourceClass = leastDerivedMethod != null ? leastDerivedMethod.getDeclaringClass() : requiredJavaClass;
		//
		js.appendLocalStatements(cgSlot);
		js.appendLocalStatements(cgInit);
		//
		js.appendValueName(cgSlot);
		js.append(".");
		js.append(setAccessor);
		js.append("(");
		js.appendValueName(cgInit);
		js.append(");\n");
		return null;
	}

	@Override
	@Nullable
	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgRealizedVariable) {
		EClassifier eClassifier = cgRealizedVariable.getEClassifier();
		EPackage ePackage = eClassifier.getEPackage();
		String javaClass = genModelHelper.getQualifiedFactoryInterfaceName(ePackage);
		//
		js.appendDeclaration(cgRealizedVariable);
		js.append(" = ");
		js.appendClassReference(javaClass);
//		js.appendReferenceTo(localContext.getExecutorType(cgRealizedVariable.getPivotTypeId()));
		js.append(".eINSTANCE.create");
		js.append(eClassifier.getName());		// FIXME accessor
		js.append("();\n");
		//
		doAddRealization(cgRealizedVariable);
		return null;
	}

	@Override
	@Nullable
	public Object visitCGFunction(@NonNull CGFunction cgFunction) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(cgFunction);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				List<CGParameter> cgParameters = cgFunction.getParameters();
				CGValuedElement body = getExpression(cgFunction.getBody());
				//
				js.append("protected ");
				js.appendIsRequired(cgFunction.isRequired());
		//		js.append(" ");
		//		js.appendIsCaught(!cgOperation.isInvalid(), cgOperation.isInvalid());
				js.append(" ");
//				CGTypeId cgTypeId = cgFunction.getTypeId();
				TypeDescriptor javaTypeDescriptor = context.getJavaTypeDescriptor(cgFunction.getTypeId().getElementId(), false);
				js.appendClassReference(javaTypeDescriptor);
				js.append(" ");
				js.append(cgFunction.getName());
				js.append("(");
				boolean isFirst = true;
				for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendDeclaration(cgParameter);
					isFirst = false;
				}
				js.append(") {\n");
				js.pushIndentation(null);
					js.appendCastParameters(localContext2, cgParameters);
					JavaDependencyVisitor dependencyVisitor = new JavaDependencyVisitor(localContext2);
					dependencyVisitor.visit(body);
					dependencyVisitor.visitAll(localContext2.getLocalVariables());
					Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
					for (CGValuedElement cgElement : sortedDependencies) {
						if (!cgElement.isInlineable() && cgElement.isConstant() && !cgElement.isGlobal()) {
							cgElement.accept(this);
						}
					}
					// FIXME merge locals into AST as LetExps.
					if (cgFunction.getBody() != null) {
						js.appendLocalStatements(body);
						if (body.isInvalid()) {
							js.append("throw ");
						}
						else {
							js.append("return ");
						}
						js.appendValueName(body);
						js.append(";\n");
					}
					else {			// FIXME Fudge for body-less functions
						js.append("return null;\n");
					}
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return null;
	}

	@Override
	@Nullable
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		Operation pOperation = cgFunctionCallExp.getReferredOperation();
		List<CGValuedElement> cgArguments = cgFunctionCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			js.appendLocalStatements(argument);
		}
		//
		js.appendDeclaration(cgFunctionCallExp);
		js.append(" = ");
		js.append(cgFunctionCallExp.getFunction().getName());
		js.append("(");
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			if (i > 0) {
				js.append(", ");
			}
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = getExpression(cgArgument);
			Parameter pParameter = pParameters.get(i);
//			CGTypeId cgParameterTypeId = analyzer.getTypeId(pParameter.getTypeId());
			TypeDescriptor parameterTypeDescriptor = context.getJavaTypeDescriptor(pParameter.getTypeId(), false);
			js.appendReferenceTo(parameterTypeDescriptor, argument);
		}
		js.append(");\n");
		return null;
	}

	@Override
	@Nullable
	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	@Nullable
	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(cgMapping);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				List<CGGuardVariable> cgGuardVariables = cgMapping.getGuardVariables();
				//
				js.appendCommentWithOCL(null, cgMapping.getPivot());
				js.append("protected boolean " + cgMapping.getName() + "(");
				boolean isFirst = true;
				for (@SuppressWarnings("null")@NonNull CGGuardVariable cgGuardVariable : cgGuardVariables) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendDeclaration(cgGuardVariable);
					isFirst = false;
				}
				js.append(") {\n");
				js.pushIndentation(null);
//					js.appendCastParameters(localContext2, cgGuardVariables);
					DependencyVisitor dependencyVisitor = context.createDependencyVisitor(localContext2);
					dependencyVisitor.visitAll(localContext2.getLocalVariables());
					Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
					for (CGValuedElement cgElement : sortedDependencies) {
						if (!cgElement.isInlineable() && cgElement.isConstant() && !cgElement.isGlobal()) {
							cgElement.accept(this);
						}
					}
					// FIXME merge locals into AST as LetExps.
					js.append("// guards\n");
					for (CGPredicate cgPredicate : cgMapping.getPredicates()) {
						cgPredicate.accept(this);
					}
					js.append("// creations\n");
					for (CGRealizedVariable cgRealizedVariable : cgMapping.getRealizedVariables()) {
						cgRealizedVariable.accept(this);
					}
					js.append("// assignments\n");
					for (CGPropertyAssignment cgAssignment : cgMapping.getAssignments()) {
						cgAssignment.accept(this);
					}
					js.append("// mapping calls\n");
					for (CGMappingCall cgMappingCall : cgMapping.getMappingCalls()) {
						cgMappingCall.accept(this);
					}
					js.append("return true;\n");
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		MappingCall pMappingCall = (MappingCall) cgMappingCall.getPivot();
		Mapping pReferredMapping = pMappingCall.getReferredMapping();
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		if (cgReferredMapping == null) {
			return null;
		}
		List<CGMappingCallBinding> cgMappingCallBindings = cgMappingCall.getMappingCallBindings();
		for (CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			js.appendLocalStatements(cgMappingCallBinding.getValueOrValues());
		}
		for (CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			if (cgMappingCallBinding.isLoop()) {
				js.append("for (");
				js.appendClassReference(cgMappingCallBinding);
				js.append(" ");
				js.appendValueName(cgMappingCallBinding);
				js.append(" : ");
				js.appendValueName(cgMappingCallBinding.getValueOrValues());
				js.append(") {\n");
				js.pushIndentation(null);
			}
		}
		js.append(cgReferredMapping.getName() + "(");
		boolean isFirst = true;
		for (CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			if (!isFirst) {
				js.append(", ");
			}
			if (cgMappingCallBinding.isLoop()) {
				js.appendValueName(cgMappingCallBinding);
			}
			else {
				js.appendValueName(cgMappingCallBinding.getValueOrValues());
			}
			isFirst = false;
		}
		js.append(");\n");
		for (CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			if (cgMappingCallBinding.isLoop()) {
				js.popIndentation();
				js.append("}\n");
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return null;
	}

	@Override
	public @Nullable Object visitCGPredicate(@NonNull CGPredicate cgPredicate) {
		CGValuedElement cgConditionExpression = cgPredicate.getConditionExpression();
		js.appendLocalStatements(cgConditionExpression);
		js.append("if (");
		js.appendValueName(cgConditionExpression);
		js.append(" != ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".TRUE_VALUE) {\n");
		js.pushIndentation(null);
		js.append("return false;\n");
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGExecutorProperty cgExecutorProperty = localContext.getExecutorProperty(cgPropertyAssignment.getReferredProperty());
		js.appendLocalStatements(cgPropertyAssignment.getInitValue());
		js.appendValueName(cgExecutorProperty);
		js.append(".initValue(");
		js.appendValueName(cgPropertyAssignment.getInitValue());
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		js.appendDeclaration(cgRealizedVariable);
		js.append(" = ");
		js.appendReferenceTo(localContext.getExecutorType(cgRealizedVariable.getPivotTypeId()));
		js.append(".createInstance();\n");
		//
		doAddRealization(cgRealizedVariable);
		return null;
	}

	@Override
	public @Nullable Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {		
		String className = cgTransformation.getName();
		js.append("/**\n");
		js.append(" * The " + className + " transformation:\n");
		js.append(" * <p>\n");
		js.append(" * Construct with an evaluator\n");
		js.append(" * <br>\n");
		js.append(" * Populate each input model with {@link addRootObjects(String,List)}\n");
		js.append(" * <br>\n");
		js.append(" * {@link run()}\n");
		js.append(" * <br>\n");
		js.append(" * Extract each output model with {@link getRootObjects(String)}\n");
		js.append(" */\n");
		js.append("@SuppressWarnings(\"nls\")\n");
		js.append("public class " + className + " extends ");
		js.appendClassReference(AbstractTransformation.class);
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
		doGlobals(cgTransformation);
		js.append("\n");
		doConstructor(cgTransformation);
		js.append("\n");
		doRun(cgTransformation);
		for (CGOperation cgOperation : cgTransformation.getOperations()) {
			js.append("\n");
			cgOperation.accept(this);
		}
		for (CGMapping cgMapping : cgTransformation.getMappings()) {
			js.append("\n");
			cgMapping.accept(this);
		}
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	@Override
	@Nullable
	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return null;
	}
}
