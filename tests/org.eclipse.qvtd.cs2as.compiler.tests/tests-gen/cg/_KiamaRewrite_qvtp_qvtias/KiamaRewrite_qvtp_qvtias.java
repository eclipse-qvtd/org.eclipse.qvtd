/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._KiamaRewrite_qvtp_qvtias;

import example3.kiamaas.KiamaasFactory;
import example3.kiamaas.KiamaasPackage;
import example3.kiamaas.Node;
import example3.kiamaas.Num;
import example3.kiamaas.Plus;
import example3.kiamaas.Top;
import example3.kiamacs.KiamacsPackage;
import example3.kiamacs.NodeCS;
import example3.kiamacs.NumCS;
import example3.kiamacs.PlusCS;
import example3.kiamacs.TopCS;
import java.lang.reflect.Constructor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionMaxOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;

/**
 * The KiamaRewrite_qvtp_qvtias transformation:
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
public class KiamaRewrite_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamaas_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example3/kiamaas/1.0", null, KiamaasPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamacs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example3/kiamacs/1.0", null, KiamacsPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Node = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamaas_s_1_0.getClassId("Node", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NodeCS = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamacs_s_1_0.getClassId("NodeCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Num = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamaas_s_1_0.getClassId("Num", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NumCS = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamacs_s_1_0.getClassId("NumCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Plus = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamaas_s_1_0.getClassId("Plus", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PlusCS = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamacs_s_1_0.getClassId("PlusCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Top = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamaas_s_1_0.getClassId("Top", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TopCS = PACKid_http_c_s_s_cs2as_s_tests_s_example3_s_kiamacs_s_1_0.getClassId("TopCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ DataTypeId DATAid_EInt = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ DataTypeId DATAid_EIntegerObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_NumCS = TypeId.SET.getSpecializedId(CLSSid_NumCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PlusCS = TypeId.SET.getSpecializedId(CLSSid_PlusCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TopCS = TypeId.SET.getSpecializedId(CLSSid_TopCS);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_DATAid_EIntegerObject = TypeId.SET.getSpecializedId(DATAid_EIntegerObject);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final /*@NonNull*/ ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_NumCS,                   // 0 => NumCS
        CLSSid_PlusCS,                  // 1 => PlusCS
        CLSSid_TopCS                    // 2 => TopCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static /*@NonNull*/ int[][] classIndex2allClassIndexes = new int[][] {
        {0},                    // 0 : NumCS -> {NumCS}
        {1},                    // 1 : PlusCS -> {PlusCS}
        {2}                     // 2 : TopCS -> {TopCS}
    };
    
    protected final /*@NonNull*/ Constructor<MAP_uNum_depth> CTOR_uNum_depth;
    protected final /*@NonNull*/ Constructor<MAP_uPlus_depth> CTOR_uPlus_depth;
    protected final /*@NonNull*/ Constructor<MAP_uPlus_height> CTOR_uPlus_height;
    
    public KiamaRewrite_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
        CTOR_uNum_depth = ClassUtil.nonNullState(MAP_uNum_depth.class.getConstructor(KiamaRewrite_qvtp_qvtias.class, Object[].class));
        CTOR_uPlus_depth = ClassUtil.nonNullState(MAP_uPlus_depth.class.getConstructor(KiamaRewrite_qvtp_qvtias.class, Object[].class));
        CTOR_uPlus_height = ClassUtil.nonNullState(MAP_uPlus_height.class.getConstructor(KiamaRewrite_qvtp_qvtias.class, Object[].class));
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    /**
     * 
     * map cNumCS_2_Num in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (numCS : kiamacs::NumCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize num : kiamaas::Num[1];
     *  |}
     * where ( |)
     * { |
     * numCS.ast := num;
     * }
     * map uNum_value {
     * numCS := numCS;
     * }
     *   map uNum_height {
     * numCS := numCS;
     * }
     */
    protected boolean MAP_cNumCS_2_Num(final /*@NonNull*/ /*@NonInvalid*/ NumCS numCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Num num = KiamaasFactory.eINSTANCE.createNum();
        assert num != null;
        models[1/*rightAS*/].add(num);
        // property assignments
        numCS.setAst(num);
        objectManager.assigned(numCS, KiamacsPackage.Literals.BASE_CS__AST, num);
        // mapping statements
        MAP_uNum_value(numCS);
        MAP_uNum_height(numCS);
        return true;
    }
    
    /**
     * 
     * map cPlusCS_2_Plus in KiamaRewrite_qvtp_qvtias {
     * leftCS (plusCS : kiamacs::PlusCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize plus : kiamaas::Plus[1];
     *  |}
     * where ( |)
     * { |
     * plusCS.ast := plus;
     * }
     * 
     */
    protected boolean MAP_cPlusCS_2_Plus(final /*@NonNull*/ /*@NonInvalid*/ PlusCS plusCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Plus plus = KiamaasFactory.eINSTANCE.createPlus();
        assert plus != null;
        models[1/*rightAS*/].add(plus);
        // property assignments
        plusCS.setAst(plus);
        objectManager.assigned(plusCS, KiamacsPackage.Literals.BASE_CS__AST, plus);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cTopCS_2_Top in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (topCS : kiamacs::TopCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize top : kiamaas::Top[1];
     *  |}
     * where ( |)
     * { |
     * topCS.ast := top;
     * }
     * map uTop_node {
     * topCS := topCS;
     * }
     */
    protected boolean MAP_cTopCS_2_Top(final /*@NonNull*/ /*@NonInvalid*/ TopCS topCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Top top = KiamaasFactory.eINSTANCE.createTop();
        assert top != null;
        models[1/*rightAS*/].add(top);
        // property assignments
        topCS.setAst(top);
        objectManager.assigned(topCS, KiamacsPackage.Literals.BASE_CS__AST, top);
        // mapping statements
        MAP_uTop_node(topCS);
        return true;
    }
    
    /**
     * 
     * map uNum_value in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (numCS : kiamacs::NumCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Num[1];
     * _1 : ecore::EInt[?];
     *  |
     * _0 := numCS.ast.oclAsType(kiamaas::Num);
     * _1 := value;
     * _0.value := _1;
     * }
     * 
     */
    protected boolean MAP_uNum_value(final /*@NonNull*/ /*@NonInvalid*/ NumCS numCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Num_0 = idResolver.getClass(CLSSid_Num, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(numCS_0, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Num oclAsType = ClassUtil.nonNullState((Num)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Num_0));
        final /*@Thrown*/ int value = numCS_0.getValue();
        // property assignments
        oclAsType.setValue(value);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uNum_depth in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (numCS : kiamacs::NumCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Num[1];
     * _1 : Integer[1];
     *  |
     * _0 := numCS.ast.oclAsType(kiamaas::Num)
     *   ;
     * _1 := let
     *     container : OclElement[?] = ast.oclAsType(kiamaas::Num)
     *     .oclContainer();
     * 
     *   in
     *     if container.oclIsKindOf(kiamaas::Top)
     *     then 0
     *     else container.oclAsType(kiamaas::Plus).depth + 1
     *     endif;
     * _0.depth := _1;
     * }
     * 
     */
    protected class MAP_uNum_depth extends AbstractInvocation
    {
        protected final /*@NonNull*/ /*@NonInvalid*/ NumCS numCS_1;
        
        @SuppressWarnings("null")
        public MAP_uNum_depth(/*@NonNull*/ Object[] boundValues) {
            numCS_1 = (NumCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Num_0 = idResolver.getClass(CLSSid_Num, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(numCS_1, KiamacsPackage.Literals.BASE_CS__AST);
            final /*@NonNull*/ /*@Thrown*/ Num oclAsType = ClassUtil.nonNullState((Num)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Num_0));
            // variable assignments
            final /*@Nullable*/ /*@Thrown*/ Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, oclAsType);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_kiamaas_c_c_Top_0).booleanValue();
            /*@NonNull*/ /*@Thrown*/ IntegerValue symbol_0;
            if (oclIsKindOf) {
                symbol_0 = INT_0;
            }
            else {
                final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Plus_0 = idResolver.getClass(CLSSid_Plus, null);
                final /*@NonNull*/ /*@Thrown*/ Plus oclAsType_1 = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_kiamaas_c_c_Plus_0));
                final /*@Nullable*/ /*@Thrown*/ Integer depth = objectManager.get(oclAsType_1, KiamaasPackage.Literals.NODE__DEPTH);
                final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1);
                symbol_0 = sum;
            }
            // property assignments
            final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
            oclAsType.setDepth(ECORE_symbol_0);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__DEPTH, ECORE_symbol_0);
            // mapping statements
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(numCS_1, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uNum_height in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (numCS : kiamacs::NumCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Num[1];
     *  |
     * _0 := numCS.ast.oclAsType(kiamaas::Num);
     * _0.height := 0;
     * }
     * 
     */
    protected boolean MAP_uNum_height(final /*@NonNull*/ /*@NonInvalid*/ NumCS numCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Num_0 = idResolver.getClass(CLSSid_Num, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(numCS_2, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Num oclAsType = ClassUtil.nonNullState((Num)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Num_0));
        // property assignments
        final Integer ECORE_INT_0 = ValueUtil.intValueOf(INT_0);
        oclAsType.setHeight(ECORE_INT_0);
        objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_INT_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPlus_left in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (plusCS : kiamacs::PlusCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Plus[1];
     * _1 : kiamaas::Node[1];
     *  |
     * _0 := plusCS.ast.oclAsType(kiamaas::Plus)
     *   ;
     * _1 := left.ast.oclAsType(kiamaas::Node);
     * _0.left := _1;
     * }
     * 
     */
    protected boolean MAP_uPlus_left(final /*@NonNull*/ /*@NonInvalid*/ PlusCS plusCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Plus_0 = idResolver.getClass(CLSSid_Plus, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(plusCS_0, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Plus oclAsType = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Plus_0));
        final /*@Nullable*/ /*@Thrown*/ NodeCS left = plusCS_0.getLeft();
        if (left == null) {
            throwNull(plusCS_0, "Null source for \'\'http://cs2as/tests/example3/kiamacs/1.0\'::BaseCS::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = objectManager.get(left, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setLeft(oclAsType_0);
        objectManager.assigned(oclAsType, KiamaasPackage.Literals.PLUS__LEFT, oclAsType_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPlus_right in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (plusCS : kiamacs::PlusCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Plus[1];
     * _1 : kiamaas::Node[1];
     *  |
     * _0 := plusCS.ast.oclAsType(kiamaas::Plus)
     *   ;
     * _1 := right.ast.oclAsType(kiamaas::Node);
     * _0.right := _1;
     * }
     * 
     */
    protected boolean MAP_uPlus_right(final /*@NonNull*/ /*@NonInvalid*/ PlusCS plusCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Plus_0 = idResolver.getClass(CLSSid_Plus, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(plusCS_1, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Plus oclAsType = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Plus_0));
        final /*@Nullable*/ /*@Thrown*/ NodeCS right = plusCS_1.getRight();
        if (right == null) {
            throwNull(plusCS_1, "Null source for \'\'http://cs2as/tests/example3/kiamacs/1.0\'::BaseCS::ast\'");
        }
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = objectManager.get(right, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setRight(oclAsType_0);
        objectManager.assigned(oclAsType, KiamaasPackage.Literals.PLUS__RIGHT, oclAsType_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPlus_depth in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (plusCS : kiamacs::PlusCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Plus[1];
     * _1 : Integer[1];
     *  |
     * _0 := plusCS.ast.oclAsType(kiamaas::Plus)
     *   ;
     * _1 := let
     *     container : OclElement[?] = ast.oclAsType(kiamaas::Plus)
     *     .oclContainer();
     * 
     *   in
     *     if container.oclIsKindOf(kiamaas::Top)
     *     then 0
     *     else container.oclAsType(kiamaas::Plus).depth + 1
     *     endif;
     * _0.depth := _1;
     * }
     * 
     */
    protected class MAP_uPlus_depth extends AbstractInvocation
    {
        protected final /*@NonNull*/ /*@NonInvalid*/ PlusCS plusCS_2;
        
        @SuppressWarnings("null")
        public MAP_uPlus_depth(/*@NonNull*/ Object[] boundValues) {
            plusCS_2 = (PlusCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Plus_0 = idResolver.getClass(CLSSid_Plus, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(plusCS_2, KiamacsPackage.Literals.BASE_CS__AST);
            final /*@NonNull*/ /*@Thrown*/ Plus oclAsType = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Plus_0));
            // variable assignments
            final /*@Nullable*/ /*@Thrown*/ Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, oclAsType);
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_kiamaas_c_c_Top_0).booleanValue();
            /*@NonNull*/ /*@Thrown*/ IntegerValue symbol_0;
            if (oclIsKindOf) {
                symbol_0 = INT_0;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ Plus oclAsType_1 = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_kiamaas_c_c_Plus_0));
                final /*@Nullable*/ /*@Thrown*/ Integer depth = objectManager.get(oclAsType_1, KiamaasPackage.Literals.NODE__DEPTH);
                final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_depth = depth == null ? null : ValueUtil.integerValueOf(depth);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_depth, INT_1);
                symbol_0 = sum;
            }
            // property assignments
            final Integer ECORE_symbol_0 = ValueUtil.intValueOf(symbol_0);
            oclAsType.setDepth(ECORE_symbol_0);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__DEPTH, ECORE_symbol_0);
            // mapping statements
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(plusCS_2, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uPlus_height in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (plusCS : kiamacs::PlusCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Plus[1];
     * _1 : Integer[1];
     *  |
     * _0 := plusCS.ast.oclAsType(kiamaas::Plus)
     *   ;
     * _1 := ast.oclAsType(kiamaas::Plus)
     *   .left.height->including(
     *     ast.oclAsType(kiamaas::Plus).right.height)
     *   ->max() + 1;
     * _0.height := _1;
     * }
     * 
     */
    protected class MAP_uPlus_height extends AbstractInvocation
    {
        protected final /*@NonNull*/ /*@NonInvalid*/ PlusCS plusCS_3;
        
        @SuppressWarnings("null")
        public MAP_uPlus_height(/*@NonNull*/ Object[] boundValues) {
            plusCS_3 = (PlusCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
            final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Plus_0 = idResolver.getClass(CLSSid_Plus, null);
            final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(plusCS_3, KiamacsPackage.Literals.BASE_CS__AST);
            final /*@NonNull*/ /*@Thrown*/ Plus oclAsType = ClassUtil.nonNullState((Plus)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Plus_0));
            // variable assignments
            final /*@Nullable*/ /*@Thrown*/ Node left = objectManager.get(oclAsType, KiamaasPackage.Literals.PLUS__LEFT);
            if (left == null) {
                throwNull(plusCS_3, "Null source for \'\'http://cs2as/tests/example3/kiamaas/1.0\'::Node::height\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Integer height = objectManager.get(left, KiamaasPackage.Literals.NODE__HEIGHT);
            final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_height = height == null ? null : ValueUtil.integerValueOf(height);
            final /*@NonNull*/ /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_DATAid_EIntegerObject, BOXED_height);
            final /*@Nullable*/ /*@Thrown*/ Node right = objectManager.get(oclAsType, KiamaasPackage.Literals.PLUS__RIGHT);
            if (right == null) {
                throwNull(plusCS_3, "Null source for \'\'http://cs2as/tests/example3/kiamaas/1.0\'::Node::height\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Integer height_0 = objectManager.get(right, KiamaasPackage.Literals.NODE__HEIGHT);
            final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_height_0 = height_0 == null ? null : ValueUtil.integerValueOf(height_0);
            final /*@NonNull*/ /*@Thrown*/ SetValue including = (SetValue)CollectionIncludingOperation.INSTANCE.evaluate(oclAsSet, BOXED_height_0);
            final /*@NonNull*/ /*@Thrown*/ IntegerValue max = (IntegerValue)CollectionMaxOperation.INSTANCE.evaluate(including);
            final /*@NonNull*/ /*@Thrown*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(max, INT_1);
            // property assignments
            final Integer ECORE_sum = ValueUtil.intValueOf(sum);
            oclAsType.setHeight(ECORE_sum);
            objectManager.assigned(oclAsType, KiamaasPackage.Literals.NODE__HEIGHT, ECORE_sum);
            // mapping statements
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(plusCS_3, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uTop_node in KiamaRewrite_qvtp_qvtias {
     * 
     *   leftCS (topCS : kiamacs::TopCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {_0 : kiamaas::Top[1];
     * _1 : kiamaas::Node[1];
     *  |
     * _0 := topCS.ast.oclAsType(kiamaas::Top)
     *   ;
     * _1 := node.ast.oclAsType(kiamaas::Node);
     * _0.node := _1;
     * }
     * 
     */
    protected boolean MAP_uTop_node(final /*@NonNull*/ /*@NonInvalid*/ TopCS topCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Node_0 = idResolver.getClass(CLSSid_Node, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamaas_c_c_Top_0 = idResolver.getClass(CLSSid_Top, null);
        // variable assignments
        final /*@Nullable*/ /*@Thrown*/ EObject ast = objectManager.get(topCS_0, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Top oclAsType = ClassUtil.nonNullState((Top)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_kiamaas_c_c_Top_0));
        final /*@NonNull*/ /*@Thrown*/ NodeCS node = topCS_0.getNode();
        final /*@Nullable*/ /*@Thrown*/ EObject ast_0 = objectManager.get(node, KiamacsPackage.Literals.BASE_CS__AST);
        final /*@NonNull*/ /*@Thrown*/ Node oclAsType_0 = ClassUtil.nonNullState((Node)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_kiamaas_c_c_Node_0));
        // property assignments
        oclAsType.setNode(oclAsType_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map __root__ in KiamaRewrite_qvtp_qvtias {
     * 
     *   where ( |)
     * { |}
     * for _numCS_NumCS : kiamacs::NumCS in kiamacs::NumCS.allInstances()
     *    {
     * map cNumCS_2_Num {
     * numCS := _numCS_NumCS;
     * }}
     *   for _plusCS_PlusCS : kiamacs::PlusCS in kiamacs::PlusCS.allInstances()
     *    {
     * map cPlusCS_2_Plus {
     * plusCS := _plusCS_PlusCS;
     * }}
     *   for _plusCS_PlusCS : kiamacs::PlusCS in kiamacs::PlusCS.allInstances()
     *    {
     * map uPlus_left {
     * plusCS := _plusCS_PlusCS;
     * }}
     *   for _plusCS_PlusCS : kiamacs::PlusCS in kiamacs::PlusCS.allInstances()
     *    {
     * map uPlus_right {
     * plusCS := _plusCS_PlusCS;
     * }}
     *   for _topCS_TopCS : kiamacs::TopCS in kiamacs::TopCS.allInstances()
     *    {
     * map cTopCS_2_Top {
     * topCS := _topCS_TopCS;
     * }}
     *   for _plusCS_PlusCS : kiamacs::PlusCS in kiamacs::PlusCS.allInstances()
     *    {
     * infinite map uPlus_height {
     * plusCS ?= _plusCS_PlusCS;
     * }}
     *   for _numCS_NumCS : kiamacs::NumCS in kiamacs::NumCS.allInstances()
     *    {
     * infinite map uNum_depth {
     * numCS ?= _numCS_NumCS;
     * }}
     *   for _plusCS_PlusCS : kiamacs::PlusCS in kiamacs::PlusCS.allInstances()
     *    {
     * infinite map uPlus_depth {
     * plusCS ?= _plusCS_PlusCS;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_NumCS_1 = idResolver.getClass(CLSSid_NumCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_PlusCS_4 = idResolver.getClass(CLSSid_PlusCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ Class TYP_kiamacs_c_c_TopCS_0 = idResolver.getClass(CLSSid_TopCS, null);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_5 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_NumCS, TYP_kiamacs_c_c_NumCS_1);
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_PlusCS, TYP_kiamacs_c_c_PlusCS_4);
        // mapping statements
        for (NumCS _numCS_NumCS : ValueUtil.typedIterable(NumCS.class, allInstances_5)) {
            if (_numCS_NumCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ NumCS symbol_0 = (NumCS)_numCS_NumCS;
                MAP_cNumCS_2_Num(symbol_0);
            }
        }
        for (PlusCS _plusCS_PlusCS : ValueUtil.typedIterable(PlusCS.class, allInstances_1)) {
            if (_plusCS_PlusCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PlusCS symbol_2 = (PlusCS)_plusCS_PlusCS;
                MAP_cPlusCS_2_Plus(symbol_2);
            }
        }
        for (PlusCS _plusCS_PlusCS_0 : ValueUtil.typedIterable(PlusCS.class, allInstances_1)) {
            if (_plusCS_PlusCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PlusCS symbol_4 = (PlusCS)_plusCS_PlusCS_0;
                MAP_uPlus_left(symbol_4);
            }
        }
        for (PlusCS _plusCS_PlusCS_1 : ValueUtil.typedIterable(PlusCS.class, allInstances_1)) {
            if (_plusCS_PlusCS_1 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PlusCS symbol_6 = (PlusCS)_plusCS_PlusCS_1;
                MAP_uPlus_right(symbol_6);
            }
        }
        final /*@NonNull*/ /*@NonInvalid*/ SetValue allInstances_3 = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_TopCS, TYP_kiamacs_c_c_TopCS_0);
        for (TopCS _topCS_TopCS : ValueUtil.typedIterable(TopCS.class, allInstances_3)) {
            if (_topCS_TopCS != null) {
                final /*@NonNull*/ /*@NonInvalid*/ TopCS symbol_8 = (TopCS)_topCS_TopCS;
                MAP_cTopCS_2_Top(symbol_8);
            }
        }
        for (PlusCS _plusCS_PlusCS_2 : ValueUtil.typedIterable(PlusCS.class, allInstances_1)) {
            if (_plusCS_PlusCS_2 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PlusCS symbol_10 = (PlusCS)_plusCS_PlusCS_2;
                invokeOnce(CTOR_uPlus_height, symbol_10);
            }
        }
        for (NumCS _numCS_NumCS_0 : ValueUtil.typedIterable(NumCS.class, allInstances_5)) {
            if (_numCS_NumCS_0 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ NumCS symbol_12 = (NumCS)_numCS_NumCS_0;
                invokeOnce(CTOR_uNum_depth, symbol_12);
            }
        }
        for (PlusCS _plusCS_PlusCS_3 : ValueUtil.typedIterable(PlusCS.class, allInstances_1)) {
            if (_plusCS_PlusCS_3 != null) {
                final /*@NonNull*/ /*@NonInvalid*/ PlusCS symbol_14 = (PlusCS)_plusCS_PlusCS_3;
                invokeOnce(CTOR_uPlus_depth, symbol_14);
            }
        }
        return true;
    }
}
