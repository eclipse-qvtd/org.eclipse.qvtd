/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.AbstractTransformation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import test.hls.HLSTree.HLSNode;
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
public class hsv2hls extends AbstractTransformation
{
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HLSTree", null, HLSTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HSVTree", null, HSVTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/HSVtoHLS", null, HSV2HLSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HLSNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree.getClassId("HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree.getClassId("HSVNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode2HLSNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS.getClassId("HSVNode2HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_HLS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree.getDataTypeId("HLS", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_HSV = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree.getDataTypeId("HSV", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_RGB = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS.getDataTypeId("RGB", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_HSVNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_HSVNode2HLSNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode2HLSNode);
    
    public hsv2hls(final @NonNull DomainEvaluator evaluator) {
        super(evaluator, new String[] {"hsv", "hls", "middle"});
    }
    
    public boolean run() {
        final EClass ECLASS_hsvRoot = HSVTreePackage.Literals.HSV_NODE;
        assert ECLASS_hsvRoot != null;
        List<? extends HSVNode> LIST_hsvRoot = getObjectsByType(HSVNode.class, 0/*hsv*/, ECLASS_hsvRoot);
        for (HSVNode hsvRoot : LIST_hsvRoot) {
            if (hsvRoot != null) {
                HSV2MiddleRoot(hsvRoot);
            }
        }
        return true;
    }
    
    protected @NonNull String hls2rgb(final @Nullable /*@NonInvalid*/ String color) {
        return "";
    }
    
    protected @NonNull String hsv2rgb(final @Nullable /*@NonInvalid*/ String color_0) {
        return "";
    }
    
    protected @NonNull String rgb2hls(final @Nullable /*@NonInvalid*/ String color_1) {
        return "";
    }
    
    protected @NonNull String rgb2hsv(final @Nullable /*@NonInvalid*/ String color_2) {
        return "";
    }
    
    /**
     * 
     * map HSV2MiddleRoot in hsv2hls) {
     * hsv (hsvRoot : HSVTree::HSVNode;
     *  |
     * )
     * { |
     * }
     * middle ( |
     * )
     * {realize middleRoot : HSV2HLS::HSVNode2HLSNode;
     *  |
     * }
     * where ( |
     * hsvRoot.parent =
     *   null)
     * { |
     * middleRoot = hsvRoot;
     * middleRoot = hsvRoot.name;
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
     * }
     */
    protected boolean HSV2MiddleRoot(final @NonNull /*@NonInvalid*/ HSVNode hsvRoot) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ HSVNode parent = hsvRoot.getParent();
            final /*@Thrown*/ boolean eq = parent == null;
            if (!eq) {
                return false;
            }
            // creations
            final /*@Thrown*/ HSVNode2HLSNode middleRoot = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
            assert middleRoot != null;
            modelObjects[2/*middle*/].add(middleRoot);
            // assignments
            middleRoot.setHsv(hsvRoot);
            final @Nullable /*@Thrown*/ String name = hsvRoot.getName();
            middleRoot.setName(name);
            // mapping statements
            final @Nullable /*@Thrown*/ List<HSVNode> children = hsvRoot.getChildren();
            assert children != null;
            ;
            for (HSVNode hsvChild : children) {
                final @NonNull /*@NonInvalid*/ HSVNode symbol_3 = (HSVNode)hsvChild;
                HSV2MiddleRecursion(symbol_3, middleRoot);
            }
            Middle2HLSRoot(middleRoot);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map HSV2MiddleRecursion in hsv2hls) {
     * 
     *   hsv (hsvNode : HSVTree::HSVNode;
     *  |
     * )
     * { |
     * }
     * middle (middleParent : HSV2HLS::HSVNode2HLSNode;
     *  |
     * )
     * {realize middleNode : HSV2HLS::HSVNode2HLSNode;
     *  |
     * }
     * where ( |
     * )
     * { |
     * middleNode = middleParent;
     * middleNode = hsvNode;
     * middleNode = hsvNode.name;
     * }
     * for hsvChild : HSVTree::HSVNode in hsvNode.children {
     * 
     *     map HSV2MiddleRecursion {
     * hsvNode := hsvChild;
     * middleParent := middleNode;
     * }}
     * }
     */
    protected boolean HSV2MiddleRecursion(final @NonNull /*@NonInvalid*/ HSVNode hsvNode, final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleParent) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ HSVNode2HLSNode middleNode = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
            assert middleNode != null;
            modelObjects[2/*middle*/].add(middleNode);
            // assignments
            middleNode.setParent(middleParent);
            middleNode.setHsv(hsvNode);
            final @Nullable /*@Thrown*/ String name = hsvNode.getName();
            middleNode.setName(name);
            // mapping statements
            final @Nullable /*@Thrown*/ List<HSVNode> children = hsvNode.getChildren();
            assert children != null;
            ;
            for (HSVNode hsvChild : children) {
                final @NonNull /*@NonInvalid*/ HSVNode symbol_4 = (HSVNode)hsvChild;
                HSV2MiddleRecursion(symbol_4, middleNode);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map Middle2HLSRoot in hsv2hls) {
     * 
     *   middle (middleNode : HSV2HLS::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * }
     * hls ( |
     * )
     * {realize hlsNode : HLSTree::HLSNode;
     *  |
     * }
     * where ( |
     * )
     * { |
     * hlsNode = null;
     * middleNode = hlsNode;
     * hlsNode = middleNode.name;
     * }
     * for middleChild : HSV2HLS::HSVNode2HLSNode in middleNode.children {
     * 
     *     map Middle2HLSRecursion {
     * middleNode := middleChild;
     * }}
     * }
     */
    protected boolean Middle2HLSRoot(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
            assert hlsNode != null;
            modelObjects[1/*hls*/].add(hlsNode);
            // assignments
            hlsNode.setParent(null);
            middleNode.setHls(hlsNode);
            final @Nullable /*@Thrown*/ String name = middleNode.getName();
            hlsNode.setName(name);
            // mapping statements
            final @Nullable /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode.getChildren();
            assert children != null;
            ;
            for (HSVNode2HLSNode middleChild : children) {
                final @NonNull /*@NonInvalid*/ HSVNode2HLSNode symbol_4 = (HSVNode2HLSNode)middleChild;
                Middle2HLSRecursion(symbol_4);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map Middle2HLSRecursion in hsv2hls) {
     * 
     *   middle (middleNode : HSV2HLS::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * }
     * hls ( |
     * )
     * {realize hlsNode : HLSTree::HLSNode;
     *  |
     * }
     * where ( |
     * )
     * { |
     * hlsNode = middleNode.parent.hls;
     * middleNode = hlsNode;
     * hlsNode = middleNode.name;
     * }
     * for middleChild : HSV2HLS::HSVNode2HLSNode in middleNode.children {
     * 
     *     map Middle2HLSRecursion {
     * middleNode := middleChild;
     * }}
     * }
     */
    protected boolean Middle2HLSRecursion(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode_0) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
            assert hlsNode != null;
            modelObjects[1/*hls*/].add(hlsNode);
            // assignments
            final @Nullable /*@Thrown*/ HSVNode2HLSNode parent = middleNode_0.getParent();
            if (parent == null) {
                throw new InvalidValueException("Null source for \'HSV2HLS::HSVNode2HLSNode::hls\'");
            }
            final @Nullable /*@Thrown*/ HLSNode hls = parent.getHls();
            hlsNode.setParent(hls);
            middleNode_0.setHls(hlsNode);
            final @Nullable /*@Thrown*/ String name = middleNode_0.getName();
            hlsNode.setName(name);
            // mapping statements
            final @Nullable /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode_0.getChildren();
            assert children != null;
            ;
            for (HSVNode2HLSNode middleChild : children) {
                final @NonNull /*@NonInvalid*/ HSVNode2HLSNode symbol_4 = (HSVNode2HLSNode)middleChild;
                Middle2HLSRecursion(symbol_4);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
