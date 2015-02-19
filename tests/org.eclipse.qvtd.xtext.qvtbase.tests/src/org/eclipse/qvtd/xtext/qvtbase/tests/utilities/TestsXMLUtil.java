package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMIResource;


public class TestsXMLUtil {

	public static Map<String, Object> defaultSavingOptions; 
	
	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<String, Object>();
		defaultSavingOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMIResource.OPTION_LINE_DELIMITER, "\n"); 
		
	}
}
