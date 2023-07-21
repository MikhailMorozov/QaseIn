# QaseIn
mvn clean -DsuiteXmlFile='src/test/resources/apiSuite.xml' test //запуск указанное suite
mvn clean -Dlogin='m.s.morozoff@gmail.com' -Dpassword='3359347m' -DsuiteXmlFile='src/test/resources/uiSuite.xml' test
mvn clean -Dlogin='m.s.morozoff@gmail.com' -Dpassword='3359347m' -Dtest=LoginTest test // запуск отдельного теста
