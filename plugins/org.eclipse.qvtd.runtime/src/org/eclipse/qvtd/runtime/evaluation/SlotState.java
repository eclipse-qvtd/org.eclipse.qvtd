/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A SlotState identifies the assigned/not assigned state of an Object slot. Except for debug purposes, it does not
 * maintain the assigned values, just whether an assignment has occurred.
 *
 * Derived classes handle different usages:
 * A SimpleSlotState supports a unidirectional state such as an EAttribute.
 * An OneToOneSlotState supports both ends of a 1:1 EReference.
 * An OnetoManyElementSlotState and OneToManyAggregatorSlotState support the 1:N and N:1 ends of a 1:N EReference.
 * An OclContainerSlotState supports the variant OnetoManyElementSlotState for the eContainer(0 relationship.
 * A ManyToManySlotState supports one end of an M:N EReference.
 *
 * Note that by supporting both ends of a relationship, use of OneToOneSlotState may involve either the forward
 * or reverse direction; a get may occur in the opposite direction to the assign.
 *
 * @noimplement clients should derive from AbstractSlotState
 */
public interface SlotState extends ExecutionVisitable
{
	/**
	 * Update the SlotState as a result of an assignment of ecoreValue to the eFeature of eObject.
	 */
	void assigned(@NonNull Object eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue);

	/**
	 * Install this SlotState as a block on the progress of invocation.
	 */
	void block(@NonNull Invocation invocation);

	void debugUnblock();

	/**
	 * Throw an InvocationFailedException if the eFeature of eObject has not been assigned.
	 */
	void getting(@NonNull Object eObject, @NonNull EStructuralFeature eFeature) throws InvocationFailedException;

	public interface Incremental extends SlotState
	{
		void addSourceInternal(Invocation.@NonNull Incremental invocation);
		void addTargetInternal(Execution.@NonNull Incremental invocation);
		@NonNull EStructuralFeature getEFeature();
		SlotState.@NonNull Incremental getPrimarySlotState();
		@Nullable Object getValue();
		@NonNull Iterable<Invocation.@NonNull Incremental> getSources();
		@NonNull Iterable<Execution.@NonNull Incremental> getTargets();
		void revokeAssigned();
	}
}
