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
 * $Id: CommonParseController.java,v 1.1 2008/08/08 16:42:46 ewillink Exp $
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

import java.util.Iterator;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.SimpleAnnotationTypeInfo;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;

/**
 * Base class for an IParseController implementation that encapsulates a simple LPG-based
 * scanner and parser.  Implements IParseController because methods defined there are
 * used here.
 * 
 * @author rfuhrer
 */
public abstract class CommonParseController implements IParseController
{
	protected final Language fLanguage;

    protected ISourceProject fProject;

    protected IPath fFilePath;

    protected IMessageHandler handler;
    
    protected Object fCurrentAst;

    private char fKeywords[][];

    private boolean fIsKeyword[];

    private final SimpleAnnotationTypeInfo fSimpleAnnotationTypeInfo= new SimpleAnnotationTypeInfo();
    
    /**
     * An adapter from an Eclipse IProgressMonitor to an LPG Monitor
     */
    protected static class PMMonitor implements Monitor {
    	private IProgressMonitor monitor;

    	private boolean wasCancelled= false;

    	public PMMonitor(IProgressMonitor monitor) {
    		this.monitor= monitor;
    	}

    	public boolean isCancelled() {
    		if (!wasCancelled)
    			wasCancelled= monitor.isCanceled();
    		return wasCancelled;
    	}

    	public void setMonitor(IProgressMonitor monitor) {
    		this.monitor= monitor;
    	}
    }

    public CommonParseController(String languageID) {
        fLanguage= LanguageRegistry.findLanguage(languageID);
    }

    public Language getLanguage() {
        return fLanguage;
    }

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
    }

    public abstract AbstractParser getParser();

    public abstract AbstractLexer getLexer();

    public ISourceProject getProject() {
	return fProject;
    }

    public IPath getPath() {
	return fFilePath;
    }

    public IMessageHandler getHandler() {
    	return handler;
    }

    public Object getCurrentAst() {
	return fCurrentAst;
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

    public IAnnotationTypeInfo getAnnotationTypeInfo() {
        return fSimpleAnnotationTypeInfo;
    }

    public boolean isKeyword(int kind) {
        String tokenKindNames[]= getParser().orderedTerminalSymbols();
    	return kind < tokenKindNames.length && fIsKeyword[kind];
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
                System.err.println("SimpleLPGParseController.cacheKeywordsOnce():  NullPointerException; trapped and discarded");
            }
        }
    }

	protected abstract int[] getKeywordKinds();
}
