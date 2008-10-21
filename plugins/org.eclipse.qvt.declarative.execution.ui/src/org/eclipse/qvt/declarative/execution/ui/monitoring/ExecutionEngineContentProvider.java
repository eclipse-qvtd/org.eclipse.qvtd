package org.eclipse.qvt.declarative.execution.ui.monitoring;

import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;
import org.eclipse.qvt.declarative.execution.ExecutionService;

public class ExecutionEngineContentProvider implements ITreeContentProvider {

	ExecutionService service;
	
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ExecutionService) {
			ExecutionService service = (ExecutionService) parentElement;
			Map<ProviderDescriptor.Priority, Provider[]> map = service.getProviders();
			return new Object[]{map};
		}
		if (parentElement instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) parentElement;
			return map.entrySet().toArray();
		}
		if (parentElement instanceof Map.Entry<?, ?>) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) parentElement;
			return (Object[])entry.getValue();
		}
		return null;
	}

	public Object getParent(Object element) {
//		if (element instanceof ExecutionService) {
//			return null;
//		}
		if (element instanceof Map<?, ?>) {
			return service;
		}
		if (element instanceof Map.Entry<?, ?>) {
			return service.getProviders();
		}
		if (element instanceof Provider) {
			Provider provider = (Provider) element;
			for(Map.Entry<ProviderDescriptor.Priority, Provider[]> entry : service.getProviders().entrySet()){
				for (Provider currentPriorityProvider : entry.getValue()) {
					if (provider == currentPriorityProvider) {
						return entry.getKey();
					}
				}
			}
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Map<?,?>) {
			return true;
		}
		if (element instanceof Map.Entry<?, ?>) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) element;
			Provider[] providers = (Provider[])entry.getValue();
			return providers.length > 0;
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ExecutionService) {
			ExecutionService executionService = (ExecutionService) inputElement;
			return getChildren(executionService);
		}
		return null;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof ExecutionService) {
			service = (ExecutionService) newInput;
		}
		
	}
}
