/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.resource.UMLSaveImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Translator from the QVT 1.2 *.ecore master to the QVT 1.2 distribution
 */
@SuppressWarnings("restriction")
public class Ecore2UML {
	
	public static class MyConverter extends UMLUtil.Ecore2UMLConverter {
		
		public Element get(EObject eObject) {
			return eModelElementToElementMap.get(eObject);
		}

		@Override	// Overridden to give Package not Model at root
		public Object caseEPackage(EPackage ePackage) {
			org.eclipse.uml2.uml.Package package_ = UMLFactory.eINSTANCE.createPackage();
			eModelElementToElementMap.put(ePackage, package_);

			if (!ePackages.contains(ePackage)) {
				EPackage eSuperPackage = ePackage.getESuperPackage();

				if (eSuperPackage != null) {
					((org.eclipse.uml2.uml.Package) doSwitch(eSuperPackage))
						.getNestedPackages().add(package_);
				}
			}

			package_.setName(ePackage.getName());
			package_.setURI(ePackage.getNsURI());

			defaultCase(ePackage);

			return package_;
		}
	}
	
	public static class MyXMIResourceFactoryImpl extends XMIResourceFactoryImpl
	{
		@Override
		public Resource createResource(URI uri) {
		    return new MyXMIResourceImpl(uri);
		}
		
	}

	public static class MyXMIResourceImpl extends XMIResourceImpl
	{
		public MyXMIResourceImpl(URI uri) {
			super(uri);
		}

		@Override
		protected XMLSave createXMLSave() {
		    return new MyXMISaveImpl(createXMLHelper());
		}

		@Override
		protected XMLSave createXMLSave(Map<?, ?> options) {
		    if (options != null && Boolean.TRUE.equals(options.get(OPTION_SUPPRESS_XMI)))
		    {
		      return new MyXMISaveImpl(new XMLHelperImpl(this));
		    }
		    else
		    {
		      return super.createXMLSave(options);
		    }
		}
	}
	
	public static class MyXMISaveImpl extends UMLSaveImpl
	{
		public MyXMISaveImpl(XMLHelper helper) {
			super(helper);
		}

		@Override	// Overridden to give xmi:type for root objects
		protected void saveElementID(EObject o) {
			if (o.eContainer() == null) {
				EClass eClass = o.eClass();
				if (eClass instanceof EDataType) {
					saveTypeAttribute((EDataType) eClass);
				} else {
					saveTypeAttribute(eClass);
				}
			}
			super.saveElementID(o);
		}
	}

	public static void main(String [ ] args) throws IOException {
		ProjectMap projectMap = new ProjectMap(false);
//		EcorePlugin.ExtensionProcessor.process(Ecore2UML.class.getClassLoader());
		ResourceSet ecoreResourceSet = new ResourceSetImpl();
		projectMap.initializeResourceSet(ecoreResourceSet);
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		EcorePackage.eINSTANCE.getClass();
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/PrimitiveTypes.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/EMOF.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/EssentialOCL.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVTBase.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVTCore.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVTTemplate.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVTRelation.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/ImperativeOCL.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVTOperational.ecore", true), true);
		EcoreUtil.resolveAll(ecoreResourceSet);
		Set<EObject> allEcoreObjects = new HashSet<EObject>();
		for (TreeIterator<Notifier> tit = ecoreResourceSet.getAllContents(); tit.hasNext(); ) {	// Ignore any profiles that appear
			Notifier next = tit.next();
			if (next instanceof EObject) {
				allEcoreObjects.add((EObject) next);
			}
		}
		//
		//	Convert *.ecore to *.uml
		//
		MyConverter ecore2umlConverter = new MyConverter();
		Map<String, String> convertOptions = new HashMap<String, String>();
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__REDEFINES_ANNOTATIONS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__SUBSETS_ANNOTATIONS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__UNION_ANNOTATIONS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__BODY_ANNOTATIONS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__DOCUMENTATION_ANNOTATIONS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__XMI_IDENTIFIERS, UMLUtil.OPTION__IGNORE);
		convertOptions.put(UMLUtil.Ecore2UMLConverter.OPTION__OPPOSITE_ROLE_NAMES, UMLUtil.OPTION__PROCESS);
		ecore2umlConverter.convert(allEcoreObjects, convertOptions, null, null);
		Map<Element,String> nsPrefixes = new HashMap<Element,String>();
		ResourceSet umlResourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(umlResourceSet);
		for (Resource ecoreResource : new ArrayList<Resource>(ecoreResourceSet.getResources())) {	// Ignore any profiles that appear
			URI ecoreURI = ecoreResource.getURI();
			URI umlURI = URI.createPlatformResourceURI("/org.eclipse.qvt/model/uml/" + ecoreURI.trimFileExtension().lastSegment() + ".uml", true);
			Resource umlResource = umlResourceSet.createResource(umlURI);
			for (EObject eObject : ecoreResource.getContents()) {
				Element umlElement = ecore2umlConverter.get(eObject);
				if (umlElement != null) {
					umlResource.getContents().add(umlElement);
				}
				if (eObject instanceof EPackage) {
					String nsPrefix = ((EPackage)eObject).getNsPrefix();
					if (nsPrefix != null) {
						nsPrefixes.put(umlElement, nsPrefix);
					}
				}
			}
		}
		//
		//	Prettify *.uml
		//
		for (Resource umlResource : umlResourceSet.getResources()) {
			disorderNonCollections(umlResource);
			nameAssociations(umlResource);
			alphabeticize(umlResource);
			assignIDs(umlResource);
		}
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		saveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		for (Resource umlResource : umlResourceSet.getResources()) {
			umlResource.save(saveOptions);
		}
		EPackage mofPackage = EcoreFactory.eINSTANCE.createEPackage();
		mofPackage.setName("mof");
		mofPackage.setNsURI("http://www.omg.org/spec/MOF/20131001");
		mofPackage.setNsPrefix("mofext");
		EClass mofTag = EcoreFactory.eINSTANCE.createEClass();
		mofTag.setName("Tag");
		mofPackage.getEClassifiers().add(mofTag);
		EAttribute tagName = EcoreFactory.eINSTANCE.createEAttribute();
		tagName.setName("name");
		tagName.setEType(EcorePackage.Literals.ESTRING);
		mofTag.getEStructuralFeatures().add(tagName);
		EAttribute tagValue = EcoreFactory.eINSTANCE.createEAttribute();
		tagValue.setName("value");
		tagValue.setEType(EcorePackage.Literals.ESTRING);
		mofTag.getEStructuralFeatures().add(tagValue);
		EReference tagElement = EcoreFactory.eINSTANCE.createEReference();
		tagElement.setName("element");
		tagElement.setEType(EcorePackage.Literals.EOBJECT);
		mofTag.getEStructuralFeatures().add(tagElement);
		//
		//	Resave *.uml as *.xmi
		//
		ResourceSet xmiResourceSet = new ResourceSetImpl();
		xmiResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new MyXMIResourceFactoryImpl());
		for (Resource umlResource : umlResourceSet.getResources()) {
			URI xmiURI = URI.createPlatformResourceURI("/org.eclipse.qvt/model/xmi/" + umlResource.getURI().trimFileExtension().lastSegment() + ".xmi", true);
			XMIResource xmiResource = (XMIResource) xmiResourceSet.createResource(xmiURI);
		    xmiResource.setXMIVersion("20131001");
			xmiResource.getContents().addAll(umlResource.getContents());
			for (EObject eObject : new ArrayList<EObject>(xmiResource.getContents())) {
				String nsPrefix = nsPrefixes.get(eObject);
				if (nsPrefix != null) {
					EObject tag = new DynamicEObjectImpl(mofTag);
					tag.eSet(tagName, "org.omg.xmi.nsPrefix");
					tag.eSet(tagValue, nsPrefix);
					tag.eSet(tagElement, eObject);
					xmiResource.getContents().add(tag);
				}
			}
		}
		for (Resource xmiResource : xmiResourceSet.getResources()) {
			assignIDs(xmiResource);
		}
		Map<String, Object> xmiSaveOptions = new HashMap<String, Object>();
		xmiSaveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		xmiSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		xmiSaveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		xmiSaveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, new BasicExtendedMetaData(xmiResourceSet.getPackageRegistry())
		{
			@Override
			public String getNamespace(EPackage ePackage) {
				if (ePackage == UMLPackage.eINSTANCE) {
					return "http://www.omg.org/spec/UML/20131001";
				}
				else {
					return super.getNamespace(ePackage);
				}
			}
		});
		for (Resource xmiResource : xmiResourceSet.getResources()) {
			// Save intercepted to strip spurious post XMI 2.4 xmi:version
			ByteArrayOutputStream s = new ByteArrayOutputStream();
			xmiResource.save(s, xmiSaveOptions);
			OutputStream os = xmiResourceSet.getURIConverter().createOutputStream(xmiResource.getURI());
			Writer ow = new OutputStreamWriter(os);
			ByteArrayInputStream is = new ByteArrayInputStream(s.toByteArray());
			BufferedReader ir = new BufferedReader(new InputStreamReader(is));
			for (String inLine = ir.readLine(); inLine != null; inLine = ir.readLine()) {
				String outline = inLine.replace(" xmi:version=\"20131001\" ", " ");
				ow.append(outline + "\n");
			}
			ow.close();
			os.close();
		}
		//
		//	Create QVT.ecore
		//
		List<EObject> rootObjects = new ArrayList<EObject>();
		for (Resource ecoreResource : ecoreResourceSet.getResources()) {
			rootObjects.addAll(ecoreResource.getContents());
		}
		Resource qvtResource = ecoreResourceSet.createResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/QVT.ecore", true));
		qvtResource.getContents().addAll(rootObjects);
		qvtResource.save(saveOptions);
		//
		//	Create FlatQVT.ecore
		//
		List<EClassifier> flattenedObjects = new ArrayList<EClassifier>();
		for (EObject rootEObject : rootObjects) {
			for (EObject eObject : rootEObject.eContents()) {
				if (eObject instanceof EClassifier) {
					flattenedObjects.add((EClassifier) eObject);
				}
			}
		}
		Collections.sort(flattenedObjects, new Comparator<EClassifier>(){
			@Override
			public int compare(EClassifier o1, EClassifier o2) {
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		Resource flatResource = ecoreResourceSet.createResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/FlatQVT.ecore", true));
		EPackage flatEPackage = EcoreFactory.eINSTANCE.createEPackage();
		flatEPackage.setName("FlatQVT");
		flatEPackage.setNsPrefix("qvt");
		flatEPackage.setNsURI("http://www.omg.org/spec/QVT/20140401/FlatQVT");
		flatEPackage.getEClassifiers().addAll(flattenedObjects);
		flatResource.getContents().add(flatEPackage);
		flatResource.save(saveOptions);
		//
		//	Create ModelMorf compatible FlatQVT.xml
		//
		Resource emofResource = ecoreResourceSet.createResource(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/FlatQVT.emof", true));
		emofResource.setURI(URI.createPlatformResourceURI("/org.eclipse.qvt/model/ecore/FlatQVT.xml", true));
		emofResource.getContents().addAll(flatResource.getContents());
		for (TreeIterator<EObject> tit = emofResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage)eObject;
				ePackage.setNsPrefix(null);
			}
			if (eObject instanceof ETypedElement) {
				ETypedElement eTypedElement = (ETypedElement)eObject;
				EClassifier eType = eTypedElement.getEType();
				if (eType != null) {
					if ("Boolean".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.EBOOLEAN);
					}
					else if ("Integer".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.EINT);
					}
//					else if ("Real".equals(eType.getName())) {
//						eTypedElement.setEType(EcorePackage.Literals.EDOUBLE);
//					}
					else if ("String".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.ESTRING);
					}
					else if ("Unlimitednatural".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.EINT);
					}
				}
			}
			if (eObject instanceof EClassifier) {
				EClassifier eClassifier = (EClassifier)eObject;
				eClassifier.setInstanceClassName(null);
			}
			if (eObject instanceof EEnumLiteral) {
				EEnumLiteral eEnumLiteral = (EEnumLiteral)eObject;
				eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
			}
			if (eObject instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)eObject;
				eStructuralFeature.setTransient(false);
			}
			if (eObject instanceof EReference) {
				EReference eReference = (EReference)eObject;
				eReference.setResolveProxies(true);
				EReference eOpposite = eReference.getEOpposite();
				if (eOpposite == null) {
					EClass eOwningType = eReference.getEContainingClass();
					EClass eReferencedType = eReference.getEReferenceType();
					String oppositeRoleName = EcoreUtil.getAnnotation(eReference, EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE, "body");
					if (oppositeRoleName == null) {
						oppositeRoleName = eOwningType.getName();
					}
					else {
						EAnnotation eAnnotation = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
						eReference.getEAnnotations().remove(eAnnotation);
					}
					eOpposite = EcoreFactory.eINSTANCE.createEReference();
					eOpposite.setName(oppositeRoleName);
					eOpposite.setEType(eOwningType);
					eOpposite.setLowerBound(0);
					eOpposite.setLowerBound(1);
					eReferencedType.getEStructuralFeatures().add(eOpposite);
					eReference.setEOpposite(eOpposite);
					eOpposite.setEOpposite(eReference);
				}
			}
		}
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
		emofResource.save(saveOptions);
//		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//		OutputStream s = URIConverter.WriteableOutputStream();
		Map<String, Object> emofSaveOptions = new HashMap<String, Object>();
		xmiSaveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		xmiSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		xmiSaveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		ByteArrayOutputStream s = new ByteArrayOutputStream();
		emofResource.save(s, emofSaveOptions);
		OutputStream os = ecoreResourceSet.getURIConverter().createOutputStream(emofResource.getURI());
		Writer ow = new OutputStreamWriter(os);
		ByteArrayInputStream is = new ByteArrayInputStream(s.toByteArray());
		BufferedReader ir = new BufferedReader(new InputStreamReader(is));
		for (String inLine = ir.readLine(); inLine != null; inLine = ir.readLine()) {
			String outline = inLine.replace(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0, EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI);
			ow.append(outline + "\n");
		}
		ow.close();
		os.close();
		return;
	}

	public static void disorderNonCollections(Resource umlResource) {
		for (Iterator<EObject> it = umlResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof Property) {
				Property property = (Property) eObject;
				if (property.getUpper() == 1) {
					property.setIsOrdered(false);
					property.setIsUnique(true);
				}
			}
		}
	}

	public static void nameAssociations(Resource umlResource) {
		List<List<? extends NamedElement>> listOfLists = new ArrayList<List<? extends NamedElement>>();
		for (Iterator<EObject> it = umlResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof Association) {
				Association association = (Association) eObject;
				List<String> endNames = new ArrayList<String>();
				for (Property end : association.getMemberEnds()) {
					Type type = end.getClass_(); 
					String name = (type != null ? (safeNameOf(type) + ".") : "") + safeNameOf(end);
					endNames.add(name != null ? name : "$$null$$");
				}
				Collections.sort(endNames);
				StringBuilder s = new StringBuilder();
				s.append("A");
				for (String endName : endNames) {
					s.append("_" + endName);
				}
				association.setName(s.toString());
			}
		}
		for (List<? extends NamedElement> list : listOfLists) {
			sortList(list);
		}
	}

	public static void alphabeticize(Resource umlResource) {
		List<List<? extends NamedElement>> listOfLists = new ArrayList<List<? extends NamedElement>>();
		for (Iterator<EObject> it = umlResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) eObject;
				listOfLists.add(package_.getNestedPackages());
				listOfLists.add(package_.getOwnedTypes());
			}
			else if (eObject instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class class_ = (org.eclipse.uml2.uml.Class) eObject;
				listOfLists.add(class_.getGenerals());
				listOfLists.add(class_.getOwnedAttributes());
				listOfLists.add(class_.getOwnedOperations());
			}
		}
		for (List<? extends NamedElement> list : listOfLists) {
			sortList(list);
		}
	}
	

	public static String safeNameOf(Object object) {
		if (object == null) {
			return "$$null$$";
		}
		if (!(object instanceof EObject)) {
			return "$$" + object.getClass().getSimpleName() + "$$";
		}
		if (!(object instanceof NamedElement)) {
			return "$$" + ((EObject)object).eClass().getName() + "$$";
		}
		String name = ((NamedElement)object).getName();
		if (name == null) {
			return "$$null$$";
		}
		return name;
	}
	

	public static void assignIDs(Resource umlResource) {
		UMLSwitch<String> idAssigner = new UMLSwitch<String>() {

			@Override
			public String caseComment(Comment object) {
				return "";
			}

			@Override
			public String caseGeneralization(Generalization object) {
				Classifier specific = object.getSpecific();
				Classifier general = object.getGeneral();
				String string = "G_" + safeNameOf(specific) + "_" + safeNameOf(general);
				return string;
			}

			@Override
			public String caseParameter(Parameter object) {
				if (object.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
					return doSwitch(object.getOperation()) + "." + safeNameOf(object);
				}
				else {
					return "";
				}
			}

			@Override
			public String caseOperation(Operation object) {
				StringBuilder s = new StringBuilder();
				s.append(doSwitch(object.getOwner()));
				s.append(".");
				s.append(safeNameOf(object));
				for (Parameter parameter : object.getOwnedParameters()) {
					if (parameter.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
						s.append("_");
						s.append(doSwitch(parameter.getType()));
					}
				}
				return s.toString();
			}

			@Override
			public String caseProperty(Property object) {
				return safeNameOf(object.getOwner()) + "." + safeNameOf(object);
			}
			
			@Override
			public String casePackage(Package object) {
				return object.getName();
			}

			@Override
			public String caseType(Type object) {
				return safeNameOf(object);
			}

			@Override
			public String caseValueSpecification(ValueSpecification object) {
				return "";
			}

			@Override
			public String defaultCase(EObject object) {
				if (object instanceof DynamicEObjectImpl) {
					return "";
				}
				return safeNameOf(object);
			}
			
		};
		Map<String, EObject> assignedIds = new HashMap<String, EObject>();
		for (Iterator<EObject> it = umlResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			String id = idAssigner.doSwitch(eObject);
			if (id.length() > 0) {
				EObject oldEObject = assignedIds.put(id,  eObject);
				if (oldEObject != null) {
					throw new IllegalStateException(id + " already allocated to a " + oldEObject.eClass().getName());
				}
				((XMLResource)umlResource).setID(eObject, id);
			}
			else {
				((XMLResource)umlResource).setID(eObject, null);
			}
		}
	}

	protected static <T extends NamedElement> void sortList(List<T> list) {
		List<T> newList = new ArrayList<T>(list);
		Collections.sort(newList, new Comparator<T>()
		{
			@Override
			public int compare(T o1, T o2) {
				EClass e1 = o1.eClass();
				EClass e2 = o2.eClass();
				if (e1 != e2) {
					if (UMLPackage.Literals.ASSOCIATION.isSuperTypeOf(e1)) {
						return 1;
					}
					else if (UMLPackage.Literals.ASSOCIATION.isSuperTypeOf(e2)) {
						return -1;
					}
					if (UMLPackage.Literals.PRIMITIVE_TYPE.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (UMLPackage.Literals.PRIMITIVE_TYPE.isSuperTypeOf(e2)) {
						return 1;
					}
					if (UMLPackage.Literals.ENUMERATION.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (UMLPackage.Literals.ENUMERATION.isSuperTypeOf(e2)) {
						return 1;
					}
					if (UMLPackage.Literals.CLASS.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (UMLPackage.Literals.CLASS.isSuperTypeOf(e2)) {
						return 1;
					}
				}
				String n1 = o1.getName();
				String n2 = o2.getName();
				return n1.compareTo(n2);
			}
		});
		list.clear();
		list.addAll(newList);
	}

}
