<#include "base.ftlh"/>

<#macro title>${recipe.getName()}</#macro>

<#macro content>
<div>
    <table border="1">
        <tr>
            <td>${recipe.getName()}</td>
            <td>${recipe.getText()}</td>
            <td>${recipe.getCreatedAt()}</td>
            <td><#if recipe.getPhotoPath()??>
                <img src="${recipe.getPhotoPath()!}" width="200"/> </#if></td>
        </tr>
    </table>

    <a href="/new_comment?postId=${recipe.id}">New comment</a>

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