# Groovy Template Grails Asset Pipeline Plugin

This plugin lets you use Groovy expressions in your Javascript and CSS asset files and participates in the [Grails Asset Pipeline Plugin](http://grails.org/plugin/asset-pipeline) pre-compilation.

This lets you get access to config and environment variables during the pre-compilation process so that you can easily serve up static files with content that is crafted for that application.

You get the `grailsApplication` and `config` objects injected into the binding for when expressions are evaluated:


ex:

Confg.groovy

```
...
grails.serverURL = "https://mycompany.com/"
...
```

application.js-gtpl:

```
//= require_self

var serverURL = "${config.grails.serverURL}";
```

creates application.js:

```
//= require_self

var serverURL = "https://mycompany.com/";
```

You can also execute more complicated expressions inside `<% ... %>` blocks, see the [jasmine tests](https://github.com/tednaleid/groovy-template-grails-asset-pipeline/blob/master/test/projects/test-project/grails-app/assets/javascripts/jasmine/spec/SimpleExpressionsSpec.js-gtpl) for more examples.

NB: be sure to make sure when you build your war file that you're using the right environment to get the correct values out of `Config.groovy`.

Currently, there is support for javascript files (with the extension `.js-gtpl`) and CSS files (with the extension `.css-gtpl`).

Some scenarios that this plugin enables:

- extracting the base path for urls out of config, so you can refer to asset paths in JS/CSS at `/your-app/<filepath>` in dev but at just `/<filepath>` in test/prod environments.
- creating a javascript array to hold your enum values for drop-downs and radio buttons
- putting a timestamp/version/git hash in a comment in your assets so you can easily tell when they were built

All of these things are possible without this plugin by doing a callback to the server, or within a script block inside your GSP files, but those are slower, clunkier solutions.
