package org.eclipse.qvtd.debug.stubs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;

public class QVTODebugUtil
{
	public static void attachEnvironment(CompiledUnit mainUnit) {
//		throw new UnsupportedOperationException();
	}

	public static IStatus createDebugError(String string, IOException e) {
		throw new UnsupportedOperationException();
	}

	public static URI getResourceURI(IResource resource) {
		throw new UnsupportedOperationException();
	}

	public static IFile toFile(URI uri) {
		List<IFile> files = toFiles(uri);
		return files.isEmpty() ? null : files.get(0);
	}

	public static List<IFile> toFiles(URI uri) {
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			return Collections.singletonList(file);
		} else if(uri.isFile()) {
			java.net.URI javaURI;
			try {
				javaURI = java.net.URI.create(uri.toString());
			} catch(IllegalArgumentException e) {
				// not a valid EMF uri, can't look for IFile
				QVTODebugCore.log(e);
				return Collections.emptyList();
			}
			
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			List<IFile> result = new ArrayList<IFile>(files.length);
			
			for (IFile nextFile : files) {
				result.add(nextFile);
			}
			return result;
		}
		return Collections.emptyList();
	}
}
