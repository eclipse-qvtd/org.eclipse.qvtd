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
 * $Id: QVTrParseController.java,v 1.2 2008/08/18 07:57:37 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrLexer;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTopLevelEnvironment;

public class QVTrParseController extends CommonParseController
{
	public QVTrParseController() {
		super(QVTrCreationFactory.INSTANCE);
		QVTrCSTPackage.eINSTANCE.getClass();
	}

	@Override
	protected QVTrTopLevelEnvironment createEnvironment(AbstractFileHandle fileHandle) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return new QVTrTopLevelEnvironment(fileHandle, resourceSet);
	}

	@Override
	public ISourcePositionLocator getNodeLocator() {
		return new QVTrNodeLocator(environment);
	}

	@Override
	public TokenKind getTokenKind(int kind) {
		switch (kind) {
		case QVTrLexer.TK_EOF_TOKEN:
			return TokenKind.EOF;
		case QVTrLexer.TK_IDENTIFIER:
			return TokenKind.IDENTIFIER;
		case QVTrLexer.TK_INTEGER_LITERAL:
			return TokenKind.INTEGER;
		case QVTrLexer.TK_REAL_LITERAL:
			return TokenKind.REAL;
        case QVTrLexer.TK_STRING_LITERAL:
             return TokenKind.STRING;
		default:
			if (isKeyword(kind))
				return TokenKind.KEYWORD;
			return TokenKind.OTHER;
		}
	}
}
