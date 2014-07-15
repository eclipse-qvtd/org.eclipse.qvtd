/*******************************************************************************
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCS2Pivot;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;

public class QVTimperativeCS2Pivot extends QVTcoreBaseCS2Pivot
{	
    public static boolean isMiddle(@Nullable Type areaType, @NonNull ElementCS csElement) {
    	if (areaType != null) {
    		org.eclipse.ocl.examples.pivot.Package areaPackage = areaType.getPackage();
    		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer()) {
    			if (eObject instanceof MappingCS) {
    	    		Element mapping = ((MappingCS)eObject).getPivot();
					Transformation transformation = QVTimperativeUtil.getContainingTransformation(mapping);
    	    		if (transformation != null) {
    	    			TypedModel middleModel = transformation.getModelParameter(null);
    	    			if ((middleModel == null) || middleModel.getUsedPackage().contains(areaPackage)) {
    	    				return true;
    	    			}
    	    		}
    			}
    		}
    	}
		return false;
	}

    public QVTimperativeCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTimperativeCSContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeCSPreOrderVisitor(converter);
	}
}
