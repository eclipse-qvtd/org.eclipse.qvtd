package org.eclipse.qvt.tools;

import java.io.IOException;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Translator from the QVT 1.2 *.ecore master to the QVT 1.2 distribution
 * @author Ed.Willink
 *
 */
public class Ecore2UML {
	
	public static class MyConverter extends UMLUtil.Ecore2UMLConverter {
		
		public Element get(EObject eObject) {
			return eModelElementToElementMap.get(eObject);
		}
	}

	public static void main(String [ ] args) throws IOException {
		ProjectMap projectMap = new ProjectMap();
//		EcorePlugin.ExtensionProcessor.process(Ecore2UML.class.getClassLoader());
		ResourceSet ecoreResourceSet = new ResourceSetImpl();
		projectMap.initializeResourceSet(ecoreResourceSet);
		ecoreResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
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
		ResourceSet umlResourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(umlResourceSet);
		for (Resource ecoreResource : new ArrayList<Resource>(ecoreResourceSet.getResources())) {	// Ignore any profiles that aappear
			URI ecoreURI = ecoreResource.getURI();
			URI umlURI = ecoreURI.trimFileExtension().appendFileExtension("uml");
			Resource umlResource = umlResourceSet.createResource(umlURI);
			for (EObject eObject : ecoreResource.getContents()) {
				Element umlElement = ecore2umlConverter.get(eObject);
				if (umlElement != null) {
					umlResource.getContents().add(umlElement);
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
		for (Resource umlResource : umlResourceSet.getResources()) {
			umlResource.save(saveOptions);
		}
		//
		//	Resave *.uml as *.xmi
		//
		ResourceSet xmiResourceSet = new ResourceSetImpl();
		xmiResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		for (Resource umlResource : umlResourceSet.getResources()) {
			URI xmiURI = umlResource.getURI().trimFileExtension().appendFileExtension("xmi");
			XMIResource xmiResource = (XMIResource) xmiResourceSet.createResource(xmiURI);
		    xmiResource.setXMIVersion("20110701");
			xmiResource.getContents().addAll(umlResource.getContents());
		}
		for (Resource xmiResource : xmiResourceSet.getResources()) {
			assignIDs(xmiResource);
		}
		Map<String, Object> xmiSaveOptions = new HashMap<String, Object>();
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
			xmiResource.save(xmiSaveOptions);
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
		flatEPackage.setNsURI("http://schema.omg.org/spec/QVT/20120401/FlatQVT");
		flatEPackage.getEClassifiers().addAll(flattenedObjects);
		flatResource.getContents().add(flatEPackage);
		flatResource.save(saveOptions);
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
			public String caseGeneralization(Generalization object) {
				Classifier specific = object.getSpecific();
				Classifier general = object.getGeneral();
				String string = "G_" + safeNameOf(specific) + "_" + safeNameOf(general);
				return string;
			}

			@Override
			public String caseParameter(Parameter object) {
				return doSwitch(object.getOperation()) + "." + safeNameOf(object);
			}

			@Override
			public String caseOperation(Operation object) {
				return super.caseOperation(object);
			}

			@Override
			public String caseProperty(Property object) {
				return /*object.getClass().getPackage().getName() + "." +*/ safeNameOf(object.getOwner()) + "." + safeNameOf(object);
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
				return safeNameOf(object);
			}
			
		};
		for (Iterator<EObject> it = umlResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			String id = idAssigner.doSwitch(eObject);
			((XMLResource)umlResource).setID(eObject, id.length() > 0 ? id : null);
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
