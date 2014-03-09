<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Jasmine Test Runner For Groovy Template Asset Pipline Plugin</title>


  <link rel="stylesheet" type="text/css" href="<g:assetPath src="jasmine/lib/jasmine-2.0.0/jasmine.css"/>">

  <asset:stylesheet href="test.css"/>

  <asset:javascript src="jasmine/lib/jasmine-2.0.0/jasmine.js"/>
  <asset:javascript src="jasmine/lib/jasmine-2.0.0/jasmine-html.js"/>
  <asset:javascript src="jasmine/lib/jasmine-2.0.0/boot.js"/>

  <asset:javascript src="jasmine/spec/SimpleExpressionsSpec.js"/>
</head>

<body>

<span class="css-working">This text should be green if CSS groovy templates are working.</span>
</body>

</html>
