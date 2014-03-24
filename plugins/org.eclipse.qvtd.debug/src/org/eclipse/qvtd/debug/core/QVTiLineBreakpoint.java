package org.eclipse.qvtd.debug.core;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.utils.OCLDebugCore;
import org.eclipse.qvtd.debug.utils.QVTiDebugCore;

public class QVTiLineBreakpoint extends VMLineBreakpoint
{
    public static @NonNull QVTiLineBreakpoint createRunToLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
    	return new QVTiLineBreakpoint(sourceURI, lineNumber, true);
    }
    
    public static QVTiLineBreakpoint getBreakpointByID(long id) {
    	for (QVTiLineBreakpoint qvtBreakpoint : OCLDebugCore.INSTANCE.getQVTOBreakpoints(QVTiLineBreakpoint.class)) {
			if (qvtBreakpoint.getID() == id) {
				return qvtBreakpoint;
			}
		}
    	
    	return null;
    }

    /* 
     * Remark: Keep the default constructor to allow the breakpoint manager to create breakpoint from markers
     */
    public QVTiLineBreakpoint() {
    	super();
    }

    public QVTiLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
		this(sourceURI, lineNumber, false);
	}
    
    private QVTiLineBreakpoint(@NonNull URI sourceURI, int lineNumber, boolean isRunToLine) throws CoreException {  
    	super(sourceURI, lineNumber, isRunToLine);
    }

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}
}