# CSRF

Answer example to http://stackoverflow.com/questions/20430281/set-ring-anti-forgery-csrf-header-token

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

However with the latest versions of the compojure and ring libraries, I get "Invalid..." even with a valid token.

## License

Copyright © 2013 WTF Inc.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
