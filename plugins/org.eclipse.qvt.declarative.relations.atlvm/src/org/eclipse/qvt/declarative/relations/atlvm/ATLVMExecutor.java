package org.eclipse.qvt.declarative.relations.atlvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.execution.ExecuteOperation;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionProvider;

public class ATLVMExecutor implements ExecutionProvider {
	
	protected static final String EXECUTABLE_FILE_EXTENSION = "asm";
		
	public boolean provides(Operation operation) {
		if (operation instanceof ExecuteOperation) {
			ExecuteOperation executeOperation = (ExecuteOperation) operation;
			IPath sourcePath = executeOperation.getSourceFile().getProjectRelativePath();
			IPath sourceFolderPath = executeOperation.getSourceFile().getProjectRelativePath();
			if (sourceFolderPath.isPrefixOf(sourcePath)) {
				int commonSegments = sourceFolderPath.matchingFirstSegments(sourceFolderPath);
				IPath sourceRelativePath = sourceFolderPath.removeFirstSegments(commonSegments);
				IPath executablePath = sourceRelativePath.removeFileExtension().addFileExtension(EXECUTABLE_FILE_EXTENSION);
				return executeOperation.getBuildFolder().exists(executablePath);
			}
			return false;
		}
		return false;
	}

	//TODO: Implement
	public List<Object> execute(IFile sourceFile, ExecutionContext parameters, IFolder sourceFolder, IFolder buildFolder) {
		try {
			ASM qvtrTransformation = new ASMXMLReader().read(sourceFile.getContents());
			List<ASMEMFModel> participatingModels = new ArrayList<ASMEMFModel>();
			for (Object model : parameters.getModels()) {
				if (model instanceof ASMEMFModel) {
					ASMEMFModel ASMModel = (ASMEMFModel) model;
					participatingModels.add(ASMModel);
				}
			}
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected Object execute (final ASM qvtrTransformation,
			final List<ASMEMFModel> linkedModels, final List<ASM> libraries,
			final Debugger debugger) {

		ASMModule asmModule = new ASMModule(qvtrTransformation);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		for (ASMEMFModel model : linkedModels) {
			env.addModel(model.getName(), model);
		}
		env.registerOperations(qvtrTransformation);
		
		/*
		 * libraries overriding operations 
		 */
		for (ASM asm : libraries) {
			env.registerOperations(asm);
		}

		/*
		 * Launch the interpretation of the compiler on the QVTR abstract syntax
		 * tree
		 */
		try {
			new ASMInterpreter(qvtrTransformation, asmModule, env,Collections.EMPTY_MAP);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return linkedModels.get(linkedModels.size()-1);
	}
}
