package org.eclipse.qvtd.debug.launching;

import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

public abstract class QvtLaunchConfigurationDelegateBase extends LaunchConfigurationDelegate {
/*    @Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode) throws CoreException {
    	IFile moduleFile = getModuleFile(configuration);
    	if (moduleFile == null || !moduleFile.exists()) {
    		return new IProject[0];
    	}
        return new IProject[] { moduleFile.getProject() };
    } */
 
/*    public static QvtModule getQvtModule(ILaunchConfiguration configuration) throws CoreException {
        String moduleName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
		try {
			return TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleName));
		} catch (MdaException e) {
        	IStatus errorStatus = MiscUtil.makeErrorStatus(e.getMessage());
        	throw new CoreException(errorStatus);
		}
    } */

/*    public static IFile getModuleFile(ILaunchConfiguration configuration) throws CoreException {
        String moduleFileName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        IFile moduleFile = WorkspaceUtils.getWorkspaceFile(moduleUri);
        if(moduleFile == null) {
        	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
        		//	NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	//throw new CoreException(errorStatus);
        }
        
        return moduleFile;
    } */

/*    public static IStatus validate(QvtTransformation transformation, ILaunchConfiguration configuration) throws CoreException {
    	List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        boolean useTraceFile = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false); 
        
        try {
        	return QvtValidator.validateTransformation(transformation, targetUris, traceFile, useTraceFile, ValidationType.FULL_VALIDATION);
        }
        catch (MdaException ex) {
        	throw new CoreException(StatusUtil.makeErrorStatus(ex.getMessage(), ex));
        }
    } */
    
/*    public static void doLaunch(QvtTransformation transformation, ILaunchConfiguration configuration, IContext context) throws Exception {
    	List<ModelContent> inObjects = new ArrayList<ModelContent>();
    	List<TargetUriData> targetData = new ArrayList<TargetUriData>();
		List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
		
		Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            throw new MdaException(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			TargetUriData nextUri = itrTargetData.next();
			if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
		        URI inUri = toUri(nextUri.getUriString());
		        ModelContent inModel = transformation.loadInput(inUri);
		        inObjects.add(inModel);
			}
			if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
				targetData.add(nextUri);
			}
		}

        boolean saveTrace = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false);
        String traceFileName = saveTrace ? configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, "") : null; //$NON-NLS-1$
        
        doLaunch(transformation, inObjects, targetData, traceFileName, context);
    } */
    
/*    public static List<URI> doLaunch(final QvtTransformation transformation, final List<ModelContent> inObjs,
    		List<TargetUriData> targetData, Map<String, Object> configProps, final String traceFileName) throws Exception {
    	return doLaunch(transformation, inObjs, targetData, traceFileName, QvtLaunchUtil.createContext(configProps));
    } */

/*    public static void doLaunch(QvtTransformation transformation, List<ModelContent> inObjs, Map<String, Object> configProps,
    		List<ModelExtentContents> outExtents, List<EObject> outMainParams, List<Trace> outTraces, List<String> outConsole) throws MdaException {

        IStatus status = QvtValidator.validateTransformation(transformation, inObjs, null);                    
        if (status.getSeverity() > IStatus.WARNING) {
        	throw new MdaException(status);
        }      	
    	
        Context context = QvtLaunchUtil.createContext(configProps);

		final StringWriter consoleLogger = new StringWriter();
		context.setLog(new WriterLog(consoleLogger));
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new ModelContent[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);

        outExtents.addAll(out.getExtents());

        for (Object outValue : out.getOutParamValues()) {
        	if (outValue instanceof EObject) {
        		outMainParams.add((EObject) outValue);
        	}
        	else {
        		outMainParams.add(null);
        	}
        }
        
        if (out.getTrace() != null) {
        	outTraces.add(out.getTrace());
        }
        outConsole.add(consoleLogger.getBuffer().toString());
    } */
        
/*    public static List<URI> doLaunch(final QvtTransformation transformation, final List<ModelContent> inObjs,
    		List<TargetUriData> targetData, final String traceFileName, IContext context) throws Exception {
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new ModelContent[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);

        ResourceSet resSet = null;
        for (ModelContent inModel : inObjs) {
			resSet = inModel.getResourceSet();
			if(resSet != null) {
				break;
			}
		}        
        if(resSet == null) {
        	resSet = EmfUtil.getOutputResourceSet();
        }

        Iterator<ModelExtentContents> itrExtent = out.getExtents().iterator();
        for (TargetUriData outUriData : targetData) {
        	if (!itrExtent.hasNext()) {
        		throw new MdaException("Imcomplete transformation results"); //$NON-NLS-1$
        	}
        	saveTransformationResult(itrExtent.next(), outUriData, resSet);
        }

        List<URI> result = new ArrayList<URI>(out.getOutParamValues().size());
        for (Object outValue : out.getOutParamValues()) {
        	if (outValue instanceof EObject) {
        		result.add(EcoreUtil.getURI((EObject) outValue));
        	}
        	else {
        		result.add(null);
        	}
        }
        
        if(traceFileName != null && out.getTrace() != null) {
        	URI traceUri = EmfUtil.makeUri(traceFileName);
           	TraceSerializer traceSerializer = new TraceSerializer(out.getTrace());
           	traceSerializer.saveTraceModel(traceUri);
           	traceSerializer.markUnboundObjects(traceUri);
        }
        
        return result;
    } */
    
/*    @SuppressWarnings("unchecked")
	private static void saveTransformationResult(ModelExtentContents extent, TargetUriData targetData, ResourceSet resSet) throws MdaException {    	
    	URI outUri = toUri(targetData.getUriString());
    	
        switch(targetData.getTargetType()) {
        	case NEW_MODEL: {
        		try {
            		ModelExtentHelper.saveExtentToResources(extent.getAllRootElements(), resSet, outUri);
        		}
        		catch(EmfException e) {
        			throw new MdaException(e);
        		}
        		break;
        	}
        	
        	case EXISTING_CONTAINER: {
        		ModelContent loadModel = EmfUtil.loadModel(outUri, resSet);
	        	EObject container = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
	            if(container == null) {
	                throw new MdaException("No object at " + outUri); //$NON-NLS-1$
	            }
	            
		        EStructuralFeature feature = container.eClass().getEStructuralFeature(targetData.getFeature());
		        if (feature == null) {
	                throw new MdaException("Reference " + targetData.getFeature() + " not found in " + container); //$NON-NLS-1$ //$NON-NLS-2$
		        }

		        if (targetData.isClearContents() && FeatureMapUtil.isMany(container, feature)) {
		        	List<EObject> value = (List<EObject>) container.eGet(feature);
		        	if (value != null) {
		        		value.clear();
		        	}
		        }
		        
        		for (EObject out : extent.getAllRootElements()) {
			        if (FeatureMapUtil.isMany(container, feature)) {
			        	List<EObject> value = (List<EObject>) container.eGet(feature);
			        	try {
			        		value.add(out);
			        	}
			        	catch (RuntimeException ex) {
			        		throw new MdaException(NLS.bind(Messages.QvtLaunchConfigurationDelegateBase_FeatureSetFailure,
			        				EmfUtil.getFullName(out.eClass()), targetData.getFeature()));
			        	}
			        }
			        else {
			        	container.eSet(feature, out);
			        }
        		}
        		
		        try {
		        	saveResource(container);
		        }
		        catch(IOException e) {
		        	throw new MdaException(e.getMessage(), e);
		        }
		        
		        break;
        	}
        	
        	case INPLACE: {
       			throw new MdaException(Messages.QvtValidator_InplaceConfigNotSupported);
        	}
        }
        
        org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.refresh(outUri);
    } */

/*	private static void saveResource(EObject obj) throws IOException {
    	Resource resource = obj.eResource();
    	if(resource == null) {
    		Logger.getLogger().warning("Object has no resource: " + obj); //$NON-NLS-1$
    		return;
    	}

		resource.save(EmfUtil.DEFAULT_SAVE_OPTIONS);
	} */

/*    private static URI toUri(String uriString) throws MdaException {
        URI uri = URI.createURI(uriString);  
        if(uri == null) {
            throw new MdaException(NLS.bind(Messages.QvtValidator_InvalidUri, uriString));
        }
        
        return uri;
    } */
    
}
