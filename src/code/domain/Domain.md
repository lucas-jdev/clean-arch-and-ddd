# 2.Domain🫀 #

The business domain is the central part of Clean Architecture and represents the essence of the problem that the software intends to solve.

The Domain in Clean Architecture is the innermost layer of the system and is responsible for representing the business. It is in this layer that the business model is defined, along with the entities, business rules, and operations that make up the core logic of the application.

## 2.1 Entities🥷🏿 ##

Entities are business objects that have a unique identity and represent a concept or object within the domain. They are the representation of important business concepts, such as customers, orders, products, and so on.

Entities are defined by their behavior, state, and identity. Behavior describes the actions that an entity can perform, while state represents the characteristics and information that an entity possesses. Identity is what distinguishes one entity from another and is usually represented by a primary key.

Entities are important within the Domain because they allow software to accurately represent business entities, their behaviors, and relationships. When modeling entities, the developer should focus on the characteristics that are relevant to the business, ignoring technical details that are not important.

## 2.2 Repositories🗃️ ##

Repositories are interfaces that define how entities are persisted or retrieved. They are responsible for abstracting data access, hiding implementation details, and allowing entities to be accessed without the need to know persistence details.

Repositories are important within the Domain because they allow entities to be persisted and retrieved easily, without the software needing to know persistence details such as the database used, table structure, and so on. They also allow persistence operations to be isolated from the rest of the code, making software maintenance and evolution easier.

Repositories are responsible for managing the life cycle of entities, ensuring they are retrieved and persisted correctly. They can also be used to implement business rules that involve data access, such as validations and restrictions. In addition, repositories are used as an entry point for data access in the application layer.
