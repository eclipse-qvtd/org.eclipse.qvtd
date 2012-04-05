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
 * $Id: DeclarativeQVTMainTab.java,v 1.7 2009/03/05 14:39:23 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcCreationFactory;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrCreationFactory;
import org.eclipse.qvt.declarative.execution.ide.DeclarativeQVTLaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class DeclarativeQVTMainTab extends AbstractLaunchConfigurationTab {

	protected final LaunchConfigChangeListener launchConfigurationDialogUpdater = new LaunchConfigChangeListener() {

		public void launchConfigChanged() {
			updateLaunchConfigurationDialog();
		}
	};

	public static String TAB_NAME = "Main";

	private Text projectText;

	private Button projectButton;

	private Text transformationText;

	private Button transformationButton;

	private Composite modelsComposite;

	private List<ModelParameterConfiguration> modelParameterConfigurations = new ArrayList<ModelParameterConfiguration>();

	private IFile currentTransformationFile;

	private IProject currentProject;

	private RelationalTransformation currentRelationalTransformation;

	private class TransformationSelectionListener implements SelectionListener {

		Composite parent = null;

		public TransformationSelectionListener(Composite parent) {
			this.parent = parent;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			currentRelationalTransformation = handleSearchButtonSelected();
			if (currentRelationalTransformation != null) {
				modelParameterConfigurations.clear();
				List<TypedModel> models = currentRelationalTransformation
						.getModelParameter();
				int count = 0;
				int lastModelIndex = models.size() - 1;
				for (TypedModel typedModel : models) {
					ModelParameterConfiguration modelParameterConfiguration = new ModelParameterConfiguration(
							typedModel.getName(), "", count == lastModelIndex);
					modelParameterConfigurations
							.add(modelParameterConfiguration);
					modelParameterConfiguration
							.addLaunchConfigChangeListener(launchConfigurationDialogUpdater);
					count++;
				}
				ModelParameterConfiguration modelParameterConfiguration = new ModelParameterConfiguration(
						"traces", "", false);
				modelParameterConfigurations.add(modelParameterConfiguration);
				modelParameterConfiguration
						.addLaunchConfigChangeListener(launchConfigurationDialogUpdater);
				createAllModelEditors(parent);
			}
			updateLaunchConfigurationDialog();
		}
	}

	public void createControl(Composite parent) {
		Composite comp = SWTHelper.createMainComposite(parent);
		createProjectEditor(comp);
		createVerticalSpacer(comp, 1);
		createTransformationEditor(comp, "Transformation");
		setControl(comp);
	}

	private static IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	private void createProjectEditor(Composite parent) {
		Font font = parent.getFont();
		Group group = new Group(parent, SWT.NONE);
		group.setText("Project");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayoutData(gd);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		group.setFont(font);
		projectText = new Text(group, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projectText.setLayoutData(gd);
		projectText.setFont(font);
		projectText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}

		});

		projectButton = createPushButton(group, "Browse...", null);
		projectButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				handleProjectButtonSelected();
				updateLaunchConfigurationDialog();
			}
		});
	}

	private void createTransformationEditor(Composite parent, String text) {
		Group mainGroup = SWTHelper.createGroup(parent, text, 2, 1,
				GridData.FILL_HORIZONTAL);
		Composite comp = SWTHelper.createComposite(mainGroup, parent.getFont(),
				2, 2, GridData.FILL_BOTH);
		SWTHelper.removeCompositeMargin(comp);
		transformationText = SWTHelper.createSingleText(comp, 1);
		transformationText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		transformationButton = createPushButton(comp, "Search...", null);
		transformationButton
				.addSelectionListener(new TransformationSelectionListener(comp));
	}

	private RelationalTransformation handleSearchButtonSelected() {
		IProject project = getCurrentProject();
		IContainer searchScope = null;
		if (project != null && project.exists()) {
			searchScope = getCurrentProject();
		} else {
			searchScope = getWorkspaceRoot();
		}
		if (searchScope != null) {
			DeclarativeQVTFileFetcher fetcher = new DeclarativeQVTFileFetcher(
					searchScope);
			Set<IFile> qvtFiles = fetcher.getQVTfiles();
			TransformationSelectionDialog tsd = new TransformationSelectionDialog(
					getShell(), qvtFiles);
			tsd.setListLabelProvider(new DeclarativeQVTElementLabelProvider());
			if (tsd.open() == Window.OK) {
				Object selection = tsd.getFirstResult();
				if (selection instanceof IFile) {
					IFile file = (IFile) selection;
					currentTransformationFile = file;
					currentProject = file.getProject();
					transformationText.setText(file.getName());
					projectText.setText(file.getProject().getName());
					Resource modelResource = getModelResource(file);
					return getTransformation(modelResource);
				}
			}
		}
		return null;
	}

	private Resource getModelResource(IFile file) {
		IFile astFile = getASTFile(file);
		URI modelURI = URI.createPlatformResourceURI(astFile.getFullPath()
				.toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet.getResource(modelURI, true);
		return modelResource;
	}

	private RelationalTransformation getTransformation(Resource modelResource) {
		EObject object = modelResource.getContents().get(0);
		if (object instanceof RelationalTransformation) {
			return (RelationalTransformation) object;
		}
		return null;
	}

	private void initModelComposite(Composite parent) {
		if (modelsComposite != null) {
			modelsComposite.dispose();
		}
		modelsComposite = SWTHelper.createComposite(parent, parent.getFont(),
				3, 2, GridData.FILL_BOTH);
		((GridLayout) modelsComposite.getLayout()).verticalSpacing = 0;
		SWTHelper.createLabel(modelsComposite, "Model", SWT.NONE);
		SWTHelper.createLabel(modelsComposite, "Target", SWT.NONE);
		SWTHelper.createLabel(modelsComposite, "Location",
				GridData.FILL_HORIZONTAL);
	}

	private void createAllModelEditors(Composite parent) {
		initModelComposite(parent);

		for (ModelParameterConfiguration modelParameterConfiguration : modelParameterConfigurations) {
			modelParameterConfiguration.draw(modelsComposite);
		}
		updateLaunchConfigurationDialog();
	}

	private void handleProjectButtonSelected() {
		ILabelProvider labelProvider = new DeclarativeQVTElementLabelProvider();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				getShell(), labelProvider);
		dialog.setTitle("Project Selection");
		dialog.setMessage("Select a project to constrain your search.");
		IProject[] declarativeQVTProjects = getDeclarativeQVTProjects();
		dialog.setElements(declarativeQVTProjects);
		IProject currentProject = null;
		boolean projectFound = false;
		for (int i = 0; i < declarativeQVTProjects.length && !projectFound; i++) {
			IProject project = declarativeQVTProjects[i];
			if (project.getName().equals(projectText.getText().trim())) {
				currentProject = project;
				projectFound = true;
			}
		}
		if (projectFound) {
			dialog.setInitialSelections(new Object[] { currentProject });
		}
		IProject selectedProject = null;
		if (dialog.open() == Window.OK) {
			selectedProject = (IProject) dialog.getFirstResult();
		}
		if (selectedProject != null) {
			projectText.setText(selectedProject.getName());
		}
	}

	private IProject getCurrentProject() {
		String currentProjectName = projectText.getText().trim();
		for (IProject project : getWorkspaceRoot().getProjects()) {
			if (project.getName().equals(currentProjectName)) {
				return project;
			}
		}
		return null;
	}

	private IProject[] getDeclarativeQVTProjects() {
		List<IProject> qvtProjectList = new ArrayList<IProject>();
		for (IProject project : getWorkspaceRoot().getProjects()) {
			try {
				if (project.getNature(QVTrCreationFactory.NATURE_ID) != null
						|| project.getNature(QVTcCreationFactory.NATURE_ID) != null) {
					qvtProjectList.add(project);
				}
			} catch (CoreException e) {
				//TODO
			}
		}
		return qvtProjectList.toArray(new IProject[] {});
	}

	public String getName() {
		return TAB_NAME;
	}

	private static IFile getFileFromURI(String uriString)
			throws URISyntaxException {

		URI executableURI = URI.createURI(uriString);
		String scheme = executableURI.scheme();
		IFile result = null;
		if ("file".equals(scheme)) {
			result = getWorkspaceRoot().getFileForLocation(new Path(uriString));
		} else if (scheme == null || executableURI.isPlatformResource()) {
			result = getWorkspaceRoot().getFile(new Path(uriString));
		} else {
			throw new IllegalArgumentException("cannot handle the URI "
					+ uriString);
		}
		return result;
	}

	private String getExecutablePath(ILaunchConfiguration configuration) {
		String executablePath;
		try {
			executablePath = configuration
					.getAttribute(
							DeclarativeQVTLaunchDelegate.EXECUTABLE_PATH_ATTRIBUTE_NAME,
							DeclarativeQVTLaunchDelegate.EMPTY_STRING);
		} catch (CoreException e) {
			executablePath = DeclarativeQVTLaunchDelegate.EMPTY_STRING;
		}
		return executablePath;
	}

	private List<?> getModelNameList(ILaunchConfiguration configuration) {
		List<?> modelNameList;
		try {
			modelNameList = configuration
					.getAttribute(
							DeclarativeQVTLaunchDelegate.MODEL_NAME_LIST_ATTRIBUTE_NAME,
							Collections.EMPTY_LIST);
		} catch (CoreException e) {
			modelNameList = Collections.EMPTY_LIST;
		}
		return modelNameList;
	}

	private List<?> getModelPathList(ILaunchConfiguration configuration) {
		List<?> modelPathList;
		try {
			modelPathList = configuration
					.getAttribute(
							DeclarativeQVTLaunchDelegate.MODEL_PATH_LIST_ATTRIBUTE_NAME,
							Collections.EMPTY_LIST);
		} catch (CoreException e) {
			modelPathList = Collections.EMPTY_LIST;
		}
		return modelPathList;
	}

	private String getDirectionModel(ILaunchConfiguration configuration) {
		String directionModel;
		try {
			directionModel = configuration
					.getAttribute(
							DeclarativeQVTLaunchDelegate.DIRECTION_MODEL_PATH_ATTRIBUTE_NAME,
							DeclarativeQVTLaunchDelegate.EMPTY_STRING);
		} catch (CoreException e) {
			directionModel = DeclarativeQVTLaunchDelegate.EMPTY_STRING;
		}

		return directionModel;
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		String executablePath = getExecutablePath(configuration);
		List<?> modelNameList = getModelNameList(configuration);
		List<?> modelPathList = getModelPathList(configuration);
		String directionModel = getDirectionModel(configuration);

		if (executablePath == null
				|| executablePath == DeclarativeQVTLaunchDelegate.EMPTY_STRING)
			return;

		IFile sourceFile = getSourceFile(executablePath);

		if (sourceFile == null)
			return;

		currentProject = sourceFile.getProject();
		projectText.setText(currentProject.getName());
		currentTransformationFile = sourceFile;
		currentRelationalTransformation = getTransformation(getModelResource(currentTransformationFile));
		transformationText.setText(currentTransformationFile.getName());

		modelParameterConfigurations.clear();
		for (Object modelNameObject : modelNameList) {
			int index = modelNameList.indexOf(modelNameObject);
			String name = (String) modelNameObject;
			String uri = (String) modelPathList.get(index);
			boolean target = directionModel.equals(name);
			modelParameterConfigurations.add(new ModelParameterConfiguration(
					name, uri, target));
		}

		createAllModelEditors(transformationText.getParent());
	}

	private static IFile getASTFile(IFile sourceFile) {
		IJavaProject javaProject = JavaCore.create(sourceFile.getProject());
		IClasspathEntry srcContainer = null;
		IPath currentTransformationPath = sourceFile.getFullPath();
		try {
			for (IClasspathEntry classpathEntry : javaProject.getRawClasspath()) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					IPath classPathEntryPath = classpathEntry.getPath();
					if (classPathEntryPath
							.isPrefixOf(currentTransformationPath)) {
						srcContainer = classpathEntry;
					}
				}
			}
			if (srcContainer != null) {
				IPath relativeTransformationPath = currentTransformationPath
						.removeFirstSegments(srcContainer.getPath()
								.segmentCount());
				IPath binPath = srcContainer.getOutputLocation();
				IPath ASTPath = binPath.append(relativeTransformationPath)
						.removeFileExtension().addFileExtension("eqvtrelation");
				IFile ASTFile = getWorkspaceRoot().getFile(ASTPath);
				return ASTFile;
			}

		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static IFile getSourceFile(String executablePath) {
		try {
			IFile executableFile = getFileFromURI(executablePath);
			IJavaProject javaProject = JavaCore.create(executableFile
					.getProject());
			IPath executableRelativePath = executableFile.getFullPath()
					.removeFirstSegments(
							javaProject.getOutputLocation().segmentCount());
			IPath sourceRelativePath = executableRelativePath
					.removeFileExtension().removeFileExtension()
					.addFileExtension("qvtr");
			for (IClasspathEntry classpathEntry : javaProject.getRawClasspath()) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					IPath classPathPath = classpathEntry.getPath();
					IFolder classPathFolder = getWorkspaceRoot().getFolder(
							classPathPath);
					IFile searchedFile = classPathFolder
							.getFile(sourceRelativePath);
					if (searchedFile.exists()) {
						return searchedFile;
					}
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getMetamodel(String modelName) {
		if ("traces".equals(modelName)) {
			return null;
		}
		TypedModel typedModel = currentRelationalTransformation
				.getModelParameter(modelName);
		EPackage ePackage = typedModel.getUsedPackage().get(0);
		URI metamodelURI = ePackage.eResource().getURI().isPlatformPlugin() ? URI
				.createURI(ePackage.getNsURI())
				: ePackage.eResource().getURI();
		return metamodelURI.toString();
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (currentProject != null && currentTransformationFile != null) {

			String absoluteExecutablePath = currentTransformationFile
					.getFullPath().toString();

			String direction = null;
			List<String> modelNameList = new ArrayList<String>();
			List<String> modelPathList = new ArrayList<String>();
			List<String> metamodelNameList = new ArrayList<String>();
			List<String> metamodelPathList = new ArrayList<String>();

			for (ModelParameterConfiguration modelParameterConfiguration : modelParameterConfigurations) {
				String modelName = modelParameterConfiguration.getName();
				modelNameList.add(modelName);
				modelPathList.add(modelParameterConfiguration.getUri());
				if ("traces".equals(modelName)) {
					metamodelNameList.add("Traceability");
					metamodelPathList
							.add(getTraceabilityMM(absoluteExecutablePath));
				} else {
					metamodelNameList.add(modelName + "MM");
					metamodelPathList.add(getMetamodel(modelName));
				}

				if (modelParameterConfiguration.isTarget()) {
					direction = modelName;
				}
			}

			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.EXECUTABLE_PATH_ATTRIBUTE_NAME,
							absoluteExecutablePath);
			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.MODEL_NAME_LIST_ATTRIBUTE_NAME,
							modelNameList);
			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.MODEL_PATH_LIST_ATTRIBUTE_NAME,
							modelPathList);
			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.METAMODEL_NAME_LIST_ATTRIBUTE_NAME,
							metamodelNameList);
			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.METAMODEL_PATH_LIST_ATTRIBUTE_NAME,
							metamodelPathList);
			configuration
					.setAttribute(
							DeclarativeQVTLaunchDelegate.DIRECTION_MODEL_PATH_ATTRIBUTE_NAME,
							direction);
			configuration.setAttribute(
					DeclarativeQVTLaunchDelegate.EXECUTION_MODE_ATTRIBUTE_NAME,
					"enforcement");
		}

	}

	private String getTraceabilityMM(String absoluteExecutablePath) {
		IPath path = new Path(absoluteExecutablePath);
		String projectName = path.segment(0);
		IProject project = getWorkspaceRoot().getProject(projectName);
		try {
			for (IClasspathEntry classpathEntry : JavaCore.create(project)
					.getRawClasspath()) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					IPath sourcePath = classpathEntry.getPath();
					if (sourcePath.isPrefixOf(path)) {
						IPath sourceFolderRelativePath = path
								.makeRelativeTo(sourcePath);
						String traceabilityMetamodelFileName = "T"
								+ sourceFolderRelativePath
										.removeFileExtension().lastSegment()
								+ ".ecore";
						IPath result = classpathEntry.getOutputLocation();
						result = result.append(sourceFolderRelativePath
								.removeLastSegments(1));
						result = result.append(traceabilityMetamodelFileName);
						return URI.createPlatformResourceURI(result.toString(),
								true).toString();
					}
				}
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("setDefaults");

	}

	private boolean isProjectValid() {
		String projectTextValue = projectText.getText().trim();
		if (projectTextValue.length() == 0) {
			setErrorMessage("No project specified.");
			return false;
		} else {
			if (getCurrentProject() == null) {
				setErrorMessage("Project " + projectTextValue
						+ " does not exit.");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if (!isProjectValid()) {
			return false;
		}
		if (getExecutablePath(launchConfig) == DeclarativeQVTLaunchDelegate.EMPTY_STRING) {
			setErrorMessage("No transformation specified");
			return false;
		}

		List<?> modelNameList = getModelNameList(launchConfig);
		List<?> modelPathList = getModelPathList(launchConfig);

		if (modelNameList == Collections.EMPTY_LIST) {
			setErrorMessage("No models specified");
			return false;
		}

		for (int i = 0; i < modelNameList.size(); i++) {
			String name = (String) modelNameList.get(i);
			String path = (String) modelPathList.get(i);
			if (path.trim().length() == 0) {
				setErrorMessage("No path specified for model " + name);
				return false;
			}
		}

		setErrorMessage(null);
		setMessage("Launch Declarative QVT Transformation");
		return true;
	}

}
