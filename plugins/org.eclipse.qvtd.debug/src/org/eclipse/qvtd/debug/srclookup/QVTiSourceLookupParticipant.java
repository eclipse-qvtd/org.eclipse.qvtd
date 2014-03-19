package org.eclipse.qvtd.debug.srclookup;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.debug.core.QVTOStackFrame;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;


/**
 * @since 1.3
 */
public class QVTiSourceLookupParticipant extends AbstractSourceLookupParticipant {
		
	
	public QVTiSourceLookupParticipant() {
		super();
	}
	
    public String getSourceName(Object object) throws CoreException {    	
    	if (object instanceof QVTOStackFrame) {
			QVTOStackFrame frame = (QVTOStackFrame) object;
			URI unitURI = frame.getUnitURI();

			IFile sourceFile = findSourceFile(unitURI);
			if(sourceFile != null) {
				return sourceFile.getProjectRelativePath().toString();
			}
        } 
        
        return null;
    }
    
	private IFile findSourceFile(URI unitURI) {
		return QVTdDebugPlugin.getDefault().resolveWorskpaceFile(unitURI);
	}

}
