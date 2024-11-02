-- Criação da tabela tb_cliente
CREATE TABLE tb_cliente (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            email VARCHAR(255) NOT NULL,
                            login VARCHAR(255) NOT NULL,
                            password VARCHAR(255) NOT NULL
);

-- Criação da tabela tb_garcom
CREATE TABLE tb_garcom (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           cpf INT NOT NULL,
                           turno VARCHAR(255),
                           telefone INT,
                           salario DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela tb_mesa
CREATE TABLE tb_mesa (
                         numeroMesa BIGINT AUTO_INCREMENT PRIMARY KEY,
                         capacidade BIGINT,
                         localizacao VARCHAR(255),
                         disponibilidade VARCHAR(255)
);

-- Criação da tabela tb_prato
CREATE TABLE tb_prato (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          preco DECIMAL(10, 2) NOT NULL,
                          categoria VARCHAR(255),
                          tipoCozinha VARCHAR(255)
);

-- Criação da tabela tb_reserva
CREATE TABLE tb_reserva (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            data_hora_reserva DATETIME NOT NULL,
                            quantidadePessoas INT,
                            cliente_id BIGINT,
                            mesa_numeroMesa BIGINT,
                            FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id),
                            FOREIGN KEY (mesa_numeroMesa) REFERENCES tb_mesa(numeroMesa)
);

