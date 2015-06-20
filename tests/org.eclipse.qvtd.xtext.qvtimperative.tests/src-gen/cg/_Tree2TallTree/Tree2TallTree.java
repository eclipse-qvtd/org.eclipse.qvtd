/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._Tree2TallTree;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
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
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfKindOperation;
import tree2talltree.talltree.TallNode;
import tree2talltree.talltree.TalltreeFactory;
import tree2talltree.talltree.TalltreePackage;
import tree2talltree.tree.Node;
import tree2talltree.tree.TreePackage;
import tree2talltree.tree2talltree.Node2TallNode;
import tree2talltree.tree2talltree.Tree2talltreeFactory;
import tree2talltree.tree2talltree.Tree2talltreePackage;

/**
 * The Tree2TallTree transformation:
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
public class Tree2TallTree extends AbstractTransformationExecutor
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_List2List = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/List2List", null, Tree2talltreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_TallTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/TallTree", null, TalltreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_Tree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/Tree", null, TreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_PRIMid_Integer = TypeId.BAG.getSpecializedId(TypeId.INTEGER);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Node = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_Tree.getClassId("Node", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Node2TallNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_List2List.getClassId("Node2TallNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TallNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_TallTree.getClassId("TallNode", 0);
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_TallNode = TypeId.BAG.getSpecializedId(CLSSid_TallNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Node2TallNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node2TallNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Node2TallNode = TypeId.SEQUENCE.getSpecializedId(CLSSid_Node2TallNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Node = TypeId.SET.getSpecializedId(CLSSid_Node);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Node2TallNode = TypeId.SET.getSpecializedId(CLSSid_Node2TallNode);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<Node,Node2TallNode> OPPOSITE_OF_Node2TallNode_node = new HashMap<Node,Node2TallNode>();
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_Node,                    // 0 => Node
        CLSSid_Node2TallNode            // 1 => Node2TallNode
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : Node -> {Node}
        {1}                     // 1 : Node2TallNode -> {Node2TallNode}
    };
    
    protected final @NonNull Constructor<MAP_MiddleNode2TallNode> CTOR_MiddleNode2TallNode;
    
    public Tree2TallTree(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"tree", "talltree", "tree2talltree"}, null, classIndex2classId, classIndex2allClassIndexes);
        CTOR_MiddleNode2TallNode = ClassUtil.nonNullState(MAP_MiddleNode2TallNode.class.getConstructor(Tree2TallTree.class, Object[].class));
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * 
     * map __root__ in Tree2TallTree {
     * 
     *   where ( |)
     * { |}
     * for node : tree::Node in tree.objectsOfKind(tree::Node)
     *   ->sortedBy(name)
     *    {
     * map Node2MiddleNode {
     * node := node;
     * }}
     *   for node : tree::Node in tree.objectsOfKind(tree::Node)
     *   ->sortedBy(name)
     *    {
     * 
     *     map Edge2MiddleEdge {
     * node := node;
     * node2tallNode := node.Node2TallNode;
     * }}
     *   for node2tallNode : tree2talltree::Node2TallNode in tree.objectsOfKind(tree::Node)
     *   ->sortedBy(name)
     *   .Node2TallNode {
     * 
     *     map MiddleLeaf2TallLeaf {
     * node2tallNode := node2tallNode;
     * }}
     *   for node2tallNode : tree2talltree::Node2TallNode in tree2talltree.objectsOfKind(tree2talltree::Node2TallNode)
     *   ->sortedBy(name)
     *    {
     * map MiddleNode2TallNode {
     * node2tallNode ?= node2tallNode;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_tree2talltree_c_c_Node2TallNode_0 = idResolver.getClass(CLSSid_Node2TallNode, null);
        final @NonNull /*@NonInvalid*/ Class TYP_tree_c_c_Node_1 = idResolver.getClass(CLSSid_Node, null);
        final @NonNull /*@NonInvalid*/ StandardLibrary standardLibrary = idResolver.getStandardLibrary();
        final @NonNull /*@NonInvalid*/ SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Node, models[0/*tree*/], TYP_tree_c_c_Node_1);
        final @NonNull Class TYPE_sortedBy_0_0 = executor.getStaticTypeOf(objectsOfKind_0);
        final @NonNull LibraryIteration.LibraryIterationExtension IMPL_sortedBy_0_0 = (LibraryIteration.LibraryIterationExtension)TYPE_sortedBy_0_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
        final @NonNull Object ACC_sortedBy_0_0 = IMPL_sortedBy_0_0.createAccumulatorValue(executor, ORD_CLSSid_Node, TypeId.STRING);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_sortedBy_0_0 = new AbstractBinaryOperation()
        {
            /**
             * name
             */
            @Override
            public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object objectsOfKind_0, final @Nullable /*@NonInvalid*/ Object _1_0) {
                final @Nullable /*@NonInvalid*/ Node symbol_6 = (Node)_1_0;
                if (symbol_6 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/Tree\'::Node::name\'");
                }
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ String name_0 = symbol_6.getName();
                return name_0;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_sortedBy_0_0 = new ExecutorSingleIterationManager(executor, ORD_CLSSid_Node, BODY_sortedBy_0_0, objectsOfKind_0, ACC_sortedBy_0_0);
        final @NonNull /*@Thrown*/ OrderedSetValue sortedBy_0 = ClassUtil.nonNullState((OrderedSetValue)IMPL_sortedBy_0_0.evaluateIteration(MGR_sortedBy_0_0));
        final List<Node> UNBOXED_sortedBy_0 = sortedBy_0.asEcoreObjects(idResolver, Node.class);
        assert UNBOXED_sortedBy_0 != null;
        // mapping statements
        for (Node node_3 : UNBOXED_sortedBy_0) {
            if (node_3 != null) {
                final @NonNull /*@NonInvalid*/ Node symbol_2 = (Node)node_3;
                if (symbol_2 != null) {
                    MAP_Node2MiddleNode(symbol_2);
                }
            }
        }
        for (Node node_4 : UNBOXED_sortedBy_0) {
            if (node_4 != null) {
                final @NonNull /*@NonInvalid*/ Node symbol_7 = (Node)node_4;
                final @NonNull /*@Thrown*/ Node2TallNode Node2TallNode = ClassUtil.nonNullState (OPPOSITE_OF_Node2TallNode_node.get(symbol_7));
                if (symbol_7 != null) {
                    if (Node2TallNode != null) {
                        MAP_Edge2MiddleEdge(symbol_7, Node2TallNode);
                    }
                }
            }
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Node2TallNode);
        @Nullable Iterator<?> ITERATOR__1_2 = sortedBy_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_2.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Node _1_2 = (Node)ITERATOR__1_2.next();
            /**
             * Node2TallNode
             */
            if (_1_2 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/List2List\'::Node2TallNode::node\'");
            }
            final @NonNull /*@Thrown*/ Node2TallNode Node2TallNode_0 = ClassUtil.nonNullState (OPPOSITE_OF_Node2TallNode_node.get(_1_2));
            //
            accumulator.add(Node2TallNode_0);
        }
        final List<Node2TallNode> UNBOXED_collect = collect.asEcoreObjects(idResolver, Node2TallNode.class);
        assert UNBOXED_collect != null;
        for (Node2TallNode node2tallNode_5 : UNBOXED_collect) {
            if (node2tallNode_5 != null) {
                final @NonNull /*@NonInvalid*/ Node2TallNode symbol_13 = (Node2TallNode)node2tallNode_5;
                if (symbol_13 != null) {
                    MAP_MiddleLeaf2TallLeaf(symbol_13);
                }
            }
        }
        final @NonNull /*@NonInvalid*/ SetValue objectsOfKind_2 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Node2TallNode, models[2/*tree2talltree*/], TYP_tree2talltree_c_c_Node2TallNode_0);
        final @NonNull Class TYPE_sortedBy_2_0 = executor.getStaticTypeOf(objectsOfKind_2);
        final @NonNull LibraryIteration.LibraryIterationExtension IMPL_sortedBy_2_0 = (LibraryIteration.LibraryIterationExtension)TYPE_sortedBy_2_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
        final @NonNull Object ACC_sortedBy_2_0 = IMPL_sortedBy_2_0.createAccumulatorValue(executor, ORD_CLSSid_Node2TallNode, TypeId.STRING);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_sortedBy_2_0 = new AbstractBinaryOperation()
        {
            /**
             * name
             */
            @Override
            public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object objectsOfKind_2, final @Nullable /*@NonInvalid*/ Object _1_3) {
                final @Nullable /*@NonInvalid*/ Node2TallNode symbol_17 = (Node2TallNode)_1_3;
                if (symbol_17 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/List2List\'::Node2TallNode::name\'");
                }
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ String name_2 = objectManager.get(symbol_17, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME);
                return name_2;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_sortedBy_2_0 = new ExecutorSingleIterationManager(executor, ORD_CLSSid_Node2TallNode, BODY_sortedBy_2_0, objectsOfKind_2, ACC_sortedBy_2_0);
        final @NonNull /*@Thrown*/ OrderedSetValue sortedBy_2 = ClassUtil.nonNullState((OrderedSetValue)IMPL_sortedBy_2_0.evaluateIteration(MGR_sortedBy_2_0));
        final List<Node2TallNode> UNBOXED_sortedBy_2 = sortedBy_2.asEcoreObjects(idResolver, Node2TallNode.class);
        assert UNBOXED_sortedBy_2 != null;
        for (Node2TallNode node2tallNode_6 : UNBOXED_sortedBy_2) {
            if (node2tallNode_6 != null) {
                final @NonNull /*@NonInvalid*/ Node2TallNode symbol_18 = (Node2TallNode)node2tallNode_6;
                if (symbol_18 != null) {
                    invoke(CTOR_MiddleNode2TallNode, symbol_18);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map Node2MiddleNode in Tree2TallTree {
     * tree (node : tree::Node[?];
     *  |)
     * { |}
     * tree2talltree ( |)
     * {realize node2tallNode : tree2talltree::Node2TallNode[?];
     *  |}
     * where ( |)
     * {_0 : String[1];
     *  |
     * _0 := node.name;
     * node2tallNode.node := node;
     * node2tallNode.name := _0;
     * }
     * 
     */
    protected boolean MAP_Node2MiddleNode(final @NonNull /*@NonInvalid*/ Node node) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ String name = node.getName();
        // creations
        final /*@Thrown*/ Node2TallNode node2tallNode_2 = Tree2talltreeFactory.eINSTANCE.createNode2TallNode();
        assert node2tallNode_2 != null;
        models[2/*tree2talltree*/].add(node2tallNode_2);
        // property assignments
        node2tallNode_2.setNode(node);
        OPPOSITE_OF_Node2TallNode_node.put(node, node2tallNode_2);
        objectManager.assign(node2tallNode_2, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME, name);
        return true;
    }
    
    /**
     * 
     * map Edge2MiddleEdge in Tree2TallTree {
     * tree (node : tree::Node[?];
     *  |)
     * { |}
     * tree2talltree (node2tallNode : tree2talltree::Node2TallNode[?];
     *  |)
     * { |}
     * where ( |
     * node.parent <> null)
     * {_0 : tree2talltree::Node2TallNode[1];
     *  |
     * _0 := node.parent.Node2TallNode;
     * node2tallNode.parent := _0;
     * }
     * 
     */
    protected boolean MAP_Edge2MiddleEdge(final @NonNull /*@NonInvalid*/ Node node_0, final @NonNull /*@NonInvalid*/ Node2TallNode node2tallNode) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ Node parent = node_0.getParent();
        final /*@Thrown*/ boolean ne = parent != null;
        if (!ne) {
            return false;
        }
        // variable assignments
        if (parent == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/List2List\'::Node2TallNode::node\'");
        }
        final @NonNull /*@Thrown*/ Node2TallNode Node2TallNode = ClassUtil.nonNullState (OPPOSITE_OF_Node2TallNode_node.get(parent));
        // property assignments
        node2tallNode.setParent(Node2TallNode);
        return true;
    }
    
    /**
     * 
     * map MiddleLeaf2TallLeaf in Tree2TallTree {
     * 
     *   tree2talltree (node2tallNode : tree2talltree::Node2TallNode[?];
     *  |)
     * { |}
     * talltree ( |)
     * {realize tallNode : talltree::TallNode[?];
     *  |}
     * where ( |
     * node2tallNode.children->isEmpty())
     * {_0 : String[1];
     *  |
     * _0 := node2tallNode.name;
     * node2tallNode.tallNode := tallNode;
     * tallNode.name := _0;
     * tallNode.height := 0;
     * }
     * 
     */
    protected boolean MAP_MiddleLeaf2TallLeaf(final @NonNull /*@NonInvalid*/ Node2TallNode node2tallNode_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Node2TallNode> children = objectManager.get(node2tallNode_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__CHILDREN);
        final @NonNull /*@Thrown*/ SetValue BOXED_children = idResolver.createSetOfAll(SET_CLSSid_Node2TallNode, children);
        final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(BOXED_children).booleanValue();
        if (!isEmpty) {
            return false;
        }
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ String name = objectManager.get(node2tallNode_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME);
        // creations
        final /*@Thrown*/ TallNode tallNode = TalltreeFactory.eINSTANCE.createTallNode();
        assert tallNode != null;
        models[1/*talltree*/].add(tallNode);
        // property assignments
        objectManager.assign(node2tallNode_0, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, tallNode);
        tallNode.setName(name);
        final @Nullable /*@NonInvalid*/ Object UNBOXED_INT_0 = INT_0.asNumber();
        objectManager.assign(tallNode, TalltreePackage.Literals.TALL_NODE__HEIGHT, UNBOXED_INT_0);
        return true;
    }
    
    /**
     * 
     * map MiddleNode2TallNode in Tree2TallTree {
     * 
     *   tree2talltree (node2tallNode : tree2talltree::Node2TallNode[?];
     *  |)
     * { |}
     * talltree ( |)
     * {realize tallNode : talltree::TallNode[?];
     *  |}
     * where ( |
     * node2tallNode.children->notEmpty()
     *   )
     * {_0 : String[1];
     * _1 : Bag(talltree::TallNode[*|1]);
     * _2 : Integer[1];
     *  |
     * _0 := node2tallNode.name;
     * _1 := node2tallNode.children.tallNode;
     * _2 := node2tallNode.children.tallNode.height->max() + 1;
     * node2tallNode.tallNode := tallNode;
     * tallNode.name := _0;
     * tallNode.children := _1;
     * tallNode.height := _2;
     * }
     * 
     */
    protected class MAP_MiddleNode2TallNode extends AbstractInvocation
    {
        protected final @NonNull /*@NonInvalid*/ Node2TallNode node2tallNode_1;
        
        @SuppressWarnings("null")
        public MAP_MiddleNode2TallNode(@NonNull Object[] boundValues) {
            node2tallNode_1 = (Node2TallNode)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ List<Node2TallNode> children = objectManager.get(node2tallNode_1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__CHILDREN);
            final @NonNull /*@Thrown*/ SetValue BOXED_children = idResolver.createSetOfAll(SET_CLSSid_Node2TallNode, children);
            final /*@Thrown*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_children).booleanValue();
            if (!notEmpty) {
                return false;
            }
            @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_TallNode);
            @Nullable Iterator<?> ITERATOR__1 = BOXED_children.iterator();
            @NonNull /*@Thrown*/ BagValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ Node2TallNode _1 = (Node2TallNode)ITERATOR__1.next();
                /**
                 * tallNode
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/List2List\'::Node2TallNode::tallNode\'");
                }
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ TallNode tallNode_0 = objectManager.get(_1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE);
                //
                accumulator.add(tallNode_0);
            }
            // variable assignments
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ String name = objectManager.get(node2tallNode_1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__NAME);
            @NonNull /*@Thrown*/ BagValue.Accumulator accumulator_0 = ValueUtil.createBagAccumulatorValue(BAG_PRIMid_Integer);
            @NonNull Iterator<?> ITERATOR__1_1 = collect.iterator();
            @NonNull /*@Thrown*/ BagValue collect_0;
            while (true) {
                if (!ITERATOR__1_1.hasNext()) {
                    collect_0 = accumulator_0;
                    break;
                }
                @NonNull /*@NonInvalid*/ TallNode _1_1 = (TallNode)ITERATOR__1_1.next();
                /**
                 * height
                 */
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ Object height = objectManager.get(_1_1, TalltreePackage.Literals.TALL_NODE__HEIGHT);
                final @NonNull /*@Thrown*/ IntegerValue BOXED_height = ValueUtil.integerValueOf(height);
                //
                accumulator_0.add(BOXED_height);
            }
            final @NonNull /*@Thrown*/ IntegerValue max = (IntegerValue)CollectionMaxOperation.INSTANCE.evaluate(collect_0);
            final @NonNull /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(max, INT_1);
            // creations
            final /*@Thrown*/ TallNode tallNode = TalltreeFactory.eINSTANCE.createTallNode();
            assert tallNode != null;
            models[1/*talltree*/].add(tallNode);
            // property assignments
            objectManager.assign(node2tallNode_1, Tree2talltreePackage.Literals.NODE2_TALL_NODE__TALL_NODE, tallNode);
            tallNode.setName(name);
            final List<TallNode> UNBOXED_null = collect.asEcoreObjects(idResolver, TallNode.class);
            assert UNBOXED_null != null;
            tallNode.getChildren().addAll(UNBOXED_null);
            final @Nullable /*@NonInvalid*/ Object UNBOXED_null_0 = sum.asNumber();
            objectManager.assign(tallNode, TalltreePackage.Literals.TALL_NODE__HEIGHT, UNBOXED_null_0);
            return true;
        }
        
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object[] thoseValues) {
            return idResolver.oclEquals(node2tallNode_1, thoseValues[0]);
        }
    }
}
