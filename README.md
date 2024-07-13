# Coffee-Shop

## Coffee Shop Backend Application

### ProductController

- ```getProducts(): List[Product]```

Retrieves the list of all products.
addProduct(product: Product): Product

Adds a new product to the list of products.
Returns the added product.

- ```updateProduct(id: Long, updatedProduct: Product): Option[Product]```

Updates the details of an existing product.
Updates the product details in all carts.
Returns the updated product if found, None otherwise.

- ```deleteProduct(id: Long): Option[Product]```

Removes a product from the list of products.
Removes the product from all carts.
Returns the removed product if found, None otherwise.

- ```updateStock(id: Long, quantity: Int): Option[Product]```

Updates the stock quantity of an existing product.
Updates the product details in all carts.
Returns the updated product if found, None otherwise.

### CustomerController

- ```getCustomers(): List[Customer]```

Retrieves the list of all customers.

- ```addCustomer(customer: Customer): Customer```

Adds a new customer to the list of customers.
Returns the added customer.

### OrderController

- ```getOrders(): List[Order]```

Retrieves the list of all orders.

- ```addOrder(order: Order): Order```

Creates a new order or updates an existing order with the same ID.
Adds or updates the order in the list of orders.
Returns the created or updated order.

- ```deleteOrder(id: Long): Option[Order]```

Removes an order from the list of orders.
Returns the removed order if found, None otherwise.

### CartController

- ```getCart(customerId: Long): Option[Cart]```

Retrieves the cart for a specific customer.

- ```addToCart(customerId: Long, item: Item): Cart```

Adds an item to the cart. If the cart does not exist, it creates a new cart.
If the item already exists in the cart, it updates the quantity.
Updates the total price of the cart.

- ```removeFromCart(customerId: Long, productId: Long, quantity: Int): Option[Cart]```

Removes the specified quantity of a product from the cart.
If the quantity becomes zero or less, it removes the item from the cart.
Updates the total price of the cart.

- ```checkout(customerId: Long): Option[Order]```

Converts the cart to an order and removes the cart.
Uses OrderController.addOrder to add the order to the list of orders.

- ```updateProductInCarts(product: Product): Unit```

Updates the product details in all carts.
Recalculates the total price of each cart that contains the updated product.
