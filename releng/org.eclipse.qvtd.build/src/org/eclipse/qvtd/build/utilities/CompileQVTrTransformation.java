/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
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
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.EMFPlugin;
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
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystem;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.compiler.CompilerChain.Listener;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;

/**
 * Compile a *.qvtr transformation to a *.java executable
 */
public class CompileQVTrTransformation extends AbstractWorkflowComponent
{
	protected class MyQVT extends AbstractTestQVT
	{
		public MyQVT(@NonNull ProjectManager projectManager, @NonNull String testProjectName, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) {
			super(projectManager, testProjectName, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		}

		@Override
		protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			QVTrCompilerChain compilerChain = new QVTrCompilerChain(getEnvironmentFactory(), txURI, intermediateFileNamePrefixURI, options);
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

		@Override
		protected boolean generateGenModel() {
			return true;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.atl.atl2qvtr";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager() throws Exception {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : CompileQVTrTransformation.this.getTestProjectManager();
		}
	}

	private Logger log = Logger.getLogger(getClass());

	private String qvtrModel = null;
	private List<@NonNull String> usedGenPackages2 = new ArrayList<>();

	/**
	 * Define a workspace-relative path to the GenPackage identifying a pre-compiled EPackage to be used
	 * by the transformation.
	 * e.g. "org.eclipse.emf.ecore/model/Ecore.genmodel#//ecore"
	 */
	public void addUsedGenPackage(@NonNull String usedGenPackage) {
		usedGenPackages2.add(usedGenPackage);
	}

	@Override
	public void checkConfiguration(final Issues issues) {
		for (@NonNull String usedGenPackage : usedGenPackages2) {
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
	public @Nullable TestFileSystem testFileSystem = null;
	public @Nullable TestProject testProject = null;
	public @Nullable ProjectManager testProjectManager = null;

	/**
	 * Return the name of the test bundle. The default implementation assumes that the package name is
	 * the same as the bundle name. Override when this assumption is unjustified.
	 */
	protected @NonNull String getTestBundleName() {
		return ClassUtil.nonNullState(getClass().getPackage().getName());
	}
	protected @NonNull URI getTestBundleURI() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			return URI.createPlatformPluginURI("/" + getTestBundleName(), true);
		}
		else {
			return URI.createPlatformResourceURI("/" + getTestBundleName(), true);
		}
	}

	protected @NonNull TestFileSystem getTestFileSystem() {
		TestFileSystem testFileSystem2 = testFileSystem;
		if (testFileSystem2 == null) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				File testBundleFile = new File(".project");
				String absolutePath = testBundleFile.getAbsolutePath();
				assert !testBundleFile.exists() : "Default working directory should be the workspace rather than a project: " + absolutePath;
			}
			testFileSystem = testFileSystem2 = TestFileSystem.create(getTestFileSystemHelper());
		}
		return testFileSystem2;
	}

	private @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		return new TestFileSystemHelper();
	}

	/**
	 * Return the URI of the file within the testProject.
	 */
	protected @NonNull URI getTestFileURI(@NonNull String filePath) {
		TestProject testProject = getTestProject();
		TestFile outFile = testProject.getOutputFile(filePath);
		return URI.createFileURI(outFile.getFile().toString());
	}

	protected @NonNull TestProject getTestProject() {
		TestProject testProject2 = testProject;
		if (testProject2 == null) {
			String testProjectName = getTestProjectName();
			testProject = testProject2 = getTestFileSystem().getTestProject(testProjectName, true);
		}
		return testProject2;
	}

	protected @NonNull String getTestProjectName() {
		return "QVTd_" + getClass().getSimpleName() + "__" + getTestName();
	}

	protected @NonNull String getTestName() {
		return "atl2qvtr";
	}

	protected @NonNull ProjectManager getTestProjectManager() {
		ProjectManager testProjectManager2 = testProjectManager;
		if (testProjectManager2 == null) {
			testProjectManager = testProjectManager2 = getTestProject().createTestProjectManager();
		}
		return testProjectManager2;
	}

	/**
	 * Return the URI of the filePath within the testProject.
	 */
	protected @NonNull URI getTestURI(@NonNull String filePath) {
		TestProject testProject = getTestProject();
		TestFile outFile = testProject.getOutputFile(filePath);
		return outFile.getURI();
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

		String testProjectName = getTestProjectName();
		URI testBundleURI = getTestBundleURI();
		URI txURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI("atl2qvtr");
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		MyQVT myQVT = new MyQVT(testProjectManager, testProjectName, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		myQVT.addClasspathProjectName("org.eclipse.m2m.atl.common");
		myQVT.addClasspathProjectName("org.eclipse.qvtd.atl");
		myQVT.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtbase");
		myQVT.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtrelation");
		myQVT.addClasspathProjectName("org.eclipse.qvtd.pivot.qvttemplate");
		myQVT.setCopyright("Copyright (c) 2015, 2017 Willink Transformations and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n  E.D.Willink - Initial API and implementation");
		//
		//	Install the GenPackages and ensure that their nsURIs redirect to their *.ecores.
		//
		for (@NonNull String usedGenPackage : usedGenPackages2) {
			int separator = usedGenPackage.indexOf("#");
			String projectPath = usedGenPackage.substring(0, separator);
			String genPackageFragment = usedGenPackage.substring(separator+1);
			GenPackage genPackage = myQVT.addUsedGenPackage(projectPath, genPackageFragment);
			EPackage ePackage = genPackage.getEcorePackage();
			String nsURI = ePackage.getNsURI();
			URI uri = URI.createURI(nsURI);
			testProjectManager.getPackageDescriptor(uri).configure(myQVT.getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
				StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			testProjectManager.getPackageDescriptor(uri).configure(myQVT.getMetamodelManager().getASResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
				StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
		}
		try {
			@SuppressWarnings("unused")
			Class<? extends Transformer> txClass = myQVT.buildTransformation("qvtr", false); //,
		} catch (Exception e) {
			issues.addError(this, "Failed to compile 'ATL2QVTr.qvtr'", null, e, null);
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
