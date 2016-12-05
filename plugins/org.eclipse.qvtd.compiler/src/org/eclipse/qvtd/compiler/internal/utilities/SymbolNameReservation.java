/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A SymbolNameReservation ensures unique CG-friendly symbol names.
 */
public class SymbolNameReservation
{
	private @NonNull Map<@NonNull String, @NonNull Object> symbolName2symbolable = new HashMap<>();

	public @NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Object newObject) {
		String symbolName = symbolNameBuilder.toString();
		Object oldObject = symbolName2symbolable.get(symbolName);
		if (oldObject == newObject) {
			return symbolName;
		}
		if (oldObject == null) {
			symbolName2symbolable.put(symbolName, newObject);
			return symbolName;
		}
		for (int i = 1; true; i++) {
			String newSymbolName = symbolName + "_" + i;
			oldObject = symbolName2symbolable.get(newSymbolName);
			if (oldObject == null) {
				symbolName2symbolable.put(newSymbolName, newObject);
				return newSymbolName;
			}
		}
	}
}