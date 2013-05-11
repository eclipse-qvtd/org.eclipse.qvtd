/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.io.FileWriter;
import java.io.Writer;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenerator;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class CodeGenTests extends LoadTestCase
{
	@Override
	protected void setUp() throws Exception {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTcoreStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
	}

	public void testCG_HSV2HLS_qvti() throws Exception {
		metaModelManager = new MetaModelManager();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		URI inputURI = getProjectFileURI("HSV2HLS.genmodel");
		Resource genResource = resourceSet.getResource(inputURI, true);
		for (EObject eObject : genResource.getContents()) {
			if (eObject instanceof GenModel) {
				metaModelManager.addGenModel((GenModel)eObject);
			}
		}
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
		Resource resource = doLoad_Concrete("HSV2HLS", "qvti");
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.examples.pivot.Package pPackage : ((ImperativeModel)eObject).getNestedPackage()) {
					if (pPackage instanceof Transformation) {
						String packageName = "cg";
						QVTiCodeGenerator cg = new QVTiCodeGenerator(metaModelManager, (Transformation)pPackage, packageName, true);
						String className = pPackage.getName();
						String qualifiedName = packageName + "." + className;
						String javaCodeSource = cg.generateClassFile();
//						if (saveSource) {
							String fileName = "src-gen/" + qualifiedName.replace('.', '/') + ".java";
							Writer writer = new FileWriter(fileName);
							writer.append(javaCodeSource);
							writer.close();
//						}
						OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
						try {
							Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw e;
						}
					}
				}
			}
		}
	}
}
