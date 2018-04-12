/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

/**
 * Element2MiddleProperty defines the requirements on a future signature or trace property.
 * Derived classes support different kinds of Element.
 */
public abstract class Element2MiddleProperty implements Nameable
{
	/**
	 * The future trace class.
	 */
	protected final @NonNull RuleAnalysis2MiddleType relation2middleType;

	/**
	 * The preferred name for the trace property. A numeric suffix may be appended to the hint
	 * to avoid name clashes.
	 */
	protected final @NonNull String nameHint;

	/**
	 * The type the trace property.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class type;

	/**
	 * The isRequired the trace property.
	 */
	protected final boolean isRequired;

	/**
	 * The lazily created trace property.
	 */
	private @Nullable Property traceProperty;

	protected Element2MiddleProperty(@NonNull RuleAnalysis2MiddleType relation2middleType, @NonNull String nameHint, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired) {
		this.relation2middleType = relation2middleType;
		this.nameHint = nameHint;
		this.type = type;
		this.isRequired = isRequired;
	}

	protected abstract @NonNull Property createTraceProperty();

	protected @NonNull Property createMiddleProperty(@Nullable TypedModel typedModel, @NonNull String nameHint, boolean unitOpposite) {
		if (relation2middleType.getTransformation2TracePackage().isFrozen()) {
			throw new IllegalStateException("Creating " + nameHint + " after trace package frozen.");
		}
		org.eclipse.ocl.pivot.Class traceClass = relation2middleType.getMiddleClass();
		String domainName;
		if (typedModel != null) {
			domainName = typedModel.getName();
		}
		else {
			domainName = null;
		}
		String name = relation2middleType.getUniquePropertyName(this, nameHint);
		Property property = PivotFactory.eINSTANCE.createProperty();
		property.setName(name);
		property.setType(type);
		property.setIsRequired(isRequired);
		if ((type instanceof DataType) && !((DataType)type).isIsSerializable()) {
			property.setIsTransient(true);
		}
		if (domainName != null) {
			Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
			Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
			domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
			domainDetail.getValues().add(domainName);
			domainAnnotation.getOwnedDetails().add(domainDetail);
			property.getOwnedAnnotations().add(domainAnnotation);
		}
		property.setOwningClass(traceClass);
		org.eclipse.ocl.pivot.Class oppositeType = type;
		if (oppositeType instanceof CollectionType) {
			Type elementType = ((CollectionType)oppositeType).getElementType();
			if (elementType instanceof org.eclipse.ocl.pivot.Class) {
				oppositeType = (org.eclipse.ocl.pivot.Class)elementType;
			}
		}
		if (!(oppositeType instanceof DataType)) {
			Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
			oppositeProperty.setName(traceClass.getName());
			oppositeProperty.setType(unitOpposite ? traceClass : relation2middleType.getBagOfMiddleClass());
			oppositeProperty.setIsRequired(!unitOpposite);
			oppositeProperty.setIsImplicit(true);
			oppositeProperty.setOwningClass(oppositeType);
			property.setOpposite(oppositeProperty);
			oppositeProperty.setOpposite(property);
			//				putTrace(oppositeProperty, type);
		}
		//			putTrace(traceProperty, traceClass);
		return property;
	}

	public @NonNull Property getTraceProperty() {
		Property traceProperty2 = traceProperty;
		if (traceProperty2 == null) {
			traceProperty = traceProperty2 = createTraceProperty();
		}
		return traceProperty2;
	}

	@Override
	public @NonNull String getName() {
		return nameHint;
	}

	public @NonNull Property synthesizeTraceModel() {
		return getTraceProperty();
	}

	@Override
	public String toString() {
		return nameHint + ":" + type + (isRequired? "[1]" : "[?]");
	}
}