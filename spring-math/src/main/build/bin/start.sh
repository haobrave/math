#!/bin/bash
echo -e '************************************************************'
echo -e '**                                                        **'
echo -e '**                    start Tools                         **'
echo -e '**              http://www.dcits.com                      **'
echo -e '**            author:chengliang@dcits.com                 **'
echo -e '**                                                        **'
echo -e '************************************************************'
cd `dirname $0`
BIN_DIR=`pwd`
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/../conf
echo $CONF_DIR
LIB_DIR=$DEPLOY_DIR/../lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
nohup java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -classpath $CONF_DIR:$LIB_JARS com.bob.platform.amscp.AmscpApplication
echo "OK!"
