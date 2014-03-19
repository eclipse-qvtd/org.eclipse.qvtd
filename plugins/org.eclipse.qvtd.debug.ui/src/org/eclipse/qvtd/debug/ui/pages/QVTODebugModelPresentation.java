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
import org.eclipse.ocl.examples.debug.core.QVTODebugTarget;
import org.eclipse.ocl.examples.debug.core.QVTOStackFrame;
import org.eclipse.ocl.examples.debug.core.QVTOThread;
import org.eclipse.ocl.examples.debug.core.QVTOValue;
import org.eclipse.ocl.examples.debug.core.QVTOVariable;
import org.eclipse.ocl.examples.debug.vm.data.VMLocation;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.core.QVTOBreakpoint;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.actions.QVTODebugImages;
import org.eclipse.qvtd.debug.ui.messages.DebugUIMessages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;


public class QVTODebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation, IDebugModelPresentationExtension, IColorProvider, ILabelProvider {
	
	public QVTODebugModelPresentation() {
		super();
	}
	
	public void setAttribute(String attribute, Object value) {
	}

    public Image getImage(Object element) {
//    	System.out.println("getImage: " + element.getClass().getSimpleName() + " " + element);
    	if (element instanceof QVTOStackFrame) {
        	QVTOStackFrame frame = (QVTOStackFrame) element;
    		VMLocation location = frame.getLocation();
    		String elementSignature = location.getElementSignature();
            if (elementSignature != null) {
    			return QVTODebugImages.getImage(QVTODebugImages.MAPPING);
            }
            else {
    			return QVTODebugImages.getImage(QVTODebugImages.TRANSFORMATION);
            } 
        }
        else if(element instanceof QVTOVariable) {
    		QVTOVariable var = (QVTOVariable) element;
    		if (var.isModelParameter()) {
    			return QVTODebugImages.getImage(QVTODebugImages.MODEL_PARAMETER);
    		} else if (var.isReference()) {
    			return QVTODebugImages.getImage(QVTODebugImages.REFERENCE);
    		} else if (var.isAttribute()) {
    			return QVTODebugImages.getImage(QVTODebugImages.ATTRIBUTE);
    		} else if (var.isIntermProperty()) {
    			return QVTODebugImages.getImage(QVTODebugImages.INTERM_PROPERTY);
    		} else if (var.isLocalVariable()) {
    			return QVTODebugImages.getImage(QVTODebugImages.LOCAL_VARIABLE);
    		} else if (var.isPredefinedVariable()) {
    			// TODO - add special case for this
    			try {
					if("this".equals(var.getName())) { //$NON-NLS-1$
						return QVTODebugImages.getImage(QVTODebugImages.THIS_VARIABLE);
					}
				} catch (DebugException e) {
					// do nothing use the std image
				}
    			return QVTODebugImages.getImage(QVTODebugImages.PREDEFINED_VARIABLE);
    		} else if(var.isCollectionElement()) {
    			return QVTODebugImages.getImage(QVTODebugImages.COLLECTION_ELEMENT);
    		}
    		
    	} else if (element instanceof QVTOBreakpoint) {
            QVTOBreakpoint breakpoint = (QVTOBreakpoint) element;
            try {
                if (breakpoint.isConditionEnabled()) {                	
                    return breakpoint.isEnabled() ? 
                    		QVTODebugImages.getImage(QVTODebugImages.CONDITIONAL_BPNT_ENABLED) :
                    			QVTODebugImages.getImage(QVTODebugImages.CONDITIONAL_BPNT_DISABLED);
                } 
            } catch (CoreException ex) {
                QVTdDebugUIPlugin.log(ex);
            }
        }
        
        return null;
	}

	public String getText(Object element) {
//    	System.out.println("getText: " + element.getClass().getSimpleName() + " " + element);
        if (element instanceof QVTOStackFrame) {
        	QVTOStackFrame frame = (QVTOStackFrame) element;
    		VMLocation location = frame.getLocation();
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
        else if (element instanceof QVTOThread) {
        	QVTOThread thread = (QVTOThread) element;
        	String name = "main"; //$NON-NLS-1$
        	String state = thread.isSuspended() ? DebugUIMessages.QVTODebugModelPresentation_Suspended : DebugUIMessages.QVTODebugModelPresentation_Running;
        	return MessageFormat.format(DebugUIMessages.QVTODebugModelPresentation_ThreadLabel, name, state);
        } 
        else if (element instanceof QVTODebugTarget) {
        	QVTODebugTarget debugTarget = (QVTODebugTarget) element;
			String moduleName = debugTarget.getMainModuleName();
			String launchConfigName = debugTarget.getLaunch().getLaunchConfiguration().getName();
			return NLS.bind(DebugUIMessages.QVTODebugModelPresentation_TransformationLabel, moduleName, launchConfigName);
        }
        return null;
	}

    public void computeDetail(IValue value, IValueDetailListener listener) {
    	if(value instanceof QVTOValue) {
    		QVTOValue qvtValue = (QVTOValue) value;
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
