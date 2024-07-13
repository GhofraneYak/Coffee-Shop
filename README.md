# Coffee-Shop

## Coffee Shop Backend Application

### ProductController

### OrderController

### CartController

- getCart(customerId: Long): Option[Cart]

Retrieves the cart for a specific customer.

- addToCart(customerId: Long, item: Item): Cart

Adds an item to the cart. If the cart does not exist, it creates a new cart.
If the item already exists in the cart, it updates the quantity.
Updates the total price of the cart.

- removeFromCart(customerId: Long, productId: Long, quantity: Int): Option[Cart]

Removes the specified quantity of a product from the cart.
If the quantity becomes zero or less, it removes the item from the cart.
Updates the total price of the cart.

- checkout(customerId: Long): Option[Order]

Converts the cart to an order and removes the cart.
Uses OrderController.addOrder to add the order to the list of orders.

- updateProductInCarts(product: Product): Unit

Updates the product details in all carts.
Recalculates the total price of each cart that contains the updated product.
