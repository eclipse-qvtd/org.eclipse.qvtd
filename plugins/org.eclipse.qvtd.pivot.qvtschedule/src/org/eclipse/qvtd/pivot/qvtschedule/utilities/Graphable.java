/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;

public interface Graphable extends ToDOT.ToDOTable
{
	void acceptGraphVisitor(@NonNull ToGraphVisitor2 toGraphVisitor);

	/**
	 * Return the stem for auto-generated file names.
	 */
	@NonNull String getGraphName();
}