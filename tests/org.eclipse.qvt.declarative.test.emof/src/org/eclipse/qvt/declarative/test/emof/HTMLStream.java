/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * HTMLStream assists in gemneration of the Compliance by providing HTML
 * formatting for messages originally produced to define OMG issues.
 */
public class HTMLStream extends PrintStream
{
	private boolean enabled = true;;
	
	public HTMLStream(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	public void printDifferenceLine(String x) {
		StringBuffer s = new StringBuffer();
		s.append("<br>");
		int quoteCount = 0;
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if (c == '\'')
				s.append((quoteCount++ & 1) == 0 ? "<tt>" : "</tt>");
			else
				s.append(c);
		}
		println(s.toString().replaceAll("should be", "is"));
	}

	@Override
	public void println(String x) {
		if (enabled)
			super.println(x);
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
