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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public interface OperationRegion extends Region
{
	void addDependencyNode(@NonNull Node node);
	void addHeadNode(@NonNull Node node);
	@NonNull List<@NonNull Node> getDependencyNodes();
	void setResultNode(@NonNull Node node);
}