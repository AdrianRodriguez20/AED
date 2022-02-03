
import React, { useState, ChangeEvent } from 'react';
import { Container, Row , Col  } from 'react-bootstrap';
import Persona from './Persona';


const ListadoPersonas = () => {

  const [state, setState] = useState(new Array<Persona>());

  function agregarPersona() {

    let persona = new Persona();
    persona.id = state.length
    setState([...state, persona])

  }

  function modificarPersona(persona: Persona) {
    let index: number = persona.id;

    state.map(p => {
      if (p.id === index) {
        p.nombre = persona.nombre;
        p.apellido = persona.apellido;
        p.edad = persona.edad;
        p.altura = persona.altura;
        p.peso = persona.peso;
      }
    }
    );

  }
  return (

    <>
      <button onClick={agregarPersona}>+</button>
      <Container>
        <Row>
          {
            state.map((persona) => {
              return (
                <>

                  <Col md="3">
                  <PersonaCard personaState={state[persona.id].id.toString()} modificarPersona={modificarPersona} />
                  </Col>

                </>
              );
            })
          }
        </Row>
      </Container>
    </>
  );
};

interface Iprops {
  modificarPersona: Function;
  personaState: any;

}

export const PersonaCard = (props: Iprops) => {

  const { modificarPersona, personaState } = props;
  const [persona, setPersona] = useState(personaState);


  function enviarinfo(event: ChangeEvent<HTMLInputElement>) {

    let nombre = event.target.name;
    let valor = event.target.value;

    setPersona({ ...persona, [nombre]: valor });
    
    //cast persona a Persona
    let personaCast = persona as Persona;
    personaCast.id = Number(personaState);
    modificarPersona(personaCast);

  }

  return (
    <div>
      <h4>Id:  {personaState} </h4>

      <h4>Nombre: </h4>
      <input type="text" onChange={enviarinfo} name='nombre' />

      <h4>Apellido: </h4>
      <input type="text" onChange={enviarinfo} name='apellido' />

      <h4>Altura: </h4>
      <input type="number" onChange={enviarinfo} name='altura' />

      <h4>Peso: </h4>
      <input type="number" onChange={enviarinfo} name='peso' />

      <h4>Edad: </h4>
      <input type="number" onChange={enviarinfo} name='edad' />
    </div>
  )
}

export default ListadoPersonas;