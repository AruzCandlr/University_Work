
//require putting action to search query

let bar = `

<div class="col-lg-5 mx-auto" style = 'padding:5%' >
<div class="small fw-light">search input with icon</div>

<form class="input-group" action="/searchProduct" method="POST">
<input class="form-control" type="text"  id="example-search-input">
<span class="input-group-append">
<button class="btn btn-outline-secondary ms-n5" type="submit" onclick="getResult()">
SEARCH
</button>
</span>
</form>
</div>
`
function getResult(){

    let query = document.querySelector("input").value;
    window.localStorage.setItem('search_value',query)
  }

document.getElementById('search').innerHTML = bar

