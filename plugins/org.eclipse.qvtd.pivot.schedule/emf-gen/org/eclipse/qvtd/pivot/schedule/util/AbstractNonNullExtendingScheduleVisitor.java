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
 * An AbstractExtendingNonNullScheduleVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 * The return in annotated as @NonNull.
 */
public abstract class AbstractNonNullExtendingScheduleVisitor<R, C>
	extends AbstractScheduleVisitor<R, C>
	implements ScheduleVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNonNullExtendingScheduleVisitor(@NonNull C context) {
		super(context);
	}	
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param visitable a visitable
	 * @return the non-null result of visiting it
	 */
	@Override
	public @NonNull R visit(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement visitable) {
		R result = visitable.accept(this);
		if (result == null) {
			throw new IllegalStateException("null return from non-null " + getClass().getName());
		}
		return result;
	}

	@Override
	public @NonNull R visitAbstractAction(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractAction object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitAbstractDatum(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractDatum object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitClassDatum(@NonNull org.eclipse.qvtd.pivot.schedule.ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @NonNull R visitDataParameter(@NonNull org.eclipse.qvtd.pivot.schedule.DataParameter object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitInputAction(@NonNull org.eclipse.qvtd.pivot.schedule.InputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitMappingAction(@NonNull org.eclipse.qvtd.pivot.schedule.MappingAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitOutputAction(@NonNull org.eclipse.qvtd.pivot.schedule.OutputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitParameterDerivation(@NonNull org.eclipse.qvtd.pivot.schedule.ParameterDerivation object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitPropertyDatum(@NonNull org.eclipse.qvtd.pivot.schedule.PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @NonNull R visitSchedule(@NonNull org.eclipse.qvtd.pivot.schedule.Schedule object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitScheduleElement(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement object) {
		return visiting(object);
	}

	@Override
	public @NonNull R visitSecondaryParameter(@NonNull org.eclipse.qvtd.pivot.schedule.SecondaryParameter object) {
		return visitScheduleElement(object);
	}

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Override
	public abstract @NonNull R visiting(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement visitable);
}
