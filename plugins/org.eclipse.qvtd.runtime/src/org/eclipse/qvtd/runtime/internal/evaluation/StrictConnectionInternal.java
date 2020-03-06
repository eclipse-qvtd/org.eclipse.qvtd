/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Interval;

/**
 * A StrictConnectionInternal maintains the unique values between one or more sources,
 * typically Mappings, that invoke append() and one or more consumers that consume each value.
 * Uniqueness on the internal values on behalf of an overall application that is unable to do so automatically.
 *
 * Incremental update is not supported.
 */
public abstract class StrictConnectionInternal extends AbstractConnectionInternal
{
	/**
	 * Distinct connection values, if there are more than 10 values.
	 */
	private /*@LazyNonNull*/ Set<@NonNull Object> uniqueValues = null;

	protected StrictConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}

	/**
	 * Append aValue to the contents, enforcing uniqueness if necessary, and waking up the overall
	 * connection manager to schedule a propagate() to consumers when convenient.
	 */
	@Override
	public synchronized @NonNull Object appendElement(@NonNull Object anElement) {
		if (debugAppends) {
			AbstractTransformer.APPENDS.println(this + " <= " + LabelUtil.getLabel(anElement));
		}
		if (uniqueValues != null) {
			if (!uniqueValues.add(anElement)) {
				return anElement;
			}
		}
		else if (values.size() < 10) {
			for (@NonNull Object value : values) {
				if (value.equals(anElement)) {			// FIXME ==/oclEquals
					return anElement;
				}
			}
		}
		else if (!createUniqueValues().add(anElement)) {
			return anElement;
		}
		values.add(anElement);
		queue();
		return anElement;
	}

	private @NonNull Set<@NonNull Object> createUniqueValues() {
		Set<@NonNull Object> uniqueValues2 = uniqueValues = new HashSet<>();
		for (@NonNull Object value : values) {
			uniqueValues2.add(value);
		}
		return uniqueValues2;
	}
}