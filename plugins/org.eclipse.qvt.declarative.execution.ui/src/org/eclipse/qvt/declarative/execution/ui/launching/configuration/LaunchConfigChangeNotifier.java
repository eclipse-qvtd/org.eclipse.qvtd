package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

public interface LaunchConfigChangeNotifier {
	
	public void addLaunchConfigChangeListener (LaunchConfigChangeListener listener);
	
	public void notifyLaunchConfigChangeListener ();
	
	public void removeLaunchConfigChangeListener (LaunchConfigChangeListener listener);

}
