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
package org.eclipse.qvtd.xtext.qvtcore.tests;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformationExecutor;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTcDomainUsageTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;
	
	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull EnvironmentFactoryInternal environmentFactory) {
			super(environmentFactory);
		}

		protected void checkAnalysis(@NonNull Transformation asTransformation, boolean showAnalysis) {
			QVTcoreDomainUsageAnalysis domainAnalysis = new QVTcoreDomainUsageAnalysis(getEnvironmentFactory());
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
			for (Operation operation : operations) {
				DomainUsageAnalysis operationAnalysis = domainAnalysis.getAnalysis(operation);
				for (TreeIterator<EObject> tit = operation.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
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
		
		public void printAnalysis(@NonNull Map<DomainUsage, List<Element>> usage2elements) {
			@SuppressWarnings("unchecked")Set<DomainUsage.Internal> keySet = (Set<DomainUsage.Internal>)(Set<?>)usage2elements.keySet();
			List<DomainUsage.Internal> sortedUsages = new ArrayList<DomainUsage.Internal>(keySet);
			Collections.sort(sortedUsages);
			for (DomainUsage usage : sortedUsages) {
				System.out.println(usage);
				List<String> lines = new ArrayList<String>();
				for (Element element : usage2elements.get(usage)) {
					lines.add(element.eClass().getName() + " " + element);
				}
				Collections.sort(lines);
				for (String line : lines) {
					System.out.println("\t" + line);
				}
			}
		}
	}
	
	protected static class MyQVTcEnvironmentFactory extends PivotEnvironmentFactory
	{
		public MyQVTcEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}
	
	protected static class MyQVTcTransformationExecutor extends AbstractTransformationExecutor {
		private MyQVTcTransformationExecutor(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			super(environmentFactory, txClass);
		}
	}

	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTcEnvironmentFactory(getProjectMap(), null));
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTcTestUtil.doQVTcoreSetup();
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
	    
//	    CompleteOCLStandaloneSetup.doSetup();
//	    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ocl", true));
//		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, myQVT.getEnvironmentFactory());
//		completeOCLEObjectValidator2.initialize();
//		PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), myQVT.getEnvironmentFactory());
//		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE));
//		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
//		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcorePackage.eINSTANCE));
	    
//		assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
		asResource.save(getSaveOptions());
		return asResource;
	}

	protected @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}

	public void testCG_uml2rdbms_qvtu() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("models/uml2rdbms.qvtu.qvtc");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
        myQVT.dispose();
	}

	protected @NonNull Transformation loadTransformation(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
		Resource resource = doLoad_ConcreteWithOCL(myQVT, transformURI);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof CoreModel) {
				for (org.eclipse.ocl.pivot.Package asPackage : ((CoreModel)eObject).getOwnedPackages()) {
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
