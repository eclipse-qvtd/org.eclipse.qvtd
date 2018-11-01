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

	public static class XMLmodelSave extends XMISaveImpl
	{
		// FIXME The inherited use of XMLString from XMLSaveImpl is very close to what is required, but
		//  its handling of mixed content is hard to understand. Some of the whitespacing around characters
		//  is not quite right. Perhaps a simpler custom variant of XMLString is needed - it is not overrideable.
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
					String data = characters.getData();
					doc.addText(data);
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
