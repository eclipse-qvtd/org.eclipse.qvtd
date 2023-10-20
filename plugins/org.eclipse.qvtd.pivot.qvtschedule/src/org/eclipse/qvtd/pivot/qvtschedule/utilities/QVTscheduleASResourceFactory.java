/*******************************************************************************
 * Copyright (c) 2013, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.LUSSIDs;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * QVTscheduleASResourceFactory supports creation of a QVTschedule AS resource and associated artefacts.
 */
@SuppressWarnings("deprecation")
public class QVTscheduleASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable QVTscheduleASResourceFactory CONTENT_TYPE_INSTANCE = null;

	public static synchronized @NonNull QVTscheduleASResourceFactory getInstance() {
		QVTscheduleASResourceFactory contentTypeInstance = CONTENT_TYPE_INSTANCE;
		if (contentTypeInstance == null) {
			CONTENT_TYPE_INSTANCE = contentTypeInstance = getInstances(QVTschedulePackage.eCONTENT_TYPE, QVTbaseUtil.QVTSAS_FILE_EXTENSION, null,
				QVTscheduleASResourceFactory.class);
		}
		return contentTypeInstance;
	}

	private static final @NonNull ContentHandler CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTschedulePackage.eCONTENT_TYPE, new String[]{QVTbaseUtil.QVTSAS_FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTschedulePackage.eNS_URI, null);

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTscheduleASResourceFactory() {
		super(QVTschedulePackage.eCONTENT_TYPE, QVTbaseUtil.QVTSAS_FILE_EXTENSION);
	}

	/*	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor( @NonNull AS2Moniker as2moniker) {
		return new QVTscheduleAS2MonikerVisitor(as2moniker);
	} */

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new QVTscheduleAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new QVTscheduleASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverNormalizeVisitor createASSaverNormalizeVisitor(@NonNull ASSaver saver) {
		return new QVTscheduleASSaverNormalizeVisitor(saver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new QVTscheduleASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull LUSSIDs createLUSSIDs(@NonNull ASResource asResource, @NonNull Map<@NonNull Object, @Nullable Object> options) {
		return new QVTscheduleLUSSIDs(asResource, options);
	}

	/*	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTschedulePrettyPrintVisitor(printer);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull EnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTscheduleTemplateParameterSubstitutionVisitor((EnvironmentFactoryInternal) environmentFactory, selfType, selfTypeValue);
	} */

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTscheduleToStringVisitor(s);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}
