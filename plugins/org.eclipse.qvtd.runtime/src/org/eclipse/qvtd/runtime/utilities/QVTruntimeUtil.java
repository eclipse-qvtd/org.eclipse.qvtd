/*******************************************************************************
 * Copyright (c) 2010 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.utilities;

import org.eclipse.jdt.annotation.Nullable;

public class QVTruntimeUtil
{
	public static @Nullable String contextLine = null;

	public static void errPrintln(@Nullable String string) {
		if (contextLine != null) {
			System.err.println(contextLine);
			contextLine = null;
		}
		System.err.println(String.valueOf(string));
	}
}
