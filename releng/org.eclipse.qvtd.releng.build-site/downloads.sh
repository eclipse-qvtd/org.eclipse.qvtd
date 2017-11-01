#!/bin/bash -xv
#
#	Promote the PUBLISH__URL to the downloads 'page'.
#
#    PUBLISH__URL            The zip to be published e.g. https://hudson.eclipse.org/ocl/job/qvtd-photon-master/25/artifact/releng/org.eclipse.qvtd.releng.build-site/target/org.eclipse.qvtd-0.15.0.v20171025-1600.zip
#    PUBLISH__VERSION        Unqualified version e.g. 0.15.0
#    PUBLISH__BUILD_T        Build type N/I/S, blank suppresses promotion
#    PUBLISH__QUALIFIER      Version qualifier e.g. v20171025-1600
#    PUBLISH__ALIAS          Non blank to use alias as part of final name
#
dropsFolder="/home/data/httpd/download.eclipse.org/mmt/qvtd/downloads/drops/"
group="modeling.mmt.qvtd"
zipPrefix="qvtd-incubation-Update-"

if [ -n "${PUBLISH__BUILD_T}" ]
then

  tQualifier="${PUBLISH__BUILD_T}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  versionFolder="${dropsFolder}${PUBLISH__VERSION}/${tQualifier}"
  if [ ! -d "${versionFolder}" ]
  then
    mkdir -p ${versionFolder}
  fi

  fileStem="${tQualifier}"
  if [ -n "${PUBLISH__ALIAS}" ]
  then
    fileStem=${PUBLISH__ALIAS}
  fi
  zipFile="${zipPrefix}${fileStem}.zip"

  pushd ${versionFolder}
    curl -s -k ${PUBLISH__URL} > ${zipFile}
    md5sum -b ${zipFile} > ${zipFile}.md5
    sha512sum -b ${zipFile} > ${zipFile}.sha1
    # make sure permissions are for the intended group
    chgrp -R ${group} ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
    chmod -R g+w ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
  popd

fi