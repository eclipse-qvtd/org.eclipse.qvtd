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
 * $Id: CommonTokenColorer.java,v 1.1 2008/08/09 17:49:00 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.imp.services.base.TokenColorerBase;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class CommonTokenColorer extends TokenColorerBase implements ITokenColorer
{
	protected TextAttribute commentAttribute;
	protected TextAttribute keywordAttribute;
	protected TextAttribute stringAttribute;
	protected TextAttribute numberAttribute;
	protected TextAttribute doubleAttribute;
	protected TextAttribute identifierAttribute;

	public CommonTokenColorer() {
		// TODO:  Define text attributes for the various
		// token types that will have their text colored
		Display display = Display.getDefault();
		commentAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_RED), null, SWT.ITALIC);
		stringAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_BLUE), null, SWT.BOLD);
		identifierAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_BLACK), null, SWT.NORMAL);
		doubleAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_GREEN), null, SWT.BOLD);
		numberAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_YELLOW), null, SWT.BOLD);
		keywordAttribute = new TextAttribute(display.getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD);
	}

	public IRegion calculateDamageExtent(IRegion seed) {
		return seed;
	}
}
