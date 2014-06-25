/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.pivot.Type;

import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData <em>Primary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSecondaryDistinctData <em>Secondary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum()
 * @model
 * @generated
 */
public interface AbstractDatum extends EObject {
	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Sources()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getResults
	 * @model opposite="results"
	 * @generated
	 */
	EList<AbstractAction> getSources();

	/**
	 * Returns the value of the '<em><b>Primary Distinct Data</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getPrimaryArgument <em>Primary Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Distinct Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Distinct Data</em>' reference.
	 * @see #setPrimaryDistinctData(DistinctData)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_PrimaryDistinctData()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getPrimaryArgument
	 * @model opposite="primaryArgument"
	 * @generated
	 */
	DistinctData getPrimaryDistinctData();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData <em>Primary Distinct Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Distinct Data</em>' reference.
	 * @see #getPrimaryDistinctData()
	 * @generated
	 */
	void setPrimaryDistinctData(DistinctData value);

	/**
	 * Returns the value of the '<em><b>Secondary Distinct Data</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getSecondaryArgument <em>Secondary Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Distinct Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Distinct Data</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_SecondaryDistinctData()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getSecondaryArgument
	 * @model opposite="secondaryArgument"
	 * @generated
	 */
	EList<DistinctData> getSecondaryDistinctData();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(AbstractDatum)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Parent()
	 * @model
	 * @generated
	 */
	AbstractDatum getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(AbstractDatum value);

	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Super()
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
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Type()
	 * @model required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getType <em>Type</em>}' reference.
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
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Domain()
	 * @model derived="true"
	 * @generated
	 */
	CoreDomain getDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(CoreDomain value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getAbstractDatum_Targets()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getArguments
	 * @model opposite="arguments" derived="true"
	 * @generated
	 */
	EList<AbstractAction> getTargets();

} // AbstractDatum
