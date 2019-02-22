/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.Map;

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
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.NotXMLContentHandlerImpl;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

/**
 * QVTimperativeASResourceFactory supports creation of a QVTimperative AS resource and associated artefacts.
 */
public class QVTimperativeASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull String FILE_EXTENSION = "qvtias";

	private static @Nullable QVTimperativeASResourceFactory INSTANCE = null;

	public static synchronized @NonNull QVTimperativeASResourceFactory getInstance() {
		if (INSTANCE == null) {
			Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
			Object object = extensionToFactoryMap.get(FILE_EXTENSION);
			if (object instanceof Resource.Factory.Descriptor) {
				INSTANCE = (QVTimperativeASResourceFactory) ((Resource.Factory.Descriptor)object).createFactory();	// Create the registered singleton
			}
			else {
				INSTANCE = new QVTimperativeASResourceFactory();													// Create our own singleton
			}
			assert INSTANCE != null;
			INSTANCE.install("qvti",  null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	private static final @NonNull ContentHandler AS_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTimperativePackage.eCONTENT_TYPE, new String[]{FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTimperativePackage.eNS_URI, null);

	private static final @NonNull ContentHandler CS_CONTENT_HANDLER =
			new NotXMLContentHandlerImpl(new @NonNull String[]{QVTimperativeUtil.QVTI_FILE_EXTENSION});

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, AS_CONTENT_HANDLER);
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CS_CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTimperativeASResourceFactory() {
		super(QVTimperativePackage.eCONTENT_TYPE);
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getExtensionToFactoryMap().put(FILE_EXTENSION, this);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new QVTimperativeAS2MonikerVisitor(as2moniker);
	}

	@SuppressWarnings("deprecation")
	@Override
	public org.eclipse.ocl.pivot.utilities.@NonNull AS2XMIidVisitor createAS2XMIidVisitor(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid as2id) {
		return new QVTimperativeAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new QVTimperativeASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new QVTimperativeASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new QVTimperativeASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager) {
		return new QVTiEnvironmentFactory(projectManager, null);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTimperativePrettyPrintVisitor(printer);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTimperativeTemplateParameterSubstitutionVisitor((EnvironmentFactoryInternal) environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTimperativeToStringVisitor(s);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}
