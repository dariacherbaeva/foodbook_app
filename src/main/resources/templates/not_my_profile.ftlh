<#import "spring.ftl" as spring/>
<#include "base.ftlh"/>

<#macro title><@spring.message 'profile.page.title'/></#macro>

<#macro content>
<div align="center">
    <p><b><@spring.message 'profile.page.username'/>: </b>${model.user.username}</p>
    <p><b><@spring.message 'profile.page.name'/>: </b>${model.user.name}</p>
    <p><b><@spring.message 'profile.page.email'/>: </b>${model.user.email}</p>
    <p><b><@spring.message 'profile.page.phone'/>: </b>${model.user.phone}</p>
    <p><b><@spring.message 'profile.page.age'/>: </b>${model.user.age}</p>
</div>
<div align="center"><p><b><@spring.message 'profile.page.recipes'/>:</b></p>
    <#if model.recipes??>
        <#list model.recipes as r>
    <tr>
        <p>${r.name}</p>
        <p>${r.text}</p>
        <p>${r.createdAt}</p>
    <p><#if r.photoPath??>
        <img src="${r.photoPath!}" width="200"/></p>
        <p>
        </#if>
        <form name="my-form" action="/post" method="get">
            <input type="hidden" value="${r.getId()}" name="id"/>
            <button class="btn btn-primary" type="submit"><@spring.message 'open_post'/></button>
        </form>
        </p>

    </tr>
        </#list>
    <#else>
    <p>${model.user.name} <@spring.message 'profile.page.no_recipes'/>.</p>
    </#if>
</div>
<div align="center">
    <p><b><@spring.message 'profile.page.favorites'/>: </b></p>
    <#if model.favorites??>
        <#list model.favorites as f>
           <p> <form name="my-form" action="/post" method="get">
            <input type="hidden" value="${f.getRecipeId()}" name="id"/>
            <button class="btn btn-primary" type="submit"><@spring.message 'open_post'/></button>
        </form>
        </p>
        </#list>
    <#else>
        <p>${model.user.name} <@spring.message 'profile.page.no_favorites'/></p>
    </#if>
</div>
</#macro>
<@main/>