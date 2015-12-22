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
import example4.kiamacs.NodeCS;
import example4.kiamacs.TopCS;
import java.lang.reflect.Constructor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractInvocation;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
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
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example4/simplerkiamaas/1.0", null, KiamaasPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example4/simplerkiamacs/1.0", null, KiamacsPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Composite = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Composite", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_CompositeCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("CompositeCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Leaf = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Leaf", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LeafCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("LeafCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Node = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Node", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NodeCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("NodeCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Top = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamaas_s_1_0.getClassId("Top", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TopCS = PACKid_http_c_s_s_cs2as_s_tests_s_example4_s_simplerkiamacs_s_1_0.getClassId("TopCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ DataTypeId DATAid_EIntegerObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_CompositeCS = TypeId.SET.getSpecializedId(CLSSid_CompositeCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_LeafCS = TypeId.SET.getSpecializedId(CLSSid_LeafCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_NodeCS = TypeId.SET.getSpecializedId(CLSSid_NodeCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TopCS = TypeId.SET.getSpecializedId(CLSSid_TopCS);
    
    
    protected final /*@NonNull*/ Constructor<MAP_uComposite_depth> CTOR_uComposite_depth;
    protected final /*@NonNull*/ Constructor<MAP_uComposite_height> CTOR_uComposite_height;
    
    public SimplerKiama_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, null, null);
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
     * _'-child-CompositeCS-' : Set(kiamacs::CompositeCS[*|1]) = roots->selectByKind(kiamacs::CompositeCS)
     *   ;
     * _'-join-CompositeCS-0' : Set(kiamacs::CompositeCS[*|1]) = _'-child-CompositeCS-';
     * _'-join-CompositeCS-1' : Set(kiamacs::CompositeCS[*|1]) = _'-child-CompositeCS-';
     * _'-child-LeafCS-' : Set(kiamacs::LeafCS[*|1]) = roots->selectByKind(kiamacs::LeafCS)
     *   ;
     * _'-join-LeafCS-0' : Set(kiamacs::LeafCS[*|1]) = _'-child-LeafCS-';
     * _'-child-TopCS-' : Set(kiamacs::TopCS[*|1]) = roots->selectByKind(kiamacs::TopCS)
     *   ;
     * _'-join-TopCS-0' : Set(kiamacs::TopCS[*|1]) = _'-child-TopCS-';
     *  |}
     * for loop0 : kiamacs::TopCS in _'-join-TopCS-0' {
     * 
     *     map _'kiamacs%TopCS%node' {
     * _'-join-CompositeCS-0' := _'-join-CompositeCS-0';
     * _'-join-CompositeCS-1' := _'-join-CompositeCS-1';
     * _'-join-LeafCS-0' := _'-join-LeafCS-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'-join-CompositeCS-1' {
     * 
     *     map _'kiamacs%CompositeCS%child' {
     * _'-join-CompositeCS-0' := _'-join-CompositeCS-0';
     * _'-join-LeafCS-0' := _'-join-LeafCS-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'-join-CompositeCS-0' {
     * 
     *     map cCompositeCS_2_Composite {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::LeafCS in _'-join-LeafCS-0' {
     * 
     *     map _'cLeafCS_2_Leaf\\nuLeaf_height' {
     * leafCS := loop0;
     * }}
     *   for loop0 : kiamacs::TopCS in _'-join-TopCS-0' {
     * 
     *     map cTopCS_2_Top {
     * topCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'-join-CompositeCS-0' {
     * 
     *     map uComposite_child {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'-join-CompositeCS-0' {
     * 
     *     map uComposite_depth {
     * compositeCS := loop0;
     * }}
     *   for loop0 : kiamacs::LeafCS in _'-join-LeafCS-0' {
     * 
     *     map uLeaf_depth {
     * leafCS := loop0;
     * }}
     *   for loop0 : kiamacs::TopCS in _'-join-TopCS-0' {
     * 
     *     map uTop_node {
     * topCS := loop0;
     * }}
     *   for loop0 : kiamacs::CompositeCS in _'-join-CompositeCS-0' {
     * 
     *     map uComposite_height {
     * compositeCS := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_TopCS_0 = idResolver.getClass(CLSSid_TopCS, null);
        // variable assignments
        final /*@NonNull*/ /*@NonInvalid*/ SetValue rootObjects = RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*leftCS*/]);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_CompositeCS_0);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind_0 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_LeafCS_0);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind_1 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_kiamacs_c_c_TopCS_0);
        // connection variables
        final /*@NonNull*/ SetValue.Accumulator _m_join_m_CompositeCS_m_0_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_CompositeCS);
        for (CompositeCS iterator : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            _m_join_m_CompositeCS_m_0_3.add(iterator);
        }
        final /*@NonNull*/ SetValue.Accumulator _m_join_m_CompositeCS_m_1_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_CompositeCS);
        for (CompositeCS iterator_0 : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            _m_join_m_CompositeCS_m_1_1.add(iterator_0);
        }
        final /*@NonNull*/ SetValue.Accumulator _m_join_m_LeafCS_m_0_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_LeafCS);
        for (LeafCS iterator_1 : ValueUtil.typedIterable(LeafCS.class, selectByKind_0)) {
            _m_join_m_LeafCS_m_0_3.add(iterator_1);
        }
        // mapping statements
        for (TopCS loop0 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopCS symbol_0 = (TopCS)loop0;
                MAP_kiamacs_37TopCS_37node(_m_join_m_CompositeCS_m_0_3, _m_join_m_CompositeCS_m_1_1, _m_join_m_LeafCS_m_0_3, symbol_0);
            }
        }
        for (CompositeCS loop0_0 : ValueUtil.typedIterable(CompositeCS.class, _m_join_m_CompositeCS_m_1_1)) {
            if (loop0_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_2 = (CompositeCS)loop0_0;
                MAP_kiamacs_37CompositeCS_37child(_m_join_m_CompositeCS_m_0_3, _m_join_m_LeafCS_m_0_3, symbol_2);
            }
        }
        for (CompositeCS loop0_1 : ValueUtil.typedIterable(CompositeCS.class, _m_join_m_CompositeCS_m_0_3)) {
            if (loop0_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_4 = (CompositeCS)loop0_1;
                MAP_cCompositeCS_2_Composite(symbol_4);
            }
        }
        for (LeafCS loop0_2 : ValueUtil.typedIterable(LeafCS.class, _m_join_m_LeafCS_m_0_3)) {
            if (loop0_2 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ LeafCS symbol_6 = (LeafCS)loop0_2;
                MAP_cLeafCS_2_Leaf_92nuLeaf_height(symbol_6);
            }
        }
        for (TopCS loop0_3 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopCS symbol_8 = (TopCS)loop0_3;
                MAP_cTopCS_2_Top(symbol_8);
            }
        }
        for (CompositeCS loop0_4 : ValueUtil.typedIterable(CompositeCS.class, _m_join_m_CompositeCS_m_0_3)) {
            if (loop0_4 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_10 = (CompositeCS)loop0_4;
                MAP_uComposite_child(symbol_10);
            }
        }
        for (CompositeCS loop0_5 : ValueUtil.typedIterable(CompositeCS.class, _m_join_m_CompositeCS_m_0_3)) {
            if (loop0_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_12 = (CompositeCS)loop0_5;
                invoke(CTOR_uComposite_depth, symbol_12);
            }
        }
        for (LeafCS loop0_6 : ValueUtil.typedIterable(LeafCS.class, _m_join_m_LeafCS_m_0_3)) {
            if (loop0_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ LeafCS symbol_14 = (LeafCS)loop0_6;
                MAP_uLeaf_depth(symbol_14);
            }
        }
        for (TopCS loop0_7 : ValueUtil.typedIterable(TopCS.class, selectByKind_1)) {
            if (loop0_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopCS symbol_16 = (TopCS)loop0_7;
                MAP_uTop_node(symbol_16);
            }
        }
        for (CompositeCS loop0_8 : ValueUtil.typedIterable(CompositeCS.class, _m_join_m_CompositeCS_m_0_3)) {
            if (loop0_8 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_18 = (CompositeCS)loop0_8;
                invoke(CTOR_uComposite_height, symbol_18);
            }
        }
        return true;
    }
    
    /**
     * 
     * map cCompositeCS_2_Composite in SimplerKiama_qvtp_qvtias {
     * leftCS (compositeCS : kiamacs::CompositeCS[1];
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
    protected boolean MAP_cCompositeCS_2_Composite(final /*@NonNull*/ /*@NonInvalid*/ CompositeCS compositeCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Composite composite = KiamaasFactory.eINSTANCE.createComposite();
        assert composite != null;
        models[1/*rightAS*/].add(composite);
        // property assignments
        compositeCS.setAst(composite);
        return true;
    }
    
    /**
     * 
     * map _'cLeafCS_2_Leaf\\nuLeaf_height' in SimplerKiama_qvtp_qvtias {
     * leftCS (leafCS : kiamacs::LeafCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize leaf : kiamaas::Leaf[1];
     *  |}
     * where ( |)
     * { |
     * leafCS.ast := leaf;
     * leaf.height := 0;
     * }
     * 
     */
    protected boolean MAP_cLeafCS_2_Leaf_92nuLeaf_height(final /*@NonNull*/ /*@NonInvalid*/ LeafCS leafCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Leaf leaf = KiamaasFactory.eINSTANCE.createLeaf();
        assert leaf != null;
        models[1/*rightAS*/].add(leaf);
        // property assignments
        leafCS.setAst(leaf);
        final Integer ECORE_INT_0 = ValueUtil.intValueOf(INT_0);
        leaf.setHeight(ECORE_INT_0);
        objectManager.assigned(leaf, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_INT_0);
        return true;
    }
    
    /**
     * 
     * map cTopCS_2_Top in SimplerKiama_qvtp_qvtias {
     * leftCS (topCS : kiamacs::TopCS[1];
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
    protected boolean MAP_cTopCS_2_Top(final /*@NonNull*/ /*@NonInvalid*/ TopCS topCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Top top = KiamaasFactory.eINSTANCE.createTop();
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
     *   leftCS (_'-parent-' : kiamacs::CompositeCS[1];
     *  |)
     * { |}
     * where (_'-join-LeafCS-0' : Set(kiamacs::LeafCS[*|1]);
     * _'-join-CompositeCS-0' : Set(kiamacs::CompositeCS[*|1]);
     *  |)
     * {allChildren : Set(kiamacs::NodeCS[*|1]) = _'-parent-'.child.oclAsSet()
     *   ;
     * _'-child-LeafCS-' : Set(kiamacs::LeafCS[*|1]) = allChildren->selectByKind(kiamacs::LeafCS)
     *   ;
     * _'-child-CompositeCS-' : Set(kiamacs::CompositeCS[*|1]) = allChildren->selectByKind(kiamacs::CompositeCS)
     *   ;
     *  |
     * _'-join-LeafCS-0' += _'-child-LeafCS-';
     * _'-join-CompositeCS-0' += _'-child-CompositeCS-';
     * }
     * for aChild : kiamacs::CompositeCS in _'-child-CompositeCS-' {
     * 
     *     map _'kiamacs%CompositeCS%child' {
     * _'-join-CompositeCS-0' := _'-join-CompositeCS-0';
     * _'-join-LeafCS-0' := _'-join-LeafCS-0';
     * _'-parent-' := aChild;
     * }}
     */
    protected boolean MAP_kiamacs_37CompositeCS_37child(final /*@NonNull*/ SetValue.Accumulator _m_join_m_CompositeCS_m_0, final /*@NonNull*/ SetValue.Accumulator _m_join_m_LeafCS_m_0, final /*@NonNull*/ /*@NonInvalid*/ CompositeCS _m_parent_m) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ NodeCS child = _m_parent_m.getChild();
        final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_NodeCS, child);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_LeafCS_0);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind_0 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_CompositeCS_0);
        // connection assignments
        for (LeafCS iterator : ValueUtil.typedIterable(LeafCS.class, selectByKind)) {
            if (iterator instanceof LeafCS) {
                _m_join_m_LeafCS_m_0.add(iterator);
            }
        }
        for (CompositeCS iterator_0 : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (iterator_0 instanceof CompositeCS) {
                _m_join_m_CompositeCS_m_0.add(iterator_0);
            }
        }
        // mapping statements
        for (CompositeCS aChild : ValueUtil.typedIterable(CompositeCS.class, selectByKind_0)) {
            if (aChild != null) {
                final /*@NonNull*/ /*@NonInvalid*/ CompositeCS symbol_0 = (CompositeCS)aChild;
                MAP_kiamacs_37CompositeCS_37child(_m_join_m_CompositeCS_m_0, _m_join_m_LeafCS_m_0, symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'kiamacs%TopCS%node' in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (_'-parent-' : kiamacs::TopCS[1];
     *  |)
     * { |}
     * where (_'-join-CompositeCS-1' : Set(kiamacs::CompositeCS[*|1]);
     * _'-join-LeafCS-0' : Set(kiamacs::LeafCS[*|1]);
     * _'-join-CompositeCS-0' : Set(kiamacs::CompositeCS[*|1]);
     *  |)
     * {allChildren : Set(kiamacs::NodeCS[*|1]) = _'-parent-'.node.oclAsSet()
     *   ;
     * _'-child-CompositeCS-' : Set(kiamacs::CompositeCS[*|1]) = allChildren->selectByKind(kiamacs::CompositeCS)
     *   ;
     * _'-child-LeafCS-' : Set(kiamacs::LeafCS[*|1]) = allChildren->selectByKind(kiamacs::LeafCS);
     *  |
     * _'-join-CompositeCS-1' += _'-child-CompositeCS-';
     * _'-join-LeafCS-0' += _'-child-LeafCS-';
     * _'-join-CompositeCS-0' += _'-child-CompositeCS-';
     * }
     * 
     */
    protected boolean MAP_kiamacs_37TopCS_37node(final /*@NonNull*/ SetValue.Accumulator _m_join_m_CompositeCS_m_0_0, final /*@NonNull*/ SetValue.Accumulator _m_join_m_CompositeCS_m_1, final /*@NonNull*/ SetValue.Accumulator _m_join_m_LeafCS_m_0_0, final /*@NonNull*/ /*@NonInvalid*/ TopCS _m_parent_m_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_CompositeCS_0 = idResolver.getClass(CLSSid_CompositeCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_LeafCS_0 = idResolver.getClass(CLSSid_LeafCS, null);
        // variable assignments
        final /*@NonNull*/ /*@Thrown*/ NodeCS node = _m_parent_m_0.getNode();
        final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_NodeCS, node);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_CompositeCS_0);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue selectByKind_0 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_kiamacs_c_c_LeafCS_0);
        // connection assignments
        for (CompositeCS iterator : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            if (iterator instanceof CompositeCS) {
                _m_join_m_CompositeCS_m_1.add(iterator);
            }
        }
        for (LeafCS iterator_0 : ValueUtil.typedIterable(LeafCS.class, selectByKind_0)) {
            if (iterator_0 instanceof LeafCS) {
                _m_join_m_LeafCS_m_0_0.add(iterator_0);
            }
        }
        for (CompositeCS iterator_1 : ValueUtil.typedIterable(CompositeCS.class, selectByKind)) {
            if (iterator_1 instanceof CompositeCS) {
                _m_join_m_CompositeCS_m_0_0.add(iterator_1);
            }
        }
        return true;
    }
    
    /**
     * 
     * map uComposite_child in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : kiamaas::Composite[1] = compositeCS.ast.oclAsType(kiamaas::Composite)
     *   ;
     * child : kiamacs::NodeCS[1] = compositeCS.child;
     * ast1 : kiamaas::Node[1] = child.ast.oclAsType(kiamaas::Node);
     *  |
     * ast.child := ast1;
     * }
     * 
     */
    protected boolean MAP_uComposite_child(final /*@NonNull*/ /*@NonInvalid*/ CompositeCS compositeCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = compositeCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
        final /*@Nullable*/ /*@Thrown*/ NodeCS child = compositeCS_0.getChild();
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = child.getAst();
        final /*@NonNull*/ /*@Thrown*/ Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setChild(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uComposite_depth in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : kiamaas::Composite[1] = compositeCS.ast.oclAsType(kiamaas::Composite)
     *   ;
     * oclContainer : OclElement[1] = ast.oclContainer;
     * _'oclIsKindOf\\\\nkiamaas::Top' : Boolean[1] = oclContainer.oclIsKindOf(kiamaas::Top)
     *   ;
     * _'if' : Integer[1] = if _'oclIsKindOf\\\\nkiamaas::Top'
     *   then 0
     *   else oclContainer.oclAsType(kiamaas::Composite).depth + 1
     *   endif;
     *  |
     * ast.depth := _'if';
     * }
     * 
     */
    protected class MAP_uComposite_depth extends AbstractInvocation
    {
        protected final /*@NonNull*/ /*@NonInvalid*/ CompositeCS compositeCS_1;
        
        @SuppressWarnings("null")
        public MAP_uComposite_depth(/*@NonNull*/ Object[] boundValues) {
            compositeCS_1 = (CompositeCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
            // variable assignments
            final /*@Nullable*/ /*@Thrown*/ EObject ast = compositeCS_1.getAst();
            final /*@NonNull*/ /*@Thrown*/ Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
            final /*@Nullable*/ /*@Thrown*/ Object oclContainer = oclAsType.eContainer();
            final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Top_0).booleanValue();
            /*@NonNull*/ /*@Thrown*/ IntegerValue symbol_0;
            if (oclIsKindOf) {
                symbol_0 = INT_0;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ Composite oclAsType_0 = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Composite_0));
                objectManager.getting(oclAsType_0, KiamaasPackage.Literals.NODE__DEPTH);
                final /*@Nullable*/ /*@Thrown*/ Integer depth = oclAsType_0.getDepth();
                final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1);
                symbol_0 = sum;
            }
            // property assignments
            final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
            oclAsType.setDepth(ECORE_symbol_0);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__DEPTH, ECORE_symbol_0);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(compositeCS_1, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uComposite_height in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (compositeCS : kiamacs::CompositeCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : kiamaas::Composite[1] = compositeCS.ast.oclAsType(kiamaas::Composite);
     * child : kiamaas::Node[1] = ast.child;
     * height : ecore::EIntegerObject[1] = child.height;
     * _'+' : Integer[1] = height + 1;
     *  |
     * ast.height := _'+';
     * }
     * 
     */
    protected class MAP_uComposite_height extends AbstractInvocation
    {
        protected final /*@NonNull*/ /*@NonInvalid*/ CompositeCS compositeCS_2;
        
        @SuppressWarnings("null")
        public MAP_uComposite_height(/*@NonNull*/ Object[] boundValues) {
            compositeCS_2 = (CompositeCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            // variable assignments
            final /*@Nullable*/ /*@Thrown*/ EObject ast = compositeCS_2.getAst();
            final /*@NonNull*/ /*@Thrown*/ Composite oclAsType = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Composite_0));
            final /*@Nullable*/ /*@Thrown*/ Node child = oclAsType.getChild();
            objectManager.getting(child, KiamaasPackage.Literals.NODE__HEIGHT);
            final /*@Nullable*/ /*@Thrown*/ Integer height = child.getHeight();
            final /*@NonNull*/ /*@NonInvalid*/ IntegerValue BOXED_height = ValueUtil.integerValueOf(height);
            final /*@NonNull*/ /*@NonInvalid*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_height, INT_1);
            // property assignments
            final Integer ECORE_sum = ValueUtil.intValueOf(sum);
            oclAsType.setHeight(ECORE_sum);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_sum);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(compositeCS_2, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uLeaf_depth in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (leafCS : kiamacs::LeafCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : kiamaas::Leaf[1] = leafCS.ast.oclAsType(kiamaas::Leaf)
     *   ;
     * oclContainer : OclElement[1] = ast.oclContainer;
     * _'oclIsKindOf\\\\nkiamaas::Top' : Boolean[1] = oclContainer.oclIsKindOf(kiamaas::Top)
     *   ;
     * _'if' : Integer[1] = if _'oclIsKindOf\\\\nkiamaas::Top'
     *   then 0
     *   else oclContainer.oclAsType(kiamaas::Composite).depth + 1
     *   endif;
     *  |
     * ast.depth := _'if';
     * }
     * 
     */
    protected boolean MAP_uLeaf_depth(final /*@NonNull*/ /*@NonInvalid*/ LeafCS leafCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Leaf_0 = idResolver.getClass(CLSSid_Leaf, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = leafCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ Leaf oclAsType = ClassUtil.nonNullState((Leaf)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Leaf_0));
        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = oclAsType.eContainer();
        final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Top_0).booleanValue();
        /*@NonNull*/ /*@Thrown*/ IntegerValue symbol_0;
        if (oclIsKindOf) {
            symbol_0 = INT_0;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Composite_0 = idResolver.getClass(CLSSid_Composite, null);
            final /*@NonNull*/ /*@Thrown*/ Composite oclAsType_0 = ClassUtil.nonNullState((Composite)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_kiamaas_c_c_Composite_0));
            final /*@Nullable*/ /*@Thrown*/ Integer depth = oclAsType_0.getDepth();
            final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
            final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1);
            symbol_0 = sum;
        }
        // property assignments
        final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
        oclAsType.setDepth(ECORE_symbol_0);
        return true;
    }
    
    /**
     * 
     * map uTop_node in SimplerKiama_qvtp_qvtias {
     * 
     *   leftCS (topCS : kiamacs::TopCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : kiamaas::Top[1] = topCS.ast.oclAsType(kiamaas::Top)
     *   ;
     * node : kiamacs::NodeCS[1] = topCS.node;
     * ast1 : kiamaas::Node[1] = node.ast.oclAsType(kiamaas::Node);
     *  |
     * ast.node := ast1;
     * }
     * 
     */
    protected boolean MAP_uTop_node(final /*@NonNull*/ /*@NonInvalid*/ TopCS topCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = topCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ Top oclAsType = ClassUtil.nonNullState((Top)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Top_0));
        final /*@NonNull*/ /*@Thrown*/ NodeCS node = topCS_0.getNode();
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = node.getAst();
        final /*@NonNull*/ /*@Thrown*/ Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setNode(oclAsType_0);
        return true;
    }
}
