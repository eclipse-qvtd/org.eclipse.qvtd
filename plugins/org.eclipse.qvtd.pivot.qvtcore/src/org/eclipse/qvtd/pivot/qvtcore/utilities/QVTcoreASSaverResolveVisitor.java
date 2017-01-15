/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractQVTcoreASSaverResolveVisitor;

public class QVTcoreASSaverResolveVisitor extends AbstractQVTcoreASSaverResolveVisitor
{
	public QVTcoreASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment object) {
		Property referredProperty = QVTcoreUtil.getTargetProperty(object);
		Property resolvedProperty = context.resolveProperty(referredProperty);
		if (resolvedProperty != referredProperty) {
			object.setTargetProperty(resolvedProperty);
		}
		return super.visitOppositePropertyAssignment(object);
	}

	@Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment object) {
		Property referredProperty = QVTcoreUtil.getTargetProperty(object);
		Property resolvedProperty = context.resolveProperty(referredProperty);
		if (resolvedProperty != referredProperty) {
			object.setTargetProperty(resolvedProperty);
		}
		return super.visitPropertyAssignment(object);
	}
}
