/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package astm.lookup;

import astm.Definition;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link astm.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see astm.lookup.LookupPackage#getLookupEnvironment()
 * @model
 * @generated
 */
public interface LookupEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link astm.Definition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see astm.lookup.LookupPackage#getLookupEnvironment_NamedElements()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/lookup/1.0!LookupEnvironment!namedElements'"
	 * @generated
	 */
	EList<Definition> getNamedElements();

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
	 * @see astm.lookup.LookupPackage#getLookupEnvironment_ParentEnv()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/lookup/1.0!LookupEnvironment!parentEnv'"
	 * @generated
	 */
	LookupEnvironment getParentEnv();

	/**
	 * Sets the value of the '{@link astm.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}' reference.
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
	 * @model required="true" elementsType="org.eclipse.ocl.pivot.oclstdlib.Collection<NE>" elementsRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements->includingAll(elements), parentEnv = parentEnv\n * }\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@<%org.eclipse.jdt.annotation.NonNull%> Executor executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@<%org.eclipse.jdt.annotation.NonNull%> IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_namedElements = idResolver.getProperty(<%astm.lookup.LookupTables%>.PROPid_namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_parentEnv = idResolver.getProperty(<%astm.lookup.LookupTables%>.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(<%astm.lookup.LookupTables%>.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ astm.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment symbol_0 = (<%astm.lookup.LookupEnvironment%>)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%astm.Definition%>> namedElements = this.getNamedElements();\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(<%astm.lookup.LookupTables%>.ORD_CLSSid_Definition, namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> CollectionValue BOXED_elements = idResolver.createCollectionOfAll(<%astm.lookup.LookupTables%>.COL_TMPLid_, elements);\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> CollectionValue includingAll = <%org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation%>.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);\nfinal <%java.util.List%><? extends <%java.lang.Object%>> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, <%java.lang.Object%>.class);\nassert UNBOXED_includingAll != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);\nfinal /*@Thrown\052/ astm.lookup.@<%org.eclipse.jdt.annotation.Nullable%> LookupEnvironment parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	<NE extends Definition> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements->including(element), parentEnv = parentEnv\n * }\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@<%org.eclipse.jdt.annotation.NonNull%> Executor executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@<%org.eclipse.jdt.annotation.NonNull%> IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_namedElements = idResolver.getProperty(<%astm.lookup.LookupTables%>.PROPid_namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_parentEnv = idResolver.getProperty(<%astm.lookup.LookupTables%>.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(<%astm.lookup.LookupTables%>.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ astm.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment symbol_0 = (<%astm.lookup.LookupEnvironment%>)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%astm.Definition%>> namedElements = this.getNamedElements();\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(<%astm.lookup.LookupTables%>.ORD_CLSSid_Definition, namedElements);\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue including = (<%org.eclipse.ocl.pivot.values.OrderedSetValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%>.INSTANCE.evaluate(BOXED_namedElements, element);\nfinal <%java.util.List%><<%astm.Definition%>> UNBOXED_including = including.asEcoreObjects(idResolver, astm.Definition.class);\nassert UNBOXED_including != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_including);\nfinal /*@Thrown\052/ astm.lookup.@<%org.eclipse.jdt.annotation.Nullable%> LookupEnvironment parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	LookupEnvironment addElement(Definition element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new <%java.lang.UnsupportedOperationException%>(\"Enviroment::hasFinalResult() has been created for CG purposes. Don\'t call this method\");'"
	 * @generated
	 */
	boolean hasFinalResult();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="astm.lookup.Executor"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new <%java.lang.UnsupportedOperationException%>(\"Enviroment::getEvaluator() has been created for CG purposes. Don\'t call this method\");'"
	 * @generated
	 */
	Executor getExecutor();

} // LookupEnvironment
