/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.runtime.model.QVTruntimeLibrary;

public class QVTruntimeLibraryHelper
{
	private final @NonNull Operation collectionOperation;
	//	private final @NonNull Parameter collectionItemsParameter;		-- CollectionPartEdge distinguishes
	private final @NonNull Operation errorOperation;
	private final @NonNull Parameter errorElementsParameter;
	private final @NonNull Operation ifOperation;
	private final @NonNull Parameter ifConditionParameter;
	private final @NonNull Parameter ifThenParameter;
	private final @NonNull Parameter ifElseParameter;
	private final @NonNull Parameter loopBodyParameter;
	private final @NonNull Parameter loopIteratorsParameter;
	private final @NonNull Parameter loopSourceParameter;
	private final @NonNull Operation loopOperation;
	private final @NonNull Operation mapOperation;
	private final @NonNull Operation mapPartOperation;
	private final @NonNull Parameter mapPartKeyParameter;
	private final @NonNull Parameter mapPartValueParameter;
	private final @NonNull Operation rangeOperation;
	private final @NonNull Parameter rangeFirstParameter;
	private final @NonNull Parameter rangeLastParameter;
	private final @NonNull Operation shadowOperation;
	private final @NonNull Operation tupleOperation;
	private final @NonNull Operation typeOperation;

	public QVTruntimeLibraryHelper() {
		Model libModel = QVTruntimeLibrary.getDefaultModel();
		org.eclipse.ocl.pivot.Package libPackage = ClassUtil.nonNullState(NameUtil.getNameable(libModel.getOwnedPackages(), "qvtruntimelibrary"));
		org.eclipse.ocl.pivot.Class libClass = ClassUtil.nonNullState(NameUtil.getNameable(libPackage.getOwnedClasses(), "PseudoOperations"));
		Iterable<@NonNull Operation> ownedOperations = PivotUtil.getOwnedOperations(libClass);
		this.collectionOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "collection"));
		//	this.collectionItemsParameter = PivotUtil.getOwnedParameter(collectionOperation, 0);
		this.errorOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "error"));
		this.errorElementsParameter = PivotUtil.getOwnedParameter(errorOperation, 0);
		this.ifOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "if"));
		this.ifConditionParameter = PivotUtil.getOwnedParameter(ifOperation, 0);
		this.ifThenParameter = PivotUtil.getOwnedParameter(ifOperation, 1);
		this.ifElseParameter = PivotUtil.getOwnedParameter(ifOperation, 2);
		this.loopOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "loop"));
		this.loopSourceParameter = PivotUtil.getOwnedParameter(loopOperation, 0);
		this.loopIteratorsParameter = PivotUtil.getOwnedParameter(loopOperation, 1);
		this.loopBodyParameter = PivotUtil.getOwnedParameter(loopOperation, 2);
		this.mapOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "map"));
		this.mapPartOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "mapPart"));
		this.mapPartKeyParameter = PivotUtil.getOwnedParameter(mapPartOperation, 0);
		this.mapPartValueParameter = PivotUtil.getOwnedParameter(mapPartOperation, 1);
		this.rangeOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "range"));
		this.rangeFirstParameter = PivotUtil.getOwnedParameter(rangeOperation, 0);
		this.rangeLastParameter = PivotUtil.getOwnedParameter(rangeOperation, 1);
		this.shadowOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "shadow"));
		this.tupleOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "tuple"));
		this.typeOperation = ClassUtil.nonNullState(NameUtil.getNameable(ownedOperations, "type"));
	}

	//	public @NonNull Parameter getCollectionItemsParameter() {
	//		return collectionItemsParameter;
	//	}

	public @NonNull Operation getCollectionOperation() {
		return collectionOperation;
	}

	public @NonNull Parameter getErrorElementsParameter() {
		return errorElementsParameter;
	}

	public @NonNull Operation getErrorOperation() {
		return errorOperation;
	}

	public @NonNull Parameter getIfConditionParameter() {
		return ifConditionParameter;
	}

	public @NonNull Parameter getIfElseParameter() {
		return ifElseParameter;
	}

	public @NonNull Operation getIfOperation() {
		return ifOperation;
	}

	public @NonNull Parameter getIfThenParameter() {
		return ifThenParameter;
	}

	public @NonNull Parameter getLoopBodyParameter() {
		return loopBodyParameter;
	}

	public @NonNull Parameter getLoopIteratorsParameter() {
		return loopIteratorsParameter;
	}

	public @NonNull Parameter getLoopSourceParameter() {
		return loopSourceParameter;
	}

	public @NonNull Operation getMapOperation() {
		return mapOperation;
	}

	public @NonNull Operation getMapPartOperation() {
		return mapPartOperation;
	}

	public @NonNull Parameter getMapPartKeyParameter() {
		return mapPartKeyParameter;
	}

	public @NonNull Parameter getMapPartValueParameter() {
		return mapPartValueParameter;
	}

	public @NonNull Parameter getRangeFirstParameter() {
		return rangeFirstParameter;
	}

	public @NonNull Parameter getRangeLastParameter() {
		return rangeLastParameter;
	}

	public @NonNull Operation getRangeOperation() {
		return rangeOperation;
	}

	public @NonNull Operation getShadowOperation() {
		return shadowOperation;
	}

	public @NonNull Operation getTupleOperation() {
		return tupleOperation;
	}

	public @NonNull Operation getTypeOperation() {
		return typeOperation;
	}
}