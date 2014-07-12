/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeAS2XMIidVisitor;

public class QVTimperativeAS2XMIidVisitor extends AbstractQVTimperativeAS2XMIidVisitor
{
	public static final @NonNull String MAPPING_PREFIX = "m."; //$NON-NLS-1$
	
	protected QVTimperativeAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitMapping(@NonNull Mapping object) {
		s.append(MAPPING_PREFIX);
		appendParent(object);
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitMappingCallBinding(@NonNull MappingCallBinding object) {
		return null;
	}
}
