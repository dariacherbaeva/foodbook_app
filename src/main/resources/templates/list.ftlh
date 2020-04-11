<#import "/spring.ftl" as spring/>
<#include "base.ftlh"/>

<#macro title><@spring.message 'feed'/></#macro>

<#macro content>
<div align="center">
    <table border="1" align="center">
    <#list model.recipes as r>
        <tr>
            <p>${r.name}</p>
            <p>${r.text}</p>
            <p>${r.createdAt}</p>
        <p><#if r.photoPath??>
            <img src="${r.photoPath}" width="200"/></p>
        <p>
        </#if>
            <form name="my-form" action="/post" method="get">
                <input type="hidden" value="${r.getId()}" name="id"/>
                <button class="btn btn-primary" type="submit"><@spring.message 'open_post'/></button>
            </form>
            <#if model.user??>
                <#if r.authorId!=model.user.id>
            <p>
            <form action="/favorite" method="post">
                <input type="hidden" value="${r.getId()}" name="id">
                <button type="submit" class="btn btn-primary"><@spring.message 'add_favorite'/></button>
            </form>
                </#if>
            </#if>
            </p>
        </tr>
    </#list>
    </table>
</div>
</#macro>
<@main/>