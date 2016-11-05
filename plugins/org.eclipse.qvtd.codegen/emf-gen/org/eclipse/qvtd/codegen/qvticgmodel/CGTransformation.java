/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedTypedModels <em>Owned Typed Models</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation()
 * @model
 * @generated
 */
public interface CGTransformation extends CGClass {

	/**
	 * Returns the value of the '<em><b>Owned Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation_OwnedMappings()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation
	 * @model opposite="owningTransformation" containment="true" required="true"
	 * @generated
	 */
	List<CGMapping> getOwnedMappings();

	/**
	 * Returns the value of the '<em><b>Owned Typed Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Typed Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Typed Models</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTransformation_OwnedTypedModels()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation
	 * @model opposite="owningTransformation" containment="true"
	 * @generated
	 */
	List<CGTypedModel> getOwnedTypedModels();
} // CGTransformation
