package org.eclipse.qvtd.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.utils.Log;

public class QVTiEvaluationContext
{
	private @NonNull URI transformationURI;
	private @NonNull Map<String, URI> inputURIs = new HashMap<String, URI>();
	private @NonNull Map<String, URI> outputURIs = new HashMap<String, URI>();
	private @Nullable Log log;

	public QVTiEvaluationContext(@NonNull URI transformationURI, @NonNull Map<String, URI> inputURIs, @NonNull Map<String, URI> outputURIs) {
		this.transformationURI = transformationURI;
		this.inputURIs = inputURIs;
		this.outputURIs = outputURIs;
	}

	public @Nullable URI getInputURI(@NonNull String name) {
		return inputURIs.get(name);
	}

	public @NonNull Map<String, URI> getInputURIs() {
		return inputURIs;
	}

	public @Nullable Log getLog() {
		return log;
	}

	public @Nullable URI getOutputURI(@NonNull String name) {
		return outputURIs.get(name);
	}

	public @NonNull Map<String, URI> getOutputURIs() {
		return outputURIs;
	}

	public @Nullable URI getTraceFileURI() {
		return null;
	}

	public @NonNull URI getTransformationURI() {
		return transformationURI;
	}

	public void setLog(@NonNull Log log) {
		this.log = log;
	}
}
