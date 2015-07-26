/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2as_qvtp_qvtias;

import example2.classes.ClassesFactory;
import example2.classes.ClassesPackage;
import example2.classes.NamedElement;
import example2.classes.Package;
import example2.classes.Root;
import example2.classes.util.Visitable;
import example2.classescs.ClassCS;
import example2.classescs.ClassescsPackage;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PathNameCS;
import example2.classescs.RootCS;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.cs2as.compiler.tests.models.example2.java.ClassesLookupVisitor;
import org.eclipse.qvtd.cs2as.compiler.tests.models.example2.java.LookupEnvironment;

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
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_RootCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Visitable = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
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
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : ClassCS -> {ClassCS}
        {1},                    // 1 : PackageCS -> {PackageCS}
        {2}                     // 2 : RootCS -> {RootCS}
    };
    
    
    public classescs2as_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * classes::Visitable::lookupPackage(pathSeq : OrderedSet(classescs::PathElementCS)) : classes::Package[?]
     * 
     * 
     * if pathSeq->size() = 1
     * then _lookupPackage(pathSeq->first())
     * else
     *   lookupPackage(
     *     pathSeq->subOrderedSet(1, pathSeq->size() - 1))
     *   ._lookupPackage(pathSeq->last())
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Package lookupPackage(final /*@NonNull*/ /*@NonInvalid*/ Visitable self_0, final /*@NonNull*/ /*@NonInvalid*/ List<PathElementCS> pathSeq) {
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ OrderedSetValue BOXED_pathSeq_3 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq);
        final /*@NonNull*/ /*@NonInvalid*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
        final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
        /*@Nullable*/ /*@Thrown*/ Package symbol_0;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
            LookupEnvironment _lookupEnv = new LookupEnvironment(executor,first);
            ClassesLookupVisitor _lookupVisitor = new ClassesLookupVisitor(_lookupEnv);
            EList<NamedElement> _lookupResult = self_0.accept(_lookupVisitor).getNamedElements();
            Package _lookupPackage = null;
            if (_lookupResult.size() == 1) {
                _lookupPackage = (Package)_lookupResult.get(0);
            } else {
                handleLookupError(pathSeq,first);
            };
            symbol_0 = _lookupPackage;
        }
        else {
            final /*@NonNull*/ /*@NonInvalid*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq_3, INT_1, diff);
            final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_subOrderedSet != null;
            final /*@Nullable*/ /*@Thrown*/ Package lookupPackage = this.lookupPackage(self_0, UNBOXED_subOrderedSet);
            final /*@Nullable*/ /*@Thrown*/ PathElementCS last = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
            LookupEnvironment _lookupEnv_0 = new LookupEnvironment(executor,last);
            ClassesLookupVisitor _lookupVisitor_0 = new ClassesLookupVisitor(_lookupEnv_0);
            EList<NamedElement> _lookupResult_0 = lookupPackage.accept(_lookupVisitor_0).getNamedElements();
            Package _lookupPackage_0 = null;
            if (_lookupResult_0.size() == 1) {
                _lookupPackage_0 = (Package)_lookupResult_0.get(0);
            } else {
                handleLookupError(pathSeq,last);
            };
            symbol_0 = _lookupPackage_0;
        }
        return symbol_0;
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
    protected boolean MAP_cClassCS_2_Class(final /*@NonNull*/ /*@NonInvalid*/ ClassCS classCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.Class symbol_0 = ClassesFactory.eINSTANCE.createClass();
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
    protected boolean MAP_cPackageCS_2_Package(final /*@NonNull*/ /*@NonInvalid*/ PackageCS packageCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
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
    protected boolean MAP_cRootCS_2_Root(final /*@NonNull*/ /*@NonInvalid*/ RootCS rootCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Root root = ClassesFactory.eINSTANCE.createRoot();
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
    protected boolean MAP_uClass_name(final /*@NonNull*/ /*@NonInvalid*/ ClassCS classCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = classCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ example2.classes.Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Nullable*/ /*@Thrown*/ String name = classCS_0.getName();
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
     * _1 := ast.oclAsType(classes::Class)
     *   .lookupClass(classCS);
     * _0.superClass := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_superClass(final /*@NonNull*/ /*@NonInvalid*/ ClassCS classCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final /*@Nullable*/ /*@Thrown*/ EObject ast = classCS_1.getAst();
        // variable assignments
        final /*@NonNull*/ /*@Thrown*/ example2.classes.Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@NonNull*/ /*@Thrown*/ example2.classes.Class self_1 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Nullable*/ /*@Thrown*/ PathNameCS symbol_0 = classCS_1.getExtends();
        final /*@Thrown*/ boolean eq = symbol_0 == null;
        /*@Nullable*/ /*@Thrown*/ example2.classes.Class symbol_3;
        if (eq) {
            symbol_3 = null;
        }
        else {
            if (symbol_0 == null) {
                throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@NonNull*/ /*@Thrown*/ List<PathElementCS> pathSeq_0 = symbol_0.getPath();
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_pathSeq_0_3 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq_0);
            final /*@NonNull*/ /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            /*@Nullable*/ /*@Thrown*/ example2.classes.Class symbol_2;
            if (eq_0) {
                final /*@Nullable*/ /*@Thrown*/ PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
                LookupEnvironment _lookupEnv = new LookupEnvironment(executor,first);
                ClassesLookupVisitor _lookupVisitor = new ClassesLookupVisitor(_lookupEnv);
                EList<NamedElement> _lookupResult = self_1.accept(_lookupVisitor).getNamedElements();
                example2.classes.Class _lookupClass = null;
                if (_lookupResult.size() == 1) {
                    _lookupClass = (example2.classes.Class)_lookupResult.get(0);
                } else {
                    handleLookupError(classCS_1,first);
                };
                symbol_2 = _lookupClass;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3, INT_1, diff);
                final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
                assert UNBOXED_subOrderedSet != null;
                final /*@Nullable*/ /*@Thrown*/ Package lookupPackage = this.lookupPackage(self_1, UNBOXED_subOrderedSet);
                final /*@Nullable*/ /*@Thrown*/ PathElementCS last = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
                LookupEnvironment _lookupEnv_0 = new LookupEnvironment(executor,last);
                ClassesLookupVisitor _lookupVisitor_0 = new ClassesLookupVisitor(_lookupEnv_0);
                EList<NamedElement> _lookupResult_0 = lookupPackage.accept(_lookupVisitor_0).getNamedElements();
                example2.classes.Class _lookupClass_0 = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupClass_0 = (example2.classes.Class)_lookupResult_0.get(0);
                } else {
                    handleLookupError(classCS_1,last);
                };
                symbol_2 = _lookupClass_0;
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
    protected boolean MAP_uPackage_name(final /*@NonNull*/ /*@NonInvalid*/ PackageCS packageCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = packageCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@Nullable*/ /*@Thrown*/ String name = packageCS_0.getName();
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
     * _1 : OrderedSet(classes::Class);
     *  |
     * _0 := packageCS.ast.oclAsType(classes::Package)
     *   ;
     * _1 := ownedClasses.ast.oclAsType(classes::Class)
     *   ->asOrderedSet();
     * _0.ownedClasses := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedClasses(final /*@NonNull*/ /*@NonInvalid*/ PackageCS packageCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = packageCS_1.getAst();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@NonNull*/ /*@Thrown*/ List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Class)
             */
            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
            if (_1 == null) {
                throwNull(packageCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ example2.classes.Class oclAsType_0 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Class_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<example2.classes.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Class.class, asOrderedSet);
        oclAsType.getOwnedClasses().addAll(ECORE_asOrderedSet);
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
     * _1 : OrderedSet(classes::Package);
     *  |
     * _0 := packageCS.ast.oclAsType(classes::Package)
     *   ;
     * _1 := ownedPackages.ast.oclAsType(classes::Package)
     *   ->asOrderedSet();
     * _0.ownedPackages := _1;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedPackages(final /*@NonNull*/ /*@NonInvalid*/ PackageCS packageCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = packageCS_2.getAst();
        final /*@NonNull*/ /*@Thrown*/ Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@NonNull*/ /*@Thrown*/ List<PackageCS> ownedPackages = packageCS_2.getOwnedPackages();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            if (_1 == null) {
                throwNull(packageCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
        oclAsType.getOwnedPackages().addAll(ECORE_asOrderedSet);
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
     * _1 : OrderedSet(classes::Package);
     *  |
     * _0 := rootCS.ast.oclAsType(classes::Root)
     *   ;
     * _1 := ownedPackages.ast.oclAsType(classes::Package)
     *   ->asOrderedSet();
     * _0.ownedPackages := _1;
     * }
     * 
     */
    protected boolean MAP_uRoot_ownedPackages(final /*@NonNull*/ /*@NonInvalid*/ RootCS rootCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = rootCS_0.getAst();
        final /*@NonNull*/ /*@Thrown*/ Root oclAsType = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Root_0));
        final /*@NonNull*/ /*@Thrown*/ List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            if (_1 == null) {
                throwNull(rootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = _1.getAst();
            final /*@NonNull*/ /*@Thrown*/ Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        // property assignments
        final /*@NonNull*/ /*@NonInvalid*/ List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
        oclAsType.getOwnedPackages().addAll(ECORE_asOrderedSet);
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
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_ClassCS_2 = idResolver.getClass(CLSSid_ClassCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_3 = idResolver.getClass(CLSSid_PackageCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_2);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_2 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_3);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
        // mapping statements
        for (RootCS rootCS_3 : ValueUtil.typedIterable(RootCS.class, allInstances_1)) {
            if (rootCS_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ RootCS symbol_0 = (RootCS)rootCS_3;
                MAP_cRootCS_2_Root(symbol_0);
            }
        }
        for (PackageCS packageCS_7 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PackageCS symbol_3 = (PackageCS)packageCS_7;
                MAP_cPackageCS_2_Package(symbol_3);
            }
        }
        for (RootCS rootCS_4 : ValueUtil.typedIterable(RootCS.class, allInstances_1)) {
            if (rootCS_4 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ RootCS symbol_6 = (RootCS)rootCS_4;
                MAP_uRoot_ownedPackages(symbol_6);
            }
        }
        for (PackageCS packageCS_8 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_8 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PackageCS symbol_9 = (PackageCS)packageCS_8;
                MAP_uPackage_name(symbol_9);
            }
        }
        for (ClassCS classCS_5 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_5 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ClassCS symbol_12 = (ClassCS)classCS_5;
                MAP_cClassCS_2_Class(symbol_12);
            }
        }
        for (PackageCS packageCS_9 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_9 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PackageCS symbol_15 = (PackageCS)packageCS_9;
                MAP_uPackage_ownedClasses(symbol_15);
            }
        }
        for (PackageCS packageCS_10 : ValueUtil.typedIterable(PackageCS.class, allInstances_2)) {
            if (packageCS_10 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PackageCS symbol_18 = (PackageCS)packageCS_10;
                MAP_uPackage_ownedPackages(symbol_18);
            }
        }
        for (ClassCS classCS_6 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_6 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ClassCS symbol_21 = (ClassCS)classCS_6;
                MAP_uClass_name(symbol_21);
            }
        }
        for (ClassCS classCS_7 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_7 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ ClassCS symbol_24 = (ClassCS)classCS_7;
                MAP_uClass_superClass(symbol_24);
            }
        }
        return true;
    }
}
