/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.CompleteClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClass <em>Complete Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums <em>Owned Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuperClassDatums <em>Super Class Datums</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum()
 * @model
 * @generated
 */
public interface ClassDatum extends AbstractDatum {
	/**
	 * Returns the value of the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Class</em>' reference.
	 * @see #setCompleteClass(CompleteClass)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum_CompleteClass()
	 * @model required="true" transient="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatum!completeClass'"
	 * @generated
	 */
	CompleteClass getCompleteClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClass <em>Complete Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete Class</em>' reference.
	 * @see #getCompleteClass()
	 * @generated
	 */
	void setCompleteClass(CompleteClass value);

	/**
	 * Returns the value of the '<em><b>Owned Property Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum <em>Owning Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Property Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum_OwnedPropertyDatums()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum
	 * @model opposite="owningClassDatum" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatum!ownedPropertyDatums'"
	 * @generated
	 */
	EList<PropertyDatum> getOwnedPropertyDatums();

	/**
	 * Returns the value of the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums <em>Owned Class Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Schedule Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #setOwningScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum_OwningScheduleModel()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums
	 * @model opposite="ownedClassDatums" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatum!owningScheduleModel'"
	 * @generated
	 */
	ScheduleModel getOwningScheduleModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel <em>Owning Schedule Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #getOwningScheduleModel()
	 * @generated
	 */
	void setOwningScheduleModel(ScheduleModel value);

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see #setReferredClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum_ReferredClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatum!referredClass'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Super Class Datums</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Datums</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class Datums</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatum_SuperClassDatums()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatum!superClassDatums'"
	 * @generated
	 */
	EList<ClassDatum> getSuperClassDatums();

} // ClassDatum
