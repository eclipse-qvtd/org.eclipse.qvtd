/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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

import org.eclipse.emf.common.util.EList;

import example2.classes.NamedElement;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lookup Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example2.classes.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see example2.classes.lookup.EnvironmentPackage#getLookupEnvironment()
 * @model
 * @generated
 */
public interface LookupEnvironment extends Env4CG {
	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link example2.classes.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see example2.classes.lookup.EnvironmentPackage#getLookupEnvironment_NamedElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getNamedElements();

	/**
	 * Returns the value of the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Env</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Env</em>' reference.
	 * @see #setParentEnv(LookupEnvironment)
	 * @see example2.classes.lookup.EnvironmentPackage#getLookupEnvironment_ParentEnv()
	 * @model
	 * @generated
	 */
	LookupEnvironment getParentEnv();

	/**
	 * Sets the value of the '{@link example2.classes.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Env</em>' reference.
	 * @see #getParentEnv()
	 * @generated
	 */
	void setParentEnv(LookupEnvironment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementsType="org.eclipse.ocl.pivot.oclstdlib.Collection&lt;NE&gt;" elementsRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='LookupEnvironment{\n\t\t\t\t\t\tnamedElements = namedElements-&gt;includingAll(elements),\n\t\t\t\t\t\tparentEnv = parentEnv\t\n\t\t\t\t}'"
	 * @generated
	 */
	<NE extends NamedElement> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='LookupEnvironment{\n\t\t\t\t\t\tnamedElements = namedElements-&gt;including(element),\n\t\t\t\t\t\tparentEnv = parentEnv\n\t\t\t\t\t}'"
	 * @generated
	 */
	LookupEnvironment addElement(NamedElement element);

} // LookupEnvironment
