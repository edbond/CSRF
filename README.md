# CSRF

Answer example to http://stackoverflow.com/questions/20430281/set-ring-anti-forgery-csrf-header-token

Modified for http://stackoverflow.com/questions/30172569/clojure-anti-forgery-csrf-token-invalid-with-latest-version-ring-compojure
 to demonstrate failure with latest libraries.

## Usage

- Start server

```> lein ring server```

- Get CSRF Token

```
curl -X GET --cookie-jar cookies "http://localhost:3000/"

{"csrf-token":"2BYov8r71IswCQaQAIcvYxrihHRaqAdq5vFRM1zWbl4FzVz7KASo778zBFsq+cGtkLFzXYoUbWd0BqiU"}
```

**Remember CSRF token**

- Now send POST request

```
curl -X POST -v --cookie cookies -F "email=someone@gmail.com" --header "X-CSRF-Token: 2BYov8r71IswCQaQAIcvYxrihHRaqAdq5vFRM1zWbl4FzVz7KASo778zBFsq+cGtkLFzXYoUbWd0BqiU" "http://localhost:3000/send"
```

> Result should be "ok"

And without a header it should be

> <h1>Invalid anti-forgery token</h1>

## Problem

With the latest versions of the compojure (>= 1.2.0) and ring libraries, I get "Invalid..." even with a valid token.

## Solution
`ring-defaults` includes anti-forgery by default for `POST` requests (and others that modify data).
The use of `wrap-defaults routes site-defaults` with `wrap-anti-forgery` results in generating the anti-forgery token
twice and thus invalidating the token you receive with a get-request. So, just remove `(wrap-anti-forgery)`

## License

Copyright © 2013 Eduard Bondarenko.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
