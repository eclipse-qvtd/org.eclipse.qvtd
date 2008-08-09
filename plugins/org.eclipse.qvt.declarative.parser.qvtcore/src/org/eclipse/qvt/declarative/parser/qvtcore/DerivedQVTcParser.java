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
 * $Id: DerivedQVTcParser.java,v 1.1 2008/08/09 17:39:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.utils.CSTNodeTokenAdapter;

public class DerivedQVTcParser extends QVTcParser
{	
	public DerivedQVTcParser(QVTcLexer lexer) {
		super(lexer);
	}

	@Override
	protected void setOffsets(CSTNode cstNode) {
		throw new UnsupportedOperationException();	// Caller must recode to pass an IToken
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>IToken</code> to retrieve offsets from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		CSTNodeTokenAdapter.setStartToken(cstNode, startEnd);
		CSTNodeTokenAdapter.setEndToken(cstNode, startEnd);
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>CSTNode</code> to retrieve offsets from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		CSTNodeTokenAdapter.setStartToken(cstNode, CSTNodeTokenAdapter.getStartToken(startEnd));
		CSTNodeTokenAdapter.setEndToken(cstNode, CSTNodeTokenAdapter.getEndToken(startEnd));
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the 3rd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		CSTNodeTokenAdapter.setStartToken(cstNode, CSTNodeTokenAdapter.getStartToken(start));
		CSTNodeTokenAdapter.setEndToken(cstNode, CSTNodeTokenAdapter.getEndToken(end));
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		CSTNodeTokenAdapter.setStartToken(cstNode, CSTNodeTokenAdapter.getStartToken(start));
		CSTNodeTokenAdapter.setEndToken(cstNode, end);
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the given <code>IToken</code> and the
	 * end offset of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		CSTNodeTokenAdapter.setStartToken(cstNode, start);
		CSTNodeTokenAdapter.setEndToken(cstNode, CSTNodeTokenAdapter.getEndToken(end));
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 1std given <code>IToken</code> and the
	 * end offset of the 2nd given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	@Override
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		CSTNodeTokenAdapter.setStartToken(cstNode, start);
		CSTNodeTokenAdapter.setEndToken(cstNode, end);
	}
}
