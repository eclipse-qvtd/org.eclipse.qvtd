package org.eclipse.qvt.declarative.execution.ui.monitoring;

import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;
import org.eclipse.qvt.declarative.execution.ExecutionService;
import org.eclipse.swt.graphics.Image;

public class ExecutionEngineLabelProvider implements ILabelProvider {

	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(Object element) {
		if (element instanceof Map<?,?>) {
			return ExecutionService.class.getSimpleName();
		}
		if (element instanceof Map.Entry<?, ?>) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) element;
			ProviderDescriptor.Priority priority = (ProviderDescriptor.Priority) entry.getKey();
			return priority.name();
		}
		if (element instanceof Provider) {
			Provider provider = (Provider) element;
			if (provider instanceof ProviderDescriptor) {
				ProviderDescriptor descriptor = (ProviderDescriptor) provider;
				return descriptor.getDescribedProvider().getClass().getSimpleName();
			}
			return provider.getClass().getName();
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

}
