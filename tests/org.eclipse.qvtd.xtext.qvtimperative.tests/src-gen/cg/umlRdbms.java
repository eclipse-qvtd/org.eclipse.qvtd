/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.evaluation.AbstractTransformation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.examples.library.collection.CollectionUnionOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.examples.library.string.StringConcatOperation;
import test.simplerdbms.Column;
import test.simplerdbms.ForeignKey;
import test.simplerdbms.Key;
import test.simplerdbms.Schema;
import test.simplerdbms.SimplerdbmsFactory;
import test.simplerdbms.SimplerdbmsPackage;
import test.simplerdbms.Table;
import test.simpleuml.Association;
import test.simpleuml.Attribute;
import test.simpleuml.Class;
import test.simpleuml.Classifier;
import test.simpleuml.Package;
import test.simpleuml.PackageElement;
import test.simpleuml.PrimitiveDataType;
import test.simpleuml.SimpleumlPackage;
import test.umltordbms.AssociationToForeignKey;
import test.umltordbms.AttributeToColumn;
import test.umltordbms.ClassToTable;
import test.umltordbms.FromAttribute;
import test.umltordbms.NonLeafAttribute;
import test.umltordbms.PackageToSchema;
import test.umltordbms.PrimitiveToName;
import test.umltordbms.UmltordbmsFactory;
import test.umltordbms.UmltordbmsPackage;

/**
 * The umlRdbms transformation:
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
public class umlRdbms extends AbstractTransformation
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/SimpleRDBMS", null, SimplerdbmsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/UMLtoRDBMS", null, UmltordbmsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/examples/0.1/simpleUML", null, SimpleumlPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Association = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("Association", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AssociationToForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("AssociationToForeignKey", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("Attribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AttributeToColumn = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("AttributeToColumn", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassToTable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("ClassToTable", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Classifier = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("Classifier", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Column = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Column", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ForeignKey = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("ForeignKey", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_FromAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("FromAttribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Key = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Key", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NonLeafAttribute = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("NonLeafAttribute", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("PackageElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageToSchema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("PackageToSchema", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PrimitiveDataType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_simpleUML.getClassId("PrimitiveDataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PrimitiveToName = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_UMLtoRDBMS.getClassId("PrimitiveToName", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Schema = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Schema", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Table = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_examples_s_0_1_s_SimpleRDBMS.getClassId("Table", 0);
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
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_AttributeToColumn = TypeId.BAG.getSpecializedId(CLSSid_AttributeToColumn);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_FromAttribute = TypeId.BAG.getSpecializedId(CLSSid_FromAttribute);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_AssociationToForeignKey = TypeId.ORDERED_SET.getSpecializedId(CLSSid_AssociationToForeignKey);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Attribute = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Attribute);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Column = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Column);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ForeignKey = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ForeignKey);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Key = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Key);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Association = TypeId.SET.getSpecializedId(CLSSid_Association);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Attribute = TypeId.SET.getSpecializedId(CLSSid_Attribute);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_AttributeToColumn = TypeId.SET.getSpecializedId(CLSSid_AttributeToColumn);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassToTable = TypeId.SET.getSpecializedId(CLSSid_ClassToTable);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_FromAttribute = TypeId.SET.getSpecializedId(CLSSid_FromAttribute);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_NonLeafAttribute = TypeId.SET.getSpecializedId(CLSSid_NonLeafAttribute);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PrimitiveToName = TypeId.SET.getSpecializedId(CLSSid_PrimitiveToName);
    
    /* Outer-to-Middle Property navigation caches */
    protected final @NonNull Map<Table,ClassToTable> OPPOSITE_OF_ClassToTable_table = new HashMap<Table,ClassToTable>();
    protected final @NonNull Map<Class,ClassToTable> OPPOSITE_OF_ClassToTable_umlClass = new HashMap<Class,ClassToTable>();
    protected final @NonNull Map<Attribute,FromAttribute> OPPOSITE_OF_FromAttribute_attribute = new HashMap<Attribute,FromAttribute>();
    protected final @NonNull Map<PrimitiveDataType,PrimitiveToName> OPPOSITE_OF_PrimitiveToName_primitive = new HashMap<PrimitiveDataType,PrimitiveToName>();
    
    public umlRdbms(final @NonNull DomainEvaluator evaluator) {
        super(evaluator, new String[] {"uml", "rdbms", "middle"});
    }
    
    public boolean run() {
        final EClass ECLASS_p = SimpleumlPackage.Literals.PACKAGE;
        assert ECLASS_p != null;
        List<? extends Package> LIST_p = getObjectsByType(Package.class, 0/*uml*/, ECLASS_p);
        for (Package p : LIST_p) {
            if (p != null) {
                packageToSchemaLM(p);
            }
        }
        return true;
    }
    
    protected @NonNull List<Class> getAllSupers(final @Nullable /*@NonInvalid*/ Class cls) {
        @SuppressWarnings("null")@NonNull List<Class> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    protected @NonNull List<Attribute> getAllAttributes(final @Nullable /*@NonInvalid*/ Class cls_0) {
        @SuppressWarnings("null")@NonNull List<Attribute> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    protected @NonNull List<Association> getAllForwards(final @Nullable /*@NonInvalid*/ Class cls_1) {
        @SuppressWarnings("null")@NonNull List<Association> emptyList = Collections.emptyList();
        return emptyList;
    }
    
    /**
     * 
     * map packageToSchemaLM in umlRdbms) {
     * 
     *   uml (p : simpleuml::Package;
     *  |
     * )
     * { |
     * }
     * middle ( |
     * )
     * {realize p2s : umltordbms::PackageToSchema;
     *  |
     * }
     * where ( |
     * )
     * { |
     * p2s = p;
     * p2s = p.name;
     * }
     * for child : simpleuml::PackageElement in p.elements {
     * 
     *     map integerToNumberLM {
     * p := p;
     * prim := child;
     * p2s := p2s;
     * }
     *     map booleanToBooleanLM {
     * p := p;
     * prim := child;
     * p2s := p2s;
     * }
     *     map stringToVarcharLM {
     * p := p;
     * prim := child;
     * p2s := p2s;
     * }}
     *   for child : simpleuml::PackageElement in p.elements {
     * 
     *     map classToTableLM {
     * p := p;
     * c := child;
     * p2s := p2s;
     * }
     *     map associationToForeignKeyLM {
     * p := p;
     * a := child;
     * p2s := p2s;
     * }}
     *   map packageToSchemaMR {
     * p2s := p2s;
     * }
     * }
     */
    protected boolean packageToSchemaLM(final @NonNull /*@NonInvalid*/ Package p) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ List<PackageElement> elements_0 = p.getElements();
            assert elements_0 != null;
            // creations
            final /*@Thrown*/ PackageToSchema p2s = UmltordbmsFactory.eINSTANCE.createPackageToSchema();
            assert p2s != null;
            modelObjects[2/*middle*/].add(p2s);
            // assignments
            p2s.setUmlPackage(p);
            final @Nullable /*@Thrown*/ String name = p.getName();
            p2s.setName(name);
            // mapping statements
            ;
            for (PackageElement child : elements_0) {
                final @NonNull /*@NonInvalid*/ PackageElement symbol_5 = (PackageElement)child;
                if (symbol_5 instanceof PrimitiveDataType) {
                    integerToNumberLM(p, p2s, (PrimitiveDataType)symbol_5);
                }
                if (symbol_5 instanceof PrimitiveDataType) {
                    booleanToBooleanLM(p, p2s, (PrimitiveDataType)symbol_5);
                }
                if (symbol_5 instanceof PrimitiveDataType) {
                    stringToVarcharLM(p, p2s, (PrimitiveDataType)symbol_5);
                }
            }
            ;
            for (PackageElement child_0 : elements_0) {
                final @NonNull /*@NonInvalid*/ PackageElement symbol_13 = (PackageElement)child_0;
                if (symbol_13 instanceof Class) {
                    classToTableLM((Class)symbol_13, p, p2s);
                }
                if (symbol_13 instanceof Association) {
                    associationToForeignKeyLM((Association)symbol_13, p, p2s);
                }
            }
            packageToSchemaMR(p2s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map packageToSchemaMR in umlRdbms) {
     * 
     *   middle (p2s : umltordbms::PackageToSchema;
     *  |
     * )
     * { |
     * }
     * rdbms ( |
     * )
     * {realize s : simplerdbms::Schema;
     *  |
     * }
     * where ( |
     * )
     * { |
     * p2s = s;
     * }
     * map packageToSchemaMR_1 {
     * s_1 := s;
     * p2s_1 := p2s;
     * }
     *   for child : umltordbms::PrimitiveToName in p2s.primitivesToNames {
     * 
     *     map integerToNumberMR {
     * p2s := p2s;
     * p2n := child;
     * }
     *     map booleanToBooleanMR {
     * p2s := p2s;
     * p2n := child;
     * }
     *     map stringToVarcharMR {
     * p2s := p2s;
     * p2n := child;
     * }}
     *   for child : umltordbms::ClassToTable in p2s.classesToTables {
     * 
     *     map classToTableMR {
     * p2s := p2s;
     * c2t := child;
     * s := s;
     * }}
     * }
     */
    protected boolean packageToSchemaMR(final @NonNull /*@NonInvalid*/ PackageToSchema p2s) {
        try {
            // predicates
            // creations
            final /*@Thrown*/ Schema s = SimplerdbmsFactory.eINSTANCE.createSchema();
            assert s != null;
            modelObjects[1/*rdbms*/].add(s);
            // assignments
            p2s.setSchema(s);
            // mapping statements
            packageToSchemaMR_1(p2s, s);
            final @Nullable /*@Thrown*/ List<PrimitiveToName> primitivesToNames = p2s.getPrimitivesToNames();
            assert primitivesToNames != null;
            ;
            for (PrimitiveToName child : primitivesToNames) {
                final @NonNull /*@NonInvalid*/ PrimitiveToName symbol_5 = (PrimitiveToName)child;
                integerToNumberMR(symbol_5, p2s);
                booleanToBooleanMR(symbol_5, p2s);
                stringToVarcharMR(symbol_5, p2s);
            }
            final @Nullable /*@Thrown*/ List<ClassToTable> classesToTables = p2s.getClassesToTables();
            assert classesToTables != null;
            ;
            for (ClassToTable child_0 : classesToTables) {
                final @NonNull /*@NonInvalid*/ ClassToTable symbol_11 = (ClassToTable)child_0;
                classToTableMR(symbol_11, p2s, s);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map packageToSchemaMR_1 in umlRdbms) {
     * middle (p2s_1 : umltordbms::PackageToSchema;
     *  |
     * )
     * { |
     * }
     * rdbms (s_1 : simplerdbms::Schema;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * s_1 = p2s_1.name;
     * }
     * 
     * }
     */
    protected boolean packageToSchemaMR_1(final @NonNull /*@NonInvalid*/ PackageToSchema p2s_1, final @NonNull /*@NonInvalid*/ Schema s_1) {
        try {
            // predicates
            // creations
            // assignments
            final @Nullable /*@Thrown*/ String name = p2s_1.getName();
            s_1.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map integerToNumberLM in umlRdbms) {
     * uml (p : simpleuml::Package;
     * prim : simpleuml::PrimitiveDataType;
     *  |
     * )
     * { |
     * }
     * middle (p2s : umltordbms::PackageToSchema;
     *  |
     * )
     * {realize p2n : umltordbms::PrimitiveToName;
     *  |
     * }
     * where ( |
     * prim.namespace = pprim.name = 'Integer'p2s.umlPackage = p)
     * { |
     * p2n = p2s;
     * p2n = prim;
     * p2n = prim.name + '2' + 'NUMBER';
     * }
     * 
     * }
     */
    protected boolean integerToNumberLM(final @NonNull /*@NonInvalid*/ Package p_0, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_0, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Package umlPackage = p2s_0.getUmlPackage();
            final /*@Thrown*/ boolean eq = p_0.equals(umlPackage);
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
            // creations
            final /*@Thrown*/ PrimitiveToName p2n = UmltordbmsFactory.eINSTANCE.createPrimitiveToName();
            assert p2n != null;
            modelObjects[2/*middle*/].add(p2n);
            // assignments
            p2n.setOwner(p2s_0);
            p2n.setPrimitive(prim);
            OPPOSITE_OF_PrimitiveToName_primitive.put(prim, p2n);
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_NUMBER);
            p2n.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map integerToNumberMR in umlRdbms) {
     * middle (p2s : umltordbms::PackageToSchema;
     * p2n : umltordbms::PrimitiveToName;
     *  |
     * )
     * { |
     * }
     * rdbms ( |
     * )
     * { |
     * }
     * where ( |
     * p2n.owner = p2sp2n.name = 'Integer' + '2' + 'NUMBER')
     * { |
     * }
     * 
     * }
     */
    protected boolean integerToNumberMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_2) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ String name = p2n.getName();
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_Integer, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_NUMBER);
            final /*@Thrown*/ boolean eq = sum_0.equals(name);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ PackageToSchema owner = p2n.getOwner();
            final /*@Thrown*/ boolean eq_0 = p2s_2.equals(owner);
            if (!eq_0) {
                return false;
            }
            // creations
            // assignments
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map booleanToBooleanLM in umlRdbms) {
     * uml (p : simpleuml::Package;
     * prim : simpleuml::PrimitiveDataType;
     *  |
     * )
     * { |
     * }
     * middle (p2s : umltordbms::PackageToSchema;
     *  |
     * )
     * {realize p2n : umltordbms::PrimitiveToName;
     *  |
     * }
     * where ( |
     * prim.namespace = pprim.name = 'Boolean'p2s.umlPackage = p)
     * { |
     * p2n = p2s;
     * p2n = prim;
     * p2n = prim.name + '2' + 'BOOLEAN';
     * }
     * 
     * }
     */
    protected boolean booleanToBooleanLM(final @NonNull /*@NonInvalid*/ Package p_1, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_3, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim_0) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Package umlPackage = p2s_3.getUmlPackage();
            final /*@Thrown*/ boolean eq = p_1.equals(umlPackage);
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
            // creations
            final /*@Thrown*/ PrimitiveToName p2n = UmltordbmsFactory.eINSTANCE.createPrimitiveToName();
            assert p2n != null;
            modelObjects[2/*middle*/].add(p2n);
            // assignments
            p2n.setOwner(p2s_3);
            p2n.setPrimitive(prim_0);
            OPPOSITE_OF_PrimitiveToName_primitive.put(prim_0, p2n);
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_BOOLEAN);
            p2n.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map booleanToBooleanMR in umlRdbms) {
     * middle (p2s : umltordbms::PackageToSchema;
     * p2n : umltordbms::PrimitiveToName;
     *  |
     * )
     * { |
     * }
     * rdbms ( |
     * )
     * { |
     * }
     * where ( |
     * p2n.owner = p2sp2n.name = 'Boolean' + '2' + 'BOOLEAN')
     * { |
     * }
     * 
     * }
     */
    protected boolean booleanToBooleanMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_0, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_4) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ String name = p2n_0.getName();
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_Boolean, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_BOOLEAN);
            final /*@Thrown*/ boolean eq = sum_0.equals(name);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ PackageToSchema owner = p2n_0.getOwner();
            final /*@Thrown*/ boolean eq_0 = p2s_4.equals(owner);
            if (!eq_0) {
                return false;
            }
            // creations
            // assignments
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map stringToVarcharLM in umlRdbms) {
     * uml (p : simpleuml::Package;
     * prim : simpleuml::PrimitiveDataType;
     *  |
     * )
     * { |
     * }
     * middle (p2s : umltordbms::PackageToSchema;
     *  |
     * )
     * {realize p2n : umltordbms::PrimitiveToName;
     *  |
     * }
     * where ( |
     * prim.namespace = pprim.name = 'String'p2s.umlPackage = p)
     * { |
     * p2n = p2s;
     * p2n = prim;
     * p2n = prim.name + '2' + 'VARCHAR';
     * }
     * 
     * }
     */
    protected boolean stringToVarcharLM(final @NonNull /*@NonInvalid*/ Package p_2, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_5, final @NonNull /*@NonInvalid*/ PrimitiveDataType prim_1) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Package umlPackage = p2s_5.getUmlPackage();
            final /*@Thrown*/ boolean eq = p_2.equals(umlPackage);
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
            // creations
            final /*@Thrown*/ PrimitiveToName p2n = UmltordbmsFactory.eINSTANCE.createPrimitiveToName();
            assert p2n != null;
            modelObjects[2/*middle*/].add(p2n);
            // assignments
            p2n.setOwner(p2s_5);
            p2n.setPrimitive(prim_1);
            OPPOSITE_OF_PrimitiveToName_primitive.put(prim_1, p2n);
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_VARCHAR);
            p2n.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map stringToVarcharMR in umlRdbms) {
     * middle (p2s : umltordbms::PackageToSchema;
     * p2n : umltordbms::PrimitiveToName;
     *  |
     * )
     * { |
     * }
     * rdbms ( |
     * )
     * { |
     * }
     * where ( |
     * p2n.owner = p2sp2n.name = 'String' + '2' + 'VARCHAR')
     * { |
     * }
     * 
     * }
     */
    protected boolean stringToVarcharMR(final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_1, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_6) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ String name = p2n_1.getName();
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(STR_String, STR_2);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, STR_VARCHAR);
            final /*@Thrown*/ boolean eq = sum_0.equals(name);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ PackageToSchema owner = p2n_1.getOwner();
            final /*@Thrown*/ boolean eq_0 = p2s_6.equals(owner);
            if (!eq_0) {
                return false;
            }
            // creations
            // assignments
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableLM in umlRdbms) {
     * uml (p : simpleuml::Package;
     * c : simpleuml::Class;
     *  |
     * )
     * { |
     * }
     * middle (p2s : umltordbms::PackageToSchema;
     *  |
     * )
     * {realize c2t : umltordbms::ClassToTable;
     *  |
     * }
     * where ( |
     * c.kind = 'persistent'c.namespace = pp2s.umlPackage =
     *   p)
     * { |
     * c2t = p2s;
     * c2t = c;
     * c2t = c.name;
     * }
     * for anAttribute : simpleuml::Attribute in c.attributes {
     * 
     *     map classPrimitiveAttributesLM {
     * c := c;
     * a := anAttribute;
     * fao := c2t;
     * }
     *     map classComplexAttributesLM {
     * c := c;
     * a := anAttribute;
     * fao := c2t;
     * }
     *     map complexAttributePrimitiveAttributesLM {
     * ca := anAttribute;
     * c := anAttribute.type;
     * }
     *     map complexAttributeComplexAttributesLM {
     * ca := anAttribute;
     * c := anAttribute.type;
     * }}
     * }
     */
    protected boolean classToTableLM(final @NonNull /*@NonInvalid*/ Class c, final @NonNull /*@NonInvalid*/ Package p_3, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_7) {
        try {
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
            final @Nullable /*@Thrown*/ Package umlPackage = p2s_7.getUmlPackage();
            final /*@Thrown*/ boolean eq_1 = p_3.equals(umlPackage);
            if (!eq_1) {
                return false;
            }
            // creations
            final /*@Thrown*/ ClassToTable c2t = UmltordbmsFactory.eINSTANCE.createClassToTable();
            assert c2t != null;
            modelObjects[2/*middle*/].add(c2t);
            // assignments
            c2t.setOwner(p2s_7);
            c2t.setUmlClass(c);
            OPPOSITE_OF_ClassToTable_umlClass.put(c, c2t);
            final @Nullable /*@Thrown*/ String name = c.getName();
            c2t.setName(name);
            // mapping statements
            final @Nullable /*@Thrown*/ List<Attribute> attributes = c.getAttributes();
            assert attributes != null;
            ;
            for (Attribute anAttribute : attributes) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_6 = (Attribute)anAttribute;
                final @Nullable /*@Thrown*/ Classifier type_0 = symbol_6.getType();
                if (type_0 == null) {
                    throw new InvalidValueException("Null binding for \'complexAttributeComplexAttributesLM::c\'");
                }
                classPrimitiveAttributesLM(symbol_6, c, c2t);
                classComplexAttributesLM(symbol_6, c, c2t);
                if (type_0 instanceof Class) {
                    complexAttributePrimitiveAttributesLM((Class)type_0, symbol_6);
                }
                if (type_0 instanceof Class) {
                    complexAttributeComplexAttributesLM((Class)type_0, symbol_6);
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableMR in umlRdbms) {
     * middle (p2s : umltordbms::PackageToSchema;
     * c2t : umltordbms::ClassToTable;
     *  |
     * )
     * { |
     * }
     * rdbms (s : simplerdbms::Schema;
     *  |
     * )
     * {realize t : simplerdbms::Table;
     *  |
     * }
     * where ( |
     * c2t.owner =
     *   p2s)
     * { |
     * t = 'base';
     * t = s;
     * }
     * map classToTableMR_1 {
     * c2t_1 := c2t;
     * t_1 := t;
     * }
     *   map classToTableMR_2 {
     * t_2 := t;
     * c2t_2 := c2t;
     * }
     *   for child : umltordbms::AssociationToForeignKey in c2t.associationsToForeignKeys {
     * 
     *     map associationToForeignKeyMR {
     * p2s := p2s;
     * dt := t;
     * sc2t := t.ClassToTable;
     * dc2t := t.ClassToTable;
     * a2f := child;
     * s := s;
     * st := t;
     * rk := c2t.primaryKey;
     * }}
     *   for child : umltordbms::FromAttribute in c2t.fromAttributes->union(
     *     c2t.fromAttributes->selectByKind(umltordbms::NonLeafAttribute).fromAttributes)
     *    {
     * map attributeColumnsMR {
     * c2t := c2t;
     * a2c := child;
     * t := t;
     * }}
     * }
     */
    protected boolean classToTableMR(final @NonNull /*@NonInvalid*/ ClassToTable c2t, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_8, final @NonNull /*@NonInvalid*/ Schema s) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ PackageToSchema owner = c2t.getOwner();
            final /*@Thrown*/ boolean eq = p2s_8.equals(owner);
            if (!eq) {
                return false;
            }
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainClass TYP_umltordbms_c_c_NonLeafAttribute_0 = idResolver.getClass(CLSSid_NonLeafAttribute, null);
            final @Nullable /*@Thrown*/ List<FromAttribute> fromAttributes = c2t.getFromAttributes();
            assert fromAttributes != null;
            final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
            // creations
            final /*@Thrown*/ Table t = SimplerdbmsFactory.eINSTANCE.createTable();
            assert t != null;
            modelObjects[1/*rdbms*/].add(t);
            // assignments
            t.setKind(STR_base);
            t.setSchema(s);
            // mapping statements
            classToTableMR_1(c2t, t);
            classToTableMR_2(c2t, t);
            final @Nullable /*@Thrown*/ List<AssociationToForeignKey> associationsToForeignKeys = c2t.getAssociationsToForeignKeys();
            assert associationsToForeignKeys != null;
            ;
            for (AssociationToForeignKey child : associationsToForeignKeys) {
                final @Nullable /*@Thrown*/ ClassToTable ClassToTable_0 = DomainUtil.nonNullState (OPPOSITE_OF_ClassToTable_table.get(t));
                if (ClassToTable_0 == null) {
                    throw new InvalidValueException("Null binding for \'associationToForeignKeyMR::sc2t\'");
                }
                final @NonNull /*@NonInvalid*/ AssociationToForeignKey symbol_5 = (AssociationToForeignKey)child;
                final @Nullable /*@Thrown*/ Key primaryKey = c2t.getPrimaryKey();
                if (primaryKey == null) {
                    throw new InvalidValueException("Null binding for \'associationToForeignKeyMR::rk\'");
                }
                associationToForeignKeyMR(symbol_5, ClassToTable_0, t, p2s_8, primaryKey, s, ClassToTable_0, t);
            }
            final @NonNull /*@Thrown*/ SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_fromAttributes, TYP_umltordbms_c_c_NonLeafAttribute_0);
            @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_FromAttribute);
            @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
            @NonNull /*@Thrown*/ BagValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ NonLeafAttribute _1 = (NonLeafAttribute)ITERATOR__1.next();
                /**
                 * fromAttributes
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'umltordbms::FromAttributeOwner::fromAttributes\'");
                }
                final @Nullable /*@Thrown*/ List<FromAttribute> fromAttributes_1 = _1.getFromAttributes();
                assert fromAttributes_1 != null;
                final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes_1 = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes_1);
                //
                for (Object value : BOXED_fromAttributes_1.flatten().getElements()) {
                    accumulator.add(value);
                }
            }
            final @NonNull /*@Thrown*/ BagValue union = (BagValue)CollectionUnionOperation.INSTANCE.evaluate(BOXED_fromAttributes, collect);
            final List<FromAttribute> UNBOXED_union = union.asEcoreObjects(idResolver, FromAttribute.class);
            assert UNBOXED_union != null;
            ;
            for (FromAttribute child_0 : UNBOXED_union) {
                final @NonNull /*@NonInvalid*/ FromAttribute symbol_9 = (FromAttribute)child_0;
                if (symbol_9 instanceof AttributeToColumn) {
                    attributeColumnsMR((AttributeToColumn)symbol_9, c2t, t);
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableMR_1 in umlRdbms) {
     * middle (c2t_1 : umltordbms::ClassToTable;
     *  |
     * )
     * { |
     * }
     * rdbms (t_1 : simplerdbms::Table;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * c2t_1 = t_1;
     * t_1 = c2t_1.name;
     * }
     * 
     * }
     */
    protected boolean classToTableMR_1(final @NonNull /*@NonInvalid*/ ClassToTable c2t_1, final @NonNull /*@NonInvalid*/ Table t_1) {
        try {
            // predicates
            // creations
            // assignments
            c2t_1.setTable(t_1);
            OPPOSITE_OF_ClassToTable_table.put(t_1, c2t_1);
            final @Nullable /*@Thrown*/ String name = c2t_1.getName();
            t_1.setName(name);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableMR_2 in umlRdbms) {
     * 
     *   middle (c2t_2 : umltordbms::ClassToTable;
     *  |
     * )
     * { |
     * }
     * rdbms (t_2 : simplerdbms::Table;
     *  |
     * )
     * {realize pk : simplerdbms::Key;
     * realize pc : simplerdbms::Column;
     *  |
     * }
     * where ( |
     * )
     * { |
     * pk = t_2;
     * pk = 'primary';
     * pc = t_2;
     * pc = OrderedSet{pk
     *   }
     *   ;
     * pc = 'NUMBER';
     * }
     * map classToTableMR_2_1 {
     * c2t_2_1 := c2t_2;
     * pk_2_1 := pk;
     * pc_2_1 := pc;
     * }
     *   map classToTableMR_2_2 {
     * pk_2_2 := pk;
     * pc_2_2 := pc;
     * t_2_2 := t_2;
     * }
     * }
     */
    protected boolean classToTableMR_2(final @NonNull /*@NonInvalid*/ ClassToTable c2t_2, final @NonNull /*@NonInvalid*/ Table t_2) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            final /*@Thrown*/ Column pc = SimplerdbmsFactory.eINSTANCE.createColumn();
            assert pc != null;
            modelObjects[1/*rdbms*/].add(pc);
            final /*@Thrown*/ Key pk = SimplerdbmsFactory.eINSTANCE.createKey();
            assert pk != null;
            modelObjects[1/*rdbms*/].add(pk);
            // assignments
            pk.setOwner(t_2);
            pk.setKind(STR_primary);
            pc.setOwner(t_2);
            final @NonNull /*@Thrown*/ OrderedSetValue OrderedSet = ValuesUtil.createOrderedSetOfEach(ORD_CLSSid_Key, pk);
            final List<Key> UNBOXED_OrderedSet = OrderedSet.asEcoreObjects(idResolver, Key.class);
            assert UNBOXED_OrderedSet != null;
            pc.getKey().addAll(UNBOXED_OrderedSet);
            pc.setType(STR_NUMBER);
            // mapping statements
            classToTableMR_2_1(c2t_2, pc, pk);
            classToTableMR_2_2(pc, pk, t_2);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableMR_2_1 in umlRdbms) {
     * middle (c2t_2_1 : umltordbms::ClassToTable;
     *  |
     * )
     * { |
     * }
     * rdbms (pk_2_1 : simplerdbms::Key;
     * pc_2_1 : simplerdbms::Column;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * c2t_2_1 = pk_2_1;
     * c2t_2_1 = pc_2_1;
     * }
     * 
     * }
     */
    protected boolean classToTableMR_2_1(final @NonNull /*@NonInvalid*/ ClassToTable c2t_2_1, final @NonNull /*@NonInvalid*/ Column pc_2_1, final @NonNull /*@NonInvalid*/ Key pk_2_1) {
        try {
            // predicates
            // creations
            // assignments
            c2t_2_1.setPrimaryKey(pk_2_1);
            c2t_2_1.setColumn(pc_2_1);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classToTableMR_2_2 in umlRdbms) {
     * middle ( |
     * )
     * { |
     * }
     * rdbms (pk_2_2 : simplerdbms::Key;
     * pc_2_2 : simplerdbms::Column;
     * t_2_2 : simplerdbms::Table;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * pc_2_2 = t_2_2.name + '_tid';
     * pk_2_2 = t_2_2.name + '_pk';
     * }
     * 
     * }
     */
    protected boolean classToTableMR_2_2(final @NonNull /*@NonInvalid*/ Column pc_2_2, final @NonNull /*@NonInvalid*/ Key pk_2_2, final @NonNull /*@NonInvalid*/ Table t_2_2) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ String name_0 = t_2_2.getName();
            // creations
            // assignments
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR__tid);
            pc_2_2.setName(sum);
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(name_0, STR__pk);
            pk_2_2.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map associationToForeignKeyLM in umlRdbms) {
     * uml (p : simpleuml::Package;
     * sc : simpleuml::Class;
     * dc : simpleuml::Class;
     * a : simpleuml::Association;
     *  |
     * )
     * { |
     * }
     * middle (p2s : umltordbms::PackageToSchema;
     * sc2t : umltordbms::ClassToTable;
     * dc2t : umltordbms::ClassToTable;
     *  |
     * )
     * {realize a2f : umltordbms::AssociationToForeignKey;
     *  |
     * }
     * where ( |
     * a.namespace = psc.namespace = pp2s.umlPackage =
     *   p)
     * { |
     * sc2t = p2s;
     * a2f = sc2t;
     * a2f = dc2t;
     * a2f = a;
     * a2f = if a.destination = dc and a.source = sc
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
     *   endif;
     * }
     * 
     * }
     */
    protected boolean associationToForeignKeyLM(final @NonNull /*@NonInvalid*/ Association a, final @NonNull /*@NonInvalid*/ Package p_4, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_9) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Class destination = a.getDestination();
            final @Nullable /*@Thrown*/ Class dc = destination;
            final @Nullable /*@Thrown*/ Package namespace = a.getNamespace();
            final /*@Thrown*/ boolean eq = p_4.equals(namespace);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ Package umlPackage = p2s_9.getUmlPackage();
            final /*@Thrown*/ boolean eq_0 = p_4.equals(umlPackage);
            if (!eq_0) {
                return false;
            }
            final @Nullable /*@Thrown*/ Class source = a.getSource();
            final @Nullable /*@Thrown*/ Class sc = source;
            if (dc == null) {
                throw new InvalidValueException("Null source for \'umltordbms::ClassToTable::umlClass\'");
            }
            if (dc instanceof InvalidValueException) {
                throw (InvalidValueException)dc;
            }
            final @Nullable /*@Thrown*/ ClassToTable ClassToTable = DomainUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(dc));
            final @Nullable /*@Thrown*/ ClassToTable dc2t_0 = ClassToTable;
            if (sc == null) {
                throw new InvalidValueException("Null source for \'umltordbms::ClassToTable::umlClass\'");
            }
            if (sc instanceof InvalidValueException) {
                throw (InvalidValueException)sc;
            }
            final @Nullable /*@Thrown*/ Package namespace_0 = sc.getNamespace();
            final /*@Thrown*/ boolean eq_1 = p_4.equals(namespace_0);
            if (!eq_1) {
                return false;
            }
            final @Nullable /*@Thrown*/ ClassToTable ClassToTable_0 = DomainUtil.nonNullState (OPPOSITE_OF_ClassToTable_umlClass.get(sc));
            final @Nullable /*@Thrown*/ ClassToTable sc2t_0 = ClassToTable_0;
            final @Nullable /*@Thrown*/ String name = a.getName();
            @NonNull /*@Caught*/ Object CAUGHT_self_0;
            try {
                if (dc instanceof InvalidValueException) {
                    throw (InvalidValueException)dc;
                }
                final /*@Thrown*/ boolean self_0 = (destination != null) ? destination.equals(dc) : (dc == null);
                CAUGHT_self_0 = self_0;
            }
            catch (Exception e) {
                CAUGHT_self_0 = ValuesUtil.createInvalidValue(e);
            }
            @NonNull /*@Caught*/ Object CAUGHT_b;
            try {
                if (sc instanceof InvalidValueException) {
                    throw (InvalidValueException)sc;
                }
                final /*@Thrown*/ boolean b = (source != null) ? source.equals(sc) : (sc == null);
                CAUGHT_b = b;
            }
            catch (Exception e) {
                CAUGHT_b = ValuesUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ boolean symbol_4 = CAUGHT_self_0 instanceof InvalidValueException;
            /*@Thrown*/ boolean symbol_12;
            if (symbol_4) {
                final /*@NonInvalid*/ boolean symbol_5 = CAUGHT_b instanceof InvalidValueException;
                /*@Thrown*/ boolean symbol_7;
                if (symbol_5) {
                    if (CAUGHT_self_0 instanceof InvalidValueException) {
                        throw (InvalidValueException)CAUGHT_self_0;
                    }
                    symbol_7 = (Boolean)CAUGHT_self_0;
                }
                else {
                    if (CAUGHT_b instanceof InvalidValueException) {
                        throw (InvalidValueException)CAUGHT_b;
                    }
                    final /*@Thrown*/ boolean eq_2 = CAUGHT_b == Boolean.FALSE;
                    /*@Thrown*/ boolean symbol_6;
                    if (eq_2) {
                        symbol_6 = ValuesUtil.FALSE_VALUE;
                    }
                    else {
                        if (CAUGHT_self_0 instanceof InvalidValueException) {
                            throw (InvalidValueException)CAUGHT_self_0;
                        }
                        symbol_6 = (Boolean)CAUGHT_self_0;
                    }
                    symbol_7 = symbol_6;
                }
                symbol_12 = symbol_7;
            }
            else {
                if (CAUGHT_self_0 instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_self_0;
                }
                final /*@Thrown*/ boolean eq_3 = CAUGHT_self_0 == Boolean.FALSE;
                /*@Thrown*/ boolean symbol_11;
                if (eq_3) {
                    symbol_11 = ValuesUtil.FALSE_VALUE;
                }
                else {
                    if (CAUGHT_b instanceof InvalidValueException) {
                        throw (InvalidValueException)CAUGHT_b;
                    }
                    final /*@NonInvalid*/ boolean symbol_8 = CAUGHT_b instanceof InvalidValueException;
                    /*@Thrown*/ boolean symbol_10;
                    if (symbol_8) {
                        symbol_10 = (Boolean)CAUGHT_b;
                    }
                    else {
                        final /*@Thrown*/ boolean eq_4 = CAUGHT_b == Boolean.FALSE;
                        /*@NonInvalid*/ boolean symbol_9;
                        if (eq_4) {
                            symbol_9 = ValuesUtil.FALSE_VALUE;
                        }
                        else {
                            symbol_9 = ValuesUtil.TRUE_VALUE;
                        }
                        symbol_10 = symbol_9;
                    }
                    symbol_11 = symbol_10;
                }
                symbol_12 = symbol_11;
            }
            // creations
            final /*@Thrown*/ AssociationToForeignKey a2f = UmltordbmsFactory.eINSTANCE.createAssociationToForeignKey();
            assert a2f != null;
            modelObjects[2/*middle*/].add(a2f);
            // assignments
            sc2t_0.setOwner(p2s_9);
            a2f.setOwner(sc2t_0);
            a2f.setReferenced(dc2t_0);
            a2f.setAssociation(a);
            @Nullable /*@Thrown*/ String symbol_33;
            if (symbol_12) {
                symbol_33 = name;
            }
            else {
                @NonNull /*@Thrown*/ String symbol_32;
                if (symbol_12) {
                    final @Nullable /*@Thrown*/ String name_0 = dc.getName();
                    final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name_0, STR__);
                    final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name);
                    symbol_32 = sum_0;
                }
                else {
                    final @Nullable /*@Thrown*/ String name_6 = sc.getName();
                    @NonNull /*@Thrown*/ String symbol_31;
                    if (symbol_12) {
                        final @NonNull /*@Thrown*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(name, STR__);
                        final @NonNull /*@Thrown*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, name_6);
                        symbol_31 = sum_2;
                    }
                    else {
                        final @Nullable /*@Thrown*/ String name_4 = dc.getName();
                        final @NonNull /*@Thrown*/ String sum_3 = StringConcatOperation.INSTANCE.evaluate(name_4, STR__);
                        final @NonNull /*@Thrown*/ String sum_4 = StringConcatOperation.INSTANCE.evaluate(sum_3, name);
                        final @NonNull /*@Thrown*/ String sum_5 = StringConcatOperation.INSTANCE.evaluate(sum_4, STR__);
                        final @NonNull /*@Thrown*/ String sum_6 = StringConcatOperation.INSTANCE.evaluate(sum_5, name_6);
                        symbol_31 = sum_6;
                    }
                    symbol_32 = symbol_31;
                }
                symbol_33 = symbol_32;
            }
            a2f.setName(symbol_33);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map associationToForeignKeyMR in umlRdbms) {
     * middle (p2s : umltordbms::PackageToSchema;
     * sc2t : umltordbms::ClassToTable;
     * dc2t : umltordbms::ClassToTable;
     * a2f : umltordbms::AssociationToForeignKey;
     *  |
     * )
     * { |
     * }
     * rdbms (s : simplerdbms::Schema;
     * st : simplerdbms::Table;
     * dt : simplerdbms::Table;
     * rk : simplerdbms::Key;
     *  |
     * )
     * {realize fk : simplerdbms::ForeignKey;
     * realize fc : simplerdbms::Column;
     *  |
     * }
     * where ( |
     * a2f.owner = sc2ta2f.referenced = dc2tp2s.schema = sst.schema = s)
     * { |
     * fk = a2f.name;
     * fc = a2f.name +
     *   '_tid';
     * fk = st;
     * fc = st;
     * }
     * map associationToForeignKeyMR_1 {
     * fk := fk;
     * fc := fc;
     * dt := a2f.referenced.table;
     * rk := rk;
     * }
     *   map associationToForeignKeyMR_2 {
     * a2f_1 := a2f;
     * fk_1 := fk;
     * fc_1 := fc;
     * }
     * }
     */
    protected boolean associationToForeignKeyMR(final @NonNull /*@NonInvalid*/ AssociationToForeignKey a2f, final @NonNull /*@NonInvalid*/ ClassToTable dc2t, final @NonNull /*@NonInvalid*/ Table dt, final @NonNull /*@NonInvalid*/ PackageToSchema p2s_10, final @NonNull /*@NonInvalid*/ Key rk, final @NonNull /*@NonInvalid*/ Schema s_0, final @NonNull /*@NonInvalid*/ ClassToTable sc2t, final @NonNull /*@NonInvalid*/ Table st) {
        try {
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
            final @Nullable /*@Thrown*/ Schema schema = p2s_10.getSchema();
            final /*@Thrown*/ boolean eq_1 = s_0.equals(schema);
            if (!eq_1) {
                return false;
            }
            final @Nullable /*@Thrown*/ Schema schema_0 = st.getSchema();
            final /*@Thrown*/ boolean eq_2 = s_0.equals(schema_0);
            if (!eq_2) {
                return false;
            }
            final @Nullable /*@Thrown*/ String name = a2f.getName();
            // creations
            final /*@Thrown*/ Column fc = SimplerdbmsFactory.eINSTANCE.createColumn();
            assert fc != null;
            modelObjects[1/*rdbms*/].add(fc);
            final /*@Thrown*/ ForeignKey fk = SimplerdbmsFactory.eINSTANCE.createForeignKey();
            assert fk != null;
            modelObjects[1/*rdbms*/].add(fk);
            // assignments
            fk.setName(name);
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__tid);
            fc.setName(sum);
            fk.setOwner(st);
            fc.setOwner(st);
            // mapping statements
            if (referenced == null) {
                throw new InvalidValueException("Null source for \'umltordbms::ClassToTable::table\'");
            }
            final @Nullable /*@Thrown*/ Table table = referenced.getTable();
            if (table == null) {
                throw new InvalidValueException("Null binding for \'associationToForeignKeyMR_1::dt\'");
            }
            associationToForeignKeyMR_1(table, fc, fk, rk);
            associationToForeignKeyMR_2(a2f, fc, fk);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map associationToForeignKeyMR_1 in umlRdbms) {
     * 
     *   middle ( |
     * )
     * { |
     * }
     * rdbms (fk : simplerdbms::ForeignKey;
     * fc : simplerdbms::Column;
     * dt : simplerdbms::Table;
     * rk : simplerdbms::Key;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * fk = rk;
     * fc = OrderedSet{fk
     *   }
     *   ;
     * fc = rk.column->first().type;
     * }
     * 
     * }
     */
    protected boolean associationToForeignKeyMR_1(final @NonNull /*@NonInvalid*/ Table dt_0, final @NonNull /*@NonInvalid*/ Column fc, final @NonNull /*@NonInvalid*/ ForeignKey fk, final @NonNull /*@NonInvalid*/ Key rk_0) {
        try {
            // predicates
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            // assignments
            fk.setRefersTo(rk_0);
            final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet = ValuesUtil.createOrderedSetOfEach(ORD_CLSSid_ForeignKey, fk);
            final List<ForeignKey> UNBOXED_OrderedSet = OrderedSet.asEcoreObjects(idResolver, ForeignKey.class);
            assert UNBOXED_OrderedSet != null;
            fc.getForeignKeys().addAll(UNBOXED_OrderedSet);
            final @Nullable /*@Thrown*/ List<Column> column = rk_0.getColumn();
            assert column != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_column = idResolver.createOrderedSetOfAll(ORD_CLSSid_Column, column);
            final @Nullable /*@Thrown*/ Column first = (Column)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_column);
            if (first == null) {
                throw new InvalidValueException("Null source for \'simplerdbms::Column::type\'");
            }
            final @Nullable /*@Thrown*/ String type = first.getType();
            fc.setType(type);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map associationToForeignKeyMR_2 in umlRdbms) {
     * middle (a2f_1 : umltordbms::AssociationToForeignKey;
     *  |
     * )
     * { |
     * }
     * rdbms (fk_1 : simplerdbms::ForeignKey;
     * fc_1 : simplerdbms::Column;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * a2f_1 = fk_1;
     * a2f_1 = fc_1;
     * }
     * 
     * }
     */
    protected boolean associationToForeignKeyMR_2(final @NonNull /*@NonInvalid*/ AssociationToForeignKey a2f_1, final @NonNull /*@NonInvalid*/ Column fc_1, final @NonNull /*@NonInvalid*/ ForeignKey fk_1) {
        try {
            // predicates
            // creations
            // assignments
            a2f_1.setForeignKey(fk_1);
            a2f_1.setColumn(fc_1);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classPrimitiveAttributesLM in umlRdbms) {
     * uml (c : simpleuml::Class;
     * t : simpleuml::PrimitiveDataType;
     * a : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao : umltordbms::ClassToTable;
     * p2n : umltordbms::PrimitiveToName;
     *  |
     * )
     * {realize atc : umltordbms::AttributeToColumn;
     *  |
     * }
     * where ( |
     * a.owner = cfao.umlClass =
     *   c)
     * { |
     * atc = a;
     * atc = fao;
     * atc = p2n;
     * atc = a.kind;
     * atc = a.name;
     * atc = Set{atc
     *   };
     * }
     * 
     * }
     */
    protected boolean classPrimitiveAttributesLM(final @NonNull /*@NonInvalid*/ Attribute a_0, final @NonNull /*@NonInvalid*/ Class c_0, final @NonNull /*@NonInvalid*/ ClassToTable fao) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Class owner = a_0.getOwner();
            final /*@Thrown*/ boolean eq = c_0.equals(owner);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ Class umlClass = fao.getUmlClass();
            final /*@Thrown*/ boolean eq_0 = c_0.equals(umlClass);
            if (!eq_0) {
                return false;
            }
            final @Nullable /*@Thrown*/ Classifier type = a_0.getType();
            if (!(type instanceof PrimitiveDataType)) {
                return false;
            }
            final @Nullable /*@Thrown*/ PrimitiveDataType t_0 = (PrimitiveDataType)type;
            if (t_0 == null) {
                throw new InvalidValueException("Null source for \'umltordbms::PrimitiveToName::primitive\'");
            }
            final @NonNull /*@Thrown*/ PrimitiveToName PrimitiveToName = DomainUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(t_0));
            final @Nullable /*@Thrown*/ PrimitiveToName p2n_3 = PrimitiveToName;
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            final /*@Thrown*/ AttributeToColumn atc = UmltordbmsFactory.eINSTANCE.createAttributeToColumn();
            assert atc != null;
            modelObjects[2/*middle*/].add(atc);
            // assignments
            atc.setAttribute(a_0);
            OPPOSITE_OF_FromAttribute_attribute.put(a_0, atc);
            atc.setOwner(fao);
            atc.setType(p2n_3);
            final @Nullable /*@Thrown*/ String kind = a_0.getKind();
            atc.setKind(kind);
            final @Nullable /*@Thrown*/ String name = a_0.getName();
            atc.setName(name);
            final @NonNull /*@Thrown*/ SetValue Set = ValuesUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, atc);
            final List<AttributeToColumn> UNBOXED_Set = Set.asEcoreObjects(idResolver, AttributeToColumn.class);
            assert UNBOXED_Set != null;
            atc.getLeafs().addAll(UNBOXED_Set);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map classComplexAttributesLM in umlRdbms) {
     * uml (c : simpleuml::Class;
     * t : simpleuml::Class;
     * a : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao : umltordbms::ClassToTable;
     *  |
     * )
     * {realize fa : umltordbms::NonLeafAttribute;
     *  |
     * }
     * where ( |
     * a.owner = cfao.umlClass =
     *   c)
     * { |
     * fa = a;
     * fa = fao;
     * fa = a.kind;
     * fa = a.name;
     * fa = fao.fromAttributes.leafs->asSet();
     * }
     * 
     * }
     */
    protected boolean classComplexAttributesLM(final @NonNull /*@NonInvalid*/ Attribute a_1, final @NonNull /*@NonInvalid*/ Class c_1, final @NonNull /*@NonInvalid*/ ClassToTable fao_0) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Class owner = a_1.getOwner();
            final /*@Thrown*/ boolean eq = c_1.equals(owner);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ Class umlClass = fao_0.getUmlClass();
            final /*@Thrown*/ boolean eq_0 = c_1.equals(umlClass);
            if (!eq_0) {
                return false;
            }
            final @Nullable /*@Thrown*/ Classifier type = a_1.getType();
            if (!(type instanceof Class)) {
                return false;
            }
            final @Nullable /*@Thrown*/ Class t_0 = (Class)type;
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            final /*@Thrown*/ NonLeafAttribute fa = UmltordbmsFactory.eINSTANCE.createNonLeafAttribute();
            assert fa != null;
            modelObjects[2/*middle*/].add(fa);
            // assignments
            fa.setAttribute(a_1);
            OPPOSITE_OF_FromAttribute_attribute.put(a_1, fa);
            fa.setOwner(fao_0);
            final @Nullable /*@Thrown*/ String kind = a_1.getKind();
            fa.setKind(kind);
            final @Nullable /*@Thrown*/ String name = a_1.getName();
            fa.setName(name);
            final @Nullable /*@Thrown*/ List<FromAttribute> fromAttributes = fao_0.getFromAttributes();
            assert fromAttributes != null;
            final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
            @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
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
                    throw new InvalidValueException("Null source for \'umltordbms::FromAttribute::leafs\'");
                }
                final @Nullable /*@Thrown*/ List<AttributeToColumn> leafs = _1.getLeafs();
                assert leafs != null;
                final @NonNull /*@Thrown*/ SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
                //
                for (Object value : BOXED_leafs.flatten().getElements()) {
                    accumulator.add(value);
                }
            }
            final @NonNull /*@Thrown*/ SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
            final List<AttributeToColumn> UNBOXED_asSet = asSet.asEcoreObjects(idResolver, AttributeToColumn.class);
            assert UNBOXED_asSet != null;
            fa.getLeafs().addAll(UNBOXED_asSet);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map complexAttributePrimitiveAttributesLM in umlRdbms) {
     * uml (c : simpleuml::Class;
     * ca : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao : umltordbms::NonLeafAttribute;
     *  |
     * )
     * { |
     * }
     * where ( |
     * ca.type =
     *   c)
     * { |
     * }
     * for anAttribute : simpleuml::Attribute in c.attributes {
     * 
     *     map complexAttributePrimitiveAttributesLM_1 {
     * c_1 := c;
     * ca_1 := ca;
     * fao_1 := fao;
     * a_1 := anAttribute;
     * }}
     * }
     */
    protected boolean complexAttributePrimitiveAttributesLM(final @NonNull /*@NonInvalid*/ Class c_2, final @NonNull /*@NonInvalid*/ Attribute ca) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ FromAttribute FromAttribute = DomainUtil.nonNullState (OPPOSITE_OF_FromAttribute_attribute.get(ca));
            if (!(FromAttribute instanceof NonLeafAttribute)) {
                return false;
            }
            final @Nullable /*@Thrown*/ NonLeafAttribute fao_2 = (NonLeafAttribute)FromAttribute;
            final @Nullable /*@Thrown*/ Classifier type = ca.getType();
            final /*@Thrown*/ boolean eq = c_2.equals(type);
            if (!eq) {
                return false;
            }
            // creations
            // assignments
            // mapping statements
            final @Nullable /*@Thrown*/ List<Attribute> attributes = c_2.getAttributes();
            assert attributes != null;
            ;
            for (Attribute anAttribute : attributes) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_1 = (Attribute)anAttribute;
                if (fao_2 == null) {
                    throw new InvalidValueException("Null binding for \'complexAttributePrimitiveAttributesLM_1::fao_1\'");
                }
                complexAttributePrimitiveAttributesLM_1(symbol_1, c_2, ca, fao_2);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map complexAttributePrimitiveAttributesLM_1 in umlRdbms) {
     * 
     *   uml (c_1 : simpleuml::Class;
     * t_1 : simpleuml::PrimitiveDataType;
     * a_1 : simpleuml::Attribute;
     * ca_1 : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao_1 : umltordbms::NonLeafAttribute;
     * p2n_1 : umltordbms::PrimitiveToName;
     *  |
     * )
     * {realize fa : umltordbms::AttributeToColumn;
     *  |
     * }
     * where ( |
     * )
     * { |
     * fa = fao_1;
     * fa = Set{fa
     *   };
     * fa = a_1;
     * fa = p2n_1;
     * fa = a_1.kind;
     * fa = ca_1.name + '_' + a_1.name;
     * }
     * 
     * }
     */
    protected boolean complexAttributePrimitiveAttributesLM_1(final @NonNull /*@NonInvalid*/ Attribute a_1_0, final @NonNull /*@NonInvalid*/ Class c_1_0, final @NonNull /*@NonInvalid*/ Attribute ca_1, final @NonNull /*@NonInvalid*/ NonLeafAttribute fao_1) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Classifier type = a_1_0.getType();
            if (!(type instanceof PrimitiveDataType)) {
                return false;
            }
            final @Nullable /*@Thrown*/ PrimitiveDataType t_1_0 = (PrimitiveDataType)type;
            if (t_1_0 == null) {
                throw new InvalidValueException("Null source for \'umltordbms::PrimitiveToName::primitive\'");
            }
            final @NonNull /*@Thrown*/ PrimitiveToName PrimitiveToName = DomainUtil.nonNullState (OPPOSITE_OF_PrimitiveToName_primitive.get(t_1_0));
            final @Nullable /*@Thrown*/ PrimitiveToName p2n_1_0 = PrimitiveToName;
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            final /*@Thrown*/ AttributeToColumn fa = UmltordbmsFactory.eINSTANCE.createAttributeToColumn();
            assert fa != null;
            modelObjects[2/*middle*/].add(fa);
            // assignments
            fa.setOwner(fao_1);
            final @NonNull /*@Thrown*/ SetValue Set = ValuesUtil.createSetOfEach(SET_CLSSid_AttributeToColumn, fa);
            final List<AttributeToColumn> UNBOXED_Set = Set.asEcoreObjects(idResolver, AttributeToColumn.class);
            assert UNBOXED_Set != null;
            fa.getLeafs().addAll(UNBOXED_Set);
            fa.setAttribute(a_1_0);
            OPPOSITE_OF_FromAttribute_attribute.put(a_1_0, fa);
            fa.setType(p2n_1_0);
            final @Nullable /*@Thrown*/ String kind = a_1_0.getKind();
            fa.setKind(kind);
            final @Nullable /*@Thrown*/ String name = ca_1.getName();
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
            final @Nullable /*@Thrown*/ String name_0 = a_1_0.getName();
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
            fa.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map complexAttributeComplexAttributesLM in umlRdbms) {
     * uml (c : simpleuml::Class;
     * ca : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao : umltordbms::NonLeafAttribute;
     *  |
     * )
     * { |
     * }
     * where ( |
     * ca.type =
     *   c)
     * { |
     * }
     * for anAttribute : simpleuml::Attribute in c.attributes {
     * 
     *     map complexAttributeComplexAttributesLM_1 {
     * ca_1 := ca;
     * a_1 := anAttribute;
     * c_1 := c;
     * fao_1 := fao;
     * }}
     * }
     */
    protected boolean complexAttributeComplexAttributesLM(final @NonNull /*@NonInvalid*/ Class c_3, final @NonNull /*@NonInvalid*/ Attribute ca_0) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ FromAttribute FromAttribute = DomainUtil.nonNullState (OPPOSITE_OF_FromAttribute_attribute.get(ca_0));
            if (!(FromAttribute instanceof NonLeafAttribute)) {
                return false;
            }
            final @Nullable /*@Thrown*/ NonLeafAttribute fao_2 = (NonLeafAttribute)FromAttribute;
            final @Nullable /*@Thrown*/ Classifier type = ca_0.getType();
            final /*@Thrown*/ boolean eq = c_3.equals(type);
            if (!eq) {
                return false;
            }
            // creations
            // assignments
            // mapping statements
            final @Nullable /*@Thrown*/ List<Attribute> attributes = c_3.getAttributes();
            assert attributes != null;
            ;
            for (Attribute anAttribute : attributes) {
                final @NonNull /*@NonInvalid*/ Attribute symbol_1 = (Attribute)anAttribute;
                if (fao_2 == null) {
                    throw new InvalidValueException("Null binding for \'complexAttributeComplexAttributesLM_1::fao_1\'");
                }
                complexAttributeComplexAttributesLM_1(symbol_1, c_3, ca_0, fao_2);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map complexAttributeComplexAttributesLM_1 in umlRdbms) {
     * uml (c_1 : simpleuml::Class;
     * ca_1 : simpleuml::Attribute;
     * t_1 : simpleuml::Class;
     * a_1 : simpleuml::Attribute;
     *  |
     * )
     * { |
     * }
     * middle (fao_1 : umltordbms::NonLeafAttribute;
     *  |
     * )
     * {realize fa : umltordbms::NonLeafAttribute;
     *  |
     * }
     * where ( |
     * a_1.owner =
     *   c_1)
     * { |
     * fa = fao_1;
     * fa = fao_1.fromAttributes.leafs->asSet();
     * fa = a_1;
     * fa = a_1.kind;
     * fa = ca_1.name + '_' + a_1.name;
     * }
     * 
     * }
     */
    protected boolean complexAttributeComplexAttributesLM_1(final @NonNull /*@NonInvalid*/ Attribute a_1_1, final @NonNull /*@NonInvalid*/ Class c_1_1, final @NonNull /*@NonInvalid*/ Attribute ca_1_0, final @NonNull /*@NonInvalid*/ NonLeafAttribute fao_1_0) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Class owner = a_1_1.getOwner();
            final /*@Thrown*/ boolean eq = c_1_1.equals(owner);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ Classifier type = a_1_1.getType();
            if (!(type instanceof Class)) {
                return false;
            }
            final @Nullable /*@Thrown*/ Class t_1_0 = (Class)type;
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            // creations
            final /*@Thrown*/ NonLeafAttribute fa = UmltordbmsFactory.eINSTANCE.createNonLeafAttribute();
            assert fa != null;
            modelObjects[2/*middle*/].add(fa);
            // assignments
            fa.setOwner(fao_1_0);
            final @Nullable /*@Thrown*/ List<FromAttribute> fromAttributes = fao_1_0.getFromAttributes();
            assert fromAttributes != null;
            final @NonNull /*@Thrown*/ SetValue BOXED_fromAttributes = idResolver.createSetOfAll(SET_CLSSid_FromAttribute, fromAttributes);
            @NonNull /*@Thrown*/ BagValue.Accumulator accumulator = ValuesUtil.createBagAccumulatorValue(BAG_CLSSid_AttributeToColumn);
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
                    throw new InvalidValueException("Null source for \'umltordbms::FromAttribute::leafs\'");
                }
                final @Nullable /*@Thrown*/ List<AttributeToColumn> leafs = _1.getLeafs();
                assert leafs != null;
                final @NonNull /*@Thrown*/ SetValue BOXED_leafs = idResolver.createSetOfAll(SET_CLSSid_AttributeToColumn, leafs);
                //
                for (Object value : BOXED_leafs.flatten().getElements()) {
                    accumulator.add(value);
                }
            }
            final @NonNull /*@Thrown*/ SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
            final List<AttributeToColumn> UNBOXED_asSet = asSet.asEcoreObjects(idResolver, AttributeToColumn.class);
            assert UNBOXED_asSet != null;
            fa.getLeafs().addAll(UNBOXED_asSet);
            fa.setAttribute(a_1_1);
            OPPOSITE_OF_FromAttribute_attribute.put(a_1_1, fa);
            final @Nullable /*@Thrown*/ String kind = a_1_1.getKind();
            fa.setKind(kind);
            final @Nullable /*@Thrown*/ String name = ca_1_0.getName();
            final @NonNull /*@Thrown*/ String sum = StringConcatOperation.INSTANCE.evaluate(name, STR__);
            final @Nullable /*@Thrown*/ String name_0 = a_1_1.getName();
            final @NonNull /*@Thrown*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
            fa.setName(sum_0);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map attributeColumnsMR in umlRdbms) {
     * middle (c2t : umltordbms::ClassToTable;
     * a2c : umltordbms::AttributeToColumn;
     * p2n : umltordbms::PrimitiveToName;
     *  |
     * )
     * { |
     * }
     * rdbms (t : simplerdbms::Table;
     * ct : String;
     *  |
     * )
     * {realize c : simplerdbms::Column;
     *  |
     * }
     * where ( |
     * c2t.table =
     *   t)
     * { |
     * c = t;
     * }
     * map attributeColumnsMR_1 {
     * a2c_1 := a2c;
     * c_1 := c;
     * }
     *   map attributeColumnsMR_2 {
     * a2c_2 := a2c;
     * c_2 := c;
     * p2n_2 := p2n;
     * ct_2 := ct;
     * }
     *   map attributeColumnsMR_3 {
     * c_3 := c;
     * a2c_3 := a2c;
     * }
     * }
     */
    protected boolean attributeColumnsMR(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c, final @NonNull /*@NonInvalid*/ ClassToTable c2t_0, final @NonNull /*@NonInvalid*/ Table t) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ Table table = c2t_0.getTable();
            final /*@Thrown*/ boolean eq = t.equals(table);
            if (!eq) {
                return false;
            }
            final @Nullable /*@Thrown*/ PrimitiveToName type = a2c.getType();
            final @Nullable /*@Thrown*/ PrimitiveToName p2n_3 = type;
            if (p2n_3 == null) {
                throw new InvalidValueException("Null source for \'umltordbms::PrimitiveToName::typeName\'");
            }
            final @Nullable /*@Thrown*/ String typeName = p2n_3.getTypeName();
            final @Nullable /*@Thrown*/ String ct = typeName;
            // creations
            final /*@Thrown*/ Column c = SimplerdbmsFactory.eINSTANCE.createColumn();
            assert c != null;
            modelObjects[1/*rdbms*/].add(c);
            // assignments
            c.setOwner(t);
            // mapping statements
            attributeColumnsMR_1(a2c, c);
            if (ct == null) {
                throw new InvalidValueException("Null binding for \'attributeColumnsMR_2::ct_2\'");
            }
            attributeColumnsMR_2(a2c, c, ct, p2n_3);
            attributeColumnsMR_3(a2c, c);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map attributeColumnsMR_1 in umlRdbms) {
     * middle (a2c_1 : umltordbms::AttributeToColumn;
     *  |
     * )
     * { |
     * }
     * rdbms (c_1 : simplerdbms::Column;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * a2c_1 = c_1;
     * }
     * 
     * }
     */
    protected boolean attributeColumnsMR_1(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_1, final @NonNull /*@NonInvalid*/ Column c_1_2) {
        try {
            // predicates
            // creations
            // assignments
            a2c_1.setColumn(c_1_2);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map attributeColumnsMR_2 in umlRdbms) {
     * middle (p2n_2 : umltordbms::PrimitiveToName;
     * a2c_2 : umltordbms::AttributeToColumn;
     *  |
     * )
     * { |
     * }
     * rdbms (c_2 : simplerdbms::Column;
     * ct_2 : String;
     *  |
     * )
     * { |
     * }
     * where ( |
     * a2c_2.type =
     *   p2n_2)
     * { |
     * c_2 = ct_2;
     * }
     * map attributeColumnsMR_2_1 {
     * p2n_2_1 := p2n_2;
     * ct_2_1 := ct_2;
     * }
     * }
     */
    protected boolean attributeColumnsMR_2(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_2, final @NonNull /*@NonInvalid*/ Column c_2_0, final @NonNull /*@NonInvalid*/ String ct_2, final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_2) {
        try {
            // predicates
            final @Nullable /*@Thrown*/ PrimitiveToName type = a2c_2.getType();
            final /*@Thrown*/ boolean eq = p2n_2.equals(type);
            if (!eq) {
                return false;
            }
            // creations
            // assignments
            c_2_0.setType(ct_2);
            // mapping statements
            attributeColumnsMR_2_1(ct_2, p2n_2);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map attributeColumnsMR_2_1 in umlRdbms) {
     * middle (p2n_2_1 : umltordbms::PrimitiveToName;
     *  |
     * )
     * { |
     * }
     * rdbms (ct_2_1 : String;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * p2n_2_1 = ct_2_1;
     * }
     * 
     * }
     */
    protected boolean attributeColumnsMR_2_1(final @NonNull /*@NonInvalid*/ String ct_2_1, final @NonNull /*@NonInvalid*/ PrimitiveToName p2n_2_1) {
        try {
            // predicates
            // creations
            // assignments
            p2n_2_1.setTypeName(ct_2_1);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * map attributeColumnsMR_3 in umlRdbms) {
     * middle (a2c_3 : umltordbms::AttributeToColumn;
     *  |
     * )
     * { |
     * }
     * rdbms (c_3 : simplerdbms::Column;
     *  |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * c_3 = a2c_3.name;
     * c_3 = a2c_3.kind;
     * }
     * 
     * }
     */
    protected boolean attributeColumnsMR_3(final @NonNull /*@NonInvalid*/ AttributeToColumn a2c_3, final @NonNull /*@NonInvalid*/ Column c_3_0) {
        try {
            // predicates
            // creations
            // assignments
            final @Nullable /*@Thrown*/ String name = a2c_3.getName();
            c_3_0.setName(name);
            final @Nullable /*@Thrown*/ String kind = a2c_3.getKind();
            c_3_0.setKind(kind);
            // mapping statements
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
