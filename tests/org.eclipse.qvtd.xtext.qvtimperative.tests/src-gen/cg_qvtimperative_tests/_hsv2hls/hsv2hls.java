/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg_qvtimperative_tests._hsv2hls;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfKindOperation;
import test.hls.HLSTree.HLSTreeFactory;
import test.hls.HLSTree.HLSTreePackage;
import test.hsv.HSVTree.HSVNode;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HLS.HSV2HLSFactory;
import test.middle.HSV2HLS.HSV2HLSPackage;
import test.middle.HSV2HLS.HSVNode2HLSNode;

/**
 * The hsv2hls transformation:
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
public class hsv2hls extends AbstractTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HLSTree", null, HLSTreePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HSVTree", null, HSVTreePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HSVtoHLS", null, HSV2HLSPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_HLSNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree.getClassId("HLSNode", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_HSVNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree.getClassId("HSVNode", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_HSVNode2HLSNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS.getClassId("HSVNode2HLSNode", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_HLS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree.getDataTypeId("HLS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_HSV = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree.getDataTypeId("HSV", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_RGB = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS.getDataTypeId("RGB", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_HSVNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_HSVNode2HLSNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode2HLSNode);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_HSVNode = TypeId.SET.getSpecializedId(CLSSid_HSVNode);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
        CLSSid_HSVNode                  // 0 => HSVNode
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
        {0}                     // 0 : HSVNode -> {HSVNode}
    };
    
    
    public hsv2hls(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new @NonNull String[] {"hsv", "hls", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    protected @Nullable String hls2rgb(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String color) {
        return "";
    }
    
    protected @Nullable String hsv2rgb(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String color_0) {
        return "";
    }
    
    protected @Nullable String rgb2hls(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String color_1) {
        return "";
    }
    
    protected @Nullable String rgb2hsv(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String color_2) {
        return "";
    }
    
    /**
     * 
     * map __root__ in hsv2hls {
     * 
     *   where ( |)
     * { |}
     * for hsvRoot : HSVTree::HSVNode in hsv.objectsOfKind(HSVTree::HSVNode)
     *    {
     * map HSV2MiddleRoot {
     * hsvRoot := hsvRoot;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_HSVTree_c_c_HSVNode_0 = idResolver.getClass(CLSSid_HSVNode, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ClassUtil.nonNullState(ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_HSVNode, models[0/*hsv*/], TYP_HSVTree_c_c_HSVNode_0));
        for (HSVNode hsvRoot_1 : ValueUtil.typedIterable(HSVNode.class, objectsOfKind)) {
            if (hsvRoot_1 != null) {
                final /*@NonInvalid*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.NonNull HSVNode symbol_0 = (HSVNode)hsvRoot_1;
                MAP_HSV2MiddleRoot(symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map HSV2MiddleRoot in hsv2hls {
     * hsv (hsvRoot : HSVTree::HSVNode[1];
     *  |)
     * { |}
     * middle ( |)
     * {realize middleRoot : HSV2HLS::HSVNode2HLSNode[1];
     *  |}
     * where ( |
     * hsvRoot.parent =
     *   null)
     * {_0 : String[?];
     *  |
     * _0 := hsvRoot.name;
     * middleRoot.hsv := hsvRoot;
     * middleRoot.name := _0;
     * }
     * for hsvChild : HSVTree::HSVNode in hsvRoot.children {
     * 
     *     map HSV2MiddleRecursion {
     * hsvNode := hsvChild;
     * middleParent := middleRoot;
     * }}
     *   map Middle2HLSRoot {
     * middleNode := middleRoot;
     * }
     */
    protected boolean MAP_HSV2MiddleRoot(final /*@NonInvalid*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.NonNull HSVNode hsvRoot) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.Nullable HSVNode parent = hsvRoot.getParent();
        final /*@Thrown*/ boolean eq = parent == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = hsvRoot.getName();
        // creations
        final /*@Thrown*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.Nullable HSVNode2HLSNode middleRoot = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
        assert middleRoot != null;
        models[2/*middle*/].add(middleRoot);
        // property assignments
        middleRoot.setHsv(hsvRoot);
        middleRoot.setName(name);
        // mapping statements
        @SuppressWarnings("null")
        final /*@Thrown*/ List<HSVNode> children = hsvRoot.getChildren();
        for (HSVNode hsvChild : children) {
            if (hsvChild != null) {
                final /*@NonInvalid*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.NonNull HSVNode symbol_2 = (HSVNode)hsvChild;
                MAP_HSV2MiddleRecursion(symbol_2, middleRoot);
            }
        }
        MAP_Middle2HLSRoot(middleRoot);
        return true;
    }
    
    /**
     * 
     * map HSV2MiddleRecursion in hsv2hls {
     * 
     *   hsv (hsvNode : HSVTree::HSVNode[1];
     *  |)
     * { |}
     * middle (middleParent : HSV2HLS::HSVNode2HLSNode[1];
     *  |)
     * {realize middleNode : HSV2HLS::HSVNode2HLSNode[1];
     *  |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := hsvNode.name;
     * middleNode.parent := middleParent;
     * middleNode.hsv := hsvNode;
     * middleNode.name := _0;
     * }
     * for hsvChild : HSVTree::HSVNode in hsvNode.children {
     * 
     *     map HSV2MiddleRecursion {
     * hsvNode := hsvChild;
     * middleParent := middleNode;
     * }}
     */
    protected boolean MAP_HSV2MiddleRecursion(final /*@NonInvalid*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.NonNull HSVNode hsvNode, final /*@NonInvalid*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.NonNull HSVNode2HLSNode middleParent) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = hsvNode.getName();
        // creations
        final /*@Thrown*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.Nullable HSVNode2HLSNode middleNode_1 = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
        assert middleNode_1 != null;
        models[2/*middle*/].add(middleNode_1);
        // property assignments
        middleNode_1.setParent(middleParent);
        middleNode_1.setHsv(hsvNode);
        middleNode_1.setName(name);
        // mapping statements
        @SuppressWarnings("null")
        final /*@Thrown*/ List<HSVNode> children = hsvNode.getChildren();
        for (HSVNode hsvChild : children) {
            if (hsvChild != null) {
                final /*@NonInvalid*/ test.hsv.HSVTree.@org.eclipse.jdt.annotation.NonNull HSVNode symbol_3 = (HSVNode)hsvChild;
                MAP_HSV2MiddleRecursion(symbol_3, middleNode_1);
            }
        }
        return true;
    }
    
    /**
     * 
     * map Middle2HLSRoot in hsv2hls {
     * 
     *   middle (middleNode : HSV2HLS::HSVNode2HLSNode[1];
     *  |)
     * { |}
     * hls ( |)
     * {realize hlsNode : HLSTree::HLSNode[1];
     *  |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := middleNode.name;
     * hlsNode.parent := null;
     * middleNode.hls := hlsNode;
     * hlsNode.name := _0;
     * }
     * for middleChild : HSV2HLS::HSVNode2HLSNode in middleNode.children {
     * 
     *     map Middle2HLSRecursion {
     * middleNode := middleChild;
     * }}
     */
    protected boolean MAP_Middle2HLSRoot(final /*@NonInvalid*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.NonNull HSVNode2HLSNode middleNode) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = middleNode.getName();
        // creations
        final /*@Thrown*/ test.hls.HLSTree.@org.eclipse.jdt.annotation.Nullable HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
        assert hlsNode != null;
        models[1/*hls*/].add(hlsNode);
        // property assignments
        hlsNode.setParent(null);
        middleNode.setHls(hlsNode);
        hlsNode.setName(name);
        // mapping statements
        @SuppressWarnings("null")
        final /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode.getChildren();
        for (HSVNode2HLSNode middleChild : children) {
            if (middleChild != null) {
                final /*@NonInvalid*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.NonNull HSVNode2HLSNode symbol_3 = (HSVNode2HLSNode)middleChild;
                MAP_Middle2HLSRecursion(symbol_3);
            }
        }
        return true;
    }
    
    /**
     * 
     * map Middle2HLSRecursion in hsv2hls {
     * 
     *   middle (middleNode : HSV2HLS::HSVNode2HLSNode[1];
     *  |)
     * { |}
     * hls ( |)
     * {realize hlsNode : HLSTree::HLSNode[1];
     *  |}
     * where ( |)
     * {_0 : HLSTree::HLSNode[1];
     * _1 : String[?];
     *  |
     * _0 := middleNode.parent.hls;
     * _1 := middleNode.name;
     * hlsNode.parent := _0;
     * middleNode.hls := hlsNode;
     * hlsNode.name := _1;
     * }
     * for middleChild : HSV2HLS::HSVNode2HLSNode in middleNode.children {
     * 
     *     map Middle2HLSRecursion {
     * middleNode := middleChild;
     * }}
     */
    protected boolean MAP_Middle2HLSRecursion(final /*@NonInvalid*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.NonNull HSVNode2HLSNode middleNode_0) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.Nullable HSVNode2HLSNode parent = middleNode_0.getParent();
        if (parent == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/HSVtoHLS\'::HSVNode2HLSNode::hls\'");
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ test.hls.HLSTree.@org.eclipse.jdt.annotation.NonNull HLSNode hls = parent.getHls();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = middleNode_0.getName();
        // creations
        final /*@Thrown*/ test.hls.HLSTree.@org.eclipse.jdt.annotation.Nullable HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
        assert hlsNode != null;
        models[1/*hls*/].add(hlsNode);
        // property assignments
        hlsNode.setParent(hls);
        middleNode_0.setHls(hlsNode);
        hlsNode.setName(name);
        // mapping statements
        @SuppressWarnings("null")
        final /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode_0.getChildren();
        for (HSVNode2HLSNode middleChild : children) {
            if (middleChild != null) {
                final /*@NonInvalid*/ test.middle.HSV2HLS.@org.eclipse.jdt.annotation.NonNull HSVNode2HLSNode symbol_3 = (HSVNode2HLSNode)middleChild;
                MAP_Middle2HLSRecursion(symbol_3);
            }
        }
        return true;
    }
}
