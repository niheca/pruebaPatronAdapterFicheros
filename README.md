endpoint : http://localhost:8080/api/v1/convert
 
request :
{
    "name":"niheca",
    "lastName":"hernandez",
    "birthDate":"17/07/2003",
    "gender": "male",
    "typeOfFile":"csv" 
}

response : 
{
    fullName; //Junta el Name y el lastName
    formattedBirthDate; // pasará de este formato de fecha 'dd/MM/yyyy' a este 'yyyy-MM-dd'
    Integer age; // teniendo en cuena la fecha de nacimiento, la edad actual correspondiente
    gender; //M(male) ,F(female),X(other)
}

{
  "fullName":"niheca hernandez",
  "formattedBirthDate":"2003-07-17",
  "age":21,
  "gender":"M"
}

Segun el typeOfFile pasado por request la response será de un tipo u otro pero siguiendo el mismo formateo
El archivo creado lo guarda en src/main/resources/generatedFiles/
