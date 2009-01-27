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
 * $Id: OCLTokenColorer.java,v 1.2 2009/01/27 21:21:13 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTokenColorer;

public class OCLTokenColorer extends CommonTokenColorer
{
	@Override
	protected TextAttribute getInterColoring(String interChars) {
		if (interChars.trim().startsWith("/*"))
			return paragraphCommentAttribute;
		else
			return lineCommentAttribute;
	}
}
