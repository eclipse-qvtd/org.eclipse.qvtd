package org.eclipse.qvtd.cs2as.compiler.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class OCL2QVTiCompilerChain extends AbstractCompilerChain {

	public @NonNull static final String DEFAULT_TRACE_PROPERTY_NAME = "ast"; 
	public @NonNull static final Key<String> TRACE_PROPERTY_NAME_KEY = new Key<String>("ocl2qvtp.tracePropName");

	private @NonNull URI oclASUri;
	private @NonNull List<URI> extendedASUris = new ArrayList<URI>();	
	private @Nullable String traceabilityPropName;
	
	/**
	 * To provide a different traceabilityPropName different to the default {@link OCL2QVTiCompilerChain#DEFAULT_TRACE_PROPERTY_NAME "ast"} one,
	 * it must be passed as an option using the {@link #TRACE_PROPERTY_NAME_KEY TRACE_PROPERTY_NAME_KEY} and the {@link CompilerChain#QVTP_STEP QVTP_STEP}
	 * 
	 * @param qvti mandatory {@link QVTimperative} instance
	 * @param options optional options
	 * @param oclDocURI the mandatory main OCL document URI to compile
	 * @param extendedDocURIs optional OCL document URIs that the main one extends
	 */
	public OCL2QVTiCompilerChain(@NonNull QVTimperative qvti, @Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options,			
			@NonNull URI oclDocURI, URI... extendedDocURIs) { 
		super(qvti.getEnvironmentFactory(), oclDocURI, options);
		this.traceabilityPropName = getTraceabilityPropertyName();
		this.oclASUri = qvti.parse(oclDocURI).getURI();
		for (URI oclDocUri : extendedDocURIs) {
			this.extendedASUris.add(qvti.parse(oclDocUri).getURI()); // We add the AS URI
		}
	}

	@Override
	public @NonNull Transformation compile(@NonNull String enforcedOutputName) throws IOException {
		return qvtp2qvti(ocl2qvtp());
	}
	
	public @NonNull Transformation compile() throws IOException {
		return compile("");
	}
	
	protected Resource ocl2qvtp() throws IOException { 
		Resource pModel = ocl2qvtp(oclASUri);
		if (!extendedASUris.isEmpty()) {
			List<Resource> qvtpModels = new ArrayList<Resource>();
			for (URI extendedQVTpModel : extendedASUris) {
				qvtpModels.add(ocl2qvtp(extendedQVTpModel));
			}
			QVTpModelsMerger.merge(environmentFactory , pModel, qvtpModels);
			saveResource(pModel, QVTP_STEP);
			for(Resource qvtpModel : qvtpModels) {	// unload unnecessary qvtpModels
				qvtpModel.unload();
			}
		}
		return pModel;
	}
	
	protected Resource ocl2qvtp(URI oclURI) throws IOException {
		OCL2QVTp ocl2qvtp = new OCL2QVTp(environmentFactory, traceabilityPropName);
		Resource pResource = ocl2qvtp.run(environmentFactory.getMetamodelManager().getASResourceSet(), oclURI);
		saveResource(pResource, QVTP_STEP);
		return pResource;
	}
	
	private @NonNull String getTraceabilityPropertyName() {
		String tracePropName = getOption(QVTP_STEP, TRACE_PROPERTY_NAME_KEY);
		return tracePropName == null ? DEFAULT_TRACE_PROPERTY_NAME : tracePropName;
	}
	@Override
	protected @NonNull Transformation qvtp2qvti(@NonNull Resource pResource) throws IOException {
		rewriteSafeNavigations(pResource);
		return super.qvtp2qvti(pResource);
	}

	// FIXME this workaround produces a new traversal of the resource
	private void rewriteSafeNavigations(@NonNull Resource resource) {
		for (EObject rootObject : resource.getContents()) {
			if (rootObject instanceof Element) {
				QVTbaseUtil.rewriteSafeNavigations(environmentFactory, (Element) rootObject);
			}
		}
	}
}
