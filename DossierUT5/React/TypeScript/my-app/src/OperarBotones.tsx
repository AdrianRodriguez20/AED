import React from 'react';

function OperarBotones() {

    function operar(event: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        switch (event.currentTarget.id) {
            case "multiplicar":
                document.getElementById("resultado")!.innerHTML =
                    ((Number(document.getElementById("resultado")!.innerHTML)) * 2).toString();
                document.getElementById("dividir")!.innerHTML = document.getElementById("resultado")!.innerHTML + "/2";
                document.getElementById("multiplicar")!.innerHTML = document.getElementById("resultado")!.innerHTML + "*2";
                break;
            case "dividir":
                document.getElementById("resultado")!.innerHTML =
                    ((Number(document.getElementById("resultado")!.innerHTML)) / 2).toString();
                document.getElementById("dividir")!.innerHTML = document.getElementById("resultado")!.innerHTML + "/2";
                document.getElementById("multiplicar")!.innerHTML = document.getElementById("resultado")!.innerHTML + "*2";
                break;
        }

    }


    return (
        <div>
            Valor actual:<h5 id="resultado">400 </h5>
            <button id="dividir" onClick={operar} >400/2</button>
            <button id="multiplicar" onClick={operar} >400*2</button>
        </div>
    );
}

export default OperarBotones;