import React from "react";

interface IProps { }
interface IState { tiempoRestante: number }

class Cronometro extends React.Component<IProps, IState> {

    timerID: any;
    horaFinalizacion: Date | null;
    inputTiempo: any;
    estadoBoton: string;

    constructor(props: IProps) {
        super(props);
        this.state = { tiempoRestante: 0 };
        this.horaFinalizacion = null;
        this.inputTiempo = React.createRef();
        this.estadoBoton = "Iniciar";
    }
    tick = () => {

        let tiempoRestante = this.state.tiempoRestante;
        if (this.estadoBoton === "Detener") {
            if (tiempoRestante > 0) {
                this.setState({ tiempoRestante: tiempoRestante - 1 });
            }
        } else if ( this.estadoBoton === "Reanudar") {
            this.setState({ tiempoRestante: tiempoRestante });
        }


    }
    componentDidMount() {

        this.timerID = setInterval(
            () => this.tick(),
            1000
        );
    }


    iniciar(segundos: number): any {
        if (this.estadoBoton === "Iniciar") {
            this.horaFinalizacion = new Date(new Date().getTime() + segundos * 1000);
            this.estadoBoton = "Detener";
            this.setState({ tiempoRestante: segundos });
        } else if (this.estadoBoton === "Detener") {
            this.estadoBoton = "Reanudar";
            this.setState({ tiempoRestante: this.state.tiempoRestante });
        } else if (this.estadoBoton === "Reanudar") {
            this.estadoBoton = "Detener";
            this.setState({ tiempoRestante: this.state.tiempoRestante });



        }
    }


    render() {
        const iniciarCronometro = () => {
            let nodeInputTiempo = this.inputTiempo.current;
            let valorSegundos = Number(nodeInputTiempo.value);
            console.log(valorSegundos);
            this.iniciar(valorSegundos);
            nodeInputTiempo.value = "";
        }
        return (
            <div>
                <h1>Cronómetro</h1>
                Cantidad segundos: <input type="text" ref={this.inputTiempo} />
                <br /><button onClick={iniciarCronometro} > {this.estadoBoton} </button>
                <h2>Quedan: {this.state.tiempoRestante} segundos.</h2>
            </div>
        );
    }

}

export default Cronometro;