/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: OCLParseController.java,v 1.1 2008/08/14 07:51:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.qvt.declarative.editor.ocl.ui.OCLPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonProblemHandler;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.ocl.OCLFileAnalyzer;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;

public class OCLParseController extends CommonParseController
{
	public OCLParseController() {
		super(OCLPlugin.kLanguageName);
		CSTPackage.eINSTANCE.getClass();
	}

	private OCLTopLevelEnvironment environment;

	protected OCLTopLevelEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return new OCLTopLevelEnvironment(fileHandle, resourceSet);
	}

	protected int[] getKeywordKinds() {
		return getLexer().getKeywordKinds();
	}

	public OCLLexer getLexer() {
		return getParser().getLexer();
	}

	public ISourcePositionLocator getNodeLocator() {
		return new OCLNodeLocator(environment);
	}

	public OCLParser getParser() {
		return (OCLParser) environment.getParser();
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
	}

	@Override
	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case OCLLexer.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case OCLLexer.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case OCLLexer.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case OCLLexer.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case OCLLexer.TK_STRING_LITERAL:
             return TokenKind.STRING;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}

	public Object parse(String contents, boolean scanOnly, IProgressMonitor monitor) {
		PMMonitor my_monitor = new PMMonitor(monitor);
		if (my_monitor.isCancelled())
			return fCurrentAst; // TODO currentAst might (probably will) be inconsistent wrt the lex stream now
		AbstractFileHandle fileHandle = getFileHandle();
		environment = createEnvironment(fileHandle);
		environment.getAnalyzer();		// Create parser
		environment.setProblemHandler(new CommonProblemHandler(environment.getParser(), handler));
		ASTandCST astAndCst = new ASTandCST(false);
		fCurrentAst = astAndCst;
		Reader reader = new StringReader(contents);
		try {
			OCLFileAnalyzer analyzer = environment.parseToTokens(reader, monitor);
			if (analyzer != null) {
				CSTNode cstNode = analyzer.parseToCST();
				astAndCst.setCST(cstNode);
				if (cstNode != null) {
					URI uri = fileHandle.getURI();
					Collection<? extends EObject> astNodes = analyzer.parseCSTtoAST(cstNode, uri);
					if (astNodes != null) {
						Resource resource = new XMIResourceImpl(uri);
						resource.getContents().addAll(astNodes);
						environment.initASTMapping(resource, cstNode);
						astAndCst.setAST(resource);
					}
				}
			}
		} catch (IOException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} catch (CoreException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		}		// FIXME my_monitor
		cacheKeywordsOnce();
		return fCurrentAst;
	}
}
