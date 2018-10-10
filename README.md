# community-tags

Generated using Luminus version "3.10.5".

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

You'll need to create a `dev-config.edn` with the following before you can run
the server. The config of primary concern is the `:neo4j-url`.

```
{
  :dev true
  :port 3000
  :nrepl-port 7000
  :neo4j-url "http://neo4j:your-password@localhost:7474/db/data/"
}
```

To start a web server for the application, run:

    lein run 

Alternatively you can start the server from the repl with:
```
lein repl
> (start)
```

### Resources

* http://localhost:3000/tag/age/communities - for a list of communities associated with
  the age tag.
* http://localhost:3000/community/babylon5/tags - for a list of tags associated with the babylon5
  community.

## License

Copyright © 2018 FIXME
