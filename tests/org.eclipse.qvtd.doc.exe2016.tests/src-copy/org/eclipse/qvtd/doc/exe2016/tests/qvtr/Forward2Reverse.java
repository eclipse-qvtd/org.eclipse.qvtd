/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.exe2016.tests.qvtr;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReverseFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
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
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation2_s_tests_s_forward2reverse_s_Forward2Reverse = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation2/tests/forward2reverse/Forward2Reverse", "PForward2Reverse", PForward2ReversePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/forward2reverse/1.0/DoublyLinkList", null, doublylinkedlistPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DoublyLinkedList = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("DoublyLinkedList", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("Element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Telement2element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation2_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("Telement2element", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TemptyList2emptyList = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation2_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("TemptyList2emptyList", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Tlist2list = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation2_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("Tlist2list", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_DoublyLinkedList = TypeId.SET.getSpecializedId(CLSSid_DoublyLinkedList);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Element = TypeId.SET.getSpecializedId(CLSSid_Element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Telement2element = TypeId.SET.getSpecializedId(CLSSid_Telement2element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Tlist2list = TypeId.SET.getSpecializedId(CLSSid_Tlist2list);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_Telement2element);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set_0 = ValueUtil.createSetOfEach(SET_CLSSid_Tlist2list);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Element,Telement2element> OPPOSITE_OF_Telement2element_forwardElement = new HashMap<Element,Telement2element>();
	protected final @NonNull Map<Element,Telement2element> OPPOSITE_OF_Telement2element_forwardTarget = new HashMap<Element,Telement2element>();
	protected final @NonNull Map<DoublyLinkedList,Tlist2list> OPPOSITE_OF_Tlist2list_forwardList = new HashMap<DoublyLinkedList,Tlist2list>();

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

	public Forward2Reverse(final @NonNull Executor executor) {
		super(executor, new @NonNull String[] {"middle", "forward", "reverse"}, null, classIndex2classId, classIndex2allClassIndexes);
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
	 * ::ji_Element : Set(doublylinkedlist::Element)[*|1]::jm_Telement2element : Set(PForward2Reverse::Telement2element)[*|1]::jm_Tlist2list : Set(PForward2Reverse::Tlist2list)[*|1]for loop0 : doublylinkedlist::DoublyLinkedList[1] in ji_DoublyLinkedList {
	 *     call _'m_TemptyList2emptyList_DoublyLinkedList.r0' {
	 * forwardList iterates loop0 : doublylinkedlist::DoublyLinkedList[1];
	 * }}
	 *   for loop0 : doublylinkedlist::Element[1] in ji_Element {
	 *     call _'m_Telement2element_Element.p0' {
	 * forwardElement iterates loop0 : doublylinkedlist::Element[1];
	 * jm_Telement2element appendsTo jm_Telement2element;
	 * }}
	 *   for loop0 : doublylinkedlist::DoublyLinkedList[1] in ji_DoublyLinkedList {
	 *     call _'m_Tlist2list_DoublyLinkedList.p0' {
	 * forwardList iterates loop0 : doublylinkedlist::DoublyLinkedList[1];
	 * jm_Tlist2list appendsTo jm_Tlist2list;
	 * }}
	 *   for loop0 : PForward2Reverse::Telement2element[1] in jm_Telement2element {
	 *     call _'m_Telement2element_Element.p1' {
	 * trace iterates loop0 : PForward2Reverse::Telement2element[1];
	 * }}
	 *   for loop0 : doublylinkedlist::Element[1] in ji_Element {
	 *     call _'m_Telement2element_Element.p3' {
	 * forwardTarget iterates loop0 : doublylinkedlist::Element[1];
	 * }}
	 *   for loop0 : PForward2Reverse::Tlist2list[1] in jm_Tlist2list {
	 *     call _'m_Tlist2list_DoublyLinkedList.p1' {
	 * trace iterates loop0 : PForward2Reverse::Tlist2list[1];
	 * }}
	 *   for loop0 : PForward2Reverse::Telement2element[1] in jm_Telement2element {
	 *     call _'m_Telement2element_Element.p2' {
	 * trace iterates loop0 : PForward2Reverse::Telement2element[1];
	 * }}
	 *   for loop0 : PForward2Reverse::Tlist2list[1] in jm_Tlist2list {
	 *     call _'m_Tlist2list_DoublyLinkedList.p2' {
	 * trace iterates loop0 : PForward2Reverse::Tlist2list[1];
	 * }}
	 */
	protected boolean MAP___root__()  {
		try {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_doublylinkedlist_c_c_DoublyLinkedList_0 = idResolver.getClass(CLSSid_DoublyLinkedList, null);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_DoublyLinkedList, models[1/*forward*/], TYP_doublylinkedlist_c_c_DoublyLinkedList_0);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_doublylinkedlist_c_c_Element_0 = idResolver.getClass(CLSSid_Element, null);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Element, models[1/*forward*/], TYP_doublylinkedlist_c_c_Element_0);
			// connection variables
			final SetValue.@NonNull Accumulator ji_DoublyLinkedList = createUnenforcedSetAccumulatorValue(SET_CLSSid_DoublyLinkedList);
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList iterator : ValueUtil.typedIterable(DoublyLinkedList.class, objectsOfKind)) {
				ji_DoublyLinkedList.add(iterator);
			}
			final SetValue.@NonNull Accumulator ji_Element = createUnenforcedSetAccumulatorValue(SET_CLSSid_Element);
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element iterator_0 : ValueUtil.typedIterable(Element.class, objectsOfKind_0)) {
				ji_Element.add(iterator_0);
			}
			final SetValue.@NonNull Accumulator jm_Telement2element_1 = createUnenforcedSetAccumulatorValue(SET_CLSSid_Telement2element);
			final SetValue.@NonNull Accumulator jm_Tlist2list_1 = createUnenforcedSetAccumulatorValue(SET_CLSSid_Tlist2list);
			// mapping statements
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList loop0 : ValueUtil.typedIterable(DoublyLinkedList.class, ji_DoublyLinkedList)) {
				MAP_m_TemptyList2emptyList_DoublyLinkedList_46r0(loop0);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element loop0_0 : ValueUtil.typedIterable(Element.class, ji_Element)) {
				MAP_m_Telement2element_Element_46p0(loop0_0, jm_Telement2element_1);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList loop0_1 : ValueUtil.typedIterable(DoublyLinkedList.class, ji_DoublyLinkedList)) {
				MAP_m_Tlist2list_DoublyLinkedList_46p0(loop0_1, jm_Tlist2list_1);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Telement2element loop0_2 : ValueUtil.typedIterable(Telement2element.class, jm_Telement2element_1)) {
				MAP_m_Telement2element_Element_46p1(loop0_2);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element loop0_3 : ValueUtil.typedIterable(Element.class, ji_Element)) {
				MAP_m_Telement2element_Element_46p3(loop0_3);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Tlist2list loop0_4 : ValueUtil.typedIterable(Tlist2list.class, jm_Tlist2list_1)) {
				MAP_m_Tlist2list_DoublyLinkedList_46p1(loop0_4);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Telement2element loop0_5 : ValueUtil.typedIterable(Telement2element.class, jm_Telement2element_1)) {
				MAP_m_Telement2element_Element_46p2(loop0_5);
			}
			for (org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Tlist2list loop0_6 : ValueUtil.typedIterable(Tlist2list.class, jm_Tlist2list_1)) {
				MAP_m_Tlist2list_DoublyLinkedList_46p2(loop0_6);
			}
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP___root__", e);
		}
	}

	/**
	 *
	 * map _'m_Telement2element_Element.p0' in Forward2Reverse {
	 * guard:forward forwardElement  : doublylinkedlist::Element[1];
	 * append jm_Telement2element  : Set(PForward2Reverse::Telement2element)[*|1];
	 * var elementName : String[1] := forwardElement.name;
	 * var forwardList : doublylinkedlist::DoublyLinkedList[1] := forwardElement.list;
	 * var forwardTarget : doublylinkedlist::Element[1] := forwardElement.target;
	 * new:middle trace : PForward2Reverse::Telement2element[1];
	 * set trace.forwardElement := forwardElement;
	 * set trace.elementName := elementName;
	 * set trace.forwardList := forwardList;
	 * set trace.forwardTarget := forwardTarget;
	 * add jm_Telement2element += trace;
	 *
	 */
	protected boolean MAP_m_Telement2element_Element_46p0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardElement, final SetValue.@NonNull Accumulator jm_Telement2element)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = forwardElement.getName();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList list = forwardElement.getList();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element target = forwardElement.getTarget();
			// creations
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element trace_3 = PForward2ReverseFactory.eINSTANCE.createTelement2element();
			assert trace_3 != null;
			models[0/*middle*/].add(trace_3);
			// mapping statements
			OPPOSITE_OF_Telement2element_forwardElement.put(forwardElement, trace_3);
			trace_3.setForwardElement(forwardElement);
			trace_3.setElementName(name);
			trace_3.setForwardList(list);
			OPPOSITE_OF_Telement2element_forwardTarget.put(target, trace_3);
			trace_3.setForwardTarget(target);
			jm_Telement2element.add(trace_3);
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Telement2element_Element_p0 = ValueUtil.TRUE_VALUE;
			return m_Telement2element_Element_p0;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Telement2element_Element_46p0", e);
		}
	}

	/**
	 *
	 * map _'m_Telement2element_Element.p1' in Forward2Reverse {
	 * guard:middle trace  : PForward2Reverse::Telement2element[1];
	 * var elementName : String[1] := trace.elementName;
	 * var forwardList : doublylinkedlist::DoublyLinkedList[1] := trace.forwardList;
	 * var forwardTarget : doublylinkedlist::Element[1] := trace.forwardTarget;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var when_Tlist2list : PForward2Reverse::Tlist2list[1] := forwardList.Tlist2list;
	 * new:reverse reverseElement : doublylinkedlist::Element[1];
	 * set trace.reverseElement := reverseElement;
	 * set reverseElement.name := elementName;
	 *
	 */
	protected boolean MAP_m_Telement2element_Element_46p1(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Telement2element trace)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String elementName = trace.getElementName();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList_1 = trace.getForwardList();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardTarget_0 = trace.getForwardTarget();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardElement.get(forwardTarget_0);
			final /*@Thrown*/ boolean symbol_0 = Telement2element != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Telement2element;
			if (symbol_0) {
				if (Telement2element == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Tlist2list Tlist2list = OPPOSITE_OF_Tlist2list_forwardList.get(forwardList_1);
				final /*@Thrown*/ boolean symbol_1 = Tlist2list != null;
				/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Tlist2list;
				if (symbol_1) {
					if (Tlist2list == null) {
						throw new InvalidValueException("Null where non-null value required");
					}
					// creations
					final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element reverseElement = doublylinkedlistFactory.eINSTANCE.createElement();
					assert reverseElement != null;
					models[2/*reverse*/].add(reverseElement);
					// mapping statements
					trace.setReverseElement(reverseElement);
					reverseElement.setName(elementName);
					final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Telement2element_Element_p1 = ValueUtil.TRUE_VALUE;
					raw_when_Tlist2list = m_Telement2element_Element_p1;
				}
				else {
					raw_when_Tlist2list = ValueUtil.FALSE_VALUE;
				}
				raw_when_Telement2element = raw_when_Tlist2list;
			}
			else {
				raw_when_Telement2element = ValueUtil.FALSE_VALUE;
			}
			return raw_when_Telement2element;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Telement2element_Element_46p1", e);
		}
	}

	/**
	 *
	 * map _'m_Telement2element_Element.p2' in Forward2Reverse {
	 * guard:middle trace  : PForward2Reverse::Telement2element[1];
	 * var forwardList : doublylinkedlist::DoublyLinkedList[1] := trace.forwardList;
	 * var reverseElement : doublylinkedlist::Element[1] := trace.reverseElement;
	 * var when_Tlist2list : PForward2Reverse::Tlist2list[1] := forwardList.Tlist2list;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := when_Tlist2list.reverseList;
	 * set reverseElement.list := reverseList;
	 * set trace.reverseList := reverseList;
	 *
	 */
	protected boolean MAP_m_Telement2element_Element_46p2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Telement2element trace_0)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList_1 = trace_0.getForwardList();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element reverseElement = trace_0.getReverseElement();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Tlist2list Tlist2list = OPPOSITE_OF_Tlist2list_forwardList.get(forwardList_1);
			final /*@Thrown*/ boolean symbol_0 = Tlist2list != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Tlist2list;
			if (symbol_0) {
				if (Tlist2list == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList reverseList = Tlist2list.getReverseList();
				// mapping statements
				reverseElement.setList(reverseList);
				trace_0.setReverseList(reverseList);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Telement2element_Element_p2 = ValueUtil.TRUE_VALUE;
				raw_when_Tlist2list = m_Telement2element_Element_p2;
			}
			else {
				raw_when_Tlist2list = ValueUtil.FALSE_VALUE;
			}
			return raw_when_Tlist2list;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Telement2element_Element_46p2", e);
		}
	}

	/**
	 *
	 * map _'m_Telement2element_Element.p3' in Forward2Reverse {
	 * guard:forward forwardTarget  : doublylinkedlist::Element[1];
	 * var trace : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var reverseElement : doublylinkedlist::Element[1] := trace.reverseElement;
	 * var reverseSource : doublylinkedlist::Element[1] := when_Telement2element.reverseElement;
	 * set trace.reverseSource := reverseSource;
	 * set reverseElement.source := reverseSource;
	 *
	 */
	protected boolean MAP_m_Telement2element_Element_46p3(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardTarget)  {
		try {
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardTarget.get(forwardTarget);
			final /*@Thrown*/ boolean symbol_0 = Telement2element != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_trace;
			if (symbol_0) {
				if (Telement2element == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element Telement2element_0 = OPPOSITE_OF_Telement2element_forwardElement.get(forwardTarget);
				final /*@Thrown*/ boolean symbol_1 = Telement2element_0 != null;
				/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Telement2element;
				if (symbol_1) {
					if (Telement2element_0 == null) {
						throw new InvalidValueException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element reverseElement = Telement2element.getReverseElement();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element reverseElement_0 = Telement2element_0.getReverseElement();
					// mapping statements
					Telement2element.setReverseSource(reverseElement_0);
					reverseElement.setSource(reverseElement_0);
					final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Telement2element_Element_p3 = ValueUtil.TRUE_VALUE;
					raw_when_Telement2element = m_Telement2element_Element_p3;
				}
				else {
					raw_when_Telement2element = ValueUtil.FALSE_VALUE;
				}
				raw_trace = raw_when_Telement2element;
			}
			else {
				raw_trace = ValueUtil.FALSE_VALUE;
			}
			return raw_trace;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Telement2element_Element_46p3", e);
		}
	}

	/**
	 *
	 * map _'m_TemptyList2emptyList_DoublyLinkedList.r0' in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * var listName : String[1] := forwardList.name;
	 * check forwardList.headElement = null;
	 * new:reverse reverseList : doublylinkedlist::DoublyLinkedList[1];
	 * new:middle trace : PForward2Reverse::TemptyList2emptyList[1];
	 * set reverseList.headElement := null;
	 * set trace.forwardList := forwardList;
	 * set trace.reverseList := reverseList;
	 * set reverseList.name := listName;
	 * set trace.listName := listName;
	 *
	 */
	protected boolean MAP_m_TemptyList2emptyList_DoublyLinkedList_46r0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = forwardList.getName();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element headElement = forwardList.getHeadElement();
			final /*@Thrown*/ boolean symbol_0 = headElement == null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
			if (symbol_0) {
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable DoublyLinkedList reverseList = doublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
				assert reverseList != null;
				models[2/*reverse*/].add(reverseList);
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable TemptyList2emptyList trace_3 = PForward2ReverseFactory.eINSTANCE.createTemptyList2emptyList();
				assert trace_3 != null;
				models[0/*middle*/].add(trace_3);
				// mapping statements
				reverseList.setHeadElement(null);
				trace_3.setForwardList(forwardList);
				trace_3.setReverseList(reverseList);
				reverseList.setName(name);
				trace_3.setListName(name);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_TemptyList2emptyList_DoublyLinkedList_r0 = ValueUtil.TRUE_VALUE;
				symbol_7 = m_TemptyList2emptyList_DoublyLinkedList_r0;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_TemptyList2emptyList_DoublyLinkedList_46r0", e);
		}
	}

	/**
	 *
	 * map _'m_Tlist2list_DoublyLinkedList.p0' in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * append jm_Tlist2list  : Set(PForward2Reverse::Tlist2list)[*|1];
	 * var forwardHead : doublylinkedlist::Element[1] := forwardList.headElement;
	 * var listName : String[1] := forwardList.name;
	 * new:middle trace : PForward2Reverse::Tlist2list[1];
	 * set trace.forwardList := forwardList;
	 * set trace.listName := listName;
	 * set trace.forwardHead := forwardHead;
	 * add jm_Tlist2list += trace;
	 *
	 */
	protected boolean MAP_m_Tlist2list_DoublyLinkedList_46p0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList forwardList_0, final SetValue.@NonNull Accumulator jm_Tlist2list)  {
		try {
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable Element headElement = forwardList_0.getHeadElement();
			final /*@Thrown*/ boolean symbol_0 = headElement != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_forwardHead;
			if (symbol_0) {
				if (headElement == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String name = forwardList_0.getName();
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Tlist2list trace_3 = PForward2ReverseFactory.eINSTANCE.createTlist2list();
				assert trace_3 != null;
				models[0/*middle*/].add(trace_3);
				// mapping statements
				OPPOSITE_OF_Tlist2list_forwardList.put(forwardList_0, trace_3);
				trace_3.setForwardList(forwardList_0);
				trace_3.setListName(name);
				trace_3.setForwardHead(headElement);
				jm_Tlist2list.add(trace_3);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Tlist2list_DoublyLinkedList_p0 = ValueUtil.TRUE_VALUE;
				raw_forwardHead = m_Tlist2list_DoublyLinkedList_p0;
			}
			else {
				raw_forwardHead = ValueUtil.FALSE_VALUE;
			}
			return raw_forwardHead;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Tlist2list_DoublyLinkedList_46p0", e);
		}
	}

	/**
	 *
	 * map _'m_Tlist2list_DoublyLinkedList.p1' in Forward2Reverse {
	 * guard:middle trace  : PForward2Reverse::Tlist2list[1];
	 * var forwardHead : doublylinkedlist::Element[1] := trace.forwardHead;
	 * var listName : String[1] := trace.listName;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardHead.Telement2element;
	 * new:reverse reverseList : doublylinkedlist::DoublyLinkedList[1];
	 * set trace.reverseList := reverseList;
	 * set reverseList.name := listName;
	 *
	 */
	protected boolean MAP_m_Tlist2list_DoublyLinkedList_46p1(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Tlist2list trace_1)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardHead = trace_1.getForwardHead();
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String listName = trace_1.getListName();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardElement.get(forwardHead);
			final /*@Thrown*/ boolean symbol_0 = Telement2element != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Telement2element;
			if (symbol_0) {
				if (Telement2element == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.Nullable DoublyLinkedList reverseList = doublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
				assert reverseList != null;
				models[2/*reverse*/].add(reverseList);
				// mapping statements
				trace_1.setReverseList(reverseList);
				reverseList.setName(listName);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Tlist2list_DoublyLinkedList_p1 = ValueUtil.TRUE_VALUE;
				raw_when_Telement2element = m_Tlist2list_DoublyLinkedList_p1;
			}
			else {
				raw_when_Telement2element = ValueUtil.FALSE_VALUE;
			}
			return raw_when_Telement2element;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Tlist2list_DoublyLinkedList_46p1", e);
		}
	}

	/**
	 *
	 * map _'m_Tlist2list_DoublyLinkedList.p2' in Forward2Reverse {
	 * guard:middle trace  : PForward2Reverse::Tlist2list[1];
	 * var forwardHead : doublylinkedlist::Element[1] := trace.forwardHead;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := trace.reverseList;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardHead.Telement2element;
	 * var reverseHead : doublylinkedlist::Element[1] := when_Telement2element.reverseElement;
	 * set reverseList.headElement := reverseHead;
	 * set trace.reverseHead := reverseHead;
	 *
	 */
	protected boolean MAP_m_Tlist2list_DoublyLinkedList_46p2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.NonNull Tlist2list trace_2)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element forwardHead = trace_2.getForwardHead();
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull DoublyLinkedList reverseList = trace_2.getReverseList();
			final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.@org.eclipse.jdt.annotation.Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardElement.get(forwardHead);
			final /*@Thrown*/ boolean symbol_0 = Telement2element != null;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_when_Telement2element;
			if (symbol_0) {
				if (Telement2element == null) {
					throw new InvalidValueException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.@org.eclipse.jdt.annotation.NonNull Element reverseElement = Telement2element.getReverseElement();
				// mapping statements
				reverseList.setHeadElement(reverseElement);
				trace_2.setReverseHead(reverseElement);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Tlist2list_DoublyLinkedList_p2 = ValueUtil.TRUE_VALUE;
				raw_when_Telement2element = m_Tlist2list_DoublyLinkedList_p2;
			}
			else {
				raw_when_Telement2element = ValueUtil.FALSE_VALUE;
			}
			return raw_when_Telement2element;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Tlist2list_DoublyLinkedList_46p2", e);
		}
	}
}
