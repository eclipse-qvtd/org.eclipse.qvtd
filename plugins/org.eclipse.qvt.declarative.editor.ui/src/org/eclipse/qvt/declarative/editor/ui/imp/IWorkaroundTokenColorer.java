/**
 * <copyright>
 * 
 * Copyright (c) 20098 E.D.Willink and others.
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
 * $Id: IWorkaroundTokenColorer.java,v 1.1 2009/01/27 21:21:15 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.text.TextAttribute;

/**
 * This temporary interface provides build compatibility pending the
 * availability of the functionality in org.eclipse.imp.services.ITokenColorer
 * submitted as Bug 262049.
 */
@Deprecated
public interface IWorkaroundTokenColorer
{
    /**
     * Provide coloring and font to use between a pair of tokens in the model.
     * @param model The model that contains the token
     * @param prevToken The token preceding the intertoken gap, null at start of file
     * @param nextToken The token following the intertoken gap, null at end of file
     * @return a TextAttribute
     */
    public TextAttribute getInterColoring(IParseController controller, Object prevToken, Object nextToken);
}
