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
 * $Id: CommonDocumentationProvider.java,v 1.2 2008/08/14 07:57:47 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IDocumentationProvider;
import org.eclipse.ocl.cst.CSTNode;

public abstract class CommonDocumentationProvider implements IDocumentationProvider, ILanguageService
{
	public static String getSubstring(CommonParseController parseController, int start, int end) {
		return new String(parseController.getLexer().getInputChars(), start, end - start + 1);
	}

	public static String getSubstring(CommonParseController parseController, CSTNode cstNode) {
		return getSubstring(parseController, cstNode.getStartOffset(), cstNode.getEndOffset());
	}

	public String getDocumentation(Object node, IParseController controller) {
		if (node == null)
			return null;
		if (node instanceof CSTNode) {
			CommonParseController parseController = (CommonParseController)controller;
			CSTNode cstNode = (CSTNode) node;
			CommonParseController.TokenKind tokenKind = parseController.getTokenKind(getTokenKindForNode(cstNode));
			switch (tokenKind) {
			case IDENTIFIER:
				return "'" + getSubstring(parseController, cstNode) + "' is an identifier";
			case INTEGER:
				return "'" + getSubstring(parseController, cstNode) + "' is an integer number";
			case REAL:
				return "'" + getSubstring(parseController, cstNode) + "' is a floating point number";
			case KEYWORD:
				return "'" + getSubstring(parseController, cstNode) + "' is a keyword";
			case LINE_COMMENT:
				return "'" + getSubstring(parseController, cstNode) + "' is a line comment";
			case PARAGRAPH_COMMENT:
				return "'" + getSubstring(parseController, cstNode) + "' is a paragraph comment";
			case STRING:
				return "'" + getSubstring(parseController, cstNode) + "' is a string";
			default:
				//return "No documentation available for token kind = " + tokenKind;
				return null;
			}
		}
		return null;
	}

	public int getTokenKindForNode(CSTNode node) {
		// If you want some token for a node
		// other than the right token, compute
		// that here ...
		return node.getEndToken().getKind();
	}
}
