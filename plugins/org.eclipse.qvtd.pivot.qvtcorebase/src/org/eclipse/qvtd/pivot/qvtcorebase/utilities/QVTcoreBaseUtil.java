/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

public class QVTcoreBaseUtil extends QVTbaseUtil
{
	public static @NonNull Area getArea(@NonNull AbstractMapping mapping, @NonNull TypedModel typedModel) {
		for (Domain domain : mapping.getDomain()) {
			if (domain.getTypedModel() == typedModel) {
				return (CoreDomain)domain;
			}
		}
		return mapping;
	}

	public static @Nullable Area getContainingArea(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Area) {
				return (Area) eObject;
			}
		}
		return null;
	}

	public static @Nullable TypedModel getTypedModel(@Nullable Area area) {
        if (area instanceof CoreDomain) {
            return ((CoreDomain)area).getTypedModel();
        }
        else {
        	return null;
        }
	}
}