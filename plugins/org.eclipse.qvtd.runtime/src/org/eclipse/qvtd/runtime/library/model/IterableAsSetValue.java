/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.library.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.internal.values.ValueImpl;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;

import com.google.common.collect.Iterables;

/**
 * This wrapper makes an Iterable appear to be a SetValue. It only has enough functionality to
 * allow a ModelObjectsOfKindOperation return to satisfy the SetValue return.
 */
class IterableAsSetValue extends ValueImpl implements SetValue
{
	protected final @NonNull CollectionTypeId typeId;
	protected final @NonNull Iterable<@Nullable Object> iterable;

	public IterableAsSetValue(@NonNull CollectionTypeId typeId, @NonNull Iterable<@Nullable Object> iterable) {
		this.typeId = typeId;
		this.iterable = iterable;
	}

	@Override
	public @NonNull Collection<@Nullable Object> asCollection() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		return this;
	}

	@Override
	public @Nullable List<@Nullable Object> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T1> @Nullable List<T1> asEcoreObjects(@NonNull IdResolver idResolver, @Nullable Class<T1> instanceClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Object asObject() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull SetValue asSetValue() {
		return this;
	}

	@Override
	public @NonNull IntegerValue count(@Nullable Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Boolean excludes(@Nullable Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Boolean excludesAll(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue excluding(@Nullable Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue excludingAll(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue flatten() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Collection<@Nullable Object> getElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getKind() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return typeId;
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException();
		//		return iterable.hashCode();
	}

	@Override
	public @NonNull Boolean includes(@Nullable Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Boolean includesAll(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue including(@Nullable Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue includingAll(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int intSize() {
		return Iterables.size(iterable);
	}

	@Override
	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Boolean isEmpty() {
		return Iterables.isEmpty(iterable);
	}

	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	@Override
	public @NonNull Iterator<@Nullable Object> iterator() {
		return iterable.iterator();
	}

	@Override
	public @NonNull UniqueCollectionValue minus(@NonNull UniqueCollectionValue set) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@Nullable Object> iterable() {
		return iterable;
	}

	@Override
	public @NonNull Boolean notEmpty() {
		return !Iterables.isEmpty(iterable);
	}

	@Override
	public @Nullable Set<@NonNull TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull IntegerValue size() {
		return ValueUtil.integerValueOf(intSize());
	}

	@Override
	public @NonNull OrderedCollectionValue sort(@NonNull Comparator<@Nullable Object> comparator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull UniqueCollectionValue symmetricDifference(@NonNull UniqueCollectionValue set) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable SequenceValue toSequenceValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CollectionValue union(@NonNull CollectionValue c) {
		throw new UnsupportedOperationException();
	}
}