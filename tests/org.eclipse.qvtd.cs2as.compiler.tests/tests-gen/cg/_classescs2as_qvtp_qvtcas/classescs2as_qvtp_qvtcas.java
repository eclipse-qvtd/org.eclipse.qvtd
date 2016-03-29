/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl$CS2ASJavaCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2as_qvtp_qvtcas;

import example2.classes.ClassesFactory;
import example2.classes.ClassesPackage;
import example2.classes.Package;
import example2.classes.Root;
import example2.classes.lookup.util.ClassesLookupResult;
import example2.classes.lookup.util.ClassesLookupSolver;
import example2.classes.util.Visitable;
import example2.classescs.ClassCS;
import example2.classescs.ClassescsPackage;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PathNameCS;
import example2.classescs.RootCS;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.runtime.internal.cs2as.AbstractCS2ASTransformer;
import org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation;

/**
 * The classescs2as_qvtp_qvtcas transformation:
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
public class classescs2as_qvtp_qvtcas extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PackageCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RootCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Visitable = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
        CLSSid_ClassCS,                 // 0 => ClassCS
        CLSSid_PackageCS,               // 1 => PackageCS
        CLSSid_RootCS                   // 2 => RootCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
        {0},                    // 0 : ClassCS -> {ClassCS}
        {1},                    // 1 : PackageCS -> {PackageCS}
        {2}                     // 2 : RootCS -> {RootCS}
    };
    
    private final ClassesLookupSolver lookupSolver = new ClassesLookupSolver(executor);
    
    public classescs2as_qvtp_qvtcas(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new @NonNull String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    @Override
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * classes::Visitable::lookupPackage(segments : OrderedSet(classescs::PathElementCS)) : classes::Package[?]
     * 
     * 
     * if segments->size() = 1
     * then lookupPackage(segments->first())
     * else
     *   let
     *     qualifierSegments : OrderedSet(classescs::PathElementCS) = segments->subOrderedSet(1,
     *       segments->size() - 1)
     *   in
     *     let
     *       qualifier : ::Package[?] = lookupPackage(qualifierSegments)
     *     in qualifier?.lookupQualifiedPackage(segments->last())
     * endif
     */
    public /*@NonInvalid*/ Package lookupPackage(final /*@NonInvalid*/ example2.classes.util.@org.eclipse.jdt.annotation.NonNull Visitable self_0, final /*@NonInvalid*/ List<PathElementCS> segments) {
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments);
        final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments);
            if (aPathElementCS == null) {
                throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<Package> _lookupResult = lookupSolver._lookupPackage(self_0, name);
            Package _lookupPackage = null;
            if (_lookupResult.size() == 1) {
                _lookupPackage = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupPackage;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments, INT_1, diff);
            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_qualifierSegments != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_0, UNBOXED_qualifierSegments);
            /*@Caught*/ @Nullable Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ @NonNull Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package safe_lookupQualifiedPackage_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedPackage_source = null;
            }
            else {
                if (qualifier == null) {
                    throw new InvalidValueException("Null where non-null value required");
                }
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments);
                if (aPathElementCS_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                ClassesLookupResult<Package> _lookupResult_0 = lookupSolver._lookupQualifiedPackage(qualifier, name_0);
                Package _lookupQualifiedPackage = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupQualifiedPackage = _lookupResult_0.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_0,name_0);
                };
                safe_lookupQualifiedPackage_source = _lookupQualifiedPackage;
            }
            symbol_1 = safe_lookupQualifiedPackage_source;
        }
        return symbol_1;
    }
    
    /**
     * 
     * map __root__ in classescs2as_qvtp_qvtcas {
     *   where ( |)
     * {_'\u00ABClassCS\u00BB' : Set(classescs::ClassCS) = leftCS.objectsOfKind(classescs::ClassCS)
     *   ;
     * ji_ClassCS1 : Set(classescs::ClassCS[*|1]) = _'\u00ABClassCS\u00BB';
     * _'\u00ABPackageCS\u00BB' : Set(classescs::PackageCS) = leftCS.objectsOfKind(classescs::PackageCS)
     *   ;
     * ji_PackageCS1 : Set(classescs::PackageCS[*|1]) = _'\u00ABPackageCS\u00BB';
     * _'\u00ABRootCS\u00BB' : Set(classescs::RootCS) = leftCS.objectsOfKind(classescs::RootCS)
     *   ;
     * ji_RootCS1 : Set(classescs::RootCS[*|1]) = _'\u00ABRootCS\u00BB';
     *  |}
     * for loop0 : classescs::ClassCS in ji_ClassCS1 {
     *     call m_ClassCS_ast {
     * lClassCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in ji_PackageCS1 {
     *     call m_PackageCS_ast {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in ji_RootCS1 {
     *     call m_RootCS_ast {
     * lRootCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in ji_ClassCS1 {
     *     call m_ClassCS_ast_name {
     * lClassCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in ji_PackageCS1 {
     *     call m_PackageCS_ast_name_ownedClasses_ownedPackages {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in ji_RootCS1 {
     *     call m_RootCS_ast_ownedPackages {
     * lRootCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in ji_ClassCS1 {
     *     call m_ClassCS_ast_extends {
     * lClassCS := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_0 = idResolver.getClass(CLSSid_ClassCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue _171_ClassCS_187 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, models[0/*leftCS*/], TYP_classescs_c_c_ClassCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue _171_PackageCS_187 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, models[0/*leftCS*/], TYP_classescs_c_c_PackageCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RootCS_0 = idResolver.getClass(CLSSid_RootCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue _171_RootCS_187 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, models[0/*leftCS*/], TYP_classescs_c_c_RootCS_0);
            // connection variables
            final SetValue.@NonNull Accumulator ji_ClassCS1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ClassCS);
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS iterator : ValueUtil.typedIterable(ClassCS.class, _171_ClassCS_187)) {
                ji_ClassCS1.add(iterator);
            }
            final SetValue.@NonNull Accumulator ji_PackageCS1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS iterator_0 : ValueUtil.typedIterable(PackageCS.class, _171_PackageCS_187)) {
                ji_PackageCS1.add(iterator_0);
            }
            final SetValue.@NonNull Accumulator ji_RootCS1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_RootCS);
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS iterator_1 : ValueUtil.typedIterable(RootCS.class, _171_RootCS_187)) {
                ji_RootCS1.add(iterator_1);
            }
            // mapping statements
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS1)) {
                MAP_m_ClassCS_ast(loop0);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_0 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS1)) {
                MAP_m_PackageCS_ast(loop0_0);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS loop0_1 : ValueUtil.typedIterable(RootCS.class, ji_RootCS1)) {
                MAP_m_RootCS_ast(loop0_1);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_2 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS1)) {
                MAP_m_ClassCS_ast_name(loop0_2);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_3 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS1)) {
                MAP_m_PackageCS_ast_name_ownedClasses_ownedPackages(loop0_3);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS loop0_4 : ValueUtil.typedIterable(RootCS.class, ji_RootCS1)) {
                MAP_m_RootCS_ast_ownedPackages(loop0_4);
            }
            for (example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_5 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS1)) {
                MAP_m_ClassCS_ast_extends(loop0_5);
            }
            boolean __root__ = ValueUtil.TRUE_VALUE;
            return __root__;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP___root__", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast in classescs2as_qvtp_qvtcas {leftCS (lClassCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rClass : classes::Class[1];
     *  |}
     * where ( |)
     * { |
     * lClassCS.ast := rClass;
     * }
     * 
     */
    protected boolean MAP_m_ClassCS_ast(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class rClass = ClassesFactory.eINSTANCE.createClass();
            assert rClass != null;
            models[1/*rightAS*/].add(rClass);
            // property assignments
            lClassCS.setAst(rClass);
            boolean m_ClassCS_ast = ValueUtil.TRUE_VALUE;
            return m_ClassCS_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_extends in classescs2as_qvtp_qvtcas {
     *   leftCS (lClassCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {extends : classescs::PathNameCS[?] = lClassCS.extends;
     * ast : ecore::EObject[?] = lClassCS.ast;
     * aClass : classes::Class[1] = lClassCS.ast.oclAsType(classes::Class);
     * _'=' : Boolean[1] = extends =
     *   null;
     * superClass : classes::Class[?] = if _'='
     *   then null
     *   else aClass.lookupClass(extends)
     *   endif;
     *  |
     * aClass.superClass := superClass;
     * }
     * 
     */
    protected boolean MAP_m_ClassCS_ast_extends(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_0) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_0 = lClassCS_0.getExtends();
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lClassCS_0.getAst();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = lClassCS_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class aClass = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Class_0));
            final /*@Thrown*/ boolean eq = symbol_0 == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class superClass;
            if (eq) {
                superClass = null;
            }
            else {
                if (symbol_0 == null) {
                    throw throwNull(lClassCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = symbol_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_2;
                if (eq_0) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lClassCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(aClass, name);
                    example2.classes.Class _lookupClass = null;
                    if (_lookupResult.size() == 1) {
                        _lookupClass = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,name);
                    };
                    symbol_2 = _lookupClass;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                    final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(aClass, UNBOXED_qualifierSegments);
                    /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ @NonNull Object symbol_1 = CAUGHT_qualifier == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_1 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        if (qualifier == null) {
                            throw throwNull(lClassCS_0, "Null where non-null value required");
                        }
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lClassCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, name_0);
                        example2.classes.Class _lookupQualifiedClass = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,name_0);
                        };
                        safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                    }
                    symbol_2 = safe_lookupQualifiedClass_source;
                }
                superClass = symbol_2;
            }
            // property assignments
            aClass.setSuperClass(superClass);
            boolean m_ClassCS_ast_extends = ValueUtil.TRUE_VALUE;
            return m_ClassCS_ast_extends;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_extends", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_name in classescs2as_qvtp_qvtcas {
     *   leftCS (lClassCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lClassCS.ast;
     * name : String[?] = lClassCS.name;
     * aClass : classes::Class[1] = lClassCS.ast.oclAsType(classes::Class);
     *  |
     * aClass.name := name;
     * }
     * 
     */
    protected boolean MAP_m_ClassCS_ast_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_1) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lClassCS_1.getAst();
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lClassCS_1.getName();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = lClassCS_1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class aClass = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Class_0));
            // property assignments
            aClass.setName(name);
            boolean m_ClassCS_ast_name = ValueUtil.TRUE_VALUE;
            return m_ClassCS_ast_name;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_PackageCS_ast in classescs2as_qvtp_qvtcas {leftCS (lPackageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rPackage : classes::Package[1];
     *  |}
     * where ( |)
     * { |
     * lPackageCS.ast := rPackage;
     * }
     * 
     */
    protected boolean MAP_m_PackageCS_ast(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package rPackage = ClassesFactory.eINSTANCE.createPackage();
            assert rPackage != null;
            models[1/*rightAS*/].add(rPackage);
            // property assignments
            lPackageCS.setAst(rPackage);
            boolean m_PackageCS_ast = ValueUtil.TRUE_VALUE;
            return m_PackageCS_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PackageCS_ast", e);
        }
    }
    
    /**
     * 
     * map m_PackageCS_ast_name_ownedClasses_ownedPackages in classescs2as_qvtp_qvtcas {
     *   leftCS (lPackageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lPackageCS.ast;
     * name : String[?] = lPackageCS.name;
     * ownedClasses : OrderedSet(classescs::ClassCS) = lPackageCS.ownedClasses;
     * ownedPackages : OrderedSet(classescs::PackageCS) = lPackageCS.ownedPackages;
     * aPackage : classes::Package[1] = lPackageCS.ast.oclAsType(classes::Package)
     *   ;
     * _'\u00ABcollect\u00BB' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package))
     *   ;
     * _'\u00ABcollect\u00BB1' : Sequence(classes::Class) = ownedClasses->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Class));
     *  |
     * aPackage.name := name;
     * aPackage.ownedClasses := _'\u00ABcollect\u00BB1';
     * aPackage.ownedPackages := _'\u00ABcollect\u00BB';
     * }
     * 
     */
    protected boolean MAP_m_PackageCS_ast_name_ownedClasses_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_0) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lPackageCS_0.getAst();
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPackageCS_0.getName();
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = lPackageCS_0.getOwnedClasses();
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = lPackageCS_0.getOwnedPackages();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = lPackageCS_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package aPackage = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
            /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
            @Nullable Iterator<Object> ITERATOR__1 = BOXED_ownedPackages.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue _171_collect_187;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    _171_collect_187 = accumulator;
                    break;
                }
                /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1 = (PackageCS)ITERATOR__1.next();
                /**
                 * _'1_'.ast.oclAsType(classes::Package)
                 */
                if (_1 == null) {
                    throw throwNull(lPackageCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
                }
                final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_1 = _1.getAst();
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_classes_c_c_Package_0));
                //
                accumulator.add(oclAsType);
            }
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
            /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
            @Nullable Iterator<Object> ITERATOR__1_0 = BOXED_ownedClasses.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue _171_collect_187_1;
            while (true) {
                if (!ITERATOR__1_0.hasNext()) {
                    _171_collect_187_1 = accumulator_0;
                    break;
                }
                /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable ClassCS _1_0 = (ClassCS)ITERATOR__1_0.next();
                /**
                 * _'1_'.ast.oclAsType(classes::Class)
                 */
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                if (_1_0 == null) {
                    throw throwNull(lPackageCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
                }
                final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_2 = _1_0.getAst();
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType_0 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_2, TYP_classes_c_c_Class_0));
                //
                accumulator_0.add(oclAsType_0);
            }
            // property assignments
            aPackage.setName(name);
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Class> ECORE__171_collect_187_1 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Class.class, _171_collect_187_1);
            aPackage.getOwnedClasses().addAll(ECORE__171_collect_187_1);
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE__171_collect_187 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, _171_collect_187);
            aPackage.getOwnedPackages().addAll(ECORE__171_collect_187);
            boolean m_PackageCS_ast_name_ownedClasses_ownedPackages = ValueUtil.TRUE_VALUE;
            return m_PackageCS_ast_name_ownedClasses_ownedPackages;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PackageCS_ast_name_ownedClasses_ownedPackages", e);
        }
    }
    
    /**
     * 
     * map m_RootCS_ast in classescs2as_qvtp_qvtcas {leftCS (lRootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rRoot : classes::Root[1];
     *  |}
     * where ( |)
     * { |
     * lRootCS.ast := rRoot;
     * }
     * 
     */
    protected boolean MAP_m_RootCS_ast(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Root rRoot = ClassesFactory.eINSTANCE.createRoot();
            assert rRoot != null;
            models[1/*rightAS*/].add(rRoot);
            // property assignments
            lRootCS.setAst(rRoot);
            boolean m_RootCS_ast = ValueUtil.TRUE_VALUE;
            return m_RootCS_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_RootCS_ast", e);
        }
    }
    
    /**
     * 
     * map m_RootCS_ast_ownedPackages in classescs2as_qvtp_qvtcas {
     *   leftCS (lRootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lRootCS.ast;
     * ownedPackages : OrderedSet(classescs::PackageCS) = lRootCS.ownedPackages;
     * aRoot : classes::Root[1] = lRootCS.ast.oclAsType(classes::Root)
     *   ;
     * _'\u00ABcollect\u00BB' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package));
     *  |
     * aRoot.ownedPackages := _'\u00ABcollect\u00BB';
     * }
     * 
     */
    protected boolean MAP_m_RootCS_ast_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS_0) throws ReflectiveOperationException {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lRootCS_0.getAst();
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = lRootCS_0.getOwnedPackages();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = lRootCS_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Root aRoot = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Root_0));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
            /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
            @Nullable Iterator<Object> ITERATOR__1 = BOXED_ownedPackages.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue _171_collect_187;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    _171_collect_187 = accumulator;
                    break;
                }
                /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1 = (PackageCS)ITERATOR__1.next();
                /**
                 * _'1_'.ast.oclAsType(classes::Package)
                 */
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                if (_1 == null) {
                    throw throwNull(lRootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
                }
                final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_1 = _1.getAst();
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_classes_c_c_Package_0));
                //
                accumulator.add(oclAsType);
            }
            // property assignments
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE__171_collect_187 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, _171_collect_187);
            aRoot.getOwnedPackages().addAll(ECORE__171_collect_187);
            boolean m_RootCS_ast_ownedPackages = ValueUtil.TRUE_VALUE;
            return m_RootCS_ast_ownedPackages;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_RootCS_ast_ownedPackages", e);
        }
    }
}
