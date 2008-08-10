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
 * $Id: CommonContentProposer.java,v 1.1 2008/08/10 13:46:14 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.imp.services.IContentProposer;
import org.eclipse.ocl.cst.CSTNode;

public abstract class CommonContentProposer implements IContentProposer
{
	protected ArrayList<CSTNode> filterSymbols(HashMap<?,CSTNode> in_symbols, String prefix) {
		ArrayList<CSTNode> symbols = new ArrayList<CSTNode>();
		for (Iterator<CSTNode> i = in_symbols.values().iterator(); i.hasNext();) {
			CSTNode decl = i.next();
			String name = getVariableName(decl);
			if (name.length() >= prefix.length()
					&& prefix.equals(name.substring(0, prefix.length())))
				symbols.add(decl);
		}
		return symbols;
	}

	protected String getPrefix(CommonParseController controller, IToken token, int offset) {
		if (controller.isIdentifier(token.getKind()))
			if ((token.getStartOffset() <= offset) && (offset <= token.getEndOffset() + 1))
				return token.toString().substring(0, offset - token.getStartOffset());
		return "";
	}

	protected IToken getToken(CommonParseController controller, int offset) {
		PrsStream stream = controller.getParser();
		int index = stream.getTokenIndexAtCharacter(offset), token_index = (index < 0 ? -(index - 1)
				: index), previous_index = stream.getPrevious(token_index);
		int previousIndexKind = stream.getKind(previous_index);
		boolean isIdentifier = controller.isIdentifier(previousIndexKind);
		boolean isKeyword = controller.isKeyword(previousIndexKind);
		boolean atEnd = offset == stream.getEndOffset(previous_index) + 1;
		return stream.getIToken(((isIdentifier || isKeyword) && atEnd) ? previous_index : token_index);
	}
	
	protected String getVariableName(CSTNode decl) {
//		if (decl instanceof declaration)
//			return ((declaration) decl).getidentifier().toString();
//		else if (decl instanceof functionHeader)
//			return ((functionHeader) decl).getidentifier().toString();
		return "";
	}
}
