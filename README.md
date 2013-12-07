# CSRF

Answer example to http://stackoverflow.com/questions/20430281/set-ring-anti-forgery-csrf-header-token

## Usage

lein ring server

1. Get CSRF Token

```
curl --cookie-jar cookies "http://localhost:3000/"

{"csrf-token":"2BYov8r71IswCQaQAIcvYxrihHRaqAdq5vFRM1zWbl4FzVz7KASo778zBFsq+cGtkLFzXYoUbWd0BqiU"}
Remember CSRF token
```

2. Now send POST request

```
curl -v --cookie cookies -F "email=someone@gmail.com" --header "X-CSRF-Token: 2BYov8r71IswCQaQAIcvYxrihHRaqAdq5vFRM1zWbl4FzVz7KASo778zBFsq+cGtkLFzXYoUbWd0BqiU" "http://localhost:3000/send"
```

> Result is "ok"

Without a header it will be

> <h1>Invalid anti-forgery token</h1>

## License

Copyright © 2013 WTF Inc.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
