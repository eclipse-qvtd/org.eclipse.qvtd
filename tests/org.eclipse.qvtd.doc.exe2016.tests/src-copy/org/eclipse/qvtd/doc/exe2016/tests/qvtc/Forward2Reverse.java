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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;

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
@SuppressWarnings("unused")
public class Forward2Reverse extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList", null, DoublylinkedlistPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/List2List", null, List2listPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DoublyLinkedList = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("DoublyLinkedList", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("Element", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Element2Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List.getClassId("Element2Element", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_List2List = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_forward2reverse_s_1_0_s_List2List.getClassId("List2List", 0);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_element1 = CLSSid_Element2Element.getPropertyId("element1");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_list1 = CLSSid_List2List.getPropertyId("list1");

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Element,Element2Element> OPPOSITE_OF_Element2Element_element1 = new HashMap<Element,Element2Element>();
	protected final @NonNull Map<DoublyLinkedList,List2List> OPPOSITE_OF_List2List_list1 = new HashMap<DoublyLinkedList,List2List>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_list1,		// 0 => list1
		PROPid_element1		// 1 => element1
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_DoublyLinkedList,              // 0 => DoublyLinkedList
		CLSSid_Element                        // 1 => Element
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0},                          // 0 : DoublyLinkedList -> {DoublyLinkedList}
		{1}                           // 1 : Element -> {Element}
	};


	public Forward2Reverse(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"forward", "reverse", "middle", "$primitive$"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_DoublyLinkedList = models[0/*forward*/].getConnection(0/*doublylinkedlist::DoublyLinkedList*/);
		final @NonNull Connection ji_Element = models[0/*forward*/].getConnection(1/*doublylinkedlist::Element*/);
		return MAP___root__(ji_DoublyLinkedList, ji_Element) && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in Forward2Reverse {
	 *
	 *   append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * append ji_Element  : doublylinkedlist::Element[1];
	 * ::jm_Element2Element : list2list::Element2Element[1]::jm_List2List : list2list::List2List[1]install m_Element2Element_element1_name_p0 {
	 * jm_Element2Element appendsTo jm_Element2Element;
	 * source consumes append ji_Element  : doublylinkedlist::Element[1];
	 * ;
	 * }
	 *   install m_List2List_list1_name_p0 {
	 * forwardList consumes append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * ;
	 * jm_List2List appendsTo jm_List2List;
	 * }
	 *   install m_Element2Element_element2_list2list_p1 {
	 * element2element consumes ::jm_Element2Element : list2list::Element2Element[1];
	 * }
	 *   install m_Element2Element__source_target_p3 {
	 * forwardElement consumes append ji_Element  : doublylinkedlist::Element[1];
	 * ;
	 * }
	 *   install m_List2List_list2_p1 {
	 * list2list1 consumes ::jm_List2List : list2list::List2List[1];
	 * }
	 *   install m_Element2Element__list_p2 {
	 * element2element consumes ::jm_Element2Element : list2list::Element2Element[1];
	 * }
	 *   install m_List2List__headElement_p2 {
	 * forwardList consumes append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * ;
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_DoublyLinkedList, final @NonNull Connection ji_Element)  {
		try {
			// connection variables
			final @NonNull Connection jm_Element2Element_1 = createConnection("jm_Element2Element", CLSSid_Element2Element, false);
			final @NonNull Connection jm_List2List_1 = createConnection("jm_List2List", CLSSid_List2List, false);
			// mapping statements
			for (@NonNull Element source_0 : ji_Element.typedIterable(Element.class)) {
				MAP_m_Element2Element_element1_name_p0(jm_Element2Element_1, source_0);
			}
			for (@NonNull DoublyLinkedList forwardList_1 : ji_DoublyLinkedList.typedIterable(DoublyLinkedList.class)) {
				MAP_m_List2List_list1_name_p0(forwardList_1, jm_List2List_1);
			}
			for (@NonNull Element2Element element2element_1 : jm_Element2Element_1.typedIterable(Element2Element.class)) {
				MAP_m_Element2Element_element2_list2list_p1(element2element_1);
			}
			for (@NonNull Element forwardElement_0 : ji_Element.typedIterable(Element.class)) {
				MAP_m_Element2Element__source_target_p3(forwardElement_0);
			}
			for (@NonNull List2List list2list1_0 : jm_List2List_1.typedIterable(List2List.class)) {
				MAP_m_List2List_list2_p1(list2list1_0);
			}
			for (@NonNull Element2Element element2element_2 : jm_Element2Element_1.typedIterable(Element2Element.class)) {
				MAP_m_Element2Element__list_p2(element2element_2);
			}
			for (@NonNull DoublyLinkedList forwardList_2 : ji_DoublyLinkedList.typedIterable(DoublyLinkedList.class)) {
				MAP_m_List2List__headElement_p2(forwardList_2);
			}
			final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP___root__", e);
		}
	}

	/**
	 *
	 * map m_Element2Element_element1_name_p0 in Forward2Reverse {
	 * guard:forward source  : doublylinkedlist::Element[1];
	 * append jm_Element2Element  : list2list::Element2Element[1];
	 * var forwardElement : doublylinkedlist::Element[1] := source.target;
	 * var list : doublylinkedlist::DoublyLinkedList[1] := forwardElement.list;
	 * var name : String[1] := forwardElement.name;
	 * contained new:middle element2element : list2list::Element2Element[1];
	 * set element2element.element1 := forwardElement;
	 * set element2element.name := name;
	 * add jm_Element2Element += element2element;
	 *
	 */
	protected boolean MAP_m_Element2Element_element1_name_p0(final @NonNull Connection jm_Element2Element, final /*@NonInvalid*/ @NonNull Element source)  {
		try {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element target = source.getTarget();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DoublyLinkedList list = target.getList();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = target.getName();
			// creations
			final @SuppressWarnings("null")@NonNull Element2Element element2element_1 = List2listFactory.eINSTANCE.createElement2Element();
			models[2/*middle*/].add(element2element_1, true);
			// mapping statements
			OPPOSITE_OF_Element2Element_element1.put(target, element2element_1);
			element2element_1.setElement1(target);
			element2element_1.setName(name);
			jm_Element2Element.appendElement(element2element_1);
			final /*@Thrown*/ @Nullable Boolean m_Element2Element_element1_name_p0 = ValueUtil.TRUE_VALUE;
			return m_Element2Element_element1_name_p0;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_element1_name_p0", e);
		}
	}

	/**
	 *
	 * map m_List2List_list1_name_p0 in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * append jm_List2List  : list2list::List2List[1];
	 * var headElement : doublylinkedlist::Element[?] := forwardList.headElement;
	 * var name : String[1] := forwardList.name;
	 * new:middle list2list1 : list2list::List2List[1];
	 * set list2list1.list1 := forwardList;
	 * set list2list1.name := name;
	 * add jm_List2List += list2list1;
	 *
	 */
	protected boolean MAP_m_List2List_list1_name_p0(final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList, final @NonNull Connection jm_List2List)  {
		try {
			final /*@NonInvalid*/ @Nullable Element headElement = forwardList.getHeadElement();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = forwardList.getName();
			// creations
			final @SuppressWarnings("null")@NonNull List2List list2list1_0 = List2listFactory.eINSTANCE.createList2List();
			models[2/*middle*/].add(list2list1_0, false);
			// mapping statements
			OPPOSITE_OF_List2List_list1.put(forwardList, list2list1_0);
			list2list1_0.setList1(forwardList);
			list2list1_0.setName(name);
			jm_List2List.appendElement(list2list1_0);
			final /*@Thrown*/ @Nullable Boolean m_List2List_list1_name_p0 = ValueUtil.TRUE_VALUE;
			return m_List2List_list1_name_p0;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List_list1_name_p0", e);
		}
	}

	/**
	 *
	 * map m_Element2Element_element2_list2list_p1 in Forward2Reverse {
	 * guard:middle element2element  : list2list::Element2Element[1];
	 * var forwardElement : doublylinkedlist::Element[1] := element2element.element1;
	 * var name : String[1] := element2element.name;
	 * var list : doublylinkedlist::DoublyLinkedList[1] := forwardElement.list;
	 * var source : doublylinkedlist::Element[1] := forwardElement.source;
	 * var middle1 : list2list::List2List[1] := list.middle1;
	 * var middle11 : list2list::Element2Element[1] := source.middle1;
	 * check name = forwardElement.name;
	 * contained new:reverse reverseElement : doublylinkedlist::Element[1];
	 * set element2element.element2 := reverseElement;
	 * set reverseElement.name := name;
	 * set element2element.list2list := middle1;
	 *
	 */
	protected boolean MAP_m_Element2Element_element2_list2list_p1(final /*@NonInvalid*/ @NonNull Element2Element element2element)  {
		try {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element element1 = element2element.getElement1();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = element2element.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DoublyLinkedList list = element1.getList();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element source_0 = element1.getSource();
			final /*@NonInvalid*/ @NonNull List2List middle1 = ClassUtil.nonNullState (OPPOSITE_OF_List2List_list1.get(list));
			final /*@NonInvalid*/ @NonNull Element2Element middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(source_0));
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_0 = element1.getName();
			final /*@NonInvalid*/ boolean symbol_0 = name.equals(name_0);
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				// creations
				final @SuppressWarnings("null")@NonNull Element reverseElement = DoublylinkedlistFactory.eINSTANCE.createElement();
				models[1/*reverse*/].add(reverseElement, true);
				// mapping statements
				element2element.setElement2(reverseElement);
				reverseElement.setName(name);
				element2element.setList2list(middle1);
				final /*@Thrown*/ @Nullable Boolean m_Element2Element_element2_list2list_p1 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_Element2Element_element2_list2list_p1;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			return symbol_5;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element_element2_list2list_p1", e);
		}
	}

	/**
	 *
	 * map m_Element2Element__source_target_p3 in Forward2Reverse {
	 * guard:forward forwardElement  : doublylinkedlist::Element[1];
	 * var element2element : list2list::Element2Element[1] := forwardElement.middle1;
	 * var source : doublylinkedlist::Element[1] := forwardElement.source;
	 * var middle1 : list2list::Element2Element[1] := source.middle1;
	 * var reverseElement : doublylinkedlist::Element[1] := element2element.element2;
	 * var element2 : doublylinkedlist::Element[1] := middle1.element2;
	 * set reverseElement.target := element2;
	 *
	 */
	protected boolean MAP_m_Element2Element__source_target_p3(final /*@NonInvalid*/ @NonNull Element forwardElement)  {
		try {
			final /*@NonInvalid*/ @NonNull Element2Element middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(forwardElement));
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element source_0 = forwardElement.getSource();
			final /*@NonInvalid*/ @NonNull Element2Element middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(source_0));
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element element2 = middle1.getElement2();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element element2_0 = middle1_0.getElement2();
			// mapping statements
			element2.setTarget(element2_0);
			final /*@Thrown*/ @Nullable Boolean m_Element2Element__source_target_p3 = ValueUtil.TRUE_VALUE;
			return m_Element2Element__source_target_p3;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element__source_target_p3", e);
		}
	}

	/**
	 *
	 * map m_List2List_list2_p1 in Forward2Reverse {
	 * guard:middle list2list1  : list2list::List2List[1];
	 * var name : String[1] := list2list1.name;
	 * new:reverse reverseList : doublylinkedlist::DoublyLinkedList[1];
	 * set list2list1.list2 := reverseList;
	 * set reverseList.name := name;
	 *
	 */
	protected boolean MAP_m_List2List_list2_p1(final /*@NonInvalid*/ @NonNull List2List list2list1)  {
		try {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = list2list1.getName();
			// creations
			final @SuppressWarnings("null")@NonNull DoublyLinkedList reverseList = DoublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
			models[1/*reverse*/].add(reverseList, false);
			// mapping statements
			list2list1.setList2(reverseList);
			reverseList.setName(name);
			final /*@Thrown*/ @Nullable Boolean m_List2List_list2_p1 = ValueUtil.TRUE_VALUE;
			return m_List2List_list2_p1;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List_list2_p1", e);
		}
	}

	/**
	 *
	 * map m_Element2Element__list_p2 in Forward2Reverse {
	 * guard:middle element2element  : list2list::Element2Element[1];
	 * var middle1 : list2list::List2List[1] := element2element.list2list;
	 * var reverseElement : doublylinkedlist::Element[1] := element2element.element2;
	 * var list2 : doublylinkedlist::DoublyLinkedList[1] := middle1.list2;
	 * set reverseElement.list := list2;
	 *
	 */
	protected boolean MAP_m_Element2Element__list_p2(final /*@NonInvalid*/ @NonNull Element2Element element2element_0)  {
		try {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List2List list2list = element2element_0.getList2list();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Element element2 = element2element_0.getElement2();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DoublyLinkedList list2 = list2list.getList2();
			// mapping statements
			element2.setList(list2);
			final /*@Thrown*/ @Nullable Boolean m_Element2Element__list_p2 = ValueUtil.TRUE_VALUE;
			return m_Element2Element__list_p2;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Element2Element__list_p2", e);
		}
	}

	/**
	 *
	 * map m_List2List__headElement_p2 in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * var headElement : doublylinkedlist::Element[?] := forwardList.headElement;
	 * var list2list1 : list2list::List2List[1] := forwardList.middle1;
	 * var middle1 : list2list::Element2Element[1] := headElement.middle1;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := list2list1.list2;
	 * var element2 : doublylinkedlist::Element[1] := middle1.element2;
	 * set reverseList.headElement := element2;
	 *
	 */
	protected boolean MAP_m_List2List__headElement_p2(final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList_0)  {
		try {
			final /*@NonInvalid*/ @Nullable Element headElement = forwardList_0.getHeadElement();
			final /*@NonInvalid*/ @NonNull List2List middle1 = ClassUtil.nonNullState (OPPOSITE_OF_List2List_list1.get(forwardList_0));
			if (headElement == null) {
				throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList\'::Element::middle1\'");
			}
			final /*@Thrown*/ @NonNull Element2Element middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Element2Element_element1.get(headElement));
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DoublyLinkedList list2 = middle1.getList2();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull Element element2 = middle1_0.getElement2();
			// mapping statements
			list2.setHeadElement(element2);
			final /*@Thrown*/ @Nullable Boolean m_List2List__headElement_p2 = ValueUtil.TRUE_VALUE;
			return m_List2List__headElement_p2;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_List2List__headElement_p2", e);
		}
	}
}
