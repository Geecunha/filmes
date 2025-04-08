-- AUTOR
INSERT INTO autor (nome, cpf, idade) VALUES ('J.K. Rowling', '12345678900', 58);
INSERT INTO autor (nome, cpf, idade) VALUES ('George R.R. Martin', '98765432100', 75);
INSERT INTO autor (nome, cpf, idade) VALUES ('J.R.R. Tolkien', '45678912300', 81);
INSERT INTO autor (nome, cpf, idade) VALUES ('Stephen King', '11122233344', 76);
INSERT INTO autor (nome, cpf, idade) VALUES ('Agatha Christie', '55566677788', 85);
INSERT INTO autor (nome, cpf, idade) VALUES ('Neil Gaiman', '99988877766', 63);
INSERT INTO autor (nome, cpf, idade) VALUES ('Isaac Asimov', '22233344455', 72);
INSERT INTO autor (nome, cpf, idade) VALUES ('Suzanne Collins', '88877766655', 61);
INSERT INTO autor (nome, cpf, idade) VALUES ('Rick Riordan', '33344455566', 59);
INSERT INTO autor (nome, cpf, idade) VALUES ('Dan Brown', '77788899900', 59);


-- EDITORA
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Bloomsbury Publishing', '00112233000144', 'https://www.bloomsbury.com', '12345678');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Bantam Books', '11223344000155', 'https://www.bantambooks.com', '23456789');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Allen & Unwin', '22334455000166', 'https://www.allenandunwin.com', '34567890');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Scribner', '33445566000177', 'https://www.simonandschusterpublishing.com/scribner', '45678901');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('HarperCollins', '44556677000188', 'https://www.harpercollins.com', '56789012');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('William Morrow', '55667788000199', 'https://www.harpercollins.com/william-morrow', '67890123');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Doubleday', '66778899000100', 'https://www.penguinrandomhouse.com', '78901234');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Scholastic Press', '77889900000111', 'https://www.scholastic.com', '89012345');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Disney-Hyperion', '88990011000122', 'https://www.disneybooks.com', '90123456');
INSERT INTO editora (nome, cnpj, site, cep) VALUES ('Doubleday (Dan Brown)', '99001122000133', 'https://www.danbrown.com', '01234567');


-- LIVRO
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
