/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius.ide;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * FileExtensionRegistry maintains a mapping between the file extensions and the *.odesign files
 * that declare diagramming support fpor those file extensions.
 * <br>
 * HasODesignPropertyTester provides support for use within org.eclipse.ui.menus extension points.
 * <br>
 * This functionality has no Sirius dependencies and so minimizes the
 * impact of providing Sirius-based menu entries.
 */
public class FileExtensionRegistry implements IResourceChangeListener, IResourceDeltaVisitor
{

	/**
	 * The prevailing status of OPTION_COMPONENTIZATION_ANALYSIS. May be set true by JUnit tests.
	 */
	public static boolean DEBUG_COMPONENTIZATION_ANALYSIS = false;

	private static final Logger logger = Logger.getLogger(FileExtensionRegistry.class);
	private static final @NonNull String ORG_ECLIPSE_SIRIUS_COMPONENTIZATION_EXTENSION_POINT = "org.eclipse.sirius.componentization" /*ISiriusComponent.ID*/;
	private static final @NonNull String OPTION_COMPONENTIZATION_ANALYSIS = "org.eclipse.qvtd.sirius.ide/componentization/analysis";
	private static final String O_DESIGN = "odesign";
	private static final String STAR_DOT_O_DESIGN = "*." + O_DESIGN;

	private static @Nullable FileExtensionRegistry INSTANCE = new FileExtensionRegistry();

	public static @NonNull FileExtensionRegistry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FileExtensionRegistry();
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	/**
	 * ODesignReader provides the SAX callbacks to support reading
	 * the description:Group.ownedViewpoints.modelFileExtension attribute(s) in an odesign file.
	 */
	protected static class ODesignReader extends DefaultHandler
	{
		public static final @NonNull String groupTag = "description:Group";
		public static final @NonNull String ownedViewpointsTag = "ownedViewpoints";
		public static final @NonNull String modelFileExtensionAttribute = "modelFileExtension";

		protected final @NonNull FileExtensionRegistry registry;
		protected final @NonNull Object oDesignFile;

		private @NonNull Stack<@NonNull String> elements = new Stack<>();

		public ODesignReader(@NonNull FileExtensionRegistry registry, @NonNull IFile oDesignFile) {
			this.registry = registry;
			this.oDesignFile = oDesignFile;
		}

		public ODesignReader(@NonNull FileExtensionRegistry registry, @NonNull URL oDesignFile) {
			this.registry = registry;
			this.oDesignFile = oDesignFile;
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			elements.pop();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			int size = elements.size();
			if (ownedViewpointsTag.equals(qName)) {
				if ((size == 1) && groupTag.equals(elements.elementAt(0))) {
					String modelFileExtension = attributes.getValue(modelFileExtensionAttribute);
					if (modelFileExtension != null) {
						registry.addEntry(modelFileExtension, oDesignFile);
					}
				}
			}
			elements.push(qName);
		}
	}

	/**
	 * The HasODesignPropertyTester is a PropertyTester for use by org.eclipse.ui.menus extension points
	 * to guard IFile menu items according to the availability of a *.odesign file for the IFile's extension.
	 * <br>
	 * This tester and the supporting FileExtensionRegistry have no Sirius dependencies and so minimize the
	 * impact of providing Sirius-based menu entries.
	 */
	public static class HasODesignPropertyTester extends PropertyTester
	{
		private static final String HAS_O_DESIGN = "hasODesign";

		@Override
		public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
			if (HAS_O_DESIGN.equals(property) && (receiver instanceof IFile)) {
				String fileExtension = ((IFile)receiver).getFileExtension();
				boolean hasODesign = FileExtensionRegistry.getInstance().hasODesign(fileExtension);
			//	System.out.println(property + " for " + receiver + " => " + hasODesign);
				return expectedValue != null ? Boolean.valueOf(hasODesign).equals(expectedValue) : hasODesign;
			}
			return expectedValue != null ? Boolean.FALSE.equals(expectedValue) : false;
		}
	}

	private final @NonNull Map<@NonNull Object, @NonNull List<@NonNull String>> handle2extensions = new HashMap<>();
	private final @NonNull Map<@NonNull String, @NonNull List<@NonNull Object>> extension2entries = new HashMap<>();

	/**
	 * non-null visitor when this FileExtensionRegistry is listening to resource changes in the workspace.
	 */
	private /*@LazyNonNull*/ IResourceDeltaVisitor visitor = null;

	/**
	 * plugin.xml deltas in the current visit();
	 */
	private @Nullable List<@NonNull IResourceDelta> oDesignDeltas = null;

	private FileExtensionRegistry() {
		if (!DEBUG_COMPONENTIZATION_ANALYSIS) {		// If not statically set by a JUnit test.
			String debugOption = System.getProperty(OPTION_COMPONENTIZATION_ANALYSIS);
			if (debugOption == null) {
				debugOption = Platform.getDebugOption(OPTION_COMPONENTIZATION_ANALYSIS);
			}
			DEBUG_COMPONENTIZATION_ANALYSIS = Boolean.TRUE.toString().equalsIgnoreCase(debugOption);
		}
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		SAXParser saxParser = getSAXParser();
		assert saxParser != null;
		final IExtensionPoint point = registry.getExtensionPoint(ORG_ECLIPSE_SIRIUS_COMPONENTIZATION_EXTENSION_POINT);
		if (point != null) {
			for (IConfigurationElement element : point.getConfigurationElements()) {
				IContributor contributor = element.getContributor();
				String bundleName = contributor.getName();
				Bundle bundle = Platform.getBundle(bundleName);
				processBundle(bundle, saxParser);
			}
		}
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		for (IProject project : root.getProjects()) {
			if (project.isOpen()) {
				processResource(project, saxParser);
			}
		}
		if (DEBUG_COMPONENTIZATION_ANALYSIS) {
			debugPrintout();
		}
	}

	protected void addEntry(@NonNull String fileExtension, @NonNull Object oDesignFile) {
		if (DEBUG_COMPONENTIZATION_ANALYSIS) {
			System.out.println(OPTION_COMPONENTIZATION_ANALYSIS + " : *." + fileExtension + " => " + oDesignFile.toString());
		}
		List<@NonNull String> extensions = handle2extensions.get(oDesignFile);
		if (extensions == null) {
			extensions = new ArrayList<>();
			handle2extensions.put(oDesignFile, extensions);
		}
		extensions.add(fileExtension);
		List<@NonNull Object> entries = extension2entries.get(fileExtension);
		if (entries == null) {
			entries = new ArrayList<>();
			extension2entries.put(fileExtension, entries);
		}
		entries.add(oDesignFile);
	}

	protected void debugPrintout() {
		StringBuilder s = new StringBuilder();
		s.append(OPTION_COMPONENTIZATION_ANALYSIS);
		for (Map.Entry<String, List<Object>> entry : extension2entries.entrySet()) {
			s.append("\n\t");
			s.append(entry.getKey());
			s.append(" => ");
			for (Object object : entry.getValue()) {
				s.append("\n\t\t");
				s.append(object);
			}
		}
		for (Entry<@NonNull Object, @NonNull List<@NonNull String>> entry : handle2extensions.entrySet()) {
			s.append("\n\t");
			s.append(entry.getKey());
			s.append(" <=");
			for (Object object : entry.getValue()) {
				s.append(" ");
				s.append(object);
			}
		}
		System.out.println(s.toString());
	}

	public synchronized void dispose() {
		if (visitor != null) {
			visitor = null;
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			INSTANCE = null;
		}
	}

	protected @Nullable SAXParser getSAXParser() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			return factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			logger.error("Failed to prepare to SAXParser");
			return null;
		}
	}

	public boolean hasODesign(String fileExtension) {
		return extension2entries.containsKey(fileExtension);
	}

	protected void processBundle(@NonNull Bundle bundle, @NonNull SAXParser saxParser) {
		for (Iterator<URL> it = bundle.findEntries("/", STAR_DOT_O_DESIGN, true).asIterator(); it.hasNext(); ) {
			URL url = it.next();
			ODesignReader oDesignReader = new ODesignReader(this, url);
			try {
				InputStream inputStream = url.openStream();
				try {
					saxParser.parse(inputStream, oDesignReader);
				} catch (IOException e) {
					logger.error("Failed to read " + url.toString(), e);
				} catch (SAXException e) {
					logger.error("Failed to parse " + url.toString(), e);
				}
			} catch (IOException e) {
				logger.error("Failed to open " + url.toString(), e);
			}
		}
	}

	protected void processODesignFile(IFile file, SAXParser saxParser) {
		ODesignReader oDesignReader = new ODesignReader(this, file);
		try {
			InputStream inputStream = file.getContents();
			try {
				saxParser.parse(inputStream, oDesignReader);
			} catch (IOException e) {
				logger.error("Failed to read " + file.toString(), e);
			} catch (SAXException e) {
				logger.error("Failed to parse " + file.toString(), e);
			}
		} catch (CoreException e) {
			logger.error("Failed to open " + file.toString(), e);
		}
	}

	protected void processResource(@NonNull IResource resource, @NonNull SAXParser saxParser) {
		if (resource.isDerived()) {
		}
		else if (resource instanceof IContainer) {
			IContainer container = (IContainer)resource;
			try {
				for (IResource member : container.members()) {
					assert member != null;
					processResource(member, saxParser);
				}
			} catch (CoreException e) {
				logger.error("Failed to traverse " + container.toString(), e);
			}
		}
		else if (resource instanceof IFile) {
			IFile file = (IFile)resource;
			if (O_DESIGN.equals(file.getFileExtension())) {
				processODesignFile(file, saxParser);
				if (visitor == null) {
					visitor = this;
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
				}
			}
		}
	}

	/**
	 * Internal call-back for a resource change visits the delta to respond to changed open/closed projects.
	 * Changes are synchronized on this.
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		System.out.println("resourceChanged " + event.toString());
		SAXParser saxParser = null;
		boolean doPrintOut = false;
		try {
			synchronized (this) {
				assert oDesignDeltas == null;
				try {
					event.getDelta().accept(visitor);
					if (oDesignDeltas != null) {
						for (IResourceDelta oDesignDelta : oDesignDeltas) {
							IResource resource = oDesignDelta.getResource();
							System.out.println("resourceChanged " + resource.toString() + " " + oDesignDelta.getAffectedChildren().length);
							IFile file = (IFile)resource;
							int kind = oDesignDelta.getKind();
							if ((kind == IResourceDelta.CHANGED) || (kind == IResourceDelta.REMOVED)) {
								List<@NonNull String> extensions = handle2extensions.get(file);
								if (extensions != null) {
									for (@NonNull String fileExtension : extensions) {
										List<@NonNull Object> entries = extension2entries.get(fileExtension);
										if (entries != null) {
											boolean wasRemoved = entries.remove(file);
											assert wasRemoved;
											if (entries.isEmpty()) {
												extension2entries.remove(fileExtension);
											}
										}
									}
									handle2extensions.remove(file);
								}
							}
							if ((kind == IResourceDelta.ADDED) || (kind == IResourceDelta.CHANGED)) {
								if (saxParser == null) {
									saxParser = getSAXParser();
								}
								assert saxParser != null;
								processODesignFile(file, saxParser);
							}
							doPrintOut = true;
						}
					}
				}
				finally {
					oDesignDeltas = null;
				}
			}
		} catch (CoreException e) {
			logger.error(e.getMessage(), e);
		}
		if (doPrintOut) {
			debugPrintout();
		}
	}

	/**
	 * Internal call-back from a resourceChanged() add/s/removes IProjectDescriptor for newly opened/closed projects.
	 */
	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		System.out.println("visit " + resource.toString() + " " + delta.getAffectedChildren().length);
		if (resource instanceof IContainer) {
			return true;
		}
		if (resource instanceof IFile) {
			IFile file = (IFile)resource;
			if (O_DESIGN.equals(file.getFileExtension())) {
				List<@NonNull IResourceDelta> oDesignDeltas2 = oDesignDeltas;
				if (oDesignDeltas2 == null) {
					oDesignDeltas = oDesignDeltas2 = new ArrayList<>();
				}
				oDesignDeltas2.add(delta);
			}
			return true;
		}
		return false;
	}
}
