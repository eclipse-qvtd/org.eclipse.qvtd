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
	@Nullable R visiting(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement visitable);

	@Nullable R visitAbstractAction(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractAction object);
	@Nullable R visitAbstractDatum(@NonNull org.eclipse.qvtd.pivot.schedule.AbstractDatum object);
	@Nullable R visitClassDatum(@NonNull org.eclipse.qvtd.pivot.schedule.ClassDatum object);
	@Nullable R visitDataParameter(@NonNull org.eclipse.qvtd.pivot.schedule.DataParameter object);
	@Nullable R visitInputAction(@NonNull org.eclipse.qvtd.pivot.schedule.InputAction object);
	@Nullable R visitMappingAction(@NonNull org.eclipse.qvtd.pivot.schedule.MappingAction object);
	@Nullable R visitOutputAction(@NonNull org.eclipse.qvtd.pivot.schedule.OutputAction object);
	@Nullable R visitParameterDerivation(@NonNull org.eclipse.qvtd.pivot.schedule.ParameterDerivation object);
	@Nullable R visitPropertyDatum(@NonNull org.eclipse.qvtd.pivot.schedule.PropertyDatum object);
	@Nullable R visitSchedule(@NonNull org.eclipse.qvtd.pivot.schedule.Schedule object);
	@Nullable R visitScheduleElement(@NonNull org.eclipse.qvtd.pivot.schedule.ScheduleElement object);
	@Nullable R visitSecondaryParameter(@NonNull org.eclipse.qvtd.pivot.schedule.SecondaryParameter object);
}
