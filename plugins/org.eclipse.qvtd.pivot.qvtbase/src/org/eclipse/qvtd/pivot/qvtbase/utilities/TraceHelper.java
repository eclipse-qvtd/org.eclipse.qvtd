/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory.EnvironmentFactoryExtension2;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * TraceHelper provides helper routines to assist in use of the QVTtrace Metamodel.
 */
public class TraceHelper
{
	protected final @NonNull EnvironmentFactoryExtension2 environmentFactory;
	private org.eclipse.ocl.pivot.@Nullable Package tracePackage = null;
	private org.eclipse.ocl.pivot.@Nullable Class dispatchClass = null;
	private org.eclipse.ocl.pivot.@Nullable Class executionClass = null;
	private org.eclipse.ocl.pivot.@Nullable Class traceElementClass = null;

	public TraceHelper(@NonNull EnvironmentFactory environmentFactory) {
		this.environmentFactory = (EnvironmentFactoryExtension2) environmentFactory;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getDispatchClass() {
		org.eclipse.ocl.pivot.Class dispatchClass2 = dispatchClass;
		if (dispatchClass2 == null) {
			String className = QVTtracePackage.Literals.DISPATCH.getName();
			Iterable<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = PivotUtil.getOwnedClasses(getTracePackage());
			dispatchClass = dispatchClass2 = ClassUtil.nonNullState(NameUtil.getNameable(ownedClasses, className));
		}
		return dispatchClass2;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getExecutionClass() {
		org.eclipse.ocl.pivot.Class executionClass2 = executionClass;
		if (executionClass2 == null) {
			String className = QVTtracePackage.Literals.EXECUTION.getName();
			Iterable<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = PivotUtil.getOwnedClasses(getTracePackage());
			executionClass = executionClass2 = ClassUtil.nonNullState(NameUtil.getNameable(ownedClasses, className));
		}
		return executionClass2;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceElementClass() {
		org.eclipse.ocl.pivot.Class traceElementClass2 = traceElementClass;
		if (traceElementClass2 == null) {
			String className = QVTtracePackage.Literals.TRACE_ELEMENT.getName();
			Iterable<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = PivotUtil.getOwnedClasses(getTracePackage());
			traceElementClass = traceElementClass2 = ClassUtil.nonNullState(NameUtil.getNameable(ownedClasses, className));
		}
		return traceElementClass2;
	}

	public org.eclipse.ocl.pivot.@NonNull Package getTracePackage() {
		org.eclipse.ocl.pivot.@Nullable Package tracePackage2 = tracePackage;
		if (tracePackage2 == null) {
			//
			//	NB See Bug 532561, we must not load a generated version of QVTtrace.ecore to avoid
			//	dynamic-extends-generated hazards for interpreted execution. For compiled execution
			//	the QVTtrace.ecore references resolve to generated eventually anyway.
			//
			Resource traceResource = environmentFactory.getResourceSet().getResource(AbstractTransformer.TRACE_MODEL_URI, true);
			if ((traceResource == null) || !(traceResource.getErrors().isEmpty()) || (traceResource.getContents().size() != 1)) {
				throw new IllegalTraceException("Failed to load '" + AbstractTransformer.TRACE_MODEL_URI + "'");
			}
			EPackage traceEPackage = (EPackage) traceResource.getContents().get(0);
			try {
				tracePackage = tracePackage2 = environmentFactory.getASOf(org.eclipse.ocl.pivot.Package.class, traceEPackage);
			} catch (Throwable e) {
				throw new IllegalTraceException("Failed to create Pivot version of '" + AbstractTransformer.TRACE_MODEL_URI + "'", e);
			}
			if (tracePackage2 ==  null) {
				throw new IllegalTraceException("Failed to create Pivot version of '" + AbstractTransformer.TRACE_MODEL_URI + "'");
			}
		}
		return tracePackage2;
	}
}