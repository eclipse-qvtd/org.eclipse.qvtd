/**
 * <copyright>
 * 
 * Copyright (c) 2008,2009 E.D.Willink and others.
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
 * $Id: EcoreUtils.java,v 1.9 2009/12/26 14:27:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EcoreUtils
{	
	public static <E extends EObject> E copy(E newObject) {
		return (E) EcoreUtil.copy(newObject);
	}

	/**
	 * Convert the map return from EcoreUtil.UnresolvedProxyCrossReferencer.find(xx)
	 * into a textual diagnosis.
	 * <br>
	 * Returns null if there are no unresolved URIs.
	 * <br>
	 * Returns a String containing a title line containing the contextURI and
	 * subsequent lines identifying each distinct unresolved URI. 
	 */
	public static String diagnoseUnresolvedProxies(URI contextURI, Map<EObject, Collection<EStructuralFeature.Setting>> map) {
	    if (map.isEmpty())
	    	return null;	    
    	Map<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURIs = new HashMap<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>(map.size());
    	for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map.entrySet()) {
    		EObject key = entry.getKey();
    		URI uri = EcoreUtil.getURI(key);
			if (uri != null) {
				String uriString = uri.toString();
				if (!unresolvedURIs.containsKey(uriString))
					unresolvedURIs.put(uriString, entry);
			}
    	}
    	StringBuffer s = new StringBuffer();
		s.append("Unresolved URIs in '" + String.valueOf(contextURI) + "' :");
    	for (Map.Entry<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURI : unresolvedURIs.entrySet())
 			s.append("\n    '" + unresolvedURI.getKey() + "'");
    	return s.toString();
	}
	
	@Deprecated
	public static String formatFullName(Object object) {
		return formatQualifiedName(object, "::");
	}

	public static String formatMultiplicity(ETypedElement typedElement) {
		if (typedElement == null)
			return "";
		int lower = typedElement.getLowerBound();
		int upper = typedElement.getUpperBound();
		if (lower == upper)
			return Integer.toString(lower);
		else if (lower == 0) {
			if (upper < 0)
				return "*";
			else if (upper == 1)
				return "?";
		}
		else if (lower == 1) {
			if (upper < 0)
				return "+";
		}
		return Integer.toString(lower) + ".." + (upper >= 0 ? Integer.toString(upper) : "*");
	}

	public static String formatName(Object object) {
		if (object == null) {
            return formatString(null);
        } else if (object instanceof ENamedElement) {
            return formatString(((ENamedElement) object).getName());
        } else if (object instanceof EObject) {
            return formatString(((EObject) object).eClass().getName());
        } else {
            return object.getClass().getName();
        }
	}

	public static String formatOrdered(ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isOrdered() && typedElement.isMany()) : false;
		return isOrdered ? "{ordered}" : "";
	}
	
	public static String formatQualifiedName(Object object) {
		return formatQualifiedName(object, "::");
	}
	
	public static String formatQualifiedName(Object object, String separator) {
		if (object instanceof EObject) {
			Object container = ((EObject)object).eContainer();
			if (container != null)
				return formatQualifiedName(container) + separator + formatName(object);
		}
		return formatName(object);
	}

	public static String formatString(String name) {
		return name != null ? name : "<null>";
	}

	public static String formatUnique(ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isUnique() && typedElement.isMany()) : false;
		return isOrdered ? "{unique}" : "";
	}
	
	public static <T extends Adapter> T getAdapter(Notifier notifier, Class<T> adapterClass) {
		if (notifier == null)
			return null;
		return getAdapter(notifier.eAdapters(), adapterClass);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Adapter> T getAdapter(List<Adapter> eAdapters, Class<T> adapterClass) {
		return (T) EcoreUtil.getAdapter(eAdapters, adapterClass);
	}

	/**
	 * Return the specialised value of feature.getEType() resolving any type parameters
	 * from the specialised type of the sourceObject of the feature.
	 * 
	 * @param sourceObject
	 * @param feature
	 * @return
	 */
	public static EClassifier getEType(EObject sourceObject, EStructuralFeature feature) {
		EGenericType targetGenericType = feature.getEGenericType();
		ETypeParameter targetTypeParameter = targetGenericType.getETypeParameter();
		if ((targetTypeParameter != null) && (sourceObject != null)) {
			EClass sourceGenericType = feature.getEContainingClass();
			EObject typeParameterContainer = targetTypeParameter.eContainer();
			EClass sourceClass = sourceObject.eClass();
			EList<EGenericType> allSourceGenericSuperTypes = sourceClass.getEAllGenericSuperTypes();
			for (EGenericType sourceGenericSuperType : allSourceGenericSuperTypes) {
				if (sourceGenericSuperType.getERawType() == typeParameterContainer) {
					EList<EGenericType> sourceTypeArguments = sourceGenericSuperType.getETypeArguments();
					int i = sourceGenericType.getETypeParameters().indexOf(targetTypeParameter);
					if ((0 <= i) && (i < sourceTypeArguments.size())) {
						EGenericType sourceTypeArgument = sourceTypeArguments.get(i);
						return sourceTypeArgument.getERawType();
					}
				}
			}
		}
		return targetGenericType.getERawType();
	}

	public static <T> int getFeatureID(Notification notification, T expectedNotifier, Class<T> featureClass) {
		if (expectedNotifier == null)
			return Notification.NO_FEATURE_ID;
		Object notifier = notification.getNotifier();
		if (notifier != expectedNotifier)
			return Notification.NO_FEATURE_ID;
		T castNotifier = ClassUtils.asClassOrNull(notifier, featureClass);
		if (castNotifier == null)
			throw new IllegalArgumentException("EcoreUtils.getFeatureID: " + featureClass.getName() + " for a " + notifier.getClass().getName());
		return notification.getFeatureID(featureClass);
	}

	public static <T extends ENamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		if (name == null)
			return null;
		for (T element : elements)
			if (name.equals(element.getName()))
				return element;
		return null;				
	}

	@SuppressWarnings("unchecked")
	public static <T extends ENamedElement, R extends T> R getNamedElement(Collection<T> elements, String name, Class<R> returnClass) {
		if (elements == null)
			return null;
		if (name == null)
			return null;
		if (returnClass == null)
			return null;
		for (T element : elements)
			if (returnClass.isAssignableFrom(element.getClass()) && name.equals(element.getName()))
				return (R) element;
		return null;				
	}
}
