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
 * $Id: QVTcParseController.java,v 1.2 2008/08/18 07:57:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcLexer;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;

public class QVTcParseController extends CommonParseController
{
	public QVTcParseController() {
		super(QVTcCreationFactory.INSTANCE);
		QVTcCSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected QVTcTopLevelEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return new QVTcTopLevelEnvironment(fileHandle, resourceSet);
	}

	@Override
	public ISourcePositionLocator getNodeLocator() {
		return new QVTcNodeLocator(environment);
	}

	@Override
	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case QVTcLexer.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case QVTcLexer.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case QVTcLexer.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case QVTcLexer.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case QVTcLexer.TK_STRING_LITERAL:
             return TokenKind.STRING;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
