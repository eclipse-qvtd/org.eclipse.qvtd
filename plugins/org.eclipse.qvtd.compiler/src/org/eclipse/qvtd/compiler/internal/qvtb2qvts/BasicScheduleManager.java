/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public abstract class BasicScheduleManager extends AbstractScheduleManager
{
	protected final @NonNull NameGenerator nameGenerator;
	protected final @NonNull DatumCaches datumCaches;

	private @Nullable ClassDatum booleanClassDatum;
	private @Nullable ClassDatum oclVoidClassDatum;

	/**
	 * The extended analysis of each ClassDatum.
	 */
	private final @NonNull Set<@NonNull ClassDatum> classDatums = new HashSet<>();

	/**
	 * Property used as a navigation to cast to a specific type.
	 */
	//	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<>();

	/**
	 * Property used as a navigation to iterate collection elements.
	 */
	private final @NonNull Map<Type, Property> type2iterateProperty = new HashMap<>();

	private final @NonNull Map<@NonNull Transformation, @NonNull Transformation2TracePackage> transformation2transformation2TracePackage = new HashMap<>();

	protected BasicScheduleManager(@NonNull ScheduleModel scheduleModel, @NonNull EnvironmentFactory environmentFactory,
			@NonNull Transformation transformation, @NonNull ProblemHandler problemHandler, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		this(scheduleModel, environmentFactory, transformation, problemHandler, schedulerOptions, null, null, null);
	}

	protected BasicScheduleManager(@NonNull ScheduleModel scheduleModel, @NonNull EnvironmentFactory environmentFactory,
			@NonNull Transformation transformation, @NonNull ProblemHandler problemHandler, CompilerOptions.@Nullable StepOptions schedulerOptions,
			@Nullable NameGenerator nameGenerator, @Nullable DatumCaches datumCaches, @Nullable RootDomainUsageAnalysis domainUsageAnalysis) {
		super(scheduleModel, environmentFactory, transformation, problemHandler, schedulerOptions, domainUsageAnalysis);
		this.nameGenerator = nameGenerator != null ? nameGenerator : createNameGenerator();
		this.datumCaches = datumCaches != null ? datumCaches : new DatumCaches(this);
	}

	@Override
	public void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage) {
		//		domainUsageAnalysis.analyzeTracePackage(typedModel, tracePackage);
		datumCaches.analyzeCompletePackage(typedModel, completePackage);
	}

	@Override
	public void analyzeTracePackage(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {
		domainUsageAnalysis.analyzeTracePackage(typedModel, tracePackage);
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		CompletePackage completePackage = completeModel.getCompletePackage(tracePackage);
		datumCaches.analyzeCompletePackage(typedModel, completePackage);
	}

	@Override
	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum) {
		return datumCaches.getAllPropertyDatums(classDatum);
	}

	@Override
	public @NonNull ClassDatum getBooleanClassDatum() {
		ClassDatum booleanClassDatum2 = booleanClassDatum;
		if (booleanClassDatum2 == null) {
			TypedModel primitiveTypedModel = domainUsageAnalysis.getPrimitiveTypedModel();
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			booleanClassDatum = booleanClassDatum2 = getClassDatum(primitiveTypedModel, standardLibrary.getBooleanType());
		}
		return booleanClassDatum2;
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		return datumCaches.getClassDatum(typedModel, completeClass);
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull Iterable<@NonNull CompleteClass> completeClasses) {
		int size = Iterables.size(completeClasses);
		if (size == 1) {
			return datumCaches.getClassDatum(typedModel, completeClasses.iterator().next());
		}
		else {
			return datumCaches.getClassDatum(typedModel, Sets.newHashSet(completeClasses));
		}
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)asTypedElement.getType();
		assert asType != null;
		Type elementType = PivotUtil.getElementalType(asType);
		TypedModel typedModel;
		if (elementType instanceof DataType) {
			typedModel = getDomainUsageAnalysis().getPrimitiveTypedModel();
		}
		else {
			DomainUsage domainUsage = getDomainUsage(asTypedElement);
			assert domainUsage != null;
			typedModel = domainUsage.getTypedModel(asTypedElement);
			assert typedModel != null;
		}
		return datumCaches.getClassDatum(typedModel, asType);
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull Type asType) {
		return datumCaches.getClassDatum(typedModel, asType);
	}

	@Override
	public @NonNull Iterable<@NonNull ClassDatum> getClassDatums() {
		return classDatums;
	}

	@Override
	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return datumCaches.getContainmentAnalysis();
	}

	@Override
	public @NonNull ClassDatum getElementalTargetClassDatum(@NonNull PropertyDatum propertyDatum) {
		return datumCaches.getElementalTargetClassDatum(propertyDatum);
	}

	@Override
	public @NonNull Property getIterateProperty(@NonNull Type type) {
		Property iterateProperty = type2iterateProperty.get(type);
		if (iterateProperty == null) {
			iterateProperty = createProperty("«iterate»", type, true);
			type2iterateProperty.put(type, iterateProperty);
		}
		return iterateProperty;
	}

	@Override
	public @NonNull NameGenerator getNameGenerator() {
		return nameGenerator;
	}

	//	@Override
	//	public @NonNull Iterable<@NonNull PropertyDatum> getOclContainerPropertyDatums(@NonNull ClassDatum classDatum) {
	//		return datumCaches.getOclContainerPropertyDatums(classDatum);
	//	}

	@Override
	public @NonNull ClassDatum getOclVoidClassDatum() {
		ClassDatum oclVoidClassDatum2 = oclVoidClassDatum;
		if (oclVoidClassDatum2 == null) {
			TypedModel primitiveTypedModel = domainUsageAnalysis.getPrimitiveTypedModel();
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			oclVoidClassDatum = oclVoidClassDatum2 = getClassDatum(primitiveTypedModel, standardLibrary.getOclVoidType());
		}
		return oclVoidClassDatum2;
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum sourceClassDatum, @NonNull Property property, @Nullable ClassDatum targetClassDatum) {
		return datumCaches.getPropertyDatum(sourceClassDatum, property, targetClassDatum);
	}

	@Override
	public @NonNull Iterable<@NonNull PropertyDatum> getPropertyDatums(@NonNull NavigationEdge navigationEdge) {
		Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
		if (property == standardLibraryHelper.getOclContainerProperty()) {
			Node targetNode = QVTscheduleUtil.getSourceNode(navigationEdge);
			Node castTarget = targetNode;
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
			return datumCaches.getOclContainerPropertyDatums(classDatum);
		}
		else {
			return Collections.singletonList(getPropertyDatum(navigationEdge));
		}
	}

	@Override
	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {
		return datumCaches.getSuccessPropertyDatum(successProperty);
	}

	@Override
	public @NonNull Transformation2TracePackage getTransformation2TracePackage(@NonNull Transformation transformation) {
		Transformation2TracePackage transformation2TracePackage = transformation2transformation2TracePackage.get(transformation);
		if (transformation2TracePackage == null) {
			transformation2TracePackage = createTransformation2TracePackage(transformation);
			transformation2transformation2TracePackage.put(transformation, transformation2TracePackage);
		}
		return transformation2TracePackage;
	}
}