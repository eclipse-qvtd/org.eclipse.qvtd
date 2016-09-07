/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;

public class QVTcoreBaseUtil extends QVTbaseUtil
{
	public static @Nullable Area getContainingArea(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Area) {
				return (Area) eObject;
			}
		}
		return null;
	}

	public static @NonNull Property getTargetProperty(@NonNull NavigationAssignment asNavigationAssignment) {
		if (asNavigationAssignment instanceof PropertyAssignment) {
			return ClassUtil.nonNullState(((PropertyAssignment)asNavigationAssignment).getTargetProperty());
		}
		else if (asNavigationAssignment instanceof OppositePropertyAssignment) {
			Property referredProperty = ClassUtil.nonNullState(((OppositePropertyAssignment)asNavigationAssignment).getTargetProperty());
			return ClassUtil.nonNullState(referredProperty.getOpposite());
		}
		throw new UnsupportedOperationException("Unsupported " + asNavigationAssignment.eClass().getName());
	}
}