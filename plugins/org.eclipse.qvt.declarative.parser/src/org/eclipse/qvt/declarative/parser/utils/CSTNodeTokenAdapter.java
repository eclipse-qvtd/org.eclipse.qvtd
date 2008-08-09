/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.utils;

import java.util.List;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.cst.CSTNode;

/**
 * CSTNodeTokenAdapter emulates endToken and startToken fields pending revision of
 * CSTNode in accordance with Bugzilla 242153
 */
public class CSTNodeTokenAdapter extends AdapterImpl
{

	public static CSTNodeTokenAdapter getAdapter(CSTNode cstNode) {
		List<Adapter> eAdapters = cstNode.eAdapters();
		CSTNodeTokenAdapter adapter = (CSTNodeTokenAdapter) EcoreUtil.getAdapter(eAdapters, CSTNodeTokenAdapter.class);
		if (adapter == null) {
			adapter = new CSTNodeTokenAdapter();
			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static IToken getEndToken(CSTNode cstNode) {
		return getAdapter(cstNode).getEndToken();
	}

	public static IToken getStartToken(CSTNode cstNode) {
		return getAdapter(cstNode).getStartToken();
	}

	public static void setEndToken(CSTNode cstNode, IToken token) {
		getAdapter(cstNode).setEndToken(token);
		if (token != null)
			cstNode.setEndOffset(token.getEndOffset());
	}

	public static void setStartToken(CSTNode cstNode, IToken token) {
		getAdapter(cstNode).setStartToken(token);
		if (token != null)
			cstNode.setStartOffset(token.getStartOffset());
	}

	protected IToken endToken = null;
	protected IToken startToken = null;

	protected IToken getEndToken() {
		return endToken;
	}

	protected IToken getStartToken() {
		return startToken;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == CSTNodeTokenAdapter.class;
	}

	protected void setEndToken(IToken endToken) {
		this.endToken = endToken;
	}

	protected void setStartToken(IToken startToken) {
		this.startToken = startToken;
	}
}
