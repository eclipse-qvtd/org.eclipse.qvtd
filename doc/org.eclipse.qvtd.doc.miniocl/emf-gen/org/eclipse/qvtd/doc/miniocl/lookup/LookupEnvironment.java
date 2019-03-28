/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl.lookup;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.doc.miniocl.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lookup Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage#getLookupEnvironment()
 * @model
 * @generated
 */
public interface LookupEnvironment extends Env4CG {
	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage#getLookupEnvironment_NamedElements()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0!LookupEnvironment!namedElements'"
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
	 * @see org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage#getLookupEnvironment_ParentEnv()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0!LookupEnvironment!parentEnv'"
	 * @generated
	 */
	LookupEnvironment getParentEnv();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}' reference.
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements-&gt;includingAll(elements), parentEnv = parentEnv\n * }\n \052/\nassert elements != null;\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; CTORid_namedElements = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_namedElements);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; CTORid_parentEnv = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Class%&gt; TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ &lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;LookupEnvironment%&gt; symbol_0 = (&lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;LookupEnvironment%&gt;)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ &lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;List%&gt;&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; namedElements = this.getNamedElements();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OrderedSetValue%&gt; BOXED_namedElements = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.ORD_CLSSid_NamedElement, namedElements);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;CollectionValue%&gt; BOXED_elements = idResolver.createCollectionOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.COL_TMPLid_, elements);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OrderedSetValue%&gt; includingAll = (&lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;OrderedSetValue%&gt;)&lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation%&gt;.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);\nfinal &lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, &lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;.class);\nassert UNBOXED_includingAll != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;LookupEnvironment%&gt; parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	<NE extends NamedElement> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='LookupEnvironment{\n\t\t\t\t\t\tnamedElements = namedElements-&gt;including(elements),\n\t\t\t\t\t\tparentEnv = parentEnv\n\t\t\t\t\t}'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements-&gt;including(elements), parentEnv = parentEnv\n * }\n \052/\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.evaluation.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Executor%&gt; executor = &lt;%org.eclipse.ocl.pivot.utilities.PivotUtil%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.ids.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;IdResolver%&gt; idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; CTORid_namedElements = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_namedElements);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Property%&gt; CTORid_parentEnv = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;Class%&gt; TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ &lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;LookupEnvironment%&gt; symbol_0 = (&lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;LookupEnvironment%&gt;)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ &lt;%java.util.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;List%&gt;&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; namedElements = this.getNamedElements();\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OrderedSetValue%&gt; BOXED_namedElements = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.ORD_CLSSid_NamedElement, namedElements);\nfinal /*@Thrown\052/ &lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; %&gt;OrderedSetValue%&gt; including = (&lt;%org.eclipse.ocl.pivot.values.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;OrderedSetValue%&gt;)&lt;%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%&gt;.INSTANCE.evaluate(BOXED_namedElements, elements);\nfinal &lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; UNBOXED_including = including.asEcoreObjects(idResolver, &lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;.class);\nassert UNBOXED_including != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_including);\nfinal /*@NonInvalid\052/ &lt;%org.eclipse.qvtd.doc.miniocl.lookup.&lt;%@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; %&gt;LookupEnvironment%&gt; parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	LookupEnvironment addElements(NamedElement elements);

} // LookupEnvironment
