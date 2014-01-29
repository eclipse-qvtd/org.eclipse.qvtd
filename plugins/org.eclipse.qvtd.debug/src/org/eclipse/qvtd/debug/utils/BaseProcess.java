package org.eclipse.qvtd.debug.utils;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public abstract class BaseProcess extends PlatformObject implements IProcess {
    
	public static interface IRunnable {
		
        public void run() throws Exception;
        
    }
    
	public void setStreamsProxy(IStreamsProxy streamsProxy) {
		myStreamsProxy = streamsProxy;
	}
	
    public IStreamsProxy getStreamsProxy() {
    	return myStreamsProxy;
    }
    
    private IStreamsProxy myStreamsProxy;
    
}
