/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction()
 * @model
 * @generated
 */
public interface AbstractAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_Results()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSources
	 * @model opposite="sources"
	 * @generated
	 */
	EList<AbstractDatum> getResults();

	/**
	 * Returns the value of the '<em><b>Distinct Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distinct Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distinct Arguments</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_DistinctArguments()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getTargets
	 * @model opposite="targets"
	 * @generated
	 */
	EList<DistinctData> getDistinctArguments();

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_Count()
	 * @model
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(AbstractAction)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_Parent()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	AbstractAction getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_Children()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<AbstractAction> getChildren();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractAction_Arguments()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getTargets
	 * @model opposite="targets" derived="true"
	 * @generated
	 */
	EList<AbstractDatum> getArguments();

} // AbstractAction
