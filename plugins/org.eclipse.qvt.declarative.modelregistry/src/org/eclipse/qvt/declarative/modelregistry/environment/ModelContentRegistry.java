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
package org.eclipse.qvt.declarative.modelregistry.environment;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.qvt.declarative.modelregistry.resource.ModelContentAnalyser;

/**
 * The maps of xml/text content to resource factory.
 */
public class ModelContentRegistry
{
	public static abstract class ModelContentAnalyserDelegate extends ClassDelegate<ModelContentAnalyser>
	{
		public ModelContentAnalyserDelegate(String name) {
			super(name, ModelContentAnalyser.class);
		}
		
		public ModelContentAnalyserDelegate(ModelContentAnalyser instance) {
			super(instance);
		}
	}
	
	public static class ContentAnalyser extends ModelContentAnalyserDelegate
	{
		public ContentAnalyser(ModelContentAnalyser instance) {
			super(instance);
		}

		@Override protected Class<?> loadClass(String className) { return null; }
	}
	
	public static abstract class ResourceFactoryDelegate extends ClassDelegate<Resource.Factory>
	{
		public ResourceFactoryDelegate(String name) {
			super(name, Resource.Factory.class);
		}
		
		public ResourceFactoryDelegate(Resource.Factory instance) {
			super(instance);
		}
	}
	
	public static class ResourceFactory extends ResourceFactoryDelegate
	{
		public ResourceFactory(Resource.Factory instance) {
			super(instance);
		}

		@Override protected Class<?> loadClass(String className) { return null; }
	}

	private final List<ModelContentAnalyserDelegate> textContents = new ArrayList<ModelContentAnalyserDelegate>();
	private final Map<String, ResourceFactoryDelegate> xmlContents = new HashMap<String, ResourceFactoryDelegate>();

	public void addModelContentAnalyser(ModelContentAnalyser instance) {
		textContents.add(new ContentAnalyser(instance));
	}

	public void addModelContentAnalyserDelegate(ModelContentAnalyserDelegate textContent) {
		textContents.add(textContent);
	}

	public void addResourceFactories(Map<String, Factory> contentToFactoryMap) {
		for (String uri : contentToFactoryMap.keySet()) {
			Resource.Factory newFactory = contentToFactoryMap.get(uri);
			ResourceFactoryDelegate oldFactoryDelegate = xmlContents.get(uri);
			if (oldFactoryDelegate != null) {
				Resource.Factory oldFactory = oldFactoryDelegate.load();
				if (newFactory.getClass().isAssignableFrom(oldFactory.getClass()))
					continue;	// Keep old factory
				else if (!oldFactory.getClass().isAssignableFrom(newFactory.getClass()))
					ModelRegistryEnvironment.getInstance().logTheError(
							"Conflicting factories for " + uri +
							" " + oldFactory.getClass().getName() +
							" " + newFactory.getClass().getName(), null);
			}
			addResourceFactory(uri, newFactory);
		}
	}

	public void addResourceFactory(String uri, Resource.Factory instance) {
		xmlContents.put(uri, new ResourceFactory(instance));
	}

	public void addResourceFactoryDelegate(String uri, ResourceFactoryDelegate xmlContent) {
		xmlContents.put(uri, xmlContent);
	}

	public Collection<ModelContentAnalyserDelegate> getTextContentAnalysers() {
		return textContents;
	}

	public Resource.Factory getXMLContent(String uri) {
		ClassDelegate<? extends Resource.Factory> delegate = xmlContents.get(uri);
		return delegate != null ? delegate.load() : null;
	}
}
