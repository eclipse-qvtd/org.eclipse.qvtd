package org.eclipse.qvt.declarative.compilation;

public abstract class DeclarativeQVTCompilationException extends Exception {

	protected int lineNumber;
	
	protected int startCharacter;
	
	protected int endCharacter;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1492308790290465113L;

	public DeclarativeQVTCompilationException(int lineNumber,
			int startCharacter, int endCharacter ) {
		super();
		this.lineNumber = lineNumber;
		this.startCharacter = startCharacter;
		this.endCharacter = endCharacter;
	}

	
	
}
