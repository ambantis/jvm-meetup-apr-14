Introduction to Scala and Play Framework
========================================

Intro
-----

This presentation has two goals:

  1. explain how Scala can improve the developer experience and the bottom line
  2. ditto for Playframework!

Setup
---------------------------
In this presentation, I'll be using Linux, Scala 2.10.3, Playframework 2.2.2, and IntelliJ 13.1.1.

To install Scala, please refer to the instructions at [scala-lang.org](http://www.scala-lang.org/download/) 
or refer to the documentation for your operating system (e.g. `apt-get install scala`).

To install Playframework, I encourage you to download it from
[playframework.com](http://www.playframework.com/download) and follow these
[instructions](http://www.playframework.com/documentation/2.2.x/Installing); you can also use your
operating system repos. The download link has two versions: activator & standalone. I will be using
the standalone version.

During the presentation, I will assume that if you brought your computer, you were able to get
everything successfully installed. I will not be covering this material. If you hit a roadblock, please 
[email](mailto:ambantis@gmail.com) me and I will do my best to help you.

Scala REPL (Read-Eval-Print Loop)
---------------------------------

Part of the interactive portion of the presentation will be using the Scala REPL. You should review
this section BEFORE the presentation if you would like to follow along on your own computer.

We will be working with the Scala repl a bit, pasting or loading code snippets, so you might want
to review a bit on how that works [funconf: James Earl Douglas](http://www.youtube.com/watch?v=0hCwtsR0cas) 
... just kidding, this youtube video is a presentation titled "Hands-On Category Theory", which we will 
definitely NOT be convering, but it is a cool demo of how the repl can be used during development.

Actually, once you have scala installed, you can just begin a repl session by typing `scala` at the
command line:

    ambantis@okosmos ~/dev/genesis/presos/jvm-meetup-apr-14
     % scala
    Welcome to Scala version 2.10.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_51).
    Type in expressions to have them evaluated.
    Type :help for more information.

    scala> :help
    All commands can be abbreviated, e.g. :he instead of :help.
    Those marked with a * have more detailed help, e.g. :help imports.

    :cp <path>                 add a jar or directory to the classpath
    :help [command]            print this summary or command-specific help
    :history [num]             show the history (optional num is commands to show)
    :h? <string>               search the history
    :imports [name name ...]   show import history, identifying sources of names
    :implicits [-v]            show the implicits in scope
    :javap <path|class>        disassemble a file or class name
    :load <path>               load and interpret a Scala file
    :paste                     enter paste mode: all input up to ctrl-D compiled together
    :power                     enable power user mode
    :quit                      exit the interpreter
    :replay                    reset execution and replay all previous commands
    :reset                     reset the repl to its initial state, forgetting all session entries
    :sh <command line>         run a shell command (result is implicitly => List[String])
    :silent                    disable/enable automatic printing of results
    :type [-v] <expr>          display the type of an expression without evaluating it
    :warnings                  show the suppressed warnings from the most recent line which had any

    scala>

Keep in mind, that if you want to load a file into the repl, you'll want to start the repl in the
directory that has the source files you want (it is possible to change directories within the repl
and do other command-line actions, but we won't be covering that in this demonstration). The main
repl commands you will want to be familiar with are `:paste` and `:load`.

Here's a youtube video that shows connecting to a live play application (very cool): 
[Scala Remote REPL demo](http://www.youtube.com/watch?v=SKNhET81FxI) and another that gives a brief intro 
to Scala using the repl: [12 Things, Part 1: The Scala REPL](http://www.youtube.com/watch?v=-LGFQ-s7Xr8)

Why I Like Scala
----------------

In this section I will compare/contrast Java and Scala with regards to three specific tasks:

  1. Open a (potentially) VERY large file on disk and output the contents of the Nth line.
  2. Design an algorithm to figure out if someone has won a game of tic-tac-toe.
  3. Given a sorted array of n integers that has been rotated an unknown number of times, write code
     to find an element in the array. You may assume that the array was originally sorted in
     increasing order.

The code for these tasks are located at:

  1. [OpenAFile6.java](https://gist.github.com/ambantis/9986848) & [OpenAFile7.java](https://gist.github.com/ambantis/9986825) & 
     [OpenAFile.scala](https://gist.github.com/ambantis/9986533)
  2. [FindInRotatedArray.java](https://gist.github.com/ambantis/9981797) & [FindInRotatedArray.scala](https://gist.github.com/ambantis/9986086)
  3. [TicTacToe.java](https://gist.github.com/ambantis/10008457) & [TicTacToe.scala](https://gist.github.com/ambantis/10008325)

I will be spending about 5 minutes on each task, highlighting some of the features that make Scala a
joy to work with (IMHO). We can spend more time with this section; otherwise, we can push on to
Play! and take questions/comments towards the end.

Monadic Methods (TODO)
----------------------

We'll play with the repl for about 5-10 minutes to explore three methods common to almost all containers and
collections in Scala:

  1. [map](http://twitter.github.io/scala_school/collections.html#map)
  2. [flatMap](http://twitter.github.io/scala_school/collections.html#flatMap)
  3. [filter](http://twitter.github.io/scala_school/collections.html#filter)

Don't worry about what Monadic means. When you hear "Monadic" in Scala, just think "map, flatMap, and filter".

PowerPointish Stuff
-------------------

Here's the link to my presentation (in Google Drive): http://goo.gl/aLyfjd

I'm going to make use of a couple of presentations already created about Playframework:
  1. [Play vs. Grails Smackdown](http://www.ubertracks.com/preso/#/intro)
  2. [Introduction to the Play Framework - Java Edition](http://presos.jamesward.com/introduction_to_the_play_framework-java/)
  3. [Introduction to the Play Framework - Scala Edition](http://presos.jamesward.com/introduction_to_the_play_framework-scala/)

You may also want to check out this 20 minute video: [Introduction to Play Framework for Java developers](http://vimeo.com/58969923)

Here's also a very awesome & recent presentation (56 minutes) about why Linkedin is moving to Playframework:
[Building composable, streaming, testable Play apps](http://www.ustream.tv/recorded/42801129)

Play! Live Demo (TODO)
----------------------


