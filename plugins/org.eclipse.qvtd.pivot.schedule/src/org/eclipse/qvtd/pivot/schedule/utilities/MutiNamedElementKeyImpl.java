/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;

/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public class MutiNamedElementKeyImpl implements MultiValueKey<NamedElement, String>
{
	public static final @NonNull MultiValueKey<?, ?> EMPTY_LIST = new MutiNamedElementKeyImpl();
	
	private final @NonNull List<String> valueIds = new ArrayList<String>();
	private final @NonNull NamedElement[] values;

	private int hashCode;
	
	public MutiNamedElementKeyImpl(@NonNull NamedElement... values) {
		//this.parametersId = IdManager.getParametersId(parameterTypes);
		this.values = values;
		for (NamedElement v : values) {
			if (v != null) {
				valueIds.add(v.getName());
			} else {
				valueIds.add("null");
			}
		}
		hashCode = valueIds.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MutiNamedElementKeyImpl)) {
			return false;
		}
		MutiNamedElementKeyImpl that = (MutiNamedElementKeyImpl)obj;
		if (hashCode() != that.hashCode()) {
			return false;
		}
		NamedElement[] thoseValues = that.values;
		if (values.length != thoseValues.length) {
			return false;
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				if (!values[i].equals(thoseValues[i])) {
					return false;
				}
			} else {
				if (values[i] != thoseValues[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.schedule.utilities.MultiValueKey#get(int)
	 */
	@Override
	public @NonNull NamedElement get(int index) {
		NamedElement element = values[index];
		assert element != null;
		return element;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.schedule.utilities.MultiValueKey#get()
	 */
	@Override
	public @NonNull NamedElement[] get() {
		return values;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.schedule.utilities.MultiValueKey#getParameters()
	 */
	@Override
	public @NonNull List<String> getKeyIds() {
		return valueIds;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.schedule.utilities.MultiValueKey#size()
	 */
	@Override
	public int size() {
		return values.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		Iterator<String> it = valueIds.iterator();
		String val;
		while (it.hasNext()) {
			val = it.next();
			s.append(val);
			if (it.hasNext())
				s.append(",");
		}
		s.append(')');
		return s.toString();
	}
}