/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.PivotLUSSIDs;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseLUSSIDs extends PivotLUSSIDs
{
	public QVTbaseLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		super(asResource, options);
	}

	@Override
	protected boolean isExternallyReferenceable(@NonNull EObject eObject) {
		if (eObject instanceof Rule) {
			return true;
		}
		if (eObject instanceof TypedModel) {
			return true;
		}
		return super.isExternallyReferenceable(eObject);
	}
}