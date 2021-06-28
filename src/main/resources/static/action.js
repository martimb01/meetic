buttonClicked = "";

async function action(id, suffix) {
    try {
    $.getJSON('/api/' + id + suffix, function(data) {
        console.log(data);
        if (data.length === 0){
            console.log("lista vazia");
            while(document.querySelector("td")){
                document.querySelector("td").remove();
            }
            return;
        } 
        let table = document.querySelector("table");
        let data2 = Object.keys(data[0]);
        while(document.querySelector("tr")){
            document.querySelector("tr").remove();
        }
        while(document.querySelector("th")){
            document.querySelector("th").remove();
        }
        while(document.querySelector("td")){
            document.querySelector("td").remove();
        }
        table = document.querySelector("table");
        generateTableHead(table, data2);
        generateTable(table, data);
        buttonClicked = id;
    });

    } catch (error) { console.log(error); }
    
   }

   function generateTableHead(table, data) {
    let thead = table.createTHead();
    let row = thead.insertRow();
    for (let key of data) {
      let th = document.createElement("th");
      let text = document.createTextNode(key);
      th.appendChild(text);
      row.appendChild(th);
    }
  }

  function generateTable(table, data) {
    for (let element of data) {
      let row = table.insertRow();
      for (key in element) {
        let cell = row.insertCell();
        let text = document.createTextNode(element[key]);
        cell.appendChild(text);
      }
    row.onclick = function(){
        suffix = "";
        if (buttonClicked == "users")
            suffix = "/inscricoes";
        action(buttonClicked + "/" + parseInt(row.cells[0].innerText),suffix);
    }

    }
    
  }
