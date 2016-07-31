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
import org.eclipse.jdt.annotation.Nullable;

/**
 * SymbolNameBuilder supports building a symbol name including replacement of awkward characters.
 */
public class SymbolNameBuilder
{
	private final @NonNull StringBuilder s = new StringBuilder();
	private @Nullable String suffix = null;

	public SymbolNameBuilder() {}

	public SymbolNameBuilder(@NonNull String s) {
		this.s.append(s);
	}

	public void appendName(/*@NonNull*/ String name) {
		assert name != null;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c == '_') {
				s.append("__");
			}
			else {
				int codePoint  = name.codePointAt(i);
				if ((i == 0) ? Character.isJavaIdentifierStart(codePoint) : Character.isJavaIdentifierPart(codePoint)) {
					s.append(c);
				}
				else {
					s.append("_");
					s.append(codePoint);
					s.append("_");
				}
			}
		}
	}

	public void appendString(@NonNull String string) {
		s.append(string);
	}

	public void setSuffix(@NonNull String suffix) {
		this.suffix = suffix;
	}

	@Override
	public @NonNull String toString() {
		String string = s.toString();
		if (s.length() > 50) {
			string = string.substring(0, 50);
		}
		if (suffix != null) {
			return string + suffix;
		}
		else {
			return string;
		}
	}
}