package org.eclipse.qvt.declarative.emof.EMOF.facade;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.util.EMOFMappingMetaData;

/**
 * EMOFFacade provides definitions in a distinct package that can be
 * imported avoiding the exposure of all EMOF-based definitions as would
 * be the case for import of the entire bundle.
 */
public interface EMOFFacade
{
	String CONTENT_TYPE = EMOFPackage.eCONTENT_TYPE;
	EPackage PACKAGE = EMOFPackage.eINSTANCE;
	IMappingMetaData MAPPING_META_DATA = EMOFMappingMetaData.INSTANCE;
}
