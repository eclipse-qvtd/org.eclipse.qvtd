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

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.qvt.declarative.ecore.mappings.EReferenceMap;
import org.eclipse.qvt.declarative.ecore.mappings.EcoreFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.ExtensionFeatureElement.ExtensionReferenceElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry.Install;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * EAnnotationsReferenceMap provides the irregular mapping of an EModelElement.eAnnotations reference
 * to an Element.ownedComment or an xmi:Extension. 
 */
public class EAnnotationsReferenceMap extends EReferenceMap
{
	/**
	 * EAnnotationsReferenceElement describes the EModelElement.eAnnotations reference.
	 * <br>
	 * The eAnnotations content must be selectively mapped to implemented elements
	 * or xmi:Extension elements as appropriate.
	 */
	public static class EAnnotationsReferenceElement extends ExtensionReferenceElement
	{
		private EAnnotationsReferenceElement(Install mappingMetaDataRegistry) {
			super(mappingMetaDataRegistry.createDemandExtensionReferenceFeature(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, true),
					EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		}

		@Override
		public void set(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, Object values) {
			if (!(values instanceof List<?>) || (((List<?>)values).size() <= 0))
				super.set(mappingMetaDataRegistry, object, values);
			else { // Suppress setting of stateless non-xmi:Extension to avoid spurious xmi:Extension elements
				List<EAnnotationAdapter> xmiAnnotations = new BasicInternalEList<EAnnotationAdapter>(EAnnotationAdapter.class);
				for (Object value : (List<?>)values) {
					EAnnotationAdapter adapter = (EAnnotationAdapter) value;
					if (adapter.isXmiExtension())
						xmiAnnotations.add(adapter);
				}
				super.set(mappingMetaDataRegistry, object, xmiAnnotations); // FIXME avoid list creation for simple cases
			}
		}

		@Override
		protected void setExtensionElement(FeatureMap featureMap, EObject object, EStructuralFeature structuralFeature, Object value) {
			EAnnotationAdapter adapter = (EAnnotationAdapter)value;
			if (adapter.isXmiExtension())		// Only create the xmi:Extension for xmiExtension annotations
				super.setExtensionElement(featureMap, object, structuralFeature, value);
		}
	}

	protected final EAnnotationClassMap annotationClassMap;
	private final EcoreFeatureElement<EReference> adaptingCommentFeatureElement;

	public EAnnotationsReferenceMap(Install mappingMetaDataRegistry, EAnnotationClassMap annotationClassMap) {
		super(mappingMetaDataRegistry,
				EcoreFeatureElement.create(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS),
				new EAnnotationsReferenceElement(mappingMetaDataRegistry));
		this.annotationClassMap = annotationClassMap;
		adaptingCommentFeatureElement = EcoreFeatureElement.create(EMOFPackage.Literals.ELEMENT__OWNED_COMMENT);
	}

	@Override
	public void install() {
		installEcoreFeatureElement(ecoreFeatureElement);		// EModelElement.eAnnotations
		installAdaptingFeatureElement(adaptingFeatureElement);		// xmi:Extension
		installAdaptingFeatureElement(adaptingCommentFeatureElement);	// Element.ownedComment
	}

	// Only set if an annotation that is not an xmi:Extension
	@Override
	public boolean isSetEcore(EObject ecoreObject) {
		for (EAnnotation eAnnotation : ((EModelElement)ecoreObject).getEAnnotations()) {
			if (!annotationClassMap.isXmiExtension(eAnnotation))
				return true;
		}
		return false;
	}
}
