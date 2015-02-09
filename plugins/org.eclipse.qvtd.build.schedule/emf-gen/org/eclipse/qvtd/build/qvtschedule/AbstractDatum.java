/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSub <em>Sub</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getProducedBy <em>Produced By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDatum extends EObject {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSub <em>Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_Super()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSub
	 * @model opposite="sub"
	 * @generated
	 */
	EList<AbstractDatum> getSuper();

	/**
	 * Returns the value of the '<em><b>Sub</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_Sub()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper
	 * @model opposite="super"
	 * @generated
	 */
	EList<AbstractDatum> getSub();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(CoreDomain)
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_Domain()
	 * @model
	 * @generated
	 */
	CoreDomain getDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(CoreDomain value);

	/**
	 * Returns the value of the '<em><b>Produced By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getProductions <em>Productions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced By</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_ProducedBy()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getProductions
	 * @model opposite="productions"
	 * @generated
	 */
	EList<AbstractAction> getProducedBy();

	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getRequisites <em>Requisites</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_RequiredBy()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getRequisites
	 * @model opposite="requisites" derived="true"
	 * @generated
	 */
	EList<AbstractAction> getRequiredBy();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.Schedule#getDatums <em>Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' container reference.
	 * @see #setSchedule(Schedule)
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_Schedule()
	 * @see org.eclipse.qvtd.build.qvtschedule.Schedule#getDatums
	 * @model opposite="datums" transient="false"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSchedule <em>Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' container reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

	/**
	 * Returns the value of the '<em><b>Data Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DataParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum <em>Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Parameter</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getAbstractDatum_DataParameter()
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum
	 * @model opposite="datum"
	 * @generated
	 */
	EList<DataParameter> getDataParameter();

} // AbstractDatum
