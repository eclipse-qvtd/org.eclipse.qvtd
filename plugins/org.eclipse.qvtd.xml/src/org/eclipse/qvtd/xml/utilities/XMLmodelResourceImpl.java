/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xml.utilities;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xml.Attribute;
import org.eclipse.qvtd.xml.CDATA;
import org.eclipse.qvtd.xml.Characters;
import org.eclipse.qvtd.xml.Comment;
import org.eclipse.qvtd.xml.DTD;
import org.eclipse.qvtd.xml.Document;
import org.eclipse.qvtd.xml.Element;
import org.eclipse.qvtd.xml.Entity;
import org.eclipse.qvtd.xml.Node;
import org.eclipse.qvtd.xml.PrefixMapping;
import org.eclipse.qvtd.xml.ProcessingInstruction;
import org.eclipse.qvtd.xml.XMLmodelFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLmodelResourceImpl loads an XML Resource creating a model that conforms to http://www.eclipse.org/qvt/2015/XML.
 * It therefore comprioses a hierrachy of Nodes such s Element, Attribute, Comment corresponding to SAX parser call-backs.
 *
 * This allows the XML technology space to be manipulated using Model techology space tooling.
 */
public class XMLmodelResourceImpl extends XMIResourceImpl
{
	public static class XMLmodelLoadImpl extends XMILoadImpl
	{
		private SAXParser makeParser = null;

		public XMLmodelLoadImpl(XMLHelper helper) {
			super(helper);
		}

		@Override
		protected DefaultHandler makeDefaultHandler() {
			XMLmodelHandler handler = new XMLmodelHandler(resource, helper, options);
			try {
				makeParser.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
			} catch (SAXException e) {
				// Never happens, but we can survive without a lexical-handler
			}
			return handler;
		}

		@Override
		protected SAXParser makeParser() throws ParserConfigurationException, SAXException {
			makeParser = super.makeParser();
			return makeParser;
		}
	}

	public static class XMLmodelHandler extends DefaultHandler implements LexicalHandler
	{
		private XMLResource xmlResource;
		private Document document = null;
		private @NonNull Stack<@NonNull Node> nodeStack = new Stack<>();

		public XMLmodelHandler(XMLResource xmlResource, XMLHelper helper, Map<?, ?> options) {
			this.xmlResource = xmlResource;
		}

		protected void addNode(Node node) {
			if (nodeStack.isEmpty()) {
				document.getChildren().add(node);
			}
			else {
				nodeStack.peek().getChildren().add(node);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) {
			Characters characters = XMLmodelFactory.eINSTANCE.createCharacters();
			String characterText = new String(ch, start, length);
			//			if (!characterText.trim().isEmpty()) {
			characters.setData(characterText);
			//			}
			addNode(characters);
		}

		@Override
		public void comment(char[] ch, int start, int length) {
			Comment comment = XMLmodelFactory.eINSTANCE.createComment();
			comment.setData(new String(ch, start, length));
			addNode(comment);
		}

		@Override
		public void endCDATA() {
			nodeStack.pop();
		}

		@Override
		public void endDTD() {
			nodeStack.pop();
		}

		@Override
		public void endDocument() {
			xmlResource.getContents().add(document);
			document = null;
		}

		@Override
		public void endElement(String uri, String localName, String name) {
			nodeStack.pop();
		}

		@Override
		public void endEntity(String name) {
			nodeStack.pop();
		}

		@Override
		public void endPrefixMapping(String prefix) {
			nodeStack.pop();
		}

		@Override
		public void processingInstruction(String target, String data) {
			ProcessingInstruction processingInstruction = XMLmodelFactory.eINSTANCE.createProcessingInstruction();
			processingInstruction.setTarget(target);
			processingInstruction.setData(data);
			addNode(processingInstruction);
		}

		@Override
		public void startCDATA() {
			CDATA cdata = XMLmodelFactory.eINSTANCE.createCDATA();
			addNode(cdata);
			nodeStack.push(cdata);
		}

		@Override
		public void startDTD(String name, String publicId, String systemId) {
			DTD dtd = XMLmodelFactory.eINSTANCE.createDTD();
			dtd.setName(name);
			dtd.setPublicId(publicId);
			dtd.setSystemId(systemId);
			addNode(dtd);
			nodeStack.push(dtd);
		}

		@Override
		public void startDocument() {
			document = XMLmodelFactory.eINSTANCE.createDocument();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			Element element = XMLmodelFactory.eINSTANCE.createElement();
			element.setUri(uri);
			element.setLocalName(localName);
			element.setQName(qName);
			for (int index = 0; index < attributes.getLength(); index++) {
				Attribute attribute = XMLmodelFactory.eINSTANCE.createAttribute();
				attribute.setName(attributes.getQName(index));
				attribute.setValue(attributes.getValue(index));
				element.getChildren().add(attribute);
			}
			addNode(element);
			nodeStack.push(element);
		}

		@Override
		public void startEntity(String name) {
			Entity entity = XMLmodelFactory.eINSTANCE.createEntity();
			entity.setName(name);
			addNode(entity);
			nodeStack.push(entity);
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) {
			PrefixMapping prefixMapping = XMLmodelFactory.eINSTANCE.createPrefixMapping();
			prefixMapping.setPrefix(prefix);
			prefixMapping.setUri(uri);
			addNode(prefixMapping);
			nodeStack.push(prefixMapping);
		}
	}

	public static class XMLmodelSave extends XMISaveImpl
	{
		public XMLmodelSave(XMLHelper helper) {
			super(helper);
		}

		@Override
		public void traverse(List<? extends EObject> contents) {
			doc.add("<?xml version=\"" + xmlVersion + "\" encoding=\"" + encoding + "\"?>");
			doc.addLine();
			doc.setMixed(true);
			traverseElements(contents);
		}

		protected void traverseElements(List<? extends EObject> contents) {
			for (EObject eObject : contents) {
				if (eObject instanceof Document) {
					traverseElements(((Document)eObject).getChildren());
				}
				else if (eObject instanceof Element) {
					Element element = (Element)eObject;
					doc.startElement(element.getQName());
					List<Node> children = element.getChildren();
					if ((children.size() == 1) && (children.get(0) instanceof Characters)) {
						Characters characters = (Characters)children.get(0);
						String data = characters.getData();
						doc.endContentElement(escape.convert(data));
					}
					else {
						traverseElements(children);
						doc.endElement();
					}
				}
				else if (eObject instanceof Attribute) {
					Attribute attribute = (Attribute)eObject;
					doc.startAttribute(attribute.getName());
					doc.addAttributeContent(escape.convert(attribute.getValue()));
					doc.endAttribute();
				}
				else if (eObject instanceof Comment) {
					Comment comment = (Comment)eObject;
					doc.addComment(comment.getData());
					doc.addLine();
				}
				else if (eObject instanceof Characters) {
					Characters characters = (Characters)eObject;
					@SuppressWarnings("unused") String data = characters.getData();
					//					doc.add(data);
				}
				else if (eObject instanceof CDATA) {
					CDATA cdata = (CDATA)eObject;
					doc.addCDATA(getCharacters(cdata));
				}
				else if (eObject instanceof ProcessingInstruction) {
					ProcessingInstruction processingInstruction = (ProcessingInstruction)eObject;
					doc.addProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
				}
			}
		}

		private String getCharacters(Node node) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Node child : node.getChildren()) {
				if (child instanceof Characters) {
					s.append(((Characters)child).getData());
				}
			}
			return s.toString();
		}
	}

	public XMLmodelResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new XMLmodelLoadImpl(createXMLHelper());
	}

	@Override
	protected XMLLoad createXMLLoad(Map<?, ?> options) {
		return createXMLLoad();
	}

	@Override
	protected XMLSave createXMLSave() {
		return new XMLmodelSave(createXMLHelper());
	}

	@Override
	protected XMLSave createXMLSave(Map<?, ?> options) {
		return createXMLSave();
	}
}
