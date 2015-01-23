package org.eclipse.qvtd.examples.qvtrelation.modelmorf.abstracttoconcrete;

import java.io.File;
import java.io.FileWriter;

import adex.dom.IMObject;
import adex.dom.x.IMWorkSpace;

public class AbstractToConcrete_ext {

	
	public static IMObject print(IMObject c1, IMObject c2, IMWorkSpace e2Workspace) throws Exception {
		String fileName = "C:/ModelMorf/Example/AbstractToConcrete/a2clog.txt";
		fileName = null;
		File f = new File(fileName);
		if (f.canWrite()) {
			throw new Exception("bingo");
		}
		f = null;
		FileWriter fw = new FileWriter(f, false);
		fw.write(c1.toString());
		fw.flush();
		fw.close();
        return c2;
	}
}
