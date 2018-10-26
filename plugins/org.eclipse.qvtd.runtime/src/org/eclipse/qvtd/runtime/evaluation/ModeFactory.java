/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * ModeFactory support construction of incremental/non-incremental run-time artefacts prividing extensibility
 * to alternate execution modes in the future.
 */
public interface ModeFactory
{
	public static final @NonNull ModeFactory INCREMENTAL = new Incremental();
	public static final @NonNull ModeFactory NON_INCREMENTAL = new NonIncremental();

	public class Incremental implements ModeFactory
	{
		@Override
		public @NonNull Connection createConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
			if (isStrict) {
				return new StrictIncrementalConnection(interval, name, typeId);
			}
			else {
				return new SimpleIncrementalConnection(interval, name, typeId);
			}
		}
	}

	public class NonIncremental implements ModeFactory
	{
		@Override
		public @NonNull Connection createConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
			if (isStrict) {
				return new StrictConnection(interval, name, typeId);
			}
			else {
				return new SimpleConnection(interval, name, typeId);
			}
		}
	}

	@NonNull Connection createConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId, boolean isStrict);
}
