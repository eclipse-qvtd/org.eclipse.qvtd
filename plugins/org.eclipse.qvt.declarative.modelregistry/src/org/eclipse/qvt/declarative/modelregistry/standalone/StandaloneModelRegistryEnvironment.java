/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.modelregistry.standalone;

import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.qvt.declarative.modelregistry.environment.AccessorKindRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelContentRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelSerializationRegistry;
import org.eclipse.qvt.declarative.modelregistry.model.ModelNameAccessor;
import org.eclipse.qvt.declarative.modelregistry.model.URIAccessor;
import org.eclipse.qvt.declarative.modelregistry.resource.EcoreFamilyResourceFactoryImpl;

public class StandaloneModelRegistryEnvironment extends ModelRegistryEnvironment
{
	/**
	 * Initialize the AccessorKindRegistry with the ModelName and URI accessors.
	 */
	@Override protected void initializeAccessorKindRegistry(AccessorKindRegistry accessorKindRegistry) {
		accessorKindRegistry.addAccessor(new ModelNameAccessor());
		accessorKindRegistry.addAccessor(new URIAccessor());
	}

	/**
	 * Initialize the ModelContentRegistry with the Ecore URI and support.
	 */
	@Override protected void initializeModelContentRegistry(ModelContentRegistry modelContentRegistry) {
		modelContentRegistry.addResourceFactory("http://www.eclipse.org/emf/2002/Ecore",
				new EcoreResourceFactoryImpl());
		modelContentRegistry.addResourceFactory("http://schema.omg.org/spec/mof/2.0/emof.xmi",
				new EMOFResourceFactoryImpl());
	}

	/**
	 * Initialize the ModelSerializationRegistry with the XML support.
	 */
	@Override protected void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry) {
		modelSerializationRegistry.addSerializationFactory("XML", new EcoreFamilyResourceFactoryImpl());
	}		

	@Override public void logTheError(String string, Throwable e) {
		System.err.println(PLUGIN_ID + ":ERROR " + string);
		e.printStackTrace(System.err);
	}
}