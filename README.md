# MUSIC FESTIVAL TICKETS SALE SYSTEM, CONCERT AND EMPLOYEE MANAGEMENT
Technologies: JavaFX, Maven, Hibernate and MySQL



Illia Halych
Warsaw, Poland
June 11, 2019



## Scope and requirements
The goal of the software is to improve the way users manage music festival sales. The system will be used by cashiers, managers and contract musician workers. 

The **cashier** will sell tickets and issue refunds before the specified deadlines. They may also send the receipts to the customers via email. The cashier may find customers by mail, email, phone numbers or Social Security Number and see their purchases.

The **manager** will fire employees, hire employees either with permanent or temporary contracts, raise wages and promote employees and receive monthly reports about, 3 monthly reports and yearly reports. The manager should be able to receive the reports between the specified dates by the manager. It will be sent to the manager via email as PDF.

The **musician** will be able to see when their contracts start and end, the amounts that’ll be paid out to them after the gig to their bank accounts, the list of songs they’ll sing/play during the gig and they’ll be able to make changes 2 weeks before the performance starts. 



## DDL
[Database DDL](https://github.com/MiddleZwei/Ticketing-System/blob/master/DDLs.sql)
![Database structure][database]

## Dependencies and Maven project structure
[Parent](https://github.com/MiddleZwei/Ticketing-System/blob/master/pom.xml)
[GUI](https://github.com/MiddleZwei/Ticketing-System/blob/master/gui/pom.xml)
[Logic](https://github.com/MiddleZwei/Ticketing-System/blob/master/logic/pom.xml)

## GUI of the desktop app
Used a 2 level Maven project: tehre are 2 sub projects:
- GUI: [Go to GUI subproject](https://github.com/MiddleZwei/Ticketing-System/tree/master/gui)
- Logic: [Go to Logic subproject](https://github.com/MiddleZwei/Ticketing-System/tree/master/logic)

## Tests
This version of the application doesn't cover tests. The focus is made on OOP in this initial version.



## Analytical class diagram
Shows the analytical or "theoretical" classes and how the reference other classes, thus the objects of the class.
![Analytical class diagram][analytical_diagram]

## Design class diagram
It redesignes the analytical class diagram, so there are only elements (a.k.a references, cardinalities, data structures, constraints, inheritance, abstraction)
![Design class diagram][design_diagram]

## Use case diagram
It includes several use cases of the system. The **ticket sale** use case is the chosen one for other UML diagrams,
![Use case diagram][use_case_diagram]

## Activity diagram
It describes the dynamics of the system for the ticket sale use case. It is basically a flowchart.
![Activity class diagram][activity_diagram]

## State diagrams
It describes the states of the objects and how it changes - that's their behavior during the runtime. The cashier and ticket - are 2 main classes for the **ticket sale** use case.
![State diagram][state_diagram]

## Sequence diagram
It shows the message flow between objects of the use case. That is what methods are called and what messages are passed from one object to another. Keep in mind, that all object are linked and the usage of this project requires a bit of understanding of the OOP principles. Java is somewhat a high level language, but it preserves the possibility of manual association management.
![Sequence diagram][sequence_diagram]



GUI is written with JavaFX
Logic contains the following OOP elements:
_**Classes & attributes:** class extents, persistence, complex attributes, optional attributes, multi-value attributes, class attributes, derrived attributes, class methods, method overriding and overloading
**Associations:** 1-1, with an attribute, qualified, composition
**Inheritance:** abstract classes and polymorphic method invocation, overlapping inheritance, multi-inheritance, multi-aspect inheritance, dynamic inheritance
**Constraints:** attribute constraints, unique, subset, ordered, bag, XOR
**ORM:** classes, associations, inheritance_



[analytical_diagram]: O "Analytical class diagram"
[design_diagram]: O "Design class diagram"
[use_case_diagram]: O "Use case diagram"
[activity_diagram]: O "Activity class diagram"
[state_diagram]: O "State diagram"
[sequence_diagram]: O "Sequence diagram"
[database]: O "Database structure"
