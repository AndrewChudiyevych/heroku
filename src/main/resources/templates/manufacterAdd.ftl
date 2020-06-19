<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add manufacter</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/manufacter/list"><button class="log-out">Go back</button></a>
<div class="manufacterAdd-Form">
    <div class="manufacterAdd">
        <h2 class="AddText">Add Manufacter</h2>
        <form name="manufacter" action="" method="POST">
            Name:<@spring.formInput "manufacterForm.name", "", "text"/>
            <br>
            <br>
            Type of production:<@spring.formInput "manufacterForm.typeOfProduction", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>