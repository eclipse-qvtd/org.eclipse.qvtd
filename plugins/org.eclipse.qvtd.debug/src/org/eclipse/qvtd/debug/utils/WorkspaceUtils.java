package org.eclipse.qvtd.debug.utils;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvtd.debug.launching.LaunchConstants;

/** @author pkobiakov */
public class WorkspaceUtils {
	private WorkspaceUtils() {}
	
    public static IFile getIFile(String fileUnderWorkspace) {
		IPath location = new Path(fileUnderWorkspace);
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
		return ifile;
	}

    public static IFile getModuleFile(ILaunchConfiguration configuration) throws CoreException {
//        String moduleFileName = configuration.getAttribute(LaunchConstants.MODULE, ""); //$NON-NLS-1$
        String moduleFileName = configuration.getAttribute(LaunchConstants.TX_KEY, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        IFile moduleFile = getWorkspaceFile(moduleUri);
        if(moduleFile == null) {
        	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
        		//	NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	//throw new CoreException(errorStatus);
        }
        
        return moduleFile;
    }
    
    public static IFile getWorkspaceFile(String name) {
        try {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(name));
            return file;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static IFile getWorkspaceFile(URI uri) {
		String uriPath;
		if (uri.isFile()) {
			uriPath = uri.toFileString();
		}
		else if (uri.isPlatform()) {
			uriPath = uri.toPlatformString(true);
		}
		else {
			uriPath = uri.toString();
		}
		IFile ifile = getWorkspaceFile(uriPath);
		
		if (ifile == null || !ifile.exists()) {
			if (uri.isFile()) {
				IFile wsfile = getIFile(uriPath);
				if (wsfile != null && wsfile.exists()) {
					return wsfile;
				}
			}
		}
		return ifile;
    }
    
    public static IContainer getIContainer(String folderUnderWorkspace) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(folderUnderWorkspace);
        IContainer cont = workspace.getRoot().getContainerForLocation(location);
        return cont;
    }
    
}
