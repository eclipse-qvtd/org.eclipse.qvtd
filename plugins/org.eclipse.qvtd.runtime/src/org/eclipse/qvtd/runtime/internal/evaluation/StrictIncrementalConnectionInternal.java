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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;

/**
 * An AbstractEnforcedConnectionInternal maintains the unqiue values between one or more sources,
 * typically Mappings, that invoke append() and one or more consumers that consume each value.
 * Uniqueness on the internal values on behalf of an overall application that is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 */
public abstract class StrictIncrementalConnectionInternal extends AbstractIncrementalConnectionInternal
{
	/**
	 * Map from each unique value to the entry for that value.
	 */
	private final @NonNull Map<@NonNull Object, @NonNull List<@NonNull Object>> uniqueValues2valueAndConsumingInvocations = new HashMap<>();

	protected StrictIncrementalConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}

	/**
	 * Append anElement to the contents, enforcing uniqueness if necessary, and waking up the overall
	 * connection manager to schedule a propagate() to consumers when convenient.
	 */
	@Override
	public synchronized @NonNull Object appendElement(@NonNull Object anElement) {
		if (debugAppends) {
			AbstractTransformer.APPENDS.println(this + " <= " + LabelUtil.getLabel(anElement));
		}
		List<@NonNull Object> valueAndConsumingInvocations = uniqueValues2valueAndConsumingInvocations.get(anElement);
		if (valueAndConsumingInvocations == null) {
			valueAndConsumingInvocations = new ArrayList<>();
			valueAndConsumingInvocations.add(anElement);									// VALUE_INDEX
			valueAndConsumingInvocations.add(listOfValueAndConsumingInvocations.size());	// INDEX_INDEX
			valueAndConsumingInvocations.add(1);											// COUNT_INDEX
			listOfValueAndConsumingInvocations.add(valueAndConsumingInvocations);
			uniqueValues2valueAndConsumingInvocations.put(anElement, valueAndConsumingInvocations);
			queue();
		}
		else {
			Integer count = (Integer) valueAndConsumingInvocations.get(COUNT_INDEX);
			valueAndConsumingInvocations.set(COUNT_INDEX, count+1);
		}
		return valueAndConsumingInvocations;
	}

	@Override
	public void check() {
		for (int i = 0; i < listOfValueAndConsumingInvocations.size(); i++) {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
			if (valueAndConsumingInvocations != null) {
				assert valueAndConsumingInvocations.get(INDEX_INDEX) == Integer.valueOf(i);
				assert valueAndConsumingInvocations.contains(valueAndConsumingInvocations.get(VALUE_INDEX));
			}
		}
	}

	/**
	 * Replace the old value at connectionKey by newValue.
	 *
	 * If the old value is a multiple value in a unique value connection, the multi-value count is decremented
	 * and a new entry created for the newValue by delegating to append to enforce uniqueness of the newValue.
	 *
	 * Otherwise the old value is removed, its consumingInvocations are invalidated
	 * so that they recompute with the newValue which replaces the old.
	 */
	@Override
	public synchronized @NonNull Object replace(@NonNull Object connectionKey, @NonNull Object newValue) {
		@SuppressWarnings("unchecked") List<@NonNull Object> valueAndConsumingInvocations = (List<@NonNull Object>) connectionKey;
		Object oldValue = valueAndConsumingInvocations.get(VALUE_INDEX);
		if (newValue != oldValue) {		// FIXME ?? equals/oclEquals ??
			Integer count = (Integer) valueAndConsumingInvocations.get(COUNT_INDEX);
			if (count > 1) {
				valueAndConsumingInvocations.set(COUNT_INDEX, count-1);
				return appendElement(newValue);
			}
			valueAndConsumingInvocations.set(VALUE_INDEX, newValue);
			int iMax = valueAndConsumingInvocations.size();
			for (int i = COUNT_INDEX+1; i < iMax; i++) {
				Invocation consumer = (Invocation) valueAndConsumingInvocations.get(i);
				interval.queue(consumer);
			}
		}
		return connectionKey;
	}

	/**
	 * Revoke, inverse append, the old value at connectionKey.
	 *
	 * If the old value is a multiple value in a unique value connection, the multi-value count is decremented.
	 *
	 * Otherwise the old value is removed, its consumingInvocations are revoked
	 * so that their appends are also revoked.
	 */
	@Override
	public synchronized void revoke(@NonNull Object connectionKey) {
		@SuppressWarnings("unchecked") List<@NonNull Object> valueAndConsumingInvocations = (List<@NonNull Object>) connectionKey;
		int valueIndex = (int) valueAndConsumingInvocations.get(INDEX_INDEX);
		Integer count = (Integer) valueAndConsumingInvocations.get(COUNT_INDEX);
		if (count > 1) {
			valueAndConsumingInvocations.set(COUNT_INDEX, count-1);
			return;
		}
		listOfValueAndConsumingInvocations.set(valueIndex, null);			// Do not disrupt index equivalence.
		int iMax = valueAndConsumingInvocations.size();
		for (int i = COUNT_INDEX+1; i < iMax; i++) {
			AbstractInvocation.Incremental consumingInvocation = (AbstractInvocation.Incremental) valueAndConsumingInvocations.get(i);
			consumingInvocation.revoke();
		}
	}
}