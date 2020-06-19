<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Visit</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/visit/list"><button class="log-out">Go back</button></a>
<div class="visitAdd-Form">
    <div class="visitAdd">
        <h2 class="AddText">Edit Visit</h2>
        <form name="visit" action="" method="POST">
            Patient:<@spring.formSingleSelect "visitForm.patient", patientL, "" />
            <br>
            <br>
            Doctor:<@spring.formSingleSelect "visitForm.doctor", doctorL, "" />
            <br>
            <br>
            First or secondVisit:<@spring.formInput "visitForm.firstOrSecondVisit", "", "text"/>
            <br>
            <br>
            Anamnez:<@spring.formInput "visitForm.anamnez", "", "text"/>
            <br>
            <br>
            Diagnoz:<@spring.formInput "visitForm.diagnoz", "", "text"/>
            <br>
            <br>
            Treatment:<@spring.formInput "visitForm.treatment", "", "text"/>
            <br>
            <br>
            Cost of spendedMedicine:<@spring.formInput "visitForm.costOfSpendedMedicine", "", "text"/>
            <br>
            <br>
            Cost of spendedMaterials:<@spring.formInput "visitForm.costOfSpendedMaterials", "", "text"/>
            <br>
            <br>
            Cost of services:<@spring.formInput "visitForm.costOfServices", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Edit"/>
        </form>
    </div>
</div>

</body>
</html>