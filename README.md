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

4. Populate the `users` collection with users whose reputation you would
   like to record, in the following format:

        {_id: <stack overflow user id>}

5. Run the Jar file:

        $ java -jar target/chameleon-1.0.0-standalone.jar

You will probably want to run the program as a cron task, to sample
reputation periodically.
