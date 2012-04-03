# heion

RESTful Clojure with Dropwizard

Eventually, I'd like this project to provide a quick way to write REST services
using ideomatic Clojure with the Dropwizard framework.  Right now, it just shows
that it is possible.

This code currently implements the HelloWorldService as described in
http://dropwizard.codahale.com/getting-started .  There are a few changes:

  1. the YAML config contains a single dictionary to fit in Clojure's model of
     only providing 1 state variable per generated class.
  2. There is no Saying class, using a map is simplier and more ideomatic.

## Usage

Compiling heion requires a patch to the clojure compiler, available at
https://github.com/jblomo/clojure .  It enables parameterized generic
superclasses, which Dropwizard uses via reflection during setup.

So after you dowload, build, and install the patched version of Clojure, you can
compile and run heion.

   lein compile
   lein run server resources/hello-world.yml
   # browse to http://localhost:8080/hello-world

## License

Copyright (C) 2012 Jim Blomo

Distributed under the Eclipse Public License, the same as Clojure.
