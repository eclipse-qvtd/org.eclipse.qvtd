/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.invocation.AbstractTransformationTechnology;

public class OCL2QVTiTransformationTechnology extends AbstractTransformationTechnology
{
	public static final @NonNull OCL2QVTiTransformationTechnology INSTANCE = new OCL2QVTiTransformationTechnology("org.eclipse.qvtd.ocl2qvti");
	
	protected @Nullable Log log = null;
	
	private OCL2QVTiTransformationTechnology(@NonNull String name) {
		super(name);
//		Scheduler.DEBUG_GRAPHS.setState(true);
	}

	@Override
	public @NonNull Map<@NonNull String, Object> execute(@NonNull ResourceSet resourceSet, @NonNull Map<String, Object> modelMap,
			@NonNull Map<@NonNull String, Object> parametersMap) throws TransformationException {
		Object logObject = parametersMap.get("log");
		if (logObject instanceof Log) {
			log = (Log)logObject;
		}
		String lookupSolverClassName = (String) parametersMap.get("lookupSolverClassName");
		String lookupResultItfName = (String) parametersMap.get("lookupResultItfName");
		String javaFolder = (String) parametersMap.get("javaFolder");
		String javaPackage = (String) parametersMap.get("javaPackage");
		Boolean debug = (Boolean) parametersMap.get("debug");
		//
		String oclFileURI = (String) parametersMap.get("oclFileURI");
		@SuppressWarnings("unchecked")
		Map<String, String> packageRenames = (Map<String, String>) parametersMap.get("packageRenames");
		@SuppressWarnings("unchecked")
		List<String> extendedOclFileURIs = (List<String>) parametersMap.get("extendedOclFileURIs");
		String traceabilityPropName = (String) parametersMap.get("traceabilityPropName");
		//
		URI oclDocURI = URI.createURI(oclFileURI);
		URI[] extendedOclDocURIs = new URI[extendedOclFileURIs.size()];
		for (int i=0; i< extendedOclFileURIs.size(); i++) {
			extendedOclDocURIs[i] = URI.createURI(extendedOclFileURIs.get(i));
		}
		CS2ASJavaCompilerParametersImpl cgParams = new CS2ASJavaCompilerParametersImpl(lookupSolverClassName, lookupResultItfName, javaFolder, javaPackage);
		if (packageRenames != null) {
			for (Map.Entry<String, String> entry : packageRenames.entrySet()) {
				String fromPackage = entry.getKey();
				String toPackage = entry.getValue();
				if ((fromPackage != null) && (toPackage != null)) {
					cgParams.addPackageRename(fromPackage, toPackage);
				}
			}
		}
		try {
			OCL2QVTiCGTxCompiler ocl2qvTiCGTxCompiler = new OCL2QVTiCGTxCompiler();
			ocl2qvTiCGTxCompiler.setLog(log);
			ocl2qvTiCGTxCompiler.setDebug(debug);
			Class<? extends Transformer> transformationClass = ocl2qvTiCGTxCompiler.compileTransformation(resourceSet, cgParams, traceabilityPropName, oclDocURI, extendedOclDocURIs);
			if (log != null) {
				log.info("Created " + transformationClass);
			}
			return new HashMap<@NonNull String, Object>();
		} catch (Exception e) {
			throw new TransformationException(null, e, "Error while executing " + OCL2QVTiCGTxCompiler.class.getName());
		} finally {
			log = null;
		}
	}
}
