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
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;

/**
 * An AbstractConnection maintains the values between one or more sources, typically Mappings, that
 * invoke append() and one or more consumers that consume each value.
 *
 * The AbstractConnection may optionally enforce uniqueness on the internal values where the overall
 * application is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 */
public class IncrementalConnectionInternal extends AbstractIncrementalConnectionInternal
{
	protected IncrementalConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}

	/**
	 * Append anElement to the contents, and waking up the overall
	 * connection manager to schedule a propagate() to consumers when convenient.
	 */
	@Override
	public synchronized @NonNull Object appendElement(@NonNull Object anElement) {
		if (debugAppends) {
			AbstractTransformer.APPENDS.println(this + " <= " + LabelUtil.getLabel(anElement));
		}
		List<@NonNull Object> valueAndConsumingInvocations = new ArrayList<>();
		valueAndConsumingInvocations.add(anElement);									// VALUE_INDEX
		valueAndConsumingInvocations.add(listOfValueAndConsumingInvocations.size());	// INDEX_INDEX
		listOfValueAndConsumingInvocations.add(valueAndConsumingInvocations);
		queue();
		return valueAndConsumingInvocations;
	}

	@Override
	public void check() {
		for (int i = 0; i < listOfValueAndConsumingInvocations.size(); i++) {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
			if (valueAndConsumingInvocations != null) {
				assert valueAndConsumingInvocations.get(INDEX_INDEX) == Integer.valueOf(i);
			}
		}
	}

	/**
	 * Remove, inverse append, the old anElement. The old value is removed,
	 * its consumingInvocations are revoked so that their appends are also revoked.
	 */
	@Override
	public synchronized void removeElement(@NonNull Object anElement) {
		for (int i = 0; i < listOfValueAndConsumingInvocations.size(); i++) {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
			if ((valueAndConsumingInvocations != null) && (valueAndConsumingInvocations.get(VALUE_INDEX) == anElement)) {
				listOfValueAndConsumingInvocations.set(i, null);
				int jMax = valueAndConsumingInvocations.size();
				for (int j = INDEX_INDEX+1; j < jMax; j++) {
					AbstractInvocation.Incremental consumingInvocation = (AbstractInvocation.Incremental) valueAndConsumingInvocations.get(j);
					consumingInvocation.revokeExecution();
				}
				break;
			}
		}
	}

	/**
	 * Replace the old value at connectionKey by newValue.The old value is removed,
	 * its consumingInvocations are invalidated so that they recompute with the newValue which replaces the old.
	 */
	@Override
	public synchronized @NonNull Object replace(@NonNull Object connectionKey, @NonNull Object newValue) {
		@SuppressWarnings("unchecked") List<@NonNull Object> valueAndConsumingInvocations = (List<@NonNull Object>) connectionKey;
		Object oldValue = valueAndConsumingInvocations.get(VALUE_INDEX);
		if (newValue != oldValue) {		// FIXME ?? equals/oclEquals ??
			valueAndConsumingInvocations.set(VALUE_INDEX, newValue);
			int iMax = valueAndConsumingInvocations.size();
			for (int i = INDEX_INDEX+1; i < iMax; i++) {
				Invocation consumer = (Invocation) valueAndConsumingInvocations.get(i);
				interval.queue(consumer);
			}
		}
		return connectionKey;
	}

	/**
	 * Revoke, inverse append, the old value at connectionKey. The old value is removed,
	 * its consumingInvocations are revoked so that their appends are also revoked.
	 */
	@Override
	public synchronized void revoke(@NonNull Object connectionKey) {
		@SuppressWarnings("unchecked") List<@NonNull Object> valueAndConsumingInvocations = (List<@NonNull Object>) connectionKey;
		int valueIndex = (int) valueAndConsumingInvocations.get(INDEX_INDEX);
		listOfValueAndConsumingInvocations.set(valueIndex, null);			// Do not disrupt index equivalence.
		int iMax = valueAndConsumingInvocations.size();
		for (int i = INDEX_INDEX+1; i < iMax; i++) {
			AbstractInvocation.Incremental consumingInvocation = (AbstractInvocation.Incremental) valueAndConsumingInvocations.get(i);
			consumingInvocation.revokeExecution();
		}
	}
}