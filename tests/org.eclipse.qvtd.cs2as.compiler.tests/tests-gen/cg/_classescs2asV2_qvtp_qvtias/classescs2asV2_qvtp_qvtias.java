/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2asV2_qvtp_qvtias;

import example2.classes.Argument;
import example2.classes.CallExp;
import example2.classes.ClassesFactory;
import example2.classes.ClassesPackage;
import example2.classes.Operation;
import example2.classes.OperationCallExp;
import example2.classes.Package;
import example2.classes.Parameter;
import example2.classes.PropertyCallExp;
import example2.classes.Root;
import example2.classes.lookup.util.ClassesLookupResult;
import example2.classes.lookup.util.ClassesLookupSolver;
import example2.classescs.ArgumentCS;
import example2.classescs.ClassCS;
import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.OperationCS;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PropertyCS;
import example2.classescs.RootCS;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;

/**
 * The classescs2asV2_qvtp_qvtias transformation:
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
public class classescs2asV2_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Argument = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Argument", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ArgumentCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ArgumentCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("CallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NameExpCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("NameExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("OperationCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("OperationCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PackageCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Property", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PropertyCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("PropertyCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RootCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RoundedBracketClause = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RoundedBracketClause", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Visitable = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Argument = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Argument);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ArgumentCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ArgumentCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NameExpCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Argument = TypeId.SEQUENCE.getSpecializedId(CLSSid_Argument);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_CallExp = TypeId.SEQUENCE.getSpecializedId(CLSSid_CallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ArgumentCS = TypeId.SET.getSpecializedId(CLSSid_ArgumentCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NameExpCS = TypeId.SET.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OperationCS = TypeId.SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PropertyCS = TypeId.SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new /*@NonNull*/ ClassId[]{
        CLSSid_ArgumentCS,              // 0 => ArgumentCS
        CLSSid_ClassCS,                 // 1 => ClassCS
        CLSSid_NameExpCS,               // 2 => NameExpCS
        CLSSid_OperationCS,             // 3 => OperationCS
        CLSSid_PackageCS,               // 4 => PackageCS
        CLSSid_PropertyCS,              // 5 => PropertyCS
        CLSSid_RootCS                   // 6 => RootCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int /*@NonNull*/ [] /*@NonNull*/ [] classIndex2allClassIndexes = new int /*@NonNull*/ [] /*@NonNull*/ [] {
        {0},                    // 0 : ArgumentCS -> {ArgumentCS}
        {1},                    // 1 : ClassCS -> {ClassCS}
        {2},                    // 2 : NameExpCS -> {NameExpCS}
        {3},                    // 3 : OperationCS -> {OperationCS}
        {4},                    // 4 : PackageCS -> {PackageCS}
        {5},                    // 5 : PropertyCS -> {PropertyCS}
        {6}                     // 6 : RootCS -> {RootCS}
    };
    
    private final ClassesLookupSolver lookupSolver = new ClassesLookupSolver(executor);
    
    public classescs2asV2_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
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
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments));
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
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments, INT_1, diff));
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
     * map cArgumentCS_2_Argument in classescs2asV2_qvtp_qvtias {
     * leftCS (argumentCS : classescs::ArgumentCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize argument : classes::Argument[1];
     *  |}
     * where ( |)
     * { |
     * argumentCS.ast := argument;
     * }
     * 
     */
    protected boolean MAP_cArgumentCS_2_Argument(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS argumentCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Argument argument = ClassesFactory.eINSTANCE.createArgument();
        assert argument != null;
        models[1/*rightAS*/].add(argument);
        // property assignments
        argumentCS.setAst(argument);
        return true;
    }
    
    /**
     * 
     * map cClassCS_2_Class in classescs2asV2_qvtp_qvtias {
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
     * map cNameExpCS_2_PropertyCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize propertyCallExp : classes::PropertyCallExp[1];
     *  |}
     * where ( |
     * not isOpCallExp()
     *   isPropCallExp())
     * { |
     * nameExpCS.ast := propertyCallExp;
     * }
     * 
     */
    protected boolean MAP_cNameExpCS_2_PropertyCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable PropertyCallExp propertyCallExp = ClassesFactory.eINSTANCE.createPropertyCallExp();
        assert propertyCallExp != null;
        models[1/*rightAS*/].add(propertyCallExp);
        // property assignments
        nameExpCS.setAst(propertyCallExp);
        return true;
    }
    
    /**
     * 
     * map cNameExpCS_2_OperationCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize operationCallExp : classes::OperationCallExp[1];
     *  |}
     * where ( |
     * isOpCallExp())
     * { |
     * nameExpCS.ast := operationCallExp;
     * }
     * 
     */
    protected boolean MAP_cNameExpCS_2_OperationCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_0.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable OperationCallExp operationCallExp = ClassesFactory.eINSTANCE.createOperationCallExp();
        assert operationCallExp != null;
        models[1/*rightAS*/].add(operationCallExp);
        // property assignments
        nameExpCS_0.setAst(operationCallExp);
        return true;
    }
    
    /**
     * 
     * map cOperationCS_2_Operation in classescs2asV2_qvtp_qvtias {
     * leftCS (operationCS : classescs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize operation : classes::Operation[1];
     *  |}
     * where ( |)
     * { |
     * operationCS.ast := operation;
     * }
     * 
     */
    protected boolean MAP_cOperationCS_2_Operation(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation operation = ClassesFactory.eINSTANCE.createOperation();
        assert operation != null;
        models[1/*rightAS*/].add(operation);
        // property assignments
        operationCS.setAst(operation);
        return true;
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2asV2_qvtp_qvtias {
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
     * map cPropertyCS_2_Property in classescs2asV2_qvtp_qvtias {
     * leftCS (propertyCS : classescs::PropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize property : classes::Property[1];
     *  |}
     * where ( |)
     * { |
     * propertyCS.ast := property;
     * }
     * 
     */
    protected boolean MAP_cPropertyCS_2_Property(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property property = ClassesFactory.eINSTANCE.createProperty();
        assert property != null;
        models[1/*rightAS*/].add(property);
        // property assignments
        propertyCS.setAst(property);
        return true;
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2asV2_qvtp_qvtias {
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
     * map uArgument_name in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (argumentCS : classescs::ArgumentCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Argument[1];
     * _1 : String[?];
     *  |
     * _0 := argumentCS.ast.oclAsType(classes::Argument);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uArgument_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS argumentCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Argument_0 = idResolver.getClass(CLSSid_Argument, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = argumentCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Argument oclAsType = ClassUtil.nonNullState((Argument)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Argument_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = argumentCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uClass_name in classescs2asV2_qvtp_qvtias {
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
     * map uClass_ownedOperations in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Class[1];
     * _1 : Sequence(classes::Operation);
     *  |
     * _0 := classCS.ast.oclAsType(classes::Class)
     *   ;
     * _1 := operations.ast.oclAsType(classes::Operation);
     * _0.ownedOperations := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_ownedOperations(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_1.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<OperationCS> operations = classCS_1.getOperations();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_operations.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable OperationCS _1 = (OperationCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Operation)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
            if (_1 == null) {
                throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Operation_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
        oclAsType.getOwnedOperations().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uClass_ownedProperties in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Class[1];
     * _1 : Sequence(classes::Property);
     *  |
     * _0 := classCS.ast.oclAsType(classes::Class)
     *   ;
     * _1 := properties.ast.oclAsType(classes::Property);
     * _0.ownedProperties := _1;
     * }
     * 
     */
    protected boolean MAP_uClass_ownedProperties(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_2.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PropertyCS> properties = classCS_2.getProperties();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_properties.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PropertyCS _1 = (PropertyCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Property)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
            if (_1 == null) {
                throwNull(classCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType_0 = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Property_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Property> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Property.class, collect);
        oclAsType.getOwnedProperties().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uClass_superClass in classescs2asV2_qvtp_qvtias {
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
    protected boolean MAP_uClass_superClass(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_3.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_0 = classCS_3.getExtends();
        final /*@Thrown*/ boolean eq = symbol_0 == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
        if (eq) {
            symbol_3 = null;
        }
        else {
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class self_1 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = classCS_3.getExtends();
            if (aPathNameCS == null) {
                throwNull(classCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_2;
            if (eq_0) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS == null) {
                    throwNull(classCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
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
                        throwNull(classCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
     * map uPropertyCallExp_ownedCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not isOpCallExp()
     *   isPropCallExp()
     *   )
     * {_0 : classes::PropertyCallExp[1];
     * _1 : classes::CallExp[?];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::PropertyCallExp)
     *   ;
     * _1 := if ownedNameExp = null
     *   then null
     *   else ownedNameExp.ast.oclAsType(classes::CallExp)
     *   endif;
     * _0.ownedCallExp := _1;
     * }
     * 
     */
    protected boolean MAP_uPropertyCallExp_ownedCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_1.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_1.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS ownedNameExp = nameExpCS_1.getOwnedNameExp();
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_1.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
        final /*@Thrown*/ boolean eq_0 = ownedNameExp == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp symbol_0;
        if (eq_0) {
            symbol_0 = null;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
            if (ownedNameExp == null) {
                throwNull(nameExpCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownedNameExp.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
            symbol_0 = oclAsType_0;
        }
        // property assignments
        oclAsType.setOwnedCallExp(symbol_0);
        return true;
    }
    
    /**
     * 
     * map uPropertyCallExp_referredProperty in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not isOpCallExp()
     *   isPropCallExp()
     *   )
     * {_0 : classes::PropertyCallExp[1];
     * _1 : classes::Property[?];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::PropertyCallExp)
     *   ;
     * _1 := if
     *     oclContainer()
     *     .oclIsKindOf(classescs::NameExpCS)
     *   then
     *     ast.oclAsType(classes::CallExp)
     *     .lookupPropertyFrom(
     *       ast.oclAsType(classes::CallExp).owningSource.type, name)
     *   else ast.oclAsType(classes::CallExp).lookupProperty(name)
     *   endif;
     * _0.referredProperty := _1;
     * }
     * 
     */
    protected boolean MAP_uPropertyCallExp_referredProperty(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_2.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_2.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_2 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_2.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp self_2 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_2));
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, nameExpCS_2);
        final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_classescs_c_c_NameExpCS_0).booleanValue());
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_8;
        if (oclIsKindOf) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = nameExpCS_2.getName();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_2));
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp owningSource = oclAsType_0.getOwningSource();
            if (owningSource == null) {
                throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
            }
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class exporter = owningSource.getType();
            if (aPathNameCS == null) {
                throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_3;
            if (eq_0) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS == null) {
                    throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                ClassesLookupResult<example2.classes.Property> _lookupResult = lookupSolver._lookupExportedProperty(exporter, self_2, name);
                example2.classes.Property _lookupExportedProperty = null;
                if (_lookupResult.size() == 1) {
                    _lookupExportedProperty = _lookupResult.getSingleResult();
                } else {
                    handleLookupError(self_2,self_2);
                };
                symbol_3 = _lookupExportedProperty;
            }
            else {
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_1 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments));
                final /*@Thrown*/ boolean eq_1 = size_1.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                if (eq_1) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                    if (aPathElementCS_0 == null) {
                        throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupClass(self_2, name_0);
                    example2.classes.Class _lookupClass = null;
                    if (_lookupResult_0.size() == 1) {
                        _lookupClass = _lookupResult_0.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_0,name_0);
                    };
                    symbol_1 = _lookupClass;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0));
                    final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments_0 != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_2, UNBOXED_qualifierSegments_0);
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_0 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                        if (aPathElementCS_1 == null) {
                            throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_1 = aPathElementCS_1.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_1 = lookupSolver._lookupQualifiedClass(qualifier, name_1);
                        example2.classes.Class _lookupQualifiedClass = null;
                        if (_lookupResult_1.size() == 1) {
                            _lookupQualifiedClass = _lookupResult_1.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_1,name_1);
                        };
                        safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                    }
                    symbol_1 = safe_lookupQualifiedClass_source;
                }
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_1;
                try {
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_symbol_1 == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source;
                if (symbol_2 == Boolean.TRUE) {
                    safe_lookupQualifiedProperty_source = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS_2 == null) {
                        throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_2 = aPathElementCS_2.getName();
                    ClassesLookupResult<example2.classes.Property> _lookupResult_2 = lookupSolver._lookupQualifiedProperty(symbol_1, name_2);
                    example2.classes.Property _lookupQualifiedProperty = null;
                    if (_lookupResult_2.size() == 1) {
                        _lookupQualifiedProperty = _lookupResult_2.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_2,name_2);
                    };
                    safe_lookupQualifiedProperty_source = _lookupQualifiedProperty;
                }
                symbol_3 = safe_lookupQualifiedProperty_source;
            }
            symbol_8 = symbol_3;
        }
        else {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS_0 = nameExpCS_2.getName();
            if (aPathNameCS_0 == null) {
                throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_1 = aPathNameCS_0.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_1);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_3 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_1));
            final /*@Thrown*/ boolean eq_2 = size_3.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_7;
            if (eq_2) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_3 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_1);
                if (aPathElementCS_3 == null) {
                    throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_3 = aPathElementCS_3.getName();
                ClassesLookupResult<example2.classes.Property> _lookupResult_3 = lookupSolver._lookupProperty(self_2, name_3);
                example2.classes.Property _lookupProperty = null;
                if (_lookupResult_3.size() == 1) {
                    _lookupProperty = _lookupResult_3.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_3,name_3);
                };
                symbol_7 = _lookupProperty;
            }
            else {
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_1 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_3, INT_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_1 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_1, INT_1, diff_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_5 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments_1));
                final /*@Thrown*/ boolean eq_3 = size_5.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                if (eq_3) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_4 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments_1);
                    if (aPathElementCS_4 == null) {
                        throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_4 = aPathElementCS_4.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult_4 = lookupSolver._lookupClass(self_2, name_4);
                    example2.classes.Class _lookupClass_0 = null;
                    if (_lookupResult_4.size() == 1) {
                        _lookupClass_0 = _lookupResult_4.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_4,name_4);
                    };
                    symbol_5 = _lookupClass_0;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_2 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_5, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_2 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments_1, INT_1, diff_2));
                    final List<PathElementCS> UNBOXED_qualifierSegments_2 = qualifierSegments_2.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments_2 != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier_0 = this.lookupPackage(self_2, UNBOXED_qualifierSegments_2);
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier_0;
                    try {
                        CAUGHT_qualifier_0 = qualifier_0;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier_0 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_4 = CAUGHT_qualifier_0 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source_0;
                    if (symbol_4 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source_0 = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_5 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments_1);
                        if (aPathElementCS_5 == null) {
                            throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_5 = aPathElementCS_5.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_5 = lookupSolver._lookupQualifiedClass(qualifier_0, name_5);
                        example2.classes.Class _lookupQualifiedClass_0 = null;
                        if (_lookupResult_5.size() == 1) {
                            _lookupQualifiedClass_0 = _lookupResult_5.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_5,name_5);
                        };
                        safe_lookupQualifiedClass_source_0 = _lookupQualifiedClass_0;
                    }
                    symbol_5 = safe_lookupQualifiedClass_source_0;
                }
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_5;
                try {
                    CAUGHT_symbol_5 = symbol_5;
                }
                catch (Exception e) {
                    CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_6 = CAUGHT_symbol_5 == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source_0;
                if (symbol_6 == Boolean.TRUE) {
                    safe_lookupQualifiedProperty_source_0 = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_6 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_1);
                    if (aPathElementCS_6 == null) {
                        throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_6 = aPathElementCS_6.getName();
                    ClassesLookupResult<example2.classes.Property> _lookupResult_6 = lookupSolver._lookupQualifiedProperty(symbol_5, name_6);
                    example2.classes.Property _lookupQualifiedProperty_0 = null;
                    if (_lookupResult_6.size() == 1) {
                        _lookupQualifiedProperty_0 = _lookupResult_6.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_6,name_6);
                    };
                    safe_lookupQualifiedProperty_source_0 = _lookupQualifiedProperty_0;
                }
                symbol_7 = safe_lookupQualifiedProperty_source_0;
            }
            symbol_8 = symbol_7;
        }
        // property assignments
        oclAsType.setReferredProperty(symbol_8);
        return true;
    }
    
    /**
     * 
     * map uPropertyCallExp_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not isOpCallExp()
     *   isPropCallExp()
     *   )
     * {_0 : classes::PropertyCallExp[1];
     * _1 : classes::Class[?];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::PropertyCallExp)
     *   ;
     * _1 := ast.oclAsType(classes::CallExp)
     *   .oclAsType(classes::PropertyCallExp).referredProperty?.type;
     * _0.type := _1;
     * }
     * 
     */
    protected boolean MAP_uPropertyCallExp_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_3.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_3.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_3.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType_1 = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_0, TYP_classes_c_c_PropertyCallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property referredProperty = oclAsType_1.getReferredProperty();
        /*@Caught*/ /*@Nullable*/ Object CAUGHT_referredProperty;
        try {
            CAUGHT_referredProperty = referredProperty;
        }
        catch (Exception e) {
            CAUGHT_referredProperty = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_referredProperty == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_type_source;
        if (symbol_0 == Boolean.TRUE) {
            safe_type_source = null;
        }
        else {
            assert referredProperty != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class type = referredProperty.getType();
            safe_type_source = type;
        }
        // property assignments
        oclAsType.setType(safe_type_source);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_ownedCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * isOpCallExp()
     *   )
     * {_0 : classes::OperationCallExp[1];
     * _1 : classes::CallExp[1];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::OperationCallExp)
     *   ;
     * _1 := ownedNameExp.ast.oclAsType(classes::CallExp);
     * _0.ownedCallExp := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_ownedCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_4) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_4.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_4.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS ownedNameExp = nameExpCS_4.getOwnedNameExp();
        if (ownedNameExp == null) {
            throwNull(nameExpCS_4, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
        }
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownedNameExp.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
        // property assignments
        oclAsType.setOwnedCallExp(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_ownedArguments in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * isOpCallExp()
     *   )
     * {_0 : classes::OperationCallExp[1];
     * _1 : Sequence(classes::Argument);
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::OperationCallExp)
     *   ;
     * _1 := roundedBrackets.args.ast.oclAsType(classes::Argument);
     * _0.ownedArguments := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_ownedArguments(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_5) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_5.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_5.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_5.getRoundedBrackets();
        if (roundedBrackets_0 == null) {
            throwNull(nameExpCS_5, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::RoundedBracketClause::args\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ArgumentCS> args = roundedBrackets_0.getArgs();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_args = idResolver.createOrderedSetOfAll(ORD_CLSSid_ArgumentCS, args);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Argument);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_args.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable ArgumentCS _1 = (ArgumentCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Argument)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Argument_0 = idResolver.getClass(CLSSid_Argument, null);
            if (_1 == null) {
                throwNull(nameExpCS_5, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Argument oclAsType_0 = ClassUtil.nonNullState((Argument)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Argument_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Argument.class, collect);
        oclAsType.getOwnedArguments().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_referredOperation in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * isOpCallExp()
     *   )
     * {_0 : classes::OperationCallExp[1];
     * _1 : classes::Operation[?];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::OperationCallExp)
     *   ;
     * _1 := if
     *     oclContainer()
     *     .oclIsKindOf(classescs::NameExpCS)
     *   then
     *     ast.oclAsType(classes::CallExp)
     *     .lookupOperationFrom(
     *       ast.oclAsType(classes::CallExp).owningSource.type, name,
     *       ast.oclAsType(classes::CallExp)
     *       .oclAsType(classes::OperationCallExp).ownedArguments)
     *   else
     *     ast.oclAsType(classes::CallExp)
     *     .lookupOperation(name,
     *       ast.oclAsType(classes::CallExp)
     *       .oclAsType(classes::OperationCallExp).ownedArguments)
     *   endif;
     * _0.referredOperation := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_referredOperation(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_6) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_6.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_3 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_6.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp self_2 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_3));
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, nameExpCS_6);
        final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_classescs_c_c_NameExpCS_0).booleanValue());
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_8;
        if (oclIsKindOf) {
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_3));
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType_1 = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_0, TYP_classes_c_c_OperationCallExp_0));
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> args = oclAsType_1.getOwnedArguments();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = nameExpCS_6.getName();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp owningSource = oclAsType_0.getOwningSource();
            if (owningSource == null) {
                throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
            }
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class exporter = owningSource.getType();
            if (aPathNameCS == null) {
                throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
            final /*@Thrown*/ boolean eq = size.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_3;
            if (eq) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS == null) {
                    throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                ClassesLookupResult<Operation> _lookupResult = lookupSolver._lookupExportedOperation(exporter, self_2, name, (List<Argument>)args);
                Operation _lookupExportedOperation = null;
                if (_lookupResult.size() == 1) {
                    _lookupExportedOperation = _lookupResult.getSingleResult();
                } else {
                    handleLookupError(self_2,self_2);
                };
                symbol_3 = _lookupExportedOperation;
            }
            else {
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_1 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments));
                final /*@Thrown*/ boolean eq_0 = size_1.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                if (eq_0) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                    if (aPathElementCS_0 == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupClass(self_2, name_0);
                    example2.classes.Class _lookupClass = null;
                    if (_lookupResult_0.size() == 1) {
                        _lookupClass = _lookupResult_0.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_0,name_0);
                    };
                    symbol_1 = _lookupClass;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0));
                    final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments_0 != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_2, UNBOXED_qualifierSegments_0);
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_0 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                        if (aPathElementCS_1 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_1 = aPathElementCS_1.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_1 = lookupSolver._lookupQualifiedClass(qualifier, name_1);
                        example2.classes.Class _lookupQualifiedClass = null;
                        if (_lookupResult_1.size() == 1) {
                            _lookupQualifiedClass = _lookupResult_1.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_1,name_1);
                        };
                        safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                    }
                    symbol_1 = safe_lookupQualifiedClass_source;
                }
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_1;
                try {
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_symbol_1 == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation safe_lookupQualifiedOperation_source;
                if (symbol_2 == Boolean.TRUE) {
                    safe_lookupQualifiedOperation_source = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS_2 == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_2 = aPathElementCS_2.getName();
                    ClassesLookupResult<Operation> _lookupResult_2 = lookupSolver._lookupQualifiedOperation(symbol_1, name_2, (List<Argument>)args);
                    Operation _lookupQualifiedOperation = null;
                    if (_lookupResult_2.size() == 1) {
                        _lookupQualifiedOperation = _lookupResult_2.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_2,name_2);
                    };
                    safe_lookupQualifiedOperation_source = _lookupQualifiedOperation;
                }
                symbol_3 = safe_lookupQualifiedOperation_source;
            }
            symbol_8 = symbol_3;
        }
        else {
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_3 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_3));
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType_4 = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_3, TYP_classes_c_c_OperationCallExp_0));
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> args_0 = oclAsType_4.getOwnedArguments();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS_0 = nameExpCS_6.getName();
            if (aPathNameCS_0 == null) {
                throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_1 = aPathNameCS_0.getPath();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_1);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_3 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_1));
            final /*@Thrown*/ boolean eq_1 = size_3.equals(INT_1);
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_7;
            if (eq_1) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_3 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_1);
                if (aPathElementCS_3 == null) {
                    throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_3 = aPathElementCS_3.getName();
                ClassesLookupResult<Operation> _lookupResult_3 = lookupSolver._lookupOperation(self_2, name_3, (List<Argument>)args_0);
                Operation _lookupOperation = null;
                if (_lookupResult_3.size() == 1) {
                    _lookupOperation = _lookupResult_3.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_3,name_3);
                };
                symbol_7 = _lookupOperation;
            }
            else {
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_1 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_3, INT_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_1 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_1, INT_1, diff_1));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_5 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments_1));
                final /*@Thrown*/ boolean eq_2 = size_5.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                if (eq_2) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_4 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments_1);
                    if (aPathElementCS_4 == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_4 = aPathElementCS_4.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult_4 = lookupSolver._lookupClass(self_2, name_4);
                    example2.classes.Class _lookupClass_0 = null;
                    if (_lookupResult_4.size() == 1) {
                        _lookupClass_0 = _lookupResult_4.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_4,name_4);
                    };
                    symbol_5 = _lookupClass_0;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_2 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_5, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_2 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments_1, INT_1, diff_2));
                    final List<PathElementCS> UNBOXED_qualifierSegments_2 = qualifierSegments_2.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments_2 != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier_0 = this.lookupPackage(self_2, UNBOXED_qualifierSegments_2);
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier_0;
                    try {
                        CAUGHT_qualifier_0 = qualifier_0;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier_0 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_4 = CAUGHT_qualifier_0 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source_0;
                    if (symbol_4 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source_0 = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_5 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments_1);
                        if (aPathElementCS_5 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_5 = aPathElementCS_5.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_5 = lookupSolver._lookupQualifiedClass(qualifier_0, name_5);
                        example2.classes.Class _lookupQualifiedClass_0 = null;
                        if (_lookupResult_5.size() == 1) {
                            _lookupQualifiedClass_0 = _lookupResult_5.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_5,name_5);
                        };
                        safe_lookupQualifiedClass_source_0 = _lookupQualifiedClass_0;
                    }
                    symbol_5 = safe_lookupQualifiedClass_source_0;
                }
                /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_5;
                try {
                    CAUGHT_symbol_5 = symbol_5;
                }
                catch (Exception e) {
                    CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ /*@NonNull*/ Object symbol_6 = CAUGHT_symbol_5 == null;
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation safe_lookupQualifiedOperation_source_0;
                if (symbol_6 == Boolean.TRUE) {
                    safe_lookupQualifiedOperation_source_0 = null;
                }
                else {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_6 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_1);
                    if (aPathElementCS_6 == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_6 = aPathElementCS_6.getName();
                    ClassesLookupResult<Operation> _lookupResult_6 = lookupSolver._lookupQualifiedOperation(symbol_5, name_6, (List<Argument>)args_0);
                    Operation _lookupQualifiedOperation_0 = null;
                    if (_lookupResult_6.size() == 1) {
                        _lookupQualifiedOperation_0 = _lookupResult_6.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_6,name_6);
                    };
                    safe_lookupQualifiedOperation_source_0 = _lookupQualifiedOperation_0;
                }
                symbol_7 = safe_lookupQualifiedOperation_source_0;
            }
            symbol_8 = symbol_7;
        }
        // property assignments
        oclAsType.setReferredOperation(symbol_8);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * isOpCallExp()
     *   )
     * {_0 : classes::OperationCallExp[1];
     * _1 : classes::Class[?];
     *  |
     * _0 := nameExpCS.ast.oclAsType(classes::OperationCallExp)
     *   ;
     * _1 := ast.oclAsType(classes::CallExp)
     *   .oclAsType(classes::OperationCallExp).referredOperation?.type;
     * _0.type := _1;
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_7) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_7.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_7.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_CallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType_1 = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclAsType_0, TYP_classes_c_c_OperationCallExp_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation referredOperation = oclAsType_1.getReferredOperation();
        /*@Caught*/ /*@Nullable*/ Object CAUGHT_referredOperation;
        try {
            CAUGHT_referredOperation = referredOperation;
        }
        catch (Exception e) {
            CAUGHT_referredOperation = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_referredOperation == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_type_source;
        if (symbol_0 == Boolean.TRUE) {
            safe_type_source = null;
        }
        else {
            assert referredOperation != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class type = referredOperation.getType();
            safe_type_source = type;
        }
        // property assignments
        oclAsType.setType(safe_type_source);
        return true;
    }
    
    /**
     * 
     * map uOperation_name in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Operation[1];
     * _1 : String[?];
     *  |
     * _0 := operationCS.ast.oclAsType(classes::Operation);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uOperation_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = operationCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uOperation_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Operation[1];
     * _1 : classes::Class[?];
     *  |
     * _0 := operationCS.ast.oclAsType(classes::Operation)
     *   ;
     * _1 := ast.oclAsType(classes::Operation)
     *   .lookupClass(resultRef);
     * _0.type := _1;
     * }
     * 
     */
    protected boolean MAP_uOperation_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_1.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation self_1 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = operationCS_1.getResultRef();
        if (aPathNameCS == null) {
            throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
            if (aPathElementCS == null) {
                throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(self_1, name);
            example2.classes.Class _lookupClass = null;
            if (_lookupResult.size() == 1) {
                _lookupClass = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupClass;
        }
        else {
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
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
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedClass_source = null;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS_0 == null) {
                    throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
            symbol_1 = safe_lookupQualifiedClass_source;
        }
        // property assignments
        oclAsType.setType(symbol_1);
        return true;
    }
    
    /**
     * 
     * map uOperation_ownedParameters in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Operation[1];
     * _1 : Sequence(classes::Parameter[*|1]);
     *  |
     * _0 := operationCS.ast.oclAsType(classes::Operation)
     *   ;
     * _1 := params->collect(x | classes::Parameter{name = x});
     * _0.ownedParameters := _1;
     * }
     * 
     */
    protected boolean MAP_uOperation_ownedParameters(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_2.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<String> params = operationCS_2.getParams();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_params = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, params);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_params.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String x = (String)ITERATOR_x.next();
            /**
             * classes::Parameter{name = x}
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Parameter symbol_0 = (Parameter)TYP_classes_c_c_Parameter_0.createInstance();
            CTORid_name.initValue(symbol_0, x);
            //
            accumulator.add(symbol_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, collect);
        oclAsType.getOwnedParameters().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uOperation_ownedExpressions in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Operation[1];
     * _1 : Sequence(classes::CallExp);
     *  |
     * _0 := operationCS.ast.oclAsType(classes::Operation)
     *   ;
     * _1 := bodyExps.ast.oclAsType(classes::CallExp);
     * _0.ownedExpressions := _1;
     * }
     * 
     */
    protected boolean MAP_uOperation_ownedExpressions(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_3.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NameExpCS> bodyExps = operationCS_3.getBodyExps();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_bodyExps = idResolver.createOrderedSetOfAll(ORD_CLSSid_NameExpCS, bodyExps);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_CallExp);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_bodyExps.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS _1 = (NameExpCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::CallExp)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
            if (_1 == null) {
                throwNull(operationCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<CallExp> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(CallExp.class, collect);
        oclAsType.getOwnedExpressions().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uPackage_name in classescs2asV2_qvtp_qvtias {
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
     * map uPackage_ownedClasses in classescs2asV2_qvtp_qvtias {
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
                throwNull(packageCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
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
     * map uPackage_ownedPackages in classescs2asV2_qvtp_qvtias {
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
                throwNull(packageCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
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
     * map uProperty_name in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (propertyCS : classescs::PropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Property[1];
     * _1 : String[?];
     *  |
     * _0 := propertyCS.ast.oclAsType(classes::Property);
     * _1 := name;
     * _0.name := _1;
     * }
     * 
     */
    protected boolean MAP_uProperty_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = propertyCS_0.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Property_0));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = propertyCS_0.getName();
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uProperty_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (propertyCS : classescs::PropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : classes::Property[1];
     * _1 : classes::Class[?];
     *  |
     * _0 := propertyCS.ast.oclAsType(classes::Property)
     *   ;
     * _1 := ast.oclAsType(classes::Property)
     *   .lookupClass(typeRef);
     * _0.type := _1;
     * }
     * 
     */
    protected boolean MAP_uProperty_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = propertyCS_1.getAst();
        // variable assignments
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Property_0));
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property self_1 = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Property_0));
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = propertyCS_1.getTypeRef();
        if (aPathNameCS == null) {
            throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
            if (aPathElementCS == null) {
                throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(self_1, name);
            example2.classes.Class _lookupClass = null;
            if (_lookupResult.size() == 1) {
                _lookupClass = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupClass;
        }
        else {
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
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
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedClass_source = null;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS_0 == null) {
                    throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
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
            symbol_1 = safe_lookupQualifiedClass_source;
        }
        // property assignments
        oclAsType.setType(symbol_1);
        return true;
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2asV2_qvtp_qvtias {
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
                throwNull(rootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
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
     * map __root__ in classescs2asV2_qvtp_qvtias {
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
     *   for operationCS : classescs::OperationCS in classescs::OperationCS.allInstances()
     *    {
     * map cOperationCS_2_Operation {
     * operationCS := operationCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_ownedOperations {
     * classCS := classCS;
     * }}
     *   for propertyCS : classescs::PropertyCS in classescs::PropertyCS.allInstances()
     *    {
     * map cPropertyCS_2_Property {
     * propertyCS := propertyCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_ownedProperties {
     * classCS := classCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_superClass {
     * classCS := classCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map cNameExpCS_2_OperationCallExp {
     * nameExpCS := nameExpCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map cNameExpCS_2_PropertyCallExp {
     * nameExpCS := nameExpCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uOperationCallExp_ownedCallExp {
     * nameExpCS := nameExpCS;
     * }}
     *   for argumentCS : classescs::ArgumentCS in classescs::ArgumentCS.allInstances()
     *    {
     * map cArgumentCS_2_Argument {
     * argumentCS := argumentCS;
     * }}
     *   for argumentCS : classescs::ArgumentCS in classescs::ArgumentCS.allInstances()
     *    {
     * map uArgument_name {
     * argumentCS := argumentCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uOperationCallExp_ownedArguments {
     * nameExpCS := nameExpCS;
     * }}
     *   for operationCS : classescs::OperationCS in classescs::OperationCS.allInstances()
     *    {
     * map uOperation_name {
     * operationCS := operationCS;
     * }}
     *   for operationCS : classescs::OperationCS in classescs::OperationCS.allInstances()
     *    {
     * map uOperation_ownedExpressions {
     * operationCS := operationCS;
     * }}
     *   for operationCS : classescs::OperationCS in classescs::OperationCS.allInstances()
     *    {
     * map uOperation_ownedParameters {
     * operationCS := operationCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uPropertyCallExp_ownedCallExp {
     * nameExpCS := nameExpCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uOperationCallExp_referredOperation {
     * nameExpCS := nameExpCS;
     * }}
     *   for operationCS : classescs::OperationCS in classescs::OperationCS.allInstances()
     *    {
     * map uOperation_type {
     * operationCS := operationCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uOperationCallExp_type {
     * nameExpCS := nameExpCS;
     * }}
     *   for propertyCS : classescs::PropertyCS in classescs::PropertyCS.allInstances()
     *    {
     * map uProperty_name {
     * propertyCS := propertyCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uPropertyCallExp_referredProperty {
     * nameExpCS := nameExpCS;
     * }}
     *   for propertyCS : classescs::PropertyCS in classescs::PropertyCS.allInstances()
     *    {
     * map uProperty_type {
     * propertyCS := propertyCS;
     * }}
     *   for nameExpCS : classescs::NameExpCS in classescs::NameExpCS.allInstances()
     *    {
     * map uPropertyCallExp_type {
     * nameExpCS := nameExpCS;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ArgumentCS_1 = idResolver.getClass(CLSSid_ArgumentCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_4 = idResolver.getClass(CLSSid_ClassCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_8 = idResolver.getClass(CLSSid_NameExpCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_OperationCS_4 = idResolver.getClass(CLSSid_OperationCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_3 = idResolver.getClass(CLSSid_PackageCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PropertyCS_2 = idResolver.getClass(CLSSid_PropertyCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_16 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ArgumentCS, TYP_classescs_c_c_ArgumentCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_6 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_4));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_13 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_NameExpCS, TYP_classescs_c_c_NameExpCS_8));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_18 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_OperationCS, TYP_classescs_c_c_OperationCS_4));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_2 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_3));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_25 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PropertyCS, TYP_classescs_c_c_PropertyCS_2));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue allInstances_1 = ClassUtil.nonNullState(ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1));
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
        for (ClassCS classCS_9 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_9 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_12 = (ClassCS)classCS_9;
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
        for (ClassCS classCS_10 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_10 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_21 = (ClassCS)classCS_10;
                MAP_uClass_name(symbol_21);
            }
        }
        for (OperationCS operationCS_9 : ValueUtil.typedIterable(OperationCS.class, allInstances_18)) {
            if (operationCS_9 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_24 = (OperationCS)operationCS_9;
                MAP_cOperationCS_2_Operation(symbol_24);
            }
        }
        for (ClassCS classCS_11 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_11 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_27 = (ClassCS)classCS_11;
                MAP_uClass_ownedOperations(symbol_27);
            }
        }
        for (PropertyCS propertyCS_5 : ValueUtil.typedIterable(PropertyCS.class, allInstances_25)) {
            if (propertyCS_5 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_30 = (PropertyCS)propertyCS_5;
                MAP_cPropertyCS_2_Property(symbol_30);
            }
        }
        for (ClassCS classCS_12 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_12 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_33 = (ClassCS)classCS_12;
                MAP_uClass_ownedProperties(symbol_33);
            }
        }
        for (ClassCS classCS_13 : ValueUtil.typedIterable(ClassCS.class, allInstances_6)) {
            if (classCS_13 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_36 = (ClassCS)classCS_13;
                MAP_uClass_superClass(symbol_36);
            }
        }
        for (NameExpCS nameExpCS_17 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_17 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_39 = (NameExpCS)nameExpCS_17;
                MAP_cNameExpCS_2_OperationCallExp(symbol_39);
            }
        }
        for (NameExpCS nameExpCS_18 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_18 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_42 = (NameExpCS)nameExpCS_18;
                MAP_cNameExpCS_2_PropertyCallExp(symbol_42);
            }
        }
        for (NameExpCS nameExpCS_19 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_19 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_45 = (NameExpCS)nameExpCS_19;
                MAP_uOperationCallExp_ownedCallExp(symbol_45);
            }
        }
        for (ArgumentCS argumentCS_3 : ValueUtil.typedIterable(ArgumentCS.class, allInstances_16)) {
            if (argumentCS_3 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS symbol_48 = (ArgumentCS)argumentCS_3;
                MAP_cArgumentCS_2_Argument(symbol_48);
            }
        }
        for (ArgumentCS argumentCS_4 : ValueUtil.typedIterable(ArgumentCS.class, allInstances_16)) {
            if (argumentCS_4 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS symbol_51 = (ArgumentCS)argumentCS_4;
                MAP_uArgument_name(symbol_51);
            }
        }
        for (NameExpCS nameExpCS_20 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_20 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_54 = (NameExpCS)nameExpCS_20;
                MAP_uOperationCallExp_ownedArguments(symbol_54);
            }
        }
        for (OperationCS operationCS_10 : ValueUtil.typedIterable(OperationCS.class, allInstances_18)) {
            if (operationCS_10 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_57 = (OperationCS)operationCS_10;
                MAP_uOperation_name(symbol_57);
            }
        }
        for (OperationCS operationCS_11 : ValueUtil.typedIterable(OperationCS.class, allInstances_18)) {
            if (operationCS_11 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_60 = (OperationCS)operationCS_11;
                MAP_uOperation_ownedExpressions(symbol_60);
            }
        }
        for (OperationCS operationCS_12 : ValueUtil.typedIterable(OperationCS.class, allInstances_18)) {
            if (operationCS_12 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_63 = (OperationCS)operationCS_12;
                MAP_uOperation_ownedParameters(symbol_63);
            }
        }
        for (NameExpCS nameExpCS_21 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_21 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_66 = (NameExpCS)nameExpCS_21;
                MAP_uPropertyCallExp_ownedCallExp(symbol_66);
            }
        }
        for (NameExpCS nameExpCS_22 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_22 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_69 = (NameExpCS)nameExpCS_22;
                MAP_uOperationCallExp_referredOperation(symbol_69);
            }
        }
        for (OperationCS operationCS_13 : ValueUtil.typedIterable(OperationCS.class, allInstances_18)) {
            if (operationCS_13 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_72 = (OperationCS)operationCS_13;
                MAP_uOperation_type(symbol_72);
            }
        }
        for (NameExpCS nameExpCS_23 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_23 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_75 = (NameExpCS)nameExpCS_23;
                MAP_uOperationCallExp_type(symbol_75);
            }
        }
        for (PropertyCS propertyCS_6 : ValueUtil.typedIterable(PropertyCS.class, allInstances_25)) {
            if (propertyCS_6 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_78 = (PropertyCS)propertyCS_6;
                MAP_uProperty_name(symbol_78);
            }
        }
        for (NameExpCS nameExpCS_24 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_24 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_81 = (NameExpCS)nameExpCS_24;
                MAP_uPropertyCallExp_referredProperty(symbol_81);
            }
        }
        for (PropertyCS propertyCS_7 : ValueUtil.typedIterable(PropertyCS.class, allInstances_25)) {
            if (propertyCS_7 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_84 = (PropertyCS)propertyCS_7;
                MAP_uProperty_type(symbol_84);
            }
        }
        for (NameExpCS nameExpCS_25 : ValueUtil.typedIterable(NameExpCS.class, allInstances_13)) {
            if (nameExpCS_25 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_87 = (NameExpCS)nameExpCS_25;
                MAP_uPropertyCallExp_type(symbol_87);
            }
        }
        return true;
    }
}
