del CoreUM.xml /Q
CALL C:\Tools\ModelMorf\pre-beta-4\modelmorf.bat -m QVTMM -mf FlatQVT.xml  -c FlatRelToCore.qvt -u relations -f RelUM.xml -u core -f CoreUM.xml -t relToCore -d core -q enforce
pause