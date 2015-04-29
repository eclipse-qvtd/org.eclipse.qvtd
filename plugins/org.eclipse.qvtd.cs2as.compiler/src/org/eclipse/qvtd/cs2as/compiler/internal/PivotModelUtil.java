/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.util.Map;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.compiler.internal.etl.QvtMtcExecutionException;

public class PivotModelUtil {

	private @NonNull EnvironmentFactory environmentFactory;
	
	public PivotModelUtil(@NonNull EnvironmentFactory environmentFactory) {
		
		this.environmentFactory = environmentFactory;
	}
	
	/**
	 * Creates a Pivot Model with the given attributes. The models are not expanded
	 * by default.
	 *
	 * @param modeUri the mode uri
	 * @param modelName the model name
	 * @param modelAliases the model aliases (Comma separated string)
	 * @param metamodelUris the metamodel URIs
	 * @param readOnLoad read on load flag
	 * @param storeOnDispoal store on disposal flag 
	 * @param cached cached flag
	 * @param the model is a pivot resource (i.e. .oclas)
	 * @return the pivot model
	 * @throws QvtMtcExecutionException There was an error loading the model
	 */
	// Copied from MTC broker
	public PivotModel createPivotModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
			boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean resolveExternalRefs, boolean isPivotResource, Map<?, ?> savingOptions) throws QvtMtcExecutionException {

		PivotModel model = new PivotModel(environmentFactory, isPivotResource, savingOptions);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(resolveExternalRefs));
		try {
			model.load(properties, "");
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		return model;
	}
}
