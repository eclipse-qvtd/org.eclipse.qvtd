/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
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
 * $Id: EditorModelUtils.java,v 1.1 2009/01/17 20:18:43 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.utils;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.ocl.cst.CSTNode;

public class EditorModelUtils
{
	public static String getTokenFileName(CSTNode cstNode) {
		IToken token = cstNode.getStartToken();
		if (token == null)
			return null;
		PrsStream prsStream = token.getPrsStream();
		if (prsStream == null)
			return null;
		LexStream lexStream = prsStream.getLexStream();
		if (lexStream == null)
			return null;
		return lexStream.getFileName();
	}
}