/*******************************************************************************
 * <copyright>
 * Copyright (c) 2015 Horacio Hoyos and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Horacio Hoyos - Initial API and implementation
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.schedule/model/Schedule.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.schedule.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface ScheduleVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement visitable);

	R visitAbstractAction(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractAction object);
	R visitAbstractDatum(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractDatum object);
	R visitClassDatum(org.eclipse.qvtd.pivot.schedule.@NonNull ClassDatum object);
	R visitDataParameter(org.eclipse.qvtd.pivot.schedule.@NonNull DataParameter object);
	R visitInputAction(org.eclipse.qvtd.pivot.schedule.@NonNull InputAction object);
	R visitMappingAction(org.eclipse.qvtd.pivot.schedule.@NonNull MappingAction object);
	R visitOutputAction(org.eclipse.qvtd.pivot.schedule.@NonNull OutputAction object);
	R visitParameterDerivation(org.eclipse.qvtd.pivot.schedule.@NonNull ParameterDerivation object);
	R visitPropertyDatum(org.eclipse.qvtd.pivot.schedule.@NonNull PropertyDatum object);
	R visitSchedule(org.eclipse.qvtd.pivot.schedule.@NonNull Schedule object);
	R visitScheduleElement(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement object);
	R visitSecondaryParameter(org.eclipse.qvtd.pivot.schedule.@NonNull SecondaryParameter object);
}
