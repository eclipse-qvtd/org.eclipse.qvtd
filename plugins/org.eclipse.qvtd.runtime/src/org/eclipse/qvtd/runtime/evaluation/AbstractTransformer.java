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


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractTransformerInternal;

/**
 * The abstract implementation of an auto-generated transformation provides the mandatory shared functionality for maintaining
 * models and deferring invocation of not-ready mapping invocations.
 */
public abstract class AbstractTransformer extends AbstractTransformerInternal
{
	public static abstract class Incremental extends AbstractTransformerInternal.Incremental
	{
		protected Incremental(@NonNull TransformationExecutor executor, @NonNull String @NonNull [] modelNames,
				@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
			super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes) ;
		}
	}

	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.runtime";
	public static final @NonNull TracingOption APPENDS = new TracingOption(PLUGIN_ID, "tx/appends");
	public static final @NonNull TracingOption CONSUMES = new TracingOption(PLUGIN_ID, "tx/consumes");
	public static final @NonNull TracingOption CONTAINMENTS = new TracingOption(PLUGIN_ID, "tx/containments");
	public static final @NonNull TracingOption EXCEPTIONS = new TracingOption(PLUGIN_ID, "tx/exceptions");
	public static final @NonNull TracingOption INVOCATIONS = new TracingOption(PLUGIN_ID, "tx/invocations");

	protected AbstractTransformer(@NonNull TransformationExecutor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes) ;
	}
}
