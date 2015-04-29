/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.mwe;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.cs2as.compiler.OCL2QVTiBroker;
import org.eclipse.qvtd.cs2as.compiler.qvti.CS2ASJavaCGParameters;
import org.eclipse.qvtd.cs2as.compiler.qvti.CS2ASJavaCompiler;
import org.eclipse.qvtd.cs2as.compiler.qvti.QVTiFacade;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

import com.google.common.base.Objects;

public  class GenerateCGedQVTiTransformation extends AbstractWorkflowComponent
{
	private final static @NonNull String BACKSLASH = "/";
	private final static @NonNull String EMPTY_STRING = "";

	protected static boolean isDefined(final String string) {
		return (!Objects.equal(string, null));
	}
	
	protected String projectName;
	protected String oclFileURI;
	protected ResourceSet resourceSet;
	protected String javaFolder = "src-gen/";
	protected String javaPackage = "";
	protected String envClassName;
	protected String visitorClassName;
	protected String namedElementItfName;
	protected Map<?, ?> savingOptions;

	public void checkConfiguration(final Issues issues) {
		if (!isDefined(oclFileURI)) {
			issues.addError(this, "OCL document URI not specified.");
		}
		
		if (!isDefined(envClassName)) {
			issues.addError(this, "Fully qualified name of the Environment java class not specified.");
		}
		
		if (!isDefined(visitorClassName)) {
			issues.addError(this, "Fully qualified name of the Loookup Visitor java class not specified");
		}
		
		if (!isDefined(namedElementItfName)) {
			issues.addError(this, "Fully qualified name of the Named Element interface not specified");
		}
	}
	
	 

	protected void doSetup() {
		CompleteOCLStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
	}
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		doSetup();
		QVTiFacade qvt = QVTiFacade.createInstance(BasicProjectManager.CLASS_PATH, resourceSet);
		URI oclDocURI = URI.createURI(oclFileURI);

		PivotModel qvtiTransf;
		try {
			qvtiTransf = executeOCL2QVTi_MTC(qvt, oclDocURI.trimSegments(1), oclDocURI.lastSegment());
			CS2ASJavaCGParameters cgParams = createParameters();
			createCompiler().compileTransformation(qvt, qvtiTransf.getTransformation(), cgParams);
		} catch (Exception e) {
			issues.addError(this, "Error while executing " + GenerateCGedQVTiTransformation.class.getName(), null, e, null);
		}	
						
		qvt.dispose();
	}

	protected CS2ASJavaCompiler createCompiler() {
		return new CS2ASJavaCompiler();
	}
	
	protected CS2ASJavaCGParameters createParameters() {
		return new CS2ASJavaCGParameters(envClassName, visitorClassName, namedElementItfName, javaFolder, javaPackage);
	}

	/**
	 * (Optional) The folder within the project that forms the root of EMF
	 * generated sources. (default is "src-gen/")
	 */
	public void setJavaFolder(final String javaFolder) {
		this.javaFolder = javaFolder.endsWith(BACKSLASH) ? javaFolder : javaFolder.concat(BACKSLASH);
	}
	
	/**
	 * (Optional) The folder within the project that forms the root of EMF
	 * generated sources. (default is "")
	 */
	public void setJavaPackage(final String javaPackage) {
		this.javaPackage = javaPackage;
	}

	/**
	 * (Mandatory) The OCL document URI corresponding to the CS2AS description  
	 */
	public void setOclDocURI(final String oclDocURI) {
		this.oclFileURI = oclDocURI;
	}

	/**
	 * (Mandatory) The fully qualified class name of the Environment java class  
	 */
	public void setEnvironmentClassName(final String envClassName) {
		this.envClassName = envClassName;
	}
	
	/**
	 * (Mandatory) The fully qualified class name of the Lookup Visitor java class  
	 */
	public void setLookupVisitorClassName(final String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}
	
	/**
	 * (Mandatory) The fully qualified interface name of the NamedElement (itf which provides the "name" attribute)  
	 */
	public void setNamedElementItfName(final String namedElementItfName) {
		this.namedElementItfName = namedElementItfName;
	}
	
	/**
	 * An optional ResourceSet that MWE components may share to reduce model
	 * loading.
	 */
	public void setResourceSet(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	/**
	 * An optional saving options used when serialising EMF resources. (default is {@link XMIUtil#createSaveOptions()})
	 */
	public void setSavingOptions(final Map<?, ?> savingOptions) {
		this.savingOptions = savingOptions;
	}
	
	/**
	 * @param qvt
	 * @param baseURI
	 * @param oclDocName
	 * @return the {@link PivotModel} corresponding to the final QVTi transformation
	 * @throws Exception
	 */
	protected PivotModel executeOCL2QVTi_MTC(OCL qvt, URI baseURI, String oclDocName) throws Exception {
		
		Map<?, ?> savingOptions = this.savingOptions == null ? XMIUtil.createSaveOptions() : this.savingOptions;
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, qvt, savingOptions);
    	mtc.execute();
    	return mtc.getiModel();
	}
}
