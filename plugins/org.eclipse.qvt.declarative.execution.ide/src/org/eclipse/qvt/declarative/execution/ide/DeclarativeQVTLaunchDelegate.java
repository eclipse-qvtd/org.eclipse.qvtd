package org.eclipse.qvt.declarative.execution.ide;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionContextFactory;
import org.eclipse.qvt.declarative.execution.ExecutionService;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.LabelledModelFactory;
import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;

public class DeclarativeQVTLaunchDelegate implements
		ILaunchConfigurationDelegate {
	
	public final static String EXECUTABLE_PATH_ATTRIBUTE_NAME = "QVTExecutableAttributeName";
	
	public final static String MODEL_NAME_LIST_ATTRIBUTE_NAME = "QVTModelNamesAttributeName";
	
	public final static String MODEL_PATH_LIST_ATTRIBUTE_NAME = "QVTModelPathsAttributeName";
	
	public final static String METAMODEL_NAME_LIST_ATTRIBUTE_NAME = "QVTMetamodelNamesAttributeName";
	
	public final static String METAMODEL_PATH_LIST_ATTRIBUTE_NAME = "QVTMetamodelPathsAttributeName";
	
	public final static String DIRECTION_MODEL_PATH_ATTRIBUTE_NAME = "QVTDirectionmodelPathsAttributeName";
	
	public final static String EXECUTION_MODE_ATTRIBUTE_NAME = "QVTExecutionModeAttributeName";
	
	public final static String EMPTY_STRING = "";
	

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		File sourceFile = getSourceFile(configuration);
		ExecutionContext parameters = getParameters(configuration);
		try {
			ExecutionService.getInstance().execute(sourceFile, parameters);
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}

	}

	private ExecutionContext getParameters(ILaunchConfiguration configuration) throws CoreException {
		//TODO check parameters
		List<?> modelNameList = configuration.getAttribute(MODEL_NAME_LIST_ATTRIBUTE_NAME, Collections.EMPTY_LIST);
		List<?> modelPathList = configuration.getAttribute(MODEL_PATH_LIST_ATTRIBUTE_NAME, Collections.EMPTY_LIST);
		List<?> metamodelNameList = configuration.getAttribute(METAMODEL_NAME_LIST_ATTRIBUTE_NAME, Collections.EMPTY_LIST);
		List<?> metamodelPathList = configuration.getAttribute(METAMODEL_PATH_LIST_ATTRIBUTE_NAME, Collections.EMPTY_LIST);
		String direction = configuration.getAttribute(DIRECTION_MODEL_PATH_ATTRIBUTE_NAME, EMPTY_STRING);
		
		List<LabelledModel> sourceModels = new ArrayList<LabelledModel>();
		LabelledModel directionModel = null;
		
		for (int i = 0; i < modelPathList.size(); i++) {
			String modelName = (String) modelNameList.get(i);
			String modelPath = (String)modelPathList.get(i);
			String metamodelName = (String) metamodelNameList.get(i);
			String metamodelPath = (String)metamodelPathList.get(i);
			LabelledModel metamodel = LabelledModelFactory.INSTANCE.createLabelledMetamodel(metamodelName, metamodelPath);
			LabelledModel model = LabelledModelFactory.INSTANCE.createLabelledModel(modelName, modelPath, metamodel);
			if (modelName.equals(direction)) {
				directionModel = model;
			} else {
				sourceModels.add(model);
			}
		}

		String modeValue = configuration.getAttribute(EXECUTION_MODE_ATTRIBUTE_NAME, EMPTY_STRING);
		
		ExecutionContext context = ExecutionContextFactory.INSTANCE.createExecutionContext(sourceModels, directionModel, ExecutionMode.valueOf(modeValue));
		return context;
	}

	private File getSourceFile(ILaunchConfiguration configuration) throws CoreException {
		String executablePath = configuration.getAttribute(EXECUTABLE_PATH_ATTRIBUTE_NAME, EMPTY_STRING);
		File result = new File(executablePath);
		//TODO check file
		return result;
	}

}
