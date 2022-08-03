import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Paper, Button } from "@mui/material";

export default function Estudiantes() {
 const paperStyle = { padding: "50px 20px", width: 600, margin: "20px auto" };
 const [nombre, setNombre] = useState("");
 const [direccion, setDireccion] = useState("");

 const [estudiantes, setEstudiantes] = useState([]);

 const handleClick = (e) => {
  e.preventDefault();
  const estudiante = { nombre, direccion };
  console.log(estudiante);
  fetch("http://localhost:8080/api/estudiantes/add", {
   method: "POST",
   headers: { "Content-Type": "application/json" },
   body: JSON.stringify(estudiante),
  }).then(() => {
   console.log("Nuevo estudiante agregado");
  });
 };

 useEffect(() => {
  fetch("http://localhost:8080/api/estudiantes")
   .then((res) => res.json())
   .then((result) => {
    setEstudiantes(result);
   });
 }, []);

 return (
  <Container>
   <Paper elevation={3} style={paperStyle}>
    <h1 style={{ color: "blue" }}>
     <u>Añadir Estudiante</u>
    </h1>
    <Box
     component="form"
     sx={{
      "& > :not(style)": { m: 1 },
     }}
     noValidate
     autoComplete="off"
    >
     <TextField
      id="outlined-basic"
      label="Nombre del estudiante"
      variant="outlined"
      fullWidth
      value={nombre}
      onChange={(e) => setNombre(e.target.value)}
     />
     <TextField
      id="outlined-basic"
      label="Direccion del estudiante"
      variant="outlined"
      fullWidth
      value={direccion}
      onChange={(e) => setDireccion(e.target.value)}
     />
     <Button variant="contained" onClick={handleClick}>
      Agregar
     </Button>
    </Box>
   </Paper>

   <h1>Estudiantes</h1>
   <Paper elevation={3} style={paperStyle}>
    {estudiantes.map((estudiantes) => (
     <Paper
      elevation={6}
      style={{ margin: "10px", padding: "15px", textAlign: "left" }}
      key={estudiantes.idEstudiante}
     >
      Id:{estudiantes.idEstudiante}
      <br />
      Name:{estudiantes.nombre}
      <br />
      Direccion:{estudiantes.direccion}
      <br />
     </Paper>
    ))}
   </Paper>
  </Container>
 );
}
