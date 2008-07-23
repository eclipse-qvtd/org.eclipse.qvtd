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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The XMLElementNamespaceParser.parse(InputStream) method supports examination of an XML input
 * stream to locate and return the URIs used by each element.
 */
public class XMLElementNamespaceParser extends DefaultHandler
{		
	public static final String XML_PREFIX_COLON = ExtendedMetaData.XMLNS_PREFIX + ":";
	
//	@SuppressWarnings("serial")
//	public static class FoundRootURIException extends SAXException
//	{
//		private String rootURI = null;
//		public FoundRootURIException(String rootURI) { this.rootURI = rootURI; }
//		public String getRootURI() { return rootURI; }
//	}

	
	public static String parse(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		Set<String> elementURIs = new XMLElementNamespaceParser().parseAll(inputStream);
		return elementURIs.size() > 0 ? elementURIs.iterator().next() : null;
	}
	
	protected Set<String> elementURIs = new HashSet<String>();
	protected Map<String, String> xmlnsMap = null;
	protected List<String> typePrefixes = new ArrayList<String>();
	
	public Set<String> parseAll(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		parser.parse(inputStream, this);
		return elementURIs;
	}
	
	@Override public void startElement(String uri, String localName, String name, Attributes attributes) {
		boolean atRoot = xmlnsMap == null;
		if (atRoot) {
			xmlnsMap = new HashMap<String, String>();
			int iMax = attributes.getLength();
			for (int i = 0; i < iMax; i++) {
				String qName = attributes.getQName(i);
				if (qName.equals(ExtendedMetaData.XMLNS_PREFIX))
					xmlnsMap.put("", attributes.getValue(i));
				else if (qName.startsWith(XML_PREFIX_COLON)) {
					xmlnsMap.put(qName.substring(XML_PREFIX_COLON.length()), attributes.getValue(i));
				}
			}
			for (String key : xmlnsMap.keySet()) {
				String value = xmlnsMap.get(key);
				if (ExtendedMetaData.XSI_URI.equals(value))
					typePrefixes.add(key);
				else if (ExtendedMetaData.XMI_URI.equals(value))
					typePrefixes.add(key);
			}
		}
		int iMax = attributes.getLength();
		for (int i = 0; i < iMax; i++) {
			String typeQName = attributes.getQName(i);
			if (typeQName.endsWith("type")) {
				int typeColonAt = typeQName.indexOf(':');				
				if (typeColonAt + 5 == typeQName.length()) {
					String namespace = typeColonAt >= 0 ? typeQName.substring(0, typeColonAt) : "";
					if (typePrefixes.contains(namespace)) {
						String valueQName = attributes.getValue(i);
						int valueColonAt = valueQName.indexOf(':');				
						if (valueColonAt >= 0)
							elementURIs.add(xmlnsMap.get(valueQName.substring(0, valueColonAt)));
						else if (atRoot)
							elementURIs.add(xmlnsMap.get(""));
					}
				}
			}
		}
		int colonAt = name.indexOf(':');
		if (colonAt >= 0)
			elementURIs.add(xmlnsMap.get(name.substring(0, colonAt)));
		else if (atRoot)
			elementURIs.add(xmlnsMap.get(""));
	}
}