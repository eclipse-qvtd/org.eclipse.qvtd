/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.resource.AS2ID;
import org.eclipse.ocl.pivot.internal.resource.PivotLUSSIDs;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

public class QVTscheduleLUSSIDs extends PivotLUSSIDs
{
	protected static final int PROPERTY_MULTIPLIER = 103;
	protected static final int PROPERTY_SOURCE_MULTIPLIER = 107;
	protected static final int PROPERTY_TARGET_MULTIPLIER = 109;
	protected static final int TYPED_MODEL_MULTIPLIER = 101;
	protected static final int TYPE_MULTIPLIER = 103;

	public QVTscheduleLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		super(asResource, options);
	}

	@Override
	protected @Nullable Integer computeLocalLUSSID(@NonNull AS2ID as2id, @NonNull EObject element, boolean normalizeTemplateParameters) {
		Integer localLUSSID = super.computeLocalLUSSID(as2id, element, normalizeTemplateParameters);
		if (localLUSSID != null) {
			int localId = localLUSSID.intValue();
			if (element instanceof ClassDatum) {
				ClassDatum classDatum = (ClassDatum)element;
				TypedModel asTypedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				localId += TYPED_MODEL_MULTIPLIER * as2id.assignLUSSID(asTypedModel, false, true);
				Type asType = classDatum.getReferredClass();
				assert asType != null;
				localId += TYPE_MULTIPLIER * as2id.assignLUSSID(asType, false, true);
			}
			else if (element instanceof PropertyDatum) {
				PropertyDatum propertyDatum = (PropertyDatum)element;
				Property asProperty = propertyDatum.getReferredProperty();
				assert asProperty != null;
				localId += PROPERTY_MULTIPLIER * as2id.assignLUSSID(asProperty, false, true);
				ClassDatum sourceClassDatum = QVTscheduleUtil.getOwningClassDatum(propertyDatum);
				localId += PROPERTY_SOURCE_MULTIPLIER * as2id.assignLUSSID(sourceClassDatum, false, true);
				ClassDatum targetClassDatum = propertyDatum.getTargetClassDatum();
				if (targetClassDatum != null) {
					localId += PROPERTY_TARGET_MULTIPLIER * as2id.assignLUSSID(targetClassDatum, false, true);
				}
			}
			localLUSSID = localId;
		}
		return localLUSSID;
	}
}