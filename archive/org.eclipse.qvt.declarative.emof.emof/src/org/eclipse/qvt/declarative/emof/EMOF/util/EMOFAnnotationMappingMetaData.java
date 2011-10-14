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

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * EMOFAnnotationMappingMetaData supports the mapping of EMOF constructs to Ecore EAnnotations.
 * <br>
 * This class is separated from EMOFMappingMetaData to ease comprehension rather than subclassing.
 * It is not intended that this class be subclassed without a minor redesign.
 */
public class EMOFAnnotationMappingMetaData
{
//	public static final String ANNOTATION_COMMENT_SOURCE = EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE;
//	public static final String ANNOTATION_PROPERTY_SOURCE = EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE;
	public static final String EMOF_TAG_ANNOTATION_SOURCE = EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0 + "#Tag";
	public static final String DETAILS_BODY = "body";		// FIXME Non-body details are not diagnosed
	public static final String DETAILS_NAME = "name";
	public static final String DETAILS_VALUE = "value";
	
	protected final EMOFMappingMetaData mappingMetaData;
	protected final EAnnotationClassMap annotationClassMap;
	
	public EMOFAnnotationMappingMetaData(EMOFMappingMetaData mappingMetaData) {
		this.mappingMetaData = mappingMetaData;
	    annotationClassMap = new EAnnotationClassMap(mappingMetaData);
	}

	protected EObject createEAnnotationCommentAdapter(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		EAnnotationAdapter adapter = (EAnnotationAdapter) mappingMetaDataRegistry.getAdapter(eAnnotation);
		Map<String, RedirectedAnnotationClassMap> classMaps = annotationClassMap.getClassMaps();
		adapter.postLoader = classMaps.get(EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE);
		return adapter;
	}

	protected EObject createEAnnotationTagAdapter(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		EAnnotationAdapter adapter = (EAnnotationAdapter) mappingMetaDataRegistry.getAdapter(eAnnotation);
		Map<String, RedirectedAnnotationClassMap> classMaps = annotationClassMap.getClassMaps();
		adapter.postLoader = classMaps.get(EMOF_TAG_ANNOTATION_SOURCE);
		return adapter;
	}

	public EMOFMappingMetaData getMappingMetaData() {
		return mappingMetaData;
	}

	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		// EAnnotation <=> Comment/Tag/xmi:Extension class maps
		Map<String, RedirectedAnnotationClassMap> classMaps = annotationClassMap.getClassMaps();
	    RedirectedAnnotationClassMap commentAnnotation = new EMOFCommentAnnotationClassMap(annotationClassMap);
	    RedirectedAnnotationClassMap tagAnnotation = new EMOFTagAnnotationClassMap(annotationClassMap);
		classMaps.put(EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE, commentAnnotation);
		classMaps.put(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE, commentAnnotation);
		classMaps.put(EMOF_TAG_ANNOTATION_SOURCE, tagAnnotation);
		annotationClassMap.install(mappingMetaDataRegistry);
		// EModelElement.eAnnotations <=> Element.ownedComment/xmi:Extension reference maps
		new EAnnotationsReferenceMap(mappingMetaDataRegistry, annotationClassMap).install();

		mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EANNOTATION__CONTENTS);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EANNOTATION__DETAILS);
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeOrElementMap(EcorePackage.Literals.EANNOTATION__REFERENCES);
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeMap(EcorePackage.Literals.EANNOTATION__SOURCE);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(null, EMOFPackage.Literals.COMMENT__ANNOTATED_ELEMENT); // FIXME
	    mappingMetaDataRegistry.installDetailToFeatureMap(DETAILS_BODY, EMOFPackage.Literals.COMMENT__BODY);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(null, EMOFPackage.Literals.TAG__ELEMENT);
	    mappingMetaDataRegistry.installDetailToFeatureMap(DETAILS_NAME, EMOFPackage.Literals.TAG__NAME);
	    mappingMetaDataRegistry.installDetailToFeatureMap(DETAILS_VALUE, EMOFPackage.Literals.TAG__VALUE);
	}
	
	//
	//	The original implementation that suppressed comments and tags
	/*
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) throws MappingConfigurationException {
	    mappingMetaDataRegistry.installClassToExtensionMap(new EClassMap.Extension(mappingMetaData, EcorePackage.Literals.EANNOTATION));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(mappingMetaData, null, EMOFPackage.Literals.COMMENT));

	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EANNOTATION__CONTENTS);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EANNOTATION__DETAILS);
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeOrElementMap(EcorePackage.Literals.EANNOTATION__REFERENCES);
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeMap(EcorePackage.Literals.EANNOTATION__SOURCE);
//**
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(null, EMOFPackage.Literals.ELEMENT__OWNED_COMMENT);
//	    mappingMetaDataRegistry.installFeatureToFeatureMap(null, EMOFPackage.Literals.ELEMENT__TAG);
	} */
}
