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
 * $Id: OCLFileAnalyzer.java,v 1.2 2008/08/18 07:56:33 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.ocl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.common.util.URI;
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
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.qvt.declarative.parser.environment.IFileAnalyzer;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLTopLevelEnvironment;

public final class OCLFileAnalyzer extends
		OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, 
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> implements IFileAnalyzer
{
	private Monitor monitor;

	public OCLFileAnalyzer(OCLTopLevelEnvironment environment) {
		super(new OCLParser(new OCLLexer(environment)));
		monitor = environment.getMonitor();
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

	protected boolean isCancelled() {
		return monitor != null ? monitor.isCancelled() : false;
	}

	public Collection<? extends EObject> parseCSTtoAST(CSTNode cstNode, URI sourceURI) {
		if (cstNode == null)
			return null;
		if (cstNode instanceof PackageDeclarationCS) {
			List<Constraint> constraints = new ArrayList<Constraint>();
			PackageDeclarationCS pkgdecl = (PackageDeclarationCS) cstNode;
			while (pkgdecl != null) {
				packageDeclarationCS(pkgdecl, constraints);
				pkgdecl = pkgdecl.getPackageDeclarationCS();
			}
			return constraints;
		}
		ERROR(cstNode, "topLevelCS", "Expected a PackageDeclarationCS rather than a " + formatEClassName(cstNode));
		return null;
	}
    
	public Collection<? extends EObject> parseToAST(URI sourceURI) {
		CSTNode cstNode = parseToCST();
        if (cstNode == null)
 			return null;
		if (isCancelled())
			return null;
		return parseCSTtoAST(cstNode, sourceURI);
	}

	public CSTNode parseToCST() {
		AbstractParser parser = getParser();
		if (isCancelled())
			return null;
		parser.getLexer().lexToTokens(parser);
		if (isCancelled())
			return null;
		return parser.parseTokensToCST();
	}
}