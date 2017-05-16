set CLASSPATH=%CLASSPATH%;../build/classes/test;../build/resources/test
set CLASSPATH=%CLASSPATH%;C:\Users\bribin.zheng\.gradle\caches\modules-2\files-2.1\org.testng\testng\6.11\1fdd5e22f50b14f6d846163456e8c9a7657626fb\testng-6.11.jar;C:\Users\bribin.zheng\.gradle\caches\modules-2\files-2.1\com.beust\jcommander\1.64\456a985ac9b12d34820e4d5de063b2c2fc43ed5a\jcommander-1.64.jar

rmdir /s /q test-output

java -classpath %CLASSPATH% org.testng.TestNG ../src/test/resources/testng.xml
