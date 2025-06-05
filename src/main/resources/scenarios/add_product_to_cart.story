Meta:
@ShoppingCart

Scenario: Add product to cart
Given Opened BigShop app
And User logged in to margouzunka69@mail.ru:UFzRmcfn.JeZ32Y

When I search Iphone 16 pro max
And Select first product from result list
Then Product page is opened

When I click to 'Add to cart' button
Then 'Product added to cart' page is opened

When I click to 'Confirm order' button
Then Shopping Cart page is opened
