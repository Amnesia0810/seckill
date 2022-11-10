server_pid=$(jps -l |grep simt-special-issue | awk '{print $1}')
echo "server_pid is " ${server_pid}
echo "now kill simt-special-issue service"
kill -9 ${server_pid}
echo "kill special issue service success"
git pull
mvn clean
mvn package
nohup java -jar ./target/seckill-0.0.1-SNAPSHOT.jar >nohup.out 2>&1 &
