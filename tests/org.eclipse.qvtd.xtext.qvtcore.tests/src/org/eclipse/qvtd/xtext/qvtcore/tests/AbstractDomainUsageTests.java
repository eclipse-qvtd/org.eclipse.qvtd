/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;

/**
 * Abstract support for tests that demonstrate that the QVTxxxDomainUsageAnalysis analyzes everything.
 */
public abstract class AbstractDomainUsageTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;

	protected static class MyQVT extends OCLInternal
	{
		protected final @NonNull RootDomainUsageAnalysis domainAnalysis;

		public MyQVT(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull RootDomainUsageAnalysis domainAnalysis) {
			super(environmentFactory);
			this.domainAnalysis = domainAnalysis;
		}

		public void checkAnalysis(@NonNull Transformation asTransformation, boolean showAnalysis) {
			Map<Element, DomainUsage> analysis = domainAnalysis.analyzeTransformation(asTransformation);
			Map<DomainUsage, List<Element>> usage2elements = new HashMap<DomainUsage, List<Element>>();
			List<@NonNull Operation> operations = new ArrayList<>();
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
					if (eObject instanceof Comment) {
						continue;
					}
					if (eObject instanceof Element) {
						DomainUsage usage = operationAnalysis.getUsage((Element)eObject);
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
				List<Element> elements = usage2elements.get(usage);
				if (elements != null) {
					for (Element element : elements) {
						lines.add(element.eClass().getName() + " " + element);
					}
				}
				Collections.sort(lines);
				for (String line : lines) {
					System.out.println("\t" + line);
				}
			}
		}
	}

	protected @NonNull Map<Object, Object> getSaveOptions() {
		return TestsXMLUtil.defaultSavingOptions;
	}

	protected @NonNull Transformation loadTransformation(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
		//		Resource asResource = doLoad_ConcreteWithOCL(myQVT, transformURI);
		String inputName = transformURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + "as";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource xtextResource = (BaseCSResource) myQVT.getResourceSet().getResource(transformURI, true);
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

		for (EObject eObject : new TreeIterable(asResource)) {
			if (eObject instanceof Transformation) {
				return (Transformation)eObject;
			}
		}
		fail("Failed to load " + transformURI);
		throw new IllegalStateException();		// Never here
	}
}
