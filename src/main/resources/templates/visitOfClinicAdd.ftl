<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add visit of policlinic</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/visitofclinic/list"><button class="log-out">Go back</button></a>
<div class="visitOfClinicAdd-Form">
    <div class="visitOfClinicAdd">
        <h2 class="AddText2">Add Visit of clinic</h2>
        <form name="visitOfClinic" action="" method="POST">
            Patients per day:<@spring.formInput "visitsOfClinicForm.patientsPerDay", "", "text"/>
            <br>
            <br>
            Patients per month:<@spring.formInput "visitsOfClinicForm.patientsPerMonth", "", "text"/>
            <br>
            <br>
            Day:<@spring.formInput "visitsOfClinicForm.day", "", "text"/>
            <br>
            <br>
            Month:<@spring.formInput "visitsOfClinicForm.month", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>