/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;

public class RWhenPatternToMGuardPattern extends AbstractRule
{
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();

	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();

	public RWhenPatternToMGuardPattern(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}

	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
}
