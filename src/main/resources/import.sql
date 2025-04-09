-- PRODUTORAS

INSERT INTO produtora (id, nome, endereco) VALUES 
(1, 'CineArt Films', 'Rua Aurora, 101'),
(2, 'Global Cinema', 'Avenida Brasil, 202'),
(3, 'Estúdio Central', 'Rua das Laranjeiras, 303'),
(4, 'Visionary Pictures', 'Av. Liberdade, 404'),
(5, 'Cinema Luz', 'Rua da Paz, 505'),
(6, 'Tela Viva', 'Alameda Santos, 606'),
(7, 'Sete Estrelas', 'Rua Estrela, 707'),
(8, 'Bravos Filmes', 'Rua dos Bravos, 808'),
(9, 'Orion Filmes', 'Av. Estelar, 909'),
(10, 'Girasol Produções', 'Rua do Sol, 1001'),
(11, 'Altas Produções', 'Rua Montanha, 1102'),
(12, 'Impacto Filmes', 'Rua do Impacto, 1203'),
(13, 'Sétima Arte', 'Rua Cineasta, 1304'),
(14, 'Estúdios Atlântida', 'Rua Atlântida, 1405'),
(15, 'Vision Films', 'Av. Criativa, 1506'),
(16, 'Cine Mundi', 'Rua Universal, 1607'),
(17, 'CineBrasil', 'Rua Tupiniquim, 1708'),
(18, 'Nova Tela', 'Av. Contemporânea, 1809'),
(19, 'Futura Filmes', 'Rua do Amanhã, 1901'),
(20, 'Classic Studios', 'Rua do Clássico, 2002');


-- DIRETORES

INSERT INTO diretor (id, nome, nacionalidade, idade, produtora_id) VALUES 
(1, 'Joana Prado', 'Brasileira', 45, 1),
(2, 'Carlos Silva', 'Brasileiro', 50, 2),
(3, 'Luiza Monteiro', 'Portuguesa', 38, 3),
(4, 'John Smith', 'Americano', 60, 4),
(5, 'Akira Tanaka', 'Japonês', 48, 5),
(6, 'Amélie Dupont', 'Francesa', 42, 6),
(7, 'Rajiv Kapoor', 'Indiano', 55, 7),
(8, 'Luciano Rossi', 'Italiano', 53, 8),
(9, 'Hans Meier', 'Alemão', 47, 9),
(10, 'Sofia Costa', 'Brasileira', 35, 10),
(11, 'Pedro Torres', 'Espanhol', 44, 11),
(12, 'Emily Clark', 'Britânica', 39, 12),
(13, 'Chen Wei', 'Chinês', 41, 13),
(14, 'Fatima Noor', 'Egípcia', 37, 14),
(15, 'Liam O\'Connor', 'Irlandês', 46, 15),
(16, 'Marcos Reis', 'Brasileiro', 51, 16),
(17, 'Nina Petrova', 'Russa', 40, 17),
(18, 'Tomé Almeida', 'Moçambicano', 49, 18),
(19, 'Helena Duarte', 'Brasileira', 36, 19),
(20, 'Victor Lima', 'Brasileiro', 43, 20);

-- FILMES

INSERT INTO filme (id, titulo, genero, notas, produtora_id, diretor_id) VALUES 
(1, 'A Jornada', 'Aventura', 8.7, 1, 1),
(2, 'Sombras do Passado', 'Suspense', 7.9, 2, 2),
(3, 'Luzes de Lisboa', 'Drama', 8.2, 3, 3),
(4, 'Eco do Futuro', 'Ficção Científica', 9.1, 4, 4),
(5, 'Caminho da Honra', 'Ação', 7.5, 5, 5),
(6, 'Paris ao Amanhecer', 'Romance', 8.0, 6, 6),
(7, 'O Coração da Índia', 'Drama', 8.4, 7, 7),
(8, 'Veneza Misteriosa', 'Mistério', 7.8, 8, 8),
(9, 'Código Alemão', 'Thriller', 8.6, 9, 9),
(10, 'Sol Nascente', 'Romance', 7.7, 10, 10),
(11, 'El Matador', 'Ação', 8.1, 11, 11),
(12, 'Sombras em Londres', 'Suspense', 7.6, 12, 12),
(13, 'O Tigre e o Dragão', 'Aventura', 8.9, 13, 13),
(14, 'Mistérios do Nilo', 'Aventura', 7.9, 14, 14),
(15, 'Céus Irlandeses', 'Drama', 8.3, 15, 15),
(16, 'A Lenda do Sertão', 'Ficção Histórica', 8.2, 16, 16),
(17, 'Gelo Vermelho', 'Suspense', 7.4, 17, 17),
(18, 'A Alma da Savana', 'Documentário', 8.0, 18, 18),
(19, 'Chamas do Amor', 'Romance', 8.5, 19, 19),
(20, 'Ecos do Tempo', 'Fantasia', 8.8, 20, 20);