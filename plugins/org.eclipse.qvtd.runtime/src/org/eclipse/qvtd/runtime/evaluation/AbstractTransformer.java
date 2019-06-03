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


import org.eclipse.emf.common.util.URI;
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
	public static final @NonNull String TRACE_MODEL = "org.eclipse.qvtd.runtime/model/QVTtrace.ecore";
	public static final @NonNull URI TRACE_MODEL_URI = URI.createPlatformResourceURI(TRACE_MODEL, true);
	public static final @NonNull String TRACE_GENMODEL = "org.eclipse.qvtd.runtime/model/QVTtrace.genmodel";
	public static final @NonNull String TRACE_GENMODEL_FRAGMENT = "//qvttrace";
	public static final @NonNull String QVTLIB_GENMODEL = "org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.genmodel";
	public static final @NonNull String QVTLIB_GENMODEL_FRAGMENT = "//qvtruntimelibrary";
	public static final @NonNull String OCLLIB_GENMODEL = "org.eclipse.ocl.pivot/model/oclstdlib.genmodel";
	public static final @NonNull String OCLLIB_GENMODEL_FRAGMENT = "//oclstdlib";

	public static final @NonNull TracingOption APPENDS = new TracingOption(PLUGIN_ID, "tx/appends");
	public static final @NonNull TracingOption ASSIGNMENTS = new TracingOption(PLUGIN_ID, "tx/assignments");
	public static final @NonNull TracingOption BLOCKS = new TracingOption(PLUGIN_ID, "tx/blocks");
	public static final @NonNull TracingOption CONSUMES = new TracingOption(PLUGIN_ID, "tx/consumes");
	public static final @NonNull TracingOption CONTAINMENTS = new TracingOption(PLUGIN_ID, "tx/containments");
	public static final @NonNull TracingOption CREATIONS = new TracingOption(PLUGIN_ID, "tx/creations");
	public static final @NonNull TracingOption EXCEPTIONS = new TracingOption(PLUGIN_ID, "tx/exceptions");
	public static final @NonNull TracingOption GETTINGS = new TracingOption(PLUGIN_ID, "tx/gettings");
	public static final @NonNull TracingOption INVOCATIONS = new TracingOption(PLUGIN_ID, "tx/invocations");

	protected AbstractTransformer(@NonNull TransformationExecutor executor, @NonNull String @NonNull [] modelNames,
			@NonNull PropertyId @Nullable [] propertyIndex2propertyId, @NonNull ClassId @NonNull [] classIndex2classId, int @Nullable [] @NonNull [] classIndex2allClassIndexes) {
		super(executor, modelNames, propertyIndex2propertyId, classIndex2classId, classIndex2allClassIndexes) ;
	}
}
