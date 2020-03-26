<#include "base.ftlh"/>

<#macro title>Profile</#macro>

<#macro content>
<div align="center">
    <p>${user.username}</p>
    <p>${user.name}</p>
    <p>${user.age}</p>
</div>

<#list favorites as f>
    <tr>
        <p>${r.name}</p>
        <p>${r.text}</p>
        <p>${r.createdAt}</p>
    <p><#if r.photoPath??>
        <img src="${r.photoPath!}" width="200"/></p>
        <p><button>
            <a href="/post?id=${r.getId()}">
                Open </a>
        </button></p>
    </#if>
    </tr>
</#list>

</#macro>
<@main/>