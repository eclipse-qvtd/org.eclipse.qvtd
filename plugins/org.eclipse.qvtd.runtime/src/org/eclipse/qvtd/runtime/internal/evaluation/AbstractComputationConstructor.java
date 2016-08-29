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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Computation;

public abstract class AbstractComputationConstructor implements Computation.Constructor
{
	protected final IdResolver.@NonNull IdResolverExtension idResolver;

	/**
	 * Map from invocation hashCode to one or more computations with that hashCode. Single map entries use the
	 * Computation directly as the entry. Colliding entries use a List<@NonNull Computation> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated computations.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> hashCode2computations = new HashMap<@NonNull Integer, @NonNull Object>();

	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	protected AbstractComputationConstructor(@NonNull IdResolver idResolver) {
		this.idResolver = (IdResolver.IdResolverExtension)idResolver;
	}

	@Override
	public @NonNull Computation getUniqueComputation(@Nullable Object @NonNull ... argValues) {
		int hashCode = 0;
		for (@Nullable Object argValue : argValues) {
			hashCode = 3 * hashCode + idResolver.oclHashCode(argValue);
		}
		synchronized (hashCode2computations) {
			Object zeroOrMoreComputations = hashCode2computations.get(hashCode);
			Computation oneComputation = null;
			if (zeroOrMoreComputations instanceof Computation) {
				oneComputation = (Computation)zeroOrMoreComputations;
				if (oneComputation.isEqual(idResolver, argValues)) {
					if (debugInvocations) {
						AbstractTransformer.INVOCATIONS.println("getUniqueComputation old:" + oneComputation);
					}
					return oneComputation;
				}
			}
			else if (zeroOrMoreComputations instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull Computation> zeroOrMoreComputations2 = (List<@NonNull Computation>)zeroOrMoreComputations;
				for (@NonNull Computation aComputation : zeroOrMoreComputations2) {
					if (aComputation.isEqual(idResolver, argValues)) {
						if (debugInvocations) {
							AbstractTransformer.INVOCATIONS.println("getUniqueComputation old:" + aComputation);
						}
						return aComputation;
					}
				}
			}
		}
		//
		//	Must resynchronize after newInstance creation and execution in case the execution is recursive.
		//
		Computation theComputation = newInstance(argValues);
		synchronized (hashCode2computations) {
			Object zeroOrMoreComputations = hashCode2computations.get(hashCode);
			if (zeroOrMoreComputations == null) {
				hashCode2computations.put(hashCode, theComputation);
			}
			else if (zeroOrMoreComputations instanceof Computation) {
				Computation oneComputation = (Computation)zeroOrMoreComputations;
				if (oneComputation.isEqual(idResolver, argValues)) {
					if (debugInvocations) {
						AbstractTransformer.INVOCATIONS.println("getUniqueComputation old:" + oneComputation);
					}
					return oneComputation;
				}
				List<@NonNull Computation> twoOrMoreComputations = new ArrayList<@NonNull Computation>(4);
				twoOrMoreComputations.add(oneComputation);
				twoOrMoreComputations.add(theComputation);
				hashCode2computations.put(hashCode, twoOrMoreComputations);
			}
			else if (zeroOrMoreComputations instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull Computation> twoOrMoreComputations = (List<@NonNull Computation>)zeroOrMoreComputations;
				for (@NonNull Computation aComputation : twoOrMoreComputations) {
					if (aComputation.isEqual(idResolver, argValues)) {
						if (debugInvocations) {
							AbstractTransformer.INVOCATIONS.println("getUniqueComputation old:" + aComputation);
						}
						return aComputation;
					}
				}
				twoOrMoreComputations.add(theComputation);
			}
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("getUniqueComputation new:" + theComputation);
			}
			return theComputation;
		}
	}

	protected abstract @NonNull Computation newInstance(@Nullable Object @NonNull [] values);

}