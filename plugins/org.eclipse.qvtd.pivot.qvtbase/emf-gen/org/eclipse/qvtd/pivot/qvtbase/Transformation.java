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
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTargets <em>Owned Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext <em>Owned Context</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends org.eclipse.ocl.pivot.Class {
	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_OwnedTag()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<Annotation> getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_ModelParameter()
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation
	 * @model opposite="transformation" containment="true"
	 * @generated
	 */
	@NonNull EList<TypedModel> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Owned Targets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Target}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Target#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of typed models that need to be checked/enforced before this TypedModel can be checked/enforced.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Targets</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_OwnedTargets()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Target#getOwningTransformation
	 * @model opposite="owningTransformation" containment="true" ordered="false"
	 * @generated
	 */
	EList<Target> getOwnedTargets();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_Rule()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<Rule> getRule();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_Extends()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='extendedBy'"
	 * @generated
	 */
	Transformation getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Transformation value);

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
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTransformation_OwnedContext()
	 * @model containment="true"
	 * @generated
	 */
	Parameter getOwnedContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context</em>' containment reference.
	 * @see #getOwnedContext()
	 * @generated
	 */
	void setOwnedContext(Parameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	Function getFunction(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	TypedModel getModelParameter(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ContextTypeIsTransformation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\townedContext &lt;&gt; null implies ownedContext.type.oclIsKindOf(Transformation)\n\n'"
	 * @generated
	 */
	boolean validateContextTypeIsTransformation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ExtendedTypedModelIsExtended'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t_extends &lt;&gt; null implies\n\t_extends.modelParameter-&gt;forAll(etm |\n\t\tself.modelParameter-&gt;select(name = etm.name).usedPackage-&gt;includesAll(etm.usedPackage)\n\t)\n\t\n'"
	 * @generated
	 */
	boolean validateExtendedTypedModelIsExtended(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ModelParameterIsUnique'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tmodelParameter-&gt;isUnique(name)\n\n'"
	 * @generated
	 */
	boolean validateModelParameterIsUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='NoExtendsCycle'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t_extends-&gt;closure(_extends)-&gt;excludes(self)\n\n'"
	 * @generated
	 */
	boolean validateNoExtendsCycle(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Transformation
