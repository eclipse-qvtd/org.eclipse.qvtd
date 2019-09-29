/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.ResourceSetAwareASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.LUSSIDs;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.NotXMLContentHandlerImpl;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLUSSIDs;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

/**
 * QVTrelationASResourceFactory supports creation of a QVTrelation AS resource and associated artefacts.
 */
@SuppressWarnings("deprecation")
public class QVTrelationASResourceFactory extends ResourceSetAwareASResourceFactory
{
	private static @Nullable QVTrelationASResourceFactory CONTENT_TYPE_INSTANCE = null;

	public static synchronized @NonNull QVTrelationASResourceFactory getInstance() {
		QVTrelationASResourceFactory contentTypeInstance = CONTENT_TYPE_INSTANCE;
		if (contentTypeInstance == null) {
			CONTENT_TYPE_INSTANCE = contentTypeInstance = getInstances(QVTrelationPackage.eCONTENT_TYPE, QVTrelationUtil.QVTRAS_FILE_EXTENSION, QVTrelationUtil.QVTR_FILE_EXTENSION,
				QVTrelationASResourceFactory.class);
		}
		return contentTypeInstance;
	}

	private static final @NonNull ContentHandler AS_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTrelationPackage.eCONTENT_TYPE, new String[]{QVTrelationUtil.QVTRAS_FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTrelationPackage.eNS_URI, null);

	private static final @NonNull ContentHandler CS_CONTENT_HANDLER =
			new NotXMLContentHandlerImpl(new @NonNull String[]{QVTrelationUtil.QVTR_FILE_EXTENSION});

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, AS_CONTENT_HANDLER);
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CS_CONTENT_HANDLER);
	}

	/**
	 * The ResourceSetAware variant of the ASResourceFactory provides the local extension registration that
	 * creates the required resource unless an existing AS or CS resource is available to be opened
	 * re-using the parsing infrastructure for an earlier resource in the CSResourceSet.
	 */
	public static class ResourceSetAware extends QVTrelationASResourceFactory
	{
		public ResourceSetAware(@NonNull ResourceSet csResourceSet) {
			super(csResourceSet);
		}

		@Override
		public Resource createResource(URI uri) {
			assert resourceSet != null;
			assert uri != null;
			return createResource(resourceSet, uri);
		}
	}

	public QVTrelationASResourceFactory() {
		this(null);
	}

	protected QVTrelationASResourceFactory(@Nullable ResourceSet csResourceSet) {
		super(QVTrelationPackage.eCONTENT_TYPE, QVTrelationUtil.QVTRAS_FILE_EXTENSION, csResourceSet);
	}


	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor( @NonNull AS2Moniker as2moniker) {
		return new QVTrelationAS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new QVTrelationAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new QVTrelationASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new QVTrelationASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new QVTrelationASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager) {
		return new QVTrEnvironmentFactory(projectManager, null);
	}

	@Override
	public @NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		return new QVTbaseLUSSIDs(asResource, options);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTrelationPrettyPrintVisitor(printer);
	}

	@Override
	protected @Nullable ASResourceFactory createResourceSetAwareASResourceFactory(@NonNull ResourceSet resourceSet) {
		return new ResourceSetAware(resourceSet);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTrelationTemplateParameterSubstitutionVisitor((EnvironmentFactoryInternal) environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTrelationToStringVisitor(s);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}

	@Override
	protected @NonNull URI getCSuri(@NonNull URI uri) {
		return uri.trimFileExtension().appendFileExtension(QVTrelationUtil.QVTR_FILE_EXTENSION);
	}
}
