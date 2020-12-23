#!/bin/sh
amscp=`ps -ef |grep amscp | grep -v grep | awk '{print $2}'`
kill -9 $amscp
