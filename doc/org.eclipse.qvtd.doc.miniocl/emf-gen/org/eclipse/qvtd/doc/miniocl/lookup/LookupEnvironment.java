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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements-&gt;includingAll(elements), parentEnv = parentEnv\n * }\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property CTORid_namedElements = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property CTORid_parentEnv = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_lookup_c_c_LookupEnvironment = idResolver.getClass(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ org.eclipse.qvtd.doc.miniocl.lookup.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; LookupEnvironment symbol_0 = (&lt;%org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment%&gt;)TYP_lookup_c_c_LookupEnvironment.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; namedElements = this.getNamedElements();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.ORD_CLSSid_NamedElement, namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; CollectionValue BOXED_elements = idResolver.createCollectionOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.COL_TMPLid_, elements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; CollectionValue includingAll = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionMutableIncludingAllOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.COL_PRIMid_OclAny, BOXED_namedElements, BOXED_elements);\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.Object%&gt;&gt; UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, &lt;%java.lang.Object%&gt;.class);\nassert UNBOXED_includingAll != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.doc.miniocl.lookup.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; LookupEnvironment parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	<NE extends NamedElement> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n *\n * LookupEnvironment{\n *   namedElements = namedElements-&gt;including(elements), parentEnv = parentEnv\n * }\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Executor executor = &lt;%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%&gt;.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property CTORid_namedElements = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_namedElements);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Property CTORid_parentEnv = idResolver.getProperty(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.PROPid_parentEnv);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.CLSSid_LookupEnvironment, null);\nfinal /*@Thrown\052/ org.eclipse.qvtd.doc.miniocl.lookup.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; LookupEnvironment symbol_0 = (&lt;%org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment%&gt;)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\n@SuppressWarnings(\"null\")\nfinal /*@NonInvalid\052/ java.util.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; List&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; namedElements = this.getNamedElements();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(&lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.ORD_CLSSid_NamedElement, namedElements);\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@&lt;%org.eclipse.jdt.annotation.NonNull%&gt; CollectionValue including = &lt;%org.eclipse.ocl.pivot.library.collection.CollectionMutableIncludingOperation%&gt;.INSTANCE.evaluate(executor, &lt;%org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables%&gt;.ORD_CLSSid_NamedElement, BOXED_namedElements, elements);\nfinal &lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;&gt; UNBOXED_including = including.asEcoreObjects(idResolver, &lt;%org.eclipse.qvtd.doc.miniocl.NamedElement%&gt;.class);\nassert UNBOXED_including != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_including);\nfinal /*@NonInvalid\052/ org.eclipse.qvtd.doc.miniocl.lookup.@&lt;%org.eclipse.jdt.annotation.Nullable%&gt; LookupEnvironment parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	LookupEnvironment addElements(NamedElement elements);

} // LookupEnvironment
