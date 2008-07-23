/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;

public class QVTcAnalyzer extends AbstractQVTcAnalyzer
{
	protected final QVTcTopLevelEnvironment topLevelEnvironment;
	
	public QVTcAnalyzer(QVTcTopLevelEnvironment environment) {
		super(new QVTcParser(new QVTcLexer(environment)));
		topLevelEnvironment = environment;
	}
    
	public Collection<EPackage> parseWithDroppings(URI sourceURI, String saveStem) {
		CSTNode cstNode = parseToCST();
        if (cstNode == null) {
        	ERROR("Failed to create Concrete Syntax Tree");
			return null;
        }
		if (isCancelled())
			return null;
       	if (saveStem != null) {
       		try {
				topLevelEnvironment.saveCST(cstNode, URI.createFileURI(saveStem + ".qvtrcst"));
    		} catch (IOException e) {
    			ERROR(cstNode, null, "Failed to save CST : " + e.getMessage());
			}
       	}
		if (isCancelled())
			return null;
		Collection<EPackage> ast = parseCSTtoAST(cstNode, sourceURI); // Parse the token stream to produce an AST
        if (ast == null) {
        	ERROR(cstNode, null, "Failed to create Abstract Syntax Tree");
			return null;
        }
		if (isCancelled())
			return null;
        if (saveStem != null) {
       		try {
       			Resource resource = topLevelEnvironment.createASTResource(ast, URI.createFileURI(saveStem + ".qvtrelation"));
       			resource.save(null);
			} catch (IOException e) {
				ERROR(cstNode, null, "Failed to save AST : " + e.getMessage());
			}
        }
        return ast;
	}

	@Override public Collection<EPackage> parseCSTtoAST(CSTNode cstNode, URI sourceURI) {
		if (cstNode == null)
			return null;
		if (cstNode instanceof TopLevelCS) {
			defineTopLevelCS(topLevelEnvironment, (TopLevelCS)cstNode, sourceURI);
			return topLevelEnvironment.getEPackages();
		}
		ERROR(cstNode, "topLevelCS", "Expected a TopLevelCS rather than a " + formatEClassName(cstNode));
		return null;
	}
}
