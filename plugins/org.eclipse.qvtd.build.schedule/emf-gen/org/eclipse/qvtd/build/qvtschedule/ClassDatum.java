/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Type;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getClassDatum()
 * @model
 * @generated
 */
public interface ClassDatum extends AbstractDatum {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getClassDatum_Type()
	 * @model required="true" derived="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Property Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getClassDatum_PropertyDatums()
	 * @see org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum
	 * @model opposite="classDatum" containment="true"
	 * @generated
	 */
	EList<PropertyDatum> getPropertyDatums();
} // ClassDatum
