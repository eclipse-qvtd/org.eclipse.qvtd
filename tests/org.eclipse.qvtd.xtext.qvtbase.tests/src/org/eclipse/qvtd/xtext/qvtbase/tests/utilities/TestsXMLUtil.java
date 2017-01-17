/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.TreeIterable;


public class TestsXMLUtil {

	public final static @NonNull Map<Object, Object> defaultSavingOptions;

	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<Object, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		defaultSavingOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
	}

	public static void resetTransients(@NonNull Resource asResource) {
		for (@NonNull EObject eObject : new TreeIterable(asResource)) {
			if (eObject instanceof org.eclipse.ocl.pivot.Class) {
				((org.eclipse.ocl.pivot.Class)eObject).setUnspecializedElement(null);		// Suppress transient value
			}
			else if (eObject instanceof VariableDeclaration) {
				((VariableDeclaration)eObject).setTypeValue(null);		// Suppress transient value
			}
			else if (eObject instanceof OCLExpression) {
				((OCLExpression)eObject).setTypeValue(null);		// Suppress transient value
			}
		}
	}
}
