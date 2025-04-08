
-- AUTORES (20 registros)

INSERT INTO autor (nome, cpf, idade, genero) VALUES ('J.K. Rowling', '12345678900', 58, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('George R.R. Martin', '98765432100', 75, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('J.R.R. Tolkien', '45678912300', 81, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Stephen King', '11122233344', 76, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Agatha Christie', '55566677788', 85, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Neil Gaiman', '99988877766', 63, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Isaac Asimov', '22233344455', 72, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Suzanne Collins', '88877766655', 61, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Rick Riordan', '33344455566', 59, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Dan Brown', '77788899900', 59, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Margaret Atwood', '11122233311', 84, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Haruki Murakami', '22233344422', 75, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Clarice Lispector', '33344455533', 56, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Machado de Assis', '44455566644', 69, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Victor Hugo', '55566677755', 83, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Gabriel García Márquez', '66677788866', 87, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Jane Austen', '77788899977', 41, 'FEMININO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Franz Kafka', '88899900088', 40, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('José Saramago', '99900011199', 87, 'MASCULINO');
INSERT INTO autor (nome, cpf, idade, genero) VALUES ('Virginia Woolf', '00011122200', 59, 'FEMININO');


-- EDITORAS (20 registros)

INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Bloomsbury Publishing', '00112233000144', 'https://www.bloomsbury.com', '12345678');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Bantam Books', '11223344000155', 'https://www.bantambooks.com', '23456789');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Allen & Unwin', '22334455000166', 'https://www.allenandunwin.com', '34567890');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Scribner', '33445566000177', 'https://www.simonandschusterpublishing.com/scribner', '45678901');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('HarperCollins', '44556677000188', 'https://www.harpercollins.com', '56789012');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('William Morrow', '55667788000199', 'https://www.harpercollins.com/william-morrow', '67890123');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Doubleday', '66778899000100', 'https://www.penguinrandomhouse.com', '78901234');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Scholastic Press', '77889900000111', 'https://www.scholastic.com', '89012345');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Disney-Hyperion', '88990011000122', 'https://www.disneybooks.com', '90123456');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Penguin Books', '99001122000133', 'https://www.penguin.co.uk', '01234567');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Companhia das Letras', '01020304000199', 'https://www.companhiadasletras.com.br', '01310930');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Vintage', '02030405000188', 'https://www.vintage-books.co.uk', '01421040');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Planeta', '03040506000177', 'https://www.planetadelivros.com.br', '01532150');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Globo Livros', '04050607000166', 'https://www.globolivros.globo.com', '01643260');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Editora Rocco', '05060708000155', 'https://www.rocco.com.br', '01754370');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Intrínseca', '06070809000144', 'https://www.intrinseca.com.br', '01865480');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Editora Objetiva', '07080910000133', 'https://www.objetiva.com.br', '01976590');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Editora 34', '08091011000122', 'https://www.editora34.com.br', '02087600');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Editora FTD', '09101112000111', 'https://www.ftd.com.br', '02198710');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('L&PM Editores', '10111213000100', 'https://www.lpm.com.br', '02209821');


-- LIVROS
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Harry Potter e a Pedra Filosofal', 1, 1, 320);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('A Guerra dos Tronos', 2, 2, 694);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('O Senhor dos Anéis: A Sociedade do Anel', 3, 3, 576);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('O Iluminado', 4, 4, 447);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Assassinato no Expresso Oriente', 5, 5, 256);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Deuses Americanos', 6, 6, 624);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Fundação', 7, 7, 296);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Jogos Vorazes', 8, 8, 374);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Percy Jackson e o Ladrão de Raios', 9, 9, 400);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('O Código Da Vinci', 10, 10, 454);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('O Conto da Aia', 11, 11, 311);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Norwegian Wood', 12, 12, 296);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('A Hora da Estrela', 13, 13, 96);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Dom Casmurro', 14, 14, 256);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Os Miseráveis', 15, 15, 1463);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Cem Anos de Solidão', 16, 16, 417);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Orgulho e Preconceito', 17, 17, 279);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('A Metamorfose', 18, 18, 74);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Ensaio sobre a Cegueira', 19, 19, 312);
INSERT INTO livro (titulo, autor_id, editora_id, num_paginas) VALUES ('Mrs. Dalloway', 20, 20, 296);
