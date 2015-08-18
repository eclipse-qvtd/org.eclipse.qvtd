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
package org.eclipse.qvtd.cs2as.build.mwe;

import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.OCL2QVTiCGTxCompiler;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;


public  class GenerateCGedQVTiTransformation extends AbstractWorkflowComponent
{
	private final static @NonNull String BACKSLASH = "/";
	private final static @NonNull String EMPTY_STRING = "";

	protected static boolean isDefined(final String string) {
		return (!Objects.equals(string, null));
	}
	
	protected String projectName;
	protected String oclFileURI;
	protected ResourceSet resourceSet;
	protected String javaFolder = "src-gen/";
	protected String javaPackage = "";
	protected String lookupResolverClassName;
	protected String lookupResultItfName;
	protected String traceabilityPropName = "ast";
	protected Map<?, ?> savingOptions;

	public void checkConfiguration(final Issues issues) {
		if (!isDefined(oclFileURI)) {
			issues.addError(this, "OCL document URI not specified.");
		}
		
		if (!isDefined(lookupResolverClassName)) {
			issues.addError(this, "Fully qualified name of the Loookup Visitor java class not specified");
		}
		
		if (!isDefined(lookupResultItfName)) {
			issues.addError(this, "Fully qualified name of the Named Element interface not specified");
		}
	}
	
	 


	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		try {
			URI oclDocURI = URI.createURI(oclFileURI);
			CS2ASJavaCompilerParameters cgParams = createParameters();
			createCompiler().compileTransformation(oclDocURI, cgParams, resourceSet, traceabilityPropName);
		} catch (Exception e) {
			issues.addError(this, "Error while executing " + GenerateCGedQVTiTransformation.class.getName(), null, e, null);
		}		
	}

	protected OCL2QVTiCGTxCompiler createCompiler() {
		return new OCL2QVTiCGTxCompiler();
	}
	protected CS2ASJavaCompilerParameters createParameters() {
		return new CS2ASJavaCompilerParametersImpl(lookupResolverClassName, lookupResultItfName, javaFolder, javaPackage);
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
	 * (Mandatory) The fully qualified class name of the Lookup Resolver java class  
	 */
	public void setLookupResolverClassName(final String visitorClassName) {
		this.lookupResolverClassName = visitorClassName;
	}
	
	/**
	 * (Mandatory) The fully qualified interface name of the Lookup Result java interface  
	 */
	public void setLookupResultItfName(final String namedElementItfName) {
		this.lookupResultItfName = namedElementItfName;
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
	 * An optional CS2AS traceability property name (default is "ast")
	 */
	public void setTracePropertyName(final String tracePropName) {
		this.traceabilityPropName = tracePropName;
	}
	
	
}
