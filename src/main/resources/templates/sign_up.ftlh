<#include "base.ftlh"/>
<#macro title>Sign Up</#macro>


<#macro content>
    <div class="register-photo">
        <div class="form-container">
            <div class="image-holder" style="background-image: url(&quot;/student-education.jpg&quot;);"></div>
            <form method="post" action="/sign_up" enctype="multipart/form-data" novalidate>
                <h2 class="text-center"><strong>Sign up</strong></h2>
                <div class="form-group"><input class="form-control" type="text" pattern="[a-zA-Z0-9]+" title="The Latin alphabet letters and numbers (username should be unique)." name="username" placeholder="Username" value="{{ }}"></div>
                <div class="form-group"><input class="form-control" type="text" pattern="[a-zA-Z0-9]+"  title="The Latin alphabet letters and numbers." name="name" placeholder="Name"></div>
                <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"> </div>
                <div class="form-group"><input class="form-control" type="tel" name="phone" placeholder="Phone Number"></div>
                <div class="form-group"><input class="form-control" type="password" pattern="[a-zA-Z0-9]+" title="The Latin alphabet letters and numbers." name="password" placeholder="Password"></div>
                <div class="form-group"><input class="form-control" type="password" pattern="[a-zA-Z0-9]+" title="The Latin alphabet letters and numbers." name="password2" placeholder="Confirm password"></div>
                <div class="form-group"><input class="form-control" type="text" name="age" placeholder="Age"></div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Sign up</button></div><a class="already" href="/login">Already have an account? Sign in here.</a></form>
        </div>
    </div>
</#macro>

<@main/>