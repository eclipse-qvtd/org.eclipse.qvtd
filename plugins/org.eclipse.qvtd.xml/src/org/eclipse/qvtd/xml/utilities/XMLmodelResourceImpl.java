/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xml.utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

import org.eclipse.emf.common.util.SegmentSequence;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.xml.Attribute;
import org.eclipse.qvtd.xml.CDATA;
import org.eclipse.qvtd.xml.Characters;
import org.eclipse.qvtd.xml.ClassAttribute;
import org.eclipse.qvtd.xml.ClassElement;
import org.eclipse.qvtd.xml.Comment;
import org.eclipse.qvtd.xml.DTD;
import org.eclipse.qvtd.xml.DataTypeAttribute;
import org.eclipse.qvtd.xml.DataTypeElement;
import org.eclipse.qvtd.xml.Document;
import org.eclipse.qvtd.xml.Element;
import org.eclipse.qvtd.xml.Entity;
import org.eclipse.qvtd.xml.Node;
import org.eclipse.qvtd.xml.PrefixMapping;
import org.eclipse.qvtd.xml.ProcessingInstruction;
import org.eclipse.qvtd.xml.XMLmodelFactory;
import org.eclipse.qvtd.xml.XMLmodelPackage;
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
	/**
	 * By default xmlns references to user URIs are resolved to EPackages enabling accurate resolution of
	 * xsi:Type child elements and reference resolution.
	 */
	public static final @NonNull String IGNORE_ECORE = "ignore-ecore";

	protected static class XMLmodelLoadImpl extends XMILoadImpl
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

	protected static class XMLmodelHandler extends DefaultHandler implements LexicalHandler
	{
		private ResourceSet resourceSet = new ResourceSetImpl();
		private XMLResource xmlResource;
		private Document document = null;
		private @NonNull Stack<@NonNull Node> nodeStack = new Stack<>();
		private boolean useEcore;

		/**
		 * Map from xmlns prefix to its corresponding URI. The default xmlns namespace is the blank string.
		 */
		protected final @NonNull Map<@NonNull String, @NonNull String> xmlns2uri = new HashMap<>();

		/**
		 * Map from xmlns prefix to its corresponding EPackage. The default xmlns namespace is the blank string.
		 */
		protected final @NonNull Map<@NonNull String, @NonNull EPackage> xmlns2ePackage = new HashMap<>();
		protected final @NonNull Map<@NonNull String, @NonNull String> uri2schemaLocation = new HashMap<>();
		protected final @NonNull Map<@NonNull String, @NonNull Element> xmiid2element = new HashMap<>();

		public XMLmodelHandler(XMLResource xmlResource, XMLHelper helper, Map<?, ?> options) {
			this.xmlResource = xmlResource;
			this.useEcore = (options == null) || (options.get(IGNORE_ECORE) != Boolean.TRUE);
		}

		protected void addError(@NonNull String string) {
			xmlResource.getErrors().add(new XMIException(string));
		}

		protected void addNode(Node node) {
			if (nodeStack.isEmpty()) {
				document.getChildren().add(node);
			}
			else {
				nodeStack.peek().getChildren().add(node);
			}
		}

		protected void addWarning(@NonNull String string) {
			xmlResource.getWarnings().add(new XMIException(string));
		}

		protected @Nullable Element basicGetChildElement(@NonNull Element parentElement, @NonNull String pathElement) {
			if (pathElement.length() <= 0) {
				return basicGetChildElementByIndex(parentElement, 0);
			}
			char firstChar = pathElement.charAt(0);
			if (firstChar == '@') {
				String childName;
				int childIndex = -1;
				int index = pathElement.indexOf('.');
				if (index >= 0) {
					childName = pathElement.substring(1, index);
					childIndex = Integer.valueOf(pathElement.substring(index+1));
				}
				else {
					childName = pathElement.substring(1);
					childIndex = 0;
				}
				return basicGetChildElementByName(parentElement, childName, childIndex);
			}
			else if (Character.isDigit(firstChar)) {
				int childIndex = Integer.valueOf(pathElement);
				return basicGetChildElementByIndex(parentElement, childIndex);
			}
			else {
				return basicGetChildElementByEClassName(parentElement, pathElement);		// Ecore EClassifier.name match
			}
		}

		protected @Nullable Element basicGetChildElementByEClassName(@NonNull Element parentElement, @NonNull String childName) {
			for (@NonNull Node childNode : parentElement.getChildren()) {
				if (childNode instanceof Element) {
					Element childElement = (Element)childNode;
					for (@NonNull Node grandchildNode : childElement.getChildren()) {
						if (grandchildNode instanceof DataTypeAttribute) {
							DataTypeAttribute grandchildElement = (DataTypeAttribute)grandchildNode;
							if (grandchildElement.getEcoreAttribute() == EcorePackage.Literals.ENAMED_ELEMENT__NAME) {
								if (childName.equals(grandchildElement.getValue())) {
									return childElement;
								}
							}
						}
					}
				}
			}
			return null;
		}

		protected @Nullable Element basicGetChildElementByIndex(@NonNull Element parentElement, int childElementIndex) {
			int matchIndex = 0;
			for (@NonNull Node childNode : parentElement.getChildren()) {
				if (childNode instanceof Element) {
					Element childElement = (Element)childNode;
					if (matchIndex == childElementIndex) {
						return childElement;
					}
					matchIndex++;
				}
			}
			return null;
		}

		protected @Nullable Element basicGetChildElementByName(@NonNull Element parentElement, @NonNull String childName, int childIndex) {
			int matchIndex = 0;
			for (@NonNull Node childNode : parentElement.getChildren()) {
				if (childNode instanceof Element) {
					Element childElement = (Element)childNode;
					if (childName.equals(childElement.getQName())) {
						if (matchIndex == childIndex) {
							return childElement;
						}
						matchIndex++;
					}
				}
			}
			return null;
		}

		/**
		 * Returns the object based on the fragment path as a list of Strings.
		 */
		protected @Nullable Element basicGetElementForPath(List<String> uriFragmentPath) {
			int size = uriFragmentPath.size();
			Element element = getRootElement(size == 0 ? "" : uriFragmentPath.get(0));
			for (int i = 1; i < size && element != null; ++i)
			{
				String uriFragmentSegment = uriFragmentPath.get(i);
				element = basicGetChildElement(element, uriFragmentSegment);
			}
			return element;
		}

		private @Nullable EPackage basicGetEPackage(@NonNull String prefix) {
			return xmlns2ePackage.get(prefix);
		}

		@Override
		public void characters(char[] ch, int start, int length) {
			boolean isWhite = true;
			for (int i = 0; i < length; i++) {
				char c = ch[start+i];
				if (!Character.isWhitespace(c)) {
					isWhite = false;
					break;
				}
			}
			if (!isWhite) {
				String characterText = new String(ch, start, length);
				Characters characters = XMLmodelFactory.eINSTANCE.createCharacters();
				//			if (!characterText.trim().isEmpty()) {
				characters.setData(characterText);
				//			}
				addNode(characters);
			}
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
			resolveReferences(document);
			document = null;
		}

		@Override
		public void endElement(String uri, String localName, String name) {
			Node node = nodeStack.pop();
			if (node instanceof ClassElement) {
				ClassElement element = (ClassElement)node;
				EClass ecoreClass = element.getEcoreClass();
				if (ecoreClass != null) {
					EAttribute idAttribute = ecoreClass.getEIDAttribute();
					if (idAttribute != null) {
						Object id = element.eGet(idAttribute);
						if (id != null) {
							Element oldElement = xmiid2element.put(String.valueOf(id), element);
							if (oldElement != null) {
								addError("Ambiguous xmi:id '" + id + "'");
							}
						}
					}
				}
			}
		}

		@Override
		public void endEntity(String name) {
			nodeStack.pop();
		}

		@Override
		public void endPrefixMapping(String prefix) {
			nodeStack.pop();
		}

		protected @Nullable EClassifier getEClassifier(@NonNull String qName) {
			String prefix = "";
			int colonIndex = qName.indexOf(":");
			String suffix = qName;
			if (colonIndex >= 0) {
				prefix = qName.substring(0, colonIndex);
				suffix = qName.substring(colonIndex+1);
			}
			EPackage ePackage = getEPackage(prefix);
			if (ePackage != null) {
				EClassifier eClassifier = ePackage.getEClassifier(suffix);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
			addError("Failed to locate an EClassifier for '" + qName + "'");
			return null;
		}

		protected @Nullable EPackage getEPackage(@NonNull String prefix) {
			EPackage ePackage = xmlns2ePackage.get(prefix);
			if (ePackage == null) {
				String uri = getURIofXMLNS(prefix);		// FIXME xsi:schemaLocation
				if ((uri != null) && !ExtendedMetaData.XMI_URI.equals(uri)) {
					ePackage = resourceSet.getPackageRegistry().getEPackage(uri);
					if (ePackage instanceof EPackage.Descriptor) {
						ePackage = ((EPackage.Descriptor)ePackage).getEPackage();
					}
					if (ePackage != null) {
						xmlns2ePackage.put(prefix, ePackage);
					}
					else if (!xmlns2ePackage.containsKey(prefix)) {
						xmlns2ePackage.put(prefix, null);
						if (useEcore) {
							addError("Failed to locate EPackage for '" + uri + "'");
						}
						else {
							//	addWarning("Failed to locate EPackage for '" + uri + "'");
						}
					}
				}
			}
			return ePackage;
		}

		protected @Nullable Element getElementAtChildIndex(@NonNull Node node, int index) {
			int elementIndex = 0;
			for (@NonNull Node child : node.getChildren()) {
				if (child instanceof Element) {
					if (elementIndex == index) {
						return (Element)child;
					}
					elementIndex++;
				}
			}
			return null;
		}

		protected @Nullable Element getElement(@NonNull String uriFragment) {
			// based on ResourceImpl.getEObject etc
			int length = uriFragment.length();
			if (length > 0) {
				if (uriFragment.charAt(0) == '/') {
					List<String> path = SegmentSequence.create("/", uriFragment).subSegmentsList(1);
					Element element = basicGetElementForPath(path);
					if (element == null) {
						addError("Failed to resolve '" + uriFragment + "'");
					}
					return element;
				}
				else if (uriFragment.charAt(length - 1) == '?') {
					int index = uriFragment.lastIndexOf('?', length - 2);
					if (index > 0) {
						uriFragment = uriFragment.substring(0, index);
					}
				}
			}
			Element element = xmiid2element.get(uriFragment);
			if (element == null) {
				addError("Failed to resolve xmi:id '" + uriFragment + "'");
			}
			return element;
		}

		/**
		 * Returns the object associated with the URI fragment root segment.
		 * This default implementation uses the position of the object;
		 * an empty string is the same as <code>"0"</code>.
		 * @return the object associated with the URI fragment root segment.
		 */
		protected @Nullable Element getRootElement(String uriFragmentRootSegment) {
			int position =  0;
			if (uriFragmentRootSegment.length() > 0) {
				if (uriFragmentRootSegment.charAt(0) == '?') {
					return xmiid2element.get(uriFragmentRootSegment.substring(1));
				}
				try {
					position = Integer.parseInt(uriFragmentRootSegment);
				}
				catch (NumberFormatException exception) {
					throw new WrappedException(exception);
				}
			}
			Node rootElement = document;
			List<Node> rootChildren = rootElement.getChildren();
			if (rootChildren.size() == 1) {
				Node onlyChild = rootChildren.get(0);
				if (onlyChild.eClass() == XMLmodelPackage.Literals.ELEMENT) {	// Not a ClassElement
					rootElement = onlyChild;
				}
			}
			return getElementAtChildIndex(rootElement, position);
		}

		protected @Nullable String getURIofXMLNS(@NonNull String xmlnsPrefix) {
			String value = xmlns2uri.get(xmlnsPrefix);
			if (value == null) {
				addError("Unresolved XMLNS prefix '" + xmlnsPrefix + "'");
			};
			return value;
		}

		protected @Nullable EClassifier getXsiType(@NonNull Attributes attributes) {
			int length = attributes.getLength();
			for (int index = 0; index < length; index++) {
				String qName = attributes.getQName(index);
				if (qNameEquals(qName, ExtendedMetaData.XMI_URI, "type") || qNameEquals(qName, ExtendedMetaData.XSI_URI, "type")) {
					String value = attributes.getValue(index);
					return getEClassifier(value);
				}
			}
			return null;
		}

		protected void processAttribute(@NonNull Element element, @NonNull String attributeQName, @NonNull String value) {
			Attribute attribute = null;
			Element childElement = null;
			int colonIndex = attributeQName.indexOf(':');
			if (colonIndex >= 0) {
				attribute = XMLmodelFactory.eINSTANCE.createAttribute();
				if (qNameEquals(attributeQName, ExtendedMetaData.XMI_URI, "id")) {
					Element oldElement = xmiid2element.put(value, element);
					if (oldElement != null) {
						addError("Ambiguous xmi:id '" + value + "'");
					}
				}
			}
			else if (ExtendedMetaData.XMLNS_PREFIX.equals(attributeQName)) {
				attribute = XMLmodelFactory.eINSTANCE.createAttribute();
			}
			else {
				EClassifier ecoreClassifier = element.getEcoreClassifier();
				if (ecoreClassifier == null) {
					attribute = XMLmodelFactory.eINSTANCE.createAttribute();
				}
				else if (ecoreClassifier instanceof EClass) {
					EStructuralFeature eFeature = ((EClass)ecoreClassifier).getEStructuralFeature(attributeQName);
					if (eFeature instanceof EAttribute) {
						DataTypeAttribute dataTypeAttribute = XMLmodelFactory.eINSTANCE.createDataTypeAttribute();
						dataTypeAttribute.setEcoreAttribute((EAttribute) eFeature);
						attribute = dataTypeAttribute;
					}
					else {
						ClassAttribute classAttribute = XMLmodelFactory.eINSTANCE.createClassAttribute();
						classAttribute.setEcoreReference((EReference) eFeature);
						attribute = classAttribute;
					}
				}
				else if (ecoreClassifier instanceof EDataType) {
					DataTypeElement dataTypeElement = XMLmodelFactory.eINSTANCE.createDataTypeElement();
					dataTypeElement.setEcoreDataType((EDataType) ecoreClassifier);
					childElement = dataTypeElement;
				}
				else {
					childElement = XMLmodelFactory.eINSTANCE.createElement();
					//	EStructuralFeature eFeature = ((EClass)ecoreClassifier).getEStructuralFeature(attributeQName);
					//	if (eFeature instanceof EAttribute) {
					//		DataTypeAttribute dataTypeAttribute = XMLmodelFactory.eINSTANCE.createDataTypeAttribute();
					//		dataTypeAttribute.setEcoreAttribute((EAttribute) eFeature);
					//		attribute = dataTypeAttribute;
					//	}
					//	else {
					//		ClassAttribute classAttribute = XMLmodelFactory.eINSTANCE.createClassAttribute();
					//		classAttribute.setEcoreReference((EReference) eFeature);
					//		attribute = classAttribute;
					//	}
				}
			}
			if (attribute != null) {
				attribute.setName(attributeQName);
				attribute.setValue(value);
				element.getChildren().add(attribute);
			}
			else if (childElement != null) {
				element.getChildren().add(childElement);
			}
		}

		protected void processRootAttributes(@NonNull Attributes attributes) {
			int length = attributes.getLength();
			for (int index = 0; index < length; index++) {
				String xmlns = null;
				String qName = attributes.getQName(index);
				int colonIndex = qName.indexOf(':');
				if (colonIndex >= 0) {
					String prefix = qName.substring(0, colonIndex);
					if (ExtendedMetaData.XMLNS_PREFIX.equals(prefix)) {
						xmlns = qName.substring(colonIndex+1);
					}
				}
				else if (ExtendedMetaData.XMLNS_PREFIX.equals(qName)) {
					xmlns = "";
				}
				if (xmlns != null) {
					String newValue = attributes.getValue(index);
					String oldValue = xmlns2uri.put(xmlns, newValue);
					if (oldValue != null) {
						addError("Conflicting '" + xmlns + "' XMLNS values '" + oldValue + "' and '" + newValue + "'");
					}
				}
			}
			for (int index = 0; index < length; index++) {
				String qName = attributes.getQName(index);
				int colonIndex = qName.indexOf(':');
				if (colonIndex >= 0) {
					String prefix = qName.substring(0, colonIndex);
					if (!ExtendedMetaData.XMLNS_PREFIX.equals(prefix)) {
						String suffix = qName.substring(colonIndex+1);
						String uri = getURIofXMLNS(prefix);
						if (ExtendedMetaData.XSI_URI.equals(uri) && "schemaLocation".equals(suffix)) {
							String value = attributes.getValue(index);
							int spaceIndex = value.indexOf(' ');
							String schemaLocation = value;
							String schemaURI = "";
							if (spaceIndex >= 0) {
								schemaLocation = value.substring(spaceIndex+1).trim();
								schemaURI = value.substring(spaceIndex);
							}
							String oldValue = uri2schemaLocation.put(schemaURI, schemaLocation);
							if (oldValue != null) {
								addError("Conflicting '" + schemaURI + "' schemaLocation values '" + oldValue + "' and '" + schemaLocation + "'");
							}
						}
					}
				}
			}
		}

		@Override
		public void processingInstruction(String target, String data) {
			ProcessingInstruction processingInstruction = XMLmodelFactory.eINSTANCE.createProcessingInstruction();
			processingInstruction.setTarget(target);
			processingInstruction.setData(data);
			addNode(processingInstruction);
		}

		/**
		 * Return true if a qName such as 'xmi:id' corresponds to uri:name where uri is registered XMLNS URI for the
		 * qName prefix of defauly XMLNS if qName has no : to separate a prefix.
		 */
		protected boolean qNameEquals(@NonNull String qName, @NonNull String uri, @NonNull String name) {
			int colonIndex = qName.indexOf(':');
			if (colonIndex < 0) {
				if (!uri.equals(xmlns2uri.get(""))) {
					return false;
				}
				return name.equals(qName);
			}
			else {
				String prefix = qName.substring(0, colonIndex);
				if (!uri.equals(xmlns2uri.get(prefix))) {
					return false;
				}
				String suffix = qName.substring(colonIndex+1);
				return name.equals(suffix);
			}
		}

		protected void resolveReferences(@NonNull Node node) {
			if (node instanceof ClassAttribute) {
				ClassAttribute classAttribute = (ClassAttribute)node;
				String[] values = classAttribute.getValue().split(" ");
				for (int i = 0; i < values.length; i++) {
					EClassifier eClassifier = classAttribute.getEcoreReference().getEType();
					String value = values[i].trim();
					int hashIndex = value.indexOf('#');
					if ((hashIndex < 0) && ((i+1) < values.length)) {
						String nextValue = values[i+1].trim();
						int nextHashIndex = nextValue.indexOf('#');
						if (nextHashIndex > 0) {
							eClassifier = getEClassifier(value);
							i++;						// Skip type prefix to external reference
							value = nextValue;
							hashIndex = nextHashIndex;
						}
					}
					if (value.length() > 0) {
						EObject resolvedElement = null;
						if (hashIndex <= 0) {  // absent or at start
							resolvedElement = getElement(hashIndex < 0 ? value : value.substring(1));
						}
						if (resolvedElement == null) {
							resolvedElement = eClassifier.getEPackage().getEFactoryInstance().create((EClass) eClassifier);
							((BasicEObjectImpl)resolvedElement).eSetProxyURI(URI.createURI(value));
						}
						classAttribute.getEObjects().add(resolvedElement);
						//						}
					}
				}
			}
			for (@NonNull Node child : node.getChildren()) {
				resolveReferences(child);
			}
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
			if (nodeStack.isEmpty()) {
				processRootAttributes(attributes);
			}
			EPackage ecorePackage = null;
			EClassifier ecoreClassifier = null;
			String name = qName;
			int colonIndex = qName.indexOf(':');
			if (colonIndex >= 0) {					// Qualified element name
				String prefix = qName.substring(0, colonIndex);
				name = qName.substring(colonIndex+1);
				ecorePackage = getEPackage(prefix);
				if (ecorePackage != null) {
					ecoreClassifier = ecorePackage.getEClassifier(name);
					if (ecoreClassifier == null) {
						addError("Failed to locate EClassifier '" + name + "' in '" + ecorePackage.getNsURI() + "'");
					}
				}
			}
			else {
				ecoreClassifier = getXsiType(attributes);
				if (ecoreClassifier == null) {
					ecorePackage = basicGetEPackage("");
					if (ecorePackage != null) {
						ecoreClassifier  = ecorePackage.getEClassifier(name);
						if (ecoreClassifier == null) {
							addError("Failed to locate EClassifier '" + name + "' in '" + ecorePackage.getNsURI() + "'");
						}
					}
					else {
						Element container = (Element)nodeStack.peek();
						EClassifier ecoreContainerClassifier = container.getEcoreClassifier();
						if (ecoreContainerClassifier instanceof EClass) {
							EStructuralFeature eStructuralFeature = ((EClass)ecoreContainerClassifier).getEStructuralFeature(name);
							if (eStructuralFeature != null) {
								ecoreClassifier = eStructuralFeature.getEType();
							}
							else {
								addError("Failed to locate EStructuralFeature '" + name + "' in '" + ecoreContainerClassifier.getName() + "'");
							}
						}
						else if (ecoreContainerClassifier instanceof EDataType) {
							//	EReference ecoreContainerReference = (EAttribute) ((EDataType)ecoreContainerClassifier).getEStructuralFeature(name);
							//	if (ecoreContainerReference != null) {
							//		ecoreClass = ecoreContainerReference.getEReferenceType();
							//	}
							//	else {
							//		addError("Failed to locate EReference '" + name + "' in '" + ecoreContainerClassifier.getName() + "'");
							//	}
						}
					}
				}
			}

			Element element;
			if (ecoreClassifier instanceof EClass) {
				ClassElement classElement = XMLmodelFactory.eINSTANCE.createClassElement();
				classElement.setEcoreClass((EClass) ecoreClassifier);
				element = classElement;
			}
			else if (ecoreClassifier instanceof EDataType) {
				DataTypeElement dataTypeElement = XMLmodelFactory.eINSTANCE.createDataTypeElement();
				dataTypeElement.setEcoreDataType((EDataType) ecoreClassifier);
				element = dataTypeElement;
			}
			else {
				element = XMLmodelFactory.eINSTANCE.createElement();
			}
			element.setUri(uri);
			element.setLocalName(localName);
			element.setQName(qName);
			int length = attributes.getLength();
			for (int index = 0; index < length; index++) {
				String attributeQName = attributes.getQName(index);
				String value = attributes.getValue(index);
				processAttribute(element, attributeQName, value);
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

	/**
	 *  The XMLString inherited by XMLSaveImpl is very close to what is required, but its handling of mixed content is
	 *  hard to understand. Some of the whitespacing around characters is not quite right. XMLStringBuilder is significantly
	 *  simpler, mostly with justofiication, but sometimes through naivety.
	 */
	protected static class XMLStringBuilder
	{
		protected enum XMLstate {
			OUTSIDE,					// e.g at "@<xx/>" or <xx/>@"
			HAS_ELEMENT_OPEN,			// e.g at "<xx ... @>
			HAS_ELEMENT_CLOSE			// e.g at "<xx>...@<xx/>
		};
		private StringBuilder s = new StringBuilder();
		private int currentColumn = 0;
		//		private int indentColumn = 0;
		private Stack<@NonNull String> elementNameStack = new Stack<>();
		//	private boolean hasAttributes = false;
		private StringBuilder attributeBuilder = new StringBuilder(256);
		private @NonNull String lineSeparator;
		private int lineWidth;
		//	private boolean hasElements = false;
		private XMLstate xmlState = XMLstate.OUTSIDE;

		public XMLStringBuilder(@NonNull String lineSeparator, int lineWidth) {
			this.lineSeparator = lineSeparator;
			this.lineWidth = lineWidth;
		}

		public void add(@NonNull String string) {
			append(string);
		}

		public void addAttributeContent(@NonNull String content) {
			assert attributeBuilder.length() > 0;
			attributeBuilder.append(content);
		}

		public void addCDATA(@NonNull String characters) {
			appendOuterElementClose();
			s.append("<![CDATA[");
			s.append(characters);
			s.append("]]>");
			addLine();
		}

		public void addCharacters(@NonNull String characters) {
			appendOuterElementClose();
			append(characters);
		}

		public void addComment(@NonNull String string) {
			appendOuterElementClose();
			addLine();
			append("<!--" + string + "-->");
			addLine();
		}

		public void addLine() {
			if (currentColumn > 0) {
				s.append(lineSeparator);
				currentColumn = 0;
			}
		}

		public void addProcessingInstruction(@Nullable String target, @Nullable String data) {
			appendOuterElementClose();
			addLine();
			s.append("<?");
			s.append(target == null ? "_" : target);
			if (data != null) {
				s.append(" ");
				s.append(data);		// FIXME line wrap at new-lines
			}
			s.append("?>");
			addLine();
		}

		protected void append(@NonNull String string) {
			int length = string.length();
			if (length > 0) {
				int indentColumn = (elementNameStack.size() + (attributeBuilder.length() > 0 ? 1 : 0)) * 2;
				for ( ; currentColumn < indentColumn; currentColumn++) {
					s.append(' ');
				}
				s.append(string);
				currentColumn += length;
			}
		}

		protected void appendOuterElementClose() {
			assert attributeBuilder.length() <= 0;
			assert xmlState != XMLstate.OUTSIDE;
			if (xmlState == XMLstate.HAS_ELEMENT_OPEN) {
				append(">");
				xmlState = XMLstate.HAS_ELEMENT_CLOSE;
			}
		}

		public void endAttribute() {
			assert attributeBuilder.length() > 0;
			attributeBuilder.append("\"");
			int length = attributeBuilder.length();
			if (currentColumn + 1 + length > lineWidth) {
				addLine();
			}
			else {
				append(" ");
			}
			append(attributeBuilder.toString());
			attributeBuilder.replace(0, length, "");
		}

		public void endContentElement(@NonNull String contentElement) {
			append(">");
			addLine();
		}

		public void endElement() {
			assert xmlState != XMLstate.OUTSIDE;
			assert attributeBuilder.length() <= 0;
			String qName = elementNameStack.pop();
			append(xmlState == XMLstate.HAS_ELEMENT_CLOSE ? "</" + qName + ">" : "/>");
			addLine();
			xmlState = elementNameStack.isEmpty() ? XMLstate.OUTSIDE : XMLstate.HAS_ELEMENT_CLOSE;
		}

		public void startAttribute(@NonNull String name) {
			assert xmlState == XMLstate.HAS_ELEMENT_OPEN;
			assert attributeBuilder.length() <= 0;
			attributeBuilder.append(name);
			attributeBuilder.append("=\"");
		}

		public void startElement(@NonNull String qName) {
			if (xmlState != XMLstate.OUTSIDE) {
				appendOuterElementClose();
			}
			addLine();
			append("<" + qName);
			elementNameStack.push(qName);
			xmlState = XMLstate.HAS_ELEMENT_OPEN;
		}

		public void write(@NonNull Writer os, int flushThreshold) throws IOException {
			String s2 = s.toString();
			assert xmlState == XMLstate.OUTSIDE;
			os.write(s2);
		}

		public void writeAscii(@NonNull OutputStream os, int flushThreshold) throws IOException {
			String s2 = s.toString();
			assert xmlState == XMLstate.OUTSIDE;
			os.write(s2.getBytes());		// No encoding necessary
		}
	}

	protected static class XMLmodelSave extends XMISaveImpl
	{
		// The inherited doc is never intentionally used.
		private XMLStringBuilder doc2;

		public XMLmodelSave(XMLHelper helper) {
			super(helper);
		}

		private @NonNull String getCharacters(@NonNull Node node) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Node child : node.getChildren()) {
				if (child instanceof Characters) {
					s.append(((Characters)child).getData());
				}
			}
			return s.toString();
		}

		@Override
		protected void init(XMLResource resource, Map<?, ?> options) {
			Integer lineWidth = (Integer)options.get(XMLResource.OPTION_LINE_WIDTH);
			if (lineWidth == null) {
				lineWidth = Integer.MAX_VALUE;
			}
			String lineSeparator = (String)options.get(Resource.OPTION_LINE_DELIMITER);
			if (lineSeparator == null || lineSeparator.equals(Resource.OPTION_LINE_DELIMITER_UNSPECIFIED)) {
				lineSeparator = System.getProperty("line.separator");
			}
			super.init(resource, options);
			this.doc2 = new XMLStringBuilder(lineSeparator, lineWidth);
		}

		@Override
		public void traverse(List<? extends EObject> contents) {
			doc2.add("<?xml version=\"" + xmlVersion + "\" encoding=\"" + encoding + "\"?>");
			traverseElements(contents);
		}

		protected void traverseElements(List<? extends EObject> contents) {
			for (EObject eObject : contents) {
				if (eObject instanceof Document) {
					traverseElements(((Document)eObject).getChildren());
				}
				else if (eObject instanceof Element) {
					Element element = (Element)eObject;
					doc2.startElement(element.getQName());
					traverseElements(element.getChildren());
					doc2.endElement();
				}
				else if (eObject instanceof Attribute) {
					Attribute attribute = (Attribute)eObject;
					doc2.startAttribute(attribute.getName());
					doc2.addAttributeContent(escape.convert(attribute.getValue()));
					doc2.endAttribute();
				}
				else if (eObject instanceof Comment) {
					Comment comment = (Comment)eObject;
					doc2.addComment(comment.getData());
				}
				else if (eObject instanceof Characters) {
					Characters characters = (Characters)eObject;
					String data = characters.getData();
					doc2.addCharacters(data);
				}
				else if (eObject instanceof CDATA) {
					CDATA cdata = (CDATA)eObject;
					doc2.addCDATA(getCharacters(cdata));
				}
				else if (eObject instanceof DTD) {
					DTD dtd = (DTD)eObject;
					//	doc2.addDTD(dtd.getName(), dtd.getPublicId(), dtd.getSystemId());
				}
				else if (eObject instanceof Entity) {
					Entity entity = (Entity)eObject;
					//	doc2.addEntity(entity.getName());
				}
				else if (eObject instanceof ProcessingInstruction) {
					ProcessingInstruction processingInstruction = (ProcessingInstruction)eObject;
					doc2.addProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
				}
			}
		}

		@Override
		public void write(Writer os) throws IOException {
			doc2.write(os, flushThreshold);
			os.flush();
		}

		@Override
		public void writeAscii(OutputStream os) throws IOException {
			doc2.writeAscii(os, flushThreshold);
			os.flush();
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
