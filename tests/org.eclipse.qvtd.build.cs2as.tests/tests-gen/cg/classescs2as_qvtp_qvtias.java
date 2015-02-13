/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import classes.ClassesFactory;
import classes.ClassesPackage;
import classes.Element;
import classes.Package;
import classes.Root;
import classescs.ClassCS;
import classescs.ClassescsPackage;
import classescs.PackageCS;
import classescs.RootCS;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;

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
public class classescs2as_qvtp_qvtias extends AbstractTransformationExecutor
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_PRIMid_OclSelf = TypeId.SET.getSpecializedId(TypeId.OCL_SELF);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_RootCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    
    
    
    public classescs2as_qvtp_qvtias(final @NonNull Evaluator evaluator) {
        super(evaluator, new String[] {"leftCS", "rightAS"}, null, null, null);
    }
    
    public boolean run() {
        return __root__();
    }
    
    /**
     * 
     * map cClassCS_2_Class in classescs2as_qvtp_qvtias) {
     * leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize class : classes::Class;
     *  |
     * }
     * where ( |
     * )
     * { |
     * classCS = class;
     * }
     * 
     * }
     */
    protected boolean cClassCS_2_Class(final @NonNull /*@NonInvalid*/ ClassCS classCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ classes.Class symbol_0 = ClassesFactory.eINSTANCE.createClass();
            assert symbol_0 != null;
            modelObjects[1/*rightAS*/].add(symbol_0);
            // assignments
            classCS.setAst(symbol_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2as_qvtp_qvtias) {
     * leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize package : classes::Package;
     *  |
     * }
     * where ( |
     * )
     * { |
     * packageCS = package;
     * }
     * 
     * }
     */
    protected boolean cPackageCS_2_Package(final @NonNull /*@NonInvalid*/ PackageCS packageCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
            assert symbol_0 != null;
            modelObjects[1/*rightAS*/].add(symbol_0);
            // assignments
            packageCS.setAst(symbol_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2as_qvtp_qvtias) {
     * leftCS (rootCS : classescs::RootCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize root : classes::Root;
     *  |
     * }
     * where ( |
     * )
     * { |
     * rootCS = root;
     * }
     * 
     * }
     */
    protected boolean cRootCS_2_Root(final @NonNull /*@NonInvalid*/ RootCS rootCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ Root root = ClassesFactory.eINSTANCE.createRoot();
            assert root != null;
            modelObjects[1/*rightAS*/].add(root);
            // assignments
            rootCS.setAst(root);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uClass_name in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (classCS : classescs::ClassCS;
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
     * classCS.ast.oclAsType(classes::Class) = name;
     * }
     * 
     * }
     */
    protected boolean uClass_name(final @NonNull /*@NonInvalid*/ ClassCS classCS_0) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
            // creations
            // assignments
            final @Nullable /*@Thrown*/ Element ast = classCS_0.getAst();
            final @Nullable /*@Thrown*/ classes.Class oclAsType = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Class_0);
            final @Nullable /*@Thrown*/ String name = classCS_0.getName();
            oclAsType.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uPackage_name in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (packageCS : classescs::PackageCS;
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
     * packageCS.ast.oclAsType(classes::Package) = name;
     * }
     * 
     * }
     */
    protected boolean uPackage_name(final @NonNull /*@NonInvalid*/ PackageCS packageCS_0) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            // creations
            // assignments
            final @Nullable /*@Thrown*/ Element ast = packageCS_0.getAst();
            final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Package_0);
            final @Nullable /*@Thrown*/ String name = packageCS_0.getName();
            oclAsType.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uPackage_ownedClasses in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (packageCS : classescs::PackageCS;
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
     * packageCS.ast.oclAsType(classes::Package)
     *    = ownedClasses.ast.oclAsType(classes::Class)
     *   ->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uPackage_ownedClasses(final @NonNull /*@NonInvalid*/ PackageCS packageCS_1) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            // creations
            // assignments
            final @Nullable /*@Thrown*/ Element ast = packageCS_1.getAst();
            final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Package_0);
            final @Nullable /*@Thrown*/ List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
            assert ownedClasses != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
            @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
            @NonNull /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ ClassCS _1 = (ClassCS)ITERATOR__1.next();
                /**
                 * ast.oclAsType(classes::Class)
                 */
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'classescs::ElementCS::ast\'");
                }
                final @Nullable /*@Thrown*/ Element ast_0 = _1.getAst();
                final @Nullable /*@Thrown*/ classes.Class oclAsType_0 = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_classes_c_c_Class_0);
                //
                accumulator.add(oclAsType_0);
            }
            final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = ClassUtil.nonNullState(CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect));
            final List<classes.Class> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, classes.Class.class);
            assert UNBOXED_asOrderedSet != null;
            oclAsType.getOwnedClasses().addAll(UNBOXED_asOrderedSet);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (rootCS : classescs::RootCS;
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
     * rootCS.ast.oclAsType(classes::Root)
     *    = ownedPackages.ast.oclAsType(classes::Package)
     *   ->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uRoot_ownedPackages(final @NonNull /*@NonInvalid*/ RootCS rootCS_0) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
            // creations
            // assignments
            final @Nullable /*@Thrown*/ Element ast = rootCS_0.getAst();
            final @Nullable /*@Thrown*/ Root oclAsType = (Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Root_0);
            final @Nullable /*@Thrown*/ List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
            assert ownedPackages != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
            @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
            @NonNull /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
                /**
                 * ast.oclAsType(classes::Package)
                 */
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'classescs::ElementCS::ast\'");
                }
                final @Nullable /*@Thrown*/ Element ast_0 = _1.getAst();
                final @Nullable /*@Thrown*/ Package oclAsType_0 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_classes_c_c_Package_0);
                //
                accumulator.add(oclAsType_0);
            }
            final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = ClassUtil.nonNullState(CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect));
            final List<Package> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, Package.class);
            assert UNBOXED_asOrderedSet != null;
            oclAsType.getOwnedPackages().addAll(UNBOXED_asOrderedSet);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map __root__ in classescs2as_qvtp_qvtias) {
     * 
     *   where ( |
     * )
     * { |
     * }
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
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_name {
     * classCS := classCS;
     * }}
     * }
     */
    protected boolean __root__() {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_ClassCS_1 = idResolver.getClass(CLSSid_ClassCS, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_2 = idResolver.getClass(CLSSid_PackageCS, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
            final @NonNull /*@Thrown*/ SetValue allInstances_5 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_PRIMid_OclSelf, TYP_classescs_c_c_ClassCS_1));
            final @NonNull /*@Thrown*/ SetValue allInstances_2 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_PRIMid_OclSelf, TYP_classescs_c_c_PackageCS_2));
            final @NonNull /*@Thrown*/ SetValue allInstances_1 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_PRIMid_OclSelf, TYP_classescs_c_c_RootCS_1));
            final List<? extends Object> UNBOXED_allInstances_5 = allInstances_5.asEcoreObjects(idResolver, Object.class);
            assert UNBOXED_allInstances_5 != null;
            final List<? extends Object> UNBOXED_allInstances_2 = allInstances_2.asEcoreObjects(idResolver, Object.class);
            assert UNBOXED_allInstances_2 != null;
            final List<? extends Object> UNBOXED_allInstances_1 = allInstances_1.asEcoreObjects(idResolver, Object.class);
            assert UNBOXED_allInstances_1 != null;
            // creations
            // assignments
            // mapping statements
            ;
            for (RootCS rootCS_3 : UNBOXED_allInstances_1) {
                if (rootCS_3 != null) {
                    final @NonNull /*@NonInvalid*/ RootCS symbol_1 = (RootCS)rootCS_3;
                    cRootCS_2_Root(symbol_1);
                }
            }
            ;
            for (PackageCS packageCS_5 : UNBOXED_allInstances_2) {
                if (packageCS_5 != null) {
                    final @NonNull /*@NonInvalid*/ PackageCS symbol_5 = (PackageCS)packageCS_5;
                    cPackageCS_2_Package(symbol_5);
                }
            }
            ;
            for (RootCS rootCS_4 : UNBOXED_allInstances_1) {
                if (rootCS_4 != null) {
                    final @NonNull /*@NonInvalid*/ RootCS symbol_9 = (RootCS)rootCS_4;
                    uRoot_ownedPackages(symbol_9);
                }
            }
            ;
            for (PackageCS packageCS_6 : UNBOXED_allInstances_2) {
                if (packageCS_6 != null) {
                    final @NonNull /*@NonInvalid*/ PackageCS symbol_13 = (PackageCS)packageCS_6;
                    uPackage_name(symbol_13);
                }
            }
            ;
            for (ClassCS classCS_3 : UNBOXED_allInstances_5) {
                if (classCS_3 != null) {
                    final @NonNull /*@NonInvalid*/ ClassCS symbol_17 = (ClassCS)classCS_3;
                    cClassCS_2_Class(symbol_17);
                }
            }
            ;
            for (PackageCS packageCS_7 : UNBOXED_allInstances_2) {
                if (packageCS_7 != null) {
                    final @NonNull /*@NonInvalid*/ PackageCS symbol_21 = (PackageCS)packageCS_7;
                    uPackage_ownedClasses(symbol_21);
                }
            }
            ;
            for (ClassCS classCS_4 : UNBOXED_allInstances_5) {
                if (classCS_4 != null) {
                    final @NonNull /*@NonInvalid*/ ClassCS symbol_25 = (ClassCS)classCS_4;
                    uClass_name(symbol_25);
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
