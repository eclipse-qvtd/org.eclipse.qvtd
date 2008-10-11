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
 * $Id: CommonProposal.java,v 1.1 2008/10/11 15:38:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.editor.SourceProposal;
import org.eclipse.swt.graphics.Image;

public class CommonProposal extends SourceProposal implements ICommonProposal<CommonProposal>
{
	private final Image image;

	public CommonProposal(String proposal, String prefix, int offset) {
		super(proposal, proposal, prefix, offset);
		this.image = null;
	}

	public CommonProposal(String proposal, String newText, String prefix, int offset) {
		super(proposal, newText, prefix, offset);
		this.image = null;
	}

	public CommonProposal(String proposal, String newText, String prefix, int offset, Image image) {
		super(proposal, newText, prefix, offset);
		this.image = image;
	}

	public int compareTo(CommonProposal o) {
		return getDisplayString().compareTo(o.getDisplayString());
	}

	@Override
	public Image getImage() {
		return image;
	}
}