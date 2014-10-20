/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;

/**
 * Merge the QVT Pivot files into a single flat package for use by ModelMorf
 */
public class QVTPivot2FlatQVTPivot
{

	private static final Comparator<? super EClass> superTypeComparator = new Comparator<EClass>()
	{
		private Map<String, String> map = new HashMap<String, String>();
		
		{		// Inheritance must beconsistently ordered to avoid EMF anomalies wrt inverseFeatureIDs
			map.put("Type", "01");
			map.put("Feature", "02");
			map.put("Namespace", "1");
			map.put("NamedElement", "2");
			map.put("Rule", "40");
			map.put("Domain", "41");
			map.put("Area", "42");
			map.put("DynamicElement", "~90");
			map.put("ReferringElement", "~91");
			map.put("ParameterableElement", "~92");
			map.put("TemplateableElement", "~93");
			map.put("NameableElement", "~94");
		}
		
		@Override
		public int compare(EClass o1, EClass o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			String s1 = map.get(n1);
			String s2 = map.get(n2);
			if (s1 == null) s1 = n1;
			if (s2 == null) s2 = n1;
			if (s1 == null) s1 = "";
			if (s2 == null) s2 = "";
			return s1.compareTo(s2);
		}
		
	};

	public static void main(String [ ] args) throws IOException {
		ProjectMap projectMap = new ProjectMap();
		List<URI> uris = new ArrayList<URI>();
		uris.add(URI.createPlatformResourceURI("/org.eclipse.ocl.examples.pivot/model/Pivot.ecore", true));
		uris.add(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore", true));
		uris.add(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore", true));
		uris.add(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore", true));
		uris.add(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.ecore", true));
		uris.add(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore", true));
		URI ecoreURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtbase/model-gen/FlatQVTpivot.ecore", true);
		createFlatResources(projectMap, uris, true, ecoreURI);
//		URI ecoreURI2 = URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtbase/model-gen/FlatQVTpivot2.ecore", true);
//		createFlatResources(projectMap, uris, false, ecoreURI2);
		return;
	}

	protected static void createFlatResources(@NonNull ProjectMap projectMap, @NonNull Iterable <URI> uris, boolean excludePrimitives, @NonNull URI ecoreURI) throws IOException {
		URI emofURI = ecoreURI.trimFileExtension().appendFileExtension("emof");
		ResourceSet ecoreResourceSet = new ResourceSetImpl();
		projectMap.initializeResourceSet(ecoreResourceSet);
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		EcorePackage.eINSTANCE.getClass();
		for (URI uri : uris) {
			ecoreResourceSet.getResource(uri, true);
		}
		EcoreUtil.resolveAll(ecoreResourceSet);
		//
		Resource flatResource = createFlatResource(ecoreResourceSet, ecoreURI, excludePrimitives);
		alphabeticize(flatResource);
		List<EClass> flatEClasses = new ArrayList<EClass>();
		List<EReference> flatEReferences = new ArrayList<EReference>();
		preprocessFlatResource(flatResource, flatEClasses, flatEReferences);
		List<EReference> eOpposites = installEOpposites(flatEReferences);
		removeDuplicateEOpposites(flatEClasses, eOpposites);
		saveFlatResource(flatResource);
		//
		//	Create ModelMorf compatible FlatQVT.xml
		//
		Resource emofResource = ecoreResourceSet.createResource(emofURI);
//		emofResource.setURI(URI.createPlatformResourceURI("/org.eclipse.qvtd.build/model-gen/FlatQVTpivot.xml", true));
		emofResource.getContents().addAll(flatResource.getContents());
		for (TreeIterator<EObject> tit = emofResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
//			if (eObject instanceof EPackage) {
//				EPackage ePackage = (EPackage)eObject;
//				ePackage.setNsPrefix(null);
//			}
//			if (eObject instanceof EClassifier) {
//				EClassifier eClassifier = (EClassifier)eObject;
//				eClassifier.setInstanceClassName(null);
//			}
			if (eObject instanceof EEnumLiteral) {
				EEnumLiteral eEnumLiteral = (EEnumLiteral)eObject;
				eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
			}
		}

//		emofResource.save(saveOptions);
		saveFlatEmofResource(emofResource);
	}

	/**
	 * Create and return Flat Package within a Flat Resource by reparenting all the EClasses of all the EPackages within all the
	 * Resources of the resourceSet.
	 * <p>
	 * Unwanted primitive types such as Boolean, Integer, Real, String, UnlimitedNatural are not migrated so that subseqiuent
	 * usage is resoved to Ecore/EMOF types.
	 * <p>
	 * Unwanted types such as Visitable and Visitor are also not migrated.
	 */
	protected static @NonNull Resource createFlatResource(@NonNull ResourceSet resourceSet, @NonNull URI ecoreURI, boolean excludePrimitives) {
		EPackage emofPackage = EcoreFactory.eINSTANCE.createEPackage();
		emofPackage.setName("emof");
		emofPackage.setNsURI(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI);
		emofPackage.setNsPrefix("emof");
		EPackage flatPackage = EcoreFactory.eINSTANCE.createEPackage();
		flatPackage.setName("flatemofqvt");
		flatPackage.setNsURI("http://www.eclipse.org/qvt/0.9/FlatEmofQVT");
		flatPackage.setNsPrefix("flatemofqvt");
		//
		//	Copy wanted classes to the Flat package, other classes are lost in the 'EMOF' package.
		//
		for (Resource resource : resourceSet.getResources()) {
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					for (EClassifier eClassifier : new ArrayList<EClassifier>(ePackage.getEClassifiers())) {
						String name = eClassifier.getName();
						if (excludePrimitives && isPrimitive(name)) {
							emofPackage.getEClassifiers().add(eClassifier);
						}
//						else if ("Metaclass".equals(name)) {
//							emofPackage.getEClassifiers().add(eClassifier);
//						}
						else if ("Visitable".equals(name)) {
							emofPackage.getEClassifiers().add(eClassifier);
						}
						else if ("Visitor".equals(name)) {
							emofPackage.getEClassifiers().add(eClassifier);
						}
						else {
							flatPackage.getEClassifiers().add(eClassifier);
						}
					}
				}
			}
		}
		Resource flatResource = resourceSet.createResource(ecoreURI);
//		flatResource.getContents().add(emofPackage);		-- throw away the unwanted types redirected to EMOF.
		flatResource.getContents().add(flatPackage);
		return flatResource;
	}

	private static boolean isPrimitive(String name) {
		return "Boolean".equals(name) || "Integer".equals(name) || "Real".equals(name) || "String".equals(name) || "UnlimitedNatural".equals(name);
	}

	/**
	 * Save emofResource correcting usage of "http://schema.omg.org/spec/mof/2.0/emof.xml" to "http://schema.omg.org/spec/mof/2.0/emof.xmi".
	 */
	protected static void saveFlatEmofResource(@NonNull Resource emofResource) throws IOException {
		Map<String, Object> emofSaveOptions = new HashMap<String, Object>();
		emofSaveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		emofSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		emofSaveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		emofSaveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		ByteArrayOutputStream s = new ByteArrayOutputStream();
		emofResource.save(s, emofSaveOptions);
		OutputStream os = emofResource.getResourceSet().getURIConverter().createOutputStream(emofResource.getURI());
		Writer ow = new OutputStreamWriter(os);
		ByteArrayInputStream is = new ByteArrayInputStream(s.toByteArray());
		BufferedReader ir = new BufferedReader(new InputStreamReader(is));
		for (String inLine = ir.readLine(); inLine != null; inLine = ir.readLine()) {
			String outline = inLine.replace(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0, EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI);
			ow.append(outline + "\n");
		}
		ow.close();
		os.close();
	}

	protected static void saveFlatResource(Resource flatResource) throws IOException {
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
		saveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		flatResource.save(saveOptions);
	}

	/**
	 * Analyze the flatResource to identify and return all EClasses and all EReferences.
	 * <p>
	 * Usage of PrimitiveTypes is adjusted to use Ecore/EMOF types with a -1 rather than * upperbound.
	 * <p>
	 * The Visitable type is removed as a superclass. Superclasses are sorted into a consistent order that avoids
	 * EMF problems with inconsistent multiple inheritnace.
	 */
	protected static void preprocessFlatResource(Resource flatResource, List<EClass> flatEClasses, List<EReference> flatEReferences) {
		for (TreeIterator<EObject> tit = flatResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
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
					else if ("Real".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.EDOUBLE);
					}
					else if ("String".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.ESTRING);
					}
					else if ("UnlimitedNatural".equals(eType.getName())) {
						eTypedElement.setEType(EcorePackage.Literals.EINT);
					}
				}
			}
			if (eObject instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)eObject;
				eStructuralFeature.setTransient(false);
				if ("*".equals(eStructuralFeature.getDefaultValueLiteral())) {
					if (EcorePackage.Literals.EINT == eStructuralFeature.getEType()) {
						eStructuralFeature.setDefaultValueLiteral("-1");
					}
				}
			}
			if (eObject instanceof EReference) {
				EReference eReference = (EReference)eObject;
				((EReference)eObject).setResolveProxies(true);
//				if (!eReference.isContainer() && !eReference.isContainment()) {
				flatEReferences.add(eReference);
//				}
			}
			if (eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;
				flatEClasses.add(eClass);
				List<EClass> eSuperTypes = eClass.getESuperTypes();
				EClass visitable = EcoreUtils.getNamedElement(eSuperTypes, "Visitable");
				if (visitable != null) {
					eSuperTypes.remove(visitable);
				}
				if (eSuperTypes.size() > 1) {
					List<EClass> sortedSuperTypes = new ArrayList<EClass>(eSuperTypes);
					Collections.sort(sortedSuperTypes, superTypeComparator);
					eSuperTypes.clear();
					eSuperTypes.addAll(sortedSuperTypes);
				}
			}
		}
	}

	/**
	 * Remove all EOpposites that would give validation warnings fronm either a duplicate name or a conflicting
	 * mixed case name within the visible inheritance.
	 */
	protected static void removeDuplicateEOpposites(@NonNull List<EClass> eClasses, @NonNull List<EReference> eOpposites) {
		//
		//	Avoid validation warnings from exact duplicates
		//
		Set<EReference> badEOpposites = new HashSet<EReference>();
		for (EReference eOpposite : eOpposites) {
			EClass eOwningType = eOpposite.getEContainingClass();
			int count = 0;
			for (EStructuralFeature eStructuralFeature : eOwningType.getEAllStructuralFeatures()) {
				if (eOpposite.getName().equals(eStructuralFeature.getName())) {
					count++;
				}
			}
			if (count > 1) {
				badEOpposites.add(eOpposite);
			}
		}
		//
		//	Avoid validation warnings from mixed case duplicates
		//
		for (EClass eClass : eClasses) {
			List<EStructuralFeature> eAllStructuralFeatures = eClass.getEAllStructuralFeatures();
			for (EStructuralFeature refStructuralFeature : eAllStructuralFeatures) {
				String refName = refStructuralFeature.getName();
				if (Character.isLowerCase(refName.charAt(0))) {
					String refUCname = refName.toUpperCase();
					for (EStructuralFeature aStructuralFeature : eAllStructuralFeatures) {
						String aName = aStructuralFeature.getName();
						if (!aName.equals(refName)) {
							String ucName = aName.toUpperCase();
							if (ucName.equals(refUCname) && (aStructuralFeature instanceof EReference)) {
								badEOpposites.add((EReference) aStructuralFeature);
							}
						}
					}
					
				}
			}
		}
		for (EReference eOpposite : badEOpposites) {
			eOpposite.getEOpposite().setEOpposite(null);
			eOpposite.getEContainingClass().getEStructuralFeatures().remove(eOpposite);
		}
	}

	/**
	 * Create and install an explicit EReference.eOpposite for every reference with an oppositeRoleName.
	 * REturns a list of all the new references.
	 */
	protected static @NonNull List<EReference> installEOpposites(@NonNull List<EReference> eReferences) {
		List<EReference> eOpposites = new ArrayList<EReference>();
		for (EReference eReference : eReferences) {
			EReference eOpposite = eReference.getEOpposite();
			EClass eOwningType = eReference.getEContainingClass();
			if ((eOpposite == null) && (eOwningType.getETypeParameters().size() == 0)) {
				EClass eReferencedType = eReference.getEReferenceType();
				String oppositeRoleName = EcoreUtil.getAnnotation(eReference, EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE, "body");
				if (oppositeRoleName != null) {
					EAnnotation eAnnotation = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
					eReference.getEAnnotations().remove(eAnnotation);
					eOpposite = EcoreFactory.eINSTANCE.createEReference();
					eOpposite.setName(oppositeRoleName);
					eOpposite.setEType(eOwningType);
					eOpposite.setLowerBound(0);
					eOpposite.setUpperBound(eReference.isContainment() ? 1 : -1);
					eReferencedType.getEStructuralFeatures().add(eOpposite);
					eReference.setEOpposite(eOpposite);
					eOpposite.setEOpposite(eReference);
					eOpposites.add(eOpposite);
				}
			}
		}
		return eOpposites;
	}

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
