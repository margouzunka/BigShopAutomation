Scenario: User profile could be opened
Given Opened BigShop app
And User logged in to margouzunka69@mail.ru:UFzRmcfn.JeZ32Y

When I open profile
Then Profile for "Marina Litash" is opened
