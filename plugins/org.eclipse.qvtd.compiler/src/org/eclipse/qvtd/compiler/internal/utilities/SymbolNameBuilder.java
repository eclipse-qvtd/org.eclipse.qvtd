/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.utilities;

import org.eclipse.jdt.annotation.NonNull;

/**
 * SymbolNameBuilder supports building a symbol name including replacement of awkward characters.
 */
public class SymbolNameBuilder
{
	private final @NonNull StringBuilder s = new StringBuilder();

	public SymbolNameBuilder() {}

	public void appendName(/*@NonNull*/ String name) {
		assert name != null;
		s.append(name.replace("_",  "__"));
	}

	public void appendString(@NonNull String string) {
		s.append(string);
	}
	
	@Override
	public @NonNull String toString() {
		String string = s.toString();
		if (s.length() > 50) {
			string = string.substring(0, 50);
		}
		return string;
	}
}