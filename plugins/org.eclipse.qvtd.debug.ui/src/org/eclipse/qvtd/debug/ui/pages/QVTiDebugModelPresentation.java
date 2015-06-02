/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.core.VMStackFrame;
import org.eclipse.ocl.examples.debug.vm.core.VMThread;
import org.eclipse.ocl.examples.debug.vm.core.VMVariable;
import org.eclipse.ocl.examples.debug.vm.ui.actions.DebugVMImages;
import org.eclipse.ocl.examples.debug.vm.ui.pages.VMDebugModelPresentation;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.actions.QVTiDebugImages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;

public class QVTiDebugModelPresentation extends VMDebugModelPresentation
{
    public Image getImage(Object element) {		// FIXME Inherit most of this
    	if (element instanceof VMDebugTarget) {
    		return QVTiDebugImages.getImage(QVTiDebugImages.TRANSFORMATION);
    	}
    	else if (element instanceof VMThread) {
        	return null;
        }
    	else if (element instanceof VMStackFrame) {
        	return null;
/*        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.MAPPING);
            }
            else {
    			return QVTiDebugImages.getImage(QVTiDebugImages.TRANSFORMATION);
            }  */
        }
        else if(element instanceof VMVariable) {
    		VMVariable var = (VMVariable) element;
    		if (var.isModelParameter()) {
    			return DebugVMImages.getImage(DebugVMImages.MODEL_PARAMETER);
    		} else if (var.isReference()) {
    			return DebugVMImages.getImage(DebugVMImages.REFERENCE);
    		} else if (var.isAttribute()) {
    			return DebugVMImages.getImage(DebugVMImages.ATTRIBUTE);
    		} else if (var.isIntermProperty()) {
    			return DebugVMImages.getImage(DebugVMImages.INTERM_PROPERTY);
    		} else if (var.isLocalVariable()) {
    			return DebugVMImages.getImage(DebugVMImages.LOCAL_VARIABLE);
    		} else if (var.isPredefinedVariable()) {
    			// TODO - add special case for this
    			try {
					if("this".equals(var.getName())) { //$NON-NLS-1$
						return DebugVMImages.getImage(DebugVMImages.THIS_VARIABLE);
					}
				} catch (DebugException e) {
					// do nothing use the std image
				}
    			return DebugVMImages.getImage(DebugVMImages.PREDEFINED_VARIABLE);
    		} else if(var.isCollectionElement()) {
    			return DebugVMImages.getImage(DebugVMImages.COLLECTION_ELEMENT);
    		}
    		
    	} else if (element instanceof VMLineBreakpoint) {
            VMLineBreakpoint breakpoint = (VMLineBreakpoint) element;
            try {
                if (breakpoint.isConditionEnabled()) {                	
                    return breakpoint.isEnabled() ? 
                    		DebugVMImages.getImage(DebugVMImages.CONDITIONAL_BPNT_ENABLED) :
                    			DebugVMImages.getImage(DebugVMImages.CONDITIONAL_BPNT_DISABLED);
                } 
            } catch (CoreException ex) {
                QVTdDebugUIPlugin.log(ex);
            }
        }
        
        return null;
	}

/*	public String getText(Object element) {
        if (element instanceof VMDebugTarget) {
        	VMDebugTarget debugTarget = (VMDebugTarget) element;
			String moduleName = debugTarget.getMainModuleName();
			String launchConfigName = debugTarget.getLaunch().getLaunchConfiguration().getName();
			return NLS.bind(DebugUIMessages.QVTiDebugModelPresentation_TransformationLabel, moduleName, launchConfigName);
        }
        else if (element instanceof VMThread) {
        	VMThread thread = (VMThread) element;
        	String name = "main"; //$NON-NLS-1$
        	String state = thread.isSuspended() ? DebugUIMessages.QVTiDebugModelPresentation_Suspended : DebugUIMessages.QVTiDebugModelPresentation_Running;
        	return MessageFormat.format(DebugUIMessages.QVTiDebugModelPresentation_ThreadLabel, name, state);
        } 
        else if (element instanceof VMStackFrame) {
        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String source = frame.getUnitURI().lastSegment();
    		int line = frame.getLineNumber();
            StringBuilder s = new StringBuilder();
//            s.append(location.getModule());
            String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
//            	s.append("::");
            	s.append(elementSignature);
            }
        	s.append(" - ");
        	s.append(source);
        	s.append(":");
        	s.append(line);
            return s.toString();
        } 
        return null;
	} */

	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint) {
			return QVTimperativeEditor.EDITOR_ID;
		}
		return null;
	}
}
