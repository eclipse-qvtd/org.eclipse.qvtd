/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;

/**
 * A QVTiXtextEvaluator supports loading a transformation as source then loading models, performing a transformation
 * and then saving the models.
 * 
 * @see QVTiPivotEvaluator
 */
public class QVTiXtextEvaluator extends QVTiPivotEvaluator
{
	public static ASResource asResource;
	
    public static @NonNull Transformation loadTransformation(@NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		
		// Load the transformation resource
        BaseCSResource xtextResource = null;
        xtextResource = (BaseCSResource) environmentFactory.getResourceSet().getResource(transformationURI, true);
        if (xtextResource == null) {
            throw new IOException("Failed to load '" + transformationURI + "'");
        }
		String csMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(xtextResource.getErrors()), "Failed to load '" + transformationURI + "'", "\n");
		if (csMessage != null) {
			throw new IOException(csMessage);
		}
		try {
			asResource = xtextResource.getASResource();
			String asMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(asResource.getErrors()), "Failed to load '" + asResource.getURI() + "'", "\n");
			if (asMessage != null) {
				throw new IOException(asMessage);
			}
			for (EObject eContent : asResource.getContents()) {
				if (eContent instanceof ImperativeModel) {
	    			for (org.eclipse.ocl.pivot.Package asPackage : ((ImperativeModel)eContent).getOwnedPackages()) {
    	    			for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
    	    				if (asClass instanceof Transformation) {
    	    	                return (Transformation)asClass;
    	    				}
    	    			}
	    			}
				}
			}
		} finally {
			if (!keepDebug) {
				xtextResource.dispose();
			}
		}
        throw new IOException("Failed to locate a transformation in '" + transformationURI + "'");
	}
    
    public QVTiXtextEvaluator(@NonNull QVTiEnvironmentFactory envFactory, @NonNull URI transformationURI) throws IOException {
    	super(envFactory, loadTransformation(envFactory, transformationURI, envFactory.keepDebug()));
    }
}
