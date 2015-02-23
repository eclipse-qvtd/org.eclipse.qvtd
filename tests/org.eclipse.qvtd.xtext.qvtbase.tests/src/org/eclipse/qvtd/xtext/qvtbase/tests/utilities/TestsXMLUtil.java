package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;


public class TestsXMLUtil {

	public final static Map<String, Object> defaultSavingOptions; 
	
	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<String, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		
	}
}
