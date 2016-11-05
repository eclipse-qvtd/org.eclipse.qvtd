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
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractConnection;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;

/**
 * An AbstractConnection maintains the values between one or more sources, typically Mappings, that
 * invoke append() and one or more consumers that consume each value.
 *
 * The AbstractConnection may optionally enforce uniqueness on the internal values where the overall
 * application is unable to do so automatically.
 *
 * Incremental update is not supported.
 */
public abstract class AbstractConnectionInternal extends AbstractConnection
{
	/**
	 * The values passed by the connection..
	 */
	protected final @NonNull List<@NonNull Object> values = new ArrayList<>();

	protected AbstractConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}

	@Override
	public void addAppender(@NonNull InvocationConstructor appendingInvoker) {}

	/**
	 * Append anElement to the contents, and waking up the overall
	 * connection manager to schedule a propagate() to consumers when convenient.
	 */
	@Override
	public synchronized @NonNull Object appendElement(@NonNull Object anElement) {
		if (debugAppends) {
			AbstractTransformer.APPENDS.println(this + " <= " + LabelUtil.getLabel(anElement));
		}
		values.add(anElement);
		queue();
		return anElement;
	}

	@Override
	public int getCapacity() {
		return values.size();
	}

	@Override
	public @NonNull Object getValue(int i) {
		return values.get(i);
	}

	@Override
	public int getValues() {
		return values.size();
	}

	@Override
	public <@NonNull T> @NonNull Iterable<T> typedIterable(Class<T> elementClass) {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull T> castValues = (Iterable<@NonNull T>) values;
		return castValues;
	}
}