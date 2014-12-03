/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An AbstractDatum represents a the types consumed (target) or created (source)
 * by an AbstractAction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDatum extends EObject {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Super()
	 * @model
	 * @generated
	 */
	EList<AbstractDatum> getSuper();

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
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Type()
	 * @model required="true" derived="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

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
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Domain()
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
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Sources()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults
	 * @model opposite="results"
	 * @generated
	 */
	EList<AbstractAction> getSources();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Targets()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getArguments
	 * @model opposite="arguments" derived="true"
	 * @generated
	 */
	EList<AbstractAction> getTargets();

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
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_Schedule()
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
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractDatum_DataParameter()
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum
	 * @model opposite="datum"
	 * @generated
	 */
	EList<DataParameter> getDataParameter();

} // AbstractDatum
