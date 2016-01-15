package example2.classes.lookup.util;

import example2.classes.NamedElement;

public abstract class AbstractClassesLookupFilter<C extends NamedElement> implements ClassesLookupFilter {

	private Class<C> _class;
	
	public AbstractClassesLookupFilter(Class<C> _class) {
		this._class = _class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean matches(NamedElement namedElement) {
		return _class.isInstance(namedElement) && _matches((C)namedElement);
	}
	
	abstract protected boolean _matches(C element);
}
