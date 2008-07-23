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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * An EMOFCommentAnnotationClassMap defines the behaviour of the EAnnotationAdapter
 * adapting the EAnnotation created when an EMOF Comment is loaded. It ensures
 * that the EAnnotation is marked as a Comment of Property.oppositeRoleName
 * once loading completes.
 */
public class EMOFCommentAnnotationClassMap extends RedirectedAnnotationClassMap
{
	public EMOFCommentAnnotationClassMap(EAnnotationClassMap annotationClassMap) {
		super(annotationClassMap, EMOFPackage.Literals.COMMENT);
	}

	// Nested ownedComments are loaded as nested EAnnotations, so postloading converts
	//  any nested EAnnotation bodies to parent sources.
	@Override
	public void postLoad(EAnnotationAdapter commentAdapter) {
		EAnnotation commentAnnotation = commentAdapter.getTarget();
		for (EAnnotation childAnnotation : commentAnnotation.getEAnnotations()) {
			if ((childAnnotation.getEAnnotations().size() <= 0)
			 && (childAnnotation.getReferences().size() <= 0)
			 && (childAnnotation.getDetails().size() == 1)
			 && childAnnotation.getDetails().containsKey(EMOFAnnotationMappingMetaData.DETAILS_BODY)) {
				String body = childAnnotation.getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_BODY);
				if (EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE.equals(body)) {
					EObject adapter = commentAdapter.getMappingMetaDataRegistry().getAdapter(childAnnotation);
					if (adapter instanceof EAnnotationAdapter) {
						EAnnotationAdapter childAdapter = (EAnnotationAdapter) adapter;
						commentAnnotation.setSource(body);
						commentAnnotation.getEAnnotations().remove(childAnnotation);
						childAdapter.setTarget(commentAnnotation);
						childAdapter.parentComment = commentAdapter;
						commentAdapter.childComment = childAdapter;
						break;
					}
				}
			}
		}	
		if (commentAnnotation.getSource() == null)
			commentAnnotation.setSource(EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE);		
	}		
}