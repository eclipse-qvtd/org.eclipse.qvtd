/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._Source2TargetBase_qvtp_qvtias;

import example5.sbase.SRoot;
import example5.sbase.SbasePackage;
import example5.sbase.X;
import example5.sbase.Y;
import example5.sbase.Z;
import example5.tbase.A;
import example5.tbase.B;
import example5.tbase.C;
import example5.tbase.TRoot;
import example5.tbase.TbaseFactory;
import example5.tbase.TbasePackage;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;

/**
 * The Source2TargetBase_qvtp_qvtias transformation:
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
public class Source2TargetBase_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/sourceBaseMM/1.0", null, SbasePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/targetBaseMM/1.0", null, TbasePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("A", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("B", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("C", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("SRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_X = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("X", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("Y", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Z = PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_sourceBaseMM_s_1_0.getClassId("Z", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_X = TypeId.ORDERED_SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Y = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_A = TypeId.SEQUENCE.getSpecializedId(CLSSid_A);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_B = TypeId.SEQUENCE.getSpecializedId(CLSSid_B);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_SRoot = TypeId.SET.getSpecializedId(CLSSid_SRoot);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_X = TypeId.SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y = TypeId.SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Z = TypeId.SET.getSpecializedId(CLSSid_Z);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_SRoot,                   // 0 => SRoot
        CLSSid_X,                       // 1 => X
        CLSSid_Y,                       // 2 => Y
        CLSSid_Z                        // 3 => Z
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : SRoot -> {SRoot}
        {1},                    // 1 : X -> {X}
        {2},                    // 2 : Y -> {Y}
        {3}                     // 3 : Z -> {Z}
    };
    
    
    public Source2TargetBase_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * 
     * map cSRoot_2_TRoot in Source2TargetBase_qvtp_qvtias {
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
    protected boolean MAP_cSRoot_2_TRoot(final /*@NonNull*/ /*@NonInvalid*/ SRoot sRoot) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ TRoot tRoot = TbaseFactory.eINSTANCE.createTRoot();
        assert tRoot != null;
        models[1/*rightAS*/].add(tRoot);
        // property assignments
        sRoot.setAst(tRoot);
        return true;
    }
    
    /**
     * 
     * map cX_2_A in Source2TargetBase_qvtp_qvtias {
     * leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a : tbase::A[1];
     *  |}
     * where ( |)
     * { |
     * x.ast := a;
     * }
     * 
     */
    protected boolean MAP_cX_2_A(final /*@NonNull*/ /*@NonInvalid*/ X x) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ A a = TbaseFactory.eINSTANCE.createA();
        assert a != null;
        models[1/*rightAS*/].add(a);
        // property assignments
        x.setAst(a);
        return true;
    }
    
    /**
     * 
     * map cY_2_B in Source2TargetBase_qvtp_qvtias {
     * leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize b : tbase::B[1];
     *  |}
     * where ( |)
     * { |
     * y.ast := b;
     * }
     * 
     */
    protected boolean MAP_cY_2_B(final /*@NonNull*/ /*@NonInvalid*/ Y y) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ B b = TbaseFactory.eINSTANCE.createB();
        assert b != null;
        models[1/*rightAS*/].add(b);
        // property assignments
        y.setAst(b);
        return true;
    }
    
    /**
     * 
     * map cZ_2_C in Source2TargetBase_qvtp_qvtias {
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
    protected boolean MAP_cZ_2_C(final /*@NonNull*/ /*@NonInvalid*/ Z z) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ C c = TbaseFactory.eINSTANCE.createC();
        assert c != null;
        models[1/*rightAS*/].add(c);
        // property assignments
        z.setAst(c);
        return true;
    }
    
    /**
     * 
     * map uTRoot_ownedA in Source2TargetBase_qvtp_qvtias {
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
    protected boolean MAP_uTRoot_ownedA(final /*@NonNull*/ /*@NonInvalid*/ SRoot sRoot_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = sRoot_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ TRoot oclAsType = ClassUtil.nonNullState((TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_TRoot_0));
        final /*@NonNull*/ /*@Thrown*/ List<X> ownedX = sRoot_0.getOwnedX();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedX = idResolver.createOrderedSetOfAll(ORD_CLSSid_X, ownedX);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_A);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedX.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ X _1 = (X)ITERATOR__1.next();
            /**
             * ast.oclAsType(tbase::A)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
            if (_1 == null) {
                throwNull(sRoot_0, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ A oclAsType_0 = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_A_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<A> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(A.class, collect);
        oclAsType.getOwnedA().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uA_name in Source2TargetBase_qvtp_qvtias {
     * 
     *   leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tbase::A[1];
     * _1 : String[?];
     *  |
     * _0 := x.ast.oclAsType(tbase::A);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA_name(final /*@NonNull*/ /*@NonInvalid*/ X x_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ A oclAsType = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_A_0));
        final /*@Nullable*/ /*@Thrown*/ String name = x_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA_ownsB in Source2TargetBase_qvtp_qvtias {
     * 
     *   leftCS (x : sbase::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
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
    protected boolean MAP_uA_ownsB(final /*@NonNull*/ /*@NonInvalid*/ X x_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ A oclAsType = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_A_0));
        final /*@NonNull*/ /*@Thrown*/ List<Y> ownsY = x_1.getOwnsY();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * ast.oclAsType(tbase::B)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            if (_1 == null) {
                throwNull(x_1, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ B oclAsType_0 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_B_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<B> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, collect);
        oclAsType.getOwnsB().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uB_name in Source2TargetBase_qvtp_qvtias {
     * 
     *   leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : tbase::B[1];
     * _1 : String[?];
     *  |
     * _0 := y.ast.oclAsType(tbase::B);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uB_name(final /*@NonNull*/ /*@NonInvalid*/ Y y_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_B_0));
        final /*@Nullable*/ /*@Thrown*/ String name = y_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uB_ownsC in Source2TargetBase_qvtp_qvtias {
     * 
     *   leftCS (y : sbase::Y[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
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
    protected boolean MAP_uB_ownsC(final /*@NonNull*/ /*@NonInvalid*/ Y y_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_tbase_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_tbase_c_c_B_0));
        final /*@Nullable*/ /*@Thrown*/ Z ownsZ = y_1.getOwnsZ();
        if (ownsZ == null) {
            throwNull(y_1, "Null source for \'\'http://cs2as/tests/example5/sourceBaseMM/1.0\'::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final /*@NonNull*/ /*@Thrown*/ C oclAsType_0 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_tbase_c_c_C_0));
        // property assignments
        oclAsType.setOwnsC(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map __root__ in Source2TargetBase_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for sRoot : sbase::SRoot in sbase::SRoot.allInstances()
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
     *   for y : sbase::Y in sbase::Y.allInstances()
     *    {
     * map cY_2_B {
     * y := y;
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
     *   for z : sbase::Z in sbase::Z.allInstances()
     *    {
     * map cZ_2_C {
     * z := z;
     * }}
     *   for y : sbase::Y in sbase::Y.allInstances()
     *    {
     * map uB_ownsC {
     * y := y;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_sbase_c_c_SRoot_1 = idResolver.getClass(CLSSid_SRoot, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_sbase_c_c_X_2 = idResolver.getClass(CLSSid_X, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_sbase_c_c_Y_2 = idResolver.getClass(CLSSid_Y, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_sbase_c_c_Z_0 = idResolver.getClass(CLSSid_Z, null);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_SRoot, TYP_sbase_c_c_SRoot_1);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_X, TYP_sbase_c_c_X_2);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_5 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Y, TYP_sbase_c_c_Y_2);
        for (SRoot sRoot_3 : ValueUtil.typedIterable(SRoot.class, allInstances_1)) {
            if (sRoot_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_0 = (SRoot)sRoot_3;
                MAP_cSRoot_2_TRoot(symbol_0);
            }
        }
        for (X x_5 : ValueUtil.typedIterable(X.class, allInstances_3)) {
            if (x_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_3 = (X)x_5;
                MAP_cX_2_A(symbol_3);
            }
        }
        for (SRoot sRoot_4 : ValueUtil.typedIterable(SRoot.class, allInstances_1)) {
            if (sRoot_4 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_6 = (SRoot)sRoot_4;
                MAP_uTRoot_ownedA(symbol_6);
            }
        }
        for (Y y_5 : ValueUtil.typedIterable(Y.class, allInstances_5)) {
            if (y_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y symbol_9 = (Y)y_5;
                MAP_cY_2_B(symbol_9);
            }
        }
        for (X x_6 : ValueUtil.typedIterable(X.class, allInstances_3)) {
            if (x_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_12 = (X)x_6;
                MAP_uA_name(symbol_12);
            }
        }
        for (X x_7 : ValueUtil.typedIterable(X.class, allInstances_3)) {
            if (x_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_15 = (X)x_7;
                MAP_uA_ownsB(symbol_15);
            }
        }
        for (Y y_6 : ValueUtil.typedIterable(Y.class, allInstances_5)) {
            if (y_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y symbol_18 = (Y)y_6;
                MAP_uB_name(symbol_18);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Z, TYP_sbase_c_c_Z_0);
        for (Z z_1 : ValueUtil.typedIterable(Z.class, allInstances_6)) {
            if (z_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_21 = (Z)z_1;
                MAP_cZ_2_C(symbol_21);
            }
        }
        for (Y y_7 : ValueUtil.typedIterable(Y.class, allInstances_5)) {
            if (y_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y symbol_24 = (Y)y_7;
                MAP_uB_ownsC(symbol_24);
            }
        }
        return true;
    }
}
