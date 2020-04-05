<#include "base.ftlh"/>

<#macro title>New comment</#macro>

<#macro content>
 <form method="post" enctype="multipart/form-data">
     <h2 class="text-center"><strong>New comment</strong></h2>
     <div class="form-group"><textarea class="form-control" type="text" name="text" placeholder="Your comment"></textarea></div>
     <div class="form-group">
         <button class="btn btn-primary btn-block" type="submit">Add</button>
     </div>
 </form>
</#macro>

<@main/>