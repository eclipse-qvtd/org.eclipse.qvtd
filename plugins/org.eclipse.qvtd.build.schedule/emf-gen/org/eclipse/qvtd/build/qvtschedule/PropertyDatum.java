/**
 */
package org.eclipse.qvtd.build.qvtschedule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}</li>
 * </ul>
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
	 * @see #setProperty(org.eclipse.ocl.pivot.Property)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getPropertyDatum_Property()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Property getProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(org.eclipse.ocl.pivot.Property value);

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

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(PropertyDatum)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getPropertyDatum_Opposite()
	 * @model
	 * @generated
	 */
	PropertyDatum getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(PropertyDatum value);

} // PropertyDatum
