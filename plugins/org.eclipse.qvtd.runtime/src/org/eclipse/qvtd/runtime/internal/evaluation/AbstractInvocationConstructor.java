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
import org.eclipse.qvtd.runtime.evaluation.Invocation;

public abstract class AbstractInvocationConstructor implements Invocation.Constructor
{
	protected final IdResolver.@NonNull IdResolverExtension idResolver;
	
	/**
	 * Map from invocation hashCode to one or more invocations with that hashCode. Single map entries use the
	 * Invocation directly as the entry. Colliding entries use a List<@NonNull Invocation> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated invocations.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> hashCode2invocations = new HashMap<@NonNull Integer, @NonNull Object>();
	
	protected AbstractInvocationConstructor(@NonNull IdResolver idResolver) {
		this.idResolver = (IdResolver.IdResolverExtension)idResolver;
	}
	
	@Override
	public @Nullable Invocation getFirstInvocation(@NonNull Object @NonNull [] argValues) {
		int hashCode = 0;
    	for (@Nullable Object argValue : argValues) {
    		hashCode = 3 * hashCode + idResolver.oclHashCode(argValue);
    	}
    	synchronized (hashCode2invocations) {
	    	Object zeroOrMoreInvocations = hashCode2invocations.get(hashCode);
	    	Invocation oneInvocation = null;
			List<@NonNull Invocation> twoOrMoreInvocations = null;
	    	if (zeroOrMoreInvocations instanceof Invocation) {
	    		oneInvocation = (Invocation)zeroOrMoreInvocations;
	    		if (oneInvocation.isEqual(idResolver, argValues)) {
		    		return null;
		    	}
	    	}
	    	else if (zeroOrMoreInvocations instanceof List<?>) {
	    		@SuppressWarnings("unchecked")@NonNull List<@NonNull Invocation> zeroOrMoreInvocations2 = (List<@NonNull Invocation>)zeroOrMoreInvocations;
	    		twoOrMoreInvocations = zeroOrMoreInvocations2;
				for (@NonNull Invocation anInvocation : zeroOrMoreInvocations2) {
			   		if (anInvocation.isEqual(idResolver, argValues)) {
			    		return null;
	    	    	}
	    		}
	    	}
	    	Invocation theInvocation = newInstance(argValues);
			if (zeroOrMoreInvocations == null) {
				hashCode2invocations.put(hashCode, theInvocation);
			}
			else if (twoOrMoreInvocations == null) {
		    	twoOrMoreInvocations = new ArrayList<@NonNull Invocation>(4);
		    	assert oneInvocation != null;
	    		twoOrMoreInvocations.add(oneInvocation);
				twoOrMoreInvocations.add(theInvocation);
				hashCode2invocations.put(hashCode, twoOrMoreInvocations);
			}
			else {
				twoOrMoreInvocations.add(theInvocation);
			}
			return theInvocation;
    	}
    }
}