package org.eclipse.qvtd.debug.utils;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * @author vrepeshko
 */
public class StreamsProxy implements IStreamsProxy {

	public StreamsProxy() {
		myOutputStreamMonitor = new WriterMonitor();
		myErrStreamMonitor = new WriterMonitor();
	}
	
	public IStreamMonitor getErrorStreamMonitor() {
		return myErrStreamMonitor;
	}

	public IStreamMonitor getOutputStreamMonitor() {
		return myOutputStreamMonitor;
	}
	
	public Writer getOutputWriter() {
		return myOutputStreamMonitor;
	}
	
	public Writer getErrWriter() {
		return myErrStreamMonitor;
	}	

	public void write(String input) throws IOException {
	}
	
	private final WriterMonitor myOutputStreamMonitor;
	private final WriterMonitor myErrStreamMonitor;
}
