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
 * $Id: QVTrReferenceResolver.java,v 1.1 2008/08/10 13:51:13 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonReferenceResolver;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

public class QVTrReferenceResolver extends CommonReferenceResolver
{
	/**
	 * Get the target for a given source node in the AST represented by a
	 * given Parse Controller.
	 */
	public Object getLinkTarget(Object node, IParseController controller) {
		// START_HERE
		// Replace the given implementation with an implementation
		// that is suitable to you language and link types

		// NOTE:  The code shown in this method body works with the
		// example grammar used in the SAFARI language-service templates.
		// It may be adaptable for use with other languages.  HOWEVER,
		// this particular code is not essential to reference resolvers
		// in general, and the user should provide an implementation
		// that is appropriate to the language and AST structure for
		// which the service is being defined.

		if (node instanceof IdentifierCS)
			return ((IdentifierCS) node).getValue();
		if (node instanceof IdentifiedCS) {
			IdentifierCS identifier = ((IdentifiedCS) node).getIdentifier();
			return identifier != null ? identifier.getValue() : null;
		}
		
//		if (node instanceof Iidentifier && controller.getCurrentAst() != null) {
//			identifier id = (identifier) node;
//			Km3Parser parser = (Km3Parser) ((SimpleLPGParseController) controller)
//					.getParser();
//			Km3Parser.SymbolTable symtab = parser.getEnclosingSymbolTable(id);
//			return symtab.findDeclaration(id.toString());
//		}

		return null;
	}
}
