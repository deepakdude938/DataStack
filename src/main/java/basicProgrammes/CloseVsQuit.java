package basicProgrammes;
public class CloseVsQuit {
	
	/*
	 
	 
	 What is the difference between quit() and close() in selenium ?

The close() method can close the browser in focus.
It closes the present window on which we are working.

driver.get("https://lnkd.in/exqxcmdH");
SessionId s1=((RemoteWebDriver)driver).getSessionId();
System.out.println("Session id before close : " +s);
driver.close();
SessionId s2=((RemoteWebDriver)driver).getSessionId();
System.out.println("Session id after close : " +s1);

Session id before and after closing the browser is same.
Session id before close : 90280517aacf7068eef75f708dccea83
Session id after close: 90280517aacf7068eef75f708dccea83

The quit() method suspends all the driver sessions and instances, thereby closing each opened window.

driver.get("https://lnkd.in/exqxcmdH");
SessionId s1=((RemoteWebDriver)driver).getSessionId();
System.out.println("Session id before quit : " +s1);
driver.quit();
SessionId s2=((RemoteWebDriver)driver).getSessionId();
System.out.println("Session id after quit: " +s2);

Session id before and after quiting the browser is different.
Session id before quit : b4676c7ddac4e5fdeee0ed82f249bf0d
Session id after quit: null

What if only one driver instance is open and we use driver.close(), 
will it close the browser only or kill the current session also ?
	 
	 
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
