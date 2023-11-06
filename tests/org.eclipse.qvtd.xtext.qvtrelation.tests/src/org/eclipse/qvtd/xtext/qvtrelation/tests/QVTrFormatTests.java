/*******************************************************************************
 * Copyright (c) 2017, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.base.serializer.DeclarativeFormatter;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTrFormatTests extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	@Override
	public void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
	}

	protected @NonNull ResourceSet doReformatInit(@NonNull OCL ocl) {
		//		long startTime = System.currentTimeMillis();
		//		System.out.println("Start at " + startTime);
		ResourceSet resourceSet = ocl.getResourceSet();
		ProjectManager.CLASS_PATH.initializeResourceSet(resourceSet);
		return resourceSet;
	}

	private @NonNull EObject doReformatLoad(@NonNull ResourceSet resourceSet, @NonNull URI inputURI) {
		String extension = inputURI.fileExtension();
		String stem = inputURI.trimFileExtension().lastSegment();
		String outputName = stem + "." + extension + ".xmi";
		String output2Name = stem + ".saved." + extension;
		@SuppressWarnings("unused")
		URI outputURI = getTestFileURI(outputName);
		URI output2URI = getTestFileURI(output2Name);
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		Resource xtextResource = resourceSet.getResource(inputURI, true);
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", xtextResource);
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		xtextResource.setURI(output2URI);
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		//	DebugTimestamp debugTimestamp = new DebugTimestamp(xtextResource.getURI().toString());

		EObject rootEObject = xtextResource.getContents().get(0);
		//	ICompositeNode rootNode = NodeModelUtils.getNode(rootEObject);
		//	assert rootNode != null;
		return rootEObject;
	}

	protected @NonNull String doReformatReference(@NonNull ResourceSet resourceSet, @NonNull URI referenceURI) throws IOException {
		InputStream referenceStream = resourceSet.getURIConverter().createInputStream(referenceURI, null);
		String referenceText = readFile(referenceStream);
		return referenceText;
	}

	protected void doReformatText(@NonNull DeclarativeFormatter declarativeFormatter, @NonNull ICompositeNode rootNode, int selectOffset, int selectLength, String referenceText) throws IOException {
		Resource xtextResource = rootNode.getSemanticElement().eResource();
		URI xmiURI = xtextResource.getURI().trimFileExtension().trimFileExtension().appendFileExtension("xmi");
		XMLResource xmiResource = (XMLResource) xtextResource.getResourceSet().createResource(xmiURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
		xmiResource.save(XMIUtil.createSaveOptions(xmiResource));
		xtextResource.getContents().addAll(xmiResource.getContents());
		String text = rootNode.getText();
		int selectEnd = selectOffset+selectLength;
		String unformattedText = text.substring(selectOffset, selectEnd);
		IFormattedRegion region = declarativeFormatter.format(rootNode, selectOffset, selectLength);
		String formattedText = text.substring(0, selectOffset) + region.getFormattedText() + text.substring(selectEnd);
		assertEquals(referenceText, formattedText);
		//	xtextResource.save(XMIUtil.createSaveOptions());		//-- skip save since it does a serialize
		//	debugTimestamp.log("Serialization save done");
		//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		//	assertNoResourceErrors("Save failed", xtextResource);
		//
		//	CS2AS cs2as = xtextResource.findCS2AS();
		//	if (cs2as != null) {
		//		ASResource asResource = cs2as.getASResource();
		//		assertNoValidationErrors("Loaded pivot", asResource);
		//	}
	}

	public @NonNull String readFile(@NonNull InputStream inputStream) throws IOException {
		Reader reader = new InputStreamReader(inputStream);
		StringBuilder s = new StringBuilder();
		char[] buf = new char[16384];
		//	try {
		for (int len; (len = reader.read(buf)) >= 0; ) {
			s.append(buf, 0, len);
		}
		//	} catch (IOException e) {
		//		LOG.error("Failed to read '" + fileName + "'", e);
		//		return null;
		//	}
		//	try {
		reader.close();
		//	} catch (IOException e) {
		//		LOG.error("Failed to close '" + fileName + "'", e);
		//		return null;
		//	}
		return s.toString();
	}


	protected @NonNull String replace(@NonNull LazyLinkingResource xtextResource, @NonNull ICompositeNode rootNode, @NonNull String oldString, @NonNull String newString) {
		String xtextContent = rootNode.getText();
		int index = xtextContent.indexOf(oldString);
		assert index >= 0;
		xtextResource.update(index, oldString.length(), newString);
		return rootNode.getText();
	}

	public void testQVTrFormat_HierarchicalStateMachine2FlatStateMachine() throws IOException, InterruptedException {
		//	DeclarativeFormatter.FORMATTER_FRAGMENTS.setState(true);
		//	DeclarativeSerializer.SERIALIZER_FRAGMENTS.setState(true);
		//	SerializationBuilder.SERIALIZATION.setState(true);
		DeclarativeFormatter declarativeFormatter = new QVTrelationStandaloneSetup().createInjector().getInstance(DeclarativeFormatter.class);
		OCLInternal ocl = createOCL();
		URI inputURI = getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr");
		URI referenceURI = getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr");
		ResourceSet resourceSet = doReformatInit(ocl);
		String referenceText = doReformatReference(resourceSet, referenceURI);
		EObject rootEObject = doReformatLoad(resourceSet, inputURI);
		ICompositeNode rootNode = NodeModelUtils.getNode(rootEObject);
		assert rootNode != null;
		int rootOffset = rootNode.getOffset();
		int rootLength = rootNode.getLength();
		@SuppressWarnings("unused")
		int totalOffset = rootNode.getTotalOffset();
		@SuppressWarnings("unused")
		int totalLength = rootNode.getTotalLength();
		//	xtextResource.save(XMIUtil.createSaveOptions());
		int selectOffset = 0;//rootOffset + rootLength/4;
		int selectLength = rootLength;// / 2;
		// XXX	doReformatText(declarativeFormatter, rootNode, selectOffset, selectLength, referenceText);
		ocl.dispose();
	}
}
