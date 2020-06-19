<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Receipt of Doctor</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/receiptsofdoctors/list"><button class="log-out">Go back</button></a>
<div class="reciptOfDoctorAdd-Form">
    <div class="receiptsOfDoctorAdd">
        <h2 class="AddText2">Add Receipt of Doctor</h2>
        <form name="receiptOfDoctor" action="" method="POST">
            Doctor:<@spring.formSingleSelect "receiptsOfDoctorsForm.doctor", doctorL, ""/>
            <br>
            <br>
            In a Day:<@spring.formInput "receiptsOfDoctorsForm.inADay" "" "text"/>
            <br>
            <br>
            In a Month:<@spring.formInput "receiptsOfDoctorsForm.inAMounth" "" "text"/>
            <br>
            <br>
            Day:<@spring.formInput "receiptsOfDoctorsForm.day" "" "text"/>
            <br>
            <br>
            Month:<@spring.formInput "receiptsOfDoctorsForm.month" "" "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>