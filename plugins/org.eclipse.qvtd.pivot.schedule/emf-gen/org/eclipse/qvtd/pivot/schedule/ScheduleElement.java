/**
 */
package org.eclipse.qvtd.pivot.schedule;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.pivot.schedule.util.ScheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getScheduleElement()
 * @model abstract="true"
 * @generated
 */
public interface ScheduleElement extends EObject {
	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public @Nullable <R> R accept(@NonNull ScheduleVisitor<R> visitor);
} // ScheduleElement
