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
 * Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 * E.D.Willink - abstracted API for common editing framework
 * 
 * </copyright>
 *
 * $Id: CommonParseController.java,v 1.7 2008/09/10 05:36:06 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;
/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Iterator;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.builder.ProblemLimit;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.environment.IFileAnalyzer;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;

/**
 * Base class for an IParseController implementation that encapsulates a simple LPG-based
 * scanner and parser.  Implements IParseController because methods defined there are
 * used here.
 * 
 * @author rfuhrer
 */
public abstract class CommonParseController implements IParseController
{
	private static int counter = 0;

	public static class ParsedResult extends ASTandCST
	{
		protected final IFileEnvironment environment;

		public ParsedResult(IFileEnvironment environment) {
			this.environment = environment;
		}

		public IFileEnvironment getEnvironment() {
			return environment;
		}

		public void parse(String contents, IProgressMonitor monitor) throws IOException, CoreException {
			Reader reader = new StringReader(contents);
			IFileAnalyzer analyzer = environment.parseToTokens(reader, monitor);
			if (analyzer != null) {
				CSTNode cstNode = analyzer.parseToCST();
				setCST(cstNode);
				if (cstNode != null) {
					URI uri = environment.getFile().getURI();
					Collection<? extends EObject> astNodes = analyzer.parseCSTtoAST(cstNode, uri);
					if (astNodes != null) {
						Resource resource = new XMIResourceImpl(uri);
						resource.getContents().addAll(astNodes);
						environment.initASTMapping(resource, cstNode);
						setAST(resource);
					}
				}
			}
		}
	}

	public enum TokenKind {
		EOF,
		IDENTIFIER,
		INTEGER,
		REAL,
		STRING,
		KEYWORD,
		LINE_COMMENT,			// e.g. a Java // comment
		PARAGRAPH_COMMENT,		// e.g. a Java /* ... */ comment
		OTHER
	}
	
	protected final ICreationFactory creationFactory;
	protected final Language fLanguage;
    protected ISourceProject fProject;
    protected IPath fFilePath;
    protected IMessageHandler handler;   
    protected ParsedResult fCurrentAst;
    private char fKeywords[][];
    private boolean fIsKeyword[];
    private final SimpleAnnotationTypeInfo fSimpleAnnotationTypeInfo = new SimpleAnnotationTypeInfo();
	private final String id;

    public CommonParseController(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
        fLanguage= creationFactory.getLanguage();
		id = getClass().getSimpleName() + "-" + ++ counter;
		System.out.println(id + " created");
    }

    protected void cacheKeywordsOnce() {
        if (fKeywords == null) {
            // SMS 25 Jun 2007
            // Added try-catch block in case parser is null
            try {
                String tokenKindNames[]= getParser().orderedTerminalSymbols();
                this.fIsKeyword= new boolean[tokenKindNames.length];
                this.fKeywords= new char[tokenKindNames.length][];
                int[] keywordKinds= getKeywordKinds();
                for(int i= 1; i < keywordKinds.length; i++) {
                    int index= getParser().mapKind(keywordKinds[i]);
                    fIsKeyword[index]= true;
                    fKeywords[index]= tokenKindNames[index].toCharArray();
                }
            } catch (NullPointerException e) {
                System.err.println(getClass().getSimpleName() + ".cacheKeywordsOnce():  NullPointerException; trapped and discarded");
            }
        }
    }

	protected IFileEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return creationFactory.createFileEnvironment(fileHandle, resourceSet);
	}

	protected ProblemHandler createProblemHandler(IFileEnvironment environment) {
		if (handler instanceof ProblemHandler) {
			((ProblemHandler)handler).setParser(environment.getParser());
			if (handler instanceof MarkerProblemHandler)
				((MarkerProblemHandler<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)handler).setProblemLimit(new ProblemLimit(50, 50, 50));
			return (ProblemHandler) handler;
		}
		else {
			CommonProblemHandler commonProblemHandler = new CommonProblemHandler(environment.getParser(), handler);
			commonProblemHandler.setProblemLimit(new ProblemLimit(50, 50, 50));
			return commonProblemHandler;
		}
	}

	public Object getASTNode(Object object) {
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		if (object instanceof CSTNode)
			object = ((CSTNode) object).getAstNode();
		return object;
	}

	public Object getASTorCSTNode(Object object) {
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		return object;
	}
	
    public IAnnotationTypeInfo getAnnotationTypeInfo() {
        return fSimpleAnnotationTypeInfo;
    }

	public CSTNode getCSTNode(Object object) {
		if (fCurrentAst == null)
			return null;
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		return fCurrentAst.getEnvironment().getASTMapping(object);
	}

    public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	public ASTandCST getCurrentAst() {
    	return fCurrentAst;
    }

	protected AbstractFileHandle getFileHandle() {
		IProject rawProject = fProject.getRawProject();
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(rawProject);
		EclipseFileHandle fileHandle = projectHandle.getFileHandle(fFilePath.toString());
		return fileHandle;
	}

    public IMessageHandler getHandler() {
    	return handler;
    }

	protected int[] getKeywordKinds() {
		return getLexer().getKeywordKinds();
	}

    public Language getLanguage() {
        return fLanguage;
    }

	public AbstractLexer getLexer() {
		return getParser().getLexer();
	}

	public ISourcePositionLocator getNodeLocator() {
		if (fCurrentAst == null)
			return null;
		return creationFactory.createNodeLocator(fCurrentAst.getEnvironment());
	}

	public AbstractParser getParser() {
		if (fCurrentAst == null)
			return null;
		return fCurrentAst.getEnvironment().getParser();
	}

    public IPath getPath() {
    	return fFilePath;
    }

    public ISourceProject getProject() {
    	return fProject;
    }

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
	}

    public Iterator<IToken> getTokenIterator(IRegion region) {
        final int offset= region.getOffset();
        final int length= region.getLength();

        return new Iterator<IToken>() {
            final PrsStream stream= CommonParseController.this.getParser();
            final int firstTokIdx= getTokenIndexAtCharacter(offset);
            final int lastTokIdx= getTokenIndexAtCharacter(offset + length - 1);
            int curTokIdx= Math.max(1, firstTokIdx); // skip bogus initial token
            IToken[] adjuncts;
            int adjunctIdx= -1;

            {
                loadPrecedingAdjuncts();
            }

            private int getTokenIndexAtCharacter(int offset) {
                int result= stream.getTokenIndexAtCharacter(offset);
                // getTokenIndexAtCharacter() answers the negative of the
                // index of the preceding token if the given offset is not
                // actually within a token.
                if (result < 0) {
                    result= -result + 1;
                }
                return result;
            }
            private void loadPrecedingAdjuncts() {
                try {
                	adjuncts= stream.getPrecedingAdjuncts(curTokIdx);
                } catch (IndexOutOfBoundsException e) {
                	System.out.println("curTokIdx = " + curTokIdx);
                	throw e;
                }
                for(adjunctIdx=0; adjunctIdx < adjuncts.length && adjuncts[adjunctIdx].getEndOffset() < offset; adjunctIdx++)
                    ;
                if (adjunctIdx >= adjuncts.length)
                    adjuncts= null;
            }
            private void loadFollowingAdjuncts() {
                adjuncts= stream.getFollowingAdjuncts(curTokIdx);
                if (adjuncts != null && (adjuncts.length == 0 || adjuncts[0].getStartOffset() >= offset + length))
                    adjuncts= null;
            }
            public boolean hasNext() {
                //return curTokIdx < lastTokIdx - 1 || (curTokIdx == lastTokIdx - 1 && adjunctIdx >= 0);
                return curTokIdx < lastTokIdx - 1 || (curTokIdx >= lastTokIdx - 1 && adjunctIdx >= 0 && 
                		((adjuncts != null && adjunctIdx < adjuncts.length && adjuncts[adjunctIdx].getStartOffset() < offset + length && adjuncts[adjunctIdx].getEndOffset() > offset)));
            }
            public IToken next() {
                if (adjunctIdx >= 0) {
                    if (adjuncts != null && adjunctIdx < adjuncts.length && adjuncts[adjunctIdx].getStartOffset() < offset + length && adjuncts[adjunctIdx].getEndOffset() > offset)
                        return adjuncts[adjunctIdx++];
                    adjunctIdx= -1;
                }
                IToken o= stream.getIToken(curTokIdx++);
                if (curTokIdx == stream.getSize() - 1)
                    loadFollowingAdjuncts();
                else
                    loadPrecedingAdjuncts();
                return o;
            }
            public void remove() {
                throw new IllegalArgumentException("Unimplemented");
            }
        };
    }

    public abstract TokenKind getTokenKind(int kind);

    /*
     * Defined in the IParseController interface.  The implementation here serves
     * as a super method to support initialization of lexer and parser in a concrete
     * subtype where the concrete lexer and parser types are known.
     * 
     * The handler parameter is required by the IParseController interface and is
     * used in a concrete subtype along with a concrete parser type.
     */
    public void initialize(IPath filePath, ISourceProject project, IMessageHandler handler) {
		this.fProject= project;
		this.fFilePath= filePath;	
		this.handler = handler;
		System.out.println(id + " initialized for " + fFilePath.toString());
    }

    public boolean isIdentifier(int kind) {
    	return getTokenKind(kind) == TokenKind.IDENTIFIER;
    }

    public boolean isKeyword(int kind) {
        String tokenKindNames[] = getParser().orderedTerminalSymbols();
    	return kind < tokenKindNames.length && fIsKeyword[kind];
    }

	public ParsedResult parse(String contents, boolean scanOnly, IProgressMonitor monitor) {
//		FIXME scanOnly appears to be false always
		System.out.println(id + " Parse " + fFilePath.toString() + " " + fLanguage + " scanOnly = " + scanOnly + " handler = " + handler.getClass().getName());
		if (monitor.isCanceled())
			return fCurrentAst;
		try {
			AbstractFileHandle fileHandle = getFileHandle();
			IFileEnvironment environment = createEnvironment(fileHandle);
			environment.getAnalyzer();		// Create parser
			ProblemHandler problemHandler = createProblemHandler(environment);
			environment.setProblemHandler(problemHandler);
			ParsedResult newResult = new ParsedResult(environment);
			newResult.parse(contents, monitor);
			fCurrentAst = newResult;		// Change only when all done.
		} catch (IOException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} catch (CoreException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		}
		// FIXME my_monitor
		cacheKeywordsOnce();
		return fCurrentAst;
	}
}
