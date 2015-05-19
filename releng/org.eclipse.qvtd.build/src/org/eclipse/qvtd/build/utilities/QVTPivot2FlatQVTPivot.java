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
package org.eclipse.qvtd.build.utilities;

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;

/**
 * Merge the QVT Pivot files intp a single flat package for use by ModelMorf
 */
public class QVTPivot2FlatQVTPivot
{

	public static void main(String [ ] args) throws IOException {
		ProjectMap projectMap = new ProjectMap(false);
//		EcorePlugin.ExtensionProcessor.process(Ecore2UML.class.getClassLoader());
		ResourceSet ecoreResourceSet = new ResourceSetImpl();
		projectMap.initializeResourceSet(ecoreResourceSet);
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		EcorePackage.eINSTANCE.getClass();
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.ocl.pivot/model/Pivot.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.ecore", true), true);
		ecoreResourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore", true), true);
		EcoreUtil.resolveAll(ecoreResourceSet);
		//
		EPackage flatPackage = EcoreFactory.eINSTANCE.createEPackage();
		flatPackage.setName("flatqvt");
		flatPackage.setNsURI("http://www.eclipse.org/qvt/2015/FlatQVT");
		flatPackage.setNsPrefix("flatqvt");
		for (Resource ecoreResource : ecoreResourceSet.getResources()) {
			for (EObject eObject : ecoreResource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					for (EClassifier eClassifier : new ArrayList<EClassifier>(ePackage.getEClassifiers()))
//						if (!"OppositePropertyCallExp".equals(eClassifier.getName()) || "pivot".equals(ePackage.getName())) {
							flatPackage.getEClassifiers().add(eClassifier);
//						}
				}
			}
		}
		Resource flatResource = ecoreResourceSet.createResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.build/model-gen/FlatQVTpivot.ecore", true));
		flatResource.getContents().add(flatPackage);
		alphabeticize(flatResource);
//		assignIDs(flatResource);
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		saveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		flatResource.save(saveOptions);
		//
		//	Create ModelMorf compatible FlatQVT.xml
		//
		Resource emofResource = ecoreResourceSet.createResource(URI.createPlatformResourceURI("/org.eclipse.qvtd.build/model-gen/FlatQVTpivot.emof", true));
//		emofResource.setURI(URI.createPlatformResourceURI("/org.eclipse.qvtd.build/model-gen/FlatQVTpivot.xml", true));
		emofResource.getContents().addAll(flatResource.getContents());
		List<EReference> eReferences = new ArrayList<EReference>();
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
				eReferences.add((EReference)eObject);
			}
		}
		for (EReference eReference : eReferences) {
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

//		ByteArrayOutputStream os = new ByteArrayOutputStream();
		emofResource.save(saveOptions);
//		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//		OutputStream s = URIConverter.WriteableOutputStream();
		Map<String, Object> emofSaveOptions = new HashMap<String, Object>();
		emofSaveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		emofSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		emofSaveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
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

/*	public static void disorderNonCollections(Resource umlResource) {
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
	} */

/*	public static void nameAssociations(Resource umlResource) {
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
	} */

	public static void alphabeticize(Resource ecoreResource) {
		List<List<? extends ENamedElement>> listOfLists = new ArrayList<List<? extends ENamedElement>>();
		for (Iterator<EObject> it = ecoreResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				listOfLists.add(ePackage.getESubpackages());
				listOfLists.add(ePackage.getEClassifiers());
			}
			else if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				listOfLists.add(eClass.getESuperTypes());
				listOfLists.add(eClass.getEStructuralFeatures());
				listOfLists.add(eClass.getEOperations());
			}
		}
		for (List<? extends ENamedElement> list : listOfLists) {
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
		if (!(object instanceof ENamedElement)) {
			return "$$" + ((EObject)object).eClass().getName() + "$$";
		}
		String name = ((ENamedElement)object).getName();
		if (name == null) {
			return "$$null$$";
		}
		return name;
	}
	

	public static void assignIDs(Resource umlResource) {
/*		UMLSwitch<String> idAssigner = new UMLSwitch<String>() {

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
		} */
	}

	protected static <T extends ENamedElement> void sortList(List<T> list) {
		List<T> newList = new ArrayList<T>(list);
		Collections.sort(newList, new Comparator<T>()
		{
			@Override
			public int compare(T o1, T o2) {
				EClass e1 = o1.eClass();
				EClass e2 = o2.eClass();
				if (e1 != e2) {
					if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e2)) {
						return 1;
					}
					if (EcorePackage.Literals.EENUM.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.EENUM.isSuperTypeOf(e2)) {
						return 1;
					}
					if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e1)) {
						return -1;
					}
					else if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e2)) {
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
