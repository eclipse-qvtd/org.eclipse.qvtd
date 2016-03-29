/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An ObjectManager supervises the state of relevant properties in objects used by a mapping invocation.
 * 
 * getting should be invoked as a pre-access guard to cause the invocation to fail if a not-ready property is accessed.
 * 
 * assigned should be invoked to invocation that a property whose access is guarded is now assigned.
 * 
 * @since 1.1
 * @noimplement clients should derive from AbstractObjectManager
 */
public interface ObjectManager extends ExecutionVisitable
{
	/**
	 * Mark the eFeature of eObject as assigned with an ecoreValue. Ordered child assignments may be ordered by the childKey.
	 */
	void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey);

	/**
	 * Mark the eFeature of eObject as assigned with an ecoreValue by an invocation. Ordered child assignments may be ordered by the childKey.
	 */
	void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey);

	/**
	 * Identify the creation of eObject by the current mapping invocation.
	 */
	void created(Invocation.@NonNull Incremental invocation, @NonNull Object eObject);

	@NonNull Iterable<@NonNull ? extends Object> getObjects();
	@NonNull Iterable<@NonNull ? extends SlotState> getSlotStates(@NonNull Object object);
	
	/**
	 * Throw an InvocationFailedException if the eFeature of eObject has not yet been assigned.
	 * If isOpposite, the eFeature's opposite is to be be assessed.
	 */
	void getting(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, boolean isOpposite) throws InvocationFailedException;
	
	/**
	 * Identify that the read of eFeature of eObject return ecoreValue.
	 */
	void got(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue);

	void unblock(@NonNull Invocation anInvocation);
}
