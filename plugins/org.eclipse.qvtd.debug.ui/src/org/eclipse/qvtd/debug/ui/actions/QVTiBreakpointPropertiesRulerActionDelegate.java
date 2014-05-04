/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

public class QVTiBreakpointPropertiesRulerActionDelegate  extends AbstractRulerActionDelegate {

    /**
     * @see AbstractRulerActionDelegate#createAction(ITextEditor, IVerticalRulerInfo)
     */
    protected IAction createAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {
    	
    	
        return new QVTiBreakpointPropertiesRulerAction(editor, rulerInfo);
    }
}