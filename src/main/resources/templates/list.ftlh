<#import "/spring.ftl" as spring/>
<#include "base.ftlh"/>

<#macro title>Recipes Feed</#macro>

<#macro content>
<div align="center">
<table border="1" align="center">
    <#list recipes as r>
        <tr>
            <p>${r.name}</p>
            <p>${r.text}</p>
            <p>${r.createdAt}</p>
        <p><#if r.photoPath??>
            <img src="${r.photo.url!}" width="200"/></p>
        <p>
        </#if>
            <form name="my-form" action="/post" method="get">
                <input type="hidden" value="${r.getId()}" name="id"/>
                <button class="btn btn-primary" type="submit">Open post</button>
            </form>
            <form action="/favorite" method="post">
                <input type="hidden" value="${r.getId()}" name="id">
                <button type="submit" class="btn btn-primary">Add to favorite</button>
            </form>
            </p>
</table>
        </tr>
    </#list>
</div>
</#macro>
<@main/>