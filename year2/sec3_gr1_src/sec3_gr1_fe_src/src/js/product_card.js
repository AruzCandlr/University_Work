//for generating product card
//note: need to make the white card box be more responsive(its too big sometimes)
//maybe i might make it a slide or scrollable

function createCol(imgLink, name, price, prodLink, item_id) {

  console.log('generate ' + name)
  
  return `
<div class="col-lg-3 col-6 col-xl-3">

                        <div class=" card text-black" style='align-self:center'>

                            <img src="${imgLink}" class="d-block card-img-top"
                                style="aspect-ratio: 16/9; object-fit: cover;">
                            <div class="card-body">
                                <div class="text-center mt-1">
                                    <h4 class="card-title">${name}</h4>
                                    <h6 class="text-primary mb-1 pb-3">price: ${price}฿</h6>
                                </div>
                                <div class="d-flex flex-row">
                                    <button type="button" class="btn btn-primary flex-fill me-1"
                                        data-mdb-ripple-color="dark" 
                                        onclick="window.location.href='${prodLink}';window.localStorage.setItem('item_id',${item_id})">
                                        to product page
                                    </button>

                                </div>

                            </div>
                        </div>
                       
</div>`
}

function cardInit(input) {
  console.log('activate car initialization')
  let outFrame = `
  
    <div class="container text-center">
      <div class="row g-5 center">
        ${input}
      </div>
    </div>
    `
  document.getElementById('productGen').innerHTML = outFrame
}

