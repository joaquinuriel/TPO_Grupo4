import React, { useEffect, useState } from 'react';

function SociosList() {
    const [socios, setSocios] = useState([]);

    useEffect(() => {
        fetch("/api/socios")
            .then(response => response.json())
            .then(data => setSocios(data))
            .catch(error => console.error("Error fetching socios:", error));
    }, []);

    return (
        <div>
            <h1>Lista de Socios</h1>
            <ul>
                {socios.map(socio => (
                    <li key={socio.id}>{socio.nombre} - Edad: {socio.edad}</li>
                ))}
            </ul>
        </div>
    );
}

export default SociosList;
