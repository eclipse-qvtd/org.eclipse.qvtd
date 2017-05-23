/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Debug assist. An instance of ToDOT may be used to provide a debugger facility to serialize a
 * DOT image description of a ToDOTable as a string when the the instance is selected. The string may then be pasted
 * to a *.dot file for display in an Eclipse GraphViz (TextUML) Image Viewer. 
 */
public class ToDOT
{
	public interface ToDOTable
	{
		void toGraph(@NonNull GraphStringBuilder s);
	}
	
	private final @NonNull ToDOTable toDot;
	
	public ToDOT(@NonNull ToDOTable toDot) {
		this.toDot = toDot;
	}
	
	@Override
	public @NonNull String toString() {
		DOTStringBuilder s = new DOTStringBuilder();
		toDot.toGraph(s);
		return s.toString();
	}
}