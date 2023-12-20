(function(){
  'use strict';
    // APIを実行
  const elItemList = document.querySelector('#item_list');

  window.addEventListener('load', () =>{
    fetch('/22jz_eva_g19/ItemList')
    .then(res => res.json())
    .then(data => {
      console.log(data);
      // data.array.forEach(e => {
      //   console.log(e.name);
      // });

      // let li;

      for (const oneData of data) {
        let li = `
		<li>
		  <ul>
		    <li>ID    : ${oneData.id}</li>
		    <li>name  : ${oneData.name}</li>
		    <li>price : ${oneData.price}</li>
		  </ul>
		</li>
		`;
        elItemList.innerHTML += li;
      }


    });
  });
  
  


  
})();

