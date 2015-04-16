/*******************************************************************************
 * <copyright>
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
import org.eclipse.jdt.annotation.Nullable;

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
	protected AbstractExtendingScheduleVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitAbstractAction(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractAction object) {
		return visitScheduleElement(object);
	}

	@Override
	public @Nullable R visitAbstractDatum(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractDatum object) {
		return visitScheduleElement(object);
	}

	@Override
	public @Nullable R visitClassDatum(@NonNull org.eclipse.qvtd.pivot.schedule.ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable R visitDataParameter(@NonNull org.eclipse.qvtd.pivot.schedule.DataParameter object) {
		return visitScheduleElement(object);
	}

	@Override
	public @Nullable R visitInputAction(@NonNull org.eclipse.qvtd.pivot.schedule.InputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @Nullable R visitMappingAction(@NonNull org.eclipse.qvtd.pivot.schedule.MappingAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @Nullable R visitOutputAction(@NonNull org.eclipse.qvtd.pivot.schedule.OutputAction object) {
		return visitAbstractAction(object);
	}

	@Override
	public @Nullable R visitParameterDerivation(@NonNull org.eclipse.qvtd.pivot.schedule.ParameterDerivation object) {
		return visitScheduleElement(object);
	}

	@Override
	public @Nullable R visitPropertyDatum(@NonNull org.eclipse.qvtd.pivot.schedule.PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable R visitSchedule(@NonNull org.eclipse.qvtd.pivot.schedule.Schedule object) {
		return visitScheduleElement(object);
	}

	@Override
	public @Nullable R visitScheduleElement(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitSecondaryParameter(@NonNull org.eclipse.qvtd.pivot.schedule.SecondaryParameter object) {
		return visitScheduleElement(object);
	}
}
