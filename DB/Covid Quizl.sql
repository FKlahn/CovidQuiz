CREATE TABLE cq_usuario (
    cq_id_usuario               VARCHAR2(36),
    cq_login_usuario            VARCHAR2(20) UNIQUE NOT NULL,
    cq_senha_usuario            VARCHAR2(25) NOT NULL,
    cq_nome_usuario             VARCHAR2(35) NOT NULL,
    cq_pontuacao_usuario        NUMBER NOT NULL,
    cq_tipo_usuario             VARCHAR2(8) NOT NULL,
    cq_status_usuario           NUMBER(1) NOT NULL,
    cq_dica_usuario             NUMBER(1) NOT NULL,
    cq_sempre_dificil_usuario   NUMBER(1) NOT NULL
);

ALTER TABLE cq_usuario ADD CONSTRAINT pk_cq_id_usuario PRIMARY KEY ( cq_id_usuario );

INSERT INTO cq_usuario (
    cq_id_usuario,
    cq_login_usuario,
    cq_senha_usuario,
    cq_nome_usuario,
    cq_pontuacao_usuario,
    cq_tipo_usuario,
    cq_status_usuario,
    cq_dica_usuario,
    cq_sempre_dificil_usuario
) VALUES (
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b',
    'sysadmin',
    'root123',
    'Admin',
    0,
    'ADMIN',
    1,
    0,
    0
);

CREATE TABLE cq_pergunta (
    cq_id_pergunta            INT NOT NULL,
    cq_pergunta               VARCHAR2(110) NOT NULL,
    cq_alternativa1           VARCHAR2(70) NOT NULL,
    cq_alternativa2           VARCHAR2(70) NOT NULL,
    cq_alternativa3           VARCHAR2(70) NOT NULL,
    cq_alternativa_correta    VARCHAR2(70) NOT NULL,
    cq_status_pergunta        INT NOT NULL,
    cq_dificuldade_pergunta   INT NOT NULL,
    cq_id_usuario_pergunta            VARCHAR2(36)
);

ALTER TABLE CQ_PERGUNTA ADD CONSTRAINT PK_CQ_ID_PERGUNTA PRIMARY KEY (CQ_ID_PERGUNTA);
ALTER TABLE CQ_PERGUNTA ADD CONSTRAINT FK_CQ_IDUSUARIO FOREIGN KEY (CQ_ID_USUARIO_PERGUNTA) REFERENCES CQ_USUARIO;

CREATE SEQUENCE SEQ_PERGUNTA START WITH 1 INCREMENT BY 1;


CREATE TABLE cq_pergunta_respondida (
    cq_id_pergunta   INT NOT NULL,
    cq_id_usuario    VARCHAR2(36)
);

ALTER TABLE cq_pergunta_respondida ADD CONSTRAINT fk_cq_id_pergunta FOREIGN KEY ( cq_id_pergunta )
    REFERENCES cq_pergunta;

ALTER TABLE cq_pergunta_respondida ADD CONSTRAINT fk_cq_id_usuario FOREIGN KEY ( cq_id_usuario )
    REFERENCES cq_usuario;

ALTER TABLE cq_pergunta_respondida ADD CONSTRAINT pk_cq_pergunta_respondida PRIMARY KEY ( cq_id_pergunta,
                                                                                          cq_id_usuario );

--CRIANDO PERGUNTAS BASE DO JOGO

--PERGUNTAS N�VEL F�CIL
INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'O que n�o � sintoma de covid-19?',
    'tosse seca',
    'diminui��o do apetite',
    'coriza',
    'Incha�os no pesco�o',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'O que n�o transmite covid-19?',
    'Got�culas de saliva',
    'tosse',
    'espirro',
    'falar mesmo a dist�ncia',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    '� uma informa��o verdadeira sobre Covid-19:',
    'Tem o DNA como material gen�tico',
    'Fica encubado na pessoa por at� 5 dias',
    'Surgiu na europa',
    'Pode causar pneumonia',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Quando o v�rus surgiu na China?',
    'Janeiro de 2019',
    'Fevereiro de 2020',
    'Mar�o de 2020',
    'Dezembro de 2019',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

--PERGUNTAS N�VEL M�DIO

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual cantora morreu de covid-19?',
    'Aline Barros',
    'Fernanda Brum',
    'Lauriete Rodrigues',
    'Fabiana Anast�cia',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Entre essas alternativas, qual � o sintoma mais comum de aparecer?',
    'Diarreia',
    'Espirros',
    'Insufici�ncia renal',
    'Tosse seca',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual a porcentagem de �gua o �lcool gel deve ter?',
    '40%',
    '50%',
    '60%',
    '70%',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Para a m�scara ser eficiente, o que ela precisa cobrir?',
    'Boca',
    'Nariz',
    'Queixo',
    'Todas est�o corretas',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

--PERGUNTAS N�VEL DIF�CIL

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual foi o estado brasileiro com maior �ndice de covid-19 (24/11/2020)?',
    'Mato Grosso do Sul',
    'Mato Grosso',
    'Rio de Janeiro',
    'S�o Paulo',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual foi a cidade Rio-Grandense com maior �ndice de mortes por covid-19 (24/11/2020)?',
    'Sapucaia do sul',
    'Gravata�',
    'Canoas',
    'Porto Alegre',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual � a menor temperatura considerada febre?',
    '37,3',
    '37,8',
    '38.0',
    '37,5',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'O tamanho aproximado da Covid-19 � de:',
    '0,5 nan�metros',
    '2,5 nan�metros',
    '3,0 nan�metros',
    '25 nan�metros',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual informa��o abaixo � falsa?',
    'Mais de 1 milh�o de pessoas j� foram mortas pelo Covid-19',
    'Cachorros n�o transmitem Covid-19',
    'Luvas e m�scaras protegem contra a transmiss�o do v�rus',
    'Entregas vindo do exterior podem conter Covid-19',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Quais animais podem transmitir covid-19?',
    'Morcegos e ratos',
    'Insetos e ratos',
    'Cobras e insetos',
    'Morcegos e cobras',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'O que pode aumentar o risco de complica��es do Covid-19?',
    'Incha�os no corpo',
    'Pr�tica de exerc�cios antes da infec��o viral',
    'Cafe�na',
    'Hipertens�o',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);


INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual � um mito sobre o Covid-19?',
    'Luvas auxiliam na preven��o do Covid-19',
    'M�scara n�o � totalmente eficaz na prote��o contra o v�rus',
    'Cachorros e gatos n�o transmitem Covid-19',
    'Vitamina D previne o covid-19',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'Qual dessas informa��es sobre a Covid-19 � correta?',
    'Covid-19 � uma muta��o do v�rus da gripe',
    'Usando luvas e m�scaras n�o pegar� o v�rus',
    'Hidroxicloroquina � a cura contra Covid-19',
    'Covid-19 � mais mortal que a gripe comum',
    1,
    2,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    '� uma forma comprovada de preven��o ao covid-19:',
    'Comer alho cr�',
    'Fazer gargarejo bucal',
    'Lavar o nariz com soro fisiol�gico',
    'Cozinhar bem alimentos cr�s',
    1,
    3,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

INSERT INTO cq_pergunta (
    cq_id_pergunta,
    cq_pergunta,
    cq_alternativa1,
    cq_alternativa2,
    cq_alternativa3,
    cq_alternativa_correta,
    cq_status_pergunta,
    cq_dificuldade_pergunta,
    cq_id_usuario_pergunta
) VALUES (
    SEQ_PERGUNTA.NEXTVAL,
    'O que pode matar o covid-19?',
    'Antibi�ticos',
    'Bebidas com alto teor alco�lico',
    'Ibuprofeno',
    'Alcool 70',
    1,
    1,
    'b60c8f46-d4ee-4ff4-936e-0d551d75ba0b'
);

COMMIT;

--ADMIN INICIAL LOGIN: sysadmin SENHA: root123