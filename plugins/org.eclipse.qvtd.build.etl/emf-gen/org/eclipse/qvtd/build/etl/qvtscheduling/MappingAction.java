/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction#getMappingBindings <em>Mapping Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingAction()
 * @model
 * @generated
 */
public interface MappingAction extends AbstractAction {
	/**
	 * Returns the value of the '<em><b>Mapping Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingAction_MappingBindings()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction
	 * @model opposite="mappingAction" containment="true"
	 * @generated
	 */
	EList<MappingBinding> getMappingBindings();

} // MappingAction
