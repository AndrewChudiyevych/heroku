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
<div class="Table-text">Receipt's of doctor List</div>
<br>
<br>
<br>
<div>
    <fieldset>
        <legend class="SearchText">Find receipt of doctor by Doctor's FIO</legend>
        <form name="search" action="" method="POST">
            <div class="SearchText">Input doctor's FIO<@spring.formInput "searchForm.string" "" "text"/></div>
            <br>
            <input class="log-out" type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<a href="create"><button class="AddButtn">Create</button></a>
<div>
    <table class="table table-striped table-dark">
        <tr>
            <th>Id</th>
            <th>Doctor<a href="/web/receiptsofdoctors/list/sorted"><button class="sortButtn"><h6>Sort</h6></button></a>
                <a href="/web/receiptsofdoctors/list"><button class="UndoSortButtn"><h6 class="undoText">Undo sort</h6></button></a></th>
            <th>In a day</th>
            <th>In a month</th>
            <th>Day</th>
            <th>Month</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list receiptsofdoctors as receiptofdoctor>
            <tr>
                <td>${receiptofdoctor.id}</td>
                <td>${receiptofdoctor.doctor.FIO}</td>
                <td>${receiptofdoctor.inADay}</td>
                <td>${receiptofdoctor.inAMounth}</td>
                <td>${receiptofdoctor.day}</td>
                <td>${receiptofdoctor.month}</td>
                <td><a href="delete/${receiptofdoctor.id}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to delete ${receiptofdoctor.id}?');"><h6>DELETE</h6></a></td>
                <td><a href="edit/${receiptofdoctor.id}" type="button" class="buttonDelEd" onclick="return confirm('Are you sure you want to Edit ${receiptofdoctor.id}?');"><h6>EDIT</h6></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>