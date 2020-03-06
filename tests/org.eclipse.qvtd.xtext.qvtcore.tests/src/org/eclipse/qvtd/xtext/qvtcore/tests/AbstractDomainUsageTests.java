/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.usage.DirectedDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.DomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;

/**
 * Abstract support for tests that demonstrate that the QVTxxxDomainUsageAnalysis analyzes everything.
 */
public abstract class AbstractDomainUsageTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;

	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull EnvironmentFactoryInternal environmentFactory) {
			super(environmentFactory);
		}

		public void checkAnalysis(@NonNull Transformation asTransformation, @NonNull TypedModelsConfiguration typedModelsConfiguration, @NonNull RootDomainUsageAnalysis domainAnalysis, boolean showAnalysis) {
			Map<Element, DomainUsage> analysis = domainAnalysis.analyzeTransformation();
			DirectedDomainUsageAnalysis directedDomainUsageAnalysis = domainAnalysis.createDirectedDomainUsageAnalysis(typedModelsConfiguration);	// FIXME proper config
			directedDomainUsageAnalysis.analyzeTransformation();
			Map<@NonNull DomainUsage, @NonNull List<@NonNull Element>> usage2elements = new HashMap<>();
			List<@NonNull Operation> operations = new ArrayList<>();
			for (TreeIterator<EObject> tit = asTransformation.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				if (eObject instanceof Comment) {
					continue;
				}
				DomainUsage usage = analysis.get(eObject);
				assert usage != null : "No usage for " + eObject.eClass().getName() + " " + eObject;
				assert usage.isConstant() : "Variable usage for " + eObject;
				List<@NonNull Element> list = usage2elements.get(usage);
				if (list == null) {
					list = new ArrayList<>();
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
						List<@NonNull Element> list = usage2elements.get(usage);
						if (list == null) {
							list = new ArrayList<>();
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

		public void printAnalysis(@NonNull Map<@NonNull DomainUsage, @NonNull List<@NonNull Element>> usage2elements) {
			List<@NonNull DomainUsage> sortedUsages = new ArrayList<>(usage2elements.keySet());
			Collections.sort(sortedUsages);
			for (@NonNull DomainUsage usage : sortedUsages) {
				System.out.println(usage);
				List<@NonNull String> lines = new ArrayList<>();
				List<@NonNull Element> elements = usage2elements.get(usage);
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
		return DefaultCompilerOptions.defaultSavingOptions;
	}

	protected @NonNull Transformation loadTransformation(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
		//		Resource asResource = doLoad_ConcreteWithOCL(myQVT, transformURI);
		String inputName = transformURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + "as";
		URI cstURI = getTestURI(cstName);
		URI pivotURI = getTestURI(pivotName);
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
		//		System.out.println("asResource.getURI() = " + asResource.getURI());
		asResource.save(getSaveOptions());

		for (@NonNull EObject eObject : new TreeIterable(asResource)) {
			if (eObject instanceof Transformation) {
				return (Transformation)eObject;
			}
		}
		fail("Failed to load " + transformURI);
		throw new IllegalStateException();		// Never here
	}
}
