<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add doctor</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/doctor/list"><button class="log-out">Go back</button></a>
<div class="doctorAdd-Form">
    <div class="doctorAdd">
        <h2 class="AddText">Add Doctor</h2>
        <form name="doctor" action="" method="POST">
            FIO:<@spring.formInput "doctorForm.FIO", "", "text"/>
            <br>
            <br>
            Speciality:<@spring.formInput "doctorForm.speciality", "", "text"/>
            <br>
            <br>
            Adress:<@spring.formInput "doctorForm.adress", "", "text"/>
            <br>
            <br>
            Phone number:<@spring.formInput "doctorForm.phoneNumber", "", "text"/>
            <br>
            <br>
            Cost per session:<@spring.formInput "doctorForm.costPerSession", "", "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>

</body>
</html>