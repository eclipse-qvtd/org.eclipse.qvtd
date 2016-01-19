/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._SimplerKiama_qvtp_qvtias;

import example4.kiamaas.Composite;
import example4.kiamaas.KiamaasFactory;
import example4.kiamaas.KiamaasPackage;
import example4.kiamaas.Leaf;
import example4.kiamaas.Node;
import example4.kiamaas.Top;
import example4.kiamacs.CompositeCS;
import example4.kiamacs.KiamacsPackage;
import example4.kiamacs.LeafCS;
import example4.kiamacs.TopCS;
import java.lang.reflect.Constructor;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractInvocation;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation;

/**
 * The SimplerKiama_qvtp_qvtias transformation:
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
public class SimplerKiama_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example4/simplerkiamaas/1.0", null, KiamaasPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example4/simplerkiamacs/1.0", null, KiamacsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Composite = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Composite", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CompositeCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("CompositeCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Leaf = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Leaf", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LeafCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("LeafCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Node", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NodeCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("NodeCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Top = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Top", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TopCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("TopCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EIntegerObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_CompositeCS = TypeId.SET.getSpecializedId(CLSSid_CompositeCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_LeafCS = TypeId.SET.getSpecializedId(CLSSid_LeafCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NodeCS = TypeId.SET.getSpecializedId(CLSSid_NodeCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_TopCS = TypeId.SET.getSpecializedId(CLSSid_TopCS);
    
    
    protected final /*@NonNull*/ Constructor<MAP_uComposite_depth> CTOR_uComposite_depth;
    protected final /*@NonNull*/ Constructor<MAP_uComposite_height> CTOR_uComposite_height;
    
    public SimplerKiama_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new /*@NonNull*/ String[] {"leftCS", "rightAS"}, null, null, null);
        CTOR_uComposite_depth = ClassUtil.nonNullState(MAP_uComposite_depth.class.getConstructor(SimplerKiama_qvtp_qvtias.class, Object[].class));
        CTOR_uComposite_height = ClassUtil.nonNullState(MAP_uComposite_height.class.getConstructor(SimplerKiama_qvtp_qvtias.class, Object[].class));
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * 
     * map __root__ in SimplerKiama_qvtp_qvtias {
     * 
     *   where ( |)
     * {roots : Set(OclElement) = leftCS.rootObjects()
     *   ;
     * _'\u00ABchild-CompositeCS\u00BB' : Set(kiamacs::CompositeCS[*|1]) = roots->selectByKind(kiamacs::CompositeCS)
     *   ;
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' : Set(kiamacs::CompositeCS[*|1]) = _'\u00ABchild-CompositeCS\u00BB';
     * _'\\u00ABjoin-CompositeCS-1\\u00BB' : Set(kiamacs::CompositeCS[*|1]) = _'\u00ABchild-CompositeCS\u00BB';
     * _'\u00ABchild-LeafCS\u00BB' : Set(kiamacs::LeafCS[*|1]) = roots->selectByKind(kiamacs::LeafCS)
     *   ;
     * _'\\u00ABjoin-LeafCS-0\\u00BB' : Set(kiamacs::LeafCS[*|1]) = _'\u00ABchild-LeafCS\u00BB';
     * _'\u00ABchild-TopCS\u00BB' : Set(kiamacs::TopCS[*|1]) = roots->selectByKind(kiamacs::TopCS)
     *   ;
     * _'\\u00ABjoin-TopCS-0\\u00BB' : Set(kiamacs::TopCS[*|1]) = _'\u00ABchild-TopCS\u00BB';
     *  |}
     * for loop0 : kiamacs::TopCS in _'\\u00ABjoin-TopCS-0\\u00BB' {
     * 
     *     map _'kiamacs%TopCS%node' {
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' := _'\\u00ABjoin-CompositeCS-0\\u00BB';
     * _'\\u00ABjoin-CompositeCS-1\\u00BB' := _'\\u00ABjoin-CompositeCS-1\\u00BB';
     * _'\\u00ABjoin-LeafCS-0\\u00BB' := _'\\u00ABjoin-LeafCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'\\u00ABjoin-CompositeCS-1\\u00BB' {
     * 
     *     map _'kiamacs%CompositeCS%child' {
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' := _'\\u00ABjoin-CompositeCS-0\\u00BB';
     * _'\\u00ABjoin-LeafCS-0\\u00BB' := _'\\u00ABjoin-LeafCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'\\u00ABjoin-CompositeCS-0\\u00BB' {
     * 
     *     map cCompositeCS_2_Composite {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::LeafCS in _'\\u00ABjoin-LeafCS-0\\u00BB' {
     * 
     *     map cLeafCS_2_Leaf {
     * leafCS := loop0;
     * }}
     *   for loop0 : kiamacs::TopCS in _'\\u00ABjoin-TopCS-0\\u00BB' {
     * 
     *     map cTopCS_2_Top {
     * topCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'\\u00ABjoin-CompositeCS-0\\u00BB' {
     * 
     *     map uComposite_child {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'\\u00ABjoin-CompositeCS-0\\u00BB' {
     * 
     *     map uComposite_depth {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::LeafCS in _'\\u00ABjoin-LeafCS-0\\u00BB' {
     * 
     *     map uLeaf_depth {
     * leafCS := loop0;
     * }}
     *   for loop0 : kiamacs::LeafCS in _'\\u00ABjoin-LeafCS-0\\u00BB' {
     * 
     *     map uLeaf_height {
     * leafCS := loop0;
     * }}
     *   for loop0 : kiamacs::TopCS in _'\\u00ABjoin-TopCS-0\\u00BB' {
     * 
     *     map uTop_node {
     * topCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'\\u00ABjoin-CompositeCS-0\\u00BB' {
     * 
     *     map uComposite_height {
     * compositeCS := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_TopCS_0 = idResolver.getClass(CLSSid_TopCS, null);
        // variable assignments
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue rootObjects = ClassUtil.nonNullState(RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*leftCS*/]));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_CompositeCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_LeafCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_1 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_TopCS_0));
        // connection variables
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_CompositeCS);
        for (CompositeCS iterator : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3.add(iterator);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_CompositeCS);
        for (CompositeCS iterator_0 : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB_1.add(iterator_0);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_LeafCS);
        for (LeafCS iterator_1 : ValueUtil.typedIterable(LeafCS.class, selectByKind_0)) {
            _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3.add(iterator_1);
        }
        // mapping statements
        for (TopCS loop0 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS symbol_0 = (TopCS)loop0;
                MAP_kiamacs_37TopCS_37node(_92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3, _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB_1, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3, symbol_0);
            }
        }
        for (CompositeCS loop0_0 : ValueUtil.typedIterable(CompositeCS.class, _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB_1)) {
            if (loop0_0 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_2 = (CompositeCS)loop0_0;
                MAP_kiamacs_37CompositeCS_37child(_92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3, symbol_2);
            }
        }
        for (CompositeCS loop0_1 : ValueUtil.typedIterable(CompositeCS.class, _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3)) {
            if (loop0_1 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_4 = (CompositeCS)loop0_1;
                if (symbol_4 != null) {
                    MAP_cCompositeCS_2_Composite(symbol_4);
                }
            }
        }
        for (LeafCS loop0_2 : ValueUtil.typedIterable(LeafCS.class, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3)) {
            if (loop0_2 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS symbol_6 = (LeafCS)loop0_2;
                if (symbol_6 != null) {
                    MAP_cLeafCS_2_Leaf(symbol_6);
                }
            }
        }
        for (TopCS loop0_3 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0_3 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS symbol_8 = (TopCS)loop0_3;
                if (symbol_8 != null) {
                    MAP_cTopCS_2_Top(symbol_8);
                }
            }
        }
        for (CompositeCS loop0_4 : ValueUtil.typedIterable(CompositeCS.class, _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3)) {
            if (loop0_4 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_10 = (CompositeCS)loop0_4;
                if (symbol_10 != null) {
                    MAP_uComposite_child(symbol_10);
                }
            }
        }
        for (CompositeCS loop0_5 : ValueUtil.typedIterable(CompositeCS.class, _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3)) {
            if (loop0_5 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_12 = (CompositeCS)loop0_5;
                if (symbol_12 != null) {
                    invoke(CTOR_uComposite_depth, symbol_12);
                }
            }
        }
        for (LeafCS loop0_6 : ValueUtil.typedIterable(LeafCS.class, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3)) {
            if (loop0_6 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS symbol_14 = (LeafCS)loop0_6;
                if (symbol_14 != null) {
                    MAP_uLeaf_depth(symbol_14);
                }
            }
        }
        for (LeafCS loop0_7 : ValueUtil.typedIterable(LeafCS.class, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_3)) {
            if (loop0_7 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS symbol_16 = (LeafCS)loop0_7;
                if (symbol_16 != null) {
                    MAP_uLeaf_height(symbol_16);
                }
            }
        }
        for (TopCS loop0_8 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0_8 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS symbol_18 = (TopCS)loop0_8;
                if (symbol_18 != null) {
                    MAP_uTop_node(symbol_18);
                }
            }
        }
        for (CompositeCS loop0_9 : ValueUtil.typedIterable(CompositeCS.class, _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_3)) {
            if (loop0_9 != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_20 = (CompositeCS)loop0_9;
                if (symbol_20 != null) {
                    invoke(CTOR_uComposite_height, symbol_20);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map cCompositeCS_2_Composite in SimplerKiama_qvtp_qvtias {
     * leftCS (compositeCS : kiamacs::CompositeCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize composite : kiamaas::Composite[1];
     *  |}
     * where ( |)
     * { |
     * compositeCS.ast := composite;
     * }
     * 
     */
    protected boolean MAP_cCompositeCS_2_Composite(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS compositeCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.Nullable Composite composite = KiamaasFactory.eINSTANCE.createComposite();
        assert composite != null;
        models[1/*rightAS*/].add(composite);
        // property assignments
        compositeCS.setAst(composite);
        return true;
    }
    
    /**
     * 
     * map cLeafCS_2_Leaf in SimplerKiama_qvtp_qvtias {
     * leftCS (leafCS : kiamacs::LeafCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize leaf : kiamaas::Leaf[1];
     *  |}
     * where ( |)
     * { |
     * leafCS.ast := leaf;
     * }
     * 
     */
    protected boolean MAP_cLeafCS_2_Leaf(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS leafCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.Nullable Leaf leaf = KiamaasFactory.eINSTANCE.createLeaf();
        assert leaf != null;
        models[1/*rightAS*/].add(leaf);
        // property assignments
        leafCS.setAst(leaf);
        return true;
    }
    
    /**
     * 
     * map cTopCS_2_Top in SimplerKiama_qvtp_qvtias {
     * leftCS (topCS : kiamacs::TopCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize top : kiamaas::Top[1];
     *  |}
     * where ( |)
     * { |
     * topCS.ast := top;
     * }
     * 
     */
    protected boolean MAP_cTopCS_2_Top(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS topCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.Nullable Top top = KiamaasFactory.eINSTANCE.createTop();
        assert top != null;
        models[1/*rightAS*/].add(top);
        // property assignments
        topCS.setAst(top);
        return true;
    }
    
    /**
     * 
     * map _'kiamacs%CompositeCS%child' in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : kiamacs::CompositeCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-LeafCS-0\\u00BB' : Set(kiamacs::LeafCS[*|1]);
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' : Set(kiamacs::CompositeCS[*|1]);
     *  |)
     * {allChildren : Set(kiamacs::NodeCS[*|1]) = _'\\u00ABparent\\u00BB'.child.oclAsSet()
     *   ;
     * _'\u00ABchild-LeafCS\u00BB' : Set(kiamacs::LeafCS[*|1]) = allChildren->selectByKind(kiamacs::LeafCS)
     *   ;
     * _'\u00ABchild-CompositeCS\u00BB' : Set(kiamacs::CompositeCS[*|1]) = allChildren->selectByKind(kiamacs::CompositeCS)
     *   ;
     *  |
     * _'\\u00ABjoin-LeafCS-0\\u00BB' += _'\u00ABchild-LeafCS\u00BB';
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' += _'\u00ABchild-CompositeCS\u00BB';
     * }
     * for aChild : kiamacs::CompositeCS in _'\u00ABchild-CompositeCS\u00BB' {
     * 
     *     map _'kiamacs%CompositeCS%child' {
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' := _'\\u00ABjoin-CompositeCS-0\\u00BB';
     * _'\\u00ABjoin-LeafCS-0\\u00BB' := _'\\u00ABjoin-LeafCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := aChild;
     * }}
     */
    protected boolean MAP_kiamacs_37CompositeCS_37child(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB, final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_LeafCS_m_0_92_u00BB, final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS _92_u00ABparent_92_u00BB) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        // variable assignments
        final /*@Thrown*/ example4.kiamacs.@org.eclipse.jdt.annotation.Nullable NodeCS child = _92_u00ABparent_92_u00BB.getChild();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_NodeCS, child));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_LeafCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_CompositeCS_0));
        // connection assignments
        for (LeafCS iterator : ValueUtil.typedIterable(LeafCS.class, selectByKind)) {
            if (iterator instanceof LeafCS) {
                _92_u00ABjoin_m_LeafCS_m_0_92_u00BB.add(iterator);
            }
        }
        for (CompositeCS iterator_0 : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (iterator_0 instanceof CompositeCS) {
                _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB.add(iterator_0);
            }
        }
        // mapping statements
        for (CompositeCS aChild : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (aChild != null) {
                final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS symbol_0 = (CompositeCS)aChild;
                MAP_kiamacs_37CompositeCS_37child(_92_u00ABjoin_m_CompositeCS_m_0_92_u00BB, _92_u00ABjoin_m_LeafCS_m_0_92_u00BB, symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'kiamacs%TopCS%node' in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : kiamacs::TopCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-LeafCS-0\\u00BB' : Set(kiamacs::LeafCS[*|1]);
     * _'\\u00ABjoin-CompositeCS-1\\u00BB' : Set(kiamacs::CompositeCS[*|1]);
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' : Set(kiamacs::CompositeCS[*|1]);
     *  |)
     * {allChildren : Set(kiamacs::NodeCS[*|1]) = _'\\u00ABparent\\u00BB'.node.oclAsSet()
     *   ;
     * _'\u00ABchild-LeafCS\u00BB' : Set(kiamacs::LeafCS[*|1]) = allChildren->selectByKind(kiamacs::LeafCS)
     *   ;
     * _'\u00ABchild-CompositeCS\u00BB' : Set(kiamacs::CompositeCS[*|1]) = allChildren->selectByKind(kiamacs::CompositeCS);
     *  |
     * _'\\u00ABjoin-LeafCS-0\\u00BB' += _'\u00ABchild-LeafCS\u00BB';
     * _'\\u00ABjoin-CompositeCS-1\\u00BB' += _'\u00ABchild-CompositeCS\u00BB';
     * _'\\u00ABjoin-CompositeCS-0\\u00BB' += _'\u00ABchild-CompositeCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_kiamacs_37TopCS_37node(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_0, final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB, final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_0, final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS _92_u00ABparent_92_u00BB_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        // variable assignments
        final /*@Thrown*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull NodeCS node = _92_u00ABparent_92_u00BB_0.getNode();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_NodeCS, node));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_LeafCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_CompositeCS_0));
        // connection assignments
        for (LeafCS iterator : ValueUtil.typedIterable(LeafCS.class, selectByKind)) {
            if (iterator instanceof LeafCS) {
                _92_u00ABjoin_m_LeafCS_m_0_92_u00BB_0.add(iterator);
            }
        }
        for (CompositeCS iterator_0 : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (iterator_0 instanceof CompositeCS) {
                _92_u00ABjoin_m_CompositeCS_m_1_92_u00BB.add(iterator_0);
            }
        }
        for (CompositeCS iterator_1 : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (iterator_1 instanceof CompositeCS) {
                _92_u00ABjoin_m_CompositeCS_m_0_92_u00BB_0.add(iterator_1);
            }
        }
        return true;
    }
    
    /**
     * 
     * map uComposite_child in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = compositeCS.ast;
     * child : kiamacs::NodeCS[?] = compositeCS.child;
     * aComposite : kiamaas::Composite[1] = ast.oclAsType(kiamaas::Composite)
     *   ;
     * ast1 : ecore::EObject[?] = child.ast;
     * aNode : kiamaas::Node[1] = ast1.oclAsType(kiamaas::Node);
     *  |
     * aComposite.child := aNode;
     * }
     * 
     */
    protected boolean MAP_uComposite_child(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS compositeCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = compositeCS_0.getAst();
        final /*@Thrown*/ example4.kiamacs.@org.eclipse.jdt.annotation.Nullable NodeCS child = compositeCS_0.getChild();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
        if (child == null) {
            throw throwNull(compositeCS_0, "Null source for \'\'http://cs2as/tests/example4/simplerkiamacs/1.0\'::BaseCS::ast\'");
        }
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = child.getAst();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setChild(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uComposite_depth in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = compositeCS.ast;
     * aComposite : kiamaas::Composite[1] = ast.oclAsType(kiamaas::Composite)
     *   ;
     * oclContainer : OclElement[?] = aComposite.oclContainer;
     * _'oclIsKindOf\\\\nkiamaas::Top' : Boolean[1] = oclContainer.oclIsKindOf(kiamaas::Top)
     *   ;
     * _'if' : Integer[1] = if _'oclIsKindOf\\\\nkiamaas::Top'
     *   then 0
     *   else oclContainer.oclAsType(kiamaas::Composite).depth + 1
     *   endif;
     *  |
     * aComposite.depth := _'if';
     * }
     * 
     */
    protected class MAP_uComposite_depth extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS compositeCS_1;
        
        @SuppressWarnings("null")
        public MAP_uComposite_depth(/*@NonNull*/ Object /*@NonNull*/ [] boundValues) {
            compositeCS_1 = (CompositeCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = compositeCS_1.getAst();
            final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = oclAsType.eContainer();
            final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Top_0).booleanValue());
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue symbol_0;
            if (oclIsKindOf) {
                symbol_0 = INT_0;
            }
            else {
                final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Composite oclAsType_0 = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Composite_0));
                objectManager.getting(oclAsType_0, KiamaasPackage.Literals.NODE__DEPTH);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Integer depth = oclAsType_0.getDepth();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.Nullable IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue sum = ClassUtil.nonNullState((IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1));
                symbol_0 = sum;
            }
            // property assignments
            final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
            oclAsType.setDepth(ECORE_symbol_0);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__DEPTH, ECORE_symbol_0);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object /*@NonNull*/ [] thoseValues) {
            return idResolver.oclEquals(compositeCS_1, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uComposite_height in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = compositeCS.ast;
     * aComposite : kiamaas::Composite[1] = ast.oclAsType(kiamaas::Composite);
     * child : kiamaas::Node[?] = aComposite.child;
     * height : ecore::EIntegerObject[?] = child.height;
     * _'+' : Integer[1] = height + 1;
     *  |
     * aComposite.height := _'+';
     * }
     * 
     */
    protected class MAP_uComposite_height extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull CompositeCS compositeCS_2;
        
        @SuppressWarnings("null")
        public MAP_uComposite_height(/*@NonNull*/ Object /*@NonNull*/ [] boundValues) {
            compositeCS_2 = (CompositeCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = compositeCS_2.getAst();
            final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
            final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.Nullable Node child = oclAsType.getChild();
            if (child == null) {
                throw throwNull(compositeCS_2, "Null source for \'\'http://cs2as/tests/example4/simplerkiamaas/1.0\'::Node::height\'");
            }
            objectManager.getting(child, KiamaasPackage.Literals.NODE__HEIGHT);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Integer height = child.getHeight();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.Nullable IntegerValue BOXED_height = height == null ? null : ValueUtil.integerValueOf(height);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue sum = ClassUtil.nonNullState((IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_height, INT_1));
            // property assignments
            final Integer ECORE_sum = ValueUtil.intValueOf(sum);
            oclAsType.setHeight(ECORE_sum);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_sum);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object /*@NonNull*/ [] thoseValues) {
            return idResolver.oclEquals(compositeCS_2, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uLeaf_depth in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (leafCS : kiamacs::LeafCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = leafCS.ast;
     * aLeaf : kiamaas::Leaf[1] = ast.oclAsType(kiamaas::Leaf)
     *   ;
     * oclContainer : OclElement[?] = aLeaf.oclContainer;
     * _'oclIsKindOf\\\\nkiamaas::Top' : Boolean[1] = oclContainer.oclIsKindOf(kiamaas::Top)
     *   ;
     * _'if' : Integer[1] = if _'oclIsKindOf\\\\nkiamaas::Top'
     *   then 0
     *   else oclContainer.oclAsType(kiamaas::Composite).depth + 1
     *   endif;
     *  |
     * aLeaf.depth := _'if';
     * }
     * 
     */
    protected boolean MAP_uLeaf_depth(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS leafCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Leaf_0 = idResolver.getClass(CLSSid_Leaf, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = leafCS_0.getAst();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Leaf oclAsType = ClassUtil.nonNullState((Leaf)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Leaf_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = oclAsType.eContainer();
        final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Top_0).booleanValue());
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue symbol_0;
        if (oclIsKindOf) {
            symbol_0 = INT_0;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Composite oclAsType_0 = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Composite_0));
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Integer depth = oclAsType_0.getDepth();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.Nullable IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue sum = ClassUtil.nonNullState((IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1));
            symbol_0 = sum;
        }
        // property assignments
        final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
        oclAsType.setDepth(ECORE_symbol_0);
        return true;
    }
    
    /**
     * 
     * map uLeaf_height in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (leafCS : kiamacs::LeafCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = leafCS.ast;
     * aLeaf : kiamaas::Leaf[1] = ast.oclAsType(kiamaas::Leaf);
     *  |
     * aLeaf.height := 0;
     * }
     * 
     */
    protected boolean MAP_uLeaf_height(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull LeafCS leafCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Leaf_0 = idResolver.getClass(CLSSid_Leaf, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = leafCS_1.getAst();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Leaf oclAsType = ClassUtil.nonNullState((Leaf)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Leaf_0));
        // property assignments
        final Integer ECORE_INT_0 = ValueUtil.intValueOf(INT_0);
        oclAsType.setHeight(ECORE_INT_0);
        objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_INT_0);
        return true;
    }
    
    /**
     * 
     * map uTop_node in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (topCS : kiamacs::TopCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = topCS.ast;
     * node : kiamacs::NodeCS[1] = topCS.node;
     * aTop : kiamaas::Top[1] = ast.oclAsType(kiamaas::Top)
     *   ;
     * ast1 : ecore::EObject[?] = node.ast;
     * aNode : kiamaas::Node[1] = ast1.oclAsType(kiamaas::Node);
     *  |
     * aTop.node := aNode;
     * }
     * 
     */
    protected boolean MAP_uTop_node(final /*@NonInvalid*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull TopCS topCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = topCS_0.getAst();
        final /*@Thrown*/ example4.kiamacs.@org.eclipse.jdt.annotation.NonNull NodeCS node = topCS_0.getNode();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Top oclAsType = ClassUtil.nonNullState((Top)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Top_0));
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = node.getAst();
        final /*@Thrown*/ example4.kiamaas.@org.eclipse.jdt.annotation.NonNull Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setNode(oclAsType_0);
        return true;
    }
}
