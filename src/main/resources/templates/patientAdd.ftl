<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org/">
<head>
    <meta charset="UTF-8">
    <title>Add patient</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/patient/list"><button class="log-out">Go back</button></a>
<div class="patientAdd-form">
    <div class="patientAdd">
        <h2 class="AddText">Add Patient</h2>
        <form name="patient" action="/web/patient/create" method="POST" >
            Patient medicalHistoryNumber:<@spring.formInput "patientForm.medicalHistoryNumber", "", "text"/>
            <@spring.showErrors "patientForm.medicalHistoryNumber"/>
            <br>
            <br>
            Patient FIO:<@spring.formInput "patientForm.FIO", "", "text"/>
            <br>
            <br>
            Patient adress:<@spring.formInput "patientForm.adress", "", "text"/>
            <br>
            <br>
            Patient phoneNumber:<@spring.formInput "patientForm.phoneNumber", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
            <br>
        </form>
    </div>
</div>

</body>
</html>