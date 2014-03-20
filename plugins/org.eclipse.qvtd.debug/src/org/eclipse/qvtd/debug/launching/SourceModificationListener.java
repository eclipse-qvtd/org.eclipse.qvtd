package org.eclipse.qvtd.debug.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.qvtd.debug.utils.QVTiDebugCore;

class SourceModificationListener implements IResourceChangeListener {

	private IFile fTransfFile;
	private ITerminate fTerminate;

	SourceModificationListener(IFile transformationFile,
			ITerminate terminateable) {
		if (transformationFile == null || terminateable == null) {
			throw new IllegalArgumentException();
		}

		fTransfFile = transformationFile;
		fTerminate = terminateable;
	}

	private boolean expired() {
		if(fTerminate.isTerminated()) {
			fTransfFile.getProject().getWorkspace().removeResourceChangeListener(this);
			return true;
		}
		return false;
	}
	
	public void resourceChanged(final IResourceChangeEvent event) {
		if(expired()) {			
			return;
		}
		
		IResourceDelta delta = event.getDelta();

		final boolean[] modified = new boolean[] { false };

		if (delta == null) {
			if (event.getResource() instanceof IProject) {
				if (event.getType() == IResourceChangeEvent.PRE_CLOSE
						&& event.getResource() == fTransfFile.getProject()) {
					modified[0] = true;
				}
			}
		} else {
			try {
				delta.accept(new IResourceDeltaVisitor() {
					public boolean visit(IResourceDelta delta) throws CoreException {
						IResource resource = delta.getResource();
						if (resource instanceof IFile) {
							IFile file = (IFile) resource;
							boolean include = (delta.getFlags() & IResourceDelta.CONTENT) != 0;
							if (include && fTransfFile.equals(file)) {
								modified[0] = true;
							}

							return false;
						} 

						IProject project = resource.getProject();
						return project == null || project.equals(fTransfFile.getProject());
					}
				});
			} catch (CoreException e) {
				QVTiDebugCore.log(e.getStatus());
			}
		}

		if (modified[0]) {
			handleSourceModified(fTransfFile, fTerminate);
		}
	}

	protected void handleSourceModified(IFile sourceFile,
			ITerminate terminateable) {
/*		IStatusHandler handler = DebugPlugin.getDefault().getStatusHandler(
				QVTODebugConfiguration.MODIFIED_SOURCE_STATUS);
		if (handler != null) {
			Object resolved;
			try {
				resolved = handler.handleStatus(
						QVTODebugConfiguration.MODIFIED_SOURCE_STATUS,
						sourceFile.getFullPath());
				if (resolved instanceof IStatus) {
					IStatus resolvedStatus = (IStatus) resolved;
					if (resolvedStatus.getSeverity() == IStatus.CANCEL) {
						fTerminate.canTerminate();
					}
				}

			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}

		} else {
			QVTODebugCore.log(QVTODebugConfiguration.MODIFIED_SOURCE_STATUS);
		} */
	}
}