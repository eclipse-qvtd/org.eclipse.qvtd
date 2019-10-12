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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A TypedModelConfiguration specifies how a particular TypedModel is to be used during execution.
 */
public class TypedModelConfiguration //implements Nameable
{
	public enum Mode {
		CHECK,					// Used as input only
		ENFORCE,				// Used as output only
		INTERNAL,				// Used to connect internal productions to internal consumptions
		REPLACE,				// Used as input to compute a replacement output
		UPDATE					// Used as input to compute an updated output
	}
	private final @NonNull Mode mode;
	private final @Nullable String name;
	private @Nullable TypedModel typedModel = null;

	public TypedModelConfiguration(@Nullable String name, @NonNull Mode mode) {
		this.name = name;
		this.mode = mode;
	}

	public @Nullable String getName() {
		return name;
	}

	public @NonNull TypedModel getTypedModel() {
		return ClassUtil.nonNullState(typedModel);
	}

	public @Nullable String init(@NonNull Iterable<@NonNull TypedModel> typedModels) {
		assert typedModel == null;
		typedModel = NameUtil.getNameable(typedModels, name);
		return typedModel != null ? null : "No '" + name + " TypedModel in " + typedModels.iterator().next().getTransformation();
	}

	public boolean isInput() {
		return (mode == Mode.CHECK) || (mode == Mode.INTERNAL) || (mode == Mode.REPLACE);
	}

	public boolean isIntermediate() {
		return mode == Mode.INTERNAL;
	}

	public boolean isOutput() {
		return (mode == Mode.ENFORCE) || (mode == Mode.INTERNAL) || (mode == Mode.REPLACE);
	}

	@Override
	public String toString() {
		return typedModel != null ? typedModel.getName() : name;
	}
}
