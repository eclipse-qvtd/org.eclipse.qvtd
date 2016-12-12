package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.ArrayDeque;
import java.util.Deque;
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
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;

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

	public static @NonNull ModificationMonitor getModificationMonitor(@NonNull TypedModelInstance typedModelInstance, @NonNull Resource resource, @NonNull TransformationExecutor executor) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter eAdapter : eAdapters) {
			if (eAdapter instanceof ModificationMonitor) {
				ModificationMonitor monitor = (ModificationMonitor)eAdapter;
				if (monitor.getExecutor() == executor) {
					return monitor;
				}
			}
		}
		ModificationMonitor monitor = new ModificationMonitor(typedModelInstance, resource, executor);
		for (@NonNull EObject eObject : new TreeIterable(resource)) {
			eObject.eAdapters().add(monitor);
		}
		eAdapters.add(monitor);
		return monitor;
	}

	private final AbstractTransformerInternal.Model.@NonNull Incremental typedModelInstance;
	private final @NonNull Resource resource;
	private final @NonNull TransformationExecutor executor;
	private final AbstractTransformer.@NonNull Incremental transformer;
	//	private final @NonNull IncrementalInvocationManager invocationManager;
	private final @NonNull IncrementalObjectManager objectManager;
	private @Nullable Deque<@NonNull Notification> notifications = null;
	private boolean isDisabled = false;

	public ModificationMonitor(@NonNull TypedModelInstance typedModelInstance, @NonNull Resource resource, @NonNull TransformationExecutor executor) {
		this.typedModelInstance = (AbstractTransformerInternal.Model.Incremental)typedModelInstance;
		this.resource = resource;
		this.executor = executor;
		this.transformer = (AbstractTransformer.Incremental) executor.getTransformer();
		//		this.transformer = (AbstractTransformer.Incremental) typedModelInstance.getTransformer();
		//		this.invocationManager = (IncrementalInvocationManager) transformer.getInvocationManager();
		this.objectManager = (IncrementalObjectManager) transformer.getObjectManager();
	}

	protected void addEObject(@NonNull EObject newValue) {
		for (@NonNull EObject eObject : new TreeIterable(newValue, true)) {
			eObject.eAdapters().add(this);
		}
		typedModelInstance.add(newValue, false);
		for (@NonNull EObject eObject : new TreeIterable(newValue, false)) {
			typedModelInstance.add(eObject, true);
		}
	}

	public void dispose() {
		isDisabled = true;
		Deque<@NonNull Notification> notifications2 = notifications;
		if (notifications2 != null) {
			notifications2.clear();
		}
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
		if (isDisabled) {
			return;
		}
		assert notification != null;
		if (notification.isTouch()) {
			return;
		}
		Deque<@NonNull Notification> notifications2 = notifications;
		assert notifications2 == null;
		if (notifications2 != null) {
			notifications2.add(notification);
			return;
		}
		notifications2 = notifications = new ArrayDeque<>();
		do {
			int eventType = notification.getEventType();
			switch (eventType) {
				case Notification.ADD: {
					EObject object2 = (EObject) notification.getNewValue();
					assert object2 != null;
					addEObject(object2);
					break;
				}
				case Notification.REMOVE: {
					EObject object2 = (EObject) notification.getOldValue();
					assert object2 != null;
					removeEObject(object2);
					break;
				}
				case Notification.ADD_MANY: {
					for (Object object : (Iterable<?>)notification.getNewValue()) {
						EObject object2 = (EObject) object;
						assert object2 != null;
						addEObject(object2);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					for (Object object : (Iterable<?>)notification.getOldValue()) {
						EObject object2 = (EObject) object;
						assert object2 != null;
						removeEObject(object2);
					}
					break;
				}
				case Notification.SET:
				case Notification.UNSET: {
					Object notifier = notification.getNotifier();
					assert notifier != null;
					Object feature = notification.getFeature();
					if (feature instanceof EStructuralFeature) {
						objectManager.modified(notifier, (EStructuralFeature)feature);
					}
					break;
				}
			}
			notification = notifications2.peek() != null ? notifications2.pop() : null;
		} while (notification != null);
		notifications = null;
	}

	protected void removeEObject(@NonNull EObject oldValue) {
		for (EObject eObject : new TreeIterable(oldValue, true)) {
			eObject.eAdapters().remove(this);
		}
		//		if (feature instanceof EReference) {
		//			EReference eReference = (EReference)feature;
		//			if (eReference.isContainment()) {
		IncrementalObjectManager objectManager = (IncrementalObjectManager)executor.getTransformer().getObjectManager();
		//			}
		//		}
		for (EObject eObject : new TreeIterable(oldValue, true)) {
			typedModelInstance.remove(eObject);
			objectManager.destroyed(eObject);
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {}
}
