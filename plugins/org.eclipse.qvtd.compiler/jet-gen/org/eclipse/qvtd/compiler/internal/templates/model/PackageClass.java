package org.eclipse.qvtd.compiler.internal.templates.model;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;

public class PackageClass
{
  protected static String nl;
  public static synchronized PackageClass create(String lineSeparator)
  {
    nl = lineSeparator;
    PackageClass result = new PackageClass();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**";
  protected final String TEXT_3 = NL + " * ";
  protected final String TEXT_4 = NL + " */";
  protected final String TEXT_5 = NL + "package ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "package ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Package</b> for the model." + NL + " * It contains accessors for the meta objects to represent" + NL + " * <ul>" + NL + " *   <li>each class,</li>" + NL + " *   <li>each feature of each class,</li>";
  protected final String TEXT_11 = NL + " *   <li>each operation of each class,</li>";
  protected final String TEXT_12 = NL + " *   <li>each enum,</li>" + NL + " *   <li>and each data type</li>" + NL + " * </ul>" + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_13 = NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_14 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_15 = NL + " * @see ";
  protected final String TEXT_16 = NL + " * @model ";
  protected final String TEXT_17 = NL + " *        ";
  protected final String TEXT_18 = NL + " * @model";
  protected final String TEXT_19 = NL + " * @generated" + NL + " */";
  protected final String TEXT_20 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model <b>Package</b>." + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */";
  protected final String TEXT_21 = NL + "public class ";
  protected final String TEXT_22 = " extends ";
  protected final String TEXT_23 = " implements ";
  protected final String TEXT_24 = NL + "public interface ";
  protected final String TEXT_25 = " extends ";
  protected final String TEXT_26 = NL + "{";
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_28 = " copyright = ";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t/**" + NL + "\t * The package name." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_32 = " eNAME = \"";
  protected final String TEXT_33 = "\";";
  protected final String TEXT_34 = NL + NL + "\t/**" + NL + "\t * The package namespace URI." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_35 = " eNS_URI = \"";
  protected final String TEXT_36 = "\";";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * The package namespace name." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_38 = " eNS_PREFIX = \"";
  protected final String TEXT_39 = "\";";
  protected final String TEXT_40 = NL + NL + "\t/**" + NL + "\t * The package content type ID." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_41 = " eCONTENT_TYPE = \"";
  protected final String TEXT_42 = "\";";
  protected final String TEXT_43 = NL + NL + "\t/**" + NL + "\t * The singleton instance of the package." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_44 = " eINSTANCE = ";
  protected final String TEXT_45 = ".init();" + NL;
  protected final String TEXT_46 = NL + "\t/**";
  protected final String TEXT_47 = NL + "\t * The meta object id for the '{@link ";
  protected final String TEXT_48 = " <em>";
  protected final String TEXT_49 = "</em>}' class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see ";
  protected final String TEXT_50 = NL + "\t * The meta object id for the '{@link ";
  protected final String TEXT_51 = " <em>";
  protected final String TEXT_52 = "</em>}' class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see ";
  protected final String TEXT_53 = NL + "\t * The meta object id for the '{@link ";
  protected final String TEXT_54 = " <em>";
  protected final String TEXT_55 = "</em>}' enum." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see ";
  protected final String TEXT_56 = NL + "\t * The meta object id for the '<em>";
  protected final String TEXT_57 = "</em>' data type." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_58 = NL + "\t * @see ";
  protected final String TEXT_59 = NL + "\t * @see ";
  protected final String TEXT_60 = "#get";
  protected final String TEXT_61 = "()" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_62 = "int ";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL;
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t * The feature id for the '<em><b>";
  protected final String TEXT_66 = "</b></em>' ";
  protected final String TEXT_67 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t";
  protected final String TEXT_68 = "int ";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ";" + NL;
  protected final String TEXT_71 = NL + "\t/**" + NL + "\t * The number of structural features of the '<em>";
  protected final String TEXT_72 = "</em>' class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t";
  protected final String TEXT_73 = "int ";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ";" + NL;
  protected final String TEXT_76 = NL + "\t/**" + NL + "\t * The operation id for the '<em>";
  protected final String TEXT_77 = "</em>' operation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t";
  protected final String TEXT_78 = "int ";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = ";" + NL;
  protected final String TEXT_81 = NL + "\t/**" + NL + "\t * The number of operations of the '<em>";
  protected final String TEXT_82 = "</em>' class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t";
  protected final String TEXT_83 = "int ";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ";" + NL;
  protected final String TEXT_86 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String packageFilename = \"";
  protected final String TEXT_87 = "\";";
  protected final String TEXT_88 = NL;
  protected final String TEXT_89 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = " = null;" + NL;
  protected final String TEXT_92 = NL + "\t/**" + NL + "\t * Creates an instance of the model <b>Package</b>, registered with" + NL + "\t * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package" + NL + "\t * package URI value." + NL + "\t * <p>Note: the correct way to create the package is via the static" + NL + "\t * factory method {@link #init init()}, which also performs" + NL + "\t * initialization of the package, or returns the registered package," + NL + "\t * if one already exists." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see org.eclipse.emf.ecore.EPackage.Registry" + NL + "\t * @see ";
  protected final String TEXT_93 = "#eNS_URI" + NL + "\t * @see #init()" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_94 = "()" + NL + "\t{" + NL + "\t\tsuper(eNS_URI, ";
  protected final String TEXT_95 = ");" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isInited = false;" + NL + "" + NL + "\t/**" + NL + "\t * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends." + NL + "\t * " + NL + "\t * <p>This method is used to initialize {@link ";
  protected final String TEXT_96 = "#eINSTANCE} when that field is accessed." + NL + "\t * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #eNS_URI";
  protected final String TEXT_97 = NL + "\t * @see #createPackageContents()" + NL + "\t * @see #initializePackageContents()";
  protected final String TEXT_98 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_99 = " init()" + NL + "\t{" + NL + "\t\tif (isInited) return (";
  protected final String TEXT_100 = ")";
  protected final String TEXT_101 = ".Registry.INSTANCE.getEPackage(";
  protected final String TEXT_102 = ".eNS_URI);" + NL;
  protected final String TEXT_103 = NL + "\t\tinitializeRegistryHelpers();" + NL;
  protected final String TEXT_104 = NL + "\t\t// Obtain or create and register package" + NL + "\t\tObject ePackage = ";
  protected final String TEXT_105 = ".Registry.INSTANCE.get(eNS_URI);" + NL + "\t\t";
  protected final String TEXT_106 = " the";
  protected final String TEXT_107 = " = (";
  protected final String TEXT_108 = ")(ePackage instanceof ";
  protected final String TEXT_109 = " ? ePackage : new ";
  protected final String TEXT_110 = "());" + NL + "" + NL + "\t\tisInited = true;" + NL;
  protected final String TEXT_111 = NL + "\t\t// Initialize simple dependencies";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = ".eINSTANCE.eClass();";
  protected final String TEXT_114 = NL;
  protected final String TEXT_115 = NL + "\t\t// Obtain or create and register interdependencies";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = " = (";
  protected final String TEXT_119 = ")(";
  protected final String TEXT_120 = ".Registry.INSTANCE.getEPackage(";
  protected final String TEXT_121 = ".eNS_URI) instanceof ";
  protected final String TEXT_122 = " ? ";
  protected final String TEXT_123 = ".Registry.INSTANCE.getEPackage(";
  protected final String TEXT_124 = ".eNS_URI) : ";
  protected final String TEXT_125 = ".eINSTANCE);";
  protected final String TEXT_126 = NL;
  protected final String TEXT_127 = NL + "\t\t// Load packages";
  protected final String TEXT_128 = NL + "\t\tthe";
  protected final String TEXT_129 = ".loadPackage();";
  protected final String TEXT_130 = NL + "\t\t";
  protected final String TEXT_131 = ".loadPackage();";
  protected final String TEXT_132 = NL;
  protected final String TEXT_133 = NL + "\t\t// Create package meta-data objects";
  protected final String TEXT_134 = NL + "\t\tthe";
  protected final String TEXT_135 = ".createPackageContents();";
  protected final String TEXT_136 = NL + "\t\t";
  protected final String TEXT_137 = ".createPackageContents();";
  protected final String TEXT_138 = NL + NL + "\t\t// Initialize created meta-data";
  protected final String TEXT_139 = NL + "\t\tthe";
  protected final String TEXT_140 = ".initializePackageContents();";
  protected final String TEXT_141 = NL + "\t\t";
  protected final String TEXT_142 = ".initializePackageContents();";
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = NL + "\t\t// Fix loaded packages";
  protected final String TEXT_145 = NL + "\t\tthe";
  protected final String TEXT_146 = ".fixPackageContents();";
  protected final String TEXT_147 = NL + "\t\t";
  protected final String TEXT_148 = ".fixPackageContents();";
  protected final String TEXT_149 = NL;
  protected final String TEXT_150 = NL + "\t\t// Register package validator" + NL + "\t\t";
  protected final String TEXT_151 = ".Registry.INSTANCE.put" + NL + "\t\t\t(the";
  protected final String TEXT_152 = ", " + NL + "\t\t\t new ";
  protected final String TEXT_153 = ".Descriptor()" + NL + "\t\t\t {" + NL + "\t\t\t\t public ";
  protected final String TEXT_154 = " getEValidator()" + NL + "\t\t\t\t {" + NL + "\t\t\t\t\t return ";
  protected final String TEXT_155 = ".INSTANCE;" + NL + "\t\t\t\t }" + NL + "\t\t\t });" + NL;
  protected final String TEXT_156 = NL + "\t\t// Mark meta-data to indicate it can't be changed" + NL + "\t\tthe";
  protected final String TEXT_157 = ".freeze();" + NL;
  protected final String TEXT_158 = NL + "  " + NL + "\t\t// Update the registry and return the package" + NL + "\t\t";
  protected final String TEXT_159 = ".Registry.INSTANCE.put(";
  protected final String TEXT_160 = ".eNS_URI, the";
  protected final String TEXT_161 = ");" + NL + "\t\treturn the";
  protected final String TEXT_162 = ";" + NL + "\t}";
  protected final String TEXT_163 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void initializeRegistryHelpers()" + NL + "\t{";
  protected final String TEXT_164 = NL + "\t\t";
  protected final String TEXT_165 = ".register" + NL + "\t\t\t(";
  protected final String TEXT_166 = ".class, " + NL + "\t\t\t new ";
  protected final String TEXT_167 = ".Helper() " + NL + "\t\t\t {" + NL + "\t\t\t\t public boolean isInstance(Object instance)" + NL + "\t\t\t\t {" + NL + "\t\t\t\t\t return instance instanceof ";
  protected final String TEXT_168 = ";" + NL + "\t\t\t\t }" + NL + "" + NL + "\t\t\t\t public Object newArrayInstance(int size)" + NL + "\t\t\t\t {" + NL + "\t\t\t\t\t return new ";
  protected final String TEXT_169 = "[size];" + NL + "\t\t\t\t }" + NL + "\t\t\t });";
  protected final String TEXT_170 = NL + "\t\t";
  protected final String TEXT_171 = ".register" + NL + "\t\t\t(";
  protected final String TEXT_172 = ".class, " + NL + "\t\t\t new ";
  protected final String TEXT_173 = ".Helper() " + NL + "\t\t\t {" + NL + "\t\t\t\t public boolean isInstance(Object instance)" + NL + "\t\t\t\t {" + NL + "\t\t\t\t\t return instance instanceof ";
  protected final String TEXT_174 = ";" + NL + "\t\t\t\t }" + NL + "" + NL + "\t\t\t\t public Object newArrayInstance(int size)" + NL + "\t\t\t\t {";
  protected final String TEXT_175 = NL + "\t\t\t\t\t return new ";
  protected final String TEXT_176 = "[size]";
  protected final String TEXT_177 = ";";
  protected final String TEXT_178 = NL + "\t\t\t\t\t return new ";
  protected final String TEXT_179 = "[size];";
  protected final String TEXT_180 = NL + "\t\t\t\t }" + NL + "\t\t});";
  protected final String TEXT_181 = NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class WhiteList implements ";
  protected final String TEXT_182 = ", EBasicWhiteList" + NL + "\t{";
  protected final String TEXT_183 = NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_184 = " ";
  protected final String TEXT_185 = ";" + NL;
  protected final String TEXT_186 = NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_187 = " ";
  protected final String TEXT_188 = ";" + NL;
  protected final String TEXT_189 = NL + "\t}";
  protected final String TEXT_190 = NL;
  protected final String TEXT_191 = NL;
  protected final String TEXT_192 = NL + "\t/**";
  protected final String TEXT_193 = NL + "\t * Returns the meta object for class '{@link ";
  protected final String TEXT_194 = " <em>";
  protected final String TEXT_195 = "</em>}'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the meta object for class '<em>";
  protected final String TEXT_196 = "</em>'." + NL + "\t * @see ";
  protected final String TEXT_197 = NL + "\t * @model ";
  protected final String TEXT_198 = NL + "\t *        ";
  protected final String TEXT_199 = NL + "\t * @model";
  protected final String TEXT_200 = NL + "\t * Returns the meta object for enum '{@link ";
  protected final String TEXT_201 = " <em>";
  protected final String TEXT_202 = "</em>}'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the meta object for enum '<em>";
  protected final String TEXT_203 = "</em>'." + NL + "\t * @see ";
  protected final String TEXT_204 = NL + "\t * Returns the meta object for data type '<em>";
  protected final String TEXT_205 = "</em>'.";
  protected final String TEXT_206 = NL + "\t * Returns the meta object for data type '{@link ";
  protected final String TEXT_207 = " <em>";
  protected final String TEXT_208 = "</em>}'.";
  protected final String TEXT_209 = NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the meta object for data type '<em>";
  protected final String TEXT_210 = "</em>'.";
  protected final String TEXT_211 = NL + "\t * @see ";
  protected final String TEXT_212 = NL + "\t * @model ";
  protected final String TEXT_213 = NL + "\t *        ";
  protected final String TEXT_214 = NL + "\t * @model";
  protected final String TEXT_215 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_216 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_217 = NL + "\tpublic ";
  protected final String TEXT_218 = " get";
  protected final String TEXT_219 = "()" + NL + "\t{";
  protected final String TEXT_220 = NL + "\t\tif (";
  protected final String TEXT_221 = " == null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_222 = " = (";
  protected final String TEXT_223 = ")";
  protected final String TEXT_224 = ".Registry.INSTANCE.getEPackage(";
  protected final String TEXT_225 = ".eNS_URI).getEClassifiers().get(";
  protected final String TEXT_226 = ");" + NL + "\t\t}";
  protected final String TEXT_227 = NL + "\t\treturn ";
  protected final String TEXT_228 = ";" + NL + "\t}" + NL;
  protected final String TEXT_229 = NL + "\t";
  protected final String TEXT_230 = " get";
  protected final String TEXT_231 = "();" + NL;
  protected final String TEXT_232 = NL + "\t/**" + NL + "\t * Returns the meta object for the ";
  protected final String TEXT_233 = " '{@link ";
  protected final String TEXT_234 = "#";
  protected final String TEXT_235 = " <em>";
  protected final String TEXT_236 = "</em>}'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the meta object for the ";
  protected final String TEXT_237 = " '<em>";
  protected final String TEXT_238 = "</em>'." + NL + "\t * @see ";
  protected final String TEXT_239 = "#";
  protected final String TEXT_240 = "()";
  protected final String TEXT_241 = NL + "\t * @see #get";
  protected final String TEXT_242 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_243 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_244 = NL + "\tpublic ";
  protected final String TEXT_245 = " get";
  protected final String TEXT_246 = "()" + NL + "\t{";
  protected final String TEXT_247 = NL + "\t\treturn (";
  protected final String TEXT_248 = ")";
  protected final String TEXT_249 = ".getEStructuralFeatures().get(";
  protected final String TEXT_250 = ");";
  protected final String TEXT_251 = NL + "        return (";
  protected final String TEXT_252 = ")get";
  protected final String TEXT_253 = "().getEStructuralFeatures().get(";
  protected final String TEXT_254 = ");";
  protected final String TEXT_255 = NL + "\t}";
  protected final String TEXT_256 = NL + "\t";
  protected final String TEXT_257 = " get";
  protected final String TEXT_258 = "();";
  protected final String TEXT_259 = NL;
  protected final String TEXT_260 = NL + "\t/**" + NL + "\t * Returns the meta object for the '{@link ";
  protected final String TEXT_261 = "#";
  protected final String TEXT_262 = "(";
  protected final String TEXT_263 = ") <em>";
  protected final String TEXT_264 = "</em>}' operation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the meta object for the '<em>";
  protected final String TEXT_265 = "</em>' operation." + NL + "\t * @see ";
  protected final String TEXT_266 = "#";
  protected final String TEXT_267 = "(";
  protected final String TEXT_268 = ")" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_269 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_270 = NL + "\tpublic ";
  protected final String TEXT_271 = " get";
  protected final String TEXT_272 = "()" + NL + "\t{";
  protected final String TEXT_273 = NL + "\t\treturn ";
  protected final String TEXT_274 = ".getEOperations().get(";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "        return get";
  protected final String TEXT_277 = "().getEOperations().get(";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "\t}";
  protected final String TEXT_280 = NL + "\t";
  protected final String TEXT_281 = " get";
  protected final String TEXT_282 = "();";
  protected final String TEXT_283 = NL;
  protected final String TEXT_284 = NL + "\t/**" + NL + "\t * Returns the factory that creates the instances of the model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the factory that creates the instances of the model." + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_285 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_286 = NL + "\tpublic ";
  protected final String TEXT_287 = " get";
  protected final String TEXT_288 = "()" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_289 = ")getEFactoryInstance();" + NL + "\t}";
  protected final String TEXT_290 = NL + "\t";
  protected final String TEXT_291 = " get";
  protected final String TEXT_292 = "();";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isCreated = false;" + NL + "" + NL + "\t/**" + NL + "\t * Creates the meta-model objects for the package.  This method is" + NL + "\t * guarded to have no affect on any invocation but its first." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createPackageContents()" + NL + "\t{" + NL + "\t\tif (isCreated) return;" + NL + "\t\tisCreated = true;";
  protected final String TEXT_295 = NL + NL + "\t\t// Create classes and their features";
  protected final String TEXT_296 = NL + "\t\t";
  protected final String TEXT_297 = " = create";
  protected final String TEXT_298 = "(";
  protected final String TEXT_299 = ");";
  protected final String TEXT_300 = NL + "\t\tcreate";
  protected final String TEXT_301 = "(";
  protected final String TEXT_302 = ", ";
  protected final String TEXT_303 = ");";
  protected final String TEXT_304 = NL + "\t\tcreateEOperation(";
  protected final String TEXT_305 = ", ";
  protected final String TEXT_306 = ");";
  protected final String TEXT_307 = NL;
  protected final String TEXT_308 = NL + NL + "\t\t// Create enums";
  protected final String TEXT_309 = NL + "\t\t";
  protected final String TEXT_310 = " = createEEnum(";
  protected final String TEXT_311 = ");";
  protected final String TEXT_312 = NL + NL + "\t\t// Create data types";
  protected final String TEXT_313 = NL + "\t\t";
  protected final String TEXT_314 = " = createEDataType(";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isInitialized = false;" + NL;
  protected final String TEXT_317 = NL + "\t/**" + NL + "\t * Complete the initialization of the package and its meta-model.  This" + NL + "\t * method is guarded to have no affect on any invocation but its first." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void initializePackageContents()" + NL + "\t{" + NL + "\t\tif (isInitialized) return;" + NL + "\t\tisInitialized = true;" + NL + "" + NL + "\t\t// Initialize package" + NL + "\t\tsetName(eNAME);" + NL + "\t\tsetNsPrefix(eNS_PREFIX);" + NL + "\t\tsetNsURI(eNS_URI);";
  protected final String TEXT_318 = NL + NL + "\t\t// Obtain other dependent packages";
  protected final String TEXT_319 = NL + "\t\t";
  protected final String TEXT_320 = " ";
  protected final String TEXT_321 = " = (";
  protected final String TEXT_322 = ")";
  protected final String TEXT_323 = ".Registry.INSTANCE.getEPackage(";
  protected final String TEXT_324 = ".eNS_URI);";
  protected final String TEXT_325 = NL + NL + "\t\t// Add subpackages";
  protected final String TEXT_326 = NL + "\t\tgetESubpackages().add(";
  protected final String TEXT_327 = ");";
  protected final String TEXT_328 = NL + NL + "\t\t// Create type parameters";
  protected final String TEXT_329 = NL + "\t\t";
  protected final String TEXT_330 = " ";
  protected final String TEXT_331 = "_";
  protected final String TEXT_332 = " = addETypeParameter(";
  protected final String TEXT_333 = ", \"";
  protected final String TEXT_334 = "\");";
  protected final String TEXT_335 = NL + "\t\taddETypeParameter(";
  protected final String TEXT_336 = ", \"";
  protected final String TEXT_337 = "\");";
  protected final String TEXT_338 = NL + NL + "\t\t// Set bounds for type parameters";
  protected final String TEXT_339 = NL + "\t\t";
  protected final String TEXT_340 = "g";
  protected final String TEXT_341 = " = createEGenericType(";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = NL + "\t\tg";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = "(g";
  protected final String TEXT_346 = ");";
  protected final String TEXT_347 = NL + "\t\t";
  protected final String TEXT_348 = "_";
  protected final String TEXT_349 = ".getEBounds().add(g1);";
  protected final String TEXT_350 = NL + NL + "\t\t// Add supertypes to classes";
  protected final String TEXT_351 = NL + "\t\t";
  protected final String TEXT_352 = ".getESuperTypes().add(";
  protected final String TEXT_353 = ".get";
  protected final String TEXT_354 = "());";
  protected final String TEXT_355 = NL + "\t\t";
  protected final String TEXT_356 = "g";
  protected final String TEXT_357 = " = createEGenericType(";
  protected final String TEXT_358 = ");";
  protected final String TEXT_359 = NL + "\t\tg";
  protected final String TEXT_360 = ".";
  protected final String TEXT_361 = "(g";
  protected final String TEXT_362 = ");";
  protected final String TEXT_363 = NL + "\t\t";
  protected final String TEXT_364 = ".getEGenericSuperTypes().add(g1);";
  protected final String TEXT_365 = NL + NL + "\t\t// Initialize classes";
  protected final String TEXT_366 = ", features, and operations; add parameters";
  protected final String TEXT_367 = " and features; add operations and parameters";
  protected final String TEXT_368 = NL + "\t\tinitEClass(";
  protected final String TEXT_369 = ", ";
  protected final String TEXT_370 = "null";
  protected final String TEXT_371 = ".class";
  protected final String TEXT_372 = ", \"";
  protected final String TEXT_373 = "\", ";
  protected final String TEXT_374 = ", ";
  protected final String TEXT_375 = ", ";
  protected final String TEXT_376 = ", \"";
  protected final String TEXT_377 = "\"";
  protected final String TEXT_378 = ");";
  protected final String TEXT_379 = NL + "\t\t";
  protected final String TEXT_380 = "g";
  protected final String TEXT_381 = " = createEGenericType(";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = NL + "\t\tg";
  protected final String TEXT_384 = ".";
  protected final String TEXT_385 = "(g";
  protected final String TEXT_386 = ");";
  protected final String TEXT_387 = NL + "\t\tinitEReference(get";
  protected final String TEXT_388 = "(), ";
  protected final String TEXT_389 = "g1";
  protected final String TEXT_390 = ".get";
  protected final String TEXT_391 = "()";
  protected final String TEXT_392 = ", ";
  protected final String TEXT_393 = ", \"";
  protected final String TEXT_394 = "\", ";
  protected final String TEXT_395 = ", ";
  protected final String TEXT_396 = ", ";
  protected final String TEXT_397 = ", ";
  protected final String TEXT_398 = ", ";
  protected final String TEXT_399 = ", ";
  protected final String TEXT_400 = ", ";
  protected final String TEXT_401 = ", ";
  protected final String TEXT_402 = ", ";
  protected final String TEXT_403 = ", ";
  protected final String TEXT_404 = ", ";
  protected final String TEXT_405 = ", ";
  protected final String TEXT_406 = ", ";
  protected final String TEXT_407 = ");";
  protected final String TEXT_408 = NL + "\t\tget";
  protected final String TEXT_409 = "().getEKeys().add(";
  protected final String TEXT_410 = ".get";
  protected final String TEXT_411 = "());";
  protected final String TEXT_412 = NL + "\t\tinitEAttribute(get";
  protected final String TEXT_413 = "(), ";
  protected final String TEXT_414 = "g1";
  protected final String TEXT_415 = ".get";
  protected final String TEXT_416 = "()";
  protected final String TEXT_417 = ", \"";
  protected final String TEXT_418 = "\", ";
  protected final String TEXT_419 = ", ";
  protected final String TEXT_420 = ", ";
  protected final String TEXT_421 = ", ";
  protected final String TEXT_422 = ", ";
  protected final String TEXT_423 = ", ";
  protected final String TEXT_424 = ", ";
  protected final String TEXT_425 = ", ";
  protected final String TEXT_426 = ", ";
  protected final String TEXT_427 = ", ";
  protected final String TEXT_428 = ", ";
  protected final String TEXT_429 = ", ";
  protected final String TEXT_430 = ");";
  protected final String TEXT_431 = NL;
  protected final String TEXT_432 = NL + "\t\t";
  protected final String TEXT_433 = "initEOperation(get";
  protected final String TEXT_434 = "()";
  protected final String TEXT_435 = "addEOperation(";
  protected final String TEXT_436 = ", ";
  protected final String TEXT_437 = "null";
  protected final String TEXT_438 = ".get";
  protected final String TEXT_439 = "()";
  protected final String TEXT_440 = ", \"";
  protected final String TEXT_441 = "\", ";
  protected final String TEXT_442 = ", ";
  protected final String TEXT_443 = ", ";
  protected final String TEXT_444 = ", ";
  protected final String TEXT_445 = ");";
  protected final String TEXT_446 = NL + "\t\t";
  protected final String TEXT_447 = "initEOperation(get";
  protected final String TEXT_448 = "()";
  protected final String TEXT_449 = "addEOperation(";
  protected final String TEXT_450 = ", ";
  protected final String TEXT_451 = ".get";
  protected final String TEXT_452 = "(), \"";
  protected final String TEXT_453 = "\", ";
  protected final String TEXT_454 = ", ";
  protected final String TEXT_455 = ", ";
  protected final String TEXT_456 = ", ";
  protected final String TEXT_457 = ");";
  protected final String TEXT_458 = NL + "\t\t";
  protected final String TEXT_459 = "initEOperation(get";
  protected final String TEXT_460 = "()";
  protected final String TEXT_461 = "addEOperation(";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = ".get";
  protected final String TEXT_464 = "(), \"";
  protected final String TEXT_465 = "\", ";
  protected final String TEXT_466 = ", ";
  protected final String TEXT_467 = ");";
  protected final String TEXT_468 = NL + "\t\t";
  protected final String TEXT_469 = "initEOperation(get";
  protected final String TEXT_470 = "()";
  protected final String TEXT_471 = "addEOperation(";
  protected final String TEXT_472 = ", null, \"";
  protected final String TEXT_473 = "\");";
  protected final String TEXT_474 = NL + "\t\t";
  protected final String TEXT_475 = "addETypeParameter(op, \"";
  protected final String TEXT_476 = "\");";
  protected final String TEXT_477 = NL + "\t\t";
  protected final String TEXT_478 = "g";
  protected final String TEXT_479 = " = createEGenericType(";
  protected final String TEXT_480 = ");";
  protected final String TEXT_481 = NL + "\t\tg";
  protected final String TEXT_482 = ".";
  protected final String TEXT_483 = "(g";
  protected final String TEXT_484 = ");";
  protected final String TEXT_485 = NL + "\t\tt";
  protected final String TEXT_486 = ".getEBounds().add(g1);";
  protected final String TEXT_487 = NL + "\t\t";
  protected final String TEXT_488 = "g";
  protected final String TEXT_489 = " = createEGenericType(";
  protected final String TEXT_490 = ");";
  protected final String TEXT_491 = NL + "\t\tg";
  protected final String TEXT_492 = ".";
  protected final String TEXT_493 = "(g";
  protected final String TEXT_494 = ");";
  protected final String TEXT_495 = NL + "\t\taddEParameter(op, ";
  protected final String TEXT_496 = "g1";
  protected final String TEXT_497 = ".get";
  protected final String TEXT_498 = "()";
  protected final String TEXT_499 = ", \"";
  protected final String TEXT_500 = "\", ";
  protected final String TEXT_501 = ", ";
  protected final String TEXT_502 = ", ";
  protected final String TEXT_503 = ", ";
  protected final String TEXT_504 = ");";
  protected final String TEXT_505 = NL + "\t\taddEParameter(op, ";
  protected final String TEXT_506 = "g1";
  protected final String TEXT_507 = ".get";
  protected final String TEXT_508 = "()";
  protected final String TEXT_509 = ", \"";
  protected final String TEXT_510 = "\", ";
  protected final String TEXT_511 = ", ";
  protected final String TEXT_512 = ", ";
  protected final String TEXT_513 = ", ";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "\t\taddEParameter(op, ";
  protected final String TEXT_516 = "g1";
  protected final String TEXT_517 = ".get";
  protected final String TEXT_518 = "()";
  protected final String TEXT_519 = ", \"";
  protected final String TEXT_520 = "\", ";
  protected final String TEXT_521 = ", ";
  protected final String TEXT_522 = ");";
  protected final String TEXT_523 = NL + "\t\t";
  protected final String TEXT_524 = "g";
  protected final String TEXT_525 = " = createEGenericType(";
  protected final String TEXT_526 = ");";
  protected final String TEXT_527 = NL + "\t\tg";
  protected final String TEXT_528 = ".";
  protected final String TEXT_529 = "(g";
  protected final String TEXT_530 = ");";
  protected final String TEXT_531 = NL + "\t\taddEException(op, g";
  protected final String TEXT_532 = ");";
  protected final String TEXT_533 = NL + "\t\taddEException(op, ";
  protected final String TEXT_534 = ".get";
  protected final String TEXT_535 = "());";
  protected final String TEXT_536 = NL + "\t\t";
  protected final String TEXT_537 = "g";
  protected final String TEXT_538 = " = createEGenericType(";
  protected final String TEXT_539 = ");";
  protected final String TEXT_540 = NL + "\t\tg";
  protected final String TEXT_541 = ".";
  protected final String TEXT_542 = "(g";
  protected final String TEXT_543 = ");";
  protected final String TEXT_544 = NL + "\t\tinitEOperation(op, g1);";
  protected final String TEXT_545 = NL;
  protected final String TEXT_546 = NL + NL + "\t\t// Initialize enums and add enum literals";
  protected final String TEXT_547 = NL + "\t\tinitEEnum(";
  protected final String TEXT_548 = ", ";
  protected final String TEXT_549 = ".class, \"";
  protected final String TEXT_550 = "\");";
  protected final String TEXT_551 = NL + "\t\taddEEnumLiteral(";
  protected final String TEXT_552 = ", ";
  protected final String TEXT_553 = ".";
  protected final String TEXT_554 = ");";
  protected final String TEXT_555 = NL;
  protected final String TEXT_556 = NL + NL + "\t\t// Initialize data types";
  protected final String TEXT_557 = NL + "\t\tinitEDataType(";
  protected final String TEXT_558 = ", ";
  protected final String TEXT_559 = ".class, \"";
  protected final String TEXT_560 = "\", ";
  protected final String TEXT_561 = ", ";
  protected final String TEXT_562 = ", \"";
  protected final String TEXT_563 = "\"";
  protected final String TEXT_564 = ");";
  protected final String TEXT_565 = NL + NL + "\t\t// Create resource" + NL + "\t\tcreateResource(";
  protected final String TEXT_566 = ");";
  protected final String TEXT_567 = NL + NL + "\t\t// Create annotations";
  protected final String TEXT_568 = NL + "\t\t// ";
  protected final String TEXT_569 = NL + "\t\tcreate";
  protected final String TEXT_570 = "Annotations();";
  protected final String TEXT_571 = NL + "\t}" + NL;
  protected final String TEXT_572 = NL + "\t/**" + NL + "\t * Initializes the annotations for <b>";
  protected final String TEXT_573 = "</b>." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void create";
  protected final String TEXT_574 = "Annotations()" + NL + "\t{" + NL + "\t\tString source = ";
  protected final String TEXT_575 = "null;";
  protected final String TEXT_576 = "\"";
  protected final String TEXT_577 = "\";";
  protected final String TEXT_578 = "\t" + NL + "\t\taddAnnotation" + NL + "\t\t  (";
  protected final String TEXT_579 = ", " + NL + "\t\t   source, " + NL + "\t\t   new String[] " + NL + "\t\t   {";
  protected final String TEXT_580 = NL + "\t\t\t ";
  protected final String TEXT_581 = ", ";
  protected final String TEXT_582 = NL + "\t\t   }";
  protected final String TEXT_583 = ");";
  protected final String TEXT_584 = ",";
  protected final String TEXT_585 = NL + "\t\t   new ";
  protected final String TEXT_586 = "[] " + NL + "\t\t   {";
  protected final String TEXT_587 = NL + "\t\t\t ";
  protected final String TEXT_588 = ".createURI(";
  protected final String TEXT_589 = ".";
  protected final String TEXT_590 = "eNS_URI).appendFragment(\"";
  protected final String TEXT_591 = "\")";
  protected final String TEXT_592 = ",";
  protected final String TEXT_593 = NL + "\t\t   });";
  protected final String TEXT_594 = NL + "\t\taddAnnotation" + NL + "\t\t  (";
  protected final String TEXT_595 = ", " + NL + "\t\t   ";
  protected final String TEXT_596 = "new boolean[] { ";
  protected final String TEXT_597 = " }";
  protected final String TEXT_598 = "," + NL + "\t\t   ";
  protected final String TEXT_599 = "null,";
  protected final String TEXT_600 = "\"";
  protected final String TEXT_601 = "\",";
  protected final String TEXT_602 = NL + "\t\t   new String[] " + NL + "\t\t   {";
  protected final String TEXT_603 = NL + "\t\t\t ";
  protected final String TEXT_604 = ", ";
  protected final String TEXT_605 = NL + "\t\t   }";
  protected final String TEXT_606 = ");";
  protected final String TEXT_607 = ",";
  protected final String TEXT_608 = NL + "\t\t   new ";
  protected final String TEXT_609 = "[] " + NL + "\t\t   {";
  protected final String TEXT_610 = NL + "\t\t\t ";
  protected final String TEXT_611 = ".createURI(";
  protected final String TEXT_612 = ".";
  protected final String TEXT_613 = "eNS_URI).appendFragment(\"";
  protected final String TEXT_614 = "\")";
  protected final String TEXT_615 = ",";
  protected final String TEXT_616 = NL + "\t\t   });";
  protected final String TEXT_617 = NL + "\t}" + NL;
  protected final String TEXT_618 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLoaded = false;" + NL + "" + NL + "\t/**" + NL + "\t * Laods the package and any sub-packages from their serialized form." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void loadPackage()" + NL + "\t{" + NL + "\t\tif (isLoaded) return;" + NL + "\t\tisLoaded = true;" + NL + "" + NL + "\t\t";
  protected final String TEXT_619 = " url = getClass().getResource(packageFilename);" + NL + "\t\tif (url == null)" + NL + "\t\t{" + NL + "\t\t\tthrow new RuntimeException(\"Missing serialized package: \" + packageFilename);";
  protected final String TEXT_620 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_621 = " uri = ";
  protected final String TEXT_622 = ".createURI(url.toString());" + NL + "\t\t";
  protected final String TEXT_623 = " resource = new ";
  protected final String TEXT_624 = "().createResource(uri);" + NL + "\t\ttry" + NL + "\t\t{" + NL + "\t\t\tresource.load(null);" + NL + "\t\t}" + NL + "\t\tcatch (";
  protected final String TEXT_625 = " exception)" + NL + "\t\t{" + NL + "\t\t\tthrow new ";
  protected final String TEXT_626 = "(exception);" + NL + "\t\t}" + NL + "\t\tinitializeFromLoadedEPackage(this, (";
  protected final String TEXT_627 = ")resource.getContents().get(0));" + NL + "\t\tcreateResource(eNS_URI);" + NL + "\t}" + NL;
  protected final String TEXT_628 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isFixed = false;" + NL + "" + NL + "\t/**" + NL + "\t * Fixes up the loaded package, to make it appear as if it had been programmatically built." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void fixPackageContents()" + NL + "\t{" + NL + "\t\tif (isFixed) return;" + NL + "\t\tisFixed = true;" + NL + "\t\tfixEClassifiers();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Sets the instance class on the given classifier." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_629 = NL + "\t@Override";
  protected final String TEXT_630 = NL + "\tprotected void fixInstanceClass(";
  protected final String TEXT_631 = " eClassifier)" + NL + "\t{" + NL + "\t\tif (eClassifier.getInstanceClassName() == null)" + NL + "\t\t{";
  protected final String TEXT_632 = NL + "\t\t\teClassifier.setInstanceClassName(\"";
  protected final String TEXT_633 = ".\" + eClassifier.getName());";
  protected final String TEXT_634 = NL + "\t\t\tsetGeneratedClassName(eClassifier);";
  protected final String TEXT_635 = NL + "\t\t\tswitch (eClassifier.getClassifierID())" + NL + "\t\t\t{";
  protected final String TEXT_636 = NL + "\t\t\t\tcase ";
  protected final String TEXT_637 = ":";
  protected final String TEXT_638 = NL + "\t\t\t\t{" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tdefault:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\teClassifier.setInstanceClassName(\"";
  protected final String TEXT_639 = ".\" + eClassifier.getName());";
  protected final String TEXT_640 = NL + "\t\t\t\t\tsetGeneratedClassName(eClassifier);" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_641 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_642 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_643 = " addEOperation(";
  protected final String TEXT_644 = " owner, ";
  protected final String TEXT_645 = " type, String name, int lowerBound, int upperBound, boolean isUnique, boolean isOrdered)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_646 = " o = addEOperation(owner, type, name, lowerBound, upperBound);" + NL + "\t\to.setUnique(isUnique);" + NL + "\t\to.setOrdered(isOrdered);" + NL + "\t\treturn o;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_647 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_648 = " addEParameter(";
  protected final String TEXT_649 = " owner, ";
  protected final String TEXT_650 = " type, String name, int lowerBound, int upperBound, boolean isUnique, boolean isOrdered)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_651 = " p = ecoreFactory.createEParameter();" + NL + "\t\tp.setEType(type);" + NL + "\t\tp.setName(name);" + NL + "\t\tp.setLowerBound(lowerBound);" + NL + "\t\tp.setUpperBound(upperBound);" + NL + "\t\tp.setUnique(isUnique);" + NL + "\t\tp.setOrdered(isOrdered);" + NL + "\t\towner.getEParameters().add(p);" + NL + "\t\treturn p;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_652 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * Defines literals for the meta objects that represent" + NL + "\t * <ul>" + NL + "\t *   <li>each class,</li>" + NL + "\t *   <li>each feature of each class,</li>";
  protected final String TEXT_653 = NL + "\t *   <li>each operation of each class,</li>";
  protected final String TEXT_654 = NL + "\t *   <li>each enum,</li>" + NL + "\t *   <li>and each data type</li>" + NL + "\t * </ul>" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_655 = "public ";
  protected final String TEXT_656 = "interface Literals" + NL + "\t{";
  protected final String TEXT_657 = NL + "\t\t/**";
  protected final String TEXT_658 = NL + "\t\t * The meta object literal for the '{@link ";
  protected final String TEXT_659 = " <em>";
  protected final String TEXT_660 = "</em>}' class." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @see ";
  protected final String TEXT_661 = NL + "\t\t * The meta object literal for the '{@link ";
  protected final String TEXT_662 = " <em>";
  protected final String TEXT_663 = "</em>}' class." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @see ";
  protected final String TEXT_664 = NL + "\t\t * The meta object literal for the '{@link ";
  protected final String TEXT_665 = " <em>";
  protected final String TEXT_666 = "</em>}' enum." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @see ";
  protected final String TEXT_667 = NL + "\t\t * The meta object literal for the '<em>";
  protected final String TEXT_668 = "</em>' data type." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->";
  protected final String TEXT_669 = NL + "\t\t * @see ";
  protected final String TEXT_670 = NL + "\t\t * @see ";
  protected final String TEXT_671 = "#get";
  protected final String TEXT_672 = "()" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\t";
  protected final String TEXT_673 = " ";
  protected final String TEXT_674 = " = eINSTANCE.get";
  protected final String TEXT_675 = "();" + NL;
  protected final String TEXT_676 = NL + "\t\t/**" + NL + "\t\t * The meta object literal for the '<em><b>";
  protected final String TEXT_677 = "</b></em>' ";
  protected final String TEXT_678 = " feature." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\t";
  protected final String TEXT_679 = " ";
  protected final String TEXT_680 = " = eINSTANCE.get";
  protected final String TEXT_681 = "();" + NL;
  protected final String TEXT_682 = NL + "\t\t/**" + NL + "\t\t * The meta object literal for the '<em><b>";
  protected final String TEXT_683 = "</b></em>' operation." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\t";
  protected final String TEXT_684 = " ";
  protected final String TEXT_685 = " = eINSTANCE.get";
  protected final String TEXT_686 = "();" + NL;
  protected final String TEXT_687 = NL + "\t}" + NL;
  protected final String TEXT_688 = NL + "} //";
  protected final String TEXT_689 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * Copyright (c) 2002-2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */

    final GenPackage genPackage = (GenPackage)((Object[])argument)[0]; final GenModel genModel=genPackage.getGenModel();
    boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
    String publicStaticFinalFlag = isImplementation ? "public static final " : "";
    boolean needsAddEOperation = false;
    boolean needsAddEParameter = false;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    {GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    }}
    stringBuffer.append(TEXT_4);
    if (isImplementation && !genModel.isSuppressInterfaces()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getClassPackageName());
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPackage.getReflectionPackageName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    genModel.markImportLocation(stringBuffer, genPackage);
    if (isImplementation) {
    genModel.addPseudoImport("org.eclipse.emf.ecore.EPackage.Registry");
    genModel.addPseudoImport("org.eclipse.emf.ecore.EPackage.Descriptor");
    genModel.addPseudoImport("org.eclipse.emf.ecore.impl.EPackageImpl.EBasicWhiteList");
    genModel.addPseudoImport("org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container");
    genModel.addPseudoImport("org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container.Dynamic");
    if (genPackage.isLiteralsInterface()) {
    genModel.addPseudoImport(genPackage.getQualifiedPackageInterfaceName() + ".Literals");
    }
    for (GenClassifier genClassifier : genPackage.getOrderedGenClassifiers()) genModel.addPseudoImport(genPackage.getQualifiedPackageInterfaceName() + "." + genPackage.getClassifierID(genClassifier));
    }
    if (isInterface) {
    stringBuffer.append(TEXT_10);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    if (genPackage.hasDocumentation()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genPackage.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genPackage.getQualifiedFactoryInterfaceName());
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genPackage.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_18);
    }}
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_20);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.EPackageImpl"));
    if (!isInterface){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    }
    } else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genPackage.getPackageInterfaceName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    }
    stringBuffer.append(TEXT_26);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_30);
    }
    if (isInterface) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genPackage.getPackageName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genPackage.getNSName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genModel.getNonNLS());
    if (genPackage.isContentType()) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genPackage.getContentTypeIdentifier());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genPackage.getPackageInterfaceName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genPackage.getQualifiedPackageClassName());
    stringBuffer.append(TEXT_45);
    for (GenClassifier genClassifier : genPackage.getOrderedGenClassifiers()) {
    stringBuffer.append(TEXT_46);
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    if (!genClass.isInterface()) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genClass.getQualifiedClassName());
    } else {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    }
    } else if (genClassifier instanceof GenEnum) { GenEnum genEnum = (GenEnum)genClassifier;
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genEnum.getQualifiedName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genEnum.getQualifiedName());
    } else if (genClassifier instanceof GenDataType) { GenDataType genDataType = (GenDataType)genClassifier;
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_57);
    if (!genDataType.isPrimitiveType() && !genDataType.isArrayType()) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genDataType.getRawInstanceClassName());
    }
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genPackage.getQualifiedPackageClassName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genPackage.getClassifierID(genClassifier));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genPackage.getClassifierValue(genClassifier));
    stringBuffer.append(TEXT_64);
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    for (GenFeature genFeature : genClass.getAllGenFeatures()) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genClass.getFeatureID(genFeature));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genClass.getFeatureValue(genFeature));
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genClass.getFeatureCountID());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genClass.getFeatureCountValue());
    stringBuffer.append(TEXT_75);
    if (genModel.isOperationReflection()) {
    for (GenOperation genOperation : genClass.getAllGenOperations(false)) {
    if (genClass.getOverrideGenOperation(genOperation) == null) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genOperation.getFormattedName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getOperationID(genOperation, false));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genClass.getOperationValue(genOperation));
    stringBuffer.append(TEXT_80);
    }
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genClass.getOperationCountID());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genClass.getOperationCountValue());
    stringBuffer.append(TEXT_85);
    }
    }
    }
    }
    if (isImplementation) {
    if (genPackage.isLoadingInitialization()) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genPackage.getSerializedPackageFilename());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_88);
    }
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genClassifier.getImportedMetaType());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genPackage.getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_96);
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_102);
    if (genModel.getRuntimePlatform() == GenRuntimePlatform.GWT) {
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genPackage.getPackageClassName());
    stringBuffer.append(TEXT_110);
    if (!genPackage.getPackageSimpleDependencies().isEmpty()) {
    stringBuffer.append(TEXT_111);
    for (GenPackage dep : genPackage.getPackageSimpleDependencies()) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    }
    if (!genPackage.getPackageInterDependencies().isEmpty()) {
    stringBuffer.append(TEXT_115);
    for (GenPackage interdep : genPackage.getPackageInterDependencies()) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(interdep.getImportedPackageClassName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genPackage.getPackageInstanceVariable(interdep));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(interdep.getImportedPackageClassName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(interdep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(interdep.getImportedPackageClassName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(interdep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(interdep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    }
    if (genPackage.isLoadedInitialization() || !genPackage.getPackageLoadInterDependencies().isEmpty()) {
    stringBuffer.append(TEXT_127);
    if (genPackage.isLoadingInitialization()) {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_129);
    }
    for (GenPackage interdep : genPackage.getPackageLoadInterDependencies()) {
    if (interdep.isLoadingInitialization()) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genPackage.getPackageInstanceVariable(interdep));
    stringBuffer.append(TEXT_131);
    }
    }
    stringBuffer.append(TEXT_132);
    }
    if (!genPackage.isLoadedInitialization() || !genPackage.getPackageBuildInterDependencies().isEmpty()) {
    stringBuffer.append(TEXT_133);
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_135);
    }
    for (GenPackage interdep : genPackage.getPackageBuildInterDependencies()) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genPackage.getPackageInstanceVariable(interdep));
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_140);
    }
    for (GenPackage interdep : genPackage.getPackageBuildInterDependencies()) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genPackage.getPackageInstanceVariable(interdep));
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    }
    if (genPackage.isLoadedInitialization() || !genPackage.getPackageLoadInterDependencies().isEmpty()) {
    stringBuffer.append(TEXT_144);
    if (genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_146);
    }
    for (GenPackage interdep : genPackage.getPackageLoadInterDependencies()) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genPackage.getPackageInstanceVariable(interdep));
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    }
    if (genPackage.hasConstraints()) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EValidator"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EValidator"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EValidator"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genPackage.getImportedValidatorClassName());
    stringBuffer.append(TEXT_155);
    }
    if (!genPackage.isEcorePackage()) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genPackage.getBasicPackageName());
    stringBuffer.append(TEXT_162);
    if (genModel.getRuntimePlatform() == GenRuntimePlatform.GWT) {
    stringBuffer.append(TEXT_163);
    Set<String> helpers = new HashSet<String>(); for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    if (!genClass.isDynamic()) { String theClass = genClass.isMapEntry() ? genClass.getImportedClassName() : genClass.getRawImportedInterfaceName(); if (helpers.add(theClass)) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Reflect"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(theClass);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Reflect"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genClass.isMapEntry() ? genClass.getImportedClassName() : genClass.getRawImportedInterfaceName() + genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(theClass);
    stringBuffer.append(TEXT_169);
    }}
    } else if (genClassifier instanceof GenDataType) { GenDataType genDataType = (GenDataType)genClassifier;
    if (!genDataType.isPrimitiveType() && !genDataType.isObjectType()) { String theClass = genDataType.getRawImportedInstanceClassName(); if (helpers.add(theClass)) { 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Reflect"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(theClass);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Reflect"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(theClass);
    stringBuffer.append(TEXT_174);
    if (genDataType.isArrayType()) { String componentType = theClass; String indices = ""; while(componentType.endsWith("[]")) { componentType = componentType.substring(0, componentType.length() - 2); indices += "[]";}
    stringBuffer.append(TEXT_175);
    stringBuffer.append(componentType);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(indices);
    stringBuffer.append(TEXT_177);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(theClass);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    }}
    }
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.IsSerializable"));
    stringBuffer.append(TEXT_182);
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    if (!genClass.isDynamic()) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(genClass.isMapEntry() ? genClass.getImportedClassName() : genClass.getImportedWildcardInstanceClassName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_185);
    }
    } else if (genClassifier instanceof GenDataType) { GenDataType genDataType = (GenDataType)genClassifier;
    if (!genDataType.isObjectType() && genDataType.isSerializable()) {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genDataType.getImportedWildcardInstanceClassName());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_188);
    }
    }
    }
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    }
    if (isInterface) { // TODO REMOVE THIS BOGUS EMPTY LINE
    stringBuffer.append(TEXT_191);
    }
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    if (isInterface) {
    stringBuffer.append(TEXT_192);
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    if (!genModel.isSuppressEMFModelTags() && (genClass.isExternalInterface() || genClass.isDynamic())) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_197);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_199);
    }}
    } else if (genClassifier instanceof GenEnum) { GenEnum genEnum = (GenEnum)genClassifier;
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genEnum.getQualifiedName());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genEnum.getQualifiedName());
    } else if (genClassifier instanceof GenDataType) { GenDataType genDataType = (GenDataType)genClassifier;
    if (genDataType.isPrimitiveType() || genDataType.isArrayType()) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_205);
    } else {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genDataType.getRawInstanceClassName());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_210);
    if (!genDataType.isPrimitiveType() && !genDataType.isArrayType()) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genDataType.getRawInstanceClassName());
    }
    if (!genModel.isSuppressEMFModelTags()) {boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genDataType.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_212);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_214);
    }}
    }
    stringBuffer.append(TEXT_215);
    } else {
    stringBuffer.append(TEXT_216);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genClassifier.getImportedMetaType());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_219);
    if (genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_220);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(genClassifier.getImportedMetaType());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(genPackage.getLocalClassifierIndex(genClassifier));
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_228);
    } else {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genClassifier.getImportedMetaType());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_231);
    }
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    for (GenFeature genFeature : genClass.getGenFeatures()) {
    if (isInterface) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    if (!genClass.isMapEntry() && !genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genFeature.getGetAccessor());
    }
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    if (!genClass.isMapEntry() && !genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_242);
    } else {
    stringBuffer.append(TEXT_243);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(genFeature.getImportedMetaType());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_246);
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genFeature.getImportedMetaType());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(genClass.getLocalFeatureIndex(genFeature));
    stringBuffer.append(TEXT_250);
    } else {
    stringBuffer.append(TEXT_251);
    stringBuffer.append(genFeature.getImportedMetaType());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genClass.getLocalFeatureIndex(genFeature));
    stringBuffer.append(TEXT_254);
    }
    stringBuffer.append(TEXT_255);
    } else {
    stringBuffer.append(TEXT_256);
    stringBuffer.append(genFeature.getImportedMetaType());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    }
    if (genModel.isOperationReflection()) {
    for (GenOperation genOperation : genClass.getGenOperations()) {
    if (isInterface) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(genOperation.getParameterTypes(", "));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genOperation.getFormattedName());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(genOperation.getFormattedName());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(genOperation.getParameterTypes(", "));
    stringBuffer.append(TEXT_268);
    } else {
    stringBuffer.append(TEXT_269);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_270);
    stringBuffer.append(genOperation.getImportedMetaType());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_272);
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(genClass.getLocalOperationIndex(genOperation));
    stringBuffer.append(TEXT_275);
    } else {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genClass.getLocalOperationIndex(genOperation));
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    } else {
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genOperation.getImportedMetaType());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_283);
    }
    }
    }
    }
    if (isInterface) {
    stringBuffer.append(TEXT_284);
    } else {
    stringBuffer.append(TEXT_285);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    stringBuffer.append(TEXT_287);
    stringBuffer.append(genPackage.getFactoryName());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    stringBuffer.append(TEXT_289);
    } else {
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genPackage.getFactoryInterfaceName());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genPackage.getFactoryName());
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    if (isImplementation) {
    if (!genPackage.isLoadedInitialization()) {
    stringBuffer.append(TEXT_294);
    if (!genPackage.getGenClasses().isEmpty()) {
    stringBuffer.append(TEXT_295);
    for (Iterator<GenClass> c=genPackage.getGenClasses().iterator(); c.hasNext();) { GenClass genClass = c.next();
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genClass.getMetaType());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(genClass.getClassifierID());
    stringBuffer.append(TEXT_299);
    for (GenFeature genFeature : genClass.getGenFeatures()) {
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genFeature.getMetaType());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genClass.getFeatureID(genFeature));
    stringBuffer.append(TEXT_303);
    }
    if (genModel.isOperationReflection()) {
    for (GenOperation genOperation : genClass.getGenOperations()) {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_305);
    stringBuffer.append(genClass.getOperationID(genOperation, false));
    stringBuffer.append(TEXT_306);
    }
    }
    if (c.hasNext()) {
    stringBuffer.append(TEXT_307);
    }
    }
    }
    if (!genPackage.getGenEnums().isEmpty()) {
    stringBuffer.append(TEXT_308);
    for (GenEnum genEnum : genPackage.getGenEnums()) {
    stringBuffer.append(TEXT_309);
    stringBuffer.append(genEnum.getClassifierInstanceName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(genEnum.getClassifierID());
    stringBuffer.append(TEXT_311);
    }
    }
    if (!genPackage.getGenDataTypes().isEmpty()) {
    stringBuffer.append(TEXT_312);
    for (GenDataType genDataType : genPackage.getGenDataTypes()) {
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genDataType.getClassifierInstanceName());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genDataType.getClassifierID());
    stringBuffer.append(TEXT_315);
    }
    }
    stringBuffer.append(TEXT_316);
    
///////////////////////
class Information
{
  @SuppressWarnings("unused")
  EGenericType eGenericType;
  int depth;
  String type;
  String accessor;
}

class InformationIterator
{
  Iterator<Object> iterator;
  InformationIterator(EGenericType eGenericType)
  {
    iterator = EcoreUtil.getAllContents(Collections.singleton(eGenericType));
  }

  boolean hasNext()
  {
    return iterator.hasNext();
  }

  Information next()
  {
    Information information = new Information();
    EGenericType eGenericType = information.eGenericType = (EGenericType)iterator.next();
    for (EObject container = eGenericType.eContainer(); container instanceof EGenericType; container = container.eContainer())
    {
      ++information.depth;
    }
    if (eGenericType.getEClassifier() != null )
    {
      GenClassifier genClassifier = genModel.findGenClassifier(eGenericType.getEClassifier());
      information.type = genPackage.getPackageInstanceVariable(genClassifier.getGenPackage()) + ".get" + genClassifier.getClassifierAccessorName() + "()";
    }
    else if (eGenericType.getETypeParameter() != null)
    {
      ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
      if (eTypeParameter.eContainer() instanceof EClass)
      {
        information.type = genModel.findGenClassifier((EClass)eTypeParameter.eContainer()).getClassifierInstanceName() + "_" + eGenericType.getETypeParameter().getName();
      }
      else
      {
        information.type = "t" + (((EOperation)eTypeParameter.eContainer()).getETypeParameters().indexOf(eTypeParameter) + 1);
      }
    }
    else
    {
      information.type ="";
    }
    if (information.depth > 0)
    {
      if (eGenericType.eContainmentFeature().isMany())
      {
        information.accessor = "getE" + eGenericType.eContainmentFeature().getName().substring(1) + "().add";
      }
      else
      {
        information.accessor = "setE" + eGenericType.eContainmentFeature().getName().substring(1);
      }
    }
    return information;
  }
}
///////////////////////
int maxGenericTypeAssignment = 0;

    stringBuffer.append(TEXT_317);
    if (!genPackage.getPackageInitializationDependencies().isEmpty()) {
    stringBuffer.append(TEXT_318);
    for (GenPackage dep : genPackage.getPackageInitializationDependencies()) {
    stringBuffer.append(TEXT_319);
    stringBuffer.append(dep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(genPackage.getPackageInstanceVariable(dep));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(dep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(dep.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_324);
    }
    }
    if (!genPackage.getSubGenPackages().isEmpty()) {
    stringBuffer.append(TEXT_325);
    for (GenPackage sub : genPackage.getSubGenPackages()) {
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genPackage.getPackageInstanceVariable(sub));
    stringBuffer.append(TEXT_327);
    }
    }
    if (!genPackage.getGenClasses().isEmpty()) { boolean firstOperationAssignment = true; int maxTypeParameterAssignment = 0;
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_328);
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    for (GenTypeParameter genTypeParameter : genClassifier.getGenTypeParameters()) {
    if (!genTypeParameter.getEcoreTypeParameter().getEBounds().isEmpty() || genTypeParameter.isUsed()) {
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.ETypeParameter"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genTypeParameter.getName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genTypeParameter.getName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_335);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genTypeParameter.getName());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    }
    }
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_338);
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    for (GenTypeParameter genTypeParameter : genClassifier.getGenTypeParameters()) {
    for (EGenericType bound : genTypeParameter.getEcoreTypeParameter().getEBounds()) {
    for (InformationIterator i=new InformationIterator(bound); i.hasNext(); ) { Information info = i.next(); String prefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; prefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_339);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_342);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_346);
    }
    }
    stringBuffer.append(TEXT_347);
    stringBuffer.append(genClassifier.getClassifierInstanceName());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genTypeParameter.getName());
    stringBuffer.append(TEXT_349);
    }
    }
    }
    }
    stringBuffer.append(TEXT_350);
    for (GenClass genClass : genPackage.getGenClasses()) {
    if (!genClass.hasGenericSuperTypes()) {
    for (GenClass baseGenClass : genClass.getBaseGenClasses()) {
    stringBuffer.append(TEXT_351);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_352);
    stringBuffer.append(genPackage.getPackageInstanceVariable(baseGenClass.getGenPackage()));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(baseGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_354);
    }
    } else {
    for (EGenericType superType : genClass.getEcoreClass().getEGenericSuperTypes()) {
    for (InformationIterator i=new InformationIterator(superType); i.hasNext(); ) { Information info = i.next(); String prefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; prefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_355);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_358);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_359);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_362);
    }
    }
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_364);
    }
    }
    }
    stringBuffer.append(TEXT_365);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_366);
    } else {
    stringBuffer.append(TEXT_367);
    }
    for (Iterator<GenClass> c=genPackage.getGenClasses().iterator(); c.hasNext();) { GenClass genClass = c.next(); boolean hasInstanceTypeName = genModel.useGenerics() && genClass.getEcoreClass().getInstanceTypeName() != null && genClass.getEcoreClass().getInstanceTypeName().contains("<");
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genClass.getClassifierInstanceName());
    stringBuffer.append(TEXT_369);
    if (genClass.isDynamic()) {
    stringBuffer.append(TEXT_370);
    } else {
    stringBuffer.append(genClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_371);
    }
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_373);
    stringBuffer.append(genClass.getAbstractFlag());
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genClass.getInterfaceFlag());
    stringBuffer.append(TEXT_375);
    stringBuffer.append(genClass.getGeneratedInstanceClassFlag());
    if (hasInstanceTypeName) {
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genClass.getEcoreClass().getInstanceTypeName());
    stringBuffer.append(TEXT_377);
    }
    stringBuffer.append(TEXT_378);
    stringBuffer.append(genModel.getNonNLS());
    if (hasInstanceTypeName) {
    stringBuffer.append(genModel.getNonNLS(2));
    }
    for (GenFeature genFeature : genClass.getGenFeatures()) {
    if (genFeature.hasGenericType()) {
    for (InformationIterator i=new InformationIterator(genFeature.getEcoreFeature().getEGenericType()); i.hasNext(); ) { Information info = i.next(); String prefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; prefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_379);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_382);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_386);
    }
    }
    }
    if (genFeature.isReferenceType()) { GenFeature reverseGenFeature = genFeature.getReverse();
    String reverse = reverseGenFeature == null ? "null" : genPackage.getPackageInstanceVariable(reverseGenFeature.getGenPackage()) + ".get" + reverseGenFeature.getFeatureAccessorName() + "()";
    stringBuffer.append(TEXT_387);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_388);
    if (genFeature.hasGenericType()) {
    stringBuffer.append(TEXT_389);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(genFeature.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    stringBuffer.append(reverse);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_394);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_395);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_398);
    stringBuffer.append(genFeature.getTransientFlag());
    stringBuffer.append(TEXT_399);
    stringBuffer.append(genFeature.getVolatileFlag());
    stringBuffer.append(TEXT_400);
    stringBuffer.append(genFeature.getChangeableFlag());
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genFeature.getContainmentFlag());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(genFeature.getResolveProxiesFlag());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getUnsettableFlag());
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genFeature.getUniqueFlag());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genFeature.getDerivedFlag());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(genFeature.getOrderedFlag());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(genFeature.getDefaultValue(), 2));
    for (GenFeature keyFeature : genFeature.getKeys()) {
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genPackage.getPackageInstanceVariable(keyFeature.getGenPackage()));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(keyFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_411);
    }
    } else {
    stringBuffer.append(TEXT_412);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_413);
    if (genFeature.hasGenericType()) {
    stringBuffer.append(TEXT_414);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genFeature.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_416);
    }
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_421);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_422);
    stringBuffer.append(genFeature.getTransientFlag());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(genFeature.getVolatileFlag());
    stringBuffer.append(TEXT_424);
    stringBuffer.append(genFeature.getChangeableFlag());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genFeature.getUnsettableFlag());
    stringBuffer.append(TEXT_426);
    stringBuffer.append(genFeature.getIDFlag());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genFeature.getUniqueFlag());
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genFeature.getDerivedFlag());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(genFeature.getOrderedFlag());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(genFeature.getDefaultValue(), 2));
    }
    }
    for (GenOperation genOperation : genClass.getGenOperations()) {String prefix = ""; if (genOperation.hasGenericType() || !genOperation.getGenParameters().isEmpty() || !genOperation.getGenExceptions().isEmpty() || !genOperation.getGenTypeParameters().isEmpty()) { if (firstOperationAssignment) { firstOperationAssignment = false; prefix = genModel.getImportedName("org.eclipse.emf.ecore.EOperation") + " op = "; } else { prefix = "op = "; }} 
    stringBuffer.append(TEXT_431);
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_432);
    stringBuffer.append(prefix);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_434);
    } else {
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genClass.getClassifierInstanceName());
    }
    stringBuffer.append(TEXT_436);
    if (genOperation.isVoid() || genOperation.hasGenericType()) {
    stringBuffer.append(TEXT_437);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genOperation.getTypeGenPackage()));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genOperation.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_439);
    }
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(genOperation.getLowerBound());
    stringBuffer.append(TEXT_442);
    stringBuffer.append(genOperation.getUpperBound());
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genOperation.getUniqueFlag());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genOperation.getOrderedFlag());
    stringBuffer.append(TEXT_445);
    stringBuffer.append(genModel.getNonNLS());
    } else if (!genOperation.isVoid()) {
    if (!genOperation.getEcoreOperation().isOrdered() || !genOperation.getEcoreOperation().isUnique()) { needsAddEOperation = true;
    stringBuffer.append(TEXT_446);
    stringBuffer.append(prefix);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_448);
    } else {
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genClass.getClassifierInstanceName());
    }
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genPackage.getPackageInstanceVariable(genOperation.getTypeGenPackage()));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(genOperation.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genOperation.getLowerBound());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(genOperation.getUpperBound());
    stringBuffer.append(TEXT_455);
    stringBuffer.append(genOperation.getUniqueFlag());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(genOperation.getOrderedFlag());
    stringBuffer.append(TEXT_457);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_458);
    stringBuffer.append(prefix);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_460);
    } else {
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genClass.getClassifierInstanceName());
    }
    stringBuffer.append(TEXT_462);
    stringBuffer.append(genPackage.getPackageInstanceVariable(genOperation.getTypeGenPackage()));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(genOperation.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_464);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_465);
    stringBuffer.append(genOperation.getLowerBound());
    stringBuffer.append(TEXT_466);
    stringBuffer.append(genOperation.getUpperBound());
    stringBuffer.append(TEXT_467);
    stringBuffer.append(genModel.getNonNLS());
    }
    } else {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(prefix);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_469);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_470);
    } else {
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genClass.getClassifierInstanceName());
    }
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genModel.useGenerics()) {
    for (ListIterator<GenTypeParameter> t=genOperation.getGenTypeParameters().listIterator(); t.hasNext(); ) { GenTypeParameter genTypeParameter = t.next(); String typeParameterVariable = ""; if (!genTypeParameter.getEcoreTypeParameter().getEBounds().isEmpty() || genTypeParameter.isUsed()) { if (maxTypeParameterAssignment <= t.previousIndex()) { ++maxTypeParameterAssignment; typeParameterVariable = genModel.getImportedName("org.eclipse.emf.ecore.ETypeParameter") + " t" + t.nextIndex() + " = "; } else { typeParameterVariable = "t" + t.nextIndex() + " = "; }} 
    stringBuffer.append(TEXT_474);
    stringBuffer.append(typeParameterVariable);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(genTypeParameter.getName());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genModel.getNonNLS());
    for (EGenericType typeParameter : genTypeParameter.getEcoreTypeParameter().getEBounds()) {
    for (InformationIterator i=new InformationIterator(typeParameter); i.hasNext(); ) { Information info = i.next(); String typePrefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; typePrefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_477);
    stringBuffer.append(typePrefix);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_480);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_484);
    }
    }
    stringBuffer.append(TEXT_485);
    stringBuffer.append(t.nextIndex());
    stringBuffer.append(TEXT_486);
    }
    }
    }
    for (GenParameter genParameter : genOperation.getGenParameters()) {
    if (genParameter.hasGenericType()) {
    for (InformationIterator i=new InformationIterator(genParameter.getEcoreParameter().getEGenericType()); i.hasNext(); ) { Information info = i.next(); String typePrefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; typePrefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_487);
    stringBuffer.append(typePrefix);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_490);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_491);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_494);
    }
    }
    }
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_495);
    if (genParameter.hasGenericType()){
    stringBuffer.append(TEXT_496);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genParameter.getTypeGenPackage()));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(genParameter.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_498);
    }
    stringBuffer.append(TEXT_499);
    stringBuffer.append(genParameter.getName());
    stringBuffer.append(TEXT_500);
    stringBuffer.append(genParameter.getLowerBound());
    stringBuffer.append(TEXT_501);
    stringBuffer.append(genParameter.getUpperBound());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genParameter.getUniqueFlag());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genParameter.getOrderedFlag());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(genModel.getNonNLS());
    } else if (!genParameter.getEcoreParameter().isOrdered() || !genParameter.getEcoreParameter().isUnique()) { needsAddEParameter = true;
    stringBuffer.append(TEXT_505);
    if (genParameter.hasGenericType()){
    stringBuffer.append(TEXT_506);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genParameter.getTypeGenPackage()));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genParameter.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_508);
    }
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genParameter.getName());
    stringBuffer.append(TEXT_510);
    stringBuffer.append(genParameter.getLowerBound());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(genParameter.getUpperBound());
    stringBuffer.append(TEXT_512);
    stringBuffer.append(genParameter.getUniqueFlag());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genParameter.getOrderedFlag());
    stringBuffer.append(TEXT_514);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_515);
    if (genParameter.hasGenericType()){
    stringBuffer.append(TEXT_516);
    } else {
    stringBuffer.append(genPackage.getPackageInstanceVariable(genParameter.getTypeGenPackage()));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genParameter.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_518);
    }
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genParameter.getName());
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genParameter.getLowerBound());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genParameter.getUpperBound());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    if (genOperation.hasGenericExceptions()) {
    for (EGenericType genericExceptions : genOperation.getEcoreOperation().getEGenericExceptions()) {
    for (InformationIterator i=new InformationIterator(genericExceptions); i.hasNext(); ) { Information info = i.next(); String typePrefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; typePrefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_523);
    stringBuffer.append(typePrefix);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_526);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_527);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_530);
    }
    stringBuffer.append(TEXT_531);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_532);
    }
    }
    } else {
    for (GenClassifier genException : genOperation.getGenExceptions()) {
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genPackage.getPackageInstanceVariable(genException.getGenPackage()));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genException.getClassifierAccessorName());
    stringBuffer.append(TEXT_535);
    }
    }
    if (!genOperation.isVoid() && genOperation.hasGenericType()) {
    for (InformationIterator i=new InformationIterator(genOperation.getEcoreOperation().getEGenericType()); i.hasNext(); ) { Information info = i.next(); String typePrefix = ""; if (maxGenericTypeAssignment <= info.depth) { ++maxGenericTypeAssignment; typePrefix = genModel.getImportedName("org.eclipse.emf.ecore.EGenericType") + " "; }
    stringBuffer.append(TEXT_536);
    stringBuffer.append(typePrefix);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(info.type);
    stringBuffer.append(TEXT_539);
    if (info.depth > 0) {
    stringBuffer.append(TEXT_540);
    stringBuffer.append(info.depth);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(info.accessor);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(info.depth + 1);
    stringBuffer.append(TEXT_543);
    }
    }
    stringBuffer.append(TEXT_544);
    }
    }
    if (c.hasNext()) {
    stringBuffer.append(TEXT_545);
    }
    }
    }
    if (!genPackage.getGenEnums().isEmpty()) {
    stringBuffer.append(TEXT_546);
    for (Iterator<GenEnum> e=genPackage.getGenEnums().iterator(); e.hasNext();) { GenEnum genEnum = e.next();
    stringBuffer.append(TEXT_547);
    stringBuffer.append(genEnum.getClassifierInstanceName());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(genEnum.getImportedName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genModel.getNonNLS());
    for (GenEnumLiteral genEnumLiteral : genEnum.getGenEnumLiterals()) {
    stringBuffer.append(TEXT_551);
    stringBuffer.append(genEnum.getClassifierInstanceName());
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genEnum.getImportedName().equals(genEnum.getClassifierID()) ? genEnum.getQualifiedName() : genEnum.getImportedName());
    stringBuffer.append(TEXT_553);
    stringBuffer.append(genEnumLiteral.getEnumLiteralInstanceConstantName());
    stringBuffer.append(TEXT_554);
    }
    if (e.hasNext()) {
    stringBuffer.append(TEXT_555);
    }
    }
    }
    if (!genPackage.getGenDataTypes().isEmpty()) {
    stringBuffer.append(TEXT_556);
    for (GenDataType genDataType : genPackage.getGenDataTypes()) {boolean hasInstanceTypeName = genModel.useGenerics() && genDataType.getEcoreDataType().getInstanceTypeName() != null && genDataType.getEcoreDataType().getInstanceTypeName().contains("<");
    stringBuffer.append(TEXT_557);
    stringBuffer.append(genDataType.getClassifierInstanceName());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(genDataType.getRawImportedInstanceClassName());
    stringBuffer.append(TEXT_559);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_560);
    stringBuffer.append(genDataType.getSerializableFlag());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(genDataType.getGeneratedInstanceClassFlag());
    if (hasInstanceTypeName) {
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genDataType.getEcoreDataType().getInstanceTypeName());
    stringBuffer.append(TEXT_563);
    }
    stringBuffer.append(TEXT_564);
    stringBuffer.append(genModel.getNonNLS());
    if (hasInstanceTypeName) {
    stringBuffer.append(genModel.getNonNLS(2));
    }
    }
    }
    if (genPackage.getSuperGenPackage() == null) {
    stringBuffer.append(TEXT_565);
    stringBuffer.append(genPackage.getSchemaLocation());
    stringBuffer.append(TEXT_566);
    }
    if (!genPackage.isEcorePackage() && !genPackage.getAnnotationSources().isEmpty()) {
    stringBuffer.append(TEXT_567);
    for (String annotationSource : genPackage.getAnnotationSources()) {
    stringBuffer.append(TEXT_568);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(genPackage.getAnnotationSourceIdentifier(annotationSource));
    stringBuffer.append(TEXT_570);
    }
    }
    stringBuffer.append(TEXT_571);
    for (String annotationSource : genPackage.getAnnotationSources()) {
    stringBuffer.append(TEXT_572);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(genPackage.getAnnotationSourceIdentifier(annotationSource));
    stringBuffer.append(TEXT_574);
    if (annotationSource == null) {
    stringBuffer.append(TEXT_575);
    } else {
    stringBuffer.append(TEXT_576);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genModel.getNonNLS());
    }
    for (EAnnotation eAnnotation : genPackage.getAllAnnotations()) { List<GenPackage.AnnotationReferenceData> annotationReferenceDataList = genPackage.getReferenceData(eAnnotation);
    if (annotationSource == null ? eAnnotation.getSource() == null : annotationSource.equals(eAnnotation.getSource())) {
    stringBuffer.append(TEXT_578);
    stringBuffer.append(genPackage.getAnnotatedModelElementAccessor(eAnnotation));
    stringBuffer.append(TEXT_579);
    for (Iterator<Map.Entry<String, String>> k = eAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry<String, String> detail = k.next(); String key = Literals.toStringLiteral(detail.getKey(), genModel); String value = Literals.toStringLiteral(detail.getValue(), genModel);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(value);
    stringBuffer.append(k.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    stringBuffer.append(TEXT_582);
    if (annotationReferenceDataList.isEmpty()) {
    stringBuffer.append(TEXT_583);
    } else {
    stringBuffer.append(TEXT_584);
    }
    if (!annotationReferenceDataList.isEmpty()) {
    stringBuffer.append(TEXT_585);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_586);
    for (Iterator<GenPackage.AnnotationReferenceData> k = annotationReferenceDataList.iterator(); k.hasNext();) { GenPackage.AnnotationReferenceData annotationReferenceData = k.next();
    stringBuffer.append(TEXT_587);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_588);
    if (annotationReferenceData.containingGenPackage != genPackage) {
    stringBuffer.append(annotationReferenceData.containingGenPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_589);
    }
    stringBuffer.append(TEXT_590);
    stringBuffer.append(annotationReferenceData.uriFragment);
    stringBuffer.append(TEXT_591);
    if (k.hasNext()) {
    stringBuffer.append(TEXT_592);
    }
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_593);
    }
    for (EAnnotation nestedEAnnotation : genPackage.getAllNestedAnnotations(eAnnotation)) {String nestedAnnotationSource = nestedEAnnotation.getSource();  int depth = 0; boolean nonContentAnnotation = false; StringBuilder path = new StringBuilder();  for (EObject eContainer = nestedEAnnotation.eContainer(), child = nestedEAnnotation; child != eAnnotation; child = eContainer, eContainer = eContainer.eContainer())  {  boolean nonContentChild = child.eContainmentFeature() != EcorePackage.Literals.EANNOTATION__CONTENTS; if (path.length() != 0) { path.insert(0, ", ");  } path.insert(0, nonContentChild); if (nonContentChild) { nonContentAnnotation = true; } ++depth;  } List<GenPackage.AnnotationReferenceData> nestedAnnotationReferenceDataList = genPackage.getReferenceData(nestedEAnnotation);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(genPackage.getAnnotatedModelElementAccessor(eAnnotation));
    stringBuffer.append(TEXT_595);
    if (nonContentAnnotation && genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF210_VALUE) {
    stringBuffer.append(TEXT_596);
    stringBuffer.append(path.toString());
    stringBuffer.append(TEXT_597);
    } else {
    stringBuffer.append(depth);
    }
    stringBuffer.append(TEXT_598);
    if (nestedAnnotationSource == null) {
    stringBuffer.append(TEXT_599);
    } else {
    stringBuffer.append(TEXT_600);
    stringBuffer.append(nestedAnnotationSource);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_602);
    for (Iterator<Map.Entry<String, String>> l = nestedEAnnotation.getDetails().iterator(); l.hasNext();) { Map.Entry<String, String> detail = l.next(); String key = Literals.toStringLiteral(detail.getKey(), genModel); String value = Literals.toStringLiteral(detail.getValue(), genModel);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(value);
    stringBuffer.append(l.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    stringBuffer.append(TEXT_605);
    if (nestedAnnotationReferenceDataList.isEmpty()) {
    stringBuffer.append(TEXT_606);
    } else {
    stringBuffer.append(TEXT_607);
    }
    if (!nestedAnnotationReferenceDataList.isEmpty()) {
    stringBuffer.append(TEXT_608);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_609);
    for (Iterator<GenPackage.AnnotationReferenceData> l = nestedAnnotationReferenceDataList.iterator(); l.hasNext();) { GenPackage.AnnotationReferenceData annotationReferenceData = l.next();
    stringBuffer.append(TEXT_610);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_611);
    if (annotationReferenceData.containingGenPackage != genPackage) {
    stringBuffer.append(annotationReferenceData.containingGenPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_612);
    }
    stringBuffer.append(TEXT_613);
    stringBuffer.append(annotationReferenceData.uriFragment);
    stringBuffer.append(TEXT_614);
    if (l.hasNext()) {
    stringBuffer.append(TEXT_615);
    }
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_616);
    }
    }
    }
    }
    stringBuffer.append(TEXT_617);
    }
    } else {
    if (genPackage.isLoadingInitialization()) {
    stringBuffer.append(TEXT_618);
    stringBuffer.append(genModel.getImportedName("java.net.URL"));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl"));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(genModel.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.WrappedException"));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_627);
    }
    stringBuffer.append(TEXT_628);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_629);
    }
    stringBuffer.append(TEXT_630);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_631);
    ArrayList<GenClass> dynamicGenClasses = new ArrayList<GenClass>(); for (GenClass genClass : genPackage.getGenClasses()) { if (genClass.isDynamic()) { dynamicGenClasses.add(genClass); } }
    if (dynamicGenClasses.isEmpty()) {
    stringBuffer.append(TEXT_632);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_634);
    } else {
    stringBuffer.append(TEXT_635);
    for (GenClass genClass : dynamicGenClasses) {
    if (genClass.isDynamic()) {
    stringBuffer.append(TEXT_636);
    stringBuffer.append(genPackage.getClassifierID(genClass));
    stringBuffer.append(TEXT_637);
    }
    }
    stringBuffer.append(TEXT_638);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_639);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_640);
    }
    stringBuffer.append(TEXT_641);
    }
    if (needsAddEOperation) {
    stringBuffer.append(TEXT_642);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
    stringBuffer.append(TEXT_646);
    }
    if (needsAddEParameter) {
    stringBuffer.append(TEXT_647);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EParameter"));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EParameter"));
    stringBuffer.append(TEXT_651);
    }
    }
    if (isInterface && genPackage.isLiteralsInterface()) {
    stringBuffer.append(TEXT_652);
    if (genModel.isOperationReflection()) {
    stringBuffer.append(TEXT_653);
    }
    stringBuffer.append(TEXT_654);
    if (isImplementation) {
    stringBuffer.append(TEXT_655);
    }
    stringBuffer.append(TEXT_656);
    for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
    stringBuffer.append(TEXT_657);
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    if (!genClass.isInterface()) {
    stringBuffer.append(TEXT_658);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_659);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_660);
    stringBuffer.append(genClass.getQualifiedClassName());
    } else {
    stringBuffer.append(TEXT_661);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_662);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_663);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    }
    } else if (genClassifier instanceof GenEnum) { GenEnum genEnum = (GenEnum)genClassifier;
    stringBuffer.append(TEXT_664);
    stringBuffer.append(genEnum.getQualifiedName());
    stringBuffer.append(TEXT_665);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_666);
    stringBuffer.append(genEnum.getQualifiedName());
    } else if (genClassifier instanceof GenDataType) { GenDataType genDataType = (GenDataType)genClassifier;
    stringBuffer.append(TEXT_667);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_668);
    if (!genDataType.isPrimitiveType() && !genDataType.isArrayType()) {
    stringBuffer.append(TEXT_669);
    stringBuffer.append(genDataType.getRawInstanceClassName());
    }
    }
    stringBuffer.append(TEXT_670);
    stringBuffer.append(genPackage.getQualifiedPackageClassName());
    stringBuffer.append(TEXT_671);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_672);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genClassifier.getImportedMetaType());
    stringBuffer.append(TEXT_673);
    stringBuffer.append(genPackage.getClassifierID(genClassifier));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_675);
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass)genClassifier;
    for (GenFeature genFeature : genClass.getGenFeatures()) {
    stringBuffer.append(TEXT_676);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_677);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_678);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genFeature.getImportedMetaType());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(genClass.getFeatureID(genFeature));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_681);
    }
    if (genModel.isOperationReflection()) {
    for (GenOperation genOperation : genClass.getGenOperations()) {
    stringBuffer.append(TEXT_682);
    stringBuffer.append(genOperation.getFormattedName());
    stringBuffer.append(TEXT_683);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genOperation.getImportedMetaType());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(genClass.getOperationID(genOperation, false));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(genOperation.getOperationAccessorName());
    stringBuffer.append(TEXT_686);
    }
    }
    }
    }
    stringBuffer.append(TEXT_687);
    }
    stringBuffer.append(TEXT_688);
    stringBuffer.append(isInterface ? genPackage.getPackageInterfaceName() : genPackage.getPackageClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_689);
    return stringBuffer.toString();
  }
}
