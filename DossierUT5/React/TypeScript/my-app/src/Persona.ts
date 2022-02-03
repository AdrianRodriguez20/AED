
 class Persona {

    id: number;
    nombre: string;
    apellido: string;
    altura: number;
    edad: number;
    peso: number;

    constructor(){
        this.id = 0;
        this.nombre= "";
        this.apellido = "";
        this.altura =0;
        this.edad =0;
        this.peso = 0;
    }

    calcular() {
        return this.peso / (this.altura*this.altura);       
    }



}
export default Persona ;