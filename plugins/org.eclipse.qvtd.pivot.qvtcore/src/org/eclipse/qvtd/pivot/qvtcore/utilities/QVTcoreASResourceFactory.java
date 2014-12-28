/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.internal.resource.ASSaverNormalizeVisitor;
import org.eclipse.ocl.pivot.internal.resource.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

/**
 * QVTcoreASResourceFactory supports creation of a QVTcore AS resource and associated artefacts.
 */
public class QVTcoreASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull String FILE_EXTENSION = "qvtcas";
	public static final @NonNull QVTcoreASResourceFactory INSTANCE = new QVTcoreASResourceFactory();

	private static final @NonNull ContentHandler CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTcorePackage.eCONTENT_TYPE, new String[]{FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTcorePackage.eNS_URI, null);
	
	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CONTENT_HANDLER);
	}
	
	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTcoreASResourceFactory() {
		super(QVTcorePackage.eCONTENT_TYPE, FILE_EXTENSION);
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
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTcorePrettyPrintVisitor(printer);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTcoreToStringVisitor(s);
	}
}