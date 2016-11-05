package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;

/**
 * An adapter implementation for tracking resource modification.
 */
public class ModificationMonitor implements Adapter
{
	public static @Nullable ModificationMonitor basicGetModificationMonitor(@NonNull Resource resource, @NonNull TransformationExecutor executor) {
		for (Adapter eAdapter : resource.eAdapters()) {
			if (eAdapter instanceof ModificationMonitor) {
				ModificationMonitor monitor = (ModificationMonitor)eAdapter;
				if (monitor.getExecutor() == executor) {
					return monitor;
				}
			}
		}
		return null;
	}

	public static @NonNull ModificationMonitor getModificationMonitor(@NonNull Resource resource, @NonNull TransformationExecutor executor) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter eAdapter : eAdapters) {
			if (eAdapter instanceof ModificationMonitor) {
				ModificationMonitor monitor = (ModificationMonitor)eAdapter;
				if (monitor.getExecutor() == executor) {
					return monitor;
				}
			}
		}
		ModificationMonitor monitor = new ModificationMonitor(resource, executor);
		for (@NonNull EObject eObject : new TreeIterable(resource)) {
			eObject.eAdapters().add(monitor);
		}
		eAdapters.add(monitor);
		return monitor;
	}

	private @NonNull Resource resource;
	private @NonNull TransformationExecutor executor;

	public ModificationMonitor(@NonNull Resource resource, @NonNull TransformationExecutor executor) {
		this.resource = resource;
		this.executor = executor;
	}

	public @NonNull TransformationExecutor getExecutor() {
		return executor;
	}

	@Override
	public @NonNull Resource getTarget() {
		return resource;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ModificationMonitor.class;
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		if (!notification.isTouch())
		{
			Object notifier = notification.getNotifier();
			assert notifier != null;
			IncrementalObjectManager objectManager = (IncrementalObjectManager) executor.getTransformer().getObjectManager();
			switch (notification.getEventType()) {
				case Notification.ADD:
				case Notification.REMOVE: {
					break;
				}
				case Notification.ADD_MANY:
				case Notification.REMOVE_MANY: {
					break;
				}
				case Notification.SET:
				case Notification.UNSET: {
					Object feature = notification.getFeature();
					if (feature instanceof EStructuralFeature) {
						objectManager.modified(notifier, (EStructuralFeature)feature);
					}
					break;
				}
			}
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {}
}
