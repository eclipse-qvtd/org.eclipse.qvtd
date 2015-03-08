/**
 */
package example2.env;

import org.eclipse.emf.common.util.EList;

import example2.classes.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.env.Environment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example2.env.Environment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see example2.env.EnvironmentPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends Env4CG {
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
	 * @see example2.env.EnvironmentPackage#getEnvironment_NamedElements()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!Environment!namedElements'"
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
	 * @see #setParentEnv(Environment)
	 * @see example2.env.EnvironmentPackage#getEnvironment_ParentEnv()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!Environment!parentEnv'"
	 * @generated
	 */
	Environment getParentEnv();

	/**
	 * Sets the value of the '{@link example2.env.Environment#getParentEnv <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Env</em>' reference.
	 * @see #getParentEnv()
	 * @generated
	 */
	void setParentEnv(Environment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model elementsMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * Environment{\n *   namedElements = namedElements->includingAll(elements), parentEnv = parentEnv\n * }\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Property%> CTORid_namedElements = idResolver.getProperty(<%example2.env.EnvironmentTables%>.PROPid_namedElements);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Property%> CTORid_parentEnv = idResolver.getProperty(<%example2.env.EnvironmentTables%>.PROPid_parentEnv);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_env_c_c_Environment_0 = idResolver.getClass(<%example2.env.EnvironmentTables%>.CLSSid_Environment, null);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%example2.env.Environment%> symbol_0 = (<%example2.env.Environment%>)TYP_env_c_c_Environment_0.createInstance();\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%><<%example2.classes.NamedElement%>> namedElements = this.getNamedElements();\nassert namedElements != null;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_namedElements = idResolver.createOrderedSetOfAll(<%example2.env.EnvironmentTables%>.ORD_CLSSid_NamedElement, namedElements);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_elements = idResolver.createOrderedSetOfAll(<%example2.env.EnvironmentTables%>.ORD_CLSSid_NamedElement, elements);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.CollectionValue%> includingAll = <%org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation%>.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);\nfinal <%java.util.List%><<%example2.classes.NamedElement%>> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, <%example2.classes.NamedElement%>.class);\nassert UNBOXED_includingAll != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%example2.env.Environment%> parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	Environment addElements(EList<NamedElement> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * Environment{\n *   namedElements = namedElements->including(element), parentEnv = parentEnv\n * }\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Property%> CTORid_namedElements = idResolver.getProperty(<%example2.env.EnvironmentTables%>.PROPid_namedElements);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Property%> CTORid_parentEnv = idResolver.getProperty(<%example2.env.EnvironmentTables%>.PROPid_parentEnv);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_env_c_c_Environment_0 = idResolver.getClass(<%example2.env.EnvironmentTables%>.CLSSid_Environment, null);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%example2.env.Environment%> symbol_0 = (<%example2.env.Environment%>)TYP_env_c_c_Environment_0.createInstance();\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%><<%example2.classes.NamedElement%>> namedElements = this.getNamedElements();\nassert namedElements != null;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> BOXED_namedElements = idResolver.createOrderedSetOfAll(<%example2.env.EnvironmentTables%>.ORD_CLSSid_NamedElement, namedElements);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%> including = (<%org.eclipse.ocl.pivot.values.OrderedSetValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%>.INSTANCE.evaluate(BOXED_namedElements, element);\nfinal <%java.util.List%><<%example2.classes.NamedElement%>> UNBOXED_including = including.asEcoreObjects(idResolver, <%example2.classes.NamedElement%>.class);\nassert UNBOXED_including != null;\nCTORid_namedElements.initValue(symbol_0, UNBOXED_including);\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%example2.env.Environment%> parentEnv = this.getParentEnv();\nCTORid_parentEnv.initValue(symbol_0, parentEnv);\nreturn symbol_0;'"
	 * @generated
	 */
	Environment addElement(NamedElement element);

} // Environment
