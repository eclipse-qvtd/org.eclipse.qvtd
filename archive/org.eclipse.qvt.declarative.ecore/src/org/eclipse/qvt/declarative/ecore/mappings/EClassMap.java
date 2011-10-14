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
 * $Id: EClassMap.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingExtension;

/**
 * An EClassMap defines the mapping between an EClass of an adapting model and a corresponding
 * EClass of an Ecore model. It forms the intermediate node in the MappingMetaData, EClassMap,
 * EStructuralFeatureMap, AbstractFeatureElement hierarchy providing the meta data for the
 * adapting to/from ecore mapping.
 */
public abstract class EClassMap
{
	public static class Direct extends EClassMap
	{
		public Direct(MappingMetaData mappingMetaData, EClass ecoreEClass, EClass adaptingEClass) {
			super(mappingMetaData, ecoreEClass, adaptingEClass);
		}

		@Override public AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
			return new AdaptingEObject(mappingMetaDataRegistry, this, ecoreObject);
		}
	}
	
	public static class Extension extends EClassMap
	{
		public Extension(MappingMetaData mappingMetaData, EClass ecoreEClass) {
			super(mappingMetaData, ecoreEClass, XMLTypePackage.Literals.ANY_TYPE);
		}

		@Override public AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
			return new AdaptingExtension(mappingMetaDataRegistry, this, ecoreObject);
		}
	}
	
	protected final MappingMetaData mappingMetaData;
	protected final EClass ecoreEClass;
	protected final EClass adaptingEClass;
	protected Map<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>> adaptingFeatureMaps;
	protected Map<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>> ecoreFeatureMaps;
	
	protected EClassMap(MappingMetaData mappingMetaData, EClass ecoreEClass, EClass adaptingEClass) {
		this.mappingMetaData = mappingMetaData;
		this.ecoreEClass = ecoreEClass;
		this.adaptingEClass = adaptingEClass;
	}
	
	public void compile(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		adaptingFeatureMaps = new HashMap<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>>();
		ecoreFeatureMaps = new HashMap<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>>();
		EList<EStructuralFeature> ecoreFeatures = ecoreEClass.getEAllStructuralFeatures();
		for (EStructuralFeature ecoreFeature : ecoreFeatures) {
			EStructuralFeatureMap<? extends EStructuralFeature> featureMap = mappingMetaData.getEcoreFeatureMap(mappingMetaDataRegistry, ecoreEClass, ecoreFeature);
			if (featureMap != null) {
				ecoreFeatureMaps.put(ecoreFeature, featureMap);
				EStructuralFeature adaptingFeature = featureMap.getAdaptingFeature();
				if (adaptingFeature != null)
					adaptingFeatureMaps.put(adaptingFeature, featureMap);
			}
		}
		if (adaptingEClass != null) {
			EList<EStructuralFeature> adaptingFeatures = adaptingEClass.getEAllStructuralFeatures();
			for (EStructuralFeature adaptingFeature : adaptingFeatures) {
				EStructuralFeatureMap<? extends EStructuralFeature> featureMap = mappingMetaData.getAdaptingFeatureMap(mappingMetaDataRegistry, adaptingEClass, adaptingFeature);
				if ((featureMap != null) && !adaptingFeatureMaps.containsKey(adaptingFeature)) {
					adaptingFeatureMaps.put(adaptingFeature, featureMap);
					EStructuralFeature ecoreFeature = featureMap.getEcoreStructuralFeature();
					if (ecoreFeature != null)
						ecoreFeatureMaps.put(ecoreFeature, featureMap);
				}
			}
		}
	}

	public abstract AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject);
	
	public EClass getAdaptingEClass() {
		return adaptingEClass;
	}
	
	public EClass getAdaptingEClass(EObject ecoreObject) {
		return adaptingEClass;
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingFeatureMap(EStructuralFeature adaptingFeature) {
		return adaptingFeatureMaps.get(adaptingFeature);		
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingFeatureMap(EObject ecoreObject, EStructuralFeature adaptingFeature) {
		return adaptingFeatureMaps.get(adaptingFeature);		
	}

	public Collection<EStructuralFeatureMap<? extends EStructuralFeature>> getAdaptingFeatureMaps() {
		return adaptingFeatureMaps.values();
	}

	public Collection<EStructuralFeatureMap<? extends EStructuralFeature>> getAdaptingFeatureMaps(EObject ecoreObject) {
		return adaptingFeatureMaps.values();
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getEcoreFeatureMap(EStructuralFeature ecoreFeature) {
		return ecoreFeatureMaps.get(ecoreFeature);		
	}

	public Collection<EStructuralFeatureMap<? extends EStructuralFeature>> getEcoreFeatureMaps() {
		return ecoreFeatureMaps.values();
	}

	public EClass getEcoreEClass() {
		return ecoreEClass;
	}

	@SuppressWarnings("unchecked")
	protected <E extends EClass> Class<? extends E> getInstanceClass(EClass ecoreEClass) {
		return (Class<? extends E>)ecoreEClass.getInstanceClass();
	}

	public MappingMetaData getMappingMetaData() {
		return mappingMetaData;
	}

	public void postLoad(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		AdaptingEObject adaptingObject = (AdaptingEObject) mappingMetaDataRegistry.getAdapter(ecoreObject);
		if (adaptingObject != null)
			adaptingObject.postLoad();
	}

	public void postSave(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		AdaptingEObject adaptingObject = (AdaptingEObject) mappingMetaDataRegistry.getAdapter(ecoreObject);
		if (adaptingObject != null)
			adaptingObject.postSave();
	}

	public void preLoad(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		AdaptingEObject adaptingObject = (AdaptingEObject) mappingMetaDataRegistry.getAdapter(ecoreObject);
		if (adaptingObject != null)
			adaptingObject.preLoad();
	}

	public void preSave(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
		AdaptingEObject adaptingObject = (AdaptingEObject) mappingMetaDataRegistry.getAdapter(ecoreObject);
		if (adaptingObject != null)
			adaptingObject.preSave();
	}
	
	@Override public String toString() {
		return MappingUtils.formatFullName(ecoreEClass) + " <==> " + MappingUtils.formatFullName(adaptingEClass);
	}

	/**
	 * Return null if this class map has an accurate set of feature map declarations.
	 * Return first non-null feature and if non-null explanations to writer as well if not valid.
	 */
	public EStructuralFeature validate(MappingMetaDataRegistry mappingMetaDataRegistry, PrintWriter writer) {
		if ((ecoreEClass == null) || (adaptingEClass == null))
				return null;
		EStructuralFeature badFeature = null;
		EList<EStructuralFeature> ecoreFeatures = ecoreEClass.getEAllStructuralFeatures();
//		EList<EStructuralFeature> debugAdaptingFeatures = adaptingEClass.getEAllStructuralFeatures();
		for (EStructuralFeature ecoreFeature : ecoreFeatures) {
			EStructuralFeatureMap<? extends EStructuralFeature> structuralFeatureMap = mappingMetaDataRegistry.getEcoreEStructuralFeatureMap(ecoreFeature);
			if ((ecoreFeature instanceof EReference) && (((EReference)ecoreFeature).isContainer())) {
				if (structuralFeatureMap != null) {
					if (writer != null)
						writer.println("Redundant container feature: " + MappingUtils.formatFullName(ecoreEClass) + " " + MappingUtils.formatFeatureName(ecoreFeature));
					badFeature = ecoreFeature;
				}
			}
			else if (ecoreFeature.isDerived()) {
				if (structuralFeatureMap != null) {
					if (writer != null)
						writer.println("Redundant derived feature: " + MappingUtils.formatFullName(ecoreEClass) + " " + MappingUtils.formatFeatureName(ecoreFeature));
					badFeature = ecoreFeature;
				}					
			}
			else if (ecoreFeature.isTransient()) {
				if (structuralFeatureMap != null) {
					if (writer != null)
						writer.println("Redundant transient feature: " + MappingUtils.formatFullName(ecoreEClass) + " " + MappingUtils.formatFeatureName(ecoreFeature));
					badFeature = ecoreFeature;
				}					
			}
			else {
				if (structuralFeatureMap == null) {
					if (writer != null)
						writer.println("Missing feature: " + MappingUtils.formatFullName(ecoreEClass) + " " + MappingUtils.formatFeatureName(ecoreFeature));
					badFeature = ecoreFeature;
				}					
			}
		}
		return badFeature;
	}
}