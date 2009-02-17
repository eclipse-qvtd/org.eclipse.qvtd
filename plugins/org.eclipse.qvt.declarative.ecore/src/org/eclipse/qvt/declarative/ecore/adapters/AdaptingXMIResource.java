/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AdaptingXMIResource.java,v 1.3 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.SAXXMIHandler;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

/**
 * An AdaptingXMIResource supports an XMIResource that is an adaptation of some other Resource.
 * Typically this may be used to support an EMOF representation of an Ecore model.
 * Loading and saving the adapting resource loads and saves from the adapting representation.
 * Loading and saving the adapted resource loads and saves from the adapted representation.
 * 
 * The adapting resource has no inherited contents since all content is maintained as adapters of the
 * adapted content. Access to getContents() and transitively to all other content accessors return
 * adapters that obtain their state from the adapted model.
 * 
 * The adapting resource delegates getID/setID to the adapted resource.
 * 
 * The adapting resource may have a distinct URI in which case the adapting resource
 * is contained  in a ResourceSet. If the URI is null or the same as the adapted
 * resource, the adapting resource is in no REsourceSet but still provides a non-null
 * return to getResourceSet by delegating to the adapted resource.
 * 
 * The adapting resource transiently maintains a set of extension objects. These are created
 * during preSave and destroyed during postSave, or created during load and destroyed during postLoad.
 * 
 * Typical preparation is:
 *		AdaptingXMIResourceFactory factory = new AdaptingXMIResourceFactory(EMOFPackage.eINSTANCE, XXXMappingMetaData.INSTANCE);
 * or:
 * 		AdaptingXMIResourceFactory factory = new XXXResourceFactoryImpl();
 * 
 * 		MappingMetaDataRegistry mappingMetaDataRegistry = factory.getMappingMetaDataRegistry();
 *		ResourceSet resourceSet = new ResourceSetImpl();
 * then typical usage is:
 * 		XMIResource ecoreResource = factory.createResource(ecoreURI);
 * 		XMIResource adaptingResource = mappingMetaDataRegistry.getAdapter(ecoreResource, adaptingURI);
 * 		adaptingResource.save(...);
 * or:
 * 		XMIResource adaptingResource = resourceSet.loadResource(adaptingURI, true);
 * 		XMIResource ecoreResource = ((AdaptingXMIResource) adaptingResource).getTarget();
 */
public class AdaptingXMIResource extends XMIResourceImpl implements Adapter
{
	public static AdaptingXMIResource findAdapter(Resource resource) {
		for (Adapter eAdapter : resource.eAdapters())
			if (eAdapter instanceof AdaptingXMIResource)
				return (AdaptingXMIResource) eAdapter;
		return null;
	}
	
	/**
	 * Return true if ecoreObject is part of a resource that is loading.
	 * <p>
	 * FIXME The Resource.isLoading should be correct.
	 * <p>
	 * but access protection prevents maintenance of the status in the
	 * adapted resource.
	 * 
	 * @param ecoreObject
	 * @return
	 */
	public static boolean isLoading(EObject ecoreObject) {
		Resource resource = ecoreObject.eResource();
		if ((resource != null) && resource.isLoaded()) {
			for (Adapter eAdapter :  resource.eAdapters()) {
				if (eAdapter instanceof AdaptingXMIResource)
					if (((AdaptingXMIResource)eAdapter).isLoading())
						return true;
			}
		}
		return false;
	}
	
	protected final Resource target;
	protected final IMappingMetaDataRegistry mappingMetaDataRegistry;
	protected boolean hasDistinctIDs = false;
	protected boolean loadInProgress = false;
	protected boolean saveInProgress = false;

	public AdaptingXMIResource(Resource target, URI uri, IMappingMetaDataRegistry mappingMetaDataRegistry) {
		super(uri);
		this.target = target;
		this.mappingMetaDataRegistry = mappingMetaDataRegistry;
		Boolean useDeprecatedLoadMethods = Boolean.TRUE;	// FIXME false gives load only problems on whether adaptedPackage is a demandedPackage
//		Boolean useDeprecatedSaveMethods = Boolean.FALSE;	// TRUE or FALSE is fine
		setEncoding("UTF-8");
		//	Ensure referenced packages are resolved
		getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, mappingMetaDataRegistry);
		//	Use new methods
	    getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, useDeprecatedLoadMethods);
//		resource.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, mappingMetaDataRegistry);
		//	Use xmi:type rather than xsi:type just like EMOF
	    getDefaultSaveOptions().put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
	    getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));
		//	Use new methods
//	    getDefaultSaveOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, useDeprecatedSaveMethods);
	}

	@Override protected XMLHelper createXMLHelper() {
	    return new XMIHelperImpl(this)
	    {
			@Override public EObject createObject(EFactory factory, EClassifier type) {
				IMappingMetaData mappingMetaData = mappingMetaDataRegistry.getMappingMetaData((EClass) type);
				if (mappingMetaData != null)		// No change for XMLTypePackage
					factory = mappingMetaDataRegistry.getMappingMetaDataFactory(mappingMetaData);
				return super.createObject(factory, type);
			}
			
			@Override
			public EClassifier getType(EFactory factory, String typeName) {
				EClassifier eClassifier = super.getType(factory, typeName);
				if ((eClassifier == null) && (factory instanceof IMappingMetaData.Factory)) {
					List<IMappingMetaData> merges = ((IMappingMetaData.Factory) factory).getMappingMetaData().getMerges(); // FIXME casts
					for (IMappingMetaData merge : merges) {
						EPackage ePackage = merge.getAdaptingEPackage();
						eClassifier = getMappingMetaDataRegistry().getType(ePackage, typeName);
						if (eClassifier != null)
							return eClassifier;
					}
				}
				return eClassifier;
			}

			@Override
			public Object getValue(EObject obj, EStructuralFeature f) {
				Object value = super.getValue(obj, f);
				if (value instanceof AdaptingInternalEList<?,?>) {
					boolean hasXmiExtension = false;
//					for (Object v : (List<?>)value) {
					for (Object v : ((AdaptingInternalEList<?,?>)value).basicList()) {
						if (((AdaptingEObject)v).isXmiExtension()) {
							hasXmiExtension = true;
							break;
						}
					}
					if (hasXmiExtension) {
						List<Object> newList = new BasicInternalEList<Object>(EObject.class);
//						for (Object v : (List<?>)value) {
						for (Object v : ((AdaptingInternalEList<?,?>)value).basicList()) {
							if (!((AdaptingEObject)v).isXmiExtension())
								newList.add(v);
						}
						value = newList;
					}
				}
				return value;
			}
	    };
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new XMILoadImpl(createXMLHelper()) {

			@Override
			protected DefaultHandler makeDefaultHandler() {
			    return new SAXXMIHandler(resource, helper, options) {

					@Override
					protected void processElement(String name, String prefix,
							String localName) {
						try {
							super.processElement(name, prefix, localName);
						} catch (NotAdapterException e) {
						      error
						        (new AdapterNotFoundException
						           (e.getMessage(),
						            getLocation(),
						            getLineNumber(),
						            getColumnNumber()));
						}
					}		    	
			    };
			}
			
		};
	}

	/**
	 * Create a modified XMISave that always uses xmi:XMI so that the resulting EMOF complies
	 * with XMI.xsd.
	 */
	@Override protected XMLSave createXMLSave() {
	    return new XMISaveImpl(createXMLHelper())
	    {
			@Override protected Object writeTopObject(EObject top) {
				return super.writeTopObjects(getContents());	// Force xmi:XMI root element even if only a single top object
			}
	    };
	}

	@Override public void doLoad(InputSource inputSource, Map<?, ?> options) throws IOException {
		assert !loadInProgress && !saveInProgress;
		loadInProgress = true;
		try {
			preLoad();
			super.doLoad(inputSource, options);
			postLoad();
		}
		finally {
			loadInProgress = false;
		}
	}

	@Override public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		assert !loadInProgress && !saveInProgress;
		loadInProgress = true;
		try {
			preLoad();
			super.doLoad(inputStream, options);
			postLoad();
		}
		finally {
			loadInProgress = false;
		}
	}

	@Override public void doLoad(Node node, Map<?, ?> options) throws IOException {
		assert !loadInProgress && !saveInProgress;
		loadInProgress = true;
		try {
			preLoad();
			super.doLoad(node, options);
			postLoad();
		}
		finally {
			loadInProgress = false;
		}
	}

	@Override public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		assert !loadInProgress && !saveInProgress;
		saveInProgress = true;
		try {
			preSave();
			super.doSave(outputStream, options);
			postSave();
		}
		finally {
			saveInProgress = false;
		}
	}

	@Override public void doSave(Writer writer, Map<?, ?> options) throws IOException {
		assert !loadInProgress && !saveInProgress;
		saveInProgress = true;
		try {
			preSave();
			super.doSave(writer, options);
			postSave();
		}
		finally {
			saveInProgress = false;
		}
	}

	protected List<EObject> getAllTargetContents() {
		List<EObject> allContents = new ArrayList<EObject>(1024);
		for (TreeIterator<EObject> iterator = target.getAllContents(); iterator.hasNext(); )
			allContents.add(iterator.next());
		return allContents;
	}

	@Override public EList<EObject> getContents() {
		return mappingMetaDataRegistry.getAdapters(target.getContents());
	}

	@Override public EObject getEObject(String uriFragment) {
		if (hasDistinctIDs)
			return super.getEObject(uriFragment);
		EObject eObject = null;
		if (target instanceof XMIResourceImpl)
			eObject = ((XMIResourceImpl) target).getIDToEObjectMap().get(uriFragment);
		if (eObject == null)
			eObject = target.getEObject(uriFragment);
		if (eObject == null)
			return null;
		return loadInProgress || saveInProgress ? mappingMetaDataRegistry.getAdapter(eObject) : eObject;
	}

	@Deprecated
	@Override public Map<EObject, String> getEObjectToIDMap() {
		if (hasDistinctIDs)
			return super.getEObjectToIDMap();
		throw new UnsupportedOperationException(getClass().getName() + ".getEObjectToIDMap");
	}

	@Override public String getID(EObject object) {
		if (hasDistinctIDs || !(target instanceof XMLResource))
			return super.getID(object);
		return object instanceof Adapter ? ((XMLResource) target).getID((EObject)((Adapter)object).getTarget()) : null;
	}

	@Deprecated
	@Override public Map<String, EObject> getIDToEObjectMap() {
		if (hasDistinctIDs)
			return super.getIDToEObjectMap();
		throw new UnsupportedOperationException(getClass().getName() + ".getIDToEObjectMap");
	}

	public IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		return mappingMetaDataRegistry;
	}

	@Override
	public ResourceSet getResourceSet() {
		return getTarget().getResourceSet();
	}

	public Resource getTarget() {
		return target;
	}

	@Override public URI getURI() {
		URI uri = super.getURI();
		return uri != null ? uri : target.getURI();
	}

	public boolean isAdapterForType(Object type) {
		return (type instanceof Class<?>) && ((Class<?>)type).isAssignableFrom(getClass());
	}

	public void notifyChanged(Notification notification) {}

	/**
	 * After a load it is necessary to transfer the xmi:Extensions from the extension map
	 * to the adapted model and repair the id map for resolved EMOF Property elements. 
	 */
	protected void postLoad() {
		List<EObject> allTargets = getAllTargetContents();
		for (EObject aTarget : allTargets)					// Flattened loop avoids CMEs
			mappingMetaDataRegistry.postLoad(aTarget);		// FIXME Catch exceptions and log errors
		if (eObjectToExtensionMap != null)
	    	eObjectToExtensionMap.clear();
	}

	protected void postSave() {
		List<EObject> allTargets = getAllTargetContents();
		for (EObject aTarget : allTargets)					// Flattened loop avoids CMEs
			mappingMetaDataRegistry.postSave(aTarget);
		if (eObjectToExtensionMap != null)
			eObjectToExtensionMap.clear();
	}

	protected void preLoad() {
		List<EObject> allTargets = getAllTargetContents();
		for (EObject aTarget : allTargets)					// Flattened loop avoids CMEs
			mappingMetaDataRegistry.preLoad(aTarget);
		if (eObjectToExtensionMap != null)
			eObjectToExtensionMap.clear();
	}

	/**
	 * Prior to a save it is necessary to populate the extension map with any adapted content that is
	 * maintained as xmi:Extensions.
	 */
	protected void preSave() {
	    if (eObjectToExtensionMap != null)
	    	getEObjectToExtensionMap().clear();
		List<EObject> allTargets = getAllTargetContents();
		for (EObject aTarget : allTargets)					// Flattened loop avoids CMEs
			mappingMetaDataRegistry.preSave(aTarget);
	}
	
	@Override public void setID(EObject object, String id) {
		if (hasDistinctIDs || !(target instanceof XMLResource))
			super.setID(object, id);
		else if (object instanceof Adapter)
			((XMLResource) target).setID((EObject)((Adapter)object).getTarget(), id);
	}

	public void setTarget(Notifier newTarget) {
		if (target != newTarget)
			throw new UnsupportedOperationException(getClass().getName() + ".setTarget");
	}
	
	@Override
	public String toString() {
		return "Adapter(" + MappingUtils.formatLocalName(target) + ")";
	}
}
