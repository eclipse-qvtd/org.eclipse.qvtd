/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
package example2.classes.lookup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Env4 CG</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see example2.classes.lookup.EnvironmentPackage#getEnv4CG()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Env4CG extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasFinalResult();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="example2.classes.lookup.Executor"
	 * @generated
	 */
	Executor getExecutor();

} // Env4CG
