- You need to get a copy of ModelMorf and have a valid licence. Download links and licence information can be found here: http://www.tcs-trddc.com/trddc_website/ModelMorf/ModelMorf.htm
- You need to create two substition strings in your Eclipse (Windows->Preferences->Run/Debug->String Substitution)
    - java_15: Should point to the java.exe of a Java 1.5 32-bit JVM executable.
    - modelmorf: Should point to your ModelMorf installation path (i.e. C:\ModelMorf).
- The workspace or git repository where the plugins exists can not have spaces in the path.
- The *.qvt file is a copy of the *.qvtr file with some minor modifications due to syntax differences between ModelMorf and Eclipse QVTd concrete syntax. Hence, if you want to modify the source, recommended approach is to do it in the *.qvtr file to take advantage of error highlighting and type resolution and then copy the changes to the *.qvt file.
- ModelMorf requires that all metamodels and models are *.xml files. Read "Modeling with EMF Editor.pdf" in your ModelMorf /Examples folder for a guide on how to get the xml files from Ecore and XMI files. 
 