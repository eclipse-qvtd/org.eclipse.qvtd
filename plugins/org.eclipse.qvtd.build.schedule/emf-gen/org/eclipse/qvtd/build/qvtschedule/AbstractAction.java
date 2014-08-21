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
 * <!-- begin-model-doc -->
 * An AbstractAction represents an operation that consumes (arguments) or
 * creates (results) datums.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getOrder <em>Order</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getSchedule <em>Schedule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Results()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSources
	 * @model opposite="sources"
	 * @generated
	 */
	EList<AbstractDatum> getResults();

	/**
	 * Returns the value of the '<em><b>Distinct Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DistinctData}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distinct Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distinct Arguments</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_DistinctArguments()
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	EList<DistinctData> getDistinctArguments();

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
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getAbstractAction_Arguments()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getTargets
	 * @model opposite="targets" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n            self.distinctArguments.primaryArguments->union(self.distinctArguments.secondaryArguments)->collect(datum)'"
	 * @generated
	 */
	EList<AbstractDatum> getArguments();

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
