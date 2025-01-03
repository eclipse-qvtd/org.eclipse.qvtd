/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.runtime.internal.evaluation.StrictIncrementalConnectionInternal;

/**
 * An EnforcedConnection maintains the unqiue values between one or more sources,
 * typically Mappings, that invoke append() and one or more consumers that consume each value.
 * Uniqueness on the internal values on behalf of an overall application that is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 */
public class StrictIncrementalConnection extends StrictIncrementalConnectionInternal
{
	public StrictIncrementalConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
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
				Integer count = (Integer) valueAndConsumingInvocations.get(COUNT_INDEX);
				assert count != null;
				if (count <= 0) {
					listOfValueAndConsumingInvocations.set(i, null);
					int jMax = valueAndConsumingInvocations.size();
					for (int j = COUNT_INDEX+1; j < jMax; j++) {
						AbstractInvocation.Incremental consumingInvocation = (AbstractInvocation.Incremental) valueAndConsumingInvocations.get(j);
						consumingInvocation.revoke();
					}
				}
				else {
					valueAndConsumingInvocations.set(COUNT_INDEX, count-1);
				}
				break;
			}
		}
	}

	@Override
	public void revokeConsumer(@NonNull Object anElement, Invocation.@NonNull Incremental invocation) {	// FIXME Use connectionKey
		for (int i = 0; i < listOfValueAndConsumingInvocations.size(); i++) {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
			if ((valueAndConsumingInvocations != null) && (valueAndConsumingInvocations.get(VALUE_INDEX) == anElement)) {
				int jMax = valueAndConsumingInvocations.size();
				for (int j = COUNT_INDEX+1; j < jMax; j++) {
					AbstractInvocation.Incremental consumingInvocation = (AbstractInvocation.Incremental) valueAndConsumingInvocations.get(j);
					if (consumingInvocation == invocation) {
						valueAndConsumingInvocations.remove(j);
						break;
					}
				}
				break;
			}
		}
	}
}