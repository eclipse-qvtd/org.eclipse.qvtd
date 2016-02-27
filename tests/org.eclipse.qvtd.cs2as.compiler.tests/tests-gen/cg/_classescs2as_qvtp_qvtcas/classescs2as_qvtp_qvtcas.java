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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.model.RootObjectsOperation;
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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    
    private final ClassesLookupSolver lookupSolver = new ClassesLookupSolver(executor);
    
    public classescs2as_qvtp_qvtcas(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new /*@NonNull*/ String[] {"leftCS", "rightAS"}, null, null, null);
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
     * map __root__ in classescs2as_qvtp_qvtcas {
     * 
     *   where ( |)
     * {roots : Set(OclElement) = leftCS.rootObjects()
     *   ;
     * _'\u00ABchild-ClassCS\u00BB' : Set(classescs::ClassCS[*|1]) = roots->selectByKind(classescs::ClassCS)
     *   ;
     * _'\\u00ABjoin-ClassCS-0\\u00BB' : Set(classescs::ClassCS[*|1]) = _'\u00ABchild-ClassCS\u00BB';
     * _'\u00ABchild-PackageCS\u00BB' : Set(classescs::PackageCS[*|1]) = roots->selectByKind(classescs::PackageCS)
     *   ;
     * _'\\u00ABjoin-PackageCS-0\\u00BB' : Set(classescs::PackageCS[*|1]) = _'\u00ABchild-PackageCS\u00BB';
     * _'\\u00ABjoin-PackageCS-1\\u00BB' : Set(classescs::PackageCS[*|1]) = _'\u00ABchild-PackageCS\u00BB';
     * _'\u00ABchild-RootCS\u00BB' : Set(classescs::RootCS[*|1]) = roots->selectByKind(classescs::RootCS)
     *   ;
     * _'\\u00ABjoin-RootCS-0\\u00BB' : Set(classescs::RootCS[*|1]) = _'\u00ABchild-RootCS\u00BB';
     *  |}
     * for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map _'classescs::RootCS::ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABjoin-PackageCS-1\\u00BB' := _'\\u00ABjoin-PackageCS-1\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-1\\u00BB' {
     * 
     *     map _'classescs::PackageCS::ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map _'classescs::PackageCS::ownedClasses' {
     * _'\\u00ABjoin-ClassCS-0\\u00BB' := _'\\u00ABjoin-ClassCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map cClassCS_2_Class {
     * lClassCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map cPackageCS_2_Package {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map cRootCS_2_Root {
     * lRootCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map uClassCS_2_Class_name {
     * lClassCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map _'uPackageCS_2_Package_name\\nuPackageCS_2_Package_ownedClasses\\nuPackageCS_2_Package_ownedPackages' {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map uRootCS_2_Root_ownedPackages {
     * lRootCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map uClassCS_2_Class_superClass {
     * lClassCS := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_0 = idResolver.getClass(CLSSid_ClassCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RootCS_0 = idResolver.getClass(CLSSid_RootCS, null);
        // variable assignments
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue rootObjects = RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*leftCS*/]);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_ClassCS_0);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_PackageCS_0);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_1 = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_RootCS_0);
        // connection variables
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ClassCS);
        for (ClassCS iterator : ValueUtil.typedIterable(ClassCS.class, selectByKind)) {
            _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1.add(iterator);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
        for (PackageCS iterator_0 : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3.add(iterator_0);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
        for (PackageCS iterator_1 : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1.add(iterator_1);
        }
        // mapping statements
        for (RootCS loop0 : ValueUtil.typedIterable(RootCS.class, selectByKind_1)) {
            if (loop0 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_0 = (RootCS)loop0;
                MAP_classescs_58_58RootCS_58_58ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3, _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1, symbol_0);
            }
        }
        for (PackageCS loop0_0 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1)) {
            if (loop0_0 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_2 = (PackageCS)loop0_0;
                MAP_classescs_58_58PackageCS_58_58ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3, symbol_2);
            }
        }
        for (PackageCS loop0_1 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_1 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_4 = (PackageCS)loop0_1;
                MAP_classescs_58_58PackageCS_58_58ownedClasses(_92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1, symbol_4);
            }
        }
        for (ClassCS loop0_2 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_2 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_6 = (ClassCS)loop0_2;
                if (symbol_6 != null) {
                    MAP_cClassCS_2_Class(symbol_6);
                }
            }
        }
        for (PackageCS loop0_3 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_3 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_8 = (PackageCS)loop0_3;
                if (symbol_8 != null) {
                    MAP_cPackageCS_2_Package(symbol_8);
                }
            }
        }
        for (RootCS loop0_4 : ValueUtil.typedIterable(RootCS.class, selectByKind_1)) {
            if (loop0_4 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_10 = (RootCS)loop0_4;
                if (symbol_10 != null) {
                    MAP_cRootCS_2_Root(symbol_10);
                }
            }
        }
        for (ClassCS loop0_5 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_5 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_12 = (ClassCS)loop0_5;
                if (symbol_12 != null) {
                    MAP_uClassCS_2_Class_name(symbol_12);
                }
            }
        }
        for (PackageCS loop0_6 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_6 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_14 = (PackageCS)loop0_6;
                if (symbol_14 != null) {
                    MAP_uPackageCS_2_Package_name_92nuPackageCS_2_Package_ownedClasses_92nuPackageCS_2_Package_ownedPackages(symbol_14);
                }
            }
        }
        for (RootCS loop0_7 : ValueUtil.typedIterable(RootCS.class, selectByKind_1)) {
            if (loop0_7 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_16 = (RootCS)loop0_7;
                if (symbol_16 != null) {
                    MAP_uRootCS_2_Root_ownedPackages(symbol_16);
                }
            }
        }
        for (ClassCS loop0_8 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_8 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_18 = (ClassCS)loop0_8;
                if (symbol_18 != null) {
                    MAP_uClassCS_2_Class_superClass(symbol_18);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map cClassCS_2_Class in classescs2as_qvtp_qvtcas {
     * leftCS (lClassCS : classescs::ClassCS[?];
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
    protected boolean MAP_cClassCS_2_Class(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class rClass = ClassesFactory.eINSTANCE.createClass();
        assert rClass != null;
        models[1/*rightAS*/].add(rClass);
        // property assignments
        lClassCS.setAst(rClass);
        return true;
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2as_qvtp_qvtcas {
     * leftCS (lPackageCS : classescs::PackageCS[?];
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
    protected boolean MAP_cPackageCS_2_Package(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package rPackage = ClassesFactory.eINSTANCE.createPackage();
        assert rPackage != null;
        models[1/*rightAS*/].add(rPackage);
        // property assignments
        lPackageCS.setAst(rPackage);
        return true;
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2as_qvtp_qvtcas {
     * leftCS (lRootCS : classescs::RootCS[?];
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
    protected boolean MAP_cRootCS_2_Root(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Root rRoot = ClassesFactory.eINSTANCE.createRoot();
        assert rRoot != null;
        models[1/*rightAS*/].add(rRoot);
        // property assignments
        lRootCS.setAst(rRoot);
        return true;
    }
    
    /**
     * 
     * map _'classescs::PackageCS::ownedClasses' in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::PackageCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-ClassCS-0\\u00BB' : Set(classescs::ClassCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::ClassCS) = _'\\u00ABparent\\u00BB'.ownedClasses->selectByKind(classescs::ClassCS)
     *   ;
     * _'\u00ABchild-ClassCS\u00BB' : OrderedSet(classescs::ClassCS[*|1]) = allChildren->selectByKind(classescs::ClassCS);
     *  |
     * _'\\u00ABjoin-ClassCS-0\\u00BB' += _'\u00ABchild-ClassCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_58_58PackageCS_58_58ownedClasses(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ClassCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS _92_u00ABparent_92_u00BB) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_1 = idResolver.getClass(CLSSid_ClassCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = _92_u00ABparent_92_u00BB.getOwnedClasses();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedClasses, TYP_classescs_c_c_ClassCS_1);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_ClassCS_1);
        // connection assignments
        for (ClassCS iterator : ValueUtil.typedIterable(ClassCS.class, selectByKind_0)) {
            if (iterator instanceof ClassCS) {
                _92_u00ABjoin_m_ClassCS_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs::PackageCS::ownedPackages' in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::PackageCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-PackageCS-0\\u00BB' : Set(classescs::PackageCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::PackageCS) = _'\\u00ABparent\\u00BB'.ownedPackages->selectByKind(classescs::PackageCS)
     *   ;
     * _'\u00ABchild-PackageCS\u00BB' : OrderedSet(classescs::PackageCS[*|1]) = allChildren->selectByKind(classescs::PackageCS)
     *   ;
     *  |
     * _'\\u00ABjoin-PackageCS-0\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * }
     * for aChild : classescs::PackageCS in allChildren {
     * 
     *     map _'classescs::PackageCS::ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := aChild;
     * }}
     */
    protected boolean MAP_classescs_58_58PackageCS_58_58ownedPackages(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS _92_u00ABparent_92_u00BB_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_1 = idResolver.getClass(CLSSid_PackageCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = _92_u00ABparent_92_u00BB_0.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedPackages, TYP_classescs_c_c_PackageCS_1);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_PackageCS_1);
        // connection assignments
        for (PackageCS iterator : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_0_92_u00BB.add(iterator);
            }
        }
        // mapping statements
        for (PackageCS aChild : ValueUtil.typedIterable(PackageCS.class, selectByKind)) {
            if (aChild != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_0 = (PackageCS)aChild;
                MAP_classescs_58_58PackageCS_58_58ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB, symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs::RootCS::ownedPackages' in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::RootCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-PackageCS-0\\u00BB' : Set(classescs::PackageCS[*|1]);
     * _'\\u00ABjoin-PackageCS-1\\u00BB' : Set(classescs::PackageCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::PackageCS) = _'\\u00ABparent\\u00BB'.ownedPackages->selectByKind(classescs::PackageCS)
     *   ;
     * _'\u00ABchild-PackageCS\u00BB' : OrderedSet(classescs::PackageCS[*|1]) = allChildren->selectByKind(classescs::PackageCS);
     *  |
     * _'\\u00ABjoin-PackageCS-0\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * _'\\u00ABjoin-PackageCS-1\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_58_58RootCS_58_58ownedPackages(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_0, final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_1_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS _92_u00ABparent_92_u00BB_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_1 = idResolver.getClass(CLSSid_PackageCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = _92_u00ABparent_92_u00BB_1.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedPackages, TYP_classescs_c_c_PackageCS_1);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_PackageCS_1);
        // connection assignments
        for (PackageCS iterator : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_0.add(iterator);
            }
        }
        for (PackageCS iterator_0 : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator_0 instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_1_92_u00BB.add(iterator_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map uClassCS_2_Class_name in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (lClassCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lClassCS.ast;
     * name : String[?] = lClassCS.name;
     * aClass : classes::Class[1] = ast.oclAsType(classes::Class);
     *  |
     * aClass.name := name;
     * }
     * 
     */
    protected boolean MAP_uClassCS_2_Class_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lClassCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lClassCS_0.getName();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uClassCS_2_Class_superClass in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (lClassCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lClassCS.ast;
     * extends : classescs::PathNameCS[?] = lClassCS.extends;
     * aClass : classes::Class[1] = ast.oclAsType(classes::Class);
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
    protected boolean MAP_uClassCS_2_Class_superClass(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lClassCS_1.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_0 = lClassCS_1.getExtends();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ boolean symbol_1 = symbol_0 == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
        if (symbol_1) {
            symbol_4 = null;
        }
        else {
            if (symbol_0 == null) {
                throw throwNull(lClassCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = symbol_0.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
            final /*@Thrown*/ boolean eq = size.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
            if (eq) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS == null) {
                    throw throwNull(lClassCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(oclAsType, name);
                example2.classes.Class _lookupClass = null;
                if (_lookupResult.size() == 1) {
                    _lookupClass = _lookupResult.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS,name);
                };
                symbol_3 = _lookupClass;
            }
            else {
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                assert UNBOXED_qualifierSegments != null;
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(oclAsType, UNBOXED_qualifierSegments);
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                try {
                    CAUGHT_qualifier = qualifier;
                }
                catch (Exception e) {
                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_qualifier == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                if (symbol_2 == Boolean.TRUE) {
                    safe_lookupQualifiedClass_source = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS_0 == null) {
                        throw throwNull(lClassCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
                symbol_3 = safe_lookupQualifiedClass_source;
            }
            symbol_4 = symbol_3;
        }
        // property assignments
        oclAsType.setSuperClass(symbol_4);
        return true;
    }
    
    /**
     * 
     * map _'uPackageCS_2_Package_name\\nuPackageCS_2_Package_ownedClasses\\nuPackageCS_2_Package_ownedPackages' in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (lPackageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lPackageCS.ast;
     * name : String[?] = lPackageCS.name;
     * ownedPackages : OrderedSet(classescs::PackageCS) = lPackageCS.ownedPackages;
     * ownedClasses : OrderedSet(classescs::ClassCS) = lPackageCS.ownedClasses;
     * aPackage : classes::Package[1] = ast.oclAsType(classes::Package)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package))
     *   ;
     * _'\\u00ABcollect\\u00BB1' : Sequence(classes::Class) = ownedClasses->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Class));
     *  |
     * aPackage.name := name;
     * aPackage.ownedClasses := _'\\u00ABcollect\\u00BB1';
     * aPackage.ownedPackages := _'\\u00ABcollect\\u00BB';
     * }
     * 
     */
    protected boolean MAP_uPackageCS_2_Package_name_92nuPackageCS_2_Package_ownedClasses_92nuPackageCS_2_Package_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lPackageCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPackageCS_0.getName();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = lPackageCS_0.getOwnedPackages();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = lPackageCS_0.getOwnedClasses();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
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
             * _'1_'.ast.oclAsType(classes::Package)
             */
            if (_1 == null) {
                throw throwNull(lPackageCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = BOXED_ownedClasses.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect_0 = accumulator_0;
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
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_1 = _1_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType_1 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_classes_c_c_Class_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        oclAsType.setName(name);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Class> ECORE_collect_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Class.class, collect_0);
        oclAsType.getOwnedClasses().addAll(ECORE_collect_0);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, collect);
        oclAsType.getOwnedPackages().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uRootCS_2_Root_ownedPackages in classescs2as_qvtp_qvtcas {
     * 
     *   leftCS (lRootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = lRootCS.ast;
     * ownedPackages : OrderedSet(classescs::PackageCS) = lRootCS.ownedPackages;
     * aRoot : classes::Root[1] = ast.oclAsType(classes::Root)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package));
     *  |
     * aRoot.ownedPackages := _'\\u00ABcollect\\u00BB';
     * }
     * 
     */
    protected boolean MAP_uRootCS_2_Root_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = lRootCS_0.getAst();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = lRootCS_0.getOwnedPackages();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Root oclAsType = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Root_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
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
             * _'1_'.ast.oclAsType(classes::Package)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            if (_1 == null) {
                throw throwNull(lRootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
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
}
