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
package org.eclipse.qvt.declarative.modelregistry.resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelContentRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.xml.sax.SAXException;

/**
 * EcoreFamilyResourceFactoryImpl extends EcoreResourceFactoryImpl to support automatic
 * translation of loaded models to Ecore exploiting the root namespace of XML files.
 * 
 * Use of EcoreFamilyResourceSetImpl should be preferred to EcoreFamilyResourceFactoryImpl
 * since EcoreFamilyResourceSetImpl is fully compliant with the Resource API. This class
 * has to take some liberties during createResource, by assuming that the model should
 * be loaded if at all possible, and by throwing a Wrapped RunTime exception id createResource
 * fails. A variety of alternate methods support more sensible resource creation if
 * the caller has control of the inputStream or knowledge of the root namespace URI.
 * 
 * Registration of translators occurs through the model_content extension point.
 */
@SuppressWarnings("deprecation") // FIXME change to URIConverterImpl to ExtensibleURIConverterImpl once EMF 2.4 dependency acceptable
public class EcoreFamilyResourceFactoryImpl extends EcoreResourceFactoryImpl
{
	/**
	 * The default URI converter when there is no resource set.
	 */
	private static URIConverter defaultURIConverter;

	/**
	 * Returns the default URI converter that's used when there is no resource set.
	 * @return the default URI converter.
	 * @see #getURIConverter
	 */
	protected static URIConverter getDefaultURIConverter() {
	    if (defaultURIConverter == null)
	    	defaultURIConverter = new URIConverterImpl();	
	    return defaultURIConverter;
	}
	
	public EcoreFamilyResourceFactoryImpl() {
		super();
	}

	@Override public Resource createResource(URI uri) {
	    try {
			return loadResource(uri, getDefaultURIConverter(), null);
		} catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	public Resource createResource(URI resourceURI, String rootNamespaceURI) {
		Resource.Factory resourceFactory = findResourceFactory(rootNamespaceURI);
		return resourceFactory.createResource(resourceURI);
	}

	public Resource.Factory findResourceFactory(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		String rootURI = XMLElementNamespaceParser.parse(inputStream);
		return findResourceFactory(rootURI);
	}

	public Resource.Factory findResourceFactory(String rootURI) {
		ModelContentRegistry modelContentRegistry = ModelRegistryEnvironment.getInstance().getModelContentRegistry();
		Resource.Factory resourceFactory = modelContentRegistry.getXMLContent(rootURI);
		if (resourceFactory == null)
			resourceFactory = new XMIResourceFactoryImpl();
		return resourceFactory;
	}

	public Resource loadResource(URI uri, URIConverter uriConverter, Map<?,?> loadOptions) throws ParserConfigurationException, SAXException, IOException {
		InputStream inputStream = uriConverter.createInputStream(uri);
		if (!inputStream.markSupported()) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[16384];
			for (int i; (i = inputStream.read(buffer)) >= 0; )
				outputStream.write(buffer, 0, i);
			inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		}
		String rootURI = XMLElementNamespaceParser.parse(inputStream);
		Resource resource = createResource(uri, rootURI);
		inputStream.reset();
		resource.load(inputStream, loadOptions);
		return resource;
	}

	public Resource loadResource(URI uri, InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		Resource.Factory resourceFactory = findResourceFactory(inputStream);
		return resourceFactory.createResource(uri);
	}
}
