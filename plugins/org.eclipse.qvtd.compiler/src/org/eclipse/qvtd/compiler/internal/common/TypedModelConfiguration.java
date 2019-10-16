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
 *
 * Initial construction associates a node with a TypedModel name. reconcile() locates the actual TypedModel.
 */
public class TypedModelConfiguration //implements Nameable
{
	public enum Mode {		// TODO this probably needs elaboration for IN-PLACE etc
		INPUT,					// Used as input only
		ENFORCE,				// Used as output only
		INTERMEDIATE,			// Used to connect internal productions to internal consumptions
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

	public @Nullable TypedModel basicGetTypedModel() {
		return typedModel;
	}

	public @Nullable String getName() {
		return name;
	}

	public @NonNull TypedModel getTypedModel() {
		return ClassUtil.nonNullState(typedModel);
	}

	public boolean isInput() {
		return (mode == Mode.INPUT) || /*(mode == Mode.INTERMEDIATE) ||*/ (mode == Mode.REPLACE);
	}

	public boolean isIntermediate() {
		return mode == Mode.INTERMEDIATE;
	}

	public boolean isOutput() {
		return (mode == Mode.ENFORCE) || /*(mode == Mode.INTERMEDIATE) ||*/ (mode == Mode.REPLACE);
	}

	/**
	 * Locate the TypedModel corresponding to the configured name.
	 *
	 * Returns null if successful, or an explanatory error message if not.
	 */
	public @Nullable String reconcile(@NonNull Iterable<@NonNull TypedModel> typedModels) {
		//	assert typedModel == null;		// Allow re-reconcilaiation of QVTc as QVTm
		typedModel = NameUtil.getNameable(typedModels, name);
		return typedModel != null ? null : "No '" + name + " TypedModel in " + typedModels.iterator().next().getTransformation();
	}

	@Override
	public String toString() {
		return "«" + mode + "»" + (typedModel != null ? typedModel.getName() : name);
	}
}
