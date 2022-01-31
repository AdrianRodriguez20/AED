import React, { ChangeEvent } from 'react';


function MostrarInput() {

        function handleChange(event:ChangeEvent<HTMLInputElement>){
            event.preventDefault();
       document.getElementById("resultado")!.innerHTML = event.target.value;
            
            }
    
  return (
      <div>
        <label>Nombre :</label>  <input type="text" onChange={handleChange} />
        <h5> Has escrito :</h5> <h5 id="resultado"> </h5>
       </div>  
  );
}

export default MostrarInput;
