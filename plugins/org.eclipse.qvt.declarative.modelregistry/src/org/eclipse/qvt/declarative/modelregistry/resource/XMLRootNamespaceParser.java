/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
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
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The XMLRootNamespaceParser.parse(InputStream) method supports examination of an XML input
 * stream to locate and return the URI of the root namespace, or null if none.
 */
public class XMLRootNamespaceParser extends DefaultHandler
{		
	public static final String XMLNS_PREFIX_COLON = ExtendedMetaData.XMLNS_PREFIX + ":";
	public static final int XMLNS_PREFIX_LENGTH = ExtendedMetaData.XMLNS_PREFIX.length();
	
	@SuppressWarnings("serial")
	public static class FoundRootURIException extends SAXException
	{
		private String rootURI = null;
		public FoundRootURIException(String rootURI) { this.rootURI = rootURI; }
		public String getRootURI() { return rootURI; }
	}
	
	protected Map<String, String> xmlnsMap = null;
	private String xmiPrefix = null;

	public static String parse(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		XMLRootNamespaceParser handler = new XMLRootNamespaceParser();
		try {
			parser.parse(inputStream, handler);
			return null;
		} catch (FoundRootURIException e) {
			return e.getRootURI();
		}		
	}
	
	@Override public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		boolean atRoot = xmlnsMap == null;
		if (atRoot) {
			xmlnsMap = new HashMap<String, String>();
			int iMax = attributes.getLength();
			for (int i = 0; i < iMax; i++) {
				String qName = attributes.getQName(i);
				String prefix = null;
				String value = attributes.getValue(i);
				if (qName.equals(ExtendedMetaData.XMLNS_PREFIX))
					prefix = "";
				else if (qName.startsWith(XMLNS_PREFIX_COLON))
					prefix = qName.substring(XMLNS_PREFIX_COLON.length());
				if (prefix != null) {
					xmlnsMap.put(prefix, value);
					if (ExtendedMetaData.XMI_URI.equals(value))
						xmiPrefix  = prefix;
				}
			}
		}
		int colonAt = name.indexOf(':');
		String prefix = colonAt >= 0 ? name.substring(0, colonAt) : "";
		if (prefix.equals(xmiPrefix))
			return;
		throw new FoundRootURIException(xmlnsMap.get(prefix));
	}
}