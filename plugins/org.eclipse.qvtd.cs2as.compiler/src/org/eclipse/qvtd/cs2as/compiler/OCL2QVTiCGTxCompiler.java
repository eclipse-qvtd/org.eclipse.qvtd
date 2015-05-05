package org.eclipse.qvtd.cs2as.compiler;



import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiBroker;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

public class OCL2QVTiCGTxCompiler implements OCL2JavaTxCompiler<CS2ASJavaCompilerParameters> {

	static {
		CompleteOCLStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
	}
		
	@Override
	public Class<? extends CS2ASTransformation> compileTransformation(@NonNull URI oclDocURI, @NonNull CS2ASJavaCompilerParameters params, @Nullable ResourceSet rSet) throws Exception {
		
		QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, rSet);
		try {
			PivotModel qvtiTransf = executeOCL2QVTi_MTC(qvt, oclDocURI.trimSegments(1), oclDocURI.lastSegment());
			return createCompiler().compileTransformation(qvt, qvtiTransf.getTransformation(), (CS2ASJavaCompilerParameters) params);	
		} finally {
			qvt.dispose();	
		}
	}
	
	protected CS2ASJavaCompilerImpl createCompiler() {
		return new CS2ASJavaCompilerImpl();
	}
	
	/**
	 * @param qvt
	 * @param baseURI
	 * @param oclDocName
	 * @return the {@link PivotModel} corresponding to the final QVTi transformation
	 * @throws Exception
	 */
	protected PivotModel executeOCL2QVTi_MTC(OCL qvt, URI baseURI, String oclDocName) throws Exception {
		
		// Map<?, ?> savingOptions = this.savingOptions == null ? XMIUtil.createSaveOptions() : this.savingOptions;
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, qvt, null);
    	mtc.execute();
    	return mtc.getiModel();
	}
}
