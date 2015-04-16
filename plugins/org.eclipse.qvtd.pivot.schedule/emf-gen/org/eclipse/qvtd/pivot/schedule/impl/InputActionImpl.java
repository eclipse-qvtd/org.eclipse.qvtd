/**
 */
package org.eclipse.qvtd.pivot.schedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.schedule.InputAction;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.util.ScheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InputActionImpl extends AbstractActionImpl implements InputAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulePackage.Literals.INPUT_ACTION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull ScheduleVisitor<R> visitor) {
		return visitor.visitInputAction(this);
	}

} //InputActionImpl
