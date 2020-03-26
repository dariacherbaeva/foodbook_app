<#import "/spring.ftl" as spring/>
<#include "base.ftlh"/>

<#macro title>Recipes Feed</#macro>

<#macro content>
<table border="1" align="center">
    <#list recipes as r>
        <tr>
            <p>${r.name}</p>
            <p>${r.text}</p>
            <p>${r.createdAt}</p>
        <p><#if r.photoPath??>
            <img src="${r.photoPath!}" width="200"/></p>
        <p>
        </#if>
<form name="my-form" action="getpost" method="post">
    <input type="hidden" value="${r.getId()}" name="id"/>
    <button class="btn btn-primary" type="submit">Open post</button>
</form>
        </p>

        </tr>
    </#list>
</#macro>
<@main/>