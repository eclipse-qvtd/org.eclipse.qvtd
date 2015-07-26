/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._ManualUML2RDBMS;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import manualuml2rdbms.rdbms.Column;
import manualuml2rdbms.rdbms.ForeignKey;
import manualuml2rdbms.rdbms.Key;
import manualuml2rdbms.rdbms.RDBMSFactory;
import manualuml2rdbms.rdbms.RDBMSPackage;
import manualuml2rdbms.rdbms.Schema;
import manualuml2rdbms.rdbms.Table;
import manualuml2rdbms.uml.Association;
import manualuml2rdbms.uml.Attribute;
import manualuml2rdbms.uml.Classifier;
import manualuml2rdbms.uml.Package;
import manualuml2rdbms.uml.PackageElement;
import manualuml2rdbms.uml.PrimitiveDataType;
import manualuml2rdbms.uml.UMLPackage;
import manualuml2rdbms.uml2rdbms.AssociationToForeignKey;
import manualuml2rdbms.uml2rdbms.AttributeToColumn;
import manualuml2rdbms.uml2rdbms.ClassToTable;
import manualuml2rdbms.uml2rdbms.FromAttribute;
import manualuml2rdbms.uml2rdbms.NonLeafAttribute;
import manualuml2rdbms.uml2rdbms.PackageToSchema;
import manualuml2rdbms.uml2rdbms.PrimitiveToName;
import manualuml2rdbms.uml2rdbms.UML2RDBMSFactory;
import manualuml2rdbms.uml2rdbms.UML2RDBMSPackage;
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
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionUnionOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * The ManualUML2RDBMS transformation:
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
public class ManualUML2RDBMS extends AbstractTransformer
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/ManualRDBMS", null, RDBMSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/ManualUML", null, UMLPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS", null, UML2RDBMSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Association = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("Association", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AssociationToForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("AssociationToForeignKey", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("Attribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AttributeToColumn = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("AttributeToColumn", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassToTable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("ClassToTable", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Classifier = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("Classifier", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Column = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS.getClassId("Column", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS.getClassId("ForeignKey", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_FromAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("FromAttribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Key = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS.getClassId("Key", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NonLeafAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("NonLeafAttribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("PackageElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageToSchema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("PackageToSchema", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PrimitiveDataType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML.getClassId("PrimitiveDataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PrimitiveToName = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualUML2RDBMS.getClassId("PrimitiveToName", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Schema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS.getClassId("Schema", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Table = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_ManualRDBMS.getClassId("Table", 0);
    public static final @NonNull /*@NonInvalid*/ String STR_2 = "2";
    public static final @NonNull /*@NonInvalid*/ String STR_BOOLEAN = "BOOLEAN";
    public static final @NonNull /*@NonInvalid*/ String STR_Boolean = "Boolean";
    public static final @NonNull /*@NonInvalid*/ String STR_Integer = "Integer";
    public static final @NonNull /*@NonInvalid*/ String STR_NUMBER = "NUMBER";
    public static final @NonNull /*@NonInvalid*/ String STR_String = "String";
    public static final @NonNull /*@NonInvalid*/ String STR_VARCHAR = "VARCHAR";
    public static final @NonNull /*@NonInvalid*/ String STR__ = "_";
    public static final @NonNull /*@NonInvalid*/ String STR__pk = "_pk";
    public static final @NonNull /*@NonInvalid*/ String STR__tid = "_tid";
    public static final @NonNull /*@NonInvalid*/ String STR_base = "base";
    public static final @NonNull /*@NonInvalid*/ String STR_persistent = "persistent";
    public static final @NonNull /*@NonInvalid*/ String STR_primary = "primary";
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_AttributeToColumn = TypeId.BAG.getSpecializedId(CLSSid_AttributeToColumn, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_FromAttribute = TypeId.BAG.getSpecializedId(CLSSid_FromAttribute, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_AssociationToForeignKey = TypeId.ORDERED_SET.getSpecializedId(CLSSid_AssociationToForeignKey, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Attribute = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Attribute, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Column = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Column, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ForeignKey = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ForeignKey, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Key = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Key, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageElement, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Association = TypeId.SET.getSpecializedId(CLSSid_Association, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Attribute = TypeId.SET.getSpecializedId(CLSSid_Attribute, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_AttributeToColumn = TypeId.SET.getSpecializedId(CLSSid_AttributeToColumn, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassToTable = TypeId.SET.getSpecializedId(CLSSid_ClassToTable, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_FromAttribute = TypeId.SET.getSpecializedId(CLSSid_FromAttribute, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_NonLeafAttribute = TypeId.SET.getSpecializedId(CLSSid_NonLeafAttribute, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PrimitiveToName = TypeId.SET.getSpecializedId(CLSSid_PrimitiveToName, TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
    
    /*
     * Property-source to Property-target unnavigable navigation caches
     */
    protected final @NonNull Map<Table,ClassToTable> OPPOSITE_OF_ClassToTable_table = new HashMap<Table,ClassToTable>();
    protected final @NonNull Map<manualuml2rdbms.uml.Class,ClassToTable> OPPOSITE_OF_ClassToTable_umlClass = new HashMap<manualuml2rdbms.uml.Class,ClassToTable>();
    protected final @NonNull Map<Attribute,FromAttribute> OPPOSITE_OF_FromAttribute_attribute = new HashMap<Attribute,FromAttribute>();
    protected final @NonNull Map<PrimitiveDataType,PrimitiveToName> OPPOSITE_OF_PrimitiveToName_primitive = new HashMap<PrimitiveDataType,PrimitiveToName>();
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_Package                  // 0 => Package
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0}                     // 0 : Package -> {Package}
    };
    
    
    public ManualUML2RDBMS(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new String[] {"uml", "rdbms", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() throws ReflectiveOperationException {
        boolean returnStatus = MAP___root__();
        invocationManager.flush();
        return returnStatus;
    }
    
    protected @NonNull List<manualuml2rdbms.uml.Class> getAllSupers(final @Nullable /*@NonInvalid*/ manualuml2rdbms.uml.Class cls) {
        @SuppressWarnings("null")@NonNull List<manualuml2rdbms.uml.Class> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    protected @NonNull List<Attribute> getAllAttributes(final @Nullable /*@NonInvalid*/ manualuml2rdbms.uml.Class cls_0) {
        @SuppressWarnings("null")@NonNull List<Attribute> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    protected @NonNull List<Association> getAllForwards(final @Nullable /*@NonInvalid*/ manualuml2rdbms.uml.Class cls_1) {
        @SuppressWarnings("null")@NonNull List<Association> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    /**
     * 
     * map __root__ in ManualUML2RDBMS {
     * 
     *   where ( |)
     * { |}
     * for p1 : uml::Package in uml::Package.allInstances()
     *    {
     * map packageToSchemaLM {
     * p := p1;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_uml_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // mapping statements
        final @NonNull /*@NonInvalid*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, TYP_uml_c_c_Package_0);
        for (Package p1 : ValueUtil.typedIterable(Package.class, allInstances)) {
            if (p1 != null) {
                final @NonNull /*@NonInvalid*/ Package symbol_0 = (Package)p1;
                if (symbol_0 != null) {
                    MAP_packageToSchemaLM(symbol_0);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map packageToSchemaLM in ManualUML2RDBMS {
     * 
     *   uml (p : uml::Package[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize p2s : uml2rdbms::PackageToSchema[?];
     *  |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := p.name;
     * p2s.umlPackage := p;
     * p2s.name := _0;
     * }
     * for child : uml::PackageElement in p.elements {
     * 
     *     map integerToNumberLM {
     * p := p;
     * p2s := p2s;
     * prim := child;
     * }
     *     map booleanToBooleanLM {
     * p := p;
     * p2s := p2s;
     * prim := child;
     * }
     *     map stringToVarcharLM {
     * p := p;
     * p2s := p2s;
     * prim := child;
     * }}
     *   for child : uml::PackageElement in p.elements {
     * 
     *     map classToTableLM {
     * c := child;
     * p := p;
     * p2s := p2s;
     * }
     *     map associationToForeignKeyLM {
     * a := child;
     * p := p;
     * p2s := p2s;
     * }}
     *   map packageToSchemaMR {
     * p2s := p2s;
     * }
     */
    protected boolean MAP_packageToSchemaLM(final @NonNull /*@NonInvalid*/ Package p) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<PackageElement> elements_0 = p.getElements();
        // variable assignments
        final @Nullable /*@Thrown*/ String name = p.getName();
        // creations
        final /*@Thrown*/ PackageToSchema p2s_11 = UML2RDBMSFactory.eINSTANCE.createPackageToSchema();
        assert p2s_11 != null;
        models[2/*middle*/].add(p2s_11);
        // property assignments
        p2s_11.setUmlPackage(p);
        p2s_11.setName(name);
        // mapping statements
        for (PackageElement child : elements_0) {
            if (child != null) {
                final @NonNull /*@NonInvalid*/ PackageElement symbol_4 = (PackageElement)child;
                if (p != null) {
                    if (p2s_11 != null) {
                        if (symbol_4 instanceof PrimitiveDataType) {
                            MAP_integerToNumberLM(p, p2s_11, (PrimitiveDataType)symbol_4);
                        }
                    }
                }
                if (p != null) {
                    if (p2s_11 != null) {
                        if (symbol_4 instanceof PrimitiveDataType) {
                            MAP_booleanToBooleanLM(p, p2s_11, (PrimitiveDataType)symbol_4);
                        }
                    }
                }
                if (p != null) {
                    if (p2s_11 != null) {
                        if (symbol_4 instanceof PrimitiveDataType) {
                            MAP_stringToVarcharLM(p, p2s_11, (PrimitiveDataType)symbol_4);
                        }
                    }
                }
            }
        }
        for (PackageElement child_0 : elements_0) {
            if (child_0 != null) {
                final @NonNull /*@NonInvalid*/ PackageElement symbol_11 = (PackageElement)child_0;
                if (symbol_11 instanceof manualuml2rdbms.uml.Class) {
                    if (p != null) {
                        if (p2s_11 != null) {
                            MAP_classToTableLM((manualuml2rdbms.uml.Class)symbol_11, p, p2s_11);
                        }
                    }
                }
                if (symbol_11 instanceof Association) {
                    if (p != null) {
                        if (p2s_11 != null) {
                            MAP_associationToForeignKeyLM((Association)symbol_11, p, p2s_11);
                        }
                    }
                }
            }
        }
        if (p2s_11 != null) {
            MAP_packageToSchemaMR(p2s_11);
        }
        return true;
    }
    
    /**
     * 
     * map packageToSchemaMR in ManualUML2RDBMS {
     * 
     *   middle (p2s : uml2rdbms::PackageToSchema[?];
     *  |)
     * { |}
     * rdbms ( |)
     * {realize s : rdbms::Schema[?];
     *  |}
     * where ( |)
     * { |
     * p2s.schema := s;
     * }
     * map packageToSchemaMR_1 {
     * p2s_1 := p2s;
     * s_1 := s;
     * }
     *   for child : uml2rdbms::PrimitiveToName in p2s.primitivesToNames {
     * 
     *     map integerToNumberMR {
     * p2n := child;
     * p2s := p2s;
     * }
     *     map booleanToBooleanMR {
     * p2n := child;
     * p2s := p2s;
     * }
     *     map stringToVarcharMR {
     * p2n := child;
     * p2s := p2s;
     * }}
     *   for child : uml2rdbms::ClassToTable in p2s.classesToTables {
     * 
     *     map classToTableMR {
     * c2t := child;
     * p2s := p2s;
     * s := s;
     * }}
     */
    protected boolean MAP_packageToSchemaMR(final @NonNull /*@NonInvalid*/ PackageToSchema p2s) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ Schema s_2 = RDBMSFactory.eINSTANCE.createSchema();
        assert s_2 != null;
        models[1/*rdbms*/].add(s_2);
        // property assignments
        p2s.setSchema(s_2);
        // mapping statements
        if (p2s != null) {
            if (s_2 != null) {
                MAP_packageToSchemaMR_1(p2s, s_2);
            }
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<PrimitiveToName> primitivesToNames = p2s.getPrimitivesToNames();
        for (PrimitiveToName child : primitivesToNames) {
            if (child != null) {
                final @NonNull /*@NonInvalid*/ PrimitiveToName symbol_4 = (PrimitiveToName)child;
                if (symbol_4 != null) {
                    if (p2s != null) {
                        MAP_integerToNumberMR(symbol_4, p2s);
                    }
                }
                if (symbol_4 != null) {
                    if (p2s != null) {
                        MAP_booleanToBooleanMR(symbol_4, p2s);
                    }
                }
                if (symbol_4 != null) {
                    if (p2s != null) {
                        MAP_stringToVarcharMR(symbol_4, p2s);
                    }
                }
            }
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<ClassToTable> classesToTables = p2s.getClassesToTables();
        for (ClassToTable child_0 : classesToTables) {
            if (child_0 != null) {
                final @NonNull /*@NonInvalid*/ ClassToTable symbol_9 = (ClassToTable)child_0;
                if (symbol_9 != null) {
                    if (p2s != null) {
                        if (s_2 != null) {
                            MAP_classToTableMR(symbol_9, p2s, s_2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map packageToSchemaMR_1 in ManualUML2RDBMS {
     * middle (p2s_1 : uml2rdbms::PackageToSchema[?];
     *  |)
     * { |}
     * rdbms (s_1 : rdbms::Schema[?];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := p2s_1.name;
     * s_1.name := _0;
     * }
     * 
     */
    protected boolean MAP_packageToSchemaMR_1(final @NonNull /*@NonInvalid*/ PackageToSchema p2s_1, final @NonNull /*@NonInvalid*/ Schema s_1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ String name = p2s_1.getName();
        // property assignments
        s_1.setName(name);
        return true;
    }
    
    /**
     * 
     * map integerToNumberLM in ManualUML2RDBMS {
     * uml (p : uml::Package[?];
     * prim : uml::PrimitiveDataType[?];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     *  |)
     * {realize p2n : uml2rdbms::PrimitiveToName[?];
     *  |}
     * where ( |
     * prim.namespace = pprim.name = 'Integer'p2s.umlPackage = p)
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'NUMBER';
     * p2n.owner := p2s;
     * p2n.primitive := prim;
     * p2n.name := _0;
     * p2n.typeName := 'NUMBER';
     * }
     * 
     */
    protected boolean MAP_integerToNumberLM(final @NonNull /*@NonInvalid*/ Package p_0, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_0, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package umlPackage = p2s_0.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_0);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ String name = prim.getName();
        final /*@Thrown*/ boolean eq_0 = STR_Integer.equals(name);
        if (!eq_0) {
            return false;
        }
        final @Nullable /*@Thrown*/ Package namespace = prim.getNamespace();
        final /*@Thrown*/ boolean eq_1 = p_0.equals(namespace);
        if (!eq_1) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name_0 = prim.getName();
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_NUMBER);
        // creations
        final /*@Thrown*/ PrimitiveToName p2n_3 = UML2RDBMSFactory.eINSTANCE.createPrimitiveToName();
        assert p2n_3 != null;
        models[2/*middle*/].add(p2n_3);
        // property assignments
        p2n_3.setOwner(p2s_0);
        p2n_3.setPrimitive(prim);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim, p2n_3);
        p2n_3.setName(sum_0);
        p2n_3.setTypeName(STR_NUMBER);
        return true;
    }
    
    /**
     * 
     * map integerToNumberMR in ManualUML2RDBMS {
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * p2n : uml2rdbms::PrimitiveToName[?];
     *  |)
     * { |}
     * rdbms ( |)
     * { |}
     * where ( |
     * p2n.owner = p2sp2n.name = 'Integer' + '2' + 'NUMBER')
     * { |}
     * 
     */
    protected boolean MAP_integerToNumberMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_2) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ String name = p2n.getName();
        final @NonNull /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_Integer, STR_2);
        final @NonNull /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_NUMBER);
        final /*@Thrown*/ boolean eq = sum_0.equals(name);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ PackageToSchema owner = p2n.getOwner();
        final /*@Thrown*/ boolean eq_0 = p2s_2.equals(owner);
        if (!eq_0) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * map booleanToBooleanLM in ManualUML2RDBMS {
     * uml (p : uml::Package[?];
     * prim : uml::PrimitiveDataType[?];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     *  |)
     * {realize p2n : uml2rdbms::PrimitiveToName[?];
     *  |}
     * where ( |
     * prim.namespace = pprim.name = 'Boolean'p2s.umlPackage = p)
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'BOOLEAN';
     * p2n.owner := p2s;
     * p2n.primitive := prim;
     * p2n.name := _0;
     * p2n.typeName := 'BOOLEAN';
     * }
     * 
     */
    protected boolean MAP_booleanToBooleanLM(final @NonNull /*@NonInvalid*/ Package p_1, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_3, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim_0) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package umlPackage = p2s_3.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_1);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ String name = prim_0.getName();
        final /*@Thrown*/ boolean eq_0 = STR_Boolean.equals(name);
        if (!eq_0) {
            return false;
        }
        final @Nullable /*@Thrown*/ Package namespace = prim_0.getNamespace();
        final /*@Thrown*/ boolean eq_1 = p_1.equals(namespace);
        if (!eq_1) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name_0 = prim_0.getName();
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_BOOLEAN);
        // creations
        final /*@Thrown*/ PrimitiveToName p2n_3 = UML2RDBMSFactory.eINSTANCE.createPrimitiveToName();
        assert p2n_3 != null;
        models[2/*middle*/].add(p2n_3);
        // property assignments
        p2n_3.setOwner(p2s_3);
        p2n_3.setPrimitive(prim_0);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim_0, p2n_3);
        p2n_3.setName(sum_0);
        p2n_3.setTypeName(STR_BOOLEAN);
        return true;
    }
    
    /**
     * 
     * map booleanToBooleanMR in ManualUML2RDBMS {
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * p2n : uml2rdbms::PrimitiveToName[?];
     *  |)
     * { |}
     * rdbms ( |)
     * { |}
     * where ( |
     * p2n.owner = p2sp2n.name = 'Boolean' + '2' + 'BOOLEAN')
     * { |}
     * 
     */
    protected boolean MAP_booleanToBooleanMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_0, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_4) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ String name = p2n_0.getName();
        final @NonNull /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_Boolean, STR_2);
        final @NonNull /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_BOOLEAN);
        final /*@Thrown*/ boolean eq = sum_0.equals(name);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ PackageToSchema owner = p2n_0.getOwner();
        final /*@Thrown*/ boolean eq_0 = p2s_4.equals(owner);
        if (!eq_0) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * map stringToVarcharLM in ManualUML2RDBMS {
     * uml (p : uml::Package[?];
     * prim : uml::PrimitiveDataType[?];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     *  |)
     * {realize p2n : uml2rdbms::PrimitiveToName[?];
     *  |}
     * where ( |
     * prim.namespace = pprim.name = 'String'p2s.umlPackage = p)
     * {_0 : String[1];
     *  |
     * _0 := prim.name + '2' + 'VARCHAR';
     * p2n.owner := p2s;
     * p2n.primitive := prim;
     * p2n.name := _0;
     * p2n.typeName := 'VARCHAR';
     * }
     * 
     */
    protected boolean MAP_stringToVarcharLM(final @NonNull /*@NonInvalid*/ Package p_2, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_5, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim_1) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package umlPackage = p2s_5.getUmlPackage();
        final /*@Thrown*/ boolean eq = umlPackage.equals(p_2);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ String name = prim_1.getName();
        final /*@Thrown*/ boolean eq_0 = STR_String.equals(name);
        if (!eq_0) {
            return false;
        }
        final @Nullable /*@Thrown*/ Package namespace = prim_1.getNamespace();
        final /*@Thrown*/ boolean eq_1 = p_2.equals(namespace);
        if (!eq_1) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name_0 = prim_1.getName();
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR_2);
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_VARCHAR);
        // creations
        final /*@Thrown*/ PrimitiveToName p2n_3 = UML2RDBMSFactory.eINSTANCE.createPrimitiveToName();
        assert p2n_3 != null;
        models[2/*middle*/].add(p2n_3);
        // property assignments
        p2n_3.setOwner(p2s_5);
        p2n_3.setPrimitive(prim_1);
        OPPOSITE_OF_PrimitiveToName_primitive.put(prim_1, p2n_3);
        p2n_3.setName(sum_0);
        p2n_3.setTypeName(STR_VARCHAR);
        return true;
    }
    
    /**
     * 
     * map stringToVarcharMR in ManualUML2RDBMS {
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * p2n : uml2rdbms::PrimitiveToName[?];
     *  |)
     * { |}
     * rdbms ( |)
     * { |}
     * where ( |
     * p2n.owner = p2sp2n.name = 'String' + '2' + 'VARCHAR')
     * { |}
     * 
     */
    protected boolean MAP_stringToVarcharMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_1, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_6) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ String name = p2n_1.getName();
        final @NonNull /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_String, STR_2);
        final @NonNull /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_VARCHAR);
        final /*@Thrown*/ boolean eq = sum_0.equals(name);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ PackageToSchema owner = p2n_1.getOwner();
        final /*@Thrown*/ boolean eq_0 = p2s_6.equals(owner);
        if (!eq_0) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * map classToTableLM in ManualUML2RDBMS {
     * uml (p : uml::Package[?];
     * c : uml::Class[?];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     *  |)
     * {realize c2t : uml2rdbms::ClassToTable[?];
     *  |}
     * where ( |
     * c.kind = 'persistent'c.namespace = pp2s.umlPackage =
     *   p)
     * {_0 : String[?];
     *  |
     * _0 := c.name;
     * c2t.owner := p2s;
     * c2t.umlClass := c;
     * c2t.name := _0;
     * }
     * for anAttribute : uml::Attribute in c.attributes {
     * 
     *     map classPrimitiveAttributesLM {
     * a := anAttribute;
     * c := c;
     * fao := c2t;
     * }
     *     map classComplexAttributesLM {
     * a := anAttribute;
     * c := c;
     * fao := c2t;
     * }
     *     map complexAttributePrimitiveAttributesLM {
     * c := anAttribute.type;
     * ca := anAttribute;
     * }
     *     map complexAttributeComplexAttributesLM {
     * c := anAttribute.type;
     * ca := anAttribute;
     * }}
     */
    protected boolean MAP_classToTableLM(final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c, final @NonNull /*@NonInvalid*/ Package p_3, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_7) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ String kind = c.getKind();
        final /*@Thrown*/ boolean eq = STR_persistent.equals(kind);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ Package namespace = c.getNamespace();
        final /*@Thrown*/ boolean eq_0 = p_3.equals(namespace);
        if (!eq_0) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package umlPackage = p2s_7.getUmlPackage();
        final /*@Thrown*/ boolean eq_1 = umlPackage.equals(p_3);
        if (!eq_1) {
            return false;
        }
        // variable assignments
        final @Nullable /*@Thrown*/ String name = c.getName();
        // creations
        final /*@Thrown*/ ClassToTable c2t_3 = UML2RDBMSFactory.eINSTANCE.createClassToTable();
        assert c2t_3 != null;
        models[2/*middle*/].add(c2t_3);
        // property assignments
        c2t_3.setOwner(p2s_7);
        c2t_3.setUmlClass(c);
        OPPOSITE_OF_ClassToTable_umlClass.put(c, c2t_3);
        c2t_3.setName(name);
        // mapping statements
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Attribute> attributes = c.getAttributes();
        for (Attribute anAttribute : attributes) {
            if (anAttribute != null) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_5 = (Attribute)anAttribute;
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ Classifier type_0 = symbol_5.getType();
                if (symbol_5 != null) {
                    if (c != null) {
                        if (c2t_3 != null) {
                            MAP_classPrimitiveAttributesLM(symbol_5, c, c2t_3);
                        }
                    }
                }
                if (symbol_5 != null) {
                    if (c != null) {
                        if (c2t_3 != null) {
                            MAP_classComplexAttributesLM(symbol_5, c, c2t_3);
                        }
                    }
                }
                if (type_0 instanceof manualuml2rdbms.uml.Class) {
                    if (symbol_5 != null) {
                        MAP_complexAttributePrimitiveAttributesLM((manualuml2rdbms.uml.Class)type_0, symbol_5);
                    }
                }
                if (type_0 instanceof manualuml2rdbms.uml.Class) {
                    if (symbol_5 != null) {
                        MAP_complexAttributeComplexAttributesLM((manualuml2rdbms.uml.Class)type_0, symbol_5);
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map classToTableMR in ManualUML2RDBMS {
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * c2t : uml2rdbms::ClassToTable[?];
     *  |)
     * { |}
     * rdbms (s : rdbms::Schema[?];
     *  |)
     * {realize t : rdbms::Table[?];
     *  |}
     * where ( |
     * c2t.owner =
     *   p2s)
     * { |
     * t.kind := 'base';
     * t.schema := s;
     * }
     * map classToTableMR_1 {
     * c2t_1 := c2t;
     * t_1 := t;
     * }
     *   map classToTableMR_2 {
     * c2t_2 := c2t;
     * t_2 := t;
     * }
     *   for child : uml2rdbms::AssociationToForeignKey in c2t.associationsToForeignKeys {
     * 
     *     map associationToForeignKeyMR {
     * a2f := child;
     * dc2t := t.ClassToTable;
     * dt := t;
     * p2s := p2s;
     * rk := c2t.primaryKey;
     * s := s;
     * sc2t := t.ClassToTable;
     * st := t;
     * }}
     *   for child : uml2rdbms::FromAttribute in c2t.fromAttributes->union(
     *     c2t.fromAttributes->selectByKind(uml2rdbms::NonLeafAttribute).fromAttributes)
     *    {
     * map attributeColumnsMR {
     * a2c := child;
     * c2t := c2t;
     * t := t;
     * }}
     */
    protected boolean MAP_classToTableMR(final @NonNull /*@NonInvalid*/ ClassToTable c2t, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_8, final @NonNull /*@NonInvalid*/ Schema s) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        final @Nullable /*@Thrown*/ PackageToSchema owner = c2t.getOwner();
        final /*@Thrown*/ boolean eq = p2s_8.equals(owner);
        if (!eq) {
            return false;
        }
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_uml2rdbms_c_c_NonLeafAttribute_0 = idResolver.getClass(CLSSid_NonLeafAttribute, null);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<FromAttribute> fromAttributes = c2t.getFromAttributes();
        final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        // creations
        final /*@Thrown*/ Table t_0 = RDBMSFactory.eINSTANCE.createTable();
        assert t_0 != null;
        models[1/*rdbms*/].add(t_0);
        // property assignments
        t_0.setKind(STR_base);
        t_0.setSchema(s);
        // mapping statements
        if (c2t != null) {
            if (t_0 != null) {
                MAP_classToTableMR_1(c2t, t_0);
            }
        }
        if (c2t != null) {
            if (t_0 != null) {
                MAP_classToTableMR_2(c2t, t_0);
            }
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<AssociationToForeignKey> associationsToForeignKeys = c2t.getAssociationsToForeignKeys();
        for (AssociationToForeignKey child : associationsToForeignKeys) {
            if (child != null) {
                final @Nullable /*@Thrown*/ ClassToTable ClassToTable_0 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_table.get(t_0));
                final @NonNull /*@NonInvalid*/ AssociationToForeignKey symbol_4 = (AssociationToForeignKey)child;
                final @Nullable /*@Thrown*/ Key primaryKey = c2t.getPrimaryKey();
                if (symbol_4 != null) {
                    if (ClassToTable_0 != null) {
                        if (t_0 != null) {
                            if (p2s_8 != null) {
                                if (primaryKey != null) {
                                    if (s != null) {
                                        if (ClassToTable_0 != null) {
                                            if (t_0 != null) {
                                                MAP_associationToForeignKeyMR(symbol_4, ClassToTable_0, t_0, p2s_8, primaryKey, s, ClassToTable_0, t_0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        final @NonNull /*@Thrown*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_fromAttributes, TYP_uml2rdbms_c_c_NonLeafAttribute_0);
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_FromAttribute);
        @NonNull Iterator<?> ITERATOR__1 = selectByKind.iterator();
        @NonNull /*@Thrown*/ BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @SuppressWarnings("null")
            @NonNull /*@NonInvalid*/ NonLeafAttribute _1 = (NonLeafAttribute)ITERATOR__1.next();
            /**
             * fromAttributes
             */
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ List<FromAttribute> fromAttributes_1 = _1.getFromAttributes();
            final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes_1 = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes_1);
            //
            for (Object value : BOXED_fromAttributes_1.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final @NonNull /*@Thrown*/ BagValue union = (BagValue)CollectionUnionOperation.INSTANCE.evaluate(BOXED_fromAttributes, collect);
        for (FromAttribute child_0 : ValueUtil.typedIterable(FromAttribute.class, union)) {
            if (child_0 != null) {
                final @NonNull /*@NonInvalid*/ FromAttribute symbol_7 = (FromAttribute)child_0;
                if (symbol_7 instanceof AttributeToColumn) {
                    if (c2t != null) {
                        if (t_0 != null) {
                            MAP_attributeColumnsMR((AttributeToColumn)symbol_7, c2t, t_0);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map classToTableMR_1 in ManualUML2RDBMS {
     * middle (c2t_1 : uml2rdbms::ClassToTable[?];
     *  |)
     * { |}
     * rdbms (t_1 : rdbms::Table[?];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := c2t_1.name;
     * c2t_1.table := t_1;
     * t_1.name := _0;
     * }
     * 
     */
    protected boolean MAP_classToTableMR_1(final @NonNull /*@NonInvalid*/ ClassToTable c2t_1, final @NonNull /*@NonInvalid*/ Table t_1) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ String name = c2t_1.getName();
        // property assignments
        c2t_1.setTable(t_1);
        OPPOSITE_OF_ClassToTable_table.put(t_1, c2t_1);
        t_1.setName(name);
        return true;
    }
    
    /**
     * 
     * map classToTableMR_2 in ManualUML2RDBMS {
     * 
     *   middle (c2t_2 : uml2rdbms::ClassToTable[?];
     *  |)
     * { |}
     * rdbms (t_2 : rdbms::Table[?];
     *  |)
     * {realize pk : rdbms::Key[?];
     * realize pc : rdbms::Column[?];
     *  |}
     * where ( |)
     * { |
     * pk.owner := t_2;
     * pk.kind := 'primary';
     * pc.owner := t_2;
     * pc.key := OrderedSet{pk
     *   }
     *   ;
     * pc.type := 'NUMBER';
     * }
     * map classToTableMR_2_1 {
     * c2t_2_1 := c2t_2;
     * pc_2_1 := pc;
     * pk_2_1 := pk;
     * }
     *   map classToTableMR_2_2 {
     * pc_2_2 := pc;
     * pk_2_2 := pk;
     * t_2_2 := t_2;
     * }
     */
    protected boolean MAP_classToTableMR_2(final @NonNull /*@NonInvalid*/ ClassToTable c2t_2, final @NonNull /*@NonInvalid*/ Table t_2) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        // creations
        final /*@Thrown*/ Column pc = RDBMSFactory.eINSTANCE.createColumn();
        assert pc != null;
        models[1/*rdbms*/].add(pc);
        final /*@Thrown*/ Key pk = RDBMSFactory.eINSTANCE.createKey();
        assert pk != null;
        models[1/*rdbms*/].add(pk);
        // property assignments
        pk.setOwner(t_2);
        pk.setKind(STR_primary);
        pc.setOwner(t_2);
        final @NonNull /*@Thrown*/ OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_Key, pk);
        final @NonNull /*@Thrown*/ List<Key> ECORE_OrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Key.class, OrderedSet);
        pc.getKey().addAll(ECORE_OrderedSet);
        pc.setType(STR_NUMBER);
        // mapping statements
        if (c2t_2 != null) {
            if (pc != null) {
                if (pk != null) {
                    MAP_classToTableMR_2_1(c2t_2, pc, pk);
                }
            }
        }
        if (pc != null) {
            if (pk != null) {
                if (t_2 != null) {
                    MAP_classToTableMR_2_2(pc, pk, t_2);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map classToTableMR_2_1 in ManualUML2RDBMS {
     * middle (c2t_2_1 : uml2rdbms::ClassToTable[?];
     *  |)
     * { |}
     * rdbms (pk_2_1 : rdbms::Key[?];
     * pc_2_1 : rdbms::Column[?];
     *  |)
     * { |}
     * where ( |)
     * { |
     * c2t_2_1.primaryKey := pk_2_1;
     * c2t_2_1.column := pc_2_1;
     * }
     * 
     */
    protected boolean MAP_classToTableMR_2_1(final @NonNull /*@NonInvalid*/ ClassToTable c2t_2_1, final @NonNull /*@NonInvalid*/ Column pc_2_1, final @NonNull /*@NonInvalid*/ Key pk_2_1) throws ReflectiveOperationException {
        // predicates
        // property assignments
        c2t_2_1.setPrimaryKey(pk_2_1);
        c2t_2_1.setColumn(pc_2_1);
        return true;
    }
    
    /**
     * 
     * map classToTableMR_2_2 in ManualUML2RDBMS {
     * middle ( |)
     * { |}
     * rdbms (pk_2_2 : rdbms::Key[?];
     * pc_2_2 : rdbms::Column[?];
     * t_2_2 : rdbms::Table[?];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[1];
     * _1 : String[1];
     *  |
     * _0 := t_2_2.name + '_tid';
     * _1 := t_2_2.name + '_pk';
     * pc_2_2.name := _0;
     * pk_2_2.name := _1;
     * }
     * 
     */
    protected boolean MAP_classToTableMR_2_2(final @NonNull /*@NonInvalid*/ Column pc_2_2, final @NonNull /*@NonInvalid*/ Key pk_2_2, final @NonNull /*@NonInvalid*/ Table t_2_2) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ String name_0 = t_2_2.getName();
        // variable assignments
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR__tid);
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(name_0, STR__pk);
        // property assignments
        pc_2_2.setName(sum);
        pk_2_2.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map associationToForeignKeyLM in ManualUML2RDBMS {
     * uml (p : uml::Package[?];
     * sc : uml::Class[?];
     * dc : uml::Class[?];
     * a : uml::Association[?];
     *  |)
     * { |}
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * sc2t : uml2rdbms::ClassToTable[?];
     * dc2t : uml2rdbms::ClassToTable[?];
     *  |)
     * {realize a2f : uml2rdbms::AssociationToForeignKey[?];
     *  |}
     * where ( |
     * a.namespace = psc.namespace = pp2s.umlPackage =
     *   p)
     * {_0 : String[?];
     *  |
     * _0 := let dc2 : uml::Class[?] = dc;
     * 
     *   in
     *     if a.destination = dc and a.source = sc
     *     then a.name
     *     else
     *       if a.destination <> dc and a.source = sc
     *       then dc2.name + '_' + a.name
     *       else
     *         if a.destination = dc and a.source <> sc
     *         then a.name + '_' + sc.name
     *         else dc2.name + '_' + a.name + '_' + sc.name
     *         endif
     *       endif
     *     endif;
     * sc2t.owner := p2s;
     * a2f.owner := sc2t;
     * a2f.referenced := dc2t;
     * a2f.association := a;
     * a2f.name := _0;
     * }
     * 
     */
    protected boolean MAP_associationToForeignKeyLM(final @NonNull /*@NonInvalid*/ Association a, final @NonNull /*@NonInvalid*/ Package p_4, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_9) throws ReflectiveOperationException {
        // predicates
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class destination = a.getDestination();
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class dc = destination;
        final @Nullable /*@Thrown*/ Package namespace = a.getNamespace();
        final /*@Thrown*/ boolean eq = p_4.equals(namespace);
        if (!eq) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Package umlPackage = p2s_9.getUmlPackage();
        final /*@Thrown*/ boolean eq_0 = umlPackage.equals(p_4);
        if (!eq_0) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class source = a.getSource();
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class sc = source;
        if (dc == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::ClassToTable::umlClass\'");
        }
        if (dc instanceof InvalidValueException) {
            throw (InvalidValueException)dc;
        }
        final @Nullable /*@Thrown*/ ClassToTable ClassToTable = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(dc));
        final @Nullable /*@Thrown*/ ClassToTable dc2t_0 = ClassToTable;
        if (sc == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::ClassToTable::umlClass\'");
        }
        if (sc instanceof InvalidValueException) {
            throw (InvalidValueException)sc;
        }
        final @Nullable /*@Thrown*/ Package namespace_0 = sc.getNamespace();
        final /*@Thrown*/ boolean eq_1 = p_4.equals(namespace_0);
        if (!eq_1) {
            return false;
        }
        final @Nullable /*@Thrown*/ ClassToTable ClassToTable_0 = ClassUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(sc));
        final @Nullable /*@Thrown*/ ClassToTable sc2t_0 = ClassToTable_0;
        // variable assignments
        final @Nullable /*@Thrown*/ String name = a.getName();
        @NonNull /*@Caught*/ Object CAUGHT_eq_2;
        try {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class destination_0 = a.getDestination();
            if (dc instanceof InvalidValueException) {
                throw (InvalidValueException)dc;
            }
            final /*@Thrown*/ boolean eq_2 = destination_0.equals(dc);
            CAUGHT_eq_2 = eq_2;
        }
        catch (Exception e) {
            CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
        }
        @NonNull /*@Caught*/ Object CAUGHT_eq_3;
        try {
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class source_0 = a.getSource();
            if (sc instanceof InvalidValueException) {
                throw (InvalidValueException)sc;
            }
            final /*@Thrown*/ boolean eq_3 = source_0.equals(sc);
            CAUGHT_eq_3 = eq_3;
        }
        catch (Exception e) {
            CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
        }
        final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_eq_3);
        if (and == null) {
            throw new InvalidValueException("Null if condition");
        }
        @Nullable /*@Thrown*/ String symbol_2;
        if (and) {
            symbol_2 = name;
        }
        else {
            @NonNull /*@Caught*/ Object CAUGHT_ne;
            try {
                @SuppressWarnings("null")
                final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class destination_1 = a.getDestination();
                if (dc instanceof InvalidValueException) {
                    throw (InvalidValueException)dc;
                }
                final /*@Thrown*/ boolean ne = !destination_1.equals(dc);
                CAUGHT_ne = ne;
            }
            catch (Exception e) {
                CAUGHT_ne = ValueUtil.createInvalidValue(e);
            }
            final @Nullable /*@Thrown*/ Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq_3);
            if (and_0 == null) {
                throw new InvalidValueException("Null if condition");
            }
            @NonNull /*@Thrown*/ String symbol_1;
            if (and_0) {
                if (dc == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML\'::UMLModelElement::name\'");
                }
                if (dc instanceof InvalidValueException) {
                    throw (InvalidValueException)dc;
                }
                final @Nullable /*@Thrown*/ String name_0 = dc.getName();
                final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR__);
                final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name);
                symbol_1 = sum_0;
            }
            else {
                if (sc == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML\'::UMLModelElement::name\'");
                }
                if (sc instanceof InvalidValueException) {
                    throw (InvalidValueException)sc;
                }
                final @Nullable /*@Thrown*/ String name_6 = sc.getName();
                @NonNull /*@Caught*/ Object CAUGHT_ne_0;
                try {
                    @SuppressWarnings("null")
                    final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class source_2 = a.getSource();
                    if (sc instanceof InvalidValueException) {
                        throw (InvalidValueException)sc;
                    }
                    final /*@Thrown*/ boolean ne_0 = !source_2.equals(sc);
                    CAUGHT_ne_0 = ne_0;
                }
                catch (Exception e) {
                    CAUGHT_ne_0 = ValueUtil.createInvalidValue(e);
                }
                final @Nullable /*@Thrown*/ Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_ne_0);
                if (and_1 == null) {
                    throw new InvalidValueException("Null if condition");
                }
                @NonNull /*@Thrown*/ String symbol_0;
                if (and_1) {
                    final @NonNull /*@Thrown*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(name, STR__);
                    final @NonNull /*@Thrown*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, name_6);
                    symbol_0 = sum_2;
                }
                else {
                    if (dc == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML\'::UMLModelElement::name\'");
                    }
                    if (dc instanceof InvalidValueException) {
                        throw (InvalidValueException)dc;
                    }
                    final @Nullable /*@Thrown*/ String name_4 = dc.getName();
                    final @NonNull /*@Thrown*/ String sum_3 = StringConcatOperation.INSTANCE.evaluate(name_4, STR__);
                    final @NonNull /*@Thrown*/ String sum_4 = StringConcatOperation.INSTANCE.evaluate(sum_3, name);
                    final @NonNull /*@Thrown*/ String sum_5 = StringConcatOperation.INSTANCE.evaluate(sum_4, STR__);
                    final @NonNull /*@Thrown*/ String sum_6 = StringConcatOperation.INSTANCE.evaluate(sum_5, name_6);
                    symbol_0 = sum_6;
                }
                symbol_1 = symbol_0;
            }
            symbol_2 = symbol_1;
        }
        // creations
        final /*@Thrown*/ AssociationToForeignKey a2f_0 = UML2RDBMSFactory.eINSTANCE.createAssociationToForeignKey();
        assert a2f_0 != null;
        models[2/*middle*/].add(a2f_0);
        // property assignments
        sc2t_0.setOwner(p2s_9);
        a2f_0.setOwner(sc2t_0);
        a2f_0.setReferenced(dc2t_0);
        a2f_0.setAssociation(a);
        a2f_0.setName(symbol_2);
        return true;
    }
    
    /**
     * 
     * map associationToForeignKeyMR in ManualUML2RDBMS {
     * middle (p2s : uml2rdbms::PackageToSchema[?];
     * sc2t : uml2rdbms::ClassToTable[?];
     * dc2t : uml2rdbms::ClassToTable[?];
     * a2f : uml2rdbms::AssociationToForeignKey[?];
     *  |)
     * { |}
     * rdbms (s : rdbms::Schema[?];
     * st : rdbms::Table[?];
     * dt : rdbms::Table[?];
     * rk : rdbms::Key[?];
     *  |)
     * {realize fk : rdbms::ForeignKey[?];
     * realize fc : rdbms::Column[?];
     *  |}
     * where ( |
     * a2f.owner = sc2ta2f.referenced = dc2tp2s.schema = sst.schema = s)
     * {_0 : String[?];
     * _1 : String[1];
     *  |
     * _0 := a2f.name;
     * _1 := a2f.name +
     *   '_tid';
     * sc2t.owner := p2s;
     * fk.name := _0;
     * fc.name := _1;
     * fk.owner := st;
     * fc.owner := st;
     * }
     * map associationToForeignKeyMR_1 {
     * dt := a2f.referenced.table;
     * fc := fc;
     * fk := fk;
     * rk := rk;
     * }
     *   map associationToForeignKeyMR_2 {
     * a2f_1 := a2f;
     * fc_1 := fc;
     * fk_1 := fk;
     * }
     */
    protected boolean MAP_associationToForeignKeyMR(final @NonNull /*@NonInvalid*/ AssociationToForeignKey a2f, final @NonNull /*@NonInvalid*/ ClassToTable dc2t, final @NonNull /*@NonInvalid*/ Table dt, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_10, final @NonNull /*@NonInvalid*/ Key rk, final @NonNull /*@NonInvalid*/ Schema s_0, final @NonNull /*@NonInvalid*/ ClassToTable sc2t, final @NonNull /*@NonInvalid*/ Table st) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ ClassToTable owner = a2f.getOwner();
        final /*@Thrown*/ boolean eq = sc2t.equals(owner);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ ClassToTable referenced = a2f.getReferenced();
        final /*@Thrown*/ boolean eq_0 = dc2t.equals(referenced);
        if (!eq_0) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Schema schema = p2s_10.getSchema();
        final /*@Thrown*/ boolean eq_1 = schema.equals(s_0);
        if (!eq_1) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Schema schema_0 = st.getSchema();
        final /*@Thrown*/ boolean eq_2 = schema_0.equals(s_0);
        if (!eq_2) {
            return false;
        }
        final @Nullable /*@Thrown*/ String name = a2f.getName();
        // variable assignments
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__tid);
        // creations
        final /*@Thrown*/ Column fc_0 = RDBMSFactory.eINSTANCE.createColumn();
        assert fc_0 != null;
        models[1/*rdbms*/].add(fc_0);
        final /*@Thrown*/ ForeignKey fk_0 = RDBMSFactory.eINSTANCE.createForeignKey();
        assert fk_0 != null;
        models[1/*rdbms*/].add(fk_0);
        // property assignments
        sc2t.setOwner(p2s_10);
        fk_0.setName(name);
        fc_0.setName(sum);
        fk_0.setOwner(st);
        fc_0.setOwner(st);
        // mapping statements
        if (referenced == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::ClassToTable::table\'");
        }
        final @Nullable /*@Thrown*/ Table table = referenced.getTable();
        if (table != null) {
            if (fc_0 != null) {
                if (fk_0 != null) {
                    if (rk != null) {
                        MAP_associationToForeignKeyMR_1(table, fc_0, fk_0, rk);
                    }
                }
            }
        }
        if (a2f != null) {
            if (fc_0 != null) {
                if (fk_0 != null) {
                    MAP_associationToForeignKeyMR_2(a2f, fc_0, fk_0);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map associationToForeignKeyMR_1 in ManualUML2RDBMS {
     * 
     *   middle ( |)
     * { |}
     * rdbms (fk : rdbms::ForeignKey[?];
     * fc : rdbms::Column[?];
     * dt : rdbms::Table[?];
     * rk : rdbms::Key[?];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[?];
     *  |
     * _0 := rk.column->first()
     *   .type;
     * fk.refersTo := rk;
     * fc.foreignKeys := OrderedSet{fk
     *   };
     * fc.type := _0;
     * }
     * 
     */
    protected boolean MAP_associationToForeignKeyMR_1(final @NonNull /*@NonInvalid*/ Table dt_0, final @NonNull /*@NonInvalid*/ Column fc, final @NonNull /*@NonInvalid*/ ForeignKey fk, final @NonNull /*@NonInvalid*/ Key rk_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Column> column = rk_0.getColumn();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_column = idResolver.createOrderedSetOfAll(ORD_CLSSid_Column, column);
        final @Nullable /*@Thrown*/ Column first = (Column)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_column);
        if (first == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualRDBMS\'::Column::type\'");
        }
        final @Nullable /*@Thrown*/ String type = first.getType();
        // property assignments
        fk.setRefersTo(rk_0);
        final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet = ValueUtil.createOrderedSetOfEach(ORD_CLSSid_ForeignKey, fk);
        final @NonNull /*@NonInvalid*/ List<ForeignKey> ECORE_OrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(ForeignKey.class, OrderedSet);
        fc.getForeignKeys().addAll(ECORE_OrderedSet);
        fc.setType(type);
        return true;
    }
    
    /**
     * 
     * map associationToForeignKeyMR_2 in ManualUML2RDBMS {
     * middle (a2f_1 : uml2rdbms::AssociationToForeignKey[?];
     *  |)
     * { |}
     * rdbms (fk_1 : rdbms::ForeignKey[?];
     * fc_1 : rdbms::Column[?];
     *  |)
     * { |}
     * where ( |)
     * { |
     * a2f_1.foreignKey := fk_1;
     * a2f_1.column := fc_1;
     * }
     * 
     */
    protected boolean MAP_associationToForeignKeyMR_2(final @NonNull /*@NonInvalid*/ AssociationToForeignKey a2f_1, final @NonNull /*@NonInvalid*/ Column fc_1, final @NonNull /*@NonInvalid*/ ForeignKey fk_1) throws ReflectiveOperationException {
        // predicates
        // property assignments
        a2f_1.setForeignKey(fk_1);
        a2f_1.setColumn(fc_1);
        return true;
    }
    
    /**
     * 
     * map classPrimitiveAttributesLM in ManualUML2RDBMS {
     * uml (c : uml::Class[?];
     * t : uml::PrimitiveDataType[?];
     * a : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::ClassToTable[?];
     * p2n : uml2rdbms::PrimitiveToName[?];
     *  |)
     * {realize atc : uml2rdbms::AttributeToColumn[?];
     *  |}
     * where ( |
     * a.owner = cfao.umlClass =
     *   c)
     * {_0 : String[?];
     * _1 : String[?];
     *  |
     * _0 := a.kind;
     * _1 := a.name;
     * atc.attribute := a;
     * atc.owner := fao;
     * atc.type := p2n;
     * atc.kind := _0;
     * atc.name := _1;
     * atc.leafs := Set{atc
     *   };
     * }
     * 
     */
    protected boolean MAP_classPrimitiveAttributesLM(final @NonNull /*@NonInvalid*/ Attribute a_0, final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_0, final @NonNull /*@NonInvalid*/ ClassToTable fao) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class owner = a_0.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_0);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class umlClass = fao.getUmlClass();
        final /*@Thrown*/ boolean eq_0 = c_0.equals(umlClass);
        if (!eq_0) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = a_0.getType();
        if (!(type instanceof PrimitiveDataType)) {
            return false;
        }
        final @Nullable /*@Thrown*/ PrimitiveDataType t_0 = (PrimitiveDataType)type;
        if (t_0 == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::PrimitiveToName::primitive\'");
        }
        final @NonNull /*@Thrown*/ PrimitiveToName PrimitiveToName = ClassUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(t_0));
        final @Nullable /*@Thrown*/ PrimitiveToName p2n_3 = PrimitiveToName;
        // variable assignments
        final @Nullable /*@Thrown*/ String kind = a_0.getKind();
        final @Nullable /*@Thrown*/ String name = a_0.getName();
        // creations
        final /*@Thrown*/ AttributeToColumn atc = UML2RDBMSFactory.eINSTANCE.createAttributeToColumn();
        assert atc != null;
        models[2/*middle*/].add(atc);
        // property assignments
        atc.setAttribute(a_0);
        OPPOSITE_OF_FromAttribute_attribute.put(a_0, atc);
        atc.setOwner(fao);
        atc.setType(p2n_3);
        atc.setKind(kind);
        atc.setName(name);
        final @NonNull /*@Thrown*/ SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, atc);
        final @NonNull /*@Thrown*/ List<AttributeToColumn> ECORE_Set = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, Set);
        atc.getLeafs().addAll(ECORE_Set);
        return true;
    }
    
    /**
     * 
     * map classComplexAttributesLM in ManualUML2RDBMS {
     * uml (c : uml::Class[?];
     * t : uml::Class[?];
     * a : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::ClassToTable[?];
     *  |)
     * {realize fa : uml2rdbms::NonLeafAttribute[?];
     *  |}
     * where ( |
     * a.owner = cfao.umlClass =
     *   c)
     * {_0 : String[?];
     * _1 : String[?];
     * _2 : Set(uml2rdbms::AttributeToColumn);
     *  |
     * _0 := a.kind;
     * _1 := a.name;
     * _2 := fao.fromAttributes.leafs->asSet();
     * fa.attribute := a;
     * fa.owner := fao;
     * fa.kind := _0;
     * fa.name := _1;
     * fa.leafs := _2;
     * }
     * 
     */
    protected boolean MAP_classComplexAttributesLM(final @NonNull /*@NonInvalid*/ Attribute a_1, final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_1, final @NonNull /*@NonInvalid*/ ClassToTable fao_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class owner = a_1.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_1);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class umlClass = fao_0.getUmlClass();
        final /*@Thrown*/ boolean eq_0 = c_1.equals(umlClass);
        if (!eq_0) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = a_1.getType();
        if (!(type instanceof manualuml2rdbms.uml.Class)) {
            return false;
        }
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class t_0 = (manualuml2rdbms.uml.Class)type;
        // variable assignments
        final @Nullable /*@Thrown*/ String kind = a_1.getKind();
        final @Nullable /*@Thrown*/ String name = a_1.getName();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<FromAttribute> fromAttributes = fao_0.getFromAttributes();
        final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_fromAttributes.iterator();
        @NonNull /*@Thrown*/ BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ FromAttribute _1 = (FromAttribute)ITERATOR__1.next();
            /**
             * leafs
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::FromAttribute::leafs\'");
            }
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ List<AttributeToColumn> leafs = _1.getLeafs();
            final @NonNull /*@Thrown*/ SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
            //
            for (Object value : BOXED_leafs.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final @NonNull /*@Thrown*/ SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
        // creations
        final /*@Thrown*/ NonLeafAttribute fa = UML2RDBMSFactory.eINSTANCE.createNonLeafAttribute();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setAttribute(a_1);
        OPPOSITE_OF_FromAttribute_attribute.put(a_1, fa);
        fa.setOwner(fao_0);
        fa.setKind(kind);
        fa.setName(name);
        final @NonNull /*@NonInvalid*/ List<AttributeToColumn> ECORE_asSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, asSet);
        fa.getLeafs().addAll(ECORE_asSet);
        return true;
    }
    
    /**
     * 
     * map complexAttributePrimitiveAttributesLM in ManualUML2RDBMS {
     * uml (c : uml::Class[?];
     * ca : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::NonLeafAttribute[?];
     *  |)
     * { |}
     * where ( |
     * ca.type =
     *   c)
     * { |}
     * for anAttribute : uml::Attribute in c.attributes {
     * 
     *     map complexAttributePrimitiveAttributesLM_1 {
     * a_1 := anAttribute;
     * c_1 := c;
     * ca_1 := ca;
     * fao_1 := fao;
     * }}
     */
    protected boolean MAP_complexAttributePrimitiveAttributesLM(final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_2, final @NonNull /*@NonInvalid*/ Attribute ca) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ FromAttribute FromAttribute = ClassUtil.nonNullState (OPPOSITE_OF_FromAttribute_attribute.get(ca));
        if (!(FromAttribute instanceof NonLeafAttribute)) {
            return false;
        }
        final @Nullable /*@Thrown*/ NonLeafAttribute fao_2 = (NonLeafAttribute)FromAttribute;
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = ca.getType();
        final /*@Thrown*/ boolean eq = type.equals(c_2);
        if (!eq) {
            return false;
        }
        // mapping statements
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Attribute> attributes = c_2.getAttributes();
        for (Attribute anAttribute : attributes) {
            if (anAttribute != null) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_0 = (Attribute)anAttribute;
                if (symbol_0 != null) {
                    if (c_2 != null) {
                        if (ca != null) {
                            if (fao_2 != null) {
                                MAP_complexAttributePrimitiveAttributesLM_1(symbol_0, c_2, ca, fao_2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map complexAttributePrimitiveAttributesLM_1 in ManualUML2RDBMS {
     * uml (c_1 : uml::Class[?];
     * t_1 : uml::PrimitiveDataType[?];
     * a_1 : uml::Attribute[?];
     * ca_1 : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao_1 : uml2rdbms::NonLeafAttribute[?];
     * p2n_1 : uml2rdbms::PrimitiveToName[?];
     *  |)
     * {realize fa : uml2rdbms::AttributeToColumn[?];
     *  |}
     * where ( |
     * )
     * {_0 : String[?];
     * _1 : String[1];
     *  |
     * _0 := a_1.kind;
     * _1 := ca_1.name + '_' +
     *   a_1.name;
     * fa.owner := fao_1;
     * fa.leafs := Set{fa
     *   };
     * fa.attribute := a_1;
     * fa.type := p2n_1;
     * fa.kind := _0;
     * fa.name := _1;
     * }
     * 
     */
    protected boolean MAP_complexAttributePrimitiveAttributesLM_1(final @NonNull /*@NonInvalid*/ Attribute a_1_0, final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_1_0, final @NonNull /*@NonInvalid*/ Attribute ca_1, final @NonNull /*@NonInvalid*/ NonLeafAttribute fao_1) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = a_1_0.getType();
        if (!(type instanceof PrimitiveDataType)) {
            return false;
        }
        final @Nullable /*@Thrown*/ PrimitiveDataType t_1_0 = (PrimitiveDataType)type;
        if (t_1_0 == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::PrimitiveToName::primitive\'");
        }
        final @NonNull /*@Thrown*/ PrimitiveToName PrimitiveToName = ClassUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(t_1_0));
        final @Nullable /*@Thrown*/ PrimitiveToName p2n_1_0 = PrimitiveToName;
        // variable assignments
        final @Nullable /*@Thrown*/ String kind = a_1_0.getKind();
        final @Nullable /*@Thrown*/ String name = ca_1.getName();
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
        final @Nullable /*@Thrown*/ String name_0 = a_1_0.getName();
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
        // creations
        final /*@Thrown*/ AttributeToColumn fa = UML2RDBMSFactory.eINSTANCE.createAttributeToColumn();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setOwner(fao_1);
        final @NonNull /*@Thrown*/ SetValue Set = ValueUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, fa);
        final @NonNull /*@Thrown*/ List<AttributeToColumn> ECORE_Set = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, Set);
        fa.getLeafs().addAll(ECORE_Set);
        fa.setAttribute(a_1_0);
        OPPOSITE_OF_FromAttribute_attribute.put(a_1_0, fa);
        fa.setType(p2n_1_0);
        fa.setKind(kind);
        fa.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map complexAttributeComplexAttributesLM in ManualUML2RDBMS {
     * uml (c : uml::Class[?];
     * ca : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao : uml2rdbms::NonLeafAttribute[?];
     *  |)
     * { |}
     * where ( |
     * ca.type =
     *   c)
     * { |}
     * for anAttribute : uml::Attribute in c.attributes {
     * 
     *     map complexAttributeComplexAttributesLM_1 {
     * a_1 := anAttribute;
     * c_1 := c;
     * ca_1 := ca;
     * fao_1 := fao;
     * }}
     */
    protected boolean MAP_complexAttributeComplexAttributesLM(final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_3, final @NonNull /*@NonInvalid*/ Attribute ca_0) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ FromAttribute FromAttribute = ClassUtil.nonNullState (OPPOSITE_OF_FromAttribute_attribute.get(ca_0));
        if (!(FromAttribute instanceof NonLeafAttribute)) {
            return false;
        }
        final @Nullable /*@Thrown*/ NonLeafAttribute fao_2 = (NonLeafAttribute)FromAttribute;
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = ca_0.getType();
        final /*@Thrown*/ boolean eq = type.equals(c_3);
        if (!eq) {
            return false;
        }
        // mapping statements
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Attribute> attributes = c_3.getAttributes();
        for (Attribute anAttribute : attributes) {
            if (anAttribute != null) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_0 = (Attribute)anAttribute;
                if (symbol_0 != null) {
                    if (c_3 != null) {
                        if (ca_0 != null) {
                            if (fao_2 != null) {
                                MAP_complexAttributeComplexAttributesLM_1(symbol_0, c_3, ca_0, fao_2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map complexAttributeComplexAttributesLM_1 in ManualUML2RDBMS {
     * uml (c_1 : uml::Class[?];
     * ca_1 : uml::Attribute[?];
     * t_1 : uml::Class[?];
     * a_1 : uml::Attribute[?];
     *  |)
     * { |}
     * middle (fao_1 : uml2rdbms::NonLeafAttribute[?];
     *  |)
     * {realize fa : uml2rdbms::NonLeafAttribute[?];
     *  |}
     * where ( |
     * a_1.owner =
     *   c_1)
     * {_0 : Set(uml2rdbms::AttributeToColumn);
     * _1 : String[?];
     * _2 : String[1];
     *  |
     * _0 := fao_1.fromAttributes.leafs->asSet();
     * _1 := a_1.kind;
     * _2 := ca_1.name + '_' + a_1.name;
     * fa.owner := fao_1;
     * fa.leafs := _0;
     * fa.attribute := a_1;
     * fa.kind := _1;
     * fa.name := _2;
     * }
     * 
     */
    protected boolean MAP_complexAttributeComplexAttributesLM_1(final @NonNull /*@NonInvalid*/ Attribute a_1_1, final @NonNull /*@NonInvalid*/ manualuml2rdbms.uml.Class c_1_1, final @NonNull /*@NonInvalid*/ Attribute ca_1_0, final @NonNull /*@NonInvalid*/ NonLeafAttribute fao_1_0) throws ReflectiveOperationException {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ manualuml2rdbms.uml.Class owner = a_1_1.getOwner();
        final /*@Thrown*/ boolean eq = owner.equals(c_1_1);
        if (!eq) {
            return false;
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Classifier type = a_1_1.getType();
        if (!(type instanceof manualuml2rdbms.uml.Class)) {
            return false;
        }
        final @Nullable /*@Thrown*/ manualuml2rdbms.uml.Class t_1_0 = (manualuml2rdbms.uml.Class)type;
        // variable assignments
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<FromAttribute> fromAttributes = fao_1_0.getFromAttributes();
        final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
        @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_fromAttributes.iterator();
        @NonNull /*@Thrown*/ BagValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ FromAttribute _1 = (FromAttribute)ITERATOR__1.next();
            /**
             * leafs
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::FromAttribute::leafs\'");
            }
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ List<AttributeToColumn> leafs = _1.getLeafs();
            final @NonNull /*@Thrown*/ SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
            //
            for (Object value : BOXED_leafs.flatten().getElements()) {
                accumulator.add(value);
            }
        }
        final @NonNull /*@Thrown*/ SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
        final @Nullable /*@Thrown*/ String kind = a_1_1.getKind();
        final @Nullable /*@Thrown*/ String name = ca_1_0.getName();
        final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
        final @Nullable /*@Thrown*/ String name_0 = a_1_1.getName();
        final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
        // creations
        final /*@Thrown*/ NonLeafAttribute fa = UML2RDBMSFactory.eINSTANCE.createNonLeafAttribute();
        assert fa != null;
        models[2/*middle*/].add(fa);
        // property assignments
        fa.setOwner(fao_1_0);
        final @NonNull /*@NonInvalid*/ List<AttributeToColumn> ECORE_asSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(AttributeToColumn.class, asSet);
        fa.getLeafs().addAll(ECORE_asSet);
        fa.setAttribute(a_1_1);
        OPPOSITE_OF_FromAttribute_attribute.put(a_1_1, fa);
        fa.setKind(kind);
        fa.setName(sum_0);
        return true;
    }
    
    /**
     * 
     * map attributeColumnsMR in ManualUML2RDBMS {
     * middle (c2t : uml2rdbms::ClassToTable[?];
     * a2c : uml2rdbms::AttributeToColumn[?];
     * p2n : uml2rdbms::PrimitiveToName[?];
     *  |)
     * { |}
     * rdbms (t : rdbms::Table[?];
     * ct : String[?];
     *  |)
     * {realize c : rdbms::Column[?];
     *  |}
     * where ( |
     * c2t.table =
     *   t)
     * { |
     * c.owner := t;
     * }
     * map attributeColumnsMR_1 {
     * a2c_1 := a2c;
     * c_1 := c;
     * }
     *   map attributeColumnsMR_2 {
     * a2c_2 := a2c;
     * c_2 := c;
     * ct_2 := ct;
     * p2n_2 := p2n;
     * }
     *   map attributeColumnsMR_3 {
     * a2c_3 := a2c;
     * c_3 := c;
     * }
     */
    protected boolean MAP_attributeColumnsMR(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c, final @NonNull /*@NonInvalid*/ ClassToTable c2t_0, final @NonNull /*@NonInvalid*/ Table t) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ Table table = c2t_0.getTable();
        final /*@Thrown*/ boolean eq = t.equals(table);
        if (!eq) {
            return false;
        }
        final @Nullable /*@Thrown*/ PrimitiveToName type = a2c.getType();
        final @Nullable /*@Thrown*/ PrimitiveToName p2n_3 = type;
        if (p2n_3 == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS\'::PrimitiveToName::typeName\'");
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ String typeName = p2n_3.getTypeName();
        final @Nullable /*@Thrown*/ String ct = typeName;
        // creations
        final /*@Thrown*/ Column c_4 = RDBMSFactory.eINSTANCE.createColumn();
        assert c_4 != null;
        models[1/*rdbms*/].add(c_4);
        // property assignments
        c_4.setOwner(t);
        // mapping statements
        if (a2c != null) {
            if (c_4 != null) {
                MAP_attributeColumnsMR_1(a2c, c_4);
            }
        }
        if (a2c != null) {
            if (c_4 != null) {
                if (ct != null) {
                    if (p2n_3 != null) {
                        MAP_attributeColumnsMR_2(a2c, c_4, ct, p2n_3);
                    }
                }
            }
        }
        if (a2c != null) {
            if (c_4 != null) {
                MAP_attributeColumnsMR_3(a2c, c_4);
            }
        }
        return true;
    }
    
    /**
     * 
     * map attributeColumnsMR_1 in ManualUML2RDBMS {
     * middle (a2c_1 : uml2rdbms::AttributeToColumn[?];
     *  |)
     * { |}
     * rdbms (c_1 : rdbms::Column[?];
     *  |)
     * { |}
     * where ( |)
     * { |
     * a2c_1.column := c_1;
     * }
     * 
     */
    protected boolean MAP_attributeColumnsMR_1(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_1, final @NonNull /*@NonInvalid*/ Column c_1_2) throws ReflectiveOperationException {
        // predicates
        // property assignments
        a2c_1.setColumn(c_1_2);
        return true;
    }
    
    /**
     * 
     * map attributeColumnsMR_2 in ManualUML2RDBMS {
     * middle (p2n_2 : uml2rdbms::PrimitiveToName[?];
     * a2c_2 : uml2rdbms::AttributeToColumn[?];
     *  |)
     * { |}
     * rdbms (c_2 : rdbms::Column[?];
     * ct_2 : String[?];
     *  |)
     * { |}
     * where ( |
     * a2c_2.type =
     *   p2n_2)
     * { |
     * c_2.type := ct_2;
     * }
     * map attributeColumnsMR_2_1 {
     * ct_2_1 := ct_2;
     * p2n_2_1 := p2n_2;
     * }
     */
    protected boolean MAP_attributeColumnsMR_2(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_2, final @NonNull /*@NonInvalid*/ Column c_2_0, final @NonNull /*@NonInvalid*/ String ct_2, final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_2) throws ReflectiveOperationException {
        // predicates
        final @Nullable /*@Thrown*/ PrimitiveToName type = a2c_2.getType();
        final /*@Thrown*/ boolean eq = p2n_2.equals(type);
        if (!eq) {
            return false;
        }
        // property assignments
        c_2_0.setType(ct_2);
        // mapping statements
        if (ct_2 != null) {
            if (p2n_2 != null) {
                MAP_attributeColumnsMR_2_1(ct_2, p2n_2);
            }
        }
        return true;
    }
    
    /**
     * 
     * map attributeColumnsMR_2_1 in ManualUML2RDBMS {
     * middle (p2n_2_1 : uml2rdbms::PrimitiveToName[?];
     *  |)
     * { |}
     * rdbms (ct_2_1 : String[?];
     *  |)
     * { |}
     * where ( |)
     * { |
     * p2n_2_1.typeName := ct_2_1;
     * }
     * 
     */
    protected boolean MAP_attributeColumnsMR_2_1(final @NonNull /*@NonInvalid*/ String ct_2_1, final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_2_1) throws ReflectiveOperationException {
        // predicates
        // property assignments
        p2n_2_1.setTypeName(ct_2_1);
        return true;
    }
    
    /**
     * 
     * map attributeColumnsMR_3 in ManualUML2RDBMS {
     * middle (a2c_3 : uml2rdbms::AttributeToColumn[?];
     *  |)
     * { |}
     * rdbms (c_3 : rdbms::Column[?];
     *  |)
     * { |}
     * where ( |)
     * {_0 : String[?];
     * _1 : String[?];
     *  |
     * _0 := a2c_3.name;
     * _1 := a2c_3.kind;
     * c_3.name := _0;
     * c_3.kind := _1;
     * }
     * 
     */
    protected boolean MAP_attributeColumnsMR_3(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_3, final @NonNull /*@NonInvalid*/ Column c_3_0) throws ReflectiveOperationException {
        // predicates
        // variable assignments
        final @Nullable /*@Thrown*/ String name = a2c_3.getName();
        final @Nullable /*@Thrown*/ String kind = a2c_3.getKind();
        // property assignments
        c_3_0.setName(name);
        c_3_0.setKind(kind);
        return true;
    }
}
