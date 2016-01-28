/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl$CS2ASJavaCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2as_qvtp_qvtias;

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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
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
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;

/**
 * The classescs2as_qvtp_qvtias transformation:
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
public class classescs2as_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new /*@NonNull*/ ClassId[]{
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
    private final static int /*@NonNull*/ [] /*@NonNull*/ [] classIndex2allClassIndexes = new int /*@NonNull*/ [] /*@NonNull*/ [] {
        {0},                    // 0 : ClassCS -> {ClassCS}
        {1},                    // 1 : PackageCS -> {PackageCS}
        {2}                     // 2 : RootCS -> {RootCS}
    };
    
    private final ClassesLookupSolver lookupSolver = new ClassesLookupSolver(executor);
    
    public classescs2as_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new /*@NonNull*/ String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
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
            /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package safe_lookupQualifiedPackage_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedPackage_source = null;
            }
            else {
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
     * map cClassCS_2_Class in classescs2as_qvtp_qvtias {
     * leftCS (classCS : classescs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize class : classes::Class[1];
     *  |}
     * where ( |)
     * { |
     * classCS.ast := class;
     * }
     * 
     */
    protected boolean MAP_cClassCS_2_Class(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_0 = ClassesFactory.eINSTANCE.createClass();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        classCS.setAst(symbol_0);
        return true;
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2as_qvtp_qvtias {
     * leftCS (packageCS : classescs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize package : classes::Package[1];
     *  |}
     * where ( |)
     * { |
     * packageCS.ast := package;
     * }
     * 
     */
    protected boolean MAP_cPackageCS_2_Package(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        packageCS.setAst(symbol_0);
        return true;
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2as_qvtp_qvtias {
     * leftCS (rootCS : classescs::RootCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize root : classes::Root[1];
     *  |}
     * where ( |)
     * { |
     * rootCS.ast := root;
     * }
     * 
     */
    protected boolean MAP_cRootCS_2_Root(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS rootCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Root root = ClassesFactory.eINSTANCE.createRoot();
        assert root != null;
        models[1/*rightAS*/].add(root);
        // property assignments
        rootCS.setAst(root);
        return true;
    }
    
    /**
     * 
     * map uClass_name in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Class[1];
     * _1 : String[?];
     *  |
     * _0 := classCS.ast.oclAsType(classes::Class);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = classCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uClass_superClass in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Class[1];
     * _1 : classes::Class[?];
     *  |
     * _0 := classCS.ast.oclAsType(classes::Class)
     *   ;
     * _1 := if extends = null
     *   then null
     *   else ast.oclAsType(classes::Class).lookupClass(extends)
     *   endif;
     * _0.superClass := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_superClass(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_1.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_0 = classCS_1.getExtends();
        final /*@Thrown*/ boolean eq = symbol_0 == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
        if (eq) {
            symbol_3 = null;
        }
        else {
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class self_1 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = classCS_1.getExtends();
            if (aPathNameCS == null) {
                throw throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_2;
            if (eq_0) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS == null) {
                    throw throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(self_1, name);
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
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_1, UNBOXED_qualifierSegments);
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                try {
                    CAUGHT_qualifier = qualifier;
                }
                catch (Exception e) {
                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_1 = CAUGHT_qualifier == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                if (symbol_1 == Boolean.TRUE) {
                    safe_lookupQualifiedClass_source = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS_0 == null) {
                        throw throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
            symbol_3 = symbol_2;
        }
        // property assignments
        oclAsType.setSuperClass(symbol_3);
        return true;
    }
    
    /**
     * 
     * map uPackage_name in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (packageCS : classescs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Package[1];
     * _1 : String[?];
     *  |
     * _0 := packageCS.ast.oclAsType(classes::Package);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = packageCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = packageCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedClasses in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (packageCS : classescs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Package[1];
     * _1 : Sequence(classes::Class);
     *  |
     * _0 := packageCS.ast.oclAsType(classes::Package)
     *   ;
     * _1 := ownedClasses.ast.oclAsType(classes::Class);
     * _0.ownedClasses := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedClasses(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = packageCS_1.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Class)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
            if (_1 == null) {
                throw throwNull(packageCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType_0 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Class_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Class> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Class.class, collect);
        oclAsType.getOwnedClasses().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedPackages in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (packageCS : classescs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Package[1];
     * _1 : Sequence(classes::Package);
     *  |
     * _0 := packageCS.ast.oclAsType(classes::Package)
     *   ;
     * _1 := ownedPackages.ast.oclAsType(classes::Package);
     * _0.ownedPackages := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = packageCS_2.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = packageCS_2.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            if (_1 == null) {
                throw throwNull(packageCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, collect);
        oclAsType.getOwnedPackages().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2as_qvtp_qvtias {
     * 
     *   leftCS (rootCS : classescs::RootCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Root[1];
     * _1 : Sequence(classes::Package);
     *  |
     * _0 := rootCS.ast.oclAsType(classes::Root)
     *   ;
     * _1 := ownedPackages.ast.oclAsType(classes::Package);
     * _0.ownedPackages := _1;
     * }
     * 
     */
    protected boolean MAP_uRoot_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS rootCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = rootCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Root oclAsType = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Root_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            if (_1 == null) {
                throw throwNull(rootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, collect);
        oclAsType.getOwnedPackages().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map __root__ in classescs2as_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * map cRootCS_2_Root {
     * rootCS := rootCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map cPackageCS_2_Package {
     * packageCS := packageCS;
     * }}
     *   for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * map uRoot_ownedPackages {
     * rootCS := rootCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_name {
     * packageCS := packageCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map cClassCS_2_Class {
     * classCS := classCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_ownedClasses {
     * packageCS := packageCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_ownedPackages {
     * packageCS := packageCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_name {
     * classCS := classCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_superClass {
     * classCS := classCS;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_2 = idResolver.getClass(CLSSid_ClassCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_3 = idResolver.getClass(CLSSid_PackageCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_2);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_2 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_3);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
        for (RootCS rootCS_3 : ValueUtil.typedIterable(RootCS.class, allInstances_1)) {
            if (rootCS_3 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_0 = (RootCS)rootCS_3;
                MAP_cRootCS_2_Root(symbol_0);
            }
        }
        for (PackageCS packageCS_7 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_7 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_3 = (PackageCS)packageCS_7;
                MAP_cPackageCS_2_Package(symbol_3);
            }
        }
        for (RootCS rootCS_4 : ValueUtil.typedIterable(RootCS.class, allInstances_1)) {
            if (rootCS_4 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_6 = (RootCS)rootCS_4;
                MAP_uRoot_ownedPackages(symbol_6);
            }
        }
        for (PackageCS packageCS_8 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_8 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_9 = (PackageCS)packageCS_8;
                MAP_uPackage_name(symbol_9);
            }
        }
        for (ClassCS classCS_5 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_5 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_12 = (ClassCS)classCS_5;
                MAP_cClassCS_2_Class(symbol_12);
            }
        }
        for (PackageCS packageCS_9 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_9 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_15 = (PackageCS)packageCS_9;
                MAP_uPackage_ownedClasses(symbol_15);
            }
        }
        for (PackageCS packageCS_10 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_10 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_18 = (PackageCS)packageCS_10;
                MAP_uPackage_ownedPackages(symbol_18);
            }
        }
        for (ClassCS classCS_6 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_6 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_21 = (ClassCS)classCS_6;
                MAP_uClass_name(symbol_21);
            }
        }
        for (ClassCS classCS_7 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_7 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_24 = (ClassCS)classCS_7;
                MAP_uClass_superClass(symbol_24);
            }
        }
        return true;
    }
}
