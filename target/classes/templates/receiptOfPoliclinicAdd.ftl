<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Receipt of Policlinic</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="addFormBody">
<a href="/web/receiptsofpoliclinic/list"><button class="log-out">Go back</button></a>
<div class="receiptsOfPoliclinicAdd-Form">
    <div class="receiptsOfPolicliclinicAddd">
        <h2 class="AddText2">Add Receipt of Policlinic</h2>
        <form name="receiptOfPoliclinic" action="" method="POST">
            In a Day:<@spring.formInput "receiptsOfPoliclinicForm.inADay" "" "text"/>
            <br>
            <br>
            In a Month:<@spring.formInput "receiptsOfPoliclinicForm.inAMounth" "" "text"/>
            <br>
            <br>
            Day:<@spring.formInput "receiptsOfPoliclinicForm.day" "" "text"/>
            <br>
            <br>
            Month:<@spring.formInput "receiptsOfPoliclinicForm.month" "" "text"/>
            <br>
            <br>
            <input class="log-out" type="submit" value="Create"/>
        </form>
    </div>
</div>
</body>
</html>