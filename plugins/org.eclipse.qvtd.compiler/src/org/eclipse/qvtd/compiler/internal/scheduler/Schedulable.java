/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A Schedulable object has a linear scheduled index.
 */
public interface Schedulable
{
	boolean addIndex(int index);
	int getEarliestIndex();
	@Nullable String getIndexText();
	@Nullable List<@NonNull Integer> getIndexes();
	int getLatestIndex();
}