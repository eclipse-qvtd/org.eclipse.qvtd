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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.runtime.evaluation.SlotState.Speculating;

/**
 * An ObjectManager supervises the state of relevant properties in objects used by a mapping invocation.
 *
 * getting should be invoked as a pre-access guard to cause the invocation to fail if a not-ready property is accessed.
 *
 * assigned should be invoked to invocation that a property whose access is guarded is now assigned.
 *
 * @noimplement clients should derive from AbstractObjectManager
 */
public interface ObjectManager/*<SS extends SlotState>*/ extends ExecutionVisitable
// It is tempting to use an SS parameter to capture the Incremental/LazySlotState diversity, but with only one
// active ObjectManager, the parameter just migrates the gratuitous inherently safe casts.
{
	/**
	 * Register eAttributes as a Boolean[?] status aattributes that may be used by speculations.
	 */
	void addSpeculatedEAttributes(@NonNull Iterable<@NonNull EAttribute> eAttributes);

	/**
	 * Mark the eFeature of eObject as assigned with an ecoreValue. Ordered child assignments may be ordered by the childKey.
	 *
	 * If !isPartial, ecoreValue is a total assignment, i.e. A collection if eFeature.isMany();
	 * If isPartial, ecoreValue is a partial assignment, i.e. An element of the eFeature.isMany() collection;
	 */
	void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial);

	@Deprecated /* @deprecated supply isPartial argument */
	default void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assigned(eObject, eFeature, ecoreValue, false);
	}

	/**
	 * Mark the eFeature of eObject as assigned with an ecoreValue by an invocation. Ordered child assignments may be ordered by the childKey.
	 *
	 * If !isPartial, ecoreValue is a total assignment, i.e. A collection if eFeature.isMany();
	 * If isPartial, ecoreValue is a partial assignment, i.e. An element of the eFeature.isMany() collection;
	 */
	void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, boolean isPartial);

	@Deprecated /* @deprecated supply isPartial argument */
	default void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue) {
		assigned(invocation, eObject, eFeature, ecoreValue, false);
	}

	/**
	 * Identify the creation of eObject by the current mapping invocation.
	 */
	void created(Invocation.@NonNull Incremental invocation, @NonNull Object eObject);

	void destroyed(@NonNull Object eObject);

	/**
	 * Return the eReference's opposite EReference which may be an internal EOppositeReferenceImpl if the Ecore model
	 * EReference is not bidirectional.
	 */
	@NonNull EReference getEOppositeReference(@NonNull EReference eReference);

	@NonNull Iterable<@NonNull ? extends Object> getObjects();
	@NonNull Iterable<@NonNull ? extends SlotState> getSlotStates(@NonNull Object object);

	@NonNull Speculating getSpeculatingSlotState(@NonNull Object object, @NonNull EAttribute successAttribute);
	/**
	 * Throw an InvocationFailedException if the eFeature of eObject has not yet been assigned.
	 * If isOpposite, the eFeature's opposite is to be be assessed.
	 */
	void getting(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, boolean isOpposite) throws InvocationFailedException;

	/**
	 * Identify that the read of eFeature of eObject returns ecoreValue.

	/**
	 * Update the eFeature SlotState of eObject with an ecoreValue as a consequence of ecoreValue being obtained by an eGet().
	 * Register the update with invocation so that any blockage can be removed.
	 */
	void got(Execution.@NonNull Incremental invocation, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue);

}
