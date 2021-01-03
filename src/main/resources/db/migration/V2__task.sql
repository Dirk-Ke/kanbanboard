CREATE TABLE task (
    id integer PRIMARY KEY,
    name varchar(40) NOT NULL,
    description varchar(400) NOT NULL,
    version integer
);


INSERT INTO task(id, name, description) VALUES
(1, 'Todo 1', 'Beschreibung 1'),
(2, 'Todo 2', 'Beschreibung 2'),
(3, 'Todo 3', 'Beschreibung 3');