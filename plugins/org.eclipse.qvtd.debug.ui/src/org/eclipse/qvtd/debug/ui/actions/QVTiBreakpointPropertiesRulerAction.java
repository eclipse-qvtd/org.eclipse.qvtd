/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.actions.RulerBreakpointAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.debug.core.VMLineBreakpoint;
import org.eclipse.qvtd.debug.ui.messages.DebugUIMessages;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;


public class QVTiBreakpointPropertiesRulerAction extends RulerBreakpointAction implements IUpdate {
    
    private IBreakpoint fBreakpoint;

    public QVTiBreakpointPropertiesRulerAction(ITextEditor editor, IVerticalRulerInfo info) {
        super(editor, info); 
        setText(DebugUIMessages.QVTiBreakpointProperties_RulerActionLabel);
    }

    public void run() {
        if (getBreakpoint() != null) {
            PropertyDialogAction action= 
                new PropertyDialogAction(getEditor().getEditorSite(), new ISelectionProvider() {
                    public void addSelectionChangedListener(ISelectionChangedListener listener) {
                    }
                    public ISelection getSelection() {
                        return new StructuredSelection(getBreakpoint());
                    }
                    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
                    }
                    public void setSelection(ISelection selection) {
                    }
                });
            action.run();   
        }
    }
    
    /**
     * @see IUpdate#update()
     */
    public void update() {
        fBreakpoint = null;
        IBreakpoint breakpoint = getBreakpoint();
        if (breakpoint != null && (breakpoint instanceof VMLineBreakpoint)) {
            fBreakpoint = breakpoint;
        }
        setEnabled(fBreakpoint != null);
    }
}