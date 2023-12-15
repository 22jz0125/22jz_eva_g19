(function(){
  'use strict';
    // APIを実行
  const elItemList = document.querySelector('#item_list');

  window.addEventListener('load', () =>{
    fetch('/22jz_eva_g19/ItemList')
    .then(res => res.json())
    .then(data => {
       console.log(data);
//       console.log(data[0].id);
		let li = `
		<li>
		  <ul>
		    <li>ID    : ${data[0].id}</li>
		    <li>name  : ${data[0].name}</li>
		    <li>price : ${data[0].price}</li>
		  </ul>
		</li>
		`;
		elItemList.innerHTML += li;
//       let li = document.createElement('li');           
//       li.textContent += 'ID    : ' + data[0].id;
//       li.textContent += 'name  : ' + data[0].name;
//       li.textContent += 'price : ' + data[0].price;
//       elItemList.appendChild(li);
    });
  });
  
  


  
})();

