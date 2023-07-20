# QaseIn
mvn clean -Dlogin='m.s.morozoff@gmail.com' -Dpassword='3359347m' -DsuiteXmlFile='src/test/resources/UItest.xml' test
mvn clean -DsuiteXmlFile='src/test/resources/APItest.xml' test
mvn clean -Dtest=loginTest test

проверенное
mvn clean -Dmaven.test.failure.ignore=true test //запуск suite по умолчанию, прописанного в pom.xml
mvn clean -DsuiteXmlFile='src/test/resources/apiSuite.xml' test //запуск указанное suite

-Dsurefire.suiteXmlFile=src/test/resources/apiSuite.xml clean test // для jenkins