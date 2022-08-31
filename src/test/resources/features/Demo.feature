Feature: Demoqa

@tag1
	Scenario: User regis 
    Given User go to Web DemoQA and click myAcc
    When User enter username email password regis
    Then User click button regis and alert

	@tag2  
	Scenario: User Login
		When User enter username password
		And Button remember me
		Then User click button login

	@tag3		
	Scenario: Select Wishlist1
	Given Search item1
	When Click button wishlist1
	Then Click logo1
	
	@tag4
	Scenario: Select Wishlist2
	When Search item2
	And Click button wishlist2
	And Click logo2
	Then Click mywishlist
		
	@tag5
	Scenario: Select Options Item1
	When Click select options1
	And Select options1
	Then Alert to cart
	
	@tag6
	Scenario: Select Options Item2
	Given Click logo3 
	When Click mywishlist2
#	Given Click select options2
#	When Select options2
	
	@tag7
	Scenario: Show Cart
	When Click viewcart 
	And Click proceed to checkout
	
	@tag8
	Scenario: Checkout
	Given Click checkout to data
	And Click checkbox accept
	Then Click placeorder
	
	@tag9
	Scenario: User Logout
	Given Click logo4
	When Click myacc
	And Click logout
	