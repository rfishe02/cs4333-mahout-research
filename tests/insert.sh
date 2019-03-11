#!/bin/bash

mysql -h localhost -u dbuser -pmariadb cs4333 < cmds.txt

#query="insert into FILES (name,type,date,station) VALUES('$archivoF','$tipoOb','$fcha','$st')"
#mysql -h dbhost -u dbuser -ppassword mariadb -e "$query"
