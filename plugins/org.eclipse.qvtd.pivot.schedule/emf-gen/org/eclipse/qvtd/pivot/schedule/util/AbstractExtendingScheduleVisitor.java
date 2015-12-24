/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.schedule/model/Schedule.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.schedule.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingScheduleVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingScheduleVisitor<R, C>
	extends AbstractScheduleVisitor<R, C>
	implements ScheduleVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingScheduleVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAbstractAction(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractAction object) {
		return visitScheduleElement(object);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractDatum object) {
		return visitScheduleElement(object);
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.schedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public R visitDataParameter(org.eclipse.qvtd.pivot.schedule.@NonNull DataParameter object) {
		return visitScheduleElement(object);
	}

	@Override
	public R visitInputAction(org.eclipse.qvtd.pivot.schedule.@NonNull InputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public R visitMappingAction(org.eclipse.qvtd.pivot.schedule.@NonNull MappingAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public R visitOutputAction(org.eclipse.qvtd.pivot.schedule.@NonNull OutputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public R visitParameterDerivation(org.eclipse.qvtd.pivot.schedule.@NonNull ParameterDerivation object) {
		return visitScheduleElement(object);
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.schedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public R visitSchedule(org.eclipse.qvtd.pivot.schedule.@NonNull Schedule object) {
		return visitScheduleElement(object);
	}

	@Override
	public R visitScheduleElement(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement object) {
		return visiting(object);
	}

	@Override
	public R visitSecondaryParameter(org.eclipse.qvtd.pivot.schedule.@NonNull SecondaryParameter object) {
		return visitScheduleElement(object);
	}
}
