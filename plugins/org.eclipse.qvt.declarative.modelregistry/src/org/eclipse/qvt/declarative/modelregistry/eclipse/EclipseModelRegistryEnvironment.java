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
package org.eclipse.qvt.declarative.modelregistry.eclipse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.environment.AccessorKindRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelContentRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelSerializationRegistry;

public class EclipseModelRegistryEnvironment extends ModelRegistryEnvironment
{
	// The access kind extension point name
	public static final String ACCESSOR_KIND_PPID = "accessor_kind";
	// The model content extension point name
	public static final String MODEL_CONTENT_PPID = "model_content";
	// The model serialization extension point name
	public static final String MODEL_SERIALIZATION_PPID = "model_serialization";
	
	/**
	 * Return a File to access the URI, or null if the URI cannot be
	 * resolved to a file protocol.
	 * 
	 * @return the File
	 * @throws URISyntaxException if the URI syntax is bad
	 * @throws IOException if URL resolution fails
	 */
	@Override public File getFile(URI uri) throws URISyntaxException, IOException {
		String fileString = uri.toString();
		URL url = new URL(fileString);
		URL resolvedURL = FileLocator.toFileURL(url);
		if (!"file".equals(resolvedURL.getProtocol()))
			return null;
		return new File(resolvedURL.toString().substring(5));
	}	

	@Override protected void initializeAccessorKindRegistry(AccessorKindRegistry accessorKindRegistry) {
	    new AccessorKindRegistryReader(accessorKindRegistry).readRegistry();
	}
	
	@Override protected void initializeModelContentRegistry(ModelContentRegistry modelContentRegistry) {
	    new ModelContentRegistryReader(modelContentRegistry).readRegistry();
	}

	@Override protected void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry) {
	    new ModelSerializationRegistryReader(modelSerializationRegistry).readRegistry();
	}
	
	@Override public void logTheError(String string, Throwable e) {
		logException(newError(string, e), false);
	}		

	public void logException(Throwable e, boolean showErrorDialog) {
		if (e instanceof InvocationTargetException) {
			e = ((InvocationTargetException) e).getTargetException();
		}
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		} else {
			String message = e.getMessage();
			if (message == null)
				message = e.toString();
			status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
		}
		ModelRegistryPlugin.log(status, showErrorDialog);
	}
	
    /**
     * Return a CoreException with Error severity containing a text description and optionally
     * wrapping a further exception.
     * @param text description of exception
     * @param exception optional wrapped exception
     */
    public CoreException newError(String text, Throwable exception) {
        return new CoreException(new Status(IStatus.ERROR,
				PLUGIN_ID, IStatus.ERROR, "ERROR -- " + text, exception));
    }  
}