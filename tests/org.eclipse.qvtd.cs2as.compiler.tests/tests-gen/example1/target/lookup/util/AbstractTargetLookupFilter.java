/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.lookup.util;

import example1.target.NamedElement;

/**
 * 
 */
public abstract class AbstractTargetLookupFilter<C extends NamedElement> implements TargetLookupFilter {
	
	private Class<C> _class;
	
	public AbstractTargetLookupFilter(Class<C> _class) {
		this._class = _class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean matches(NamedElement namedElement) {
		return _class.isInstance(namedElement) && _matches((C)namedElement);
	}
	
	abstract protected boolean _matches(C element);
}
