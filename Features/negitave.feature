Feature: Login zoopla

Scenario Outline: Successful Login with Valid username & password
	Given User Launch the Chrome browser 
	And User opens the URL "<URL>" 
	When User enters username as "<username>" and pwd as "<password>" 
	And Click on the Login 
	Then Page Title should be on the page  "My Zoopla-Zoopla" 
	When User click on the Log out link 
	Then Page logout Title should be present "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents" 
	And close the browser
	
	Examples: 	
	|username         |password |URL                      |
	|asifqsm@gmail.com|Haris2017|https://www.zoopla.co.uk/|
	|asifqsm@yahoo.com|Haris2017|https://www.zoopla.co.uk/|
	|asifqsm@gmail.com|Haris2018|https://www.zoopla.co.uk/|