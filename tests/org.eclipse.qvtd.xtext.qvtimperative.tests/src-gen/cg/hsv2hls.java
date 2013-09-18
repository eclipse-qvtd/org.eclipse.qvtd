/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package cg;

import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.AbstractTransformation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
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
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree = IdManager.getNsURIPackageId("http://http://www.eclipse.org/qvt/examples/0.1/HLSTree", "hls", HLSTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree = IdManager.getNsURIPackageId("http://http://www.eclipse.org/qvt/examples/0.1/HSVTree", "hsv", HSVTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS = IdManager.getNsURIPackageId("http://http://www.eclipse.org/qvt/examples/0.1/HSVtoHLS", "hsv2hls", HSV2HLSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HLSNode = PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HLSTree.getClassId("HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode = PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVTree.getClassId("HSVNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode2HLSNode = PACKid_http_c_s_s_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_HSVtoHLS.getClassId("HSVNode2HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_HSVNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_HSVNode2HLSNode = TypeId.ORDERED_SET.getSpecializedId(CLSSid_HSVNode2HLSNode);
    
    public hsv2hls(final @NonNull DomainEvaluator evaluator) {
        super(evaluator, new String[] {"hsv", "hls", ""});
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
    
    protected @NonNull String hls2rgb(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator_0, final @NonNull /*@NonInvalid*/ TypeId typeId, final @Nullable /*@NonInvalid*/ String color) {
        return "";
    }
    
    protected @NonNull String hsv2rgb(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator_0, final @NonNull /*@NonInvalid*/ TypeId typeId, final @Nullable /*@NonInvalid*/ String color_0) {
        return "";
    }
    
    protected @NonNull String rgb2hls(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator_0, final @NonNull /*@NonInvalid*/ TypeId typeId, final @Nullable /*@NonInvalid*/ String color_1) {
        return "";
    }
    
    protected @NonNull String rgb2hsv(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator_0, final @NonNull /*@NonInvalid*/ TypeId typeId, final @Nullable /*@NonInvalid*/ String color_2) {
        return "";
    }
    
    /**
     * 
     * map HSV2MiddleRoot in hsv2hls) {
     * hsv (hsvRoot : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSVTree.ecore#/'::HSVNode;
     *  |
     * hsvRoot.parent =
     *   null)
     * { |
     * }
     * where ( |
     * )
     * {realize middleRoot : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * middleRoot = hsvRoot;
     * middleRoot = hsvRoot.name;
     * }
     * map HSV2MiddleRecursion {
     * hsvNode <= hsvRoot.children;
     * middleParent := middleRoot;
     * }
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
            final @NonNull /*@Thrown*/ HSVNode2HLSNode middleRoot = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
            modelObjects[2/*null*/].add(middleRoot);
            // assignments
            middleRoot.setHsv(hsvRoot);
            final @Nullable /*@Thrown*/ String name = hsvRoot.getName();
            middleRoot.setName(name);
            // mapping calls
            final @Nullable /*@Thrown*/ List<HSVNode> children = hsvRoot.getChildren();
            assert children != null;
            for (Object hsvNode_0 : children) {
                if (hsvNode_0 != null) {
                    HSV2MiddleRecursion((HSVNode)hsvNode_0, middleRoot);
                }
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
     *   hsv (hsvNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSVTree.ecore#/'::HSVNode;
     *  |
     * )
     * { |
     * }
     * where (middleParent : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * {realize middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * middleNode = middleParent;
     * middleNode = hsvNode;
     * middleNode = hsvNode.name;
     * }
     * map HSV2MiddleRecursion {
     * hsvNode <= hsvNode.children;
     * middleParent := middleNode;
     * }
     * }
     */
    protected boolean HSV2MiddleRecursion(final @NonNull /*@NonInvalid*/ HSVNode hsvNode, final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleParent) {
        try {
            // predicates
            // creations
            final @NonNull /*@Thrown*/ HSVNode2HLSNode middleNode = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
            modelObjects[2/*null*/].add(middleNode);
            // assignments
            middleNode.setParent(middleParent);
            middleNode.setHsv(hsvNode);
            final @Nullable /*@Thrown*/ String name = hsvNode.getName();
            middleNode.setName(name);
            // mapping calls
            final @Nullable /*@Thrown*/ List<HSVNode> children = hsvNode.getChildren();
            assert children != null;
            for (Object hsvNode_0 : children) {
                if (hsvNode_0 != null) {
                    HSV2MiddleRecursion((HSVNode)hsvNode_0, middleNode);
                }
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
     *   hls ( |
     * )
     * {realize hlsNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HLSTree.ecore#/'::HLSNode;
     *  |
     * }
     * where (middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * hlsNode = null;
     * middleNode = hlsNode;
     * hlsNode = middleNode.name;
     * }
     * map Middle2HLSRecursion {
     * middleNode <= middleNode.children;
     * }
     * }
     */
    protected boolean Middle2HLSRoot(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode) {
        try {
            // predicates
            // creations
            final @Nullable /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
            modelObjects[1/*hls*/].add(hlsNode);
            assert hlsNode != null;
            // assignments
            hlsNode.setParent(null);
            middleNode.setHls(hlsNode);
            final @Nullable /*@Thrown*/ String name = middleNode.getName();
            hlsNode.setName(name);
            // mapping calls
            final @Nullable /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode.getChildren();
            assert children != null;
            for (Object middleNode_1 : children) {
                if (middleNode_1 != null) {
                    Middle2HLSRecursion((HSVNode2HLSNode)middleNode_1);
                }
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
     *   hls ( |
     * )
     * {realize hlsNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HLSTree.ecore#/'::HLSNode;
     *  |
     * }
     * where (middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtimperative.tests/bin/org/eclipse/qvtd/xtext/qvtimperative/tests/models/HSV2HLS/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * hlsNode = middleNode.parent.hls;
     * middleNode = hlsNode;
     * hlsNode = middleNode.name;
     * }
     * map Middle2HLSRecursion {
     * middleNode <= middleNode.children;
     * }
     * }
     */
    protected boolean Middle2HLSRecursion(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode_0) {
        try {
            // predicates
            // creations
            final @Nullable /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
            modelObjects[1/*hls*/].add(hlsNode);
            assert hlsNode != null;
            // assignments
            final @Nullable /*@Thrown*/ HSVNode2HLSNode parent = middleNode_0.getParent();
            if (parent == null) {
                throw new InvalidValueException("Null source");
            }
            final @Nullable /*@Thrown*/ HLSNode hls = parent.getHls();
            hlsNode.setParent(hls);
            middleNode_0.setHls(hlsNode);
            final @Nullable /*@Thrown*/ String name = middleNode_0.getName();
            hlsNode.setName(name);
            // mapping calls
            final @Nullable /*@Thrown*/ List<HSVNode2HLSNode> children = middleNode_0.getChildren();
            assert children != null;
            for (Object middleNode_1 : children) {
                if (middleNode_1 != null) {
                    Middle2HLSRecursion((HSVNode2HLSNode)middleNode_1);
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
