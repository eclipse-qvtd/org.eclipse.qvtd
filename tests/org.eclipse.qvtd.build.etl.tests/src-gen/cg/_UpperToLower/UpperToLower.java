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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.string.StringToLowerCaseOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
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
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph", null, SimplegraphPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/test/compiler/0.1/SimpleGraph2Graph", null, Simplegraph2graphPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Edge = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Edge", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Edge2Edge = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Edge2Edge", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Graph = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Graph", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Graph2Graph = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Graph2Graph", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Node = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph.getClassId("Node", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Node2Node = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_test_s_compiler_s_0_1_s_SimpleGraph2Graph.getClassId("Node2Node", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Edge = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Edge);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Element = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Element);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Graph = TypeId.SET.getSpecializedId(CLSSid_Graph);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet_0 = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Node);
    public static final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Edge);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<Graph,Graph2Graph> OPPOSITE_OF_Graph2Graph_graph1 = new HashMap<Graph,Graph2Graph>();
    protected final @NonNull Map<Node,Node2Node> OPPOSITE_OF_Node2Node_node1 = new HashMap<Node,Node2Node>();
    
    
    
    public UpperToLower(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"upperGraph", "lowerGraph", "middle"}, null, null, null);
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
     * roots : Set(OclElement) = upperGraph.rootObjects()
     *   ;
     * _'-child-Graph-' : Set(simplegraph::Graph[*|1]) = roots->selectByKind(simplegraph::Graph)
     *   ;
     * _'-join-Graph-0' : Set(simplegraph::Graph[*|1]) = _'-child-Graph-';
     * _'-join-Node-0' : OrderedSet(simplegraph::Node[*|1]) = OrderedSet{};
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
     * n1 := loop0;
     * }}
     *   for loop0 : simplegraph::Edge in _'-join-Edge-0' {
     * 
     *     map edge2edge_LM {
     * e1 := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_simplegraph_c_c_Graph_0 = idResolver.getClass(CLSSid_Graph, null);
        // variable assignments
        final @NonNull /*@NonInvalid*/ SetValue rootObjects = RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*upperGraph*/]);
        final @NonNull /*@NonInvalid*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_simplegraph_c_c_Graph_0);
        // connection variables
        final @NonNull OrderedSetValue.Accumulator _m_join_m_Edge_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Edge);
        final @NonNull OrderedSetValue.Accumulator _m_join_m_Node_m_0_1 = (OrderedSetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Node);
        // mapping statements
        for (Graph loop0 : ValueUtil.typedIterable(Graph.class, selectByKind)) {
            if (loop0 != null) {
                final @NonNull /*@NonInvalid*/ Graph symbol_0 = (Graph)loop0;
                MAP_simplegraph_37Graph_37element(_m_join_m_Edge_m_0_1, _m_join_m_Node_m_0_1, symbol_0);
            }
        }
        for (Graph loop0_0 : ValueUtil.typedIterable(Graph.class, selectByKind)) {
            if (loop0_0 != null) {
                final @NonNull /*@NonInvalid*/ Graph symbol_2 = (Graph)loop0_0;
                MAP_graph2graph_LM_92ngraph2graph_MR(symbol_2);
            }
        }
        for (Node loop0_1 : ValueUtil.typedIterable(Node.class, _m_join_m_Node_m_0_1)) {
            if (loop0_1 != null) {
                final @NonNull /*@NonInvalid*/ Node symbol_4 = (Node)loop0_1;
                MAP_node2node_LM(symbol_4);
            }
        }
        for (Edge loop0_2 : ValueUtil.typedIterable(Edge.class, _m_join_m_Edge_m_0_1)) {
            if (loop0_2 != null) {
                final @NonNull /*@NonInvalid*/ Edge symbol_6 = (Edge)loop0_2;
                MAP_edge2edge_LM(symbol_6);
            }
        }
        return true;
    }
    
    /**
     * 
     * map edge2edge_LM in UpperToLower {
     * 
     *   middle ( |)
     * {realize e2e : simplegraph2graph::Edge2Edge[1];
     *  |}
     * upperGraph (e1 : simplegraph::Edge[1];
     *  |)
     * { |}
     * where ( |)
     * {sn1 : simplegraph::Node[1] = e1.source;
     * tn1 : simplegraph::Node[1] = e1.target;
     * g1 : simplegraph::Graph[1] = e1.graph;
     * sn2n : simplegraph2graph::Node2Node[1] = sn1.middle1;
     * tn2n : simplegraph2graph::Node2Node[1] = tn1.middle1;
     * g2g : simplegraph2graph::Graph2Graph[1] = g1.middle1;
     *  |
     * e2e.edge1 := e1;
     * e2e.owner := g2g;
     * e2e.source := sn2n;
     * e2e.target := tn2n;
     * }
     * map edge2edge_MR {
     * e2e := e2e;
     * }
     */
    protected boolean MAP_edge2edge_LM(final @NonNull /*@NonInvalid*/ Edge e1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ Node source = e1.getSource();
        final @Nullable /*@Thrown*/ Node target = e1.getTarget();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Graph graph = e1.getGraph();
        final @Nullable /*@Thrown*/ Node2Node middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Node2Node_node1.get(source));
        final @Nullable /*@Thrown*/ Node2Node middle1_0 = ClassUtil.nonNullState (OPPOSITE_OF_Node2Node_node1.get(target));
        final @Nullable /*@Thrown*/ Graph2Graph middle1_1 = ClassUtil.nonNullState (OPPOSITE_OF_Graph2Graph_graph1.get(graph));
        // creations
        final /*@Thrown*/ Edge2Edge e2e_0 = Simplegraph2graphFactory.eINSTANCE.createEdge2Edge();
        assert e2e_0 != null;
        models[2/*middle*/].add(e2e_0);
        // property assignments
        e2e_0.setEdge1(e1);
        e2e_0.setOwner(middle1_1);
        e2e_0.setSource(middle1);
        e2e_0.setTarget(middle1_0);
        // mapping statements
        MAP_edge2edge_MR(e2e_0);
        return true;
    }
    
    /**
     * 
     * map edge2edge_MR in UpperToLower {
     * lowerGraph ( |)
     * {realize e2 : simplegraph::Edge[1];
     *  |}
     * middle (e2e : simplegraph2graph::Edge2Edge[1];
     *  |)
     * { |}
     * where ( |)
     * {tn2n : simplegraph2graph::Node2Node[1] = e2e.target;
     * sn2n : simplegraph2graph::Node2Node[1] = e2e.source;
     * g2g : simplegraph2graph::Graph2Graph[1] = e2e.owner;
     * tn2 : simplegraph::Node[1] = tn2n.node2;
     * sn2 : simplegraph::Node[1] = sn2n.node2;
     * g2 : simplegraph::Graph[1] = g2g.graph2;
     *  |
     * e2e.edge2 := e2;
     * e2.graph := g2;
     * e2.source := sn2;
     * e2.target := tn2;
     * }
     * 
     */
    protected boolean MAP_edge2edge_MR(final @NonNull /*@NonInvalid*/ Edge2Edge e2e) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ Node2Node target = e2e.getTarget();
        final @Nullable /*@Thrown*/ Node2Node source = e2e.getSource();
        final @Nullable /*@Thrown*/ Graph2Graph owner = e2e.getOwner();
        final @Nullable /*@Thrown*/ Node node2 = target.getNode2();
        final @Nullable /*@Thrown*/ Node node2_0 = source.getNode2();
        final @Nullable /*@Thrown*/ Graph graph2 = owner.getGraph2();
        // creations
        final /*@Thrown*/ Edge e2 = SimplegraphFactory.eINSTANCE.createEdge();
        assert e2 != null;
        models[1/*lowerGraph*/].add(e2);
        // property assignments
        e2e.setEdge2(e2);
        e2.setGraph(graph2);
        e2.setSource(node2_0);
        e2.setTarget(node2);
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
     * upperGraph (g1 : simplegraph::Graph[1];
     *  |)
     * { |}
     * where ( |)
     * {name : String[1] = g1.name;
     * toLowerCase : String[1] = name.toLowerCase();
     *  |
     * g2g.graph1 := g1;
     * g2g.graph2 := g2;
     * g2g.name := toLowerCase;
     * g2.name := toLowerCase;
     * }
     * 
     */
    protected boolean MAP_graph2graph_LM_92ngraph2graph_MR(final @NonNull /*@NonInvalid*/ Graph g1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ String name = g1.getName();
        final @NonNull /*@NonInvalid*/ String toLowerCase = StringToLowerCaseOperation.INSTANCE.evaluate(name);
        // creations
        final /*@Thrown*/ Graph g2 = SimplegraphFactory.eINSTANCE.createGraph();
        assert g2 != null;
        models[1/*lowerGraph*/].add(g2);
        final /*@Thrown*/ Graph2Graph g2g = Simplegraph2graphFactory.eINSTANCE.createGraph2Graph();
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
     * upperGraph (n1 : simplegraph::Node[1];
     *  |)
     * { |}
     * where ( |)
     * {g1 : simplegraph::Graph[1] = n1.graph;
     * label : String[1] = n1.label;
     * g2g : simplegraph2graph::Graph2Graph[1] = g1.middle1;
     * toLowerCase : String[1] = label.toLowerCase()
     *   ;
     *  |
     * n2n.label := toLowerCase;
     * n2n.node1 := n1;
     * n2n.owner := g2g;
     * }
     * map node2node_MR {
     * n2n := n2n;
     * }
     */
    protected boolean MAP_node2node_LM(final @NonNull /*@NonInvalid*/ Node n1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Graph graph = n1.getGraph();
        final @Nullable /*@Thrown*/ String label = n1.getLabel();
        final @Nullable /*@Thrown*/ Graph2Graph middle1 = ClassUtil.nonNullState (OPPOSITE_OF_Graph2Graph_graph1.get(graph));
        final @NonNull /*@NonInvalid*/ String toLowerCase = StringToLowerCaseOperation.INSTANCE.evaluate(label);
        // creations
        final /*@Thrown*/ Node2Node n2n_0 = Simplegraph2graphFactory.eINSTANCE.createNode2Node();
        assert n2n_0 != null;
        models[2/*middle*/].add(n2n_0);
        // property assignments
        n2n_0.setLabel(toLowerCase);
        n2n_0.setNode1(n1);
        OPPOSITE_OF_Node2Node_node1.put(n1, n2n_0);
        n2n_0.setOwner(middle1);
        // mapping statements
        MAP_node2node_MR(n2n_0);
        return true;
    }
    
    /**
     * 
     * map node2node_MR in UpperToLower {
     * lowerGraph ( |)
     * {realize n2 : simplegraph::Node[1];
     *  |}
     * middle (n2n : simplegraph2graph::Node2Node[1];
     *  |)
     * { |}
     * where ( |)
     * {g2g : simplegraph2graph::Graph2Graph[1] = n2n.owner;
     * label : String[1] = n2n.label;
     * g2 : simplegraph::Graph[1] = g2g.graph2;
     *  |
     * n2.graph := g2;
     * n2.label := label;
     * n2n.node2 := n2;
     * }
     * 
     */
    protected boolean MAP_node2node_MR(final @NonNull /*@NonInvalid*/ Node2Node n2n) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ Graph2Graph owner = n2n.getOwner();
        final @Nullable /*@Thrown*/ String label = n2n.getLabel();
        final @Nullable /*@Thrown*/ Graph graph2 = owner.getGraph2();
        // creations
        final /*@Thrown*/ Node n2 = SimplegraphFactory.eINSTANCE.createNode();
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
     * upperGraph (_'-parent-' : simplegraph::Graph[1];
     *  |)
     * { |}
     * where (_'-join-Edge-0' : OrderedSet(simplegraph::Edge[*|1]);
     * _'-join-Node-0' : OrderedSet(simplegraph::Node[*|1]);
     *  |)
     * {allChildren : OrderedSet(simplegraph::Element) = _'-parent-'.element;
     *  |
     * _'-join-Edge-0' += allChildren;
     * _'-join-Node-0' += allChildren;
     * }
     * 
     */
    protected boolean MAP_simplegraph_37Graph_37element(final @NonNull OrderedSetValue.Accumulator _m_join_m_Edge_m_0, final @NonNull OrderedSetValue.Accumulator _m_join_m_Node_m_0, final @NonNull /*@NonInvalid*/ Graph _m_parent_m) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Element> element = _m_parent_m.getElement();
        // connection assignments
        for (Element iterator : element) {
            if (iterator instanceof Edge) {
                _m_join_m_Edge_m_0.add(iterator);
            }
        }
        for (Element iterator_0 : element) {
            if (iterator_0 instanceof Node) {
                _m_join_m_Node_m_0.add(iterator_0);
            }
        }
        return true;
    }
}
