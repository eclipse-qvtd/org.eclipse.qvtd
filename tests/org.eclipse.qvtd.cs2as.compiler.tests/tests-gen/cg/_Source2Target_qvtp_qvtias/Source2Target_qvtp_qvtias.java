/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._Source2Target_qvtp_qvtias;

import example1.source.PathElementCS;
import example1.source.PathNameCS;
import example1.source.SElement;
import example1.source.SRoot;
import example1.source.SourcePackage;
import example1.source.X;
import example1.source.Y;
import example1.source.Y1;
import example1.source.Y2;
import example1.source.Z;
import example1.target.A;
import example1.target.A1;
import example1.target.A2;
import example1.target.A3;
import example1.target.B;
import example1.target.C;
import example1.target.D;
import example1.target.NamedElement;
import example1.target.Namespace;
import example1.target.TRoot;
import example1.target.TargetFactory;
import example1.target.TargetPackage;
import example1.target.util.Visitable;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionAtOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.cs2as.compiler.tests.models.example1.java.LookupEnvironment;
import org.eclipse.qvtd.cs2as.compiler.tests.models.example1.java.TargetLookupVisitor;

/**
 * The Source2Target_qvtp_qvtias transformation:
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
public class Source2Target_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/sourceMM/1.0", null, SourcePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_A3 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A3", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Namespace = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("Namespace", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("PathElementCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("PathNameCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SElement = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("SElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("SRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Visitable = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_X = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("X", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y1", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y2", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Z = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Z", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_X = TypeId.ORDERED_SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Y = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_A = TypeId.SEQUENCE.getSpecializedId(CLSSid_A);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_B = TypeId.SEQUENCE.getSpecializedId(CLSSid_B);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_C = TypeId.SEQUENCE.getSpecializedId(CLSSid_C);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y1 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y1);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y2 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y2);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PathElementCS = TypeId.SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PathNameCS = TypeId.SET.getSpecializedId(CLSSid_PathNameCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_SRoot = TypeId.SET.getSpecializedId(CLSSid_SRoot);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_X = TypeId.SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y1 = TypeId.SET.getSpecializedId(CLSSid_Y1);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y2 = TypeId.SET.getSpecializedId(CLSSid_Y2);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Z = TypeId.SET.getSpecializedId(CLSSid_Z);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_PathElementCS,           // 0 => PathElementCS
        CLSSid_PathNameCS,              // 1 => PathNameCS
        CLSSid_SRoot,                   // 2 => SRoot
        CLSSid_X,                       // 3 => X
        CLSSid_Y1,                      // 4 => Y1
        CLSSid_Y2,                      // 5 => Y2
        CLSSid_Z                        // 6 => Z
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : PathElementCS -> {PathElementCS}
        {1},                    // 1 : PathNameCS -> {PathNameCS}
        {2},                    // 2 : SRoot -> {SRoot}
        {3},                    // 3 : X -> {X}
        {4},                    // 4 : Y1 -> {Y1}
        {5},                    // 5 : Y2 -> {Y2}
        {6}                     // 6 : Z -> {Z}
    };
    
    
    public Source2Target_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * 
     * map cSRoot_2_TRoot in Source2Target_qvtp_qvtias {
     * leftCS (sRoot : source::SRoot[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize tRoot : target::TRoot[1];
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
        final /*@Thrown*/ TRoot tRoot = TargetFactory.eINSTANCE.createTRoot();
        assert tRoot != null;
        models[1/*rightAS*/].add(tRoot);
        // property assignments
        sRoot.setAst(tRoot);
        return true;
    }
    
    /**
     * 
     * map cX_2_A3 in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a3 : target::A3[1];
     *  |}
     * where ( |
     * not disambiguatesToA1()
     *   not disambiguatesToA2())
     * { |
     * x.ast := a3;
     * }
     * 
     */
    protected boolean MAP_cX_2_A3(final /*@NonNull*/ /*@NonInvalid*/ X x) throws ReflectiveOperationException {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x.isIsA2();
        final /*@Nullable*/ /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isA2);
        if (not_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A3 a3 = TargetFactory.eINSTANCE.createA3();
        assert a3 != null;
        models[1/*rightAS*/].add(a3);
        // property assignments
        x.setAst(a3);
        return true;
    }
    
    /**
     * 
     * map cX_2_A2 in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a2 : target::A2[1];
     *  |}
     * where ( |
     * not disambiguatesToA1()
     *   disambiguatesToA2())
     * { |
     * x.ast := a2;
     * }
     * 
     */
    protected boolean MAP_cX_2_A2(final /*@NonNull*/ /*@NonInvalid*/ X x_0) throws ReflectiveOperationException {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_0.isIsA2();
        if (isA2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_0.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A2 a2 = TargetFactory.eINSTANCE.createA2();
        assert a2 != null;
        models[1/*rightAS*/].add(a2);
        // property assignments
        x_0.setAst(a2);
        return true;
    }
    
    /**
     * 
     * map cX_2_A1 in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize a1 : target::A1[1];
     *  |}
     * where ( |
     * disambiguatesToA1())
     * { |
     * x.ast := a1;
     * }
     * 
     */
    protected boolean MAP_cX_2_A1(final /*@NonNull*/ /*@NonInvalid*/ X x_1) throws ReflectiveOperationException {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_1.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A1 a1 = TargetFactory.eINSTANCE.createA1();
        assert a1 != null;
        models[1/*rightAS*/].add(a1);
        // property assignments
        x_1.setAst(a1);
        return true;
    }
    
    /**
     * 
     * map cY1_2_B in Source2Target_qvtp_qvtias {
     * leftCS (y1 : source::Y1[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize b : target::B[1];
     *  |}
     * where ( |)
     * { |
     * y1.ast := b;
     * }
     * 
     */
    protected boolean MAP_cY1_2_B(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ B b = TargetFactory.eINSTANCE.createB();
        assert b != null;
        models[1/*rightAS*/].add(b);
        // property assignments
        y1.setAst(b);
        return true;
    }
    
    /**
     * 
     * map cY2_2_C in Source2Target_qvtp_qvtias {
     * leftCS (y2 : source::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize c : target::C[1];
     *  |}
     * where ( |)
     * { |
     * y2.ast := c;
     * }
     * 
     */
    protected boolean MAP_cY2_2_C(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ C c = TargetFactory.eINSTANCE.createC();
        assert c != null;
        models[1/*rightAS*/].add(c);
        // property assignments
        y2.setAst(c);
        return true;
    }
    
    /**
     * 
     * map cZ_2_D_0 in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize d : target::D[1];
     *  |}
     * where ( |
     * not toY.oclIsKindOf(source::Y1))
     * { |
     * z.ast := d;
     * }
     * 
     */
    protected boolean MAP_cZ_2_D_0(final /*@NonNull*/ /*@NonInvalid*/ Z z) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ D d = TargetFactory.eINSTANCE.createD();
        assert d != null;
        models[1/*rightAS*/].add(d);
        // property assignments
        z.setAst(d);
        return true;
    }
    
    /**
     * 
     * map cZ_2_D_1 in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize d : target::D[1];
     *  |}
     * where ( |
     * toY.oclIsKindOf(source::Y1))
     * { |
     * z.ast := d;
     * }
     * 
     */
    protected boolean MAP_cZ_2_D_1(final /*@NonNull*/ /*@NonInvalid*/ Z z_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_0.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        // creations
        final /*@Thrown*/ D d = TargetFactory.eINSTANCE.createD();
        assert d != null;
        models[1/*rightAS*/].add(d);
        // property assignments
        z_0.setAst(d);
        return true;
    }
    
    /**
     * 
     * map uTRoot_ownedA in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (sRoot : source::SRoot[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::TRoot[1];
     * _1 : Sequence(target::A);
     *  |
     * _0 := sRoot.ast.oclAsType(target::TRoot)
     *   ;
     * _1 := ownedX.ast.oclAsType(target::A);
     * _0.ownedA := _1;
     * }
     * 
     */
    protected boolean MAP_uTRoot_ownedA(final /*@NonNull*/ /*@NonInvalid*/ SRoot sRoot_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = sRoot_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ TRoot oclAsType = ClassUtil.nonNullState((TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_TRoot_0));
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
             * ast.oclAsType(target::A)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
            if (_1 == null) {
                throwNull(sRoot_0, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ A oclAsType_0 = ClassUtil.nonNullState((A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_A_0));
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
     * map uA3_name in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not disambiguatesToA1()
     *   not disambiguatesToA2()
     *   )
     * {_0 : target::A3[1];
     * _1 : String[?];
     *  |
     * _0 := x.ast.oclAsType(target::A3);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA3_name(final /*@NonNull*/ /*@NonInvalid*/ X x_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_2.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_2.isIsA2();
        final /*@Nullable*/ /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isA2);
        if (not_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A3_0 = idResolver.getClass(CLSSid_A3, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_2.getAst();
        final /*@NonNull*/ /*@Thrown*/ A3 oclAsType = ClassUtil.nonNullState((A3)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A3_0));
        final /*@Nullable*/ /*@Thrown*/ String name = x_2.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA3_ownsC in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not disambiguatesToA1()
     *   not disambiguatesToA2()
     *   )
     * {_0 : target::A3[1];
     * _1 : Sequence(target::C);
     *  |
     * _0 := x.ast.oclAsType(target::A3)
     *   ;
     * _1 := ownsY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C);
     * _0.ownsC := _1;
     * }
     * 
     */
    protected boolean MAP_uA3_ownsC(final /*@NonNull*/ /*@NonInvalid*/ X x_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_3.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_3.isIsA2();
        final /*@Nullable*/ /*@Thrown*/ Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isA2);
        if (not_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A3_0 = idResolver.getClass(CLSSid_A3, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_3.getAst();
        final /*@NonNull*/ /*@Thrown*/ A3 oclAsType = ClassUtil.nonNullState((A3)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A3_0));
        final /*@NonNull*/ /*@Thrown*/ List<Y> ownsY = x_3.getOwnsY();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Y2);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * oclAsType(source::Y2)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
            final /*@NonNull*/ /*@Thrown*/ Y2 oclAsType_0 = ClassUtil.nonNullState((Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1, TYP_source_c_c_Y2_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_C);
        /*@NonNull*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@NonNull*/ /*@NonInvalid*/ Y2 _1_0 = (Y2)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::C)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@NonNull*/ /*@Thrown*/ C oclAsType_1 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_C_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<C> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(C.class, collect);
        oclAsType.getOwnsC().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uA2_name in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not disambiguatesToA1()
     *   disambiguatesToA2()
     *   )
     * {_0 : target::A2[1];
     * _1 : String[?];
     *  |
     * _0 := x.ast.oclAsType(target::A2);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA2_name(final /*@NonNull*/ /*@NonInvalid*/ X x_4) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_4.isIsA2();
        if (isA2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_4.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_4.getAst();
        final /*@NonNull*/ /*@Thrown*/ A2 oclAsType = ClassUtil.nonNullState((A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A2_0));
        final /*@Nullable*/ /*@Thrown*/ String name = x_4.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA2_ownsC in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not disambiguatesToA1()
     *   disambiguatesToA2()
     *   )
     * {_0 : target::A2[1];
     * _1 : Sequence(target::C);
     *  |
     * _0 := x.ast.oclAsType(target::A2)
     *   ;
     * _1 := ownsY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C);
     * _0.ownsC := _1;
     * }
     * 
     */
    protected boolean MAP_uA2_ownsC(final /*@NonNull*/ /*@NonInvalid*/ X x_5) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_5.isIsA2();
        if (isA2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_5.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_5.getAst();
        final /*@NonNull*/ /*@Thrown*/ A2 oclAsType = ClassUtil.nonNullState((A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A2_0));
        final /*@NonNull*/ /*@Thrown*/ List<Y> ownsY = x_5.getOwnsY();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Y2);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * oclAsType(source::Y2)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
            final /*@NonNull*/ /*@Thrown*/ Y2 oclAsType_0 = ClassUtil.nonNullState((Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1, TYP_source_c_c_Y2_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_C);
        /*@NonNull*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@NonNull*/ /*@NonInvalid*/ Y2 _1_0 = (Y2)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::C)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@NonNull*/ /*@Thrown*/ C oclAsType_1 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_C_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<C> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(C.class, collect);
        oclAsType.getOwnsC().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uA1_name in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * disambiguatesToA1()
     *   )
     * {_0 : target::A1[1];
     * _1 : String[?];
     *  |
     * _0 := x.ast.oclAsType(target::A1);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uA1_name(final /*@NonNull*/ /*@NonInvalid*/ X x_6) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_6.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A1_0 = idResolver.getClass(CLSSid_A1, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_6.getAst();
        final /*@NonNull*/ /*@Thrown*/ A1 oclAsType = ClassUtil.nonNullState((A1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A1_0));
        final /*@Nullable*/ /*@Thrown*/ String name = x_6.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uA1_ownsB in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (x : source::X[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * disambiguatesToA1()
     *   )
     * {_0 : target::A1[1];
     * _1 : Sequence(target::B);
     *  |
     * _0 := x.ast.oclAsType(target::A1)
     *   ;
     * _1 := ownsY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B);
     * _0.ownsB := _1;
     * }
     * 
     */
    protected boolean MAP_uA1_ownsB(final /*@NonNull*/ /*@NonInvalid*/ X x_7) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_7.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A1_0 = idResolver.getClass(CLSSid_A1, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_7.getAst();
        final /*@NonNull*/ /*@Thrown*/ A1 oclAsType = ClassUtil.nonNullState((A1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_A1_0));
        final /*@NonNull*/ /*@Thrown*/ List<Y> ownsY = x_7.getOwnsY();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Y1);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * oclAsType(source::Y1)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
            final /*@NonNull*/ /*@Thrown*/ Y1 oclAsType_0 = ClassUtil.nonNullState((Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1, TYP_source_c_c_Y1_0));
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        /*@NonNull*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@NonNull*/ /*@NonInvalid*/ Y1 _1_0 = (Y1)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::B)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@NonNull*/ /*@Thrown*/ B oclAsType_1 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_B_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<B> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, collect);
        oclAsType.getOwnsB().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uB_ownsD in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (y1 : source::Y1[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::B[1];
     * _1 : target::D[1];
     *  |
     * _0 := y1.ast.oclAsType(target::B)
     *   ;
     * _1 := ownsZ.ast.oclAsType(target::D);
     * _0.ownsD := _1;
     * }
     * 
     */
    protected boolean MAP_uB_ownsD(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y1_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_B_0));
        final /*@Nullable*/ /*@Thrown*/ Z ownsZ = y1_0.getOwnsZ();
        if (ownsZ == null) {
            throwNull(y1_0, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType_0 = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_D_0));
        // property assignments
        oclAsType.setOwnsD(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uB_name in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (y1 : source::Y1[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::B[1];
     * _1 : String[?];
     *  |
     * _0 := y1.ast.oclAsType(target::B);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uB_name(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y1_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ B oclAsType = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_B_0));
        final /*@Nullable*/ /*@Thrown*/ String name = y1_1.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uC_ownsD in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (y2 : source::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::C[1];
     * _1 : target::D[1];
     *  |
     * _0 := y2.ast.oclAsType(target::C)
     *   ;
     * _1 := ownsZ.ast.oclAsType(target::D);
     * _0.ownsD := _1;
     * }
     * 
     */
    protected boolean MAP_uC_ownsD(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y2_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ C oclAsType = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_C_0));
        final /*@Nullable*/ /*@Thrown*/ Z ownsZ = y2_0.getOwnsZ();
        if (ownsZ == null) {
            throwNull(y2_0, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType_0 = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_D_0));
        // property assignments
        oclAsType.setOwnsD(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uC_name in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (y2 : source::Y2[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::C[1];
     * _1 : String[?];
     *  |
     * _0 := y2.ast.oclAsType(target::C);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uC_name(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y2_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ C oclAsType = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_C_0));
        final /*@Nullable*/ /*@Thrown*/ String name = y2_1.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uD_0_toA in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * {_0 : target::D[1];
     * _1 : target::A2[?];
     *  |
     * _0 := z.ast.oclAsType(target::D)
     *   ;
     * _1 := toY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C).toA2;
     * _0.toA := _1;
     * }
     * 
     */
    protected boolean MAP_uD_0_toA(final /*@NonNull*/ /*@NonInvalid*/ Z z_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_1.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_D_0));
        final /*@Nullable*/ /*@Thrown*/ Y toY_0 = z_1.getToY();
        final /*@NonNull*/ /*@Thrown*/ Y2 oclAsType_0 = ClassUtil.nonNullState((Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, toY_0, TYP_source_c_c_Y2_0));
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ C oclAsType_1 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_C_0));
        final /*@Nullable*/ /*@Thrown*/ A2 toA2 = oclAsType_1.getToA2();
        // property assignments
        oclAsType.setToA(toA2);
        return true;
    }
    
    /**
     * 
     * map uD_0_refsC in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * {_0 : target::D[1];
     * _1 : target::C[?];
     *  |
     * _0 := z.ast.oclAsType(target::D)
     *   ;
     * _1 := if refers = null
     *   then null
     *   else
     *     refers.ast.oclAsType(target::NamedElement)
     *     .oclAsType(target::C)
     *   endif;
     * _0.refsC := _1;
     * }
     * 
     */
    protected boolean MAP_uD_0_refsC(final /*@NonNull*/ /*@NonInvalid*/ Z z_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_2.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        final /*@Nullable*/ /*@Thrown*/ PathNameCS refers = z_2.getRefers();
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_2.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_D_0));
        final /*@Thrown*/ boolean eq = refers == null;
        /*@Nullable*/ /*@Thrown*/ C symbol_0;
        if (eq) {
            symbol_0 = null;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_NamedElement_0 = idResolver.getClass(CLSSid_NamedElement, null);
            if (refers == null) {
                throwNull(z_2, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = refers.getAst();
            final /*@NonNull*/ /*@Thrown*/ NamedElement oclAsType_0 = ClassUtil.nonNullState((NamedElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_NamedElement_0));
            final /*@NonNull*/ /*@Thrown*/ C oclAsType_1 = ClassUtil.nonNullState((C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_0, TYP_target_c_c_C_0));
            symbol_0 = oclAsType_1;
        }
        // property assignments
        oclAsType.setRefsC(symbol_0);
        return true;
    }
    
    /**
     * 
     * map uD_1_toA in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * toY.oclIsKindOf(source::Y1)
     *   )
     * {_0 : target::D[1];
     * _1 : target::A1[?];
     *  |
     * _0 := z.ast.oclAsType(target::D)
     *   ;
     * _1 := toY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B).toA1;
     * _0.toA := _1;
     * }
     * 
     */
    protected boolean MAP_uD_1_toA(final /*@NonNull*/ /*@NonInvalid*/ Z z_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_3.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_1 = idResolver.getClass(CLSSid_Y1, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_3.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_D_0));
        final /*@Nullable*/ /*@Thrown*/ Y toY_0 = z_3.getToY();
        final /*@NonNull*/ /*@Thrown*/ Y1 oclAsType_0 = ClassUtil.nonNullState((Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, toY_0, TYP_source_c_c_Y1_1));
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ B oclAsType_1 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_B_0));
        final /*@Nullable*/ /*@Thrown*/ A1 toA1 = oclAsType_1.getToA1();
        // property assignments
        oclAsType.setToA(toA1);
        return true;
    }
    
    /**
     * 
     * map uD_1_refsB in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (z : source::Z[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * toY.oclIsKindOf(source::Y1)
     *   )
     * {_0 : target::D[1];
     * _1 : target::B[?];
     *  |
     * _0 := z.ast.oclAsType(target::D)
     *   ;
     * _1 := if refers = null
     *   then null
     *   else
     *     refers.ast.oclAsType(target::NamedElement)
     *     .oclAsType(target::B)
     *   endif;
     * _0.refsB := _1;
     * }
     * 
     */
    protected boolean MAP_uD_1_refsB(final /*@NonNull*/ /*@NonInvalid*/ Z z_4) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_4.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        final /*@Nullable*/ /*@Thrown*/ PathNameCS refers = z_4.getRefers();
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_4.getAst();
        final /*@NonNull*/ /*@Thrown*/ D oclAsType = ClassUtil.nonNullState((D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_D_0));
        final /*@Thrown*/ boolean eq = refers == null;
        /*@Nullable*/ /*@Thrown*/ B symbol_0;
        if (eq) {
            symbol_0 = null;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_NamedElement_0 = idResolver.getClass(CLSSid_NamedElement, null);
            if (refers == null) {
                throwNull(z_4, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = refers.getAst();
            final /*@NonNull*/ /*@Thrown*/ NamedElement oclAsType_0 = ClassUtil.nonNullState((NamedElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_target_c_c_NamedElement_0));
            final /*@NonNull*/ /*@Thrown*/ B oclAsType_1 = ClassUtil.nonNullState((B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_0, TYP_target_c_c_B_0));
            symbol_0 = oclAsType_1;
        }
        // property assignments
        oclAsType.setRefsB(symbol_0);
        return true;
    }
    
    /**
     * 
     * map uPathElementCS_ast in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (pathElementCS : source::PathElementCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::NamedElement[?];
     *  |
     * _0 := let path : OrderedSet(source::PathElementCS) = pathName.path;
     * 
     *   in
     *     let
     *       lookupContext : target::Visitable[?] = pathName.oclContainer()
     *       .oclAsType(source::SElement)
     *       .ast.oclAsType(target::Visitable);
     * 
     *     in
     *       let first : source::PathElementCS[?] = path->at(1);
     * 
     *       in
     *         let
     *           last : source::PathElementCS[?] = path->at(path->size());
     * 
     *         in
     *           if pathElementCS = first
     *           then
     *             if pathElementCS = last
     *             then
     *               lookupContext._lookupNamedElement(pathElementCS, false)
     *             else
     *               lookupContext._lookupNamespace(pathElementCS, false)
     *             endif
     *           else
     *             let
     *               prevPathElement : source::PathElementCS[?] = path->at(
     *                 path->indexOf(pathElementCS) - 1);
     * 
     *             in
     *               if pathElementCS = last
     *               then
     *                 prevPathElement.ast.oclAsType(target::NamedElement)
     *                 ._lookupNamedElement(pathElementCS, true)
     *               else
     *                 prevPathElement.ast.oclAsType(target::NamedElement)
     *                 ._lookupNamespace(pathElementCS, true)
     *               endif
     *           endif;
     * pathElementCS.ast := _0;
     * }
     * 
     */
    protected boolean MAP_uPathElementCS_ast(final /*@NonNull*/ /*@NonInvalid*/ PathElementCS pathElementCS) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@Nullable*/ /*@Thrown*/ PathNameCS pathName = pathElementCS.getPathName();
        // variable assignments
        if (pathName == null) {
            throwNull(pathElementCS, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::PathNameCS::path\'");
        }
        final /*@NonNull*/ /*@Thrown*/ List<PathElementCS> path = pathName.getPath();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_SElement_0 = idResolver.getClass(CLSSid_SElement, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_Visitable_0 = idResolver.getClass(CLSSid_Visitable, null);
        final /*@Nullable*/ /*@Thrown*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, pathName);
        final /*@NonNull*/ /*@Thrown*/ SElement oclAsType = ClassUtil.nonNullState((SElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_source_c_c_SElement_0));
        final /*@Nullable*/ /*@Thrown*/ EObject ast = oclAsType.getAst();
        final /*@NonNull*/ /*@Thrown*/ Visitable lookupContext = ClassUtil.nonNullState((Visitable)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_Visitable_0));
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
        final /*@Nullable*/ /*@Thrown*/ PathElementCS first = (PathElementCS)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_path, INT_1);
        final /*@NonNull*/ /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
        final /*@Nullable*/ /*@Thrown*/ PathElementCS last = (PathElementCS)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_path, size);
        final /*@Thrown*/ boolean eq = pathElementCS.equals(first);
        /*@Nullable*/ /*@Thrown*/ NamedElement symbol_2;
        if (eq) {
            final /*@Thrown*/ boolean eq_0 = pathElementCS.equals(last);
            /*@Nullable*/ /*@Thrown*/ NamedElement symbol_0;
            if (eq_0) {
                LookupEnvironment _lookupEnv = new LookupEnvironment(executor,pathElementCS, ValueUtil.FALSE_VALUE);
                TargetLookupVisitor _lookupVisitor = new TargetLookupVisitor(_lookupEnv);
                EList<NamedElement> _lookupResult = lookupContext.accept(_lookupVisitor).getNamedElements();
                NamedElement _lookupNamedElement = null;
                if (_lookupResult.size() == 1) {
                    _lookupNamedElement = (NamedElement)_lookupResult.get(0);
                } else {
                    handleLookupError(pathElementCS,pathElementCS);
                };
                symbol_0 = _lookupNamedElement;
            }
            else {
                LookupEnvironment _lookupEnv_0 = new LookupEnvironment(executor,pathElementCS, ValueUtil.FALSE_VALUE);
                TargetLookupVisitor _lookupVisitor_0 = new TargetLookupVisitor(_lookupEnv_0);
                EList<NamedElement> _lookupResult_0 = lookupContext.accept(_lookupVisitor_0).getNamedElements();
                Namespace _lookupNamespace = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupNamespace = (Namespace)_lookupResult_0.get(0);
                } else {
                    handleLookupError(pathElementCS,pathElementCS);
                };
                symbol_0 = _lookupNamespace;
            }
            symbol_2 = symbol_0;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_path, pathElementCS);
            final /*@NonNull*/ /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(indexOf, INT_1);
            final /*@Nullable*/ /*@Thrown*/ PathElementCS prevPathElement = (PathElementCS)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_path, diff);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_NamedElement_1 = idResolver.getClass(CLSSid_NamedElement, null);
            if (prevPathElement == null) {
                throwNull(pathElementCS, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_1 = prevPathElement.getAst();
            final /*@NonNull*/ /*@Thrown*/ NamedElement oclAsType_1 = ClassUtil.nonNullState((NamedElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_target_c_c_NamedElement_1));
            final /*@Thrown*/ boolean eq_1 = pathElementCS.equals(last);
            /*@Nullable*/ /*@Thrown*/ NamedElement symbol_1;
            if (eq_1) {
                LookupEnvironment _lookupEnv_1 = new LookupEnvironment(executor,pathElementCS, ValueUtil.TRUE_VALUE);
                TargetLookupVisitor _lookupVisitor_1 = new TargetLookupVisitor(_lookupEnv_1);
                EList<NamedElement> _lookupResult_1 = oclAsType_1.accept(_lookupVisitor_1).getNamedElements();
                NamedElement _lookupNamedElement_0 = null;
                if (_lookupResult_1.size() == 1) {
                    _lookupNamedElement_0 = (NamedElement)_lookupResult_1.get(0);
                } else {
                    handleLookupError(pathElementCS,pathElementCS);
                };
                symbol_1 = _lookupNamedElement_0;
            }
            else {
                LookupEnvironment _lookupEnv_2 = new LookupEnvironment(executor,pathElementCS, ValueUtil.TRUE_VALUE);
                TargetLookupVisitor _lookupVisitor_2 = new TargetLookupVisitor(_lookupEnv_2);
                EList<NamedElement> _lookupResult_2 = oclAsType_1.accept(_lookupVisitor_2).getNamedElements();
                Namespace _lookupNamespace_0 = null;
                if (_lookupResult_2.size() == 1) {
                    _lookupNamespace_0 = (Namespace)_lookupResult_2.get(0);
                } else {
                    handleLookupError(pathElementCS,pathElementCS);
                };
                symbol_1 = _lookupNamespace_0;
            }
            symbol_2 = symbol_1;
        }
        // property assignments
        pathElementCS.setAst(symbol_2);
        return true;
    }
    
    /**
     * 
     * map uPathNameCS_ast in Source2Target_qvtp_qvtias {
     * 
     *   leftCS (pathNameCS : source::PathNameCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : target::NamedElement[1];
     *  |
     * _0 := path->at(
     *     path->size())
     *   .ast.oclAsType(target::NamedElement);
     * pathNameCS.ast := _0;
     * }
     * 
     */
    protected boolean MAP_uPathNameCS_ast(final /*@NonNull*/ /*@NonInvalid*/ PathNameCS pathNameCS) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_NamedElement_0 = idResolver.getClass(CLSSid_NamedElement, null);
        final /*@NonNull*/ /*@Thrown*/ List<PathElementCS> path = pathNameCS.getPath();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
        // variable assignments
        final /*@NonNull*/ /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
        final /*@Nullable*/ /*@Thrown*/ PathElementCS at = (PathElementCS)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_path, size);
        if (at == null) {
            throwNull(pathNameCS, "Null source for \'\'http://cs2as/tests/example1/sourceMM/1.0\'::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast = at.getAst();
        final /*@NonNull*/ /*@Thrown*/ NamedElement oclAsType = ClassUtil.nonNullState((NamedElement)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_target_c_c_NamedElement_0));
        // property assignments
        pathNameCS.setAst(oclAsType);
        return true;
    }
    
    /**
     * 
     * map __root__ in Source2Target_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for sRoot : source::SRoot in source::SRoot.allInstances()
     *    {
     * map cSRoot_2_TRoot {
     * sRoot := sRoot;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map cX_2_A1 {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map cX_2_A2 {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map cX_2_A3 {
     * x := x;
     * }}
     *   for sRoot : source::SRoot in source::SRoot.allInstances()
     *    {
     * map uTRoot_ownedA {
     * sRoot := sRoot;
     * }}
     *   for y1 : source::Y1 in source::Y1.allInstances()
     *    {
     * map cY1_2_B {
     * y1 := y1;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map cY2_2_C {
     * y2 := y2;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map cZ_2_D_0 {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map cZ_2_D_1 {
     * z := z;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA2_ownsC {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA3_ownsC {
     * x := x;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_0_toA {
     * z := z;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA1_name {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA1_ownsB {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA2_name {
     * x := x;
     * }}
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA3_name {
     * x := x;
     * }}
     *   for y1 : source::Y1 in source::Y1.allInstances()
     *    {
     * map uB_ownsD {
     * y1 := y1;
     * }}
     *   for y1 : source::Y1 in source::Y1.allInstances()
     *    {
     * map uB_name {
     * y1 := y1;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map uC_name {
     * y2 := y2;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map uC_ownsD {
     * y2 := y2;
     * }}
     *   for pathElementCS : source::PathElementCS in source::PathElementCS.allInstances()
     *    {
     * map uPathElementCS_ast {
     * pathElementCS := pathElementCS;
     * }}
     *   for pathNameCS : source::PathNameCS in source::PathNameCS.allInstances()
     *    {
     * map uPathNameCS_ast {
     * pathNameCS := pathNameCS;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_refsB {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_0_refsC {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_toA {
     * z := z;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_PathElementCS_0 = idResolver.getClass(CLSSid_PathElementCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_PathNameCS_0 = idResolver.getClass(CLSSid_PathNameCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_SRoot_1 = idResolver.getClass(CLSSid_SRoot, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_X_8 = idResolver.getClass(CLSSid_X, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_2 = idResolver.getClass(CLSSid_Y1, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_2 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Z_5 = idResolver.getClass(CLSSid_Z, null);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_SRoot, TYP_source_c_c_SRoot_1);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_X, TYP_source_c_c_X_8);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_15 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Y1, TYP_source_c_c_Y1_2);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_17 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Y2, TYP_source_c_c_Y2_2);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Z, TYP_source_c_c_Z_5);
        // mapping statements
        for (SRoot sRoot_3 : ValueUtil.typedIterable(SRoot.class, allInstances_3)) {
            if (sRoot_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_0 = (SRoot)sRoot_3;
                MAP_cSRoot_2_TRoot(symbol_0);
            }
        }
        for (X x_17 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_17 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_3 = (X)x_17;
                MAP_cX_2_A1(symbol_3);
            }
        }
        for (X x_18 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_18 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_6 = (X)x_18;
                MAP_cX_2_A2(symbol_6);
            }
        }
        for (X x_19 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_19 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_9 = (X)x_19;
                MAP_cX_2_A3(symbol_9);
            }
        }
        for (SRoot sRoot_4 : ValueUtil.typedIterable(SRoot.class, allInstances_3)) {
            if (sRoot_4 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_12 = (SRoot)sRoot_4;
                MAP_uTRoot_ownedA(symbol_12);
            }
        }
        for (Y1 y1_5 : ValueUtil.typedIterable(Y1.class, allInstances_15)) {
            if (y1_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_15 = (Y1)y1_5;
                MAP_cY1_2_B(symbol_15);
            }
        }
        for (Y2 y2_5 : ValueUtil.typedIterable(Y2.class, allInstances_17)) {
            if (y2_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_18 = (Y2)y2_5;
                MAP_cY2_2_C(symbol_18);
            }
        }
        for (Z z_11 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_11 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_21 = (Z)z_11;
                MAP_cZ_2_D_0(symbol_21);
            }
        }
        for (Z z_12 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_12 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_24 = (Z)z_12;
                MAP_cZ_2_D_1(symbol_24);
            }
        }
        for (X x_20 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_20 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_27 = (X)x_20;
                MAP_uA2_ownsC(symbol_27);
            }
        }
        for (X x_21 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_21 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_30 = (X)x_21;
                MAP_uA3_ownsC(symbol_30);
            }
        }
        for (Z z_13 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_13 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_33 = (Z)z_13;
                MAP_uD_0_toA(symbol_33);
            }
        }
        for (X x_22 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_22 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_36 = (X)x_22;
                MAP_uA1_name(symbol_36);
            }
        }
        for (X x_23 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_23 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_39 = (X)x_23;
                MAP_uA1_ownsB(symbol_39);
            }
        }
        for (X x_24 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_24 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_42 = (X)x_24;
                MAP_uA2_name(symbol_42);
            }
        }
        for (X x_25 : ValueUtil.typedIterable(X.class, allInstances_1)) {
            if (x_25 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_45 = (X)x_25;
                MAP_uA3_name(symbol_45);
            }
        }
        for (Y1 y1_6 : ValueUtil.typedIterable(Y1.class, allInstances_15)) {
            if (y1_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_48 = (Y1)y1_6;
                MAP_uB_ownsD(symbol_48);
            }
        }
        for (Y1 y1_7 : ValueUtil.typedIterable(Y1.class, allInstances_15)) {
            if (y1_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_51 = (Y1)y1_7;
                MAP_uB_name(symbol_51);
            }
        }
        for (Y2 y2_6 : ValueUtil.typedIterable(Y2.class, allInstances_17)) {
            if (y2_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_54 = (Y2)y2_6;
                MAP_uC_name(symbol_54);
            }
        }
        for (Y2 y2_7 : ValueUtil.typedIterable(Y2.class, allInstances_17)) {
            if (y2_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_57 = (Y2)y2_7;
                MAP_uC_ownsD(symbol_57);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_19 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PathElementCS, TYP_source_c_c_PathElementCS_0);
        for (PathElementCS pathElementCS_1 : ValueUtil.typedIterable(PathElementCS.class, allInstances_19)) {
            if (pathElementCS_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PathElementCS symbol_60 = (PathElementCS)pathElementCS_1;
                MAP_uPathElementCS_ast(symbol_60);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_20 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PathNameCS, TYP_source_c_c_PathNameCS_0);
        for (PathNameCS pathNameCS_1 : ValueUtil.typedIterable(PathNameCS.class, allInstances_20)) {
            if (pathNameCS_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PathNameCS symbol_63 = (PathNameCS)pathNameCS_1;
                MAP_uPathNameCS_ast(symbol_63);
            }
        }
        for (Z z_14 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_14 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_66 = (Z)z_14;
                MAP_uD_1_refsB(symbol_66);
            }
        }
        for (Z z_15 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_15 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_69 = (Z)z_15;
                MAP_uD_0_refsC(symbol_69);
            }
        }
        for (Z z_16 : ValueUtil.typedIterable(Z.class, allInstances_7)) {
            if (z_16 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_72 = (Z)z_16;
                MAP_uD_1_toA(symbol_72);
            }
        }
        return true;
    }
}
