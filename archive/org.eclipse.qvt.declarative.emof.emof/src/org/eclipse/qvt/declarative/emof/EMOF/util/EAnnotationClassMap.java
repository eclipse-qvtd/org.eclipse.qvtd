/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.EStructuralFeatureMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry.Install;

/**
 * EAnnotationClassMap defines the unresolved mapping of an EAnnotation to something.
 * <br>
 * The appropriate resolved mapping is selected when createAdapter is invoked for the Ecore object.
 */
public class EAnnotationClassMap extends EClassMap.Extension
{				
	protected final Map<String, RedirectedAnnotationClassMap> classMaps = new HashMap<String, RedirectedAnnotationClassMap>();

	protected EAnnotationClassMap(MappingMetaData mappingMetaData) {
		super(mappingMetaData, EcorePackage.Literals.EANNOTATION);
	}

	@Override
	public void compile(MappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		for (EClassMap classMap : classMaps.values())
			classMap.compile(mappingMetaDataRegistry);
		super.compile(mappingMetaDataRegistry);
	}

	@Override
	public AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		return new EAnnotationAdapter(mappingMetaDataRegistry, this, (EAnnotation) ecoreObject);
	}

	@Override
	public EClass getAdaptingEClass(EObject ecoreObject) {
		if (ecoreObject == null)
			return super.getAdaptingEClass();
		EClassMap classMap = getClassMap((EAnnotation) ecoreObject);
		return classMap.getAdaptingEClass();
	}

	@Override
	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingFeatureMap(EObject ecoreObject, EStructuralFeature adaptingFeature) {
		if (ecoreObject == null)
			return super.getAdaptingFeatureMap(adaptingFeature);
		EClassMap classMap = getClassMap((EAnnotation) ecoreObject);
		return classMap.getAdaptingFeatureMap(adaptingFeature);
	}

	@Override
	public Collection<EStructuralFeatureMap<? extends EStructuralFeature>> getAdaptingFeatureMaps(EObject ecoreObject) {
		if (ecoreObject == null)
			return getAdaptingFeatureMaps();
		EClassMap classMap = getClassMap((EAnnotation) ecoreObject);
		return classMap.getAdaptingFeatureMaps();
	}

	protected EClassMap getClassMap(EAnnotation eAnnotation) {
		String source = eAnnotation.getSource();
		EClassMap classMap = classMaps.get(source);
		if (classMap == null)
			classMap = this;
		return classMap;
	}

	public Map<String, RedirectedAnnotationClassMap> getClassMaps() {
		return classMaps;
	}

	public void install(Install mappingMetaDataRegistry) {
		mappingMetaDataRegistry.putEcoreEClassMap(EcorePackage.Literals.EANNOTATION, this);
		for (EClassMap classMap : classMaps.values())
			mappingMetaDataRegistry.putAdaptingEClassMap(classMap.getAdaptingEClass(), this);
	}

	public boolean isXmiExtension(EAnnotation eAnnotation) {
		String source = eAnnotation.getSource();
		return classMaps.get(source) == null;
	}
}
