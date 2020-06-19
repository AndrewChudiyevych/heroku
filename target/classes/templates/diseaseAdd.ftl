<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add disease</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/disease/list"><button class="log-out">Go back</button></a>
<div class="diseaseAdd-Form">
    <div class="diseaseAdd">
        <h2 class="AddText">Add Disease</h2>
    <form name="disease" action="" method="POST">
        Name of disease:<@spring.formInput "diseaseForm.nameOfDisease", "", "text"/>
        <br>
        <br>
        Medicine:<@spring.formInput "diseaseForm.medicine", "", "text"/>
        <br>
        <br>
        Materials:<@spring.formInput "diseaseForm.materials", "", "text"/>
        <br>
        <br>
        <input class="log-out" type="submit" value="Create"/>
    </form>
    </div>
</div>
</body>
</html>