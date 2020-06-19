<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit history of diseases</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/historyofdiseases/list"><button class="log-out">Go back</button></a>
<div class="historyOfDiseaseAdd-Form">
    <div class="historyOfDiseaseAdd">
        <h2 class="AddText2">Edit History of disease</h2>
        <form name="historyOfDisease" action="" method="POST">
            Disease:<@spring.formSingleSelect "historyOfDiseasesForm.disease", diseaseL, "" />
            <br>
            <br>
            Patient:<@spring.formSingleSelect "historyOfDiseasesForm.patient", patientL, "" />
            <br>
            <br>
            Doctor:<@spring.formSingleSelect "historyOfDiseasesForm.doctor", doctorL, "" />
            <br>
            <br>
            BeginOfDesease:<@spring.formInput "historyOfDiseasesForm.beginOfDesease", "", "text"/>
            <br>
            <br>
            EndOfDesease:<@spring.formInput "historyOfDiseasesForm.endOfDisease", "", "text"/>
            <br>
            <br>
            Status:<@spring.formInput "historyOfDiseasesForm.status", "", "text"/>
            <br>
            <br>
            SpendedMoneyOnDesease:<@spring.formInput "historyOfDiseasesForm.spendedMoneyOnDesease", "", "text"/>
            <br>
            <br>
            SpendingCard:<@spring.formSingleSelect "historyOfDiseasesForm.spendingCard", spendingCardL, "" />
            <br>
            <br>
            <input class="log-out" type="submit" value="Edit"/>
        </form>
    </div>
</div>
</body>
</html>