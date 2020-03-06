/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A SymbolNameAdapter ensures unique CG-friendly symbol names.
 */
public class SymbolNameAdapter extends SymbolNameReservation implements Adapter	// FIXME change to Visitor to absorb code
{
	public static @NonNull SymbolNameAdapter get(@NonNull Model model) {
		SymbolNameAdapter adapter = ClassUtil.getAdapter(SymbolNameAdapter.class, model);
		if (adapter == null) {
			adapter = new SymbolNameAdapter(model);
		}
		return adapter;
	}

	protected final @NonNull Model model;

	public SymbolNameAdapter(@NonNull Model model) {
		model.eAdapters().add(this);
		this.model = model;
	}

	@Override
	public Notifier getTarget() {
		return model;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == SymbolNameAdapter.class;
	}

	@Override
	public void notifyChanged(Notification notification) {}

	@Override
	public void setTarget(Notifier newTarget) {}
}