/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractQVTscheduleASSaverLocateVisitor;

public class QVTscheduleASSaverLocateVisitor extends AbstractQVTscheduleASSaverLocateVisitor
{
	public QVTscheduleASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitClassDatum(@NonNull ClassDatum object) {
		org.eclipse.ocl.pivot.Class referredClass = object.getReferredClass();
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return super.visitClassDatum(object);
	}
}
