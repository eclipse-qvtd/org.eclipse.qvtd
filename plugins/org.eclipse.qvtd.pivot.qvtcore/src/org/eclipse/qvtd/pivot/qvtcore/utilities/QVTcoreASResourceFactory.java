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
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
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
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

/**
 * QVTcoreASResourceFactory supports creation of a QVTcore AS resource and associated artefacts.
 */
@SuppressWarnings("deprecation")
public class QVTcoreASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull String FILE_EXTENSION = "qvtcas";

	private static @Nullable QVTcoreASResourceFactory INSTANCE = null;

	public static synchronized @NonNull QVTcoreASResourceFactory getInstance() {
		if (INSTANCE == null) {
			Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
			Object object = extensionToFactoryMap.get(FILE_EXTENSION);
			if (object instanceof Resource.Factory.Descriptor) {
				INSTANCE = (QVTcoreASResourceFactory) ((Resource.Factory.Descriptor)object).createFactory();	// Create the registered singleton
			}
			else {
				INSTANCE = new QVTcoreASResourceFactory();														// Create our own singleton
			}
			assert INSTANCE != null;
			INSTANCE.install("qvtc",  null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	private static final @NonNull ContentHandler AS_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTcorePackage.eCONTENT_TYPE, new String[]{FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTcorePackage.eNS_URI, null);

	private static final @NonNull ContentHandler CS_CONTENT_HANDLER =
			new NotXMLContentHandlerImpl(new @NonNull String[]{QVTcoreUtil.QVTC_FILE_EXTENSION});

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, AS_CONTENT_HANDLER);
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CS_CONTENT_HANDLER);
	}

	/**
	 * The private URIConverter avoids installing the (Standalone)PlatformURIHandlerImpl in a global URIConverter.
	 *
	 * This functionality might be resolveable via the URIMap if the ResourceFactory had access to the caller's
	 * ResourceSet and so the caller's URIMap.
	 */
	private @NonNull URIConverter uriConverter = new ExtensibleURIConverterImpl();

	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTcoreASResourceFactory() {
		super(QVTcorePackage.eCONTENT_TYPE);
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		super.configure(resourceSet);
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getExtensionToFactoryMap().put(FILE_EXTENSION, this);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new QVTcoreAS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new QVTcoreAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new QVTcoreASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new QVTcoreASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new QVTcoreASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager) {
		return new QVTcEnvironmentFactory(projectManager, null);
	}

	@Override
	public @NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		return new QVTbaseLUSSIDs(asResource, options);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTcorePrettyPrintVisitor(printer);
	}

	@Override
	public Resource createResource(URI uri) {
		/*		URI nonASuri = uri.trimFileExtension().appendFileExtension("qvtc");
		String nonASuriString = nonASuri.toString();
		assert nonASuriString != null;
		String xxxasExtension = nonASuri.fileExtension();
		ASResourceFactory asResourceFactory = ASResourceFactoryRegistry.INSTANCE.getASResourceFactoryForExtension(xxxasExtension);
		//		String fileExtension = uri.fileExtension();
		//		if (fileExtension == null) {			// Must be an Ecore Package registration
		//			return EcoreASResourceFactory.INSTANCE.createResource(uri);
		//		}
		//		if (/ *(asResourceFactory == null) &&* / !"http".equals(uri.scheme())) { //|| !nonASuri.isFile()) {					// If it's not a known double extension
		if (uri.isPlatform() || uri.isFile() || uri.isArchive()) { // not http:
			//
			//	If *.xxxas exists use it.
			//
			if (uriConverter.exists(uri, null)) {	// NB this expects a (Standalone)PlatformURIHandlerImpl to be installed
				return super.createResource(uri);
			}
		}
		//
		//	Otherwise create a *.xxxas by converting the trimmed resource to XXX AS.
		//
		if (asResourceFactory == null) {			// Must be an Ecore Package registration possibly with a confusing 'extension'
			asResourceFactory = EcoreASResourceFactory.getInstance();
		}
		assert !(asResourceFactory instanceof OCLASResourceFactory);
		//		return asResourceFactory.createResource(uri);
		 */
		assert uri != null;
		ASResource result = new ASResourceImpl(uri, this);
		configureResource(result);
		return result;




		// TODO Auto-generated method stub
		//		return super.createResource(uri);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTcoreTemplateParameterSubstitutionVisitor((EnvironmentFactoryInternal) environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTcoreToStringVisitor(s);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}