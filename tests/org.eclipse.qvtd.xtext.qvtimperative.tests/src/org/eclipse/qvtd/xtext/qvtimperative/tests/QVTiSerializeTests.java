/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTiSerializeTests extends XtextTestCase
{

	protected ASResource loadQVTiAS(@NonNull MetaModelManager MetaModelManager, @NonNull URI inputURI) {
		Resource asResource = MetaModelManager.getExternalResourceSet().getResource(inputURI, true);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", asResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return (ASResource) asResource;
	}

	public static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = DomainUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, QVTimperativeCSPackage.eCONTENT_TYPE));
//		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
//		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//		Resource csResource = csResourceSet.createResource(uri);
//		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		ocl.pivot2cs(asResource, (BaseResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
//		csResource.save(null);
		//
		//	CS save and reload
		//		
		URI savedURI = DomainUtil.nonNullState(asResource.getURI());
//		asResource.setURI(PivotUtil.getNonPivotURI(savedURI).appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(null);
		asResource.setURI(savedURI);
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(null);
			fail(e.toString());
		}
		return xtextResource;
	}

	public XtextResource doSerialize(@NonNull String stem) throws Exception {
		return doSerialize(stem, stem, null, true, true);
	}
	public XtextResource doSerialize(@NonNull String stem, @NonNull String referenceStem, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		String inputName = stem + ".qvtias";
		URI inputURI = getProjectFileURI(inputName);
		String referenceName = referenceStem + ".ecore";
		URI referenceURI = getProjectFileURI(referenceName);
		return doSerialize(inputURI, stem, referenceURI, options, doCompare, validateSaved);
	}
	@SuppressWarnings("null")
	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
//		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.qvti";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load as Pivot
		//
		MetaModelManager metaModelManager = new MetaModelManager();
		//
		//	Load Pivot
		//		
		OCL ocl1 = OCL.newInstance();
		XtextResource xtextResource = null;
		try {
			ASResource asResource = loadQVTiAS(ocl1.getMetaModelManager(), inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//		
			xtextResource = pivot2cs(ocl1, resourceSet, asResource, outputURI);
			resourceSet.getResources().clear();
		}
		finally {
			ocl1.dispose();
			ocl1 = null;
		}
/*		OCL ocl2 = OCL.newInstance();
		try {
			MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
			BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.createResource(outputURI);
			MetaModelManagerResourceAdapter.getAdapter(xtextResource2, metaModelManager2);
			xtextResource2.load(null);
			Object cs2asErrors = options != null ? options.get("cs2asErrors") : null;
			if (cs2asErrors != null) {
				assertResourceErrors("Reload failed", xtextResource2, cs2asErrors.toString());
			}
			else {
				assertNoResourceErrors("Reload failed", xtextResource2);
				assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2);
			}
			//
			//	CS to Pivot
			//	
			String pivotName2 = stem + "2.ecore.oclas";
			URI pivotURI2 = getProjectFileURI(pivotName2);
			Resource pivotResource2 = cs2pivot(ocl2, xtextResource2, pivotURI2);
			//
			//	Pivot to Ecore
			//		
			String inputName2 = stem + "2.ecore";
			URI ecoreURI2 = getProjectFileURI(inputName2);
			Resource ecoreResource2 = pivot2ecore(ocl2, pivotResource2, ecoreURI2, validateSaved);
			//
			//
			//
	//		assertSameModel(asResource, pivotResource2);
			Resource referenceResource = loadEcore(referenceURI);
			if (doCompare) {	// Workaround for Bug 354621
				assertSameModel(referenceResource, ecoreResource2);		
			}
			return xtextResource;
		}
		finally {
			ocl2.dispose();
			ocl2 = null;
		} */
		return null;
	}
	
	public void testSerialize_Graph2GraphHierarchical() throws Exception {
		QVTimperativeStandaloneSetup.doSetup();
		doSerialize("Graph2GraphHierarchical/Graph2GraphHierarchical");
	}
}
