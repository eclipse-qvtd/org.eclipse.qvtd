/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.doc.miniocl.lookup.util;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The lookup result returned by the name lookup solver
 */
public interface MiniOCLLookupResult<NE> {

	@Nullable
	NE getSingleResult();
	
	@NonNull
	List<NE> getAllResults();
	
	int size();
}
