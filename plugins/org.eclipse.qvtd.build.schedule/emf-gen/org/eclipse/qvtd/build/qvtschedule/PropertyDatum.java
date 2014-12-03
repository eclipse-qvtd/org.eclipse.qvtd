/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.ocl.examples.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getPropertyDatum()
 * @model
 * @generated
 */
public interface PropertyDatum extends AbstractDatum {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getPropertyDatum_Property()
	 * @model required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Class Datum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Datum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Datum</em>' container reference.
	 * @see #setClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getPropertyDatum_ClassDatum()
	 * @see org.eclipse.qvtd.build.qvtschedule.ClassDatum#getPropertyDatums
	 * @model opposite="propertyDatums" required="true" transient="false"
	 * @generated
	 */
	ClassDatum getClassDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum</em>' container reference.
	 * @see #getClassDatum()
	 * @generated
	 */
	void setClassDatum(ClassDatum value);

} // PropertyDatum
