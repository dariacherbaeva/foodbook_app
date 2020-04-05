<#include "base.ftlh"/>

<#macro title>${model.recipe.name}</#macro>

<#macro content>
<div>
    <table border="1">
        <tr>
            <td>${model.recipe.name}</td>
            <td>${model.recipe.text}</td>
            <td>${model.recipe.createdAt()}</td>
            <td><#if model.recipe.photo.storageFileName??>
                <img src="${model.recipe.photo.storageFileName!}" width="200"/> </#if></td>
        </tr>
    </table>

    <a href="/new_comment?postId=${model.recipe.id}">New comment</a>

    <table border="1" align="center">
        <#if comments??>
            <#list comments as c>
        <tr><p>${c.authorId}</p></tr>
        <tr><p>${c.text}</p></tr>
            </#list>
        <#else>
            ${message}
        </#if>
    </table>

</div>


</#macro>
<@main/>