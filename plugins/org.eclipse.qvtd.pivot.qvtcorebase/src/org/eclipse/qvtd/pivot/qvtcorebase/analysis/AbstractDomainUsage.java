/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;

public abstract class AbstractDomainUsage implements DomainUsage
{
	protected static final int PRIMITIVE_BIT = 1 << 0;
	protected static final int SOURCE_BIT = 1 << 1;
	protected static final int MIDDLE_BIT = 1 << 2;
	protected static final int TARGET_BIT = 1 << 3;
	protected static final int ERROR_BIT = 1 << 4;

	protected final int mask;
	
	protected AbstractDomainUsage(int mask) {
		this.mask = mask;
	}

	@Override
	public void addUsedBy(@NonNull Element element) {}

	@Override
	public @Nullable Iterable<Element> getElements() {
		return null;
	}

	@Override
	public int getMask() {
		return mask;
	}
	
	@Override
	public boolean isError() {
		return (mask & ERROR_BIT) != 0;
	}
	
	@Override
	public boolean isMiddle() {
		return (mask & MIDDLE_BIT) != 0;
	}
	
	@Override
	public boolean isPrimitive() {
		return (mask & PRIMITIVE_BIT) != 0;
	}
	
	@Override
	public boolean isSource() {
		return (mask & SOURCE_BIT) != 0;
	}
	
	@Override
	public boolean isTarget() {
		return (mask & TARGET_BIT) != 0;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		if ((mask & PRIMITIVE_BIT) != 0) {
			s.append(" PRIMITIVE");
		}
		if ((mask & SOURCE_BIT) != 0) {
			s.append(" SOURCE");
		}
		if ((mask & MIDDLE_BIT) != 0) {
			s.append(" MIDDLE");
		}
		if ((mask & TARGET_BIT) != 0) {
			s.append(" TARGET");
		}
		if ((mask & ERROR_BIT) != 0) {
			s.append(" ERROR");
		}
		return s.toString();
	}
}
