/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.runtime.evaluation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractDispatchOperation;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;

/**
 * AbstractDispatchOperation supports evaluation by virtual dispatch to the appropriate operation
 * determined by the class of the source argument.
 * @since 1.3
 */
public abstract class AbstractDispatchOperation2 extends AbstractDispatchOperation implements LibraryOperation.LibraryOperationExtension2
{
	/**
	 * BAD_OPERATION populates dispatch targets that fail to resolve and inhibits attempts at re-resolution.
	 */
	private static final  Computation.@NonNull Constructor BAD_OPERATION = new Computation.Constructor()
	{
		@Override
		public @NonNull Computation getUniqueComputation(@Nullable Object @NonNull... argValues) {
			throw new UnsupportedOperationException();		// XXX invalid
		}
	};

	/**
	 * Map of target operations for each known source type. Map is populated by installed targets. Thereafter
	 * it grows lazily as the target for further types is discovered by inheritance search.
	 */
	private final @NonNull Map<@NonNull Class<?>, Computation.@NonNull Constructor> class2cache = new HashMap<>();

	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
		Object source = sourceAndArgumentValues[0];
		if (source == null) {
			return null;
		}
		Class<?> jClass = source.getClass();
		Computation.Constructor abstractOperation = class2cache.get(jClass);
		if (abstractOperation == null) {
			abstractOperation = resolve(jClass);
			if (abstractOperation == null) {
				abstractOperation = BAD_OPERATION;
				class2cache.put(jClass, abstractOperation);
			}
			assert class2cache.get(jClass) == abstractOperation;
		}
		return abstractOperation.getUniqueComputation(/*executor, caller,*/ sourceAndArgumentValues).getResult();
	}

	@Override
	protected void install(@NonNull Class<?> jClass, @NonNull AbstractOperation operation) {
		throw new UnsupportedOperationException();
	}

	protected void install(@NonNull Class<?> jClass, @NonNull AbstractComputationConstructor cache) {
		class2cache.put(jClass, cache);
	}

	private Computation.@Nullable Constructor resolve(@NonNull Class<?> jClass) {
		for (Class<?> jInterface : jClass.getInterfaces()) { // Interfaces first supports EMF's Impl registered as non-Impl
			assert jInterface != null;
			Computation.Constructor abstractOperation = class2cache.get(jInterface);
			if (abstractOperation != null) {
				class2cache.put(jClass, abstractOperation);
				return abstractOperation;
			}
			abstractOperation = resolve(jInterface);
			if (abstractOperation != null) {
				class2cache.put(jClass, abstractOperation);
				return abstractOperation;
			}
		}
		Class<?> jSuperclass = jClass.getSuperclass();
		if (jSuperclass != null) {
			Computation.Constructor abstractOperation = class2cache.get(jSuperclass);
			if (abstractOperation != null) {
				class2cache.put(jClass, abstractOperation);
				return abstractOperation;
			}
			abstractOperation = resolve(jSuperclass);
			if (abstractOperation != null) {
				class2cache.put(jClass, abstractOperation);
				return abstractOperation;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		List<@NonNull Class<?>> keys = new ArrayList<>(class2cache.keySet());
		Collections.sort(keys, new Comparator<@NonNull Class<?>>()
		{
			@Override
			public int compare(@NonNull Class<?> o1, @NonNull Class<?> o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		StringBuilder s = new StringBuilder();
		for (@NonNull Class<?> key : keys) {
			s.append(key + " => " + class2cache.get(key) + "\n");
		}
		return s.toString();
	}
}
