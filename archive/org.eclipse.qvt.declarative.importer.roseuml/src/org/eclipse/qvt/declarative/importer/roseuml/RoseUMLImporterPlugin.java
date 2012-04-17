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
package org.eclipse.qvt.declarative.importer.roseuml;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;

/**
 * The <b>Plugin</b> for the EMF.CodeGen.Ecore.Rose library.
 * @since 2.1.0
 */
public final class RoseUMLImporterPlugin extends EMFPlugin
{
	/**
	 *  The plug-in ID
	 */
	public static final String PLUGIN_ID = RoseUMLImporterPlugin.class.getPackage().getName();
	
    /**
     * The singleton instance of the plugin.
     */
    public static final RoseUMLImporterPlugin INSTANCE = new RoseUMLImporterPlugin();

    /**
     * The one instance of this class.
     */
    private static Implementation plugin;

    /**
     * Creates the singleton instance.
     */
    private RoseUMLImporterPlugin()
    {
        super(new ResourceLocator [] { ImporterPlugin.INSTANCE });
    }

	public static Status createErrorStatus(String string, Throwable e) {
		return new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, string, e);
	}

    /*
     * Javadoc copied from base class.
     */
    @Override
    public ResourceLocator getPluginResourceLocator()
    {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * @return the singleton instance.
     */
    public static Implementation getPlugin()
    {
        return plugin;
    }
    
	public static void logError(String string, Throwable e) {
		ILog log = getPlugin().getLog();
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
			ErrorDialog.openError(null, "RoseUML Error", null, createErrorStatus(string, e)); 		
	}

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     */
    public static class Implementation extends EclipsePlugin
    {
        /**
         * Creates an instance.
         */
        public Implementation()
        {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }
}
