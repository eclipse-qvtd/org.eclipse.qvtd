/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;

/**
 * A SymbolNameAdapter ensures unique CG-friendly symbol names.
 */
public class SymbolNameAdapter extends SymbolNameReservation implements Adapter	// FIXME change to Visitor to absorb code
{
	public static @NonNull SymbolNameAdapter get(@NonNull ScheduleModel scheduleModel) {
		SymbolNameAdapter adapter = ClassUtil.getAdapter(SymbolNameAdapter.class, scheduleModel);
		if (adapter == null) {
			adapter = new SymbolNameAdapter(scheduleModel);
		}
		return adapter;
	}

	protected final @NonNull ScheduleModel scheduleModel;

	public SymbolNameAdapter(@NonNull ScheduleModel scheduleModel) {
		scheduleModel.eAdapters().add(this);
		this.scheduleModel = scheduleModel;
	}

	@Override
	public Notifier getTarget() {
		return scheduleModel;
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