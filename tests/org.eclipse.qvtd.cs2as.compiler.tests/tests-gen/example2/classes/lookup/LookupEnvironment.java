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
 *   <li>{@link example2.classes.lookup.LookupEnvironment#getEntries <em>Entries</em>}</li>
 *   <li>{@link example2.classes.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see example2.classes.lookup.EnvironmentPackage#getLookupEnvironment()
 * @model
 * @generated
 */
public interface LookupEnvironment extends Env4CG {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.lookup.EnvEntry}.
	 * It is bidirectional and its opposite is '{@link example2.classes.lookup.EnvEntry#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see example2.classes.lookup.EnvironmentPackage#getLookupEnvironment_Entries()
	 * @see example2.classes.lookup.EnvEntry#getEnv
	 * @model opposite="env" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!LookupEnvironment!entries'"
	 * @generated
	 */
	EList<EnvEntry> getEntries();

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!LookupEnvironment!parentEnv'"
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
	 * @model required="true" elementsType="org.eclipse.ocl.pivot.oclstdlib.Collection<NE>" elementsRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * elements->iterate(x; acc : LookupEnvironment[?] = self |\n *   acc.addElement(x))\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@<%org.eclipse.jdt.annotation.NonNull%> Executor executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@<%org.eclipse.jdt.annotation.NonNull%> IdResolver idResolver = executor.getIdResolver();\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> CollectionValue BOXED_elements = idResolver.createCollectionOfAll(<%example2.classes.lookup.EnvironmentTables%>.COL_TMPLid_, elements);\n/*@NonInvalid\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment acc = this;\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR_x = BOXED_elements.iterator();\n/*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.Nullable%> LookupEnvironment iterate;\nwhile (true) {\n    if (!ITERATOR_x.hasNext()) {\n        iterate = acc;\n        break;\n    }\n    /*@NonInvalid\052/ example2.classes.@<%org.eclipse.jdt.annotation.Nullable%> NamedElement x = (<%example2.classes.NamedElement%>)ITERATOR_x.next();\n    /**\n     * acc.addElement(x)\n     \052/\n    @SuppressWarnings(\"null\")\n    final /*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment addElement = acc.addElement(x);\n    //\n    acc = addElement;\n}\nif (iterate == null) {\n    throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null body for \\\'lookup::LookupEnvironment::addElements(NE)(Collection(addElements.NE)) : lookup::LookupEnvironment[1]\\\'\");\n}\nreturn iterate;'"
	 * @generated
	 */
	<NE extends NamedElement> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * addElementWithName(element.name, element)\n \052/\nfinal /*@Thrown\052/ java.lang.@<%org.eclipse.jdt.annotation.Nullable%> String name = element.getName();\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment addElementWithName = this.addElementWithName(name, element);\nreturn addElementWithName;'"
	 * @generated
	 */
	LookupEnvironment addElement(NamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * let entry : OrderedSet(lookup::EnvEntry) = entries->select(name = entryName)\n * in\n *   LookupEnvironment{\n *     entries = if entry = null\n *     then\n *       entries->including(\n *         EnvEntry{name = entryName, namedElements = OrderedSet{element}\n *         })\n *     else\n *       entries->excluding(entry)\n *       ->including(\n *         EnvEntry{\n *           name = entryName, namedElements = entry.namedElements->including(element)\n *         })\n *     endif\n *   }\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@<%org.eclipse.jdt.annotation.NonNull%> Executor executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@<%org.eclipse.jdt.annotation.NonNull%> IdResolver idResolver = executor.getIdResolver();\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%example2.classes.lookup.EnvEntry%>> entries = this.getEntries();\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_entries = idResolver.createOrderedSetOfAll(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_EnvEntry, entries);\n/*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%>.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetAccumulatorValue(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_EnvEntry);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1 = BOXED_entries.iterator();\n/*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue entry;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        entry = accumulator;\n        break;\n    }\n    /*@NonInvalid\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.Nullable%> EnvEntry _1 = (<%example2.classes.lookup.EnvEntry%>)ITERATOR__1.next();\n    /**\n     * name = entryName\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://cs2as/tests/example2/env/1.0\\\'::EnvEntry::name\\\'\");\n    }\n    final /*@Thrown\052/ java.lang.@<%org.eclipse.jdt.annotation.Nullable%> String name = _1.getName();\n    final /*@Thrown\052/ boolean eq = (name != null) ? name.equals(entryName) : (entryName == null);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_name_0 = idResolver.getProperty(<%example2.classes.lookup.EnvironmentTables%>.PROPid_name);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Class TYP_lookup_c_c_EnvEntry_1 = idResolver.getClass(<%example2.classes.lookup.EnvironmentTables%>.CLSSid_EnvEntry, null);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(<%example2.classes.lookup.EnvironmentTables%>.CLSSid_LookupEnvironment, null);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_entries = idResolver.getProperty(<%example2.classes.lookup.EnvironmentTables%>.PROPid_entries);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.@<%org.eclipse.jdt.annotation.NonNull%> Property CTORid_namedElements_0 = idResolver.getProperty(<%example2.classes.lookup.EnvironmentTables%>.PROPid_namedElements);\nfinal /*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> LookupEnvironment symbol_3 = (<%example2.classes.lookup.LookupEnvironment%>)TYP_lookup_c_c_LookupEnvironment_0.createInstance();\nfinal /*@Thrown\052/ boolean eq_0 = false;\n/*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue symbol_2;\nif (eq_0) {\n    final /*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> EnvEntry symbol_0 = (<%example2.classes.lookup.EnvEntry%>)TYP_lookup_c_c_EnvEntry_1.createInstance();\n    CTORid_name_0.initValue(symbol_0, entryName);\n    final /*@NonInvalid\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue OrderedSet = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetOfEach(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_NamedElement, element);\n    final <%java.util.List%><<%example2.classes.NamedElement%>> UNBOXED_OrderedSet = OrderedSet.asEcoreObjects(idResolver, <%example2.classes.NamedElement%>.class);\n    assert UNBOXED_OrderedSet != null;\n    CTORid_namedElements_0.initValue(symbol_0, UNBOXED_OrderedSet);\n    final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue including = (<%org.eclipse.ocl.pivot.values.OrderedSetValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%>.INSTANCE.evaluate(BOXED_entries, symbol_0);\n    symbol_2 = including;\n}\nelse {\n    final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue excluding = (<%org.eclipse.ocl.pivot.values.OrderedSetValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation%>.INSTANCE.evaluate(BOXED_entries, entry);\n    final /*@Thrown\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.NonNull%> EnvEntry symbol_1 = (<%example2.classes.lookup.EnvEntry%>)TYP_lookup_c_c_EnvEntry_1.createInstance();\n    CTORid_name_0.initValue(symbol_1, entryName);\n    /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%example2.classes.lookup.EnvironmentTables%>.SEQ_CLSSid_NamedElement);\n    @<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1_0 = entry.iterator();\n    /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> SequenceValue collect;\n    while (true) {\n        if (!ITERATOR__1_0.hasNext()) {\n            collect = accumulator_0;\n            break;\n        }\n        /*@NonInvalid\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.Nullable%> EnvEntry _1_0 = (<%example2.classes.lookup.EnvEntry%>)ITERATOR__1_0.next();\n        /**\n         * namedElements\n         \052/\n        if (_1_0 == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://cs2as/tests/example2/env/1.0\\\'::EnvEntry::namedElements\\\'\");\n        }\n        @SuppressWarnings(\"null\")\n        final /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%example2.classes.NamedElement%>> namedElements_0 = _1_0.getNamedElements();\n        final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_namedElements_0 = idResolver.createOrderedSetOfAll(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_NamedElement, namedElements_0);\n        //\n        for (Object value : BOXED_namedElements_0.flatten().getElements()) {\n            accumulator_0.add(value);\n        }\n    }\n    final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> SequenceValue including_0 = (<%org.eclipse.ocl.pivot.values.SequenceValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%>.INSTANCE.evaluate(collect, element);\n    final <%java.util.List%><<%example2.classes.NamedElement%>> UNBOXED_including_0 = including_0.asEcoreObjects(idResolver, <%example2.classes.NamedElement%>.class);\n    assert UNBOXED_including_0 != null;\n    CTORid_namedElements_0.initValue(symbol_1, UNBOXED_including_0);\n    final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue including_1 = (<%org.eclipse.ocl.pivot.values.OrderedSetValue%>)<%org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation%>.INSTANCE.evaluate(excluding, symbol_1);\n    symbol_2 = including_1;\n}\nfinal <%java.util.List%><<%example2.classes.lookup.EnvEntry%>> UNBOXED_symbol_2 = symbol_2.asEcoreObjects(idResolver, <%example2.classes.lookup.EnvEntry%>.class);\nassert UNBOXED_symbol_2 != null;\nCTORid_entries.initValue(symbol_3, UNBOXED_symbol_2);\nreturn symbol_3;'"
	 * @generated
	 */
	LookupEnvironment addElementWithName(String entryName, NamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * let entry : OrderedSet(lookup::EnvEntry) = entries->select(name = entryName)\n * in if entry = null then OrderedSet{} else entry.namedElements endif\n \052/\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.evaluation.@<%org.eclipse.jdt.annotation.NonNull%> Executor executor = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getExecutor(this);\nfinal /*@NonInvalid\052/ org.eclipse.ocl.pivot.ids.@<%org.eclipse.jdt.annotation.NonNull%> IdResolver idResolver = executor.getIdResolver();\n@SuppressWarnings(\"null\")\nfinal /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%example2.classes.lookup.EnvEntry%>> entries = this.getEntries();\nfinal /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_entries = idResolver.createOrderedSetOfAll(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_EnvEntry, entries);\n/*@Thrown\052/ <%org.eclipse.ocl.pivot.values.OrderedSetValue%>.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createOrderedSetAccumulatorValue(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_EnvEntry);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1 = BOXED_entries.iterator();\n/*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue entry;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        entry = accumulator;\n        break;\n    }\n    /*@NonInvalid\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.Nullable%> EnvEntry _1 = (<%example2.classes.lookup.EnvEntry%>)ITERATOR__1.next();\n    /**\n     * name = entryName\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://cs2as/tests/example2/env/1.0\\\'::EnvEntry::name\\\'\");\n    }\n    final /*@Thrown\052/ java.lang.@<%org.eclipse.jdt.annotation.Nullable%> String name = _1.getName();\n    final /*@Thrown\052/ boolean eq = (name != null) ? name.equals(entryName) : (entryName == null);\n    //\n    if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\n/*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SequenceValue%>.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSequenceAccumulatorValue(<%example2.classes.lookup.EnvironmentTables%>.SEQ_CLSSid_NamedElement);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%><?> ITERATOR__1_0 = entry.iterator();\n/*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> SequenceValue collect;\nwhile (true) {\n    if (!ITERATOR__1_0.hasNext()) {\n        collect = accumulator_0;\n        break;\n    }\n    /*@NonInvalid\052/ example2.classes.lookup.@<%org.eclipse.jdt.annotation.Nullable%> EnvEntry _1_0 = (<%example2.classes.lookup.EnvEntry%>)ITERATOR__1_0.next();\n    /**\n     * namedElements\n     \052/\n    if (_1_0 == null) {\n        throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null source for \\\'\\\'http://cs2as/tests/example2/env/1.0\\\'::EnvEntry::namedElements\\\'\");\n    }\n    @SuppressWarnings(\"null\")\n    final /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%example2.classes.NamedElement%>> namedElements = _1_0.getNamedElements();\n    final /*@Thrown\052/ org.eclipse.ocl.pivot.values.@<%org.eclipse.jdt.annotation.NonNull%> OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(<%example2.classes.lookup.EnvironmentTables%>.ORD_CLSSid_NamedElement, namedElements);\n    //\n    for (Object value : BOXED_namedElements.flatten().getElements()) {\n        accumulator_0.add(value);\n    }\n}\nfinal /*@Thrown\052/ java.util.@<%org.eclipse.jdt.annotation.NonNull%> List<<%example2.classes.NamedElement%>> ECORE_collect = ((<%org.eclipse.ocl.pivot.ids.IdResolver%>.IdResolverExtension)idResolver).ecoreValueOfAll(<%example2.classes.NamedElement%>.class, collect);\nreturn (<%org.eclipse.emf.common.util.EList%><<%example2.classes.NamedElement%>>)ECORE_collect;'"
	 * @generated
	 */
	EList<NamedElement> getNamedElements(String entryName);

} // LookupEnvironment
