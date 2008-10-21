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
 * $Id: CommonDocumentationProvider.java,v 1.3 2008/10/21 20:03:52 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IDocumentationProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;

public abstract class CommonDocumentationProvider implements IDocumentationProvider, ILanguageService
{
	public static String getSubstring(CommonParseController parseController, int start, int end) {
		return new String(parseController.getLexer().getInputChars(), start, end - start + 1);
	}

	public static String getSubstring(CommonParseController parseController, CSTNode cstNode) {
		return getSubstring(parseController, cstNode.getStartOffset(), cstNode.getEndOffset());
	}

	protected String getASTDocumentation(Object node) {
		if (node instanceof LiteralExp) {
			return EcoreUtils.formatName(((EObject)node).eClass()) + " : " + node.toString();
		}
		else if (node instanceof EObject) {
			return EcoreUtils.formatName(((EObject)node).eClass()) + " : " + EcoreUtils.formatQualifiedName(node);
		}
		return null;
	}

	protected String getCSTDocumentation(CSTNode cstNode, CommonParseController parseController) {
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

	public String getDocumentation(Object node, IParseController controller) {
		if (node == null)
			return null;
		if (node instanceof CSTNode)
			return getCSTDocumentation((CSTNode)node, (CommonParseController)controller);
		return getASTDocumentation(node);
	}

	public int getTokenKindForNode(CSTNode node) {
		// If you want some token for a node
		// other than the right token, compute
		// that here ...
		return node.getEndToken().getKind();
	}
}
