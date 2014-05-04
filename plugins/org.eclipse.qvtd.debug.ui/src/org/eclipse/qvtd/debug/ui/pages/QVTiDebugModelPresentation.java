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
package org.eclipse.qvtd.debug.ui.pages;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugModelPresentationExtension;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.examples.debug.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.core.VMValue;
import org.eclipse.ocl.examples.debug.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.core.VMStackFrame;
import org.eclipse.ocl.examples.debug.core.VMThread;
import org.eclipse.ocl.examples.debug.core.VMVariable;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.actions.QVTiDebugImages;
import org.eclipse.qvtd.debug.ui.messages.DebugUIMessages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;


public class QVTiDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation, IDebugModelPresentationExtension, IColorProvider, ILabelProvider {
	
	public QVTiDebugModelPresentation() {
		super();
	}
	
	public void setAttribute(String attribute, Object value) {
	}

    public Image getImage(Object element) {
//    	System.out.println("getImage: " + element.getClass().getSimpleName() + " " + element);
    	if (element instanceof VMStackFrame) {
        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.MAPPING);
            }
            else {
    			return QVTiDebugImages.getImage(QVTiDebugImages.TRANSFORMATION);
            } 
        }
        else if(element instanceof VMVariable) {
    		VMVariable var = (VMVariable) element;
    		if (var.isModelParameter()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.MODEL_PARAMETER);
    		} else if (var.isReference()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.REFERENCE);
    		} else if (var.isAttribute()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.ATTRIBUTE);
    		} else if (var.isIntermProperty()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.INTERM_PROPERTY);
    		} else if (var.isLocalVariable()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.LOCAL_VARIABLE);
    		} else if (var.isPredefinedVariable()) {
    			// TODO - add special case for this
    			try {
					if("this".equals(var.getName())) { //$NON-NLS-1$
						return QVTiDebugImages.getImage(QVTiDebugImages.THIS_VARIABLE);
					}
				} catch (DebugException e) {
					// do nothing use the std image
				}
    			return QVTiDebugImages.getImage(QVTiDebugImages.PREDEFINED_VARIABLE);
    		} else if(var.isCollectionElement()) {
    			return QVTiDebugImages.getImage(QVTiDebugImages.COLLECTION_ELEMENT);
    		}
    		
    	} else if (element instanceof VMLineBreakpoint) {
            VMLineBreakpoint breakpoint = (VMLineBreakpoint) element;
            try {
                if (breakpoint.isConditionEnabled()) {                	
                    return breakpoint.isEnabled() ? 
                    		QVTiDebugImages.getImage(QVTiDebugImages.CONDITIONAL_BPNT_ENABLED) :
                    			QVTiDebugImages.getImage(QVTiDebugImages.CONDITIONAL_BPNT_DISABLED);
                } 
            } catch (CoreException ex) {
                QVTdDebugUIPlugin.log(ex);
            }
        }
        
        return null;
	}

	public String getText(Object element) {
//    	System.out.println("getText: " + element.getClass().getSimpleName() + " " + element);
        if (element instanceof VMStackFrame) {
        	VMStackFrame frame = (VMStackFrame) element;
    		VMLocationData location = frame.getLocation();
    		String source = frame.getUnitURI().lastSegment();
    		int line = frame.getLineNumber();
            StringBuilder s = new StringBuilder();
            s.append(location.getModule());
            String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
            	s.append("::");
            	s.append(elementSignature);
            }
        	s.append(" - ");
        	s.append(source);
        	s.append(":");
        	s.append(line);
            return s.toString();
        } 
        else if (element instanceof VMThread) {
        	VMThread thread = (VMThread) element;
        	String name = "main"; //$NON-NLS-1$
        	String state = thread.isSuspended() ? DebugUIMessages.QVTiDebugModelPresentation_Suspended : DebugUIMessages.QVTiDebugModelPresentation_Running;
        	return MessageFormat.format(DebugUIMessages.QVTiDebugModelPresentation_ThreadLabel, name, state);
        } 
        else if (element instanceof VMDebugTarget) {
        	VMDebugTarget debugTarget = (VMDebugTarget) element;
			String moduleName = debugTarget.getMainModuleName();
			String launchConfigName = debugTarget.getLaunch().getLaunchConfiguration().getName();
			return NLS.bind(DebugUIMessages.QVTiDebugModelPresentation_TransformationLabel, moduleName, launchConfigName);
        }
        return null;
	}

    public void computeDetail(IValue value, IValueDetailListener listener) {
    	if(value instanceof VMValue) {
    		VMValue qvtValue = (VMValue) value;
    		try {
				listener.detailComputed(value, qvtValue.computeDetail());
			} catch (DebugException e) {
				QVTdDebugUIPlugin.log(e.getStatus());
			}
    	} else {
    		listener.detailComputed(value, value.toString());
    	}
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile) {
			return new FileEditorInput((IFile) element);
		}
		else if (element instanceof ILineBreakpoint) {
			return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
		}
		else {
			return null;
		}
	}

	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint) {
			return QVTimperativeEditor.EDITOR_ID;
		}

		return null;
	}
	
    public Color getForeground(Object element) {
    	return null;
    }
    
    public Color getBackground(Object element) {
    	return null;
    }	

	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		return false;
	}

	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
	}
    
    public void dispose() {
    }
        
    public boolean requiresUIThread(Object element) {    
    	return true;
    }    
    
    public void addListener(ILabelProviderListener listener) {
    }

    public void removeListener(ILabelProviderListener listener) {
	}    
}
