package org.eclipse.qvtd.debug.utils;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.messages.QVTdDebugMessages;

/**
 * @author pkobiakov
 */
public class MiscUtil {
	private MiscUtil() {}

    
    public static IStatus makeErrorStatus(Exception e) {
        return new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, IStatus.ERROR, NLS.bind(QVTdDebugMessages.MiscUtil_ErrorMessage, e.getMessage()), e);
    }
    
	public static IStatus makeErrorStatus(String message, Exception e) {
		return new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, IStatus.ERROR, message, e);
	}

	public static IStatus makeErrorStatus(String message) {
		return new Status(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
	}	
	
//	public static String readStream(CFile file) throws IOException {
//	    return readAndClose(CFileUtil.getReader(file));
//	}

	public static String readAndClose(Reader reader) throws IOException {
	    StringBuffer contents = new StringBuffer();
	    try {
	        char[] buf = new char[4096];
	        int read;
	        while((read=reader.read(buf)) > 0) {
	            contents.append(buf, 0, read);
	        }
	    }
	    finally {
	        try { reader.close(); } catch(IOException e) {}
	    }
	 
	    return contents.toString();
	}	
	
	public static int getLineNumber(CharSequence data, int pos) {
		int length = data.length();
		pos = Math.min(pos, length);
		int line = 1;
		for(int i = 0; i < pos; i++) {
			if(data.charAt(i) == '\n') {
				line++;
			}
		}
		
		return line;
    }
	
}
