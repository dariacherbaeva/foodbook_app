<#include "base.ftlh"/>

<#macro title>
    <#if model.recipe??>
        ${model.recipe.name}
    <#else>
        <@spring.message 'no_post'/>
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
        <button type="submit" class="btn btn-primary"><@spring.message 'add_comment'/></button>
    </form>

    <table border="1" align="center">
        <#if model.comments??>
            <#list model.comments as c>
            <p><b>Author id: ${c.authorId}</b></p>
            <form action="/profile" method="get">
                <input type="hidden" value="${c.authorId}" name="id"/>
                <button type="submit" class="btn btn-primary"><@spring.message 'profile.page.title'/></button>
            </form>
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