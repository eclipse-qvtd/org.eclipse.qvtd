package org.eclipse.qvt.declarative.emof.QVTRelation.facade;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.emof.QVTRelation.util.QVTRelationMappingMetaData;

/**
 * QVTRelationFacade provides definitions in a distinct package that can be
 * imported avoiding the exposure of all EMOF-based definitions as would
 * be the case for import of the entire bundle.
 */
public interface QVTRelationFacade
{
	String CONTENT_TYPE = QVTRelationPackage.eCONTENT_TYPE;
	EPackage PACKAGE = QVTRelationPackage.eINSTANCE;
	IMappingMetaData MAPPING_META_DATA = QVTRelationMappingMetaData.INSTANCE;
}
