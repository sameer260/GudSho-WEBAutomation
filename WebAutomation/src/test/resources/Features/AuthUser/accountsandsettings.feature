Feature: Account and settings  page Scenarios

 	 
  Scenario Outline: Friends functionality
    Given click friends tab and enter <email> and verify toast message
    Examples: 
      |email|
      |ramya.k@contus.in|
      
    
    Scenario Outline: Invited new friend
    Given click friends tab and enter <newemail> and verify success  toast message

    Examples: 
      |newemail|
      |sindhugnk@gmail.com|
      
      
    Scenario Outline: existemail friend functionality
    Given click emailid tan and enter <existemail> and verify error toast message
    
    Examples: 
      |existemail|
      |vramyagnk@gmail.com|
     
      
   
    Scenario Outline: enter any   dummy email and then click invite button
    Given click friends tab and enter <dummyemail> and verify  error msg validation

    Examples: 
      |dummyemail|
      |ramya|
      
     @ramya  
    Scenario: verify privacy policy
    Given click privacy policy tab and verify it should navigate to correct page
      
    
    Scenario: Notification functionality
    Given click notification tab and verify in-app toggle button
    
       
    
    
    
    
    Scenario Outline: My profile functionality
    Given enter <name> and <dob> and <gendar> details  and click save button and verify toast message

    Examples: 
      |email|dob|gendar|
      |vramyagnk@gmail.com|9/10/1991|F|
    