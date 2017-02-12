/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.IndexableIterable;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * OperationDatum provides a hashed list of ClassDatums suitable for characterizing a specialized OperationRegion.
 * OperationDatums are suitable for use when indexing operation overloads.
 */
public class OperationDatum implements IndexableIterable<@NonNull ClassDatum>
{
	protected class Iterator implements java.util.Iterator<@NonNull ClassDatum>
	{
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < classDatums.length;
		}

		@Override
		public @NonNull ClassDatum next() {
			return classDatums[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private final @NonNull Integer hashCode;
	private final @NonNull String name;
	private final @NonNull ClassDatum @NonNull [] classDatums;

	/**
	 * Construct an OperationDatum for an Scheduler that has computed the hashCode for the classDatums.
	 */
	public OperationDatum(@NonNull QVTp2QVTs scheduler, @NonNull String name, @NonNull ClassDatum @NonNull [] classDatums) {
		int hashCode = name.hashCode();
		for (@NonNull ClassDatum classDatum : classDatums) {
			hashCode = 3 * hashCode + classDatum.hashCode();
		}
		this.hashCode = hashCode;
		this.name = name;
		this.classDatums = classDatums;
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof OperationDatum)) {
			return false;
		}
		OperationDatum that = (OperationDatum)obj;
		if (!this.name.equals(that.name)) {
			return false;
		}
		if (this.classDatums.length != that.classDatums.length) {
			return false;
		}
		for (int i = 0; i < classDatums.length; i++) {
			if (!this.classDatums[i].equals(that.classDatums[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull ClassDatum get(int index) {
		ClassDatum parameterType = classDatums[index];
		assert parameterType != null;
		return parameterType;
	}

	public @NonNull ClassDatum @NonNull [] get() {
		return classDatums;
	}


	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public java.util.@NonNull Iterator<@NonNull ClassDatum> iterator() {
		return new Iterator();
	}

	@Override
	public int size() {
		return classDatums.length;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append('(');
		for (int i = 0; i < classDatums.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			ClassDatum classDatum = classDatums[i];
			s.append(classDatum.toString());
		}
		s.append(')');
		return s.toString();
	}
}