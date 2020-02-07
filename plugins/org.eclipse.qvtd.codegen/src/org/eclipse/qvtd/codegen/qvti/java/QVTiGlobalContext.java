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
package org.eclipse.qvtd.codegen.qvti.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.pivot.Property;

/**
 * A QVTiGlobalContext maintains the Java-specific global context for generation of QVTi code.
 */
public class QVTiGlobalContext extends JavaGlobalContext<@NonNull QVTiCodeGenerator>
{
	public static final @NonNull String CONSTRUCTOR_NAME = "constructor";
	public static final @NonNull String CREATE_FROM_STRING_NAME = "createFromString";
	public static final @NonNull String EMPTY_LIST_NAME = "emptyList";
	public static final @NonNull String GET_SPECULATING_SLOT_STATE_NAME = "getSpeculatingSlotState";
	public static final @NonNull String GET_STATUS_NAME = "getStatus";
	public static final @NonNull String GET_TRANSFORMATION_EXECUTION_NAME = "getTransformationExecution";
	public static final @NonNull String INPUT_SPECULATING_SLOT_STATE_NAME = "inputSpeculatingSlotState";
	public static final @NonNull String INPUT_SPECULATING_SLOT_STATUS_NAME = "inputSpeculatingSlotStatus";
	public static final @NonNull String INVOCATION_HASH_CODE_NAME = "invocationHashCode";
	public static final @NonNull String MODELS_NAME = "models";
	public static final @NonNull String NEEDS_SPECULATION_NAME = "needsSpeculation";
	public static final @NonNull String OBJECT_MANAGER_NAME = "objectManager";
	public static final @NonNull String OUTPUT_SPECULATING_SLOT_STATE_NAME = "outputSpeculatingSlotState";
	public static final @NonNull String OUTPUT_SPECULATING_SLOT_STATUS_NAME = "outputSpeculatingSlotStatus";
	public static final @NonNull String TRANSFORMATION_EXECUTION_NAME = "transformationExecution";

	/**
	 * Map from an oppositeProperty that requites a cache to the global name of that cache.
	 */
	private /*@LazyNonNull*/ Map<@NonNull Property, @NonNull String> oppositeProperty2oppositeCacheName = null;

	public QVTiGlobalContext(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager.reserveName(JavaConstants.EXECUTOR_NAME, null);
		nameManager.reserveName(JavaConstants.EVALUATION_CACHE_NAME, null);
		nameManager.reserveName(CONSTRUCTOR_NAME, null);
		nameManager.reserveName(CREATE_FROM_STRING_NAME, null);
		nameManager.reserveName(EMPTY_LIST_NAME, null);
		nameManager.reserveName(GET_SPECULATING_SLOT_STATE_NAME, null);
		nameManager.reserveName(GET_STATUS_NAME, null);
		nameManager.reserveName(GET_TRANSFORMATION_EXECUTION_NAME, null);
		nameManager.reserveName(INPUT_SPECULATING_SLOT_STATE_NAME, null);
		nameManager.reserveName(INPUT_SPECULATING_SLOT_STATUS_NAME, null);
		nameManager.reserveName(INVOCATION_HASH_CODE_NAME, null);
		nameManager.reserveName(MODELS_NAME, null);
		nameManager.reserveName(NEEDS_SPECULATION_NAME, null);
		nameManager.reserveName(OBJECT_MANAGER_NAME, null);
		nameManager.reserveName(OUTPUT_SPECULATING_SLOT_STATE_NAME, null);
		nameManager.reserveName(OUTPUT_SPECULATING_SLOT_STATUS_NAME, null);
		nameManager.reserveName(TRANSFORMATION_EXECUTION_NAME, null);
	}

	public @NonNull String addOppositeProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isIsImplicit() && !pivotProperty.isIsComposite();
		if (oppositeProperty2oppositeCacheName == null) {
			oppositeProperty2oppositeCacheName = new HashMap<@NonNull Property, @NonNull String>();
		}
		if (!oppositeProperty2oppositeCacheName.containsKey(pivotProperty)) {
			oppositeProperty2oppositeCacheName.put(pivotProperty, nameManager.getGlobalSymbolName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()));
		}
		String name = oppositeProperty2oppositeCacheName.get(pivotProperty);
		assert name != null;
		return name;
	}

	@Override
	protected @NonNull QVTiLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new QVTiLocalContext(this, cgScope);
	}

	public @Nullable Map<@NonNull Property, @NonNull String> getOppositeProperties() {
		return oppositeProperty2oppositeCacheName;
	}
}
