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
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * An EMOFTagAnnotationClassMap defines the behaviour of the EAnnotationAdapter
 * adapting the EAnnotation created when an EMOF Tag is loaded. It ensures
 * that the EAnnotation is marked as a Tag once loading completes.
 */
public class EMOFTagAnnotationClassMap extends RedirectedAnnotationClassMap
{
	public EMOFTagAnnotationClassMap(EAnnotationClassMap annotationClassMap) {
		super(annotationClassMap, EMOFPackage.Literals.TAG);
	}

	@Override
	public void postLoad(EAnnotationAdapter tagAdapter) {
		EAnnotation annotation = tagAdapter.getTarget();
		if (annotation.getSource() == null)
			annotation.setSource(EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE);		
	}		
}