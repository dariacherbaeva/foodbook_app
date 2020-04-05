<#include "base.ftlh"/>

<#macro title>Profile</#macro>

<#macro content>
<div align="center">
    <p><b>Username: </b>${model.user.username}</p>
    <p><b>Name: </b>${model.user.name}</p>
    <p><b>Email: </b>${model.user.email}</p>
    <p><b>Phone number: </b>${model.user.phone}</p>
    <p><b>Age: </b>${model.user.age}</p>
</div>
<div align="center"><p><b>${model.user.name}'s recipes:</b></p>
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
            <button class="btn btn-primary" type="submit">Open post</button>
        </form>
        </p>

    </tr>
        </#list>
    <#else>
    <p>${model.user.name} have no recipes yet.</p>
    </#if>
</div>
<div align="center">
    <p><b>${model.user.name}'s favorites: </b></p>
    <#if model.favorites??>
        <#list model.favorites as f>
           <p> <form name="my-form" action="/post" method="get">
            <input type="hidden" value="${f.getRecipeId()}" name="id"/>
            <button class="btn btn-primary" type="submit">Open post</button>
        </form>
        </p>
        </#list>
    <#else>
        <p>${model.user.name} have no favorites yet.</p>
    </#if>
</div>
</#macro>
<@main/>