<#import "spring.ftl" as spring/>
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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/myShortNavBarWithBulb.css">
    <link rel="shortcut icon" href="images/bulb.png" type="image/x-icon">
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="/feed">FoodBook</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="/new"><@spring.message 'base.add'/></a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="/profile"><@spring.message 'profile.page.title'/></a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="/support"><@spring.message 'profile.page.support'/></a></li>
                <li class="nav-item" role="presentation">
                    <form class="form-inline my-2 my-lg-0" method="get" action="/search">
                        <input class="form-control mr-sm-1" type="search" placeholder="<@spring.message 'base.search'/>"
                               aria-label="Search" id="search" name="q">
                        <input class="form-control mr-sm-1" type="number" placeholder="<@spring.message 'base.page'/>"
                               aria-label="Page" id="page" name="page">
                        <input class="form-control mr-sm-1" type="number" placeholder="<@spring.message 'base.size'/>"
                               aria-label="Size" id="size" name="size">
                        <button class="btn btn-primary" type="submit"><@spring.message 'base.search'/></button>
                    </form>
                </li>
            </ul>
        </div>
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
