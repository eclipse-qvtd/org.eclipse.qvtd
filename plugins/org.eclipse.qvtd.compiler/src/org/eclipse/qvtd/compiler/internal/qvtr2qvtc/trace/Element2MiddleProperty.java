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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

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
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

/**
 * Element2MiddleProperty defines the requirements on a future signature or trace property.
 * Derived classes support different kinds of Element.
 */
public abstract class Element2MiddleProperty implements Nameable
{
	/**
	 * The future trace class.
	 */
	protected final @NonNull Relation2MiddleClass relation2middleClass;

	/**
	 * The unique name for the middle property.
	 */
	protected final @NonNull String name;

	/**
	 * The type the middle property.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class type;

	/**
	 * The isRequired the middle property.
	 */
	protected final boolean isRequired;

	/**
	 * The lazily created middle property.
	 */
	private @Nullable Property middleProperty;

	protected Element2MiddleProperty(@NonNull Relation2MiddleClass relation2middleClass, @NonNull String name, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired) {
		this.relation2middleClass = relation2middleClass;
		this.name = relation2middleClass.getUniquePropertyName(this, name);
		this.type = type;
		this.isRequired = isRequired;
	}

	protected abstract @NonNull Property createMiddleProperty();

	protected @NonNull Property createMiddleProperty(@Nullable TypedModel rTypedModel, boolean unitOpposite) {
		org.eclipse.ocl.pivot.Class middleClass = relation2middleClass.getMiddleClass();
		String domainName = rTypedModel != null ? rTypedModel.getName() : null;
		Property property = PivotFactory.eINSTANCE.createProperty();
		property.setName(name);
		property.setType(type);
		property.setIsRequired(isRequired);
		if (domainName != null) {
			Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
			Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
			domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
			domainDetail.getValues().add(domainName);
			domainAnnotation.getOwnedDetails().add(domainDetail);
			property.getOwnedAnnotations().add(domainAnnotation);
		}
		property.setOwningClass(middleClass);
		org.eclipse.ocl.pivot.Class oppositeType = type;
		if (oppositeType instanceof CollectionType) {
			Type elementType = ((CollectionType)oppositeType).getElementType();
			if (elementType instanceof org.eclipse.ocl.pivot.Class) {
				oppositeType = (org.eclipse.ocl.pivot.Class)elementType;
			}
		}
		if (!(oppositeType instanceof DataType)) {
			Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
			oppositeProperty.setName(middleClass.getName());
			oppositeProperty.setType(unitOpposite ? middleClass : relation2middleClass.getBagOfMiddleClass());
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

	public @NonNull Property getMiddleProperty() {
		Property middleProperty2 = middleProperty;
		if (middleProperty2 == null) {
			middleProperty = middleProperty2 = createMiddleProperty();
		}
		return middleProperty2;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ":" + type + (isRequired? "[1]" : "[?]");
	}
}