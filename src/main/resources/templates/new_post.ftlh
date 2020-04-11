<#include "base.ftlh"/>

<#macro title><@spring.message 'base.add'/></#macro>

<#macro content>

 <form action="/new" method="post" enctype="multipart/form-data">
     <h2 class="text-center"><strong><@spring.message 'base.add'/></strong></h2>
    <div class="form-group"><input class="form-control" type="text" name="name" placeholder="<@spring.message 'profile.page.name'/>"></div>
    <div class="form-group"><textarea class="form-control" type="text" name="text" placeholder="<@spring.message 'text'/>"></textarea></div>
    <!--<div class="form-group"> <input type="file" class="form-control" name="file"></div>-->
    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit"><@spring.message 'base.add'/></button>
    </div>
 </form>

</#macro>

<@main/>