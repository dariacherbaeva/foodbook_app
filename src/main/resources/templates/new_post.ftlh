<#include "base.ftlh"/>

<#macro title>New recipe</#macro>

<#macro content>

 <form action="/new" method="post" enctype="multipart/form-data">
     <h2 class="text-center"><strong>New recipe</strong></h2>
    <div class="form-group"><input class="form-control" type="text" name="name" placeholder="Name"></div>
    <div class="form-group"><textarea class="form-control" type="text" name="text" placeholder="Your recipe"></textarea></div>
    <!--<div class="form-group"> <input type="file" class="form-control" name="file"></div>-->
    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit">Add</button>
    </div>
 </form>

</#macro>

<@main/>