/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.UnboxedExplicitNavigationProperty;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.build.cs2as.tests.Environment;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import source.SRoot;
import source.SourcePackage;
import source.X;
import source.Y;
import source.Y1;
import source.Y2;
import source.Z;
import target.A;
import target.A1;
import target.A2;
import target.B;
import target.C;
import target.D;
import target.NamedElement;
import target.TRoot;
import target.TargetFactory;
import target.TargetPackage;

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
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/sourceMM/1.0", null, SourcePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore = IdManager.getNsURIPackageId("http://www.example.org/examples/env.ecore", null, null);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("A", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A1 = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A2 = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_B = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("B", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_C = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("C", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_D = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("D", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("NamedElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SRoot = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("SRoot", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_ocldependencyanalysis_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_X = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("X", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Y = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("Y", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Y1 = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("Y1", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Y2 = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("Y2", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Z = PACKid_http_c_s_s_ocldependencyanalysis_s_sourceMM_s_1_0.getClassId("Z", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_X = TypeId.ORDERED_SET.getSpecializedId(CLSSid_X);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Y = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Y);
    public static final @NonNull /*@NonInvalid*/ PropertyId PROPid_namedElements = CLSSid_Environment.getPropertyId("namedElements");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_A = TypeId.SEQUENCE.getSpecializedId(CLSSid_A);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_B = TypeId.SEQUENCE.getSpecializedId(CLSSid_B);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_C = TypeId.SEQUENCE.getSpecializedId(CLSSid_C);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y1 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y1);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Y2 = TypeId.SEQUENCE.getSpecializedId(CLSSid_Y2);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_SRoot = TypeId.SET.getSpecializedId(CLSSid_SRoot);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_X = TypeId.SET.getSpecializedId(CLSSid_X);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y1 = TypeId.SET.getSpecializedId(CLSSid_Y1);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Y2 = TypeId.SET.getSpecializedId(CLSSid_Y2);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Z = TypeId.SET.getSpecializedId(CLSSid_Z);
    
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
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
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0},		// 0 : SRoot -> {SRoot}
        {1},		// 1 : X -> {X}
        {2},		// 2 : Y1 -> {Y1}
        {3},		// 3 : Y2 -> {Y2}
        {4}		// 4 : Z -> {Z}
    };
    
    public Source2Target_qvtp_qvtias(final @NonNull Evaluator evaluator) {
        super(evaluator, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() {
        return __root__();
    }
    
    /**
     * ocl::OclElement::parentEnv() : env::Environment
     * 
     * 
     * let parent : OclElement = oclContainer()
     * in
     *   if parent = null
     *   then env::Environment{}
     *   else parent._env(self)
     *   endif
     */
    public @NonNull /*@NonInvalid*/ Environment parentEnv(final @NonNull /*@NonInvalid*/ Object self_2) {
        final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_2);
        final /*@Thrown*/ boolean eq = parent == null;
        @NonNull /*@Thrown*/ Environment symbol_1;
        if (eq) {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@NonInvalid*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            symbol_1 = symbol_0;
        }
        else {
            if (parent == null) {
                throw new InvalidValueException("Null source for \'OclElement::_env(OclElement) : env::Environment\'");
            }
            final @NonNull /*@Thrown*/ Environment _env = this._env(parent, self_2);
            symbol_1 = _env;
        }
        return symbol_1;
    }
    
    /**
     * ocl::OclElement::_env_B(child : OclElement) : env::Environment
     * 
     * parentEnv()
     */
    public @NonNull /*@NonInvalid*/ Environment _env_B(final @NonNull /*@NonInvalid*/ Object self_1, final @NonNull /*@NonInvalid*/ Object child_0) {
        final @NonNull /*@Thrown*/ Environment parentEnv = this.parentEnv(self_1);
        return parentEnv;
    }
    
    /**
     * ocl::OclElement::_env_C(child : OclElement) : env::Environment
     * 
     * parentEnv()
     */
    public @NonNull /*@NonInvalid*/ Environment _env_C(final @NonNull /*@NonInvalid*/ Object self_3, final @NonNull /*@NonInvalid*/ Object child_1) {
        final @NonNull /*@Thrown*/ Environment parentEnv = this.parentEnv(self_3);
        return parentEnv;
    }
    
    /**
     * ocl::OclElement::_env(child : OclElement) : env::Environment
     * 
     * _env_B(child).mergeEnv(_env_C(child))
     */
    public @NonNull /*@NonInvalid*/ Environment _env(final @NonNull /*@NonInvalid*/ Object self_0, final @NonNull /*@NonInvalid*/ Object child) {
        final @NonNull /*@Thrown*/ Environment _env_B = this._env_B(self_0, child);
        final @NonNull /*@Thrown*/ Environment _env_C = this._env_C(self_0, child);
        // FIXME Not clear if this kind of expressions will be used in the name resolution descriptions
        final @Nullable /*@Thrown*/ Environment mergeEnv = _env_B.mergeEnv(_env_C);
        if (mergeEnv == null) {
            throw new InvalidValueException("Null body for \'OclElement::_env(OclElement) : env::Environment\'");
        }
        return mergeEnv;
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
    protected boolean cSRoot_2_TRoot(final @NonNull /*@NonInvalid*/ SRoot sRoot) {
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
     * map cX_2_A2 in Source2Target_qvtp_qvtias) {
     * leftCS (x : source::X;
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
     * not isA1)
     * { |
     * x = a2;
     * }
     * 
     * }
     */
    protected boolean cX_2_A2(final @NonNull /*@NonInvalid*/ X x) {
        // predicates
        final @Nullable /*@Thrown*/ Boolean isA1 = x.isIsA1();
        final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isA1);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A2 a2 = TargetFactory.eINSTANCE.createA2();
        assert a2 != null;
        modelObjects[1/*rightAS*/].add(a2);
        // assignments
        x.setAst(a2);
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
     * isA1)
     * { |
     * x = a1;
     * }
     * map cX_2_A2 {
     * x := x;
     * }
     * }
     */
    protected boolean cX_2_A1(final @NonNull /*@NonInvalid*/ X x_0) {
        // predicates
        final @Nullable /*@Thrown*/ Boolean isA1 = x_0.isIsA1();
        if (isA1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ A1 a1 = TargetFactory.eINSTANCE.createA1();
        assert a1 != null;
        modelObjects[1/*rightAS*/].add(a1);
        // assignments
        x_0.setAst(a1);
        // mapping statements
        cX_2_A2(x_0);
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
    protected boolean cY1_2_B(final @NonNull /*@NonInvalid*/ Y1 y1) {
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
    protected boolean cY2_2_C(final @NonNull /*@NonInvalid*/ Y2 y2) {
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
     * not toY.oclIsKindOf(source::Y1)
     *   )
     * { |
     * z = d;
     * }
     * map cZ_2_D_1 {
     * z := z;
     * }
     * }
     */
    protected boolean cZ_2_D_0(final @NonNull /*@NonInvalid*/ Z z) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final @Nullable /*@Thrown*/ Y toY = z.getToY();
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0).booleanValue();
        final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
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
        cZ_2_D_1(z);
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
    protected boolean cZ_2_D_1(final @NonNull /*@NonInvalid*/ Z z_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final @Nullable /*@Thrown*/ Y toY = z_0.getToY();
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
    protected boolean uTRoot_ownedA(final @NonNull /*@NonInvalid*/ SRoot sRoot_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_TRoot_0 = idResolver.getClass(CLSSid_TRoot, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = sRoot_0.getAst();
        final @Nullable /*@Thrown*/ TRoot oclAsType = (TRoot)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_TRoot_0);
        final @Nullable /*@Thrown*/ List<X> ownedX = sRoot_0.getOwnedX();
        assert ownedX != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedX = idResolver.createOrderedSetOfAll(ORD_CLSSid_X, ownedX);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_A);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedX.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ X _1 = (X)ITERATOR__1.next();
            /**
             * ast.oclAsType(target::A)
             */
            final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_A_0 = idResolver.getClass(CLSSid_A, null);
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1.getAst();
            final @Nullable /*@Thrown*/ A oclAsType_0 = (A)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_A_0);
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
     * )
     * { |
     * x.ast.oclAsType(target::A2)
     *    = ownsY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C);
     * }
     * 
     * }
     */
    protected boolean uA2_ownsC(final @NonNull /*@NonInvalid*/ X x_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_A2_0 = idResolver.getClass(CLSSid_A2, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = x_1.getAst();
        final @Nullable /*@Thrown*/ A2 oclAsType = (A2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_A2_0);
        final @Nullable /*@Thrown*/ List<Y> ownsY = x_1.getOwnsY();
        assert ownsY != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Y2);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * oclAsType(source::Y2)
             */
            final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
            final @Nullable /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, _1, TYP_source_c_c_Y2_0);
            //
            accumulator.add(oclAsType_0);
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_C);
        @Nullable Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ Y2 _1_0 = (Y2)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::C)
             */
            final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final @Nullable /*@Thrown*/ C oclAsType_1 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
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
     * )
     * { |
     * x.ast.oclAsType(target::A1)
     *    = ownsY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B)
     *   ;
     * }
     * map uA2_ownsC {
     * x := x;
     * }
     * }
     */
    protected boolean uA1_ownsB(final @NonNull /*@NonInvalid*/ X x_2) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_A1_0 = idResolver.getClass(CLSSid_A1, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = x_2.getAst();
        final @Nullable /*@Thrown*/ A1 oclAsType = (A1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_A1_0);
        final @Nullable /*@Thrown*/ List<Y> ownsY = x_2.getOwnsY();
        assert ownsY != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownsY = idResolver.createOrderedSetOfAll(ORD_CLSSid_Y, ownsY);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Y1);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownsY.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Y _1 = (Y)ITERATOR__1.next();
            /**
             * oclAsType(source::Y1)
             */
            final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
            final @Nullable /*@Thrown*/ Y1 oclAsType_0 = (Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, _1, TYP_source_c_c_Y1_0);
            //
            accumulator.add(oclAsType_0);
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_B);
        @Nullable Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            @Nullable /*@NonInvalid*/ Y1 _1_0 = (Y1)ITERATOR__1_0.next();
            /**
             * ast.oclAsType(target::B)
             */
            final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'source::SElement::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1_0.getAst();
            final @Nullable /*@Thrown*/ B oclAsType_1 = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_B_0);
            //
            accumulator_0.add(oclAsType_1);
        }
        final List<B> UNBOXED_collect = collect.asEcoreObjects(idResolver, B.class);
        assert UNBOXED_collect != null;
        oclAsType.getOwnsB().addAll(UNBOXED_collect);
        // mapping statements
        uA2_ownsC(x_2);
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
     *    = ownsZ.ast.oclAsType(target::D)
     *   ;
     * }
     * map uB_name {
     * y1 := y1;
     * }
     * }
     */
    protected boolean uB_ownsD(final @NonNull /*@NonInvalid*/ Y1 y1_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = y1_0.getAst();
        final @Nullable /*@Thrown*/ B oclAsType = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_B_0);
        final @Nullable /*@Thrown*/ Z ownsZ = y1_0.getOwnsZ();
        if (ownsZ == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final @Nullable /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final @Nullable /*@Thrown*/ D oclAsType_0 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_D_0);
        oclAsType.setOwnsD(oclAsType_0);
        // mapping statements
        uB_name(y1_0);
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
    protected boolean uB_name(final @NonNull /*@NonInvalid*/ Y1 y1_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = y1_1.getAst();
        final @Nullable /*@Thrown*/ B oclAsType = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_B_0);
        final @Nullable /*@Thrown*/ String name = y1_1.getName();
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
    protected boolean uC_ownsD(final @NonNull /*@NonInvalid*/ Y2 y2_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = y2_0.getAst();
        final @Nullable /*@Thrown*/ C oclAsType = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_C_0);
        final @Nullable /*@Thrown*/ Z ownsZ = y2_0.getOwnsZ();
        if (ownsZ == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final @Nullable /*@Thrown*/ EObject ast_0 = ownsZ.getAst();
        final @Nullable /*@Thrown*/ D oclAsType_0 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_D_0);
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
    protected boolean uC_name(final @NonNull /*@NonInvalid*/ Y2 y2_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = y2_1.getAst();
        final @Nullable /*@Thrown*/ C oclAsType = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_C_0);
        final @Nullable /*@Thrown*/ String name = y2_1.getName();
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
     * )
     * { |
     * z.ast.oclAsType(target::D)
     *    = toY.oclAsType(source::Y2)
     *   .ast.oclAsType(target::C).toA2;
     * }
     * 
     * }
     */
    protected boolean uD_0_toA(final @NonNull /*@NonInvalid*/ Z z_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y2_0 = idResolver.getClass(CLSSid_Y2, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = z_1.getAst();
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ Y toY = z_1.getToY();
        final @Nullable /*@Thrown*/ Y2 oclAsType_0 = (Y2)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y2_0);
        if (oclAsType_0 == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final @Nullable /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final @Nullable /*@Thrown*/ C oclAsType_1 = (C)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_C_0);
        if (oclAsType_1 == null) {
            throw new InvalidValueException("Null source for \'target::C::toA2\'");
        }
        final @Nullable /*@Thrown*/ A2 toA2 = oclAsType_1.getToA2();
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
     * )
     * { |
     * z.ast.oclAsType(target::D) = name;
     * }
     * 
     * }
     */
    protected boolean uD_0_name(final @NonNull /*@NonInvalid*/ Z z_2) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = z_2.getAst();
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ String name = z_2.getName();
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
     * )
     * { |
     * z.ast.oclAsType(target::D)
     *    = ast.oclAsType(target::D)
     *   .lookupC(name)
     *   ;
     * }
     * map uD_0_toA {
     * z := z;
     * }
     *   map uD_1_toA {
     * z := z;
     * }
     *   map uD_0_name {
     * z := z;
     * }
     *   map uD_1_name {
     * z := z;
     * }
     * }
     */
    protected boolean uD_0_refsC(final @NonNull /*@NonInvalid*/ Z z_3) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        final @Nullable /*@Thrown*/ EObject ast = z_3.getAst();
        // creations
        // assignments
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ D self_4 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ String name = z_3.getName();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_C_0 = idResolver.getClass(CLSSid_C, null);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        if (self_4 == null) {
            throw new InvalidValueException("Null source for \'OclElement::_env(OclElement) : env::Environment\'");
        }
        final @NonNull /*@Thrown*/ Environment _env = this._env(self_4, null);
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, _env);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements, TYP_target_c_c_C_0);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
        @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                select = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ C _1 = (C)ITERATOR__1.next();
            /**
             * _'=' : Boolean
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'target::NamedElement::name\'");
            }
            final @Nullable /*@Thrown*/ String name_0 = _1.getName();
            final /*@Thrown*/ boolean eq = (name_0 != null) ? name_0.equals(name) : (name == null);
            //
            if (eq == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        @Nullable Iterator<?> ITERATOR__1_0 = select.iterator();
        @Nullable /*@Thrown*/ C any;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                throw new InvalidValueException("No matching content for 'any'");
            }
            @Nullable /*@NonInvalid*/ C _1_0 = (C)ITERATOR__1_0.next();
            /**
             * _'null' : Boolean
             */
            //
            if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
                any = _1_0;
                break;
            }
        }
        oclAsType.setRefsC(any);
        // mapping statements
        uD_0_toA(z_3);
        uD_1_toA(z_3);
        uD_0_name(z_3);
        uD_1_name(z_3);
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
     * )
     * { |
     * z.ast.oclAsType(target::D)
     *    = toY.oclAsType(source::Y1)
     *   .ast.oclAsType(target::B).toA1;
     * }
     * 
     * }
     */
    protected boolean uD_1_toA(final @NonNull /*@NonInvalid*/ Z z_4) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y1_0 = idResolver.getClass(CLSSid_Y1, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = z_4.getAst();
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ Y toY = z_4.getToY();
        final @Nullable /*@Thrown*/ Y1 oclAsType_0 = (Y1)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, toY, TYP_source_c_c_Y1_0);
        if (oclAsType_0 == null) {
            throw new InvalidValueException("Null source for \'source::SElement::ast\'");
        }
        final @Nullable /*@Thrown*/ EObject ast_0 = oclAsType_0.getAst();
        final @Nullable /*@Thrown*/ B oclAsType_1 = (B)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_target_c_c_B_0);
        if (oclAsType_1 == null) {
            throw new InvalidValueException("Null source for \'target::B::toA1\'");
        }
        final @Nullable /*@Thrown*/ A1 toA1 = oclAsType_1.getToA1();
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
     * )
     * { |
     * z.ast.oclAsType(target::D) = name;
     * }
     * 
     * }
     */
    protected boolean uD_1_name(final @NonNull /*@NonInvalid*/ Z z_5) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = z_5.getAst();
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ String name = z_5.getName();
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
     * )
     * { |
     * z.ast.oclAsType(target::D)
     *    = ast.oclAsType(target::D)
     *   .lookupB(name);
     * }
     * 
     * }
     */
    protected boolean uD_1_refsB(final @NonNull /*@NonInvalid*/ Z z_6) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_D_0 = idResolver.getClass(CLSSid_D, null);
        final @Nullable /*@Thrown*/ EObject ast = z_6.getAst();
        // creations
        // assignments
        final @Nullable /*@Thrown*/ D oclAsType = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ D self_4 = (D)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_target_c_c_D_0);
        final @Nullable /*@Thrown*/ String name = z_6.getName();
        final @NonNull /*@NonInvalid*/ Class TYP_target_c_c_B_0 = idResolver.getClass(CLSSid_B, null);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        if (self_4 == null) {
            throw new InvalidValueException("Null source for \'OclElement::_env(OclElement) : env::Environment\'");
        }
        final @NonNull /*@Thrown*/ Environment _env = this._env(self_4, null);
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, _env);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements, TYP_target_c_c_B_0);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
        @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue select;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                select = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ B _1 = (B)ITERATOR__1.next();
            /**
             * _'=' : Boolean
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'target::NamedElement::name\'");
            }
            final @Nullable /*@Thrown*/ String name_0 = _1.getName();
            final /*@Thrown*/ boolean eq = (name_0 != null) ? name_0.equals(name) : (name == null);
            //
            if (eq == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        @Nullable Iterator<?> ITERATOR__1_0 = select.iterator();
        @Nullable /*@Thrown*/ B any;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                throw new InvalidValueException("No matching content for 'any'");
            }
            @Nullable /*@NonInvalid*/ B _1_0 = (B)ITERATOR__1_0.next();
            /**
             * _'null' : Boolean
             */
            //
            if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
                any = _1_0;
                break;
            }
        }
        oclAsType.setRefsB(any);
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
     *   for x : source::X in source::X.allInstances()
     *    {
     * map uA1_ownsB {
     * x := x;
     * }}
     *   for y1 : source::Y1 in source::Y1.allInstances()
     *    {
     * map uB_ownsD {
     * y1 := y1;
     * }}
     *   for y2 : source::Y2 in source::Y2.allInstances()
     *    {
     * map uC_ownsD {
     * y2 := y2;
     * }}
     *   for z : source::Z in source::Z.allInstances()
     *    {
     * map uD_1_refsB {
     * z := z;
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
     * }
     */
    protected boolean __root__() {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_SRoot_1 = idResolver.getClass(CLSSid_SRoot, null);
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_X_1 = idResolver.getClass(CLSSid_X, null);
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y1_1 = idResolver.getClass(CLSSid_Y1, null);
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Y2_2 = idResolver.getClass(CLSSid_Y2, null);
        final @NonNull /*@NonInvalid*/ Class TYP_source_c_c_Z_2 = idResolver.getClass(CLSSid_Z, null);
        final @NonNull /*@Thrown*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_SRoot, TYP_source_c_c_SRoot_1);
        final @NonNull /*@Thrown*/ SetValue allInstances_5 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_X, TYP_source_c_c_X_1);
        final @NonNull /*@Thrown*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Y1, TYP_source_c_c_Y1_1);
        final @NonNull /*@Thrown*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Y2, TYP_source_c_c_Y2_2);
        final @NonNull /*@Thrown*/ SetValue allInstances_8 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Z, TYP_source_c_c_Z_2);
        final List<SRoot> UNBOXED_allInstances_1 = allInstances_1.asEcoreObjects(idResolver, SRoot.class);
        assert UNBOXED_allInstances_1 != null;
        final List<X> UNBOXED_allInstances_5 = allInstances_5.asEcoreObjects(idResolver, X.class);
        assert UNBOXED_allInstances_5 != null;
        final List<Y1> UNBOXED_allInstances_6 = allInstances_6.asEcoreObjects(idResolver, Y1.class);
        assert UNBOXED_allInstances_6 != null;
        final List<Y2> UNBOXED_allInstances_7 = allInstances_7.asEcoreObjects(idResolver, Y2.class);
        assert UNBOXED_allInstances_7 != null;
        final List<Z> UNBOXED_allInstances_8 = allInstances_8.asEcoreObjects(idResolver, Z.class);
        assert UNBOXED_allInstances_8 != null;
        // creations
        // assignments
        // mapping statements
        ;
        for (SRoot sRoot_3 : UNBOXED_allInstances_1) {
            if (sRoot_3 != null) {
                final @NonNull /*@NonInvalid*/ SRoot symbol_1 = (SRoot)sRoot_3;
                cSRoot_2_TRoot(symbol_1);
            }
        }
        ;
        for (X x_5 : UNBOXED_allInstances_5) {
            if (x_5 != null) {
                final @NonNull /*@NonInvalid*/ X symbol_5 = (X)x_5;
                cX_2_A1(symbol_5);
            }
        }
        ;
        for (SRoot sRoot_4 : UNBOXED_allInstances_1) {
            if (sRoot_4 != null) {
                final @NonNull /*@NonInvalid*/ SRoot symbol_9 = (SRoot)sRoot_4;
                uTRoot_ownedA(symbol_9);
            }
        }
        ;
        for (Y1 y1_4 : UNBOXED_allInstances_6) {
            if (y1_4 != null) {
                final @NonNull /*@NonInvalid*/ Y1 symbol_13 = (Y1)y1_4;
                cY1_2_B(symbol_13);
            }
        }
        ;
        for (Y2 y2_5 : UNBOXED_allInstances_7) {
            if (y2_5 != null) {
                final @NonNull /*@NonInvalid*/ Y2 symbol_17 = (Y2)y2_5;
                cY2_2_C(symbol_17);
            }
        }
        ;
        for (Z z_10 : UNBOXED_allInstances_8) {
            if (z_10 != null) {
                final @NonNull /*@NonInvalid*/ Z symbol_21 = (Z)z_10;
                cZ_2_D_0(symbol_21);
            }
        }
        ;
        for (X x_6 : UNBOXED_allInstances_5) {
            if (x_6 != null) {
                final @NonNull /*@NonInvalid*/ X symbol_25 = (X)x_6;
                uA1_ownsB(symbol_25);
            }
        }
        ;
        for (Y1 y1_5 : UNBOXED_allInstances_6) {
            if (y1_5 != null) {
                final @NonNull /*@NonInvalid*/ Y1 symbol_29 = (Y1)y1_5;
                uB_ownsD(symbol_29);
            }
        }
        ;
        for (Y2 y2_6 : UNBOXED_allInstances_7) {
            if (y2_6 != null) {
                final @NonNull /*@NonInvalid*/ Y2 symbol_33 = (Y2)y2_6;
                uC_ownsD(symbol_33);
            }
        }
        ;
        for (Z z_11 : UNBOXED_allInstances_8) {
            if (z_11 != null) {
                final @NonNull /*@NonInvalid*/ Z symbol_37 = (Z)z_11;
                uD_1_refsB(symbol_37);
            }
        }
        ;
        for (Y2 y2_7 : UNBOXED_allInstances_7) {
            if (y2_7 != null) {
                final @NonNull /*@NonInvalid*/ Y2 symbol_41 = (Y2)y2_7;
                uC_name(symbol_41);
            }
        }
        ;
        for (Z z_12 : UNBOXED_allInstances_8) {
            if (z_12 != null) {
                final @NonNull /*@NonInvalid*/ Z symbol_45 = (Z)z_12;
                uD_0_refsC(symbol_45);
            }
        }
        return true;
    }
}
