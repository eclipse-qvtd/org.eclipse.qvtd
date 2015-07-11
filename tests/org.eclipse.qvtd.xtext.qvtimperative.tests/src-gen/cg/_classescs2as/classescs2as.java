/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2as;

import classes.ClassesFactory;
import classes.ClassesPackage;
import classes.Package;
import classes.Root;
import classescs.ClassCS;
import classescs.ClassescsPackage;
import classescs.PackageCS;
import classescs.RootCS;
import classescstraces.ClassCS2Class;
import classescstraces.ClassescstracesFactory;
import classescstraces.ClassescstracesPackage;
import classescstraces.PackageCS2Package;
import classescstraces.RootCS2Root;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * The classescs2as transformation:
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
public class classescs2as extends AbstractTransformer
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_tracesmodel_s_1_0_s_classescstraces = IdManager.getNsURIPackageId("http://tracesmodel/1.0/classescstraces", null, ClassescstracesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassCS2Class = PACKid_http_c_s_s_tracesmodel_s_1_0_s_classescstraces.getClassId("ClassCS2Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS2Package = PACKid_http_c_s_s_tracesmodel_s_1_0_s_classescstraces.getClassId("PackageCS2Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_RootCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_RootCS2Root = PACKid_http_c_s_s_tracesmodel_s_1_0_s_classescstraces.getClassId("RootCS2Root", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_ClassCS2Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_ClassCS2Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_PackageCS2Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_PackageCS2Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassCS2Class = TypeId.SET.getSpecializedId(CLSSid_ClassCS2Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PackageCS2Package = TypeId.SET.getSpecializedId(CLSSid_PackageCS2Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Root = TypeId.SET.getSpecializedId(CLSSid_Root);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_RootCS2Root = TypeId.SET.getSpecializedId(CLSSid_RootCS2Root);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<ClassCS,ClassCS2Class> OPPOSITE_OF_ClassCS2Class_classCS = new HashMap<ClassCS,ClassCS2Class>();
    protected final @NonNull Map<PackageCS,PackageCS2Package> OPPOSITE_OF_PackageCS2Package_packageCS = new HashMap<PackageCS,PackageCS2Package>();
    protected final @NonNull Map<RootCS,RootCS2Root> OPPOSITE_OF_RootCS2Root_rootCS = new HashMap<RootCS,RootCS2Root>();
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_Class,                   // 0 => Class
        CLSSid_ClassCS,                 // 1 => ClassCS
        CLSSid_ClassCS2Class,           // 2 => ClassCS2Class
        CLSSid_Package,                 // 3 => Package
        CLSSid_PackageCS,               // 4 => PackageCS
        CLSSid_PackageCS2Package,       // 5 => PackageCS2Package
        CLSSid_Root,                    // 6 => Root
        CLSSid_RootCS,                  // 7 => RootCS
        CLSSid_RootCS2Root              // 8 => RootCS2Root
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : Class -> {Class}
        {1},                    // 1 : ClassCS -> {ClassCS}
        {2},                    // 2 : ClassCS2Class -> {ClassCS2Class}
        {3},                    // 3 : Package -> {Package}
        {4},                    // 4 : PackageCS -> {PackageCS}
        {5},                    // 5 : PackageCS2Package -> {PackageCS2Package}
        {6},                    // 6 : Root -> {Root}
        {7},                    // 7 : RootCS -> {RootCS}
        {8}                     // 8 : RootCS2Root -> {RootCS2Root}
    };
    
    
    public classescs2as(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * 
     * map mClassCS2Class_LM in classescs2as {
     * leftCS (classCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize c2c : classescstraces::ClassCS2Class[?];
     *  |}
     * where ( |)
     * { |
     * c2c.classCS := classCS;
     * }
     * 
     */
    protected boolean MAP_mClassCS2Class_LM(final @NonNull /*@NonInvalid*/ ClassCS classCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ ClassCS2Class c2c_0 = ClassescstracesFactory.eINSTANCE.createClassCS2Class();
        assert c2c_0 != null;
        models[2/*middle*/].add(c2c_0);
        // property assignments
        c2c_0.setClassCS(classCS);
        OPPOSITE_OF_ClassCS2Class_classCS.put(classCS, c2c_0);
        return true;
    }
    
    /**
     * 
     * map mRootCS2Root_LM in classescs2as {
     * leftCS (rootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize r2r : classescstraces::RootCS2Root[?];
     *  |}
     * where ( |)
     * { |
     * r2r.rootCS := rootCS;
     * }
     * 
     */
    protected boolean MAP_mRootCS2Root_LM(final @NonNull /*@NonInvalid*/ RootCS rootCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ RootCS2Root r2r_0 = ClassescstracesFactory.eINSTANCE.createRootCS2Root();
        assert r2r_0 != null;
        models[2/*middle*/].add(r2r_0);
        // property assignments
        r2r_0.setRootCS(rootCS);
        OPPOSITE_OF_RootCS2Root_rootCS.put(rootCS, r2r_0);
        return true;
    }
    
    /**
     * 
     * map mPackageCS2Package_LM in classescs2as {
     * leftCS (packageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize p2p : classescstraces::PackageCS2Package[?];
     *  |}
     * where ( |)
     * { |
     * p2p.packageCS := packageCS;
     * }
     * 
     */
    protected boolean MAP_mPackageCS2Package_LM(final @NonNull /*@NonInvalid*/ PackageCS packageCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ PackageCS2Package p2p_0 = ClassescstracesFactory.eINSTANCE.createPackageCS2Package();
        assert p2p_0 != null;
        models[2/*middle*/].add(p2p_0);
        // property assignments
        p2p_0.setPackageCS(packageCS);
        OPPOSITE_OF_PackageCS2Package_packageCS.put(packageCS, p2p_0);
        return true;
    }
    
    /**
     * 
     * map mClassCS2Class_MR in classescs2as {
     * middle (c2c : classescstraces::ClassCS2Class[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize class : classes::Class[?];
     *  |}
     * where ( |)
     * { |
     * c2c.class := class;
     * }
     * 
     */
    protected boolean MAP_mClassCS2Class_MR(final @NonNull /*@NonInvalid*/ ClassCS2Class c2c) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ classes.Class symbol_3 = ClassesFactory.eINSTANCE.createClass();
        assert symbol_3 != null;
        models[1/*rightAS*/].add(symbol_3);
        // property assignments
        c2c.setClass(symbol_3);
        return true;
    }
    
    /**
     * 
     * map mRootCS2Root_MR in classescs2as {
     * middle (r2r : classescstraces::RootCS2Root[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize root : classes::Root[?];
     *  |}
     * where ( |)
     * { |
     * r2r.root := root;
     * }
     * 
     */
    protected boolean MAP_mRootCS2Root_MR(final @NonNull /*@NonInvalid*/ RootCS2Root r2r) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Root root_0 = ClassesFactory.eINSTANCE.createRoot();
        assert root_0 != null;
        models[1/*rightAS*/].add(root_0);
        // property assignments
        r2r.setRoot(root_0);
        return true;
    }
    
    /**
     * 
     * map mPackageCS2Package_MR in classescs2as {
     * middle (p2p : classescstraces::PackageCS2Package[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize package : classes::Package[?];
     *  |}
     * where ( |)
     * { |
     * p2p.package := package;
     * }
     * 
     */
    protected boolean MAP_mPackageCS2Package_MR(final @NonNull /*@NonInvalid*/ PackageCS2Package p2p) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Package symbol_3 = ClassesFactory.eINSTANCE.createPackage();
        assert symbol_3 != null;
        models[1/*rightAS*/].add(symbol_3);
        // property assignments
        p2p.setPackage(symbol_3);
        return true;
    }
    
    /**
     * 
     * map uClass_name in classescs2as {
     * rightAS (class : classes::Class[?];
     *  |)
     * { |}
     * leftCS (classCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * where ( |
     * classCS.ClassCS2Class.class = class)
     * {_0 : String[?];
     *  |
     * _0 := classCS.name;
     * class.name := _0;
     * }
     * 
     */
    protected boolean MAP_uClass_name(final @NonNull /*@NonInvalid*/ classes.Class symbol_0, final @NonNull /*@NonInvalid*/ ClassCS classCS_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@Thrown*/ ClassCS2Class ClassCS2Class = ClassUtil.nonNullState (OPPOSITE_OF_ClassCS2Class_classCS.get(classCS_0));
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ classes.Class symbol_3 = ClassCS2Class.getClass_();
        final /*@Thrown*/ boolean eq = symbol_3.equals(symbol_0);
        if (!eq) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name = classCS_0.getName();
        // property assignments
        symbol_0.setName(name);
        return true;
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2as {
     * rightAS (root : classes::Root[?];
     *  |)
     * { |}
     * leftCS (rootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * where ( |
     * rootCS.RootCS2Root.root =
     *   root)
     * {_0 : OrderedSet(classes::Package)[*|1];
     *  |
     * _0 := rootCS.ownedPackages.PackageCS2Package.package->asOrderedSet();
     * root.ownedPackages := _0;
     * }
     * 
     */
    protected boolean MAP_uRoot_ownedPackages(final @NonNull /*@NonInvalid*/ Root root, final @NonNull /*@NonInvalid*/ RootCS rootCS_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@Thrown*/ RootCS2Root RootCS2Root = ClassUtil.nonNullState (OPPOSITE_OF_RootCS2Root_rootCS.get(rootCS_0));
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Root root_0 = RootCS2Root.getRoot();
        final /*@Thrown*/ boolean eq = root_0.equals(root);
        if (!eq) {
            return false;
        }
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_PackageCS2Package);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * PackageCS2Package
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://tracesmodel/1.0/classescstraces\'::PackageCS2Package::packageCS\'");
            }
            final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(_1));
            //
            accumulator.add(PackageCS2Package);
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        @NonNull Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            @SuppressWarnings("null")
            @NonNull /*@NonInvalid*/ PackageCS2Package _1_0 = (PackageCS2Package)ITERATOR__1_0.next();
            /**
             * package
             */
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ Package symbol_3 = _1_0.getPackage();
            //
            accumulator_0.add(symbol_3);
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        // property assignments
        final @NonNull /*@NonInvalid*/ List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
        root.getOwnedPackages().addAll(ECORE_asOrderedSet);
        return true;
    }
    
    /**
     * 
     * map uPackage_name in classescs2as {
     * rightAS (package : classes::Package[?];
     *  |)
     * { |}
     * leftCS (packageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * where ( |
     * packageCS.PackageCS2Package.package = package)
     * {_0 : String[?];
     *  |
     * _0 := packageCS.name;
     * package.name := _0;
     * }
     * 
     */
    protected boolean MAP_uPackage_name(final @NonNull /*@NonInvalid*/ Package symbol_1, final @NonNull /*@NonInvalid*/ PackageCS packageCS_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(packageCS_0));
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package symbol_3 = PackageCS2Package.getPackage();
        final /*@Thrown*/ boolean eq = symbol_3.equals(symbol_1);
        if (!eq) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name = packageCS_0.getName();
        // property assignments
        symbol_1.setName(name);
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedClasses in classescs2as {
     * rightAS (package : classes::Package[?];
     *  |)
     * { |}
     * leftCS (packageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * where ( |
     * packageCS.PackageCS2Package.package =
     *   package)
     * {_0 : OrderedSet(classes::Class)[*|1];
     *  |
     * _0 := packageCS.ownedClasses.ClassCS2Class.class->asOrderedSet();
     * package.ownedClasses := _0;
     * }
     * 
     */
    protected boolean MAP_uPackage_ownedClasses(final @NonNull /*@NonInvalid*/ Package symbol_2, final @NonNull /*@NonInvalid*/ PackageCS packageCS_1) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(packageCS_1));
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package symbol_3 = PackageCS2Package.getPackage();
        final /*@Thrown*/ boolean eq = symbol_3.equals(symbol_2);
        if (!eq) {
            return false;
        }
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_ClassCS2Class);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect_0 = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * ClassCS2Class
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://tracesmodel/1.0/classescstraces\'::ClassCS2Class::classCS\'");
            }
            final @NonNull /*@Thrown*/ ClassCS2Class ClassCS2Class = ClassUtil.nonNullState (OPPOSITE_OF_ClassCS2Class_classCS.get(_1));
            //
            accumulator.add(ClassCS2Class);
        }
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        @NonNull Iterator<?> ITERATOR__1_0 = collect_0.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect = accumulator_0;
                break;
            }
            @SuppressWarnings("null")
            @NonNull /*@NonInvalid*/ ClassCS2Class _1_0 = (ClassCS2Class)ITERATOR__1_0.next();
            /**
             * class
             */
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ classes.Class symbol_4 = _1_0.getClass_();
            //
            accumulator_0.add(symbol_4);
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        // property assignments
        final @NonNull /*@NonInvalid*/ List<classes.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(classes.Class.class, asOrderedSet);
        symbol_2.getOwnedClasses().addAll(ECORE_asOrderedSet);
        return true;
    }
    
    /**
     * 
     * map __root__ in classescs2as {
     * 
     *   where ( |)
     * { |}
     * for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map mPackageCS2Package_LM {
     * packageCS := packageCS;
     * }}
     *   for p2p : classescstraces::PackageCS2Package in classescstraces::PackageCS2Package.allInstances()
     *    {
     * map mPackageCS2Package_MR {
     * p2p := p2p;
     * }}
     *   for package : classes::Package in classes::Package.allInstances()
     *    {
     * 
     *     for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *      {
     * map uPackage_name {
     * package := package;
     * packageCS := packageCS;
     * }}}
     *   for package : classes::Package in classes::Package.allInstances()
     *    {
     * 
     *     for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *      {
     * 
     *       map uPackage_ownedClasses {
     * package := package;
     * packageCS := packageCS;
     * }}}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map mClassCS2Class_LM {
     * classCS := classCS;
     * }}
     *   for c2c : classescstraces::ClassCS2Class in classescstraces::ClassCS2Class.allInstances()
     *    {
     * map mClassCS2Class_MR {
     * c2c := c2c;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * 
     *     for class : classes::Class in classes::Class.allInstances()
     *      {
     * map uClass_name {
     * class := class;
     * classCS := classCS;
     * }}}
     *   for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * map mRootCS2Root_LM {
     * rootCS := rootCS;
     * }}
     *   for r2r : classescstraces::RootCS2Root in classescstraces::RootCS2Root.allInstances()
     *    {
     * map mRootCS2Root_MR {
     * r2r := r2r;
     * }}
     *   for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * 
     *     for root : classes::Root in classes::Root.allInstances()
     *      {
     * map uRoot_ownedPackages {
     * root := root;
     * rootCS := rootCS;
     * }}}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_ClassCS_1 = idResolver.getClass(CLSSid_ClassCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_ClassCS2Class_0 = idResolver.getClass(CLSSid_ClassCS2Class, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_PackageCS2Package_0 = idResolver.getClass(CLSSid_PackageCS2Package, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_RootCS2Root_0 = idResolver.getClass(CLSSid_RootCS2Root, null);
        final @NonNull /*@NonInvalid*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, TYP_classes_c_c_Package_1);
        final @NonNull /*@NonInvalid*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_1);
        final @NonNull /*@NonInvalid*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_0);
        final @NonNull /*@NonInvalid*/ SetValue allInstances_11 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
        // mapping statements
        for (PackageCS packageCS_5 : ValueUtil.typedIterable(PackageCS.class, allInstances)) {
            if (packageCS_5 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_6 = (PackageCS)packageCS_5;
                if (symbol_6 != null) {
                    MAP_mPackageCS2Package_LM(symbol_6);
                }
            }
        }
        final @NonNull /*@NonInvalid*/ SetValue allInstances_0 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS2Package, TYP_classescstraces_c_c_PackageCS2Package_0);
        for (PackageCS2Package p2p_1 : ValueUtil.typedIterable(PackageCS2Package.class, allInstances_0)) {
            if (p2p_1 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS2Package symbol_9 = (PackageCS2Package)p2p_1;
                if (symbol_9 != null) {
                    MAP_mPackageCS2Package_MR(symbol_9);
                }
            }
        }
        for (Package symbol_17 : ValueUtil.typedIterable(Package.class, allInstances_3)) {
            if (symbol_17 != null) {
                for (PackageCS packageCS_6 : ValueUtil.typedIterable(PackageCS.class, allInstances)) {
                    if (packageCS_6 != null) {
                        final @NonNull /*@NonInvalid*/ Package symbol_12 = (Package)symbol_17;
                        final @NonNull /*@NonInvalid*/ PackageCS symbol_13 = (PackageCS)packageCS_6;
                        if (symbol_12 != null) {
                            if (symbol_13 != null) {
                                MAP_uPackage_name(symbol_12, symbol_13);
                            }
                        }
                    }
                }
            }
        }
        for (Package symbol_23 : ValueUtil.typedIterable(Package.class, allInstances_3)) {
            if (symbol_23 != null) {
                for (PackageCS packageCS_7 : ValueUtil.typedIterable(PackageCS.class, allInstances)) {
                    if (packageCS_7 != null) {
                        final @NonNull /*@NonInvalid*/ Package symbol_18 = (Package)symbol_23;
                        final @NonNull /*@NonInvalid*/ PackageCS symbol_19 = (PackageCS)packageCS_7;
                        if (symbol_18 != null) {
                            if (symbol_19 != null) {
                                MAP_uPackage_ownedClasses(symbol_18, symbol_19);
                            }
                        }
                    }
                }
            }
        }
        for (ClassCS classCS_3 : ValueUtil.typedIterable(ClassCS.class, allInstances_7)) {
            if (classCS_3 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_24 = (ClassCS)classCS_3;
                if (symbol_24 != null) {
                    MAP_mClassCS2Class_LM(symbol_24);
                }
            }
        }
        final @NonNull /*@NonInvalid*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS2Class, TYP_classescstraces_c_c_ClassCS2Class_0);
        for (ClassCS2Class c2c_1 : ValueUtil.typedIterable(ClassCS2Class.class, allInstances_6)) {
            if (c2c_1 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS2Class symbol_27 = (ClassCS2Class)c2c_1;
                if (symbol_27 != null) {
                    MAP_mClassCS2Class_MR(symbol_27);
                }
            }
        }
        for (ClassCS classCS_4 : ValueUtil.typedIterable(ClassCS.class, allInstances_7)) {
            if (classCS_4 != null) {
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
                final @NonNull /*@NonInvalid*/ SetValue allInstances_8 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, TYP_classes_c_c_Class_0);
                for (classes.Class symbol_34 : ValueUtil.typedIterable(classes.Class.class, allInstances_8)) {
                    if (symbol_34 != null) {
                        final @NonNull /*@NonInvalid*/ classes.Class symbol_30 = (classes.Class)symbol_34;
                        final @NonNull /*@NonInvalid*/ ClassCS symbol_31 = (ClassCS)classCS_4;
                        if (symbol_30 != null) {
                            if (symbol_31 != null) {
                                MAP_uClass_name(symbol_30, symbol_31);
                            }
                        }
                    }
                }
            }
        }
        for (RootCS rootCS_3 : ValueUtil.typedIterable(RootCS.class, allInstances_11)) {
            if (rootCS_3 != null) {
                final @NonNull /*@NonInvalid*/ RootCS symbol_36 = (RootCS)rootCS_3;
                if (symbol_36 != null) {
                    MAP_mRootCS2Root_LM(symbol_36);
                }
            }
        }
        final @NonNull /*@NonInvalid*/ SetValue allInstances_10 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS2Root, TYP_classescstraces_c_c_RootCS2Root_0);
        for (RootCS2Root r2r_1 : ValueUtil.typedIterable(RootCS2Root.class, allInstances_10)) {
            if (r2r_1 != null) {
                final @NonNull /*@NonInvalid*/ RootCS2Root symbol_39 = (RootCS2Root)r2r_1;
                if (symbol_39 != null) {
                    MAP_mRootCS2Root_MR(symbol_39);
                }
            }
        }
        for (RootCS rootCS_4 : ValueUtil.typedIterable(RootCS.class, allInstances_11)) {
            if (rootCS_4 != null) {
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
                final @NonNull /*@NonInvalid*/ SetValue allInstances_12 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Root, TYP_classes_c_c_Root_0);
                for (Root root_1 : ValueUtil.typedIterable(Root.class, allInstances_12)) {
                    if (root_1 != null) {
                        final @NonNull /*@NonInvalid*/ Root symbol_42 = (Root)root_1;
                        final @NonNull /*@NonInvalid*/ RootCS symbol_43 = (RootCS)rootCS_4;
                        if (symbol_42 != null) {
                            if (symbol_43 != null) {
                                MAP_uRoot_ownedPackages(symbol_42, symbol_43);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
