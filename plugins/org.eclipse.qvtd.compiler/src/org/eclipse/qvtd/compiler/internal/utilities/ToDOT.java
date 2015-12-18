package org.eclipse.qvtd.compiler.internal.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.schedule.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

/**
 * Debug assist. An instance of ToDOT may be used to provide a debugger facility to serialize a
 * DOT image description of a ToDOTable as a string when the the instance is selected. The string may then be pasted
 * to a *.dot file for display in an Eclipse GraphViz (TextUML) Image Viewer. 
 */
public class ToDOT
{
	public interface ToDOTable
	{
		void toGraph(@NonNull GraphStringBuilder s);
	}
	
	private final @NonNull ToDOTable toDot;
	
	public ToDOT(@NonNull ToDOTable toDot) {
		this.toDot = toDot;
	}
	
	@Override
	public String toString() {
		DOTStringBuilder s = new DOTStringBuilder();
		toDot.toGraph(s);
		return s.toString();
	}
}