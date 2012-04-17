rem You need to correct the ECLIPSE_LAUNCHER variable below.  It should point to the launcher JAR in your eclipse directory.
set ECLIPSE_LAUNCHER=C:\Eclipse\plugins\org.eclipse.equinox.launcher_1.0.0.v20070606.jar

rem Model project
set MAIN_DIR=..

rem The directory indicated by the -modelProject argument should be neither a parent nor a child directory of the workspace.
set WORKSPACE=%MAIN_DIR%\..\codegenWorkspace

rem Rose2GenModel application
java -jar %ECLIPSE_LAUNCHER% -clean -data %WORKSPACE% -application org.eclipse.gmt.umlx.importer.roseuml.RoseUML2GenModel %MAIN_DIR%\model\library.mdl %MAIN_DIR%\emf\library.genmodel -modelProject %MAIN_DIR% src -modelPluginID library.model -copyright "This is my code." -jdkLevel "5.0" -noQualify -package library library library.xmi org.examples Library

rem Generator application
java -jar %ECLIPSE_LAUNCHER% -clean -data %WORKSPACE% -application org.eclipse.emf.codegen.ecore.Generator -model %MAIN_DIR%\emf\library.genmodel