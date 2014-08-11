SeleniumGridTest
================
This is the grid test demo using Selenium Grid 2 on windows platform.

Note: This demo use Selenium Server v2.42.2, Chrome v36(ChromeDriver v2.9.248315), IE11(IEDriverSearver v2.39),Firefox v31,

Step One: Start the selenium hub
	 
	 On the hub machine, run this command,

	java -jar selenium-server-standalone-2.xx.x.jar -role hub

Step Two: Register the grid node

	java -jar selenium-server-2.xx.x.jar -role node -hub http://localhost:4444/grid/register -browser "browserName=chrome,version=36,maxInstances=1,platform=WINDOWS" -browser "browserName=internet explorer,version=11,maxInstances=1,platform=WINDOWS" -browser "browserName=firefox,version=31,maxInstances=1,platform=WINDOWS"

	Note: This command register three test nodes(IE v11 node, Firefox v31 node, Chrome v36) to the hub.
	You can check the registration results at http://localhost:4444/grid/console.

Step Three: Prepare the page which will be tested

	Put the DemoPage/index.jsp, Result.jsp in your web container like Tomcat, and run it.
	Make sure the demo page can be shown correctly.

	Note: Your web container my be ran on linux, windows, etc.


Step Four: Run the Test Use Case

	On the test node machine, put WebDriver/chromedriver.exe and WebDriver/IEDriverServer.exe into the PATH(system32 in windows).
	Import project "SeleniumGridTest" to eclipse, change the baseUrl in the setUp method to YOUR DEMO PAGE URL.
	Run the project as Junit Test, it will begin to test automatically.

    

