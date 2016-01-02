/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.schedule;

import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction()
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
	 * @see #setMapping(AbstractMapping)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction_Mapping()
	 * @model
	 * @generated
	 */
	AbstractMapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(AbstractMapping value);

} // MappingAction
