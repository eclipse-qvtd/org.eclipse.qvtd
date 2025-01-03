/*******************************************************************************
 * Copyright (c) 2016, 2023 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.io.IOException;
import java.util.List;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.validation.ValidationContext;
import org.eclipse.ocl.pivot.validation.ValidationRegistryAdapter;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreRuntimeModule;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeRuntimeModule;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationRuntimeModule;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Guice;

public class XtextCompilerUtil extends CompilerUtil
{
	public static void assertNoDiagnosticErrors(String message, XtextResource xtextResource) {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(message);
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			assert false : s.toString();
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, @NonNull EObject eObject) {
		ValidationRegistryAdapter validationRegistry = ValidationRegistryAdapter.getAdapter(eObject);
		ValidationContext validationContext = new ValidationContext(validationRegistry);
		Diagnostician diagnostician = validationContext.getDiagnostician();
		Diagnostic diagnostic = diagnostician.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			if (child.getData().size() > 0) {
				Object data = child.getData().get(0);
				if (data instanceof Element) {
					for (EObject eScope = (Element)data; eScope instanceof Element; eScope = eScope.eContainer()) {
						ModelElementCS csElement = ElementUtil.getCsElement((Element)eScope);
						if (csElement != null) {
							ICompositeNode node = NodeModelUtils.getNode(csElement);
							if (node != null) {
								Resource eResource = csElement.eResource();
								if (eResource != null) {
									s.append(eResource.getURI().lastSegment() + ":");
								}
								int startLine = node.getStartLine();
								s.append(startLine + ":");
							}
							s.append(((Element)data).eClass().getName() + ": ");
							break;
						}
					}
				}
			}
			s.append(child.getMessage());
		}
		assert false : s.toString();
	}

	public static void doQVTcSerializeAndLoad(@NonNull ProjectManager projectManager, @NonNull URI inputURI, @NonNull URI serializedURI) throws IOException {
		/*XtextResource csResource =*/ doSerialize(projectManager, inputURI, serializedURI);
		QVTcore qvtc = QVTcore.newInstance(projectManager, null);
		Resource cResource2 = QVTcoreUtil.loadTransformations(qvtc.getEnvironmentFactory(), serializedURI, false);
		assertNoResourceErrors("Core Load", cResource2);
	}

	/**
	 * Perform the appropriate initialization to support QVTcore parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTcoreSetup() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			QVTcoreStandaloneSetup.doSetup();
			QVTschedulePivotStandaloneSetup.doSetup();
		}
		else {
			Guice.createInjector(new QVTcoreRuntimeModule());
		}
	}

	public static void doQVTiSerializeAndLoad(@NonNull ProjectManager projectManager, @NonNull URI inputURI, @NonNull URI serializedURI) throws IOException {
		/*XtextResource csResource =*/ doSerialize(projectManager, inputURI, serializedURI);
		QVTimperative qvti = QVTimperative.newInstance(projectManager, null);
		ASResource iResource2 = QVTimperativeUtil.loadTransformations(ImperativeModel.class, qvti.getEnvironmentFactory(), serializedURI, false);
		assertNoResourceErrors("IMperative Load", iResource2);
	}

	/**
	 * Perform the appropriate initialization to support QVTimperative parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTimperativeSetup() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			QVTimperativeStandaloneSetup.doSetup();
		}
		else {
			Guice.createInjector(new QVTimperativeRuntimeModule());
		}
	}

	/**
	 * Perform the appropriate initialization to support QVTrelation parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTrelationSetup() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			QVTrelationStandaloneSetup.doSetup();
		}
		else {
			Guice.createInjector(new QVTrelationRuntimeModule());
		}
	}

	/**
	 * Perform the appropriate initialization to support QVTrelation parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTscheduleSetup() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			QVTschedulePivotStandaloneSetup.doSetup();
		}
	}

	private static XtextResource doSerialize(@NonNull ProjectManager projectManager, @NonNull URI inputURI, @NonNull URI serializedURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		//
		//	Load QVTcAS
		//
		OCL ocl = QVTcore.newInstance(projectManager, null);
		try {
			ASResource asResource = loadQVTcAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoUnresolvedProxies("Normalisation invalid", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = pivot2cs(ocl, resourceSet, asResource, serializedURI);
			resourceSet.getResources().clear();
			return xtextResource;
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
	}

	private static @NonNull ASResource loadQVTcAS(@NonNull OCL ocl, @NonNull URI inputURI) {
		Resource asResource = ocl.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		assert asResource != null;
		//		List<String> conversionErrors = new ArrayList<String>();
		//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
		//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", asResource);
		//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
		//		xtextResource.getContents().add(documentCS);
		return (ASResource) asResource;
	}


	// FIXME move following clones to a Util class
	private static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = ClassUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, null));
		ocl.as2cs(asResource, (CSResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(defaultSavingOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(ClassUtil.nullFree(xtextResource.getContents()));
			xmiResource.save(defaultSavingOptions);
			assert false : e.toString();
		}
		return xtextResource;
	}
}