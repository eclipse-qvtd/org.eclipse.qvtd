#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/site.p2 MMT-QVTd.p2.repository
mv buildroot/buckminster.output/org.eclipse.qvtd.releng.build_*-eclipse.feature/zips MMT-QVTd.downloads

set

echo cp MMT-QVTd.downloads /home/data/httpd/download.eclipse.org/mmt/qvtd/downloads/drops/0.11.0/
echo cp MMT-QVTd.p2.repository /home/data/httpd/download.eclipse.org/mmt/qvtd/updates/milestones/0.11.0

ls /opt/public/common

ant -f publishroot/publisher.ant -Dbuild.archives=publishroot &> qvtd-publishing-luna.log 

