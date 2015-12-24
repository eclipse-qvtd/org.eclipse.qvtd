/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCS2AS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;

public class QVTimperativeCS2AS extends QVTcoreBaseCS2AS
{	
    public static boolean isMiddle(org.eclipse.ocl.pivot.@Nullable Class areaType, @NonNull ElementCS csElement) {
    	if (areaType != null) {
    		org.eclipse.ocl.pivot.Package areaPackage = areaType.getOwningPackage();
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

    public QVTimperativeCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		super(environmentFactory, csResource, asResource);
	}

	@Override
	protected @NonNull QVTimperativeCSContainmentVisitor createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new QVTimperativeCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new QVTimperativeCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTimperativeCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTimperativeCSPreOrderVisitor(converter);
	}
}
