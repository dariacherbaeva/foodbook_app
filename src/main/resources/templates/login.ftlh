<#include "base.ftlh" />
<#macro content>
 <div class="login-clean">
     <form method="post" align="center">
         <h2 class="sr-only">Login Form</h2>
         <div class="illustration"><img src="images/verification-sign-sketch.png" style="width: 128px;"></div>
         <div class="form-group"><input class="form-control" type="email" name="email" placeholder="email"></div>
         <div class="form-group"><input class="form-control" type="password" name="password" pattern="[a-zA-Z0-9]+"
                                        title="The Latin alphabet letters and numbers." placeholder="Password"></div>
         <div class="form-group">
             <label>
                 <input type="checkbox" name="remember-me">Запомни меня
             </label>
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
             <button class="btn btn-primary btn-block" type="submit">Log In</button>
         </div>
     </form>
     <p align="center">Don't have an account yet? <a href="/sign_up">Sign up here.</a></p>
 </div>
</#macro>

<@main/>