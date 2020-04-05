<#include "base.ftlh"/>

<#macro title>
    <#if model.recipe??>
        ${model.recipe.name}
    <#else>
        Пост не найден!
    </#if>
</#macro>

<#macro content>
    <#if model.recipe??>
<div>
    <table border="1">
        <tr>
            <td>${model.recipe.name}</td>
            <td>${model.recipe.text}</td>
            <td><#if model.recipe.photoPath??>
                <img src="${model.recipe.photoPath}">
            </#if></td>
        </tr>
    </table>

    <form action="/new_comment" method="get">
        <input type="hidden" value="${model.recipe.id}" name="id"/>
        <button type="submit" class="btn btn-primary">New comment</button>
    </form>
    <table border="1" align="center">
        <#if comments??>
            <#list comments as c>
        <tr><p>${c.authorId}</p></tr>
        <tr><p>${c.text}</p></tr>
            </#list>
        <#else>
        <p>
            ${model.message}
        </p>

        </#if>
    </table>

</div>
    <#else>
        ${model.message}
    </#if>



</#macro>
<@main/>