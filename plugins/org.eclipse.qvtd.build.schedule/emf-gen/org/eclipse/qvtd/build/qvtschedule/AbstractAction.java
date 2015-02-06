/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getProductions <em>Productions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getRequisites <em>Requisites</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameterDerivations <em>Parameter Derivations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getOrder <em>Order</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Productions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Productions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Productions</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Productions()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getProducedBy
	 * @model opposite="producedBy"
	 * @generated
	 */
	EList<AbstractDatum> getProductions();

	/**
	 * Returns the value of the '<em><b>Requisites</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requisites</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requisites</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Requisites()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getRequiredBy
	 * @model opposite="requiredBy"
	 * @generated
	 */
	EList<AbstractDatum> getRequisites();

	/**
	 * Returns the value of the '<em><b>Parameter Derivations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Derivations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Derivations</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_ParameterDerivations()
	 * @see org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	EList<ParameterDerivation> getParameterDerivations();

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Order()
	 * @model
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(AbstractAction)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Parent()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	AbstractAction getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Children()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<AbstractAction> getChildren();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DataParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DataParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataParameter> getResults();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.Schedule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' container reference.
	 * @see #setSchedule(Schedule)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Schedule()
	 * @see org.eclipse.qvtd.build.qvtschedule.Schedule#getActions
	 * @model opposite="actions" transient="false"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getSchedule <em>Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' container reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

} // AbstractAction
