/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.invocation;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.osgi.util.NLS;

/**
 * TransformationTechnology defines a polymorphic interface by which a variety of alternative transformation
 * technologies my be invoked.
 *
 * @noimplement clients should derive from AbstractTransformationTechnology
 */
public interface TransformationTechnology
{
	@SuppressWarnings("serial")
	public class TransformationException extends Exception {
		protected final @NonNull Map<@NonNull String, Object> parametersMap;

		public TransformationException(@NonNull Map<@NonNull String, Object> parametersMap, @Nullable Throwable cause, @NonNull String message, Object... objects) {
			super(NLS.bind(message, objects), cause);
			this.parametersMap = parametersMap;
		}
	}

	/**
	 * Perform a transformation.
	 * Optionally use resources within resourceSet.
	 * Optionally bind model names to models using modelMap.
	 * Optionally bind named parameters to arbitrary objects using parametersMap.
	 * Optionally return model names bound via a return Map.
	 * Throw an Exception if execution is unsuccessful.
	 */
	@NonNull Map<@NonNull String, Object> execute(@NonNull ResourceSet resourceSet, @NonNull Map<@NonNull String, Object> modelMap,
			@NonNull Map<@NonNull String, Object> parametersMap) throws TransformationException;

	/**
	 * Return the TransformationTechnology name used as the TransformationTechnologyContribution.REGISTRY key.
	 */
	@NonNull String getName();
}
