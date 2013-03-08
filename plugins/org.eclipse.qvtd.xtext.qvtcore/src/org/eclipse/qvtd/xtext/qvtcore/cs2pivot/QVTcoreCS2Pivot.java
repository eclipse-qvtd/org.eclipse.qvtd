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
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2pivot.QVTcoreBaseCS2Pivot;

public class QVTcoreCS2Pivot extends QVTcoreBaseCS2Pivot
{	
	public QVTcoreCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTcoreContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTcorePostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcorePostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTcorePreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcorePreOrderVisitor(converter);
	}
}
