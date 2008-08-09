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
 * $Id: QVTcParseController.java,v 1.1 2008/08/09 17:55:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
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
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonProblemHandler;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcLexer;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcParser;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.IQVTcEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;


/**
 * NOTE:  This version of the Parse Controller is for use when the Parse
 * Controller and corresponding Node Locator are generated separately from
 * a corresponding set of LPG grammar templates and possibly in the absence
 * of the lexer, parser, and AST-related types that would be generated from
 * those templates.  It is assumed that either a) the Controller will be
 * used with a suitable set of lexer, parser, and AST-related types
 * that are provided by some means other than LPG, or b) the Controller will
 * be used with a set of lexer, parser, and AST types that have been, or will
 * be, separately generated based on LPG.  In order to enable this version of
 * the Parse Controller to compile, dummy lexer, parser, and AST-related types
 * have been included as member types in the Controller.  These types are not
 * operational and are merely placeholders for types that would support a
 * functioning implementation.  Apart from the inclusion of these dummy types,
 * this representation of the Parse Controller is the same as that used
 * with LPG.
 * 	
 * @author Stan Sutton (suttons@us.ibm.com)
 * @since May 1,  2007	Addition of marker types
 * @since May 10, 2007	Conversion IProject -> ISourceProject
 * @since May 15, 2007	Addition of dummy types
 */
public class QVTcParseController extends CommonParseController
{
	public QVTcParseController() {
		super(QVTcPlugin.kLanguageName);
		QVTcCSTPackage.eINSTANCE.getClass();
	}

	private QVTcTopLevelEnvironment environment;

	protected AbstractFileHandle getFileHandle() {
		IProject rawProject = fProject.getRawProject();
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(rawProject);
		EclipseFileHandle fileHandle = projectHandle.getFileHandle(fFilePath.toString());
		return fileHandle;
	}

	protected QVTcTopLevelEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return new QVTcTopLevelEnvironment(fileHandle, resourceSet);
	}

	protected int[] getKeywordKinds() {
		return getLexer().getKeywordKinds();
	}

	public QVTcLexer getLexer() {
		return getParser().getLexer();
	}

	public ISourcePositionLocator getNodeLocator() {
		return new QVTcNodeLocator(environment);
	}

	public QVTcParser getParser() {
		return (QVTcParser) environment.getParser();
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
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
			AbstractQVTAnalyzer<IQVTcEnvironment> analyzer = environment.parseToTokens(reader, monitor);
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
