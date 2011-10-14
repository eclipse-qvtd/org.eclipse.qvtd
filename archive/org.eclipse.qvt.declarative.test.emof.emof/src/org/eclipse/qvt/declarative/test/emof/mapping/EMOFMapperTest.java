/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.mapping;

import java.io.IOException;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.EMOF.util.EMOFMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.AbstractMapperTest;

public class EMOFMapperTest extends AbstractMapperTest
{	
	public void adaptedEMOFLoad(String prefixName) throws IOException, MappingConfigurationException {
		adaptedEMOFLoad(prefixName, ".ecore", ".emof");
	}
	
	public void directEMOFLoad(String prefixName) throws IOException, MappingConfigurationException {
		directEMOFLoad(prefixName, ".ecore", ".emof");
	}
	
	public void ecoreToAdaptedEMOF(String prefixName) throws IOException, MappingConfigurationException {
		ecoreToAdaptedEMOF(prefixName, ".ecore", ".emof");
	}
	
	public void ecoreToDirectEMOF(String prefixName) throws IOException, MappingConfigurationException {
		ecoreToDirectEMOF(prefixName, ".ecore", ".as.emof");
	}

	@Override
	protected String getEcoreContentTypeIdentifier() {
		return EcorePackage.eCONTENT_TYPE;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		EMOFMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	public void testEcoreToEMOF_Empty1() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("Empty1"); }
	public void testEmofLoad_Empty1() throws IOException, MappingConfigurationException { adaptedEMOFLoad("Empty1"); }
	public void testEcoreToEMOF_Empty2() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("Empty2"); }
	public void testEmofLoad_Empty2() throws IOException, MappingConfigurationException { adaptedEMOFLoad("Empty2"); }
	public void testEcoreToEMOF_EEList() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EEList"); }
	public void testEmofLoad_EEList() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EEList"); }
	public void testEcoreToEMOF_EObject() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EObject"); }
	public void testEmofLoad_EObject() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EObject"); }
	public void testEcoreToEMOF_EAttribute_iD() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EAttribute_iD"); }
	public void testEmofLoad_EAttribute_iD() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EAttribute_iD"); }
	public void testEcoreToEMOF_EMap() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EMap"); }
	public void testEmofLoad_EMap() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EMap"); }
	public void testEcoreToEMOF_EClassifier_instanceClass() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EClassifier_instanceClass"); }
	public void testEmofLoad_EClassifier_instanceClass() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EClassifier_instanceClass"); }
	public void testEcoreToEMOF_EId() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EId"); }
	public void testEmofLoad_EId() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EId"); }
	public void testEcoreToEMOF_EAttribute_annotated() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("EAttribute_annotated"); }
	public void testEmofLoad_EAttribute_annotated() throws IOException, MappingConfigurationException { adaptedEMOFLoad("EAttribute_annotated"); }
	public void testEcoreToEMOF_Ecore() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("Ecore"); }
	public void testEmofLoad_Ecore() throws IOException, MappingConfigurationException { adaptedEMOFLoad("Ecore"); }

	public void testEcoreToEMOF_SingleAnnotationReference() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("SingleAnnotationReference"); }	
	public void testEmofLoad_SingleAnnotationReference() throws IOException, MappingConfigurationException { adaptedEMOFLoad("SingleAnnotationReference"); }
	public void testEcoreToEMOF_DoubleAnnotationReference() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("DoubleAnnotationReference"); }	
//
//	Following test incorrectly assumed that an xmi:idref had semantics within an xmi:Extension - bug 279686
// FIXME reimplement for revised semantics
//	public void testEmofLoad_DoubleAnnotationReference() throws IOException, MappingConfigurationException { adaptedEMOFLoad("DoubleAnnotationReference"); }
	public void testEcoreToEMOF_Comment() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("Comment"); }
	public void testEmofLoad_Comment() throws IOException, MappingConfigurationException { adaptedEMOFLoad("Comment"); }
	public void testEcoreToEMOF_DoubleAnnotation() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("DoubleAnnotation"); }
	public void testEmofLoad_DoubleAnnotation() throws IOException, MappingConfigurationException { adaptedEMOFLoad("DoubleAnnotation"); }
	public void testEcoreToEMOF_OppositeRoleName() throws IOException, MappingConfigurationException { ecoreToAdaptedEMOF("OppositeRoleName"); }
	public void testEmofLoad_OppositeRoleName() throws IOException, MappingConfigurationException { adaptedEMOFLoad("OppositeRoleName"); }
	public void testEcoreToEMOF_Annotations() throws IOException, MappingConfigurationException {
		//FIXME Test: spurious non-body detail commented out
		ecoreToAdaptedEMOF("Annotations");
	}
	public void testEmofLoad_Annotations() throws IOException, MappingConfigurationException { adaptedEMOFLoad("Annotations"); }
	
	// Next one requires a fix to Bugzilla 205546
	public void testEcoreToAsEMOF_Ecore() throws IOException, MappingConfigurationException { ecoreToDirectEMOF("Ecore"); }
	public void testEmofLoadFrom_Ecore() throws IOException, MappingConfigurationException { directEMOFLoad("Ecore"); }

	// Next 8 require the Bugzilla 229998 patch
	public void testEcoreToAsEMOF_Comment() throws IOException, MappingConfigurationException { ecoreToDirectEMOF("Comment"); }
	public void testEmofLoadFrom_Comment() throws IOException, MappingConfigurationException { directEMOFLoad("Comment"); }
	public void testEcoreToAsEMOF_DoubleAnnotation() throws IOException, MappingConfigurationException { ecoreToDirectEMOF("DoubleAnnotation"); }
	public void testEmofLoadFrom_DoubleAnnotation() throws IOException, MappingConfigurationException { directEMOFLoad("DoubleAnnotation"); }
	public void testEcoreToAsEMOF_OppositeRoleName() throws IOException, MappingConfigurationException { ecoreToDirectEMOF("OppositeRoleName"); }
	public void testEmofLoadFrom_OppositeRoleName() throws IOException, MappingConfigurationException { directEMOFLoad("OppositeRoleName"); }
	public void testEcoreToAsEMOF_Annotations() throws IOException, MappingConfigurationException { ecoreToDirectEMOF("Annotations"); }
	public void testEmofLoadFrom_Annotations() throws IOException, MappingConfigurationException { directEMOFLoad("Annotations"); }
	
//	public void testEmofLoad_qvt_metamodel() throws IOException, MappingConfigurationException { adaptedEMOFLoad("qvt_metamodel"); }
//	public void testEmofLoad_temp() throws IOException, MappingConfigurationException { emofLoad("temp", ".ecore.xml", ".emof.xml"); }
}
