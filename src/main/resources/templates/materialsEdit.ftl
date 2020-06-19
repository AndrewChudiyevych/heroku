<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit material</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/material/list"><button class="log-out">Go back</button></a>
<div class="materialsAdd-Form">
    <div class="materialsAdd">
        <h2 class="AddText">Edit Material</h2>
        <form name="material" action="" method="POST">
            Manufacter:<@spring.formSingleSelect "materialForm.manufacter", manufacterL, ""/>
            <br>
            <br>
            Price:<@spring.formInput "materialForm.price" "" "text"/>
            <br>
            <br>
            TypeOfMaterial:<@spring.formInput "materialForm.typeOfMaterial" "" "text"/>
            <br>
            <br>
            nameOfMaterial:<@spring.formInput "materialForm.nameOfMaterial" "" "text"/>
            <br>
            <br>
            Disiase:<@spring.formSingleSelect "materialForm.disease", disiaseL, "" />
            <br>
            <br>
            <input class="log-out" type="submit" value="Edit"/>
        </form>
    </div>
</div>
</body>
</html>
