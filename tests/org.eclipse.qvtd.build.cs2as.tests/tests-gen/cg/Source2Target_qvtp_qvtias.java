/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import example1.env.Environment;
import example1.env.EnvironmentPackage;
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
import example1.target.TRoot;
import example1.target.TargetFactory;
import example1.target.TargetPackage;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;

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
public class Source2Target_qvtp_qvtias extends AbstractTransformationExecutor
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
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
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("Environment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("SRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_X = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("X", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y1", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Y2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Y2", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Z = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_sourceMM_s_1_0.getClassId("Z", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId COL_CLSSid_NamedElement = TypeId.COLLECTION.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_X = TypeId.ORDERED_SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Y = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Y);
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_namedElements = CLSSid_Environment.getPropertyId("namedElements");
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_parentEnv = CLSSid_Environment.getPropertyId("parentEnv");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_A = TypeId.SEQUENCE.getSpecializedId(CLSSid_A);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_B = TypeId.SEQUENCE.getSpecializedId(CLSSid_B);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_C = TypeId.SEQUENCE.getSpecializedId(CLSSid_C);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_NamedElement = TypeId.SEQUENCE.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y1 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y1);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y2 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y2);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_SRoot = TypeId.SET.getSpecializedId(CLSSid_SRoot);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_X = TypeId.SET.getSpecializedId(CLSSid_X);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y1 = TypeId.SET.getSpecializedId(CLSSid_Y1);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y2 = TypeId.SET.getSpecializedId(CLSSid_Y2);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Z = TypeId.SET.getSpecializedId(CLSSid_Z);
    
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_SRoot,		// 0 => SRoot
        CLSSid_X,		// 1 => X
        CLSSid_Y1,		// 2 => Y1
        CLSSid_Y2,		// 3 => Y2
        CLSSid_Z		// 4 => Z
    };
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},		// 0 : SRoot -> {SRoot}
        {1},		// 1 : X -> {X}
        {2},		// 2 : Y1 -> {Y1}
        {3},		// 3 : Y2 -> {Y2}
        {4}		// 4 : Z -> {Z}
    };
    
    public Source2Target_qvtp_qvtias(final /*@NonNull*/ Evaluator evaluator) {
        super(evaluator, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() {
        return __root__();
    }
    
    /**
     * 
     * map cSRoot_2_TRoot in Source2Target_qvtp_qvtias) {
     * leftCS (sRoot : source::SRoot;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize tRoot : target::TRoot;
     *  |
     * }
     * where ( |
     * )
     * { |
     * sRoot = tRoot;
     * }
     * 
     * }
     */
    protected boolean cSRoot_2_TRoot(final /*@NonNull*/ /*@NonInvalid*/ SRoot sRoot) {
        // predicates
        // creations
        final /*@Thrown*/ TRoot tRoot = TargetFactory.eINSTANCE.createTRoot();
        assert tRoot != null;
        modelObjects[1/*rightAS*/].add(tRoot);
        // assignments
        sRoot.setAst(tRoot);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cX_2_A3 in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize a3 : target::A3;
     *  |
     * }
     * where ( |
     * not disambiguatesToA1()
     *   not disambiguatesToA2())
     * { |
     * x = a3;
     * }
     * 
     * }
     */
    protected boolean cX_2_A3(final /*@NonNull*/ /*@NonInvalid*/ X x) {
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
        modelObjects[1/*rightAS*/].add(a3);
        // assignments
        x.setAst(a3);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cX_2_A2 in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize a2 : target::A2;
     *  |
     * }
     * where ( |
     * not disambiguatesToA1()
     *   disambiguatesToA2())
     * { |
     * x = a2;
     * }
     * 
     * }
     */
    protected boolean cX_2_A2(final /*@NonNull*/ /*@NonInvalid*/ X x_0) {
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
        modelObjects[1/*rightAS*/].add(a2);
        // assignments
        x_0.setAst(a2);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cX_2_A1 in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize a1 : target::A1;
     *  |
     * }
     * where ( |
     * disambiguatesToA1())
     * { |
     * x = a1;
     * }
     * 
     * }
     */
    protected boolean cX_2_A1(final /*@NonNull*/ /*@NonInvalid*/ X x_1) {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_1.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A1 a1 = TargetFactory.eINSTANCE.createA1();
        assert a1 != null;
        modelObjects[1/*rightAS*/].add(a1);
        // assignments
        x_1.setAst(a1);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cY1_2_B in Source2Target_qvtp_qvtias) {
     * leftCS (y1 : source::Y1;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize b : target::B;
     *  |
     * }
     * where ( |
     * )
     * { |
     * y1 = b;
     * }
     * 
     * }
     */
    protected boolean cY1_2_B(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1) {
        // predicates
        // creations
        final /*@Thrown*/ B b = TargetFactory.eINSTANCE.createB();
        assert b != null;
        modelObjects[1/*rightAS*/].add(b);
        // assignments
        y1.setAst(b);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cY2_2_C in Source2Target_qvtp_qvtias) {
     * leftCS (y2 : source::Y2;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize c : target::C;
     *  |
     * }
     * where ( |
     * )
     * { |
     * y2 = c;
     * }
     * 
     * }
     */
    protected boolean cY2_2_C(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2) {
        // predicates
        // creations
        final /*@Thrown*/ C c = TargetFactory.eINSTANCE.createC();
        assert c != null;
        modelObjects[1/*rightAS*/].add(c);
        // assignments
        y2.setAst(c);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cZ_2_D_0 in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize d : target::D;
     *  |
     * }
     * where ( |
     * not toY.oclIsKindOf(source::Y1))
     * { |
     * z = d;
     * }
     * 
     * }
     */
    protected boolean cZ_2_D_0(final /*@NonNull*/ /*@NonInvalid*/ Z z) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ D d = TargetFactory.eINSTANCE.createD();
        assert d != null;
        modelObjects[1/*rightAS*/].add(d);
        // assignments
        z.setAst(d);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cZ_2_D_1 in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize d : target::D;
     *  |
     * }
     * where ( |
     * toY.oclIsKindOf(source::Y1))
     * { |
     * z = d;
     * }
     * 
     * }
     */
    protected boolean cZ_2_D_1(final /*@NonNull*/ /*@NonInvalid*/ Z z_0) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_0.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        // creations
        final /*@Thrown*/ D d = TargetFactory.eINSTANCE.createD();
        assert d != null;
        modelObjects[1/*rightAS*/].add(d);
        // assignments
        z_0.setAst(d);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uTRoot_ownedA in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (sRoot : source::SRoot;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * sRoot.ast.oclAsType(target::TRoot)
     *    = ownedX.ast.oclAsType(target::A);
     * }
     * 
     * }
     */
    protected boolean uTRoot_ownedA(final /*@NonNull*/ /*@NonInvalid*/ SRoot sRoot_0) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = sRoot_0.getAst();
        final /*@Nullable*/ /*@Thrown*/ TRoot oclAsType = (TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_TRoot_0);
        final /*@Nullable*/ /*@Thrown*/ List<X> ownedX = sRoot_0.getOwnedX();
        assert ownedX != null;
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
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@Nullable*/ /*@Thrown*/ A oclAsType_0 = (A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_A_0);
            //
            accumulator.add(oclAsType_0);
        }
        final List<A> UNBOXED_collect = collect.asEcoreObjects(idResolver, A.class);
        assert UNBOXED_collect != null;
        oclAsType.getOwnedA().addAll(UNBOXED_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uA3_ownsC in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * not disambiguatesToA1()
     *   not disambiguatesToA2()
     *   )
     * { |
     * x.ast.oclAsType(target::A3)
     *    = ownsY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C);
     * }
     * 
     * }
     */
    protected boolean uA3_ownsC(final /*@NonNull*/ /*@NonInvalid*/ X x_2) {
        // predicates
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
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A3_0 = idResolver.getClass(CLSSid_A3, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_2.getAst();
        final /*@Nullable*/ /*@Thrown*/ A3 oclAsType = (A3)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_A3_0);
        final /*@Nullable*/ /*@Thrown*/ List<Y> ownsY = x_2.getOwnsY();
        assert ownsY != null;
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
            final /*@Nullable*/ /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, _1, TYP_source_c_c_Y2_0);
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_C);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y2 _1_0 = (Y2)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::C)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@Nullable*/ /*@Thrown*/ C oclAsType_1 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
            //
            accumulator_0.add(oclAsType_1);
        }
        final List<C> UNBOXED_collect = collect.asEcoreObjects(idResolver, C.class);
        assert UNBOXED_collect != null;
        oclAsType.getOwnsC().addAll(UNBOXED_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uA2_ownsC in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * not disambiguatesToA1()
     *   disambiguatesToA2()
     *   )
     * { |
     * x.ast.oclAsType(target::A2)
     *    = ownsY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C);
     * }
     * 
     * }
     */
    protected boolean uA2_ownsC(final /*@NonNull*/ /*@NonInvalid*/ X x_3) {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA2 = x_3.isIsA2();
        if (isA2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_3.isIsA1();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_3.getAst();
        final /*@Nullable*/ /*@Thrown*/ A2 oclAsType = (A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_A2_0);
        final /*@Nullable*/ /*@Thrown*/ List<Y> ownsY = x_3.getOwnsY();
        assert ownsY != null;
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
            final /*@Nullable*/ /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, _1, TYP_source_c_c_Y2_0);
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_C);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y2 _1_0 = (Y2)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::C)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@Nullable*/ /*@Thrown*/ C oclAsType_1 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
            //
            accumulator_0.add(oclAsType_1);
        }
        final List<C> UNBOXED_collect = collect.asEcoreObjects(idResolver, C.class);
        assert UNBOXED_collect != null;
        oclAsType.getOwnsC().addAll(UNBOXED_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uA1_ownsB in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (x : source::X;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * disambiguatesToA1()
     *   )
     * { |
     * x.ast.oclAsType(target::A1)
     *    = ownsY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B);
     * }
     * 
     * }
     */
    protected boolean uA1_ownsB(final /*@NonNull*/ /*@NonInvalid*/ X x_4) {
        // predicates
        final /*@Nullable*/ /*@Thrown*/ Boolean isA1 = x_4.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A1_0 = idResolver.getClass(CLSSid_A1, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = x_4.getAst();
        final /*@Nullable*/ /*@Thrown*/ A1 oclAsType = (A1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_A1_0);
        final /*@Nullable*/ /*@Thrown*/ List<Y> ownsY = x_4.getOwnsY();
        assert ownsY != null;
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
            final /*@Nullable*/ /*@Thrown*/ Y1 oclAsType_0 = (Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, _1, TYP_source_c_c_Y1_0);
            //
            accumulator.add(oclAsType_0);
        }
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ Y1 _1_0 = (Y1)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::B)
             */
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final /*@Nullable*/ /*@Thrown*/ B oclAsType_1 = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_B_0);
            //
            accumulator_0.add(oclAsType_1);
        }
        final List<B> UNBOXED_collect = collect.asEcoreObjects(idResolver, B.class);
        assert UNBOXED_collect != null;
        oclAsType.getOwnsB().addAll(UNBOXED_collect);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uB_ownsD in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (y1 : source::Y1;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * y1.ast.oclAsType(target::B)
     *    = ownsZ.ast.oclAsType(target::D);
     * }
     * 
     * }
     */
    protected boolean uB_ownsD(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1_0) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y1_0.getAst();
        final /*@Nullable*/ /*@Thrown*/ B oclAsType = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_B_0);
        final /*@Nullable*/ /*@Thrown*/ Z ownsZ = y1_0.getOwnsZ();
        if (ownsZ == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType_0 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_D_0);
        oclAsType.setOwnsD(oclAsType_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uB_name in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (y1 : source::Y1;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * y1.ast.oclAsType(target::B) = name;
     * }
     * 
     * }
     */
    protected boolean uB_name(final /*@NonNull*/ /*@NonInvalid*/ Y1 y1_1) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y1_1.getAst();
        final /*@Nullable*/ /*@Thrown*/ B oclAsType = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_B_0);
        final /*@Nullable*/ /*@Thrown*/ String name = y1_1.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uC_ownsD in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (y2 : source::Y2;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * y2.ast.oclAsType(target::C)
     *    = ownsZ.ast.oclAsType(target::D);
     * }
     * 
     * }
     */
    protected boolean uC_ownsD(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2_0) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y2_0.getAst();
        final /*@Nullable*/ /*@Thrown*/ C oclAsType = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_C_0);
        final /*@Nullable*/ /*@Thrown*/ Z ownsZ = y2_0.getOwnsZ();
        if (ownsZ == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType_0 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_D_0);
        oclAsType.setOwnsD(oclAsType_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uC_name in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (y2 : source::Y2;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * y2.ast.oclAsType(target::C) = name;
     * }
     * 
     * }
     */
    protected boolean uC_name(final /*@NonNull*/ /*@NonInvalid*/ Y2 y2_1) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = y2_1.getAst();
        final /*@Nullable*/ /*@Thrown*/ C oclAsType = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_C_0);
        final /*@Nullable*/ /*@Thrown*/ String name = y2_1.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_0_toA in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D)
     *    = toY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C).toA2;
     * }
     * 
     * }
     */
    protected boolean uD_0_toA(final /*@NonNull*/ /*@NonInvalid*/ Z z_1) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_1.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_1.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final /*@Nullable*/ /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y2_0);
        if (oclAsType_0 == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final /*@Nullable*/ /*@Thrown*/ C oclAsType_1 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
        if (oclAsType_1 == null) {
            throw new InvalidValueException("Null source for \'target::C::toA2\'");
        }
        final /*@Nullable*/ /*@Thrown*/ A2 toA2 = oclAsType_1.getToA2();
        oclAsType.setToA(toA2);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_0_name in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D) = name;
     * }
     * 
     * }
     */
    protected boolean uD_0_name(final /*@NonNull*/ /*@NonInvalid*/ Z z_2) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_2.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_2.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final /*@Nullable*/ /*@Thrown*/ String name = z_2.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_0_refsC in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D)
     *    = if name.oclIsUndefined()
     *   then null
     *   else
     *     toY.oclAsType(source::Y2)
     *     .ast.oclAsType(target::C)
     *     .env()
     *     .lookupC(name)
     *   endif;
     * }
     * 
     * }
     */
    protected boolean uD_0_refsC(final /*@NonNull*/ /*@NonInvalid*/ Z z_3) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_3.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_3.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        /*@Nullable*/ /*@Caught*/ Object CAUGHT_name;
        try {
            final /*@Nullable*/ /*@Thrown*/ String name = z_3.getName();
            CAUGHT_name = name;
        }
        catch (Exception e) {
            CAUGHT_name = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_name == null) || (CAUGHT_name instanceof InvalidValueException);
        /*@Nullable*/ /*@Thrown*/ C symbol_5;
        if (symbol_0) {
            symbol_5 = null;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            final /*@Nullable*/ /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y2_0);
            if (oclAsType_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
            final /*@Nullable*/ /*@Thrown*/ C self_0 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
            final /*@Nullable*/ /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_0);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
            final /*@Nullable*/ /*@Thrown*/ A2 self_1 = (A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_target_c_c_A2_0);
            if (self_1 == null) {
                throw new InvalidValueException("Null source for \'target::A2::ownsC\'");
            }
            final /*@Nullable*/ /*@Thrown*/ List<C> ownedCs = self_1.getOwnsC();
            assert ownedCs != null;
            final /*@Nullable*/ /*@Thrown*/ Object parent_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_1);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
            final /*@Nullable*/ /*@Thrown*/ TRoot self_2 = (TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent_0, TYP_target_c_c_TRoot_0);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@NonInvalid*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_1 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@Thrown*/ Environment symbol_2 = (Environment)TYP_env_c_c_Environment_1.createInstance();
            CTORid_parentEnv.initValue(symbol_2, symbol_1);
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedCs = idResolver.createOrderedSetOfAll(ORD_CLSSid_C, ownedCs);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
            /*@Nullable*/ Iterator<?> ITERATOR_x_5 = BOXED_ownedCs.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue elements;
            while (true) {
                if (!ITERATOR_x_5.hasNext()) {
                    elements = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ C x_5 = (C)ITERATOR_x_5.next();
                /**
                 * _'<' : Boolean
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedCs, x_5);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedCs, self_0);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(evaluator, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x_5);
                }
            }
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_2 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
            final /*@NonNull*/ /*@Thrown*/ Environment symbol_3 = (Environment)TYP_env_c_c_Environment_2.createInstance();
            final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements = symbol_2.getNamedElements();
            assert namedElements != null;
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
            final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
            final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, elements);
            final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll != null;
            CTORid_namedElements.initValue(symbol_3, UNBOXED_includingAll);
            final /*@Nullable*/ /*@Thrown*/ String name_0 = z_3.getName();
            final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements_1 = symbol_3.getNamedElements();
            assert namedElements_1 != null;
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_1);
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements_1, TYP_target_c_c_C_0);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    select = accumulator_0;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ C _1 = (C)ITERATOR__1.next();
                /**
                 * _'=' : Boolean
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'target::NamedElement::name\'");
                }
                final /*@Nullable*/ /*@Thrown*/ String name_1 = _1.getName();
                final /*@Thrown*/ boolean eq = (name_1 != null) ? name_1.equals(name_0) : (name_0 == null);
                //
                if (eq == ValueUtil.TRUE_VALUE) {
                    accumulator_0.add(_1);
                }
            }
            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
            /*@Nullable*/ /*@Thrown*/ C symbol_4;
            if (isEmpty) {
                symbol_4 = null;
            }
            else {
                /*@Nullable*/ Iterator<?> ITERATOR__1_0 = select.iterator();
                /*@Nullable*/ /*@Thrown*/ C any;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        throw new InvalidValueException("No matching content for 'any'");
                    }
                    /*@Nullable*/ /*@NonInvalid*/ C _1_0 = (C)ITERATOR__1_0.next();
                    /**
                     * _'null' : Boolean
                     */
                    //
                    if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
                        any = _1_0;
                        break;
                    }
                }
                symbol_4 = any;
            }
            symbol_5 = symbol_4;
        }
        oclAsType.setRefsC(symbol_5);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_1_toA in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D)
     *    = toY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B).toA1;
     * }
     * 
     * }
     */
    protected boolean uD_1_toA(final /*@NonNull*/ /*@NonInvalid*/ Z z_4) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_4.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_4.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final /*@Nullable*/ /*@Thrown*/ Y1 oclAsType_0 = (Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0);
        if (oclAsType_0 == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final /*@Nullable*/ /*@Thrown*/ B oclAsType_1 = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_B_0);
        if (oclAsType_1 == null) {
            throw new InvalidValueException("Null source for \'target::B::toA1\'");
        }
        final /*@Nullable*/ /*@Thrown*/ A1 toA1 = oclAsType_1.getToA1();
        oclAsType.setToA(toA1);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_1_name in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D) = name;
     * }
     * 
     * }
     */
    protected boolean uD_1_name(final /*@NonNull*/ /*@NonInvalid*/ Z z_5) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_5.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_5.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final /*@Nullable*/ /*@Thrown*/ String name = z_5.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uD_1_refsB in Source2Target_qvtp_qvtias) {
     * 
     *   leftCS (z : source::Z;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z.ast.oclAsType(target::D)
     *    = if name.oclIsUndefined()
     *   then null
     *   else
     *     toY.oclAsType(source::Y1)
     *     .ast.oclAsType(target::B)
     *     .env()
     *     .lookupB(name)
     *   endif;
     * }
     * 
     * }
     */
    protected boolean uD_1_refsB(final /*@NonNull*/ /*@NonInvalid*/ Z z_6) {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final /*@Nullable*/ /*@Thrown*/ Y toY = z_6.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        if (!oclIsKindOf) {
            return false;
        }
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = z_6.getAst();
        final /*@Nullable*/ /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        /*@Nullable*/ /*@Caught*/ Object CAUGHT_name;
        try {
            final /*@Nullable*/ /*@Thrown*/ String name = z_6.getName();
            CAUGHT_name = name;
        }
        catch (Exception e) {
            CAUGHT_name = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_name == null) || (CAUGHT_name instanceof InvalidValueException);
        /*@Nullable*/ /*@Thrown*/ B symbol_5;
        if (symbol_0) {
            symbol_5 = null;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            final /*@Nullable*/ /*@Thrown*/ Y1 oclAsType_0 = (Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0);
            if (oclAsType_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
            final /*@Nullable*/ /*@Thrown*/ B self_0 = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_B_0);
            final /*@Nullable*/ /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_0);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_A1_0 = idResolver.getClass(CLSSid_A1, null);
            final /*@Nullable*/ /*@Thrown*/ A1 self_1 = (A1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_target_c_c_A1_0);
            if (self_1 == null) {
                throw new InvalidValueException("Null source for \'target::A1::ownsB\'");
            }
            final /*@Nullable*/ /*@Thrown*/ List<B> ownedBs = self_1.getOwnsB();
            assert ownedBs != null;
            final /*@Nullable*/ /*@Thrown*/ Object parent_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_1);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_target_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
            final /*@Nullable*/ /*@Thrown*/ TRoot self_2 = (TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent_0, TYP_target_c_c_TRoot_0);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@NonInvalid*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_1 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@Thrown*/ Environment symbol_2 = (Environment)TYP_env_c_c_Environment_1.createInstance();
            CTORid_parentEnv.initValue(symbol_2, symbol_1);
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedBs = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownedBs);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
            /*@Nullable*/ Iterator<?> ITERATOR_x_5 = BOXED_ownedBs.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue elements;
            while (true) {
                if (!ITERATOR_x_5.hasNext()) {
                    elements = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ B x_5 = (B)ITERATOR_x_5.next();
                /**
                 * _'<' : Boolean
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedBs, x_5);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedBs, self_0);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(evaluator, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x_5);
                }
            }
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_env_c_c_Environment_2 = idResolver.getClass(CLSSid_Environment, null);
            final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
            final /*@NonNull*/ /*@Thrown*/ Environment symbol_3 = (Environment)TYP_env_c_c_Environment_2.createInstance();
            final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements = symbol_2.getNamedElements();
            assert namedElements != null;
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
            final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
            final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, elements);
            final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll != null;
            CTORid_namedElements.initValue(symbol_3, UNBOXED_includingAll);
            final /*@Nullable*/ /*@Thrown*/ String name_0 = z_6.getName();
            final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements_1 = symbol_3.getNamedElements();
            assert namedElements_1 != null;
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_1);
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements_1, TYP_target_c_c_B_0);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    select = accumulator_0;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ B _1 = (B)ITERATOR__1.next();
                /**
                 * _'=' : Boolean
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'target::NamedElement::name\'");
                }
                final /*@Nullable*/ /*@Thrown*/ String name_1 = _1.getName();
                final /*@Thrown*/ boolean eq = (name_1 != null) ? name_1.equals(name_0) : (name_0 == null);
                //
                if (eq == ValueUtil.TRUE_VALUE) {
                    accumulator_0.add(_1);
                }
            }
            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
            /*@Nullable*/ /*@Thrown*/ B symbol_4;
            if (isEmpty) {
                symbol_4 = null;
            }
            else {
                /*@Nullable*/ Iterator<?> ITERATOR__1_0 = select.iterator();
                /*@Nullable*/ /*@Thrown*/ B any;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        throw new InvalidValueException("No matching content for 'any'");
                    }
                    /*@Nullable*/ /*@NonInvalid*/ B _1_0 = (B)ITERATOR__1_0.next();
                    /**
                     * _'null' : Boolean
                     */
                    //
                    if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
                        any = _1_0;
                        break;
                    }
                }
                symbol_4 = any;
            }
            symbol_5 = symbol_4;
        }
        oclAsType.setRefsB(symbol_5);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map __root__ in Source2Target_qvtp_qvtias) {
     * 
     *   where ( |
     * )
     * { |
     * }
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
     * map uA1_ownsB {
     * x := x;
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
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_refsB {
     * z := z;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map uC_ownsD {
     * y2 := y2;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map uC_name {
     * y2 := y2;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_0_refsC {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_0_toA {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_toA {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_0_name {
     * z := z;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_name {
     * z := z;
     * }}
     * }
     */
    protected boolean __root__() {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_SRoot_1 = idResolver.getClass(CLSSid_SRoot, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_X_5 = idResolver.getClass(CLSSid_X, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y1_2 = idResolver.getClass(CLSSid_Y1, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Y2_2 = idResolver.getClass(CLSSid_Y2, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_source_c_c_Z_7 = idResolver.getClass(CLSSid_Z, null);
        final /*@NonNull*/ /*@Thrown*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_SRoot, TYP_source_c_c_SRoot_1);
        final /*@NonNull*/ /*@Thrown*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_X, TYP_source_c_c_X_5);
        final /*@NonNull*/ /*@Thrown*/ SetValue allInstances_11 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Y1, TYP_source_c_c_Y1_2);
        final /*@NonNull*/ /*@Thrown*/ SetValue allInstances_14 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Y2, TYP_source_c_c_Y2_2);
        final /*@NonNull*/ /*@Thrown*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Z, TYP_source_c_c_Z_7);
        final List<SRoot> UNBOXED_allInstances_3 = allInstances_3.asEcoreObjects(idResolver, SRoot.class);
        assert UNBOXED_allInstances_3 != null;
        final List<X> UNBOXED_allInstances_1 = allInstances_1.asEcoreObjects(idResolver, X.class);
        assert UNBOXED_allInstances_1 != null;
        final List<Y1> UNBOXED_allInstances_11 = allInstances_11.asEcoreObjects(idResolver, Y1.class);
        assert UNBOXED_allInstances_11 != null;
        final List<Y2> UNBOXED_allInstances_14 = allInstances_14.asEcoreObjects(idResolver, Y2.class);
        assert UNBOXED_allInstances_14 != null;
        final List<Z> UNBOXED_allInstances_7 = allInstances_7.asEcoreObjects(idResolver, Z.class);
        assert UNBOXED_allInstances_7 != null;
        // creations
        // assignments
        // mapping statements
        ;
        for (SRoot sRoot_3 : UNBOXED_allInstances_3) {
            if (sRoot_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_1 = (SRoot)sRoot_3;
                cSRoot_2_TRoot(symbol_1);
            }
        }
        ;
        for (X x_11 : UNBOXED_allInstances_1) {
            if (x_11 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_5 = (X)x_11;
                cX_2_A1(symbol_5);
            }
        }
        ;
        for (X x_12 : UNBOXED_allInstances_1) {
            if (x_12 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_9 = (X)x_12;
                cX_2_A2(symbol_9);
            }
        }
        ;
        for (X x_13 : UNBOXED_allInstances_1) {
            if (x_13 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_13 = (X)x_13;
                cX_2_A3(symbol_13);
            }
        }
        ;
        for (SRoot sRoot_4 : UNBOXED_allInstances_3) {
            if (sRoot_4 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ SRoot symbol_17 = (SRoot)sRoot_4;
                uTRoot_ownedA(symbol_17);
            }
        }
        ;
        for (Y1 y1_5 : UNBOXED_allInstances_11) {
            if (y1_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_21 = (Y1)y1_5;
                cY1_2_B(symbol_21);
            }
        }
        ;
        for (Y2 y2_5 : UNBOXED_allInstances_14) {
            if (y2_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_25 = (Y2)y2_5;
                cY2_2_C(symbol_25);
            }
        }
        ;
        for (Z z_15 : UNBOXED_allInstances_7) {
            if (z_15 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_29 = (Z)z_15;
                cZ_2_D_0(symbol_29);
            }
        }
        ;
        for (Z z_16 : UNBOXED_allInstances_7) {
            if (z_16 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_33 = (Z)z_16;
                cZ_2_D_1(symbol_33);
            }
        }
        ;
        for (X x_14 : UNBOXED_allInstances_1) {
            if (x_14 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_37 = (X)x_14;
                uA1_ownsB(symbol_37);
            }
        }
        ;
        for (X x_15 : UNBOXED_allInstances_1) {
            if (x_15 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_41 = (X)x_15;
                uA2_ownsC(symbol_41);
            }
        }
        ;
        for (X x_16 : UNBOXED_allInstances_1) {
            if (x_16 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ X symbol_45 = (X)x_16;
                uA3_ownsC(symbol_45);
            }
        }
        ;
        for (Y1 y1_6 : UNBOXED_allInstances_11) {
            if (y1_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_49 = (Y1)y1_6;
                uB_ownsD(symbol_49);
            }
        }
        ;
        for (Y1 y1_7 : UNBOXED_allInstances_11) {
            if (y1_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y1 symbol_53 = (Y1)y1_7;
                uB_name(symbol_53);
            }
        }
        ;
        for (Z z_17 : UNBOXED_allInstances_7) {
            if (z_17 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_57 = (Z)z_17;
                uD_1_refsB(symbol_57);
            }
        }
        ;
        for (Y2 y2_6 : UNBOXED_allInstances_14) {
            if (y2_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_61 = (Y2)y2_6;
                uC_ownsD(symbol_61);
            }
        }
        ;
        for (Y2 y2_7 : UNBOXED_allInstances_14) {
            if (y2_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Y2 symbol_65 = (Y2)y2_7;
                uC_name(symbol_65);
            }
        }
        ;
        for (Z z_18 : UNBOXED_allInstances_7) {
            if (z_18 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_69 = (Z)z_18;
                uD_0_refsC(symbol_69);
            }
        }
        ;
        for (Z z_19 : UNBOXED_allInstances_7) {
            if (z_19 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_73 = (Z)z_19;
                uD_0_toA(symbol_73);
            }
        }
        ;
        for (Z z_20 : UNBOXED_allInstances_7) {
            if (z_20 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_77 = (Z)z_20;
                uD_1_toA(symbol_77);
            }
        }
        ;
        for (Z z_21 : UNBOXED_allInstances_7) {
            if (z_21 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_81 = (Z)z_21;
                uD_0_name(symbol_81);
            }
        }
        ;
        for (Z z_22 : UNBOXED_allInstances_7) {
            if (z_22 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ Z symbol_85 = (Z)z_22;
                uD_1_name(symbol_85);
            }
        }
        return true;
    }
}
