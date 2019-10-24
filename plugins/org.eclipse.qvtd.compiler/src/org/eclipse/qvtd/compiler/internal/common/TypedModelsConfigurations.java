/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * A TypedModelsConfigurations specifies all the alternative ways in which a transformation may be executed
 * with a TypedModelsConfiguration for eaxch alternative.
 */
public class TypedModelsConfigurations implements Iterable<@NonNull TypedModelsConfiguration>
{
	protected final @NonNull List<@NonNull TypedModelsConfiguration> typedModelsConfigurations = new ArrayList<>();

	public TypedModelsConfigurations() {}

	public void add(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		typedModelsConfigurations.add(typedModelsConfiguration);
	}

	@Override
	public @NonNull Iterator<@NonNull TypedModelsConfiguration> iterator() {
		return typedModelsConfigurations.iterator();
	}

	/**
	 * Determine the alterbatives by applying an appropriate derived class specific algorithm to
	 * the transformation.
	 *
	 * Returns null if successful, or a new-line-separated concatenation of explanatory error messages if not.
	 */
	public @Nullable String reconcile(@NonNull Transformation transformation) {
		StringBuilder s = null;
		for (@NonNull TypedModelsConfiguration typedModelsConfiguration : typedModelsConfigurations) {
			String s2 = typedModelsConfiguration.reconcile(transformation);
			if (s2 != null) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append("\n");
				}
				s.append(s2);
			}
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");
		for (@NonNull TypedModelsConfiguration typedModelsConfiguration : typedModelsConfigurations) {
			s.append(typedModelsConfiguration.toString());
		}
		s.append("}");
		return s.toString();
	}
}
