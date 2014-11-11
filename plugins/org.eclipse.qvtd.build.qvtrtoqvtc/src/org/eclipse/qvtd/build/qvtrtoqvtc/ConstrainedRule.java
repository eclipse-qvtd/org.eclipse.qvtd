package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConstrainedRule.
 */
public interface ConstrainedRule {
	
	// Execution
	/**
	 * Creare trace.
	 *
	 * @return the trace record
	 */
	public TraceRecord creareTrace();
	
	/**
	 * When.
	 *
	 * @param transformation the transformation
	 * @param args the input elements
	 * @return true, if successful
	 */
	public boolean when(QvtrToQvtcTransformation transformation, List<Object> args);
	
	/**
	 * When.
	 *
	 * @param transformation the transformation
	 * @return true, if successful
	 */
	public boolean when(QvtrToQvtcTransformation transformation);	
	
	/**
	 * Instantiate output elements.
	 *
	 * @param qvtcModelElements the qvtc model elements
	 * @return the list
	 */
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> qvtcModelElements);
	
	/**
	 * Instantiate middle elements.
	 *
	 * @param qvtcMiddleElements the qvtc middle elements
	 * @return the list
	 */
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements);
	
	/**
	 * Sets the attributes.
	 */
	public void setAttributes();
	
	/**
	 * Where.
	 *
	 * @param transformation the transformation
	 */
	public void where(QvtrToQvtcTransformation transformation);
	
	/**
	 * Gets the loop data.
	 *
	 * @param inputModel the input model
	 * @return the loop data
	 */
	public List<List<Object>> getLoopData(Resource inputModel);
}
