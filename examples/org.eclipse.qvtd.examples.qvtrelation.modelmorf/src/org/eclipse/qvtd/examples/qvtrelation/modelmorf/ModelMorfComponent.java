/*******************************************************************************
 * Copyright (c) 2014 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.examples.qvtrelation.modelmorf;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

public class ModelMorfComponent implements IWorkflowComponent {
	
	private static final String METAMODEL_ALIAS = "-m";
	private static final String METAMODEL_FILE = "-mf";
	private static final String METAMODEL_REFERENCE = "-mi";
	private static final String QVT_SPECIFICATION_FILE = "-c";
	private static final String IMPORTED_QVT_FILE_DIR = "-qp";
	private static final String MODEL_VARIABLE = "-u";
	private static final String MODEL_FILE = "-f";
	private static final String MODEL_REFERENCE = "-ui";
	private static final String MODEL_DELTA = "-df";
	private static final String TRANSFORMATION_NAME = "-t";
	private static final String TOP_RELATION_NAME = "-r";
	private static final String DIRECTION_DOMAIN = "-d";
	private static final String DOMAIN_QUALIFIER = "-q";
	private static final String TRACE_OUTPUT_FILE = "-tox";
	private static final String TRACE_INPUT_FILE = "-tix";
	private static final String INCREMENTAL = "-it";
	
	private String java15Path;				// Path to Java 1.5 bin folder
	private String modelMorfPath;			// Path to ModelMorf Installation
	private String javaCommand = "java";	// Java command
	
	private List<MetamodelEntry> metamodels; 
	private List<String> importedQvtFileDir; 
	private List<ModelEntry> models;  
	
	private String qvtSpecificationFile; 
	private String transformationName;	
	private String topRelationName;
	private String directionDomain;		
	private String domainQualifier;		 
	private String traceOutputFile;		
	private String traceInputFile;
	private boolean incremental;

	
	
	public ModelMorfComponent() {
		metamodels = new ArrayList<MetamodelEntry>();
		models = new ArrayList<ModelEntry>();
		importedQvtFileDir = new ArrayList<String>();
	}

	public void preInvoke() {
		// TODO Auto-generated method stub
		
	}

	public void invoke(IWorkflowContext ctx) {
		// TODO test all parameters are correct and required values set
		
		List<String> arguments = new ArrayList<String>();
		StringBuilder argBuilder = new StringBuilder();
		// Create the java arguments
		argBuilder.append(java15Path);
		if (!java15Path.endsWith("\\")) {
			argBuilder.append("\\");
		}
		argBuilder.append(javaCommand);
		arguments.add(argBuilder.toString());
		argBuilder.setLength(0);
		arguments.add("-jar");
		argBuilder.append(modelMorfPath);
		if (!modelMorfPath.endsWith("\\")) {
			argBuilder.append("\\");
		}
		argBuilder.append("qvt.jar");
		arguments.add(argBuilder.toString());
		argBuilder.setLength(0);
		arguments.add("-p");
		arguments.add(modelMorfPath);
		// ( -m meta_model_alias ( -mf meta_model_file | -mi meta_model_ref ) )+
		Iterator<MetamodelEntry> mmit = metamodels.iterator();
	    while (mmit.hasNext()) {
	    	MetamodelEntry entry = mmit.next();
	    	arguments.add(METAMODEL_ALIAS);
	    	arguments.add(entry.getAlias());
	    	if (entry.isRelative()) {
	    		arguments.add(METAMODEL_REFERENCE);
				arguments.add(entry.getReference());
	    	} else {
	    		arguments.add(METAMODEL_FILE);
	    		arguments.add(entry.getFile());
	    	}
	    }
	    // -c qvt_specification_file 
	    arguments.add(QVT_SPECIFICATION_FILE);
	    arguments.add(getQvtSpecificationFile());
		// [ -qp imported_qvt_file_dir ( ';' imported_qvt_file_dir )* ] 
		if (!importedQvtFileDir.isEmpty()) {
			arguments.add(IMPORTED_QVT_FILE_DIR);
			Iterator<String> lIt = importedQvtFileDir.iterator();
			while(lIt.hasNext()) {
				argBuilder.append(lIt.next());
				if (lIt.hasNext()) {
					argBuilder.append(";");
				}
			}
			arguments.add(argBuilder.toString());
			argBuilder.setLength(0);
		}
		// ( -u model_variable ( -f instance_model_file | -ui model_variable_ref ) [ -df model_delta_file ] )+ 
		Iterator<ModelEntry> mit = models.iterator();
	    while (mit.hasNext()) {
	    	ModelEntry entry = mit.next();
	    	arguments.add(MODEL_VARIABLE);
	    	arguments.add(entry.getVariable());
			if (entry.isBound()) {
				arguments.add(MODEL_REFERENCE);
				arguments.add(entry.getVariableRef());
			} else {
				arguments.add(MODEL_FILE);
				arguments.add(entry.getFile());
			}
			if (entry.hasDelta()) {
				arguments.add(MODEL_DELTA);
				arguments.add(entry.getDeltaFile());
			}
	    }
	    // -t transformation_name [-r top_relation_name ] 
	    arguments.add(TRANSFORMATION_NAME);
	    arguments.add(getTransformationName());
		if (getTopRelationName() != null) {
			arguments.add(TOP_RELATION_NAME);
			arguments.add(getTransformationName());
		}
		// -d direction_domain -q domain_qualifier 
		arguments.add(DIRECTION_DOMAIN);
		arguments.add(getDirectionDomain());
		arguments.add(DOMAIN_QUALIFIER);
		arguments.add(getDomainQualifier());
		//[ -tox trace_output_file ] [ -tix trace_input_file ] [ -it ]
		if (getTraceOutputFile() != null) {
			arguments.add(TRACE_OUTPUT_FILE);
			arguments.add(getTraceOutputFile());
		}
		if (getTraceInputFile() != null) {
			arguments.add(TRACE_INPUT_FILE);
			arguments.add(getTraceOutputFile());
		}
		if (isIncremental()) {
			arguments.add(INCREMENTAL);
		}
		
		ProcessBuilder probuilder  = new ProcessBuilder(arguments);
		//process.redirectErrorStream(true);
		File dir = new File("C:/git/org.eclipse.qvtd/examples/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/org/eclipse/qvtd/examples/qvtrelation/modelmorf/hstmtostm");
		probuilder .directory(dir);
		System.out.println(probuilder .directory());
		probuilder.redirectErrorStream(true);
		try {
			Process process = probuilder .start();
			//Read out dir output
	        InputStream is = process.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	        System.out.printf("Running ModelMorf with the given parameters.");
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postInvoke() {
		// TODO Auto-generated method stub

	}
	
	public String getJava15Path() {
		return java15Path;
	}

	public void setJava15Path(String java15Path) {
		this.java15Path = java15Path;
	}

	public String getModelMorfPath() {
		return modelMorfPath;
	}

	public void setModelMorfPath(String modelMorfPath) {
		this.modelMorfPath = modelMorfPath;
	}

	public String getJavaCommand() {
		return javaCommand;
	}

	public void setJavaCommand(String javaCommand) {
		this.javaCommand = javaCommand;
	}

	public String getQvtSpecificationFile() {
		return qvtSpecificationFile;
	}

	public void setQvtSpecificationFile(String qvtSpecificationFile) {
		this.qvtSpecificationFile = qvtSpecificationFile;
	}

	public String getTransformationName() {
		return transformationName;
	}

	public void setTransformationName(String transformationName) {
		this.transformationName = transformationName;
	}

	public String getTopRelationName() {
		return topRelationName;
	}

	public void setTopRelationName(String topRelationName) {
		this.topRelationName = topRelationName;
	}

	public String getDirectionDomain() {
		return directionDomain;
	}

	public void setDirectionDomain(String directionDomain) {
		this.directionDomain = directionDomain;
	}

	public String getDomainQualifier() {
		return domainQualifier;
	}

	public void setDomainQualifier(String domainQualifier) {
		this.domainQualifier = domainQualifier;
	}

	public String getTraceOutputFile() {
		return traceOutputFile;
	}

	public void setTraceOutputFile(String traceOutputFile) {
		this.traceOutputFile = traceOutputFile;
	}

	public String getTraceInputFile() {
		return traceInputFile;
	}

	public void setTraceInputFile(String traceInputFile) {
		this.traceInputFile = traceInputFile;
	}

	public boolean isIncremental() {
		return incremental;
	}

	public void setIncremental(boolean incremental) {
		this.incremental = incremental;
	}
	
	public void addMetamodel(MetamodelEntry metamodel){
		metamodels.add(metamodel);
	} 
	
	public void addImportedQvtFileDir(String fileDir){
		importedQvtFileDir.add(fileDir);
	} 
	
	public void addModel(ModelEntry model) {
		models.add(model);
	}  
	
}
