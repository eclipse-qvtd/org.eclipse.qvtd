/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._Source2TargetDerived_qvtp_qvtias;

import example5.sbase.SRoot;
import example5.sbase.SbasePackage;
import example5.sbase.X;
import example5.sbase.Y;
import example5.sbase.Z;
import example5.sderived.SderivedPackage;
import example5.sderived.W;
import example5.sderived.X2;
import example5.sderived.Y2;
import example5.tbase.A;
import example5.tbase.B;
import example5.tbase.C;
import example5.tbase.TRoot;
import example5.tbase.TbaseFactory;
import example5.tbase.TbasePackage;
import example5.tderived.A2;
import example5.tderived.B2;
import example5.tderived.D;
import example5.tderived.TderivedFactory;
import example5.tderived.TderivedPackage;
import java.util.Iterator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;

/**
 * The Source2TargetDerived_qvtp_qvtias transformation:
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
public class Source2TargetDerived_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/sourceBaseMM/1.0", null, SbasePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceDerivedMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/sourceDerivedMM/1.0", null, SderivedPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/targetBaseMM/1.0", null, TbasePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/targetDerivedMM/1.0", null, TderivedPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("A", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0.getClassId("A2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("B", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_B2 = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0.getClassId("B2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("C", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0.getClassId("D", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_SRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("SRoot", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_W = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceDerivedMM_s_1_0.getClassId("W", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_X = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("X", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_X2 = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceDerivedMM_s_1_0.getClassId("X2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Y = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("Y", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Y2 = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceDerivedMM_s_1_0.getClassId("Y2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Z = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("Z", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_W = TypeId.ORDERED_SET.getSpecializedId(CLSSid_W);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_X = TypeId.ORDERED_SET.getSpecializedId(CLSSid_X);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Y = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_A = TypeId.SEQUENCE.getSpecializedId(CLSSid_A);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_B = TypeId.SEQUENCE.getSpecializedId(CLSSid_B);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_D = TypeId.SEQUENCE.getSpecializedId(CLSSid_D);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_SRoot = TypeId.SET.getSpecializedId(CLSSid_SRoot);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_W = TypeId.SET.getSpecializedId(CLSSid_W);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_X = TypeId.SET.getSpecializedId(CLSSid_X);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_X2 = TypeId.SET.getSpecializedId(CLSSid_X2);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Y = TypeId.SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Y2 = TypeId.SET.getSpecializedId(CLSSid_Y2);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Z = TypeId.SET.getSpecializedId(CLSSid_Z);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new /*@NonNull*/ ClassId[]{
        CLSSid_SRoot,                   // 0 => SRoot
        CLSSid_W,                       // 1 => W
        CLSSid_X,                       // 2 => X
        CLSSid_X2,                      // 3 => X2
        CLSSid_Y,                       // 4 => Y
        CLSSid_Y2,                      // 5 => Y2
        CLSSid_Z                        // 6 => Z
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int /*@NonNull*/ [] /*@NonNull*/ [] classIndex2allClassIndexes = new int /*@NonNull*/ [] /*@NonNull*/ [] {
        {0},                    // 0 : SRoot -> {SRoot}
        {1},                    // 1 : W -> {W}
        {2},                    // 2 : X -> {X}
        {3,2},                  // 3 : X2 -> {X2,X}
        {4},                    // 4 : Y -> {Y}
        {5,4},                  // 5 : Y2 -> {Y2,Y}
        {6}                     // 6 : Z -> {Z}
    };
    
    
    public Source2TargetDerived_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new /*@NonNull*/ String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * 
     * map cW_2_D in Source2TargetDerived_qvtp_qvtias {
     * leftCS (w : sderived::W[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize d : tderived::D[1];
     *  |}
     * where ( |)
     * { |
     * w.ast := d;
     * }
     * 
     */
    protected boolean MAP_cW_2_D(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull W w) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.Nullable D d = TderivedFactory.eINSTANCE.createD();
        assert d != null;
        models[1/*rightAS*/].add(d);
        // property assignments
        w.setAst(d);
        return true;
    }
    
    /**
     * 
     * map cX2_2_A2 in Source2TargetDerived_qvtp_qvtias {
     * leftCS (x2 : sderived::X2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a2 : tderived::A2[1];
     *  |}
     * where ( |)
     * { |
     * x2.ast := a2;
     * }
     * 
     */
    protected boolean MAP_cX2_2_A2(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 x2) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.Nullable A2 a2 = TderivedFactory.eINSTANCE.createA2();
        assert a2 != null;
        models[1/*rightAS*/].add(a2);
        // property assignments
        x2.setAst(a2);
        return true;
    }
    
    /**
     * 
     * map cY2_2_B2 in Source2TargetDerived_qvtp_qvtias {
     * leftCS (y2 : sderived::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize b2 : tderived::B2[1];
     *  |}
     * where ( |)
     * { |
     * y2.ast := b2;
     * }
     * 
     */
    protected boolean MAP_cY2_2_B2(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 y2) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.Nullable B2 b2 = TderivedFactory.eINSTANCE.createB2();
        assert b2 != null;
        models[1/*rightAS*/].add(b2);
        // property assignments
        y2.setAst(b2);
        return true;
    }
    
    /**
     * 
     * map uA2_name in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x2 : sderived::X2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::A2[1];
     * _1 : String[?];
     *  |
     * _0 := x2.ast.oclAsType(tderived::A2);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA2_name(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 x2_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = x2_0.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull A2 oclAsType = ClassUtil.nonNullState((A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_A2_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = x2_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA2_ownsB in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x2 : sderived::X2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::A2[1];
     * _1 : Sequence(tbase::B);
     *  |
     * _0 := x2.ast.oclAsType(tderived::A2)
     *   ;
     * _1 := ownsY.ast.oclAsType(tbase::B);
     * _0.ownsB := _1;
     * }
     * 
     */
    protected boolean MAP_uA2_ownsB(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 x2_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = x2_1.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull A2 oclAsType = ClassUtil.nonNullState((A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_A2_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Y> ownsY = x2_1.getOwnsY();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.Nullable Y _1 = (Y)ITERATOR__1.next();
            /**
             * ast.oclAsType(tbase::B)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            if (_1 == null) {
                throwNull(x2_1, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull B oclAsType_0 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_B_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<B> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, collect);
        oclAsType.getOwnsB().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uA2_ownsD in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x2 : sderived::X2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::A2[1];
     * _1 : Sequence(tderived::D);
     *  |
     * _0 := x2.ast.oclAsType(tderived::A2)
     *   ;
     * _1 := ownsW.ast.oclAsType(tderived::D);
     * _0.ownsD := _1;
     * }
     * 
     */
    protected boolean MAP_uA2_ownsD(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 x2_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = x2_2.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull A2 oclAsType = ClassUtil.nonNullState((A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_A2_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<W> ownsW = x2_2.getOwnsW();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsW = idResolver.createOrderedSetOfAll(ORD_CLSSid_W, ownsW);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_D);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsW.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.Nullable W _1 = (W)ITERATOR__1.next();
            /**
             * ast.oclAsType(tderived::D)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
            if (_1 == null) {
                throwNull(x2_2, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull D oclAsType_0 = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tderived_c_c_D_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<D> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(D.class, collect);
        oclAsType.getOwnsD().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uB2_name in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y2 : sderived::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::B2[1];
     * _1 : String[?];
     *  |
     * _0 := y2.ast.oclAsType(tderived::B2);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uB2_name(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 y2_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_B2_0 = idResolver.getClass(CLSSid_B2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = y2_0.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull B2 oclAsType = ClassUtil.nonNullState((B2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_B2_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = y2_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uB2_anotherName in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y2 : sderived::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::B2[1];
     * _1 : String[?];
     *  |
     * _0 := y2.ast.oclAsType(tderived::B2);
     * _1 := name2;
     * _0.anotherName := _1;
     * }
     * 
     */
    protected boolean MAP_uB2_anotherName(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 y2_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_B2_0 = idResolver.getClass(CLSSid_B2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = y2_1.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull B2 oclAsType = ClassUtil.nonNullState((B2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_B2_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name2 = y2_1.getName2();
        // property assignments
        oclAsType.setAnotherName(name2);
        return true;
    }
    
    /**
     * 
     * map uB2_ownsC in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y2 : sderived::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tderived::B2[1];
     * _1 : tbase::C[1];
     *  |
     * _0 := y2.ast.oclAsType(tderived::B2)
     *   ;
     * _1 := ownsZ.ast.oclAsType(tbase::C);
     * _0.ownsC := _1;
     * }
     * 
     */
    protected boolean MAP_uB2_ownsC(final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 y2_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tderived_c_c_B2_0 = idResolver.getClass(CLSSid_B2, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = y2_2.getAst();
        final /*@Thrown*/ example5.tderived.@org.eclipse.jdt.annotation.NonNull B2 oclAsType = ClassUtil.nonNullState((B2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tderived_c_c_B2_0));
        final /*@Thrown*/ example5.sbase.@org.eclipse.jdt.annotation.Nullable Z ownsZ = y2_2.getOwnsZ();
        if (ownsZ == null) {
            throwNull(y2_2, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
        }
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownsZ.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull C oclAsType_0 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_C_0));
        // property assignments
        oclAsType.setOwnsC(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map cSRoot_2_TRoot in Source2TargetDerived_qvtp_qvtias {
     * leftCS (sRoot : sbase::SRoot[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize tRoot : tbase::TRoot[1];
     *  |}
     * where ( |)
     * { |
     * sRoot.ast := tRoot;
     * }
     * 
     */
    protected boolean MAP_cSRoot_2_TRoot(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull SRoot sRoot) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.Nullable TRoot tRoot = TbaseFactory.eINSTANCE.createTRoot();
        assert tRoot != null;
        models[1/*rightAS*/].add(tRoot);
        // property assignments
        sRoot.setAst(tRoot);
        return true;
    }
    
    /**
     * 
     * map cX_2_A in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a : tbase::A[1];
     *  |}
     * where ( |
     * not x.oclIsKindOf(sderived::X2))
     * { |
     * x.ast := a;
     * }
     * 
     */
    protected boolean MAP_cX_2_A(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X x) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_X2_0 = idResolver.getClass(CLSSid_X2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, x, TYP_sderived_c_c_X2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.Nullable A a = TbaseFactory.eINSTANCE.createA();
        assert a != null;
        models[1/*rightAS*/].add(a);
        // property assignments
        x.setAst(a);
        return true;
    }
    
    /**
     * 
     * map cY_2_B in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize b : tbase::B[1];
     *  |}
     * where ( |
     * not y.oclIsKindOf(sderived::Y2))
     * { |
     * y.ast := b;
     * }
     * 
     */
    protected boolean MAP_cY_2_B(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y y) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, y, TYP_sderived_c_c_Y2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.Nullable B b = TbaseFactory.eINSTANCE.createB();
        assert b != null;
        models[1/*rightAS*/].add(b);
        // property assignments
        y.setAst(b);
        return true;
    }
    
    /**
     * 
     * map cZ_2_C in Source2TargetDerived_qvtp_qvtias {
     * leftCS (z : sbase::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize c : tbase::C[1];
     *  |}
     * where ( |)
     * { |
     * z.ast := c;
     * }
     * 
     */
    protected boolean MAP_cZ_2_C(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Z z) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.Nullable C c = TbaseFactory.eINSTANCE.createC();
        assert c != null;
        models[1/*rightAS*/].add(c);
        // property assignments
        z.setAst(c);
        return true;
    }
    
    /**
     * 
     * map uTRoot_ownedA in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (sRoot : sbase::SRoot[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tbase::TRoot[1];
     * _1 : Sequence(tbase::A);
     *  |
     * _0 := sRoot.ast.oclAsType(tbase::TRoot)
     *   ;
     * _1 := ownedX.ast.oclAsType(tbase::A);
     * _0.ownedA := _1;
     * }
     * 
     */
    protected boolean MAP_uTRoot_ownedA(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull SRoot sRoot_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = sRoot_0.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull TRoot oclAsType = ClassUtil.nonNullState((TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_TRoot_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<X> ownedX = sRoot_0.getOwnedX();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedX = idResolver.createOrderedSetOfAll(ORD_CLSSid_X, ownedX);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_A);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedX.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.Nullable X _1 = (X)ITERATOR__1.next();
            /**
             * ast.oclAsType(tbase::A)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
            if (_1 == null) {
                throwNull(sRoot_0, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull A oclAsType_0 = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_A_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<A> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(A.class, collect);
        oclAsType.getOwnedA().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uA_name in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not x.oclIsKindOf(sderived::X2)
     *   )
     * {_0 : tbase::A[1];
     * _1 : String[?];
     *  |
     * _0 := x.ast.oclAsType(tbase::A);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA_name(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X x_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_X2_0 = idResolver.getClass(CLSSid_X2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, x_0, TYP_sderived_c_c_X2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = x_0.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull A oclAsType = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_A_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = x_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA_ownsB in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not x.oclIsKindOf(sderived::X2)
     *   )
     * {_0 : tbase::A[1];
     * _1 : Sequence(tbase::B);
     *  |
     * _0 := x.ast.oclAsType(tbase::A)
     *   ;
     * _1 := ownsY.ast.oclAsType(tbase::B);
     * _0.ownsB := _1;
     * }
     * 
     */
    protected boolean MAP_uA_ownsB(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X x_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_X2_0 = idResolver.getClass(CLSSid_X2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, x_1, TYP_sderived_c_c_X2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = x_1.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull A oclAsType = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_A_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Y> ownsY = x_1.getOwnsY();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.Nullable Y _1 = (Y)ITERATOR__1.next();
            /**
             * ast.oclAsType(tbase::B)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            if (_1 == null) {
                throwNull(x_1, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull B oclAsType_0 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_B_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<B> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, collect);
        oclAsType.getOwnsB().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uB_name in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not y.oclIsKindOf(sderived::Y2)
     *   )
     * {_0 : tbase::B[1];
     * _1 : String[?];
     *  |
     * _0 := y.ast.oclAsType(tbase::B);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uB_name(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y y_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, y_0, TYP_sderived_c_c_Y2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = y_0.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_B_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = y_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uB_ownsC in Source2TargetDerived_qvtp_qvtias {
     * 
     *   leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not y.oclIsKindOf(sderived::Y2)
     *   )
     * {_0 : tbase::B[1];
     * _1 : tbase::C[1];
     *  |
     * _0 := y.ast.oclAsType(tbase::B)
     *   ;
     * _1 := ownsZ.ast.oclAsType(tbase::C);
     * _0.ownsC := _1;
     * }
     * 
     */
    protected boolean MAP_uB_ownsC(final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y y_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonInvalid*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, y_1, TYP_sderived_c_c_Y2_0).booleanValue());
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_tbase_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = y_1.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_B_0));
        final /*@Thrown*/ example5.sbase.@org.eclipse.jdt.annotation.Nullable Z ownsZ = y_1.getOwnsZ();
        if (ownsZ == null) {
            throwNull(y_1, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
        }
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownsZ.getAst();
        final /*@Thrown*/ example5.tbase.@org.eclipse.jdt.annotation.NonNull C oclAsType_0 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_C_0));
        // property assignments
        oclAsType.setOwnsC(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map __root__ in Source2TargetDerived_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for x2 : sderived::X2 in sderived::X2.allInstances()
     *    {
     * map cX2_2_A2 {
     * x2 := x2;
     * }}
     *   for x2 : sderived::X2 in sderived::X2.allInstances()
     *    {
     * map uA2_name {
     * x2 := x2;
     * }}
     *   for y2 : sderived::Y2 in sderived::Y2.allInstances()
     *    {
     * map cY2_2_B2 {
     * y2 := y2;
     * }}
     *   for y : sbase::Y in sbase::Y.allInstances()
     *    {
     * map cY_2_B {
     * y := y;
     * }}
     *   for x2 : sderived::X2 in sderived::X2.allInstances()
     *    {
     * map uA2_ownsB {
     * x2 := x2;
     * }}
     *   for w : sderived::W in sderived::W.allInstances()
     *    {
     * map cW_2_D {
     * w := w;
     * }}
     *   for x2 : sderived::X2 in sderived::X2.allInstances()
     *    {
     * map uA2_ownsD {
     * x2 := x2;
     * }}
     *   for y2 : sderived::Y2 in sderived::Y2.allInstances()
     *    {
     * map uB2_name {
     * y2 := y2;
     * }}
     *   for y2 : sderived::Y2 in sderived::Y2.allInstances()
     *    {
     * map uB2_anotherName {
     * y2 := y2;
     * }}
     *   for z : sbase::Z in sbase::Z.allInstances()
     *    {
     * map cZ_2_C {
     * z := z;
     * }}
     *   for y2 : sderived::Y2 in sderived::Y2.allInstances()
     *    {
     * map uB2_ownsC {
     * y2 := y2;
     * }}
     *   for sRoot : sbase::SRoot in sbase::SRoot.allInstances()
     *    {
     * map cSRoot_2_TRoot {
     * sRoot := sRoot;
     * }}
     *   for x : sbase::X in sbase::X.allInstances()
     *    {
     * map cX_2_A {
     * x := x;
     * }}
     *   for sRoot : sbase::SRoot in sbase::SRoot.allInstances()
     *    {
     * map uTRoot_ownedA {
     * sRoot := sRoot;
     * }}
     *   for x : sbase::X in sbase::X.allInstances()
     *    {
     * map uA_name {
     * x := x;
     * }}
     *   for x : sbase::X in sbase::X.allInstances()
     *    {
     * map uA_ownsB {
     * x := x;
     * }}
     *   for y : sbase::Y in sbase::Y.allInstances()
     *    {
     * map uB_name {
     * y := y;
     * }}
     *   for y : sbase::Y in sbase::Y.allInstances()
     *    {
     * map uB_ownsC {
     * y := y;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sbase_c_c_SRoot_1 = idResolver.getClass(CLSSid_SRoot, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sbase_c_c_X_2 = idResolver.getClass(CLSSid_X, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sbase_c_c_Y_2 = idResolver.getClass(CLSSid_Y, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sbase_c_c_Z_0 = idResolver.getClass(CLSSid_Z, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_W_0 = idResolver.getClass(CLSSid_W, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_X2_3 = idResolver.getClass(CLSSid_X2, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_sderived_c_c_Y2_3 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_12 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_SRoot, TYP_sbase_c_c_SRoot_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_13 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_X, TYP_sbase_c_c_X_2));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_15 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Y, TYP_sbase_c_c_Y_2));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_0 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_X2, TYP_sderived_c_c_X2_3));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_6 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Y2, TYP_sderived_c_c_Y2_3));
        for (X2 x2_7 : ValueUtil.typedIterable(X2.class, allInstances_0)) {
            if (x2_7 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 symbol_0 = (X2)x2_7;
                MAP_cX2_2_A2(symbol_0);
            }
        }
        for (X2 x2_8 : ValueUtil.typedIterable(X2.class, allInstances_0)) {
            if (x2_8 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 symbol_3 = (X2)x2_8;
                MAP_uA2_name(symbol_3);
            }
        }
        for (Y2 y2_7 : ValueUtil.typedIterable(Y2.class, allInstances_6)) {
            if (y2_7 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 symbol_6 = (Y2)y2_7;
                MAP_cY2_2_B2(symbol_6);
            }
        }
        for (Y y_5 : ValueUtil.typedIterable(Y.class, allInstances_15)) {
            if (y_5 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y symbol_9 = (Y)y_5;
                MAP_cY_2_B(symbol_9);
            }
        }
        for (X2 x2_9 : ValueUtil.typedIterable(X2.class, allInstances_0)) {
            if (x2_9 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 symbol_12 = (X2)x2_9;
                MAP_uA2_ownsB(symbol_12);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_4 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_W, TYP_sderived_c_c_W_0));
        for (W w_1 : ValueUtil.typedIterable(W.class, allInstances_4)) {
            if (w_1 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull W symbol_15 = (W)w_1;
                MAP_cW_2_D(symbol_15);
            }
        }
        for (X2 x2_10 : ValueUtil.typedIterable(X2.class, allInstances_0)) {
            if (x2_10 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull X2 symbol_18 = (X2)x2_10;
                MAP_uA2_ownsD(symbol_18);
            }
        }
        for (Y2 y2_8 : ValueUtil.typedIterable(Y2.class, allInstances_6)) {
            if (y2_8 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 symbol_21 = (Y2)y2_8;
                MAP_uB2_name(symbol_21);
            }
        }
        for (Y2 y2_9 : ValueUtil.typedIterable(Y2.class, allInstances_6)) {
            if (y2_9 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 symbol_24 = (Y2)y2_9;
                MAP_uB2_anotherName(symbol_24);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_8 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Z, TYP_sbase_c_c_Z_0));
        for (Z z_1 : ValueUtil.typedIterable(Z.class, allInstances_8)) {
            if (z_1 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Z symbol_27 = (Z)z_1;
                MAP_cZ_2_C(symbol_27);
            }
        }
        for (Y2 y2_10 : ValueUtil.typedIterable(Y2.class, allInstances_6)) {
            if (y2_10 != null) {
                final /*@NonInvalid*/ example5.sderived.@org.eclipse.jdt.annotation.NonNull Y2 symbol_30 = (Y2)y2_10;
                MAP_uB2_ownsC(symbol_30);
            }
        }
        for (SRoot sRoot_3 : ValueUtil.typedIterable(SRoot.class, allInstances_12)) {
            if (sRoot_3 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull SRoot symbol_33 = (SRoot)sRoot_3;
                MAP_cSRoot_2_TRoot(symbol_33);
            }
        }
        for (X x_5 : ValueUtil.typedIterable(X.class, allInstances_13)) {
            if (x_5 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X symbol_36 = (X)x_5;
                MAP_cX_2_A(symbol_36);
            }
        }
        for (SRoot sRoot_4 : ValueUtil.typedIterable(SRoot.class, allInstances_12)) {
            if (sRoot_4 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull SRoot symbol_39 = (SRoot)sRoot_4;
                MAP_uTRoot_ownedA(symbol_39);
            }
        }
        for (X x_6 : ValueUtil.typedIterable(X.class, allInstances_13)) {
            if (x_6 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X symbol_42 = (X)x_6;
                MAP_uA_name(symbol_42);
            }
        }
        for (X x_7 : ValueUtil.typedIterable(X.class, allInstances_13)) {
            if (x_7 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull X symbol_45 = (X)x_7;
                MAP_uA_ownsB(symbol_45);
            }
        }
        for (Y y_6 : ValueUtil.typedIterable(Y.class, allInstances_15)) {
            if (y_6 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y symbol_48 = (Y)y_6;
                MAP_uB_name(symbol_48);
            }
        }
        for (Y y_7 : ValueUtil.typedIterable(Y.class, allInstances_15)) {
            if (y_7 != null) {
                final /*@NonInvalid*/ example5.sbase.@org.eclipse.jdt.annotation.NonNull Y symbol_51 = (Y)y_7;
                MAP_uB_ownsC(symbol_51);
            }
        }
        return true;
    }
}
