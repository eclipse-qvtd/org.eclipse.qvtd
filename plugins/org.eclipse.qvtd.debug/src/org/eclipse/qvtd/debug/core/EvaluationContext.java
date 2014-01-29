package org.eclipse.qvtd.debug.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.debug.utils.Log;

public class EvaluationContext
{
	private @Nullable URI transformationURI;
	private @NonNull Map<String, URI> inputURIs = new HashMap<String, URI>();
	private @NonNull Map<String, URI> outputURIs = new HashMap<String, URI>();
	private @Nullable Log log;

	public void addInputURI(@NonNull String name, @NonNull URI uri) {
		inputURIs.put(name,  uri);
	}

	public void addOutputURI(@NonNull String name, @NonNull URI uri) {
		outputURIs.put(name,  uri);
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

	public @Nullable URI getTransformationURI() {
		return transformationURI;
	}

	public void setLog(@NonNull Log log) {
		this.log = log;
	}
	
	public void setTransformationURI(@NonNull URI uri) {
		this.transformationURI = uri;
	}
}
