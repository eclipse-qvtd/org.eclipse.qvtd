/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import java.util.List;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getTypedModels <em>Typed Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation()
 * @model
 * @generated
 */
public interface CGTransformation extends CGClass {

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation_Mappings()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation
	 * @model opposite="transformation" containment="true" required="true"
	 * @generated
	 */
	List<CGMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Typed Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Models</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation_TypedModels()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation
	 * @model opposite="transformation" containment="true"
	 * @generated
	 */
	List<CGTypedModel> getTypedModels();
} // CGTransformation
