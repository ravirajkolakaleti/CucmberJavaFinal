
Feature: Check google search functionality


	Background: user open the browser and navigates to "http://google.com"

		Given browser is open and go to "http://google.com"
		And user is on google search page
		


  Scenario Outline: Validate google search is working
  
    When user enter text in the google search text box
    And hits Enter
    Then Search Results page displays 
    And quit browser
    


 Scenario Outline: Sign up in Demoblaze website
    
    When user enter text in the google search text box
    And hits Enter
    Then Search Results page displays
    And click on the Demoblaze link in the search results
    Then I should be navigated to "https://www.demoblaze.com/"
    When I click on Sign Up link
    And I sign up with <username> and <password>
    Then I should be signed up successfully
    And quit browser
    
  
   
   
    Examples: 
      | username | password |
      | sushen13  | test1234 |
      
    
    Scenario Outline: Login to Demoblaze website
   
    When user enter text in the google search text box
    And hits Enter
    Then Search Results page displays
    And click on the Demoblaze link in the search results
    Then I should be navigated to "https://www.demoblaze.com/"
    When I click on Login link
    And I login with <loginusername> and <loginpassword>
    Then I should be logged in successfully
    And quit browser
    
  
   
     Examples: 
      | loginusername | loginpassword|
      | sushen12 			| test1234  |
    