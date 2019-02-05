/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.resource.LUSSIDs;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.NotXMLContentHandlerImpl;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLUSSIDs;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

/**
 * QVTrelationASResourceFactory supports creation of a QVTrelation AS resource and associated artefacts.
 */
@SuppressWarnings("deprecation")
public class QVTrelationASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull String FILE_EXTENSION = "qvtras";

	private static @Nullable QVTrelationASResourceFactory INSTANCE = null;

	public static synchronized @NonNull QVTrelationASResourceFactory getInstance() {
		if (INSTANCE == null) {
			Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
			Object object = extensionToFactoryMap.get(FILE_EXTENSION);
			if (object instanceof Resource.Factory.Descriptor) {
				INSTANCE = (QVTrelationASResourceFactory) ((Resource.Factory.Descriptor)object).createFactory();	// Create the registered singleton
			}
			else {
				INSTANCE = new QVTrelationASResourceFactory();														// Create our own singleton
			}
			assert INSTANCE != null;
			INSTANCE.install(null, null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	private static final @NonNull ContentHandler AS_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTrelationPackage.eCONTENT_TYPE, new String[]{FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTrelationPackage.eNS_URI, null);

	private static final @NonNull ContentHandler CS_CONTENT_HANDLER =
			new NotXMLContentHandlerImpl(new @NonNull String[]{QVTrelationUtil.QVTR_FILE_EXTENSION});

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, AS_CONTENT_HANDLER);
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CS_CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTrelationASResourceFactory() {
		super(QVTrelationPackage.eCONTENT_TYPE);
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getExtensionToFactoryMap().put(FILE_EXTENSION, this);
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
	public @NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		return new QVTbaseLUSSIDs(asResource, options);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTrelationPrettyPrintVisitor(printer);
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
}
