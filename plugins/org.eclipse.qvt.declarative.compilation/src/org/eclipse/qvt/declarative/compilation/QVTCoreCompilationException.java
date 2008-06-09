package org.eclipse.qvt.declarative.compilation;

public class QVTCoreCompilationException extends
		DeclarativeQVTCompilationException {

	public QVTCoreCompilationException(int lineNumber, int startCharacter,
			int endCharacter) {
		super(lineNumber, startCharacter, endCharacter);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613629919927749266L;

}
