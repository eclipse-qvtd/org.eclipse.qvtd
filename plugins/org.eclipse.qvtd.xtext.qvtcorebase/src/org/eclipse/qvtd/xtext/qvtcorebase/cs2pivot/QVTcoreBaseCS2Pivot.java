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
package org.eclipse.qvtd.xtext.qvtcorebase.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;

public class QVTcoreBaseCS2Pivot extends EssentialOCLCS2Pivot
{	
	public QVTcoreBaseCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTcoreBaseContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreBaseContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBaseLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreBaseLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBasePostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreBasePostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBasePreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreBasePreOrderVisitor(converter);
	}
}
