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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReverseFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.SlistHead2listHead;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_Forward2Reverse = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse", "PForward2Reverse", PForward2ReversePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/forward2reverse/1.0/DoublyLinkList", null, doublylinkedlistPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DoublyLinkedList = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("DoublyLinkedList", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_1_0_s_DoublyLinkList.getClassId("Element", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SlistHead2listHead = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("SlistHead2listHead", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Telement2element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("Telement2element", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Tlist2list = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("Tlist2list", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TlistHead2listHead = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_xtext_s_qvtrelation_s_tests_s_forward2reverse_s_Forward2Reverse.getClassId("TlistHead2listHead", 0);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_forwardElement = CLSSid_Telement2element.getPropertyId("forwardElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_forwardList_1 = CLSSid_Tlist2list.getPropertyId("forwardList");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_forwardList_2 = CLSSid_TlistHead2listHead.getPropertyId("forwardList");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_forwardTarget = CLSSid_Telement2element.getPropertyId("forwardTarget");

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Element,Telement2element> OPPOSITE_OF_Telement2element_forwardElement = new HashMap<Element,Telement2element>();
	protected final @NonNull Map<Element,Telement2element> OPPOSITE_OF_Telement2element_forwardTarget = new HashMap<Element,Telement2element>();
	protected final @NonNull Map<DoublyLinkedList,Tlist2list> OPPOSITE_OF_Tlist2list_forwardList = new HashMap<DoublyLinkedList,Tlist2list>();
	protected final @NonNull Map<DoublyLinkedList,TlistHead2listHead> OPPOSITE_OF_TlistHead2listHead_forwardList = new HashMap<DoublyLinkedList,TlistHead2listHead>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_forwardElement,		// 0 => forwardElement
		PROPid_forwardList_1,		// 1 => forwardList
		PROPid_forwardTarget,		// 2 => forwardTarget
		PROPid_forwardList_2		// 3 => forwardList
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
		super(executor, new @NonNull String[] {"middle", "forward", "reverse", "$primitive$"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_DoublyLinkedList = models[1/*forward*/].getConnection(0/*doublylinkedlist::DoublyLinkedList*/);
		final @NonNull Connection ji_Element = models[1/*forward*/].getConnection(1/*doublylinkedlist::Element*/);
		return MAP___root__(ji_DoublyLinkedList, ji_Element) && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in Forward2Reverse {
	 *
	 *   append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * append ji_Element  : doublylinkedlist::Element[1];
	 * ::jm_SlistHead2listHead : PForward2Reverse::SlistHead2listHead[1]::jm_Telement2element : PForward2Reverse::Telement2element[1]install m_TlistHead2listHead_forwardHead_forwardList_p0 {
	 * forwardList consumes append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * ;
	 * }
	 *   install m_Tlist2list_forwardList_listName_reverseList_where__r0 {
	 * forwardList consumes append ji_DoublyLinkedList  : doublylinkedlist::DoublyLinkedList[1];
	 * ;
	 * jm_SlistHead2listHead appendsTo jm_SlistHead2listHead;
	 * }
	 *   install m_Telement2element_elementName_forwardElement_forwar_p0 {
	 * forwardElement consumes append ji_Element  : doublylinkedlist::Element[1];
	 * ;
	 * jm_Telement2element appendsTo jm_Telement2element;
	 * }
	 *   install m_Telement2element_reverseElement_reverseList_lc {
	 * trace consumes ::jm_Telement2element : PForward2Reverse::Telement2element[1];
	 * }
	 *   install m_Telement2element_reverseSource_p3 {
	 * forwardTarget consumes append ji_Element  : doublylinkedlist::Element[1];
	 * ;
	 * }
	 *   install m_TlistHead2listHead_reverseHead_reverseList_p1 {
	 * from_SlistHead2listHead consumes ::jm_SlistHead2listHead : PForward2Reverse::SlistHead2listHead[1];
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_DoublyLinkedList, final @NonNull Connection ji_Element)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP___root__" + ", " + ji_DoublyLinkedList + ", " + ji_Element);
		}
		// connection variables
		final @NonNull Connection jm_SlistHead2listHead_1 = createConnection("jm_SlistHead2listHead", CLSSid_SlistHead2listHead, false);
		final @NonNull Connection jm_Telement2element_1 = createConnection("jm_Telement2element", CLSSid_Telement2element, false);
		// mapping statements
		for (@NonNull DoublyLinkedList forwardList_1 : ji_DoublyLinkedList.typedIterable(DoublyLinkedList.class)) {
			MAP_m_TlistHead2listHead_forwardHead_forwardList_p0(forwardList_1);
		}
		for (@NonNull DoublyLinkedList forwardList_2 : ji_DoublyLinkedList.typedIterable(DoublyLinkedList.class)) {
			MAP_m_Tlist2list_forwardList_listName_reverseList_where__r0(forwardList_2, jm_SlistHead2listHead_1);
		}
		for (@NonNull Element forwardElement_0 : ji_Element.typedIterable(Element.class)) {
			MAP_m_Telement2element_elementName_forwardElement_forwar_p0(forwardElement_0, jm_Telement2element_1);
		}
		for (@NonNull Telement2element trace_0 : jm_Telement2element_1.typedIterable(Telement2element.class)) {
			MAP_m_Telement2element_reverseElement_reverseList_lc(trace_0);
		}
		for (@NonNull Element forwardTarget_0 : ji_Element.typedIterable(Element.class)) {
			MAP_m_Telement2element_reverseSource_p3(forwardTarget_0);
		}
		for (@NonNull SlistHead2listHead from_SlistHead2listHead_0 : jm_SlistHead2listHead_1.typedIterable(SlistHead2listHead.class)) {
			MAP_m_TlistHead2listHead_reverseHead_reverseList_p1(from_SlistHead2listHead_0);
		}
		final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((__root__ ? "done "  : "fail ") + "MAP___root__");
		}
		return __root__;
	}

	/**
	 *
	 * map m_TlistHead2listHead_forwardHead_forwardList_p0 in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * var forwardHead : doublylinkedlist::Element[1] := forwardList.headElement;
	 * new:middle trace : PForward2Reverse::TlistHead2listHead[1];
	 * set trace.forwardList := forwardList;
	 * set trace.forwardHead := forwardHead;
	 *
	 */
	protected boolean MAP_m_TlistHead2listHead_forwardHead_forwardList_p0(final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TlistHead2listHead_forwardHead_forwardList_p0" + ", " + forwardList);
		}
		final /*@NonInvalid*/ @Nullable Element headElement = forwardList.getHeadElement();
		final /*@NonInvalid*/ boolean symbol_0 = headElement != null;
		/*@Thrown*/ @Nullable Boolean raw_forwardHead;
		if (symbol_0) {
			if (headElement == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @SuppressWarnings("null")@NonNull TlistHead2listHead trace_0 = PForward2ReverseFactory.eINSTANCE.createTlistHead2listHead();
			models[0/*middle*/].add(trace_0, false);
			// mapping statements
			OPPOSITE_OF_TlistHead2listHead_forwardList.put(forwardList, trace_0);
			trace_0.setForwardList(forwardList);
			trace_0.setForwardHead(headElement);
			final /*@Thrown*/ @Nullable Boolean m_TlistHead2listHead_forwardHead_forwardList_p0 = ValueUtil.TRUE_VALUE;
			raw_forwardHead = m_TlistHead2listHead_forwardHead_forwardList_p0;
		}
		else {
			raw_forwardHead = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_forwardHead ? "done "  : "fail ") + "MAP_m_TlistHead2listHead_forwardHead_forwardList_p0");
		}
		return raw_forwardHead;
	}

	/**
	 *
	 * map m_Tlist2list_forwardList_listName_reverseList_where__r0 in Forward2Reverse {
	 * guard:forward forwardList  : doublylinkedlist::DoublyLinkedList[1];
	 * append jm_SlistHead2listHead  : PForward2Reverse::SlistHead2listHead[1];
	 * var listName : String[1] := forwardList.name;
	 * new:reverse reverseList : doublylinkedlist::DoublyLinkedList[1];
	 * new:middle trace : PForward2Reverse::Tlist2list[1];
	 * new:middle where_SlistHead2listHead : PForward2Reverse::SlistHead2listHead[1];
	 * set trace.forwardList := forwardList;
	 * set trace.reverseList := reverseList;
	 * set trace.where_listHead2listHead := where_SlistHead2listHead;
	 * set where_SlistHead2listHead.forwardList := forwardList;
	 * set where_SlistHead2listHead.reverseList := reverseList;
	 * set reverseList.name := listName;
	 * set trace.listName := listName;
	 * add jm_SlistHead2listHead += where_SlistHead2listHead;
	 *
	 */
	protected boolean MAP_m_Tlist2list_forwardList_listName_reverseList_where__r0(final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList_0, final @NonNull Connection jm_SlistHead2listHead)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Tlist2list_forwardList_listName_reverseList_where__r0" + ", " + forwardList_0 + ", " + jm_SlistHead2listHead);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name = forwardList_0.getName();
		// creations
		final @SuppressWarnings("null")@NonNull DoublyLinkedList reverseList = doublylinkedlistFactory.eINSTANCE.createDoublyLinkedList();
		models[2/*reverse*/].add(reverseList, false);
		final @SuppressWarnings("null")@NonNull Tlist2list trace_0 = PForward2ReverseFactory.eINSTANCE.createTlist2list();
		models[0/*middle*/].add(trace_0, false);
		final @SuppressWarnings("null")@NonNull SlistHead2listHead where_SlistHead2listHead = PForward2ReverseFactory.eINSTANCE.createSlistHead2listHead();
		models[0/*middle*/].add(where_SlistHead2listHead, false);
		// mapping statements
		OPPOSITE_OF_Tlist2list_forwardList.put(forwardList_0, trace_0);
		trace_0.setForwardList(forwardList_0);
		trace_0.setReverseList(reverseList);
		trace_0.setWhere_listHead2listHead(where_SlistHead2listHead);
		where_SlistHead2listHead.setForwardList(forwardList_0);
		where_SlistHead2listHead.setReverseList(reverseList);
		reverseList.setName(name);
		trace_0.setListName(name);
		jm_SlistHead2listHead.appendElement(where_SlistHead2listHead);
		final /*@Thrown*/ @Nullable Boolean m_Tlist2list_forwardList_listName_reverseList_where__r0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_Tlist2list_forwardList_listName_reverseList_where__r0 ? "done "  : "fail ") + "MAP_m_Tlist2list_forwardList_listName_reverseList_where__r0");
		}
		return m_Tlist2list_forwardList_listName_reverseList_where__r0;
	}

	/**
	 *
	 * map m_Telement2element_elementName_forwardElement_forwar_p0 in Forward2Reverse {
	 * guard:forward forwardElement  : doublylinkedlist::Element[1];
	 * append jm_Telement2element  : PForward2Reverse::Telement2element[1];
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
	protected boolean MAP_m_Telement2element_elementName_forwardElement_forwar_p0(final /*@NonInvalid*/ @NonNull Element forwardElement, final @NonNull Connection jm_Telement2element)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Telement2element_elementName_forwardElement_forwar_p0" + ", " + forwardElement + ", " + jm_Telement2element);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name = forwardElement.getName();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DoublyLinkedList list = forwardElement.getList();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Element target = forwardElement.getTarget();
		// creations
		final @SuppressWarnings("null")@NonNull Telement2element trace_0 = PForward2ReverseFactory.eINSTANCE.createTelement2element();
		models[0/*middle*/].add(trace_0, false);
		// mapping statements
		OPPOSITE_OF_Telement2element_forwardElement.put(forwardElement, trace_0);
		trace_0.setForwardElement(forwardElement);
		trace_0.setElementName(name);
		trace_0.setForwardList(list);
		OPPOSITE_OF_Telement2element_forwardTarget.put(target, trace_0);
		trace_0.setForwardTarget(target);
		jm_Telement2element.appendElement(trace_0);
		final /*@Thrown*/ @Nullable Boolean m_Telement2element_elementName_forwardElement_forwar_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_Telement2element_elementName_forwardElement_forwar_p0 ? "done "  : "fail ") + "MAP_m_Telement2element_elementName_forwardElement_forwar_p0");
		}
		return m_Telement2element_elementName_forwardElement_forwar_p0;
	}

	/**
	 *
	 * map m_Telement2element_reverseElement_reverseList_lc in Forward2Reverse {
	 * guard:middle trace  : PForward2Reverse::Telement2element[1];
	 * var elementName : String[1] := trace.elementName;
	 * var forwardList : doublylinkedlist::DoublyLinkedList[1] := trace.forwardList;
	 * var forwardTarget : doublylinkedlist::Element[1] := trace.forwardTarget;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var when_Tlist2list : PForward2Reverse::Tlist2list[1] := forwardList.Tlist2list;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := when_Tlist2list.reverseList;
	 * new:reverse reverseElement : doublylinkedlist::Element[1];
	 * set trace.reverseElement := reverseElement;
	 * set reverseElement.name := elementName;
	 * set reverseElement.list := reverseList;
	 * set trace.reverseList := reverseList;
	 *
	 */
	protected boolean MAP_m_Telement2element_reverseElement_reverseList_lc(final /*@NonInvalid*/ @NonNull Telement2element trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Telement2element_reverseElement_reverseList_lc" + ", " + trace);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String elementName = trace.getElementName();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList_1 = trace.getForwardList();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Element forwardTarget_0 = trace.getForwardTarget();
		final /*@NonInvalid*/ @Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardElement.get(forwardTarget_0);
		final /*@NonInvalid*/ boolean symbol_0 = Telement2element != null;
		/*@Thrown*/ @Nullable Boolean raw_when_Telement2element;
		if (symbol_0) {
			if (Telement2element == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable Tlist2list Tlist2list = OPPOSITE_OF_Tlist2list_forwardList.get(forwardList_1);
			final /*@NonInvalid*/ boolean symbol_1 = Tlist2list != null;
			/*@Thrown*/ @Nullable Boolean raw_when_Tlist2list;
			if (symbol_1) {
				if (Tlist2list == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull DoublyLinkedList reverseList = Tlist2list.getReverseList();
				// creations
				final @SuppressWarnings("null")@NonNull Element reverseElement = doublylinkedlistFactory.eINSTANCE.createElement();
				models[2/*reverse*/].add(reverseElement, false);
				// mapping statements
				trace.setReverseElement(reverseElement);
				reverseElement.setName(elementName);
				reverseElement.setList(reverseList);
				trace.setReverseList(reverseList);
				final /*@Thrown*/ @Nullable Boolean m_Telement2element_reverseElement_reverseList_lc = ValueUtil.TRUE_VALUE;
				raw_when_Tlist2list = m_Telement2element_reverseElement_reverseList_lc;
			}
			else {
				raw_when_Tlist2list = ValueUtil.FALSE_VALUE;
			}
			raw_when_Telement2element = raw_when_Tlist2list;
		}
		else {
			raw_when_Telement2element = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_Telement2element ? "done "  : "fail ") + "MAP_m_Telement2element_reverseElement_reverseList_lc");
		}
		return raw_when_Telement2element;
	}

	/**
	 *
	 * map m_Telement2element_reverseSource_p3 in Forward2Reverse {
	 * guard:forward forwardTarget  : doublylinkedlist::Element[1];
	 * var trace : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardTarget.Telement2element;
	 * var reverseElement : doublylinkedlist::Element[1] := trace.reverseElement;
	 * var reverseSource : doublylinkedlist::Element[1] := when_Telement2element.reverseElement;
	 * set reverseElement.source := reverseSource;
	 * set trace.reverseSource := reverseSource;
	 *
	 */
	protected boolean MAP_m_Telement2element_reverseSource_p3(final /*@NonInvalid*/ @NonNull Element forwardTarget)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Telement2element_reverseSource_p3" + ", " + forwardTarget);
		}
		final /*@NonInvalid*/ @Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardTarget.get(forwardTarget);
		final /*@NonInvalid*/ boolean symbol_0 = Telement2element != null;
		/*@Thrown*/ @Nullable Boolean raw_trace;
		if (symbol_0) {
			if (Telement2element == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable Telement2element Telement2element_0 = OPPOSITE_OF_Telement2element_forwardElement.get(forwardTarget);
			final /*@NonInvalid*/ boolean symbol_1 = Telement2element_0 != null;
			/*@Thrown*/ @Nullable Boolean raw_when_Telement2element;
			if (symbol_1) {
				if (Telement2element_0 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Element reverseElement = Telement2element.getReverseElement();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Element reverseElement_0 = Telement2element_0.getReverseElement();
				// mapping statements
				reverseElement.setSource(reverseElement_0);
				Telement2element.setReverseSource(reverseElement_0);
				final /*@Thrown*/ @Nullable Boolean m_Telement2element_reverseSource_p3 = ValueUtil.TRUE_VALUE;
				raw_when_Telement2element = m_Telement2element_reverseSource_p3;
			}
			else {
				raw_when_Telement2element = ValueUtil.FALSE_VALUE;
			}
			raw_trace = raw_when_Telement2element;
		}
		else {
			raw_trace = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_trace ? "done "  : "fail ") + "MAP_m_Telement2element_reverseSource_p3");
		}
		return raw_trace;
	}

	/**
	 *
	 * map m_TlistHead2listHead_reverseHead_reverseList_p1 in Forward2Reverse {
	 * guard:middle from_SlistHead2listHead  : PForward2Reverse::SlistHead2listHead[1];
	 * var forwardList : doublylinkedlist::DoublyLinkedList[1] := from_SlistHead2listHead.forwardList;
	 * var reverseList : doublylinkedlist::DoublyLinkedList[1] := from_SlistHead2listHead.reverseList;
	 * var forwardHead : doublylinkedlist::Element[1] := forwardList.headElement;
	 * var trace : PForward2Reverse::TlistHead2listHead[1] := forwardList.TlistHead2listHead;
	 * var when_Telement2element : PForward2Reverse::Telement2element[1] := forwardHead.Telement2element;
	 * var reverseHead : doublylinkedlist::Element[1] := when_Telement2element.reverseElement;
	 * check forwardHead = trace.forwardHead;
	 * set trace.reverseList := reverseList;
	 * set reverseList.headElement := reverseHead;
	 * set trace.reverseHead := reverseHead;
	 *
	 */
	protected boolean MAP_m_TlistHead2listHead_reverseHead_reverseList_p1(final /*@NonInvalid*/ @NonNull SlistHead2listHead from_SlistHead2listHead)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TlistHead2listHead_reverseHead_reverseList_p1" + ", " + from_SlistHead2listHead);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DoublyLinkedList forwardList_1 = from_SlistHead2listHead.getForwardList();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DoublyLinkedList reverseList = from_SlistHead2listHead.getReverseList();
		final /*@NonInvalid*/ @Nullable Element headElement = forwardList_1.getHeadElement();
		final /*@NonInvalid*/ boolean symbol_0 = headElement != null;
		/*@Thrown*/ @Nullable Boolean raw_forwardHead;
		if (symbol_0) {
			if (headElement == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TlistHead2listHead TlistHead2listHead = OPPOSITE_OF_TlistHead2listHead_forwardList.get(forwardList_1);
			final /*@NonInvalid*/ boolean symbol_1 = TlistHead2listHead != null;
			/*@Thrown*/ @Nullable Boolean raw_trace;
			if (symbol_1) {
				if (TlistHead2listHead == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Telement2element Telement2element = OPPOSITE_OF_Telement2element_forwardElement.get(headElement);
				final /*@Thrown*/ boolean symbol_2 = Telement2element != null;
				/*@Thrown*/ @Nullable Boolean raw_when_Telement2element;
				if (symbol_2) {
					if (Telement2element == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Element reverseElement = Telement2element.getReverseElement();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Element forwardHead = TlistHead2listHead.getForwardHead();
					final /*@Thrown*/ boolean symbol_3 = headElement.equals(forwardHead);
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (symbol_3) {
						// mapping statements
						TlistHead2listHead.setReverseList(reverseList);
						reverseList.setHeadElement(reverseElement);
						TlistHead2listHead.setReverseHead(reverseElement);
						final /*@Thrown*/ @Nullable Boolean m_TlistHead2listHead_reverseHead_reverseList_p1 = ValueUtil.TRUE_VALUE;
						symbol_8 = m_TlistHead2listHead_reverseHead_reverseList_p1;
					}
					else {
						symbol_8 = ValueUtil.FALSE_VALUE;
					}
					raw_when_Telement2element = symbol_8;
				}
				else {
					raw_when_Telement2element = ValueUtil.FALSE_VALUE;
				}
				raw_trace = raw_when_Telement2element;
			}
			else {
				raw_trace = ValueUtil.FALSE_VALUE;
			}
			raw_forwardHead = raw_trace;
		}
		else {
			raw_forwardHead = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_forwardHead ? "done "  : "fail ") + "MAP_m_TlistHead2listHead_reverseHead_reverseList_p1");
		}
		return raw_forwardHead;
	}
}
