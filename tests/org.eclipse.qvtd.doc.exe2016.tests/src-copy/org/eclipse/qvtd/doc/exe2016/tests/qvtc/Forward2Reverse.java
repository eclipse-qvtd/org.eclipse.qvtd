/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.exe2016.tests.qvtc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation;

/**
 * The Forward2Reverse transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootObjects(String)}
 */
@SuppressWarnings("nls")
public class Forward2Reverse extends AbstractTransformer
{
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList", null, DoublylinkedlistPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/List2List", null, List2listPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DoublyLinkedList = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("DoublyLinkedList", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("Element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element2Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List.getClassId("Element2Element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_List2List = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List.getClassId("List2List", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_DoublyLinkedList = TypeId.SET.getSpecializedId(CLSSid_DoublyLinkedList);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Element = TypeId.SET.getSpecializedId(CLSSid_Element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Element2Element = TypeId.SET.getSpecializedId(CLSSid_Element2Element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_List2List = TypeId.SET.getSpecializedId(CLSSid_List2List);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_Element2Element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set_0 = ValueUtil.createSetOfEach(SET_CLSSid_List2List);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Element,Element2Element> OPPOSITE_OF_Element2Element_element1 = new HashMap<Element,Element2Element>();
	protected final @NonNull Map<DoublyLinkedList,List2List> OPPOSITE_OF_List2List_list1 = new HashMap<DoublyLinkedList,List2List>();

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_DoublyLinkedList,        // 0 => DoublyLinkedList
		CLSSid_Element                  // 1 => Element
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0},                    // 0 : DoublyLinkedList -> {DoublyLinkedList}
		{1}                     // 1 : Element -> {Element}
	};


	public Forward2Reverse(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"forward", "reverse", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		return MAP___root__() && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in Forward2Reverse {
	 *
	 *   var _'\u00ABDoublyLinkedList\u00BB' : Set(doublylinkedlist::DoublyLinkedList) := forward.objectsOfKind(doublylinkedlist::DoublyLinkedList)
	 *   ;
	 * ::ji_DoublyLinkedList : Set(doublylinkedlist::DoublyLinkedList)[*|1]var _'\u00ABElement\u00BB' : Set(doublylinkedlist::Element) := forward.objectsOfKind(doublylinkedlist::Element)
	 *   ;
	 * ::ji_Element : Set(doublylinkedlist::Element)[*|1]::jm_Element2Element : Set(list2list::Element2Element)[*|1]::jm_List2List : Set(list2list::List2List)[*|1]for loop0 : doublylinkedlist::Element[1] in ji_Element {
	 *     call _'m_Element2Element_Element.p0' {
	 * jm_Element2Element appendsTo jm_Element2Element;
	 * source iterates loop0 : doublylinkedlist::Element[1];
	 * }}
	 *   for loop0 : doublylinkedlist::DoublyLinkedList[1] in ji_DoublyLinkedList {
	 *     call _'m_List2List_DoublyLinkedList.p0' {
	 * forwardList iterates loop0 : doublylinkedlist::DoublyLinkedList[1];
	 * jm_List2List appendsTo jm_List2List;
	 * }}
	 *   for loop0 : list2list::Element2Element[1] in jm_Element2Element {
	 *     call _'m_Element2Element_Element.p1' {
	 * element2element iterates loop0 : list2list::Element2Element[1];
	 * }}
	 *   for loop0 : doublylinkedlist::Element[1] in ji_Element {
	 *     call _'m_Element2Element_Element.p3' {
	 * forwardElement iterates loop0 : doublylinkedlist::Element[1];
	 * }}
	 *   for loop0 : list2list::List2List[1] in jm_List2List {
	 *     call _'m_List2List_DoublyLinkedList.p1' {
	 * list2list iterates loop0 : list2list::List2List[1];
	 * }}
	 *   for loop0 : list2list::Element2Element[1] in jm_Element2Element {
	 *     call _'m_Element2Element_Element.p2' {
	 * element2element iterates loop0 : list2list::Element2Element[1];
	 * }}
	 *   for loop0 : doublylinkedlist::DoublyLinkedList[1] in ji_DoublyLinkedList {
	 *     call _'m_List2List_DoublyLinkedList.p2' {
	 * forwardList iterates loop0 : doublylinkedlist::DoublyLinkedList[1];
	 * }}
	 */
	protected boolean MAP___root__()  {
		try {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_doublylinkedlist_c_c_DoublyLinkedList_0 = idResolver.getClass(CLSSid_DoublyLinkedList, null);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_DoublyLinkedList, models[0/*forward*/], TYP_doublylinkedlist_c_c_DoublyLinkedList_0);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_doublylinkedlist_c_c_Element_0 = idResolver.getClass(CLSSid_Element, null);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Element, models[0/*forward*/], TYP_doublylinkedlist_c_c_Element_0);
			// connection variables
			final SetValue.@NonNull Accumulator ji_DoublyLinkedList = createUnenforcedSetAccumulatorValue(SET_CLSSid_DoublyLinkedList);
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList iterator : ValueUtil.typedIterable(DoublyLinkedList.class, objectsOfKind)) {
				ji_DoublyLinkedList.add(iterator);
			}
			final SetValue.@NonNull Accumulator ji_Element = createUnenforcedSetAccumulatorValue(SET_CLSSid_Element);
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element iterator_0 : ValueUtil.typedIterable(Element.class, objectsOfKind_0)) {
				ji_Element.add(iterator_0);
			}
			final SetValue.@NonNull Accumulator jm_Element2Element_1 = createUnenforcedSetAccumulatorValue(SET_CLSSid_Element2Element);
			final SetValue.@NonNull Accumulator jm_List2List_1 = createUnenforcedSetAccumulatorValue(SET_CLSSid_List2List);
			// mapping statements
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element loop0 : ValueUtil.typedIterable(Element.class, ji_Element)) {
				MAP_m_Element2Element_Element_46p0(jm_Element2Element_1, loop0);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList loop0_0 : ValueUtil.typedIterable(DoublyLinkedList.class, ji_DoublyLinkedList)) {
				MAP_m_List2List_DoublyLinkedList_46p0(loop0_0, jm_List2List_1);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element loop0_1 : ValueUtil.typedIterable(Element2Element.class, jm_Element2Element_1)) {
				MAP_m_Element2Element_Element_46p1(loop0_1);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element loop0_2 : ValueUtil.typedIterable(Element.class, ji_Element)) {
				MAP_m_Element2Element_Element_46p3(loop0_2);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull List2List loop0_3 : ValueUtil.typedIterable(List2List.class, jm_List2List_1)) {
				MAP_m_List2List_DoublyLinkedList_46p1(loop0_3);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element loop0_4 : ValueUtil.typedIterable(Element2Element.class, jm_Element2Element_1)) {
				MAP_m_Element2Element_Element_46p2(loop0_4);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList loop0_5 : ValueUtil.typedIterable(DoublyLinkedList.class, ji_DoublyLinkedList)) {
				MAP_m_List2List_DoublyLinkedList_46p2(loop0_5);
			}
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP___root__", e);
		}
	}

	/**
	 *
	 * map _'m_Element2Element_Element.p0' in Forward2Reverse {
	 * guard:forward source  : doublylinkedlist::Element[1];
	 * append jm_Element2Element  : Set(list2list::Element2Element)[*|1];
	 * var forwardElement : doublylinkedlist::Element[1] := source.target;
	 * var list : doublylinkedlist::DoublyLinkedList[1] := forwardElement.list;
	 * var name : String[1] := forwardElement.name;
	 * new:middle element2element : list2list::Element2Element[1];
	 * set element2element.element1 := forwardElement;
	 * set element2element.name := name;
	 * add jm_Element2Element += element2element;
	 *
	 */
	protected boolean MAP_m_Element2Element_Element_46p0(final SetValue.@NonNull Accumulator jm_Element2Element, final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element source)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element target = source.getTarget();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList list = target.getList();
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = target.getName();
			// creations
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.Nullable Element2Element element2element_1 = List2listFactory.eINSTANCE.createElement2Element();
			assert element2element_1 != null;
			models[2/*middle*/].add(element2element_1);
			// mapping statements
			OPPOSITE_OF_Element2Element_element1.put(target, element2element_1);
			element2element_1.setElement1(target);
			element2element_1.setName(name);
			jm_Element2Element.add(element2element_1);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Element2Element_Element_p0 = ValueUtil.TRUE_VALUE;
			return m_Element2Element_Element_p0;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_Element_46p0", e);
		}
	}

	/**
	 *
	 * map _'m_Element2Element_Element.p1' in Forward2Reverse {
	 * guard:middle element2element  : list2list::Element2Element[1];
	 * var forwardElement : doublylinkedlist::Element[1] := element2element.element1;
	 * var name : String[1] := element2element.name;
	 * var list : doublylinkedlist::DoublyLinkedList[1] := forwardElement.list;
	 * var source : doublylinkedlist::Element[1] := forwardElement.source;
	 * var middle1 : list2list::Element2Element[1] := source.middle1;
	 * var middle11 : list2list::List2List[1] := list.middle1;
	 * check name = forwardElement.name;
	 * new:reverse reverseElement : doublylinkedlist::Element[1];
	 * set element2element.element2 := reverseElement;
	 * set reverseElement.name := name;
	 * set element2element.list2list := middle11;
	 *
	 */
	protected boolean MAP_m_Element2Element_Element_46p1(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element element2element)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element element1 = element2element.getElement1();
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = element2element.getName();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList list = element1.getList();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element source_0 = element1.getSource();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(source_0));
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull List2List middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_List2List_list1.get(list));
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name_0 = element1.getName();
			final /*@Thrown*/ boolean symbol_0 = name.equals(name_0);
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
			if (symbol_0) {
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element reverseElement = DoublylinkedlistFactory.eINSTANCE.createElement();
				assert reverseElement != null;
				models[1/*reverse*/].add(reverseElement);
				// mapping statements
				element2element.setElement2(reverseElement);
				reverseElement.setName(name);
				element2element.setList2list(middle1_0);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Element2Element_Element_p1 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_Element2Element_Element_p1;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			return symbol_5;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_Element_46p1", e);
		}
	}

	/**
	 *
	 * map _'m_Element2Element_Element.p2' in Forward2Reverse {
	 * guard:middle element2element  : list2list::Element2Element[1];
	 * var middle1 : list2list::List2List[1] := element2element.list2list;
	 * var reverseElement : doublylinkedlist::Element[1] := element2element.element2;
	 * var list2 : doublylinkedlist::DoublyLinkedList[1] := middle1.list2;
	 * set reverseElement.list := list2;
	 *
	 */
	protected boolean MAP_m_Element2Element_Element_46p2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element element2element_0)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull List2List list2list_0 = element2element_0.getList2list();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element element2 = element2element_0.getElement2();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList list2 = list2list_0.getList2();
			// mapping statements
			element2.setList(list2);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Element2Element_Element_p2 = ValueUtil.TRUE_VALUE;
			return m_Element2Element_Element_p2;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_Element_46p2", e);
		}
	}

	/**
	 *
	 * map _'m_Element2Element_Element.p3' in Forward2Reverse {
	 * guard:forward forwardElement  : doublylinkedlist::Element[1];
	 * var element2element : list2list::Element2Element[1] := forwardElement.middle1;
	 * var source : doublylinkedlist::Element[1] := forwardElement.source;
	 * var middle1 : list2list::Element2Element[1] := source.middle1;
	 * var reverseElement : doublylinkedlist::Element[1] := element2element.element2;
	 * var element2 : doublylinkedlist::Element[1] := middle1.element2;
	 * set reverseElement.target := element2;
	 *
	 */
	protected boolean MAP_m_Element2Element_Element_46p3(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardElement)  {
		try {
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(forwardElement));
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element source_0 = forwardElement.getSource();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(source_0));
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element element2 = middle1.getElement2();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element element2_0 = middle1_0.getElement2();
			// mapping statements
			element2.setTarget(element2_0);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Element2Element_Element_p3 = ValueUtil.TRUE_VALUE;
			return m_Element2Element_Element_p3;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_Element_46p3", e);
		}
	}

	/**
	 *
	 * map _'m_List2List_DoublyLinkedList.p0' in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * append jm_List2List  : Set(list2list::List2List)[*|1];
	 * var headElement : doublylinkedlist::Element[?] := forwardList.headElement;
	 * var name : String[1] := forwardList.name;
	 * new:middle list2list : list2list::List2List[1];
	 * set list2list.list1 := forwardList;
	 * set list2list.name := name;
	 * add jm_List2List += list2list;
	 *
	 */
	protected boolean MAP_m_List2List_DoublyLinkedList_46p0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList, final SetValue.@NonNull Accumulator jm_List2List)  {
		try {
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element headElement = forwardList.getHeadElement();
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = forwardList.getName();
			// creations
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.Nullable List2List list2list_0 = List2listFactory.eINSTANCE.createList2List();
			assert list2list_0 != null;
			models[2/*middle*/].add(list2list_0);
			// mapping statements
			OPPOSITE_OF_List2List_list1.put(forwardList, list2list_0);
			list2list_0.setList1(forwardList);
			list2list_0.setName(name);
			jm_List2List.add(list2list_0);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_List2List_DoublyLinkedList_p0 = ValueUtil.TRUE_VALUE;
			return m_List2List_DoublyLinkedList_p0;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List_DoublyLinkedList_46p0", e);
		}
	}

	/**
	 *
	 * map _'m_List2List_DoublyLinkedList.p1' in Forward2Reverse {
	 * guard:middle list2list  : list2list::List2List[1];
	 * var name : String[1] := list2list.name;
	 * new:reverse reverseList : doublylinkedlist::DoublyLinkedList[1];
	 * set list2list.list2 := reverseList;
	 * set reverseList.name := name;
	 *
	 */
	protected boolean MAP_m_List2List_DoublyLinkedList_46p1(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull List2List list2list)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = list2list.getName();
			// creations
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable DoublyLinkedList reverseList = DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
			assert reverseList != null;
			models[1/*reverse*/].add(reverseList);
			// mapping statements
			list2list.setList2(reverseList);
			reverseList.setName(name);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_List2List_DoublyLinkedList_p1 = ValueUtil.TRUE_VALUE;
			return m_List2List_DoublyLinkedList_p1;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List_DoublyLinkedList_46p1", e);
		}
	}

	/**
	 *
	 * map _'m_List2List_DoublyLinkedList.p2' in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * var headElement : doublylinkedlist::Element[?] := forwardList.headElement;
	 * var list2list : list2list::List2List[1] := forwardList.middle1;
	 * var middle1 : list2list::Element2Element[1] := headElement.middle1;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := list2list.list2;
	 * var element2 : doublylinkedlist::Element[1] := middle1.element2;
	 * set reverseList.headElement := element2;
	 *
	 */
	protected boolean MAP_m_List2List_DoublyLinkedList_46p2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList_0)  {
		try {
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element headElement = forwardList_0.getHeadElement();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull List2List middle1 = ClassUtil.nonNullState (OPPOSITE_OF_List2List_list1.get(forwardList_0));
			if (headElement == null) {
				throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList\'::Element::middle1\'");
			}
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.@org.eclipse.jdt.annotation.NonNull Element2Element middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(headElement));
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList list2 = middle1.getList2();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element element2 = middle1_0.getElement2();
			// mapping statements
			list2.setHeadElement(element2);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_List2List_DoublyLinkedList_p2 = ValueUtil.TRUE_VALUE;
			return m_List2List_DoublyLinkedList_p2;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List_DoublyLinkedList_46p2", e);
		}
	}
}
