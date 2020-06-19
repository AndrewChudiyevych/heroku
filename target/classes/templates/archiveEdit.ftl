<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit archive</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/archive/list"><button class="log-out">Go back</button></a>
<div class="archiveAdd-Form">
    <div class="archiveAdd">
        <h2 class="AddText">Edit Archive</h2>
        <form name="archive" action="" method="POST">
            BeginningOfTreatment:<@spring.formInput "archiveForm.beginningOfTreatment" "" "text"/>
            <br>
            <br>
            endOfTreatment:<@spring.formInput "archiveForm.endOfTreatment" "" "text"/>
            <br>
            <br>
            Doctor:<@spring.formSingleSelect "archiveForm.doctor", doctorL, "" />
            <br>
            <br>
            Patient:<@spring.formSingleSelect "archiveForm.patient", patientL, "" />
            <br>
            <br>
            Disease:<@spring.formSingleSelect "archiveForm.disease", diseaseL, "" />
            <br>
            <br>
            <input class="log-out" type="submit" value="Edit"/>
        </form>
    </div>
</div>
</body>
</html>