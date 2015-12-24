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
 * The return is annotated as @NonNull.
 *
 * @deprecated Explicit 'NonNull' functionality is obsolete with Java 8 @NonNull annotations.  
 */
 @Deprecated
public abstract class AbstractNonNullExtendingScheduleVisitor<R, C>
	extends AbstractScheduleVisitor<R, C>
	implements ScheduleVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNonNullExtendingScheduleVisitor(C context) {
		super(context);
	}	
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param visitable a visitable
	 * @return the non-null result of visiting it
	 */
	@Override
	public @NonNull R visit(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement visitable) {
		R result = visitable.accept(this);
		if (result == null) {
			throw new IllegalStateException("null return from non-null " + getClass().getName());
		}
		return result;
	}

	@Override
	public @NonNull R visitAbstractAction(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractAction object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitAbstractDatum(org.eclipse.qvtd.pivot.schedule.@NonNull AbstractDatum object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitClassDatum(org.eclipse.qvtd.pivot.schedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @NonNull R visitDataParameter(org.eclipse.qvtd.pivot.schedule.@NonNull DataParameter object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitInputAction(org.eclipse.qvtd.pivot.schedule.@NonNull InputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitMappingAction(org.eclipse.qvtd.pivot.schedule.@NonNull MappingAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitOutputAction(org.eclipse.qvtd.pivot.schedule.@NonNull OutputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @NonNull R visitParameterDerivation(org.eclipse.qvtd.pivot.schedule.@NonNull ParameterDerivation object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitPropertyDatum(org.eclipse.qvtd.pivot.schedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @NonNull R visitSchedule(org.eclipse.qvtd.pivot.schedule.@NonNull Schedule object) {
		return visitScheduleElement(object);
	}

	@Override
	public @NonNull R visitScheduleElement(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement object) {
		return visiting(object);
	}

	@Override
	public @NonNull R visitSecondaryParameter(org.eclipse.qvtd.pivot.schedule.@NonNull SecondaryParameter object) {
		return visitScheduleElement(object);
	}

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Override
	public abstract @NonNull R visiting(org.eclipse.qvtd.pivot.schedule.@NonNull ScheduleElement visitable);
}
