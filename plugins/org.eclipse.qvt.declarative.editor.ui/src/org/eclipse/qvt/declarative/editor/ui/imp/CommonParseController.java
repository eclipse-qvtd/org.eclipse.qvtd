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
 * $Id: CommonParseController.java,v 1.9 2008/10/11 15:37:56 ewillink Exp $
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
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
		protected final ICSTFileEnvironment fileEnvironment;
		protected ICSTRootEnvironment rootEnvironment;
		
		public ParsedResult(ICSTFileEnvironment fileEnvironment) {
			this.fileEnvironment = fileEnvironment;
		}

		public ICSTFileEnvironment getFileEnvironment() {
			return fileEnvironment;
		}

		public ICSTRootEnvironment getRootEnvironment() {
			return rootEnvironment;
		}

		public ICSTRootEnvironment parse(Reader reader, IProgressMonitor progressMonitor) throws IOException, CoreException {
			rootEnvironment = fileEnvironment.parse(reader, fileEnvironment.getFile(), progressMonitor);
			if (rootEnvironment == null)
				return null;
			rootEnvironment.validate();
			setCST(rootEnvironment.getCSTNode());
			setAST(rootEnvironment.getASTNode());
			return rootEnvironment;
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
//    private String fKeywords[];
    private List<String> keywords = null;
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
        if (keywords == null) {
            // SMS 25 Jun 2007
            // Added try-catch block in case parser is null
            try {
                String tokenKindNames[]= getParser().orderedTerminalSymbols();
                this.fIsKeyword= new boolean[tokenKindNames.length];
//                this.fKeywords= new String[tokenKindNames.length];
                this.keywords = new ArrayList<String>();
                int[] keywordKinds= getKeywordKinds();
                for(int i= 1; i < keywordKinds.length; i++) {
                    int index= getParser().mapKind(keywordKinds[i]);
                    fIsKeyword[index]= true;
//                    fKeywords[index]= tokenKindNames[index];
                    keywords.add(tokenKindNames[index]);
                }
            } catch (NullPointerException e) {
                System.err.println(getClass().getSimpleName() + ".cacheKeywordsOnce():  NullPointerException; trapped and discarded");
            }
        }
    }

	protected ICSTFileEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI astURI = fileHandle.getURI().appendFileExtension(creationFactory.getXMLExtension());
		return creationFactory.createFileEnvironment(fileHandle, resourceSet, astURI);
	}

	protected ProblemHandler createProblemHandler(ICSTFileEnvironment environment) {
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
			object = ((CSTNode) object).getAst();
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
		return fCurrentAst.getFileEnvironment().getASTMapping(object);
	}

    public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	public ParsedResult getCurrentAst() {
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

	public List<String> getKeywords() {
		return keywords;
	}

	public ILabelProvider getLabelProvider() {
		return ServiceFactory.getInstance().getLabelProvider(fLanguage);
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
		return creationFactory.createNodeLocator(fCurrentAst.getFileEnvironment());
	}

	public AbstractParser getParser() {
		if (fCurrentAst == null)
			return null;
		ICSTFileEnvironment fileEnvironment = fCurrentAst.getFileEnvironment();
		return fileEnvironment.getParser();
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
            IToken[] adjuncts = null;
            int adjunctIdx= -1;
            {
                if (lastTokIdx > firstTokIdx)		// Skip if not yet parsed
                	loadPrecedingAdjuncts();
            }

            private int getTokenIndexAtCharacter(int offset) {
                int result= stream != null ? stream.getTokenIndexAtCharacter(offset) : 0;
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

    public boolean isCompleteable(int kind) {
    	switch (getTokenKind(kind)) {
	    	case IDENTIFIER:
	    	case INTEGER:
	    	case KEYWORD:
	    	case REAL:
	    	case STRING:
	    		return true;
	    }
    	return false;
    }

    public boolean isIdentifier(int kind) {
    	return getTokenKind(kind) == TokenKind.IDENTIFIER;
    }

    public boolean isKeyword(int kind) {
        String tokenKindNames[] = getParser().orderedTerminalSymbols();
    	return kind < tokenKindNames.length && fIsKeyword[kind];
    }

	public ParsedResult parse(String contents, boolean scanOnly, IProgressMonitor progressMonitor) {
//		FIXME scanOnly appears to be false always
		System.out.println(id + " Parse " + fFilePath.toString() + " " + fLanguage + " scanOnly = " + scanOnly + " handler = " + handler.getClass().getName());
		if (progressMonitor.isCanceled())
			return fCurrentAst;
		ICSTFileEnvironment fileEnvironment = createEnvironment(getFileHandle());
		fileEnvironment.setProblemHandler(createProblemHandler(fileEnvironment));
		ParsedResult newResult = null;
		try {
			ParsedResult workingResult = new ParsedResult(fileEnvironment);
			workingResult.parse(new StringReader(contents), progressMonitor);
			newResult = workingResult;
		} catch (IOException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} catch (CoreException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} finally {
			fCurrentAst = newResult;		// Change only when all done.			
		}
		// FIXME my_monitor
		cacheKeywordsOnce();
		return fCurrentAst;
	}
}
