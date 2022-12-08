/*******************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;

/**
 * QVTiEquivalenceUtil provides the bodies for many of the isEquivalentToInternal operations.
 *
 * These return:
 * <br>
 * true if two values are definitely the same.
 * <br>
 * false if two values are definitely different.
 * <br>
 * null if the values could be the same or different.
 */
public class QVTiEquivalenceUtil
{
	public static @Nullable Boolean isEquivalent(@NonNull CGMappingExp thisValue, @NonNull CGMappingExp thatValue) {
		if (thisValue == thatValue) {
			return Boolean.TRUE;
		}
		return null;
	}

	public static @Nullable Boolean isEquivalent(@NonNull CGRealizedVariablePart thisValue, @NonNull CGRealizedVariablePart thatValue) {
		if (thisValue == thatValue) {
			return Boolean.TRUE;
		}
		return null;
	}
}
