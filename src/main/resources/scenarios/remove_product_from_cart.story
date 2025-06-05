Scenario: Remove product from cart

Given Opened BigShop app
And User logged in to margouzunka69@mail.ru:UFzRmcfn.JeZ32Y
And Add "Iphone 16 pro max" product to cart

When I click to "Shopping Cart" button
Then Then Shopping Cart page is opened

When I click to "Add to cart" button
Then Confirmation page is opened

When I click to "Confirm" button
Then Shopping Cart page is opened
