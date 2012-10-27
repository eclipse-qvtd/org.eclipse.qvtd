/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;

public class QVTrelationCS2Pivot extends EssentialOCLCS2Pivot
{	
	public QVTrelationCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTrelationContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationPreOrderVisitor(converter);
	}
}
