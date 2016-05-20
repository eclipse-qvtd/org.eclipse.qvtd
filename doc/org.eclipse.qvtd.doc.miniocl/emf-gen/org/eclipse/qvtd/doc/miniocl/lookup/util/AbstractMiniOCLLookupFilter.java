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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.NamedElement;

/**
 * 
 */
public abstract class AbstractMiniOCLLookupFilter<C extends NamedElement> implements MiniOCLLookupFilter {
	
	@NonNull private Class<C> _class;
	
	public AbstractMiniOCLLookupFilter(@NonNull Class<C> _class) {
		this._class = _class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean matches(@NonNull NamedElement namedElement) {
		return _class.isInstance(namedElement) && _matches((C)namedElement);
	}
	
	abstract protected Boolean _matches(@NonNull C element);
}
