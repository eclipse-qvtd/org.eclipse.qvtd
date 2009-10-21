/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.qvt.declarative.compilation.ide.EclipseCompilationServiceConfigurator;
import org.eclipse.qvt.declarative.ecore.utils.TracingOption;
import org.eclipse.qvt.declarative.editor.ui.format.DefaultFormatManager;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTEditorPlugin extends EclipseUIPlugin
{
	// The plug-in ID
	public static final String PLUGIN_ID = QVTEditorPlugin.class.getPackage().getName();

	public static final String ID = QVTEditorPlugin.class.getPackage().getName();

	public static final TracingOption ANNOTATION_CREATE = new TracingOption(PLUGIN_ID, "annotation/create"); //$NON-NLS-1$
	public static final TracingOption ANNOTATION_DELETE = new TracingOption(PLUGIN_ID, "annotation/delete"); //$NON-NLS-1$
	public static final TracingOption ANNOTATION_UPDATE = new TracingOption(PLUGIN_ID, "annotation/update"); //$NON-NLS-1$

	public static final TracingOption EDITOR_SAVE = new TracingOption(PLUGIN_ID, "editor/save"); //$NON-NLS-1$

	public static final TracingOption MARKER_CREATE = new TracingOption(PLUGIN_ID, "marker/create"); //$NON-NLS-1$
	public static final TracingOption MARKER_DELETE = new TracingOption(PLUGIN_ID, "marker/delete"); //$NON-NLS-1$

	public static final TracingOption RESOURCE_LOAD = new TracingOption(PLUGIN_ID, "resource/load"); //$NON-NLS-1$

	public static final TracingOption SELECTION_INNER = new TracingOption(PLUGIN_ID, "selection/inner"); //$NON-NLS-1$
	public static final TracingOption SELECTION_OUTER = new TracingOption(PLUGIN_ID, "selection/outer"); //$NON-NLS-1$

	public static final TracingOption VISITOR_SELECTION = new TracingOption(PLUGIN_ID, "visitor/selection"); //$NON-NLS-1$
	public static final TracingOption VISITOR_TRACE = new TracingOption(PLUGIN_ID, "visitor/trace"); //$NON-NLS-1$

	// The shared instance
	public static QVTEditorPlugin INSTANCE;
	
	/**
	 * The constructor
	 */
	public QVTEditorPlugin() {
//		new EclipseCompilationServiceConfigurator();		// FIXME Move to start, eliminate dependency
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		DefaultFormatManager.initialize(DefaultFormatManager.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}

	public static Status createErrorStatus(String string, Throwable e) {
		return new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, string, e);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QVTEditorPlugin getDefault() {
		return INSTANCE;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	public static void logError(String string, Throwable e) {	// FIXME Exploit EclipseUIPLugin.log() 
		ILog log = INSTANCE.getLog();
		log.log(createErrorStatus(string, e));
	}

	public static void showError(final String string, final Exception e) {
//		logError(string, e);
		Display display = Display.getDefault();
		if (Thread.currentThread() != display.getThread()) {
			display.syncExec(new Runnable() {
				public void run() {
					showError(string, e);					
				}});
		}			
		else
			ErrorDialog.openError(null, "QVT Editor Error", null, createErrorStatus(string, e)); 		
	}
}
