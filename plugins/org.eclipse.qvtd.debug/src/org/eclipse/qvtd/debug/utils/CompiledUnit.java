package org.eclipse.qvtd.debug.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.debug.stubs.QvtMessage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class CompiledUnit {
	
	private List<Root> modules = new ArrayList<Root>();

	public CompiledUnit(@NonNull Element element) {
		modules.add(PivotUtil.getContainingRoot(element));
	}

	public List<CompiledUnit> getCompiledImports() {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getURI() {
		return URI.createURI(modules.get(0).getExternalURI());
	}

	public @NonNull List<Root> getModules() {
		return modules;
	}

	public List<QvtMessage> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

}
