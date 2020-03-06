/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getUsedPackage <em>Used Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getOwnedContext <em>Owned Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsPrimitive <em>Is Primitive</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsThis <em>Is This</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsTrace <em>Is Trace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getIterates <em>Iterates</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel()
 * @model
 * @generated
 */
public interface TypedModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_Transformation()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter
	 * @model opposite="modelParameter" required="true"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Used Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Package</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_UsedPackage()
	 * @model ordered="false"
	 * @generated
	 */
	@NonNull EList<org.eclipse.ocl.pivot.Package> getUsedPackage();

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of typed models that need to be checked/enforced before this TypedModel can be checked/enforced.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_DependsOn()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='dependent'"
	 * @generated
	 */
	@NonNull EList<TypedModel> getDependsOn();

	/**
	 * Returns the value of the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Context</em>' containment reference.
	 * @see #setOwnedContext(Parameter)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_OwnedContext()
	 * @model containment="true"
	 * @generated
	 */
	Parameter getOwnedContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getOwnedContext <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context</em>' containment reference.
	 * @see #getOwnedContext()
	 * @generated
	 */
	void setOwnedContext(Parameter value);

	/**
	 * Returns the value of the '<em><b>Is Primitive</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel is for a primitive domain. It may be added automatically.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Primitive</em>' attribute.
	 * @see #setIsPrimitive(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_IsPrimitive()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsPrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsPrimitive <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primitive</em>' attribute.
	 * @see #isIsPrimitive()
	 * @generated
	 */
	void setIsPrimitive(boolean value);

	/**
	 * Returns the value of the '<em><b>Is This</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel is for the transformation instance trace. It may be added automatically.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is This</em>' attribute.
	 * @see #setIsThis(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_IsThis()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsThis();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsThis <em>Is This</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is This</em>' attribute.
	 * @see #isIsThis()
	 * @generated
	 */
	void setIsThis(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Trace</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel is for the execution trace. It may be added automatically.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Trace</em>' attribute.
	 * @see #setIsTrace(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_IsTrace()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#isIsTrace <em>Is Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Trace</em>' attribute.
	 * @see #isIsTrace()
	 * @generated
	 */
	void setIsTrace(boolean value);

	/**
	 * Returns the value of the '<em><b>Iterates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of typed models whose elements are also part of this TypedModel. An input TypedModel that iterates an output TypedModel specfies a fixed point iteration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Iterates</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTypedModel_Iterates()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TypedModel> getIterates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ExclusivePrimitiveThisTrace'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tif isPrimitive then 1 else 0 endif + if isThis then 1 else 0 endif + if isTrace then 1 else 0 endif &lt;= 1 \n\n'"
	 * @generated
	 */
	boolean validateExclusivePrimitiveThisTrace(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TypedModel
