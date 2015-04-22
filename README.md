**This project has been superseded by
[Whitman](http://github.com/mdippery/whitman) and is unlikely to see any more
improvements or bugfixes.**

---

# Karmanaut

Karmanaut is a simple service for sampling link and comment reputation from
[Reddit](http://www.reddit.com). It takes a list of users from a MongoDB
collection, collects those users' reputation scores, and saves them back
into a MongoDB collection.

## Prerequisites

1. [Leiningen](http://leiningen.org)
2. [MongoDB](http://www.mongodb.org), running on your local machine.

## Usage

1. Build the Jar:

        $ lein uberjar

2. Create a MongoDB database called `karmanaut`.

3. In the `karmanaut` database, create a collection called `users`.

4. Populate the `users` collection with users whose karma you would like to
   record, in the following format:

        {_id: <reddit username>}

5. Run the Jar file:

        $ java -jar target/uberjar/karmanaut-standalone.jar

You will probably want to run the program as a cron task, to sample
reputation periodically.

---

## FAQ

### Do you have any affiliation with [karmanaut](http://www.reddit.com/user/karmanaut)?

No. I was loosely inspired by the username, but karmanaut—literally,
"karma sailor" or "karma explorer"—just made sense for this project
name, since that's what it's doing: exploring karma.

### Where does this project come from?

It's a fork of a similar crawler I wrote for Stack Overflow reputation
called [Chameleon](https://github.com/mdippery/chameleon). One day I hope
to factor out a common base for both these projects; for now, though,
Karmanaut remains but a (very divergent) fork.

### What's the goal?

To build charts of karma growth over time, and calculate all sorts of
fun statistics, as well as other data points like the derivative of
one's karma.

### Is this project actually used in production?

Yes. It is running on `pacific.monkey-robot.com`. I haven't exposed the
data publicly yet, not because I don't want to, but because I haven't
had time to build a web frontend for it.
