CREATE TABLE IF NOT EXISTS ninera (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      nombre VARCHAR(255) NOT NULL,
                                      apellido VARCHAR(255) NOT NULL,
                                      telefono VARCHAR(20),
                                      email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS disponibilidad (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              id_ninera BIGINT,
                                              fecha DATE,
                                              hora_inicio TIME,
                                              hora_fin TIME,
                                              FOREIGN KEY (id_ninera) REFERENCES ninera(id)
);