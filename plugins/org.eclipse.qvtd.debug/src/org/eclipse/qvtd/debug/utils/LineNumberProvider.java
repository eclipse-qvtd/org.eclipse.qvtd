package org.eclipse.qvtd.debug.utils;

/**
 * An interface for objects providing lines
 */
public interface LineNumberProvider {

    /**
	 * Returns offset of the given line end
	 * 
	 * @param lineNumber -
	 *            number of line (one-based)
	 * @return offset of the last character of the line that is line-delimiter -
	 *         '\n'
	 */
    public int getLineEnd(int lineNumber);
    
    /**
     * @return Number of lines
     */
    public int getLineCount();
    
    /**
	 * Returns number of a line containing given offset
	 * 
	 * @param offset -
	 *            an offset to look for
	 * @return (one-based) line number or -1 if no line found
	 */
    public int getLineNumber(int offset);
}
