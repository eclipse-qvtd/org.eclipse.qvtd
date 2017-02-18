/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractQVTscheduleASSaverNormalizeVisitor;

public class QVTscheduleASSaverNormalizeVisitor extends AbstractQVTscheduleASSaverNormalizeVisitor
{
	protected QVTscheduleASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}
}
