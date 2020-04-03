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

</#macro>
<@main/>