/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeDomainUsageAnalysis;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;

import test.hls.HLSTree.HLSTreePackage;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HLS.HSV2HLSPackage;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiDomainUsageTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;
	
	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		protected void checkAnalysis(@NonNull Transformation asTransformation, boolean showAnalysis) {
			QVTimperativeDomainUsageAnalysis domainAnalysis = new QVTimperativeDomainUsageAnalysis(getEnvironmentFactory());
			Map<Element, DomainUsage> analysis = domainAnalysis.analyzeTransformation(asTransformation);
			Map<DomainUsage, List<Element>> usage2elements = new HashMap<DomainUsage, List<Element>>();
			List<Operation> operations = new ArrayList<Operation>();
			for (TreeIterator<EObject> tit = asTransformation.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Comment) {
					continue;
				}
				DomainUsage usage = analysis.get(eObject);
				assert usage != null : "No usage for " + eObject.eClass().getName() + " " + eObject;
				assert usage.isConstant() : "Variable usage for " + eObject;
				List<Element> list = usage2elements.get(usage);
				if (list == null) {
					list = new ArrayList<Element>();
					usage2elements.put(usage, list);
				}
				list.add((Element) eObject);
				if (eObject instanceof Operation) {
					operations.add((Operation) eObject);
					tit.prune();
				}
			}
			for (@SuppressWarnings("null")@NonNull Operation operation : operations) {
				DomainUsageAnalysis operationAnalysis = domainAnalysis.getAnalysis(operation);
				for (TreeIterator<EObject> tit = operation.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					assert eObject != null;
					DomainUsage usage = operationAnalysis.getUsage(eObject);
					assert usage != null : "No nested usage for " + eObject.eClass().getName() + " " + eObject;
//					assert usage instanceof DomainUsageConstant : "Variable usage for " + eObject;
					List<Element> list = usage2elements.get(usage);
					if (list == null) {
						list = new ArrayList<Element>();
						usage2elements.put(usage, list);
					}
					list.add((Element) eObject);
				}
			}
			if (showAnalysis) {
				printAnalysis(usage2elements);
			}
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
		
		public void printAnalysis(@NonNull Map<DomainUsage, List<Element>> usage2elements) {
			@SuppressWarnings("unchecked")Set<DomainUsage.Internal> keySet = (Set<DomainUsage.Internal>)(Set<?>)usage2elements.keySet();
			List<DomainUsage.Internal> sortedUsages = new ArrayList<DomainUsage.Internal>(keySet);
			Collections.sort(sortedUsages);
			for (DomainUsage usage : sortedUsages) {
				System.out.println(usage);
				List<String> lines = new ArrayList<String>();
				List<Element> elements = usage2elements.get(usage);
				assert elements != null;
				for (Element element : elements) {
					lines.add(element.eClass().getName() + " " + element);
				}
				Collections.sort(lines);
				for (String line : lines) {
					System.out.println("\t" + line);
				}
			}
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}

	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTiTestUtil.doCompleteOCLSetup();
		QVTiTestUtil.doQVTimperativeSetup();
		super.setUp();
	}

	public Resource doLoad_ConcreteWithOCL(@NonNull MyQVT myQVT, @NonNull URI inputURI) throws IOException {
		String inputName = inputURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource xtextResource = (BaseCSResource) myQVT.getResourceSet().getResource(inputURI, true);
		assert xtextResource != null;
		assertNoResourceErrors("Load failed", xtextResource);
		ASResource asResource = xtextResource.getASResource();
//		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		asResource.setURI(pivotURI);
	    
	    TestUtil.doCompleteOCLSetup();
	    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//		CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, myQVT.getEnvironmentFactory());
//		CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
//		completeOCLEObjectValidator1.initialize();
		completeOCLEObjectValidator2.initialize();
//		completeOCLEObjectValidator3.initialize();
		PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), myQVT.getEnvironmentFactory());
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);
	    
		assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
		asResource.save(getSaveOptions());
		return asResource;
	}

	protected @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}

	public void testDomainUsage_HSV2HLS_qvti() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		packageRegistry.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		packageRegistry.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("HSV2HLS/HSV2HLS.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}
	
	public void testDomainUsage_ClassesCS2AS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}
	
	public void testDomainUsage_ClassesCS2AS_bug459225() throws Exception {
		TestUtil.doCompleteOCLSetup();
		MyQVT myQVT = createQVT();
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		packageRegistry.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		packageRegistry.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
		
		URI transformURI = getProjectFileURI("ClassesCS2AS/bug459225/ClassesCS2AS.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}

	public void testDomainUsage_Graph2GraphMinimal_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("Graph2GraphMinimal/Graph2GraphMinimal.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}

	public void testDomainUsage_ManualUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ManualUML2RDBMS/ManualUML2RDBMS.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}

	public void testCG_SimpleUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}

	protected @NonNull Transformation loadTransformation(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
		Resource resource = doLoad_ConcreteWithOCL(myQVT, transformURI);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.pivot.Package asPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
					for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
						if (asClass instanceof Transformation) {
							return (Transformation)asClass;
						}
					}
				}
			}
		}
		fail("Failed to load " + transformURI);
		throw new IllegalStateException();		// Never here
	}
}
