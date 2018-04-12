/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

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

	public RelationalTransformationAnalysis2TracePackage(@NonNull QVTrelationScheduleManager scheduleManager, @NonNull TransformationAnalysis transformationAnalysis) {
		super(scheduleManager, transformationAnalysis);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getDispatchClass() {
		org.eclipse.ocl.pivot.Class dispatchClass2 = dispatchClass;
		if (dispatchClass2 == null) {
			EnvironmentFactory environmentFactory = scheduleManager.getEnvironmentFactory();
			EPackage traceEPackage = getTraceEPackage();
			EClass dispatchEClass = (EClass) traceEPackage.getEClassifier(QVTtracePackage.Literals.DISPATCH.getName());
			dispatchClass2 = environmentFactory.getMetamodelManager().getASOfEcore(org.eclipse.ocl.pivot.Class.class, dispatchEClass);
			assert dispatchClass2 != null;
			dispatchClass = dispatchClass2;
		}
		return dispatchClass2;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getExecutionClass() {
		org.eclipse.ocl.pivot.Class executionClass2 = executionClass;
		if (executionClass2 == null) {
			EnvironmentFactory environmentFactory = scheduleManager.getEnvironmentFactory();
			EPackage traceEPackage = getTraceEPackage();
			EClass traceEClass = (EClass) traceEPackage.getEClassifier(QVTtracePackage.Literals.EXECUTION.getName());
			executionClass2 = environmentFactory.getMetamodelManager().getASOfEcore(org.eclipse.ocl.pivot.Class.class, traceEClass);
			assert executionClass2 != null;
			executionClass = executionClass2;
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
			URI traceURI = URI.createPlatformResourceURI(AbstractTransformer.TRACE_MODEL, true);
			Resource resource = environmentFactory.getResourceSet().getResource(traceURI, true);
			traceEPackage2 = (EPackage) resource.getContents().get(0);
			assert traceEPackage2 != null;
			this.traceEPackage = traceEPackage2;
		}
		return traceEPackage2;
	}
}
