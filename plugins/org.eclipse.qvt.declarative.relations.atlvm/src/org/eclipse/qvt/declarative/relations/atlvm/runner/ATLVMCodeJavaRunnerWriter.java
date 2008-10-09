/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ATLVMCodeJavaRunnerWriter.java,v 1.2 2008/10/09 17:21:06 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.runner;

import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import java.util.Iterator;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

public class ATLVMCodeJavaRunnerWriter
{
  protected static String nl;
  public static synchronized ATLVMCodeJavaRunnerWriter create(String lineSeparator)
  {
    nl = lineSeparator;
    ATLVMCodeJavaRunnerWriter result = new ATLVMCodeJavaRunnerWriter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2008 Obeo." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * Contributors:" + NL + " *     Obeo - initial API and implementation" + NL + " *******************************************************************************/";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "import java.io.File;" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.qvt.declarative.execution.ExecutionContext;" + NL + "import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;" + NL + "import org.eclipse.qvt.declarative.execution.ExecutionContextFactory;" + NL + "import org.eclipse.qvt.declarative.execution.ExecutionProvider;" + NL + "import org.eclipse.qvt.declarative.execution.LabelledModel;" + NL + "import org.eclipse.qvt.declarative.execution.LabelledModelFactory;" + NL + "import org.eclipse.qvt.declarative.relations.atlvm.ATLVMExecutor;" + NL + "" + NL + "public class ";
  protected final String TEXT_5 = " {";
  protected final String TEXT_6 = NL + "\tprotected static final File ";
  protected final String TEXT_7 = "DirectionASMFile = new File(";
  protected final String TEXT_8 = ".class.getResource(\"";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ".asm\").getFile());" + NL + "\t";
  protected final String TEXT_11 = NL + NL + "\tpublic enum Direction {";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = "}" + NL + "" + NL + "\tpublic static List<?> executeByATLVM (ExecutionContext parameters) {" + NL + "\t\tExecutionProvider provider = new ATLVMExecutor();" + NL + "\t\tswitch (Direction.valueOf(parameters.getDirectionModel().getName())){" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\tcase ";
  protected final String TEXT_15 = " : return provider.execute(";
  protected final String TEXT_16 = "DirectionASMFile, parameters);" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\tpublic static List<?> executeByATLVM (";
  protected final String TEXT_18 = "String ";
  protected final String TEXT_19 = "FileURI, String ";
  protected final String TEXT_20 = "MetamodelURI, ";
  protected final String TEXT_21 = "Direction direction, ExecutionMode executionMode) {" + NL + "\t\tList<LabelledModel> inputModels = new ArrayList<LabelledModel>();" + NL + "\t\tLabelledModel outputModel = null;" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tLabelledModel ";
  protected final String TEXT_23 = "MetaModel = LabelledModelFactory.INSTANCE.createLabelledMetamodel(\"";
  protected final String TEXT_24 = "\", ";
  protected final String TEXT_25 = "MetamodelURI);" + NL + "\t\tLabelledModel ";
  protected final String TEXT_26 = "Model = LabelledModelFactory.INSTANCE.createLabelledModel(\"";
  protected final String TEXT_27 = "\", ";
  protected final String TEXT_28 = "FileURI, ";
  protected final String TEXT_29 = "MetaModel);" + NL + "\t\tif (!Direction.valueOf(";
  protected final String TEXT_30 = "Model.getName()).equals(direction)) {" + NL + "\t\t\tinputModels.add(";
  protected final String TEXT_31 = "Model);" + NL + "\t\t} else {" + NL + "\t\t\toutputModel = ";
  protected final String TEXT_32 = "Model;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\tExecutionContext executionContext = ExecutionContextFactory.INSTANCE.createExecutionContext(inputModels, outputModel, executionMode);" + NL + "\t\treturn executeByATLVM(executionContext);\t" + NL + "\t}" + NL + "}";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    ATLVMCodeJavaRunnerWriterParameters parameter = (ATLVMCodeJavaRunnerWriterParameters) argument; 
    RelationalTransformation transformation = parameter.getTransformation(); 
    stringBuffer.append(TEXT_1);
    if(parameter.getBasePackage().length() > 0) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(parameter.getBasePackage());
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(parameter.getClassName());
    stringBuffer.append(TEXT_5);
    for (TypedModel model : transformation.getModelParameter()) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(parameter.getClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(parameter.getASMFileName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    for (Iterator<TypedModel> iterator = transformation.getModelParameter().iterator(); iterator.hasNext();) {
    stringBuffer.append(iterator.next().getName());
    if (iterator.hasNext()) {
    stringBuffer.append(TEXT_12);
    }
    }
    stringBuffer.append(TEXT_13);
    for (TypedModel model : transformation.getModelParameter()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    for (TypedModel model : transformation.getModelParameter()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    for (TypedModel model : transformation.getModelParameter()) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(model.getUsedPackage().get(0).getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(model.getName());
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
