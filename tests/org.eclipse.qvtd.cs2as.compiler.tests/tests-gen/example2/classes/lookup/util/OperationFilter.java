package example2.classes.lookup.util;

import java.util.List;

import example2.classes.Argument;
import example2.classes.Operation;
import example2.classes.Parameter;

public class OperationFilter extends AbstractClassesLookupFilter<Operation> {

	private List<Argument> args;
	
	public OperationFilter(List<Argument> args) {
		super(Operation.class);
		this.args = args;
	}
	
	protected boolean _matches(Operation op) {
		// OCL expression TO be generated
		if (!(args.size() == op.getOwnedParameters().size())) {
			return true;
		}
		boolean forAll = true;
		for (Argument arg : args) {
			Parameter param = op.getOwnedParameters().get(args.indexOf(arg));
			if (!param.getName().equals(arg.getName())) {
				forAll = false;
				break;
			}
		}
		if (forAll) {
			return true;
		}
		return false;
	}
	
}
