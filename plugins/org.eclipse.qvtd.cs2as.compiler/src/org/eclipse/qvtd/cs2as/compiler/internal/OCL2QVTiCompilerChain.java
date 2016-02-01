package org.eclipse.qvtd.cs2as.compiler.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class OCL2QVTiCompilerChain extends AbstractCompilerChain {

	public static Key<String> TRACE_PROPERTY_NAME = new Key<String>("tracePropName");

	private @NonNull URI oclASUri;
	private @NonNull List<URI> extendedASUris = new ArrayList<URI>();	
	private @Nullable String traceabilityPropName;
	
	public OCL2QVTiCompilerChain(@NonNull QVTimperative qvti, @Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options,
			String traceabilityProperty, // TODO understand options and use them
			@NonNull URI oclDocURI, @NonNull URI... extendDocURIs) { 
		super(qvti.getEnvironmentFactory(), oclDocURI, options);
		this.traceabilityPropName = traceabilityProperty;
		this.oclASUri = qvti.parse(oclDocURI).getURI();
		for (URI oclDocUri : extendDocURIs) {
			this.extendedASUris.add(qvti.parse(oclDocUri).getURI()); // We add the AS URI
		}
	}

	@Override
	public @NonNull Transformation compile(@NonNull String enforcedOutputName) throws IOException {
		Resource qvtpResource = ocl2qvtp();
		return qvtp2qvti(qvtpResource);
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
			pModel.save(null); // TODO
			for(Resource qvtpModel : qvtpModels) {	// unload unnecessary qvtpModels
				qvtpModel.unload();
			}
		}
		assertNoResourceErrors("pModel", pModel);
		return pModel;
	}
	
	protected Resource ocl2qvtp(URI oclURI) {
		OCL2QVTp ocl2qvtp = new OCL2QVTp(environmentFactory, traceabilityPropName, null); // TODO get the saving options
		return ocl2qvtp.run(environmentFactory.getMetamodelManager().getASResourceSet(),
				oclURI); 
	}
}
