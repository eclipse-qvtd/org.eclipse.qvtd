/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.xtext.qvtimperative.tests.Tree2TallTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionMaxOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalInvocationManager;
import org.eclipse.qvtd.runtime.internal.evaluation.IncrementalObjectManager;
import org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation;

import tree2talltree.talltree.TallNode;
import tree2talltree.talltree.TalltreeFactory;
import tree2talltree.talltree.TalltreePackage;
import tree2talltree.tree.Node;
import tree2talltree.tree.TreePackage;
import tree2talltree.tree2talltree.Node2TallNode;
import tree2talltree.tree2talltree.Tree2talltreeFactory;
import tree2talltree.tree2talltree.Tree2talltreePackage;

/**
 * The Tree2TallTreeInstall transformation:
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
public class Tree2TallTreeInstallManual extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_List2List = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/List2List", null, Tree2talltreePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_TallTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/TallTree", null, TalltreePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_Tree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/Tree", null, TreePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Node = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_Tree.getClassId("Node", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Node2TallNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_List2List.getClassId("Node2TallNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TallNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_TallTree.getClassId("TallNode", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EInt = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TallNode = TypeId.BAG.getSpecializedId(CLSSid_TallNode);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_DATAid_EInt = TypeId.BAG.getSpecializedId(DATAid_EInt);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Node2TallNode = TypeId.SEQUENCE.getSpecializedId(CLSSid_Node2TallNode);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Node = TypeId.SET.getSpecializedId(CLSSid_Node);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Node2TallNode = TypeId.SET.getSpecializedId(CLSSid_Node2TallNode);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TallNode = TypeId.SET.getSpecializedId(CLSSid_TallNode);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Node,Node2TallNode> OPPOSITE_OF_Node2TallNode_node = new HashMap<Node,Node2TallNode>();

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Node                     // 0 => Node
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0}                     // 0 : Node -> {Node}
	};

	protected final AbstractInvocationConstructor.@NonNull Incremental CTOR_Root = new AbstractInvocationConstructor.Incremental(invocationManager, "__root__", false)
	{
		@Override
		public @NonNull MAP___root__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP___root__(this, values);
		}
	};

	protected final AbstractInvocationConstructor.@NonNull Incremental CTOR_Node2MiddleNode = new AbstractInvocationConstructor.Incremental(invocationManager, "Node2MiddleNode", false)
	{
		@Override
		public @NonNull MAP_Node2MiddleNode newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_Node2MiddleNode(this, values);
		}
	};

	protected final AbstractInvocationConstructor.@NonNull Incremental CTOR_Edge2MiddleEdge = new AbstractInvocationConstructor.Incremental(invocationManager, "Edge2MiddleEdge", false)
	{
		@Override
		public @NonNull MAP_Edge2MiddleEdge newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_Edge2MiddleEdge(this, values);
		}
	};

	protected final AbstractInvocationConstructor.@NonNull Incremental CTOR_MiddleNode2TallNode = new AbstractInvocationConstructor.Incremental(invocationManager, "MiddleNode2TallNode", false)
	{
		@Override
		public @NonNull MAP_MiddleNode2TallNode newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_MiddleNode2TallNode(this, values);
		}
	};

	public Tree2TallTreeInstallManual(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"tree", "talltree", "tree2talltree"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	protected @NonNull InvocationManager createInvocationManager() {
		return new IncrementalInvocationManager(executor);
	}

	@Override
	protected @NonNull ObjectManager createObjectManager() {
		return new IncrementalObjectManager((IncrementalInvocationManager)invocationManager);
	}

	@Override
	public boolean run() {
		//		CTOR_Root.connect(null, null);
		CTOR_Root.invoke();
		//		invocationManager.setWorkToDoAt(0);
		return invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in Tree2TallTreeInstall {
	 *
	 *   nodes : OrderedSet(tree::Node)node2tallNodes : Sequence(tree2talltree::Node2TallNode)install Node2MiddleNode {
	 * node consumes nodes : OrderedSet(tree::Node);
	 * node2tallNodes appendsTo node2tallNodes;
	 * }
	 *   install Edge2MiddleEdge {
	 * node consumes nodes : OrderedSet(tree::Node);
	 * }
	 *   install MiddleNode2TallNode {
	 * node2tallNode consumes node2tallNodes : Sequence(tree2talltree::Node2TallNode);
	 * }
	 */
	protected class MAP___root__ extends AbstractInvocation.Incremental
	{
		public MAP___root__(InvocationConstructor.@NonNull Incremental constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
		}

		@Override
		public boolean execute()  {
			try {
				final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_tree_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
				final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
				// connection variables
				final @NonNull Connection nodes = createConnection("nodes", ORD_CLSSid_Node, false);
				final /*@NonInvalid*/ @NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Node, models[0/*tree*/], TYP_tree_c_c_Node_0);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_sortedBy_0 = executor.getStaticTypeOf(objectsOfKind);
				final LibraryIteration.@NonNull LibraryIterationExtension IMPL_sortedBy_0 = (LibraryIteration.LibraryIterationExtension)TYPE_sortedBy_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
				final @NonNull Object ACC_sortedBy_0 = IMPL_sortedBy_0.createAccumulatorValue(executor, ORD_CLSSid_Node, TypeId.STRING);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_sortedBy_0 = new AbstractBinaryOperation()
				{
					/**
					 * name
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object objectsOfKind, final /*@NonInvalid*/ @Nullable Object _1) {
						final /*@NonInvalid*/ @Nullable Node symbol_4 = (Node)_1;
						if (symbol_4 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/Tree\'::Node::name\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String name = symbol_4.getName();
						objectManager.got(MAP___root__.this, symbol_4, TreePackage.Literals.NODE__NAME, name);
						return name;
					}
				};
				final @NonNull  ExecutorSingleIterationManager MGR_sortedBy_0 = new ExecutorSingleIterationManager(executor, ORD_CLSSid_Node, BODY_sortedBy_0, objectsOfKind, ACC_sortedBy_0);
				final /*@Thrown*/ @NonNull OrderedSetValue sortedBy = ClassUtil.nonNullState((OrderedSetValue)IMPL_sortedBy_0.evaluateIteration(MGR_sortedBy_0));
				for (@NonNull Node iterator : ValueUtil.typedIterable(Node.class, sortedBy)) {
					nodes.append(iterator);
				}
				final @NonNull Connection node2tallNodes_1 = createConnection("node2tallNodes_1", SEQ_CLSSid_Node2TallNode, false);
				// mapping statements
				CTOR_Node2MiddleNode.connect(new @NonNull Connection[]{nodes}, new @NonNull Connection[]{node2tallNodes_1});
				CTOR_Edge2MiddleEdge.connect(new @NonNull Connection[]{nodes}, null);
				CTOR_MiddleNode2TallNode.connect(new @NonNull Connection[]{node2tallNodes_1}, null);
				final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
				return __root__;
			} catch (Throwable e) {
				return handleExecutionFailure("MAP___root__", e);
			}
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return true;
		}
	}

	/**
	 *
	 * map Node2MiddleNode in Tree2TallTreeInstall {
	 * guard:tree node  : tree::Node[?];
	 * append node2tallNodes  : Sequence(tree2talltree::Node2TallNode);
	 * new:tree2talltree node2tallNode : tree2talltree::Node2TallNode[?];
	 * set node2tallNode.node := node;
	 * set node2tallNode.name := node.name;
	 * add node2tallNodes += node2tallNode;
	 *
	 */
	protected class MAP_Node2MiddleNode extends AbstractInvocation.Incremental
	{
		protected final /*@NonInvalid*/ @NonNull Node node;
		protected final @NonNull Connection node2tallNodes;

		public MAP_Node2MiddleNode(InvocationConstructor.@NonNull Incremental constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			node = (Node)boundValues[0];
			node2tallNodes = (Connection)boundValues[1];
		}

		@Override
		public boolean execute()  {
			try {
				// creations
				final /*@Thrown*/ @Nullable Node2TallNode node2tallNode_0 = Tree2talltreeFactory.eINSTANCE.createNode2TallNode();
				assert node2tallNode_0 != null;
				models[2/*tree2talltree*/].add(node2tallNode_0);
				objectManager.created(this, node2tallNode_0);
				// mapping statements
				OPPOSITE_OF_Node2TallNode_node.put(node, node2tallNode_0);
				node2tallNode_0.setNode(node);
				objectManager.assigned(this, node2tallNode_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NODE, node, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull String name = node.getName();
				objectManager.got(this, node, TreePackage.Literals.NODE__NAME, name);
				node2tallNode_0.setName(name);
				objectManager.assigned(this, node2tallNode_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME, name, null);
				node2tallNodes.append(node2tallNode_0);
				final /*@Thrown*/ @Nullable Boolean Node2MiddleNode = ValueUtil.TRUE_VALUE;
				return Node2MiddleNode;
			} catch (Throwable e) {
				return handleExecutionFailure("MAP_Node2MiddleNode", e);
			}
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(node, thoseValues[0])
				&& idResolver.oclEquals(node2tallNodes, thoseValues[1]);
		}
	}

	/**
	 *
	 * map Edge2MiddleEdge in Tree2TallTreeInstall {
	 * guard:tree node  : tree::Node[?];
	 * var node2tallNode : tree2talltree::Node2TallNode[?] := node.Node2TallNode;
	 * check node.parent <> null;
	 * notify set node2tallNode.parent := node.parent.Node2TallNode;
	 *
	 */
	protected class MAP_Edge2MiddleEdge extends AbstractInvocation.Incremental
	{
		protected final /*@NonInvalid*/ @NonNull Node node_0;

		public MAP_Edge2MiddleEdge(InvocationConstructor.@NonNull Incremental constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			node_0 = (Node)boundValues[0];
		}

		@Override
		public boolean execute()  {
			try {
				final /*@Thrown*/ @NonNull Node2TallNode Node2TallNode = ClassUtil.nonNullState (OPPOSITE_OF_Node2TallNode_node.get(node_0));
				objectManager.got(this, node_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NODE, Node2TallNode);
				final /*@Thrown*/ @Nullable Node parent = node_0.getParent();
				objectManager.got(this, node_0, TreePackage.Literals.NODE__PARENT, parent);
				final /*@Thrown*/ boolean ne = parent != null;
				/*@Thrown*/ @Nullable Boolean symbol_2;
				if (ne) {
					// mapping statements
					if (parent == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/Tree\'::Node::Node2TallNode\'");
					}
					final /*@Thrown*/ @NonNull Node2TallNode Node2TallNode_0 = ClassUtil.nonNullState (OPPOSITE_OF_Node2TallNode_node.get(parent));
					objectManager.got(this, parent, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NODE, Node2TallNode_0);
					Node2TallNode.setParent(Node2TallNode_0);
					objectManager.assigned(this, Node2TallNode, Tree2talltreePackage.Literals.NODE2_TALL_NODE__PARENT, Node2TallNode_0, null);
					final /*@Thrown*/ @Nullable Boolean Edge2MiddleEdge = ValueUtil.TRUE_VALUE;
					symbol_2 = Edge2MiddleEdge;
				}
				else {
					symbol_2 = ValueUtil.FALSE_VALUE;
				}
				return symbol_2;
			} catch (Throwable e) {
				return handleExecutionFailure("MAP_Edge2MiddleEdge", e);
			}
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(node_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * map MiddleNode2TallNode in Tree2TallTreeInstall {
	 *
	 *   guard:tree2talltree node2tallNode  : tree2talltree::Node2TallNode[?];
	 * var tallNode_name : String[?] := node2tallNode.name;
	 * var tallNode_children : Set(talltree::TallNode) := node2tallNode.children?.tallNode->asSet()
	 *   ;
	 * var tallNode_height : Integer[?] := if node2tallNode.children->notEmpty()
	 *   then node2tallNode.children.tallNode.height->max() + 1
	 *   else 0
	 *   endif;
	 * new:talltree tallNode : talltree::TallNode[?];
	 * notify set node2tallNode.tallNode := tallNode;
	 * set tallNode.name := tallNode_name;
	 * set tallNode.children := tallNode_children;
	 * notify set tallNode.height := tallNode_height;
	 *
	 */
	protected class MAP_MiddleNode2TallNode extends AbstractInvocation.Incremental
	{
		protected final /*@NonInvalid*/ @NonNull Node2TallNode node2tallNode;

		public MAP_MiddleNode2TallNode(InvocationConstructor.@NonNull Incremental constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			node2tallNode = (Node2TallNode)boundValues[0];
		}

		@Override
		public boolean execute()  {
			try {
				final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull String name = node2tallNode.getName();
				objectManager.got(this, node2tallNode, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME, name);
				objectManager.getting(node2tallNode, Tree2talltreePackage.Literals.NODE2_TALL_NODE__CHILDREN, false);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<Node2TallNode> children_0 = node2tallNode.getChildren();
				objectManager.got(this, node2tallNode, Tree2talltreePackage.Literals.NODE2_TALL_NODE__CHILDREN, children_0);
				final /*@Thrown*/ @NonNull SetValue BOXED_children_0 = idResolver.createSetOfAll(SET_CLSSid_Node2TallNode, children_0);
				final /*@Thrown*/ @NonNull SetValue safe_collect_sources = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_children_0, (Object)null);
				/*@Thrown*/ BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_TallNode);
				@NonNull Iterator<Object> ITERATOR__1 = safe_collect_sources.iterator();
				/*@Thrown*/ @NonNull BagValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Node2TallNode _1 = (Node2TallNode)ITERATOR__1.next();
					/**
					 * tallNode
					 */
					objectManager.getting(_1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, false);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull TallNode tallNode_0 = _1.getTallNode();
					objectManager.got(this, _1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, tallNode_0);
					//
					accumulator.add(tallNode_0);
				}
				final /*@Thrown*/ @NonNull SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
				final /*@Thrown*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_children_0).booleanValue();
				/*@Thrown*/ @NonNull IntegerValue symbol_0;
				if (notEmpty) {
					/*@Thrown*/ BagValue.@NonNull Accumulator accumulator_0 = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_TallNode);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_children_0.iterator();
					/*@Thrown*/ @NonNull BagValue collect_1;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_1 = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Node2TallNode _1_0 = (Node2TallNode)ITERATOR__1_0.next();
						/**
						 * tallNode
						 */
						objectManager.getting(_1_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TallNode tallNode_1 = _1_0.getTallNode();
						objectManager.got(this, _1_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, tallNode_1);
						//
						accumulator_0.add(tallNode_1);
					}
					/*@Thrown*/ BagValue.@NonNull Accumulator accumulator_1 = ValueUtil.createBagAccumulatorValue(BAG_DATAid_EInt);
					@NonNull Iterator<Object> ITERATOR__1_1 = collect_1.iterator();
					/*@Thrown*/ @NonNull BagValue collect_0;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							collect_0 = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull TallNode _1_1 = (TallNode)ITERATOR__1_1.next();
						/**
						 * height
						 */
						objectManager.getting(_1_1, TalltreePackage.Literals.TALL_NODE__HEIGHT, false);
						final /*@Thrown*/ int height = _1_1.getHeight();
						objectManager.got(this, _1_1, TalltreePackage.Literals.TALL_NODE__HEIGHT, height);
						final /*@Thrown*/ @NonNull IntegerValue BOXED_height = ValueUtil.integerValueOf(height);
						//
						accumulator_1.add(BOXED_height);
					}
					final /*@Thrown*/ @NonNull IntegerValue max = (IntegerValue)CollectionMaxOperation.INSTANCE.evaluate(collect_0);
					final /*@Thrown*/ @NonNull IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(max, INT_1);
					symbol_0 = sum;
				}
				else {
					symbol_0 = INT_0;
				}
				// creations
				final /*@Thrown*/ @Nullable TallNode tallNode = TalltreeFactory.eINSTANCE.createTallNode();
				assert tallNode != null;
				models[1/*talltree*/].add(tallNode);
				objectManager.created(this, tallNode);
				// mapping statements
				node2tallNode.setTallNode(tallNode);
				objectManager.assigned(this, node2tallNode, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, tallNode, null);
				tallNode.setName(name);
				objectManager.assigned(this, tallNode, TalltreePackage.Literals.TALL_NODE__NAME, name, null);
				final /*@Thrown*/ @NonNull List<TallNode> ECORE_asSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(TallNode.class, asSet);
				tallNode.getChildren().addAll(ECORE_asSet);
				objectManager.assigned(this, tallNode, TalltreePackage.Literals.TALL_NODE__CHILDREN, ECORE_asSet, null);
				final int ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
				tallNode.setHeight(ECORE_symbol_0);
				objectManager.assigned(this, tallNode, TalltreePackage.Literals.TALL_NODE__HEIGHT, ECORE_symbol_0, null);
				final /*@Thrown*/ @Nullable Boolean MiddleNode2TallNode = ValueUtil.TRUE_VALUE;
				return MiddleNode2TallNode;
			} catch (Throwable e) {
				return handleExecutionFailure("MAP_MiddleNode2TallNode", e);
			}
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(node2tallNode, thoseValues[0]);
		}
	}
}
