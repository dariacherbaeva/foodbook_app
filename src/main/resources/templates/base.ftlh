<#import "/spring.ftl" as spring/>
<#macro content>

</#macro>

<#macro title></#macro>

<#macro main>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><@title/></title>
    <link rel="stylesheet" href="css\bootstrap.min.css">
    <link rel="stylesheet" href="css\myShortNavBarWithBulb.css">

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="/feed">FoodBook</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item" role="presentation"><img
                        src="images\bulb.png" style="width: 32px;"></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/new">Add Recipe</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/profile">Profile</a>
                </li>
                <li class="nav-item" role="presentation"></li>
            </ul></div>
    </div>
</nav>
<script src="js\jquery-3.4.1.min.js"></script>
<script src="js\bootstrap.min.js"></script>
<script id="bs-live-reload" data-sseport="50942" data-lastchange="1571275766688"
        src="js\livereload.js"></script>
<@content/>

</body>
</html>
</#macro>
