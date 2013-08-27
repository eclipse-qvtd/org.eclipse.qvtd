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
 * $Id: QVTcoreCS2Pivot.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCS2Pivot;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS;

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
    	    			if (middleModel.getUsedPackage().contains(areaPackage)) {
    	    				return true;
    	    			}
    	    		}
    			}
    		}
    	}
		return false;
	}

    public QVTimperativeCS2Pivot(@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTimperativeContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativeLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativeLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativePostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativePostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTimperativePreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTimperativePreOrderVisitor(converter);
	}
}
