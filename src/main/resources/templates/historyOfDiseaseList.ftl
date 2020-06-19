<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="/style/style.css">
</head>
<body>
<div class="discount">
    <div class="discount-container">
        <div class="discount_text">
            <marquee  behavior="scroll" direction="right">Отримайте знижку 10% на ліки та матеріали, код: 24124 </marquee>
            <a href="/"><button class="log-out">
                    <h6 class="log-out-text">Go back</h6></button></a>
        </div>
    </div>
</div>
<div class="Table-text">History of disease List</div>
<br>
<br>
<br>
<div>
    <fieldset>
        <legend class="SearchText">Find  history of disease by Patient's name</legend>
        <form name="search" action="" method="POST">
            <div class="SearchText">Inputp FIO<@spring.formInput "searchForm.string" "" "text"/></div>
            <br>
            <input class="log-out" type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<a href="create"><button class="AddButtn">Create</button></a>
<div>
    <table class="table table-striped table-dark">
        <tr>
            <th>ID of history of diseases</th>
            <th>Disease</th>
            <th>Patient<a href="/web/historyofdiseases/list/sorted"><button class="sortButtn"><h6>Sort</h6></button></a>
                <a href="/web/historyofdiseases/list"><button class="UndoSortButtn"><h6 class="undoText">Undo sort</h6></button></a></th>
            <th>Doctor</th>
            <th>Begin of desease</th>
            <th>End of disease</th>
            <th>Status</th>
            <th>Spended money on desease</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list historyofdiseases as historyofdisease>
            <tr>
                <td>${historyofdisease.idOfHistoryOfDiseases}</td>
                <td>${historyofdisease.disease.nameOfDisease}</td>
                <td>${historyofdisease.patient.FIO}</td>
                <td>${historyofdisease.doctor.FIO}</td>
                <td>${historyofdisease.beginOfDesease}</td>
                <td>${historyofdisease.endOfDisease}</td>
                <td>${historyofdisease.status}</td>
                <td>${historyofdisease.spendedMoneyOnDesease}</td>
                <td><a href="delete/${historyofdisease.idOfHistoryOfDiseases}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to delete ${historyofdisease.idOfHistoryOfDiseases}?');"><h6>DELETE</h6></a></td>
                <td><a href="edit/${historyofdisease.idOfHistoryOfDiseases}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to Edit ${historyofdisease.idOfHistoryOfDiseases}?');"><h6>EDIT</h6></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>