# The Spicy Breakfast example shopping cart

Your one stop shop for delicious treats!

Visit the site here:
https://timothypratley.github.io/spicy-breakfast


## Overview

This is an example shopping cart site in ClojureScript Reagent.
No food items can be purchased at this site.


## Development

To get an interactive development environment run:

    lein figwheel dev devcards

View the app at [localhost:3449](http://localhost:3449/).

View devcard examples at [localhost:3449/cards.html](http://localhost:3449/cards.html).

To create a production build run:

    lein do clean, cljsbuild once min

Open `resources/public/index.html` in a browser to see the production build.


## Tests

To run the tests in ClojureScript

    lein doo nashorn test

You can also run the tests in Clojure

    lein test
    
Or

    lein test-refresh


## Deploying

Hosted on github pages, deploy with

    ./deploy.sh


## License

Copyright © 2018 Timothy Pratley

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
