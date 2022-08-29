Feature: Demoqa

@tag1
	Scenario: User regis 
    Given User go to Web DemoQA and click myAcc
    When User enter username email password regis
    Then User click button regis and alert

	@tag2  
	Scenario: User Login
		Given User enter username password
		Given Button remember me
		Then User click button login

	@tag3		
	Scenario: Select Wishlist1
	Given Search item1
	When Click button wishlist1
	Then Click logo1
	
	@tag4
	Scenario: Select Wishlist2
	Given Search item2
	When Click button wishlist2
	And Click logo2
	Then Click mywishlist
		
	@tag5
	Scenario: Select Options Item1
	When Click select options1
	And Select options1
	Then Alert to cart
	
	@tag6
	Scenario: Select Options Item2
	And Click logo3 
	And Click mywishlist2
	Given Click select options2
	When Select options2
	
	@tag7
	Scenario: Show Cart
	Given Click viewcart 
	When Click checkout
	
	@tag8
	Scenario: Checkout
	Given Click checkout to data
	And Click checkbox accept
	Then Click placeorder
	
	@tag9
	Scenario: User Logout
	Given Click myacc
	Then Click logout
	