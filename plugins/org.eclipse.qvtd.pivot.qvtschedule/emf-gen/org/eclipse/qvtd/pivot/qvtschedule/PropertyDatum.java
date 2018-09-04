/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A PropertyDatum identifies a DataType value produced by one or more regions and consumed by one or more usually other regions. The DataType value is passsed within an Object Slot.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum <em>Owning Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuperPropertyDatums <em>Super Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey <em>Key</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum()
 * @model
 * @generated
 */
public interface PropertyDatum extends AbstractDatum {
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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum_Opposite()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!PropertyDatum!opposite'"
	 * @generated
	 */
	PropertyDatum getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(PropertyDatum value);

	/**
	 * Returns the value of the '<em><b>Owning Class Datum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums <em>Owned Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class Datum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parent ClassDatum for which this PropertyDatum defines a slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Class Datum</em>' container reference.
	 * @see #setOwningClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum_OwningClassDatum()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums
	 * @model opposite="ownedPropertyDatums" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!PropertyDatum!owningClassDatum'"
	 * @generated
	 */
	ClassDatum getOwningClassDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum <em>Owning Class Datum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class Datum</em>' container reference.
	 * @see #getOwningClassDatum()
	 * @generated
	 */
	void setOwningClassDatum(ClassDatum value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!PropertyDatum!referredProperty'"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Super Property Datums</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Property Datums</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Property Datums</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum_SuperPropertyDatums()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!PropertyDatum!superPropertyDatums'"
	 * @generated
	 */
	EList<PropertyDatum> getSuperPropertyDatums();

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set true if this PropertyDatum forms part of a key for the containing ClassDatum.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPropertyDatum_Key()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!PropertyDatum!key'"
	 * @generated
	 */
	boolean isKey();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #isKey()
	 * @generated
	 */
	void setKey(boolean value);

} // PropertyDatum
