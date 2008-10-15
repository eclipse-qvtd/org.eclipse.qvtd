/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLFileAnalyzer.java,v 1.4 2008/10/15 20:01:53 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.ocl;

import java.util.ArrayList;
import java.util.List;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileAnalyzer;
import org.eclipse.qvt.declarative.parser.ocl.environment.IOCLEnvironment;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLFileEnvironment;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLTopLevelEnvironment;

public final class OCLFileAnalyzer extends
		OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, 
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> implements ICSTFileAnalyzer<OCLTopLevelEnvironment>
{
	private Monitor monitor;
	private OCLTopLevelEnvironment topLevelEnvironment = null;

	public OCLFileAnalyzer(OCLFileEnvironment environment, Monitor monitor) {
		super(new OCLParser(new OCLLexer(environment)));
		this.monitor = monitor;
	}

	public boolean analyze(OCLTopLevelEnvironment environment) {
		this.topLevelEnvironment = environment;
		List<Constraint> constraints = new ArrayList<Constraint>();
		for (PackageDeclarationCS pkgdecl = environment.getCSTNode(); pkgdecl != null; pkgdecl = pkgdecl.getPackageDeclarationCS())
			packageDeclarationCS(pkgdecl, constraints);
		if (!constraints.isEmpty())
			environment.getASTNode().getContents().addAll(constraints);
		return true;
	}

	protected void checkAndSetAst(CSTNode cstNode, Object astNode) {
		if ((astNode != null) && (cstNode != null)) {
			if (cstNode.getAst() == null) {
//				System.out.println("Missing CST mapping for " + EcoreUtils.formatQualifiedName(cstNode) + " corrected");
				cstNode.setAst(astNode);
			}
		}
	}	

	@Override protected void contextDeclCS(ContextDeclCS contextDeclCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<Constraint> constraints) {
		try {
//			if (((OCLEnvironment)env).getCSTNode() == null)
//				env = new OCLNodeEnvironment((OCLEnvironment) env, contextDeclCS);	// Ensure non-null CSTNode for error messages
			super.contextDeclCS(contextDeclCS, env, constraints);
		} catch (OCLParsingError e) {
			ERROR(contextDeclCS, "contextDeclCS", e.getMessage());
		} catch (Exception e) {
			ERROR(contextDeclCS, "contextDeclCS", e.toString());
		}
	}

	@Override
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getOCLEnvironment() {
		return topLevelEnvironment != null ? topLevelEnvironment : super.getOCLEnvironment();
	}

	protected boolean isCancelled() {
		return monitor != null ? monitor.isCancelled() : false;
	}

	@Override
	protected EClassifier lookupClassifier(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<String> className) {
		EClassifier eClassifier = super.lookupClassifier(cstNode, env, className);
		if (eClassifier != null) {
			if (((IOCLEnvironment)env).getASTNodeToCSTNodeMap().get(eClassifier) == null)
				((IOCLEnvironment)env).initASTMapping(eClassifier, cstNode);
				else
					cstNode.setAst(eClassifier);
		}
		return eClassifier;
	}

	@Override
	protected Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> classifierContextDeclCS(
			ClassifierContextDeclCS classifierContextDeclCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<Constraint> constraints) {
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> classifierContext = super.classifierContextDeclCS(classifierContextDeclCS, env, constraints);
		checkAndSetAst(classifierContextDeclCS.getPathNameCS(), classifierContextDeclCS.getAst());
		return classifierContext;
	}

	@Override
	protected Constraint invOrDefCS(InvOrDefCS invOrDefCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		Constraint invOrDef = super.invOrDefCS(invOrDefCS, env);
		((IOCLEnvironment)env).initASTMapping(invOrDef.getSpecification().getContextVariable(), invOrDefCS.getSimpleNameCS());
		return invOrDef;
	}

	@Override
	protected IterateExp<EClassifier, EParameter> iterateExpCS(IterateExpCS iterateExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		IterateExp<EClassifier, EParameter> iterateExp = super.iterateExpCS(iterateExpCS, env);
		((IOCLEnvironment)env).initASTMapping(iterateExp, iterateExpCS.getSimpleNameCS());
		return iterateExp;
	}

	@Override
	protected IteratorExp<EClassifier, EParameter> iteratorExpCS(IteratorExpCS iteratorExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		IteratorExp<EClassifier, EParameter> iteratorExp = super.iteratorExpCS(iteratorExpCS, env);
		((IOCLEnvironment)env).initASTMapping(iteratorExp, iteratorExpCS.getSimpleNameCS());
		return iteratorExp;
	}

	@Override
	protected Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> operationCS(
			OperationCS operationCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		// TODO Auto-generated method stub
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> operation = super.operationCS(operationCS, env);
		checkAndSetAst(operationCS.getPathNameCS(), operationCS.getAst());
		checkAndSetAst(operationCS.getSimpleNameCS(), operationCS.getAst());
		checkAndSetAst(operationCS.getTypeCS(), operationCS.getAst());
		return operation;
	}

	@Override
	protected EStructuralFeature propertyContextCS(PropertyContextCS propertyContextCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<Constraint> constraints) {
		EStructuralFeature propertyContext = super.propertyContextCS(propertyContextCS, env, constraints);
		checkAndSetAst(propertyContextCS.getPathNameCS(), propertyContextCS.getAst());
		checkAndSetAst(propertyContextCS.getSimpleNameCS(), propertyContextCS.getAst());
		checkAndSetAst(propertyContextCS.getTypeCS(), propertyContextCS.getAst());
		return propertyContext;
	}

	@Override
	protected OCLExpression<EClassifier> operationCallExpCS(OperationCallExpCS operationCallExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> operationCallExp = super.operationCallExpCS(operationCallExpCS, env);
		checkAndSetAst(operationCallExpCS.getSimpleNameCS(), operationCallExpCS.getAst());
		return operationCallExp;
	}

	@Override
	protected void packageDeclarationCS(PackageDeclarationCS packageDeclarationCS, List<Constraint> constraints) {
		super.packageDeclarationCS(packageDeclarationCS, constraints);
		checkAndSetAst(packageDeclarationCS.getPathNameCS(), packageDeclarationCS.getAst());
	}

	@Override
	protected Constraint prePostOrBodyDeclCS(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			PrePostOrBodyDeclCS prePostOrBodyDeclCS) {
		Constraint prePostOrBody = super.prePostOrBodyDeclCS(env, prePostOrBodyDeclCS);
//		checkAndSetAst(prePostOrBodyDeclCS.getSimpleNameCS(), prePostOrBodyDeclCS.getAst());
		((IOCLEnvironment)env).initASTMapping(prePostOrBody.getSpecification().getContextVariable(), prePostOrBodyDeclCS.getSimpleNameCS());
		for (Variable<EClassifier, EParameter> variable : prePostOrBody.getSpecification().getParameterVariable())
			((IOCLEnvironment)env).getASTNodeToCSTNodeMap().put(variable, prePostOrBodyDeclCS);
		return prePostOrBody;
	}

	@Override
	protected OCLExpression<EClassifier> variableExpCS(VariableExpCS variableExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> variableExp = super.variableExpCS(variableExpCS, env);
		checkAndSetAst(variableExpCS, variableExp);
		return variableExp;
	}
}