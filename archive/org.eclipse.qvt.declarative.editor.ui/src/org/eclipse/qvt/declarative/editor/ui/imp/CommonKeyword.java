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
 * $Id: CommonKeyword.java,v 1.1 2008/12/04 07:50:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.ocl.cst.CSTNode;

public class CommonKeyword implements ICommonKeyword
{
	public static class Identifier extends CommonKeyword
	{
		public Identifier(String text) {
			super(text);
		}

		@Override
		public boolean isIdentifier(CSTNode cstNode) {
			return true;
		}
	}

	private final String text;

    public CommonKeyword(String text) {
		this.text = text;
	}

	public int compareTo(ICommonKeyword k) {
		return text.compareTo(k.getText());
	}
	
	public String getText() {
		return text;
	}

	public boolean isIdentifier(CSTNode cstNode) {
		return false;
	}
}