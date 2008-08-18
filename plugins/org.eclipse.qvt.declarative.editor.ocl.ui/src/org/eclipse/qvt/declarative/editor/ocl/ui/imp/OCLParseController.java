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
 * $Id: OCLParseController.java,v 1.2 2008/08/18 07:43:06 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.qvt.declarative.editor.ocl.ui.OCLCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.ocl.environment.OCLTopLevelEnvironment;

public class OCLParseController extends CommonParseController
{
	public OCLParseController() {
		super(OCLCreationFactory.INSTANCE);
		CSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected OCLTopLevelEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return new OCLTopLevelEnvironment(fileHandle, resourceSet);
	}

	@Override
	public ISourcePositionLocator getNodeLocator() {
		return new OCLNodeLocator(environment);
	}

	@Override
	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case OCLLexer.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case OCLLexer.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case OCLLexer.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case OCLLexer.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case OCLLexer.TK_STRING_LITERAL:
             return TokenKind.STRING;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
