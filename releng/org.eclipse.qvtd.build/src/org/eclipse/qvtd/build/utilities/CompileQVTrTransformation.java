/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Listener;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;

/**
 * Compile a *.qvtr transformation to a *.java executable
 */
public class CompileQVTrTransformation extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());

	private String qvtrModel = null;
	private List<@NonNull String> usedGenPackages = new ArrayList<>();

	/**
	 * Define a workspace-relative path to the GenPackage identifying a pre-compiled EPackage to be used
	 * by the transformation.
	 * e.g. "org.eclipse.emf.ecore/model/Ecore.genmodel#//ecore"
	 */
	public void addUsedGenPackage(@NonNull String usedGenPackage) {
		usedGenPackages.add(usedGenPackage);
	}

	@Override
	public void checkConfiguration(final Issues issues) {
		for (@NonNull String usedGenPackage : usedGenPackages) {
			if (usedGenPackage.indexOf("#") < 0) {
				issues.addError(this, "missing fragment separator for '" + usedGenPackage + "'.");
			}
		}
	}

	/**
	 * Install a platform:/resource/project... mapping for all folders in
	 * $WORKSPACE_LOC/* if defined, or $user.dir/../* otherwise.
	 */
	public static void configurePlatformResources() {
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			String urlString = System.getProperty("WORKSPACE_LOC");
			File workspaceLoc;
			if (urlString != null) {
				workspaceLoc = new File(urlString);
			}
			else {
				workspaceLoc = new File(System.getProperty("user.dir")).getParentFile();
			}
			File[] files = workspaceLoc.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					String name = file.getName();
					EcorePlugin.getPlatformResourceMap().put(name, URI.createFileURI(file.toString() + "/"));
				}
			}
		}
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues issues) {
		configurePlatformResources();
		EcorePackage.eINSTANCE.getClass();						// Workaround Bug 425841
		OCLstdlib.install();
		QVTrelationStandaloneSetup.doSetup();
		QVTcorePivotStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
		log.info("Compiling '" + qvtrModel + "'");

		MyQVT myQVT = new MyQVT("atl2qvtr") {

			@Override
			protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull URI prefixURI,
					@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options) {
				QVTrCompilerChain compilerChain = new QVTrCompilerChain(getEnvironmentFactory(), prefixURI, options);
				compilerChain.addListener(new Listener()
				{
					@Override
					public void compiled(@NonNull String step, @Nullable Object object) {
						String label = LabelUtil.getLabel(object);
						log.info("Compiled '" + step + "' : '" + label + "'");
					}
				});
				return compilerChain;
			}
		};
		//
		//	Install the GenPackages and ensure that their nsURIs redirect to their *.ecores.
		//
		ProjectManager projectManager = myQVT.getProjectManager();
		for (@NonNull String usedGenPackage : usedGenPackages) {
			int separator = usedGenPackage.indexOf("#");
			String projectPath = usedGenPackage.substring(0, separator);
			String genPackageFragment = usedGenPackage.substring(separator+1);
			GenPackage genPackage = myQVT.addUsedGenPackage(projectPath, genPackageFragment);
			EPackage ePackage = genPackage.getEcorePackage();
			String nsURI = ePackage.getNsURI();
			URI uri = URI.createURI(nsURI);
			projectManager.getPackageDescriptor(uri).configure(myQVT.getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
				StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			projectManager.getPackageDescriptor(uri).configure(myQVT.getMetamodelManager().getASResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
				StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
		}
		try {
			@SuppressWarnings("unused")
			Class<? extends Transformer> txClass = myQVT.buildTransformation("atl2qvtr",
				"ATL2QVTr.qvtr", "qvtr",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/atl2qvtr/ATL2QVTr", false); //,
		} catch (Exception e) {
			issues.addError(this, e.getMessage());;
		}
		finally {
			myQVT.dispose();
			//			myQVT.removeRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage");
			//			myQVT.removeRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage");
		}
	}

	/**
	 * Define the workspace-relative path to the QVTr transformation to be compiled.
	 */
	public void setQvtrModel(@NonNull String qvtrModel) {
		this.qvtrModel = qvtrModel;
	}
}
