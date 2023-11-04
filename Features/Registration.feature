Feature: New Registration


@Sanity
  Scenario: New User Registration
    Given Launch Browser
    And open URL "https://demo.opencart.com/"
    When Navigate to My Account
    And Click on Register
    And Fill all the details
    And Click on Continue button
    Then User registration completed
    
    
@Sanity
	Scenario Outline: Invalid Login
	Given Launch Browser
	And open URL "https://demo.opencart.com/"
	When Navigate to My Account
	And Click on Login
	And Enter User "<user>"
	And Enter Password "<password>"
	And Click on Submitt
	Then Validate Invalid Login
	
	Examples:
	 |user								|password|
	 |test1@test.com			|Test@121|
	 |test2@test.com			|Test@122|
