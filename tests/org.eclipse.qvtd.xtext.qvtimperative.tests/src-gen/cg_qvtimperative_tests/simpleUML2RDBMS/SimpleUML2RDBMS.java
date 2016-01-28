/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg_qvtimperative_tests.simpleUML2RDBMS;

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
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfKindOperation;
import simpleuml2rdbms.rdbms.Column;
import simpleuml2rdbms.rdbms.ForeignKey;
import simpleuml2rdbms.rdbms.Key;
import simpleuml2rdbms.rdbms.RDBMSFactory;
import simpleuml2rdbms.rdbms.RDBMSPackage;
import simpleuml2rdbms.rdbms.Schema;
import simpleuml2rdbms.rdbms.Table;
import simpleuml2rdbms.uml.Association;
import simpleuml2rdbms.uml.Attribute;
import simpleuml2rdbms.uml.Classifier;
import simpleuml2rdbms.uml.Package;
import simpleuml2rdbms.uml.PrimitiveDataType;
import simpleuml2rdbms.uml.UMLPackage;
import simpleuml2rdbms.uml2rdbms.AssociationToForeignKey;
import simpleuml2rdbms.uml2rdbms.AttributeToColumn;
import simpleuml2rdbms.uml2rdbms.BooleanToBoolean;
import simpleuml2rdbms.uml2rdbms.ClassToTable;
import simpleuml2rdbms.uml2rdbms.FromAttribute;
import simpleuml2rdbms.uml2rdbms.FromAttributeOwner;
import simpleuml2rdbms.uml2rdbms.IntegerToNumber;
import simpleuml2rdbms.uml2rdbms.NonLeafAttribute;
import simpleuml2rdbms.uml2rdbms.PackageToSchema;
import simpleuml2rdbms.uml2rdbms.PrimitiveToName;
import simpleuml2rdbms.uml2rdbms.StringToVarchar;
import simpleuml2rdbms.uml2rdbms.UML2RDBMSFactory;
import simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage;

/**
 * The SimpleUML2RDBMS transformation:
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
public class SimpleUML2RDBMS extends AbstractTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/SimpleRDBMS", null, RDBMSPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/SimpleUML", null, UMLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS", null, UML2RDBMSPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Association = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("Association", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_AssociationToForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("AssociationToForeignKey", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("Attribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_AttributeToColumn = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("AttributeToColumn", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_BooleanToBoolean = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("BooleanToBoolean", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassToTable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("ClassToTable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Classifier = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("Classifier", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Column = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Column", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("ForeignKey", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_FromAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("FromAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_FromAttributeOwner = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("FromAttributeOwner", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IntegerToNumber = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("IntegerToNumber", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Key = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Key", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NonLeafAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("NonLeafAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PackageToSchema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("PackageToSchema", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PrimitiveDataType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML.getClassId("PrimitiveDataType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PrimitiveToName = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("PrimitiveToName", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Schema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Schema", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_StringToVarchar = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleUML2RDBMS.getClassId("StringToVarchar", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Table = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Table", 0);
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_2 = "2";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_BOOLEAN = "BOOLEAN";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Boolean = "Boolean";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Integer = "Integer";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_NUMBER = "NUMBER";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_String = "String";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_VARCHAR = "VARCHAR";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__ = "_";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__pk = "_pk";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__tid = "_tid";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_base = "base";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_persistent = "persistent";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_primary = "primary";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_AttributeToColumn = TypeId.BAG.getSpecializedId(CLSSid_AttributeToColumn);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Column = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Column);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ForeignKey = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ForeignKey);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Key = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Key);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Association = TypeId.SET.getSpecializedId(CLSSid_Association);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_AssociationToForeignKey = TypeId.SET.getSpecializedId(CLSSid_AssociationToForeignKey);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Attribute = TypeId.SET.getSpecializedId(CLSSid_Attribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_AttributeToColumn = TypeId.SET.getSpecializedId(CLSSid_AttributeToColumn);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_BooleanToBoolean = TypeId.SET.getSpecializedId(CLSSid_BooleanToBoolean);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassToTable = TypeId.SET.getSpecializedId(CLSSid_ClassToTable);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_FromAttribute = TypeId.SET.getSpecializedId(CLSSid_FromAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_IntegerToNumber = TypeId.SET.getSpecializedId(CLSSid_IntegerToNumber);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Key = TypeId.SET.getSpecializedId(CLSSid_Key);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NonLeafAttribute = TypeId.SET.getSpecializedId(CLSSid_NonLeafAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageToSchema = TypeId.SET.getSpecializedId(CLSSid_PackageToSchema);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PrimitiveDataType = TypeId.SET.getSpecializedId(CLSSid_PrimitiveDataType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_StringToVarchar = TypeId.SET.getSpecializedId(CLSSid_StringToVarchar);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<simpleuml2rdbms.uml.Class,ClassToTable> OPPOSITE_OF_ClassToTable_umlClass = new HashMap<simpleuml2rdbms.uml.Class,ClassToTable>();
    protected final @NonNull Map<Attribute,FromAttribute> OPPOSITE_OF_FromAttribute_attribute = new HashMap<Attribute,FromAttribute>();
    protected final @NonNull Map<Package,PackageToSchema> OPPOSITE_OF_PackageToSchema_umlPackage = new HashMap<Package,PackageToSchema>();
    protected final @NonNull Map<PrimitiveDataType,PrimitiveToName> OPPOSITE_OF_PrimitiveToName_primitive = new HashMap<PrimitiveDataType,PrimitiveToName>();
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
        CLSSid_Association,             // 0 => Association
        CLSSid_AssociationToForeignKey, // 1 => AssociationToForeignKey
        CLSSid_Attribute,               // 2 => Attribute
        CLSSid_AttributeToColumn,       // 3 => AttributeToColumn
        CLSSid_BooleanToBoolean,        // 4 => BooleanToBoolean
        CLSSid_Class,                   // 5 => Class
        CLSSid_ClassToTable,            // 6 => ClassToTable
        CLSSid_IntegerToNumber,         // 7 => IntegerToNumber
        CLSSid_Key,                     // 8 => Key
        CLSSid_NonLeafAttribute,        // 9 => NonLeafAttribute
        CLSSid_Package,                 // 10 => Package
        CLSSid_PackageToSchema,         // 11 => PackageToSchema
        CLSSid_PrimitiveDataType,       // 12 => PrimitiveDataType
        CLSSid_StringToVarchar          // 13 => StringToVarchar
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
        {0},                    // 0 : Association -> {Association}
        {1},                    // 1 : AssociationToForeignKey -> {AssociationToForeignKey}
        {2},                    // 2 : Attribute -> {Attribute}
        {3},                    // 3 : AttributeToColumn -> {AttributeToColumn}
        {4},                    // 4 : BooleanToBoolean -> {BooleanToBoolean}
        {5},                    // 5 : Class -> {Class}
        {6},                    // 6 : ClassToTable -> {ClassToTable}
        {7},                    // 7 : IntegerToNumber -> {IntegerToNumber}
        {8},                    // 8 : Key -> {Key}
        {9},                    // 9 : NonLeafAttribute -> {NonLeafAttribute}
        {10},                   // 10 : Package -> {Package}
        {11},                   // 11 : PackageToSchema -> {PackageToSchema}
        {12},                   // 12 : PrimitiveDataType -> {PrimitiveDataType}
        {13}                    // 13 : StringToVarchar -> {StringToVarchar}
    };
    
    
    public SimpleUML2RDBMS(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new @NonNull String[] {"uml", "rdbms", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * 
     * map packageToSchema_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     *  |)
     * { |}
     * middle ( |)
     * {realize p2s : uml2rdbms::PackageToSchema[1];
     *  |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := p.name;
     * p2s.umlPackage := p;
     * p2s.name := _0;
     * }
     * 
     */
    protected boolean MAP_packageToSchema_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = p.getName();
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable PackageToSchema p2s_10 = UML2RDBMSFactory.eINSTANCE.createPackageToSchema();
        assert p2s_10 != null;
        models[2/*middle*/].add(p2s_10);
        // property assignments
        p2s_10.setUmlPackage(p);
        OPPOSITE_OF_PackageToSchema_umlPackage.put(p, p2s_10);
        p2s_10.setName(name);
        return true;
    }
    
    /**
     * 
     * map packageToSchema_MR in SimpleUML2RDBMS {
     * rdbms ( |)
     * {realize s : rdbms::Schema[1];
     *  |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := p2s.name;
     * s.name := _0;
     * p2s.schema := s;
     * }
     * 
     */
    protected boolean MAP_packageToSchema_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = p2s.getName();
        // creations
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Schema s_1 = RDBMSFactory.eINSTANCE.createSchema();
        assert s_1 != null;
        models[1/*rdbms*/].add(s_1);
        // property assignments
        s_1.setName(name);
        p2s.setSchema(s_1);
        return true;
    }
    
    /**
     * 
     * map integerToNumber_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     * prim : uml::PrimitiveDataType[1];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     *  |)
     * {realize p2n : uml2rdbms::IntegerToNumber[1];
     *  |}
     * where ( |
     * p2s.umlPackage = pprim.namespace = pprim.name = 'Integer')
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'NUMBER';
     * p2n.owner := p2s;
     * p2n.primitive := prim;
     * p2n.name := _0;
     * }
     * 
     */
    protected boolean MAP_integerToNumber_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p_0, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_0, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType prim) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package umlPackage = p2s_0.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_0);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = prim.getName();
        final /*@Thrown*/ boolean eq_0 = STR_Integer.equals(name);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = prim.getNamespace();
        final /*@Thrown*/ boolean eq_1 = namespace.equals(p_0);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = prim.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_NUMBER);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable IntegerToNumber p2n_5 = UML2RDBMSFactory.eINSTANCE.createIntegerToNumber();
        assert p2n_5 != null;
        models[2/*middle*/].add(p2n_5);
        // property assignments
        p2n_5.setOwner(p2s_0);
        p2n_5.setPrimitive(prim);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim, p2n_5);
        p2n_5.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map integerToNumber_MR in SimpleUML2RDBMS {
     * rdbms ( |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * p2n : uml2rdbms::IntegerToNumber[1];
     *  |)
     * { |}
     * where ( |
     * p2n.owner = p2s)
     * {sqlType : String[1] = 'NUMBER';
     *  |
     * p2n.typeName := sqlType;
     * }
     * 
     */
    protected boolean MAP_integerToNumber_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull IntegerToNumber p2n, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_1) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = p2n.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(p2s_1);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        // property assignments
        p2n.setTypeName(STR_NUMBER);
        return true;
    }
    
    /**
     * 
     * map booleanToBoolean_MR in SimpleUML2RDBMS {
     * rdbms ( |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * p2n : uml2rdbms::BooleanToBoolean[1];
     *  |)
     * { |}
     * where ( |
     * p2n.owner = p2s)
     * {sqlType : String[1];
     *  |
     * sqlType := 'BOOLEAN';
     * p2n.typeName := sqlType;
     * }
     * 
     */
    protected boolean MAP_booleanToBoolean_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull BooleanToBoolean p2n_0, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_2) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = p2n_0.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(p2s_2);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        // property assignments
        p2n_0.setTypeName(STR_BOOLEAN);
        return true;
    }
    
    /**
     * 
     * map booleanToBoolean_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     * prim : uml::PrimitiveDataType[1];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     *  |)
     * {realize p2n : uml2rdbms::BooleanToBoolean[1];
     *  |}
     * where ( |
     * p2s.umlPackage = pprim.namespace = pprim.name = 'Boolean')
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'BOOLEAN';
     * p2n.primitive := prim;
     * p2n.name := _0;
     * p2n.owner := p2s;
     * }
     * 
     */
    protected boolean MAP_booleanToBoolean_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p_1, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_3, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType prim_0) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package umlPackage = p2s_3.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_1);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = prim_0.getName();
        final /*@Thrown*/ boolean eq_0 = STR_Boolean.equals(name);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = prim_0.getNamespace();
        final /*@Thrown*/ boolean eq_1 = namespace.equals(p_1);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = prim_0.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_BOOLEAN);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable BooleanToBoolean p2n_5 = UML2RDBMSFactory.eINSTANCE.createBooleanToBoolean();
        assert p2n_5 != null;
        models[2/*middle*/].add(p2n_5);
        // property assignments
        p2n_5.setPrimitive(prim_0);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim_0, p2n_5);
        p2n_5.setName(sum_0);
        p2n_5.setOwner(p2s_3);
        return true;
    }
    
    /**
     * 
     * map stringToVarchar_MR in SimpleUML2RDBMS {
     * rdbms ( |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * p2n : uml2rdbms::StringToVarchar[1];
     *  |)
     * { |}
     * where ( |
     * p2n.owner = p2s)
     * {sqlType : String[1] = 'VARCHAR';
     *  |
     * p2n.typeName := sqlType;
     * }
     * 
     */
    protected boolean MAP_stringToVarchar_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull StringToVarchar p2n_1, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_4) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = p2n_1.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(p2s_4);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        // property assignments
        p2n_1.setTypeName(STR_VARCHAR);
        return true;
    }
    
    /**
     * 
     * map stringToVarchar_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     * prim : uml::PrimitiveDataType[1];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     *  |)
     * {realize p2n : uml2rdbms::StringToVarchar[1];
     *  |}
     * where ( |
     * p2s.umlPackage = pprim.namespace = pprim.name = 'String')
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'VARCHAR';
     * p2n.name := _0;
     * p2n.owner := p2s;
     * p2n.primitive := prim;
     * }
     * 
     */
    protected boolean MAP_stringToVarchar_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p_2, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_5, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType prim_1) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package umlPackage = p2s_5.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_2);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = prim_1.getName();
        final /*@Thrown*/ boolean eq_0 = STR_String.equals(name);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = prim_1.getNamespace();
        final /*@Thrown*/ boolean eq_1 = namespace.equals(p_2);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = prim_1.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_VARCHAR);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable StringToVarchar p2n_5 = UML2RDBMSFactory.eINSTANCE.createStringToVarchar();
        assert p2n_5 != null;
        models[2/*middle*/].add(p2n_5);
        // property assignments
        p2n_5.setName(sum_0);
        p2n_5.setOwner(p2s_5);
        p2n_5.setPrimitive(prim_1);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim_1, p2n_5);
        return true;
    }
    
    /**
     * 
     * map classToTable_MR in SimpleUML2RDBMS {
     * rdbms (s : rdbms::Schema[1];
     *  |)
     * {realize t : rdbms::Table[1];
     * realize pk : rdbms::Key[1];
     * realize pc : rdbms::Column[1];
     *  |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * c2t : uml2rdbms::ClassToTable[1];
     *  |)
     * { |}
     * where ( |
     * p2s.schema = sc2t.owner = p2s)
     * {c2t_name : String[1] = c2t.name;
     * _0 : String[1];
     * _1 : String[1];
     *  |
     * _0 := c2t_name + '_tid';
     * _1 := c2t_name +
     *   '_pk';
     * c2t.table := t;
     * t.name := c2t_name;
     * c2t.primaryKey := pk;
     * c2t.column := pc;
     * t.kind := 'base';
     * t.schema := s;
     * pk.owner := t;
     * pk.kind := 'primary';
     * pc.owner := t;
     * pc.keys := OrderedSet{pk
     *   };
     * pc.type := 'NUMBER';
     * pc.name := _0;
     * pk.name := _1;
     * }
     * 
     */
    protected boolean MAP_classToTable_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable c2t, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_6, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema s) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = c2t.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(p2s_6);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema schema = p2s_6.getSchema();
        final /*@Thrown*/ boolean eq_0 = schema.equals(s);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = c2t.getName();
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__tid);
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(name, STR__pk);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Column pc = RDBMSFactory.eINSTANCE.createColumn();
        assert pc != null;
        models[1/*rdbms*/].add(pc);
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Key pk = RDBMSFactory.eINSTANCE.createKey();
        assert pk != null;
        models[1/*rdbms*/].add(pk);
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table t_4 = RDBMSFactory.eINSTANCE.createTable();
        assert t_4 != null;
        models[1/*rdbms*/].add(t_4);
        // property assignments
        c2t.setTable(t_4);
        t_4.setName(name);
        c2t.setPrimaryKey(pk);
        c2t.setColumn(pc);
        t_4.setKind(STR_base);
        t_4.setSchema(s);
        pk.setOwner(t_4);
        pk.setKind(STR_primary);
        pc.setOwner(t_4);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Key, pk);
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Key> ECORE_OrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Key.class, OrderedSet);
        pc.getKeys().addAll(ECORE_OrderedSet);
        pc.setType(STR_NUMBER);
        pc.setName(sum);
        pk.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map classToTable_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     * c : uml::Class[1];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     *  |)
     * {realize c2t : uml2rdbms::ClassToTable[1];
     *  |}
     * where ( |
     * p2s.umlPackage = pc.kind = 'persistent'c.namespace = p)
     * {_0 : String[?];
     *  |
     * _0 := c.name;
     * c2t.owner := p2s;
     * c2t.name := _0;
     * c2t.umlClass := c;
     * }
     * 
     */
    protected boolean MAP_classToTable_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class c, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p_3, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_7) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = c.getKind();
        final /*@Thrown*/ boolean eq = STR_persistent.equals(kind);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = c.getNamespace();
        final /*@Thrown*/ boolean eq_0 = namespace.equals(p_3);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package umlPackage = p2s_7.getUmlPackage();
        final /*@Thrown*/ boolean eq_1 = umlPackage.equals(p_3);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = c.getName();
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable c2t_1 = UML2RDBMSFactory.eINSTANCE.createClassToTable();
        assert c2t_1 != null;
        models[2/*middle*/].add(c2t_1);
        // property assignments
        c2t_1.setOwner(p2s_7);
        c2t_1.setName(name);
        c2t_1.setUmlClass(c);
        OPPOSITE_OF_ClassToTable_umlClass.put(c, c2t_1);
        return true;
    }
    
    /**
     * 
     * map associationToForeignKey_MR in SimpleUML2RDBMS {
     * rdbms (s : rdbms::Schema[1];
     * st : rdbms::Table[1];
     * dt : rdbms::Table[1];
     * rk : rdbms::Key[1];
     *  |)
     * {realize fk : rdbms::ForeignKey[1];
     * realize fc : rdbms::Column[1];
     *  |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * sc2t : uml2rdbms::ClassToTable[1];
     * dc2t : uml2rdbms::ClassToTable[1];
     * a2f : uml2rdbms::AssociationToForeignKey[1];
     *  |)
     * { |}
     * where ( |
     * dc2t.table = dtsc2t.owner = p2sp2s.schema = ssc2t.table = sta2f.referenced = dc2ta2f.owner = sc2trk.kind = 'primary'rk.owner = dtst.schema =
     *   s)
     * {_0 : String[?];
     * _1 : String[?];
     * _2 : String[1];
     *  |
     * _0 := a2f.name;
     * _1 := rk.column->first().type;
     * _2 := a2f.name +
     *   '_tid';
     * fk.name := _0;
     * a2f.foreignKey := fk;
     * fc.type := _1;
     * fc.name := _2;
     * a2f.column := fc;
     * fk.owner := st;
     * fc.owner := st;
     * fk.refersTo := rk;
     * fc.foreignKeys := OrderedSet{fk
     *   };
     * }
     * 
     */
    protected boolean MAP_associationToForeignKey_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull AssociationToForeignKey a2f, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable dc2t, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Table dt, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_8, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Key rk, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema s_0, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable sc2t, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Table st) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable owner = a2f.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(sc2t);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable referenced = a2f.getReferenced();
        final /*@Thrown*/ boolean eq_0 = dc2t.equals(referenced);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table = dc2t.getTable();
        final /*@Thrown*/ boolean eq_1 = dt.equals(table);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema schema = p2s_8.getSchema();
        final /*@Thrown*/ boolean eq_2 = schema.equals(s_0);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = rk.getKind();
        final /*@Thrown*/ boolean eq_3 = STR_primary.equals(kind);
        if (eq_3 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Table owner_0 = rk.getOwner();
        final /*@Thrown*/ boolean eq_4 = owner_0.equals(dt);
        if (eq_4 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_1 = sc2t.getOwner();
        final /*@Thrown*/ boolean eq_5 = owner_1.equals(p2s_8);
        if (eq_5 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table_0 = sc2t.getTable();
        final /*@Thrown*/ boolean eq_6 = st.equals(table_0);
        if (eq_6 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema schema_0 = st.getSchema();
        final /*@Thrown*/ boolean eq_7 = schema_0.equals(s_0);
        if (eq_7 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = a2f.getName();
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Column> column = rk.getColumn();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_column = idResolver.createOrderedSetOfAll(ORD_CLSSid_Column, column);
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Column first = (Column)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_column);
        if (first == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleRDBMS\'::Column::type\'");
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String type = first.getType();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__tid);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Column fc = RDBMSFactory.eINSTANCE.createColumn();
        assert fc != null;
        models[1/*rdbms*/].add(fc);
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable ForeignKey fk = RDBMSFactory.eINSTANCE.createForeignKey();
        assert fk != null;
        models[1/*rdbms*/].add(fk);
        // property assignments
        fk.setName(name);
        a2f.setForeignKey(fk);
        fc.setType(type);
        fc.setName(sum);
        a2f.setColumn(fc);
        fk.setOwner(st);
        fc.setOwner(st);
        fk.setRefersTo(rk);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_ForeignKey, fk);
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ForeignKey> ECORE_OrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(ForeignKey.class, OrderedSet);
        fc.getForeignKeys().addAll(ECORE_OrderedSet);
        return true;
    }
    
    /**
     * 
     * map associationToForeignKey_LM in SimpleUML2RDBMS {
     * uml (p : uml::Package[1];
     * sc : uml::Class[1];
     * dc : uml::Class[1];
     * a : uml::Association[1];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[1];
     * sc2t : uml2rdbms::ClassToTable[1];
     * dc2t : uml2rdbms::ClassToTable[1];
     *  |)
     * {realize a2f : uml2rdbms::AssociationToForeignKey[1];
     *  |}
     * where ( |
     * sc2t.owner = p2sdc2t.umlClass = dcsc2t.umlClass = scp2s.umlPackage = pa.namespace = psc.namespace = pa.source = sca.destination =
     *   dc)
     * {a2f_name : String[1];
     * _1 : String[?];
     *  |
     * a2f_name := if a.destination = dc and a.source = sc
     *   then a.name
     *   else
     *     if a.destination <> dc and a.source = sc
     *     then dc.name + '_' + a.name
     *     else
     *       if a.destination = dc and a.source <> sc
     *       then a.name + '_' + sc.name
     *       else dc.name + '_' + a.name + '_' + sc.name
     *       endif
     *     endif
     *   endif
     *   ;
     * _1 := if a.destination = dc and a.source = sc
     *   then a2f_name
     *   else a.name
     *   endif;
     * a2f.association := a;
     * a2f.referenced := dc2t;
     * a2f.name := a2f_name;
     * a2f.owner := sc2t;
     * a.name := _1;
     * }
     * 
     */
    protected boolean MAP_associationToForeignKey_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Association a, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class dc, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable dc2t_0, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package p_4, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema p2s_9, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class sc, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable sc2t_0) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class destination = a.getDestination();
        final /*@Thrown*/ boolean eq = destination.equals(dc);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = a.getNamespace();
        final /*@Thrown*/ boolean eq_0 = namespace.equals(p_4);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class source = a.getSource();
        final /*@Thrown*/ boolean eq_1 = source.equals(sc);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Class umlClass = dc2t_0.getUmlClass();
        final /*@Thrown*/ boolean eq_2 = dc.equals(umlClass);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package umlPackage = p2s_9.getUmlPackage();
        final /*@Thrown*/ boolean eq_3 = umlPackage.equals(p_4);
        if (eq_3 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace_0 = sc.getNamespace();
        final /*@Thrown*/ boolean eq_4 = namespace_0.equals(p_4);
        if (eq_4 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = sc2t_0.getOwner();
        final /*@Thrown*/ boolean eq_5 = owner.equals(p2s_9);
        if (eq_5 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Class umlClass_0 = sc2t_0.getUmlClass();
        final /*@Thrown*/ boolean eq_6 = sc.equals(umlClass_0);
        if (eq_6 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = a.getName();
        /*@Caught*/ @NonNull Object CAUGHT_eq_11;
        try {
            @SuppressWarnings("null")
            final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class destination_3 = a.getDestination();
            final /*@Thrown*/ boolean eq_11 = destination_3.equals(dc);
            CAUGHT_eq_11 = eq_11;
        }
        catch (Exception e) {
            CAUGHT_eq_11 = ValueUtil.createInvalidValue(e);
        }
        /*@Caught*/ @NonNull Object CAUGHT_eq_12;
        try {
            @SuppressWarnings("null")
            final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class source_3 = a.getSource();
            final /*@Thrown*/ boolean eq_12 = source_3.equals(sc);
            CAUGHT_eq_12 = eq_12;
        }
        catch (Exception e) {
            CAUGHT_eq_12 = ValueUtil.createInvalidValue(e);
        }
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_11, CAUGHT_eq_12);
        if (and_2 == null) {
            throw new InvalidValueException("Null if condition");
        }
        // variable assignments
        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String symbol_2;
        if (and_2) {
            symbol_2 = name;
        }
        else {
            /*@Caught*/ @NonNull Object CAUGHT_ne;
            try {
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class destination_1 = a.getDestination();
                final /*@Thrown*/ boolean ne = !destination_1.equals(dc);
                CAUGHT_ne = ne;
            }
            catch (Exception e) {
                CAUGHT_ne = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq_12);
            if (and_0 == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_1;
            if (and_0) {
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = dc.getName();
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR__);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name);
                symbol_1 = sum_0;
            }
            else {
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_6 = sc.getName();
                /*@Caught*/ @NonNull Object CAUGHT_ne_0;
                try {
                    @SuppressWarnings("null")
                    final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class source_2 = a.getSource();
                    final /*@Thrown*/ boolean ne_0 = !source_2.equals(sc);
                    CAUGHT_ne_0 = ne_0;
                }
                catch (Exception e) {
                    CAUGHT_ne_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_11, CAUGHT_ne_0);
                if (and_1 == null) {
                    throw new InvalidValueException("Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_0;
                if (and_1) {
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(name, STR__);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, name_6);
                    symbol_0 = sum_2;
                }
                else {
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_4 = dc.getName();
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_3 = StringConcatOperation.INSTANCE.evaluate(name_4, STR__);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_4 = StringConcatOperation.INSTANCE.evaluate(sum_3, name);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_5 = StringConcatOperation.INSTANCE.evaluate(sum_4, STR__);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_6 = StringConcatOperation.INSTANCE.evaluate(sum_5, name_6);
                    symbol_0 = sum_6;
                }
                symbol_1 = symbol_0;
            }
            symbol_2 = symbol_1;
        }
        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String symbol_3;
        if (and_2) {
            symbol_3 = symbol_2;
        }
        else {
            symbol_3 = name;
        }
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable AssociationToForeignKey a2f_0 = UML2RDBMSFactory.eINSTANCE.createAssociationToForeignKey();
        assert a2f_0 != null;
        models[2/*middle*/].add(a2f_0);
        // property assignments
        a2f_0.setAssociation(a);
        a2f_0.setReferenced(dc2t_0);
        a2f_0.setName(symbol_2);
        a2f_0.setOwner(sc2t_0);
        a.setName(symbol_3);
        return true;
    }
    
    /**
     * 
     * map classPrimitiveAttributes_LM in SimpleUML2RDBMS {
     * uml (t : uml::PrimitiveDataType[1];
     * c : uml::Class[1];
     * a : uml::Attribute[1];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::ClassToTable[1];
     * p2n : uml2rdbms::PrimitiveToName[1];
     *  |)
     * {realize fa : uml2rdbms::AttributeToColumn[1];
     *  |}
     * where ( |
     * fao.umlClass = cp2n.primitive = ta.owner = ca.type =
     *   t)
     * {_0 : String[?];
     * _1 : String[?];
     *  |
     * _0 := a.name;
     * _1 := a.kind;
     * fa.owner := fao;
     * fa.type := p2n;
     * fa.name := _0;
     * fa.kind := _1;
     * fa.attribute := a;
     * fa.leafs := Set{fa
     *   };
     * }
     * 
     */
    protected boolean MAP_classPrimitiveAttributes_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute a_0, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class c_0, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable fao, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PrimitiveToName p2n_2, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType t) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner = a_0.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_0);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type = a_0.getType();
        final /*@Thrown*/ boolean eq_0 = type.equals(t);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Class umlClass = fao.getUmlClass();
        final /*@Thrown*/ boolean eq_1 = c_0.equals(umlClass);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType primitive = p2n_2.getPrimitive();
        final /*@Thrown*/ boolean eq_2 = primitive.equals(t);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = a_0.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = a_0.getKind();
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable AttributeToColumn fa = UML2RDBMSFactory.eINSTANCE.createAttributeToColumn();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setOwner(fao);
        fa.setType(p2n_2);
        fa.setName(name);
        fa.setKind(kind);
        fa.setAttribute(a_0);
        OPPOSITE_OF_FromAttribute_attribute.put(a_0, fa);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, fa);
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> ECORE_Set = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, Set);
        fa.getLeafs().addAll(ECORE_Set);
        return true;
    }
    
    /**
     * 
     * map classComplexAttributes_LM in SimpleUML2RDBMS {
     * uml (t : uml::Class[1];
     * c : uml::Class[1];
     * a : uml::Attribute[1];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::ClassToTable[1];
     *  |)
     * {realize fa : uml2rdbms::NonLeafAttribute[1];
     *  |}
     * where ( |
     * fao.umlClass = ca.owner = ca.type =
     *   t)
     * {_0 : String[?];
     * _1 : String[?];
     * _2 : Set(uml2rdbms::AttributeToColumn);
     *  |
     * _0 := a.kind;
     * _1 := a.name;
     * _2 := fao.fromAttributes.leafs->asSet();
     * fa.attribute := a;
     * fa.kind := _0;
     * fa.owner := fao;
     * fa.name := _1;
     * fa.leafs := _2;
     * }
     * 
     */
    protected boolean MAP_classComplexAttributes_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute a_1, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class c_1, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable fao_0, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class t_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner = a_1.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_1);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type = a_1.getType();
        final /*@Thrown*/ boolean eq_0 = type.equals(t_0);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Class umlClass = fao_0.getUmlClass();
        final /*@Thrown*/ boolean eq_1 = c_1.equals(umlClass);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = a_1.getKind();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = a_1.getName();
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<FromAttribute> fromAttributes = fao_0.getFromAttributes();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        /*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_fromAttributes.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable FromAttribute _1 = (FromAttribute)ITERATOR__1.next();
            /**
             * leafs
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS\'::FromAttribute::leafs\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> leafs = _1.getLeafs();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
            //
            for (Object value : BOXED_leafs.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable NonLeafAttribute fa = UML2RDBMSFactory.eINSTANCE.createNonLeafAttribute();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setAttribute(a_1);
        OPPOSITE_OF_FromAttribute_attribute.put(a_1, fa);
        fa.setKind(kind);
        fa.setOwner(fao_0);
        fa.setName(name);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> ECORE_asSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, asSet);
        fa.getLeafs().addAll(ECORE_asSet);
        return true;
    }
    
    /**
     * 
     * map complexAttributePrimitiveAttributes_LM in SimpleUML2RDBMS {
     * uml (ca : uml::Attribute[1];
     * c : uml::Class[1];
     * t : uml::PrimitiveDataType[1];
     * a : uml::Attribute[1];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::NonLeafAttribute[1];
     * p2n : uml2rdbms::PrimitiveToName[1];
     *  |)
     * {realize fa : uml2rdbms::AttributeToColumn[1];
     *  |}
     * where ( |
     * fao.attribute = cap2n.primitive = ta.owner = ca.type = tca.type = ca.owner = c)
     * {_0 : String[?];
     * _1 : String[1];
     *  |
     * _0 := a.kind;
     * _1 := fao.name + '_' +
     *   a.name;
     * fa.owner := fao;
     * fa.attribute := a;
     * fa.kind := _0;
     * fa.type := p2n;
     * fa.leafs := Set{fa
     *   };
     * fa.name := _1;
     * }
     * 
     */
    protected boolean MAP_complexAttributePrimitiveAttributes_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute a_2, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class c_2, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute ca, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull NonLeafAttribute fao_1, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PrimitiveToName p2n_3, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType t_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner = a_2.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_2);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type = a_2.getType();
        final /*@Thrown*/ boolean eq_1 = type.equals(t_1);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_0 = ca.getType();
        final /*@Thrown*/ boolean eq_2 = type_0.equals(c_2);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Attribute attribute = fao_1.getAttribute();
        final /*@Thrown*/ boolean eq_3 = ca.equals(attribute);
        if (eq_3 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType primitive = p2n_3.getPrimitive();
        final /*@Thrown*/ boolean eq_4 = primitive.equals(t_1);
        if (eq_4 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = a_2.getKind();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = fao_1.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = a_2.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable AttributeToColumn fa = UML2RDBMSFactory.eINSTANCE.createAttributeToColumn();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setOwner(fao_1);
        fa.setAttribute(a_2);
        OPPOSITE_OF_FromAttribute_attribute.put(a_2, fa);
        fa.setKind(kind);
        fa.setType(p2n_3);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, fa);
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> ECORE_Set = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, Set);
        fa.getLeafs().addAll(ECORE_Set);
        fa.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map complexAttributeComplexAttributes_LM in SimpleUML2RDBMS {
     * uml (ca : uml::Attribute[1];
     * c : uml::Class[1];
     * t : uml::Class[1];
     * a : uml::Attribute[1];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::NonLeafAttribute[1];
     *  |)
     * {realize fa : uml2rdbms::NonLeafAttribute[1];
     *  |}
     * where ( |
     * fao.attribute = caa.owner = ca.owner = cca.type = ca.type =
     *   t)
     * {_0 : String[?];
     * _1 : Set(uml2rdbms::AttributeToColumn);
     * _2 : String[1];
     *  |
     * _0 := a.kind;
     * _1 := fao.fromAttributes.leafs->asSet();
     * _2 := fao.name + '_' + a.name;
     * fa.owner := fao;
     * fa.kind := _0;
     * fa.leafs := _1;
     * fa.attribute := a;
     * fa.name := _2;
     * }
     * 
     */
    protected boolean MAP_complexAttributeComplexAttributes_LM(final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute a_3, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class c_3, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute ca_0, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull NonLeafAttribute fao_2, final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class t_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner = a_3.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_3);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type = a_3.getType();
        final /*@Thrown*/ boolean eq_1 = type.equals(t_2);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_0 = ca_0.getType();
        final /*@Thrown*/ boolean eq_2 = type_0.equals(c_3);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Attribute attribute = fao_2.getAttribute();
        final /*@Thrown*/ boolean eq_3 = ca_0.equals(attribute);
        if (eq_3 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = a_3.getKind();
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<FromAttribute> fromAttributes = fao_2.getFromAttributes();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        /*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_fromAttributes.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable FromAttribute _1 = (FromAttribute)ITERATOR__1.next();
            /**
             * leafs
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS\'::FromAttribute::leafs\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> leafs = _1.getLeafs();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
            //
            for (Object value : BOXED_leafs.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = fao_2.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = a_3.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
        // creations
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable NonLeafAttribute fa = UML2RDBMSFactory.eINSTANCE.createNonLeafAttribute();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setOwner(fao_2);
        fa.setKind(kind);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> ECORE_asSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, asSet);
        fa.getLeafs().addAll(ECORE_asSet);
        fa.setAttribute(a_3);
        OPPOSITE_OF_FromAttribute_attribute.put(a_3, fa);
        fa.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map attributeColumns_MR in SimpleUML2RDBMS {
     * rdbms (t : rdbms::Table[1];
     * ct : String[1];
     *  |)
     * {realize c : rdbms::Column[1];
     *  |}
     * middle (c2t : uml2rdbms::ClassToTable[1];
     * p2n : uml2rdbms::PrimitiveToName[1];
     * a2c : uml2rdbms::AttributeToColumn[1];
     *  |)
     * { |}
     * where ( |
     * c2t.table = tp2n.typeName = cta2c.owner =
     *   c2tc2t.fromAttributes.leafs->includes(a2c)a2c.type = p2n)
     * {_0 : String[?];
     * _1 : String[?];
     *  |
     * _0 := a2c.name;
     * _1 := a2c.kind;
     * c.name := _0;
     * c.kind := _1;
     * a2c.column := c;
     * c.owner := t;
     * c.type := ct;
     * }
     * 
     */
    protected boolean MAP_attributeColumns_MR(final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull AttributeToColumn a2c, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable c2t_0, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String ct, final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PrimitiveToName p2n_4, final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Table t_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table = c2t_0.getTable();
        final /*@Thrown*/ boolean eq = t_3.equals(table);
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String typeName = p2n_4.getTypeName();
        final /*@Thrown*/ boolean eq_0 = typeName.equals(ct);
        if (eq_0 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull FromAttributeOwner owner = a2c.getOwner();
        final /*@Thrown*/ boolean eq_1 = owner.equals(c2t_0);
        if (eq_1 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable PrimitiveToName type = a2c.getType();
        final /*@Thrown*/ boolean eq_2 = p2n_4.equals(type);
        if (eq_2 != ValueUtil.TRUE_VALUE) {
            return false;
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<FromAttribute> fromAttributes = c2t_0.getFromAttributes();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        /*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_fromAttributes.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable FromAttribute _1 = (FromAttribute)ITERATOR__1.next();
            /**
             * leafs
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS\'::FromAttribute::leafs\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<AttributeToColumn> leafs = _1.getLeafs();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
            //
            for (Object value : BOXED_leafs.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, a2c).booleanValue();
        if (includes != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = a2c.getName();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String kind = a2c.getKind();
        // creations
        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Column c_4 = RDBMSFactory.eINSTANCE.createColumn();
        assert c_4 != null;
        models[1/*rdbms*/].add(c_4);
        // property assignments
        c_4.setName(name);
        c_4.setKind(kind);
        a2c.setColumn(c_4);
        c_4.setOwner(t_3);
        c_4.setType(ct);
        return true;
    }
    
    /**
     * 
     * map __root__ in SimpleUML2RDBMS {
     * 
     *   where ( |)
     * { |}
     * for p : uml::Package in uml.objectsOfKind(uml::Package)
     *    {
     * map packageToSchema_LM {
     * p := p;
     * }}
     *   for p2s : uml2rdbms::PackageToSchema in middle.objectsOfKind(uml2rdbms::PackageToSchema)
     *    {
     * map packageToSchema_MR {
     * p2s := p2s;
     * }}
     *   for c : uml::Class in uml.objectsOfKind(uml::Class)
     *    {
     * 
     *     map classToTable_LM {
     * c := c;
     * p := c.namespace;
     * p2s := c.namespace.middle;
     * }}
     *   for c2t : uml2rdbms::ClassToTable in middle.objectsOfKind(uml2rdbms::ClassToTable)
     *    {
     * 
     *     map classToTable_MR {
     * c2t := c2t;
     * p2s := c2t.owner;
     * s := c2t.owner.schema;
     * }}
     *   for a : uml::Association in uml.objectsOfKind(uml::Association)
     *    {
     * 
     *     map associationToForeignKey_LM {
     * a := a;
     * dc := a.destination;
     * dc2t := a.destination.middle;
     * p := a.namespace;
     * p2s := a.source.middle.owner;
     * sc := a.source;
     * sc2t := a.source.middle;
     * }}
     *   for a2f : uml2rdbms::AssociationToForeignKey in middle.objectsOfKind(uml2rdbms::AssociationToForeignKey)
     *    {
     * 
     *     for rk : rdbms::Key in rdbms.objectsOfKind(rdbms::Key)
     *      {
     * 
     *       map associationToForeignKey_MR {
     * a2f := a2f;
     * dc2t := a2f.referenced;
     * dt := a2f.referenced.table;
     * p2s := a2f.owner.owner;
     * rk := rk;
     * s := a2f.owner.table.schema;
     * sc2t := a2f.owner;
     * st := a2f.owner.table;
     * }}}
     *   for prim : uml::PrimitiveDataType in uml.objectsOfKind(uml::PrimitiveDataType)
     *    {
     * 
     *     map stringToVarchar_LM {
     * p := prim.namespace;
     * p2s := prim.namespace.middle;
     * prim := prim;
     * }}
     *   for prim : uml::PrimitiveDataType in uml.objectsOfKind(uml::PrimitiveDataType)
     *    {
     * 
     *     map integerToNumber_LM {
     * p := prim.namespace;
     * p2s := prim.namespace.middle;
     * prim := prim;
     * }}
     *   for prim : uml::PrimitiveDataType in uml.objectsOfKind(uml::PrimitiveDataType)
     *    {
     * 
     *     map booleanToBoolean_LM {
     * p := prim.namespace;
     * p2s := prim.namespace.middle;
     * prim := prim;
     * }}
     *   for a : uml::Attribute in uml.objectsOfKind(uml::Attribute)
     *   ->select(type.oclIsKindOf(uml::PrimitiveDataType))
     *    {
     * 
     *     map classPrimitiveAttributes_LM {
     * 
     *       a := a;
     * c := a.owner;
     * fao := a.owner.middle;
     * p2n := a.type.oclAsType(uml::PrimitiveDataType).middle;
     * t := a.type;
     * }}
     *   for p2n : uml2rdbms::IntegerToNumber in middle.objectsOfKind(uml2rdbms::IntegerToNumber)
     *    {
     * map integerToNumber_MR {
     * p2n := p2n;
     * p2s := p2n.owner;
     * }}
     *   for p2n : uml2rdbms::BooleanToBoolean in middle.objectsOfKind(uml2rdbms::BooleanToBoolean)
     *    {
     * map booleanToBoolean_MR {
     * p2n := p2n;
     * p2s := p2n.owner;
     * }}
     *   for p2n : uml2rdbms::StringToVarchar in middle.objectsOfKind(uml2rdbms::StringToVarchar)
     *    {
     * map stringToVarchar_MR {
     * p2n := p2n;
     * p2s := p2n.owner;
     * }}
     *   for a : uml::Attribute in uml.objectsOfKind(uml::Attribute)
     *    {
     * 
     *     map classComplexAttributes_LM {
     * a := a;
     * c := a.owner;
     * fao := a.owner.middle;
     * t := a.type;
     * }}
     *   for fao : uml2rdbms::NonLeafAttribute in middle.objectsOfKind(uml2rdbms::NonLeafAttribute)
     *    {
     * 
     *     for a : uml::Attribute in uml.objectsOfKind(uml::Attribute)
     *      {
     * 
     *       map complexAttributeComplexAttributes_LM {
     * a := a;
     * c := fao.attribute.type;
     * ca := fao.attribute;
     * fao := fao;
     * t := a.type;
     * }}}
     *   for a : uml::Attribute in uml.objectsOfKind(uml::Attribute)
     *   ->select(type.oclIsKindOf(uml::PrimitiveDataType))
     *    {
     * 
     *     for ca : uml::Attribute in uml.objectsOfKind(uml::Attribute)
     *      {
     * 
     *       map complexAttributePrimitiveAttributes_LM {
     * 
     *         a := a;
     * c := a.owner;
     * ca := ca;
     * fao := ca.middle;
     * p2n := a.type.oclAsType(uml::PrimitiveDataType).middle;
     * t := a.type;
     * }}}
     *   for a2c : uml2rdbms::AttributeToColumn in middle.objectsOfKind(uml2rdbms::AttributeToColumn)
     *   ->select(owner.oclIsKindOf(uml2rdbms::ClassToTable))
     *    {
     * 
     *     map attributeColumns_MR {
     * 
     *       a2c := a2c;
     * c2t := a2c.owner;
     * ct := a2c.type.typeName;
     * p2n := a2c.type;
     * t := a2c.owner.oclAsType(uml2rdbms::ClassToTable).table;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        // mapping statements
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_AssociationToForeignKey_0 = idResolver.getClass(CLSSid_AssociationToForeignKey, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_AttributeToColumn_0 = idResolver.getClass(CLSSid_AttributeToColumn, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_BooleanToBoolean_0 = idResolver.getClass(CLSSid_BooleanToBoolean, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_ClassToTable_0 = idResolver.getClass(CLSSid_ClassToTable, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_IntegerToNumber_0 = idResolver.getClass(CLSSid_IntegerToNumber, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_NonLeafAttribute_0 = idResolver.getClass(CLSSid_NonLeafAttribute, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_PackageToSchema_0 = idResolver.getClass(CLSSid_PackageToSchema, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml2rdbms_c_c_StringToVarchar_0 = idResolver.getClass(CLSSid_StringToVarchar, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml_c_c_Association_0 = idResolver.getClass(CLSSid_Association, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml_c_c_Attribute_1 = idResolver.getClass(CLSSid_Attribute, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_uml_c_c_PrimitiveDataType_2 = idResolver.getClass(CLSSid_PrimitiveDataType, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_13 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Attribute, models[0/*uml*/], TYP_uml_c_c_Attribute_1);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_7 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PrimitiveDataType, models[0/*uml*/], TYP_uml_c_c_PrimitiveDataType_2);
        /*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(SET_CLSSid_Attribute);
        @Nullable Iterator<?> ITERATOR__1_0 = objectsOfKind_13.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue select_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                select_0 = accumulator;
                break;
            }
            /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Attribute _1_0 = (Attribute)ITERATOR__1_0.next();
            /**
             * type.oclIsKindOf(uml::PrimitiveDataType)
             */
            if (_1_0 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleUML\'::Attribute::type\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_5 = _1_0.getType();
            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_5, TYP_uml_c_c_PrimitiveDataType_2).booleanValue();
            //
            if (oclIsKindOf_0 == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1_0);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, models[0/*uml*/], TYP_uml_c_c_Package_0);
        for (Package p_11 : ValueUtil.typedIterable(Package.class, objectsOfKind)) {
            if (p_11 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package symbol_0 = (Package)p_11;
                MAP_packageToSchema_LM(symbol_0);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageToSchema, models[2/*middle*/], TYP_uml2rdbms_c_c_PackageToSchema_0);
        for (PackageToSchema p2s_21 : ValueUtil.typedIterable(PackageToSchema.class, objectsOfKind_0)) {
            if (p2s_21 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema symbol_3 = (PackageToSchema)p2s_21;
                MAP_packageToSchema_MR(symbol_3);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_1 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, models[0/*uml*/], TYP_uml_c_c_Class_0);
        for (simpleuml2rdbms.uml.Class c_9 : ValueUtil.typedIterable(simpleuml2rdbms.uml.Class.class, objectsOfKind_1)) {
            if (c_9 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class symbol_6 = (simpleuml2rdbms.uml.Class)c_9;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace = symbol_6.getNamespace();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema middle = ClassUtil.nonNullState (OPPOSITE_OF_PackageToSchema_umlPackage.get(namespace));
                MAP_classToTable_LM(symbol_6, namespace, middle);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_2 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassToTable, models[2/*middle*/], TYP_uml2rdbms_c_c_ClassToTable_0);
        for (ClassToTable c2t_3 : ValueUtil.typedIterable(ClassToTable.class, objectsOfKind_2)) {
            if (c2t_3 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable symbol_11 = (ClassToTable)c2t_3;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner = symbol_11.getOwner();
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema schema = owner.getSchema();
                MAP_classToTable_MR(symbol_11, owner, schema);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_3 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Association, models[0/*uml*/], TYP_uml_c_c_Association_0);
        for (Association a_9 : ValueUtil.typedIterable(Association.class, objectsOfKind_3)) {
            if (a_9 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Association symbol_16 = (Association)a_9;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class destination = symbol_16.getDestination();
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class source_0 = symbol_16.getSource();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable middle_2 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(source_0));
                if (middle_2 == null) {
                    throw new InvalidValueException("Null binding for \'associationToForeignKey_LM::sc2t\'");
                }
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable middle_0 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(destination));
                if (middle_0 == null) {
                    throw new InvalidValueException("Null binding for \'associationToForeignKey_LM::dc2t\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace_1 = symbol_16.getNamespace();
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_1 = middle_2.getOwner();
                MAP_associationToForeignKey_LM(symbol_16, destination, middle_0, namespace_1, owner_1, source_0, middle_2);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_4 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_AssociationToForeignKey, models[2/*middle*/], TYP_uml2rdbms_c_c_AssociationToForeignKey_0);
        for (AssociationToForeignKey a2f_1 : ValueUtil.typedIterable(AssociationToForeignKey.class, objectsOfKind_4)) {
            if (a2f_1 != null) {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_rdbms_c_c_Key_0 = idResolver.getClass(CLSSid_Key, null);
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_5 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Key, models[1/*rdbms*/], TYP_rdbms_c_c_Key_0);
                for (Key rk_1 : ValueUtil.typedIterable(Key.class, objectsOfKind_5)) {
                    if (rk_1 != null) {
                        final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull AssociationToForeignKey symbol_25 = (AssociationToForeignKey)a2f_1;
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable owner_5 = symbol_25.getOwner();
                        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable referenced = symbol_25.getReferenced();
                        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table_1 = owner_5.getTable();
                        if (referenced == null) {
                            throw new InvalidValueException("Null binding for \'associationToForeignKey_MR::dc2t\'");
                        }
                        if (table_1 == null) {
                            throw new InvalidValueException("Null binding for \'associationToForeignKey_MR::st\'");
                        }
                        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table = referenced.getTable();
                        if (table == null) {
                            throw new InvalidValueException("Null binding for \'associationToForeignKey_MR::dt\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_3 = owner_5.getOwner();
                        final /*@NonInvalid*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Key symbol_29 = (Key)rk_1;
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.NonNull Schema schema_0 = table_1.getSchema();
                        MAP_associationToForeignKey_MR(symbol_25, referenced, table, owner_3, symbol_29, schema_0, owner_5, table_1);
                    }
                }
            }
        }
        for (PrimitiveDataType prim_5 : ValueUtil.typedIterable(PrimitiveDataType.class, objectsOfKind_7)) {
            if (prim_5 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType symbol_38 = (PrimitiveDataType)prim_5;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace_2 = symbol_38.getNamespace();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema middle_3 = ClassUtil.nonNullState (OPPOSITE_OF_PackageToSchema_umlPackage.get(namespace_2));
                MAP_stringToVarchar_LM(namespace_2, middle_3, symbol_38);
            }
        }
        for (PrimitiveDataType prim_6 : ValueUtil.typedIterable(PrimitiveDataType.class, objectsOfKind_7)) {
            if (prim_6 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType symbol_43 = (PrimitiveDataType)prim_6;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace_4 = symbol_43.getNamespace();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema middle_4 = ClassUtil.nonNullState (OPPOSITE_OF_PackageToSchema_umlPackage.get(namespace_4));
                MAP_integerToNumber_LM(namespace_4, middle_4, symbol_43);
            }
        }
        for (PrimitiveDataType prim_7 : ValueUtil.typedIterable(PrimitiveDataType.class, objectsOfKind_7)) {
            if (prim_7 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType symbol_48 = (PrimitiveDataType)prim_7;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Package namespace_6 = symbol_48.getNamespace();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema middle_5 = ClassUtil.nonNullState (OPPOSITE_OF_PackageToSchema_umlPackage.get(namespace_6));
                MAP_booleanToBoolean_LM(namespace_6, middle_5, symbol_48);
            }
        }
        for (Attribute a_10 : ValueUtil.typedIterable(Attribute.class, select_0)) {
            if (a_10 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute symbol_51 = (Attribute)a_10;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner_7 = symbol_51.getOwner();
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_1 = symbol_51.getType();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable middle_6 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(owner_7));
                if (middle_6 == null) {
                    throw new InvalidValueException("Null binding for \'classPrimitiveAttributes_LM::fao\'");
                }
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType oclAsType = ClassUtil.nonNullState((PrimitiveDataType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_1, TYP_uml_c_c_PrimitiveDataType_2));
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PrimitiveToName middle_7 = ClassUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(oclAsType));
                if (type_1 instanceof PrimitiveDataType) {
                    MAP_classPrimitiveAttributes_LM(symbol_51, owner_7, middle_6, middle_7, (PrimitiveDataType)type_1);
                }
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_10 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_IntegerToNumber, models[2/*middle*/], TYP_uml2rdbms_c_c_IntegerToNumber_0);
        for (IntegerToNumber p2n_11 : ValueUtil.typedIterable(IntegerToNumber.class, objectsOfKind_10)) {
            if (p2n_11 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull IntegerToNumber symbol_58 = (IntegerToNumber)p2n_11;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_9 = symbol_58.getOwner();
                MAP_integerToNumber_MR(symbol_58, owner_9);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_11 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_BooleanToBoolean, models[2/*middle*/], TYP_uml2rdbms_c_c_BooleanToBoolean_0);
        for (BooleanToBoolean p2n_12 : ValueUtil.typedIterable(BooleanToBoolean.class, objectsOfKind_11)) {
            if (p2n_12 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull BooleanToBoolean symbol_62 = (BooleanToBoolean)p2n_12;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_10 = symbol_62.getOwner();
                MAP_booleanToBoolean_MR(symbol_62, owner_10);
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_12 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_StringToVarchar, models[2/*middle*/], TYP_uml2rdbms_c_c_StringToVarchar_0);
        for (StringToVarchar p2n_13 : ValueUtil.typedIterable(StringToVarchar.class, objectsOfKind_12)) {
            if (p2n_13 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull StringToVarchar symbol_66 = (StringToVarchar)p2n_13;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PackageToSchema owner_11 = symbol_66.getOwner();
                MAP_stringToVarchar_MR(symbol_66, owner_11);
            }
        }
        for (Attribute a_11 : ValueUtil.typedIterable(Attribute.class, objectsOfKind_13)) {
            if (a_11 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute symbol_70 = (Attribute)a_11;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner_12 = symbol_70.getOwner();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable ClassToTable middle_8 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(owner_12));
                if (middle_8 == null) {
                    throw new InvalidValueException("Null binding for \'classComplexAttributes_LM::fao\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_2 = symbol_70.getType();
                if (type_2 instanceof simpleuml2rdbms.uml.Class) {
                    MAP_classComplexAttributes_LM(symbol_70, owner_12, middle_8, (simpleuml2rdbms.uml.Class)type_2);
                }
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_14 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_NonLeafAttribute, models[2/*middle*/], TYP_uml2rdbms_c_c_NonLeafAttribute_0);
        for (NonLeafAttribute fao_7 : ValueUtil.typedIterable(NonLeafAttribute.class, objectsOfKind_14)) {
            if (fao_7 != null) {
                for (Attribute a_12 : ValueUtil.typedIterable(Attribute.class, objectsOfKind_13)) {
                    if (a_12 != null) {
                        final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull NonLeafAttribute symbol_79 = (NonLeafAttribute)fao_7;
                        final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute symbol_76 = (Attribute)a_12;
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.Nullable Attribute attribute_0 = symbol_79.getAttribute();
                        if (attribute_0 == null) {
                            throw new InvalidValueException("Null binding for \'complexAttributeComplexAttributes_LM::ca\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_3 = attribute_0.getType();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_4 = symbol_76.getType();
                        if (type_3 instanceof simpleuml2rdbms.uml.Class) {
                            if (type_4 instanceof simpleuml2rdbms.uml.Class) {
                                MAP_complexAttributeComplexAttributes_LM(symbol_76, (simpleuml2rdbms.uml.Class)type_3, attribute_0, symbol_79, (simpleuml2rdbms.uml.Class)type_4);
                            }
                        }
                    }
                }
            }
        }
        for (Attribute a_13 : ValueUtil.typedIterable(Attribute.class, select_0)) {
            if (a_13 != null) {
                for (Attribute ca_3 : ValueUtil.typedIterable(Attribute.class, objectsOfKind_13)) {
                    if (ca_3 != null) {
                        final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute symbol_84 = (Attribute)a_13;
                        final /*@NonInvalid*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Attribute symbol_86 = (Attribute)ca_3;
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Classifier type_7 = symbol_84.getType();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull Class owner_14 = symbol_84.getOwner();
                        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable FromAttribute middle_9 = ClassUtil.nonNullState (OPPOSITE_OF_FromAttribute_attribute.get(symbol_86));
                        if (middle_9 == null) {
                            throw new InvalidValueException("Null binding for \'complexAttributePrimitiveAttributes_LM::fao\'");
                        }
                        final /*@Thrown*/ simpleuml2rdbms.uml.@org.eclipse.jdt.annotation.NonNull PrimitiveDataType oclAsType_0 = ClassUtil.nonNullState((PrimitiveDataType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_7, TYP_uml_c_c_PrimitiveDataType_2));
                        final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull PrimitiveToName middle_10 = ClassUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(oclAsType_0));
                        if (middle_9 instanceof NonLeafAttribute) {
                            if (type_7 instanceof PrimitiveDataType) {
                                MAP_complexAttributePrimitiveAttributes_LM(symbol_84, owner_14, symbol_86, (NonLeafAttribute)middle_9, middle_10, (PrimitiveDataType)type_7);
                            }
                        }
                    }
                }
            }
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_18 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_AttributeToColumn, models[2/*middle*/], TYP_uml2rdbms_c_c_AttributeToColumn_0);
        /*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSetAccumulatorValue(SET_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1_1 = objectsOfKind_18.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue select_1;
        while (true) {
            if (!ITERATOR__1_1.hasNext()) {
                select_1 = accumulator_0;
                break;
            }
            /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable AttributeToColumn _1_1 = (AttributeToColumn)ITERATOR__1_1.next();
            /**
             * owner.oclIsKindOf(uml2rdbms::ClassToTable)
             */
            if (_1_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS\'::FromAttribute::owner\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull FromAttributeOwner owner_15 = _1_1.getOwner();
            final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, owner_15, TYP_uml2rdbms_c_c_ClassToTable_0).booleanValue();
            //
            if (oclIsKindOf_1 == ValueUtil.TRUE_VALUE) {
                accumulator_0.add(_1_1);
            }
        }
        for (AttributeToColumn a2c_1 : ValueUtil.typedIterable(AttributeToColumn.class, select_1)) {
            if (a2c_1 != null) {
                final /*@NonInvalid*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull AttributeToColumn symbol_93 = (AttributeToColumn)a2c_1;
                @SuppressWarnings("null")
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull FromAttributeOwner owner_16 = symbol_93.getOwner();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.Nullable PrimitiveToName type_9 = symbol_93.getType();
                if (type_9 == null) {
                    throw new InvalidValueException("Null binding for \'attributeColumns_MR::p2n\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String typeName = type_9.getTypeName();
                final /*@Thrown*/ simpleuml2rdbms.uml2rdbms.@org.eclipse.jdt.annotation.NonNull ClassToTable oclAsType_1 = ClassUtil.nonNullState((ClassToTable)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, owner_16, TYP_uml2rdbms_c_c_ClassToTable_0));
                final /*@Thrown*/ simpleuml2rdbms.rdbms.@org.eclipse.jdt.annotation.Nullable Table table_2 = oclAsType_1.getTable();
                if (table_2 == null) {
                    throw new InvalidValueException("Null binding for \'attributeColumns_MR::t\'");
                }
                if (owner_16 instanceof ClassToTable) {
                    MAP_attributeColumns_MR(symbol_93, (ClassToTable)owner_16, typeName, type_9, table_2);
                }
            }
        }
        return true;
    }
}
