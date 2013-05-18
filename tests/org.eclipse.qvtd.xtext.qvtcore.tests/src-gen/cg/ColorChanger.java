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
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import test.hls.HLS;
import test.hls.HLSTree.HLSNode;
import test.hls.HLSTree.HLSTreeFactory;
import test.hls.HLSTree.HLSTreePackage;
import test.hsv.HSV;
import test.hsv.HSVTree.HSVNode;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HLS.HSV2HLSFactory;
import test.middle.HSV2HLS.HSV2HLSPackage;
import test.middle.HSV2HLS.HSVNode2HLSNode;
import test.middle.RGB;

/**
 * The ColorChanger transformation:
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
public class ColorChanger extends AbstractTransformation
{
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_platform_c_s_resource_s_ICMT2013_s_ColoredTree2Tree_ecore = IdManager.getNsURIPackageId("platform:/resource/ICMT2013/ColoredTree2Tree.ecore", HSV2HLSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_platform_c_s_resource_s_ICMT2013_s_HLSTree_ecore = IdManager.getNsURIPackageId("platform:/resource/ICMT2013/HLSTree.ecore", HLSTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_platform_c_s_resource_s_ICMT2013_s_HSVTree_ecore = IdManager.getNsURIPackageId("platform:/resource/ICMT2013/HSVTree.ecore", HSVTreePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HLSNode = PACKid_platform_c_s_resource_s_ICMT2013_s_HLSTree_ecore.getClassId("HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode = PACKid_platform_c_s_resource_s_ICMT2013_s_HSVTree_ecore.getClassId("HSVNode", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_HSVNode2HLSNode = PACKid_platform_c_s_resource_s_ICMT2013_s_ColoredTree2Tree_ecore.getClassId("HSVNode2HLSNode", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_HLS = PACKid_platform_c_s_resource_s_ICMT2013_s_HLSTree_ecore.getDataTypeId("HLS", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_HSV = PACKid_platform_c_s_resource_s_ICMT2013_s_HSVTree_ecore.getDataTypeId("HSV", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_RGB = PACKid_platform_c_s_resource_s_ICMT2013_s_ColoredTree2Tree_ecore.getDataTypeId("RGB", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_HSVNode = TypeId.SET.getSpecializedId(CLSSid_HSVNode);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_HSVNode2HLSNode = TypeId.SET.getSpecializedId(CLSSid_HSVNode2HLSNode);
    
    public ColorChanger(final @NonNull DomainEvaluator evaluator) {
        super(evaluator, new String[] {"hsv", "hls", ""});
    }
    
    public boolean run() {
        List<? extends HSVNode> LIST_hsvRoot = getObjectsByType(HSVNode.class, 0/*hsv*/, HSVTreePackage.Literals.HSV_NODE);
        for (HSVNode hsvRoot : LIST_hsvRoot) {
            HSV2MiddleRoot(hsvRoot);
        }
        return true;
    }
    
    protected @NonNull RGB hls2rgb(final @Nullable /*@NonInvalid*/ HLS color) {
        return null;
    }
    
    protected @NonNull RGB hsv2rgb(final @Nullable /*@NonInvalid*/ HSV color_0) {
        return null;
    }
    
    protected @NonNull HLS rgb2hls(final @Nullable /*@NonInvalid*/ RGB color_1) {
        return null;
    }
    
    protected @NonNull HSV rgb2hsv(final @Nullable /*@NonInvalid*/ RGB color_2) {
        return null;
    }
    
    /**
     * 
     * map HSV2MiddleRoot in ColorChanger) {
     * hsv (hsvRoot : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSVTree.ecore#/'::HSVNode;
     *  |
     * hsvRoot.parent =
     *   null)
     * { |
     * }
     * where ( |
     * )
     * {realize middleRoot : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * middleRoot = hsvRoot;
     * middleRoot = hsvRoot.name;
     * middleRoot = hsv2rgb(hsvRoot.hsv)
     *   ;
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
        // guards
        @NonNull /*@Caught*/ Object CAUGHT_eq;
        try {
            final @Nullable /*@Thrown*/ HSVNode parent = hsvRoot.getParent();
            final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(parent, null);
            CAUGHT_eq = eq;
        }
        catch (Exception e) {
            CAUGHT_eq = ValuesUtil.createInvalidValue(e);
        }
        if (CAUGHT_eq != ValuesUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final @Nullable /*@Thrown*/ HSVNode2HLSNode middleRoot = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
        modelObjects[2/*null*/].add(middleRoot);
        // assignments
        middleRoot.setHsv(hsvRoot);
        final @Nullable /*@Thrown*/ String name = hsvRoot.getName();
        middleRoot.setName(name);
        final @NonNull /*@Thrown*/ HSV hsv = hsvRoot.getHsv();
        final @NonNull /*@Thrown*/ RGB hsv2rgb = hsv2rgb(hsv);
        middleRoot.setRgb(hsv2rgb);
        // mapping calls
        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<HSVNode> children = hsvRoot.getChildren();
        for (HSVNode hsvNode_0 : children) {
            HSV2MiddleRecursion(hsvNode_0, middleRoot);
        }
        Middle2HLSRoot(middleRoot);
        return true;
    }
    
    /**
     * 
     * map HSV2MiddleRecursion in ColorChanger) {
     * 
     *   hsv (hsvNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSVTree.ecore#/'::HSVNode;
     *  |
     * )
     * { |
     * }
     * where (middleParent : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * {realize middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * middleNode = middleParent;
     * middleNode = hsvNode;
     * middleNode = hsvNode.name;
     * middleNode = hsv2rgb(hsvNode.hsv)
     *   ;
     * }
     * map HSV2MiddleRecursion {
     * hsvNode <= hsvNode.children;
     * middleParent := middleNode;
     * }
     * }
     */
    protected boolean HSV2MiddleRecursion(final @NonNull /*@NonInvalid*/ HSVNode hsvNode, final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleParent) {
        // guards
        // creations
        final @Nullable /*@Thrown*/ HSVNode2HLSNode middleNode = HSV2HLSFactory.eINSTANCE.createHSVNode2HLSNode();
        modelObjects[2/*null*/].add(middleNode);
        // assignments
        middleNode.setParent(middleParent);
        middleNode.setHsv(hsvNode);
        final @Nullable /*@Thrown*/ String name_0 = hsvNode.getName();
        middleNode.setName(name_0);
        final @NonNull /*@Thrown*/ HSV hsv_0 = hsvNode.getHsv();
        final @NonNull /*@Thrown*/ RGB hsv2rgb_0 = hsv2rgb(hsv_0);
        middleNode.setRgb(hsv2rgb_0);
        // mapping calls
        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<HSVNode> children_0 = hsvNode.getChildren();
        for (HSVNode hsvNode_1 : children_0) {
            HSV2MiddleRecursion(hsvNode_1, middleNode);
        }
        return true;
    }
    
    /**
     * 
     * map Middle2HLSRoot in ColorChanger) {
     * 
     *   hls ( |
     * )
     * {realize hlsNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HLSTree.ecore#/'::HLSNode;
     *  |
     * }
     * where (middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * middleNode = hlsNode;
     * hlsNode = null;
     * hlsNode = middleNode.name;
     * hlsNode = rgb2hls(middleNode.rgb)
     *   ;
     * }
     * map Middle2HLSRecursion {
     * middleNode <= middleNode.children;
     * }
     * }
     */
    protected boolean Middle2HLSRoot(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode) {
        // guards
        // creations
        final @Nullable /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
        modelObjects[1/*hls*/].add(hlsNode);
        // assignments
        middleNode.setHls(hlsNode);
        hlsNode.setParent(null);
        final @Nullable /*@Thrown*/ String name_1 = middleNode.getName();
        hlsNode.setName(name_1);
        final @NonNull /*@Thrown*/ RGB rgb = middleNode.getRgb();
        final @NonNull /*@Thrown*/ HLS rgb2hls = rgb2hls(rgb);
        hlsNode.setHls(rgb2hls);
        // mapping calls
        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<HSVNode2HLSNode> children_1 = middleNode.getChildren();
        for (HSVNode2HLSNode middleNode_2 : children_1) {
            Middle2HLSRecursion(middleNode_2);
        }
        return true;
    }
    
    /**
     * 
     * map Middle2HLSRecursion in ColorChanger) {
     * 
     *   hls ( |
     * )
     * {realize hlsNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HLSTree.ecore#/'::HLSNode;
     *  |
     * }
     * where (middleNode : _'file:/C:/GIT/org.eclipse.qvtd/tests/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests/models/HSV2HLS.ecore#/'::HSVNode2HLSNode;
     *  |
     * )
     * { |
     * middleNode = hlsNode;
     * hlsNode = middleNode.parent.hls;
     * hlsNode = middleNode.name;
     * hlsNode = rgb2hls(middleNode.rgb)
     *   ;
     * }
     * map Middle2HLSRecursion {
     * middleNode <= middleNode.children;
     * }
     * }
     */
    protected boolean Middle2HLSRecursion(final @NonNull /*@NonInvalid*/ HSVNode2HLSNode middleNode_0) {
        // guards
        // creations
        final @Nullable /*@Thrown*/ HLSNode hlsNode = HLSTreeFactory.eINSTANCE.createHLSNode();
        modelObjects[1/*hls*/].add(hlsNode);
        // assignments
        middleNode_0.setHls(hlsNode);
        final @Nullable /*@Thrown*/ HSVNode2HLSNode parent_0 = middleNode_0.getParent();
        if (parent_0 == null) {
            throw new InvalidValueException("Null source");
        }
        final @NonNull /*@Thrown*/ HLSNode hls = parent_0.getHls();
        hlsNode.setParent(hls);
        final @Nullable /*@Thrown*/ String name_2 = middleNode_0.getName();
        hlsNode.setName(name_2);
        final @NonNull /*@Thrown*/ RGB rgb_0 = middleNode_0.getRgb();
        final @NonNull /*@Thrown*/ HLS rgb2hls_0 = rgb2hls(rgb_0);
        hlsNode.setHls(rgb2hls_0);
        // mapping calls
        final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<HSVNode2HLSNode> children_2 = middleNode_0.getChildren();
        for (HSVNode2HLSNode middleNode_3 : children_2) {
            Middle2HLSRecursion(middleNode_3);
        }
        return true;
    }
}
