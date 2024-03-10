# Book-Shop
This Java project is designed for the Advanced Object Programming course in the second year of the Computer Science program at the University of Bucharest. 
It is an app that :
- enables users to buy and use different virtual items from a book shop
- enables the store owner update and keep track of its stock


## Requirements

### Stage I(deadline: 8th of April 2024)
1. System definition
- [x] create a list based on the chosen theme with at least 10 actions/queries (Example actions: update personal data,
card creation, balance inquiry, bank transfer, ...) that can be done within the system
   - [ ] register new user
   - [ ] login existing user
   - [ ] view shop inventory
   - [ ] restock shop's inventory
   - [ ] buy item from shop
   - [ ] view item details
   - [ ] view user inventory
   - [ ] use owned item
   - [ ] throw away item
   - [ ] view shop statistics
- [x] create a list ([models documentation](documentation/models.md)) of the
at least 8 types of objects (Example entities: user, account, debit account, savings account, transaction, ...)
    - Shop
    - ShopInventory
    - User
    - UserInventory
    - Item
    - Book
    - DrawingBook
    - Notebook
    - CookBook

2. Implementation

Implement in the Java language an application based on those defined in the first point.

The application will contain:
- [ ] simple classes with private / protected attributes and access methods
- [ ] at least 2 different collections capable of managing previously defined objects (eg: List, Set, Map, etc.), least one of which should be sorted
- [ ] use inheritance to create additional classes and use them within collections;
- [ ] at least one service class to expose system operations
- [ ] a Main class from which calls to services are made

### Stage II (deadline: 27th of May 2024)
1. Extend the project from the first stage by implementing persistence using a relational database
and JDBC.
 - [ ] Create services that expose create, read, update and delete operations for at least 4 of the classes
defined. Generic singleton services will be made for writing and reading from the database.

2. Realization of an audit service
- [ ] A service will be made to write to a CSV file each time one of the
the actions described in the first stage. File structure: action_name, times
