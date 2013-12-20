package org.eclipse.qvtd.debug.utils;
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTODebugCore { //extends Plugin {
	
	public static final String BREAKPOINT_MARKER_ID = "org.eclipse.qvtd.debug.QVTdBreakpointMarker"; //$NON-NLS-1$

	public static final String MODEL_ID = "org.eclipse.qvtd.debug"; //$NON-NLS-1$
	
	public static final String DEBUGGER_ACTIVE_PROPERTY = "org.eclipse.qvtd.debug.debuggerActive"; //$NON-NLS-1$
	
	// The plug-in fBreakpointID
	public static final String PLUGIN_ID = QVTdDebugPlugin.PLUGIN_ID; //$NON-NLS-1$

	public static Trace2 TRACE = new Trace2();	
	
	// The shared instance
	private static QVTODebugCore plugin;
	
	private Map<URI, URI> platformPluginMap;
	private IResourceChangeListener resourceListener; 
	private Object pluginMapLock = new Object();

	/**
	 * The constructor
	 */
	public QVTODebugCore() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 *
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		TRACE.start(plugin);
		
		resourceListener = createResourceListen();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
	} */

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 *
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		
		TRACE.stop();
		if(resourceListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener); 
		}
	} */

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QVTODebugCore getDefault() {
		return plugin;
	}
	
	public static IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, PLUGIN_ID, message, throwable);
	}
	
	public static IStatus createStatus(int severity, String message) {
		return createStatus(severity, message, null);
	}
	
	public static IStatus createError(String message, int code,  Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, code, message, throwable);
	}
	    
	public static <T extends IBreakpoint> List<T> getQVTOBreakpoints(Class<T> breakpointType) {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(MODEL_ID);
		List<T> result = new ArrayList<T>(breakpoints.length);
		for (IBreakpoint bp : breakpoints) {
			if(breakpointType.isInstance(bp)) {
				result.add(breakpointType.cast(bp));
			}
		}
		
		return result;
	}

	public URI resolvePlatformPluginURI(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return resolvePlatformPluginURI(uri);
	}
	
	public URI resolvePlatformPluginURI(URI uri) {
		Map<URI, URI> uriMap = getPlatformPluginMap();
		
		if(uri.isPlatformResource() && uri.segmentCount() > 2) {
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
				if(mappedBaseURI.hasTrailingPathSeparator()) {
					mappedBaseURI = mappedBaseURI.trimSegments(1);
				}
				return mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));
			}
		}
			
		return null;
	}
	
/*	public IFile resolveWorskpaceFile(URI uri) {
		IFile sourceFile = QVTODebugUtil.toFile(uri);

		if(sourceFile == null && uri.isPlatformPlugin() && uri.segmentCount() > 2) {
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
		}
		
		return sourceFile;
	} */
	
	private Map<URI, URI> getPlatformPluginMap() {
		synchronized (pluginMapLock) {
			if(platformPluginMap == null) {
				platformPluginMap = new HashMap<URI, URI>(); 
				
				Map<URI, URI> plugin2ResourceMap = EcorePlugin.computePlatformPluginToPlatformResourceMap();
				platformPluginMap.putAll(plugin2ResourceMap);
				
				for (Map.Entry<URI, URI> entry : plugin2ResourceMap.entrySet()) {
					platformPluginMap.put(entry.getValue(), entry.getKey());
				}
			}			
		}
		
		return platformPluginMap;
	}	
	
	private void resetPlatformPluginMap() {
		synchronized (pluginMapLock) {
			platformPluginMap = null;
		}
	}
	
	private boolean process(IResourceDelta delta) {
		IResource resource = delta.getResource();
		if(isManifest(resource)) {
			return true;
		}

		IResourceDelta[] affectedChildren = delta.getAffectedChildren();
		for (IResourceDelta childDelta : affectedChildren) {			
			if(process(childDelta)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isManifest(IResource resource) {
		if (resource.getType() == IResource.FILE
				&& resource.getName().equals("MANIFEST.MF") //$NON-NLS-1$
				&& resource.getProjectRelativePath().equals(
						new Path("META-INF/MANIFEST.MF"))) { //$NON-NLS-1$
			return true;
		}
		return false;
	}
	
	private IResourceChangeListener createResourceListen() {
		return new IResourceChangeListener() {
			
			public void resourceChanged(IResourceChangeEvent event) {
				if(event.getResource() instanceof IProject) {
					QVTODebugCore.this.resetPlatformPluginMap();
				}
				
				if(event.getDelta() != null) {
					if(process(event.getDelta())) {
						QVTODebugCore.this.resetPlatformPluginMap();
					}
				}
			}
		};
	}

	public static void log(IStatus status) {
		QVTdDebugPlugin.log(status);
	}

	public static void log(Throwable e) {
		QVTdDebugPlugin.log(e);
	}
}
