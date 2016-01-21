/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.debug.vm.ui.launching.LaunchingUtils;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.debug.launching.QVTcLaunchConstants;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public abstract class DirectionalMainTab extends MainTab implements QVTcLaunchConstants
{
	/**
	 * Job scheduled on a worker thread to compile the transformation.
	 */
	protected class DirectionalCompileJob extends CompileJob
	{
		protected final @Nullable String genmodelPath;
		protected final @Nullable URI javaURI;
		
		public DirectionalCompileJob(@NonNull URI txURI, @NonNull String outputName, @Nullable String genmodelPath, @Nullable URI javaURI) {
			super(txURI, outputName);
			this.genmodelPath = genmodelPath;
			this.javaURI = javaURI;
		}

		public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull QVTimperative qvt, @NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			ResourceSet resourceSet = qvt.getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			for (String genModelFile : genModelFiles) {
				URI genModelURI = URI.createURI(genModelFile).resolve(txURI);
				loadGenModel(getEnvironmentFactory(), genModelURI);
			}
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
			options.setPackagePrefix("cg");
			cg.generateClassFile();
			assert javaURI != null;
			URI normalizedURI = resourceSet.getURIConverter().normalize(javaURI);
			String fileString = ClassUtil.nonNullState(normalizedURI.toFileString());
			cg.saveSourceFile(fileString);
//			cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtcore.tests/test-gen/");
			File explicitClassPath = new File("../org.eclipse.qvtd.xtext.qvtcore.tests/bin");
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			OCL2JavaFileObject.saveClass(String.valueOf(explicitClassPath), qualifiedClassName, javaCodeSource);	
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			if (txClass == null) {
//				TestCase.fail("Failed to compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}
		
		@Override
		protected void doRun() throws Exception {
			QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, null);
			CompilerChain compilerChain2 = new QVTcCompilerChain(qvt.getEnvironmentFactory(), txURI, null);
			compilerChain2.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, XMIUtil.createSaveOptions());
			compilerChain2.addListener(this);
			compilerChain2.build(outputName);
		}
				
		private void loadGenModel(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI genModelURI) {
			ResourceSet resourceSet = environmentFactory.getResourceSet();
			MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
			Resource csGenResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : csGenResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
		}
	}

	protected class TransformationModeListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			if (setDirectionModified()) {
				updateLaunchConfigurationDialog();
			}
		}

	}

	private Group genmodelGroup;
	private Text genmodelPath;
	private Button genmodelBrowseWS;
	private Button genmodelBrowseFile;

	@Override
	protected void addListeners() {
		super.addListeners();
		TransformationModeListener listener = new TransformationModeListener();
		directionCombo.addModifyListener(listener);
		modeCombo.addModifyListener(listener);
//FIXME		partialCheckButton.addSelectionListener(listener);
		LaunchingUtils.prepareBrowseWorkspaceButton(genmodelBrowseWS, genmodelPath, false);
		LaunchingUtils.prepareBrowseFileSystemButton(genmodelBrowseFile, genmodelPath, false);
	}

	@Override
	public void dispose() {
		cancelCompileJob(true);
		super.dispose();
	}

	protected CompileJob createCompileJob() {
		URI txURI = URI.createURI(txPath.getText());
		String direction = directionCombo.getText();
		if (isInterpreted()) {
			return new DirectionalCompileJob(txURI, direction, null, null);
		}
		else {
			CompileStepRow compilerStepRow = getCompilerStepRow(CompilerChain.JAVA_STEP);
			URI javaURI = compilerStepRow != null ? URI.createURI(compilerStepRow.name.getText()).resolve(txURI) : null;
			return new DirectionalCompileJob(txURI, direction, getGenmodelPath(), javaURI);
		}
	}

	@Override
	protected void createGenmodelGroup(Composite control) {
		Group txGroup = new Group(control, SWT.NONE);
		txGroup.setToolTipText("The genmodel for the generated models used by the generated transformation ");
		txGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txGroup.setText("GenModel");
		txGroup.setLayout(new GridLayout(3, false));

		genmodelPath = new Text(txGroup, SWT.BORDER);
		genmodelPath.setToolTipText("The genmodel for generated models");
		GridData gd_genmodelPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_genmodelPath.minimumWidth = 100;
		genmodelPath.setLayoutData(gd_genmodelPath);
		genmodelBrowseWS = new Button(txGroup, SWT.NONE);
		genmodelBrowseWS.setText("Browse Workspace...");
		genmodelBrowseFile = new Button(txGroup, SWT.NONE);
		genmodelBrowseFile.setText("Browse File...");
		
		genmodelGroup = txGroup;
	}

	private void gatherOutputModels(@NonNull List<TypedModel> outputModels, @NonNull TypedModel typedModel) {
		if (!outputModels.contains(typedModel)) {
			outputModels.add(typedModel);
			for (TypedModel anotherTypedModel : typedModel.getDependsOn()) {
				if (anotherTypedModel != null) {
					gatherOutputModels(outputModels, anotherTypedModel);
				}
			}
		}
	}

	protected @NonNull String getGenmodelPath() {
		return genmodelPath.getText();
	}

	@Override
	protected void initializeInternal(@NonNull ILaunchConfiguration configuration) throws CoreException {
		super.initializeInternal(configuration);
		String genmodelAttribute = configuration.getAttribute(GENMODEL_KEY, "");
		if (genmodelAttribute == null) {
			Path path = new Path(genmodelAttribute);
			genmodelAttribute = path.removeFileExtension().addFileExtension("genmodel").toString();
		}
		URI uri = URI.createURI(genmodelAttribute);
		if (uri.scheme() == null) {
			uri = URI.createPlatformResourceURI(genmodelAttribute, true);
		}
		genmodelPath.setText(String.valueOf(uri));
		List<String> directions = new ArrayList<String>();
		if (newOutputsGroup != null) {
			for (Control child : newOutputsGroup.getChildren()) {
				if (child instanceof ParameterRow) {
					directions.add(((ParameterRow)child).name.getText());
				}
			}
		}
		Collections.sort(directions);
		directionCombo.setItems(directions.toArray(new String[directions.size()]));
		directionCombo.setText(configuration.getAttribute(DIRECTION_KEY, "NONE"));
		modeCombo.setText(configuration.getAttribute(MODE_KEY, "CHECK"));
		viewCheckButton.setSelection(configuration.getAttribute(VIEW_KEY, false));
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(GENMODEL_KEY, genmodelPath.getText());
		configuration.setAttribute(DIRECTION_KEY, directionCombo.getText());
		configuration.setAttribute(MODE_KEY, modeCombo.getText());
		configuration.setAttribute(VIEW_KEY, viewCheckButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(DIRECTION_KEY, "NONE");
		configuration.setAttribute(MODE_KEY, "CHECK");
		configuration.setAttribute(VIEW_KEY, false);
	}

	protected void setDirections(@NonNull Set<TypedModel> enforceables) {
		System.out.println("setDirections");
		if (directionCombo.isDisposed()) {
			return;
		}
		String oldText = directionCombo.getText();
		String[] directionItems = new String[enforceables.size()];
		int newIndex = -1;
		int i = 0;
		for (TypedModel typedModel : enforceables) {
			String name = typedModel.getName();
			if (ClassUtil.safeEquals(name, oldText)) {
				newIndex = i;
			}
			directionItems[i++] = name;
		}
		Arrays.sort(directionItems);
		directionCombo.setItems(directionItems);
		directionCombo.select(newIndex >= 0 ? newIndex : 0);
	}

	@Override
	protected void updateDirection(@NonNull Transformation transformation) {
		System.out.println("updateDirection");
		setDirections(QVTbaseUtil.getEnforceableTypedModels(transformation));
	}

	@Override
	protected void updateGenmodelGroup() {
		GridData genmodelGridData = (GridData)genmodelGroup.getLayoutData();
		boolean interpreted = isInterpreted();
		if (genmodelGridData.exclude != interpreted) {
			genmodelGridData.exclude = interpreted;
			genmodelGroup.requestLayout();
			genmodelGroup.setVisible(!interpreted);
		}
	}

	@Override
	protected void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		super.updateGroups(transformation, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		Set<@NonNull TypedModel> inputs = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> outputs = new HashSet<@NonNull TypedModel>();
		String directionName = directionCombo.getText();
		List<@NonNull TypedModel> inputModels = new ArrayList<@NonNull TypedModel>();
		List<@NonNull TypedModel> outputModels = new ArrayList<@NonNull TypedModel>();
		for (TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			if (ClassUtil.safeEquals(typedModel.getName(), directionName)) {
				gatherOutputModels(outputModels, typedModel);
			}
		}
		for (TypedModel inputModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			if (inputModel.getName() != null) {
				inputModels.add(inputModel);
			}
		}
		inputModels.removeAll(outputModels);
		String modeName = modeCombo.getText();
		if (QVTiLaunchConstants.CHECK_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		else if (QVTiLaunchConstants.ENFORCE_CREATE_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		if (QVTiLaunchConstants.ENFORCE_UPDATE_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						oldInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
/*		for (TypedModel outputModel : outputModels) {
			if (outputs.add(outputModel)) {
				String name = outputModel.getName();
				assert name != null;
				if (name != null) {
					newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
				}
			}
		}
		checkables.addAll(enforceables);
		checkables.removeAll(outputModels);
		for (TypedModel inputModel : checkables) {
			if (inputs.add(inputModel)) {
				String name = inputModel.getName();
				assert name != null;
				if (name != null) {
					newInputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
				}
			}
		} */
	}
}
