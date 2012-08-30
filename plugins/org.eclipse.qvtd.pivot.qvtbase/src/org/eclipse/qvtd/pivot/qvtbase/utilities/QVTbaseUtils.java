/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotSaver.java,v 1.8 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseUtils
{
	public static Set<org.eclipse.ocl.examples.pivot.Package> getAllUsedPackages(Transformation transformation) {
		Set<org.eclipse.ocl.examples.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		for (TypedModel typedModel : transformation.getModelParameter()) {
			allPackages.addAll(typedModel.getUsedPackage());
		}
		return allPackages;
	}

	public static BaseModel getModel(EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof BaseModel) {
				return (BaseModel) eObject;
			}
		}
		return null;
	}
}