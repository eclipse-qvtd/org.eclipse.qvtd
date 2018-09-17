/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;

public class RelationalTransformationAnalysis2TracePackage extends TransformationAnalysis2TracePackage
{
	/**
	 * Map of invocation to trace classes.
	 */
	//	protected final @NonNull Map<@NonNull RelationCallExp, @NonNull List<Relation2TraceClass.@NonNull Internal>> invocation2relation2traceClasses = new HashMap<>();
	private @Nullable EPackage traceEPackage;

	/**
	 * Lazily create AbstractDispatch class
	 */
	private org.eclipse.ocl.pivot.@Nullable Class dispatchClass = null;

	/**
	 * Lazily create AbstractTrace class
	 */
	private org.eclipse.ocl.pivot.@Nullable Class executionClass = null;

	public RelationalTransformationAnalysis2TracePackage(@NonNull QVTrelationScheduleManager scheduleManager, @NonNull AbstractTransformationAnalysis transformationAnalysis) {
		super(scheduleManager, transformationAnalysis);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getDispatchClass() {
		org.eclipse.ocl.pivot.Class dispatchClass2 = dispatchClass;
		if (dispatchClass2 == null) {
			TraceHelper traceHelper = scheduleManager.getTraceHelper();
			dispatchClass = dispatchClass2 = traceHelper.getDispatchClass();
		}
		return dispatchClass2;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getExecutionClass() {
		org.eclipse.ocl.pivot.Class executionClass2 = executionClass;
		if (executionClass2 == null) {
			TraceHelper traceHelper = scheduleManager.getTraceHelper();
			executionClass = executionClass2 = traceHelper.getExecutionClass();
		}
		return executionClass2;
	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator)super.getNameGenerator();
	}

	@Override
	public @NonNull RelationAnalysis2TraceGroup getRuleAnalysis2TraceGroup(@NonNull Rule rule) {
		return (RelationAnalysis2TraceGroup) super.getRuleAnalysis2TraceGroup(rule);
	}

	public @NonNull EPackage getTraceEPackage() {
		EPackage traceEPackage2 = traceEPackage;
		if (traceEPackage2 == null) {
			// FIXME ?? use QVTTracePackage.eINSTANCE if it is registered and ECLIPSE_IS_RUNNING
			EnvironmentFactory environmentFactory = scheduleManager.getEnvironmentFactory();
			URI traceURI = AbstractTransformer.TRACE_MODEL_URI;
			Resource resource = environmentFactory.getResourceSet().getResource(traceURI, true);
			traceEPackage2 = (EPackage) resource.getContents().get(0);
			assert traceEPackage2 != null;
			this.traceEPackage = traceEPackage2;
		}
		return traceEPackage2;
	}
}
