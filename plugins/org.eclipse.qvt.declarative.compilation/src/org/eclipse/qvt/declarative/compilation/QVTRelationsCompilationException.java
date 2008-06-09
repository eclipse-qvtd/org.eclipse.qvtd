package org.eclipse.qvt.declarative.compilation;

public class QVTRelationsCompilationException extends
		DeclarativeQVTCompilationException {

	public QVTRelationsCompilationException(int lineNumber, int startCharacter,
			int endCharacter) {
		super(lineNumber, startCharacter, endCharacter);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2611237267419675520L;

}
