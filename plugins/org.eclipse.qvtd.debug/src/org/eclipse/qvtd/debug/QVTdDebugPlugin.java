/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.debug;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.stubs.QVTODebugUtil;
import org.osgi.framework.BundleContext;

public class QVTdDebugPlugin extends Plugin
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.debug";
	
	private static QVTdDebugPlugin plugin;

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *  
	 */
	public static void error(int code, String message, Throwable throwable) {
		log(Diagnostic.ERROR, code, message, throwable);
	}

	public static void error(String message, Throwable throwable) {
		error(0, message, throwable);
	}	

	public static void error(Throwable throwable) {
		error("", throwable); //$NON-NLS-1$
	}
	
	public static void error(String message) {
		error(0, message, null);
	}	

	public static QVTdDebugPlugin getDefault() {
		return plugin;
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
				getDefault().log(
					new Status(severity, PLUGIN_ID, code, msg, throwable));
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
    	QVTdDebugPlugin debugPlugin = getDefault();
		if(debugPlugin != null) {
			debugPlugin.getLog().log(status);
    	}
    } 

    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, "Exception caught", e)); //$NON-NLS-1$
    }

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}

	public IFile resolveWorskpaceFile(URI uri) {
		IFile sourceFile = QVTODebugUtil.toFile(uri);

/*		if(sourceFile == null && uri.isPlatformPlugin() && uri.segmentCount() > 2) {
			Map<URI, URI> uriMap = getPlatformPluginMap();
			
			URI baseURI = uri.trimSegments(uri.segmentCount() - 2);

			// key requires trailing slash
			URI key = baseURI.appendSegment(""); //$NON-NLS-1$
			URI mappedBaseURI = uriMap.get(key);
			if(mappedBaseURI == null) {
				mappedBaseURI = uriMap.get(baseURI);
			}

			if(mappedBaseURI != null) {
				List<String> segmentsList = uri.segmentsList();				
				segmentsList = segmentsList.subList(2, segmentsList.size());
				URI mappedURI = mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));			
				sourceFile = QVTODebugUtil.toFile(mappedURI);
			}
		} */
		return sourceFile;
	}

}
