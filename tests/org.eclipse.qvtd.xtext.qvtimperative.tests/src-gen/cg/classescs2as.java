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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.AbstractTransformation;
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
public class classescs2as extends AbstractTransformation
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
    
    /* Outer-to-Middle Property navigation caches */
    protected final @NonNull Map<ClassCS,ClassCS2Class> OPPOSITE_OF_ClassCS2Class_classCS = new HashMap<ClassCS,ClassCS2Class>();
    protected final @NonNull Map<PackageCS,PackageCS2Package> OPPOSITE_OF_PackageCS2Package_packageCS = new HashMap<PackageCS,PackageCS2Package>();
    protected final @NonNull Map<RootCS,RootCS2Root> OPPOSITE_OF_RootCS2Root_rootCS = new HashMap<RootCS,RootCS2Root>();
    
    public classescs2as(final @NonNull Evaluator evaluator) {
        super(evaluator, new String[] {"leftCS", "rightAS", "middle"});
    }
    
    public boolean run() {
        final EClass ECLASS_classCS = ClassescsPackage.Literals.CLASS_CS;
        assert ECLASS_classCS != null;
        List<? extends ClassCS> LIST_classCS = getObjectsByType(ClassCS.class, 0/*leftCS*/, ECLASS_classCS);
        for (ClassCS classCS : LIST_classCS) {
            if (classCS != null) {
                mClassCS2Class_LM(classCS);
            }
        }
        return true;
    }
    
    /**
     * 
     * map mClassCS2Class_LM in classescs2as) {
     * leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * middle ( |
     * )
     * {realize c2c : classescstraces::ClassCS2Class;
     *  |
     * }
     * where ( |
     * )
     * { |
     * c2c = classCS;
     * }
     * 
     * }
     */
    protected boolean mClassCS2Class_LM(final @NonNull /*@NonInvalid*/ ClassCS classCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ ClassCS2Class c2c_0 = ClassescstracesFactory.eINSTANCE.createClassCS2Class();
            assert c2c_0 != null;
            modelObjects[2/*middle*/].add(c2c_0);
            // assignments
            c2c_0.setClassCS(classCS);
            OPPOSITE_OF_ClassCS2Class_classCS.put(classCS, c2c_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map mRootCS2Root_LM in classescs2as) {
     * leftCS (rootCS : classescs::RootCS;
     *  |
     * )
     * { |
     * }
     * middle ( |
     * )
     * {realize r2r : classescstraces::RootCS2Root;
     *  |
     * }
     * where ( |
     * )
     * { |
     * r2r = rootCS;
     * }
     * 
     * }
     */
    protected boolean mRootCS2Root_LM(final @NonNull /*@NonInvalid*/ RootCS rootCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ RootCS2Root r2r_0 = ClassescstracesFactory.eINSTANCE.createRootCS2Root();
            assert r2r_0 != null;
            modelObjects[2/*middle*/].add(r2r_0);
            // assignments
            r2r_0.setRootCS(rootCS);
            OPPOSITE_OF_RootCS2Root_rootCS.put(rootCS, r2r_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map mPackageCS2Package_LM in classescs2as) {
     * leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * middle ( |
     * )
     * {realize p2p : classescstraces::PackageCS2Package;
     *  |
     * }
     * where ( |
     * )
     * { |
     * p2p = packageCS;
     * }
     * 
     * }
     */
    protected boolean mPackageCS2Package_LM(final @NonNull /*@NonInvalid*/ PackageCS packageCS) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ PackageCS2Package p2p_0 = ClassescstracesFactory.eINSTANCE.createPackageCS2Package();
            assert p2p_0 != null;
            modelObjects[2/*middle*/].add(p2p_0);
            // assignments
            p2p_0.setPackageCS(packageCS);
            OPPOSITE_OF_PackageCS2Package_packageCS.put(packageCS, p2p_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map mClassCS2Class_MR in classescs2as) {
     * middle (c2c : classescstraces::ClassCS2Class;
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
     * c2c = class;
     * }
     * 
     * }
     */
    protected boolean mClassCS2Class_MR(final @NonNull /*@NonInvalid*/ ClassCS2Class c2c) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ classes.Class symbol_3 = ClassesFactory.eINSTANCE.createClass();
            assert symbol_3 != null;
            modelObjects[1/*rightAS*/].add(symbol_3);
            // assignments
            c2c.setClass(symbol_3);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map mRootCS2Root_MR in classescs2as) {
     * middle (r2r : classescstraces::RootCS2Root;
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
     * r2r = root;
     * }
     * 
     * }
     */
    protected boolean mRootCS2Root_MR(final @NonNull /*@NonInvalid*/ RootCS2Root r2r) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ Root root_0 = ClassesFactory.eINSTANCE.createRoot();
            assert root_0 != null;
            modelObjects[1/*rightAS*/].add(root_0);
            // assignments
            r2r.setRoot(root_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map mPackageCS2Package_MR in classescs2as) {
     * middle (p2p : classescstraces::PackageCS2Package;
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
     * p2p = package;
     * }
     * 
     * }
     */
    protected boolean mPackageCS2Package_MR(final @NonNull /*@NonInvalid*/ PackageCS2Package p2p) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ Package symbol_3 = ClassesFactory.eINSTANCE.createPackage();
            assert symbol_3 != null;
            modelObjects[1/*rightAS*/].add(symbol_3);
            // assignments
            p2p.setPackage(symbol_3);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uClass_name in classescs2as) {
     * rightAS (class : classes::Class;
     *  |
     * )
     * { |
     * }
     * leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * where ( |
     * classCS.ClassCS2Class.class = class)
     * { |
     * class = classCS.name;
     * }
     * 
     * }
     */
    protected boolean uClass_name(final @NonNull /*@NonInvalid*/ classes.Class symbol_0, final @NonNull /*@NonInvalid*/ ClassCS classCS_0) {
        try {
            // predicates
            final @NonNull /*@Thrown*/ ClassCS2Class ClassCS2Class = ClassUtil.nonNullState (OPPOSITE_OF_ClassCS2Class_classCS.get(classCS_0));
            final @Nullable /*@Thrown*/ classes.Class symbol_3 = ClassCS2Class.getClass_();
            final /*@Thrown*/ boolean eq = symbol_0.equals(symbol_3);
            if (!eq) {
                return false;
            }
            // creations
            // assignments
            final @Nullable /*@Thrown*/ String name = classCS_0.getName();
            symbol_0.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2as) {
     * rightAS (root : classes::Root;
     *  |
     * )
     * { |
     * }
     * leftCS (rootCS : classescs::RootCS;
     *  |
     * )
     * { |
     * }
     * where ( |
     * rootCS.RootCS2Root.root =
     *   root)
     * { |
     * root = rootCS.ownedPackage.PackageCS2Package.package->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uRoot_ownedPackages(final @NonNull /*@NonInvalid*/ Root root, final @NonNull /*@NonInvalid*/ RootCS rootCS_0) {
        try {
            // predicates
            final @NonNull /*@Thrown*/ RootCS2Root RootCS2Root = ClassUtil.nonNullState (OPPOSITE_OF_RootCS2Root_rootCS.get(rootCS_0));
            final @Nullable /*@Thrown*/ Root root_0 = RootCS2Root.getRoot();
            final /*@Thrown*/ boolean eq = root.equals(root_0);
            if (!eq) {
                return false;
            }
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            // assignments
            final @Nullable /*@Thrown*/ List<PackageCS> ownedPackage = rootCS_0.getOwnedPackage();
            assert ownedPackage != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPackage = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackage);
            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_PackageCS2Package);
            @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedPackage.iterator();
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
                    throw new InvalidValueException("Null source for \'classescstraces::PackageCS2Package::packageCS\'");
                }
                final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(_1));
                //
                accumulator.add(PackageCS2Package);
            }
            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
            @Nullable Iterator<?> ITERATOR__1_0 = collect_0.iterator();
            @NonNull /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1_0.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                @Nullable /*@NonInvalid*/ PackageCS2Package _1_0 = (PackageCS2Package)ITERATOR__1_0.next();
                /**
                 * package
                 */
                if (_1_0 == null) {
                    throw new InvalidValueException("Null source for \'classescstraces::PackageCS2Package::package\'");
                }
                final @Nullable /*@Thrown*/ Package symbol_3 = _1_0.getPackage();
                //
                accumulator_0.add(symbol_3);
            }
            final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
            final List<Package> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, Package.class);
            assert UNBOXED_asOrderedSet != null;
            root.getOwnedPackages().addAll(UNBOXED_asOrderedSet);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uPackage_name in classescs2as) {
     * rightAS (package : classes::Package;
     *  |
     * )
     * { |
     * }
     * leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * where ( |
     * packageCS.PackageCS2Package.package = package)
     * { |
     * package = packageCS.name;
     * }
     * 
     * }
     */
    protected boolean uPackage_name(final @NonNull /*@NonInvalid*/ Package symbol_1, final @NonNull /*@NonInvalid*/ PackageCS packageCS_0) {
        try {
            // predicates
            final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(packageCS_0));
            final @Nullable /*@Thrown*/ Package symbol_3 = PackageCS2Package.getPackage();
            final /*@Thrown*/ boolean eq = symbol_1.equals(symbol_3);
            if (!eq) {
                return false;
            }
            // creations
            // assignments
            final @Nullable /*@Thrown*/ String name = packageCS_0.getName();
            symbol_1.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map uPackage_ownedClasses in classescs2as) {
     * rightAS (package : classes::Package;
     *  |
     * )
     * { |
     * }
     * leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * where ( |
     * packageCS.PackageCS2Package.package =
     *   package)
     * { |
     * package = packageCS.ownedClasses.ClassCS2Class.class->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uPackage_ownedClasses(final @NonNull /*@NonInvalid*/ Package symbol_2, final @NonNull /*@NonInvalid*/ PackageCS packageCS_1) {
        try {
            // predicates
            final @NonNull /*@Thrown*/ PackageCS2Package PackageCS2Package = ClassUtil.nonNullState (OPPOSITE_OF_PackageCS2Package_packageCS.get(packageCS_1));
            final @Nullable /*@Thrown*/ Package symbol_3 = PackageCS2Package.getPackage();
            final /*@Thrown*/ boolean eq = symbol_2.equals(symbol_3);
            if (!eq) {
                return false;
            }
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            // assignments
            final @Nullable /*@Thrown*/ List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
            assert ownedClasses != null;
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
                    throw new InvalidValueException("Null source for \'classescstraces::ClassCS2Class::classCS\'");
                }
                final @NonNull /*@Thrown*/ ClassCS2Class ClassCS2Class = ClassUtil.nonNullState (OPPOSITE_OF_ClassCS2Class_classCS.get(_1));
                //
                accumulator.add(ClassCS2Class);
            }
            @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
            @Nullable Iterator<?> ITERATOR__1_0 = collect_0.iterator();
            @NonNull /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1_0.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                @Nullable /*@NonInvalid*/ ClassCS2Class _1_0 = (ClassCS2Class)ITERATOR__1_0.next();
                /**
                 * class
                 */
                if (_1_0 == null) {
                    throw new InvalidValueException("Null source for \'classescstraces::ClassCS2Class::class\'");
                }
                final @Nullable /*@Thrown*/ classes.Class symbol_4 = _1_0.getClass_();
                //
                accumulator_0.add(symbol_4);
            }
            final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
            final List<classes.Class> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, classes.Class.class);
            assert UNBOXED_asOrderedSet != null;
            symbol_2.getOwnedClasses().addAll(UNBOXED_asOrderedSet);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map __root__ in classescs2as) {
     * 
     *   where ( |
     * )
     * { |
     * }
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
     * packageCS := packageCS;
     * package := package;
     * }}}
     *   for package : classes::Package in classes::Package.allInstances()
     *    {
     * 
     *     for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *      {
     * 
     *       map uPackage_ownedClasses {
     * packageCS := packageCS;
     * package := package;
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
     * }
     */
    protected boolean __root__() {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_ClassCS_1 = idResolver.getClass(CLSSid_ClassCS, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_ClassCS2Class_0 = idResolver.getClass(CLSSid_ClassCS2Class, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_PackageCS2Package_0 = idResolver.getClass(CLSSid_PackageCS2Package, null);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescstraces_c_c_RootCS2Root_0 = idResolver.getClass(CLSSid_RootCS2Root, null);
            final @NonNull /*@Thrown*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Package, TYP_classes_c_c_Package_1);
            final @NonNull /*@Thrown*/ SetValue allInstances_7 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_1);
            final @NonNull /*@Thrown*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_0);
            final @NonNull /*@Thrown*/ SetValue allInstances_11 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
            final List<Package> UNBOXED_allInstances_3 = allInstances_3.asEcoreObjects(idResolver, Package.class);
            assert UNBOXED_allInstances_3 != null;
            final List<ClassCS> UNBOXED_allInstances_7 = allInstances_7.asEcoreObjects(idResolver, ClassCS.class);
            assert UNBOXED_allInstances_7 != null;
            final List<PackageCS> UNBOXED_allInstances = allInstances.asEcoreObjects(idResolver, PackageCS.class);
            assert UNBOXED_allInstances != null;
            final List<RootCS> UNBOXED_allInstances_11 = allInstances_11.asEcoreObjects(idResolver, RootCS.class);
            assert UNBOXED_allInstances_11 != null;
            // creations
            // assignments
            // mapping statements
            ;
            for (PackageCS packageCS_5 : UNBOXED_allInstances) {
                if (packageCS_5 != null) {
                    final @NonNull /*@NonInvalid*/ PackageCS symbol_7 = (PackageCS)packageCS_5;
                    mPackageCS2Package_LM(symbol_7);
                }
            }
            final @NonNull /*@Thrown*/ SetValue allInstances_0 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_PackageCS2Package, TYP_classescstraces_c_c_PackageCS2Package_0);
            final List<PackageCS2Package> UNBOXED_allInstances_0 = allInstances_0.asEcoreObjects(idResolver, PackageCS2Package.class);
            assert UNBOXED_allInstances_0 != null;
            ;
            for (PackageCS2Package p2p_1 : UNBOXED_allInstances_0) {
                if (p2p_1 != null) {
                    final @NonNull /*@NonInvalid*/ PackageCS2Package symbol_11 = (PackageCS2Package)p2p_1;
                    mPackageCS2Package_MR(symbol_11);
                }
            }
            ;
            for (Package symbol_21 : UNBOXED_allInstances_3) {
                if (symbol_21 != null) {
                    ;
                    for (PackageCS packageCS_6 : UNBOXED_allInstances) {
                        if (packageCS_6 != null) {
                            final @NonNull /*@NonInvalid*/ Package symbol_16 = (Package)symbol_21;
                            final @NonNull /*@NonInvalid*/ PackageCS symbol_17 = (PackageCS)packageCS_6;
                            uPackage_name(symbol_16, symbol_17);
                        }
                    }
                }
            }
            ;
            for (Package symbol_29 : UNBOXED_allInstances_3) {
                if (symbol_29 != null) {
                    ;
                    for (PackageCS packageCS_7 : UNBOXED_allInstances) {
                        if (packageCS_7 != null) {
                            final @NonNull /*@NonInvalid*/ Package symbol_24 = (Package)symbol_29;
                            final @NonNull /*@NonInvalid*/ PackageCS symbol_25 = (PackageCS)packageCS_7;
                            uPackage_ownedClasses(symbol_24, symbol_25);
                        }
                    }
                }
            }
            ;
            for (ClassCS classCS_3 : UNBOXED_allInstances_7) {
                if (classCS_3 != null) {
                    final @NonNull /*@NonInvalid*/ ClassCS symbol_31 = (ClassCS)classCS_3;
                    mClassCS2Class_LM(symbol_31);
                }
            }
            final @NonNull /*@Thrown*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_ClassCS2Class, TYP_classescstraces_c_c_ClassCS2Class_0);
            final List<ClassCS2Class> UNBOXED_allInstances_6 = allInstances_6.asEcoreObjects(idResolver, ClassCS2Class.class);
            assert UNBOXED_allInstances_6 != null;
            ;
            for (ClassCS2Class c2c_1 : UNBOXED_allInstances_6) {
                if (c2c_1 != null) {
                    final @NonNull /*@NonInvalid*/ ClassCS2Class symbol_35 = (ClassCS2Class)c2c_1;
                    mClassCS2Class_MR(symbol_35);
                }
            }
            ;
            for (ClassCS classCS_4 : UNBOXED_allInstances_7) {
                if (classCS_4 != null) {
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
                    final @NonNull /*@Thrown*/ SetValue allInstances_8 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Class, TYP_classes_c_c_Class_0);
                    final List<classes.Class> UNBOXED_allInstances_8 = allInstances_8.asEcoreObjects(idResolver, classes.Class.class);
                    assert UNBOXED_allInstances_8 != null;
                    ;
                    for (classes.Class symbol_44 : UNBOXED_allInstances_8) {
                        if (symbol_44 != null) {
                            final @NonNull /*@NonInvalid*/ classes.Class symbol_40 = (classes.Class)symbol_44;
                            final @NonNull /*@NonInvalid*/ ClassCS symbol_41 = (ClassCS)classCS_4;
                            uClass_name(symbol_40, symbol_41);
                        }
                    }
                }
            }
            ;
            for (RootCS rootCS_3 : UNBOXED_allInstances_11) {
                if (rootCS_3 != null) {
                    final @NonNull /*@NonInvalid*/ RootCS symbol_47 = (RootCS)rootCS_3;
                    mRootCS2Root_LM(symbol_47);
                }
            }
            final @NonNull /*@Thrown*/ SetValue allInstances_10 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_RootCS2Root, TYP_classescstraces_c_c_RootCS2Root_0);
            final List<RootCS2Root> UNBOXED_allInstances_10 = allInstances_10.asEcoreObjects(idResolver, RootCS2Root.class);
            assert UNBOXED_allInstances_10 != null;
            ;
            for (RootCS2Root r2r_1 : UNBOXED_allInstances_10) {
                if (r2r_1 != null) {
                    final @NonNull /*@NonInvalid*/ RootCS2Root symbol_51 = (RootCS2Root)r2r_1;
                    mRootCS2Root_MR(symbol_51);
                }
            }
            ;
            for (RootCS rootCS_4 : UNBOXED_allInstances_11) {
                if (rootCS_4 != null) {
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
                    final @NonNull /*@Thrown*/ SetValue allInstances_12 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_Root, TYP_classes_c_c_Root_0);
                    final List<Root> UNBOXED_allInstances_12 = allInstances_12.asEcoreObjects(idResolver, Root.class);
                    assert UNBOXED_allInstances_12 != null;
                    ;
                    for (Root root_1 : UNBOXED_allInstances_12) {
                        if (root_1 != null) {
                            final @NonNull /*@NonInvalid*/ Root symbol_56 = (Root)root_1;
                            final @NonNull /*@NonInvalid*/ RootCS symbol_57 = (RootCS)rootCS_4;
                            uRoot_ownedPackages(symbol_56, symbol_57);
                        }
                    }
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
