<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add patient spending card</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/patientspendingcard/list"><button class="log-out">Go back</button></a>
<div class="patientSpendingCardAdd-Form">
    <div class="patientSpendingCardAdd">
        <h2 class="AddText2">Add Patient spending card</h2>
        <form name="patientSpendingCard" action="" method="POST">
            Patient:<@spring.formSingleSelect "patientSpendingCardForm.patient", patientL, "" />
            <br>
            <br>
            Number:<@spring.formInput "patientSpendingCardForm.number", "", "text"/>
            <br>
            <br>
            SpendPerDay:<@spring.formInput "patientSpendingCardForm.spendPerDay", "", "text"/>
            <br>
            <br>
            spendPerMonth:<@spring.formInput "patientSpendingCardForm.spendPerMonth", "", "text"/>
            <br>
            <br>
            Day:<@spring.formInput "patientSpendingCardForm.day", "", "text"/>
            <br>
            <br>
            Month:<@spring.formInput "patientSpendingCardForm.month", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>