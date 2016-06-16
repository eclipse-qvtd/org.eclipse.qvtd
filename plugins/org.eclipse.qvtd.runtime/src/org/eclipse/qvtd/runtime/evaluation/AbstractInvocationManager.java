/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;

/**
 * AbstractInvocationManager provides the mandatory shared functionality for a mapping invocation manager.
 * @since 1.1
 */
public abstract class AbstractInvocationManager implements InvocationManager
{
	protected final IdResolver.@NonNull IdResolverExtension idResolver;

	/**
	 * Map from occurrence identity to one or more occurrences with that identity. Single map entries use the
	 * Occurence directly as the entry. Colliding entries use a List<Occurence> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated occurrences of the occurrenceId.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> occurrenceId2occurrence = new HashMap<@NonNull Integer, @NonNull Object>();

	protected AbstractInvocationManager(@NonNull IdResolver idResolver) {
		this.idResolver = (IdResolverExtension)idResolver;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocationManager(this);
	}
	
    /**
     * Create or reuse the unique occurrence object, created by constructor and parameterized by argValues.
     * @throws ReflectiveOperationException 
     */
	@Override
	public <T extends Occurrence> @NonNull T createFirst(@NonNull Object constructorThis, @NonNull Constructor<? extends T> constructor, @Nullable Object @NonNull [] argValues) throws ReflectiveOperationException {
    	Class<? extends T> occurrenceClass = constructor.getDeclaringClass();
    	assert occurrenceClass != null;
		int hashCode = System.identityHashCode(occurrenceClass);
    	for (@Nullable Object argValue : argValues) {
    		hashCode = 3 * hashCode + idResolver.oclHashCode(argValue);
    	}
    	Object zeroOrMoreOccurrences = occurrenceId2occurrence.get(hashCode);
    	Occurrence oneOccurrence = null;
		List<@NonNull Occurrence> twoOrMoreOccurrences2 = null;
    	if (zeroOrMoreOccurrences instanceof Occurrence) {
    		oneOccurrence = (Occurrence)zeroOrMoreOccurrences;
    		if ((occurrenceClass == oneOccurrence.getClass()) && oneOccurrence.isEqual(idResolver, argValues)) {
	    		@SuppressWarnings("unchecked") T castOccurrence = (T)oneOccurrence;
				return castOccurrence;
	    	}
    	}
    	else if (zeroOrMoreOccurrences instanceof List<?>) {
    		@SuppressWarnings("unchecked")@NonNull List<@NonNull Occurrence> zeroOrMoreOccurrences2 = (List<@NonNull Occurrence>)zeroOrMoreOccurrences;
			twoOrMoreOccurrences2 = zeroOrMoreOccurrences2;
			for (@NonNull Occurrence anOccurrence : twoOrMoreOccurrences2) {
		   		if ((occurrenceClass == anOccurrence.getClass()) && anOccurrence.isEqual(idResolver, argValues)) {
		    		@SuppressWarnings("unchecked") T castOccurrence = (T)anOccurrence;
					return castOccurrence;
    	    	}
    		}
    	}
		T theOccurrence = constructor.newInstance(constructorThis, argValues);
		if (zeroOrMoreOccurrences == null) {
			occurrenceId2occurrence.put(hashCode, theOccurrence);
		}
		else {
			if (twoOrMoreOccurrences2 == null) {
	    		twoOrMoreOccurrences2 = new ArrayList<@NonNull Occurrence>(4);
	    		assert oneOccurrence != null;
    			twoOrMoreOccurrences2.add(oneOccurrence);
			}
			twoOrMoreOccurrences2.add(theOccurrence);
			occurrenceId2occurrence.put(hashCode, twoOrMoreOccurrences2);
		}
		return theOccurrence;
    }
}