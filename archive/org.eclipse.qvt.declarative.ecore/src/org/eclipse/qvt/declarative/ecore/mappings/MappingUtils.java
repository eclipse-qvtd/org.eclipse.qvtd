/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: MappingUtils.java,v 1.3 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EGenericTypeImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;

public abstract class MappingUtils
{
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object, T requiredClassObject) {
		return (T) object;
	}

	/**
	 * Return a Map from EPackage.nsURI to EPackage for all packages within resource.
	 */
	public static Map<String, EPackage> createPackageMap(Resource resource) {
		Map<String, EPackage> uriToPackageMap = new HashMap<String, EPackage>();
		createPackageMapRecursion(uriToPackageMap, resource.getContents());
		return uriToPackageMap;
	}

	public static void createPackageMapRecursion(Map<String, EPackage> uriToPackageMap, List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			if (eObject instanceof EPackage) {
				uriToPackageMap.put(((EPackage) eObject).getNsURI(), (EPackage) eObject);
				createPackageMapRecursion(uriToPackageMap, ((EPackage) eObject).getESubpackages());
			}
		}
	}

	/**
	 * Return a list of generic types, all of which are generic. If all input genericTypes
	 * are generic the original list is returned.
	 */
	public static List<EGenericType> excludeNonGenericTypes(List<EGenericType> genericTypes) {
		boolean fullyGeneric = true;
		for (EGenericType genericType : genericTypes)
			if (!MappingUtils.isGeneric(genericType))
				fullyGeneric = false;
		if (fullyGeneric)
			return genericTypes;
		List<EGenericType> reallyGenericTypes = new ArrayList<EGenericType>();
		for (EGenericType genericType : genericTypes)
			if (MappingUtils.isGeneric(genericType))
				reallyGenericTypes.add(genericType);						
		return reallyGenericTypes;
	}

	public static String formatClassAndFeatureName(EObject object) {
		StringBuffer s = new StringBuffer();
		s.append("'");
		formatClassAndFeatureName(s, object);
		s.append("'");
		return s.toString();
	}

	public static void formatClassAndFeatureName(StringBuffer s, EObject object) {
		EObject container = object != null ? object.eContainer() : null;
		if (container instanceof EClass) {
			s.append(formatLocalName(container));
			s.append(".");
		}
		s.append(formatLocalName(object));
	}

	public static String formatFeatureName(AbstractFeatureElement<?> feature) {
		return feature.formatName();
	}

	public static String formatFeatureName(EStructuralFeature eStructuralFeature) {
		return formatLocalName(eStructuralFeature.eContainer()) + "." + formatLocalName(eStructuralFeature);
	}

	public static String formatFullName(Object object) {
		Object container = null;
		if (object instanceof AdaptingEObject) {
			return ((AdaptingEObject) object).getMappingMetaDataRegistry().getName() + "(" + formatFullName(((AdaptingEObject) object).getTarget()) + ")"; 
		}
		if (object instanceof EObject) {
			if (((EObject) object).eIsProxy())
				return EcoreUtil.getURI((EObject) object).toString();
			container = ((EObject) object).eContainer();
		}
		if (object instanceof EClass) {
			EPackage ePackage = ((EClass)object).getEPackage();
			if (ePackage != null)
				return formatString(ePackage.getNsPrefix()) + ":" + formatString(((ENamedElement)object).getName());
			else
				return "??:" + formatString(((ENamedElement)object).getName());
		}
		if (container != null)
			return formatFullName(container) + "/" + formatLocalName(object);
		else
			return "/" + formatLocalName(object);
	}

	public static String formatLocalName(Object object) {
		if (object == null)
			return "null-object";
		else if ((object instanceof EObject) && ((EObject)object).eIsProxy())
			return formatString(EcoreUtil.getURI((EObject)object));
		else if (object instanceof ENamedElement)
			return formatString(((ENamedElement)object).getName());
		else if (object instanceof Resource)
			return "Resource(" + formatLocalName(((Resource)object).getURI()) + ")";
		else if (object instanceof URI)
			return "'" + formatString(((URI)object).toString()) + "'";
		else if (object instanceof EAnnotation)
			return "EAnnotation.'" + formatString(((EAnnotation)object).getSource()) + "'";
		else if (object instanceof Boolean)
			return "Boolean." + object.toString();
		else if (object instanceof Integer)
			return "Integer." + object.toString();
		else if (object instanceof String)
			return "String.'" + object + "'";
		else if (object instanceof Map.Entry<?,?>)
			return "Map.Entry[" + formatString(((Map.Entry<?,?>)object).getKey()) + "]";
		else if (object instanceof Collection<?>)
			return formatLocalClassName(object) + "[" + ((Collection<?>)object).size() + "]";
		else
			return "unnamed-" + formatLocalClassName(object);
	}

	public static String formatLocalClassName(Object object) {
		String name = object.getClass().getSimpleName();
		if ("".equals(name)) {
			name = object.getClass().getName();
			int i = name.lastIndexOf(".");
			if (i >= 0)
				name = name.substring(i+1);
		}
		return name;
	}

	public static void formatObject(StringBuffer s, Object object) {
		if (object instanceof Collection<?>) {
			String prefix = "";
			for (Object obj : (Collection<?>)object) {
				s.append(prefix);
				formatObject(s, obj);
				prefix = ",";
			}
		}
		else if (object instanceof EObject)
			s.append(formatClassAndFeatureName((EObject) object));
		else {
			s.append("'");
			s.append(formatString(object));
			s.append("'");
		}
	}

	public static String formatString(Object object) {
		if (object != null)
			return object.toString();
		else
			return "null-string";
	}
	
	/**
	 * Return true if eTypedElement uses a generic type.
	 */
	public static boolean isGeneric(ETypedElement eTypedElement) {
		return eTypedElement != null ? isGeneric(eTypedElement.getEGenericType()) : false;
	}
	
	/**
	 * Return true if eGenericType is a generic type.
	 */
	public static boolean isGeneric(EGenericType eGenericType) {
		if (eGenericType != null) {
//			EClassifier eClassifier = eGenericType.getEClassifier();
			EClassifier eClassifier = ((EGenericTypeImpl) eGenericType).basicGetEClassifier();
			if (eClassifier != null) {	// FIXME WIP Follow proxy
				List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
				if ((eTypeParameters != null) && (eTypeParameters.size() > 0))
					return true;
			}
		}
		return false;
	}

	/**
	 * Redirect the target of all references from within resource that could be resolved
	 * within resource to be resolved within resource.
	 * 
	 * This is typically required to remove references to an independent meta-model for
	 * which resource is intended to be a self standing replacement. For instance if
	 * resource is a new copy of Ecore, internal references to the old copy of Ecore
	 * that assisted in its creation need replacing by references the the new Ecore.
	 */
	public static void promoteReferencesToSelfToSelf(Resource resource) {
		Map<String, EPackage> uriToPackageMap = createPackageMap(resource);
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			EClass eClass = eObject.eClass();
			for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
				if ((eFeature instanceof EReference) && ((EReference)eFeature).isContainment())
					continue;
				if (eFeature == EcorePackage.eINSTANCE.getEGenericType_EClassifier())
					continue;
				EGenericType referencedGenericType = eFeature.getEGenericType();
				EClassifier referencedClassifier = referencedGenericType != null ? referencedGenericType.getEClassifier() : eFeature.getEType();
				EPackage referencedPackage = referencedClassifier.getEPackage();
				EPackage normalisedPackage = uriToPackageMap.get(referencedPackage.getNsURI());
				if ((normalisedPackage != null) && (normalisedPackage != referencedPackage)) {
					EClassifier normalisedClassifier = normalisedPackage.getEClassifier(referencedClassifier.getName());
					if (normalisedClassifier != null) {
						if (referencedGenericType != null)
							referencedGenericType.setEClassifier(normalisedClassifier);
						else
							eFeature.setEType(normalisedClassifier);
					}
				}
			}
		}
	}
}
