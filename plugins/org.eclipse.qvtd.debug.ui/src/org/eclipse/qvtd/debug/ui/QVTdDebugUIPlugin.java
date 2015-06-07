/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui;

import java.net.URL;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.examples.debug.vm.ui.actions.DebugVMImages;
import org.eclipse.qvtd.debug.ui.actions.QVTiDebugImages;
import org.eclipse.qvtd.xtext.qvtimperative.ui.QVTimperativeEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTdDebugUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.qvtd.debug.ui"; //$NON-NLS-1$
	
	public static final String DEBUG_EDITOR_ID  = QVTimperativeEditor.EDITOR_ID; //$NON-NLS-1$	

	// The shared instance
	private static QVTdDebugUIPlugin plugin;

	private static final Logger logger = Logger.getLogger(QVTdDebugUIPlugin.class);

	protected ImageRegistry imageDescriptorRegistry;
	
	/**
	 * The constructor
	 */
	public QVTdDebugUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (imageDescriptorRegistry != null) {
			imageDescriptorRegistry.dispose();
			imageDescriptorRegistry = null;
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QVTdDebugUIPlugin getDefault() {
		return plugin;
	}

	
	public Image createImage(String path) {
		
		Image image = getImageRegistry().get(path);
		
		if (image == null) {
			try {
				ImageDescriptor imageDescriptor = getImageDescriptor(path);
				if (imageDescriptor != null) {
					image = getImageDescriptor(path).createImage();
					if (image != null) { getImageRegistry().put(path, image); }
				}
			}
			catch(Exception e) { logger.error("Failed to createImage '" + path + "'", e); }
		}
		
		return image;
	}
	
	public ImageDescriptor getImageDescriptor(String path) {
		
		ImageDescriptor imageDescriptor = getImageDescriptorRegistry().getDescriptor(path);
		
		if (imageDescriptor == null) {
			URL url = FileLocator.find(getBundle(), new Path(path), Collections.<String, String>emptyMap());
			if (url != null) {
				imageDescriptor = ImageDescriptor.createFromURL(url);
				if (imageDescriptor != null) getImageDescriptorRegistry().put(path, imageDescriptor);
			}
		}
		
		return imageDescriptor;
	}
	
	protected ImageRegistry getImageDescriptorRegistry() {
		if (imageDescriptorRegistry == null) {
			imageDescriptorRegistry = createImageRegistry();
		}
		return imageDescriptorRegistry;
	}
	
	public static BasicDiagnostic createDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.OK, PLUGIN_ID, 0, message, null);
	}
	
	public static Diagnostic createErrorDiagnostic(String message, Throwable throwable) {
		Object[] data = (throwable == null) ? null : new Object [] { throwable };
		return new BasicDiagnostic(Diagnostic.ERROR,  PLUGIN_ID, 0, message, data);
	}
	
	public static Diagnostic createWarnDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.ERROR,  PLUGIN_ID, 0, message, null);
	}	

	/**
	 * Indicates that the given diagnostic is neither error or canceled.
	 * 
	 * @param diagnostic
	 *            the diagnostic to test
	 * @return <code>true</code> in case of success, <code>false</code>
	 *         otherwise
	 */
	public static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity != Diagnostic.ERROR && severity != Diagnostic.CANCEL;
	}
	
	public static void log(int severity, int code, String message, Throwable throwable) {
		//
		// Status ctor requires a non-null message
		String msg = message == null
			? "" //$NON-NLS-1$
			: message;

		try {
			if (getDefault() != null) {
				// Eclipse environment
				log(new Status(severity, PLUGIN_ID, code, msg, throwable));
			} else {
				// not in the Eclipse environment
				//if (shouldTrace()) {
					switch (code) {
						case Diagnostic.WARNING :
							System.err.print("WARNING "); //$NON-NLS-1$
							break;
						case Diagnostic.ERROR :
						case Diagnostic.CANCEL :
							System.err.print("ERROR "); //$NON-NLS-1$
							break;
						default :
							// don't output INFO or OK messages
							return;
					}

					System.err.print(code);
					System.err.print(": "); //$NON-NLS-1$
					System.err.println(message);

					if (throwable != null) {
						throwable.printStackTrace(System.err);
					}
				//}
			}
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
	}

    public static void log(IStatus status) {
    	QVTdDebugUIPlugin debugPlugin = getDefault();
		if(debugPlugin != null) {
			debugPlugin.getLog().log(status);
    	}
    } 

    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, "Exception caught", e)); //$NON-NLS-1$
    }

	public static final Display getStandardDisplay() {
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		return display;
	}

	/**
	 * Returns the active workbench window
	 * 
	 * @return the active workbench window
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}

	/**
	 * Returns the active workbench shell or <code>null</code> if none
	 * 
	 * @return the active workbench shell or <code>null</code> if none
	 */
	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}

	public static IStatus createStatus(int severity, String message) {
		return new Status(severity, PLUGIN_ID, 0, message, null);
	}

	public static IStatus createErrorStatus(String message) {
		return createStatus(IStatus.ERROR, message);
	}
	
	@Override
	protected ImageRegistry createImageRegistry() {
		ImageRegistry imageRegistry = super.createImageRegistry();
		imageRegistry.put(DebugVMImages.LOCAL_VARIABLE, imageDescriptorFromPlugin(DebugVMUIPlugin.PLUGIN_ID, "localvar_obj.gif")); //$NON-NLS-1$		
//		imageRegistry.put(QVTiDebugImages.THIS_VARIABLE, imageDescriptor("thisvar_obj.gif")); //$NON-NLS-1$
//		imageRegistry.put(QVTiDebugImages.PREDEFINED_VARIABLE, imageDescriptor("predefvar_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(DebugVMImages.MODEL_PARAMETER, imageDescriptorFromPlugin(DebugVMUIPlugin.PLUGIN_ID, "modelpar_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(DebugVMImages.ATTRIBUTE, imageDescriptorFromPlugin(DebugVMUIPlugin.PLUGIN_ID, "attribute_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(DebugVMImages.REFERENCE, imageDescriptorFromPlugin(DebugVMUIPlugin.PLUGIN_ID, "reference_obj.gif")); //$NON-NLS-1$
//		imageRegistry.put(QVTiDebugImages.COLLECTION_ELEMENT, imageDescriptor("index_element_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTiDebugImages.MAPPING, imageDescriptor("Mapping.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTiDebugImages.TRANSFORMATION, imageDescriptor("Transformation.gif")); //$NON-NLS-1$
		
/*		imageRegistry.put(QVTiDebugImages.INTERM_PROPERTY,				
				overlayImage("intermprop_ovr.gif", //$NON-NLS-1$ 
						imageRegistry.get(QVTiDebugImages.ATTRIBUTE),
						IDecoration.BOTTOM_RIGHT));		
		
		imageRegistry.put(QVTiDebugImages.CONDITIONAL_BPNT_ENABLED,
				overlayImage("conditional_ovr.gif", //$NON-NLS-1$ 
						DebugUITools.getImage(IDebugUIConstants.IMG_OBJS_BREAKPOINT),
						IDecoration.TOP_LEFT));
		imageRegistry.put(QVTiDebugImages.CONDITIONAL_BPNT_DISABLED,
				overlayImage(
						"conditional_ovr_disabled.gif", //$NON-NLS-1$
						DebugUITools.getImage(IDebugUIConstants.IMG_OBJS_BREAKPOINT_DISABLED),
						IDecoration.TOP_LEFT));
*/
		return imageRegistry;
	}

	private ImageDescriptor imageDescriptor(String imagePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + imagePath); //$NON-NLS-1$
	}
	
/*    private final ImageDescriptor overlayImage(String overImagePath, Image base, int quadrant) {
        ImageDescriptor decorator = imageDescriptor(overImagePath);
        return new DecorationOverlayIcon(base, decorator, quadrant);
    } */
}
