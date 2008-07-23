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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;

/**
 * EMOFEcoreUtils provides helper functions to create, configure and interrogate
 * Ecore EAnnotations that represent EMOF elements with no more explicit counterpart.
 */
public class EMOFEcoreUtils
{
	public void configureAsComment(EAnnotation annotation, String body) {
		annotation.setSource(EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE);
		annotation.getDetails().clear();
		annotation.getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_BODY, body);
	}
	
	public void configureAsPropertyOppositeRoleName(EAnnotation annotation, String name) {
		annotation.setSource(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
		annotation.getDetails().clear();
		annotation.getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_BODY, name);
	}
	
	public void configureAsTag(EAnnotation annotation, String name, String value) {
		annotation.setSource(EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE);
		annotation.getDetails().clear();
		annotation.getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_NAME, name);
		annotation.getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_VALUE, value);
	}
	
	public EAnnotation createComment(String body) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		configureAsComment(annotation, body);
		return annotation;
	}
	
	public EAnnotation createPropertyOppositeRoleName(String name) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		configureAsPropertyOppositeRoleName(annotation, name);
		return annotation;
	}
	
	public EAnnotation createTag(String name, String value) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		configureAsTag(annotation, name, value);
		return annotation;
	}
	
	public String getCommentBody(EAnnotation annotation) {
		return annotation.getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_BODY);
	}
	
	public String getPropertyOppositeRoleName(EAnnotation annotation) {
		return annotation.getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_BODY);
	}
	
	public String getTagName(EAnnotation annotation) {
		return annotation.getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_NAME);
	}
	
	public String getTagValue(EAnnotation annotation) {
		return annotation.getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_VALUE);
	}
	
	public boolean isComment(EAnnotation annotation) {
		return EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE.equals(annotation.getSource());
	}
	
	public boolean isPropertyOppositeRoleName(EAnnotation annotation) {
		return EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE.equals(annotation.getSource());
	}
	
	public boolean isTag(EAnnotation annotation) {
		return EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE.equals(annotation.getSource());
	}
}