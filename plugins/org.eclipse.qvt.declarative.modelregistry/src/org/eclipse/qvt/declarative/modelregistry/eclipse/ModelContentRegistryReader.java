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


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelContentRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.osgi.framework.Bundle;

/**
 * A plugin extension reader that populates the ModelContentRegistry.
 */
public class ModelContentRegistryReader extends RegistryReader
{
	private static final String TAG_TEXT = "text";
	private static final String TAG_XML = "xml";
	private static final String ATT_ANALYSER = "analyser"; 
	private static final String ATT_FACTORY = "factory"; 
	private static final String ATT_URI = "uri"; 
		
	public static class BundleModelContentAnalyserDelegate extends ModelContentRegistry.ModelContentAnalyserDelegate
	{
		protected final Bundle bundle;

		public BundleModelContentAnalyserDelegate(Bundle bundle, String name) {
			super(name);
			this.bundle = bundle;
		}

		@Override protected Class<?> loadClass(String className) throws ClassNotFoundException {
			return bundle.loadClass(className);
		}
	}
	
	public static class BundleResourceFactoryDelegate extends ModelContentRegistry.ResourceFactoryDelegate
	{
		protected final Bundle bundle;

		public BundleResourceFactoryDelegate(Bundle bundle, String name) {
			super(name);
			this.bundle = bundle;
		}

		@Override protected Class<?> loadClass(String className) throws ClassNotFoundException {
			return bundle.loadClass(className);
		}
	}
	
	private final ModelContentRegistry modelContentRegistry;
	
	public ModelContentRegistryReader(ModelContentRegistry modelContentRegistry) {
		super(Platform.getExtensionRegistry(),
				ModelRegistryPlugin.getDefault().getBundle().getSymbolicName(), 
				EclipseModelRegistryEnvironment.MODEL_CONTENT_PPID);
		this.modelContentRegistry = modelContentRegistry;
	}

	@Override protected boolean readElement(IConfigurationElement element) {
		IExtension extension = element.getDeclaringExtension();
		String namespaceIdentifier = extension.getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(namespaceIdentifier);	
	    if (element.getName().equals(TAG_TEXT)) {
    		String analyserName = element.getAttribute(ATT_ANALYSER);
    		if (analyserName == null)
    			ModelRegistryEnvironment.logError("Missing analyser for Text model content", null);
			else
				modelContentRegistry.addModelContentAnalyserDelegate(new BundleModelContentAnalyserDelegate(bundle, analyserName));
	    	return true;
	    }
	    else if (element.getName().equals(TAG_XML)) {
    		String uri = element.getAttribute(ATT_URI);
    		String factoryName = element.getAttribute(ATT_FACTORY);
    		if (uri == null)
    			ModelRegistryEnvironment.logError("Missing URI for XML model content", null);
    		else if (factoryName == null)
    			ModelRegistryEnvironment.logError("Missing factory class for '" + uri + "' model content", null);
    		else
    			modelContentRegistry.addResourceFactoryDelegate(uri, new BundleResourceFactoryDelegate(bundle, factoryName));
	    	return true;
	    }
	    return false;
	}
}
