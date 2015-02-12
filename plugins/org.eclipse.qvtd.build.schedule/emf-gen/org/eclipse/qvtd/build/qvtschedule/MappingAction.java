/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.MappingAction#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getMappingAction()
 * @model
 * @generated
 */
public interface MappingAction extends AbstractAction {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(Mapping)
	 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage#getMappingAction_Mapping()
	 * @model
	 * @generated
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.MappingAction#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

} // MappingAction
