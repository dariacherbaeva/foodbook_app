<#import "/spring.ftl" as spring/>
<#include 'base.ftlh'>

<#macro title><@spring.message 'profile.page.support'/></#macro>

<#macro content>

    <#if user.role == "ADMIN">
        <select id="receiver">
            <#list users as u>
                <option> ${u.username} </option>
            </#list>
        </select>
    </#if>
выведи что-нибудь пажалуста....
<form class="form-control">
    <input class="form-control" placeholder="<@spring.message 'text'/>"/>
    <button class="button" onclick="
            send(document.getElementById('message').value(), '${user.username}',
    <#if user.role == "ADMIN"> document.getElementById('receiver').value()
    <#else> '${adminEmail}' </#if>)"><@spring.message 'send'/></button>
</form>


</#macro>