/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.TreeIterable;

public class TestsXMLUtil
{
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
