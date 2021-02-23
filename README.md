# Object Oriented Programming (DIEF, UNIMORE)
This is an intermediate programming course for introducing Object Oriented Programming (OOP) principles applied to both Java and Python languages. We recommend this course to learners who have previous experience in software development or a background in computer science.  At the end of the course, learners will be able to develop real-world applications either desktop or mobile.

More specifically, the course introduces the fundamentals of Object Oriented Programming and the vast standard APIs of both Java and Python. Students will learn how to manipulate complex data structures, read and write data from local files, databases, web services, and how to to build graphical user interfaces.

## Software, Tutorials, Exercises

### Java
* [Java SE Development Kit](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Java SE Tutorial](https://docs.oracle.com/javase/tutorial/), [Java SE API](https://docs.oracle.com/en/java/javase/15/docs/api/index.html) 
* [IntelliJ IDEA](https://www.jetbrains.com/idea/), [IntelliJ IDEA Resources](https://www.jetbrains.com/idea/resources/)

### Python
* [Python Development Kit](https://www.python.org/downloads/)
* [Python Tutorial](https://docs.python.org/3/tutorial/), [Python API](https://docs.python.org/3/library/)
* [PyCharm](https://www.jetbrains.com/pycharm/), [PyCharm Resources](https://www.jetbrains.com/pycharm/learn/)
* [Anaconda](https://www.anaconda.com/products/individual)

### Misc
* https://git-scm.com/
* http://www.pythontutor.com/
* https://www.w3resource.com/
* https://www.programiz.com/
* https://www.baeldung.com/
* https://pynative.com/
* https://exercism.io/
* https://github.com/mtdvio/every-programmer-should-know
* https://github.com/charlax/professional-programming
* https://github.com/sindresorhus/awesome

## Books
* Head First Java; Sierra, Bates (beginner)
* Head First Object-Oriented Analysis Design; McLaughlin, Pollice, West (intermediate)
* Effective Java; Joshua Bloch (advanced)
* Python Crash Course; Matthes (beginner)
* Head First Python: A Brain-Friendly Guide; Barry (intermediate)
* Fluent Python; Ramalho (advanced)


## Videos
* [YouTube OOP Java](https://www.youtube.com/watch?v=y3H3xwI0prM&list=PLhlcRDRHVUzTruZmXalUSJAK26pouP8ST)
* [YouTube OOP Python](https://www.youtube.com/watch?v=14aWn1OZQzQ&list=PLhlcRDRHVUzR2WHN9VTPZrawqRYHz5ALF)
* [YouTube IntelliJ](https://www.youtube.com/c/intellijidea/videos)
* [YouTube PyCharm](https://www.youtube.com/c/PyCharmIDE/videos)


## Slides, code examples
Slides, and code examples can be found here and downloaded using git:

> $ git clone https://github.com/nbicocchi/ooprogramming.git

Both slides and code examples might be updated or bug-fixed during the course. At any time, for downloading the latest version, go the course material directory (on your pc) and use:

> $ git pull (in case of errors: git reset --hard; git pull)

## Java Modules
[M1] From Functions to Objects

* The software crisis
* Spaghetti code
* Modularization principles
* Variables, Functions, and Classes

[M2] Basics

* The Java environment
* Primitive types
* Control statements
* Strings and Arrays

[M3] Object Oriented Programming

* Classes and objects (Encapsulation)
* Methods and attributes
* Getters and Setters
* Scope and visibility
* Constructors
* Upcasting and Downcasting (Inheritance)
* Overloading and Overriding (Polymorphism)
* Abstract methods
* Abstract classes
* Interfaces
* Packages
* ~~UML class diagrams~~

[M4] Collections Framework (JCF)

* Structure of JCF (interfaces and abstract classes)
* Collection (Set, Queue, List) interface and its implementations
* Map interface and its implementations
* Iterator and ListIterator (definition and use)
* Sorting and Searching

[M5] Generic Data Structures (Generics)

* Array Sub-typing
* Object Sub-typing
* Collection Sub-typing
* Bounded Wild-cards Types

[M6] Functional Interfaces

* ~~Lambda functions~~
* ~~Lambda and functional interfaces~~ 
* ~~Streams~~

[M7] Exceptions

* Motivations and basic concepts
* Exceptions (checked and unchecked) and Errors
* Catching Exceptions (try/catch/finally)
* Throwing Exceptions (throw)
* Interception and Delegation (complete and partial) (throws)

[M8] Swing Framework

* Graphical event-based programming
* Containers and Components
* Layout management
* Event delegation model

[M9] Database Connectivity (JDBC)

* Database connection architecture
* Connection, Statement and Resultset classes
* Scrollable, Updateable Resultsets
* Connection Metadata

[M10] Remote Data Access (REST)

* Motivations and basic concepts
* Resources, Operations, Representations (JSON, XML)
* GET/POST/PUT/DELETE requests
* Design of a client/server staleless application

[M11] I/O Framework

* Reader/Writer interfaces and their implementations
* InputStream/OutputStream interfaces and their implementations
* Serialization (Deep/Shallow)
* Tokenizers (Scanner/StringTokeniser classes)
* Filesystem manipulation (File/Files classes)
* Random Access Files

[M12] Multi-threading

* Motivations and basic concepts
* Thread states
* Creating, starting and stopping threads
* Race conditions
* Basic synchronisation (synchronised/sleep/yield/join)
* Advanced synchronisation (wait/notify)
* Key Issues: Deadlock, Livelock, Starvation

## Python Modules
[M1] Basics

* The Python environment
* Variables
* Numeric, strings, boolean literals
* Conditional statements
* Iterative statemets
* Functions and arguments

[M2] Data Structures

* Iterable, Iterator, Generator
* List, Tuple, Set, Dictionary
* Generator Comprehension
* List Comprehension
* Itertools

[M3] Object Oriented Programming

* Classes, attributes, methods
* Getters, setters, properties, decorators
* Encapsulation, inheritance, polymorphism 
* Informal interfaces
* Sorting objects
* Modules and packages

## Exam
During the final exam students are expected:

* to discuss about the structure, the internals and engineering choices of their home project (could be developed either in Java or Python). It is worth noticing that the project is not supposed to be developed alone without supervision, but mostly during the course. The whole development process and related discussions with Prof. Bicocchi will be evaluated.

* to pass an oral examination about the Java and Python languages. Quizzes and short written exercises will be also used for assessing actual programming skills. 

## FAQ
Can we develop the project in groups of 1 or 3 people?
> No, groups must be composed of two 2 people. There are no exceptions. The use of git for developing and sharing code is mandatory. People unable to find a teammate should contact me. Groups should be composed by teammates with similar skills and desire to code. Exceptions to this rule will be negatively evaluated.

Can we use Unity, JavaScript, TypeScript, Flutter, Swift, C++, C#?
> No! Only Java and Python are allowed.

Which kind of project can we do?
> You can code a video game, a mobile app, a managing software. See examples in the repository as a reference.

Which IDE should I use for developing a mobile app?
> Android Studio is a version of IntelliJ tuned for Android development.

How big the project has to be?
> A project comprised of 1000-3000 source lines of code is enough to grasp the feeling of what developing software means.

What is the best moment for starting the project?
> The first half of the course concerns basic topics that must be assimilated before starting. My personal suggestion is to start the project around midterm and use the second part of the course to sketch out the main design.

While developing I get strange errors. What should I do?
> The first thing to do is copy and paste the error string on Google and check for eventual answers on StackOverflow. The vast majority of common errors has a dedicated page.

If I need help, should I write an email to book an appointment?
> Yes, I will be available every Wednesday morning for chatting.

How does the exam is evaluated?
> The final grade is a subjectively-weighted (Prof. Bicocchi is the subject) average between the home project and the oral examination. 
> The oral examination is composed of theoretical questions about Java and Python and simple quizzes and exercises that anyone that developed a 2000 lines software project is quickly able to solve.