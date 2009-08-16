/**
 * <copyright>
 * 
 * Copyright (c) 2008,2009 E.D.Willink and others.
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
 * $Id: CommonParseController.java,v 1.22 2009/08/16 10:30:19 ewillink Exp $
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

import lpg.lpgjavaruntime.ErrorToken;
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
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.utils.TracingOption;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.builder.ProblemLimit;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.qvt.declarative.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
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
	public static TracingOption parserProgress = new TracingOption(QVTEditorPlugin.PLUGIN_ID, "parser/progress");
	private static int counter = 0;

	private final class NullTokenIterator implements Iterator<IToken>
	{
		public boolean hasNext() {
			return false;
		}

		public IToken next() {
			return null;
		}

		public void remove() {
		}
	}

	private final class TokenIterator implements Iterator<IToken>
	{
		final PrsStream stream;
		final int firstTokIdx;
		final int lastTokIdx;
		int curTokIdx; // skip bogus initial token
		// The following declarations cover the whole input stream, which
		// may be a proper superset of the range of the given region.
		// For now, that's a simple way to collect the information, and
		// most often the given region corresponds to the whole input anyway.
		// In any case, iteration is based on the range of the given region.
		
		// The preceding adjuncts for each token
		IToken[][] precedingAdjuncts;
		// The current indices for each array of preceding adjuncts
		int[] nextPrecedingAdjunct;
		// The following adjuncts (for the last token only)
		IToken[] followingAdjuncts;
		// The current index for the array of following adjuncts
		int nextFollowingAdjunct;
		// To support hasNext(); initial values may be reset if appropriate
		private boolean finalTokenReturned;
		private boolean finalAdjunctsReturned;

		private TokenIterator(PrsStream stream, int regionEnd, int regionOffset) {
			this.stream = stream;
			firstTokIdx = getTokenIndexAtCharacter(regionOffset);
			curTokIdx = Math.max(1, firstTokIdx);
			{
				int endIdx = getTokenIndexAtCharacter(regionEnd);
			    char[] streamChars = stream.getInputChars();
			    if (streamChars != null) {
			    	try {
			    		if ((1 <= regionEnd) && (regionEnd < streamChars.length) && (streamChars[regionEnd] == IToken.EOF)) {
			    			// skip EOF token (assume LPG puts one at end of input character stream, since it does)
			    			endIdx--;
			    		}
			    	} catch (ArrayIndexOutOfBoundsException e) {
				        ErrorHandler.logError("SimpleLPGParseController.getTokenIterator(IRegion):  error initializing lastTokIdx", e);
//	            			System.err.println("getTokenIterator:  new Iterator(..)<init>:  ArrayIndexOutOfBoundsException");
//	            			System.err.println("    regionEnd = " + regionEnd + ", endIdx = " + endIdx + ", streamLen = " + streamLen + ", inputChars.length = " + streamChars.length);
			    	}
				}
				while (endIdx >= 0) {
					IToken lastToken = stream.getIToken(endIdx);
					if (!(lastToken instanceof ErrorToken))
						break;
					endIdx--;
				}
				lastTokIdx = endIdx;
			}
			precedingAdjuncts = new IToken[lastTokIdx+1][];
			nextPrecedingAdjunct = new int[lastTokIdx+1];
			{
				stream.setStreamLength();
				for (int i = 0; i < precedingAdjuncts.length; i++) {
					precedingAdjuncts[i] = stream.getPrecedingAdjuncts(i);
				}
			}
			{
				for (int i = 0; i < nextPrecedingAdjunct.length; i++) {
					if (precedingAdjuncts[i].length == 0)
						nextPrecedingAdjunct[i] = -1;
					else 
						nextPrecedingAdjunct[i] = 0;
				}
			}
			{
				if (lastTokIdx <= 0)
					followingAdjuncts = new IToken[0];
				else
					followingAdjuncts = stream.getFollowingAdjuncts(lastTokIdx);
			}
			{
				if (followingAdjuncts.length == 0)
					nextFollowingAdjunct = -1;
				else
			    	nextFollowingAdjunct = 0;
			}
			finalTokenReturned = regionEnd < 1 || lastTokIdx <= 0;
			finalAdjunctsReturned = !(followingAdjuncts.length > 0);
		}

		private int getTokenIndexAtCharacter(int offset) {
		    int result = stream.getTokenIndexAtCharacter(offset);
		    // getTokenIndexAtCharacter() answers the negative of the index of the
		    // preceding token if the given offset is not actually within a token.
		    if (result < 0) {
		        result= -result + 1;
		    }
		    
		    // The above may leave result set to a value that is one more than the
		    // last token index, so return the last token index if that's the case
		    // (This can happen if the end of the file contains some text that
		    // does not correspond to a token--e.g., if the text represents an adjunct
		    // or something unrecognized)
		    if (result >= stream.getTokens().size())
		    	result = stream.getTokens().size() - 1;
		    
		    return result;
		}

		/**
		 * Tests whether the iterator has any unreturned tokens.  These may include
		 * "regular" tokens and "adjunct" tokens (e.g., representing comments).
		 * 
		 * @return	True if there is another token available, false otherwise
		 */
		public boolean hasNext() {
		   	return !(finalTokenReturned && finalAdjunctsReturned);
		}

		/**
		 * Returns the next available token in the iterator (or null if there is none)
		 *
		 * Will return a valid token under conditions that would cause hasNext() to
		 * to return true; conversely, will return null under conditions that would
		 * cause hasNext() to return false.
		 * 
		 * As a side effect, updates the flags that are used to compute the value
		 * returned by hasNext().
		 * 
		 * The returned token may be a "regular" token (which will have a
		 * corresponding AST node) or an "adjunct" token (which will represent
		 * a comment).  The tokens are returned in the order in which they occur
		 * in the text, regardless of their kind.
		 * 
		 */
		public IToken next()
		{	
			int next = -1;	// for convenience
			
			// If we're not all the way through the tokens
			if (curTokIdx <= lastTokIdx) {
				
				// First check for any remaining preceding adjuncts
				// of the current token
		    	next = nextPrecedingAdjunct[curTokIdx];
		    	// If the current token has any unreturned preceding adjuncts
		    	if (next >= 0 && next < precedingAdjuncts[curTokIdx].length) {
		    		// Return the next preceding adjunct, incrementing the adjunct index afterwards
		    		return precedingAdjuncts[curTokIdx][nextPrecedingAdjunct[curTokIdx]++];
		    	}
		    	
				// Flag whether the current token is the last one
				finalTokenReturned = curTokIdx >= lastTokIdx;
				
				// Return the current token, incrementing the token index afterwards
		    	return stream.getIToken(curTokIdx++);
			}
			
			// If there are any adjuncts following the last token
			if (nextFollowingAdjunct >= 0 && nextFollowingAdjunct < followingAdjuncts.length) {
				
				// Flag whether the current adjunct is the last one
				finalAdjunctsReturned = (nextFollowingAdjunct+1) >= followingAdjuncts.length;
				
				// Return the current adjunct, incrementing the adjunct index afterwards
				return followingAdjuncts[nextFollowingAdjunct++];
			}
			
			return null;
		}

		public void remove() {
		    throw new IllegalArgumentException("Unimplemented");
		}
	}

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
			if (rootEnvironment.getCSTErrorTokens() <= 0)
				rootEnvironment.validate();
			setCST(rootEnvironment.getCSTNode());
			setAST(rootEnvironment.getASTNode());
			return rootEnvironment;
		}
	}

	public enum TokenKind {
		EOF,
		ERROR,
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
	private ICSTFileEnvironment fileEnvironment;
    protected ParsedResult fCurrentAst;
    private List<ICommonKeyword> keywords = null;
    private boolean fIsKeyword[];
    private final CommonAnnotationTypeInfo fSimpleAnnotationTypeInfo = new CommonAnnotationTypeInfo();
	private final String id;

    public CommonParseController(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
        fLanguage= creationFactory.getLanguage();
		id = getClass().getSimpleName() + "-" + ++ counter;
		if (parserProgress.isActive())
			parserProgress.println(id + " created");
		getAnnotationTypeInfo().addProblemMarkerType(creationFactory.getErrorMarkerId());
	}

    protected void cacheKeywordsOnce() {
        if (keywords == null) {
            // SMS 25 Jun 2007
            // Added try-catch block in case parser is null
            try {
                String tokenKindNames[]= getParser().orderedTerminalSymbols();
                this.fIsKeyword= new boolean[tokenKindNames.length];
                this.keywords = new ArrayList<ICommonKeyword>();
                int[] keywordKinds= getKeywordKinds();
                for(int i= 1; i < keywordKinds.length; i++) {
                    int index= getParser().mapKind(keywordKinds[i]);
                    fIsKeyword[index]= true;
                    keywords.add(createKeyword(tokenKindNames[index]));
                }
            } catch (NullPointerException e) {
            	QVTEditorPlugin.logError(getClass().getSimpleName() + ".cacheKeywordsOnce():  NullPointerException; trapped and discarded", e);
            }
        }
    }

	protected ICSTFileEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI astURI = fileHandle.getURI().appendFileExtension(creationFactory.getXMLExtension());
		return creationFactory.createFileEnvironment(fileHandle, resourceSet, astURI);
	}

	protected ICommonKeyword createKeyword(String text) {
		return new CommonKeyword(text);
	}

	protected ParsedResult createParsedResult(ICSTFileEnvironment fileEnvironment) {
		return new ParsedResult(fileEnvironment);
	}

	protected ProblemHandler createProblemHandler(ICSTFileEnvironment environment) {
		if (handler instanceof ProblemHandler) {
			((ProblemHandler)handler).setParser(environment.getParser());
			if (handler instanceof MarkerProblemHandler<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)
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
		return fCurrentAst.getRootEnvironment().getASTMapping(object);
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

	public List<ICommonKeyword> getKeywords() {
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

	@Deprecated // Use getSourcePositionLocator()
	public final ISourcePositionLocator getNodeLocator() {
		return getSourcePositionLocator();
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

	public ISourcePositionLocator getSourcePositionLocator() {
		if (fCurrentAst == null)
			return null;
		return creationFactory.createSourcePositionLocator(fCurrentAst.getRootEnvironment());
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
	}
	
	public Iterator<IToken> getTokenIterator(final IRegion region) {
        int regionOffset= region.getOffset();
        int regionLength= region.getLength();
    	int regionEnd = regionOffset + regionLength - 1;
		PrsStream stream =  getParser();
		if (stream != null)
			return new TokenIterator(stream, regionEnd, regionOffset);
		else
			return new NullTokenIterator();
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
		if (parserProgress.isActive())
			parserProgress.println(id + " initialized for " + fFilePath.toString());
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
        AbstractParser parser = getParser();
        if (parser == null)
        	return false;
		String tokenKindNames[] = parser.orderedTerminalSymbols();
    	return kind < tokenKindNames.length && fIsKeyword[kind];
    }

    public ParsedResult parse(String contents, IProgressMonitor progressMonitor) {
		fCurrentAst = parseInternal(contents, progressMonitor);
		// FIXME my_monitor
		cacheKeywordsOnce();
		return fCurrentAst;
	}

    // FIXME This is a workaround to Bug 257627
    public ParsedResult parseInternal(String contents, IProgressMonitor progressMonitor) {
		if (parserProgress.isActive())
			parserProgress.println(id + " Parse " + fFilePath.toString() + " " + fLanguage + " handler = " + handler.getClass().getName());
		if (progressMonitor.isCanceled())
			return fCurrentAst;
		if (fileEnvironment == null)
			fileEnvironment = createEnvironment(getFileHandle());
		fileEnvironment.setProblemHandler(createProblemHandler(fileEnvironment));
		ParsedResult newResult = null;
		try {
			ParsedResult workingResult = createParsedResult(fileEnvironment);
			workingResult.parse(new StringReader(contents), progressMonitor);
			newResult = workingResult;
		} catch (IOException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} catch (CoreException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		}
		return newResult;
	}
}
