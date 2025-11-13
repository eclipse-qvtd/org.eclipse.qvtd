/*******************************************************************************
 * Copyright (c) 2013, 2025 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.ICS2AS;
import org.eclipse.ocl.pivot.internal.resource.ResourceSetAwareASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.NotXMLContentHandlerImpl;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeAS2MonikerVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeASSaverNormalizeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeTemplateParameterSubstitutionVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeToStringVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtimperative.cs2as.QVTimperativeCS2AS;

/**
 * QVTimperativeASResourceFactory supports creation of a QVTimperative AS resource and associated artefacts.
 */
public class QVTimperativeASResourceFactory extends ResourceSetAwareASResourceFactory
{
	private static @Nullable QVTimperativeASResourceFactory CONTENT_TYPE_INSTANCE = null;

	public static synchronized @NonNull QVTimperativeASResourceFactory getInstance() {
		QVTimperativeASResourceFactory contentTypeInstance = CONTENT_TYPE_INSTANCE;
		if (contentTypeInstance == null) {
			CONTENT_TYPE_INSTANCE = contentTypeInstance = getInstances(QVTimperativePackage.eCONTENT_TYPE, QVTimperativeUtil.QVTIAS_FILE_EXTENSION, QVTimperativeUtil.QVTI_FILE_EXTENSION,
				QVTimperativeASResourceFactory.class);
		}
		return contentTypeInstance;
	}

	private static final @NonNull ContentHandler AS_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTimperativePackage.eCONTENT_TYPE, new String[]{QVTimperativeUtil.QVTIAS_FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTimperativePackage.eNS_URI, null);

	private static final @NonNull ContentHandler CS_CONTENT_HANDLER =
			new NotXMLContentHandlerImpl(new @NonNull String[]{QVTimperativeUtil.QVTI_FILE_EXTENSION});

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, AS_CONTENT_HANDLER);
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CS_CONTENT_HANDLER);
	}

	/**
	 * The ResourceSetAware variant of the ASResourceFactory provides the local extension registration that
	 * creates the required resource unless an existing AS or CS resource is available to be opened
	 * re-using the parsing infrastructure for an earlier resource in the CSResourceSet.
	 */
	public static class ResourceSetAware extends QVTimperativeASResourceFactory
	{
		public ResourceSetAware(@NonNull ResourceSet csResourceSet) {
			super(csResourceSet);
		}

		@Override
		public @NonNull Resource createResource(URI uri) {
			assert resourceSet != null;
			assert uri != null;
			return createResource(resourceSet, uri);
		}
	}

	public QVTimperativeASResourceFactory() {
		this(null);
	}

	protected QVTimperativeASResourceFactory(@Nullable ResourceSet csResourceSet) {
		super(QVTimperativePackage.eCONTENT_TYPE, QVTimperativeUtil.QVTIAS_FILE_EXTENSION, csResourceSet);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new QVTimperativeAS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new QVTimperativeASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ICS2AS createCS2AS(@NonNull EnvironmentFactory environmentFactory, @NonNull CSResource csResource, @NonNull ASResource asResource) {
		return new QVTimperativeCS2AS(environmentFactory, csResource, asResource);
	}

	@Override
	public @NonNull EnvironmentFactory createEnvironmentFactory(@NonNull ProjectManager projectManager) {
		return new QVTiEnvironmentFactory(projectManager, null);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTimperativePrettyPrintVisitor(printer);
	}

	@Override
	protected @Nullable ASResourceFactory createResourceSetAwareASResourceFactory(@NonNull ResourceSet resourceSet) {
		return new ResourceSetAware(resourceSet);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTimperativeTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTimperativeToStringVisitor(s);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}

	@Override
	protected @NonNull URI getCSuri(@NonNull URI uri) {
		return uri.trimFileExtension().appendFileExtension(QVTimperativeUtil.QVTI_FILE_EXTENSION);
	}

	@Override
	public void registerMetaPackages(@NonNull CompleteModel completeModel) {
		super.registerMetaPackages(completeModel);
		//
		List<Model> partialModels = completeModel.getPartialModels();
	//	partialModels.add(QVTbaseMetamodel.getDefaultModel());			// XXX QVTbaseTables.MODEL and super
		partialModels.add(QVTbaseTables.MODEL);			// XXX QVTbaseTables.MODEL and super
		partialModels.add(QVTimperativeTables.MODEL);			// XXX QVTbaseTables.MODEL and super
//		completeModel.registerCompletePackageContribution(PivotConstants.METAMODEL_NAME, QVTbasePackage.eINSTANCE);
//		completeModel.registerCompletePackageContribution(PivotConstants.METAMODEL_NAME, QVTimperativePackage.eINSTANCE);
		completeModel.registerCompleteModelContribution(QVTbaseTables.MODEL);
		completeModel.registerCompleteModelContribution(QVTimperativeTables.MODEL);
	}
}
