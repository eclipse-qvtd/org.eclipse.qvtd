/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * StandardLibraryHelper provides helper routines to assist in use of the StandardLibrary.
 *
 * FIXME promote to Pivot
 */
public class StandardLibraryHelper
{
	protected final @NonNull StandardLibrary standardLibrary;

	private final @NonNull OperationId collectionSelectByKindId;
	private final @NonNull OperationId oclAnyEqualsId;
	private final @NonNull OperationId oclAnyOclAsSetId;
	private final @NonNull OperationId oclAnyOclAsTypeId;
	private final @NonNull OperationId oclAnyOclIsKindOfId;
	private final @NonNull Property oclContainerProperty;
	private final @NonNull OperationId oclElementOclContainerId;

	public StandardLibraryHelper(@NonNull StandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
		org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
		org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
		Operation operation1 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
		assert operation1 != null;
		oclAnyEqualsId = operation1.getOperationId();
		Operation operation2 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclAsType");
		assert operation2 != null;
		oclAnyOclAsTypeId = operation2.getOperationId();
		Operation operation3 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclIsKindOf");
		assert operation3 != null;
		oclAnyOclIsKindOfId = operation3.getOperationId();
		Operation operation4 = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContainer");
		assert operation4 != null;
		oclElementOclContainerId = operation4.getOperationId();
		Operation operation5 = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "oclAsSet");
		assert operation5 != null;
		oclAnyOclAsSetId = operation5.getOperationId();
		Operation operation6 = NameUtil.getNameable(standardLibrary.getCollectionType().getOwnedOperations(), "selectByKind");
		assert operation6 != null;
		collectionSelectByKindId = operation6.getOperationId();
		//
		Property candidateOclContainerProperty = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContainer");
		assert candidateOclContainerProperty != null : "OCL Standard Librarty has no OclElement::oclContainer property";
		oclContainerProperty = candidateOclContainerProperty;
	}

	public @NonNull OperationId getCollectionSelectByKindId() {
		return collectionSelectByKindId;
	}

	public @NonNull OperationId getOclAnyEqualsId() {
		return oclAnyEqualsId;
	}

	public @NonNull OperationId getOclAnyOclAsSetId() {
		return oclAnyOclAsSetId;
	}

	public @NonNull OperationId getOclAnyOclAsTypeId() {
		return oclAnyOclAsTypeId;
	}

	public @NonNull OperationId getOclAnyOclIsKindOfId() {
		return oclAnyOclIsKindOfId;
	}

	public @NonNull Property getOclContainerProperty() {
		return oclContainerProperty;
	}

	public @NonNull OperationId getOclElementOclContainerId() {
		return oclElementOclContainerId;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}
}