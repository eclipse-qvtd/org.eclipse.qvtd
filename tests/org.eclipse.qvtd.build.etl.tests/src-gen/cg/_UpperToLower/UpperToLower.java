/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._UpperToLower;

import build.upper2lower.simplegraph.Edge;
import build.upper2lower.simplegraph.Element;
import build.upper2lower.simplegraph.Graph;
import build.upper2lower.simplegraph.Node;
import build.upper2lower.simplegraph.SimplegraphFactory;
import build.upper2lower.simplegraph.SimplegraphPackage;
import build.upper2lower.simplegraph2graph.Edge2Edge;
import build.upper2lower.simplegraph2graph.Graph2Graph;
import build.upper2lower.simplegraph2graph.Node2Node;
import build.upper2lower.simplegraph2graph.Simplegraph2graphFactory;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.string.StringToLowerCaseOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation;

/**
 * The UpperToLower transformation:
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
public class UpperToLower extends AbstractTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph", null, SimplegraphPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph", null, Simplegraph2graphPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Edge = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Edge", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Edge2Edge = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Edge2Edge", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Element", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Graph = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Graph", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Graph2Graph = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Graph2Graph", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Node", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node2Node = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Node2Node", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Edge = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Edge);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Edge2Edge = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Edge2Edge);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Element = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Element);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Node2Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node2Node);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Graph = TypeId.SET.getSpecializedId(CLSSid_Graph);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Edge);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet_2 = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Node2Node);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet_0 = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Edge2Edge);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet_1 = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Node);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<Graph,Graph2Graph> OPPOSITE_OF_Graph2Graph_graph1 = new HashMap<Graph,Graph2Graph>();
    protected final @NonNull Map<Node,Node2Node> OPPOSITE_OF_Node2Node_node1 = new HashMap<Node,Node2Node>();
    
    
    
    public UpperToLower(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new @NonNull String[] {"upperGraph", "lowerGraph", "middle"}, null, null, null);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * 
     * map __root__ in UpperToLower {
     * 
     *   where ( |)
     * {_'-join-Edge-0' : OrderedSet(simplegraph::Edge[*|1]) = OrderedSet{};
     * _'-join-Edge2Edge-0' : OrderedSet(simplegraph2graph::Edge2Edge[*|1]) = OrderedSet{};
     * roots : Set(OclElement) = upperGraph.rootObjects()
     *   ;
     * _'-child-Graph-' : Set(simplegraph::Graph[*|1]) = roots->selectByKind(simplegraph::Graph)
     *   ;
     * _'-join-Graph-0' : Set(simplegraph::Graph[*|1]) = _'-child-Graph-';
     * _'-join-Node-0' : OrderedSet(simplegraph::Node[*|1]) = OrderedSet{};
     * _'-join-Node2Node-0' : OrderedSet(simplegraph2graph::Node2Node[*|1]) = OrderedSet{};
     *  |}
     * for loop0 : simplegraph::Graph in _'-join-Graph-0' {
     * 
     *     map _'simplegraph%Graph%element' {
     * _'-join-Edge-0' := _'-join-Edge-0';
     * _'-join-Node-0' := _'-join-Node-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : simplegraph::Graph in _'-join-Graph-0' {
     * 
     *     map _'graph2graph_LM\\ngraph2graph_MR' {
     * g1 := loop0;
     * }}
     *   for loop0 : simplegraph::Node in _'-join-Node-0' {
     * 
     *     map node2node_LM {
     * _'-join-Node2Node-0' := _'-join-Node2Node-0';
     * n1 := loop0;
     * }}
     *   for loop0 : simplegraph::Edge in _'-join-Edge-0' {
     * 
     *     map edge2edge_LM {
     * _'-join-Edge2Edge-0' := _'-join-Edge2Edge-0';
     * e1 := loop0;
     * }}
     *   for loop0 : simplegraph2graph::Node2Node in _'-join-Node2Node-0' {
     * 
     *     map node2node_MR {
     * n2n := loop0;
     * }}
     *   for loop0 : simplegraph2graph::Edge2Edge in _'-join-Edge2Edge-0' {
     * 
     *     map edge2edge_MR {
     * e2e := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_simplegraph_c_c_Graph_0 = idResolver.getClass(CLSSid_Graph, null);
        // variable assignments
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue rootObjects = ClassUtil.nonNullState(RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*upperGraph*/]));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_simplegraph_c_c_Graph_0));
        // connection variables
        final OrderedSetValue.@NonNull Accumulator _m_join_m_Edge_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Edge);
        final OrderedSetValue.@NonNull Accumulator _m_join_m_Edge2Edge_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Edge2Edge);
        final OrderedSetValue.@NonNull Accumulator _m_join_m_Node_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Node);
        final OrderedSetValue.@NonNull Accumulator _m_join_m_Node2Node_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Node2Node);
        // mapping statements
        for (Graph loop0 : ValueUtil.typedIterable(Graph.class, selectByKind)) {
            if (loop0 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph symbol_0 = (Graph)loop0;
                MAP_simplegraph_37Graph_37element(_m_join_m_Edge_m_0_1, _m_join_m_Node_m_0_1, symbol_0);
            }
        }
        for (Graph loop0_0 : ValueUtil.typedIterable(Graph.class, selectByKind)) {
            if (loop0_0 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph symbol_2 = (Graph)loop0_0;
                if (symbol_2 != null) {
                    MAP_graph2graph_LM_92ngraph2graph_MR(symbol_2);
                }
            }
        }
        for (Node loop0_1 : ValueUtil.typedIterable(Node.class, _m_join_m_Node_m_0_1)) {
            if (loop0_1 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Node symbol_4 = (Node)loop0_1;
                if (symbol_4 != null) {
                    MAP_node2node_LM(_m_join_m_Node2Node_m_0_1, symbol_4);
                }
            }
        }
        for (Edge loop0_2 : ValueUtil.typedIterable(Edge.class, _m_join_m_Edge_m_0_1)) {
            if (loop0_2 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Edge symbol_6 = (Edge)loop0_2;
                if (symbol_6 != null) {
                    MAP_edge2edge_LM(_m_join_m_Edge2Edge_m_0_1, symbol_6);
                }
            }
        }
        for (Node2Node loop0_3 : ValueUtil.typedIterable(Node2Node.class, _m_join_m_Node2Node_m_0_1)) {
            if (loop0_3 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.NonNull Node2Node symbol_8 = (Node2Node)loop0_3;
                if (symbol_8 != null) {
                    MAP_node2node_MR(symbol_8);
                }
            }
        }
        for (Edge2Edge loop0_4 : ValueUtil.typedIterable(Edge2Edge.class, _m_join_m_Edge2Edge_m_0_1)) {
            if (loop0_4 != null) {
                final /*@NonInvalid*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.NonNull Edge2Edge symbol_10 = (Edge2Edge)loop0_4;
                if (symbol_10 != null) {
                    MAP_edge2edge_MR(symbol_10);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map edge2edge_LM in UpperToLower {
     * middle ( |)
     * {realize e2e : simplegraph2graph::Edge2Edge[1];
     *  |}
     * upperGraph (e1 : simplegraph::Edge[?];
     *  |)
     * { |}
     * where (_'-join-Edge2Edge-0' : OrderedSet(simplegraph2graph::Edge2Edge[*|1]);
     *  |)
     * {g1 : simplegraph::Graph[1] = e1.graph;
     * sn1 : simplegraph::Node[?] = e1.source;
     * tn1 : simplegraph::Node[?] = e1.target;
     * g2g : simplegraph2graph::Graph2Graph[?] = g1.middle1;
     * sn2n : simplegraph2graph::Node2Node[?] = sn1.middle1;
     * tn2n : simplegraph2graph::Node2Node[?] = tn1.middle1;
     *  |
     * _'-join-Edge2Edge-0' += e2e;
     * e2e.edge1 := e1;
     * e2e.owner := g2g;
     * e2e.source := sn2n;
     * e2e.target := tn2n;
     * }
     * 
     */
    protected boolean MAP_edge2edge_LM(final OrderedSetValue.@NonNull Accumulator _m_join_m_Edge2Edge_m_0, final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Edge e1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph graph = e1.getGraph();
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Node source = e1.getSource();
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Node target = e1.getTarget();
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Graph2Graph middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Graph2Graph_graph1.get(graph));
        if (source == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Node2Node::node1\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Node2Node middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Node2Node_node1.get(source));
        if (target == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Node2Node::node1\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Node2Node middle1_1 = ClassUtil.nonNullState (OPPOSITE_OF_Node2Node_node1.get(target));
        // creations
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Edge2Edge e2e_0 = Simplegraph2graphFactory.eINSTANCE.createEdge2Edge();
        assert e2e_0 != null;
        models[2/*middle*/].add(e2e_0);
        // property assignments
        e2e_0.setEdge1(e1);
        e2e_0.setOwner(middle1);
        e2e_0.setSource(middle1_0);
        e2e_0.setTarget(middle1_1);
        // connection assignments
        _m_join_m_Edge2Edge_m_0.add(e2e_0);
        return true;
    }
    
    /**
     * 
     * map edge2edge_MR in UpperToLower {
     * lowerGraph ( |)
     * {realize e2 : simplegraph::Edge[1];
     *  |}
     * middle (e2e : simplegraph2graph::Edge2Edge[?];
     *  |)
     * { |}
     * where ( |)
     * {g2g : simplegraph2graph::Graph2Graph[?] = e2e.owner;
     * sn2n : simplegraph2graph::Node2Node[?] = e2e.source;
     * tn2n : simplegraph2graph::Node2Node[?] = e2e.target;
     * g2 : simplegraph::Graph[?] = g2g.graph2;
     * sn2 : simplegraph::Node[?] = sn2n.node2;
     * tn2 : simplegraph::Node[?] = tn2n.node2;
     *  |
     * e2e.edge2 := e2;
     * e2.graph := g2;
     * e2.source := sn2;
     * e2.target := tn2;
     * }
     * 
     */
    protected boolean MAP_edge2edge_MR(final /*@NonInvalid*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.NonNull Edge2Edge e2e) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Graph2Graph owner = e2e.getOwner();
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Node2Node source = e2e.getSource();
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Node2Node target = e2e.getTarget();
        if (owner == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Graph2Graph::graph2\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Graph graph2 = owner.getGraph2();
        if (source == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Node2Node::node2\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Node node2 = source.getNode2();
        if (target == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Node2Node::node2\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Node node2_0 = target.getNode2();
        // creations
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Edge e2 = SimplegraphFactory.eINSTANCE.createEdge();
        assert e2 != null;
        models[1/*lowerGraph*/].add(e2);
        // property assignments
        e2e.setEdge2(e2);
        e2.setGraph(graph2);
        e2.setSource(node2);
        e2.setTarget(node2_0);
        return true;
    }
    
    /**
     * 
     * map _'graph2graph_LM\\ngraph2graph_MR' in UpperToLower {
     * 
     *   lowerGraph ( |)
     * {realize g2 : simplegraph::Graph[1];
     *  |}
     * middle ( |)
     * {realize g2g : simplegraph2graph::Graph2Graph[1];
     *  |}
     * upperGraph (g1 : simplegraph::Graph[?];
     *  |)
     * { |}
     * where ( |)
     * {name : String[?] = g1.name;
     * toLowerCase : String[1] = name.toLowerCase();
     *  |
     * g2g.graph1 := g1;
     * g2g.graph2 := g2;
     * g2g.name := toLowerCase;
     * g2.name := toLowerCase;
     * }
     * 
     */
    protected boolean MAP_graph2graph_LM_92ngraph2graph_MR(final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph g1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = g1.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toLowerCase = ClassUtil.nonNullState(StringToLowerCaseOperation.INSTANCE.evaluate(name));
        // creations
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Graph g2 = SimplegraphFactory.eINSTANCE.createGraph();
        assert g2 != null;
        models[1/*lowerGraph*/].add(g2);
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Graph2Graph g2g = Simplegraph2graphFactory.eINSTANCE.createGraph2Graph();
        assert g2g != null;
        models[2/*middle*/].add(g2g);
        // property assignments
        g2g.setGraph1(g1);
        OPPOSITE_OF_Graph2Graph_graph1.put(g1, g2g);
        g2g.setGraph2(g2);
        g2g.setName(toLowerCase);
        g2.setName(toLowerCase);
        return true;
    }
    
    /**
     * 
     * map node2node_LM in UpperToLower {
     * 
     *   middle ( |)
     * {realize n2n : simplegraph2graph::Node2Node[1];
     *  |}
     * upperGraph (n1 : simplegraph::Node[?];
     *  |)
     * { |}
     * where (_'-join-Node2Node-0' : OrderedSet(simplegraph2graph::Node2Node[*|1]);
     *  |)
     * {g1 : simplegraph::Graph[1] = n1.graph;
     * label : String[?] = n1.label;
     * g2g : simplegraph2graph::Graph2Graph[?] = g1.middle1;
     * toLowerCase : String[1] = label.toLowerCase();
     *  |
     * _'-join-Node2Node-0' += n2n;
     * n2n.label := toLowerCase;
     * n2n.node1 := n1;
     * n2n.owner := g2g;
     * }
     * 
     */
    protected boolean MAP_node2node_LM(final OrderedSetValue.@NonNull Accumulator _m_join_m_Node2Node_m_0, final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Node n1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph graph = n1.getGraph();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String label = n1.getLabel();
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Graph2Graph middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Graph2Graph_graph1.get(graph));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toLowerCase = ClassUtil.nonNullState(StringToLowerCaseOperation.INSTANCE.evaluate(label));
        // creations
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Node2Node n2n_0 = Simplegraph2graphFactory.eINSTANCE.createNode2Node();
        assert n2n_0 != null;
        models[2/*middle*/].add(n2n_0);
        // property assignments
        n2n_0.setLabel(toLowerCase);
        n2n_0.setNode1(n1);
        OPPOSITE_OF_Node2Node_node1.put(n1, n2n_0);
        n2n_0.setOwner(middle1);
        // connection assignments
        _m_join_m_Node2Node_m_0.add(n2n_0);
        return true;
    }
    
    /**
     * 
     * map node2node_MR in UpperToLower {
     * lowerGraph ( |)
     * {realize n2 : simplegraph::Node[1];
     *  |}
     * middle (n2n : simplegraph2graph::Node2Node[?];
     *  |)
     * { |}
     * where ( |)
     * {g2g : simplegraph2graph::Graph2Graph[?] = n2n.owner;
     * label : String[?] = n2n.label;
     * g2 : simplegraph::Graph[?] = g2g.graph2;
     *  |
     * n2.graph := g2;
     * n2.label := label;
     * n2n.node2 := n2;
     * }
     * 
     */
    protected boolean MAP_node2node_MR(final /*@NonInvalid*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.NonNull Node2Node n2n) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ build.upper2lower.simplegraph2graph.@org.eclipse.jdt.annotation.Nullable Graph2Graph owner = n2n.getOwner();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String label = n2n.getLabel();
        if (owner == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph\'::Graph2Graph::graph2\'");
        }
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Graph graph2 = owner.getGraph2();
        // creations
        final /*@Thrown*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.Nullable Node n2 = SimplegraphFactory.eINSTANCE.createNode();
        assert n2 != null;
        models[1/*lowerGraph*/].add(n2);
        // property assignments
        n2.setGraph(graph2);
        n2.setLabel(label);
        n2n.setNode2(n2);
        return true;
    }
    
    /**
     * 
     * map _'simplegraph%Graph%element' in UpperToLower {
     * 
     *   upperGraph (_'-parent-' : simplegraph::Graph[1];
     *  |)
     * { |}
     * where (_'-join-Edge-0' : OrderedSet(simplegraph::Edge[*|1]);
     * _'-join-Node-0' : OrderedSet(simplegraph::Node[*|1]);
     *  |)
     * {allChildren : OrderedSet(simplegraph::Element) = _'-parent-'.element->selectByKind(simplegraph::Element)
     *   ;
     * _'-child-Edge-' : OrderedSet(simplegraph::Edge[*|1]) = allChildren->selectByKind(simplegraph::Edge)
     *   ;
     * _'-child-Node-' : OrderedSet(simplegraph::Node[*|1]) = allChildren->selectByKind(simplegraph::Node);
     *  |
     * _'-join-Edge-0' += _'-child-Edge-';
     * _'-join-Node-0' += _'-child-Node-';
     * }
     * 
     */
    protected boolean MAP_simplegraph_37Graph_37element(final OrderedSetValue.@NonNull Accumulator _m_join_m_Edge_m_0, final OrderedSetValue.@NonNull Accumulator _m_join_m_Node_m_0, final /*@NonInvalid*/ build.upper2lower.simplegraph.@org.eclipse.jdt.annotation.NonNull Graph _m_parent_m) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_simplegraph_c_c_Edge_0 = idResolver.getClass(CLSSid_Edge, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_simplegraph_c_c_Element_0 = idResolver.getClass(CLSSid_Element, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_simplegraph_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ List<Element> element = _m_parent_m.getElement();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_element = idResolver.createOrderedSetOfAll(ORD_CLSSid_Element, element);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_element, TYP_simplegraph_c_c_Element_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_simplegraph_c_c_Edge_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_1 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_simplegraph_c_c_Node_0));
        // connection assignments
        for (Edge iterator : ValueUtil.typedIterable(Edge.class, selectByKind_0)) {
            if (iterator instanceof Edge) {
                _m_join_m_Edge_m_0.add(iterator);
            }
        }
        for (Node iterator_0 : ValueUtil.typedIterable(Node.class, selectByKind_1)) {
            if (iterator_0 instanceof Node) {
                _m_join_m_Node_m_0.add(iterator_0);
            }
        }
        return true;
    }
}
