<#include "base.ftlh" />
<#macro content>
 <div class="login-clean">
     <form method="post" align="center">
         <h2 class="sr-only">Login Form</h2>
         <div class="illustration"><img src="images/verification-sign-sketch.png" style="width: 128px;"></div>
         <div class="form-group"><input class="form-control" type="email" name="email" placeholder="email"> </div>
         <div class="form-group"><input class="form-control" type="password" name="password" pattern="[a-zA-Z0-9]+"  title="The Latin alphabet letters and numbers." placeholder="Password"></div>
         <div class="form-group form-check">
             <input type="checkbox" class="form-check-input" id="exampleCheck1" name="checkbox">
             <label class="form-check-label" for="exampleCheck1" align="center">Remember me</label>
         </div>
         <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Log In</button></div>
    </form>
         <div class="form-group"><button class="btn btn-primary btn-block" value="/sign_up">Sign Up</button>
 </div>
</#macro>

<@main/>