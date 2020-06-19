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
<div class="Table-text">Patients List</div>
<br>
<br>
<br>
    <div>
        <fieldset>
            <legend class="SearchText">Find  patient by FIO</legend>
            <form name="search" action="" method="POST">
                <div class="SearchText">Input FIO<@spring.formInput "searchForm.string" "" "text"/></div>
                <br>
                <input class="log-out" type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>
<a href="create"><button class="AddButtn">Create</button></a>
    <div>
        <table class="table table-striped table-dark">
            <tr>
                <th>ID</th>
                <th>FIO<a href="/web/patient/list/sorted"><button class="sortButtn"><h6>Sort</h6></button></a>
                    <a href="/web/patient/list"><button class="UndoSortButtn"><h6 class="undoText">Undo sort</h6></button></a></th>
                <th>Medical History Number</th>
                <th>Adress</th>
                <th>Phone Number</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        <#list patients as patient>
            <tr>
                <td>${patient.id}</td>
                <td>${patient.FIO}</td>
                <td>${patient.medicalHistoryNumber}</td>
                <td>${patient.adress}</td>
                <td>${patient.phoneNumber}</td>
                <td><a href="delete/${patient.id}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to delete ${patient.id}?');"><h6>DELETE</h6></a></td>
                <td><a href="edit/${patient.id}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to Edit ${patient.id}?');"><h6>EDIT</h6></a></td>
            </tr>
        </#list>
        </table>
</div>
</body>
</html>
