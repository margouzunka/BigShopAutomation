Meta:
@Login

Scenario: Log in to user account
Given Opened BigShop app

When I click to profile icon
Then Login form is opened

When I type margouzunka69@mail.ru and UFzRmcfn.JeZ32Y to form
And I click to login button
Then I logged in my account
