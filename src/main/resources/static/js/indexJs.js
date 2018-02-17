/*<![CDATA[*/
$(document).ready(function() {
    $.getJSON("/users", function(result){

        // Get the headers from JSON
        $("#customers").append('<tr class="parent"></tr>');
        $.each(result[0], function(key){
            console.log("Head: ["+key+"] "+key);
            $("tr.parent").append('<th>'+key.toUpperCase()+'</th>');
        });

        // Get the Values from the JSON
        for(var index=0; index < Object.keys(result).length; index++){
            $("tr").after('<tr class="result"></tr>');
            $.each(result[index], function(key, value){
                console.log("Results: [" + index + "] " + key + " - " + value);
                if(key === "id"){
                    $("tr.result:last").append('<td>'+'</td>');
                    $("td:last").append('<a>'+value+'</a>');
                }
                else{
                    $("tr.result:last").append('<td>' + value + '</td>');
                }

            });
        }
    });
});
/*]]>*/