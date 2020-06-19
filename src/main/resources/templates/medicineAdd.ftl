<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add medicine</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/medicine/list"><button class="log-out">Go back</button></a>
<div class="medicineAdd-Form">
    <div class="medicineAdd">
        <h2 class="AddText">Add Medicine</h2>
        <form name="medicine" action="" method="POST">
            Manufacter:<@spring.formSingleSelect "medicineForm.manufacter", manufacterL, ""/>
            <br>
            <br>
            Price:<@spring.formInput "medicineForm.price" "" "text"/>
            <br>
            <br>
            Type of medicine:<@spring.formInput "medicineForm.typeOfMedicine" "" "text"/>
            <br>
            <br>
            Name of medicine:<@spring.formInput "medicineForm.nameOfMedicine" "" "text"/>
            <br>
            <br>
            Disiase:<@spring.formSingleSelect "medicineForm.disiase", disiaseL, "" />
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
            </form>
    </div>
</div>


</body>
</html>
