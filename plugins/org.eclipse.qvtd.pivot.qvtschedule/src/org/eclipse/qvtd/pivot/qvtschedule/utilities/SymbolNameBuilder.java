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
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;

/**
 * SymbolNameBuilder supports building a symbol name including replacement of awkward characters.
 */
public class SymbolNameBuilder
{
	private final int lengthLimit;
	private final @NonNull StringBuilder s = new StringBuilder();

	public SymbolNameBuilder() {
		this.lengthLimit = 50;
	}

	public SymbolNameBuilder(int lengthLimit) {
		this.lengthLimit = lengthLimit;
	}

	//	public SymbolNameBuilder(@NonNull String s) {
	//		this.s.append(s);
	//	}

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

	@Override
	public @NonNull String toString() {
		String string = s.toString();
		if ((lengthLimit > 0) && (s.length() > lengthLimit)) {
			string = string.substring(0, lengthLimit);
		}
		return string;
	}
}