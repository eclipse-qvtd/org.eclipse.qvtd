/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2as_Bug459225;

import classes.ClassesFactory;
import classes.ClassesPackage;
import classes.Package;
import classescs.ClassescsPackage;
import classescs.NamedElementCS;
import classescs.PackageCS;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
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
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * The classescs2as_Bug459225 transformation:
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
public class classescs2as_Bug459225 extends AbstractTransformer
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElementCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("NamedElementCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ String STR__c_c = "::";
    public static final @NonNull /*@NonInvalid*/ String STR_unnamed = "unnamed";
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_PackageCS                // 0 => PackageCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0}                     // 0 : PackageCS -> {PackageCS}
    };
    
    
    public classescs2as_Bug459225(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * classescs::NamedElementCS::computeName() : String[?]
     * 
     * 
     * let container : OclElement[?] = self.oclContainer()
     * in
     *   if
     *     not container.oclIsUndefined() and
     *     container.oclIsKindOf(NamedElementCS)
     *   then
     *     container.oclAsType(NamedElementCS)
     *     .computeName() + '::' + self.name
     *   else self.name
     *   endif
     */
    public @Nullable /*@NonInvalid*/ String computeName(final @NonNull /*@NonInvalid*/ NamedElementCS self_0) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @Nullable /*@NonInvalid*/ Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_0);
        final @Nullable /*@Thrown*/ String name_0 = self_0.getName();
        final /*@NonInvalid*/ boolean symbol_0 = container == null;
        final @Nullable /*@NonInvalid*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_0);
        @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
        try {
            final @NonNull /*@NonInvalid*/ Class TYP_classescs_c_c_NamedElementCS_0 = idResolver.getClass(CLSSid_NamedElementCS, null);
            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_classescs_c_c_NamedElementCS_0).booleanValue();
            CAUGHT_oclIsKindOf = oclIsKindOf;
        }
        catch (Exception e) {
            CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
        }
        final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(not, CAUGHT_oclIsKindOf);
        if (and == null) {
            throw new InvalidValueException("Null if condition");
        }
        @Nullable /*@Thrown*/ String symbol_1;
        if (and) {
            final @NonNull /*@NonInvalid*/ Class TYP_classescs_c_c_NamedElementCS_1 = idResolver.getClass(CLSSid_NamedElementCS, null);
            final @NonNull /*@Thrown*/ NamedElementCS oclAsType = ClassUtil.nonNullState((NamedElementCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_classescs_c_c_NamedElementCS_1));
            final @Nullable /*@Thrown*/ String computeName = this.computeName(oclAsType);
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(computeName, STR__c_c);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
            symbol_1 = sum_0;
        }
        else {
            symbol_1 = name_0;
        }
        return symbol_1;
    }
    
    /**
     * 
     * map createPackage in classescs2as_Bug459225 {
     * 
     *   leftCS (packageCS : classescs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize package : classes::Package[1];
     *  |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := if
     *     packageCS.hasName()
     *   then packageCS.computeName()
     *   else 'unnamed'
     *   endif;
     * package.name := _0;
     * }
     * 
     */
    protected boolean MAP_createPackage(final @NonNull /*@NonInvalid*/ PackageCS packageCS) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        @Nullable /*@Caught*/ Object CAUGHT_name;
        try {
            final @Nullable /*@Thrown*/ String name = packageCS.getName();
            CAUGHT_name = name;
        }
        catch (Exception e) {
            CAUGHT_name = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ boolean symbol_1 = (CAUGHT_name == null) || (CAUGHT_name instanceof InvalidValueException);
        final @Nullable /*@NonInvalid*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
        if (not == null) {
            throw new InvalidValueException("Null if condition");
        }
        @Nullable /*@Thrown*/ String symbol_2;
        if (not) {
            final @Nullable /*@Thrown*/ String computeName = this.computeName(packageCS);
            symbol_2 = computeName;
        }
        else {
            symbol_2 = STR_unnamed;
        }
        // creations
        final /*@Thrown*/ Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        symbol_0.setName(symbol_2);
        return true;
    }
    
    /**
     * 
     * map __root__ in classescs2as_Bug459225 {
     * 
     *   where ( |)
     * { |}
     * for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map createPackage {
     * packageCS := packageCS;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final @NonNull /*@NonInvalid*/ Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
        final @NonNull /*@NonInvalid*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_0);
        for (PackageCS packageCS_1 : ValueUtil.typedIterable(PackageCS.class, allInstances)) {
            if (packageCS_1 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_0 = (PackageCS)packageCS_1;
                MAP_createPackage(symbol_0);
            }
        }
        return true;
    }
}
