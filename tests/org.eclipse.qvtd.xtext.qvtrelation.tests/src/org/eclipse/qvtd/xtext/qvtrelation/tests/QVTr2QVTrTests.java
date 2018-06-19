/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtr.AbstractQVTr2QVTr;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.AbstractDomainUsageTests;

/**
 * Tests that demonstrate that the QVTrelationDomainUsageAnalysis analyzes everything.
 */
public class QVTr2QVTrTests extends AbstractDomainUsageTests
{
	public static class QVTr2QVTrCopier extends AbstractQVTr2QVTr
	{
		protected class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTr2QVTrCopier>
		{
			public CreateVisitor(@NonNull QVTr2QVTrCopier context) {
				super(context);
			}
		}

		protected class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTr2QVTrCopier>
		{
			public UpdateVisitor(@NonNull QVTr2QVTrCopier context) {
				super(context);
			}
		}

		public QVTr2QVTrCopier(@NonNull EnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		@Override
		protected @NonNull CreateVisitor createCreateVisitor() {
			return new CreateVisitor(this);
		}

		@Override
		protected @NonNull UpdateVisitor createUpdateVisitor() {
			return new UpdateVisitor(this);
		}
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		QVTrEnvironmentFactory myEnvironmentFactory = new QVTrEnvironmentFactory(getTestProjectManager(), null);
		return new MyQVT(myEnvironmentFactory, new QVTrelationDomainUsageAnalysis(myEnvironmentFactory));
	}

	protected void doCopierTest(@NonNull MyQVT myQVT, @NonNull URI inURI, @NonNull URI outURI) throws Exception {
		Transformation asTransformation = loadTransformation(myQVT, inURI);
		QVTr2QVTrCopier copier = new QVTr2QVTrCopier(myQVT.getEnvironmentFactory());
		Resource inResource = asTransformation.eResource();
		Resource outResource = inResource.getResourceSet().createResource(outURI, null);
		assert outResource != null;
		copier.transform((ASResource)inResource, (ASResource)outResource);
		Model outModel = QVTrelationUtil.getModel(outResource);
		outModel.setName(inURI.lastSegment());
		outModel.setExternalURI(inURI.toString());
		((ASResourceImpl)inResource).setSaveable(true);
		((ASResourceImpl)outResource).setSaveable(true);
		inResource.save(DefaultCompilerOptions.defaultSavingOptions);
		outResource.save(DefaultCompilerOptions.defaultSavingOptions);
		assertSameModel(inResource, outResource);
	}

	/*	protected void doTopsTest(@NonNull MyQVT myQVT, @NonNull URI inURI) throws Exception {
		URI outURI = inURI.trimFileExtension().appendFileExtension("nonontops.qvtras");
		Transformation asTransformation = loadTransformation(myQVT, inURI);
		QVTr2QVTrTops copier = new QVTr2QVTrTops(myQVT.getEnvironmentFactory());
		Resource inResource = asTransformation.eResource();
		Resource outResource = inResource.getResourceSet().createResource(outURI, null);
		assert outResource != null;
		copier.transform((ASResource)inResource, (ASResource)outResource);
		Model outModel = QVTrelationUtil.getModel(outResource);
		outModel.setName(inURI.lastSegment());
		outModel.setExternalURI(inURI.toString());
		outResource.save(TestsXMLUtil.defaultSavingOptions);
		assertSameModel(inResource, outResource);
	} */

	/*	protected void doOverridesTest(@NonNull MyQVT myQVT, @NonNull URI inURI) throws Exception {
		URI outURI = inURI.trimFileExtension().appendFileExtension("nooverrides.qvtras");
		Transformation asTransformation = loadTransformation(myQVT, inURI);
		QVTr2QVTrOverrides copier = new QVTr2QVTrOverrides(myQVT.getEnvironmentFactory());
		Resource inResource = asTransformation.eResource();
		Resource outResource = inResource.getResourceSet().createResource(outURI, null);
		assert outResource != null;
		copier.transform((ASResource)inResource, (ASResource)outResource);
		Model outModel = QVTrelationUtil.getModel(outResource);
		outModel.setName(inURI.lastSegment());
		outModel.setExternalURI(inURI.toString());
		outResource.save(TestsXMLUtil.defaultSavingOptions);
		//		assertSameModel(inResource, outResource);
	} */

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
	}

	/*	public void testQVTr2QVTrCopy_ATL2QVTr() throws Exception {
		MyQVT myQVT = createQVT();
		URI inURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		doCopierTest(myQVT, inURI);
		//		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	} */

	public void testQVTr2QVTrCopy_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		URI inURI = getResourceURI("org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/HierarchicalStateMachine2FlatStateMachine.qvtr");
		URI outURI = getTestURI("HierarchicalStateMachine2FlatStateMachine.qvtr.copied.qvtras");
		//
		MyQVT myQVT = createQVT();
		doCopierTest(myQVT, inURI, outURI);
		//		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}

	public void testQVTr2QVTrCopy_RelToCore() throws Exception {
		URI inURI = getResourceURI("org.eclipse.qvtd.examples.qvtrelation.reltocore/model/RelToCore.qvtr");
		URI outURI = getTestURI("RelToCore.qvtr.copied.qvtras");
		//
		MyQVT myQVT = createQVT();
		doCopierTest(myQVT, inURI, outURI);
		//		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}

	/*	public void testQVTr2QVTrTops_ATL2QVTr() throws Exception {
		MyQVT myQVT = createQVT();
		URI inURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		doTopsTest(myQVT, inURI);
		//		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	} */

	/*	public void testQVTr2QVTroOverrides_ATL2QVTr() throws Exception {
		MyQVT myQVT = createQVT();
		URI inURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		doOverridesTest(myQVT, inURI);
		//		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	} */
}
