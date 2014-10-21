package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.XMIUtils;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;

public class QVTflatCopier extends EcoreUtil.Copier
{
	protected static final class ModelMorfResourceImpl extends EMOFResourceImpl
	{
		protected ModelMorfResourceImpl(URI uri) {
			super(uri);
			getDefaultSaveOptions();
		}

		@Override
		public Map<Object, Object> getDefaultSaveOptions() {
			if (defaultSaveOptions == null) {
				defaultSaveOptions = new HashMap<Object, Object>();
				defaultSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
				defaultSaveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
				defaultSaveOptions.put("LINE_DELIMITER", "\n");	// XMLResource.OPTION_LINE_DELIMITER
			}
			return defaultSaveOptions;
		}

		@Override
		public String makeID(EObject eObject) {
			return EcoreUtil.generateUUID();

		}

		@Override
		protected boolean useIDs() {
			return true;
		}
	}

	private static final Logger logger = Logger.getLogger(QVTflatCopier.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Collection<Resource> createFlatResource(@NonNull Resource asResource, @NonNull URI flatURI, @NonNull Resource flatResource) {
		Collection<EObject> sources = new HashSet<EObject>(asResource.getContents());
		Map<Resource, Resource> mmResources = new HashMap<Resource, Resource>();
	    Resource emofResource = new ModelMorfResourceImpl(flatURI);
		ASSaver asSaver = new ASSaver(asResource);
		asSaver.localizeSpecializations();
		asSaver.normalizeContents();
		mmResources.put(asResource, emofResource);
		for (EObject eObject : EcoreUtil.ExternalCrossReferencer.find(asResource).keySet()) {
			Resource eResource = eObject.eResource();
			if (eResource != null) {
				if (sources.addAll(eResource.getContents())) {
					URI uri = flatURI.trimSegments(1).appendSegment(eResource.getURI().lastSegment()).trimFileExtension().trimFileExtension().appendFileExtension("xml");
				    Resource mmResource = new ModelMorfResourceImpl(uri);
					asSaver = new ASSaver(eResource);
					asSaver.localizeSpecializations();
					asSaver.normalizeContents();
				    mmResources.put(eResource, mmResource);
				}
			}
		}
		Set<EClass> pivotEClasses = new HashSet<EClass>();
		for (Resource eResource : mmResources.keySet()) {
			for (TreeIterator<EObject> tit = eResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				EClass eClass = eObject.eClass();
				if (eClass != null) {
					pivotEClasses.add(eClass);
				}
			}
		}
		QVTflatCopier copier = new QVTflatCopier();
		copier.init(pivotEClasses, flatResource);
		copier.copyAll(sources);
		copier.copyReferences();
		for (Resource eResource : mmResources.keySet()) {
			Resource xmlResource = mmResources.get(eResource);
			for (EObject eObject : eResource.getContents()) {
				EObject xmlObject = copier.get(eObject);
				if (xmlObject != null) {
					xmlResource.getContents().add(xmlObject);
				}
			}
			XMIUtils.assignIds(xmlResource, "");
		}
		return mmResources.values();
	}

	public @NonNull Map<EClass, EClass> eClass2eClass = new HashMap<EClass, EClass>();
	public @NonNull Map<EStructuralFeature, EStructuralFeature> eStructuralFeature2eStructuralFeature = new HashMap<EStructuralFeature, EStructuralFeature>();
	public @NonNull Map<Enumerator, Enumerator> eEnumerator2eEnumerator = new HashMap<Enumerator, Enumerator>();

	public QVTflatCopier() {
		super(true, true);
	}

	@Override
	protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
		if ("implementation".equals(eAttribute.getName())) {
//			copyEObject.eSet(eAttribute, null);
//			super.copyAttribute(eAttribute, eObject, copyEObject);
		}
		else {
			super.copyAttribute(eAttribute, eObject, copyEObject);
		}
	}

	@Override
	protected void copyAttributeValue(EAttribute eAttribute, EObject eObject, Object value, EStructuralFeature.Setting setting) {
		if (value instanceof Enumerator) {
			value = eEnumerator2eEnumerator.get(value);
		}
		else if (value instanceof BigInteger) {
			value = ((BigInteger) value).intValue();
		}
		super.copyAttributeValue(eAttribute, eObject, value, setting);
	}

	@Override
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		if ("implementation".equals(eReference.getName())) {
			copyEObject.eSet(eReference, null);
		}
		else {
			try {
				super.copyReference(eReference, eObject, copyEObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected EObject createCopy(EObject eObject) {
		EClass eClass = getTarget(eObject);
		if (eClass == null) {
			return null;
		}
		return new DynamicEObjectImpl(eClass);
	}

	@Override
	protected EClass getTarget(EClass eClass) {
		return eClass2eClass.get(eClass);
	}

	@Override
	protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature2eStructuralFeature.get(eStructuralFeature);
	}
	
	public void init(@NonNull Set<EClass> pivotEClasses, @NonNull Resource flatResource) {
		Map<String, EClass> flatName2eClass = new HashMap<String, EClass>();
		Map<String, EEnum> flatName2eEnum = new HashMap<String, EEnum>();
		Map<String, EDataType> flatName2eDataType = new HashMap<String, EDataType>();
		initEObjects(flatName2eClass, flatName2eEnum, flatName2eDataType, flatResource.getContents());
		if (!flatName2eDataType.containsKey(PivotPackage.Literals.BOOLEAN.getName())) {
			put(PivotPackage.Literals.BOOLEAN, EcorePackage.Literals.EBOOLEAN);
		}
		if (!flatName2eDataType.containsKey(PivotPackage.Literals.INTEGER.getName())) {
			put(PivotPackage.Literals.INTEGER, EcorePackage.Literals.EINT);
		}
		if (!flatName2eDataType.containsKey(PivotPackage.Literals.STRING.getName())) {
			put(PivotPackage.Literals.STRING, EcorePackage.Literals.ESTRING);
		}
		Map<String, EClass> pivotName2eClass = new HashMap<String, EClass>();
		Set<EPackage> pivotEPackages = new HashSet<EPackage>();
		for (EClass pivotEClass : pivotEClasses) {
			if (pivotEClass != null) {
				pivotEPackages.add(pivotEClass.getEPackage());
				String name = pivotEClass.getName();
				if (name != null) {
					pivotName2eClass.put(name, pivotEClass);
				}
			}
		}
		for (EClass pivotEClass : new ArrayList<EClass>(pivotName2eClass.values())) {
			if (pivotEClass != null) {
				initSuperEClasses(pivotName2eClass, pivotEClass);
			}
		}
		List<String> keySet = new ArrayList<String>(pivotName2eClass.keySet());
		Collections.sort(keySet);
		for (String key : keySet) {
			EClass pivotEClass = pivotName2eClass.get(key);
			EClass flatEClass = flatName2eClass.get(key);
			eClass2eClass.put(pivotEClass, flatEClass);
//			StringBuilder s = new StringBuilder();
//			s.append(pivotEClass.getEPackage().getName() + "(" + pivotEClass.getEPackage().getNsURI() + ")::" + pivotEClass.getName() + " => ");
//			if (flatEClass != null) {
//				s.append(flatEClass.getEPackage().getName() + "(" + flatEClass.getEPackage().getNsURI() + ")::" + flatEClass.getName());
//			}
//			System.out.println(s.toString());
			if (flatEClass != null) {
				for (EStructuralFeature pivotEStructuralFeature : pivotEClass.getEStructuralFeatures()) {
					EStructuralFeature flatEStructuralFeature = flatEClass.getEStructuralFeature(pivotEStructuralFeature.getName());
					if (flatEStructuralFeature != null) {
						EStructuralFeature oldFlatEStructuralFeature = eStructuralFeature2eStructuralFeature.put(pivotEStructuralFeature, flatEStructuralFeature);
						if (oldFlatEStructuralFeature != null) {
							logger.warn(oldFlatEStructuralFeature + " replaced by " + flatEStructuralFeature);
						}
					}
					else {
						logger.warn("No flat EStructuralFeature for " + pivotEStructuralFeature);
					}
				}
				if ((pivotEClass instanceof EEnum) && (flatEClass instanceof EEnum)) {
					for (EEnumLiteral pivotEEnumLiteral : ((EEnum)pivotEClass).getELiterals()) {
						EEnumLiteral flatEEnumLiteral = ((EEnum)flatEClass).getEEnumLiteral(pivotEEnumLiteral.getName());
						if (flatEEnumLiteral != null) {
							eEnumerator2eEnumerator.put(pivotEEnumLiteral.getInstance(), flatEEnumLiteral.getInstance());
						}
					}
				}
			}
		}
		for (EPackage pivotEPackage : pivotEPackages) {
			if (pivotEPackage != null) {
				for (EClassifier pivotEClassifier : pivotEPackage.getEClassifiers()) {
					if (pivotEClassifier instanceof EEnum) {
						EEnum pivotEEnum = (EEnum)pivotEClassifier;
						String name = pivotEEnum.getName();
						if (name != null) {
							EEnum flatEEnum = flatName2eEnum.get(name);
							if (flatEEnum != null) {
								for (EEnumLiteral pivotEEnumLiteral : pivotEEnum.getELiterals()) {
									EEnumLiteral flatEEnumLiteral = flatEEnum.getEEnumLiteral(pivotEEnumLiteral.getName());
									if (flatEEnumLiteral != null) {
										eEnumerator2eEnumerator.put(pivotEEnumLiteral.getInstance(), flatEEnumLiteral.getInstance());
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void initSuperEClasses(@NonNull Map<String, EClass> pivotName2eClass, @NonNull EClass pivotEClass) {
		for (EClass eSuperClass : pivotEClass.getESuperTypes()) {
			if (eSuperClass != null) {
				String name = eSuperClass.getName();
				if ((name != null) && !pivotName2eClass.containsKey(name)) {
					pivotName2eClass.put(name,  eSuperClass);
					initSuperEClasses(pivotName2eClass, eSuperClass);
				}
			}
		}
	}

	protected void initEObjects(@NonNull Map<String, EClass> name2eClass, @NonNull Map<String, EEnum> name2eEnum, @NonNull Map<String, EDataType> name2eDataType, @Nullable Iterable<? extends EObject> eObjects) {
		if (eObjects != null) {
			for (EObject eObject : eObjects) {
				if (eObject instanceof EClass) {
					EClass eClass = (EClass)eObject;
					String name = eClass.getName();
					if (name != null) {
						EClassifier oldEClassifier = name2eClass.put(name, eClass);
						if (oldEClassifier != null) {
							logger.warn(oldEClassifier + " replaced by " + eClass);
						}
					}
				}
				else if (eObject instanceof EEnum) {
					EEnum eEnum = (EEnum)eObject;
					String name = eEnum.getName();
					if (name != null) {
						EEnum oldEEnum = name2eEnum.put(name, eEnum);
						if (oldEEnum != null) {
							logger.warn(oldEEnum + " replaced by " + eEnum);
						}
					}
				}
				else if (eObject instanceof EDataType) {
					EDataType eDataType = (EDataType)eObject;
					String name = eDataType.getName();
					if (name != null) {
						EDataType oldEDataType = name2eDataType.put(name, eDataType);
						if (oldEDataType != null) {
							logger.warn(oldEDataType + " replaced by " + eDataType);
						}
					}
				}
				else if (eObject instanceof EPackage) {
					initEObjects(name2eClass, name2eEnum, name2eDataType, ((EPackage)eObject).getEClassifiers());
					initEObjects(name2eClass, name2eEnum, name2eDataType, ((EPackage)eObject).getESubpackages());
				}
			}
		}
	}
}