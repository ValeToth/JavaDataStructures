# Contributing

### Tools needed :wrench:
Possibly NetBeans, wich this project has been created with.
### Level of knowledge :books:
You must have knowledge of the Java language to begin with, and then some basic understanding of design patterns as a whole. If you like you can specialize in one and develop it! 
### Writing code :pencil:
the code style we're going to follow is for easy read, so there are some simple rules:
* newline parentesis
  ``` java
  public void method (  )
  {
    code goes here
  }
  ```
* put an __I__ at the start of interfaces names

* always create an interface before implementation
  ``` java
  public interface IExample
  ```
  ``` java
  public class Example implements IExample
  ```
* every structure or design has it's own package :package:, so put your code in the right one!<br>
  the main packages are: 
  * __JDS__._patterns_
  * __JDS__._structures_ 
