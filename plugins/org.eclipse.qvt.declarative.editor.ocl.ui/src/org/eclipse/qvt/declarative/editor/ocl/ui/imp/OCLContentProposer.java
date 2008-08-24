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
 * $Id: OCLContentProposer.java,v 1.2 2008/08/24 18:58:00 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import java.util.ArrayList;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.imp.editor.SourceProposal;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonContentProposer;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;

public class OCLContentProposer  extends CommonContentProposer
{
/*	private HashMap getVisibleVariables(QVTcParser parser, ASTNode n) {
		HashMap map = new HashMap();
		for (QVTcParser.SymbolTable s = parser.getEnclosingSymbolTable(n); s != null; s = s
				.getParent())
			for (Enumeration e = s.keys(); e.hasMoreElements();) {
				Object key = e.nextElement();
				if (!map.containsKey(key))
					map.put(key, s.get(key));
			}

		return map;
	} */

	// SMS 23 Apr 2008:  original
/*	private String getVariableProposal(CSTNode decl) {
		String string = "";
		if (decl instanceof declaration) {
			// SMS 6 May 2008:  modified to put type in parens after identifier
			//            string = ((declaration) decl).getprimitiveType().toString() + " " +
			//                     ((declaration) decl).getidentifier().toString();
			string = ((declaration) decl).getidentifier().toString() + "  ("
					+ ((declaration) decl).getprimitiveType().toString() + ")";
		} else if (decl instanceof functionHeader) {
			functionHeader fdecl = (functionHeader) decl;
			declarationList parameters = fdecl.getparameters();
			string = fdecl.getType().toString() + " "
					+ fdecl.getidentifier().toString() + "(";
			for (int i = 0; i < parameters.size(); i++)
				string += ((declaration) parameters.getdeclarationAt(i))
						.getprimitiveType()
						+ (i < parameters.size() - 1 ? ", " : "");
			string += ")";
		}
		return string;
	} */

	// SMS 23 Apr 2008:  which had been replaced by ...
/*	private SourceProposal getDeclProposal(CSTNode decl, String prefix, int offset) {
		if (decl instanceof declaration) {
			String s = ((declaration) decl).getprimitiveType().toString() + " "
					+ ((declaration) decl).getidentifier().toString();
			return new SourceProposal(s, s, prefix, offset);
		} else if (decl instanceof functionDeclaration) {
			functionDeclaration fdecl = (functionDeclaration) decl;
			declarationList parameters = fdecl.getfunctionHeader()
					.getparameters();
			String newText;

			newText = fdecl.getfunctionHeader().getidentifier().toString()
					+ "(";
			for (int i = 0; i < parameters.size(); i++)
				newText += ((declaration) parameters.getdeclarationAt(i))
						.getprimitiveType()
						+ (i < parameters.size() - 1 ? ", " : "");
			newText += ")";
			String proposal = fdecl.getfunctionHeader().getType().toString()
					+ " " + newText;
			return new SourceProposal(proposal, newText, prefix, offset);
		}
		return null;
	} */

	/**
	 * Returns an array of content proposals applicable relative to the AST of the given
	 * parse controller at the given position.
	 * 
	 * (The provided ITextViewer is not used in the default implementation provided here
	 * but but is stipulated by the IContentProposer interface for purposes such as accessing
	 * the IDocument for which content proposals are sought.)
	 * 
	 * @param controller	A parse controller from which the AST of the document being edited
	 * 						can be obtained
	 * @param int			The offset for which content proposals are sought
	 * @param viewer		The viewer in which the document represented by the AST in the given
	 * 						parse controller is being displayed (may be null for some implementations)
	 * @return				An array of completion proposals applicable relative to the AST of the given
	 * 						parse controller at the given position
	 */
	public ICompletionProposal[] getContentProposals(IParseController controller, int offset, ITextViewer viewer) {
		ArrayList<ICompletionProposal> list = new ArrayList<ICompletionProposal>(); // a list of proposals.
		ASTandCST cstAndAST = (ASTandCST) controller.getCurrentAst();
		CSTNode cstRoot = cstAndAST != null ? cstAndAST.getCST() : null;
		if (cstRoot != null) {
			IToken token = getToken((CommonParseController) controller, offset);
			@SuppressWarnings("unused")
			String prefix = getPrefix((CommonParseController) controller, token, offset);
			OCLNodeLocator locator = new OCLNodeLocator(null);
			CSTNode node = (CSTNode) locator.findNode(cstRoot, token.getStartOffset(), token.getEndOffset());
			if (node != null) {
/*				if (node.getParent() instanceof Iexpression
				 || node.getParent() instanceof assignmentStmt
				 || node.getParent() instanceof BadAssignment) {
					HashMap symbols = getVisibleVariables(((AbstractLPG1ParseController) controller).getParser(), node);
					ArrayList vars = filterSymbols(symbols, prefix);
					for (int i = 0; i < vars.size(); i++) {
						CSTNode decl = (CSTNode) vars.get(i);
						// SMS 23 Apr 2008:  This is the original, which adds identifiers to the list
						list.add(new SourceProposal(getVariableProposal(decl),
								getVariableName(decl)
										+ (decl instanceof functionHeader ? "()"
												: ""), prefix, offset));
						// SMS 23 Apr 2008:  and which was replaced by this, which adds declarations
						list.add(getDeclProposal(decl, prefix, offset));
					}
				} */
			}
		} else
			list.add(new SourceProposal("no info available due to Syntax error(s)", "", offset));
		if (list.isEmpty())
			list.add(new SourceProposal("no completion exists for that prefix", "", offset));
		return (ICompletionProposal[]) list.toArray(new ICompletionProposal[list.size()]);
	}
}
